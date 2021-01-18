package com.java.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.java.ex.dto.MemberDTO;

public class MemberDAO {
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	String query=null;
	public Connection getConnection()
	{
		String driver="org.mariadb.jdbc.Driver";
		String url="jdbc:mariadb://localhost:3306/testbase";
		String user="root";
		String pwd="apmsetup";
	      Connection conn=null;
	      
	      try{
	          Class.forName(driver);
	          conn=DriverManager.getConnection(url, user,pwd);

	       }catch(ClassNotFoundException e){
	          System.out.println(e);
	       }catch(SQLException e){
	          System.out.println(e);
	       }      
	       return conn;
	}
	public int insertMember(MemberDTO dto){
		
		Connection conn=getConnection();
		query=" insert into member1(cust_id, cust_pw, cust_name, cust_phone, cust_email)values(?,?,?,?,?)";
		int row=0;
		try{
	    	 pstmt=conn.prepareStatement(query);
	    	 pstmt.setString(1, dto.getId());
	    	 pstmt.setString(2, dto.getPw());
	    	 pstmt.setString(3, dto.getName());
	    	 pstmt.setString(4, dto.getPhone());
	    	 pstmt.setString(5, dto.getEmail());
	    	 
	    	 row=pstmt.executeUpdate();
	    	 
	    	 if (1 == row) {
					JOptionPane.showMessageDialog(null, "등록되었습니다.", "회원관리", JOptionPane.INFORMATION_MESSAGE);
					conn.commit();
				}
				else {
					JOptionPane.showMessageDialog(null, "등록에 실패했습니다.", "회원관리", JOptionPane.ERROR_MESSAGE);
				}
	     }catch(SQLException e)
	     {
	    	 System.out.println(e);
	     }finally{
	    	 if(pstmt!=null) try{pstmt.close();} catch(Exception e){}
	    	 if(conn!=null) try{conn.close();} catch(Exception e){}
	     }
	     return row;
	}
public int updateMember(MemberDTO dto){
		
		Connection conn=getConnection();
		query=" update member1 set cust_pw=?, cust_name=?,cust_phone=?,cust_email=? where cust_id=?";
		int row=0;
		try{
	    	 pstmt=conn.prepareStatement(query); 
	    	 pstmt.setString(1, dto.getPw());
	    	 pstmt.setString(2, dto.getName());
	    	 pstmt.setString(3, dto.getPhone());
	    	 pstmt.setString(4, dto.getEmail());
	    	 pstmt.setString(5, dto.getId());
	    	 
	    	 row=pstmt.executeUpdate();
	     }catch(SQLException e)
	     {
	    	 System.out.println(e);
	     }finally{
	    	 if(pstmt!=null) try{pstmt.close();} catch(Exception e){}
	    	 if(conn!=null) try{conn.close();} catch(Exception e){}
	     }
	     return row;
	}
public int deleteMember(MemberDTO dto){
	
	Connection conn=getConnection();
	query="delete from member1 where cust_name=?";
	int row=0;
	try{
    	 pstmt=conn.prepareStatement(query);    	
    	 pstmt.setString(1, dto.getName());	 
    	 row=pstmt.executeUpdate();
    	 
    	 if (1 == row) {
				JOptionPane.showMessageDialog(null, "삭제되었습니다.", "회원관리", JOptionPane.INFORMATION_MESSAGE);
				conn.commit();
			}
			else {
				JOptionPane.showMessageDialog(null, "삭제 실패했습니다.", "회원관리", JOptionPane.ERROR_MESSAGE);
			}
     }catch(SQLException e)
     {
    	 System.out.println(e);
     }finally{
    	 if(pstmt!=null) try{pstmt.close();} catch(Exception e){}
    	 if(conn!=null) try{conn.close();} catch(Exception e){}
     }
     return row;
}

	public String loginidCheck(String id, String pw) {
		Connection conn=getConnection();
		query="select cust_id,cust_pw from member1 where cust_id=? and cust_pw=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				query=rs.getString("cust_id");
			}
		}catch(Exception e) {
			System.out.println(e);
		}finally{
	         if(rs!=null) try{rs.close();}catch(Exception e){}
	         if(pstmt!=null)try{pstmt.close();}catch(Exception e){}
	         if(conn!=null)try{conn.close();}catch(Exception e){}
	         
	      }
		return query;
	}
	
	public String loginpwCheck(String id, String pw) {
		Connection conn=getConnection();
		query="select cust_id,cust_pw from member1 where cust_id=? and cust_pw=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				query=rs.getString("cust_pw");
			}
		}catch(Exception e) {
			System.out.println(e);
		}finally{
	         if(rs!=null) try{rs.close();}catch(Exception e){}
	         if(pstmt!=null)try{pstmt.close();}catch(Exception e){}
	         if(conn!=null)try{conn.close();}catch(Exception e){}
	         
	      }
		return query;
	}
	
	public String idcheck(String id){
		Connection conn=getConnection();
		String str="";
		query="select cust_id from member1 where cust_id=?";
		
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
	
	public void select(DefaultTableModel t_model){
			Connection conn=getConnection();
	       query="select cust_id,cust_pw,cust_name,cust_phone,cust_email from member1";
	       try{
	           st=conn.createStatement();
	           rs=st.executeQuery("select * from member1");
	           for (int i = 0; i < t_model.getRowCount();) {
					t_model.removeRow(0);
				}
				while (rs.next()) {
					Object data[] = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) };
					t_model.addRow(data);
				}
	       }catch(Exception e){
	           System.out.println(e.getMessage());
	       }finally{
	           try {
	               rs.close(); 
	               pstmt.close(); 
	               conn.close(); 
	           } catch (Exception e2) {}
	       }
	   }
	
	public String Findid(String name, String phone, String email) {
		Connection conn = getConnection();
		String str="";
		String query="select cust_id from member1 where cust_name=? and cust_phone=? and cust_email=?";
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,name);
			pstmt.setString(2, phone);
			pstmt.setString(3, email);
			rs=pstmt.executeQuery();
			while(rs.next()){
				str=rs.getString("cust_id");
			}
			if(str!=""){
			JOptionPane.showMessageDialog(null, "아이디는 "+str+" 입니다.", "ID 찾기", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "입력한 정보가 존재하지 않습니다. 다시 확인해주세요.", "ID 찾기", JOptionPane.INFORMATION_MESSAGE);
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
	
	public String Findpw(String id, String name, String phone) {
		Connection conn = getConnection();
		String str="";
		String query="select cust_pw from member1 where cust_id=? and cust_name=? and cust_phone=?";
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,id);
			pstmt.setString(2, name);
			pstmt.setString(3, phone);
			rs=pstmt.executeQuery();
			while(rs.next()){
				str=rs.getString("cust_pw");
			}
			if(str!=""){
				JOptionPane.showMessageDialog(null, "비밀번호는 "+str+" 입니다.", "PW 찾기", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "입력한 정보가 존재하지 않습니다. 다시 확인해주세요.", "PW 찾기", JOptionPane.INFORMATION_MESSAGE);
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
	
	public void select(DefaultTableModel t_model, String text, String ch){   
		   Connection conn = getConnection();
		   if(ch=="아이디")
		   {
			   query="select cust_id,cust_pw,cust_name,cust_phone,cust_email from member1 where cust_id=?";
		   }
		   else if(ch=="비밀번호")
		   {
			   query="select cust_id,cust_pw,cust_name,cust_phone,cust_email from member1 where cust_pw=?"; 
		   }
		   else if(ch=="이름")
		   {
			   query="select cust_id,cust_pw,cust_name,cust_phone,cust_email from member1 where cust_name=?"; 
		   }
		   else if(ch=="핸드폰번호")
		   {
			   query="select cust_id,cust_pw,cust_name,cust_phone,cust_email from member1 where cust_phone=?";  
		   }
		   try {
				if (ch == "ALL") {
					query = "select * from member1";
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
