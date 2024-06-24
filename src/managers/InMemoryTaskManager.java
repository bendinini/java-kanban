package managers;

import models.Epic;
import models.Subtask;
import models.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryTaskManager implements TaskManager {
    protected Map<Integer, Task> tasks = new HashMap<>();
    protected Map<Integer, Epic> epics = new HashMap<>();
    protected int nextId = 1;

    @Override
    public void addTask(Task task) {
        task.setId(nextId++);
        tasks.put(task.getId(), task);
    }

    @Override
    public Task getTask(int id) {
        return tasks.get(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return tasks.values().stream().collect(Collectors.toList());
    }

    @Override
    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public void removeTask(int id) {
        tasks.remove(id);
    }

    @Override
    public void addEpic(Epic epic) {
        epic.setId(nextId++);
        epics.put(epic.getId(), epic);
    }

    @Override
    public Epic getEpic(int id) {
        return epics.get(id);
    }

    @Override
    public void updateEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }

    @Override
    public void removeEpic(int id) {
        epics.remove(id);
    }

    @Override
    public void addSubtask(Subtask subtask) {
        subtask.setId(nextId++);
        Epic epic = epics.get(subtask.getEpicId());
        if (epic != null) {
            epic.getEpicSubtasks().add(subtask.getId());
        }
        tasks.put(subtask.getId(), subtask);
    }

    @Override
    public Subtask getSubtask(int id) {
        Task task = tasks.get(id);
        if (task instanceof Subtask) {
            return (Subtask) task;
        }
        return null;
    }

    @Override
    public void updateSubtask(Subtask subtask) {
        tasks.put(subtask.getId(), subtask);
    }

    @Override
    public void removeSubtask(int id) {
        Task task = tasks.get(id);
        if (task instanceof Subtask) {
            Subtask subtask = (Subtask) task;
            Epic epic = epics.get(subtask.getEpicId());
            if (epic != null) {
                epic.getEpicSubtasks().remove(Integer.valueOf(id));
            }
        }
        tasks.remove(id);
    }

    @Override
    public Map<Integer, Task> getTasks() {
        return tasks;
    }

    @Override
    public Map<Integer, Epic> getEpics() {
        return epics;
    }

    @Override
    public Map<Integer, Subtask> getSubtasks() {
        return tasks.values().stream()
                .filter(task -> task instanceof Subtask)
                .map(task -> (Subtask) task)
                .collect(Collectors.toMap(Subtask::getId, subtask -> subtask));
    }
}