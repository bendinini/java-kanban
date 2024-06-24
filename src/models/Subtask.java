package models;

public class Subtask extends Task {
    private int idEpic;
    private Epic epic;

    public Subtask(String name, String description, String status, int id, int epicId, Epic epic) {
        super(name, description);
        this.idEpic = epicId;
        this.epic = epic;
        setId(id);
        setStatus(status);
    }

    public int getEpicId() {
        return idEpic;
    }

    public Epic getEpic() {
        return epic;
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
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