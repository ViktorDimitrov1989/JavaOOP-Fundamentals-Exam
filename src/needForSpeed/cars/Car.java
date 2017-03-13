package needForSpeed.cars;

public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;
    private String time;
    private boolean participate;
    private boolean parked;

    Car(String brand, String model, int yearOfProduction,
        int horsepower, int acceleration, int suspension, int durability){
        this.setBrand(brand);
        this.setModel(model);
        this.setYearOfProduction(yearOfProduction);
        this.setHorsepower(horsepower);
        this.setAcceleration(acceleration);
        this.setSuspension(suspension);
        this.setDurability(durability);
        this.participate = false;
        this.parked = false;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    protected void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    private void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    private void setDurability(int durability) {
        this.durability = durability;
    }

    public boolean isParticipate(){
        return this.participate;
    }

    public void setParticipate(boolean participate){
        this.participate = participate;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    private int getYearOfProduction() {
        return this.yearOfProduction;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public int getAcceleration() {
        return this.acceleration;
    }

    public int getSuspension() {
        return this.suspension;
    }

    public int getDurability() {
        return this.durability;
    }

    public boolean isParked() {
        return this.parked;
    }

    public void setParked(boolean parked) {
        this.parked = parked;
    }

    void increaseHorsePower(int hp){
        this.horsepower += hp;
    }

    void increaseSuspension(int suspension){
        this.suspension += (suspension * 50) / 100;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s %d", this.getBrand(), this.getModel(), this.getYearOfProduction())).append(System.lineSeparator());
        sb.append(String.format("%d HP, 100 m/h in %d s", this.getHorsepower(), this.getAcceleration())).append(System.lineSeparator());
        sb.append(String.format("%d Suspension force, %d Durability", this.getSuspension(), this.getDurability())).append(System.lineSeparator());
        return sb.toString();
    }

    public abstract void tuneCar(int index, String addOn);
}
