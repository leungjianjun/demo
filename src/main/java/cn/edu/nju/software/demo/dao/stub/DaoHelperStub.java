package cn.edu.nju.software.demo.dao.stub;

import cn.edu.nju.software.demo.dao.DaoHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created with IntelliJ IDEA.
 * User: ljj
 * Date: 13-11-1
 * Time: 下午8:46
 * To change this template use File | Settings | File Templates.
 */
public class DaoHelperStub implements DaoHelper{
    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public void closeConnection(Connection con) {
    }

    @Override
    public void closePreparedStatement(PreparedStatement stmt) {
    }

    @Override
    public void closeResult(ResultSet result) {
    }
}
