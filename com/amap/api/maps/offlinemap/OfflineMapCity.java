package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/offlinemap/OfflineMapCity.class */
public class OfflineMapCity extends City {
    public static final Parcelable.Creator<OfflineMapCity> CREATOR = new Parcelable.Creator<OfflineMapCity>() { // from class: com.amap.api.maps.offlinemap.OfflineMapCity.1
        private static OfflineMapCity a(Parcel parcel) {
            return new OfflineMapCity(parcel);
        }

        private static OfflineMapCity[] a(int i) {
            return new OfflineMapCity[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OfflineMapCity createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OfflineMapCity[] newArray(int i) {
            return a(i);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f5555a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private int f5556c;
    private String d;
    private int e;

    public OfflineMapCity() {
        this.f5555a = "";
        this.b = 0L;
        this.f5556c = 6;
        this.d = "";
        this.e = 0;
    }

    public OfflineMapCity(Parcel parcel) {
        super(parcel);
        this.f5555a = "";
        this.b = 0L;
        this.f5556c = 6;
        this.d = "";
        this.e = 0;
        this.f5555a = parcel.readString();
        this.b = parcel.readLong();
        this.f5556c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
    }

    @Override // com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getSize() {
        return this.b;
    }

    public int getState() {
        return this.f5556c;
    }

    public String getUrl() {
        return this.f5555a;
    }

    public String getVersion() {
        return this.d;
    }

    public int getcompleteCode() {
        return this.e;
    }

    public void setCompleteCode(int i) {
        this.e = i;
    }

    public void setSize(long j) {
        this.b = j;
    }

    public void setState(int i) {
        this.f5556c = i;
    }

    public void setUrl(String str) {
        this.f5555a = str;
    }

    public void setVersion(String str) {
        this.d = str;
    }

    @Override // com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f5555a);
        parcel.writeLong(this.b);
        parcel.writeInt(this.f5556c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
    }
}
