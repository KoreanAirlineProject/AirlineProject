package form;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import func.Register;


public class RegisterForm extends JFrame implements ActionListener{
    private JTextField regName;
    private JTextField regID;
    private JTextField regPW;
    private JTextField birthday;
    private JPanel deckPanel;
    private CardLayout dealer;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;


    public RegisterForm() {
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

    public JPanel setRegisterForm() {
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
        registerButton.addActionListener(this);
        register.add(registerButton);
        return register;
    }

    public void actionPerformed(ActionEvent e) {
        Register register = new Register(regID.getText(), regPW.getText(),regName.getText(), birthday.getText());
        if(register.saveFile() == 0) {
            JOptionPane.showMessageDialog(null, "회원가입에 성공하셨습니다");
            dealer.show(deckPanel, "main");
        }
        else {
            JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다");
        }

    }



}
