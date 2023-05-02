package form;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckInForm extends JFrame implements ActionListener{

    private String [] checkInInfo = new String[3]; //체크인 정보
    private JTextField ticketnum; // 티켓 번호 입력을 위한 객체
    private JTextField departureDateC; // 체크인에서 탑승일 입력을 위한 객체
    private JTextField name; // 승객이름 입력을 위한 객체
    private JPanel deckPanel;
    private CardLayout dealer;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;


    public CheckInForm() {
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

    public JPanel setCheckInForm() {
        JPanel checkin = new JPanel( );
        checkin.setLayout(new GridLayout(0, 1, 10, 10));
        checkin.setBackground(Color.LIGHT_GRAY);
        JLabel checkLabel = new JLabel("Check-in");
        checkin.add(checkLabel);
        ticketnum = new JTextField("예약 번호를 입력하세요", 10);
        checkin.add(ticketnum);
        departureDateC = new JTextField("탑승일을 입력하세요 (ex.1999/7/6)", 10);
        checkin.add(departureDateC);
        name = new JTextField("승객의 이름을 입력하세요", 10);
        checkin.add(name);
        return checkin;
    }

    public void actionPerformed(ActionEvent e) {
        checkInInfo[0] = ticketnum.getText();
        checkInInfo[1] = departureDateC.getText();
        checkInInfo[2] = name.getText();


    }



}

