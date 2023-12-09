public class Task {
    private int id;
    private String title;
    private String description;
    private String status;

    public Task (String title, String description) {
        this.title = title;
        this.description = description;
        status = "NEW";
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

    @Override
    public String toString() {
        return "Task{" +
                "ID task ='" + id + '\'' +
                ", title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", Status='" + status + '\'' +
                '}';
    }
}