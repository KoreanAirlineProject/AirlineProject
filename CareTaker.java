import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CareTaker {

    private ArrayList<Memento> mementoList = new ArrayList<Memento>();
    
    public void add(Memento memento){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("mementoList.txt", true))) {
            
            User user = User.getUser();
            writer.write( memento.getSavedTicket().getId() + ";" + user.getName() + ";" + memento.getSavedTicket().getAirplane() + ";" + memento.getSavedTicket().getFromLocation() + ";" + memento.getSavedTicket().getToLocation() + ";" + memento.getSavedTicket().getFromDate() + ";" + memento.getSavedTicket().getToDate() + ";" + memento.getSavedTicket().getCapacity() + ";" + memento.getSavedTicket().getSeat() + "\n");
            writer.flush();

        } catch (IOException e) {
            System.err.println("텍스트 파일 작성 중 오류가 발생했습니다: " + e.getMessage());
        }

        mementoList.add(memento);
    }

    public Memento get(int index){

        int i = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("mementoList.txt"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                String id = values[0];
                String airplane = values[2];
                String fromLocation = values[3];
                String toLocation = values[4];
                String fromDate = values[5];
                String toDate = values[6];
                String capacity = values[7];
                String seat = values[8];
                Ticket ticket = new Ticket(id, airplane, fromLocation, toLocation, fromDate, toDate, capacity, seat);
                if(i == index){
                    return new Memento(ticket);
                }
                i++;
            }
        } catch (IOException e) {
            System.err.println("텍스트 파일 읽기 중 오류가 발생했습니다: " + e.getMessage());
        }
        
        return null;
    }

}
