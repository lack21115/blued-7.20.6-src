package com.meizu.cloud.pushsdk.handler.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/handler/a/c/b.class */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.meizu.cloud.pushsdk.handler.a.c.b.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b[] newArray(int i) {
            return new b[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f24139a;
    private a b;

    /* renamed from: c  reason: collision with root package name */
    private f f24140c;

    public b() {
    }

    protected b(Parcel parcel) {
        this.f24139a = parcel.readString();
        this.b = (a) parcel.readParcelable(a.class.getClassLoader());
        this.f24140c = (f) parcel.readParcelable(f.class.getClassLoader());
    }

    public b(String str, String str2, String str3) {
        this.f24139a = str;
        if (TextUtils.isEmpty(str)) {
            this.b = new a();
            this.f24140c = new f();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b = a.a(jSONObject.getJSONObject("ctl"));
            f a2 = f.a(jSONObject.getJSONObject("statics"));
            this.f24140c = a2;
            a2.c(str2);
            this.f24140c.d(str3);
        } catch (JSONException e) {
            this.b = new a();
            this.f24140c = new f();
            DebugLogger.e("ControlMessage", "parse control message error " + e.getMessage());
        }
    }

    public static b a(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.a(a.a(jSONObject.getJSONObject("ctl")));
            bVar.a(f.a(jSONObject.getJSONObject("statics")));
            return bVar;
        } catch (Exception e) {
            DebugLogger.e("ControlMessage", "parse control message error " + e.getMessage());
            bVar.a(new f());
            bVar.a(new a());
            return bVar;
        }
    }

    public a a() {
        return this.b;
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public void a(f fVar) {
        this.f24140c = fVar;
    }

    public f b() {
        return this.f24140c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ControlMessage{controlMessage='" + this.f24139a + "', control=" + this.b + ", statics=" + this.f24140c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f24139a);
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.f24140c, i);
    }
}
