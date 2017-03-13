package needForSpeed.races;

import needForSpeed.cars.Car;

public class TimeLimitRace extends Race{
    private int goldTime;

    TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.goldTime = goldTime;
    }

    protected int calculateTimePerformance(Car car) {
        return super.getLength() * ((car.getHorsepower() / 100) * car.getAcceleration());
    }

    public void addParticipant(Car car){
        if(super.getParticipants().size() == 0){
            super.addParticipant(car);
        }
    }

    @Override
    protected int calculatePerformance(Car car) {
        return 0;
    }
}
