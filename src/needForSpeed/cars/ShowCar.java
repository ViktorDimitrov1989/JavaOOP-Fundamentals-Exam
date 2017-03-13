package needForSpeed.cars;

public class ShowCar extends Car{
    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("%d *", this.stars)).append(System.lineSeparator());
        return sb.toString();
    }

    @Override
    public void tuneCar(int index, String addOn) {
        this.stars += index;
        super.increaseSuspension(index);
        super.increaseHorsePower(index);
    }
}
