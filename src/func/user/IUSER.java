package func.user;
interface IUSER {
    public void login(User user);
    public void logout(User user);
    public void verification(User user);
    public void register(User user);
    public void makeReservation(User user);
    public void viewReservation(User user);
    public void viewFlightSchedule(User user);
    public void withdrawal(User user);
    public void checkin(User user);
}
