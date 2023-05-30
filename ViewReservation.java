import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;



public class ViewReservation {


    public ArrayList<Ticket> viewReservation( String info , String type){
        if(type.equals("member")){
           return MemberReadTicket(info);
        }
        return nonMemberReadTicket(info);
        
    }

    public ArrayList<Ticket> MemberReadTicket(String userName) {

        ArrayList<Ticket> reservatedTickets = new ArrayList<Ticket>();
        
            try (// int target = Integer.parseInt(ticketID);
            BufferedReader br = new BufferedReader(new FileReader("ticketList.txt"))) {
                String line;

                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(";");
                    String reservationUserName = parts[1];

                    
                    if (reservationUserName.equals(userName) ) {
                        System.out.println(userName+ "|" +reservationUserName + ";");
                        Ticket ticket = new Ticket(parts[0] , parts[2] , parts[3], parts[4] , parts[5], parts[6] , "10" , parts[8]);
                        reservatedTickets.add(ticket);
                        System.out.println(reservatedTickets.size());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return reservatedTickets;

        
        //     if (!isMatched) {
        //         return "No result";
        //     }
        // } catch (IOException e) {
        //     System.out.println("ERROR: " + e.getMessage());
        //     }
            
    } 

    public ArrayList<Ticket> nonMemberReadTicket(String ticketID) {
        
        ArrayList<Ticket> reservatedTickets = new ArrayList<Ticket>();

        try (BufferedReader br = new BufferedReader(new FileReader("ticketList.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String reservationId = parts[0];

                if (reservationId.equals(ticketID)) {

                    Ticket ticket = new Ticket(parts[0] , parts[2] , parts[3], parts[4] , parts[5], parts[6] , "10" , parts[8]);
                    reservatedTickets.add(ticket);
                    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reservatedTickets;
    } 

    public void deleteTicket(String ticketID) {

       int target = Integer.parseInt(ticketID);

        try {
                BufferedReader reader = new BufferedReader(new FileReader("ticketList.txt"));
                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("ticketList.txt" + ".tmp")));
                
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(";");
                    int lineNumber = Integer.parseInt(parts[0].trim());
                    
                    if (lineNumber != target) {
                        writer.println(line);
                    }
                }
                
                reader.close();
                writer.close();
                
                boolean deleteOriginalFile = new java.io.File("ticketList.txt").delete();
                boolean renameFile = new java.io.File("ticketList.txt" + ".tmp").renameTo(new java.io.File("ticketList.txt"));
                
            } catch (IOException e) {
                System.out.println("ERROR.");
                e.printStackTrace();
            }
        }  
}

 