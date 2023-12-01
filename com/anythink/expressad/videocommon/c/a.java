package com.anythink.expressad.videocommon.c;

import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/c/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private String f5920a;
    private String b;

    private a(String str, String str2) {
        this.f5920a = str;
        this.b = str2;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return new a(jSONObject.optString("appId"), jSONObject.optString(com.anythink.expressad.videocommon.e.b.v));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private String a() {
        return this.f5920a;
    }

    private void a(String str) {
        this.f5920a = str;
    }

    private String b() {
        return this.b;
    }

    private void b(String str) {
        this.b = str;
    }
}
