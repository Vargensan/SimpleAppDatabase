package logic;

/**
 * Created By Bartłomiej Woś
 */
public class AcessLevel {

    public static final int MAXIMAL_PRIVILAGES = 1;
    public static final int MEDIUM_PRIVILAGES = 2;
    public static final int MINIMAL_PRIVILAGES = 3;

    private static int accessLevel;

    public static int getAccessLevel() {
        return accessLevel;
    }

    public static void setAccessLevel(int accessLevel) {
        AcessLevel.accessLevel = accessLevel;
    }
}
