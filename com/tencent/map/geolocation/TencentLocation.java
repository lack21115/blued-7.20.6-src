package com.tencent.map.geolocation;

import android.os.Bundle;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/geolocation/TencentLocation.class */
public interface TencentLocation {
    public static final String BEIDOU_PROVIDER = "beidou";
    public static final String CELL_PROVIDER = "cell";
    public static final String COARSE_PROVIDER = "coarse";
    public static final int ERROR_BAD_JSON = 2;
    public static final int ERROR_INTERNAL = 5;
    public static final int ERROR_NETWORK = 1;
    public static final int ERROR_OK = 0;
    public static final int ERROR_UNKNOWN = 404;
    public static final int ERROR_WGS84 = 4;
    public static final String EXTRA_ADDRDESP_LANDMARK = "addrdesp.landmark";
    public static final String EXTRA_ADDRDESP_OTHERS_RESULTS = "addrdesp.results";
    public static final String EXTRA_ADDRDESP_SECOND_LANDMARK = "addrdesp.second_landmark";
    public static final String EXTRA_DIRECTION = "direction";
    public static final String FAKE = "fake";
    public static final String FUSED_PROVIDER = "fused";
    public static final String GPS_PROVIDER = "gps";
    public static final String NETWORK_PROVIDER = "network";
    public static final String WIFI_PROVIDER = "wifi";

    float getAccuracy();

    String getAddress();

    double getAltitude();

    Integer getAreaStat();

    float getBearing();

    String getCity();

    String getCityCode();

    String getCityPhoneCode();

    int getCoordinateType();

    double getDirection();

    String getDistrict();

    long getElapsedRealtime();

    Bundle getExtra();

    float getFakeProbability();

    int getFakeReason();

    int getGPSRssi();

    String getIndoorBuildingFloor();

    String getIndoorBuildingId();

    int getIndoorLocationType();

    double getLatitude();

    double getLongitude();

    String getName();

    String getNation();

    int getNationCode();

    List<TencentPoi> getPoiList();

    String getProvider();

    String getProvince();

    String getSourceProvider();

    float getSpeed();

    String getStreet();

    String getStreetNo();

    long getTime();

    String getTown();

    String getVillage();

    String getadCode();

    int isMockGps();
}
