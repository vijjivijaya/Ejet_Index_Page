package com.bridgelabz.ejet.experiencedengineers;

import com.bridgelabz.ejet.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;

public class Free_EBOOK_Page extends BaseClass {

    @FindBy(id = "FirstName")
    WebElement name;
    @FindBy(id = "Alert_Mandatory_FirstName")
    WebElement name_required;
    @FindBy(id = "EmailAddress")
    WebElement email;
    @FindBy(xpath = "//label[@id='Alert_Mandatory_EmailAddress']")
    WebElement email_required;
    @FindBy(xpath = "//label[@id='Alert_Valid_EmailAddress']")
    WebElement email_invalid;
    public Free_EBOOK_Page(WebDriver driver) throws IOException {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean valid_Name(String valid_name) throws InterruptedException {
        name.sendKeys(valid_name);
        String error_msg=name_required.getText();
        boolean value=false;
        if (error_msg.equals("You must enter a Full Name")) {
            value = name_required.isDisplayed();
        }
        name.clear();
        Thread.sleep(3000);
        return value;
    }
    public boolean invalid_Name(String invalid_name) throws InterruptedException {
        name.sendKeys(invalid_name);
        String error_msg=name_required.getText();
        boolean value=false;
        if (error_msg.equals("Required")) {
            value = name_required.isDisplayed();
        }
        name.clear();
        Thread.sleep(3000);
        return value;
    }
    public void valid_Email(String valid_email){
        email.sendKeys(valid_email);
    }
}
