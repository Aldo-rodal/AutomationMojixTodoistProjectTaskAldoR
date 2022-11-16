package todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class Task_CRUD extends TestBaseTodoist{

    @Test
    public void todolyCRUD() throws InterruptedException {
        String projectCreate = "Mojix" + new Date().getTime();
        String taskCreate = "Mojix" + new Date().getTime();
        //Login
        HomePage.loginButtontodoist.click();
        Thread.sleep(3000);
        LoginPage.emailTxtbox.setText(user);
        LoginPage.passwordTxtbox.setText(password);
        LoginPage.loginButton.click();
        Thread.sleep(5000);
        Assertions.assertTrue(MainPageTodoist.upcoming.isControlDisplayed(), "ERROR login failed");

        //Create project

        MainPageTodoist.plusProjectButton.click();
        MainPageTodoist.projectName.setText(projectCreate);
        MainPageTodoist.submitButton.click();
        Thread.sleep(3000);
        Assertions.assertTrue(MainPageTodoist.isProjectCreated(projectCreate),"ERROR! Project was not created");

        //Create Task

        MainPageTodoist.addTaskButton.click();
        Thread.sleep(3000);
        MainPageTodoist.taskName.setText(taskCreate);
        MainPageTodoist.submitAddTaskButton.click();
        Thread.sleep(3000);
        Assertions.assertTrue(MainPageTodoist.isTaskCreated(taskCreate),"ERROR! Task was not created");

        //Update Task
        String taskUpdate = "Mojix" + new Date().getTime();
        Thread.sleep(1000);
        MainPageTodoist.taskOptions.click();
        MainPageTodoist.taskEdit.click();
        MainPageTodoist.taskName.cleanSetText(taskUpdate);
        MainPageTodoist.submitAddTaskButton.click();
        Thread.sleep(1000);
        Assertions.assertTrue(MainPageTodoist.isTaskCreated(taskUpdate),"ERROR! Task was not updated");

        //Delete Task
        MainPageTodoist.taskOptions.click();
        MainPageTodoist.taskDelete.click();
        MainPageTodoist.submitDeleteTask.click();
        Thread.sleep(1000);
        Assertions.assertFalse(MainPageTodoist.isTaskCreated(taskUpdate),"ERROR! Task was not deleted");


    }
}
