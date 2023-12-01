package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.fk;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.beans.metadata.Location;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.utils.ab;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/ac.class */
public class ac {
    private static Location B;
    private static final byte[] C = new byte[0];
    private static final String Code = "LocationUtils";
    private static final int D = 2;
    private static final int F = 1;
    private static LocationManager I;
    private static final int L = 1;
    private static long S = -1;
    private static final long V = 30000;
    private static String Z;

    /* renamed from: a  reason: collision with root package name */
    private static long f9384a = 1800000;
    private static volatile boolean b = false;

    private static void B(final Context context) {
        ge.V(Code, "loc_tag sendAsyncLocation go!");
        if (I(context)) {
            S = System.currentTimeMillis();
            ge.V(Code, "update lastRefreshTime");
            f.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ac.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ac.Z(Context.this);
                    } catch (Throwable th) {
                        ge.Z(ac.Code, "loc_tag asyncLocation exception: " + th.getClass().getSimpleName());
                    }
                }
            });
        }
    }

    private static void C(final Context context) {
        ge.Code(Code, "loc_tag getLocationByKit");
        try {
            new ab(context, new ab.a() { // from class: com.huawei.openalliance.ad.utils.ac.5
                @Override // com.huawei.openalliance.ad.utils.ab.a
                public void Code() {
                    try {
                        ac.V(Context.this, 2);
                    } catch (Throwable th) {
                        ge.V(ac.Code, "onLocationAcquireFailed ex: %s", th.getClass().getSimpleName());
                    }
                }

                @Override // com.huawei.openalliance.ad.utils.ab.a
                public void Code(android.location.Location location) {
                    try {
                        ac.Code(location);
                    } catch (Throwable th) {
                        ge.V(ac.Code, "onLocationAcquired ex: %s", th.getClass().getSimpleName());
                    }
                }
            }).Code();
        } catch (Throwable th) {
            ge.Z(Code, "loc_tag getLocationByKit, exception = " + th.getClass().getSimpleName());
        }
    }

    public static Location Code(Context context, RequestOptions requestOptions, Location location) {
        Location location2;
        boolean V2 = V(context, requestOptions);
        ge.V(Code, "loc_tag media allow: %s", Boolean.valueOf(V2));
        com.huawei.openalliance.ad.beans.inner.b F2 = F(context);
        boolean z = false;
        if (V2) {
            z = false;
            if (F2.Z()) {
                z = true;
            }
        }
        if (!z) {
            ge.V(Code, "loc_tag isLocationAvailable = false, return null");
            location2 = null;
        } else if (location == null) {
            B(context);
            Location location3 = B;
            location2 = location3 == null ? null : location3.Code();
        } else {
            location2 = location.Code();
            location2.Code(Long.valueOf(System.currentTimeMillis()));
            location2.Code(1);
        }
        Location location4 = location2;
        if (location2 == null) {
            location4 = new Location();
        }
        location4.Code(F2);
        return location4;
    }

    public static Location Code(android.location.Location location) {
        if (location == null) {
            return null;
        }
        synchronized (C) {
            if (B == null) {
                B = new Location();
            }
            B.Code(Double.valueOf(location.getLongitude()));
            B.V(Double.valueOf(location.getLatitude()));
            B.Code(Long.valueOf(System.currentTimeMillis()));
        }
        return B;
    }

    public static void Code(final Context context, RequestOptions requestOptions) {
        if (V(context, requestOptions) && I(context)) {
            if (ge.Code()) {
                ge.Code(Code, "loc_tag sendAsyncLocationByNative go!");
            }
            f.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ac.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ac.F(Context.this).Z()) {
                        ac.V(Context.this, 1);
                    } else {
                        ge.V(ac.Code, "loc_tag sendAsyncLocationByNative failed because switch is off");
                    }
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private static com.huawei.openalliance.ad.beans.inner.b D(Context context) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.huawei.openalliance.ad.beans.inner.b F(Context context) {
        com.huawei.openalliance.ad.beans.inner.b D2 = D(context);
        boolean z = false;
        if (D2.B()) {
            z = fk.Code(context).B();
            ge.Code(Code, "loc_tag isSdkServerLocationSwitch = %s", Boolean.valueOf(z));
        }
        D2.Code(z);
        return D2;
    }

    private static boolean I(Context context) {
        long abs = Math.abs(System.currentTimeMillis() - S);
        f9384a = fk.Code(context).S();
        ge.Code(Code, "loc_tag isRefreshOk intervalRefreshTime = " + f9384a + ", intervalTime = " + abs);
        if (abs < f9384a) {
            ge.Code(Code, "loc_tag isRefreshOk = false, too frequently (no ok)");
            return false;
        }
        return true;
    }

    private static boolean L(Context context) {
        String str;
        boolean z = false;
        if (context == null) {
            str = "loc_tag isGpsSwitchOpen Context is null";
        } else if (Build.VERSION.SDK_INT < 19) {
            return !TextUtils.isEmpty(Settings.Secure.getString(context.getContentResolver(), "location_providers_allowed"));
        } else {
            try {
                int i = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE);
                ge.V(Code, "loc_tag isGpsSwitchOpen locationMode is " + i);
                if (i == 3) {
                    z = true;
                }
                return z;
            } catch (Settings.SettingNotFoundException e) {
                str = "loc_tag isGpsSwitchOpen SettingNotFoundException";
            }
        }
        ge.Z(Code, str);
        return false;
    }

    private static boolean S(Context context) {
        boolean z;
        try {
        } catch (Throwable th) {
            ge.Z(Code, "loc_tag check location sdk available error");
        }
        if (Class.forName("com.huawei.hms.location.LocationServices") != null) {
            if (Class.forName("com.huawei.hms.location.FusedLocationProviderClient") != null) {
                z = true;
                return z && e.Code(context, e.I(context));
            }
        }
        z = false;
        if (z) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Context context, int i) {
        ge.Code(Code, "loc_tag getLocationByNative");
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        I = locationManager;
        if (locationManager == null) {
            ge.Z(Code, "loc_tag getLocationByNative, nativeLocationManager is null, return");
            return;
        }
        List<String> providers = locationManager.getProviders(true);
        String str = "network";
        if (!providers.contains("network")) {
            str = "gps";
            if (!providers.contains("gps")) {
                ge.I(Code, "loc_tag nativeLocationProvider wrong, return");
                return;
            }
        }
        Z = str;
        if (ge.Code()) {
            ge.Code(Code, "loc_tag native location provider is: %s", Z);
        }
        try {
            if (Z != null) {
                if (1 == i) {
                    android.location.Location lastKnownLocation = I.getLastKnownLocation(Z);
                    if (lastKnownLocation == null) {
                        ge.I(Code, "loc_tag getLocationByNative, but location is null");
                        return;
                    }
                    ge.Code(Code, "loc_tag getLocationByNative getLastKnownLocation lat = %s, lon = %s", bc.Code(String.valueOf(lastKnownLocation.getLatitude())), bc.Code(String.valueOf(lastKnownLocation.getLongitude())));
                    Code(lastKnownLocation);
                } else if (2 != i) {
                    ge.Code(Code, "loc_tag requestLocationByNative not correct type");
                } else {
                    ge.V(Code, "loc_tag getLocationByNative requestLocationUpdates");
                    b = false;
                    final LocationListener locationListener = new LocationListener() { // from class: com.huawei.openalliance.ad.utils.ac.3
                        @Override // android.location.LocationListener
                        public void onLocationChanged(android.location.Location location) {
                            try {
                                if (location != null) {
                                    ge.Code(ac.Code, "loc_tag getLocationByNative Listener lat = %s, lon = %s", bc.Code(String.valueOf(location.getLatitude())), bc.Code(String.valueOf(location.getLongitude())));
                                    ac.Code(location);
                                } else {
                                    ge.I(ac.Code, "loc_tag getLocationByNative Listener, but location is null");
                                }
                            } catch (Throwable th) {
                                ge.V(ac.Code, "onLocationChanged ex: %s", th.getClass().getSimpleName());
                            }
                            ac.V(this);
                        }

                        @Override // android.location.LocationListener
                        public void onProviderDisabled(String str2) {
                            ge.Code(ac.Code, "loc_tag getLocationByNative onProviderDisabled");
                            ac.V(this);
                        }

                        @Override // android.location.LocationListener
                        public void onProviderEnabled(String str2) {
                            ge.Code(ac.Code, "loc_tag getLocationByNative onProviderEnabled");
                            ac.V(this);
                        }

                        @Override // android.location.LocationListener
                        public void onStatusChanged(String str2, int i2, Bundle bundle) {
                            ge.Code(ac.Code, "loc_tag getLocationByNative onStatusChanged");
                            ac.V(this);
                        }
                    };
                    I.requestSingleUpdate(Z, locationListener, Looper.getMainLooper());
                    ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ac.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ac.b) {
                                return;
                            }
                            ac.V(LocationListener.this);
                        }
                    }, 30000L);
                }
            }
        } catch (Throwable th) {
            ge.Z(Code, "loc_tag getLocationByNative, exception = " + th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(LocationListener locationListener) {
        if (b || I == null || locationListener == null) {
            return;
        }
        ge.V(Code, "loc_tag remove native location updates");
        try {
            I.removeUpdates(locationListener);
        } catch (Throwable th) {
            ge.V(Code, "loc_tag remove native location updates ex: %s", th.getClass().getSimpleName());
        }
        b = true;
    }

    private static boolean V() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private static boolean V(Context context, RequestOptions requestOptions) {
        Boolean I2;
        if (requestOptions == null || requestOptions.I() == null) {
            RequestOptions requestConfiguration = HiAd.getInstance(context).getRequestConfiguration();
            if (requestConfiguration == null || requestConfiguration.I() == null) {
                return true;
            }
            I2 = requestConfiguration.I();
        } else {
            I2 = requestOptions.I();
        }
        return I2.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Z(Context context) {
        if (S(context)) {
            ge.V(Code, "loc_tag asyncLocation has location-sdk");
            try {
                C(context);
                return;
            } catch (Throwable th) {
                ge.I(Code, "loc_tag get location by kit error, " + th.getClass().getSimpleName());
                ge.Code(5, th);
            }
        } else {
            ge.V(Code, "loc_tag asyncLocation has not location-sdk");
        }
        V(context, 2);
    }

    private static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        if (V()) {
            ArrayList<String> arrayList = new ArrayList();
            arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
            for (String str : arrayList) {
                if (!al.Code(context, str)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    private static boolean b(Context context) {
        try {
            return L(context);
        } catch (Throwable th) {
            ge.I(Code, "get location service switch exception: " + th.getClass().getSimpleName());
            return false;
        }
    }
}
