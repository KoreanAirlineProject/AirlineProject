package form;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import func.Login;

public class LoginForm extends JFrame implements ActionListener{
    private JTextField ID; // ID 입력을 위한 객체
    private JTextField password; // pass
    private JPanel deckPanel;
    private CardLayout dealer;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 500;


    public LoginForm() {
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

    public JPanel setLoginForm() {
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
        JButton SumbitButton = new JButton("로그인 하기");
        SumbitButton.addActionListener(this);


        JButton RegisterButton = new JButton("Register");
        RegisterButton.setPreferredSize(new Dimension(20,20));
        RegisterButton.addActionListener(this);
        main.add(RegisterButton);
        return main;
    }

    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand( );
        if (actionCommand.equals("SumbitButton")) //로그인 버튼 클릭시에 로그인 true로 변경
        {
            System.out.println("preseed");
            Login login = new Login(ID.getText(), password.getText());
            String username = login.loadFile();
            System.out.println("==>" + username);
            if(username != "") {
//                isLogined = true;
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

    }



}
