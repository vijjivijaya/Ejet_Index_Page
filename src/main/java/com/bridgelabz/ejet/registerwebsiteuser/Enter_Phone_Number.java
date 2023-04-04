package com.bridgelabz.ejet.registerwebsiteuser;

import com.bridgelabz.ejet.base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;

public class Enter_Phone_Number extends BaseClass {
    @FindBy(id="deftphnumber")
    WebElement phn_no_text_field;
    @FindBy(id="defphicon")
    WebElement tick_icon;
    @FindBy(xpath="//p[text()='Invalid Phone Number']")
    WebElement invalid_phn_no_msg;
    @FindBy(xpath="//p[text()='Phone Number Required']")
    WebElement phn_no_req_msg;
    public Enter_Phone_Number(WebDriver driver) throws IOException {
        super();
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

public boolean valid_Phn_Number(String phn_no) throws InterruptedException {
    phn_no_text_field.sendKeys(phn_no);
    Thread.sleep(3000);
    boolean icon = tick_icon.isDisplayed();
    phn_no_text_field.clear();
    Thread.sleep(3000);
    return icon;
}
    public Boolean invalid_Phn_Number(String invalid_phn) throws InterruptedException {
        phn_no_text_field.sendKeys(invalid_phn);
        Thread.sleep(3000);
        boolean value= invalid_phn_no_msg.isDisplayed();
        phn_no_text_field.clear();
        Thread.sleep(3000);
        return value;
    }
    public Boolean when_User_Remove_Invalid_Phn_No_From_Phn_Field(String num) throws InterruptedException {
        phn_no_text_field.sendKeys(num);
        Thread.sleep(3000);
        for (int i=0;i<num.length();i++){
            phn_no_text_field.sendKeys(Keys.BACK_SPACE);
        }
        Thread.sleep(3000);
        boolean value= phn_no_req_msg.isDisplayed();
        return value;
    }
    public Boolean when_User_Remove_Valid_Phn_No_From_Phn_Field(String num) throws InterruptedException {
        phn_no_text_field.sendKeys(num);
        Thread.sleep(3000);
        for (int i=0;i<num.length();i++){
            phn_no_text_field.sendKeys(Keys.BACK_SPACE);
        }
        Thread.sleep(3000);
        boolean value= tick_icon.isDisplayed();
        return value;
    }


}






