package com.bridgelabz.ejet.registerwebsiteuser;

import com.bridgelabz.ejet.base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Email_Id extends BaseClass {
    @FindBy(id="deftemail")
    WebElement email_id;
    @FindBy(id="deftemailvalid")
    WebElement invalid_email;
    @FindBy(xpath="//p[text()='Email Required']")
    WebElement email_req;
    public Email_Id(WebDriver driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean valid_Email_Id(String valid_emailid) throws InterruptedException {
        email_id.sendKeys(valid_emailid);
        Thread.sleep(3000);
        String error_msg = invalid_email.getText();
        boolean value=false;
        if (error_msg.equals("Invalid Email")) {
            value= invalid_email.isDisplayed();

        } else if (error_msg.equals("Email Required")) {
            value= email_req.isDisplayed();
        }
        return value;
    }
    public boolean invalid_Email_Id(String valid_emailid) throws InterruptedException {
        email_id.sendKeys(valid_emailid);
        Thread.sleep(3000);
        String error_msg=invalid_email.getText();
        boolean value=invalid_email.isDisplayed();
        return value;
    }
    public boolean enter_And_Remove_EmailId(String valid_emailid) throws InterruptedException {
        email_id.sendKeys(valid_emailid);
        Thread.sleep(3000);
        for (int i=0;i<valid_emailid.length();i++){
            email_id.sendKeys(Keys.BACK_SPACE);
        }
        Thread.sleep(3000);
        String error_msg=invalid_email.getText();
        boolean value=email_req.isDisplayed();
        return value;
    }

}
