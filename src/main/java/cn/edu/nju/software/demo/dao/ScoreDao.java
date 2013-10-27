package cn.edu.nju.software.demo.dao;

import java.util.ArrayList;

import cn.edu.nju.software.demo.model.Score;


/**
 * 
 * @author Cancy
 * ScoreDao communicates with DB
 *
 */
public interface ScoreDao {
	
	 public void save(Score score);
	 
	 public Score find(String column,String value);
	 
	 public ArrayList<Score> findByRange(String start,String end);
	 
	 public void update(Score score);

}
