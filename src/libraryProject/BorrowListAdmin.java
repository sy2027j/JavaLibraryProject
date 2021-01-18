package libraryProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import com.java.ex.dao.BookBorrowDAO;

public class BorrowListAdmin extends JPanel{
	public static String colNames[] = { "¾ÆÀÌµð", "µµ¼­¸í", "ºô¸° ³¯Â¥", "ºô¸° ½Ã°¢" };
	public static DefaultTableModel model = new DefaultTableModel(colNames, 0);


	public BorrowListAdmin() {
		setLayout(null);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.setBounds(0, 0, 790, 34);
		add(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("µµ¼­ ¹Ý³³");
		label.setFont(new Font("±¼¸²", Font.BOLD, 20));
		label.setBounds(340, 10, 100, 19);
		contentPane.add(label);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 33, 790, 43);
		add(panel_1);

		JButton btreturn = new JButton("µµ¼­ ¹Ý³³");
		btreturn.setBounds(660,9,97,23);
		panel_1.add(btreturn);

		model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 74, 788, 338);
		table.getColumnModel().getColumn(0).setPreferredWidth(197);
		table.getColumnModel().getColumn(1).setPreferredWidth(197);
		table.getColumnModel().getColumn(2).setPreferredWidth(197);
		table.getColumnModel().getColumn(3).setPreferredWidth(197);
		scrollPane.setViewportView(table);
		BookBorrowDAO dao = new BookBorrowDAO();
		dao.SelectAll2(model);
		add(scrollPane);
		btreturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				Object bookname = table.getValueAt(row, 1);
				new BookReturn(bookname);

			}
		});
	}  
}