package com.example.nick0.geoguessswipe;

import java.util.HashMap;
import java.util.Map;

public class GeoObject {

    private String mGeoName;
    private int mGeoImageName;

    public GeoObject(String mGeoName, int mGeoImageName) {
        this.mGeoName = mGeoName;
        this.mGeoImageName = mGeoImageName;
    }

    public String getmGeoName(){
        return mGeoName;
    }
    public void setmGeoName(String mGeoName){
        this.mGeoName = mGeoName;
    }
    public int getmGeoImageName() {
        return mGeoImageName;
    }
    public void setmGeoImageName(int mGeoImageName) {
        this.mGeoImageName = mGeoImageName;
    }


    public static Map<Integer, Boolean> getCountries() {
        Map<Integer, Boolean> countries = new HashMap<Integer,Boolean>();
            countries.put(R.drawable.img1_yes_denmark, true);
            countries.put(R.drawable.img2_no_canada, false);
            countries.put(R.drawable.img3_no_bangladesh, false);
            countries.put(R.drawable.img4_yes_kazachstan, true);
            countries.put(R.drawable.img5_no_colombia, false);
            countries.put(R.drawable.img6_yes_poland, true);
            countries.put(R.drawable.img7_yes_malta, true);
            countries.put(R.drawable.img8_no_thailand, false);

            return countries;
    };

    public static final String[] PRE_DEFINED_GEO_OBJECT_NAMES = {
            "Denmark",
            "Canada",
            "Bangladesh",
            "Kazachstan",
            "Colombia",
            "Poland",
            "Malta",
            "Thailand"
    };
}
