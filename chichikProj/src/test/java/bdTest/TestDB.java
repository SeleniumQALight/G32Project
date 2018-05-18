package bdTest;

import libs.Database;
import libs.UtilsForDB;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TestDB {
    static Logger logger = Logger.getLogger(TestDB.class);
    static Database dbMySql;

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySql = new Database("MySQL_PADB_DB", "MySQL");
        logger.info("MySql DB connected");
    }

    @Test
    public void dataFromDbTest() throws SQLException, IOException, ClassNotFoundException {
        List<Map<String,String>> dataFromSeleniumTable =
                dbMySql.selectTable("select * from seleniumTable where login = 'taras'");
        logger.info("Result = " + dataFromSeleniumTable);
        logger.info("FirstPass = " + dataFromSeleniumTable.get(1));
       // int affectedRows = dbMySql.changeTable("INSERT INTO seleniumTable VALUES (2,'Slim','pass')");
       // logger.info("Affected rows = " + affectedRows);
        List<Map<String,String>> dataFromSeleniumTable_1 =
                dbMySql.selectTable("select * from seleniumTable where login = 'SlimShady'");
        logger.info("Result = " + dataFromSeleniumTable_1);

        UtilsForDB utilsForDB = new UtilsForDB();
        logger.info(utilsForDB.getPassForLogin("SlimShady"));


    }



    @After
    public void tearDown() throws SQLException {
        dbMySql.quit();
    }

}
