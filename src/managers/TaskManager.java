package managers;

import models.Epic;
import models.Subtask;
import models.Task;

import java.util.List;
import java.util.Map;

public interface TaskManager {
    void addTask(Task task);
    Task getTask(int id);
    List<Task> getAllTasks();
    void updateTask(Task task);
    void removeTask(int id);

    void addEpic(Epic epic);
    Epic getEpic(int id);
    void updateEpic(Epic epic);
    void removeEpic(int id);

    void addSubtask(Subtask subtask);
    Subtask getSubtask(int id);
    void updateSubtask(Subtask subtask);
    void removeSubtask(int id);

    Map<Integer, Task> getTasks();
    Map<Integer, Epic> getEpics();
    Map<Integer, Subtask> getSubtasks();
}