package com.alipay.sdk.packet;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/packet/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f4638a;
    private final String b;

    public b(String str, String str2) {
        this.f4638a = str;
        this.b = str2;
    }

    public String a() {
        return this.f4638a;
    }

    public String b() {
        return this.b;
    }

    public JSONObject c() {
        if (TextUtils.isEmpty(this.b)) {
            return null;
        }
        try {
            return new JSONObject(this.b);
        } catch (Exception e) {
            com.alipay.sdk.util.c.a(e);
            return null;
        }
    }

    public String toString() {
        return String.format("<Letter envelop=%s body=%s>", this.f4638a, this.b);
    }
}
