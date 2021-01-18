package libraryProject;

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

public class FindID extends JFrame {

	public FindID() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("ID 찾기");
		setBounds(100, 100, 280, 270);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 251, 45);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("아이디 찾기");
		lblNewLabel_2.setBounds(100, 10, 66, 25);
		panel.add(lblNewLabel_2);

		JLabel membername = new JLabel("이름");
		membername.setBounds(27, 65, 57, 15);
		contentPane.add(membername);

		JTextField tfname = new JTextField();
		tfname.setBounds(130, 65, 116, 21);
		contentPane.add(tfname);
		
		JLabel memberphone = new JLabel("핸드폰 번호");
		memberphone.setBounds(27, 104, 70, 15);
		contentPane.add(memberphone);

		JTextField tfphone = new JTextField();
		tfphone.setBounds(130, 101, 116, 21);
		contentPane.add(tfphone);

		JLabel memberemail = new JLabel("이메일");
		memberemail.setBounds(27, 143, 57, 15);
		contentPane.add(memberemail);

		JTextField tfemail = new JTextField();
		tfemail.setBounds(130, 140, 116, 21);
		contentPane.add(tfemail);

		JButton btenter = new JButton("확인");
		btenter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = tfname.getText();
				String phone = tfphone.getText();
				String email = tfemail.getText();

				MemberDAO dao = new MemberDAO();
				MemberDTO dto = new MemberDTO();

				dto.setName(name);
				dto.setPhone(phone);
				dto.setEmail(email);

				dao.Findid(name, phone, email);

				dispose();

			}
		});
		btenter.setBounds(20, 190, 97, 23);
		contentPane.add(btenter);

		JButton btcancel = new JButton("취소하기");
		btcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btcancel.setBounds(135, 190, 97, 23);
		contentPane.add(btcancel);

	}

}