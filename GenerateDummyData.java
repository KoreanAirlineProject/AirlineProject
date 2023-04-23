import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

public class GenerateDummyData {
    public static void main(String[] args) {
        String[] airports = {"LAX", "JFK", "ICN", "HND", "PEK", "LHR", "CDG", "AMS", "FRA", "MUC"};
        LocalDate startDate = LocalDate.of(2023, 5, 1);
        LocalDate endDate = LocalDate.of(2023, 5, 31);

        try (FileWriter writer = new FileWriter("./FlightSchedule.txt")) {
            Random random = new Random();
            for (int i = 0; i < 20; i++) {
                String departureAirport = airports[random.nextInt(airports.length)];
                String arrivalAirport;
                do {
                    arrivalAirport = airports[random.nextInt(airports.length)];
                } while (departureAirport.equals(arrivalAirport));

                LocalDate departureDate = startDate.plusDays(random.nextInt((int) endDate.toEpochDay() - (int) startDate.toEpochDay()));
                LocalDate arrivalDate = departureDate.plusDays(random.nextInt((int) endDate.toEpochDay() - (int) departureDate.toEpochDay()));

                writer.write(departureDate + " " + arrivalDate + " " + departureAirport + " " + arrivalAirport + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
