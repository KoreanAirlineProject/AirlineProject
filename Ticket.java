import java.util.Date;

public class Ticket {
    // private int ticketId;
    // private int gateId;
    // private int formID;
    // private int toID;

    // private String seatRate;

    public Ticket(){
    }

    public Ticket(String airplane, int capacity, String fromDate, String toDate,String fromLocation, String toLocation){
        this.airplane = airplane;
        this.capacity = capacity;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
    }



    private String airplane;
    private int capacity;
    private String fromDate;
    private String toDate;
    private String fromLocation;
    private String toLocation;
    
    
    public String getAirplane(){
        return airplane;
    }
    public void setAirplane(String airplane){
        this.airplane = airplane;
    }

    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public String getFromDate(){
            return fromDate;
    }

    public void setFromDate(String fromDate){
        this.fromDate = fromDate;
    }

    public String getToDate(){
        return toDate;
    }

    public void setToDate(String toDate){
        this.toDate = toDate;
    }

    public String getFromLocation(){
        return fromLocation;
}

public void setFromLocation(String fromLocation){
    this.fromLocation = fromLocation;
}

public String getToLocation(){
    return toLocation;
}

public void setToLocation(String toLocation){
    this.toLocation = toLocation;
}

}
