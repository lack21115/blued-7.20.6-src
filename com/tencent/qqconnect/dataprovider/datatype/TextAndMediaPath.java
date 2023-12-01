package com.tencent.qqconnect.dataprovider.datatype;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qqconnect/dataprovider/datatype/TextAndMediaPath.class */
public class TextAndMediaPath implements Parcelable {
    public static final Parcelable.Creator<TextAndMediaPath> CREATOR = new Parcelable.Creator<TextAndMediaPath>() { // from class: com.tencent.qqconnect.dataprovider.datatype.TextAndMediaPath.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextAndMediaPath createFromParcel(Parcel parcel) {
            return new TextAndMediaPath(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextAndMediaPath[] newArray(int i) {
            return new TextAndMediaPath[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f24966a;
    private String b;

    private TextAndMediaPath(Parcel parcel) {
        this.f24966a = parcel.readString();
        this.b = parcel.readString();
    }

    public TextAndMediaPath(String str, String str2) {
        this.f24966a = str;
        this.b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMediaPath() {
        return this.b;
    }

    public String getText() {
        return this.f24966a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f24966a);
        parcel.writeString(this.b);
    }
}
