package first;

public class Car {

    private int horsepower;
    private int release;
    private Helm helm = new Helm();
    private Engine engine = new Engine();

    public Car(int horsepower, int release) throws IllegalAccessException {
        this.horsepower = horsepower;
        this.release = release;
    }

    public double getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }

    public Engine getEngine() {
        return engine;
    }

    public Helm getHelm() {
        return helm;
    }

    @Override
    public String toString() {
        return "Car{" +
                "horsepower=" + horsepower +
                ", release=" + release + "" +
                engine.toString() + "" +
                helm.toString() +
                '}';
    }

}
