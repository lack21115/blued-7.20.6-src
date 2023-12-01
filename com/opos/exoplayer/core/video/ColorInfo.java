package com.opos.exoplayer.core.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.blued.das.live.LiveProtos;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/video/ColorInfo.class */
public final class ColorInfo implements Parcelable {
    public static final Parcelable.Creator<ColorInfo> CREATOR = new Parcelable.Creator<ColorInfo>() { // from class: com.opos.exoplayer.core.video.ColorInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ColorInfo createFromParcel(Parcel parcel) {
            return new ColorInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ColorInfo[] newArray(int i) {
            return new ColorInfo[0];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f11871a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11872c;
    public final byte[] d;
    private int e;

    public ColorInfo(int i, int i2, int i3, byte[] bArr) {
        this.f11871a = i;
        this.b = i2;
        this.f11872c = i3;
        this.d = bArr;
    }

    ColorInfo(Parcel parcel) {
        this.f11871a = parcel.readInt();
        this.b = parcel.readInt();
        this.f11872c = parcel.readInt();
        this.d = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            z = false;
            if (obj != null) {
                if (getClass() != obj.getClass()) {
                    return false;
                }
                ColorInfo colorInfo = (ColorInfo) obj;
                z = false;
                if (this.f11871a == colorInfo.f11871a) {
                    z = false;
                    if (this.b == colorInfo.b) {
                        z = false;
                        if (this.f11872c == colorInfo.f11872c) {
                            if (!Arrays.equals(this.d, colorInfo.d)) {
                                return false;
                            }
                        }
                    }
                }
            }
            return z;
        }
        z = true;
        return z;
    }

    public int hashCode() {
        if (this.e == 0) {
            this.e = ((((((this.f11871a + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + this.b) * 31) + this.f11872c) * 31) + Arrays.hashCode(this.d);
        }
        return this.e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(this.f11871a);
        sb.append(", ");
        sb.append(this.b);
        sb.append(", ");
        sb.append(this.f11872c);
        sb.append(", ");
        sb.append(this.d != null);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f11871a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.f11872c);
        parcel.writeInt(this.d != null ? 1 : 0);
        byte[] bArr = this.d;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
