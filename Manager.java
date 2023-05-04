
import javax.swing.*;

import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class Manager extends JFrame implements ActionListener{

    public Manager() {
       
    }


    public void createFlight(String FlightName, String fromLocation , String toLocation ,String fromDate ,String toDate , String capacity ,String grade){

        String newData = FlightName + ";" + fromLocation + ";" + toLocation + ";" + fromDate + ";" + toDate + ";" + capacity + ";" + grade+ "\n";

        try {
            // 1. 파일 객체 생성
            File file = new File("./writeFile.txt");
            // 2. 파일 존재여부 체크 및 생성
            if (!file.exists()){
                file.createNewFile();
            }

            // 3. Buffer를 사용해서 File에 write할 수 있는 BufferedWriter 생성
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter writer = new BufferedWriter(fw);
            // 4. 파일에 쓰기
            writer.write(newData);
            // 5. BufferedWriter close
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, "비행 정보가 추가되었습니다.");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }



}

