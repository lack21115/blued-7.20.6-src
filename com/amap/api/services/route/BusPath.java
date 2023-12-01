package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/BusPath.class */
public class BusPath extends Path implements Parcelable {
    public static final Parcelable.Creator<BusPath> CREATOR = new Parcelable.Creator<BusPath>() { // from class: com.amap.api.services.route.BusPath.1
        private static BusPath a(Parcel parcel) {
            return new BusPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusPath createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusPath[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f5676a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private float f5677c;
    private float d;
    private List<BusStep> e;

    public BusPath() {
        this.e = new ArrayList();
    }

    public BusPath(Parcel parcel) {
        super(parcel);
        this.e = new ArrayList();
        this.f5676a = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.b = zArr[0];
        this.f5677c = parcel.readFloat();
        this.d = parcel.readFloat();
        this.e = parcel.createTypedArrayList(BusStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBusDistance() {
        return this.d;
    }

    public float getCost() {
        return this.f5676a;
    }

    public List<BusStep> getSteps() {
        return this.e;
    }

    public float getWalkDistance() {
        return this.f5677c;
    }

    public boolean isNightBus() {
        return this.b;
    }

    public void setBusDistance(float f) {
        this.d = f;
    }

    public void setCost(float f) {
        this.f5676a = f;
    }

    public void setNightBus(boolean z) {
        this.b = z;
    }

    public void setSteps(List<BusStep> list) {
        this.e = list;
    }

    public void setWalkDistance(float f) {
        this.f5677c = f;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f5676a);
        parcel.writeBooleanArray(new boolean[]{this.b});
        parcel.writeFloat(this.f5677c);
        parcel.writeFloat(this.d);
        parcel.writeTypedList(this.e);
    }
}
