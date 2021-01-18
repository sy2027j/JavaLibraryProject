package libraryProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.java.ex.dao.BookBorrowDAO;
import com.java.ex.dto.BookBorrowDTO;

public class BookReturn extends JFrame {
	Object bookname2;
	Login login;

	BookBorrowDAO dao = new BookBorrowDAO();

	public BookReturn(Object bookname2) {
		this.bookname2 = bookname2;

		BookBorrowDTO dto = new BookBorrowDTO();
		String id = login.loginidcheck.toString();
		dto.setCust_id(id);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 267, 343);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 257, 48);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel bookname = new JLabel("도서명");
		bookname.setBounds(27, 120, 57, 15);
		contentPane.add(bookname);

		JTextField tf_bookname = new JTextField();
		tf_bookname.setBounds(96, 120, 116, 21);
		contentPane.add(tf_bookname);
		tf_bookname.setText((String) bookname2);
		tf_bookname.setEditable(false);

		JLabel btnborrow = new JLabel("도서 반납");
		btnborrow.setBounds(98, 10, 98, 28);
		panel.add(btnborrow);

		JButton btenter = new JButton("반납하기");
		btenter.setBounds(20, 260, 97, 23);
		contentPane.add(btenter);

		JButton btcancel = new JButton("취소");
		btcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btcancel.setBounds(129, 260, 97, 23);

		btenter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Object name = bookname2;
				BookBorrowDTO dto = new BookBorrowDTO();
				BookBorrowDAO dao = new BookBorrowDAO();
				dto.setBOOK_NAME((String) bookname2);
				dao.plus(name);
				dao.deletelist(dto);
				dao.SelectAll2(BorrowListAdmin.model);
				dispose();

			}
		});

		setVisible(true);
	}

}