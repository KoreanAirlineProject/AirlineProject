import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Airline {


    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void notification() {

    }

    public ArrayList<Ticket> showFlights(String fname) throws NumberFormatException, IOException{
        
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();

        BufferedReader br;
        
            br = new BufferedReader(new FileReader(fname));
            String line;
        

            
                while((line = br.readLine()) != null) {
                    // line = br.readLine();
   
                    // if(line == null) break;
                    String data[] = line.split(";");
                    // System.out.println(data[0] + data[1]+ data[2] + data[3]+ data[4]);
                    Ticket ticket = new Ticket(data[0],data[1] , data[2],data[3],data[4],data[5],data[6]);
                    
                    tickets.add(ticket);
                }
                
                br.close();

            
        return tickets;
		
    }

}
