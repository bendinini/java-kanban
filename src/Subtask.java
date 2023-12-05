public class Subtask extends Task {
    private String epicId;
    private String status;

    public Subtask(String title, String description, String status, String epicId) {
        super(title, description);
        this.status = status;
        this.epicId = epicId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle (String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String set){
        this.status = status;
    }

//    public String getEpicId() {
//        return epicId;
//    }
//
//    public void setEpicId(String epicId) {
//        this.epicId = epicId;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

    @Override
    public String toString() {
        return "Subtask{" +
                "ID SubTaskId='" + getId() + '\'' +
                ", ID Epic='" + epicId + '\'' +
                ", Название='" + getTitle() + '\'' +
                ", Описание='" + getDescription() + '\'' +
                ", Статус='" + getStatus() + '\'' +
                '}';
    }
}