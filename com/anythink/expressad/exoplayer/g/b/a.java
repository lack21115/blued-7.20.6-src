package com.anythink.expressad.exoplayer.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.k.af;
import com.blued.das.live.LiveProtos;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/b/a.class */
public final class a extends h {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.anythink.expressad.exoplayer.g.b.a.1
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
    public static final String f4504a = "APIC";
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4505c;
    public final int d;
    public final byte[] e;

    a(Parcel parcel) {
        super(f4504a);
        this.b = parcel.readString();
        this.f4505c = parcel.readString();
        this.d = parcel.readInt();
        this.e = parcel.createByteArray();
    }

    public a(String str, String str2, int i, byte[] bArr) {
        super(f4504a);
        this.b = str;
        this.f4505c = str2;
        this.d = i;
        this.e = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.d == aVar.d && af.a((Object) this.b, (Object) aVar.b) && af.a((Object) this.f4505c, (Object) aVar.f4505c) && Arrays.equals(this.e, aVar.e);
    }

    public final int hashCode() {
        int i = this.d;
        String str = this.b;
        int i2 = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.f4505c;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((((((i + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + hashCode) * 31) + i2) * 31) + Arrays.hashCode(this.e);
    }

    @Override // com.anythink.expressad.exoplayer.g.b.h
    public final String toString() {
        return this.g + ": mimeType=" + this.b + ", description=" + this.f4505c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.f4505c);
        parcel.writeInt(this.d);
        parcel.writeByteArray(this.e);
    }
}
