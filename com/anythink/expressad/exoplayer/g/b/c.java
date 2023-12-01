package com.anythink.expressad.exoplayer.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.k.af;
import com.blued.das.live.LiveProtos;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/b/c.class */
public final class c extends h {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.anythink.expressad.exoplayer.g.b.c.1
        private static c a(Parcel parcel) {
            return new c(parcel);
        }

        private static c[] a(int i) {
            return new c[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ c[] newArray(int i) {
            return new c[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final String f7346a = "CHAP";
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7347c;
    public final int d;
    public final long e;
    public final long f;
    private final h[] h;

    c(Parcel parcel) {
        super(f7346a);
        this.b = parcel.readString();
        this.f7347c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readLong();
        this.f = parcel.readLong();
        int readInt = parcel.readInt();
        this.h = new h[readInt];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            this.h[i2] = (h) parcel.readParcelable(h.class.getClassLoader());
            i = i2 + 1;
        }
    }

    public c(String str, int i, int i2, long j, long j2, h[] hVarArr) {
        super(f7346a);
        this.b = str;
        this.f7347c = i;
        this.d = i2;
        this.e = j;
        this.f = j2;
        this.h = hVarArr;
    }

    private int a() {
        return this.h.length;
    }

    private h a(int i) {
        return this.h[i];
    }

    @Override // com.anythink.expressad.exoplayer.g.b.h, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f7347c == cVar.f7347c && this.d == cVar.d && this.e == cVar.e && this.f == cVar.f && af.a((Object) this.b, (Object) cVar.b) && Arrays.equals(this.h, cVar.h);
    }

    public final int hashCode() {
        int i = this.f7347c;
        int i2 = this.d;
        int i3 = (int) this.e;
        int i4 = (int) this.f;
        String str = this.b;
        return ((((((((i + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeInt(this.f7347c);
        parcel.writeInt(this.d);
        parcel.writeLong(this.e);
        parcel.writeLong(this.f);
        parcel.writeInt(this.h.length);
        h[] hVarArr = this.h;
        int length = hVarArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            parcel.writeParcelable(hVarArr[i3], 0);
            i2 = i3 + 1;
        }
    }
}
