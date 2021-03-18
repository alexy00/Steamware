package utilities;


import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
    public static ExtentReports getInstance(String name) {
        ExtentReports extent;
        String Path = "C:/Users/Alex/Desktop/Steamwave"+RadInt.randNum()+".html";
        extent = new ExtentReports(Path, true);

        return extent;
    }
}