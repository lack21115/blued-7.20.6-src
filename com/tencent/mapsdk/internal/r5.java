package com.tencent.mapsdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/r5.class */
public class r5 implements Parcelable {
    public static final Parcelable.Creator<r5> CREATOR = new a();
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public String f24043c;
    public int d;
    public int e;
    public float f;
    public float g;
    public float h;
    public String i;
    public int j;
    public int k;
    public String l;
    public float m;
    public float n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public LatLng v;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/r5$a.class */
    public static final class a implements Parcelable.Creator<r5> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public r5 createFromParcel(Parcel parcel) {
            return new r5(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public r5[] newArray(int i) {
            return new r5[i];
        }
    }

    public r5() {
        this.f = 0.5f;
        this.g = 0.5f;
        this.h = 1.0f;
        this.o = 0;
        this.p = 3;
    }

    public r5(Parcel parcel) {
        this.f = 0.5f;
        this.g = 0.5f;
        this.h = 1.0f;
        this.o = 0;
        this.p = 3;
        this.b = parcel.readInt();
        this.f24043c = parcel.readString();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readFloat();
        this.g = parcel.readFloat();
        this.h = parcel.readFloat();
        this.i = parcel.readString();
        this.j = parcel.readInt();
        this.k = parcel.readInt();
        this.l = parcel.readString();
        this.m = parcel.readFloat();
        this.n = parcel.readFloat();
        this.o = parcel.readInt();
        this.p = parcel.readInt();
        this.q = parcel.readInt();
        this.r = parcel.readInt();
        this.s = parcel.readInt();
        this.v = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeString(this.f24043c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeFloat(this.f);
        parcel.writeFloat(this.g);
        parcel.writeFloat(this.h);
        parcel.writeString(this.i);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeString(this.l);
        parcel.writeFloat(this.m);
        parcel.writeFloat(this.n);
        parcel.writeInt(this.o);
        parcel.writeInt(this.p);
        parcel.writeInt(this.q);
        parcel.writeInt(this.r);
        parcel.writeInt(this.s);
        parcel.writeParcelable(this.v, i);
    }
}
