package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/DrivePath.class */
public class DrivePath extends Path implements Parcelable {
    public static final Parcelable.Creator<DrivePath> CREATOR = new Parcelable.Creator<DrivePath>() { // from class: com.amap.api.services.route.DrivePath.1
        private static DrivePath a(Parcel parcel) {
            return new DrivePath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePath createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePath[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f5694a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f5695c;
    private int d;
    private List<DriveStep> e;
    private int f;

    public DrivePath() {
        this.e = new ArrayList();
    }

    public DrivePath(Parcel parcel) {
        super(parcel);
        this.e = new ArrayList();
        this.f5694a = parcel.readString();
        this.b = parcel.readFloat();
        this.f5695c = parcel.readFloat();
        this.e = parcel.createTypedArrayList(DriveStep.CREATOR);
        this.d = parcel.readInt();
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getRestriction() {
        return this.f;
    }

    public List<DriveStep> getSteps() {
        return this.e;
    }

    public String getStrategy() {
        return this.f5694a;
    }

    public float getTollDistance() {
        return this.f5695c;
    }

    public float getTolls() {
        return this.b;
    }

    public int getTotalTrafficlights() {
        return this.d;
    }

    public void setRestriction(int i) {
        this.f = i;
    }

    public void setSteps(List<DriveStep> list) {
        this.e = list;
    }

    public void setStrategy(String str) {
        this.f5694a = str;
    }

    public void setTollDistance(float f) {
        this.f5695c = f;
    }

    public void setTolls(float f) {
        this.b = f;
    }

    public void setTotalTrafficlights(int i) {
        this.d = i;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f5694a);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.f5695c);
        parcel.writeTypedList(this.e);
        parcel.writeInt(this.d);
    }
}
