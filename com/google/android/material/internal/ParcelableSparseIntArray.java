package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;

/* loaded from: source-8110460-dex2jar.jar:com/google/android/material/internal/ParcelableSparseIntArray.class */
public class ParcelableSparseIntArray extends SparseIntArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = new Parcelable.Creator<ParcelableSparseIntArray>() { // from class: com.google.android.material.internal.ParcelableSparseIntArray.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableSparseIntArray createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            ParcelableSparseIntArray parcelableSparseIntArray = new ParcelableSparseIntArray(readInt);
            int[] iArr = new int[readInt];
            int[] iArr2 = new int[readInt];
            parcel.readIntArray(iArr);
            parcel.readIntArray(iArr2);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    return parcelableSparseIntArray;
                }
                parcelableSparseIntArray.put(iArr[i2], iArr2[i2]);
                i = i2 + 1;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableSparseIntArray[] newArray(int i) {
            return new ParcelableSparseIntArray[i];
        }
    };

    public ParcelableSparseIntArray() {
    }

    public ParcelableSparseIntArray(int i) {
        super(i);
    }

    public ParcelableSparseIntArray(SparseIntArray sparseIntArray) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sparseIntArray.size()) {
                return;
            }
            put(sparseIntArray.keyAt(i2), sparseIntArray.valueAt(i2));
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
        int[] iArr2 = new int[size()];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size()) {
                parcel.writeInt(size());
                parcel.writeIntArray(iArr);
                parcel.writeIntArray(iArr2);
                return;
            }
            iArr[i3] = keyAt(i3);
            iArr2[i3] = valueAt(i3);
            i2 = i3 + 1;
        }
    }
}
