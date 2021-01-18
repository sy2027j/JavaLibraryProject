package libraryProject;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.java.ex.dao.BookBorrowDAO;

public class GeneralMember extends JFrame{
	CardLayout card=new CardLayout();
	
	Login login;
	MemberModify md;
	
	public static void main(String[] args) {
		GeneralMember gn=new GeneralMember();
		gn.setVisible(true);
	}
	
	public GeneralMember() {
		setTitle("도서관");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 505);		
		
		setLayout(null);		
		
		JButton booksearch = new JButton("도서 검색");
		booksearch.setBounds(0, 0, 400, 49);
		add(booksearch);
		
		JButton myinfo = new JButton("마이페이지"); 
		myinfo.setBounds(400, 0, 400, 49);
		add(myinfo);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 48, 783, 419);
		panel.setLayout(card);
		
		panel.add(new BookSearch(),"1");
		panel.add(new MyInfo(),"2");
		add(panel);
		
		booksearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				card.show(panel,"1");
			}
		});		
		
		myinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				panel.setVisible(true);
				card.show(panel,"2");
				BookBorrowDAO dao= new BookBorrowDAO();
				String id=login.loginidcheck.toString();
				dao.Selectlist(MyInfo.model,id);
				
			}
		});	
		

	}
}
