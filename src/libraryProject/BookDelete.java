package libraryProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.java.ex.dao.bookDAO;
import com.java.ex.dto.bookDTO;



public class BookDelete extends JFrame{
	
	JPanel contentPane,panel;
	JLabel bookname;
	JTextField tfdelbookname;
	JLabel labeldelete;
	JButton btdelete, btcancel;
	
	Object bookname2;
	
	public BookDelete(Object bookname2) {
		this.bookname2 = bookname2;
		
		bookDTO dto=new bookDTO();
		
		setTitle("도서 삭제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 267, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 257, 48);
		contentPane.add(panel);
		panel.setLayout(null);

		labeldelete = new JLabel("도서 삭제");
		labeldelete.setBounds(100, 10, 66, 25);
		panel.add(labeldelete);
		
		bookname = new JLabel("도서명");
		bookname.setBounds(27, 70, 70, 15);
		contentPane.add(bookname);
		
		tfdelbookname = new JTextField();
		tfdelbookname.setBounds(104, 70, 116, 21);
		contentPane.add(tfdelbookname);
		tfdelbookname.setColumns(10);
		tfdelbookname.setText((String)bookname2);
		tfdelbookname.setEditable(false);
		
		btdelete = new JButton("삭제");
		btdelete.setBounds(20, 130, 97, 23);
		contentPane.add(btdelete);
		
		btcancel = new JButton("취소");
		btcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btcancel.setBounds(129, 130, 97, 23);
		contentPane.add(btcancel);
		
		btdelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Object name = bookname2;
				bookDTO dto=new bookDTO();
				bookDAO dao = new bookDAO();
				dto.setBOOK_NAME((String)bookname2);
				dao.deleteBook(dto);
				dao.SelectAll(BookAdmin.model);
				dispose();
				
			}
		});
		
		setVisible(true);
	}
}
