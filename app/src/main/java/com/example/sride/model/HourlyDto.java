package com.example.sride.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HourlyDto {

    @SerializedName("data")
    private List<WeatherDataDto> data;
    @SerializedName("summary")
    private String summary;
    @SerializedName("icon")
    private String icon;

    public List<WeatherDataDto> getData() {
        return data;
    }

    public void setData(List<WeatherDataDto> data) {
        this.data = data;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
