import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class CheckIn {
    public CheckIn(String[] CheckInInfo){
        this.ticketID = CheckInInfo[0];
        this.departureDate = CheckInInfo[1];
        this.name = CheckInInfo[2];
    }
    String ticketID, departureDate, name;
    
    public void searchCheckInInfo(){
        User user = User.getUser();
        try (BufferedReader br = new BufferedReader(new FileReader("ticketList.txt"))) {
            int target = Integer.parseInt(ticketID);
            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(";");

                int reservationNum = Integer.parseInt(parts[0]);
                if (!user.getIsLogined() && reservationNum == target && name.equals(parts[1]) && departureDate.equals(parts[5])) {
                    selectFlightSeat();
                    break;
                }
                if(user.getIsLogined() && user.getName().equals(parts[1])){
                    System.out.println(line);
                }

            }

        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
     
    }
    public void selectFlightSeat(){
        Flight flight = new Flight(5, 5);
        String message = "이용 가능한 좌석:\n";
        for(int i = 0; i < flight.getSeats().length; i++) {
            for(int j = 0; j < flight.getSeats()[i].length; j++) {
                if(flight.getSeats()[i][j] == 0) {
                    message += "(" + i + ", " + j + ")\n";
                }
            }
        }
        String input = JOptionPane.showInputDialog(null, message + "좌석을 선택하세요 (행, 열):");

        // 좌석예약
        if(input == null){
            JOptionPane.showMessageDialog(null, "체크인을 취소하였습니다.");
            return;
        }
        String[] seatCoordinates = input.split(",");
        if(seatCoordinates.length != 2){
            JOptionPane.showMessageDialog(null, "좌석을 선택하지 않았습니다.");
            return;
        }
        int row = Integer.parseInt(seatCoordinates[0].trim());
        int column = Integer.parseInt(seatCoordinates[1].trim());
        if(row < 0 || row >= flight.getSeats().length || column < 0 || column >= flight.getSeats()[0].length) {
            JOptionPane.showMessageDialog(null, "잘못된 좌석을 선택하셨습니다.");
            return;
        }
        if(flight.getSeats()[row][column] != 0) {
            flight.setSeat(row, column); // 좌석을 예약 처리
            JOptionPane.showMessageDialog(null, "선택하신 좌석이 예약되었습니다.");
        }
        else {
            JOptionPane.showMessageDialog(null, "이미 예약된 좌석입니다.");
        }
    }
    public void publischOnlineTicket(){

    }
}