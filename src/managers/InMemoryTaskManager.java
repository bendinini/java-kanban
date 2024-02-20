package managers;

import models.Epic;
import models.Subtask;
import models.Task;

import java.util.ArrayList;
import java.util.HashMap;

public interface InMemoryTaskManager {

    ArrayList<Task> getHistory();
    // Добавляем task-и
    void addTask(Task task);

    // Храним task-и
    void updateTask(Task task);

    // Извлекаем task-и
    Task getTask(int id);

    HashMap<Integer, Task> getTasks();

    // Удаление
    void deleteTask(int id);

    void deleteAllTasks();

    //Эпики
    void addEpic(Epic epic);

    void updateEpic(Epic epic);

    Epic getEpic(int id);

    HashMap<Integer, Epic> getEpics();

    void deleteEpic(int id);

    void deleteAllEpics();

    //Подзадачи
    void addSubtask(Subtask subtask);

    void updateSubtask(Subtask subtask);

    Subtask getSubtask(int id);

    HashMap<Integer, Subtask> getSubtasks();

    void deleteSubtask(int id);

    void deleteAllSubtask();

    void deleteAllSubtasks();
}
