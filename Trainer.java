public class Trainer {
    private String name;
    private String surname;
    private TrainerType type;
    private Workout specialization;

    public Trainer(String name, String surname, TrainerType type, Workout specialization){
        this.name = name;
        this.surname = surname;
        this.type = type;
        this.specialization = specialization;
    }

    public String getName(){ return name; }
    public String getSurname(){ return surname; }
    public TrainerType getType(){ return type; }
    public Workout getSpecialization(){ return specialization; }
}
