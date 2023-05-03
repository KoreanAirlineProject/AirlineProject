package func.user;

public class User {
    private boolean isMember;
    private String id;
    private String password;
    private String name;
    private String gender;
    private String phone;
    private String birthDate;
    private int mileage;

    public User() {

    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void login(User user) {  }

    public void logout(User user) { }
    public void verification(User user) {  }

    public void register(User user) {  }

    public void makeReservation(User user) {  }
    public void viewReservation(User user) { }
    public void viewFlightSchedule(User user) {  }
    public void withdrawal(User user) { }

    public void checkin(User user) {  }


}

