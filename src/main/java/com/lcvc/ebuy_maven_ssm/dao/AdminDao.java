package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.util.SHA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDao {
	/**
	 * 根据账户名和密码去数据库查询，进行登录判断
	 * @param username 账户名
	 * @param password 密码
	 * @return 不为null表示登录成功,null表示登录失败
	 */
	public Admin login(String username,String password){
		Admin admin=null;//null表示登录状态
	/*	//对密码加密
		password = SHA.getResult(password);*/
		Connection conn=DBHelper.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			String sql="select * from admin where username=? and password=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			rs=pstmt.executeQuery();
			if(rs.next()){//如果能够从数据库找到记录
				admin=new Admin();
				admin.setId(rs.getInt("id"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setName(rs.getString("name"));
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBHelper.closeConn(conn,pstmt,rs);
		}
		return admin;
	}

	/**
	 *
	 * @param newPass
	 * @param id
	 * @return 更改了多少条记录
	 */
	public int updatePassword(String newPass,Integer id){
		//boolean result=false;
		int i=0;
		/*newPass=SHA.getResult(newPass);*/
		Connection conn=DBHelper.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="update admin set password=? where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,newPass);
			pstmt.setInt(2,id);
			i= pstmt.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBHelper.closeConn(conn,pstmt,rs);
		}

		return  i;
	}



	public static void main(String[] args) {
		AdminDao adminDao=new AdminDao();
	//	System.out.println(adminDao.login("admin", "123"));
	//	System.out.println(adminDao.login("user", "123"));
	//	System.out.println(adminDao.login("user", "123456"));
		//System.out.println(adminDao.updatePassword("666666",1));

	}
}
