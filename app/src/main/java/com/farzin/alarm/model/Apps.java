package com.farzin.alarm.model;

import com.google.gson.annotations.SerializedName;

public class Apps {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("version")
    private int version;

    @SerializedName("download")
    private String download;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }
}
