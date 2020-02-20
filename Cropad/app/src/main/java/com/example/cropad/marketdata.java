package com.example.cropad;

public class marketdata {

    String marketName;
    String price;
    double lat;
    double lon;
    String distance;

    public marketdata(String marketName,String price,double lat,double lon, String distance) {
        this.marketName=marketName;
        this.price=price;
        this.lat=lat;
        this.lon=lon;
        this.distance=distance;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketnName(String marketName) {
        this.marketName = marketName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
