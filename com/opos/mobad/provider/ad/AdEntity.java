package com.opos.mobad.provider.ad;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/ad/AdEntity.class */
public class AdEntity implements Parcelable {
    public static final Parcelable.Creator<AdEntity> CREATOR = new Parcelable.Creator<AdEntity>() { // from class: com.opos.mobad.provider.ad.AdEntity.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdEntity createFromParcel(Parcel parcel) {
            return new AdEntity(parcel.createByteArray(), parcel.createByteArray(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdEntity[] newArray(int i) {
            return new AdEntity[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public byte[] f13422a;
    public byte[] b;

    /* renamed from: c  reason: collision with root package name */
    public long f13423c;

    public AdEntity(byte[] bArr, byte[] bArr2, long j) {
        this.f13422a = bArr;
        this.b = bArr2;
        this.f13423c = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.f13422a);
        parcel.writeByteArray(this.b);
        parcel.writeLong(this.f13423c);
    }
}
