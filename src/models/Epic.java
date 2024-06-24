package models;

import java.util.List;
import java.util.ArrayList;

public class Epic extends Task {
    private List<Integer> idSubtasks;

    public Epic(String title, String description) {
        super(title, description);
        this.idSubtasks = new ArrayList<>();
    }

    public List<Integer> getEpicSubtasks() {
        return idSubtasks;
    }

    public void setEpicSubtasks(List<Integer> epicSubtasks) {
        this.idSubtasks = epicSubtasks;
    }

    @Override
    public String toString() {
        return "Эпик{" +
                "№=" + getId() +
                ", Название='" + getTitle() + '\'' +
                ", Описание='" + getDescription() + '\'' +
                ", Статус='" + getStatus() + '\'' +
                '}';
    }
}