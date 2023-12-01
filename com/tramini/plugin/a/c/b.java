package com.tramini.plugin.a.c;

import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/c/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f26809a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public String f26810c;

    public final JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("att_pl", this.b);
            jSONObject.put("att_ver", this.f26809a);
            jSONObject.put("att_inf", this.f26810c);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }
}
