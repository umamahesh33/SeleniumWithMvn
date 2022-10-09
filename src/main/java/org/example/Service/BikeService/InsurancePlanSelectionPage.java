package org.example.Service.BikeService;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class InsurancePlanSelectionPage {
    private WebDriver driver;
    private Actions actions;

    public InsurancePlanSelectionPage(WebDriver driver, Actions actions) {
        this.driver = driver;
        this.actions = actions;
    }

    public void selectPlanTenure(int planTenure){
        try{
            String xp="//button[text()='"+planTenure+" Year']";
            WebElement element=driver.findElement(By.xpath(xp));
            if(element.isDisplayed() && element.isEnabled()){
                element.click();
            }
            else throw new RuntimeException("Plan tenure was not displayed/enabled..!");
        }
        catch (NoSuchElementException noSuchElementException){
            System.out.println("Plan tenure element not found..!"+noSuchElementException.getMessage());
            driver.quit();
        }
        catch (RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
            driver.quit();
        }
    }

    public void selectPlanType(String planType){
        try{
            if (planType.equals("Comprehensive plan")) {
                WebElement element = driver.findElement(By.xpath("//div[@class='sc-cpmLhU ehfQtm']"));
                if(element.isDisplayed() && element.isEnabled()){
                    if (!element.isSelected()) {
                        element.click();
                    }
                }
                else throw new RuntimeException("Comprehensive plan was not enabled/displayed..!");
            }
            else if (planType.equals("Third Party plan")) {
                WebElement element=driver.findElement(By.xpath("//div[@class='sc-cpmLhU hqJawM']"));
                if(element.isDisplayed() && element.isEnabled()){
                    element.click();
                }
                else throw new RuntimeException("Third party plan was not enabled/displayed..!");
            }
            else throw new RuntimeException("Plan type not matched...!");
        }
        catch (NoSuchElementException noSuchElementException){
            System.out.println("Some element not found in plans section..!"+noSuchElementException.getMessage());
            driver.quit();
        }
        catch (RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
            driver.quit();
        }
    }

    public void selectPersonalAccidentCover(boolean isReq){
        try{
            if(isReq){
                WebElement element=driver.findElement(By.xpath("//div[@class='sc-bXGyLb sc-lkqHmb sc-eLExRp dgvKIY']"));
                if(element.isDisplayed() && element.isEnabled()){
                    element.click();
                }
                else throw new RuntimeException("Personal Accident cover checkbox was not displayed/enabled");
            }
        }
        catch (NoSuchElementException noSuchElementException){
            System.out.println("PAC checkbox not found..!"+noSuchElementException.getMessage());
            driver.quit();
        }
        catch (RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
            driver.quit();
        }
    }

    public void clickContinue(){
        try{
            WebElement element=driver.findElement(By.xpath("//button[@class='sc-dkzDqf fyOAWS']"));
            if(element.isDisplayed() && element.isEnabled()){
                element.click();
            }
            else {
                if(!element.isDisplayed()) throw new RuntimeException("Continue button is not displayed..!");
                if(!element.isEnabled()) throw new RuntimeException("Continue button is not enabled..!");
            }
        }
        catch (NoSuchElementException noSuchElementException){
            System.out.println("Continue button web element not found...!"+noSuchElementException.getMessage());
            driver.quit();
        }
        catch (RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
            driver.quit();
        }
    }
}
