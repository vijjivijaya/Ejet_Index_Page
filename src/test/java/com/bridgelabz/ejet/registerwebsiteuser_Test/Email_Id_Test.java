package com.bridgelabz.ejet.registerwebsiteuser_Test;

import com.bridgelabz.ejet.base.BaseClass;
import com.bridgelabz.ejet.registerwebsiteuser.Email_Id;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Email_Id_Test extends BaseClass {
    Email_Id email_id;

    public Email_Id_Test() throws IOException {
        super();
    }
    @BeforeMethod
    public void setUp() throws IOException {
        launch_RegisterwebsiteUser(prop.getProperty("RegisterwebsiteUserUrl"));
        email_id = new Email_Id(driver);
    }
    @Test
    public void valid_Email_Id_Test() throws InterruptedException {
        boolean msg=email_id.valid_Email_Id(prop.getProperty("valid_Email_Id"));
        Assert.assertFalse(msg);
    }
    @Test
    public void empty_Email_Id_Test() throws InterruptedException {
        boolean msg=email_id.invalid_Email_Id(" ");
        Assert.assertTrue(msg,"Invalid Email");
    }
    @Test
    public void email_Id_With_Space_Test() throws InterruptedException {
        boolean msg=email_id.invalid_Email_Id(prop.getProperty("email_Id_With_Space"));
        Assert.assertTrue(msg,"Invalid Email");
    }
    @Test
    public void invalid_Email_Id_Test() throws InterruptedException {
        boolean msg=email_id.invalid_Email_Id(prop.getProperty("invalid_Email_Id"));
        Assert.assertTrue(msg,"Invalid Email");
    }
    @Test
    public void space_After_Email_Id() throws InterruptedException {
        boolean msg=email_id.invalid_Email_Id(prop.getProperty("valid_Email_Id") + " ");
        Assert.assertTrue(msg,"Invalid Email");
    }
    @Test
    public void space_Before_Email_ID_Test() throws InterruptedException {
        boolean msg=email_id.invalid_Email_Id(" "+prop.getProperty("valid_Email_Id"));
        Assert.assertTrue(msg,"Invalid Email");
    }
    @Test
    public void email_Without_Dotcom_Test() throws InterruptedException {
        boolean msg=email_id.invalid_Email_Id(prop.getProperty("Email_Without_DotCom"));
        Assert.assertTrue(msg,"Invalid Email");
    }
    @Test
    public void email_Without_At_The_Rate_Test() throws InterruptedException {
        boolean msg=email_id.invalid_Email_Id(prop.getProperty("email_Without_At_The_Rate"));
        Assert.assertTrue(msg,"Invalid Email");
    }
    @Test
    public void enter_And_Remove_Email_Id_From_EmailField_Test() throws InterruptedException {
        boolean msg=email_id.enter_And_Remove_EmailId(prop.getProperty("valid_Email_Id"));
        Assert.assertTrue(msg,"Email Required");
    }
    @AfterMethod
   public void tearDown(){
        driver.close();
    }
}
