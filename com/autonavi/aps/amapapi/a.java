package com.autonavi.aps.amapapi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/a.class */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.autonavi.aps.amapapi.a.1
        private static a a(Parcel parcel) {
            a aVar = new a();
            aVar.c(parcel.readString());
            aVar.d(parcel.readString());
            aVar.e(parcel.readString());
            aVar.f(parcel.readString());
            aVar.b(parcel.readString());
            aVar.c(parcel.readLong());
            aVar.d(parcel.readLong());
            aVar.a(parcel.readLong());
            aVar.b(parcel.readLong());
            aVar.a(parcel.readString());
            return aVar;
        }

        private static a[] a(int i) {
            return new a[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ a createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ a[] newArray(int i) {
            return a(i);
        }
    };
    private String e;
    private String f;

    /* renamed from: a  reason: collision with root package name */
    private long f9220a = 0;
    private long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f9221c = 0;
    private long d = 0;
    private String g = "first";
    private String h = "";
    private String i = "";
    private String j = null;

    public final long a() {
        long j = this.d;
        long j2 = this.f9221c;
        if (j - j2 <= 0) {
            return 0L;
        }
        return j - j2;
    }

    public final void a(long j) {
        this.f9221c = j;
    }

    public final void a(String str) {
        this.i = str;
    }

    public final String b() {
        return this.i;
    }

    public final void b(long j) {
        this.d = j;
    }

    public final void b(String str) {
        this.j = str;
    }

    public final String c() {
        return this.j;
    }

    public final void c(long j) {
        this.f9220a = j;
    }

    public final void c(String str) {
        this.e = str;
    }

    public final String d() {
        return this.e;
    }

    public final void d(long j) {
        this.b = j;
    }

    public final void d(String str) {
        this.f = str;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f;
    }

    public final void e(String str) {
        this.g = str;
    }

    public final String f() {
        return this.g;
    }

    public final void f(String str) {
        this.h = str;
    }

    public final String g() {
        return this.h;
    }

    public final long h() {
        long j = this.b;
        long j2 = this.f9220a;
        if (j <= j2) {
            return 0L;
        }
        return j - j2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeString(this.e);
            parcel.writeString(this.f);
            parcel.writeString(this.g);
            parcel.writeString(this.h);
            parcel.writeString(this.j);
            parcel.writeLong(this.f9220a);
            parcel.writeLong(this.b);
            parcel.writeLong(this.f9221c);
            parcel.writeLong(this.d);
            parcel.writeString(this.i);
        } catch (Throwable th) {
        }
    }
}
