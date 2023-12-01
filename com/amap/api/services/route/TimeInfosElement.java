package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/TimeInfosElement.class */
public class TimeInfosElement implements Parcelable {
    public static final Parcelable.Creator<TimeInfosElement> CREATOR = new Parcelable.Creator<TimeInfosElement>() { // from class: com.amap.api.services.route.TimeInfosElement.1
        private static TimeInfosElement a(Parcel parcel) {
            return new TimeInfosElement(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TimeInfosElement createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TimeInfosElement[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    int f5771a;
    float b;

    /* renamed from: c  reason: collision with root package name */
    float f5772c;
    int d;
    private List<TMC> e;

    public TimeInfosElement() {
        this.e = new ArrayList();
    }

    public TimeInfosElement(Parcel parcel) {
        this.e = new ArrayList();
        this.f5771a = parcel.readInt();
        this.b = parcel.readFloat();
        this.f5772c = parcel.readFloat();
        this.d = parcel.readInt();
        this.e = parcel.createTypedArrayList(TMC.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDuration() {
        return this.b;
    }

    public int getPathindex() {
        return this.f5771a;
    }

    public int getRestriction() {
        return this.d;
    }

    public List<TMC> getTMCs() {
        return this.e;
    }

    public float getTolls() {
        return this.f5772c;
    }

    public void setDuration(float f) {
        this.b = f;
    }

    public void setPathindex(int i) {
        this.f5771a = i;
    }

    public void setRestriction(int i) {
        this.d = i;
    }

    public void setTMCs(List<TMC> list) {
        this.e = list;
    }

    public void setTolls(float f) {
        this.f5772c = f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5771a);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.f5772c);
        parcel.writeInt(this.d);
        parcel.writeTypedList(this.e);
    }
}
