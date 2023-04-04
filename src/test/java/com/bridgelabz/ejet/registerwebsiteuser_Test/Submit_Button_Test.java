package com.bridgelabz.ejet.registerwebsiteuser_Test;

import com.bridgelabz.ejet.base.BaseClass;
import com.bridgelabz.ejet.registerwebsiteuser.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Submit_Button_Test extends BaseClass {
    Submit_Button submit_button;
    Enter_Phone_Number enter_phone_number;
    Full_Name full_name;
    Email_Id email_id;
    Educational_Qualification educational_qualification;
    Select_Year_Of_Passout select_year_of_passout;

    public Submit_Button_Test() throws IOException {
        super();
    }
    @BeforeMethod
    public void setUp() throws IOException {
        initialization(prop.getProperty("RegisterwebsiteUserUrl"));
        submit_button = new Submit_Button(driver);
        enter_phone_number = new Enter_Phone_Number(driver);
        full_name = new Full_Name(driver);
        email_id = new Email_Id(driver);
        educational_qualification = new Educational_Qualification(driver);
        select_year_of_passout = new Select_Year_Of_Passout(driver);
    }
    @Test
    public void click_Enable_EnterButton() throws InterruptedException {
        enter_phone_number.valid_Phn_Number(prop.getProperty("Valid_Phn_Number"));
        full_name.valid_FullName(prop.getProperty("valid_FullName"));
        email_id.valid_Email_Id(prop.getProperty("valid_Email_Id"));
        educational_qualification.education_Qualification(prop.getProperty("Engineering_Cs_Or_It"));
        select_year_of_passout.passOut_Year(prop.getProperty("Before_TwoThousandTwenty"));
        String value = submit_button.click_enable_Submit_Button();
        Assert.assertEquals(value.contains("actv"),true);
    }
    @Test
    public void click_Disable_Submit_Button_Test() throws InterruptedException{
        Thread.sleep(3000);
        String value = submit_button.click_Disable_Submit_Button();
        Assert.assertEquals(value.contains("actv"),false);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
