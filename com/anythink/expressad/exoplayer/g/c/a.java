package com.anythink.expressad.exoplayer.g.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.k.s;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/g/c/a.class */
public final class a extends b {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.anythink.expressad.exoplayer.g.c.a.1
        private static a a(Parcel parcel) {
            return new a(parcel, (byte) 0);
        }

        private static a[] a(int i) {
            return new a[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ a createFromParcel(Parcel parcel) {
            return new a(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ a[] newArray(int i) {
            return new a[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final long f4525a;
    public final long b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f4526c;

    private a(long j, byte[] bArr, long j2) {
        this.f4525a = j2;
        this.b = j;
        this.f4526c = bArr;
    }

    private a(Parcel parcel) {
        this.f4525a = parcel.readLong();
        this.b = parcel.readLong();
        byte[] bArr = new byte[parcel.readInt()];
        this.f4526c = bArr;
        parcel.readByteArray(bArr);
    }

    /* synthetic */ a(Parcel parcel, byte b) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(s sVar, int i, long j) {
        long h = sVar.h();
        int i2 = i - 4;
        byte[] bArr = new byte[i2];
        sVar.a(bArr, 0, i2);
        return new a(h, bArr, j);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4525a);
        parcel.writeLong(this.b);
        parcel.writeInt(this.f4526c.length);
        parcel.writeByteArray(this.f4526c);
    }
}
