package needForSpeed.garage;
import needForSpeed.cars.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Garage {
    private List<Car> parkedCars;

    public Garage(){
        this.parkedCars = new ArrayList<>();
    }

    public void addCar(Car car){
        this.parkedCars.add(car);
    }

    public void tuneCars(int tuneIndex, String addOn) {
        for (Car parkedCar : this.parkedCars) {
            parkedCar.tuneCar(tuneIndex,addOn);
        }
    }

    public List<Car> getParkedCars() {
        return Collections.unmodifiableList(this.parkedCars);
    }

    public void removeCar(Car car) {
        this.parkedCars.remove(car);
    }
}
