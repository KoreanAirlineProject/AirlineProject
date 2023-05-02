package form;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import func.*;

public class ManagerForm extends JFrame implements ActionListener{
    private String [] scheduleInfo = new String[5]; // 항공편 현황 정보
    private JTextField startLocation;
    private JTextField endLocation;
    private JTextField startDate;
    private JTextField endDate;
    private JTextField capacity;
    private JTextField FlightName;
    private JPanel deckPanel;
    private JButton flightAdditionButton;
    private CardLayout dealer;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;


    public ManagerForm() {
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Ticketing system");
        Container contentPane = getContentPane( );
        contentPane.setLayout(new BorderLayout());

        deckPanel = new JPanel( );
        dealer = new CardLayout( );
        deckPanel.setLayout(dealer);
    }

    public JPanel setManagerForm() {
        JPanel manager = new JPanel();
        manager.setLayout(new GridLayout(0, 1, 10, 10));
        manager.setBackground(Color.LIGHT_GRAY);
        JLabel managerLabel = new JLabel("Manager Page");
        FlightName = new JTextField("비행기 정보를 입력하세요", 20);
        capacity = new JTextField("인원을 입력하세요" , 5);
        startDate = new JTextField("출발 일자를 입력하세요 (ex: 1999-05-02 15:30 ) ", 20);
        endDate = new JTextField("도착 일자를 입력하세요 (ex: 1999-05-02 15:30 )" , 20);
        startLocation = new JTextField("출발지를 입력하세요" , 20);
        endLocation = new JTextField("도착지를 입력하세요" , 20);

        manager.add(managerLabel);
        manager.add(FlightName);
        manager.add(capacity);
        manager.add(startDate);
        manager.add(endDate);
        manager.add(startLocation);
        manager.add(endLocation);

        flightAdditionButton = new JButton("비행 정보 제출");
        flightAdditionButton.addActionListener(this);
        manager.add(flightAdditionButton);
        return manager;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() ==flightAdditionButton){
            createFlight(FlightName.getText() , capacity.getText() , startDate.getText() , endDate.getText() , startLocation.getText() , endLocation.getText() );

        }


    }

    public void createFlight(String FlightName, String capacity ,String startDate ,String endDate , String startLocation ,String endLocation){

        String newData = FlightName + ";" + capacity + ";" + startDate + ";" + endDate + ";" + startLocation + ";" + endLocation + "\n";

        try {
            // 1. 파일 객체 생성
            File file = new File("writeFile.txt");
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



}

