package com.opos.mobad.provider.record;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/record/CacheEntity.class */
public class CacheEntity implements Parcelable {
    public static final Parcelable.Creator<CacheEntity> CREATOR = new Parcelable.Creator<CacheEntity>() { // from class: com.opos.mobad.provider.record.CacheEntity.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CacheEntity createFromParcel(Parcel parcel) {
            return new CacheEntity(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CacheEntity[] newArray(int i) {
            return new CacheEntity[0];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f27123a;
    public final int b;

    public CacheEntity(int i, int i2) {
        this.f27123a = i;
        this.b = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f27123a);
        parcel.writeInt(this.b);
    }
}
