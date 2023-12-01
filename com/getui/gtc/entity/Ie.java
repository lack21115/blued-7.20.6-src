package com.getui.gtc.entity;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/entity/Ie.class */
public class Ie implements Parcelable {
    public static final Parcelable.Creator<Ie> CREATOR = new Parcelable.Creator<Ie>() { // from class: com.getui.gtc.entity.Ie.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Ie createFromParcel(Parcel parcel) {
            return new Ie(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Ie[] newArray(int i) {
            return new Ie[i];
        }
    };
    private String aid;

    /* renamed from: cn  reason: collision with root package name */
    private String f22000cn;
    private String cs;
    private String k;

    public Ie() {
    }

    protected Ie(Parcel parcel) {
        this.f22000cn = parcel.readString();
        this.aid = parcel.readString();
        this.cs = parcel.readString();
        this.k = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.f22000cn;
        String str2 = ((Ie) obj).f22000cn;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public String getAid() {
        return this.aid;
    }

    public String getCn() {
        return this.f22000cn;
    }

    public String getCs() {
        return this.cs;
    }

    public String getK() {
        return this.k;
    }

    public int hashCode() {
        String str = this.f22000cn;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public void setCn(String str) {
        this.f22000cn = str;
    }

    public void setCs(String str) {
        this.cs = str;
    }

    public void setK(String str) {
        this.k = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f22000cn);
        parcel.writeString(this.aid);
        parcel.writeString(this.cs);
        parcel.writeString(this.k);
    }
}
