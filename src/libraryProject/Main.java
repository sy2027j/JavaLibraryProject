package libraryProject;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.CardLayout;

public class Main extends JFrame {
	CardLayout card=new CardLayout();
	
	public static void main(String[] args) {
					Main frame = new Main();					
					frame.setVisible(true);
			
	}

	public Main() {
		
		setTitle("도서관관리프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 505);		
		
		setLayout(null);		
		
		JButton addbt = new JButton("도서관리");
		addbt.setBounds(0, 0, 266, 49);
		add(addbt);
		
		JButton memberbt = new JButton("회원관리");
		memberbt.setBounds(266, 0, 266, 49);
		add(memberbt);
		
		JButton borrowlist=new JButton("대출 도서 관리");
		borrowlist.setBounds(532,0,267,49);
		add(borrowlist);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 48, 783, 419);
		panel.setLayout(card);
		
		panel.add(new BookAdmin(),"3");
		panel.add(new MemberAdmin(),"4");
		panel.add(new BorrowListAdmin(),"5");
		add(panel);
		
		
		addbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				card.show(panel,"3");
			}
		});		
		
		memberbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				panel.setVisible(true);
				card.show(panel,"4");
			}
		});	
		
		borrowlist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(true);
				card.show(panel, "5");
			}
		});
	}
}
