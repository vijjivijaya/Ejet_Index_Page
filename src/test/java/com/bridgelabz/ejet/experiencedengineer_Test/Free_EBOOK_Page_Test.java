package com.bridgelabz.ejet.experiencedengineer_Test;

import com.bridgelabz.ejet.base.BaseClass;
import com.bridgelabz.ejet.experiencedengineers.Experienced_Engineer_Page;
import com.bridgelabz.ejet.experiencedengineers.Free_EBOOK_Page;
import com.bridgelabz.ejet.experiencedengineers.RegisterWebsiteLateral_Page;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Free_EBOOK_Page_Test extends BaseClass {

    Experienced_Engineer_Page experienced_engineer_page;
    Free_EBOOK_Page free_ebook_page;
    RegisterWebsiteLateral_Page registerWebsiteLateral_page;
    public Free_EBOOK_Page_Test() throws IOException {
        super();
    }
    @BeforeTest
    public void setup() throws IOException, InterruptedException {
        initialization(prop.getProperty("Experienced_Engineer_Url"));
        experienced_engineer_page = new Experienced_Engineer_Page(driver);
        registerWebsiteLateral_page = new RegisterWebsiteLateral_Page(driver);
//        free_ebook_page = new Free_EBOOK_Page(driver);
        free_ebook_page = experienced_engineer_page.click_On_Download_Here_Button();
    }
    @Test
    public void valid_Name_Test() throws InterruptedException {
        boolean msg = free_ebook_page.valid_Name(prop.getProperty("name"));
        Assert.assertFalse(msg);
    }
    @Test
    public void invalid_Name_Test() throws InterruptedException {
        boolean msg = free_ebook_page.invalid_Name(prop.getProperty("name"));
        Assert.assertFalse(msg,"Required");
    }


}

