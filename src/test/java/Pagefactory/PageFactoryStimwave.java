package Pagefactory;


import Properties.SetPath;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.NoSuchElementException;
import utilities.RadInt;

public class PageFactoryStimwave {
    private ExtentReports report;
    ExtentTest test;


    public PageFactoryStimwave contact(){
        Configuration.reportsFolder = SetPath.Stimware();
        SelenideElement contactBtn = $(byText("Contact"));
        contactBtn.click();
        sleep(500);
        SelenideElement fname = $(byId("swcontactform-firstname"));
        fname.sendKeys("First");
        sleep(300);
        SelenideElement lname = $(byId("swcontactform-lastname"));
        lname.sendKeys("Last");
        sleep(300);
        SelenideElement city = $(byId("swcontactform-city"));
        city.sendKeys("City");
        sleep(300);
        SelenideElement state = $(byId("swcontactform-state"));
        state.sendKeys("State");
        sleep(300);
        SelenideElement zip = $(byId("swcontactform-zip"));
        zip.sendKeys("11111");
        sleep(300);
        SelenideElement email = $(byId("swcontactform-email"));
        email.sendKeys("email@gmail.com");
        sleep(300);
        SelenideElement phone = $(byId("swcontactform-phone"));
        phone.sendKeys("1231231235");
        sleep(300);
        SelenideElement selector = $(byId("swcontactform-pain_area"));
        selector.selectOptionByValue("2");
        sleep(300);
        SelenideElement referral = $(byId("swcontactform-referral"));
        referral.selectOptionByValue("4");
        sleep(300);
        switchTo().frame($x("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]"));
        //$(".recaptcha-checkbox-border").click();
        SelenideElement ss= $("span[role='checkbox']");
                ss.shouldBe(Condition.visible)
                .click();

        String path = screenshot("create"+ RadInt.randNum());
        String imagePath = test.addScreenCapture(path);
        try {
            if (ss.isDisplayed()) {
                test.log(LogStatus.PASS,"Captcha box is displayed");
                test.log(LogStatus.INFO,imagePath);

            } else {
                test.log(LogStatus.FAIL, "Create profile fails");
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }



        switchTo().defaultContent();
        return page(PageFactoryStimwave.class);
    }
}
