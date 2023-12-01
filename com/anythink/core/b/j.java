package com.anythink.core.b;

import com.anythink.core.common.l;
import com.cdo.oaps.ad.OapsKey;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/b/j.class */
public final class j implements Comparable<j> {

    /* renamed from: a  reason: collision with root package name */
    int f6386a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    double f6387c;
    String d;

    private double a() {
        return this.f6387c;
    }

    private int a(j jVar) {
        return this.f6386a < jVar.f6386a ? -1 : 1;
    }

    public static j a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            j jVar = new j();
            jVar.f6386a = jSONObject.optInt("prority");
            jVar.b = jSONObject.optString("ad_source_id");
            if (jSONObject.has(l.am)) {
                jVar.f6387c = jSONObject.optDouble(l.am);
            } else if (jSONObject.has(OapsKey.KEY_PRICE)) {
                jVar.f6387c = jSONObject.optDouble(OapsKey.KEY_PRICE);
            } else {
                jVar.f6387c = 0.0d;
            }
            jVar.d = jSONObject.optString("tp_bid_id");
            return jVar;
        } catch (Throwable th) {
            return null;
        }
    }

    private void a(double d) {
        this.f6387c = d;
    }

    private String b() {
        return this.b;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(j jVar) {
        return this.f6386a < jVar.f6386a ? -1 : 1;
    }
}
