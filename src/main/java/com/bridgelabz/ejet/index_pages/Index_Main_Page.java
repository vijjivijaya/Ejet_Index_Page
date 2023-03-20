package com.bridgelabz.ejet.index_pages;

import com.bridgelabz.ejet.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class Index_Main_Page extends BaseClass {
    @FindBy (partialLinkText = "Click Here to Register!")
    WebElement click_here;
    @FindBy(xpath = "//span[contains(text(),'Register Below To Know More!')]")
    WebElement unique_element;
    @FindBy(id="cta-apply")
    WebElement apply_now_btn;
//    @FindBy(xpath = "//button[text()='Let's Chat']")
//    WebElement lets_chat;
//    @FindBy (xpath = "//span[contains(text(),'Click to attend orientation')]")
//    WebElement attend_orientation_popup;

    public Index_Main_Page(WebDriver driver) throws IOException {
        super();
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public Lateral_Page click_To_Register() throws InterruptedException {
        click_here.click();
        Thread.sleep(3000);
        String parentId = driver.getWindowHandle();
        Thread.sleep(3000);
        System.out.println("The current window id is: " + parentId);
        Set<String> allWindowID = driver.getWindowHandles();
        System.out.println("The all window id's are: " + allWindowID);
        int count = allWindowID.size();
        System.out.println("The number of windows opened by selenium are: " + count);
        for (String windowHandle : allWindowID) {
            driver.switchTo().window(windowHandle);
            String title = driver.getTitle();
            System.out.println("The title is :" + title);
            if (windowHandle.equals(parentId)) {
                driver.close();
            }
        }
            unique_element.isDisplayed();
            return new Lateral_Page(driver);
        }
    public RegisterWebsiteUser_Page click_On_Apply_Now() throws InterruptedException, IOException {
        apply_now_btn.click();
        Thread.sleep(3000);
        return new RegisterWebsiteUser_Page(driver);
    }
    public Webinar_Page click_Attend_Orientation_Button() throws InterruptedException {
//      wait.until(ExpectedConditions.visibilityOfElementLocated((By)attend_orientation_popup));
        String parentId = driver.getWindowHandle();
        Thread.sleep(3000);
        System.out.println("The current window id is: " + parentId);
        WebElement Attend_orientation = new WebDriverWait(driver, Duration.ofMinutes(2))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Click to attend orientation')]")));
        Attend_orientation.click();
        Thread.sleep(30000);
        Set<String> allWindowID = driver.getWindowHandles();
        System.out.println("The all window id's are: " + allWindowID);
        int count = allWindowID.size();
        System.out.println("The number of windows opened by selenium are: " + count);
        for (String windowHandle : allWindowID) {
            driver.switchTo().window(windowHandle);
//            String title = driver.getTitle();
//            System.out.println("The title is :" + title);
            if (windowHandle.equals(parentId)) {
                driver.close();
            }
        }
        return new Webinar_Page(driver);
    }
}
