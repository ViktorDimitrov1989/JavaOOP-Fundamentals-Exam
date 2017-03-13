package needForSpeed;

import needForSpeed.cars.Car;
import needForSpeed.cars.PerformanceCar;
import needForSpeed.cars.ShowCar;
import needForSpeed.garage.Garage;
import needForSpeed.races.CasualRace;
import needForSpeed.races.DragRace;
import needForSpeed.races.DriftRace;
import needForSpeed.races.Race;

import java.util.HashMap;
import java.util.Map;

public class CarManager {
    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Garage garage;

    public CarManager() {
        this.cars = new HashMap<>();
        this.races = new HashMap<>();
        garage = new Garage();
    }

    public void register(int id, String type, String brand, String model,
                         int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        Car car;
        switch (type){
            case "Performance":
                car = new PerformanceCar(brand,model,yearOfProduction, horsepower,acceleration,suspension,durability);
                this.cars.put(id,  car);
                break;
            case "Show":
                car = new ShowCar(brand,model,yearOfProduction, horsepower,acceleration,suspension,durability);
                this.cars.put(id, car);
                break;
        }
    }

    public String check(int id) {
        return this.cars.get(id).toString();
    }

    public void open(int id, String type, int length, String route, int prizePool) {
        Race race;
        switch (type.toLowerCase()){
            case "casual":
                race = new CasualRace(length, route, prizePool);
                this.races.put(id, race);
                break;
            case "drag":
                race = new DragRace(length, route, prizePool);
                this.races.put(id, race);
                break;
            default:
                race = new DriftRace(length, route, prizePool);
                this.races.put(id, race);
                break;
        }
    }

    public void participate(int carId, int raceId) {
        Car car = this.cars.get(carId);
        Race race = this.races.get(raceId);
        if(!car.isParked() && !race.getParticipants().contains(car)){
            race.addParticipant(car);
            car.setParticipate(true);
        }
    }

    public String start(int id) {
        Race race = this.races.get(id);
        if(race.getParticipants().size() <= 0){
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot start the race with zero participants.").append(System.lineSeparator());
            return sb.toString();
        }
        race.setParticipantsAvailable(this.races);
        this.races.remove(id);
        return race.toString();
    }

    public void park(int id) {
        Car car = this.cars.get(id);
        if(!car.isParticipate()){
            this.garage.addCar(car);
            car.setParked(true);
        }
    }

    public void unpark(int id) {
        Car car = this.cars.get(id);
        this.garage.removeCar(car);
        car.setParked(false);
    }

    public void tune(int tuneIndex, String addOn) {
        if(this.garage.getParkedCars().size() > 0){
            this.garage.tuneCars(tuneIndex, addOn);
        }
    }
}
