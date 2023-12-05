import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private int id;
    private String epicId;
    private String title;
    private String description;
    private String status;
    private List<Integer> epicSubtasks;

    public Epic (String epicId, String Status) {
        super (epicId, Status);
        this.epicId = epicId;
        status = Status.NEW;
        this.description = description;
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

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    //public void setEpicId(String epicId) {
        //this.epicId = epicId;
    //}

    //public String getStatus() {
        //return status;
    //}

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Integer> getEpicSubtasks() {
        return epicSubtasks;
    }

    @Override
    public String toString() {
        return "Подзадача{" +
                "ID Epic='" + epicId + '\'' +
                ", Title='" + getTitle() + '\'' +
                ", Description='" + getDescription() + '\'' +
                ", Status='" + getStatus() + '\'' +
                ", SubTaskID='" + epicSubtasks +'\'' +
                '}';
    }
}