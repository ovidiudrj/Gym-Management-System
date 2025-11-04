public abstract class Subscription {
    protected static double price = 200;

    public static void modifyPrice(double price){
        Subscription.price = price;
    }
    public abstract double calculatePrice();
    public abstract String getType();
}
