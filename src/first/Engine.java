package first;

import java.util.Random;

public class Engine {

    private int umberOfCylinders;

    public Engine() throws IllegalAccessException {
        this.umberOfCylinders = getRandomValue(2,10);
    }

    public int getUmberOfCylinders() {
        return umberOfCylinders;
    }

    public void setUmberOfCylinders(int umberOfCylinders) {
        this.umberOfCylinders = umberOfCylinders;
    }

    @Override
    public String toString() {
        return ", " +
                "umberOfCylinders=" + umberOfCylinders +
                " ";
    }

    public static int getRandomValue(int min, int max) throws IllegalAccessException {
        if (min >= max) {
            throw new IllegalAccessException("Не правильне твердження");
        }

        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }


}
