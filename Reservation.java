public class Reservation {
    private final PaymentStrategy paymentStrategy;

    Reservation(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public String payment(){
        return paymentStrategy.payment();
    }   
}
