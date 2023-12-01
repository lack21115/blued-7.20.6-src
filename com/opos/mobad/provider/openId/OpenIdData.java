package com.opos.mobad.provider.openId;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/openId/OpenIdData.class */
public class OpenIdData implements Parcelable {
    public static final Parcelable.Creator<OpenIdData> CREATOR = new Parcelable.Creator<OpenIdData>() { // from class: com.opos.mobad.provider.openId.OpenIdData.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public OpenIdData createFromParcel(Parcel parcel) {
            return new OpenIdData(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public OpenIdData[] newArray(int i) {
            return new OpenIdData[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f27120a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f27121c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenIdData(String str, String str2, String str3) {
        this.f27120a = str;
        this.b = str2;
        this.f27121c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(TextUtils.isEmpty(this.f27120a) ? "" : this.f27120a);
        parcel.writeString(TextUtils.isEmpty(this.b) ? "" : this.b);
        parcel.writeString(TextUtils.isEmpty(this.f27121c) ? "" : this.f27121c);
    }
}
