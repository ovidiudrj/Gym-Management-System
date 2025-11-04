public class Registration {
    private Client client;
    private Subscription subscription;

    public Registration(Client client, Subscription subscription){
        this.client = client;
        this.subscription = subscription;
    }

    public Client getClient(){ return client; }
    public Subscription getSubscription(){ return subscription; }
}
