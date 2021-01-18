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

public class BookAdmin extends JPanel {
	JTable table;
	JScrollPane scrollPane;
	public static String colNames[] = { "도서번호", "재고", "도서명", "저자", "출판사" };
	public static DefaultTableModel model = new DefaultTableModel(colNames, 0);

	public BookAdmin() {
		setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel1.setBounds(0, 0, 784, 34);
		add(panel1);
		panel1.setLayout(null);

		JLabel label = new JLabel("도서관리");
		label.setFont(new Font("굴림", Font.BOLD, 20));
		label.setBounds(340, 10, 88, 19);
		panel1.add(label);

		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0, 33, 790, 43);
		add(panel2);

		JComboBox choice = new JComboBox();
		choice.addItem("ALL");
		choice.addItem("출판사");
		choice.addItem("저자");
		choice.addItem("도서명");
		choice.setBounds(50, 10, 85, 21);
		panel2.add(choice);

		JTextField textField = new JTextField();
		textField.setBounds(147, 10, 230, 21);
		panel2.add(textField);
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
		btselect.setBounds(390, 9, 97, 23);
		panel2.add(btselect);

		JButton btadd = new JButton("도서등록");
		btadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookAdd be = new BookAdd();
				be.setVisible(true);
			}});
		btadd.setBounds(530, 9, 97, 23);
		panel2.add(btadd);

		JButton btdel = new JButton("삭제");
		btdel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				Object bookname = table.getValueAt(row, 2);
				new BookDelete(bookname);
			}});
		btdel.setBounds(655, 9, 97, 23);
		panel2.add(btdel);

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
	}   
	 
}