package libraryProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.java.ex.dao.MemberDAO;
import com.java.ex.dto.MemberDTO;

public class MemberAdd extends JFrame {

	public MemberAdd() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(700, 300, 580, 500);
		JPanel panel1 = new JPanel();
		panel1.setBorder(new EmptyBorder(0, 0, 10, 0));
		panel1.setLayout(null);
		setContentPane(panel1);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel.setBounds(0, 0, 577, 93);
		panel1.add(panel);
		panel.setLayout(null);

		JLabel labeljoin = new JLabel("회원가입");
		labeljoin.setFont(new Font("굴림", Font.BOLD, 20));
		labeljoin.setBounds(237, 27, 110, 44);
		panel.add(labeljoin);

		JLabel lbid = new JLabel("아이디");
		lbid.setBounds(74, 133, 57, 15);
		panel1.add(lbid);

		JTextField tf_id = new JTextField();
		tf_id.setBounds(190, 130, 116, 21);
		panel1.add(tf_id);

		JLabel lbpw = new JLabel("비밀번호");
		lbpw.setBounds(74, 176, 57, 15);
		panel1.add(lbpw);

		JTextField tf_pw = new JTextField();
		tf_pw.setBounds(190, 173, 116, 21);
		panel1.add(tf_pw);

		JLabel lbname = new JLabel("이름");
		lbname.setBounds(74, 219, 57, 15);
		panel1.add(lbname);

		JTextField tf_name = new JTextField();
		tf_name.setText("");
		tf_name.setBounds(190, 219, 116, 21);
		panel1.add(tf_name);

		JLabel lbphone = new JLabel("번호");
		lbphone.setBounds(74, 262, 57, 15);
		panel1.add(lbphone);

		JTextField tf_phone = new JTextField();
		tf_phone.setBounds(190, 262, 116, 21);
		panel1.add(tf_phone);

		JLabel lbemail = new JLabel("이메일");
		lbemail.setBounds(74, 305, 116, 15);
		panel1.add(lbemail);

		JTextField tf_email = new JTextField();
		tf_email.setText("");
		tf_email.setBounds(190, 305, 116, 21);
		panel1.add(tf_email);

		JButton btadd = new JButton("회원가입");
		btadd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String mID = tf_id.getText();
				String mPW = tf_pw.getText();
				String mPHONE = tf_phone.getText();
				String mEMAIL = tf_email.getText();
				String mNAME = tf_name.getText();

				MemberDTO dto = new MemberDTO();
				dto.setId(mID);
				dto.setPw(mPW);
				dto.setName(mNAME);
				dto.setPhone(mPHONE);
				dto.setEmail(mEMAIL);

				MemberDAO dao = new MemberDAO();
				int data = dao.insertMember(dto);
				System.out.println("입력자료:" + data);
				dispose();
				MemberAdmin.model.setRowCount(0);
				dao.select(MemberAdmin.model);
			}
		});

		btadd.setBounds(219, 370, 97, 23);
		panel1.add(btadd);

		JButton btcancel = new JButton("취소");
		btcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btcancel.setBounds(329, 370, 97, 23);
		panel1.add(btcancel);

		JLabel lbidcheck = new JLabel("");
		lbidcheck.setBounds(190, 155, 200, 15);
		panel1.add(lbidcheck);

		JButton idcheck = new JButton("중복확인");
		idcheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDAO dao = new MemberDAO();
				String str = dao.idcheck(tf_id.getText());
				if (tf_id.getText().equals(str)) {
					tf_id.requestFocus();
					tf_id.setText("");
					lbidcheck.setText("이미 존재하는 아이디입니다.");
				} else {
					lbidcheck.setText("사용 가능한 아이디입니다.");
				}
			}
		});
		idcheck.setBounds(318, 129, 86, 23);
		panel1.add(idcheck);
	}
}
