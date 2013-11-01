package cn.edu.nju.software.demo.controller.stub;

import cn.edu.nju.software.demo.controller.ScoreController;

/**
 * Created with IntelliJ IDEA.
 * User: ljj
 * Date: 13-11-1
 * Time: 下午8:29
 * To change this template use File | Settings | File Templates.
 */
public class ScoreControllerStub implements ScoreController {

    @Override
    public double calcScores(String start, String end) {
        return 0;
    }

    @Override
    public boolean addScores() {
        return true;
    }
}
