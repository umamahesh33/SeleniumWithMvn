package org.example.Service.BikeService;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Calendar;
import java.util.List;

public class BikeDetailsVerificationPage {
    private WebDriver driver;
    private Actions actions;
    private static int currentYear= Calendar.getInstance().get(Calendar.YEAR);

    public BikeDetailsVerificationPage(WebDriver driver, Actions actions) {
        this.driver = driver;
        this.actions = actions;
    }

    public void selectBikeModel(String bikeModel) {
        try{
            WebElement element=driver.findElement(By.xpath("//input[@class='sc-jqCOkK dHHoZj']"));
            if(element.isEnabled()){
                element.sendKeys(bikeModel);
            }
            else throw new RuntimeException("Input placeholder for entering bike model was not enabled..!");

            Thread.sleep(5000);
            List<WebElement> searchResult = driver.findElements(By.xpath("//div[@class='sc-hEsumM iLpvEj']"));
            if(searchResult.size()==0) throw new RuntimeException("No Bike Models Found as search result..!");

            boolean bikeModelFoundInList = false;
            for (WebElement ele : searchResult) {
                if (bikeModel.equals(ele.getText())) {
                    ele.click();
                    bikeModelFoundInList = true;
                    break;
                }
            }
            if (!bikeModelFoundInList) throw new RuntimeException("Bike Model not found");
        }
        catch (NoSuchElementException noSuchElementException){
            System.out.println("Input Placeholder to enter bike model not found..!"+ noSuchElementException.getMessage());
            driver.quit();
        }
        catch (RuntimeException | InterruptedException runtimeException){
            System.out.println(runtimeException.getMessage());
            driver.quit();
        }
    }

    public void selectBikeBoughtYear(String bikeBoughtYear){
        try{
            WebElement element1=driver.findElement(By.xpath("//div[text()='Select']"));
            if(element1.isDisplayed()){
                actions.moveToElement(element1).click().perform();
            }
            else throw new RuntimeException("Selection of year was not displayed..!");

            WebElement element2=driver.findElement(By.xpath("//div[@class='sc-bdVaJa sc-kafWEX hkuhnK']/div[text()='"+bikeBoughtYear+"']"));
            if(element2.isDisplayed()){
                actions.moveToElement(element2).click().perform();
            }
            else throw new RuntimeException("Provided year was not displayed..!");
        }
        catch (NoSuchElementException noSuchElementException){
            System.out.println("Year selection element was not found..!"+noSuchElementException.getMessage());
            driver.quit();
        }
        catch (RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
            driver.quit();
        }
    }

    public void selectCurrentPolicyStatus(String currentPolicyStatus, String bikeBoughtYear) {
        if(Integer.parseInt(bikeBoughtYear)==currentYear) return;
        try {
            WebElement element1=driver.findElement(By.xpath("//div[text()='Expired or not']"));
            if(element1.isDisplayed()){
                actions.moveToElement(element1).click().perform();
            }
            else throw new RuntimeException("Selection of policy status was not displayed..!");

            WebElement element2=driver.findElement(By.xpath("//button[@id='"+currentPolicyStatus+"']"));
            if(element2.isDisplayed()){
                actions.moveToElement(element2).click().perform();
            }
            else throw new RuntimeException("Selection of policy status was not displayed..!");
        }
        catch (NoSuchElementException noSuchElementException){
            System.out.println("Policy selection element not found..!"+noSuchElementException.getMessage());
            driver.quit();
        }
        catch (RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
            driver.quit();
        }
    }

    public void clickViewPricesButton(){
        try {
            WebElement element = driver.findElement(By.xpath("//button[@class='sc-dkzDqf sc-kjoXOD fseCie']"));
            if (element.isDisplayed() && element.isEnabled()) {
                element.click();
            }
            else throw new RuntimeException("View prices button was not displayed/enabled to click..!");
        }
        catch (NoSuchElementException noSuchElementException){
            System.out.println("view prices element not found..!"+noSuchElementException.getMessage());
            driver.quit();
        }
        catch (RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
            driver.quit();
        }
    }
}
