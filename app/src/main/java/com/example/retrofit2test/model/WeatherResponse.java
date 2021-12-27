package com.example.retrofit2test.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {
    @SerializedName("base")
    String base;
    @SerializedName("clouds")
    Clouds clouds;
    @SerializedName("coc")
    int cod;
    @SerializedName("dt")
    int dt;
    @SerializedName("id")
    int id;
    @SerializedName("main")
    Main main;
    @SerializedName("name")
    String name;
    @SerializedName("rain")
    Rain rain;
    @SerializedName("snow")
    Snow snow;
    @SerializedName("sys")
    Sys sys;
    @SerializedName("timezone")
    int timezone;
    @SerializedName("visibility")
    int visibility;
    @SerializedName("weather")
    List<Weather> weather;
    @SerializedName("wind")
    Wind wind;

    public class Clouds{
        @SerializedName("all")
        int all;
    }
    public class Coord{
        @SerializedName("lat")
        double lat;
        @SerializedName("lon")
        double lon;
    }
    public class Main{
        @SerializedName("feels_like")
        double feels_like;
        @SerializedName("humidity")
        int humidity;
        @SerializedName("pressure")
        int pressure;
        @SerializedName("temp")
        double temp;
        @SerializedName("temp_max")
        double temp_max;
        @SerializedName("temp_min")
        double temp_min;
    }
    public class Rain{
        @SerializedName("1h")
        double h1;
    }
    public class Snow{
        @SerializedName("1h")
        double h1;
    }
    public class Sys{
        @SerializedName("country")
        String country;
        @SerializedName("id")
        int id;
        @SerializedName("sunrise")
        int sunrise;
        @SerializedName("sunset")
        int sunset;
        @SerializedName("type")
        int type;
    }
    public class Wind{
        @SerializedName("deg")
        int deg;
        @SerializedName("speed")
        double speed;
    }
    public class Weather{
        @SerializedName("description")
        String description;
        @SerializedName("icon")
        String icon;
        @SerializedName("id")
        int id;
        @SerializedName("main")
        String main;
    }
}
