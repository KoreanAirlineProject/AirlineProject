import java.util.Date;

public class Reservation {
    private int flightID;
    private Date departureDate;
    private Date arrivalDate;
    private int fromID;
    private int toID;
    private String seatRate;
    private boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getSeatRate() {
        return seatRate;
    }

    public void setSeatRate(String seatRate) {
        this.seatRate = seatRate;
    }

    public int getToID() {
        return toID;
    }

    public void setToID(int toID) {
        this.toID = toID;
    }


    public int getFromID() {
        return fromID;
    }

    public void setFromID(int fromID) {
        this.fromID = fromID;
    }


    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }


    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public void cancel() {

    }

    public void changeSeat() {

    }

    public void selectSeat() {

    }

    public void earningMileage() {

    }
    public class Payment {
        private int creditCard;
        private String userName;
        public int getCreditCard() {
            return creditCard;
        }

        public void setCreditCard(int creditCard) {
            this.creditCard = creditCard;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void makePayment() {

        }

        public void makeMileagePayment() {

        }


    }

}
