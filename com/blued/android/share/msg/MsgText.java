package com.blued.android.share.msg;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/share/msg/MsgText.class */
public class MsgText extends AbsShareMsg {
    public static final Parcelable.Creator<MsgText> CREATOR = new Parcelable.Creator<MsgText>() { // from class: com.blued.android.share.msg.MsgText.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MsgText createFromParcel(Parcel parcel) {
            return new MsgText(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MsgText[] newArray(int i) {
            return new MsgText[i];
        }
    };
    public String summary;
    public String targetUrl;
    public String title;

    public MsgText() {
    }

    public MsgText(Parcel parcel) {
        this.title = parcel.readString();
        this.summary = parcel.readString();
        this.targetUrl = parcel.readString();
        this.pType = parcel.readInt();
        this.appName = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.summary);
        parcel.writeString(this.targetUrl);
        parcel.writeInt(this.pType);
        parcel.writeString(this.appName);
    }
}
