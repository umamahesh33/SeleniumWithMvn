package org.example.Service.BikeService;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import sun.lwawt.macosx.CThreading;

public class CheckoutPage {
    private WebDriver driver;
    private Actions actions;

    public CheckoutPage(WebDriver driver, Actions actions) {
        this.driver = driver;
        this.actions = actions;
    }

    public void enterFullName(String name){
        try{
            WebElement element=driver.findElement(By.xpath("//input[@id='name']"));
            if(element.isEnabled()){
                element.sendKeys(name);
            }
            else throw new RuntimeException("Input placeholder for full name was not enabled..!");
        }
        catch (NoSuchElementException noSuchElementException){
            System.out.println("Web element of full name was not found..!");
            driver.quit();
        }
        catch (RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
            driver.quit();
        }
    }

    public void enterEmail(String email){
        try{
            WebElement element=driver.findElement(By.xpath("//input[@id='email']"));
            if(element.isEnabled()){
                element.sendKeys(email);
            }
            else throw new RuntimeException("Input placeholder for email was not enabled..!");
        }
        catch (NoSuchElementException noSuchElementException){
            System.out.println("Web element of email was not found..!");
            driver.quit();
        }
        catch (RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
            driver.quit();
        }
    }

    public void enterMobileNumber(String mobileNum){
        try{
            WebElement element=driver.findElement(By.xpath("//input[@id='phoneNumber']"));
            if(element.isEnabled()){
                element.sendKeys(mobileNum);
            }
            else throw new RuntimeException("Input placeholder for mobile number was not enabled..!");
        }
        catch (NoSuchElementException noSuchElementException){
            System.out.println("Web element of mobile number was not found..!");
            driver.quit();
        }
        catch (RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
            driver.quit();
        }
    }

    public void enterPincode(String pincode){
        try{
            WebElement element=driver.findElement(By.xpath("//input[@id='pinCode']"));
            if(element.isEnabled()){
                element.sendKeys(pincode);
            }
            else throw new RuntimeException("Input placeholder for pincode was not enabled..!");
        }
        catch (NoSuchElementException noSuchElementException){
            System.out.println("Web element of pincode was not found..!");
            driver.quit();
        }
        catch (RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
            driver.quit();
        }
    }


//    hardcoded chasis number if it was a 2022 vehicle
//    TODO: take chasis number as input

//        if(Integer.parseInt(bikeBoughtYear)==currentYear){
//        driver.findElement(By.xpath("//*[@id='bikeNumber']")).sendKeys("MB8DP12DHL8298969");
//    }

    //requires activation date as a parameter if we are making it generic
    public void selectDateOfActivation(){
        try{
            WebElement element=driver.findElement(By.xpath("//div[text()='Tomorrow']"));
            if(element.isDisplayed() && element.isEnabled()){
                element.click();
            }
            else throw new RuntimeException("Activation date was not enabled or displayed..!");
        }
        catch (NoSuchElementException noSuchElementException){
            System.out.println("Activation date web element was not found..!"+noSuchElementException.getMessage());
        }
        catch (RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
        }
    }

    public void clickContinue(){
        try{
            WebElement element=driver.findElement(By.xpath("//button[@class='sc-dkzDqf sc-gkFcWv gYiYZH']"));
            if(element.isEnabled()){
                element.click();
            }
            else throw new RuntimeException("Continue button was not enabled..!");
        }
        catch (NoSuchElementException noSuchElementException){
            System.out.println("Continue button web element not found..!"+noSuchElementException.getMessage());
            driver.quit();
        }
        catch (RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
            driver.quit();
        }
    }
}
