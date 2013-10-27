package cn.edu.nju.software.demo.model;

/**
 * 
 * @author Cancy
 * Score is the model to store the score of certain class for certain student
 */
public class Score {
	private String number;
	private double garde;
	
	public void setNumber(String number){
		this.number=number;
	}
	
	public String getNumber(){
		return this.number;
	}
	
	public void setGarde(double garde){
		this.garde=garde;
	}
	
	public double getGarde(){
		return this.garde;
	}
	
	

}
