package models;

import models.Task;

import java.util.ArrayList;

public class Epic extends Task {

    private ArrayList<Integer> idSubtasks;

    public Epic(String title, String description) {
        super(title, description);
        idSubtasks = new ArrayList<>();
    }

    public ArrayList<Integer> getEpicSubtasks() {
        return idSubtasks;
    }

    public void setEpicSubtasks(ArrayList<Integer> epicSubtasks) {
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