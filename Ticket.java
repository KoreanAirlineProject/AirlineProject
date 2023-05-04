import java.util.Date;

public class Ticket {
    // private int ticketId;
    // private int gateId;
    // private int formID;
    // private int toID;

    // private String seatRate;

    public Ticket(){
    }

    public Ticket(String airplane, String fromLocation, String toLocation, String fromDate, String toDate, String capacity, String seat){
        this.airplane = airplane;
        this.capacity = capacity;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.seat = seat;
    }



    private String airplane;
    private String capacity;
    private String fromDate;
    private String toDate;
    private String fromLocation;
    private String toLocation;
    private String seat;
    
    
    public String getAirplane(){
        return airplane;
    }
    public void setAirplane(String airplane){
        this.airplane = airplane;
    }

    public String getCapacity(){
        return capacity;
    }
    public void setCapacity(String capacity){
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
public String getSeat(){
    return seat;
}

public void setSeat(String seat){
    this.seat = seat;
}
}
