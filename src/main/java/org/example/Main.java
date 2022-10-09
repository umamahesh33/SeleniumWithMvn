package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.AutomationScript.FreshBikeAutomation;
import org.example.Model.FreshBikeInsuranceModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        //to take testcase as input
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("building testcase inputs: send 1 for car/send 2 for bike");
            int testcaseType=Integer.parseInt(br.readLine().trim());

            //if testcase is 1 builds object of car testcase type
            if (testcaseType == 1) {
                System.out.println("not implemented yet...!");
            }

            //if testcase is 2 builds object of bike testcase type
            if (testcaseType == 2) {
                //building the FresBikeInsuranceModel with the provided input
                FreshBikeInsuranceModel bike = new FreshBikeInsuranceModel();
                bike.setBikeNumber(br.readLine().trim());
                bike.setBikeModel(br.readLine().trim());
                bike.setBikeBoughtYear(br.readLine().trim());
                int policyStatusIndicator = Integer.parseInt(br.readLine().trim());
                bike.setPlanTenure(Integer.parseInt(br.readLine().trim()));
                bike.setPlanType(br.readLine().trim());
                int personalAccidentCoverIndicator = Integer.parseInt(br.readLine().trim());
                bike.setFullName(br.readLine().trim());
                bike.setEmail(br.readLine().trim());
                bike.setMobileNumber(br.readLine().trim());
                bike.setPinCode(br.readLine().trim());

                if (policyStatusIndicator == 0) {
                    bike.setCurrentPolicyStatus("notExpired");
                } else if (policyStatusIndicator == 1) {
                    bike.setCurrentPolicyStatus("expiredL90");
                } else {
                    bike.setCurrentPolicyStatus("expiredG90");
                }

                if (personalAccidentCoverIndicator == 1) {
                    bike.setPersonalAccidentCover(true);
                } else {
                    bike.setPersonalAccidentCover(false);
                }

                //calling the function to automate the current testcase
                FreshBikeAutomation fBike=new FreshBikeAutomation();
                fBike.freshBikeInsuranceTest(bike);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}