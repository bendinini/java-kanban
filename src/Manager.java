import tasks.Epic;
import tasks.Subtask;
import tasks.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    private int id;
    private HashMap<Integer, Task> tasks;
    private HashMap<Integer, Subtask> subtasks;
    private HashMap<Integer, Epic> epics;

    public Manager() {
        id = 0;
        tasks = new HashMap<>();
        subtasks = new HashMap<>();
        epics = new HashMap<>();
    }

    //Задачи: добавляем task
    public void addTask(Task task) {
        task.setId(++id);
        tasks.put(id, task);
    }

    // храним task
    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    // извлекаем task
    public Task getTask(int id) {
        return tasks.getOrDefault(id, null);
    }

    public HashMap<Integer, Task> getTasks() {
        return tasks;
    }

    // метод для удаления
    public void deleteTask(int id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
        }
    }

    public void deleteAllTasks() {
        tasks.clear();
    }

    //Эпики пошли
    public void addEpic(Epic epic) {
        epic.setId(++id);
        epic.setStatus("Новая");
        epics.put(id, epic);
    }

    public void updateEpic(Epic epic) {
        epics.put(epic.getId(), epic);
        checkEpicStatus(epic);
    }

    public Epic getEpic(int id) {
        return epics.getOrDefault(id, null);
    }

    public HashMap<Integer, Epic> getEpics() {
        return epics;
    }

    public void deleteEpic(int id) {
        if (epics.containsKey(id)) {
            Epic epic = epics.get(id);
            epics.remove(id);
            for (Integer subtaskId : epic.getEpicSubtasks()) {
                subtasks.remove(subtaskId);
            }
            epic.setEpicSubtasks(new ArrayList<>());
        }
    }

    public void deleteAllEpics() {
        epics.clear();
        subtasks.clear();
    }

    //Аналогично для подзадач
    public void addSubtask(Subtask subtask) {
        subtask.setId(++id);
        subtasks.put(id, subtask);
        subtask.getEpic().getEpicSubtasks().add(id);
        checkEpicStatus(subtask.getEpic());
    }

    public void updateSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
        checkEpicStatus(subtask.getEpic());
    }

    public Subtask getSubtask(int id) {
        return subtasks.getOrDefault(id, null);
    }

    public HashMap<Integer, Subtask> getSubtasks() {
        return subtasks;
    }

    public void deleteSubtask(int id) {
        if (subtasks.containsKey(id)) {
            Epic epic = subtasks.get(id).getEpic();
            epic.getEpicSubtasks().remove((Integer) id);
            checkEpicStatus(epic);
            subtasks.remove(id);
        }
    }

    public void deleteAllSubtask() {
        ArrayList<Epic> epicsForStatusUpdate = new ArrayList<>();
        for (Subtask subtask : subtasks.values()) {
            subtask.getEpic().setEpicSubtasks(new ArrayList<>());
            if (!epicsForStatusUpdate.contains(subtask.getEpic())) {
                epicsForStatusUpdate.add(subtask.getEpic());
            }
        }
        subtasks.clear();
        for (Epic epic : epicsForStatusUpdate) {
            epic.setStatus("New");
        }
    }

    // статусы эпиков
    private void checkEpicStatus(Epic epic) {

        if (epic.getEpicSubtasks().isEmpty()) {
            epic.setStatus("New");
            return;
        }

        boolean allTaskIsNew = true;
        boolean allTaskIsDone = true;

        for (Integer epicSubtaskId : epic.getEpicSubtasks()) {
            String status = subtasks.get(epicSubtaskId).getStatus();
            if (!status.equals("New")) {
                allTaskIsNew = false;
            }
            if (!status.equals("DONE!")) {
                allTaskIsDone = false;
            }
        }

        if (allTaskIsDone) {
            epic.setStatus("DONE!");
        } else if (allTaskIsNew) {
            epic.setStatus("New");
        } else {
            epic.setStatus("IN PROGRESS...");
        }

    }
}