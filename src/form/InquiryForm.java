package form;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import func.Register;


public class InquiryForm extends JFrame implements ActionListener{
    private String [] veiwInfo = new String[3]; //예약조회 정보
    private JTextField ticketnum; // 티켓 번호 입력을 위한 객체
    private JTextField departureDateI; // 조회에서 탑승일 입력을 위한 객체
    private JTextField name; // 승객이름 입력을 위한 객체
    private JPanel deckPanel;
    private CardLayout dealer;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;


    public InquiryForm() {
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

    public JPanel setInquiryForm() {
        JPanel inquiry = new JPanel( );
        inquiry.setLayout(new GridLayout(0, 1, 10, 10));
        inquiry.setBackground(Color.LIGHT_GRAY);
        JLabel inLabel = new JLabel("Inquiry");
        inquiry.add(inLabel);
        ticketnum = new JTextField("예약 번호를 입력하세요", 10);
        inquiry.add(ticketnum);
        departureDateI = new JTextField("탑승일을 입력하세요 (ex.1999/7/6)", 10);
        inquiry.add(departureDateI);
        name = new JTextField("승객의 이름을 입력하세요", 10);
        inquiry.add(name);
        return inquiry;
    }

    public void actionPerformed(ActionEvent e) {
        veiwInfo[0] = ticketnum.getText();
        veiwInfo[1] = departureDateI.getText();
        veiwInfo[2] = name.getText();


    }



}

