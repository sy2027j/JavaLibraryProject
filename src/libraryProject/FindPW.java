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

public class FindPW extends JFrame{

	public FindPW() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("PW ã��");
		setBounds(100, 100, 280, 270);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 251, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("��й�ȣ ã��");
		lblNewLabel_2.setBounds(90, 10, 90, 25);
		panel.add(lblNewLabel_2);
		
		JLabel memberid = new JLabel("���̵�");
		memberid.setBounds(27, 65, 57, 15);
		contentPane.add(memberid);
		
		JTextField tfid = new JTextField();
		tfid.setBounds(130, 65, 116, 21);
		contentPane.add(tfid);
		tfid.setColumns(10);
		
		JLabel membername = new JLabel("�̸�");
		membername.setBounds(27, 104, 70, 15);
		contentPane.add(membername);
		
		JTextField tfname = new JTextField();
		tfname.setBounds(130, 101, 116, 21);
		contentPane.add(tfname);
		tfname.setColumns(10);
		
		JLabel memberphone = new JLabel("�ڵ��� ��ȣ");
		memberphone.setBounds(27, 143, 70, 15);
		contentPane.add(memberphone);
		
		JTextField tfphone = new JTextField();
		tfphone.setBounds(130, 140, 116, 21);
		contentPane.add(tfphone);
		tfphone.setColumns(10);
		
		JButton btenter = new JButton("Ȯ��");
		btenter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id=tfid.getText();
				String name=tfname.getText();
				String phone=tfphone.getText();
				
					MemberDAO dao= new MemberDAO();
					MemberDTO dto= new MemberDTO();
					
					dto.setName(name);
					dto.setPhone(phone);
					dto.setId(id);
					dao.Findpw(id, name, phone);
					
			  		dispose();
			  		
			}
		});
		btenter.setBounds(20, 190, 97, 23);
		contentPane.add(btenter);
		
		JButton btcancel = new JButton("����ϱ�");
		btcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btcancel.setBounds(135, 190, 97, 23);
		contentPane.add(btcancel);
		
	}
	
}