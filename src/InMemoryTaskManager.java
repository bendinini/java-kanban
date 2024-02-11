import java.util.ArrayList;
import java.util.HashMap;

public interface InMemoryTaskManager {

    ArrayList<Task> getHistory();
    //Задачи: добавляем task
    void addTask(Task task);

    // храним task
    void updateTask(Task task);

    // извлекаем task
    Task getTask(int id);

    HashMap<Integer, Task> getTasks();

    // метод для удаления
    void deleteTask(int id);

    void deleteAllTasks();

    //Эпики пошли
    void addEpic(Epic epic);

    void updateEpic(Epic epic);

    Epic getEpic(int id);

    HashMap<Integer, Epic> getEpics();

    void deleteEpic(int id);

    void deleteAllEpics();

    //Аналогично для подзадач
    void addSubtask(Subtask subtask);

    void updateSubtask(Subtask subtask);

    Subtask getSubtask(int id);

    HashMap<Integer, Subtask> getSubtasks();

    void deleteSubtask(int id);

    void deleteAllSubtask();
}
