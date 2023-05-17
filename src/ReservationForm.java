
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ReservationForm extends JFrame implements ActionListener{
    private JTextField kindOfTicketR; // 예약에서 티켓종류 입력을 위한 객체
    private JTextField departureR; // 예약에서 출발지 입력을 위한 객체
    private JTextField arrivalR; // 예약에서 도착지 입력을 위한 객체
    private JTextField departureDateR; // 예약에서 탑승일 입력을 위한 객체
    private JTextField arrivalDateR; // 예약에서 오는 날 입력을 위한 객체
    private JTextField number; // 인원 수 입력을 위한 객체
    private JTextField grade; // 좌석 등급 입력을 위한 객체
    private JPanel deckPanel;
    private CardLayout dealer;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;


    public ReservationForm() {
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

    public JPanel setReservationForm() {
        JPanel reservation = new JPanel( );
        reservation.setLayout(new GridLayout(0, 1, 10, 10));
        reservation.setBackground(Color.LIGHT_GRAY);
        JLabel reLabel = new JLabel("Reservation");
        reservation.add(reLabel);

        kindOfTicketR = new JTextField("티켓 종류를 입력하세요 (1.왕복 2.편도 3.다구간)", 30);
        reservation.add(kindOfTicketR);
        departureR = new JTextField("출발지를 입력하세요", 10);
        reservation.add(departureR);
        arrivalR = new JTextField("도착지를 입력하세요", 10);
        reservation.add(arrivalR);
        departureDateR = new JTextField("탑승일을 입력하세요 (ex.1999/7/6)", 10);
        reservation.add(departureDateR);
        arrivalDateR = new JTextField("오는 날을 입력하세요 (ex.1999/7/6)", 10);
        reservation.add(arrivalDateR);
        number = new JTextField("탑승객 인원 수를 숫자로만 입력하세요", 10);
        reservation.add(number);
        grade = new JTextField("좌석 등급을 입력하세요 (1.일반석 2.프레스티지석 3.일등석)", 10);
        reservation.add(grade);
        return reservation;
    }

    public void actionPerformed(ActionEvent e) {
        Reservation reservation = new Reservation();
        reservation.setReservation(Integer.parseInt(kindOfTicketR.getText()), departureR.getText(), arrivalR.getText(), departureDateR.getText(), arrivalDateR.getText(), Integer.parseInt(number.getText()), grade.getText());
        reservation.checkTicket();
    }




}

