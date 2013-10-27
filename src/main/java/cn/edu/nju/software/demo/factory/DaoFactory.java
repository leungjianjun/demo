package cn.edu.nju.software.demo.factory;

import cn.edu.nju.software.demo.dao.ScoreDao;
import cn.edu.nju.software.demo.dao.impl.ScoreDaoImpl;



public class DaoFactory {
	
	public static ScoreDao getScoreDao(){
		return ScoreDaoImpl.getInstance();
	}


}
