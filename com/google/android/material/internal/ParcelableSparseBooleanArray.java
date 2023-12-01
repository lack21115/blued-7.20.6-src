package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;

/* loaded from: source-8110460-dex2jar.jar:com/google/android/material/internal/ParcelableSparseBooleanArray.class */
public class ParcelableSparseBooleanArray extends SparseBooleanArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseBooleanArray> CREATOR = new Parcelable.Creator<ParcelableSparseBooleanArray>() { // from class: com.google.android.material.internal.ParcelableSparseBooleanArray.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableSparseBooleanArray createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            ParcelableSparseBooleanArray parcelableSparseBooleanArray = new ParcelableSparseBooleanArray(readInt);
            int[] iArr = new int[readInt];
            boolean[] zArr = new boolean[readInt];
            parcel.readIntArray(iArr);
            parcel.readBooleanArray(zArr);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    return parcelableSparseBooleanArray;
                }
                parcelableSparseBooleanArray.put(iArr[i2], zArr[i2]);
                i = i2 + 1;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableSparseBooleanArray[] newArray(int i) {
            return new ParcelableSparseBooleanArray[i];
        }
    };

    public ParcelableSparseBooleanArray() {
    }

    public ParcelableSparseBooleanArray(int i) {
        super(i);
    }

    public ParcelableSparseBooleanArray(SparseBooleanArray sparseBooleanArray) {
        super(sparseBooleanArray.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sparseBooleanArray.size()) {
                return;
            }
            put(sparseBooleanArray.keyAt(i2), sparseBooleanArray.valueAt(i2));
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int[] iArr = new int[size()];
        boolean[] zArr = new boolean[size()];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size()) {
                parcel.writeInt(size());
                parcel.writeIntArray(iArr);
                parcel.writeBooleanArray(zArr);
                return;
            }
            iArr[i3] = keyAt(i3);
            zArr[i3] = valueAt(i3);
            i2 = i3 + 1;
        }
    }
}
