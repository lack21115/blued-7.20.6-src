package com.tencent.open.yyb;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/yyb/ShareModel.class */
public class ShareModel implements Parcelable {
    public static final Parcelable.Creator<ShareModel> CREATOR = new Parcelable.Creator<ShareModel>() { // from class: com.tencent.open.yyb.ShareModel.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareModel createFromParcel(Parcel parcel) {
            ShareModel shareModel = new ShareModel();
            shareModel.f24615a = parcel.readString();
            shareModel.b = parcel.readString();
            shareModel.f24616c = parcel.readString();
            shareModel.d = parcel.readString();
            return shareModel;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareModel[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f24615a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f24616c;
    public String d;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f24615a);
        parcel.writeString(this.b);
        parcel.writeString(this.f24616c);
        parcel.writeString(this.d);
    }
}
