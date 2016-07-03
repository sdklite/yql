package com.sdklite.yahoo.yql;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
            return channel;
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

        @SerializedName("item")
        private Conditions conditions;

        public Units getUnits() {
            return units;
        }

        public String getTitle() {
            return title;
        }

        public String getLink() {
            return link;
        }

        public String getLanguage() {
            return language;
        }

        public long getTtl() {
            return ttl;
        }

        public Location getLocation() {
            return location;
        }

        public Wind getWind() {
            return wind;
        }

        public Atmosphere getAtmosphere() {
            return atmosphere;
        }

        public Conditions getConditions() {
            return conditions;
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
            return distance;
        }

        public String getPressure() {
            return pressure;
        }

        public String getSpeed() {
            return speed;
        }

        public String getTemperature() {
            return temperature;
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
            return city;
        }

        public String getCountry() {
            return country;
        }

        public String getRegion() {
            return region;
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
            return chill;
        }

        public double getDirection() {
            return direction;
        }

        public double getSpeed() {
            return speed;
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
            return humidity;
        }

        public double getPressure() {
            return pressure;
        }

        public double getRising() {
            return rising;
        }

        public double getVisibility() {
            return visibility;
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
            return title;
        }

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public Condition getCondition() {
            return condition;
        }

        public List<Condition> getForecasts() {
            return forecasts;
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
            return code;
        }

        public Date getDate() {
            try {
                return new SimpleDateFormat(this.date.endsWith("CST") ? "EEE, dd MMM yyyy hh:mm a" : "dd MMM yyyy").parse(this.date);
            } catch (final ParseException e) {
                return null;
            }
        }

        public double getTemperature() {
            return temperature;
        }

        public String getText() {
            return text;
        }

        public String getDay() {
            return day;
        }

        public double getLow() {
            return low;
        }

        public double getHigh() {
            return high;
        }
    }

}
