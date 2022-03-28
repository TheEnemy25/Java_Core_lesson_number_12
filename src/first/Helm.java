package first;

import java.util.Random;

public class Helm {

    private int wheelDiameter;
    private String wheelMaterial;

    private final String[] materialList = new String[]{"leather", "alcantara"};

    public Helm() throws IllegalAccessException {
        this.wheelDiameter = getRandomValue(10, 20);
        this.wheelMaterial = generateMaterial();
    }

    public double getWheelDiameter() {
        return wheelDiameter;
    }

    public void setWheelDiameter(int wheelDiameter) {
        this.wheelDiameter = wheelDiameter;
    }

    public String getWheelMaterial() {
        return wheelMaterial;
    }

    public void setWheelMaterial(String wheelMaterial) {
        this.wheelMaterial = wheelMaterial;
    }

    @Override
    public String toString() {
        return ", " +
                "wheelDiameter=" + wheelDiameter +
                ", wheelMaterial='" + wheelMaterial + '\'' +
                "";
    }

    public static int getRandomValue(int min, int max) throws IllegalAccessException {
        if (min >= max) {
            throw new IllegalAccessException("Не правильне твердження");
        }

        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private String generateMaterial() throws IllegalAccessException {
        return materialList[getRandomValue(0, 1)];
    }


}
