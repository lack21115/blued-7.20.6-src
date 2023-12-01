package com.android.internal.util;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/ParcelableString.class */
public class ParcelableString implements Parcelable {
    public static final Parcelable.Creator<ParcelableString> CREATOR = new Parcelable.Creator<ParcelableString>() { // from class: com.android.internal.util.ParcelableString.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableString createFromParcel(Parcel parcel) {
            ParcelableString parcelableString = new ParcelableString();
            parcelableString.string = parcel.readString();
            return parcelableString;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableString[] newArray(int i) {
            return new ParcelableString[i];
        }
    };
    public String string;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.string);
    }
}
