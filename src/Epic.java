import java.util.ArrayList;
import java.util.List;

public class Epic {
    private int id;
    private String epicId;
    private String status;
    private List<Integer> epicSubtasks;

    public Epic(String epicId, String status) {
        this.epicId = epicId;
        this.status = status;
        this.epicSubtasks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Integer> getEpicSubtasks() {
        return epicSubtasks;
    }
}