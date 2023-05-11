import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;



// import form.ReservationForm;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Panels extends JFrame implements ActionListener{
    public static final int WIDTH = 600;
	public static final int HEIGHT = 500;
	
	private String [] reservationInfo = new String[7]; // 항공권예매 정보
	private String [] veiwInfo = new String[3]; //예약조회 정보
	private String [] checkInInfo = new String[3]; //체크인 정보 
	private String [] scheduleInfo = new String[5]; // 항공편 현황 정보
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

	
	
	private JTextField FlightName;
    private JTextField capacity;
    private JTextField startDate;
    private JTextField endDate;
    private JTextField startLocation;
    private JTextField endLocation;

	
	private JButton flightAdditionButton;

    public Panels(){
    }

    
public JPanel ButtonPanel1(){
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

JPanel loginSuccess = new JPanel();
loginSuccess.setLayout(new GridLayout(0, 1, 10, 10));
loginSuccess.setBackground(Color.LIGHT_GRAY);
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
	JPanel checkin = new JPanel();
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


private JPanel inpuiryPanel(){
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

			return inquiry;
}

private JPanel reservationPanel(){
//예약화면 시작
JPanel reservation = new JPanel();
reservation.setLayout(new GridLayout(0, 1, 10, 10));
reservation.setBackground(Color.LIGHT_GRAY);
JLabel reLabel = new JLabel("Reservation");
reservation.add(reLabel);

kindOfTicketR = new JTextField("항공사를 선택하세요", 30);
reservation.add(kindOfTicketR);	
departureR = new JTextField("출발지를 입력하세요", 10);
reservation.add(departureR);		
arrivalR = new JTextField("도착지를 입력하세요", 10);
reservation.add(arrivalR);	
departureDateR = new JTextField("탑승일을 입력하세요 (ex.1999/7/6)", 10);
reservation.add(departureDateR);
arrivalDateR = new JTextField("오는 날을 입력하세요 (ex.1999/7/6)", 10);
reservation.add(arrivalDateR);
// number = new JTextField("인원 입력", 10);
// reservation.add(number);
grade = new JTextField("좌석 등급을 입력하세요 ( 1.전체 , 2.이코노미 , 3.비지니스 , 4.퍼스트 )", 10);
reservation.add(grade);

return reservation;
}

private JPanel scheduelPanel(){
JPanel schedule = new JPanel();
schedule.setLayout(new GridLayout(0, 1, 10, 10));
schedule.setBackground(Color.LIGHT_GRAY);
JLabel shcheLabel = new JLabel("Flight Schedule");
schedule.add(shcheLabel);
kindOfTicketS = new JTextField("항공기 정보를 입력하세요", 30);
schedule.add(kindOfTicketS);
departureS = new JTextField("출발지를 입력하세요", 10);
schedule.add(departureS);
arrivalS = new JTextField("도착지를 입력하세요", 10);
schedule.add(arrivalS);
startDate = new JTextField("출발 일자를 입력하세요 (ex: 1999-05-02 15:30 ) ", 20);
schedule.add(startDate);
endDate = new JTextField("도착 일자를 입력하세요 (ex: 1999-05-02 15:30 )" , 20);
schedule.add(endDate);

return schedule;
}

// Inhyuk Refactoring
// 함수화 시킨 함수들
private JPanel Register(){

Dimension btnSize = new Dimension(30 ,25);
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

if(label7.getText().equals("이코노미") ) button = new JButton("예약ECO");
else if(label7.getText().equals("비지니스")) button = new JButton("예약BUS");
else button = new JButton("예약FIR");
button.addActionListener(this);


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
private JPanel TicketsPanel(String type , ArrayList<Ticket> tickets, String fromDateFT , String toDateFT, String fromLocationFT ,String toLocationFT, String gradeFT){
System.out.println( "fromDataFT:"+ fromDateFT + "\n toDateFT : " + toDateFT +"\n fromLocationFT : " +fromLocationFT + "\n toLocationFT : " +toLocationFT + "\n gradeFT : "+gradeFT + "\n");
JPanel TicketsPanel = new JPanel( );
TicketsPanel.setLayout(new GridLayout( 3, 3, 10, 10));
TicketsPanel.setBackground(Color.LIGHT_GRAY);
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
grade = new JTextField("클래스를 입력해주세요" ,20);
manager.add(managerLabel);
manager.add(FlightName);
manager.add(startLocation);
manager.add(endLocation);
manager.add(startDate);
manager.add(endDate);
manager.add(capacity);
manager.add(grade);

flightAdditionButton = new JButton("비행 정보 제출");
flightAdditionButton.addActionListener(this);
manager.add(flightAdditionButton);

return manager;
}

private JPanel loginPanel(){
JPanel loginPanel = new JPanel( );
loginPanel.setLayout(new GridLayout(0, 1, 10, 10));
loginPanel.setBackground(Color.LIGHT_GRAY);
JLabel maintLabel = new JLabel("Login");

loginPanel.add(maintLabel);
ID = new JTextField("아이디를 입력하세요", 30);
loginPanel.add(ID);
password = new JTextField("비밀번호를 입력하세요", 30);
loginPanel.add(password);
Dimension btnSize = new Dimension(30 ,25);
JButton checkLogin = new JButton("확인");
checkLogin.setPreferredSize(new Dimension(20,20));
checkLogin.addActionListener(this);
loginPanel.add(checkLogin);

return loginPanel;
}



private JPanel homePanel(String username){

JPanel homePanel = new JPanel();
homePanel.setLayout(new GridLayout(0, 1, 10, 10));
homePanel.setBackground(Color.LIGHT_GRAY);
JLabel mainLabel = new JLabel("Korean Air Home Page");
homePanel.add(mainLabel);
// System.out.println("-->" + user.getId());
if(username != "") {
JLabel welcomeLabel = new JLabel(username+ "님" );
homePanel.add(welcomeLabel);
}



if(username != "") {
JButton LogoutButton = new JButton("Logout");
LogoutButton.setPreferredSize(new Dimension(20,20));
LogoutButton.addActionListener(this);
homePanel.add(LogoutButton);
} else{
JButton loginButton = new JButton("Login");
loginButton.addActionListener(this);
homePanel.add(loginButton);

JButton RegisterButton = new JButton("Register");
RegisterButton.setPreferredSize(new Dimension(20,20));
RegisterButton.addActionListener(this);
homePanel.add(RegisterButton);
}



return homePanel;
}
}
