package libraryProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.java.ex.dao.bookDAO;
import com.java.ex.dto.bookDTO;

public class BookAdd extends JFrame {

	String bnum[] = {"총류","철학","종교","사회과학","자연과학","기술과학","예술","언어","문학","역사"};

	public BookAdd() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 267, 343);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 251, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("도서등록");
		lblNewLabel_2.setBounds(96, 10, 66, 25);
		panel.add(lblNewLabel_2);
		
		JLabel booknum = new JLabel("분류번호");
		booknum.setBounds(27, 65, 57, 15);
		contentPane.add(booknum);
		
		JComboBox cbnum = new JComboBox<String>(bnum);
		cbnum.setBounds(96, 62, 116, 21);
		contentPane.add(cbnum);
		
		JLabel bookname = new JLabel("도서명");
		bookname.setBounds(27, 104, 57, 15);
		contentPane.add(bookname);
		
		JTextField tfname = new JTextField();
		tfname.setBounds(96, 101, 116, 21);
		contentPane.add(tfname);
		tfname.setColumns(10);
		
		JLabel bookauthor = new JLabel("저자명");
		bookauthor.setBounds(27, 143, 57, 15);
		contentPane.add(bookauthor);
		
		JTextField tfauthor = new JTextField();
		tfauthor.setBounds(96, 140, 116, 21);
		contentPane.add(tfauthor);
		tfauthor.setColumns(10);
		
		JLabel bookpub = new JLabel("출판사명");
		bookpub.setBounds(27, 181, 57, 15);
		contentPane.add(bookpub);
		
		JTextField tfpub = new JTextField();
		tfpub.setBounds(96, 181, 116, 21);
		contentPane.add(tfpub);
		tfpub.setColumns(10);
		
		JLabel book = new JLabel("재고");
		book.setBounds(27, 221,57,15);
		contentPane.add(book);
		
		JTextField tfbook=new JTextField();
		tfbook.setBounds(96,221,116,21);
		contentPane.add(tfbook);
		
		JButton btinsert = new JButton("등록하기");
		btinsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String bookname=tfname.getText();
				String author=tfauthor.getText();
				String publisher=tfpub.getText();
				String stock=tfbook.getText();
				int num=Integer.parseInt(stock);
				
					bookDTO dto=new bookDTO();
					String booknum=cbnum.getSelectedItem().toString();
					int index=0;
			
					if(booknum.equals("총류"))
						index=000;
					if(booknum.equals("철학"))
						index=100;
					if(booknum.equals("종교"))
						index=200;
					if(booknum.equals("사회과학"))
						index=300;
					if(booknum.equals("자연과학"))
						index=400;
					if(booknum.equals("기술과학"))
						index=500;
					if(booknum.equals("예술"))
						index=600;
					if(booknum.equals("언어"))
						index=700;
					if(booknum.equals("문학"))
						index=800;
					if(booknum.equals("역사"))
						index=900;
					
					dto.setBOOK_CODE(index);
					dto.setBOOK_STOCK(num);
					dto.setBOOK_NAME(bookname);
					dto.setBOOK_AUTHOR(author);
					dto.setBOOK_COMPANY(publisher);
					
					bookDAO dao=new bookDAO();
					dao.insertBook(dto);
					
			  		dispose();
			  		dao.SelectAll(BookAdmin.model);
			}
		});
		btinsert.setBounds(20, 260, 97, 23);
		contentPane.add(btinsert);
		
		JButton btcancel = new JButton("취소하기");
		btcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btcancel.setBounds(129, 260, 97, 23);
		contentPane.add(btcancel);
		
	}
	
}