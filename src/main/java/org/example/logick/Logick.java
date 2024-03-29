package org.example.logick;

public class Logick {
    public static final boolean[] FIRST_COLUMN = null;
    public static final boolean[] SECOND_COLUMN = null;
    public static final boolean[] SEVENTH_COLUMN = null;
    public static final boolean[] EIGHTH_COLUMN = null;

    private Logick() {
        throw new RuntimeException("вы не можете создать экземпляр класса");
    }

    public static boolean isValidCoordinate(int coordinate) {
        return coordinate >= 0 && coordinate < 64;
    }
}
