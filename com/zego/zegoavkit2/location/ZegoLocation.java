package com.zego.zegoavkit2.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/location/ZegoLocation.class */
public final class ZegoLocation {

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/location/ZegoLocation$ZegoLocationInfo.class */
    public static class ZegoLocationInfo {
        public double longitude = 0.0d;
        public double latitude = 0.0d;
    }

    private static boolean checkLocationPermission(Context context) {
        return context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    public static ZegoLocationInfo getLastLocation(Context context) {
        LocationManager locationManager;
        if (context != null && Build.VERSION.SDK_INT >= 23 && checkLocationPermission(context) && (locationManager = (LocationManager) context.getSystemService("location")) != null) {
            Location location = null;
            for (String str : locationManager.getProviders(true)) {
                Location lastKnownLocation = locationManager.getLastKnownLocation(str);
                if (lastKnownLocation != null && (location == null || lastKnownLocation.getAccuracy() < location.getAccuracy())) {
                    location = lastKnownLocation;
                }
            }
            if (location == null) {
                return null;
            }
            ZegoLocationInfo zegoLocationInfo = new ZegoLocationInfo();
            zegoLocationInfo.longitude = location.getLongitude();
            zegoLocationInfo.latitude = location.getLatitude();
            return zegoLocationInfo;
        }
        return null;
    }
}
