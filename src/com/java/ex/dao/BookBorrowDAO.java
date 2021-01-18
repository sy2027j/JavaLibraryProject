package com.java.ex.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.java.ex.dto.BookBorrowDTO;

public class BookBorrowDAO {
	
	Calendar cal = new GregorianCalendar();
	Date date;
	Time time;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
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

	public int insertBook(BookBorrowDTO dto) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String query="insert into borrowlist values (?,?,?,?)";
		int row = 0;
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getCust_id());
			pstmt.setString(2, dto.getBOOK_NAME());
			pstmt.setDate(3, new Date(cal.getTimeInMillis()));
			pstmt.setTime(4, new Time(System.currentTimeMillis()));
			
			row = pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			System.out.println(e);
			try {conn.rollback();} catch (SQLException e2) {}
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
	
	public void SelectAll2(DefaultTableModel t_model) {
		Connection conn = getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from borrowlist");

			for (int i = 0; i < t_model.getRowCount();) {
				t_model.removeRow(0);
			}

			while (rs.next()) {
				Object data[] = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
				t_model.addRow(data);
			}
		} catch (SQLException e) {
			System.out.println(e + "SelectAll fail");
		}
	}
	

	public void Selectlist(DefaultTableModel t_model, String id) {
		Connection conn = getConnection();
		try {
			String query="select * from borrowlist where cust_id=?";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			for (int i = 0; i < t_model.getRowCount();) {
				t_model.removeRow(0);
			}

			while (rs.next()) {
				Object data[] = { rs.getString(2), rs.getString(3)};
				t_model.addRow(data);
			}
		} catch (SQLException e) {
			System.out.println(e + "SelectAll fail");
		}
	}
	
	public String Selectpw(String id) {
		Connection conn = getConnection();
		String str="";
		String query="select cust_pw from member1 where cust_id=?";
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				str=rs.getString("cust_pw");
			}
		}
		catch(SQLException e){
	         System.out.println(e);
	      }finally{
	         if(rs!=null) try{rs.close();}catch(Exception e){}
	         if(pstmt!=null)try{pstmt.close();}catch(Exception e){}
	         if(conn!=null)try{conn.close();}catch(Exception e){}
	         
	      }
		return str;
	}
	public String Selectname(String id) {
		Connection conn = getConnection();
		String str="";
		String query="select cust_name from member1 where cust_id=?";
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				str=rs.getString("cust_name");
			}
		}
		catch(SQLException e){
	         System.out.println(e);
	      }finally{
	         if(rs!=null) try{rs.close();}catch(Exception e){}
	         if(pstmt!=null)try{pstmt.close();}catch(Exception e){}
	         if(conn!=null)try{conn.close();}catch(Exception e){}
	         
	      }
		return str;
	}
	public String Selectphone(String id) {
		Connection conn = getConnection();
		String str="";
		String query="select cust_phone from member1 where cust_id=?";
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				str=rs.getString("cust_phone");
			}
		}
		catch(SQLException e){
	         System.out.println(e);
	      }finally{
	         if(rs!=null) try{rs.close();}catch(Exception e){}
	         if(pstmt!=null)try{pstmt.close();}catch(Exception e){}
	         if(conn!=null)try{conn.close();}catch(Exception e){}
	         
	      }
		return str;
	}
	
	public String Selectemail(String id) {
		Connection conn = getConnection();
		String str="";
		String query="select cust_email from member1 where cust_id=?";
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				str=rs.getString("cust_email");
			}
		}
		catch(SQLException e){
	         System.out.println(e);
	      }finally{
	         if(rs!=null) try{rs.close();}catch(Exception e){}
	         if(pstmt!=null)try{pstmt.close();}catch(Exception e){}
	         if(conn!=null)try{conn.close();}catch(Exception e){}
	         
	      }
		return str;
	}
	
	public String idcheck(String id){
		Connection conn=getConnection();
		String str="";
		String query="select cust_id from member1 where cust_id=?";
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				str=rs.getString("cust_id");
			}
		}
		catch(SQLException e){
	         System.out.println(e);
	      }finally{
	         if(rs!=null) try{rs.close();}catch(Exception e){}
	         if(pstmt!=null)try{pstmt.close();}catch(Exception e){}
	         if(conn!=null)try{conn.close();}catch(Exception e){}
	         
	      }
		return str;
	}
	
	   public void minus(Object name) {
		   Connection conn=getConnection();

	      String sql = "SELECT * FROM book WHERE BOOK_NAME = ?";
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, (String) name);
	         rs = pstmt.executeQuery();

	         if (rs.next()) {
	        	 String sql2 = "update book set BOOK_STOCK = BOOK_STOCK-1  where BOOK_NAME = ?";
	            if(rs.getString("BOOK_STOCK").equals("0")) {
	            	JOptionPane.showMessageDialog(null, "대출 신청 불가");
	            }else {
	            	 try {
	  	               pstmt = conn.prepareStatement(sql2);

	  	               pstmt.setObject(1, name);
	  	               int rs = pstmt.executeUpdate();
	  	              
	  	            } catch (SQLException e) {
	  	               e.getStackTrace();
	  	            }
	            }
	           
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public void plus(Object name) {
		   Connection conn=getConnection();

	      String sql = "SELECT * FROM book WHERE BOOK_NAME = ?";
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, (String) name);
	         rs = pstmt.executeQuery();

	         if (rs.next()) {
	        	 String sql2 = "update book set BOOK_STOCK = BOOK_STOCK+1  where BOOK_NAME = ?";
	            if(rs.getString("BOOK_STOCK").equals("0")) {
	            	JOptionPane.showMessageDialog(null, "대출 신청 불가");
	            }else {
	            	 try {
	  	               pstmt = conn.prepareStatement(sql2);

	  	               pstmt.setObject(1, name);
	  	               int rs = pstmt.executeUpdate();
	  	              
	  	            } catch (SQLException e) {
	  	               e.getStackTrace();
	  	            }
	            }
	           
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public int deletelist(BookBorrowDTO dto) {
			Connection conn = getConnection();
			String query=" delete from borrowlist where BOOK_NAME=?";
			int row = 0;
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, dto.getBOOK_NAME());
				row = pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
				if (conn != null) try {conn.close();} catch (Exception e) {}
			}
			return row;
		}
}