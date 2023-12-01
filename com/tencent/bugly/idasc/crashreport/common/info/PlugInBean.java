package com.tencent.bugly.idasc.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/crashreport/common/info/PlugInBean.class */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new Parcelable.Creator<PlugInBean>() { // from class: com.tencent.bugly.idasc.crashreport.common.info.PlugInBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PlugInBean createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PlugInBean[] newArray(int i) {
            return new PlugInBean[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f21503a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final String f21504c;

    public PlugInBean(Parcel parcel) {
        this.f21503a = parcel.readString();
        this.b = parcel.readString();
        this.f21504c = parcel.readString();
    }

    public PlugInBean(String str, String str2, String str3) {
        this.f21503a = str;
        this.b = str2;
        this.f21504c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "plid:" + this.f21503a + " plV:" + this.b + " plUUID:" + this.f21504c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f21503a);
        parcel.writeString(this.b);
        parcel.writeString(this.f21504c);
    }
}
