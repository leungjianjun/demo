package cn.edu.nju.software.demo.controller.impl;

import java.util.ArrayList;

import cn.edu.nju.software.demo.controller.ScoreController;
import cn.edu.nju.software.demo.factory.DaoFactory;
import cn.edu.nju.software.demo.model.Score;


/**
 * 
 * @author Cancy
 *
 */
public class ScoreControllerImpl implements ScoreController{
	
	public boolean addScores(){
		return false;
	}
	
	/**
	 * calculate the average
	 * @param classid
	 * @param start
	 * @param end
	 * @return
	 */
	public double calcScores(String start,String end){
		ArrayList<Score> scores=DaoFactory.getScoreDao().findByRange(start, end);
		int size=scores.size();
		if(size!=0){
			double total=0.00;
			for(int i=0;i<size;i++){
				total+=scores.get(i).getGarde();
			}
			return total/size;
		}
		return 0;
	}

	

}
