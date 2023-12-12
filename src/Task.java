package tasks;


public class Task {
    protected int id;
    protected String title;
    protected String description;
    protected String status;

    public Task() {
        this.title = "";
        this.description = "";
        this.status = "New";
    }

    public Task(String title, String description) {
        this();
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ЗАДАЧА{" +
                "№=" + id +
                ", Название='" + title + '\'' +
                ", Описание='" + description + '\'' +
                ", Статус='" + status + '\'' +
                '}';
    }
}