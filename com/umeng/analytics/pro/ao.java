package com.umeng.analytics.pro;

import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/ao.class */
public class ao implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f26935a = "https://ucc.umeng.com/v2/inn/fetch";
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f26936c;
    private String d;

    public ao(String str, JSONObject jSONObject, String str2) {
        this.b = str;
        this.f26936c = jSONObject.toString();
        this.d = str2;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0052 -> B:9:0x003f). Please submit an issue!!! */
    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject;
        try {
            byte[] a2 = am.a(this.b, this.f26936c);
            jSONObject = null;
            if (a2 != null) {
                JSONObject jSONObject2 = new JSONObject(new String(a2));
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("sourceIucc", this.d);
                    jSONObject.put(com.igexin.push.core.b.U, jSONObject2);
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
            jSONObject = null;
        }
        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 102, com.umeng.ccg.d.a(), jSONObject);
    }
}
