package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/Railway.class */
public class Railway implements Parcelable {
    public static final Parcelable.Creator<Railway> CREATOR = new Parcelable.Creator<Railway>() { // from class: com.amap.api.services.route.Railway.1
        private static Railway a(Parcel parcel) {
            return new Railway(parcel);
        }

        private static Railway[] a(int i) {
            return new Railway[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Railway createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Railway[] newArray(int i) {
            return a(i);
        }
    };
    private String a;
    private String b;

    public Railway() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Railway(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getID() {
        return this.a;
    }

    public String getName() {
        return this.b;
    }

    public void setID(String str) {
        this.a = str;
    }

    public void setName(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }
}
