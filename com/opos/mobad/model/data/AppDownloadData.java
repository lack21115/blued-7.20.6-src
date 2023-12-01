package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/data/AppDownloadData.class */
public class AppDownloadData extends a implements Parcelable {
    public static final Parcelable.Creator<AppDownloadData> CREATOR = new Parcelable.Creator<AppDownloadData>() { // from class: com.opos.mobad.model.data.AppDownloadData.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppDownloadData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                AppDownloadData appDownloadData = new AppDownloadData();
                appDownloadData.a(parcel.readString());
                appDownloadData.b(parcel.readString());
                appDownloadData.d(parcel.readString());
                appDownloadData.c(parcel.readString());
                return appDownloadData;
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppDownloadData[] newArray(int i) {
            return new AppDownloadData[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f26466a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f26467c;
    private String d;

    public String a() {
        return this.f26466a;
    }

    public void a(String str) {
        this.f26466a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.f26467c;
    }

    public void c(String str) {
        this.f26467c = str;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "appDownloadData{url=" + this.f26466a + ", md5=" + this.b + ", pkgName=" + this.f26467c + ", appName=" + this.d + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f26466a);
        parcel.writeString(this.b);
        parcel.writeString(this.f26467c);
        parcel.writeString(this.d);
    }
}
