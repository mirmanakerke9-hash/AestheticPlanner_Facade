import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ScheduleManager {
    public Map<String, String> createSchedule(List<String> tasks, String startTime) {
        if (startTime == null || startTime.trim().isEmpty()) {
            throw new IllegalArgumentException("A start time is required.");
        }

        Map<String, String> schedule = new LinkedHashMap<>();
        int hour = parseStartHour(startTime);

        for (String task : tasks) {
            String time = String.format("%02d:00", hour % 24);
            schedule.put(time, task);
            hour++;
        }

        System.out.println("2. Schedule created from " + startTime + ".");
        return schedule;
    }

    private int parseStartHour(String startTime) {
        try {
            String[] parts = startTime.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = parts.length > 1 ? Integer.parseInt(parts[1]) : 0;

            if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
                throw new IllegalArgumentException("Use a valid 24-hour time, such as 09:00.");
            }
            return hour;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException exception) {
            throw new IllegalArgumentException("Use a valid time, such as 09:00.");
        }
    }
}
