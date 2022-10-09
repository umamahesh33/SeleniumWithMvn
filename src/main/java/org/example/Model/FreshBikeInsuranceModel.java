package org.example.Model;

public class FreshBikeInsuranceModel {
    private String bikeNumber;
    private String bikeModel;
    private String bikeBoughtYear;
    private String currentPolicyStatus;
    private int planTenure;
    private String planType;
    private boolean personalAccidentCover;
    private String fullName;
    private String email;
    private String mobileNumber;
    private String pinCode;
    private String chasisNumber;

    public String getChasisNumber() {
        return chasisNumber;
    }

    public void setChasisNumber(String chasisNumber) {
        this.chasisNumber = chasisNumber;
    }

    public FreshBikeInsuranceModel() {
    }

    public String getBikeNumber() {
        return bikeNumber;
    }

    public void setBikeNumber(String bikeNumber) {
        this.bikeNumber = bikeNumber;
    }

    public String getBikeModel() {
        return bikeModel;
    }

    public void setBikeModel(String bikeModel) {
        this.bikeModel = bikeModel;
    }

    public String getBikeBoughtYear() {
        return bikeBoughtYear;
    }

    public void setBikeBoughtYear(String bikeBoughtYear) {
        this.bikeBoughtYear = bikeBoughtYear;
    }

    public String getCurrentPolicyStatus() {
        return currentPolicyStatus;
    }

    public void setCurrentPolicyStatus(String currentPolicyStatus) {
        this.currentPolicyStatus = currentPolicyStatus;
    }

    public int getPlanTenure() {
        return planTenure;
    }

    public void setPlanTenure(int planTenure) {
        this.planTenure = planTenure;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public boolean isPersonalAccidentCover() {
        return personalAccidentCover;
    }

    public void setPersonalAccidentCover(boolean personalAccidentCover) {
        this.personalAccidentCover = personalAccidentCover;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
