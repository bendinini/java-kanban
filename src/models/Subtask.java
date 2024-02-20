package models;

import models.Epic;
import models.Task;

public class Subtask extends Task {
    private int idEpic;
    private Epic epic;

    public Subtask(String title, String description, String status, int id, int epicId, Epic epic){
        super(title, description);
        this.idEpic = epicId;
        this.setStatus(status);
        this.epic = epic;
    }

    public int getIdEpic() {
        return idEpic;
    }

    public Epic getEpic() {
        return epic;
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