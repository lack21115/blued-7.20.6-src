package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/poisearch/IndoorData.class */
public class IndoorData implements Parcelable {
    public static final Parcelable.Creator<IndoorData> CREATOR = new Parcelable.Creator<IndoorData>() { // from class: com.amap.api.services.poisearch.IndoorData.1
        private static IndoorData a(Parcel parcel) {
            return new IndoorData(parcel);
        }

        private static IndoorData[] a(int i) {
            return new IndoorData[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorData createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorData[] newArray(int i) {
            return a(i);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f5659a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private String f5660c;

    protected IndoorData(Parcel parcel) {
        this.f5659a = parcel.readString();
        this.b = parcel.readInt();
        this.f5660c = parcel.readString();
    }

    public IndoorData(String str, int i, String str2) {
        this.f5659a = str;
        this.b = i;
        this.f5660c = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFloor() {
        return this.b;
    }

    public String getFloorName() {
        return this.f5660c;
    }

    public String getPoiId() {
        return this.f5659a;
    }

    public void setFloor(int i) {
        this.b = i;
    }

    public void setFloorName(String str) {
        this.f5660c = str;
    }

    public void setPoiId(String str) {
        this.f5659a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5659a);
        parcel.writeInt(this.b);
        parcel.writeString(this.f5660c);
    }
}
