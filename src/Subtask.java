public class Subtask extends Task {
    private Epic idEpic;

    public Subtask(String title, String description, String status, Epic epic) {
        super(title, description);
        this.idEpic = epic;
        this.setStatus(status);
    }

    public Epic getEpic() {
        return idEpic;
    }

    public void setEpic(Epic epic) {
        this.idEpic = epic;
    }

    @Override
    public String toString() {
        return "Подзадача{" +
                "№=" + id +
                ", Название='" + title + '\'' +
                ", Описание='" + description + '\'' +
                ", Статус='" + status + '\'' +
                '}';
    }
}