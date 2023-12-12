package tasks;

public class Subtask extends tasks.Task {
    private Epic idEpic;

    public Subtask(String title, String description, String status, Epic epic) {
        super();
        this.idEpic = epic;
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