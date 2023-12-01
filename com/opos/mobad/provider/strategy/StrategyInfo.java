package com.opos.mobad.provider.strategy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/strategy/StrategyInfo.class */
public class StrategyInfo implements Parcelable {
    public static final Parcelable.Creator<StrategyInfo> CREATOR = new Parcelable.Creator<StrategyInfo>() { // from class: com.opos.mobad.provider.strategy.StrategyInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public StrategyInfo createFromParcel(Parcel parcel) {
            return new StrategyInfo(parcel.readLong(), parcel.readBundle());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public StrategyInfo[] newArray(int i) {
            return new StrategyInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final long f13447a;
    public final Bundle b;

    public StrategyInfo(long j, Bundle bundle) {
        this.f13447a = j;
        this.b = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f13447a);
        parcel.writeBundle(this.b);
    }
}
