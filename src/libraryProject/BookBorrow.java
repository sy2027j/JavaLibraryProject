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

public class BookBorrow extends JFrame {

	Object bookname2;
	Login login;

	BookBorrowDAO dao = new BookBorrowDAO();

	public BookBorrow(Object bookname2) {
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

		JLabel userid = new JLabel("아이디");
		userid.setBounds(27, 117, 57, 15);
		contentPane.add(userid);

		JTextField tf_id = new JTextField(id);
		tf_id.setEnabled(false);
		tf_id.setBounds(96, 117, 116, 21);
		contentPane.add(tf_id);

		JLabel bookname = new JLabel("도서명");
		bookname.setBounds(27, 152, 57, 15);
		contentPane.add(bookname);

		JTextField tf_bookname = new JTextField();
		tf_bookname.setBounds(96, 152, 116, 21);
		contentPane.add(tf_bookname);
		tf_bookname.setText((String) bookname2);
		tf_bookname.setEditable(false);

		JLabel btnborrow = new JLabel("대출 신청");
		btnborrow.setBounds(98, 10, 98, 28);
		panel.add(btnborrow);

		JButton btenter = new JButton("대출하기");
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
				String id = login.loginidcheck.toString();
				dto.setCust_id(id);
				dto.setBOOK_NAME((String) bookname2);
				dao.insertBook(dto);
				dao.minus(name);
				dao.SelectAll(BookSearch.model);
				dispose();
			}
		});
		setVisible(true);
	}

}
