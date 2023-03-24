package com.bridgelabz.ejet.registerwebsiteuser_Test;

import com.bridgelabz.ejet.base.BaseClass;
import com.bridgelabz.ejet.registerwebsiteuser.Enter_Phone_Number;
import com.bridgelabz.ejet.registerwebsiteuser.Full_Name;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Full_Name_Test extends BaseClass {

    Full_Name name;
    public Full_Name_Test() throws IOException {
        super();
    }
    @BeforeMethod
    public void setUp() throws IOException {
        launch_RegisterwebsiteUser(prop.getProperty("RegisterwebsiteUserUrl"));
        name = new Full_Name(driver);
    }
    @Test
    public void valid_FullName_Test() throws InterruptedException {
        boolean msg = name.valid_FullName(prop.getProperty("valid_FullName"));
        Assert.assertFalse(msg);
    }
    @Test
    public void fullName_With_Special_Char_Test() throws InterruptedException {
        boolean msg = name.invalid_FullName(prop.getProperty("fullName_With_Special_Char"));
        Assert.assertTrue(msg,"Name must contain alphabetic only");
    }
    @Test
    public void fullName_With_Numeric_Value_Test() throws InterruptedException {
        boolean msg = name.invalid_FullName(prop.getProperty("fullName_With_Numeric_Value"));
        Assert.assertTrue(msg,"Name must contain alphabetic only");
    }
    @Test
    public void empty_FullName_Test() throws InterruptedException {
        boolean msg = name.invalid_FullName(" ");
        Assert.assertTrue(msg,"First Name Min 3 character required");
    }
    @Test
    public void only_Two_Char_FullName_Test() throws InterruptedException {
        boolean msg = name.invalid_FullName(prop.getProperty("only_Two_Char_FullName"));
        Assert.assertTrue(msg,"Please enter first & last name (min. 3 letters each) separated by a space.");
    }
    @Test
    public void only_Three_Char_FullName_Test() throws InterruptedException {
        boolean msg = name.invalid_FullName(prop.getProperty("only_Three_Char_FullName"));
        Assert.assertTrue(msg,"Please enter first & last name (min. 3 letters each) separated by a space.");
    }
    @Test
    public void three_Char_FirstName_And_Two_Char_LastName_Test() throws InterruptedException {
        boolean msg = name.invalid_FullName(prop.getProperty("three_Char_FirstName_And_Two_Char_LastName"));
        Assert.assertTrue(msg,"Please enter first & last name (min. 3 letters each) separated by a space.");
    }
    @Test
    public void fullName_Without_Space_Test() throws InterruptedException {
        boolean msg = name.invalid_FullName(prop.getProperty("fullName_Without_Space"));
        Assert.assertTrue(msg,"Please enter first & last name (min. 3 letters each) separated by a space.");
    }
    @Test
    public void space_After_LastName_Test() throws InterruptedException {
        boolean msg = name.invalid_FullName(prop.getProperty("space_After_LastName"));
        Assert.assertTrue(msg,"No space after first & last name");
    }
    @Test
    public void enter_And_Remove_Value_From_FullName_Test() throws InterruptedException {
        boolean msg = name.enter_And_Remove_Value_From_FullName(prop.getProperty("valid_FullName"));
        Assert.assertTrue(msg,"You must enter a Full Name");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
