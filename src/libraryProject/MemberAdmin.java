package libraryProject;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.java.ex.dao.MemberDAO;

public class MemberAdmin extends JPanel {
	JTable table;

	public static String colNames[] = { "아이디", "비밀번호", "이름", "번호", "이메일" };
	public static DefaultTableModel model;
	JScrollPane scrollPane;

	public MemberAdmin() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(0, 0, 800, 34);
		add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("회원관리");
		label.setFont(new Font("굴림", Font.BOLD, 20));
		label.setBounds(344, 10, 88, 19);
		panel.add(label);

		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0, 33, 783, 43);
		add(panel2);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "아이디", "비밀번호", "이름", "핸드폰번호", "ALL" }));
		comboBox.setBounds(50, 10, 85, 21);
		panel2.add(comboBox);

		JTextField textField = new JTextField();
		textField.setBounds(147, 10, 189, 21);
		panel2.add(textField);
		textField.setColumns(10);

		JButton btsearch = new JButton("조회");
		btsearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String ch = comboBox.getSelectedItem().toString();
				model.setRowCount(0);
				String text = textField.getText();
				MemberDAO dao = new MemberDAO();
				dao.select(model, text, ch);
			}
		});
		btsearch.setActionCommand("search");
		btsearch.setBounds(348, 9, 130, 23);
		panel2.add(btsearch);

		JButton btadd = new JButton("회원등록");
		btadd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MemberAdd mem = new MemberAdd();
				mem.setVisible(true);
			}
		});
		btadd.setBounds(500, 9, 130, 23);
		panel2.add(btadd);

		JButton btdel = new JButton("회원삭제");
		btdel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				Object membername = table.getValueAt(row, 2);
				new MemberDelete(membername);
			}
		});
		btdel.setBounds(642, 9, 130, 23);
		panel2.add(btdel);

		model = new DefaultTableModel(colNames, 0);
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 74, 783, 348);
		table.getColumnModel().getColumn(0).setPreferredWidth(63);
		table.getColumnModel().getColumn(1).setPreferredWidth(63);
		table.getColumnModel().getColumn(2).setPreferredWidth(186);
		table.getColumnModel().getColumn(3).setPreferredWidth(59);
		table.getColumnModel().getColumn(4).setPreferredWidth(66);
		scrollPane.setViewportView(table);
		MemberDAO dao = new MemberDAO();
		dao.select(model);
		add(scrollPane);
	}
}