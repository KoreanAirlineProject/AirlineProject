import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class User {

    private static User user = null;

    private User(){
        
    }

    public void setUser(String id, String password , String name , String birthDate) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.birthDate = birthDate;
    }

    public static User getUser(){
        if(user == null){
            user = new User();
        }
        return user;
    }

    // private String gender;
    // private String phone;
    
    private boolean isLogined = false;
    private String id;
    private String password;
    private String name;
    private String birthDate;
    private int mileage = 0;

    

    public void setIsLogined(boolean isLogined) {
        this.isLogined = isLogined;
    }

    public boolean getIsLogined(){
        return isLogined;
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

    public boolean login(String fname , String inputID , String inputPW) {
        
        // User user = User.getUser();

		boolean isSuccessed = false;
		String username = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fname));
			String line;
			
			while((line = br.readLine()) != null) {
				// line = br.readLine();

				// if(line == null) break;
				String data[] = line.split("\\|");
				String tempId = data[0];
				String tempPw = data[1];
                // System.out.println(user.getId());
                // System.out.println(user.getPassword());
				// System.out.println("tempID: " + tempId + "tempPw: " + tempPw);
				if(tempId.compareTo(inputID) == 0 && tempPw.compareTo(inputPW)==0) {
					isSuccessed = true;
                    // username = data[2];
					System.out.println("로그인 성공");
                    System.out.println(data[2]);
                    setName(data[2]);
                    setIsLogined(true);
					break;
				}
			}
			br.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}

        return isSuccessed;
		
	}

    public void logout(User user) { }
    public void verification(User user) {  }

    public boolean register(String id , String password , String name , String birthday , String fname) { 
        System.out.println("id: " + id + " pw:  " + password + " name: " + name + " birthday: " + birthday);
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(fname, true));
            PrintWriter pw = new PrintWriter(bw, true);
            
            pw.write(id + "|" + password + "|" + name + "|" + birthday + "\n");

            pw.flush();
            pw.close();
            
            System.out.println("==> 데이터 저장 완료!!!\n");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
		return true;
        
    }

    public void makeReservation(User user) { 
    }
    public void viewReservation(User user) { }
    public void viewFlightSchedule(User user) {  }
    public void withdrawal(User user) { }

    public void checkin(User user) {  }


};

