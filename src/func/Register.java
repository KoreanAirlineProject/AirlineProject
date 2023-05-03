package func;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Register {
    Scanner sc = new Scanner(System.in);
    final String fname = "member.txt";
    String id;
    String password;
    String name;
    String birthday;

    public Register(String ID, String password, String name, String birthday) {
        this.id = ID;
        this.password = password;
        this.name = name;
        this.birthday = birthday;

    }

    public int saveFile() {
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
            return 1;
        }
        return 0;
    }

}
