import form.*;
import func.user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener
{
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 1000;
	private Boolean isLogined = false; // 로그인 유무
	
	
	private CardLayout dealer;
	private JPanel deckPanel;
	LoginForm loginForm = new LoginForm();
	RegisterForm registerForm = new RegisterForm();
	ReservationForm reservationForm = new ReservationForm();
	InquiryForm inquiryForm = new InquiryForm();
	CheckInForm checkinForm = new CheckInForm();
	ManagerForm managerForm = new ManagerForm();
	ScheduleForm scheduleForm = new ScheduleForm();

	User user = new User();

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
	
		// 로그인 화면
		JPanel main = loginForm.setLoginForm();
		deckPanel.add("main", main);
		
		// 회원가입 화면
		JPanel register = registerForm.setRegisterForm();
		deckPanel.add("register", register);
		
		// 로그인 성공 후 메인화면 시작
	
		//예약 화면
		JPanel reservation = reservationForm.setReservationForm();
		deckPanel.add("reservation", reservation);

		// 조회 화면 시작
		JPanel inquiry = inquiryForm.setInquiryForm();
		deckPanel.add("inquiry", inquiry);
			
		// 체크인 화면 시작
		JPanel checkin = checkinForm.setCheckInForm();
		deckPanel.add("checkin", checkin);

		//관리자
		JPanel manager = managerForm.setManagerForm();
		deckPanel.add("manager" , manager);
			
		// 현황 조회 화면
		JPanel schedule = scheduleForm.setScheduleForm();
		deckPanel.add("schedule", schedule);
		contentPane.add(deckPanel, BorderLayout.CENTER);

		
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
		// inhyuk
		JButton managerButton = new JButton("Manager");
		managerButton.addActionListener(this);
		buttonPanel1.add(managerButton);

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
		
		//inhyuk
		JButton managerConfirm = new JButton("ManagerC");
		managerConfirm.addActionListener(this);
		buttonPanel2.add(managerConfirm);

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
		else if (actionCommand.equals("Inquiry")){
			if(!isLogined) dealer.show(deckPanel, "inquiry"); //화면전환

		} 
		else if (actionCommand.equals("checkIn")){
			if(!isLogined) dealer.show(deckPanel, "checkin"); // 화면전환
		} 
		else if (actionCommand.equals("Schedule")) dealer.show(deckPanel, "schedule"); //화면전환
		else if (actionCommand.equals("Register")) {
			dealer.show(deckPanel, "register");
		}
		
		else if(actionCommand.equals("register")) {

			
		}
		else if(actionCommand.equals("Manager")){
			dealer.show(deckPanel , "manager");
		}
		
		else if (actionCommand.equals("MainC")) //로그인 버튼 클릭시에 로그인 true로 변경
		{
;			loginForm.actionPerformed(e);
			
		}
		else if (actionCommand.equals("ReservationC")) // 예약확인 버튼 클릭시에 입력 받은 정보 배열에 저장
		{
			reservationForm.actionPerformed(e);
		}
		else if (actionCommand.equals("InquiryC")) // 예약 조회 확인 버튼 클릭시에  입력 받은 정보 배열에 저장
		{
			inquiryForm.actionPerformed(e);
		}
		else if (actionCommand.equals("checkInC")) // 체크인확인 버튼 클릭시에 입력 받은 정보 배열에 저장
		{
			checkinForm.actionPerformed(e);
		}
		else if (actionCommand.equals("ScheduleC")) //현황 조회 확인 버튼 클릭시에 입력 받은 정보 배열에 저장
		{
			scheduleForm.actionPerformed(e);
		}
		else if (actionCommand.equals("Logout")) {
			dealer.show(deckPanel, "main");
		}
//		else if(e.getSource() ==flightAdditionButton){
//			createFlight(FlightName.getText() , capacity.getText() , startDate.getText() , endDate.getText() , startLocation.getText() , endLocation.getText() );
//
//		}
	
			System.out.println("Error in CardLayout Demo.");
	}

	public static void main(String[] args)
	{
		Main demoGui = new Main( ); demoGui.setVisible(true);

	}


	public void nonMemberVarification(String page){
		switch(page){
			case "Reservation":

			break;
			case "checkIn":
				dealer.show(deckPanel, "inquiry");
			break;
			case "Inquiry":
				dealer.show(deckPanel, "inquiry");
			break;

		}	
		}
}