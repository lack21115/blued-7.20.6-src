package com.opos.mobad.provider.strategy;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/strategy/AppInfo.class */
public class AppInfo implements Parcelable {
    public static final Parcelable.Creator<AppInfo> CREATOR = new Parcelable.Creator<AppInfo>() { // from class: com.opos.mobad.provider.strategy.AppInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppInfo createFromParcel(Parcel parcel) {
            long readLong = parcel.readLong();
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            return new AppInfo(readLong, bArr);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppInfo[] newArray(int i) {
            return new AppInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final long f13445a;
    public final byte[] b;

    public AppInfo(long j, byte[] bArr) {
        this.f13445a = j;
        this.b = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f13445a);
        parcel.writeInt(this.b.length);
        parcel.writeByteArray(this.b);
    }
}
