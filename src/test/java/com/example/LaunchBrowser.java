package com.example;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class LaunchBrowser extends BasePage {
    public static void main(String[] args) {
        LaunchBrowser obj = new LaunchBrowser();
        try {

            obj.initializeDriver();

            //Navigate
            obj.navigateToWebsite("https://www.geeksforgeeks.org/");
            Thread.sleep(5000);

            //Scroll
            obj.scrollToEnd();
            Thread.sleep(5000);

            obj.scrollToTop();
            Thread.sleep(5000);

            obj.scrollToSpecificPostion();
            Thread.sleep(5000);

            obj.takeScreenShot();


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            obj.tearDown();
        }
    }

    public void takeScreenShot() {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Date date = new Date();
            System.out.println(date.getTime());
            String currentDirectory = System.getProperty("user.dir");
            String packagePath = "/Screenshot/" +  date.getTime() + ".jpg";
            String fullPath = currentDirectory + packagePath;
            Files.copy(screenshot.toPath(), Paths.get(fullPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void scrollToEnd() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
    }

    //Scroll to a Specific Element:
    public void scrollToSpecificElement() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.id("element-id"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //Scroll to a Specific Position:
    public void scrollToSpecificPostion() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500);"); // Scroll 500 pixels down
    }

    public void navigateToWebsite(String url) {
        driver.get(url);
        System.out.println("Navigated to: " + url);
    }
}
