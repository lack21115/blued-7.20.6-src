package com.tencent.mapsdk.internal;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/s5.class */
public class s5 {
    public static final int e = 0;
    public static final int f = 1;

    /* renamed from: a  reason: collision with root package name */
    private int f37991a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private JSONArray f37992c;
    private String[] d;

    public s5() {
        this.d = new String[0];
    }

    public s5(int i, int i2, JSONArray jSONArray) {
        this.d = new String[0];
        this.f37991a = i;
        this.b = i2;
        this.f37992c = jSONArray;
        if (jSONArray == null) {
            this.d = null;
            return;
        }
        int length = jSONArray.length();
        this.d = new String[length];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return;
            }
            try {
                this.d[i4] = this.f37992c.getString(i4);
                i3 = i4 + 1;
            } catch (JSONException e2) {
                this.d = null;
                na.b(Log.getStackTraceString(e2));
                return;
            }
        }
    }

    public JSONArray a() {
        return this.f37992c;
    }

    public String[] b() {
        return this.d;
    }

    public int c() {
        return this.f37991a;
    }

    public int d() {
        return this.b;
    }

    public boolean e() {
        return this.f37991a == 1;
    }

    public boolean f() {
        return this.b == 1;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("IndoorAuth{");
        stringBuffer.append("mEnabled=");
        stringBuffer.append(this.f37991a);
        stringBuffer.append(", mType=");
        stringBuffer.append(this.b);
        stringBuffer.append(", mBuildingJsonArray=");
        stringBuffer.append(this.f37992c);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
