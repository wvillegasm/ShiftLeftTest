import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringEndsWith.endsWith;
import gov.ssa.selenium.test.base.SelTestBase;
 
import java.util.Arrays;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class LoginTest extends SelTestBase {
 
      private static final String LOGIN_PAGE = "/shiftLeft/jsp/HomeAction";
 
      @BeforeClass
      public void beforeTest() {
            // given
            // My login URL: <<"/shiftLeft/jsp/HomeAction">>
            webDriver.get(getHost().append(LOGIN_PAGE).toString());
            webDriver.navigate();
      }
 
      @Test
      public void validate_server_status() {
            // given
            String pageNotFoundTitleText = "not found";
 
            // when
            String title = webDriver.getTitle().toLowerCase();
 
            // then
            assertThat(title, not(equalTo(pageNotFoundTitleText)));
      }
 
      @Test
      public void validate_that_current_url_page_corresponds_with_login_page() {
 
            // given
            String expectedURL = getHost().append(LOGIN_PAGE).toString();
 
            // when
            // get the page actual URL
            String actualURL = webDriver.getCurrentUrl();
 
            // then
            assertThat(actualURL, equalTo(expectedURL));
 
      }
 
      @Test
      public void check_error_msg_for_wrong_username_and_password_test() {
 
            // given -------------------------------------
            // wrong user, wrong password, and expected message error
            String wrongUser = "@XXXXX";
            String wrongPassword = "@XXXXX";
            String expectedErrorMsg = "Authetntication failure. Please check your username and/or password.";
 
            // when -------------------------------------
            // I attempt to login using wrong credentials
            captureData("username", wrongUser);
            clickElement("fake_pass");
            captureData("real_pass", wrongPassword);
            clickElement("submit_button");
 
            // getting errors
            WebElement el = webDriver
                        .findElement(By.id("authentication_fail_span"));
            WebElement actualErrorMsg = checkVisibilityofElement(el);
 
            // then -------------------------------------
            // Web page must show the error message:
            // "Authetntication failure. Please check your username and/or password."
            // YES, with mistyped word Authetntication!
            assertThat(actualErrorMsg.getText(), equalTo(expectedErrorMsg));
      }
 
      @Test
      public void check_error_msgs_when_blank_username_and_password() {
            // given -------------------------------------
            // blank user, blank password, and expected message
            String wrongUser = "";
            String wrongPassword = "";
            // String expectedUserErrMsg = "Username cannot be blank";
            // String expectedPassErrMsg = "Password cannot be blank";
 
            // when -------------------------------------
            // I attempt to login without capturing user name and password
            captureData("username", wrongUser);
            // captureData("fake_pass", wrongPassword);
            captureData("real_pass", wrongPassword);
            clickElement("submit_button");
 
            // getting errors
            WebElement el = webDriver.findElement(By.id("username_span"));
            WebElement actualUserErrMsg = checkVisibilityofElement(el);
 
            el = webDriver.findElement(By.id("password_span"));
            WebElement actualPassErrMsg = checkVisibilityofElement(el);
            List<String> errMsgs = Arrays.asList(actualUserErrMsg.getText(),
                        actualPassErrMsg.getText());
 
            // then -------------------------------------
            // Web page will has to show a message that field "cannot be blank" for
            // every text field
            assertThat(errMsgs, everyItem(endsWith(" cannot be blank")));          
      }
 
      @AfterClass
      public void afterTest() {
            webDriver.quit();
      }
 
}
