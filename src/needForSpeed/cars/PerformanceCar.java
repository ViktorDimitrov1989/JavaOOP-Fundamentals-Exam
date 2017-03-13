package needForSpeed.cars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PerformanceCar extends Car{
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction,
                          int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    @Override
    protected void setHorsepower(int horsepower) {
        super.setHorsepower(this.calcHorsePower(horsepower));
    }

    @Override
    protected void setSuspension(int suspension) {
        super.setSuspension(this.calcSuspension(suspension));
    }

    private int calcHorsePower(int horsePower){
        return horsePower + (horsePower * 50) / 100;
    }

    private int calcSuspension(int suspension){
        return suspension - (suspension * 25) / 100;
    }

    @Override
    public void tuneCar(int index, String addOn) {
        super.increaseSuspension(index);
        super.increaseHorsePower(index);
        this.addOns.add(addOn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("Add-ons: %s", this.addOns.size() > 0 ? String.join(", ", this.addOns.
                stream().collect(Collectors.toList())) : "None")).
                append(System.lineSeparator());
        return sb.toString();
    }

}
