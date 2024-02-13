import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager() {
            @java.lang.Override
            public ArrayList<Task> getHistory() {
                return null;
            }

            @java.lang.Override
            public void deleteAllSubtask() {

            }
        };

        performTaskAdditionAndUpdates(manager);
        printEpicsAndSubtasks(manager);
    }

    private static void performTaskAdditionAndUpdates(Manager manager) {
        Epic epic1 = new Epic("Эпик 111", "Марс");
        manager.addEpic(epic1);

        Subtask subtask11 = new Subtask("Эпик111 Подзадача1.1", "Появление", "Выполнено!", 1, manager);
        manager.addSubtask(subtask11);
        Subtask subtask12 = new Subtask("Эпик112 Подзадача2.1", "Перерисывание", "В процессе выполнения...", 1, manager);
        manager.addSubtask(subtask12);
        Subtask subtask13 = new Subtask("Эпик113 Подзадача3.3", "Отлет", "Новая", 1, manager);
        manager.addSubtask(subtask13);

        Subtask subtask12New = new Subtask("Эпик1 Подзадача2 изменена", "Молодение", "Новая", 1, manager);
        subtask12New.setId(12);
        manager.updateSubtask(subtask12New);

        Epic epic2 = new Epic("Эпик 112", "Yandex");
        manager.addEpic(epic2);

        Subtask subtask21 = new Subtask("Эпик122 Подзадача2.1", "Спринт № 1, 2, 3", "Выполнено!", 2, manager);
        manager.addSubtask(subtask21);
    }

    private static void printEpicsAndSubtasks(Manager manager) {
        System.out.println("Эпики = " + manager.getEpics());
        System.out.println("Подзадачи = " + manager.getSubtasks());
    }
}