package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/weather/LocalWeatherForecast.class */
public class LocalWeatherForecast implements Parcelable {
    public static final Parcelable.Creator<LocalWeatherForecast> CREATOR = new Parcelable.Creator<LocalWeatherForecast>() { // from class: com.amap.api.services.weather.LocalWeatherForecast.1
        private static LocalWeatherForecast a(Parcel parcel) {
            return new LocalWeatherForecast(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LocalWeatherForecast createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LocalWeatherForecast[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f5799a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f5800c;
    private String d;
    private List<LocalDayWeatherForecast> e;

    public LocalWeatherForecast() {
        this.e = new ArrayList();
    }

    public LocalWeatherForecast(Parcel parcel) {
        this.e = new ArrayList();
        this.f5799a = parcel.readString();
        this.b = parcel.readString();
        this.f5800c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readArrayList(LocalWeatherForecast.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f5800c;
    }

    public String getCity() {
        return this.b;
    }

    public String getProvince() {
        return this.f5799a;
    }

    public String getReportTime() {
        return this.d;
    }

    public List<LocalDayWeatherForecast> getWeatherForecast() {
        return this.e;
    }

    public void setAdCode(String str) {
        this.f5800c = str;
    }

    public void setCity(String str) {
        this.b = str;
    }

    public void setProvince(String str) {
        this.f5799a = str;
    }

    public void setReportTime(String str) {
        this.d = str;
    }

    public void setWeatherForecast(List<LocalDayWeatherForecast> list) {
        this.e = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5799a);
        parcel.writeString(this.b);
        parcel.writeString(this.f5800c);
        parcel.writeString(this.d);
        parcel.writeList(this.e);
    }
}
