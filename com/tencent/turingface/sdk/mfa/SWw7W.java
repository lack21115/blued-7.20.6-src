package com.tencent.turingface.sdk.mfa;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/SWw7W.class */
public final class SWw7W implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    public int f26228a;
    public byte[] b;

    /* renamed from: c  reason: collision with root package name */
    public int f26229c;

    public SWw7W(Parcel parcel) {
        this.f26228a = parcel.readInt();
        this.b = parcel.createByteArray();
        this.f26229c = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f26228a);
        parcel.writeByteArray(this.b);
        parcel.writeInt(this.f26229c);
    }
}
