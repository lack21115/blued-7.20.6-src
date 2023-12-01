package com.umeng.analytics.pro;

import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/ab.class */
public class ab extends z {

    /* renamed from: a  reason: collision with root package name */
    private String f40612a;
    private String b;

    public ab(String str, ArrayList<aa> arrayList) {
        super(str, arrayList);
        this.f40612a = "";
        this.b = "";
    }

    @Override // com.umeng.analytics.pro.z, com.umeng.analytics.pro.ag
    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject a2 = super.a(str, jSONObject);
        if (a2 != null) {
            try {
                a2.put(com.umeng.ccg.a.s, this.f40612a);
                a2.put("action", this.b);
            } catch (Throwable th) {
                return a2;
            }
        }
        return a2;
    }

    public void c(String str) {
        this.f40612a = str;
    }

    public String d() {
        return this.f40612a;
    }

    public void d(String str) {
        this.b = str;
    }

    public String e() {
        return this.b;
    }
}
