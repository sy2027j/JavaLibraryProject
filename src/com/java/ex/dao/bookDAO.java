package com.java.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.java.ex.dto.bookDTO;

public class bookDAO {

	Statement st = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	String query=null;

	private Connection getConnection() {
		String driver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/testbase";
		String user = "root";
		String pwd = "apmsetup";
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return conn;
	}


	public void insertBook(bookDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		query="insert into book(BOOK_CODE,BOOK_STOCK,BOOK_NAME,BOOK_AUTHOR,BOOK_COMPANY) values (?,?,?,?,?)";
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, dto.getBOOK_CODE());
			pstmt.setInt(2, dto.getBOOK_STOCK());
			pstmt.setString(3, dto.getBOOK_NAME());
			pstmt.setString(4, dto.getBOOK_AUTHOR());
			pstmt.setString(5, dto.getBOOK_COMPANY());
			int result = pstmt.executeUpdate();
			
			if (1 == result) {
				JOptionPane.showMessageDialog(null, "도서가 등록되었습니다.", "도서관리", JOptionPane.INFORMATION_MESSAGE);
				conn.commit();
			}
			else {
				JOptionPane.showMessageDialog(null, "도서가 등록되지않았습니다.", "도서관리", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			System.out.println(e);
			try {conn.rollback();} catch (SQLException e2) {}
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
			if (conn != null) try {conn.close();} catch (Exception e) {}
		}
	}

	public int deleteBook(bookDTO dto) {
		Connection conn = getConnection();
		query=" delete from book where BOOK_NAME=?";
		int row = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getBOOK_NAME());
			row = pstmt.executeUpdate();
			
			if (1 == row) {
				JOptionPane.showMessageDialog(null, "도서가 삭제되었습니다.", "도서관리", JOptionPane.INFORMATION_MESSAGE);
				conn.commit();
			}
			else {
				JOptionPane.showMessageDialog(null, "도서가 삭제되지않았습니다.", "도서관리", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
			if (conn != null) try {conn.close();} catch (Exception e) {}
		}
		return row;
	}

	public void SelectAll(DefaultTableModel t_model) {
		Connection conn = getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from book");

			for (int i = 0; i < t_model.getRowCount();) {
				t_model.removeRow(0);
			}

			while (rs.next()) {
				Object data[] = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) };
				t_model.addRow(data);
			}
		} catch (SQLException e) {
			System.out.println(e + "SelectAll fail");
		}
	}
	
	

	public void select(DefaultTableModel t_model, String text, String ch) {
		Connection conn = getConnection();
		if (ch == "출판사") {
			query="select BOOK_CODE,BOOK_STOCK,BOOK_NAME,BOOK_AUTHOR,BOOK_COMPANY from book where BOOK_COMPANY=?";
		} else if (ch.equals("저자")) {
			query="select BOOK_CODE,BOOK_STOCK,BOOK_NAME,BOOK_AUTHOR,BOOK_COMPANY from book where BOOK_AUTHOR=?";
		} else if (ch == "도서명") {
			query="select BOOK_CODE,BOOK_STOCK,BOOK_NAME,BOOK_AUTHOR,BOOK_COMPANY from book where BOOK_NAME=?";
		} 
		try {
			if (ch == "ALL") {
				query = "select * from book";
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				for (int i = 0; i < t_model.getRowCount();) {
					t_model.removeRow(0);
				}
				while (rs.next()) {
					Object data[] = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) };

					t_model.addRow(data);
				}
			}
			else {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, text);
				rs = pstmt.executeQuery();
				for (int i = 0; i < t_model.getRowCount();) {
					t_model.removeRow(0);
				}
				while (rs.next()) {
					Object data[] = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) };

					t_model.addRow(data);
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
		}
	}
}