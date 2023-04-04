package com.bridgelabz.ejet.registerwebsiteuser_Test;

import com.bridgelabz.ejet.base.BaseClass;
import com.bridgelabz.ejet.registerwebsiteuser.Enter_Phone_Number;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class Enter_Phone_Number_Test extends BaseClass {
    Enter_Phone_Number phone_number;

    public Enter_Phone_Number_Test() throws IOException {
        super();
    }
    @BeforeTest
    public void setUp() throws IOException {
        initialization(prop.getProperty("RegisterwebsiteUserUrl"));
        phone_number = new Enter_Phone_Number(driver);
    }
    @Test
    public void new_Valid_Phone_Number() throws InterruptedException {
        boolean phn_tick = phone_number.valid_Phn_Number(prop.getProperty("Valid_Phn_Number"));
        Assert.assertTrue(phn_tick);

    }
    @Test
    public void empty_Phone_Number() throws InterruptedException {
        boolean msg=phone_number.invalid_Phn_Number(" ");
        System.out.println(msg);
        Assert.assertTrue(msg,"Invalid Phone Number");
    }
    @Test
    public void phn_No_With_Spl_Char() throws InterruptedException {
        boolean msg=phone_number.invalid_Phn_Number(prop.getProperty("Phn_Number_With_Spl_Char"));
        System.out.println(msg);
        Assert.assertTrue(msg,"Invalid Phone Number");
    }
    @Test
    public void phn_No_With_Char() throws InterruptedException {
        boolean msg=phone_number.invalid_Phn_Number(prop.getProperty("Phn_Number_With_Char"));
        System.out.println(msg);
        Assert.assertTrue(msg,"Invalid Phone Number");
    }
    @Test
    public void Phn_Number_With_Space() throws InterruptedException {
        boolean msg=phone_number.invalid_Phn_Number(prop.getProperty("Phn_Number_With_Space"));
        System.out.println(msg);
        Assert.assertTrue(msg,"Invalid Phone Number");
    }
    @Test
    public void Phn_Number_With_Plus_NinetyOne() throws InterruptedException {
        boolean msg=phone_number.invalid_Phn_Number(prop.getProperty("Phn_Number_With_plus_NinetyOne"));
        System.out.println(msg);
        Assert.assertTrue(msg,"Invalid Phone Number");
    }
    @Test
    public void nineDigit_Phn_Number() throws InterruptedException {
        boolean msg=phone_number.when_User_Remove_Invalid_Phn_No_From_Phn_Field(prop.getProperty("Nine_Digit_Phn_Number"));
        System.out.println(msg);
        Assert.assertTrue(msg,"Invalid Phone Number");
    }
    @Test
    public void new_User_Enter_InValid_Phn_No_And_Remove_Form_Phn_No_Field() throws InterruptedException {
        boolean msg=phone_number.when_User_Remove_Invalid_Phn_No_From_Phn_Field(prop.getProperty("Nine_Digit_Phn_Number"));
        System.out.println(msg);
        Assert.assertTrue(msg,"Phone Number Required");
    }
    @Test
    public void new_User_Enter_Valid_Phn_No_And_Remove_Form_Phn_No_Field() throws InterruptedException {
        boolean msg=phone_number.when_User_Remove_Valid_Phn_No_From_Phn_Field(prop.getProperty("Valid_Phn_Number"));
        System.out.println(msg);
        Assert.assertFalse(msg);
    }
    @AfterTest
       public void tearDown(){
        driver.close();
    }
}
