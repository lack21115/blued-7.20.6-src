package com.baidu.mobads.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bv.class */
final class bv implements Parcelable.Creator<bu> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public bu createFromParcel(Parcel parcel) {
        return new bu(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public bu[] newArray(int i) {
        return new bu[i];
    }
}
