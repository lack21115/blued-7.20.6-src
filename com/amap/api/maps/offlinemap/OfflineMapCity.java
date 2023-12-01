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
    private String a;
    private long b;
    private int c;
    private String d;
    private int e;

    public OfflineMapCity() {
        this.a = "";
        this.b = 0L;
        this.c = 6;
        this.d = "";
        this.e = 0;
    }

    public OfflineMapCity(Parcel parcel) {
        super(parcel);
        this.a = "";
        this.b = 0L;
        this.c = 6;
        this.d = "";
        this.e = 0;
        this.a = parcel.readString();
        this.b = parcel.readLong();
        this.c = parcel.readInt();
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
        return this.c;
    }

    public String getUrl() {
        return this.a;
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
        this.c = i;
    }

    public void setUrl(String str) {
        this.a = str;
    }

    public void setVersion(String str) {
        this.d = str;
    }

    @Override // com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.a);
        parcel.writeLong(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
    }
}
