package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/weather/LocalWeatherLive.class */
public class LocalWeatherLive implements Parcelable {
    public static final Parcelable.Creator<LocalWeatherLive> CREATOR = new Parcelable.Creator<LocalWeatherLive>() { // from class: com.amap.api.services.weather.LocalWeatherLive.1
        private static LocalWeatherLive a(Parcel parcel) {
            return new LocalWeatherLive(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LocalWeatherLive createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LocalWeatherLive[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f5802a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f5803c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    public LocalWeatherLive() {
    }

    public LocalWeatherLive(Parcel parcel) {
        this.f5802a = parcel.readString();
        this.b = parcel.readString();
        this.f5803c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f5803c;
    }

    public String getCity() {
        return this.b;
    }

    public String getHumidity() {
        return this.h;
    }

    public String getProvince() {
        return this.f5802a;
    }

    public String getReportTime() {
        return this.i;
    }

    public String getTemperature() {
        return this.e;
    }

    public String getWeather() {
        return this.d;
    }

    public String getWindDirection() {
        return this.f;
    }

    public String getWindPower() {
        return this.g;
    }

    public void setAdCode(String str) {
        this.f5803c = str;
    }

    public void setCity(String str) {
        this.b = str;
    }

    public void setHumidity(String str) {
        this.h = str;
    }

    public void setProvince(String str) {
        this.f5802a = str;
    }

    public void setReportTime(String str) {
        this.i = str;
    }

    public void setTemperature(String str) {
        this.e = str;
    }

    public void setWeather(String str) {
        this.d = str;
    }

    public void setWindDirection(String str) {
        this.f = str;
    }

    public void setWindPower(String str) {
        this.g = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5802a);
        parcel.writeString(this.b);
        parcel.writeString(this.f5803c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
    }
}
