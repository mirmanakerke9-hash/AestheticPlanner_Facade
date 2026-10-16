import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskManager {
    public List<String> prepareTasks(List<String> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            throw new IllegalArgumentException("Please provide at least one task.");
        }

        List<String> cleanedTasks = new ArrayList<>();
        for (String task : tasks) {
            if (task != null && !task.trim().isEmpty()) {
                cleanedTasks.add(task.trim());
            }
        }

        if (cleanedTasks.isEmpty()) {
            throw new IllegalArgumentException("Tasks cannot be empty.");
        }

        System.out.println("1. Tasks organized: " + cleanedTasks);
        return Collections.unmodifiableList(cleanedTasks);
    }
}
