package func;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FlightSearch {
    public void searchSchedule(String searchFrom, String searchTo , String searchDepartureDate, String searchArrivalDate) {
        String filePath = "FlightSchedule.txt";
        ArrayList<FlightSearchRequest> requests = readRequestsFromFile(filePath);

        // 비행 스케줄 검색
        StringBuilder result = new StringBuilder();
        for (FlightSearchRequest request : requests) {
            if (request.getDepartureDate().equals(searchDepartureDate) &&
                request.getArrivalDate().equals(searchArrivalDate) &&
                request.getFrom().equals(searchFrom) &&
                request.getTo().equals(searchTo)) {
                result.append(request).append("\n"); // 검색 결과 저장
            }
        }

        // 검색 결과 메시지 박스로 출력
        if (result.length() > 0) {
            JOptionPane.showMessageDialog(null, result.toString(), "Flight Search Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No flights found for the specified search criteria.", "Flight Search Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // 파일에서 FlightSearchRequest 객체를 읽어와 ArrayList로 반환하는 메소드
    private static ArrayList<FlightSearchRequest> readRequestsFromFile(String filePath) {
        ArrayList<FlightSearchRequest> requests = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");
                FlightSearchRequest request = new FlightSearchRequest(tokens[0], tokens[1], tokens[2], tokens[3]);
                requests.add(request);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return requests;
    }
}

// FlightSearchRequest 클래스 정의
class FlightSearchRequest {
    private String departureDate;
    private String ArrivalDate;
    private String from;
    private String to;

    public FlightSearchRequest(String departureDate, String ArrivalDate, String from, String to) {
        this.departureDate = departureDate;
        this.ArrivalDate = ArrivalDate;
        this.from = from;
        this.to = to;
    }

    public String getDepartureDate() {
        return departureDate;
    }
    public String getArrivalDate() {
        return ArrivalDate;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return departureDate + " - " + ArrivalDate  + " " + from + " " + to;
    }
}
