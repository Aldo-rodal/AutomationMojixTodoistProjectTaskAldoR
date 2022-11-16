package todoist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import structuredSelenium.session.Session;
import todoist.page_todoist.HomePage;
import todoist.page_todoist.LoginPage;
import todoist.page_todoist.MainPageTodoist;

public class TestBaseTodoist {
    HomePage HomePage = new HomePage();
    LoginPage LoginPage = new LoginPage();
    MainPageTodoist MainPageTodoist = new MainPageTodoist();
    String user = "rodriguezaldob+todoist@gmail.com";
    String password = "1234abcd";

    @BeforeEach
    public void openBrowser(){
        Session.getInstance().getBrowser().get("http://todoist.com");
    }

    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }
}
