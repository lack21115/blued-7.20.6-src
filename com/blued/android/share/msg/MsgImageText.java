package com.blued.android.share.msg;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/share/msg/MsgImageText.class */
public class MsgImageText extends MsgText {
    public static final Parcelable.Creator<MsgImageText> CREATOR = new Parcelable.Creator<MsgImageText>() { // from class: com.blued.android.share.msg.MsgImageText.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MsgImageText createFromParcel(Parcel parcel) {
            return new MsgImageText(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MsgImageText[] newArray(int i) {
            return new MsgImageText[i];
        }
    };
    public int hasImage;
    public Bitmap image;
    public String imageUrl;

    public MsgImageText() {
    }

    public MsgImageText(Parcel parcel) {
        super(parcel);
        this.imageUrl = parcel.readString();
        int readInt = parcel.readInt();
        this.hasImage = readInt;
        if (readInt == 1) {
            this.image = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        }
    }

    @Override // com.blued.android.share.msg.MsgText, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.imageUrl);
        this.hasImage = 0;
        Bitmap bitmap = this.image;
        if (bitmap != null && !bitmap.isRecycled()) {
            parcel.writeParcelable(this.image, 1);
            this.hasImage = 1;
        }
        parcel.writeInt(this.hasImage);
    }
}
