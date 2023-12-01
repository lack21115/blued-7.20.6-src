package com.anythink.expressad.exoplayer.g.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.g.a;
import com.anythink.expressad.exoplayer.k.af;
import com.blued.das.live.LiveProtos;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/a/a.class */
public final class a implements a.InterfaceC0058a {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.anythink.expressad.exoplayer.g.a.a.1
        private static a a(Parcel parcel) {
            return new a(parcel);
        }

        private static a[] a(int i) {
            return new a[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ a[] newArray(int i) {
            return new a[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f4502a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final long f4503c;
    public final long d;
    public final long e;
    public final byte[] f;
    private int g;

    a(Parcel parcel) {
        this.f4502a = parcel.readString();
        this.b = parcel.readString();
        this.d = parcel.readLong();
        this.f4503c = parcel.readLong();
        this.e = parcel.readLong();
        this.f = parcel.createByteArray();
    }

    public a(String str, String str2, long j, long j2, byte[] bArr, long j3) {
        this.f4502a = str;
        this.b = str2;
        this.f4503c = j;
        this.e = j2;
        this.f = bArr;
        this.d = j3;
    }

    @Override // android.os.Parcelable
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
        a aVar = (a) obj;
        return this.d == aVar.d && this.f4503c == aVar.f4503c && this.e == aVar.e && af.a((Object) this.f4502a, (Object) aVar.f4502a) && af.a((Object) this.b, (Object) aVar.b) && Arrays.equals(this.f, aVar.f);
    }

    public final int hashCode() {
        if (this.g == 0) {
            String str = this.f4502a;
            int i = 0;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.b;
            if (str2 != null) {
                i = str2.hashCode();
            }
            long j = this.d;
            int i2 = (int) (j ^ (j >>> 32));
            long j2 = this.f4503c;
            int i3 = (int) (j2 ^ (j2 >>> 32));
            long j3 = this.e;
            this.g = ((((((((((hashCode + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + i) * 31) + i2) * 31) + i3) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + Arrays.hashCode(this.f);
        }
        return this.g;
    }

    public final String toString() {
        return "EMSG: scheme=" + this.f4502a + ", id=" + this.e + ", value=" + this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4502a);
        parcel.writeString(this.b);
        parcel.writeLong(this.d);
        parcel.writeLong(this.f4503c);
        parcel.writeLong(this.e);
        parcel.writeByteArray(this.f);
    }
}
