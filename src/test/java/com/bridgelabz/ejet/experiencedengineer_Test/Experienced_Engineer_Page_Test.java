package com.bridgelabz.ejet.experiencedengineer_Test;

import com.bridgelabz.ejet.base.BaseClass;
import com.bridgelabz.ejet.experiencedengineers.Experienced_Engineer_Page;
import com.bridgelabz.ejet.experiencedengineers.Free_EBOOK_Page;
import com.bridgelabz.ejet.experiencedengineers.RegisterWebsiteLateral_Page;
import com.bridgelabz.ejet.index_pages.Index_Main_Page;
import com.bridgelabz.ejet.index_pages.Lateral_Page;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class Experienced_Engineer_Page_Test extends BaseClass {
    Experienced_Engineer_Page experienced_engineer_page;
    Free_EBOOK_Page free_ebook_page;
    RegisterWebsiteLateral_Page registerWebsiteLateral_page;

    public Experienced_Engineer_Page_Test() throws IOException {
        super();
    }
    @BeforeTest
    public void setup() throws IOException {
        initialization(prop.getProperty("Experienced_Engineer_Url"));
        experienced_engineer_page = new Experienced_Engineer_Page(driver);
        registerWebsiteLateral_page = new RegisterWebsiteLateral_Page(driver);
    }
    @Test
    public void click_To_Register_And_Check_Nagigated_To_Lateral_Page() throws InterruptedException {
        registerWebsiteLateral_page = experienced_engineer_page.click_To_Register();
        Thread.sleep(3000);
        String url = driver.getCurrentUrl();
        Thread.sleep(3000);
        Assert.assertEquals("https://bldev.bridgelabz.com/registerwebsitelateral?fc=Lateral&sc=WS-LTL-HME&utm_source=abc&utm_medium=efg&utm_campaign=lmn",url);
    }
    @Test
    public void click_On_Download_Here_Button_And_Check_Nagigated_To_Free_EBOOK_Page() throws InterruptedException, IOException {
        free_ebook_page = experienced_engineer_page.click_On_Download_Here_Button();
        Thread.sleep(3000);
        String url = driver.getCurrentUrl();
        Thread.sleep(3000);
        Assert.assertEquals("https://bridgelabz1.viewpage.co/free_ebook",url);
    }
    @AfterTest
    public void tear_Down(){
        driver.close();
    }
}

