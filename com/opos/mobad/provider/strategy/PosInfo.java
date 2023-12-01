package com.opos.mobad.provider.strategy;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/strategy/PosInfo.class */
public class PosInfo implements Parcelable {
    public static final Parcelable.Creator<PosInfo> CREATOR = new Parcelable.Creator<PosInfo>() { // from class: com.opos.mobad.provider.strategy.PosInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PosInfo createFromParcel(Parcel parcel) {
            long readLong = parcel.readLong();
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            return new PosInfo(bArr, readLong);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PosInfo[] newArray(int i) {
            return new PosInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f27134a;
    public final long b;

    public PosInfo(byte[] bArr, long j) {
        this.f27134a = bArr;
        this.b = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.b);
        parcel.writeInt(this.f27134a.length);
        parcel.writeByteArray(this.f27134a);
    }
}
