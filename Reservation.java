import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Reservation {
    private final PaymentStrategy paymentStrategy;

    Reservation(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public String payment(Ticket ticket){
        saveTicket(ticket);
        return paymentStrategy.payment();
    }

    public void saveTicket(Ticket ticket){
        
        User user = User.getUser();

        String reservationNum = Integer.toString((int)(Math.random()*100));

        try{
			BufferedWriter bw = new BufferedWriter(new FileWriter("ticketList.txt", true));
            PrintWriter pw = new PrintWriter(bw, true);
            
            pw.write(reservationNum + ";" + user.getName() + ";" + ticket.getAirplane() + ";" + ticket.getFromLocation() + ";" + ticket.getToLocation() + ";" + ticket.getFromDate() + ";" +ticket.getToDate() + ";" + ticket.getCapacity() + ";" + ticket.getSeat() + "\n");

            pw.flush();
            pw.close();
            
            System.out.println("==> 데이터 저장 완료!!!\n");
        } catch (IOException e) {
            e.printStackTrace();
        
        }
        
    }

}
