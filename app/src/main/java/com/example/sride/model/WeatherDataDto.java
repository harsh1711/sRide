package com.example.sride.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.sride.BR;
import com.google.gson.annotations.SerializedName;

public class WeatherDataDto extends BaseObservable {

    @SerializedName("temperature")
    private Double temperature;
    @SerializedName("cloudCover")
    private Double cloudCover;
    @SerializedName("humidity")
    private Double humidity;
    @SerializedName("apparentTemperature")
    private Double apparentTemperature;
    @SerializedName("pressure")
    private Double pressure;
    @SerializedName("dewPoint")
    private Double dewPoint;
    @SerializedName("windSpeed")
    private Double windSpeed;
    @SerializedName("uvIndex")
    private Double uvIndex;
    @SerializedName("time")
    private String time;
    @SerializedName("date")
    private String date;
    @SerializedName("day")
    private String day;

    @Bindable
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
        notifyPropertyChanged(BR.date);

    }
    @Bindable
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
        notifyPropertyChanged(BR.day);
    }

    @Bindable
    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
        notifyPropertyChanged(BR.temperature);
    }
    @Bindable
    public Double getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(Double cloudCover) {
        this.cloudCover = cloudCover;
        notifyPropertyChanged(BR.cloudCover);
    }

    @Bindable
    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
        notifyPropertyChanged(BR.humidity);
    }
    @Bindable
    public Double getApparentTemperature() {
        return apparentTemperature;
    }

    public void setApparentTemperature(Double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
        notifyPropertyChanged(BR.apparentTemperature);
    }
    @Bindable
    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
        notifyPropertyChanged(BR.pressure);
    }
    @Bindable
    public Double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
        notifyPropertyChanged(BR.dewPoint);
    }
    @Bindable
    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
        notifyPropertyChanged(BR.windSpeed);
    }
    @Bindable
    public Double getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(Double uvIndex) {
        this.uvIndex = uvIndex;
        notifyPropertyChanged(BR.uvIndex);
    }
    @Bindable
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
        notifyPropertyChanged(BR.time);
    }
}
