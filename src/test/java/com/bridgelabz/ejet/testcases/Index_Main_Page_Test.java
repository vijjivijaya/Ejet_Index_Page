package com.bridgelabz.ejet.testcases;

import com.bridgelabz.ejet.base.BaseClass;
import com.bridgelabz.ejet.index_pages.Index_Main_Page;
import com.bridgelabz.ejet.index_pages.Lateral_Page;
import com.bridgelabz.ejet.index_pages.RegisterWebsiteUser_Page;
import com.bridgelabz.ejet.index_pages.Webinar_Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Index_Main_Page_Test extends BaseClass {
    Index_Main_Page index_main_page;
    Lateral_Page lateral_page;
    Webinar_Page webinar_page;
    RegisterWebsiteUser_Page register_page;
    public Index_Main_Page_Test() throws IOException {
        super();
    }
    @BeforeMethod
    public void setup() throws IOException {
        launch_Index();
        index_main_page = new Index_Main_Page(driver);
        lateral_page = new Lateral_Page(driver);
    }
    @Test
    public void click_To_Register_And_Check_Nagigated_To_Lateral_Page() throws InterruptedException {
        lateral_page = index_main_page.click_To_Register();
        Thread.sleep(3000);
        String url = driver.getCurrentUrl();
        Thread.sleep(3000);
        Assert.assertEquals("https://bridgelabz.com/registerwebsitelateral?fc=Lateral&sc=WBS-LAT-WHN",url);
        
    }
    @Test
    public void click_On_Apply_Now_And_Check_Nagigated_To_RegisterWebsiteUser_Page() throws InterruptedException, IOException {
        register_page = index_main_page.click_On_Apply_Now();
        String title = driver.getTitle();
        System.out.println("The title of the page is:" +title);
        Assert.assertEquals("BridgeLabz: Guaranteed Emerging Tech Job",title);
    }
    @Test
    public void click_Attend_Orientation_Button_And_Check_Nagigated_To_Webinar_page() throws InterruptedException {
        webinar_page = index_main_page.click_Attend_Orientation_Button();
        String title = driver.getTitle();
        System.out.println("The title of the page is:" +title);
        Assert.assertEquals("BridgeLabz: Guaranteed Emerging Tech Job",title);
    }
    @AfterMethod
    public void tear_Down(){
        driver.close();
    }
}
