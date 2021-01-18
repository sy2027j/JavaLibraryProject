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

public class MemberDelete extends JFrame {

	Object membername;

	public MemberDelete(Object membername) {
		this.membername = membername;

		setTitle("회원 삭제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 267, 243);
		JPanel panel1 = new JPanel();
		panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel1);
		panel1.setLayout(null);

		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 0, 257, 48);
		panel1.add(panel2);
		panel2.setLayout(null);

		JLabel btndel = new JLabel("회원 삭제");
		btndel.setBounds(100, 10, 66, 25);
		panel2.add(btndel);

		JLabel delname = new JLabel("이름");
		delname.setBounds(27, 70, 70, 15);
		panel1.add(delname);

		JTextField tfdelname = new JTextField();
		tfdelname.setBounds(104, 70, 116, 21);
		panel1.add(tfdelname);
		tfdelname.setColumns(10);
		tfdelname.setText((String) membername);
		tfdelname.setEditable(false);

		JButton btdelete = new JButton("삭제");
		btdelete.setBounds(20, 130, 97, 23);
		panel1.add(btdelete);

		JButton btcancel = new JButton("취소");
		btcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btcancel.setBounds(129, 130, 97, 23);
		panel1.add(btcancel);

		btdelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Object name = membername;
				MemberDTO dto = new MemberDTO();
				MemberDAO dao = new MemberDAO();
				dto.setName((String) membername);
				dao.deleteMember(dto);
				dao.select(MemberAdmin.model);
				dispose();

			}
		});

		setVisible(true);
	}
}
