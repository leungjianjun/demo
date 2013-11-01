package cn.edu.nju.software.demo.dao.stub;

import java.util.ArrayList;

import cn.edu.nju.software.demo.dao.ScoreDao;
import cn.edu.nju.software.demo.model.Score;

public class ScoreDaoStub implements ScoreDao {

    public void save(Score score) {
        // TODO Auto-generated method stub

    }

    public Score find(String column, String value) {
        // TODO Auto-generated method stub
        Score s=new Score();
        s.setGarde(98.0);
        s.setNumber("091250008");
        return s;
    }

    public ArrayList<Score> findByRange(String start, String end) {
        // TODO Auto-generated method stub
        ArrayList<Score> list=new ArrayList<Score>();
        for(int i=0;i<Integer.parseInt(end)-Integer.parseInt(start);i++){
            Score temp=new Score();
            temp.setNumber(""+(Integer.parseInt(start)+i)+"");
            temp.setGarde(100*Math.random());
            list.add(temp);

        }
        return list;
    }

    public void update(Score score) {
        // TODO Auto-generated method stub

    }

}