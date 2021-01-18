package libraryProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import com.java.ex.dao.bookDAO;

public class BookSearch extends JPanel{
	JTable table;

	public static String colNames[] = { "분류번호", "대출 가능 수량", "도서명", "저자", "출판사" };
	public static DefaultTableModel model = new DefaultTableModel(colNames, 0);


	public BookSearch() {
		setLayout(null);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.setBounds(0, 0, 790, 34);
		add(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("도서검색");
		label.setFont(new Font("굴림", Font.BOLD, 20));
		label.setBounds(340, 10, 88, 19);
		contentPane.add(label);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 33, 790, 43);
		add(panel_1);

		JComboBox choice = new JComboBox();
		choice.addItem("출판사");
		choice.addItem("저자");
		choice.addItem("도서명");
		choice.addItem("ALL");
		choice.setBounds(50, 10, 150, 21);
		panel_1.add(choice);

		JTextField textField = new JTextField();
		textField.setBounds(230, 10, 250, 21);
		panel_1.add(textField);
		textField.setColumns(10);

		JButton btselect = new JButton("검색");
		btselect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String ch=choice.getSelectedItem().toString();
				model.setRowCount(0); 			
				String text=textField.getText();
				bookDAO dao=new bookDAO();
				dao.select(model, text, ch);
			}});
		btselect.setBounds(525, 9, 97, 23);
		panel_1.add(btselect);
		
		JButton btborrow = new JButton("대출 신청");
		btborrow.setBounds(660,9,97,23);
		panel_1.add(btborrow);

		model = new DefaultTableModel(colNames, 0);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 74, 788, 338);
		table.getColumnModel().getColumn(0).setPreferredWidth(63);
		table.getColumnModel().getColumn(1).setPreferredWidth(33);
		table.getColumnModel().getColumn(2).setPreferredWidth(216);
		table.getColumnModel().getColumn(3).setPreferredWidth(59);
		table.getColumnModel().getColumn(4).setPreferredWidth(66);
		scrollPane.setViewportView(table);
		bookDAO dao = new bookDAO();
		dao.SelectAll(model);
		add(scrollPane);
		
		int row = table.getSelectedRow();
		
		btborrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				Object bookname = table.getValueAt(row, 2);
				new BookBorrow(bookname);

			}
		});
	}  
}