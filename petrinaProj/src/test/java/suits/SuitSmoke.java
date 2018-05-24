package suits;

import logintests.LoginTestWithPageObject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import spareTest.AddNewSpareTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginTestWithPageObject.class,
                AddNewSpareTest.class
        }
)
public class SuitSmoke {
}
