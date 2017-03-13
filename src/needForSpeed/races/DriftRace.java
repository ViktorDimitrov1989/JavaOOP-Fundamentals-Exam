package needForSpeed.races;

import needForSpeed.cars.Car;

import java.util.List;
import java.util.stream.Collectors;

public class DriftRace extends Race{
    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }


    @Override
    protected int calculatePerformance(Car car) {
        return (car.getSuspension() + car.getDurability());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        List<Car> sortedCars = super.getParticipants().stream()
                .sorted((c1,c2) -> Integer.compare(this.calculatePerformance(c2), this.calculatePerformance(c1)))
                .limit(3)
                .collect(Collectors.toList());
        for (int i = 0; i < sortedCars.size(); i++) {
            Car car = sortedCars.get(i);
            sb.append(String.format("%d. %s %s %dPP - $%d",
                    i + 1, car.getBrand(), car.getModel(), this.calculatePerformance(car), super.calculateProfit(i + 1)))
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
