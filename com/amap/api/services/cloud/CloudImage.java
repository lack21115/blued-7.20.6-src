package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/cloud/CloudImage.class */
public class CloudImage implements Parcelable {
    public static final Parcelable.Creator<CloudImage> CREATOR = new Parcelable.Creator<CloudImage>() { // from class: com.amap.api.services.cloud.CloudImage.1
        private static CloudImage a(Parcel parcel) {
            return new CloudImage(parcel);
        }

        private static CloudImage[] a(int i) {
            return new CloudImage[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudImage createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudImage[] newArray(int i) {
            return a(i);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f5595a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f5596c;

    public CloudImage(Parcel parcel) {
        this.f5595a = parcel.readString();
        this.b = parcel.readString();
        this.f5596c = parcel.readString();
    }

    public CloudImage(String str, String str2, String str3) {
        this.f5595a = str;
        this.b = str2;
        this.f5596c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.f5595a;
    }

    public String getPreurl() {
        return this.b;
    }

    public String getUrl() {
        return this.f5596c;
    }

    public void setId(String str) {
        this.f5595a = str;
    }

    public void setPreurl(String str) {
        this.b = str;
    }

    public void setUrl(String str) {
        this.f5596c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5595a);
        parcel.writeString(this.b);
        parcel.writeString(this.f5596c);
    }
}
