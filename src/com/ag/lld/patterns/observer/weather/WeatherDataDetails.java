package com.ag.lld.patterns.observer.weather;

public class WeatherDataDetails {
    private final double temperature;
    private final double humidity;
    private final int airQuality;


    private WeatherDataDetails(double temperature, double humidity, int airQuality) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.airQuality = airQuality;
    }

    public static WeatherDataDetailsBuilder builder(){
        return new WeatherDataDetailsBuilder();
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public int getAirQuality() {
        return airQuality;
    }

    public static class WeatherDataDetailsBuilder {
        private double temperature;
        private double humidity;
        private int airQuality;

        public WeatherDataDetailsBuilder setTemperature(double temperature) {
            this.temperature = temperature;
            return this;
        }

        public WeatherDataDetailsBuilder setHumidity(double humidity) {
            this.humidity = humidity;
            return this;

        }

        public WeatherDataDetailsBuilder setAirQuality(int airQuality) {
            this.airQuality = airQuality;
            return this;

        }

        public WeatherDataDetails build(){
            return new WeatherDataDetails(this.temperature, this.humidity, this.airQuality);
        }
    }
}
