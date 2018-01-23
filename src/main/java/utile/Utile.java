package utile;

public class Utile {
    private static Utile ourInstance = new Utile();

    public static Utile getInstance() {
        return ourInstance;
    }

    private Utile() {
    }
    public static int makeInt(String string) {
        int intValue = 0;
        try {
            intValue = Integer.parseInt(string);
        } catch (NumberFormatException n) {
            n.printStackTrace();
        }
        return intValue;
    }
}
