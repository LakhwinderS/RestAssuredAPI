package com.weather.Utils;

import com.weather.Pojo.WeatherAPI.WeatherStationRequest;

import java.util.HashMap;
/**
 *
 * @author Lakhwinder Singh
 *
 */
public class Payloads {
    static WeatherStationRequest weatherStationRequest = new WeatherStationRequest();
    public static HashMap map = new HashMap();
    public static void addNewStation(String externalId, String name, float latitude, float longitude, int altitude){

        weatherStationRequest.setExternal_id(externalId);
        weatherStationRequest.setName(name);
        weatherStationRequest.setLatitude(latitude);
        weatherStationRequest.setLongitude(longitude);
        weatherStationRequest.setAltitude(altitude);



    }
    public static HashMap postAddNewStation(){
        map.put("external_id",weatherStationRequest.getExternal_id() );
        map.put("name",weatherStationRequest.getName());
        map.put("latitude",weatherStationRequest.getLatitude());
        map.put("longitude",weatherStationRequest.getLongitude());
        map.put("altitude",weatherStationRequest.getAltitude());

        return map;
    }


}
