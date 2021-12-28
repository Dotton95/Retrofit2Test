package com.example.retrofit2test.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {
    @SerializedName("base")
    public String base;
    @SerializedName("clouds")
    public Clouds clouds;
    @SerializedName("coc")
    public Integer cod;
    @SerializedName("dt")
    public Integer dt;
    @SerializedName("id")
    public Integer id;
    @SerializedName("main")
    public Main main;
    @SerializedName("name")
    public String name;
    @SerializedName("rain")
    public Rain rain;
    @SerializedName("snow")
    public Snow snow;
    @SerializedName("sys")
    public Sys sys;
    @SerializedName("timezone")
    public Integer timezone;
    @SerializedName("visibility")
    public Integer visibility;
    @SerializedName("weather")
    public List<Weather> weather;
    @SerializedName("wind")
    public Wind wind;

    public class Clouds{
        @SerializedName("all")
        public Integer all;
    }
    public class Coord{
        @SerializedName("lat")
        public Double lat;
        @SerializedName("lon")
        public Double lon;
    }
    public class Main{
        @SerializedName("feels_like")
        public Double feels_like;
        @SerializedName("humidity")
        public Integer humidity;
        @SerializedName("pressure")
        public Integer pressure;
        @SerializedName("temp")
        public Double temp;
        @SerializedName("temp_max")
        public Double temp_max;
        @SerializedName("temp_min")
        public Double temp_min;
    }
    public class Rain{
        @SerializedName("1h")
        public Double h1;
    }
    public class Snow{
        @SerializedName("1h")
        public Double h1;
    }
    public class Sys{
        @SerializedName("country")
        public String country;
        @SerializedName("id")
        public Integer id;
        @SerializedName("sunrise")
        public Integer sunrise;
        @SerializedName("sunset")
        public Integer sunset;
        @SerializedName("type")
        public Integer type;
    }
    public class Wind{
        @SerializedName("deg")
        public Integer deg;
        @SerializedName("speed")
        public Double speed;
    }
    public class Weather{
        @SerializedName("description")
        public String description;
        @SerializedName("icon")
        public String icon;
        @SerializedName("id")
        public Integer id;
        @SerializedName("main")
        public String main;
    }
}
