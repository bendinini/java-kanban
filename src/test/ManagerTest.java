import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import managers.Manager;
import models.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

class ManagerTest {

    private Manager manager;

    @BeforeEach
    public void setUp() {
        manager = new Manager();
    }

    @Test
    void addNewTask() {
        Task task = new Task("Test addNewTask", "Test addNewTask description");
        manager.addTask(task);

        Task savedTask = manager.getTask(task.getId());

        assertNotNull(savedTask, "Task not found.");
        assertEquals(task, savedTask, "Tasks do not match.");

        int tasksSize = manager.getTasks().size();

        assertNotNull(manager.getTasks(), "Tasks are not returned.");
        assertEquals(1, tasksSize, "Incorrect number of tasks.");
        assertEquals(task, manager.getTasks().get(task.getId()), "Tasks do not match.");
    }

    @Test
    public void testUpdateTask() {
        Task task = new Task("Initial Task", "Initial Task Description");
        manager.addTask(task);

        task.setTitle("Updated Task");
        task.setDescription("Updated Task Description");
        manager.updateTask(task);

        Task updatedTask = manager.getTask(task.getId());

        assertEquals("Updated Task", updatedTask.getTitle());
        assertEquals("Updated Task Description", updatedTask.getDescription());
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("Deletable Task", "Deletable Task Description");
        manager.addTask(task);

        manager.removeTask(task.getId());

        assertNull(manager.getTask(task.getId()));
    }

    @Test
    public void testDeleteAllTasks() {
        Task task1 = new Task("Task 1", "Task 1 Description");
        Task task2 = new Task("Task 2", "Task 2 Description");
        manager.addTask(task1);
        manager.addTask(task2);

        manager.getAllTasks();

        assertEquals(new HashMap<Integer, Task>(), manager.getTasks());
    }
}