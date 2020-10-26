package com.weather.Pojo.WeatherAPI;

public class WeatherStationResponse {
    private String ID;
    private String updated_at;
    private String created_at;
    private String user_id;
    private String external_id;
    private String name;
    private float latitude;
    private float longitude;
    private int altitude;
    private int rank;
    private int source_type;

    public String getID(){return  ID;}

    public  void  setID(String ID) { this.ID = ID; }

    public String getUpdated_at(){return  updated_at;}

    public  void  setUpdated_at(String updated_at) { this.updated_at = updated_at; }

    public String getCreated_at(){return created_at;}

    public  void setCreated_at(String created_at) {this.created_at=created_at;}

    public String getUser_id(){return user_id;}

    public void setUser_id(String updated_at){this.user_id =user_id;}

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public  int getRank() { return rank; }

    public void setRank(int rank) { this.rank=rank; }

    public  int getSource_type() { return  source_type; }

    public  void setSource_type(int source_type) { this.source_type =source_type; }
}
