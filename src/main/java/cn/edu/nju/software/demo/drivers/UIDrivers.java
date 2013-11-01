package cn.edu.nju.software.demo.drivers;

import cn.edu.nju.software.demo.controller.ScoreController;
import cn.edu.nju.software.demo.controller.impl.ScoreControllerImpl;
import junit.framework.Assert;


public class UIDrivers {

    public static void main(String args[]){
        ScoreController scoreController=new ScoreControllerImpl();
        Assert.assertEquals(scoreController.calcScores("081250087","081250090"),100);
    }
}
