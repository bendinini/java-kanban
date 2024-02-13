import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Manager implements InMemoryTaskManager {
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


    // Методы для задач

    @Override
    public ArrayList<Task> getHistory() {
        return null;
    }

    @Override
    public void addTask(Task task) {
        task.setId(++id);
        tasks.put(id, task);
    }

    @Override
    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
        updateHistory(task, taskHistory);
    }

    @Override
    public Task getTask(int id) {
        return tasks.getOrDefault(id, null);
    }

    @Override
    public HashMap<Integer, Task> getTasks() {
        return tasks;
    }

    @Override
    public void deleteTask(int id) {
        tasks.remove(id);
    }

    @Override
    public void deleteAllTasks() {
        tasks.clear();
    }
    // Методы для эпиков

    @Override
    public void addEpic(Epic epic) {
        epic.setId(++id);
        epic.setStatus("Новая");
        epics.put(id, epic);
    }

    @Override
    public void updateEpic(Epic epic) {
        epics.put(epic.getId(), epic);
        checkEpicStatus(epic);

    }

    @Override
    public Epic getEpic(int id) {
        return epics.getOrDefault(id, null);
    }

    @Override
    public HashMap<Integer, Epic> getEpics() {
        return epics;
    }

    @Override
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

    @Override
    public void deleteAllEpics() {
        epics.clear();
        subtasks.clear();
    }


    // Методы для подзадач

    @Override
    public void addSubtask(Subtask subtask) {
        subtask.setId(++id);
        subtasks.put(id, subtask);
        subtask.getEpic().getEpicSubtasks().add(id);
        checkEpicStatus(subtask.getEpic());
    }

    @Override
    public void updateSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
        checkEpicStatus(subtask.getEpic());
    }

    @Override
    public Subtask getSubtask(int id) {
        return subtasks.getOrDefault(id, null);
    }

    @Override
    public HashMap<Integer, Subtask> getSubtasks() {
        return subtasks;
    }

    @Override
    public void deleteSubtask(int id) {
        if (subtasks.containsKey(id)) {
            Epic epic = subtasks.get(id).getEpic();
            epic.getEpicSubtasks().remove((Integer) id);
            checkEpicStatus(epic);
            subtasks.remove(id);
        }
    }

    @Override
    public void deleteAllSubtask() {

    }

    @Override
    public void deleteAllSubtasks() {
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

// Остальные методы и поля

    private LinkedList<Object> taskHistory = new LinkedList<>();

    private void updateHistory(Task task, LinkedList<Object> history) {
        if (history.size() >= 10) {
            history.removeFirst();
        }
        history.addLast(task);
    }

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

    public static Manager getDefault() {
        Manager manager = new Manager();
        return manager;
    }
}