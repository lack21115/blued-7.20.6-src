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
    public final int f4854a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4855c;
    public final byte[] d;
    private int e;

    private b(int i, int i2, int i3, byte[] bArr) {
        this.f4854a = i;
        this.b = i2;
        this.f4855c = i3;
        this.d = bArr;
    }

    b(Parcel parcel) {
        this.f4854a = parcel.readInt();
        this.b = parcel.readInt();
        this.f4855c = parcel.readInt();
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
        return this.f4854a == bVar.f4854a && this.b == bVar.b && this.f4855c == bVar.f4855c && Arrays.equals(this.d, bVar.d);
    }

    public final int hashCode() {
        if (this.e == 0) {
            this.e = ((((((this.f4854a + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + this.b) * 31) + this.f4855c) * 31) + Arrays.hashCode(this.d);
        }
        return this.e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ColorInfo(");
        sb.append(this.f4854a);
        sb.append(", ");
        sb.append(this.b);
        sb.append(", ");
        sb.append(this.f4855c);
        sb.append(", ");
        sb.append(this.d != null);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4854a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.f4855c);
        af.a(parcel, this.d != null);
        byte[] bArr = this.d;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
