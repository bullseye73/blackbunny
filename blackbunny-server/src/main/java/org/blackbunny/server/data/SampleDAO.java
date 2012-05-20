package org.blackbunny.server.data;

import org.apache.ibatis.session.SqlSession;
import org.blackbunny.data.DaoProxyFactory;
import org.blackbunny.data.MybatisDaoProxyFactoryImpl;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: leoincedo
 * Date: 5/15/12
 */

public class SampleDAO {

    DaoProxyFactory factory;
    SampleDBMapper mapper;

    public SampleDAO() {

        factory = new MybatisDaoProxyFactoryImpl( "sqlMapConfig.xml", "org.blackbunny.server.data" );
        mapper = factory.createDaoProxy( SampleDBMapper.class );

    }

    public void initDB() throws SQLException {

        Connection connection = factory.createConnection();
        Statement statement = connection.createStatement();

        try {
            String query = "DROP TABLE IF EXISTS USER;" +
                    "CREATE MEMORY TABLE USER (" +
                    "  UID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL PRIMARY KEY," +
                    "  ID varchar(255)," +
                    "  NICKNAME varchar(255) NOT NULL" +
                    ");";

            statement.execute( query );

            statement.execute( "insert into USER ( ID, NICKNAME ) values ( 'leo', 'SeongWooKim' );" );
            statement.execute( "insert into USER ( ID, NICKNAME ) values ( 'sar', 'SaRangKim' );" );
            statement.execute( "insert into USER ( ID, NICKNAME ) values ( 'bot1', 'Bot1' );" );
            statement.execute( "insert into USER ( ID, NICKNAME ) values ( 'bot2', 'Bot2' );" );
            statement.execute( "insert into USER ( ID, NICKNAME ) values ( 'bot3', 'Bot3' );" );
            statement.execute( "insert into USER ( ID, NICKNAME ) values ( 'bot4', 'Bot4' );" );
            statement.execute( "insert into USER ( ID, NICKNAME ) values ( 'bot5', 'Bot5' );" );
            statement.execute( "insert into USER ( ID, NICKNAME ) values ( 'bot6', 'Bot6' );" );
            statement.execute( "insert into USER ( ID, NICKNAME ) values ( 'bot7', 'Bot7' );" );
            statement.execute( "insert into USER ( ID, NICKNAME ) values ( 'bot8', 'Bot8' );" );
            statement.execute( "insert into USER ( ID, NICKNAME ) values ( 'bot9', 'Bot9' );" );


        } finally {
            statement.close();
            connection.commit();
            connection.close();
        }
    }

    public User getUser( String id )
    {
        return mapper.selectById( id );
    }

    public List<User> getUserList() {

        return mapper.selectAll();
    }
}
