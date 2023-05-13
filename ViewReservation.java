import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class ViewReservation {

    public ViewReservation(){
    
    }

    public String readTicket(String ticketID) {

        try (BufferedReader br = new BufferedReader(new FileReader("ticketList.txt"))) {
            int target = Integer.parseInt(ticketID);
            String line;
            boolean isMatched = false;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int reservationNum = Integer.parseInt(parts[0]);

                if (reservationNum == target) {
                    isMatched = true;
                    StringBuilder result = new StringBuilder();
                    result.append("예약번호: ").append(parts[0]).append(" || ");
                    result.append("항공기정보: ").append(parts[2]).append(" || ");
                    result.append("출발지: ").append(parts[3]).append(" / 도착지: ").append(parts[4]).append(" || ");
                    result.append("출발일자: ").append(parts[5]).append(" / 도착일자: ").append(parts[6]).append(" || ");
                    result.append("클래스: ").append(parts[8].replace("/", "")).append("\n");

                    return result.toString();
                }
            
            }

            if (!isMatched) {
                return "No result";
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
            }

            return null;
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

 