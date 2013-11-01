package cn.edu.nju.software.demo.dao.impl;

import cn.edu.nju.software.demo.dao.DaoHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author Cancy
 * 
 *
 */
public class DaoHelperImpl implements DaoHelper {
	
    private static DaoHelperImpl baseDao=new DaoHelperImpl();
    
    private String user;
	
	private String password;
	
	private String url;
	
	private String driver;
	
	private ConnectionPool pool;
			
	private DaoHelperImpl(){
		
	   try {
		   
			BufferedReader br = new BufferedReader(new FileReader(new File("src/main/resources/db.ini")));
			
			user = br.readLine();
			password = br.readLine();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("db.int not found");
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("read from db.int exception");
			e.printStackTrace();
		}
		
		url = "jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=GBK";
		driver = "com.mysql.jdbc.Driver";
		
		pool = new ConnectionPool(user, password, url, driver, 98);
		
	}
	
	public static DaoHelperImpl getBaseDaoInstance()
	{
		return baseDao;
	}

	public Connection getConnection() {
		// TODO Auto-generated method stub
		return pool.getDBConnection(1000);
	}

	public void closeConnection(Connection con) {
		// TODO Auto-generated method stub
		pool.freeDBConnection(con);
		
	}

	public void closePreparedStatement(PreparedStatement stmt) {
		// TODO Auto-generated method stub
		if(stmt!=null)
		{
			try
			{
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void closeResult(ResultSet result) {
		// TODO Auto-generated method stub
		if(result!=null)
		{
			try
			{
				result.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 
	 * @author Cancy
	 * inner class
	 * manage the connections
	 *
	 */
	public class ConnectionPool{
		
		private String dbUserName;
		private String dbPassWord;
		private String dbConnUrl;
		private String dbDriver;
		
		private int maxConn;
		private int checkedOut;
		
		private ArrayList<Connection> freeConn;
		
		public ConnectionPool(String dbUserName, String dbPassWord, String dbConnUrl, String dbDriver, int maxConn){
			super();
			this.dbUserName = dbUserName;
			this.dbPassWord = dbPassWord;
			this.dbConnUrl = dbConnUrl;
			this.dbDriver = dbDriver;
			this.maxConn = maxConn;
			this.freeConn = new ArrayList<Connection>();		
		}
		
		public synchronized Connection getDBConnection()
		{
			Connection conn=null;
			if(freeConn.size()>0)
			{
				conn=freeConn.get(0);
				freeConn.remove(0);
				try {
					if(conn.isClosed())
					{
						conn=getDBConnection();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}    
			}
			else if(maxConn==0 || checkedOut<maxConn)
			{
				conn=newDBConnection();
			}
	       
			if(conn!=null){
				checkedOut++;
			}
	       
			return conn;
		}
		
		public synchronized Connection getDBConnection(long timeout)
		{
			long starttime=System.currentTimeMillis();
			Connection conn = null;
	       
			while((conn=getDBConnection()) == null)
			{
				try {
					wait(timeout);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(System.currentTimeMillis()-starttime >= timeout)
				{
					return null;
				}
			}
			return conn;
		}
		
		private synchronized Connection newDBConnection()
		{
			Connection conn=null;
			try{
				if(this.dbUserName==null)
				{
					try {
						Class.forName(dbDriver);
						conn=DriverManager.getConnection(this.dbConnUrl);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
				}
				else
				{
					try {
						Class.forName(dbDriver);
						conn=DriverManager.getConnection(this.dbConnUrl,this.dbUserName,this.dbPassWord);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
				}
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			
			return conn;
		}
		
		public synchronized void freeDBConnection(Connection conn){
			if(conn != null)
			{
				freeConn.add(conn);
				checkedOut--;
				notifyAll(); 
			}
		}
		
		public synchronized void release(){
			Iterator<Connection> iter=freeConn.iterator();
			Connection conn;
			while(iter.hasNext()){
				try{
					conn=iter.next();
					conn.close();
				}catch(SQLException ex){
					ex.printStackTrace(); 
				}
			}
		
			while(iter.hasNext())
			{
				freeConn.remove(iter.next());
			}
		}
		
	}

	

	

}
