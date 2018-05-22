package dbTest;

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
        logger.info("mySQL DB connected");
    }

    @Test
    public void dataFromDBTest() throws SQLException, IOException, ClassNotFoundException {
       List<Map<String,String>> dataFromSeleniumTable =
               dbMySql.selectTable("select * from seleniumTable where Login = 'test'");
       logger.info(" Result = " + dataFromSeleniumTable);
       logger.info("FirstPass = " + dataFromSeleniumTable.get(1));
//       int effectedRowsdbMySql=dbMySql.changeTable("INSERT INTO seleniumTable VALUES (2,'Olena','pass')");
//       logger.info(" Effected = " + effectedRowsdbMySql);
        List<Map<String,String>> dataFromSeleniumTable_1 =
                dbMySql.selectTable("select * from seleniumTable where Login = 'Olena'");
        logger.info(" Result = " + dataFromSeleniumTable_1);

        UtilsForDB utilsForDB = new UtilsForDB();
        logger.info(utilsForDB.getPassForLogin("Olena"));
    }


    @After
    public void tearDown() throws SQLException {
        dbMySql.quit();
    }
}
