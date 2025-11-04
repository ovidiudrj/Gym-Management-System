import java.util.ArrayList;
import java.util.Scanner;

public class FitZone {
    private ArrayList<Registration> registrations = new ArrayList<>();
    private ArrayList<Workout> availableWorkouts = new ArrayList<>();
    private ArrayList<Trainer> trainers = new ArrayList<>();

    private String name = "FitZone+";


    public FitZone()
    {
        availableWorkouts.add( new Workout("Yoga", WorkoutIntensity.EASY, 20 ) );
        availableWorkouts.add( new Workout("Pilates", WorkoutIntensity.MEDIUM, 30) );
        availableWorkouts.add( new Workout("Crossfit", WorkoutIntensity.HARD, 40) );
        availableWorkouts.add( new Workout("Zumba", WorkoutIntensity.EASY, 20) );
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- FitZone+ Menu ---");
            System.out.println("1. Add registration");
            System.out.println("2. Show registrations");
            System.out.println("3. Update prices");
            System.out.println("4. Add workout");
            System.out.println("5. Show workouts");
            System.out.println("6. Add trainer");
            System.out.println("7. Show trainers");
            System.out.println("8. Workout-Trainers Report");
            System.out.println("0. Exit");

            option = scanner.nextInt();

            switch(option) {
                case 1 -> addRegistration(scanner);
                case 2 -> showRegistrations();
                case 3 -> updatePrices(scanner);
                case 4 -> addWorkout(scanner);
                case 5 -> showWorkouts();
                case 6 -> addTrainer(scanner);
                case 7 -> showTrainers();
                case 8 -> showWorkoutTrainerReport();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option");
            }

        } while(option != 0);
    }


    public void addRegistration(Scanner scanner){
        System.out.print("Enter client name: ");
        String name = scanner.next();
        System.out.print("Enter client surname: ");
        String surname = scanner.next();

        System.out.println("Choose subscription type: ");
        System.out.println("1. Standard subscription");
        System.out.println("2. Premium subscription");

        int option = scanner.nextInt();

        if(option == 1){
            registrations.add(new Registration(new Client(name, surname), new StandardSubscription()));
        }
        else if(option == 2){
            registrations.add(new Registration(new Client(name, surname), new PremiumSubscription()));
        }
        System.out.println("Registration added");
    }

    public void showRegistrations(){
        for ( Registration x : registrations){
            System.out.println( x.getClient().getName() + " " +
                                x.getClient().getSurname() + " | "+
                                x.getSubscription().getType());
        }
    }

    public void updatePrices(Scanner scanner){
        System.out.println("New price: ");
        double newPrice = scanner.nextDouble();
        Subscription.modifyPrice(newPrice);
        System.out.println("Prices updated");
    }

    public void addWorkout(Scanner scanner) {
        System.out.println("Please enter the name of the workout:");
        String name = scanner.next();

        System.out.println("Please choose the intensity:");
        System.out.println("a. Easy");
        System.out.println("b. Medium");
        System.out.println("c. Hard");

        String option = scanner.next();
        WorkoutIntensity intensity;

        if (option.equalsIgnoreCase("a"))
            intensity = WorkoutIntensity.EASY;
        else if (option.equalsIgnoreCase("b"))
            intensity = WorkoutIntensity.MEDIUM;
        else if (option.equalsIgnoreCase("c"))
            intensity = WorkoutIntensity.HARD;
        else {
            System.out.println("Invalid option");
            return;
        }

        System.out.println("Please enter the price of the workout:");
        double price = scanner.nextDouble();

        availableWorkouts.add(new Workout(name, intensity, price));
        System.out.println("Workout added");
    }

    public void showWorkouts(){
        for (Workout x : availableWorkouts){
            System.out.println(x.getName() + " | " + x.getIntensity() + " | " + x.getPrice() + " ron");
        }
    }

    private Workout findWorkout(String name) {
        for (Workout w : availableWorkouts) {
            if (w.getName().equalsIgnoreCase(name)) {
                return w;
            }
        }
        return null;
    }

    public void addTrainer(Scanner scanner){
        System.out.println("Please enter the trainer's name:");
        String name = scanner.next();

        System.out.println("Please enter the trainer's surname:");
        String surname = scanner.next();

        System.out.println("Please choose the trainer's type:");
        System.out.println("a. Full Time");
        System.out.println("b. Part Time");
        TrainerType type;

        String option = scanner.next();
        if (option.equals("a"))
            type = TrainerType.FULLTIME;
        else if (option.equals("b"))
            type = TrainerType.PARTTIME;
        else {
            System.out.println("Invalid option");
            return;
        }

        System.out.println ("Please enter the trainer's specialization:");
        String specializationName = scanner.next();
        Workout specialization = findWorkout(specializationName);
        if (specialization == null) {
            System.out.println("Workout not found");
            return;
        }
        trainers.add(new Trainer(name, surname, type, specialization));
        System.out.println("Trainer added");
    }

    public void showTrainers(){
        for (Trainer x : trainers)
            System.out.println(x.getName() + " " + x.getSurname() + " | " + x.getType() + " | " + x.getSpecialization().getName());
    }

    public void showWorkoutTrainerReport() {

        System.out.println("\n--- Workout-Trainers Report ---\n");

        for (Workout w : availableWorkouts) {
            System.out.println(w.getName() + " (" + w.getIntensity() + ", " + w.getPrice() + " ron)");
            boolean found = false;
            for (Trainer t : trainers)
                if (t.getSpecialization().getName().equalsIgnoreCase(w.getName())) {
                    System.out.println("   -> " + t.getName() + " " + t.getSurname() + " (" + t.getType() + ")");
                    found = true;
            }
            if (!found)
                System.out.println("   -> No trainers available");
            System.out.println();
        }
    }

}

