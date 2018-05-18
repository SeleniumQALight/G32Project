package suits;

import dbTest.TestDB;
import loginTest.LoginTestWithPageObject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import spareTest.AddNewSpareTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginTestWithPageObject.class,
                AddNewSpareTest.class,
        }
)
public class SuitSmoke {

}
