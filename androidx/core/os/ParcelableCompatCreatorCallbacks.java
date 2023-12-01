package androidx.core.os;

import android.os.Parcel;

@Deprecated
/* loaded from: source-8756600-dex2jar.jar:androidx/core/os/ParcelableCompatCreatorCallbacks.class */
public interface ParcelableCompatCreatorCallbacks<T> {
    T createFromParcel(Parcel parcel, ClassLoader classLoader);

    T[] newArray(int i);
}
