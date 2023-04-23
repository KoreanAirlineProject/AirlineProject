
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Main extends JFrame implements ActionListener
{
	public static final int WIDTH = 600;
	public static final int HEIGHT = 500;
	
	private String [] reservationInfo = new String[7]; // 항공권예매 정보
	private String [] veiwInfo = new String[3]; //예약조회 정보
	private String [] checkInInfo = new String[3]; //체크인 정보 
	private String [] scheduleInfo = new String[3]; // 항공편 현황 정보
	private Boolean isLogined = false; // 로그인 유무
	
	
	private CardLayout dealer;
	private JPanel deckPanel;
	
	private JTextField kindOfTicketR; // 예약에서 티켓종류 입력을 위한 객체
	private JTextField kindOfTicketS; // 현황에서 티켓종류 입력을 위한 객체
	private JTextField departureR; // 예약에서 출발지 입력을 위한 객체
	private JTextField departureS; // 현황조회에서 출발지 입력을 위한 객체
	private JTextField arrivalR; // 예약에서 도착지 입력을 위한 객체
	private JTextField arrivalS; // 현황 파악에서 도착지 입력을 위한 객체
	private JTextField departureDateR; // 예약에서 탑승일 입력을 위한 객체 
	private JTextField arrivalDateR; // 예약에서 오는 날 입력을 위한 객체 
	private JTextField departureDateI; // 조회에서 탑승일 입력을 위한 객체
	private JTextField departureDateC; // 체크인에서 탑승일 입력을 위한 객체
	private JTextField departureDateS; // 현황조회에서 탑승일 입력을 위한 객체 
	private JTextField number; // 인원 수 입력을 위한 객체
	private JTextField grade; // 좌석 등급 입력을 위한 객체
	private JTextField ID; // ID 입력을 위한 객체
	private JTextField ticketnum; // 티켓 번호 입력을 위한 객체
	private JTextField name; // 승객이름 입력을 위한 객체
	private JTextField password; // password 입력을 위한 객체
	private JTextField regName;
	private JTextField regID;
	private JTextField regPW;
	private JTextField birthday;
	private String username = "";

	
	
	
	public Main( )
	{
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Ticketing system");
		Container contentPane = getContentPane( );
		contentPane.setLayout(new BorderLayout());
	
		deckPanel = new JPanel( );
		dealer = new CardLayout( );
		deckPanel.setLayout(dealer);
	
		// 로그인 화면 시작
		JPanel main = new JPanel( );
		main.setLayout(new GridLayout(0, 1, 10, 10));
		main.setBackground(Color.LIGHT_GRAY);
		JLabel maintLabel = new JLabel("Main");
		main.add(maintLabel);
		ID = new JTextField("아이디를 입력하세요", 30);
		main.add(ID);
		password = new JTextField("비밀번호를 입력하세요", 30);
		main.add(password);
		Dimension btnSize = new Dimension(30 ,25);
		JButton RegisterButton = new JButton("Register");
		RegisterButton.setPreferredSize(new Dimension(20,20));
		RegisterButton.addActionListener(this);
		main.add(RegisterButton);
		deckPanel.add("main", main);
		
		//로그인 화면 종료
		
		// 회원가입 화면 시작 
		
		JPanel register = new JPanel();
		register.setLayout(new GridLayout(0, 1, 10, 10));
		register.setBackground(Color.LIGHT_GRAY);
		JLabel regLabel = new JLabel("회원가입");
		register.add(regLabel);
		
		regName = new JTextField("이름", 30);
		register.add(regName);	
		regID = new JTextField("ID", 30);
		register.add(regID);	
		regPW = new JTextField("PW", 30);
		register.add(regPW);	
		birthday = new JTextField("birthday", 30);
		register.add(birthday);
		JButton registerButton = new JButton("register");
		registerButton.setPreferredSize(btnSize);
		registerButton.addActionListener(this);
		register.add(registerButton);
		deckPanel.add("register", register);
		
		// 회원가입 화면 종료 
		
		// 로그인 성공 후 메인화면 시작
		
		
		
		// 로그인 성공 후 메인화면 종료 
	
	
		//예약화면 시작
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
			deckPanel.add("reservation", reservation);
		// 예약화면 종료
			
		// 조회 화면 시작
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
			deckPanel.add("inquiry", inquiry);
		// 조회화면 종료
			
		// 체크인 화면 시작
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
			deckPanel.add("checkin", checkin);
		// 체크인 화면 종료
			
		// 현황 조회 화면 시작	
		JPanel schedule = new JPanel( );
		schedule.setLayout(new GridLayout(0, 1, 10, 10));
		schedule.setBackground(Color.LIGHT_GRAY);
		JLabel shcheLabel = new JLabel("Flight Schedule");
		schedule.add(shcheLabel);
		kindOfTicketS = new JTextField("티켓 종류를 입력하세요 (1.왕복 2.편도 3.다구간)", 30);
		schedule.add(kindOfTicketS);
		departureS = new JTextField("출발지를 입력하세요", 10);
		schedule.add(departureS);
		arrivalS = new JTextField("도착지를 입력하세요", 10);
		schedule.add(arrivalS);
			deckPanel.add("schedule", schedule);
			contentPane.add(deckPanel, BorderLayout.CENTER);
		// 현황 조회 화면 종료
		
		// 버튼 판넬 1 시작
		JPanel buttonPanel1 = new JPanel( );
		buttonPanel1.setBackground(Color.BLACK);
		buttonPanel1.setLayout(new FlowLayout( ));
		
		JButton mainButton = new JButton("Main");
		mainButton.addActionListener(this);
		buttonPanel1.add(mainButton);
		
		JButton reserButton = new JButton("Reservation");
		reserButton.addActionListener(this);
		buttonPanel1.add(reserButton);
		
		JButton inquiryButton = new JButton("Inquiry");
		inquiryButton.addActionListener(this);
		buttonPanel1.add(inquiryButton);
		
		JButton checkButton = new JButton("checkIn");
		checkButton.addActionListener(this);
		buttonPanel1.add(checkButton);
		
		JButton scheduleButton = new JButton("Schedule");
		scheduleButton.addActionListener(this);
		buttonPanel1.add(scheduleButton);
		// 버튼 판넬 1 종료
		
		// 버튼 판넬 2 시작
		JPanel buttonPanel2 = new JPanel( );
		buttonPanel2.setBackground(Color.BLACK);
		buttonPanel2.setLayout(new FlowLayout( ));
		
		JButton mainConfirm = new JButton("MainC");
		mainConfirm.addActionListener(this);
		buttonPanel2.add(mainConfirm);
		
		JButton reserConfirm = new JButton("ReservationC");
		reserConfirm.addActionListener(this);
		buttonPanel2.add(reserConfirm);
		
		JButton inquiryConfirm = new JButton("InquiryC");
		inquiryConfirm.addActionListener(this);
		buttonPanel2.add(inquiryConfirm);
		
		JButton checkConfirm = new JButton("checkInC");
		checkConfirm.addActionListener(this);
		buttonPanel2.add(checkConfirm);
		
		JButton scheduleConfirm = new JButton("ScheduleC");
		scheduleConfirm.addActionListener(this);
		buttonPanel2.add(scheduleConfirm);
		// 버튼 판넬 2 종료
			contentPane.add(buttonPanel1, BorderLayout.NORTH);
			contentPane.add(buttonPanel2, BorderLayout.SOUTH);
				dealer.first(deckPanel);
		}
	
	// 버튼 눌렸을 떄 처리
	public void actionPerformed(ActionEvent e)
	{
		String actionCommand = e.getActionCommand( );
		
		if (actionCommand.equals("Main")) dealer.show(deckPanel, "main"); // 화면전환
		else if (actionCommand.equals("Reservation")) dealer.show(deckPanel, "reservation"); //화면전환
		else if (actionCommand.equals("Inquiry")) dealer.show(deckPanel, "inquiry"); //화면전환
		else if (actionCommand.equals("checkIn")) dealer.show(deckPanel, "checkin"); // 화면전환
		else if (actionCommand.equals("Schedule")) dealer.show(deckPanel, "schedule"); //화면전환
		else if (actionCommand.equals("Register")) {
			dealer.show(deckPanel, "register");
		}
		
		else if(actionCommand.equals("register")) {
			Register register = new Register(regID.getText(), regPW.getText(),regName.getText(), birthday.getText());
			if(register.saveFile() == 0) {
				JOptionPane.showMessageDialog(null, "회원가입에 성공하셨습니다");
				dealer.show(deckPanel, "main");
			}
			else {
				JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다");	
			}
			
		}
		
		else if (actionCommand.equals("MainC")) //로그인 버튼 클릭시에 로그인 true로 변경
		{
			System.out.println("preseed");
			Login login = new Login(ID.getText(), password.getText());
			username = login.loadFile();
			System.out.println("==>" + username);
			if(username != "") {
				isLogined = true; 
				JOptionPane.showMessageDialog(null, "로그인에 성공하셨습니다");
				JPanel loginSuccess = new JPanel();
				loginSuccess.setLayout(new GridLayout(0, 1, 10, 10));
				loginSuccess.setBackground(Color.LIGHT_GRAY);
				JLabel mainLabel = new JLabel("Korean Air Home Page");
				loginSuccess.add(mainLabel);
				System.out.println("-->" + username);
				JLabel welcomeLabel = new JLabel("안녕하세요 " + username + "님" );
				loginSuccess.add(welcomeLabel);
				
				JButton LogoutButton = new JButton("Logout");
				LogoutButton.setPreferredSize(new Dimension(20,20));
				LogoutButton.addActionListener(this);
				loginSuccess.add(LogoutButton);
				
				deckPanel.add("loginSuccess", loginSuccess);
				dealer.show(deckPanel, "loginSuccess"); 
			}
			else {
				JOptionPane.showMessageDialog(null, "일치하는 정보가 없습니다");	
			}
			
		}
		else if (actionCommand.equals("ReservationC")) // 예약확인 버튼 클릭시에 입력 받은 정보 배열에 저장
		{
			reservationInfo[0] = kindOfTicketR.getText();
			reservationInfo[1] = departureR.getText();
			reservationInfo[2] = arrivalR.getText();
			reservationInfo[3] = departureDateR.getText();
			reservationInfo[4] = arrivalDateR.getText();
			reservationInfo[5] = number.getText();
			reservationInfo[6] = grade.getText();
		}
		else if (actionCommand.equals("InquiryC")) // 예약 조회 확인 버튼 클릭시에  입력 받은 정보 배열에 저장
		{
			veiwInfo[0] = ticketnum.getText();
			veiwInfo[1] = departureDateR.getText();
			veiwInfo[2] = name.getText();
		}
		else if (actionCommand.equals("checkInC")) // 체크인확인 버튼 클릭시에 입력 받은 정보 배열에 저장
		{
			checkInInfo[0] = ticketnum.getText();
			checkInInfo[1] = departureDateC.getText();
			checkInInfo[2] = name.getText();
		}
		else if (actionCommand.equals("ScheduleC")) //현황 조회 확인 버튼 클릭시에 입력 받은 정보 배열에 저장
		{
			scheduleInfo[0] = kindOfTicketS.getText();
			scheduleInfo[1] = departureS.getText();
			scheduleInfo[2] = arrivalS.getText();
		}
		else if (actionCommand.equals("Logout")) {
			dealer.show(deckPanel, "main");
		}
	
			System.out.println("Error in CardLayout Demo.");
	}

	public static void main(String[] args)
	{
		Main demoGui = new Main( ); demoGui.setVisible(true);
	}

}

	



/*
public class Main {
	
	public static void main(String arg[]) {
	
		
	private String [] reservationInfo = new String[6]; // 항공권예매 정보
	private String [] veiwInfo = new String[3]; //예약조회 정보
	private String [] checkInInfo = new String[3]; //체크인 정보 
	private String [] scheduleInfo = new String[3]; // 항공편 현황 정보
	
	
	int answer = 0; // 유저의 답변을 위한 변수
	Boolean isLogined;
	
	
	
	System.out.println("로그인 하시겠습니니까? (1.예 2.아니오): ");
	Scanner keyboard = new Scanner(System.in);
	answer = keyboard.nextInt();
	isLogined = isLogined(answer);
	
	System.out.println("메뉴를 고르세요: 1.항공권 예매 2.예약 조회 3.체크인 4.항공편 현황" );
	answer = keyboard.nextInt();
	
	if(answer == 1) // 항공권 예매
	{
		System.out.println("티켓 종류를 입력하세요 (1.왕복 2.편도 3.다구간): ");
		reservationInfo[0] =  keyboard.next();
		System.out.println("출발지를 입력하세요: ");
		reservationInfo[1] =  keyboard.next();
		System.out.println("도착지를 입력하세요: ");
		reservationInfo[2] =  keyboard.next();
		System.out.println("탑승일을 입력하세요 (ex.1999/7/6): ");
		reservationInfo[3] =  keyboard.next();
		System.out.println("탑승객 인원 수를 숫자로만 입력하세요: ");
		reservationInfo[4] =  keyboard.next();
		System.out.println("좌석 등급을 입력하세요 (1.일반석 2.프레스티지석 3.일등석): ");
		reservationInfo[5] =  keyboard.next();
		
	}
	else if(answer == 2) // 예약 조회
	{
		System.out.println("예약번호 혹은 항공권 번호를 입력하세요: ");
		veiwInfo[0] = keyboard.next();
		System.out.println("탑승일을 입력하세요 (ex.1999/7/6): ");
		veiwInfo[1] = keyboard.next();
		System.out.println("승객의 이름을 입력하세요 (ex.홍길동 / HongGildong): ");
		veiwInfo[2] = keyboard.next();
		
	}
	else if(answer == 3) // 체크인
	{
		System.out.println("예약번호 혹은 항공권 번호를 입력하세요: ");
		checkInInfo[0] = keyboard.next();
		System.out.println("탑승일을 입력하세요 (ex.1999/7/6): ");
		checkInInfo[1] = keyboard.next();
		System.out.println("승객의 이름을 입력하세요 (ex.홍길동 / HongGildong): ");
		checkInInfo[2] = keyboard.next();
	}
	else if(answer ==4) //항공편 현황
	{
		System.out.println("티켓 종류를 입력하세요 (1.왕복 2.편도): ");
		scheduleInfo[0] =  keyboard.next();
		System.out.println("출발지를 입력하세요: ");
		scheduleInfo[1] = keyboard.next();
		System.out.println("도착지를 입력하세요: ");
		scheduleInfo[2] =  keyboard.next();		
	}
}
	
	
	private static Boolean isLogined(int ans) {
		if(ans == 1)  return true;
		 else 		  return false;
		
	}
	
}

*/

