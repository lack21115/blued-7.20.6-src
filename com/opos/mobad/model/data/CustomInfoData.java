package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.anythink.expressad.foundation.d.c;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/data/CustomInfoData.class */
public class CustomInfoData implements Parcelable {
    public static final Parcelable.Creator<CustomInfoData> CREATOR = new Parcelable.Creator<CustomInfoData>() { // from class: com.opos.mobad.model.data.CustomInfoData.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CustomInfoData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                return new CustomInfoData(parcel.readString());
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CustomInfoData[] newArray(int i) {
            return new CustomInfoData[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f26470a;
    private JSONObject b;

    public CustomInfoData(String str) {
        String str2 = str == null ? "" : str;
        this.f26470a = str2;
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.b = new JSONObject(this.f26470a);
        } catch (JSONException e) {
            com.opos.cmn.an.f.a.a("", e);
        }
    }

    public boolean a() {
        JSONObject jSONObject = this.b;
        boolean z = false;
        if (1 == (jSONObject != null ? jSONObject.optInt("c_vrs", 0) : 0)) {
            z = true;
        }
        return z;
    }

    public int b() {
        JSONObject jSONObject = this.b;
        int i = 0;
        if (jSONObject != null) {
            i = jSONObject.optInt("c_il", 0);
        }
        return i;
    }

    public int c() {
        JSONObject jSONObject = this.b;
        int i = 2;
        if (jSONObject != null) {
            i = jSONObject.optInt("c_vp", 2);
        }
        return i;
    }

    public int d() {
        JSONObject jSONObject = this.b;
        int i = 0;
        if (jSONObject != null) {
            i = jSONObject.optInt("c_lo", 0);
        }
        return i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        JSONObject jSONObject = this.b;
        int i = 0;
        if (jSONObject != null) {
            i = jSONObject.optInt("c_iom", 0);
        }
        return i;
    }

    public int f() {
        JSONObject jSONObject = this.b;
        int i = 3000;
        if (jSONObject != null) {
            i = jSONObject.optInt(c.ab, 3000);
        }
        return i;
    }

    public int g() {
        JSONObject jSONObject = this.b;
        int i = 2000;
        if (jSONObject != null) {
            i = jSONObject.optInt("c_dpt", 2000);
        }
        return i;
    }

    public String toString() {
        return "CustomInfoData{mInfoString='" + this.f26470a + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f26470a);
    }
}
