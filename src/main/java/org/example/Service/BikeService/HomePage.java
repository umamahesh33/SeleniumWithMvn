package org.example.Service.BikeService;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HomePage {

    private WebDriver driver;
    private Actions actions;

    public HomePage(WebDriver driver, Actions actions) {
        this.driver = driver;
        this.actions = actions;
    }

    public void clickBikeIcon() {
        try{
            WebElement element=driver.findElement(By.xpath("//img[@class='hover-opacity']"));
            if(element.isDisplayed()){
                actions.moveToElement(element).click().perform();
            }
            else throw new RuntimeException("Bike icon not displayed..!");
        }
        catch (NoSuchElementException noSuchElementException){
            System.out.println("Bike icon not found..!"+noSuchElementException.getMessage());
            driver.quit();
        }
        catch (RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
            driver.quit();
        }
    }

    public void enterBikeNumber(String bikeNumber){
        try{
            WebElement element= driver.findElement(By.xpath("//input[@id='bikeNumber']"));
            if(element.isEnabled()){
                element.sendKeys(bikeNumber);
            }
            else throw new RuntimeException("Not able to enter bike number..!");
        }
        catch (NoSuchElementException noSuchElementException){
            System.out.println("Input placeholder for bike number was not found..!" + noSuchElementException.getMessage());
            driver.quit();
        }
        catch (RuntimeException exception){
            System.out.println(exception.getMessage());
            driver.quit();
        }
    }

    public void clickInsureButton(){
        try{
            WebElement element=driver.findElement(By.xpath("//button[@class='sc-hzNEM sc-kxynE hIBnmR']"));
            if(element.isEnabled()){
                element.click();
            }
            else throw new RuntimeException("Get Quote Button is not enabled..!");
        }
        catch (NoSuchElementException noSuchElementException){
            System.out.println("Get Quote Button Not Found" + noSuchElementException.getMessage());
            driver.quit();
        }
        catch (RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
            driver.quit();
        }
    }
}
