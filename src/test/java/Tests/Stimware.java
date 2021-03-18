package Tests;


import Properties.SetPath;
import com.codeborne.selenide.WebDriverRunner;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pagefactory.PageFactoryStimwave;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.*;

public class Stimware {
    @BeforeClass
    void configurations() {
        //Configuration.headless=true;
        Configuration.browser = WebDriverRunner.FIREFOX;
        Configuration.reportsFolder = SetPath.Stimware();
    }
    @BeforeMethod
    void setup() {
        String baseUrl = "https://stimwavefreedom.com/";
        open(baseUrl);
    }
    @Test
    void Test1() throws Exception {
        PageFactoryStimwave contactForm = new PageFactoryStimwave();
        contactForm.contact();
        sleep(3000);
        screenshot("Steam");

    }
}
