package cn.edu.nju.software.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.nju.software.demo.dao.DaoHelper;
import cn.edu.nju.software.demo.dao.ScoreDao;
import cn.edu.nju.software.demo.model.Score;


/**
 * 
 * @author Cancy
 *
 */
public class ScoreDaoImpl implements ScoreDao {
	
	private static final String SCORE = "score";
	private static DaoHelper daoHelper= DaoHelperImpl.getBaseDaoInstance();
	private static ScoreDaoImpl scoreDao=new ScoreDaoImpl();
	
	public static ScoreDaoImpl getInstance(){
		return scoreDao;
	}

	public void save(Score score) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try {
			stmt=con.prepareStatement("insert into "+SCORE+"(number,garde) values(?,?,?)");
			stmt.setString(1, score.getNumber());
			stmt.setDouble(2, score.getGarde());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}

	}

	public Score find(String column, String value) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try {
			stmt=con.prepareStatement("select * from "+SCORE+" where "+column+"=?");
			stmt.setString(1,value);
			result=stmt.executeQuery();
			if(result.next()){
				Score score =new Score();
				score.setNumber(result.getString("number"));
				score.setGarde(result.getDouble("grade"));
				return score;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		return null;
	}

	public void update(Score score) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try {
			stmt=con.prepareStatement("update "+SCORE+" set number=?,grade=?");
			stmt.setString(1, score.getNumber());
			stmt.setDouble(2, score.getGarde());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}

	}

	public ArrayList<Score> findByRange(String start, String end) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		ArrayList<Score> scores =new ArrayList<Score>();
		try{
			stmt=con.prepareStatement("select * from "+SCORE+" where number >=? and number <=?");
			stmt.setString(1, start);
			stmt.setString(2, end);
			result=stmt.executeQuery();
			while(result.next()){
				Score score =new Score();
				score.setNumber(result.getString("number"));
				score.setGarde(result.getDouble("grade"));
				scores.add(score);
			}		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		return scores;
	}

}
