package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/DrivePlanPath.class */
public class DrivePlanPath implements Parcelable {
    public static final Parcelable.Creator<DrivePlanPath> CREATOR = new Parcelable.Creator<DrivePlanPath>() { // from class: com.amap.api.services.route.DrivePlanPath.1
        private static DrivePlanPath a(Parcel parcel) {
            return new DrivePlanPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePlanPath createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePlanPath[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    float f5698a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    private List<DrivePlanStep> f5699c;

    public DrivePlanPath() {
        this.f5699c = new ArrayList();
    }

    public DrivePlanPath(Parcel parcel) {
        this.f5699c = new ArrayList();
        this.f5698a = parcel.readFloat();
        this.b = parcel.readInt();
        this.f5699c = parcel.createTypedArrayList(DrivePlanStep.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f5698a;
    }

    public List<DrivePlanStep> getSteps() {
        return this.f5699c;
    }

    public float getTrafficLights() {
        return this.b;
    }

    public void setDistance(float f) {
        this.f5698a = f;
    }

    public void setSteps(List<DrivePlanStep> list) {
        this.f5699c = list;
    }

    public void setTrafficLights(int i) {
        this.b = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f5698a);
        parcel.writeInt(this.b);
        parcel.writeTypedList(this.f5699c);
    }
}
