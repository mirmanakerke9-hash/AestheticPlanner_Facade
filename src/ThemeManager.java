public class ThemeManager {
    public String selectTheme(String themeName) {
        if (themeName == null || themeName.trim().isEmpty()) {
            themeName = "Sage Green";
        }

        String theme = themeName.trim();
        System.out.println("3. Aesthetic theme selected: " + theme);
        return theme;
    }
}
