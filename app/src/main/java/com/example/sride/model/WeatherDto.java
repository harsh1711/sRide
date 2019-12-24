package com.example.sride.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "weather_table")
public class WeatherDto {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    private Long id;
    @SerializedName("currently")
    private WeatherDataDto currently;
    @SerializedName("offset")
    private Double offset;
    @SerializedName("timezone")
    private String timezone;
    @SerializedName("latitude")
    private Double latitude;
    @SerializedName("hourlyDto")
    private HourlyDto hourlyDto;
    @SerializedName("longitude")
    private Double longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WeatherDataDto getCurrently() {
        return currently;
    }

    public void setCurrently(WeatherDataDto currently) {
        this.currently = currently;
    }

    public Double getOffset() {
        return offset;
    }

    public void setOffset(Double offset) {
        this.offset = offset;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public HourlyDto getHourlyDto() {
        return hourlyDto;
    }

    public void setHourlyDto(HourlyDto hourlyDto) {
        this.hourlyDto = hourlyDto;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
