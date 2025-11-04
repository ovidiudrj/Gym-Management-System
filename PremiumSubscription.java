public class PremiumSubscription extends Subscription{
    @Override
    public double calculatePrice() {
        return price + ( 50 * price ) / 100;
    }

    @Override
    public String getType(){
        return "Premium Subscription";
    }
}
