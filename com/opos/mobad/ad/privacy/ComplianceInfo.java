package com.opos.mobad.ad.privacy;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/ad/privacy/ComplianceInfo.class */
public class ComplianceInfo implements Parcelable {
    public static final Parcelable.Creator<ComplianceInfo> CREATOR = new Parcelable.Creator<ComplianceInfo>() { // from class: com.opos.mobad.ad.privacy.ComplianceInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ComplianceInfo createFromParcel(Parcel parcel) {
            ComplianceInfo complianceInfo = null;
            if (parcel != null) {
                complianceInfo = new ComplianceInfo();
                complianceInfo.a(parcel.readString());
                complianceInfo.b(parcel.readString());
                complianceInfo.a(parcel.readHashMap(HashMap.class.getClassLoader()));
            }
            return complianceInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ComplianceInfo[] newArray(int i) {
            return new ComplianceInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11996a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f11997c;

    private ComplianceInfo() {
    }

    public ComplianceInfo(String str, String str2) {
        this.f11996a = str;
        this.b = str2;
    }

    public String a() {
        return this.f11996a;
    }

    public void a(String str) {
        this.f11996a = str;
    }

    public void a(HashMap<String, String> hashMap) {
        this.f11997c = hashMap;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public Map<String, String> c() {
        return this.f11997c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ComplianceInfo{privacyUrl='" + this.f11996a + "', permissionUrl='" + this.b + "', permissionMap=" + this.f11997c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11996a);
        parcel.writeString(this.b);
        parcel.writeMap(this.f11997c);
    }
}
