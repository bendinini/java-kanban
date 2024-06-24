package managers;

import models.Epic;
import models.Subtask;
import models.Task;

import java.util.Collection;
import java.util.LinkedList;

public class Manager extends InMemoryTaskManager {
    private int id;
    private LinkedList<Task> taskHistory;

    public Manager() {
        id = 0;
        taskHistory = new LinkedList<>();
    }



    private void updateHistory(Task task, LinkedList<Task> history) {
        if (history.size() >= 10) {
            history.removeFirst();
        }
        history.addLast(task);
    }

    private void checkEpicStatus(Epic epic) {
    }

    public static Manager getDefault() {
        return new Manager();
    }
}