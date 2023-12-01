package com.getui.gtc.dim.c;

import android.location.Location;
import android.os.Build;
import android.os.Parcel;
import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/c/c.class */
public final class c {
    public static String a(Location location) throws JSONException {
        double readDouble;
        double readDouble2;
        double readDouble3;
        JSONObject jSONObject;
        int i = Build.VERSION.SDK_INT;
        if (i < 28) {
            jSONObject = b(location);
        } else {
            Parcel obtain = Parcel.obtain();
            try {
                location.writeToParcel(obtain, 0);
                obtain.setDataPosition(0);
                double d = 0.0d;
                if (i == 28) {
                    obtain.readString();
                    obtain.readLong();
                    obtain.readLong();
                    obtain.readByte();
                    readDouble = obtain.readDouble();
                    readDouble3 = obtain.readDouble();
                } else if (i == 29 || i == 30) {
                    obtain.readString();
                    obtain.readLong();
                    obtain.readLong();
                    obtain.readDouble();
                    obtain.readInt();
                    readDouble = obtain.readDouble();
                    readDouble3 = obtain.readDouble();
                } else if (i != 31 && i != 32) {
                    throw new UnsupportedOperationException("cannot read location,API>=33");
                } else {
                    obtain.readString();
                    obtain.readInt();
                    obtain.readLong();
                    obtain.readLong();
                    if (location.hasElapsedRealtimeUncertaintyNanos()) {
                        obtain.readDouble();
                    }
                    readDouble = obtain.readDouble();
                    readDouble2 = obtain.readDouble();
                    if (location.hasAltitude()) {
                        d = obtain.readDouble();
                    }
                    jSONObject = new JSONObject();
                    jSONObject.put("latitude", readDouble);
                    jSONObject.put("longitude", readDouble2);
                    jSONObject.put("altitude", d);
                }
                readDouble2 = readDouble3;
                d = obtain.readDouble();
                jSONObject = new JSONObject();
                jSONObject.put("latitude", readDouble);
                jSONObject.put("longitude", readDouble2);
                jSONObject.put("altitude", d);
            } finally {
                obtain.recycle();
            }
        }
        jSONObject.put("hasAccuracy", location.hasAccuracy());
        jSONObject.put("time", location.getTime());
        jSONObject.put(com.umeng.analytics.pro.d.M, location.getProvider());
        if (i >= 17) {
            jSONObject.put("elapsedRealtimeNanos", location.getElapsedRealtimeNanos());
        }
        jSONObject.put("accuracy", String.valueOf(location.getAccuracy()));
        return jSONObject.toString();
    }

    private static JSONObject b(Location location) {
        JSONObject jSONObject = new JSONObject();
        try {
            Field declaredField = Location.class.getDeclaredField("mLatitude");
            declaredField.setAccessible(true);
            Field declaredField2 = Location.class.getDeclaredField("mLongitude");
            declaredField2.setAccessible(true);
            Field declaredField3 = Location.class.getDeclaredField("mAltitude");
            declaredField3.setAccessible(true);
            jSONObject.put("latitude", declaredField.getDouble(location));
            jSONObject.put("longitude", declaredField2.getDouble(location));
            jSONObject.put("altitude", declaredField3.getDouble(location));
            return jSONObject;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a("location getBelow28", th);
            return jSONObject;
        }
    }
}
