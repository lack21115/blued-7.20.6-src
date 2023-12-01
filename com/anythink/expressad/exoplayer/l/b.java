package com.anythink.expressad.exoplayer.l;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.k.af;
import com.blued.das.live.LiveProtos;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/l/b.class */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.anythink.expressad.exoplayer.l.b.1
        private static b a(Parcel parcel) {
            return new b(parcel);
        }

        private static b[] a() {
            return new b[0];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ b[] newArray(int i) {
            return new b[0];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f7693a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7694c;
    public final byte[] d;
    private int e;

    private b(int i, int i2, int i3, byte[] bArr) {
        this.f7693a = i;
        this.b = i2;
        this.f7694c = i3;
        this.d = bArr;
    }

    b(Parcel parcel) {
        this.f7693a = parcel.readInt();
        this.b = parcel.readInt();
        this.f7694c = parcel.readInt();
        this.d = af.a(parcel) ? parcel.createByteArray() : null;
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
        b bVar = (b) obj;
        return this.f7693a == bVar.f7693a && this.b == bVar.b && this.f7694c == bVar.f7694c && Arrays.equals(this.d, bVar.d);
    }

    public final int hashCode() {
        if (this.e == 0) {
            this.e = ((((((this.f7693a + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + this.b) * 31) + this.f7694c) * 31) + Arrays.hashCode(this.d);
        }
        return this.e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ColorInfo(");
        sb.append(this.f7693a);
        sb.append(", ");
        sb.append(this.b);
        sb.append(", ");
        sb.append(this.f7694c);
        sb.append(", ");
        sb.append(this.d != null);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7693a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.f7694c);
        af.a(parcel, this.d != null);
        byte[] bArr = this.d;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
