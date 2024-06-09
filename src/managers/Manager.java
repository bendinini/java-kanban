package managers;

import models.Epic;
import models.Subtask;
import models.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Manager extends InMemoryTaskManager {
    private int id;
    private LinkedList<Object> taskHistory;

    public Manager() {
        id = 0;
        taskHistory = new LinkedList<>();
    }

    // Остальные методы и поля

    private void updateHistory(Task task, LinkedList<Object> history) {
        if (history.size() >= 10) {
            history.removeFirst();
        }
        history.addLast(task);
    }

    private void checkEpicStatus(Epic epic) {
        // Реализация метода checkEpicStatus
    }

    public static Manager getDefault() {
        Manager manager = new Manager();
        return manager;
    }
}
