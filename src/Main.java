
public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();

        Epic epic1 = new Epic("Эпик №1", "Марс");
        manager.addEpic(epic1);

        Subtask subtask11 = new Subtask("Эпик1 Подзадача1", "Рождение", "DONE", epic1.getEpicId());
        manager.addSubtask(subtask11);
        Subtask subtask12 = new Subtask("Эпик1 Подзадача2", "Взросление", "IN_PROGRESS", epic1.getEpicId());
        manager.addSubtask(subtask12);
        Subtask subtask13 = new Subtask("Эпик1 Подзадача3", "Размножение", "NEW", epic1.getEpicId());
        manager.addSubtask(subtask13);

        Subtask subtask12New = new Subtask("Эпик1 Подзадача2 изменена", "Старение", "NEW", epic1.getEpicId());
        subtask12New.setId(10);
        manager.updateSubtask(subtask12New);

        Epic epic2 = new Epic("Эпик №2", "Космос");
        manager.addEpic(epic2);

        Subtask subtask21 = new Subtask("Эпик2 Подзадача1", "Спринт № 1, 2, 3", "DONE", epic2.getEpicId());
        manager.addSubtask(subtask21);
    }
}


