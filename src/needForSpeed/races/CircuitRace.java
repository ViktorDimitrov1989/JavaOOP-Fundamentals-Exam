package needForSpeed.races;

import needForSpeed.cars.Car;

public class CircuitRace extends Race{
    private int laps;

    CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.laps = laps;
    }

    @Override
    protected int calculatePerformance(Car car) {
        return 0;
        //TODO
    }
}
