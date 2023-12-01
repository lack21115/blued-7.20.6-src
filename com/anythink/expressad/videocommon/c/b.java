package com.anythink.expressad.videocommon.c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/c/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private int f8761a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private a f8762c;

    public b(int i, int i2, a aVar) {
        this.f8761a = i;
        this.b = i2;
        this.f8762c = aVar;
    }

    public static List<b> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    return arrayList;
                }
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                int optInt = optJSONObject.optInt("id");
                int optInt2 = optJSONObject.optInt("timeout");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("params");
                arrayList.add(new b(optInt, optInt2, optJSONObject2 != null ? a.a(optJSONObject2) : null));
                i = i2 + 1;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private void a(int i) {
        this.f8761a = i;
    }

    private void a(a aVar) {
        this.f8762c = aVar;
    }

    private void b(int i) {
        this.b = i;
    }

    private a c() {
        return this.f8762c;
    }

    public final int a() {
        return this.f8761a;
    }

    public final int b() {
        return this.b;
    }
}
