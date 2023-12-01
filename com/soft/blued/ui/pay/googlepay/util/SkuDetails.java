package com.soft.blued.ui.pay.googlepay.util;

import com.cdo.oaps.ad.OapsKey;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/googlepay/util/SkuDetails.class */
public class SkuDetails {

    /* renamed from: a  reason: collision with root package name */
    private final String f19323a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f19324c;
    private final String d;
    private final long e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;

    public SkuDetails(String str, String str2) throws JSONException {
        this.f19323a = str;
        this.i = str2;
        JSONObject jSONObject = new JSONObject(this.i);
        this.b = jSONObject.optString("productId");
        this.f19324c = jSONObject.optString("type");
        this.d = jSONObject.optString(OapsKey.KEY_PRICE);
        this.e = jSONObject.optLong("price_amount_micros");
        this.f = jSONObject.optString("price_currency_code");
        this.g = jSONObject.optString("title");
        this.h = jSONObject.optString("description");
    }

    public String a() {
        return this.b;
    }

    public String getType() {
        return this.f19324c;
    }

    public String toString() {
        return "SkuDetails:" + this.i;
    }
}
