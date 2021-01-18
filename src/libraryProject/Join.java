package libraryProject;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.java.ex.dao.MemberDAO;
import com.java.ex.dto.MemberDTO;

public class Join extends JFrame {

	public Join() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(700, 300, 560, 480);
		JPanel panel1 = new JPanel();
		panel1.setBorder(new EmptyBorder(0, 0, 10, 0));
		panel1.setLayout(null);
		setContentPane(panel1);

		JPanel panel2 = new JPanel();
		panel2.setToolTipText("");
		panel2.setBounds(0, 0, 577, 93);
		panel1.add(panel2);
		panel2.setLayout(null);

		JLabel labeljoin = new JLabel("회원가입");
		labeljoin.setFont(new Font("굴림", Font.BOLD, 20));
		labeljoin.setBounds(220, 27, 110, 44);
		panel2.add(labeljoin);

		JLabel labelid = new JLabel("아이디");
		labelid.setBounds(74, 100, 57, 15);
		panel1.add(labelid);

		JTextField tf_id = new JTextField();
		tf_id.setBounds(190, 100, 116, 21);
		panel1.add(tf_id);
		tf_id.setColumns(10);

		JLabel labelpw = new JLabel("비밀번호");
		labelpw.setBounds(74, 146, 57, 15);
		panel1.add(labelpw);

		JTextField tf_pw = new JTextField();
		tf_pw.setBounds(190, 146, 116, 21);
		panel1.add(tf_pw);
		tf_pw.setColumns(10);

		JLabel labelname = new JLabel("이름");
		labelname.setBounds(74, 189, 57, 15);
		panel1.add(labelname);

		JTextField tf_name = new JTextField();
		tf_name.setText("");
		tf_name.setBounds(190, 189, 116, 21);
		panel1.add(tf_name);
		tf_name.setColumns(10);

		JLabel labelphone = new JLabel("번호");
		labelphone.setBounds(74, 232, 57, 15);
		panel1.add(labelphone);

		JTextField tf_phone = new JTextField();
		tf_phone.setBounds(190, 232, 116, 21);
		panel1.add(tf_phone);
		tf_phone.setColumns(10);

		JLabel labelemail = new JLabel("이메일");
		labelemail.setBounds(74, 275, 116, 15);
		panel1.add(labelemail);

		JTextField tf_email = new JTextField();
		tf_email.setText("");
		tf_email.setBounds(190, 275, 116, 21);
		panel1.add(tf_email);
		tf_email.setColumns(10);

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
				dao.insertMember(dto);
				dispose();

			}
		});

		btadd.setBounds(219, 340, 97, 23);
		panel1.add(btadd);

		JButton btcancel = new JButton("취소");
		btcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btcancel.setBounds(329, 340, 97, 23);
		panel1.add(btcancel);

		JLabel lbidcheck = new JLabel("");
		lbidcheck.setBounds(190, 125, 200, 15);
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
		idcheck.setBounds(318, 100, 86, 23);
		panel1.add(idcheck);
	}
}