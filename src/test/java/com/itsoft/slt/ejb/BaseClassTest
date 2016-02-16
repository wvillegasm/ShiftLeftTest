import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import gov.ssa.selenium.test.base.SelTestBase;
 
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
 
public class BaseClassTest extends SelTestBase {
 
                private static final String MY_LOCAL_DIRECTORY = "D:/ShiftLeftBBS/docs/";
                private static final String MY_LOCAL_HOST = "http://localhost:9080";
 
                @Test
                public void check_domain() {
                                // given my properties file with all the keys
                                String currentHost = getHost().toString();
 
                                // when I expect the complete domain:port
                                String expectedHost = MY_LOCAL_HOST;
 
                                // then the domain and port is equal to the URL that I am expecting
                                assertThat(currentHost, is(equalTo(expectedHost)));
 
                }
 
                @Test
                public void check_driver_path() {
                                // given
                                String driverPath = p.get("wd.driver.path");
 
                                // when
                                String expectedDriverPath = MY_LOCAL_DIRECTORY;
 
                                // then
                                assertThat(driverPath, is(equalTo(expectedDriverPath)));
                }
               
                @AfterClass
                public void afterTest() {
                                webDriver.quit();
                }
}
