import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AestheticPlannerFacade planner = new AestheticPlannerFacade();

        List<String> tasks = Arrays.asList(
            "Morning skincare",
            "Attend lectures",
            "Study Java",
            "Go for a walk",
            "Read a book"
        );

        planner.createDailyPlan(tasks, "09:00", "Soft Pink");
    }
}
