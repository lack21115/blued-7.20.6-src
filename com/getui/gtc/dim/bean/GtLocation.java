package com.getui.gtc.dim.bean;

import android.location.Location;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.getui.gtc.dim.e.b;
import com.umeng.analytics.pro.d;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/bean/GtLocation.class */
public class GtLocation implements Parcelable {
    public static final Parcelable.Creator<GtLocation> CREATOR = new Parcelable.Creator<GtLocation>() { // from class: com.getui.gtc.dim.bean.GtLocation.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GtLocation createFromParcel(Parcel parcel) {
            return new GtLocation(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GtLocation[] newArray(int i) {
            return new GtLocation[i];
        }
    };
    private float accuracy;
    private double altitude;
    private long elapsedRealtimeNanos;
    private boolean hasAccuracy;
    private double latitude;
    private double longitude;
    private String provider;
    private long time;

    private GtLocation() {
    }

    public GtLocation(Location location) {
        this.hasAccuracy = location.hasAccuracy();
        this.accuracy = location.getAccuracy();
        this.time = location.getTime();
        this.provider = location.getProvider();
        this.longitude = location.getLongitude();
        this.latitude = location.getLatitude();
        if (Build.VERSION.SDK_INT >= 17) {
            this.elapsedRealtimeNanos = location.getElapsedRealtimeNanos();
        }
        this.altitude = location.getAltitude();
    }

    protected GtLocation(Parcel parcel) {
        this.hasAccuracy = parcel.readByte() != 0;
        this.time = parcel.readLong();
        this.provider = parcel.readString();
        this.longitude = parcel.readDouble();
        this.latitude = parcel.readDouble();
        this.elapsedRealtimeNanos = parcel.readLong();
        this.altitude = parcel.readDouble();
        this.accuracy = parcel.readFloat();
    }

    public static GtLocation parseJson(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                GtLocation gtLocation = new GtLocation();
                gtLocation.hasAccuracy = jSONObject.optBoolean("hasAccuracy", false);
                gtLocation.time = jSONObject.optLong("time", 0L);
                gtLocation.provider = jSONObject.optString(d.M, "");
                gtLocation.longitude = jSONObject.optDouble("longitude", 0.0d);
                gtLocation.latitude = jSONObject.optDouble("latitude", 0.0d);
                gtLocation.elapsedRealtimeNanos = jSONObject.optLong("elapsedRealtimeNanos", 0L);
                gtLocation.altitude = jSONObject.optDouble("altitude", 0.0d);
                try {
                    gtLocation.accuracy = Float.parseFloat(jSONObject.optString("accuracy", "0"));
                    return gtLocation;
                } catch (Throwable th) {
                    return gtLocation;
                }
            } catch (JSONException e) {
                b.b(e);
                return null;
            }
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float distanceTo(double d, double d2) {
        double d3 = this.latitude;
        double d4 = (0.017453292519943295d * d2) - (this.longitude * 0.017453292519943295d);
        double atan = Math.atan(Math.tan(d3 * 0.017453292519943295d) * 0.996647189328169d);
        double atan2 = Math.atan(Math.tan(d * 0.017453292519943295d) * 0.996647189328169d);
        double cos = Math.cos(atan);
        double cos2 = Math.cos(atan2);
        double sin = Math.sin(atan);
        double sin2 = Math.sin(atan2);
        double d5 = cos * cos2;
        double d6 = sin * sin2;
        double d7 = d4;
        int i = 0;
        double d8 = 0.0d;
        double d9 = 0.0d;
        double d10 = 0.0d;
        while (true) {
            if (i >= 20) {
                break;
            }
            double cos3 = Math.cos(d7);
            double sin3 = Math.sin(d7);
            double d11 = cos2 * sin3;
            double d12 = (cos * sin2) - ((sin * cos2) * cos3);
            double sqrt = Math.sqrt((d11 * d11) + (d12 * d12));
            double d13 = d6 + (cos3 * d5);
            d10 = Math.atan2(sqrt, d13);
            double d14 = sqrt == 0.0d ? 0.0d : (sin3 * d5) / sqrt;
            double d15 = 1.0d - (d14 * d14);
            double d16 = d15 == 0.0d ? 0.0d : d13 - ((d6 * 2.0d) / d15);
            double d17 = 0.006739496756586903d * d15;
            d9 = ((d17 / 16384.0d) * (((((320.0d - (175.0d * d17)) * d17) - 768.0d) * d17) + 4096.0d)) + 1.0d;
            double d18 = (d17 / 1024.0d) * ((d17 * (((74.0d - (47.0d * d17)) * d17) - 128.0d)) + 256.0d);
            double d19 = 2.0955066698943685E-4d * d15 * (((4.0d - (d15 * 3.0d)) * 0.0033528106718309896d) + 4.0d);
            double d20 = d16 * d16;
            double d21 = d18 * sqrt * (d16 + ((d18 / 4.0d) * ((((d20 * 2.0d) - 1.0d) * d13) - ((((d18 / 6.0d) * d16) * (((sqrt * 4.0d) * sqrt) - 3.0d)) * ((d20 * 4.0d) - 3.0d)))));
            double d22 = d4 + ((1.0d - d19) * 0.0033528106718309896d * d14 * (d10 + (sqrt * d19 * (d16 + (d19 * d13 * (((2.0d * d16) * d16) - 1.0d))))));
            if (Math.abs((d22 - d7) / d22) < 1.0E-12d) {
                d8 = d21;
                break;
            }
            i++;
            d8 = d21;
            d7 = d22;
        }
        return (float) (d9 * 6356752.3142d * (d10 - d8));
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public long getElapsedRealtimeNanos() {
        return this.elapsedRealtimeNanos;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getProvider() {
        return this.provider;
    }

    public long getTime() {
        return this.time;
    }

    public boolean hasAccuracy() {
        return this.hasAccuracy;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasAccuracy", this.hasAccuracy);
            jSONObject.put("time", this.time);
            jSONObject.put(d.M, this.provider);
            jSONObject.put("longitude", this.longitude);
            jSONObject.put("latitude", this.latitude);
            jSONObject.put("elapsedRealtimeNanos", this.elapsedRealtimeNanos);
            jSONObject.put("altitude", this.altitude);
            jSONObject.put("accuracy", String.valueOf(this.accuracy));
            return jSONObject.toString();
        } catch (Throwable th) {
            b.b(th);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.hasAccuracy ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.time);
        parcel.writeString(this.provider);
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
        parcel.writeLong(this.elapsedRealtimeNanos);
        parcel.writeDouble(this.altitude);
        parcel.writeFloat(this.accuracy);
    }
}
