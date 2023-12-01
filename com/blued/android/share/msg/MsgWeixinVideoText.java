package com.blued.android.share.msg;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/share/msg/MsgWeixinVideoText.class */
public class MsgWeixinVideoText extends MsgText {
    public static final Parcelable.Creator<MsgWeixinVideoText> CREATOR = new Parcelable.Creator<MsgWeixinVideoText>() { // from class: com.blued.android.share.msg.MsgWeixinVideoText.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MsgWeixinVideoText createFromParcel(Parcel parcel) {
            return new MsgWeixinVideoText(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MsgWeixinVideoText[] newArray(int i) {
            return new MsgWeixinVideoText[i];
        }
    };
    public Bitmap image;
    public String imageUrl;

    public MsgWeixinVideoText() {
    }

    public MsgWeixinVideoText(Parcel parcel) {
        super(parcel);
        this.imageUrl = parcel.readString();
        this.image = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
    }

    @Override // com.blued.android.share.msg.MsgText, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.imageUrl);
        parcel.writeParcelable(this.image, 1);
    }
}
