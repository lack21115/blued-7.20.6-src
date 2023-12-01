package com.tencent.mapsdk.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/d7.class */
public class d7 {
    public static <T extends Parcelable> T a(T t) {
        Parcel obtain = Parcel.obtain();
        obtain.writeParcelable(t, 0);
        obtain.setDataPosition(0);
        T t2 = (T) obtain.readParcelable(t.getClass().getClassLoader());
        obtain.recycle();
        return t2;
    }
}
