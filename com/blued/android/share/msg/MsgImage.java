package com.blued.android.share.msg;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/share/msg/MsgImage.class */
public class MsgImage extends AbsShareMsg {
    public static final Parcelable.Creator<MsgImage> CREATOR = new Parcelable.Creator<MsgImage>() { // from class: com.blued.android.share.msg.MsgImage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MsgImage createFromParcel(Parcel parcel) {
            return new MsgImage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MsgImage[] newArray(int i) {
            return new MsgImage[i];
        }
    };
    public Bitmap image;
    public String imagePath;
    public String imageUrl;

    public MsgImage() {
    }

    public MsgImage(Parcel parcel) {
        this.pType = parcel.readInt();
        this.appName = parcel.readString();
        this.imageUrl = parcel.readString();
        this.imagePath = parcel.readString();
        this.image = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.pType);
        parcel.writeString(this.appName);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.imagePath);
        parcel.writeParcelable(this.image, 1);
    }
}
