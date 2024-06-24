package managers;

import models.Epic;
import models.Subtask;
import models.Task;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileBackedTaskManager extends InMemoryTaskManager {
    private final File file;

    public FileBackedTaskManager(File file) {
        this.file = file;
        loadFromFile();
    }

    private void loadFromFile() {
        if (!file.exists()) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("id,")) {
                    continue;
                }
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                String type = fields[1];
                String name = fields[2];
                String status = fields[3];
                String description = fields[4];
                Task task = null;
                if (type.equals("TASK")) {
                    task = new Task(name, description);
                } else if (type.equals("EPIC")) {
                    task = new Epic(name, description);
                } else if (type.equals("SUBTASK")) {
                    int epicId = Integer.parseInt(fields[5]);
                    Epic epic = epics.get(epicId);
                    task = new Subtask(name, description, status, id, epicId, epic);
                    epic.getEpicSubtasks().add(id);
                }
                if (task != null) {
                    task.setId(id);
                    task.setStatus(status);
                    tasks.put(id, task);
                }
                if (nextId <= id) {
                    nextId = id + 1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("id,type,name,status,description,epic\n");
            for (Task task : tasks.values()) {
                String type = "TASK";
                if (task instanceof Epic) {
                    type = "EPIC";
                } else if (task instanceof Subtask) {
                    type = "SUBTASK";
                }
                writer.write(String.format("%d,%s,%s,%s,%s",
                        task.getId(), type, task.getTitle(), task.getStatus(), task.getDescription()));
                if (task instanceof Subtask) {
                    Subtask subtask = (Subtask) task;
                    writer.write("," + subtask.getEpicId());
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addTask(Task task) {
        super.addTask(task);
        saveToFile();
    }

    @Override
    public void updateTask(Task task) {
        super.updateTask(task);
        saveToFile();
    }

    @Override
    public void removeTask(int id) {
        super.removeTask(id);
        saveToFile();
    }

    @Override
    public void addEpic(Epic epic) {
        super.addEpic(epic);
        saveToFile();
    }

    @Override
    public void updateEpic(Epic epic) {
        super.updateEpic(epic);
        saveToFile();
    }

    @Override
    public void removeEpic(int id) {
        super.removeEpic(id);
        saveToFile();
    }

    @Override
    public void addSubtask(Subtask subtask) {
        super.addSubtask(subtask);
        saveToFile();
    }

    @Override
    public void updateSubtask(Subtask subtask) {
        super.updateSubtask(subtask);
        saveToFile();
    }

    @Override
    public void removeSubtask(int id) {
        super.removeSubtask(id);
        saveToFile();
    }
}