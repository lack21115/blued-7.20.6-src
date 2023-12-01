package com.kwad.sdk.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/r.class */
public final class r {
    private static boolean azJ;
    private static Location azK;

    private static Location a(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
                if (lastKnownLocation == null) {
                    azJ = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e) {
            azJ = true;
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return null;
        }
    }

    private static Location b(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("network");
                if (lastKnownLocation == null) {
                    azJ = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e) {
            azJ = true;
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return null;
        }
    }

    public static Location bL(Context context) {
        if (!at.DU() || at.DV() == null) {
            if (azJ || azK != null || context == null) {
                return azK;
            }
            if (at.DU() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(64L)) {
                return null;
            }
            try {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                if (locationManager.isProviderEnabled("gps")) {
                    azK = a(context, locationManager);
                }
                if (azK == null && locationManager.isProviderEnabled("network")) {
                    azK = b(context, locationManager);
                }
                if (azK == null && locationManager.isProviderEnabled(LocationManager.PASSIVE_PROVIDER)) {
                    azK = c(context, locationManager);
                }
                return azK;
            } catch (Exception e) {
                azJ = true;
                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                return null;
            }
        }
        return at.DV();
    }

    private static Location c(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
                if (lastKnownLocation == null) {
                    azJ = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e) {
            azJ = true;
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return null;
        }
    }
}
