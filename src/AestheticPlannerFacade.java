import java.util.List;
import java.util.Map;

public class AestheticPlannerFacade {
    private final TaskManager taskManager;
    private final ScheduleManager scheduleManager;
    private final ThemeManager themeManager;
    private final MotivationManager motivationManager;

    public AestheticPlannerFacade() {
        this.taskManager = new TaskManager();
        this.scheduleManager = new ScheduleManager();
        this.themeManager = new ThemeManager();
        this.motivationManager = new MotivationManager();
    }

    public void createDailyPlan(List<String> tasks, String startTime, String themeName) {
        System.out.println("\n AESTHETIC PLANNER ");

        try {
            List<String> organizedTasks = taskManager.prepareTasks(tasks);
            Map<String, String> schedule =
                    scheduleManager.createSchedule(organizedTasks, startTime);
            String theme = themeManager.selectTheme(themeName);
            String quote = motivationManager.chooseQuote();

            printPlan(schedule, theme, quote);
        } catch (IllegalArgumentException exception) {
            System.out.println("Could not create your plan: " + exception.getMessage());
        }
    }

    private void printPlan(Map<String, String> schedule, String theme, String quote) {
        System.out.println("\n YOUR DAILY PLAN ");
        System.out.println("Theme: " + theme);
        for (Map.Entry<String, String> entry : schedule.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("Quote: " + quote);
        System.out.println(" ");
    }
}
