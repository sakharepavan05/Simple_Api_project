package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import BO.AddClients_BO;
import BO.Login_BO;







public class Login_DAO {
	public static Connection getConnection()
	   {
		   Connection con=null;
		   String url="jdbc:mysql://localhost:3306/codenera";
		   String user="root";
		   String pass="Pavan@143";
		   
		   try 
		   {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  con=DriverManager.getConnection(url,user,pass);
		   } 
		   catch(Exception e) 
		   {
			System.out.println(e);
		   }
		   return con;
	   }
	public static boolean Api_login(Login_BO lb)
	{
	   boolean result=false;
		
		try {
			String q="select * from login_users where username=? and password=?";
			Connection con=Login_DAO.getConnection();
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1,lb.getID());
			ps.setString(2,lb.getPassword());
			
			ResultSet rs=ps.executeQuery();
			result =rs.next();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	public static int insert(Login_BO lb)
	{
		int status=0;
		try {
			Connection con=Login_DAO.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into login_users(username,password) values(?,?)");
			ps.setString(1,lb.getID());
			ps.setString(2, lb.getPassword());
			
		status=ps.executeUpdate();	
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static List<Login_BO> getAllUsers()
	   {
		  
		   List<Login_BO> list=new ArrayList<Login_BO>();
		   String query="select * from login_users";
		   try
		   {
			   Connection con=Login_DAO.getConnection();
			   PreparedStatement ps=con.prepareStatement(query);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   Login_BO lb=new Login_BO();
				   lb.setKey(rs.getInt(1));
				   lb.setID(rs.getString(2));
				   lb.setPassword(rs.getString(3));
				   lb.setDate(rs.getString(4));
				  
				   
				  
				   list.add(lb);
			   }
		   } 
		   catch (Exception e) 
		   {
			System.out.println(e);
		   }
		   return list;
	   }
	public static int ClientEntity(AddClients_BO lb)
	{
		int status=0;
		try {
			Connection con=Login_DAO.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into clients(name,user_id,company,email,phone) values(?,?,?,?,?)");
			ps.setString(1,lb.getName());
			ps.setString(2,lb.getUser_ID());
			ps.setString(3,lb.getCompany());
			ps.setString(4,lb.getEmail());
			ps.setString(5,lb.getPhone());
			
		status=ps.executeUpdate();	
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static List<AddClients_BO> getAllClientUsers()
	   {
		  
		   List<AddClients_BO> list=new ArrayList<AddClients_BO>();
		   String query="select * from clients";
		   try
		   {
			   Connection con=Login_DAO.getConnection();
			   PreparedStatement ps=con.prepareStatement(query);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   AddClients_BO lb=new AddClients_BO();
				   lb.setId(rs.getString(1));
				   lb.setName(rs.getString(2));
				   lb.setUser_ID(rs.getString(3));
				   lb.setCompany(rs.getString(4));
				   lb.setEmail(rs.getString(5));
				   lb.setPhone(rs.getNString(6));
				   lb.setCreatedAt(rs.getString(7));
				   lb.setUpdatedAt(rs.getString(8));
				   lb.setDeletedAt(rs.getString(9));
				   lb.setActive(rs.getBoolean(10));
				   
				  
				   list.add(lb);
			   }
		   } 
		   catch (Exception e) 
		   {
			System.out.println(e);
		   }
		   return list;
	   }
	 public static int delete(String id)
	   {
		   int status =0;
		    String query="delete from clients where id=?";
		    try
		    {
		    	Connection con=Login_DAO.getConnection();
		    	PreparedStatement ps=con.prepareStatement(query);
		    	ps.setString(1, id);
		    	status =ps.executeUpdate();
		    	ps.close();
		    	
		    }
		    catch(Exception e)
		    {
		    	System.out.println(e);
		    }
		    return status;
	   }
	 public static int update(AddClients_BO e)
	   {
		   int status =0;
		   String query="update clients set name=?,user_id=?,company=?,email=?,phone=? where id=?";
		  try 
		  {
			   Connection con=Login_DAO.getConnection();
			   PreparedStatement ps=con.prepareStatement(query);
			    ps.setString(1,e.getName());
				ps.setString(2,e.getUser_ID());
				ps.setString(3,e.getCompany());
				ps.setString(4,e.getEmail());
				ps.setString(5,e.getPhone());
				ps.setString(6,e.getId());
			   status =ps.executeUpdate();
			   con.close();
		  } 
		  catch (Exception e2) 
		  {
			System.out.println(e2);
		  }
		  return status;
	   }
	 public static AddClients_BO getEmployeeById(String id)
	   {
		 AddClients_BO lb=new AddClients_BO();
		  try 
		  {
			  Connection con =Login_DAO.getConnection();
			  PreparedStatement ps=con.prepareStatement("select *from clients where id=?");
			  ps.setString(1, id);
			  ResultSet rs=ps.executeQuery();
			  if(rs.next())
			  {
				   lb.setId(rs.getString(1));
				   lb.setName(rs.getString(2));
				   lb.setUser_ID(rs.getString(3));
				   lb.setEmail(rs.getString(5));
				   lb.setPhone(rs.getString(6));
				   
			  }
			  con.close();
			  
		  } 
		  catch (Exception e) 
		  {
			System.out.println(e);
		  }
		  return lb;
	   }
	 /*CREATE TABLE Login_Users (
       id INT AUTO_INCREMENT PRIMARY KEY,
       username VARCHAR(50) NOT NULL,
        password VARCHAR(100) NOT NULL,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        UNIQUE (username));
      */
	 /*CREATE TABLE  Clients (
     id INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     user_id VARCHAR(50),
     company VARCHAR(50) NOT NULL,
     email VARCHAR(255) UNIQUE,
     phone VARCHAR(20) NOT NULL,
     createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE     CURRENT_TIMESTAMP,
     deletedAt TIMESTAMP,
     active BOOLEAN DEFAULT TRUE
    );
    */



}
