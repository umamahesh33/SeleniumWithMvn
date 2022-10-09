package org.example.AutomationScript;

import org.example.Model.FreshBikeInsuranceModel;
import org.example.Service.BikeService.BikeDetailsVerificationPage;
import org.example.Service.BikeService.CheckoutPage;
import org.example.Service.BikeService.HomePage;
import org.example.Service.BikeService.InsurancePlanSelectionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Calendar;

public class FreshBikeAutomation {

    private static int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    //TODO: Handle current year bikes as new bikes
    //TODO: Handle before 2007 case
    private WebDriver driver;
    private Actions actions;
    private HomePage homePage;
    private BikeDetailsVerificationPage bikeDetailsVerificationPage;
    private InsurancePlanSelectionPage insurancePlanSelectionPage;
    private CheckoutPage checkoutPage;

    public FreshBikeAutomation() {
        this.driver = new ChromeDriver();
        this.actions = new Actions(driver);
        this.homePage = new HomePage(this.driver, this.actions);
        this.bikeDetailsVerificationPage = new BikeDetailsVerificationPage(this.driver, this.actions);
        this.insurancePlanSelectionPage = new InsurancePlanSelectionPage(this.driver, this.actions);
        this.checkoutPage = new CheckoutPage(this.driver, this.actions);
    }

    public void freshBikeInsuranceTest(FreshBikeInsuranceModel bike) throws InterruptedException {
        //opens ackodev website and maximizes the window size
        driver.get("https://www.ackodev.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //switches to bike search and enters bike number and clicks get quote button
        homePage.clickBikeIcon();
        homePage.enterBikeNumber(bike.getBikeNumber());
        homePage.clickInsureButton();

        //selects bike model and year and current policy status
        bikeDetailsVerificationPage.selectBikeModel(bike.getBikeModel());
        bikeDetailsVerificationPage.selectBikeBoughtYear(bike.getBikeBoughtYear());
        bikeDetailsVerificationPage.selectCurrentPolicyStatus(bike.getCurrentPolicyStatus(), bike.getBikeBoughtYear());
        bikeDetailsVerificationPage.clickViewPricesButton();

        //selects the insurance plan tenure,type,and mandatory addons
        insurancePlanSelectionPage.selectPlanTenure(bike.getPlanTenure());
        insurancePlanSelectionPage.selectPlanType(bike.getPlanType());
        insurancePlanSelectionPage.selectPersonalAccidentCover(bike.isPersonalAccidentCover());

        //clicks on continue button, based on the addon marked or not
        insurancePlanSelectionPage.clickContinue();
        if(!bike.isPersonalAccidentCover()) insurancePlanSelectionPage.clickContinue();

        //set the details of user
        checkoutPage.enterFullName(bike.getFullName());
        checkoutPage.enterEmail(bike.getEmail());
        checkoutPage.enterMobileNumber(bike.getMobileNumber());
        checkoutPage.enterPincode(bike.getPinCode());

        //checks the current policy status and sends it to select the date of activation policy
        if (bike.getCurrentPolicyStatus().equals("notExpired")) {
            checkoutPage.selectDateOfActivation();
        }
        checkoutPage.clickContinue();

        /*
         * end of the automation process here because after this otp verification needs to be
         * done to move forward
         */
        Thread.sleep(10000);
        driver.quit();
    }
}
