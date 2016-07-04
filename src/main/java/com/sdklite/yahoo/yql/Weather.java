package com.sdklite.yahoo.yql;

import java.io.Serializable;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * @author johnsonlee
 */
public interface Weather {

    public static class Forecast implements Serializable {

        private static final long serialVersionUID = 591051533092381223L;

        @SerializedName("channel")
        private Channel channel;

        public Channel getChannel() {
            return this.channel;
        }

        @Override
        public String toString() {
            return new Gson().toJson(this);
        }

    }

    public static class Channel implements Serializable {

        private static final long serialVersionUID = 2274631206833618460L;

        @SerializedName("units")
        private Units units;

        @SerializedName("title")
        private String title;

        @SerializedName("link")
        private String link;

        @SerializedName("language")
        private String language;

        @SerializedName("ttl")
        private long ttl;

        @SerializedName("location")
        private Location location;

        @SerializedName("wind")
        private Wind wind;

        @SerializedName("atmosphere")
        private Atmosphere atmosphere;

        @SerializedName("astronomy")
        private Astronomy astronomy;

        @SerializedName("item")
        private Conditions conditions;

        public Units getUnits() {
            return this.units;
        }

        public String getTitle() {
            return this.title;
        }

        public String getLink() {
            return this.link;
        }

        public String getLanguage() {
            return this.language;
        }

        public long getTtl() {
            return this.ttl;
        }

        public Location getLocation() {
            return this.location;
        }

        public Wind getWind() {
            return this.wind;
        }

        public Atmosphere getAtmosphere() {
            return this.atmosphere;
        }

        public Conditions getConditions() {
            return this.conditions;
        }

        public Astronomy getAstronomy() {
            return this.astronomy;
        }

        public void setAstronomy(Astronomy astronomy) {
            this.astronomy = astronomy;
        }

        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

    public static class Units implements Serializable {

        private static final long serialVersionUID = -7629289839813738138L;

        @SerializedName("distance")
        private String distance;

        @SerializedName("pressure")
        private String pressure;

        @SerializedName("speed")
        private String speed;

        @SerializedName("temperature")
        private String temperature;

        public String getDistance() {
            return this.distance;
        }

        public String getPressure() {
            return this.pressure;
        }

        public String getSpeed() {
            return this.speed;
        }

        public String getTemperature() {
            return this.temperature;
        }

        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

    public static class Location implements Serializable {

        private static final long serialVersionUID = 8964524120033451385L;

        @SerializedName("city")
        private String city;

        @SerializedName("country")
        private String country;

        @SerializedName("region")
        private String region;

        public String getCity() {
            return this.city;
        }

        public String getCountry() {
            return this.country;
        }

        public String getRegion() {
            return this.region;
        }

        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

    public static class Wind implements Serializable {

        private static final long serialVersionUID = 7533096636836257525L;

        @SerializedName("chill")
        private double chill;

        @SerializedName("direction")
        private double direction;

        @SerializedName("speed")
        private double speed;

        public double getChill() {
            return this.chill;
        }

        public double getDirection() {
            return this.direction;
        }

        public double getSpeed() {
            return this.speed;
        }

        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

    public static class Atmosphere implements Serializable {

        private static final long serialVersionUID = 5454279924569498048L;

        @SerializedName("humidity")
        private double humidity;

        @SerializedName("pressure")
        private double pressure;

        @SerializedName("rising")
        private double rising;

        @SerializedName("visibility")
        private double visibility;

        public double getHumidity() {
            return this.humidity;
        }

        public double getPressure() {
            return this.pressure;
        }

        public double getRising() {
            return this.rising;
        }

        public double getVisibility() {
            return this.visibility;
        }

        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

    public static class Astronomy implements Serializable {

        private static final long serialVersionUID = -4907053599305938039L;

        @SerializedName("sunrise")
        private String sunrise;

        @SerializedName("sunset")
        private String sunset;

        public String getSunrise() {
            return this.sunrise;
        }

        public String getSunset() {
            return this.sunset;
        }

    }

    public static class Conditions implements Serializable {

        private static final long serialVersionUID = 635105378389972971L;

        @SerializedName("title")
        private String title;

        @SerializedName("lat")
        private double latitude;

        @SerializedName("long")
        private double longitude;

        @SerializedName("condition")
        private Condition condition;

        @SerializedName("forecast")
        private List<Condition> forecasts;

        @SerializedName("description")
        private String description;

        public String getTitle() {
            return this.title;
        }

        public double getLatitude() {
            return this.latitude;
        }

        public double getLongitude() {
            return this.longitude;
        }

        public Condition getCondition() {
            return this.condition;
        }

        public List<Condition> getForecasts() {
            return this.forecasts;
        }

        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

    public static class Condition implements Serializable {

        private static final long serialVersionUID = 5883921573153814111L;

        @SerializedName("code")
        private int code;

        @SerializedName("date")
        private String date;

        /**
         * Day of week
         */
        @SerializedName("day")
        private String day;

        @SerializedName("temp")
        private double temperature;

        @SerializedName("low")
        private double low;

        @SerializedName("high")
        private double high;

        @SerializedName("text")
        private String text;

        public int getCode() {
            return this.code;
        }

        public String getDate() {
            return this.date;
        }

        public double getTemperature() {
            return this.temperature;
        }

        public String getText() {
            return this.text;
        }

        public String getDay() {
            return this.day;
        }

        public double getLow() {
            return this.low;
        }

        public double getHigh() {
            return this.high;
        }

        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

}
