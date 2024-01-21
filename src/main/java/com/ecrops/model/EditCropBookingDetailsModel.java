package com.ecrops.model;

import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
public class EditCropBookingDetailsModel {

    private Integer cropYear;

    private Integer vCode;

    private Integer correctionType;

    private String searchType;

    private String aadharNo;

    private String kathaNo;

    private String surveyNo;

    public Integer getCropYear() {
        return cropYear;
    }

    public void setCropYear(Integer cropYear) {
        this.cropYear = cropYear;
    }

    public Integer getvCode() {
        return vCode;
    }

    public void setvCode(Integer vCode) {
        this.vCode = vCode;
    }

    public Integer getCorrectionType() {
        return correctionType;
    }

    public void setCorrectionType(Integer correctionType) {
        this.correctionType = correctionType;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getKathaNo() {
        return kathaNo;
    }

    public void setKathaNo(String kathaNo) {
        this.kathaNo = kathaNo;
    }

    public String getSurveyNo() {
        return surveyNo;
    }

    public void setSurveyNo(String surveyNo) {
        this.surveyNo = surveyNo;
    }
}
