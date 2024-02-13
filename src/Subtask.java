public class Subtask extends Task {
    private int idEpic; //исправила, надеюсь правильно
    private Manager manager;

    public Subtask(String title, String description, String status, int epicId, Manager manager) {
        super(title, description);
        this.idEpic = epicId;
        this.setStatus(status);
        this.manager = manager;
    }

    public Epic getEpic() {
        return manager.getEpic(idEpic);
    }

    public void setEpic(Epic epic) {
        this.idEpic = epic.getId();
    }

    @Override
    public String toString() {
        return "Подзадача{" +
                "№=" + getId() +
                ", Название='" + getTitle() + '\'' +
                ", Описание='" + getDescription() + '\'' +
                ", Статус='" + getStatus() + '\'' +
                ", ID эпика=" + idEpic +
                '}';
    }
}