import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Manager  {
    private int id;
    private final HashMap<Integer, Task> allTasks = new HashMap<>();
    private final HashMap<Integer, Epic> allEpics = new HashMap<>();
    private final HashMap<Integer, Subtask> allSubtasks = new HashMap<>();

    public Manager() {

    }

    public void addTask(Task task) {
        task.setId(id++);
        allTasks.put(task.getId(), task);
    }

    public Task getTask(int id) {
        return allTasks.getOrDefault(id, null);
    }

    public List<Task> getTaskList() {
        return new ArrayList<>(allTasks.values());
    }

    public void deleteTaskById(int id) {
        if (allTasks.containsKey(id)) {
            allTasks.remove(id);
        }
    }

    public void deleteAllTasks() {
        allTasks.clear();
    }

    public void addEpic(Epic epic) {
        epic.setId(id++);
        epic.setStatus("New");
        allEpics.put(epic.getId(), epic);
    }

    public void deleteSubtask(int id) {
        if (allSubtasks.containsKey(id)) {
            Subtask subtask = allSubtasks.get(id);
            Epic epic = allEpics.get(subtask.getEpicId());
            epic.getEpicSubtasks().remove((Integer) id);
            checkEpicSubtasks(epic);
            allSubtasks.remove(id);
        }
    }

    public void deleteAllSubtasks() {
        List<Epic> epicsForStatusUpdate = new ArrayList<>();
        for (Subtask subtask : allSubtasks.values()) {
            Epic epic = allEpics.get(subtask.getEpicId());
            epic.getEpicSubtasks().clear();
            if (!epicsForStatusUpdate.contains(epic)) {
                epicsForStatusUpdate.add(epic);
            }
        }
        allSubtasks.clear();
        for (Epic epic : epicsForStatusUpdate) {
            epic.setStatus("New");
        }
    }

    public void checkEpicSubtasks(Epic epic) {
        boolean allTasksAreNew = true;
        boolean allTasksAreDone = true;

        if (epic.getEpicSubtasks().size() == 0) {
            epic.setStatus("New");
            return;
        }

        for (Integer epicSubtaskId : epic.getEpicSubtasks()) {
            String status = allSubtasks.get(epicSubtaskId).getStatus();
            if (!status.equals("New")) {
                allTasksAreNew = false;
            }
            if (!status.equals("Done")) {
                allTasksAreDone = false;
            }
        }
        if (allTasksAreDone) {
            epic.setStatus("Done");
        } else if (allTasksAreNew) {
            epic.setStatus("New");
        } else {
            epic.setStatus("In Progress");
        }
    }
}
