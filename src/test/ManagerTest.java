package test;

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

    @Test
    public void testUpdateTask() {
        Task task = new Task("Изначальная задача", "Описание изначальной задачи");
        manager.addTask(task);

                                        // Обновляю задачу
        task.setTitle("Обновленная задача");
        task.setDescription("Обновленное описание задачи");
        manager.updateTask(task);

                                        // Получаю обновленную задачу из менеджера
        Task updatedTask = manager.getTask(task.getId());

                                        // Проверка, что задача обновлена корректно
        assertEquals("Обновленная задача", updatedTask.getTitle());
        assertEquals("Обновленное описание задачи", updatedTask.getDescription());
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("Удаляемая задача", "Описание удаляемой задачи");
        manager.addTask(task);

                                    // Удаляю задачу
        manager.deleteTask(task.getId());

                                    // Проверяю, что задача удалена из менеджера
        assertNull(manager.getTask(task.getId()));
    }

    @Test
    public void testDeleteAllTasks() {
                                // Добавляю несколько задач
        Task task1 = new Task("Задача 1", "Описание задачи 1");
        Task task2 = new Task("Задача 2", "Описание задачи 2");
        manager.addTask(task1);
        manager.addTask(task2);

                                // Удаляю все задачи
        manager.deleteAllTasks();

                                // Проверяю, что все задачи удалены
        assertEquals(new HashMap<Integer, Task>(), manager.getTasks());
    }

}