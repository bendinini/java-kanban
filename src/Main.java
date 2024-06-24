import managers.TaskManager;
import managers.InMemoryTaskManager;
import models.Epic;
import models.Subtask;

public class Main {

    public static void main(String[] args) {
        TaskManager manager = new InMemoryTaskManager();

        performTaskAdditionAndUpdates(manager);
        printEpicsAndSubtasks(manager);
    }

    private static void performTaskAdditionAndUpdates(TaskManager manager) {
        Epic epic1 = new Epic("Эпик 111", "Марс");
        manager.addEpic(epic1);

        Subtask subtask11 = new Subtask("Эпик111 Подзадача1.1", "Появление", "Выполнено!", 1, epic1.getId(), epic1);
        manager.addSubtask(subtask11);
        Subtask subtask12 = new Subtask("Эпик112 Подзадача2.1", "Перерисывание", "В процессе выполнения...", 1, epic1.getId(), epic1);
        manager.addSubtask(subtask12);
        Subtask subtask13 = new Subtask("Эпик113 Подзадача3.3", "Отлет", "Новая", 1, epic1.getId(), epic1);
        manager.addSubtask(subtask13);

        Subtask subtask12New = new Subtask("Эпик1 Подзадача2 изменена", "Молодение", "Новая", subtask12.getId(), epic1.getId(), epic1);
        subtask12New.setId(subtask12.getId());
        manager.updateSubtask(subtask12New);

        Epic epic2 = new Epic("Эпик 112", "Yandex");
        manager.addEpic(epic2);

        Subtask subtask21 = new Subtask("Эпик122 Подзадача2.1", "Спринт № 1, 2, 3", "Выполнено!", 2, epic2.getId(), epic2);
        manager.addSubtask(subtask21);
    }

    private static void printEpicsAndSubtasks(TaskManager manager) {
        System.out.println("Эпики = " + manager.getEpics());
        System.out.println("Подзадачи = " + manager.getSubtasks());
    }
}