package com.example.hhh.imicmo2.Entities;

import java.io.Serializable;

public class OpeningScheduler implements Serializable {

    private String CreateDate;

    private String ImageLink;

    private String Location;

    private String ModifyUpdate;

    private String OpenDescription;

    private String OpenningDate;

    private String OpenningId;

    private String Status;

    private String Title;

    private String Views;

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    public String getImageLink() {
        return ImageLink;
    }

    public void setImageLink(String imageLink) {
        ImageLink = imageLink;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getModifyUpdate() {
        return ModifyUpdate;
    }

    public void setModifyUpdate(String modifyUpdate) {
        ModifyUpdate = modifyUpdate;
    }

    public String getOpenDescription() {
        return OpenDescription;
    }

    public void setOpenDescription(String openDescription) {
        OpenDescription = openDescription;
    }

    public String getOpenningDate() {
        return OpenningDate;
    }

    public void setOpenningDate(String openningDate) {
        OpenningDate = openningDate;
    }

    public String getOpenningId() {
        return OpenningId;
    }

    public void setOpenningId(String openningId) {
        OpenningId = openningId;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getViews() {
        return Views;
    }

    public void setViews(String views) {
        Views = views;
    }
}
