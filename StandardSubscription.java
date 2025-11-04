public class StandardSubscription extends Subscription{
    @Override
    public double calculatePrice() {
        return price;
    }

    @Override
    public String getType() {
        return "Standard Subscription";
    }
}
