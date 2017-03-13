package needForSpeed.races;

import needForSpeed.cars.Car;

import java.util.*;

//TODO add Participants to the races

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    Race(int length, String route, int prizePool){
        this.setLength(length);
        this.setRoute(route);
        this.setPrizePool(prizePool);
        this.participants = new LinkedList<>();
    }

    private void setLength(int length) {
        this.length = length;
    }

    private void setRoute(String route) {
        this.route = route;
    }

    private void setPrizePool(int prizePool) {
        this.prizePool = prizePool;
    }

    public void addParticipant(Car car){
        this.participants.add(car);
    }

    protected int getLength() {
        return this.length;
    }

    private String getRoute() {
        return this.route;
    }

    public List<Car> getParticipants() {
        return Collections.unmodifiableList(participants);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %s", this.getRoute(), this.getLength())).append(System.lineSeparator());
        return sb.toString();
    }

    protected abstract int calculatePerformance(Car car);

    int calculateProfit(int place){
        switch (place){
            case 1:
                return (this.prizePool * 50) / 100;
            case 2:
                return (this.prizePool * 30) / 100;
            case 3:
                return (this.prizePool * 20) / 100;
        }
        return 0;
    }

    public void setParticipantsAvailable(Map<Integer, Race> races){
        this.participants.forEach(c -> {
            for (Race race : races.values()) {
                if(!race.getParticipants().contains(c)){
                    c.setParticipate(false);
                }
            }
        });
    }

}
