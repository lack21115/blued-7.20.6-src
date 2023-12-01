package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/poisearch/Photo.class */
public final class Photo implements Parcelable {
    public static final Parcelable.Creator<Photo> CREATOR = new Parcelable.Creator<Photo>() { // from class: com.amap.api.services.poisearch.Photo.1
        private static Photo a(Parcel parcel) {
            return new Photo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Photo createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Photo[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f5661a;
    private String b;

    public Photo() {
    }

    public Photo(Parcel parcel) {
        this.f5661a = parcel.readString();
        this.b = parcel.readString();
    }

    public Photo(String str, String str2) {
        this.f5661a = str;
        this.b = str2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getTitle() {
        return this.f5661a;
    }

    public final String getUrl() {
        return this.b;
    }

    public final void setTitle(String str) {
        this.f5661a = str;
    }

    public final void setUrl(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5661a);
        parcel.writeString(this.b);
    }
}
