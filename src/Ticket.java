import java.util.Date;

public class Ticket {
    private int ticketId;
    private int gateId;
    private Date departureDate;
    private Date arrivalDate;
    private int formID;
    private int toID;
    private String seatRate;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }


    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }


    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }


    public int getFormID() {
        return formID;
    }

    public void setFormID(int formID) {
        this.formID = formID;
    }


    public int getToID() {
        return toID;
    }

    public void setToID(int toID) {
        this.toID = toID;
    }


    public String getSeatRate() {
        return seatRate;
    }

    public void setSeatRate(String seatRate) {
        this.seatRate = seatRate;
    }


}
