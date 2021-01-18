package libraryProject;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.java.ex.dao.MemberDAO;

public class Login extends JFrame {

	CardLayout card = new CardLayout();
	public static String loginidcheck;
	public static String loginpwcheck;

	public static void main(String[] args) {
		Login login = new Login();
		login.setSize(360, 280);
		login.setVisible(true);

	}

	public Login() {
		setTitle("도서관");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 219);
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);

		JLabel login = new JLabel("로그인");
		login.setBounds(160, 35, 50, 15);
		panel.add(login);

		JLabel lbid = new JLabel("아이디");
		lbid.setHorizontalAlignment(SwingConstants.LEFT);
		lbid.setBounds(61, 65, 57, 15);
		panel.add(lbid);

		JLabel lbpw = new JLabel("비밀번호");
		lbpw.setBounds(61, 90, 57, 15);
		panel.add(lbpw);

		JTextField tf_id = new JTextField();
		tf_id.setBounds(135, 65, 135, 21);
		panel.add(tf_id);
		tf_id.setColumns(10);

		JTextField tf_pw = new JTextField();
		tf_pw.setBounds(135, 90, 135, 21);
		panel.add(tf_pw);
		tf_pw.setColumns(10);

		JButton btlogin = new JButton("로그인");
		btlogin.setBounds(70, 140, 90, 23);
		panel.add(btlogin);

		JButton btjoin = new JButton("회원가입");
		btjoin.setBounds(190, 140, 90, 23);
		panel.add(btjoin);

		JButton btfindid = new JButton("ID찾기");
		btfindid.setBounds(70, 180, 90, 23);
		panel.add(btfindid);

		JButton btfindpw = new JButton("PW찾기");
		btfindpw.setBounds(190, 180, 90, 23);
		panel.add(btfindpw);

		btjoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Join bl = new Join();
				bl.setVisible(true);
			}
		});

		btfindid.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FindID findid = new FindID();
				findid.setVisible(true);
			}
		});

		btfindpw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FindPW findpw = new FindPW();
				findpw.setVisible(true);
			}
		});

		btlogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MemberDAO dao = new MemberDAO();
				String id = tf_id.getText();
				String pwd = tf_pw.getText();
				loginidcheck = dao.loginidCheck(tf_id.getText(), tf_pw.getText());
				loginpwcheck = dao.loginpwCheck(id, pwd);
				if (id.equals(loginidcheck) && pwd.equals(loginpwcheck)) {
					GeneralMember gn = new GeneralMember();
					gn.setVisible(true);
				} else if (id.equals("admin") && pwd.equals("admin")) {
					Main Mainframe = new Main();
					String[] str = { "메인호출" };
					Mainframe.main(str);
				} else {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 잘못되었습니다.");
				}
			}
		});
	}

}
