import java.util.ArrayList;
import java.util.List;


public class Epic extends Task {
    //private Integer epicId;
    private List<Integer> epicSubtasks = new ArrayList<>();

    public Epic (String title, String description) {

        super(title, description);

    }


    public List<Integer> getEpicSubtasks(List <Integer> epicSubtasks) {
        return epicSubtasks;
    }

    public void setEpicSubtasks (List <Integer> epicSubtasks){
        this.epicSubtasks = epicSubtasks;
    }


    @Override
    public String toString() {
        return "Epic { Title='" + getTitle() + '\'' +
                ", Description='" + getDescription() + '\'' +
                ", Status='" + getStatus() + '\'' +
                ", SubTaskID='" + epicSubtasks +'\'' +
                '}';
    }
}