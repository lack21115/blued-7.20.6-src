package com.soft.blued.ui.pay.googlepay.util;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/googlepay/util/Purchase.class */
public class Purchase {

    /* renamed from: a  reason: collision with root package name */
    String f33012a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    String f33013c;
    String d;
    long e;
    int f;
    String g;
    String h;
    String i;
    String j;
    boolean k;

    public Purchase(String str, String str2, String str3) throws JSONException {
        this.f33012a = str;
        this.i = str2;
        JSONObject jSONObject = new JSONObject(this.i);
        this.b = jSONObject.optString("orderId");
        this.f33013c = jSONObject.optString("packageName");
        this.d = jSONObject.optString("productId");
        this.e = jSONObject.optLong("purchaseTime");
        this.f = jSONObject.optInt("purchaseState");
        this.g = jSONObject.optString("developerPayload");
        this.h = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
        this.k = jSONObject.optBoolean("autoRenewing");
        this.j = str3;
    }

    public String a() {
        return this.f33012a;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.h;
    }

    public String toString() {
        return "PurchaseInfo(type:" + this.f33012a + "):" + this.i;
    }
}
