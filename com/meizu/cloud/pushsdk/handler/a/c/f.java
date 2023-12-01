package com.meizu.cloud.pushsdk.handler.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/handler/a/c/f.class */
public class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new Parcelable.Creator<f>() { // from class: com.meizu.cloud.pushsdk.handler.a.c.f.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public f[] newArray(int i) {
            return new f[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f24151a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24152c;
    private String d;
    private String e;

    public f() {
        this.f24152c = false;
    }

    protected f(Parcel parcel) {
        boolean z = false;
        this.f24152c = false;
        this.f24151a = parcel.readString();
        this.b = parcel.readString();
        this.f24152c = parcel.readByte() != 0 ? true : z;
        this.d = parcel.readString();
        this.e = parcel.readString();
    }

    public static f a(JSONObject jSONObject) {
        String str;
        f fVar = new f();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull(DBDefinition.TASK_ID)) {
                    fVar.a(jSONObject.getString(DBDefinition.TASK_ID));
                }
                if (!jSONObject.isNull("time")) {
                    fVar.b(jSONObject.getString("time"));
                }
                if (!jSONObject.isNull("pushExtra")) {
                    fVar.a(jSONObject.getInt("pushExtra") == 0);
                    return fVar;
                }
            } catch (JSONException e) {
                str = " parse statics message error " + e.getMessage();
            }
            return fVar;
        }
        str = "no control statics can parse ";
        DebugLogger.e("statics", str);
        return fVar;
    }

    public String a() {
        return this.f24151a;
    }

    public void a(String str) {
        this.f24151a = str;
    }

    public void a(boolean z) {
        this.f24152c = z;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.d = str;
    }

    public boolean c() {
        return this.f24152c;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.e;
    }

    public String toString() {
        return "Statics{taskId='" + this.f24151a + "', time='" + this.b + "', pushExtra=" + this.f24152c + ", deviceId='" + this.d + "', seqId='" + this.e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f24151a);
        parcel.writeString(this.b);
        parcel.writeByte(this.f24152c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
    }
}
