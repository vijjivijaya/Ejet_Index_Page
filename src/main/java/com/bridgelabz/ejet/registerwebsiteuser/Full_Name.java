package com.bridgelabz.ejet.registerwebsiteuser;

import com.bridgelabz.ejet.base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;

public class Full_Name extends BaseClass {
    @FindBy(id="deftusername")
    WebElement full_name;
    @FindBy(id="deftuservalid")
    WebElement full_name_error;
    @FindBy(xpath="//p[text()='You must enter a Full Name']")
    WebElement fullname_error_msg1;
    @FindBy(xpath="//p[text()='First Name Min 3 character required']")
    WebElement fullname_error_msg2;
    @FindBy(xpath="//p[text()='Please enter first & last name (min. 3 letters each) separated by a space.']")
    WebElement fullname_error_msg3;
    @FindBy(xpath="//p[text()='Name must contain alphabetic only']")
    WebElement fullname_error_msg4;
    @FindBy(xpath="//p[text()='No space after fullname and character']")
    WebElement fullname_error_msg5;
    @FindBy(xpath="//p[text()='No space after first & last name']")
    WebElement fullname_error_msg6;

    public Full_Name(WebDriver driver) throws IOException, IOException {
        super();
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean valid_FullName(String valid_name) throws InterruptedException {
        full_name.sendKeys(valid_name);
        Thread.sleep(3000);
        String error_msg=full_name_error.getText();
        boolean value=false;
        if (error_msg.equals("You must enter a Full Name")) {
            value= fullname_error_msg1.isDisplayed();
        } else if (error_msg.equals("First Name Min 3 character required")) {
            value= fullname_error_msg2.isDisplayed();
        } else if (error_msg.equals("Please enter first & last name (min. 3 letters each) separated by a space.")) {
            value= fullname_error_msg3.isDisplayed();
        } else if (error_msg.equals("Name must contain alphabetic only")) {
            value= fullname_error_msg4.isDisplayed();
        } else if (error_msg.equals("No space after fullname and character")) {
            value= fullname_error_msg5.isDisplayed();
        } else if (error_msg.equals("No space after first & last name")) {
            value= fullname_error_msg6.isDisplayed();
        }
        full_name.clear();
        Thread.sleep(3000);
        return value;
    }
    public boolean invalid_FullName(String invalid_name) throws InterruptedException {
        full_name.sendKeys(invalid_name);
        Thread.sleep(3000);
        String error_msg=full_name_error.getText();
        boolean value=false;
        if (error_msg.equals("First Name Min 3 character required")) {
            value= fullname_error_msg2.isDisplayed();
        } else if (error_msg.equals("Please enter first & last name (min. 3 letters each) separated by a space.")) {
            value= fullname_error_msg3.isDisplayed();
        } else if (error_msg.equals("Name must contain alphabetic only")) {
            value= fullname_error_msg4.isDisplayed();
        } else if (error_msg.equals("No space after fullname and character")) {
            value= fullname_error_msg5.isDisplayed();
        } else if (error_msg.equals("No space after first & last name")) {
            value= fullname_error_msg6.isDisplayed();
        }
        full_name.clear();
        Thread.sleep(3000);
        return value;
    }
    public boolean enter_And_Remove_Value_From_FullName(String name) throws InterruptedException {
        full_name.sendKeys(name);
        Thread.sleep(5000);
        for (int i=0;i<name.length();i++){
            full_name.sendKeys(Keys.BACK_SPACE);
        }
        boolean  value = fullname_error_msg1.isDisplayed();
        return value;
    }
}

