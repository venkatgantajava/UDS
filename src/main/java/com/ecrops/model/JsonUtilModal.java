package com.ecrops.model;

public class JsonUtilModal {
    private String captcha;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public JsonUtilModal(String captcha) {
        this.captcha = captcha;
    }
}
