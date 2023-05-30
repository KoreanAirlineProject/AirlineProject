public class Memento {
    private Ticket savedTicket;

    public Memento(Ticket ticketToSave){
        this.savedTicket = ticketToSave;
    }

    public Ticket getSavedTicket(){
        return this.savedTicket;
    }
}
