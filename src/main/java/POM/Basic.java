package POM;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class Basic {

    @BeforeClass
    public void setUpBrowser() {
        Browser.setup();
    }

    @AfterClass
    public void tearDownBrowser() {
        Browser.tearDown();
    }
}
