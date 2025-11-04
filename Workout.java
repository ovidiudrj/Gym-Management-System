public class Workout {
    private String name;
    private WorkoutIntensity intensity;
    private double price;

    public Workout(String name, WorkoutIntensity intensity, double price){
        this.name = name;
        this.intensity = intensity;
        this.price = price;
    }

    public String getName(){ return name; }

    public WorkoutIntensity getIntensity(){ return intensity; }

    public double getPrice(){ return price; }


}
