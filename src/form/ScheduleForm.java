package form;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import func.FlightSearch;

public class ScheduleForm extends JFrame implements ActionListener{
    private String [] scheduleInfo = new String[5]; // 항공편 현황 정보
    private JTextField kindOfTicketS; // 현황에서 티켓종류 입력을 위한 객체
    private JTextField departureS; // 현황조회에서 출발지 입력을 위한 객체

    private JTextField arrivalS; // 현황 파악에서 도착지 입력을 위한 객체
    private JTextField startDate;
    private JTextField endDate;
    private JPanel deckPanel;
    private CardLayout dealer;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;


    public ScheduleForm() {
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

    public JPanel setScheduleForm() {
        JPanel schedule = new JPanel( );
        schedule.setLayout(new GridLayout(0, 1, 10, 10));
        schedule.setBackground(Color.LIGHT_GRAY);
        JLabel shcheLabel = new JLabel("Flight Schedule");
        schedule.add(shcheLabel);
        kindOfTicketS = new JTextField("티켓 종류를 입력하세요 (1.왕복 2.편도 3.다구간)", 30);
        schedule.add(kindOfTicketS);

        startDate = new JTextField("출발 일자를 입력하세요 (ex: 1999-05-02 15:30 ) ", 20);
        schedule.add(startDate);
        endDate = new JTextField("도착 일자를 입력하세요 (ex: 1999-05-02 15:30 )" , 20);
        schedule.add(endDate);

        departureS = new JTextField("출발지를 입력하세요", 10);
        schedule.add(departureS);
        arrivalS = new JTextField("도착지를 입력하세요", 10);
        schedule.add(arrivalS);
        return schedule;
    }

    public void actionPerformed(ActionEvent e) {
        scheduleInfo[0] = kindOfTicketS.getText();
        scheduleInfo[1] = departureS.getText();
        scheduleInfo[2] = arrivalS.getText();
        scheduleInfo[3] = startDate.getText();
        scheduleInfo[4] = endDate.getText();
        FlightSearch flightSearch = new FlightSearch();
        flightSearch.searchSchedule(scheduleInfo[1], scheduleInfo[2], scheduleInfo[3], scheduleInfo[4]);

    }



}

