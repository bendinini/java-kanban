package managers;

import managers.Manager;
import models.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    void addNewTask() {

        Manager taskManager = Manager.getDefault();
        Task task = new Task("Test addNewTask", "Test addNewTask description");
        taskManager.addTask(task);

        final Task savedTask = taskManager.getTask(task.getId());

        assertNotNull(savedTask, "Задача не найдена.");
        assertEquals(task, savedTask, "Задачи не совпадают.");

        final int tasksSize = taskManager.getTasks().size();

        assertNotNull(taskManager.getTasks(), "Задачи не возвращаются.");
        assertEquals(1, tasksSize, "Неверное количество задач.");
        assertEquals(task, taskManager.getTasks().get(0), "Задачи не совпадают.");
    }
}