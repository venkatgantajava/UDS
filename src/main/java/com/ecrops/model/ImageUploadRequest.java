package com.ecrops.model;

// DTO for capturing request data
public  class ImageUploadRequest {
    private String applicationId;
    private String image;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
