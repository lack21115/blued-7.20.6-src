package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/TruckPath.class */
public class TruckPath implements Parcelable {
    public static final Parcelable.Creator<TruckPath> CREATOR = new Parcelable.Creator<TruckPath>() { // from class: com.amap.api.services.route.TruckPath.1
        private static TruckPath a(Parcel parcel) {
            return new TruckPath(parcel);
        }

        private static TruckPath[] a(int i) {
            return new TruckPath[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckPath createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckPath[] newArray(int i) {
            return a(i);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f5773a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private String f5774c;
    private float d;
    private float e;
    private int f;
    private int g;
    private List<TruckStep> h;

    public TruckPath() {
    }

    protected TruckPath(Parcel parcel) {
        this.f5773a = parcel.readFloat();
        this.b = parcel.readLong();
        this.f5774c = parcel.readString();
        this.d = parcel.readFloat();
        this.e = parcel.readFloat();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.createTypedArrayList(TruckStep.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f5773a;
    }

    public long getDuration() {
        return this.b;
    }

    public int getRestriction() {
        return this.g;
    }

    public List<TruckStep> getSteps() {
        return this.h;
    }

    public String getStrategy() {
        return this.f5774c;
    }

    public float getTollDistance() {
        return this.e;
    }

    public float getTolls() {
        return this.d;
    }

    public int getTotalTrafficlights() {
        return this.f;
    }

    public void setDistance(float f) {
        this.f5773a = f;
    }

    public void setDuration(long j) {
        this.b = j;
    }

    public void setRestriction(int i) {
        this.g = i;
    }

    public void setSteps(List<TruckStep> list) {
        this.h = list;
    }

    public void setStrategy(String str) {
        this.f5774c = str;
    }

    public void setTollDistance(float f) {
        this.e = f;
    }

    public void setTolls(float f) {
        this.d = f;
    }

    public void setTotalTrafficlights(int i) {
        this.f = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f5773a);
        parcel.writeLong(this.b);
        parcel.writeString(this.f5774c);
        parcel.writeFloat(this.d);
        parcel.writeFloat(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeTypedList(this.h);
    }
}
