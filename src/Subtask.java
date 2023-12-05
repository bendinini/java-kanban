public class Subtask extends Task {
    private String epicId;
    private String status;

    public Subtask(String title, String description, String status, String epicId) {
        super(title, description);
        this.status = status;
        this.epicId = epicId;
    }

    public String getEpicId() {
        return epicId;
    }

    public void setEpicId(String epicId) {
        this.epicId = epicId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Подзадача{" +
                "ID эпика='" + epicId + '\'' +
                ", Название='" + getTitle() + '\'' +
                ", Описание='" + getDescription() + '\'' +
                ", Статус='" + status + '\'' +
                '}';
    }
}