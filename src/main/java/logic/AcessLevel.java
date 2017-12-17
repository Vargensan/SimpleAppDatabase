package logic;

/**
 * Created By Bartłomiej Woś
 */
public class AcessLevel {

    private static int accessLevel;

    public static int getAccessLevel() {
        return accessLevel;
    }

    public static void setAccessLevel(int accessLevel) {
        AcessLevel.accessLevel = accessLevel;
    }
}
