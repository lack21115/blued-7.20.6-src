package com.opos.mobad.provider.record;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/record/CookieData.class */
public class CookieData implements Parcelable {
    public static final Parcelable.Creator<CookieData> CREATOR = new Parcelable.Creator<CookieData>() { // from class: com.opos.mobad.provider.record.CookieData.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CookieData createFromParcel(Parcel parcel) {
            return new CookieData(parcel.readString(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CookieData[] newArray(int i) {
            return new CookieData[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f13438a;
    public final long b;

    public CookieData(String str, long j) {
        this.f13438a = str;
        this.b = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(TextUtils.isEmpty(this.f13438a) ? "" : this.f13438a);
        parcel.writeLong(this.b);
    }
}
