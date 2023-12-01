package com.tencent.qqconnect.dataprovider.datatype;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qqconnect/dataprovider/datatype/TextOnly.class */
public class TextOnly implements Parcelable {
    public static final Parcelable.Creator<TextOnly> CREATOR = new Parcelable.Creator<TextOnly>() { // from class: com.tencent.qqconnect.dataprovider.datatype.TextOnly.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextOnly createFromParcel(Parcel parcel) {
            return new TextOnly(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextOnly[] newArray(int i) {
            return new TextOnly[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f38658a;

    private TextOnly(Parcel parcel) {
        this.f38658a = parcel.readString();
    }

    public TextOnly(String str) {
        this.f38658a = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getText() {
        return this.f38658a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f38658a);
    }
}
