import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {
	Scanner sc = new Scanner(System.in);
	final String fname = "member.txt";
	String id;
	String pw;
	
	Login(String ID, String password) {
		this.id = ID;
		this.pw = password;
		
	}
	
	public String loadFile() {
        System.out.println("id :" + id + "pw " + pw);
		boolean isValid = false;
		String username = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fname));
			String line;
			
			while(true) {
				line = br.readLine();
				if(line == null) break;
				String data[] = line.split("\\|");
				String tempId = data[0];
				String tempPw = data[1];
				System.out.println("tempID: " + tempId + "tempPw: " + tempPw);
				if(tempId.compareTo(id) == 0 && tempPw.compareTo(pw)==0) {
					isValid = true;
					username = data[2];
					System.out.println("로그인 성공");
					break;
				}
			}
			br.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		if(isValid) return username;
		else return "";
	}

}
