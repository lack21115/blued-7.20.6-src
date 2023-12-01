package com.meizu.cloud.pushsdk.handler.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.meizu.cloud.pushinternal.DebugLogger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/handler/a/c/g.class */
public class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new Parcelable.Creator<g>() { // from class: com.meizu.cloud.pushsdk.handler.a.c.g.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public g[] newArray(int i) {
            return new g[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f10538a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f10539c;
    private b d;
    private String e;

    protected g(Parcel parcel) {
        this.f10538a = parcel.readInt();
        this.b = parcel.readByte() != 0;
        this.f10539c = parcel.createStringArrayList();
        this.d = (b) parcel.readParcelable(b.class.getClassLoader());
        this.e = parcel.readString();
    }

    public g(String str, String str2, String str3, String str4) {
        this.e = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("max_size")) {
                this.f10538a = jSONObject.getInt("max_size");
            }
            if (!jSONObject.isNull("wifi_upload")) {
                this.b = jSONObject.getBoolean("wifi_upload");
            }
            if (!jSONObject.isNull("upload_files")) {
                JSONArray jSONArray = jSONObject.getJSONArray("upload_files");
                this.f10539c = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    this.f10539c.add(jSONArray.getString(i2));
                    i = i2 + 1;
                }
            }
        } catch (JSONException e) {
            DebugLogger.e("UploadLogMessage", "parse upload message error " + e.getMessage());
        }
        this.d = new b(str2, str3, str4);
    }

    public int a() {
        return this.f10538a;
    }

    public boolean b() {
        return this.b;
    }

    public List<String> c() {
        return this.f10539c;
    }

    public b d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UploadLogMessage{maxSize=" + this.f10538a + ", wifiUpload=" + this.b + ", fileList=" + this.f10539c + ", controlMessage=" + this.d + ", uploadMessage='" + this.e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f10538a);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.f10539c);
        parcel.writeParcelable(this.d, i);
        parcel.writeString(this.e);
    }
}
