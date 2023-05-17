public class a {
    
	JPanel idPanel, pwPanel, birthDayPanel, namePanel;
	JLabel idLabel,  pwLabel, birthDayLabel, nameLabel;

	FlowLayout flowCenter = new FlowLayout(FlowLayout.CENTER);
	JPanel register = new JPanel(flowCenter);
	register.setLayout(new BoxLayout(register, BoxLayout.Y_AXIS));
	JPanel pnlNorth = new JPanel(new GridLayout(0,1));
	register.setBackground(Color.LIGHT_GRAY);

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