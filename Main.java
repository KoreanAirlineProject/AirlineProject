
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

// 805 번째 줄 에러떠서 주석처리함

// import form.ReservationForm;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends JFrame implements ActionListener
{
	public static final int WIDTH = 800;
	public static final int HEIGHT = 500;
	
	private String [] reservationInfo = new String[7]; // 항공권예매 정보
	private String [] veiwInfo = new String[3]; //예약조회 정보
	private String [] checkInInfo = new String[3]; //체크인 정보 
	private String [] scheduleInfo = new String[5]; // 항공편 현황 정보
	private Boolean isLogined = false; // 로그인 유무
	private String result = ""; //저장된 티겟 값을 받아오는 변수
	
	
	private CardLayout dealer;
	private JPanel deckPanel, homePanel, loginSuccess, checkin, nonMemberVerificationPenel, inquiry, checkrv, reservation, schedule, register, TicketsPanel;
	
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

	// private JTextField grade; // 좌석 등급 입력을 위한 객체
	private JComboBox<String> grade;
	private JTextField ID; // ID 입력을 위한 객체
	private JTextField ticketnum; // 티켓 번호 입력을 위한 객체
	private JTextField name; // 승객이름 입력을 위한 객체
	private JTextField password; // password 입력을 위한 객체
	private JTextField regName;
	private JTextField regID;
	private JTextField regPW;
	private JTextField birthday;
	private String username = "";

	private JTextField FlightName;
    private JTextField capacity;
    private JTextField fromDate;
    private JTextField toDate;
    private JTextField fromLocation;
    private JTextField toLocation;

	
	private JButton flightAdditionButton;
	Ticket ticket;
	private String[] grades = {"전체" , "이코노미" , "비지니스" , "퍼스트"};
	private Color color;
    private boolean isDarkMode = false;
	

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

		deckPanel.add("homepanel", homePanel(("")));
		deckPanel.add("loginPanel", loginPanel());
		deckPanel.add("register", Register());
		deckPanel.add("TicketsPanel" , TicketsPanel("Scheduel",new ArrayList<>() , "" , "" , "" , "" ,""));
		deckPanel.add("managerPanel" , managerPanel());
		deckPanel.add("reservation", reservationPanel());
		deckPanel.add("inquiry", inpuiryPanel());
		deckPanel.add("checkReserve",checkrvPanel(result));
		deckPanel.add("checkin", checkInPanel());
		deckPanel.add("nonMemberVerificationPanel" , NonMemberVerificationPanel());
		deckPanel.add("loginSuccess", LoginSuccessPanel());
		deckPanel.add("schedulePanel" ,scheduelPanel());

		contentPane.add(deckPanel, BorderLayout.CENTER);

		contentPane.add(ButtonPanel1(), BorderLayout.NORTH);
		contentPane.add(ButtonPanel2(), BorderLayout.SOUTH);
			dealer.first(deckPanel);
		}


		
	
	// 버튼 눌렸을 떄 처리
	public void actionPerformed(ActionEvent e)
	{
		Reservation reservationECO = new Reservation(new EconomyPaymentStrategy());
		Reservation reservationFIR = new Reservation(new FirstPaymentStrategy());
		Reservation reservationBUS = new Reservation(new BusinessPaymentStrategy());
		
		User user = User.getUser();
		// System.out.println(e.getSource().);
		// System.out.println(e..getModifiers());
		String actionCommand = e.getActionCommand( );
		
		if (actionCommand.equals("Home")) dealer.show(deckPanel, "homepanel"); // 화면전환
	
		else if (actionCommand.equals("Login")) {
			
			dealer.show(deckPanel, "loginPanel"); // 화면전환
		}
		else if (actionCommand.equals("DarkMode")) {	
			button btn = new button();
				if(isDarkMode) {
					Off off = new Off();
					btn.setButtonState(off);
					color = btn.buttonClick();
					isDarkMode = !isDarkMode;
					System.out.println("isDarkMode: "+ isDarkMode);
					System.out.println("color: "+ color);

				}
				else {
					On on = new On();
					btn.setButtonState(on);
					color = btn.buttonClick();
					isDarkMode = !isDarkMode;
					System.out.println("isDarkMode: "+ isDarkMode);
					System.out.println("color: "+ color);
			
				}
                
				deckPanel.setBackground(color);
				deckPanel.repaint();
					
       
    }
			
		else if (actionCommand.equals("Reservation")){
			dealer.show(deckPanel, "reservation"); //화면전환
		} 
		else if (actionCommand.equals("Inquiry")){
			if(user.getIsLogined()) dealer.show(deckPanel, "inquiry"); //화면전환
			else if(!user.getIsLogined()) dealer.show(deckPanel,"nonMemberVerificationPanel");
		} 
		else if (actionCommand.equals("checkIn")){
			if(user.getIsLogined()) dealer.show(deckPanel, "checkin");  //화면전환
			else if(!user.getIsLogined()) dealer.show(deckPanel,"nonMemberVerificationPanel");
		} 
		else if (actionCommand.equals("Schedule")){
			dealer.show(deckPanel, "schedulePanel"); //화면전환	
		} 
		else if (actionCommand.equals("Register")) {
			dealer.show(deckPanel, "register");
		}
		else if(actionCommand.equals("doRegister")) {
			// User user = User.getUser();
			boolean isSuccessed = user.register(regID.getText(), regPW.getText(),regName.getText(), birthday.getText() , "./member.txt");
			// Register register = new Register(regID.getText(), regPW.getText(),regName.getText(), birthday.getText());
			if( isSuccessed == true) {
				JOptionPane.showMessageDialog(null, "회원가입에 성공하셨습니다");
				loginPanel();
				dealer.show(deckPanel, "loginPanel"); // 화면전환
			}
			else {
				JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다");	
			}
			
		}
		else if(actionCommand.equals("Manager")){
			
			deckPanel.add("managerPanel" , managerPanel());
			dealer.show(deckPanel , "managerPanel");
		}
	
			else if(actionCommand.equals("비행 정보 제출")){
				Manager manager = new Manager();
				manager.createFlight(FlightName.getText(), fromLocation.getText() , toLocation.getText() , fromDate.getText() , toDate.getText() , capacity.getText() ,grade.getToolTipText() );

				// User user = User.getUser();
				deckPanel.add("homepanel", homePanel(user.getName()));
				dealer.show(deckPanel, "homepanel"); 
			}
			else if(actionCommand.equals("닫기")){
				// User user = User.getUser();
				deckPanel.add("homepanel", homePanel(user.getName()));
				dealer.show(deckPanel, "homepanel"); 
			}
		else if (actionCommand.equals("doLogin")) //로그인 버튼 클릭시에 로그인 true로 변경
		{
			System.out.println("preseed");

			// User user = User.getUser();
			// Airline airline = new Airline();
			System.out.println(ID.getText() +password.getText() +"preseed");
			if(user.login("./member.txt" , ID.getText(), password.getText())){
				user.setIsLogined(true);
				JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다.");
				System.out.println("성공");
				dealer.show(deckPanel , "register");
				deckPanel.add("homepanel", homePanel(user.getName()));
				dealer.show(deckPanel, "homepanel"); 
			} else{
				JOptionPane.showMessageDialog(null, "로그인 정보가 일치하지 않습니다.");
				user.setIsLogined(false);
				System.out.println("실패");
			}
		}
						else if (actionCommand.equals("ReservationC")) // 예약확인 버튼 클릭시에 입력 받은 정보 배열에 저장
						{
							// ReservationForm rf = new ReservationForm();
							// rf.
							reservationInfo[0] = kindOfTicketR.getText();
							// reservationInfo[1] = number.getText();
							reservationInfo[1] = departureDateR.getText();
							reservationInfo[2] = arrivalDateR.getText();
							reservationInfo[3] = departureR.getText();
							reservationInfo[4] = arrivalR.getText();
							reservationInfo[5] = grade.getToolTipText();

							Airline airline = new Airline();

							try {
								deckPanel.add("TicketsPanel" , TicketsPanel("reservation" , airline.showFlights("./writeFile.txt") ,reservationInfo[1] , reservationInfo[2],reservationInfo[3] , reservationInfo[4],reservationInfo[5]));
								
								dealer.show(deckPanel, "TicketsPanel");
								
							} catch (NumberFormatException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						}
		else if (actionCommand.equals("CheckNonMember")) // 비회원 예약 조회 확인 버튼 클릭시에  입력 받은 정보 배열에 저장
		{
			ViewReservation rv = new ViewReservation();

			for(int i =0; i<3;i++){
				veiwInfo[i] = "";
			}
		
			veiwInfo[0] = ticketnum.getText();
			veiwInfo[1] = departureDateI.getText();
			veiwInfo[2] = name.getText();

			result = rv.readTicket(veiwInfo[0]);
			user.setName(veiwInfo[2]);

			JOptionPane.showMessageDialog(null , "인증되었습니다.");

			deckPanel.add("checkReserve",checkrvPanel(result));
			dealer.show(deckPanel, "checkReserve");
			
		}
		else if (actionCommand.equals("InquiryC") && user.getIsLogined()) // 예약 조회 확인 버튼 클릭시에 입력 받은 정보 배열에 저장,  InquiryC는 로그인 상태에서만 동작
		{

			for(int i =0; i<3;i++){
					veiwInfo[i] = "";
				}
				ViewReservation rv = new ViewReservation();

				veiwInfo[0] = ticketnum.getText();
				

				result = rv.readTicket(veiwInfo[0]);
				user.setName(veiwInfo[2]);

				deckPanel.add("checkReserve",checkrvPanel(result));
				dealer.show(deckPanel, "checkReserve");

		} 
		else if (actionCommand.equals("Delete")) // 삭제 버튼 클릭시에 저장된 티켓 삭제
		{
			ViewReservation rv = new ViewReservation();

			veiwInfo[0] = ticketnum.getText();
			rv.deleteTicket(veiwInfo[0]);

			JOptionPane.showMessageDialog(null , "티켓 정보가 삭제 되었습니다.");

			deckPanel.add("checkReserve",checkrvPanel(""));
			dealer.show(deckPanel, "checkReserve");
			rv.deleteTicket(veiwInfo[0]);

			
		}
		else if (actionCommand.equals("CheckInC")) // 체크인확인 버튼 클릭시에 입력 받은 정보 배열에 저장
		{
			checkInInfo[0] = ticketnum.getText();
			checkInInfo[1] = departureDateC.getText();
			checkInInfo[2] = name.getText();

		}
		else if (actionCommand.equals("ScheduleC")) //현황 조회 확인 버튼 클릭시에 입력 받은 정보 배열에 저장
		{
			Airline airline = new Airline();
			// scheduleInfo[0] = kindOfTicketS.getText();
			scheduleInfo[1] = departureS.getText();
			scheduleInfo[2] = arrivalS.getText();
			scheduleInfo[3] = fromDate.getText();
			scheduleInfo[4] = toDate.getText();
			try {
				deckPanel.add("TicketsPanel" , TicketsPanel("schedule" , airline.showFlights("./writeFile.txt") , scheduleInfo[3],scheduleInfo[4], scheduleInfo[1],scheduleInfo[2]  , "전체"));

			dealer.show(deckPanel, "TicketsPanel");
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// FlightSearch flightSearch = new FlightSearch();
			// flightSearch.searchSchedule(scheduleInfo[1], scheduleInfo[2], scheduleInfo[3], scheduleInfo[4]);
		}
		else if (actionCommand.equals("Logout")) {
			// dealer.show(deckPanel, "homepanel");
			deckPanel.add("homepanel", homePanel(""));
			dealer.show(deckPanel, "homepanel"); 
		}
		else if(e.getSource() ==flightAdditionButton){
			Manager manager = new Manager();
			manager.createFlight(FlightName.getText() , fromLocation.getText() , toLocation.getText() , fromDate.getText() , toDate.getText() ,capacity.getText(), grade.getToolTipText());
		}
		
		
		
	
	}

	public static void main(String[] args)
	{
		Main demoGui = new Main( ); demoGui.setVisible(true);
	}	

	public void nonMemberVerification(String page){
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



private JPanel ButtonPanel1(){
	JPanel buttonPanel1 = new JPanel( );
buttonPanel1.setBackground(Color.BLACK);
buttonPanel1.setLayout(new FlowLayout());

JButton mainButton = new JButton("Home");
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

return buttonPanel1;
}

private JPanel ButtonPanel2(){
	JPanel buttonPanel2 = new JPanel( );
buttonPanel2.setBackground(Color.BLACK);
buttonPanel2.setLayout(new FlowLayout( ));

// JButton mainConfirm = new JButton("MainC");
// mainConfirm.addActionListener(this);
// buttonPanel2.add(mainConfirm);

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
	
	return buttonPanel2;
}

private JPanel LoginSuccessPanel(){
	User user = User.getUser();

loginSuccess = new JPanel();
loginSuccess.setLayout(new GridLayout(0, 1, 10, 10));
loginSuccess.setBackground(color);
JLabel mainLabel = new JLabel("Korean Air Home Page");
loginSuccess.add(mainLabel);
System.out.println("-->" + user.getId());
JLabel welcomeLabel = new JLabel(user.getName()+ "님" );
loginSuccess.add(welcomeLabel);

JButton LogoutButton = new JButton("Logout");
LogoutButton.setPreferredSize(new Dimension(20,20));
LogoutButton.addActionListener(this);
loginSuccess.add(LogoutButton);

return loginSuccess;
}

private JPanel checkInPanel() {
	checkin = new JPanel();
	checkin.setLayout(new GridLayout(0, 1, 10, 10));
	checkin.setBackground(color);
	JLabel checkLabel = new JLabel("Check-in");
	checkin.add(checkLabel);
	// ticketnum = new JTextField("예약 번호를 입력하세요", 10);
	// checkin.add(ticketnum);
	// departureDateC = new JTextField("탑승일을 입력하세요 (ex.1999/7/6)", 10);
	// checkin.add(departureDateC);
	// name = new JTextField("승객의 이름을 입력하세요", 10);
	// checkin.add(name);

	return checkin;
}

private JPanel NonMemberVerificationPanel(){

	JPanel  ticketNumPanel, depDatePanel, namePanel;
	JLabel checkLabel,  ticketNumLabel, depDateLabel, nameLabel;

    FlowLayout flowCenter = new FlowLayout(FlowLayout.CENTER);
	nonMemberVerificationPenel = new JPanel(flowCenter);
	nonMemberVerificationPenel.setLayout(new BoxLayout(nonMemberVerificationPenel, BoxLayout.Y_AXIS));
	nonMemberVerificationPenel.setBackground(color);

	JPanel pnlNorth = new JPanel(new GridLayout(0,1));

	checkLabel = new JLabel("비회원 정보를 입력해 주세요");
	checkLabel.setFont(new Font("Verdana", Font.BOLD, 20));

	ticketNumPanel = new JPanel();
	ticketNumLabel = new JLabel("예약번호:");
	ticketnum = new JTextField(15);
	ticketNumPanel.add(ticketNumLabel);
	ticketNumPanel.add(ticketnum);

	depDatePanel = new JPanel();
	depDateLabel = new JLabel("탑승일 (ex.1999/7/6):");
	departureDateI = new JTextField(15);
	depDatePanel.add(depDateLabel);
	depDatePanel.add(departureDateI);

	namePanel = new JPanel();
	nameLabel = new JLabel("승객 이름:");
	name = new JTextField(15);
	namePanel.add(nameLabel);
	namePanel.add(name);

    pnlNorth.add(checkLabel);
	pnlNorth.add(ticketNumPanel);
	pnlNorth.add(depDatePanel);
	pnlNorth.add(namePanel);

	JPanel pnlSouth = new JPanel();
	JButton nonMemberVerificationButton = new JButton("CheckNonMember");
	nonMemberVerificationButton.addActionListener(this);
	pnlSouth.add(nonMemberVerificationButton);

	pnlNorth.setBorder(new EmptyBorder(20,20,0,20));
	pnlSouth.setBorder(new EmptyBorder(0,0,10,0));

	nonMemberVerificationPenel.add(pnlNorth, BorderLayout.NORTH);
	nonMemberVerificationPenel.add(pnlSouth, BorderLayout.SOUTH);


	return nonMemberVerificationPenel;
	
}

private JPanel inpuiryPanel(){

	JPanel  ticketNumPanel, depDatePanel, namePanel;
	JLabel inLabel,  ticketNumLabel, depDateLabel, nameLabel;

    FlowLayout flowCenter = new FlowLayout(FlowLayout.CENTER);
	inquiry = new JPanel(flowCenter);
	inquiry.setLayout(new BoxLayout(inquiry, BoxLayout.Y_AXIS));
	inquiry.setBackground(color);

	JPanel pnlNorth = new JPanel(new GridLayout(0,1));

	inLabel = new JLabel("Inquiry");
	inLabel.setFont(new Font("Verdana", Font.BOLD, 20));

	ticketNumPanel = new JPanel();
	ticketNumLabel = new JLabel("예약번호:");
	ticketnum = new JTextField(15);
	ticketNumPanel.add(ticketNumLabel);
	ticketNumPanel.add(ticketnum);

	depDatePanel = new JPanel();
	depDateLabel = new JLabel("탑승일 (ex.1999/7/6):");
	departureDateI = new JTextField(15);
	depDatePanel.add(depDateLabel);
	depDatePanel.add(departureDateI);

	namePanel = new JPanel();
	nameLabel = new JLabel("승객 이름:");
	name = new JTextField(15);
	namePanel.add(nameLabel);
	namePanel.add(name);

    pnlNorth.add(inLabel);
	pnlNorth.add(ticketNumPanel);
	pnlNorth.add(depDatePanel);
	pnlNorth.add(namePanel);

	JPanel pnlSouth = new JPanel();
	JButton nonMemberVerificationButton = new JButton("CheckNonMember");
	nonMemberVerificationButton.addActionListener(this);
	pnlSouth.add(nonMemberVerificationButton);

	pnlNorth.setBorder(new EmptyBorder(20,20,0,20));
	pnlSouth.setBorder(new EmptyBorder(0,0,10,0));

	inquiry.add(pnlNorth, BorderLayout.NORTH);
	inquiry.add(pnlSouth, BorderLayout.SOUTH);


	return inquiry;
}

private JPanel checkrvPanel(String info) {

	checkrv = new JPanel();
    checkrv.setLayout(new BorderLayout());
    
 
    JLabel infoLabel = new JLabel(info);
    checkrv.add(infoLabel, BorderLayout.CENTER);
  
    JButton deleteButton = new JButton("Delete");
	deleteButton.addActionListener(this);
    checkrv.add(deleteButton, BorderLayout.EAST);
	
    return checkrv;
}

private JPanel reservationPanel(){
	//예약화면 시작
	JPanel kindOfTicketPanel, departureRPanel, arrivalRPanel, departureDateRPanel, arrivalDateRPanel, gradePanel;
	JLabel kindOfTicketLabel, departureRLabel, arrivalRLabel, departureDateRLabel, arrivalDateRLabel, gradeLabel;

	FlowLayout flowCenter = new FlowLayout(FlowLayout.LEFT);
	reservation = new JPanel(flowCenter);
	reservation.setLayout(new BoxLayout(reservation, BoxLayout.Y_AXIS));
	reservation.setBackground(color);

	JPanel pnlNorth = new JPanel(new GridLayout(0,1));

	JLabel reLabel = new JLabel("Reservation");
	reLabel.setFont(new Font("Verdana", Font.BOLD, 20));

	kindOfTicketPanel = new JPanel();
	kindOfTicketLabel = new JLabel("항공사:");
	kindOfTicketR = new JTextField(15);
	kindOfTicketPanel.add(kindOfTicketLabel);
	kindOfTicketPanel.add(kindOfTicketR);

	departureRPanel = new JPanel();
	departureRLabel = new JLabel("출발지:");
	departureR = new JTextField(15);
	departureRPanel.add(departureRLabel);
	departureRPanel.add(departureR);

	arrivalRPanel = new JPanel();
	arrivalRLabel = new JLabel("도착지:");
	arrivalR = new JTextField(15);
	arrivalRPanel.add(arrivalRLabel);
	arrivalRPanel.add(arrivalR);

	departureDateRPanel = new JPanel();
	departureDateRLabel = new JLabel("탑승일 (ex.1999/7/6):");
	departureDateR = new JTextField(15);
	departureDateRPanel.add(departureDateRLabel);
	departureDateRPanel.add(departureDateR);

	arrivalDateRPanel = new JPanel();
	arrivalDateRLabel = new JLabel("오는 날 (ex.1999/7/6):");
	arrivalDateR = new JTextField(15);
	arrivalDateRPanel.add(arrivalDateRLabel);
	arrivalDateRPanel.add(arrivalDateR);

	gradePanel = new JPanel();
	gradeLabel = new JLabel("좌석 등급:");
	grade = new JComboBox<>(grades);
	gradePanel.add(gradeLabel);
	gradePanel.add(grade);


	pnlNorth.add(reLabel);
	pnlNorth.add(kindOfTicketPanel);
	pnlNorth.add(departureRPanel);
	pnlNorth.add(arrivalRPanel);
	pnlNorth.add(departureDateRPanel);
	pnlNorth.add(arrivalDateRPanel);
	pnlNorth.add(gradePanel);
	
		
	pnlNorth.setBorder(new EmptyBorder(20,20,0,20));

	reservation.add(pnlNorth, BorderLayout.NORTH);

	return reservation;
}

private JPanel scheduelPanel(){

	JPanel kindOfTicketSPanel, departureSPanel, arrivalSPanel, fromDatePanel, toDatePanel;
	JLabel kindOfTicketSLabel, departureSLabel, arrivalSLabel, fromDateLabel, toDateLabel;

	FlowLayout flowCenter = new FlowLayout(FlowLayout.LEFT);
	schedule = new JPanel(flowCenter);
	schedule.setLayout(new BoxLayout(schedule, BoxLayout.Y_AXIS));
	schedule.setBackground(color);

	JPanel pnlNorth = new JPanel(new GridLayout(0,1));

	JLabel shcheLabel = new JLabel("Flight Schedule");
	shcheLabel.setFont(new Font("Verdana", Font.BOLD, 20));

	kindOfTicketSPanel = new JPanel();
	kindOfTicketSLabel = new JLabel("항공기 정보:");
	kindOfTicketS = new JTextField(15);
	kindOfTicketSPanel.add(kindOfTicketSLabel);
	kindOfTicketSPanel.add(kindOfTicketS);

	departureSPanel = new JPanel();
	departureSLabel = new JLabel("출발지:");
	departureS = new JTextField(15);
	departureSPanel.add(departureSLabel);
	departureSPanel.add(departureS);

	arrivalSPanel = new JPanel();
	arrivalSLabel = new JLabel("도착지:");
	arrivalS= new JTextField(15);
	arrivalSPanel.add(arrivalSLabel);
	arrivalSPanel.add(arrivalS);

	fromDatePanel = new JPanel();
	fromDateLabel = new JLabel("출발 일자 (ex: 1999-05-02 15:30):");
	fromDate = new JTextField(15);
	fromDatePanel.add(fromDateLabel);
	fromDatePanel.add(fromDate);

	toDatePanel = new JPanel();
	toDateLabel = new JLabel("도착 일자 (ex: 1999-05-02 15:30):");
	toDate = new JTextField(15);
	toDatePanel.add(toDateLabel);
	toDatePanel.add(toDate);

	pnlNorth.add(shcheLabel);
	pnlNorth.add(kindOfTicketSPanel);
	pnlNorth.add(departureSPanel);
	pnlNorth.add(arrivalSPanel);
	pnlNorth.add(fromDatePanel);
	pnlNorth.add(toDatePanel);
		
	pnlNorth.setBorder(new EmptyBorder(20,20,0,20));

	schedule.add(pnlNorth, BorderLayout.NORTH);

	return schedule;
}

// Inhyuk Refactoring
// 함수화 시킨 함수들
private JPanel Register(){

	JPanel idPanel, pwPanel, birthDayPanel, namePanel;
	JLabel idLabel,  pwLabel, birthDayLabel, nameLabel;

	FlowLayout flowCenter = new FlowLayout(FlowLayout.CENTER);
	register = new JPanel(flowCenter);
	register.setLayout(new BoxLayout(register, BoxLayout.Y_AXIS));
	JPanel pnlNorth = new JPanel(new GridLayout(0,1));
	register.setBackground(color);

	JLabel regLabel = new JLabel("Register");
	regLabel.setFont(new Font("Verdana", Font.BOLD, 20));

	namePanel = new JPanel();
	nameLabel = new JLabel("이름:");
	regName = new JTextField(15);
	namePanel.add(nameLabel);
	namePanel.add(regName);

	idPanel = new JPanel();
	idLabel = new JLabel("ID:");
	regID = new JTextField(15);
	idPanel.add(idLabel);
	idPanel.add(regID);

	pwPanel = new JPanel();
	pwLabel = new JLabel("PW:");
	regPW = new JPasswordField(15);
	pwPanel.add(pwLabel);
	pwPanel.add(regPW);

	birthDayPanel = new JPanel();
	birthDayLabel = new JLabel("birthday:");
	birthday= new JTextField(15);
	birthDayPanel.add(birthDayLabel);
	birthDayPanel.add(birthday);

	pnlNorth.add(regLabel);
	pnlNorth.add(namePanel);
	pnlNorth.add(idPanel);
	pnlNorth.add(pwPanel);
	pnlNorth.add(birthDayPanel);

	JPanel pnlSouth = new JPanel();
	JButton registerButton = new JButton("doRegister");
	registerButton.addActionListener(this);
	pnlSouth.add(registerButton);

	pnlNorth.setBorder(new EmptyBorder(20,20,0,20));
	pnlSouth.setBorder(new EmptyBorder(0,0,10,0));

	register.add(pnlNorth, BorderLayout.NORTH);
	register.add(pnlSouth, BorderLayout.SOUTH);



	return register;
}


public JPanel LongButtonExample(String info1,String info2,String info3,String info4,String info5,String info6 , String info7 , String yesorno) {
setTitle("Long Button Example");
setDefaultCloseOperation(EXIT_ON_CLOSE);

JPanel panel = new JPanel(new GridLayout(4, 8)); // 1 row, 7 columns



// panel.setPreferredSize(new Dimension(10, 70));
add(panel);
// create labels and text fields
JLabel label1 = new JLabel(info1);
// JTextField textField1 = new JTextField(10);
JLabel label2 = new JLabel(info2);
// JTextField textField2 = new JTextField(10);
JLabel label3 = new JLabel(info3);
// JTextField textField3 = new JTextField(10);
JLabel label4 = new JLabel(info4);
// JTextField textField4 = new JTextField(10);
JLabel label5 = new JLabel(info5);
// JTextField textField5 = new JTextField(10);
JLabel label6 = new JLabel(info6);
JLabel label7 = new JLabel(info7);
// JTextField textField6 = new JTextField(10);
// create button
JButton button;

button = new JButton("예약");

button.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e){
		
		Reservation reservation = null;

		
		int option = JOptionPane.showOptionDialog(
            null,
            "어떤 결제 수단으로 결재하시겠습니까?",
            "결제 수단",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[] {"카드", "삼성페이"},
            "카드"
        );
        if(option == -1) return;
        else if (option == JOptionPane.YES_OPTION) {
            // 파일을 저장하는 코드 작성

		reservation = new Reservation( new CardPaymentMethodStrategy());
			if(!reservation.PaymentMethod()) return ;

        } else {
            // 저장하지 않고 종료하는 코드 작성
			// reservation = new Reservation(new accountPaymentMethodStrategy());

			if(!reservation.PaymentMethod()) return;
			// System.out.println("계좌이체 스트레티지");
        }
		// 각 표를 보고 예약을 할 수 있는 이벤트 , 각 표에 대한 정보를 필요로 하기 때문에 콜백 함수로 처리하였음.

		// 필요한 객체 생성
		// 구매한 유저 , 구매한 티켓에 대한 정보
		
		User user = User.getUser();
		Ticket reservedTicket = new Ticket(info1,info2,info3,info4,info5,info6,info7);
		
		// 예약 객체 생성

		// label7 은 좌석등급
		// 좌석등급별로 reservation에 다른 payment 전략을 적용함.
		switch(label7.getText()){
			case "이코노미":
			reservation = new Reservation(new EconomyPaymentStrategy());
			break;
			case "비지니스":
			reservation = new Reservation(new BusinessPaymentStrategy());
			break;
			case "퍼스트":
			reservation = new Reservation(new FirstPaymentStrategy());
			break;
		}

		// 버튼 클릭후 프로세스 
		// 구매 확인 창을 띄운 뒤 티켓 정보와 유저정보를 ticketList.txt에 저장하고 홈 페널로 이동
		JOptionPane.showMessageDialog(null, reservation.payment(reservedTicket));

		deckPanel.add("homepanel", homePanel(user.getName()));
		dealer.show(deckPanel, "homepanel");


	}	
});


// add labels and text fields to the panel
panel.add(label1);
panel.add(label2);
panel.add(label3);
panel.add(label4);
panel.add(label5);
panel.add(label6);
panel.add(label7);
if(info1!="항공기 정보" && yesorno == "yes") panel.add(button);

setVisible(true);

return panel;
}

// private class MyActionListener implements ActionListener{
// 	private Ticket ticket;
// 	public MyActionListener(Ticket ticket){
// 		this.ticket = ticket;
// 	}

// 	public actionPerfomed(ActionEvent e){
// 		System.out.println(ticket);
// 	}
// }


private JPanel TicketsPanel(String type , ArrayList<Ticket> tickets, String fromDateFT , String toDateFT, String fromLocationFT ,String toLocationFT, String gradeFT){
System.out.println( "fromDataFT:"+ fromDateFT + "\n toDateFT : " + toDateFT +"\n fromLocationFT : " +fromLocationFT + "\n toLocationFT : " +toLocationFT + "\n gradeFT : "+gradeFT + "\n");
TicketsPanel = new JPanel( );
TicketsPanel.setLayout(new GridLayout( 3, 3, 10, 10));
TicketsPanel.setBackground(color);
String[][] ticketContents = new String[300][7];
System.out.println(tickets.size());
// TicketsPanel.add(LongButtonExample("항공기 정보" , "출발지" , "도착지" , "출발일자" , "도착일자" , "인원", "좌석등급"));

if(gradeFT.equals("비지니스") || gradeFT.equals("퍼스트") || gradeFT.equals("이코노미")){
for(int i = 0 ; i < tickets.size() ; ++i){

// Filtering
if(fromLocationFT.equals(tickets.get(i).getFromLocation())  
&& toLocationFT.equals(tickets.get(i).getToLocation())  &&
fromDateFT.equals(tickets.get(i).getFromDate()) && 
toDateFT.equals(tickets.get(i).getToDate()) &&
gradeFT.equals(tickets.get(i).getSeat())
){
	
	Ticket ticket = tickets.get(i);

	ticketContents[i][0] = ticket.getAirplane();
	ticketContents[i][1] = ticket.getFromLocation();
	ticketContents[i][2] = ticket.getToLocation();
	ticketContents[i][3] = ticket.getFromDate();
	ticketContents[i][4] = ticket.getToDate();
	ticketContents[i][5] =  ticket.getCapacity();
	ticketContents[i][6] = ticket.getSeat();
	
	TicketsPanel.add(LongButtonExample(ticketContents[i][0] , ticketContents[i][1],ticketContents[i][2],ticketContents[i][3],ticketContents[i][4],ticketContents[i][5],ticketContents[i][6], "yes") );
}



}	
} else{

for(int i = 0 ; i < tickets.size() ; ++i){
// System.out.println(tickets.get(i).getFromLocation());

// Filtering
if(fromLocationFT.equals(tickets.get(i).getFromLocation())  
&& toLocationFT.equals(tickets.get(i).getToLocation())  &&
fromDateFT.equals(tickets.get(i).getFromDate()) && 
toDateFT.equals(tickets.get(i).getToDate())
){
	
	Ticket ticket = tickets.get(i);

	ticketContents[i][0] = ticket.getAirplane();
	ticketContents[i][1] = ticket.getFromLocation();
	ticketContents[i][2] = ticket.getToLocation();
	ticketContents[i][3] = ticket.getFromDate();
	ticketContents[i][4] = ticket.getToDate();
	ticketContents[i][5] =  ticket.getCapacity();
	ticketContents[i][6] = ticket.getSeat();
	
	
	
	if(type=="reservation") TicketsPanel.add(LongButtonExample(ticketContents[i][0] , ticketContents[i][1],ticketContents[i][2],ticketContents[i][3],ticketContents[i][4],ticketContents[i][5],ticketContents[i][6],"yes"));
	else if(type=="schedule") TicketsPanel.add(LongButtonExample(ticketContents[i][0] , ticketContents[i][1],ticketContents[i][2],ticketContents[i][3],ticketContents[i][4],ticketContents[i][5],ticketContents[i][6],"no"));

}


}	
}


if(type == "schedule") {
JButton closeButton = new JButton("닫기");
closeButton.addActionListener(this);
TicketsPanel.add(closeButton);	
}



return TicketsPanel;
}

private JPanel managerPanel() {

	JPanel FlightNamePanel, capacityPanel, fromDatePanel, toDatePanel, fromLocationPanel, toLocationPanel, gradePanel;
	JLabel FlightNameLabel,  capacityLabel, fromDateLabel, toDateLabel, fromLocationLabel, toLocationLabel, gradeLabel;

	FlowLayout flowCenter = new FlowLayout(FlowLayout.CENTER);
	JPanel manager = new JPanel(flowCenter);
	manager.setLayout(new BoxLayout(manager, BoxLayout.Y_AXIS));
	JPanel pnlNorth = new JPanel(new GridLayout(0,1));
	manager.setBackground(color);

	JLabel managerLabel = new JLabel("Manager Page");
	managerLabel.setFont(new Font("Verdana", Font.BOLD, 20));

	FlightNamePanel = new JPanel();
	FlightNameLabel = new JLabel("비행기 정보:");
	FlightName = new JTextField(15);
	FlightNamePanel.add(FlightNameLabel);
	FlightNamePanel.add(FlightName);

	capacityPanel = new JPanel();
	capacityLabel = new JLabel("인원:");
	capacity = new JTextField(15);
	capacityPanel.add(capacityLabel);
	capacityPanel.add(capacity);

	fromDatePanel = new JPanel();
	fromDateLabel = new JLabel("출발 일자 (ex: 1999-05-02 15:30):");
	fromDate = new JTextField(15);
	fromDatePanel.add(fromDateLabel);
	fromDatePanel.add(fromDate);

	toDatePanel = new JPanel();
	toDateLabel = new JLabel("도착 일자 (ex: 1999-05-02 15:30):");
	toDate = new JTextField(15);
	toDatePanel.add(toDateLabel);
	toDatePanel.add(toDate);

	fromLocationPanel = new JPanel();
	fromLocationLabel = new JLabel("출발지:");
	fromLocation = new JTextField(15);
	fromLocationPanel.add(fromLocationLabel);
	fromLocationPanel.add(fromLocation);

	toLocationPanel = new JPanel();
	toLocationLabel = new JLabel("도착지:");
	toLocation = new JTextField(15);
	toLocationPanel.add(toLocationLabel);
	toLocationPanel.add(toLocation);

	gradePanel = new JPanel();
	gradeLabel = new JLabel("클래스:");
	grade = new JComboBox<>(grades);
	gradePanel.add(gradeLabel);
	gradePanel.add(grade);


	pnlNorth.add(managerLabel);
	pnlNorth.add(FlightNamePanel);
	pnlNorth.add(capacityPanel);
	pnlNorth.add(fromLocationPanel);
	pnlNorth.add(toLocationPanel);
	pnlNorth.add(fromDatePanel);
	pnlNorth.add(toDatePanel);
	pnlNorth.add(gradePanel);
    
	JPanel pnlSouth = new JPanel();
	flightAdditionButton = new JButton("비행 정보 제출");
	flightAdditionButton.addActionListener(this);
	pnlSouth.add(flightAdditionButton);

	pnlNorth.setBorder(new EmptyBorder(20,20,0,20));
	pnlSouth.setBorder(new EmptyBorder(0,0,10,0));

	manager.add(pnlNorth, BorderLayout.NORTH);
	manager.add(pnlSouth, BorderLayout.SOUTH);

	return manager;
}




private JPanel loginPanel(){
	JPanel idPanel, pwPanel;
	JLabel mainLabel,  idLabel, pwLabel;
	FlowLayout flowCenter = new FlowLayout(FlowLayout.CENTER);
	JPanel loginPanel = new JPanel(flowCenter);
	loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
	loginPanel.setBackground(color);
	JPanel pnlNorth = new JPanel(new GridLayout(0,1));

	mainLabel = new JLabel("Login");
	mainLabel.setFont(new Font("Verdana", Font.BOLD, 20));

	idPanel = new JPanel();
	idLabel = new JLabel("ID:");
	ID = new JTextField(15);
	idPanel.add(idLabel);
	idPanel.add(ID);

	pwPanel = new JPanel();
	pwLabel = new JLabel("PW:");
	password = new JPasswordField(15);
	pwPanel.add(pwLabel);
	pwPanel.add(password);

	pnlNorth.add(mainLabel);
	pnlNorth.add(idPanel);
	pnlNorth.add(pwPanel);

	JPanel pnlSouth = new JPanel();
	JButton checkLogin = new JButton("doLogin");
	checkLogin.addActionListener(this);
	pnlSouth.add(checkLogin);

	pnlNorth.setBorder(new EmptyBorder(20,20,0,20));
	pnlSouth.setBorder(new EmptyBorder(0,0,10,0));

	loginPanel.add(pnlNorth, BorderLayout.NORTH);
	loginPanel.add(pnlSouth, BorderLayout.SOUTH);

	return loginPanel;
}



private JPanel homePanel(String username){

    JButton colorButton, LogoutButton, RegisterButton;
	JLabel mainLabel, welcomeLabel;
	JPanel colorButtonPanel, logoutButtonPanel, loginButtonPanel, registerButtonPanel;
	FlowLayout flowCenter = new FlowLayout(FlowLayout.CENTER);
	homePanel = new JPanel(flowCenter);
	homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.Y_AXIS));
	
	homePanel.setBackground(color);
	JPanel pnlNorth = new JPanel(new GridLayout(0,1));
	JPanel pnlNorthM = new JPanel(new GridLayout(0,1));
	JPanel pnlSouth = new JPanel(new GridLayout(0,1));

	pnlNorth.setBackground(color);
	pnlSouth.setBackground(color);

	mainLabel = new JLabel("Korean Air Home Page");
	mainLabel.setFont(new Font("Verdana", Font.BOLD, 20));
    
	pnlNorthM.add(mainLabel);

	colorButton = new JButton("DarkMode");
	colorButton.addActionListener(this);

	colorButtonPanel = new JPanel();
	colorButtonPanel.add(colorButton);
	pnlNorth.add(colorButtonPanel);

	new JLabel("Korean Air Home Page");
	if(username != "") {
		welcomeLabel = new JLabel(username+ "님" );
		pnlNorth.add(welcomeLabel);
		LogoutButton = new JButton("Logout");
		LogoutButton.addActionListener(this);
		logoutButtonPanel = new JPanel();
		logoutButtonPanel.add(LogoutButton);
		pnlSouth.add(logoutButtonPanel);
	} else{
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(this);
		loginButtonPanel = new JPanel();
		loginButtonPanel.add(loginButton);
		pnlSouth.add(loginButtonPanel);

		RegisterButton = new JButton("Register");
		RegisterButton.addActionListener(this);
		registerButtonPanel = new JPanel();
		registerButtonPanel.add(RegisterButton);
		pnlSouth.add(registerButtonPanel);

	}

	pnlNorthM.setBorder(new EmptyBorder(20,280,0,200));
	pnlNorth.setBorder(new EmptyBorder(60,350,100,350));
	pnlSouth.setBorder(new EmptyBorder(60,350,100,350));

	homePanel.add(pnlNorthM, BorderLayout.NORTH);
	homePanel.add(pnlNorth, BorderLayout.NORTH);
	homePanel.add(pnlSouth, BorderLayout.SOUTH);

	return homePanel;


 }
}


