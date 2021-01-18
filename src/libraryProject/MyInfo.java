package libraryProject;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import com.java.ex.dao.BookBorrowDAO;

public class MyInfo extends JPanel {
	public JTable table;

	public static String colNames[] = { "도서명", "빌린 날짜" };
	public static DefaultTableModel model = new DefaultTableModel(colNames, 0);

	Login login;

	public MyInfo() {

		String id = login.loginidcheck.toString();
		BookBorrowDAO dao = new BookBorrowDAO();
		String pw = dao.Selectpw(id);
		String name = dao.Selectname(id);
		String phone = dao.Selectphone(id);
		String email = dao.Selectemail(id);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(0, 0, 800, 34);
		add(panel);
		panel.setLayout(null);

		JLabel title = new JLabel("마이페이지");
		title.setFont(new Font("굴림", Font.BOLD, 20));
		title.setBounds(344, 10, 200, 19);
		panel.add(title);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 33, 783, 500);
		add(panel_1);

		JLabel lb_id = new JLabel("아이디");
		lb_id.setBounds(70, 50, 100, 21);
		panel_1.add(lb_id);

		JTextField tf_id = new JTextField(id);
		tf_id.setBounds(150, 50, 150, 21);
		panel_1.add(tf_id);
		tf_id.setEditable(false);

		JLabel lb_pw = new JLabel("비밀번호");
		lb_pw.setBounds(70, 100, 100, 21);
		panel_1.add(lb_pw);

		JTextField tf_pw = new JTextField(pw);
		tf_pw.setBounds(150, 100, 150, 21);
		panel_1.add(tf_pw);
		tf_pw.setEditable(false);

		JLabel lb_name = new JLabel("이름");
		lb_name.setBounds(70, 150, 100, 21);
		panel_1.add(lb_name);

		JTextField tf_name = new JTextField(name);
		tf_name.setBounds(150, 150, 150, 21);
		panel_1.add(tf_name);
		tf_name.setEditable(false);

		JLabel lb_phone = new JLabel("핸드폰번호");
		lb_phone.setBounds(70, 200, 100, 21);
		panel_1.add(lb_phone);

		JTextField tf_phone = new JTextField(phone);
		tf_phone.setBounds(150, 200, 150, 21);
		panel_1.add(tf_phone);
		tf_phone.setEditable(false);

		JLabel lb_email = new JLabel("이메일");
		lb_email.setBounds(70, 250, 100, 21);
		panel_1.add(lb_email);

		JTextField tf_email = new JTextField(email);
		tf_email.setBounds(150, 250, 150, 21);
		panel_1.add(tf_email);
		tf_email.setEditable(false);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(400, 50, 300, 250);
		panel_1.add(panel_2);

		JLabel lb_borrowlist = new JLabel("나의 도서 대출 현황");
		lb_borrowlist.setFont(new Font("굴림", Font.PLAIN, 20));
		lb_borrowlist.setBounds(60, 0, 200, 21);
		panel_2.add(lb_borrowlist);

		model = new DefaultTableModel(colNames, 0);
		table = new JTable(model);
		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBounds(0, 30, 300, 200);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		scrollPane_1.setViewportView(table);
		dao.Selectlist(model, id);
		panel_2.add(scrollPane_1);

	}
}
