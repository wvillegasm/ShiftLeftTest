import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsEqual.*;
 
import gov.ssa.selenium.test.base.Config;
 
import java.util.Properties;
 
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class ConfigTest {
 
      private static final String MY_PORT = "9080";
      private static final String MY_LOCAL_HOST = "http://localhost";
      private Config instance;
 
      @BeforeClass
      public void setUp() {
 
            instance = Config.getInstance();
 
      }
 
      @Test
      public void verify_property_file() {
            // given my instance
 
            // then Property file exist
            assertThat(instance.p, is(notNullValue()));
      }
 
      @Test
      public void verify_web_driver_is_an_instance() {
            // given my instance
 
            // then WebDriver most be not null
            assertThat(instance.driver, is(notNullValue()));
      }
 
      @Test
      public void check_domain_and_port_config_test() {
            // given my prop file        
            String actualDomain = instance.p.get("wd.domain").toString();
            String actualPort = instance.p.get("wd.port").toString();
 
            // when I expecting domain and port
            String expectedDomain = MY_LOCAL_HOST;
            String expectedPort = MY_PORT;
 
            // then both exists and are equal to those what I am expecting
            assertThat(actualDomain, is(equalTo(expectedDomain)));
            assertThat(actualPort, is(equalTo(expectedPort)));
 
      }
}
