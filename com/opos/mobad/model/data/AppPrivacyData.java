package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/data/AppPrivacyData.class */
public class AppPrivacyData extends a implements Parcelable {
    public static final Parcelable.Creator<AppPrivacyData> CREATOR = new Parcelable.Creator<AppPrivacyData>() { // from class: com.opos.mobad.model.data.AppPrivacyData.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppPrivacyData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                return new AppPrivacyData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppPrivacyData[] newArray(int i) {
            return new AppPrivacyData[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f26468a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final String f26469c;
    public final String d;

    public AppPrivacyData(String str, String str2, String str3, String str4) {
        this.f26468a = str;
        this.b = str2;
        this.f26469c = str3;
        this.d = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "AppPrivacyData{permissionUrl=" + this.f26468a + ", privacyUrl='" + this.b + "', developerName=" + this.f26469c + ", verName=" + this.d + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f26468a);
        parcel.writeString(this.b);
        parcel.writeString(this.f26469c);
        parcel.writeString(this.d);
    }
}
