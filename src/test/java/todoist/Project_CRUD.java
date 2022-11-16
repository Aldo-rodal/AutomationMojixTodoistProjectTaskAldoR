package todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Date;


public class Project_CRUD extends TestBaseTodoist {
    @Test
    public void todolyCRUD() throws InterruptedException {
        String projectCreate = "Mojix" + new Date().getTime();
        String projectUpdate;

        HomePage.loginButtontodoist.click();
        Thread.sleep(3000);
        LoginPage.emailTxtbox.setText(user);
        LoginPage.passwordTxtbox.setText(password);
        LoginPage.loginButton.click();
        Thread.sleep(3000);
//        Assertions.assertTrue(MainPageTodoist.upcoming.isControlDisplayed(), "ERROR login failed");

        MainPageTodoist.plusProjectButton.click();
        Thread.sleep(3000);
        MainPageTodoist.projectName.setText(projectCreate);
        Thread.sleep(3000);
        MainPageTodoist.submitButton.click();
        Thread.sleep(3000);
        Assertions.assertTrue(MainPageTodoist.isProjectCreated(projectCreate),"ERROR! Project was not created");

        MainPageTodoist.projectOptions(projectCreate).click();
        Thread.sleep(3000);
        MainPageTodoist.editButton.click();
        Thread.sleep(3000);
        projectUpdate = "Abel Update " + new Date().getTime();
        Thread.sleep(3000);
        MainPageTodoist.projectName.cleanSetText(projectUpdate);
        Thread.sleep(3000);
        MainPageTodoist.submitButton.click();
        Thread.sleep(3000);
        Assertions.assertTrue(MainPageTodoist.isProjectCreated(projectUpdate),"ERROR! Project was not updated");


        MainPageTodoist.projectOptions(projectUpdate).click();
        Thread.sleep(3000);
        MainPageTodoist.optionsDelete.click();
        Thread.sleep(3000);
        MainPageTodoist.submitButton.click();
        Thread.sleep(3000);
        Assertions.assertFalse(MainPageTodoist.isProjectCreated(projectUpdate),"ERROR! Project was not deleted");





    }
}
