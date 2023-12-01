package com.anythink.core.common.e;

import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/o.class */
public final class o {
    public static final String h = "business_type";
    public static final int i = 1000;
    public static final int j = 1001;

    /* renamed from: a  reason: collision with root package name */
    public String f6671a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public String f6672c;
    public String d;
    public String e;
    public long f;
    public String g;

    public static String a(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(h, i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    public final String a() {
        return this.d + "--extra: " + this.g + "--requestType: " + this.b + "--content:" + this.e;
    }
}
