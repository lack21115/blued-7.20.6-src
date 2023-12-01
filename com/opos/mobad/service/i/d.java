package com.opos.mobad.service.i;

import android.content.Context;
import android.text.TextUtils;
import com.opos.acs.st.STManager;
import com.opos.mobad.provider.statistic.StatisticModelIdentify;
import com.opos.mobad.service.i.f;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/i/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f13694a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f13695c;
    private int d;
    private int e;
    private String f;
    private com.opos.mobad.provider.statistic.a g;
    private com.opos.mobad.provider.record.a h;
    private long i = 0;

    private d() {
    }

    public static d a() {
        d dVar;
        d dVar2 = f13694a;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (d.class) {
            try {
                if (f13694a == null) {
                    f13694a = new d();
                }
                dVar = f13694a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    private void a(String str, String str2, String str3, int i, long j, String str4, long j2) {
        try {
            JSONObject d = d();
            d.put(STManager.KEY_DATA_TYPE, "lm-show");
            d.put(STManager.KEY_AD_POS_ID, str);
            d.put("rt", j);
            d.put("adSource", str2);
            d.put("uSdkVC", this.d + "");
            if (str3 == null) {
                str3 = "";
            }
            d.put("sdkReqId", str3);
            d.put("ret", "2");
            d.put("rsCode", "" + i);
            if (str4 == null) {
                str4 = "";
            }
            d.put(UMModuleRegister.PROCESS, a(str4));
            d.put("stgVC", j2);
            a(d);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "error:", e);
        }
    }

    public static JSONObject b(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("StatisticManager", "", (Throwable) e);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("uSdkVC", this.d + "");
                jSONObject.put("bizSdkVer", this.d + "");
            } catch (JSONException e) {
                com.opos.cmn.an.f.a.a("StatisticManager", "", (Throwable) e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                jSONObject.put("sdkReqId", str != null ? str : "");
                if (str == null) {
                    str = "";
                }
                jSONObject.put("reqId", str);
            } catch (JSONException e) {
                com.opos.cmn.an.f.a.a("StatisticManager", "", (Throwable) e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appId", this.f13695c);
        jSONObject.put("phBrand", com.opos.cmn.an.b.a.a(this.b));
        jSONObject.put("phMaker", com.opos.cmn.an.b.c.e());
        jSONObject.put("aid", com.opos.mobad.service.e.a.a().e());
        jSONObject.put("ua", com.opos.cmn.i.d.a());
        jSONObject.put("coverVc", this.e);
        jSONObject.put("extInfo", !TextUtils.isEmpty(this.f) ? this.f : "");
        jSONObject.put("classifyByAge", com.opos.mobad.service.f.a.a().w());
        jSONObject.put("ouidStatus", com.opos.mobad.service.e.a.a().j() ? "1" : "0");
        jSONObject.put("appOuidStatus", com.opos.mobad.service.e.a.a().d() ? "1" : "0");
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                jSONObject.put(STManager.KEY_AD_POS_ID, str);
                jSONObject.put("newPosId", str);
            } catch (JSONException e) {
                com.opos.cmn.an.f.a.a("StatisticManager", "", (Throwable) e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                jSONObject.put(STManager.KEY_DATA_TYPE, str);
                jSONObject.put("oriDatatype", str);
            } catch (JSONException e) {
                com.opos.cmn.an.f.a.a("StatisticManager", "", (Throwable) e);
            }
        }
    }

    public void a(Context context, String str, int i, int i2) {
        this.b = context;
        this.f13695c = str;
        this.d = i;
        this.e = i2;
        this.g = new com.opos.mobad.provider.statistic.a(context, new StatisticModelIdentify(com.opos.cmn.a.a.a(), com.opos.cmn.a.a.b()));
        this.h = new com.opos.mobad.provider.record.a(context);
    }

    public void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("StatisticManager", "report null");
            return;
        }
        try {
            JSONObject d = d();
            d.put(STManager.KEY_DATA_TYPE, "lm-count");
            d.put(STManager.KEY_AD_POS_ID, str);
            d.put("event", "1:1");
            d.put("uCount", String.valueOf(i));
            d.put("uSdkVC", this.d + "");
            a(d);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "error:", e);
        }
    }

    public void a(String str, String str2, int i, int i2, int i3) {
        try {
            JSONObject d = d();
            e(d, "lm-bid-call");
            d.put("adPosId", str);
            d.put("appId", this.f13695c);
            d.put("uSdkVC", this.d + "");
            d.put("accType", 1);
            d.put("sdkReqId", str2);
            d.put("bidResult", 0);
            d.put("returnPrice", i2);
            d.put("sspWinPrice", i3);
            d.put("adSource", i);
            a(d);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "", e);
        }
    }

    public void a(String str, String str2, int i, long j, String str3, long j2) {
        try {
            JSONObject d = d();
            d.put(STManager.KEY_DATA_TYPE, "lm-show");
            d.put(STManager.KEY_AD_POS_ID, str);
            d.put("rt", j);
            d.put("adSource", "sdk_serial");
            d.put("uSdkVC", this.d + "");
            d.put("hitSource", i);
            if (str3 == null) {
                str3 = "";
            }
            d.put(UMModuleRegister.PROCESS, a(str3));
            if (str2 == null) {
                str2 = "";
            }
            d.put("sdkReqId", str2);
            d.put("ret", "1");
            d.put("stgVC", j2);
            a(d);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "error:", e);
        }
    }

    public void a(String str, String str2, int i, long j, String str3, String str4, long j2) {
        try {
            JSONObject d = d();
            d.put(STManager.KEY_DATA_TYPE, "lm-show");
            d.put(STManager.KEY_AD_POS_ID, str);
            d.put("rt", j);
            d.put("adSource", str4);
            d.put("hitSource", i);
            d.put("uSdkVC", this.d + "");
            if (str3 == null) {
                str3 = "";
            }
            d.put(UMModuleRegister.PROCESS, a(str3));
            if (str2 == null) {
                str2 = "";
            }
            d.put("sdkReqId", str2);
            d.put("ret", "1");
            d.put("stgVC", j2);
            a(d);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "error:", e);
        }
    }

    public void a(String str, String str2, int i, String str3, int i2, int i3, int i4) {
        try {
            JSONObject d = d();
            e(d, "lm-bid-call");
            d.put("adPosId", str);
            d.put("appId", this.f13695c);
            d.put("uSdkVC", this.d + "");
            d.put("accType", 1);
            d.put("sdkReqId", str2);
            d.put("bidResult", i);
            d.put("returnPrice", i3);
            d.put("adSource", i2);
            a(d);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "", e);
        }
    }

    public void a(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.i.d.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject d = d.this.d();
                    d.this.e(d, "lm-vip-callback");
                    d.d(d, str);
                    d.put("adSource", str3);
                    d.put("adId", str2);
                    d.put("pTraceId", str4);
                    d.put("platformPkg", d.this.b.getPackageName());
                    d.c(d, str5);
                    d.this.b(d);
                    d.put("token", str7);
                    com.opos.cmn.an.f.a.b("StatisticManager", "recordVIP map=", d);
                    d.this.g.a(str6, d.toString());
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("StatisticManager", "", (Throwable) e);
                }
            }
        });
    }

    public void a(String str, Map<String, String> map) {
        try {
            JSONObject d = d();
            d.put(STManager.KEY_DATA_TYPE, str);
            b(d);
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry != null) {
                        d.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            a(d);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "report fail", e);
        }
    }

    public void a(Map<String, String> map) {
        if (map != null) {
            try {
                if (map.size() > 0) {
                    a(b(map));
                    return;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("StatisticManager", "", (Throwable) e);
                return;
            }
        }
        com.opos.cmn.an.f.a.a("StatisticManager", "report but null map");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final JSONObject jSONObject) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.i.d.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (d.this.g == null) {
                    str = "do but client null";
                } else {
                    try {
                        d.this.g.a(com.opos.mobad.service.f.b().h(), jSONObject.toString());
                        return;
                    } catch (Exception e) {
                        str = "do fail";
                    }
                }
                com.opos.cmn.an.f.a.b("StatisticManager", str);
            }
        });
    }

    public void b() {
        if (this.i + 86400000 > System.currentTimeMillis()) {
            return;
        }
        try {
            final JSONObject d = d();
            d.put(STManager.KEY_DATA_TYPE, "lm-c-ps");
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.i.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.h == null) {
                        com.opos.cmn.an.f.a.b("StatisticManager", "do but client null");
                        return;
                    }
                    try {
                        if (d.this.i <= 0) {
                            d.this.i = d.this.h.e();
                        }
                        if (d.this.i + 86400000 <= System.currentTimeMillis()) {
                            if (d.this.g == null) {
                                com.opos.cmn.an.f.a.b("StatisticManager", "do but client null");
                                return;
                            }
                            d.this.g.a(d.toString());
                            d.this.i = System.currentTimeMillis();
                        }
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("StatisticManager", "do fail");
                    }
                }
            });
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "error:", e);
        }
    }

    public void b(String str, String str2, int i, long j, String str3, long j2) {
        a(str, "sdk_serial", str2, i, j, str3, j2);
    }

    public void b(String str, String str2, int i, long j, String str3, String str4, long j2) {
        a(str, str4, str2, i, j, str3, j2);
    }

    public f.a c() {
        JSONObject jSONObject;
        try {
            jSONObject = d();
            try {
                jSONObject.put("uSdkVC", this.d + "");
                jSONObject.put("pkgName", this.b.getPackageName());
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            jSONObject = null;
        }
        return new f.a(jSONObject);
    }
}
