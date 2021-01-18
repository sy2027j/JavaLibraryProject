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

import com.java.ex.dao.BookBorrowDAO;
import com.java.ex.dao.MemberDAO;
import com.java.ex.dto.MemberDTO;

public class MemberModify extends JFrame {

	Login login;

	public MemberModify() {
		String id = login.loginidcheck.toString();
		BookBorrowDAO dao = new BookBorrowDAO();
		String pw = dao.Selectpw(id);
		String name = dao.Selectname(id);
		String phone = dao.Selectphone(id);
		String email = dao.Selectemail(id);
		setLayout(null);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 307, 383);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 300, 380);
		add(panel_1);
		
		JLabel lbupdate =new JLabel("내 정보 수정");
		lbupdate.setBounds(80,20,150,30);
		lbupdate.setFont(new Font("굴림", Font.PLAIN, 20));
		panel_1.add(lbupdate);

		JLabel lb_id = new JLabel("아이디");
		lb_id.setBounds(20, 70, 60, 21);
		panel_1.add(lb_id);

		JTextField tf_id = new JTextField(id);
		tf_id.setBounds(100, 70, 150, 21);
		panel_1.add(tf_id);
		tf_id.setEditable(false);

		JLabel lb_pw = new JLabel("비밀번호");
		lb_pw.setBounds(20, 110, 60, 21);
		panel_1.add(lb_pw);

		JTextField tf_pw = new JTextField(pw);
		tf_pw.setBounds(100, 110, 150, 21);
		panel_1.add(tf_pw);

		JLabel lb_name = new JLabel("이름");
		lb_name.setBounds(20, 150, 60, 21);
		panel_1.add(lb_name);

		JTextField tf_name = new JTextField(name);
		tf_name.setBounds(100, 150, 150, 21);
		panel_1.add(tf_name);

		JLabel lb_phone = new JLabel("핸드폰번호");
		lb_phone.setBounds(20, 190, 80, 21);
		panel_1.add(lb_phone);

		JTextField tf_phone = new JTextField(phone);
		tf_phone.setBounds(100, 190, 150, 21);
		panel_1.add(tf_phone);

		JLabel lb_email = new JLabel("이메일");
		lb_email.setBounds(20, 230, 60, 21);
		panel_1.add(lb_email);

		JTextField tf_email = new JTextField(email);
		tf_email.setBounds(100, 230, 150, 21);
		panel_1.add(tf_email);

		JButton update = new JButton("확인");
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String updateid = tf_id.getText();
				String updatepw = tf_pw.getText();
				String updatename = tf_name.getText();
				String updatephone = tf_phone.getText();
				String updateemail = tf_email.getText();

				MemberDTO dto = new MemberDTO();

				dto.setId(updateid);
				dto.setPw(updatepw);
				dto.setName(updatename);
				dto.setPhone(updatephone);
				dto.setEmail(updateemail);

				MemberDAO mdao = new MemberDAO();
				mdao.updateMember(dto);

				dispose();
			}
		});
		update.setBounds(40, 280, 97, 23);
		panel_1.add(update);

		JButton cancel = new JButton("취소");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancel.setBounds(140, 280, 97, 23);
		panel_1.add(cancel);

	}

}