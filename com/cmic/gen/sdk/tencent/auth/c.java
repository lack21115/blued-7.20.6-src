package com.cmic.gen.sdk.tencent.auth;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.cmic.gen.sdk.tencent.e.e;
import com.cmic.gen.sdk.tencent.e.g;
import com.cmic.gen.sdk.tencent.e.h;
import com.cmic.gen.sdk.tencent.e.j;
import com.cmic.gen.sdk.tencent.e.k;
import com.cmic.gen.sdk.tencent.e.m;
import com.cmic.gen.sdk.tencent.e.n;
import com.cmic.gen.sdk.tencent.e.o;
import com.cmic.gen.sdk.tencent.e.q;
import com.cmic.gen.sdk.tencent.e.r;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
import com.sina.weibo.sdk.statistic.LogBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/auth/c.class */
public class c {
    public static final String SDK_VERSION = "quick_login_android_5.9.2";
    private static c f;

    /* renamed from: a  reason: collision with root package name */
    protected final com.cmic.gen.sdk.tencent.auth.a f7991a;
    protected final Context b;

    /* renamed from: c  reason: collision with root package name */
    protected long f7992c;
    protected final Handler d;
    protected String e;
    private final Object g;

    /* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/auth/c$a.class */
    public class a implements Runnable {
        private final com.cmic.gen.sdk.tencent.a b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(com.cmic.gen.sdk.tencent.a aVar) {
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject a2 = (r.a(c.this.b).a() || !this.b.b("doNetworkSwitch", false)) ? d.a("200023", "登录超时") : d.a("102508", "数据网络切换失败");
            c.this.callBackResult(a2.optString(ProcessBridgeProvider.KEY_RESULT_CODE, "200023"), a2.optString("desc", "登录超时"), this.b, a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.f7992c = 8000L;
        this.g = new Object();
        this.b = context.getApplicationContext();
        this.d = new Handler(this.b.getMainLooper());
        this.f7991a = com.cmic.gen.sdk.tencent.auth.a.a(this.b);
        r.a(this.b);
        k.a(this.b);
        j.a(this.b);
        n.a(new n.a() { // from class: com.cmic.gen.sdk.tencent.auth.c.1
            @Override // com.cmic.gen.sdk.tencent.e.n.a
            public void a() {
                String b = k.b("AID", "");
                com.cmic.gen.sdk.tencent.e.c.b("AuthnHelperCore", "aid = " + b);
                if (TextUtils.isEmpty(b)) {
                    c.this.a();
                }
                com.cmic.gen.sdk.tencent.e.c.b("AuthnHelperCore", com.cmic.gen.sdk.tencent.e.b.a(c.this.b, true) ? "生成androidkeystore成功" : "生成androidkeystore失败");
            }
        });
    }

    private c(Context context, String str) {
        this(context);
        this.e = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        String str = "%" + q.b();
        com.cmic.gen.sdk.tencent.e.c.b("AuthnHelperCore", "generate aid = " + str);
        k.a("AID", str);
    }

    private void a(final Context context, final String str, final com.cmic.gen.sdk.tencent.a aVar) {
        n.a(new n.a() { // from class: com.cmic.gen.sdk.tencent.auth.c.7
            @Override // com.cmic.gen.sdk.tencent.e.n.a
            public void a() {
                if ("200023".equals(str)) {
                    SystemClock.sleep(8000L);
                }
                new com.cmic.gen.sdk.tencent.d.d().a(context, str, aVar);
            }
        });
    }

    public static c getInstance(Context context) {
        if (f == null) {
            synchronized (c.class) {
                try {
                    if (f == null) {
                        f = new c(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f;
    }

    public static c getInstance(Context context, String str) {
        if (f == null) {
            synchronized (c.class) {
                try {
                    if (f == null) {
                        f = new c(context, str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f;
    }

    public static void setDebugMode(boolean z) {
        com.cmic.gen.sdk.tencent.e.c.a(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.cmic.gen.sdk.tencent.a a(GenTokenListener genTokenListener) {
        com.cmic.gen.sdk.tencent.a aVar = new com.cmic.gen.sdk.tencent.a(64);
        String c2 = q.c();
        aVar.a(new com.cmic.gen.sdk.tencent.d.b());
        aVar.a("traceId", c2);
        com.cmic.gen.sdk.tencent.e.c.a("traceId", c2);
        if (genTokenListener != null) {
            e.a(c2, genTokenListener);
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.cmic.gen.sdk.tencent.a aVar) {
        final a aVar2 = new a(aVar);
        this.d.postDelayed(aVar2, this.f7992c);
        this.f7991a.a(aVar, new b() { // from class: com.cmic.gen.sdk.tencent.auth.c.5
            @Override // com.cmic.gen.sdk.tencent.auth.b
            public void a(String str, String str2, com.cmic.gen.sdk.tencent.a aVar3, JSONObject jSONObject) {
                c.this.d.removeCallbacks(aVar2);
                c.this.callBackResult(str, str2, aVar3, jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(com.cmic.gen.sdk.tencent.a aVar, String str, String str2, String str3, int i, GenTokenListener genTokenListener) {
        boolean z;
        String str4;
        String str5;
        com.cmic.gen.sdk.tencent.a.a a2 = com.cmic.gen.sdk.tencent.a.c.a(this.b).a();
        aVar.a(a2);
        aVar.a("use2048PublicKey", "rsa2048".equals(this.e));
        aVar.a("systemStartTime", SystemClock.elapsedRealtime());
        aVar.a(LogBuilder.KEY_START_TIME, o.a());
        aVar.a("loginMethod", str3);
        aVar.a("appkey", str2);
        aVar.a("appid", str);
        aVar.a("timeOut", String.valueOf(this.f7992c));
        boolean a3 = g.a(this.b, "android.permission.READ_PHONE_STATE");
        com.cmic.gen.sdk.tencent.e.c.a("AuthnHelperCore", "有READ_PHONE_STATE权限？" + a3);
        aVar.a("hsaReadPhoneStatePermission", a3);
        boolean a4 = m.a(this.b);
        com.cmic.gen.sdk.tencent.b.a.a().a(this.b, a3, a4);
        aVar.a("networkClass", com.cmic.gen.sdk.tencent.b.a.a().a(this.b));
        String b = j.a().b();
        String c2 = j.a().c();
        String a5 = j.a().a(c2);
        aVar.a("operator", c2);
        aVar.a("operatortype", a5);
        aVar.a("logintype", i);
        com.cmic.gen.sdk.tencent.e.c.b("AuthnHelperCore", "subId = " + b);
        if (!TextUtils.isEmpty(b)) {
            com.cmic.gen.sdk.tencent.e.c.a("AuthnHelperCore", "使用subId作为缓存key = " + b);
            aVar.a("scripType", "subid");
            aVar.a("scripKey", b);
        } else if (!TextUtils.isEmpty(c2)) {
            com.cmic.gen.sdk.tencent.e.c.a("AuthnHelperCore", "使用operator作为缓存key = " + c2);
            aVar.a("scripType", "operator");
            aVar.a("scripKey", c2);
        }
        int a6 = m.a(this.b, a4);
        aVar.a("networktype", a6);
        if (!a4) {
            aVar.a("authType", String.valueOf(0));
            str4 = "200010";
            str5 = "无法识别sim卡或没有sim卡";
        } else if (genTokenListener == null) {
            str4 = "102203";
            str5 = "listener不能为空";
        } else {
            if (!a2.g()) {
                if (TextUtils.isEmpty(str == null ? "" : str.trim())) {
                    str4 = "102203";
                    str5 = "appId 不能为空";
                } else {
                    if (TextUtils.isEmpty(str2 == null ? "" : str2.trim())) {
                        str4 = "102203";
                        str5 = "appkey不能为空";
                    } else if (a6 == 0) {
                        str4 = "102101";
                        str5 = "未检测到网络";
                    } else if ((!"2".equals(a5) || !a2.f()) && (!"3".equals(a5) || !a2.e())) {
                        synchronized (this.g) {
                            boolean a7 = h.a(aVar);
                            z = a7;
                            if (a7) {
                                aVar.a(com.tencent.tendinsv.b.x, k.b(com.tencent.tendinsv.b.x, ""));
                                z = a7;
                                if (3 != i) {
                                    String a8 = h.a(this.b);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("解密phoneScript ");
                                    sb.append(!TextUtils.isEmpty(a8));
                                    com.cmic.gen.sdk.tencent.e.c.b("AuthnHelperCore", sb.toString());
                                    if (TextUtils.isEmpty(a8)) {
                                        a7 = false;
                                    } else {
                                        aVar.a("phonescrip", a8);
                                    }
                                    h.a(true, false);
                                    z = a7;
                                }
                            }
                            aVar.a("isCacheScrip", z);
                            com.cmic.gen.sdk.tencent.e.c.b("AuthnHelperCore", "isCachePhoneScrip = " + z);
                        }
                        if (a6 != 2 || z) {
                            return true;
                        }
                        str4 = "102103";
                        str5 = "无数据网络";
                    }
                }
            }
            str4 = "200082";
            str5 = "服务器繁忙，请稍后重试";
        }
        callBackResult(str4, str5, aVar, null);
        return false;
    }

    public void callBackResult(String str, String str2, com.cmic.gen.sdk.tencent.a aVar, JSONObject jSONObject) {
        try {
            String b = aVar.b("traceId");
            final int b2 = aVar.b("SDKRequestCode", -1);
            if (e.a(b)) {
                return;
            }
            synchronized (this) {
                final GenTokenListener c2 = e.c(b);
                if (jSONObject == null || !jSONObject.optBoolean("keepListener", false)) {
                    e.b(b);
                }
                if (c2 == null) {
                    return;
                }
                aVar.a("systemEndTime", SystemClock.elapsedRealtime());
                aVar.a(LogBuilder.KEY_END_TIME, o.a());
                int c3 = aVar.c("logintype");
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject == null) {
                    jSONObject2 = d.a(str, str2);
                }
                JSONObject a2 = c3 == 3 ? d.a(str, aVar, jSONObject2) : d.a(str, str2, aVar, jSONObject2);
                a2.put("scripExpiresIn", String.valueOf(h.a()));
                final JSONObject jSONObject3 = a2;
                this.d.post(new Runnable() { // from class: com.cmic.gen.sdk.tencent.auth.c.6
                    @Override // java.lang.Runnable
                    public void run() {
                        c2.onGetTokenComplete(b2, jSONObject3);
                    }
                });
                com.cmic.gen.sdk.tencent.a.c.a(this.b).a(aVar);
                if (!aVar.b().j() && !q.a(aVar.b())) {
                    a(this.b, str, aVar);
                }
                if (e.a()) {
                    r.a(this.b).b();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delScrip() {
        try {
            h.a(true, true);
            com.cmic.gen.sdk.tencent.e.c.b("AuthnHelperCore", "删除scrip");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONObject getNetworkType(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            boolean a2 = m.a(this.b);
            com.cmic.gen.sdk.tencent.b.a.a().a(context, g.a(context, "android.permission.READ_PHONE_STATE"), a2);
            String a3 = j.a().a((String) null);
            int a4 = m.a(context, a2);
            jSONObject.put("operatortype", a3);
            jSONObject.put("networktype", a4 + "");
            com.cmic.gen.sdk.tencent.e.c.b("AuthnHelperCore", "网络类型: " + a4);
            com.cmic.gen.sdk.tencent.e.c.b("AuthnHelperCore", "运营商类型: " + a3);
            return jSONObject;
        } catch (Exception e) {
            try {
                jSONObject.put("errorDes", "发生未知错误");
                return jSONObject;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return jSONObject;
            }
        }
    }

    public void getPhoneInfo(final String str, final String str2, final GenTokenListener genTokenListener) {
        final com.cmic.gen.sdk.tencent.a a2 = a(genTokenListener);
        n.a(new n.a(this.b, a2) { // from class: com.cmic.gen.sdk.tencent.auth.c.4
            @Override // com.cmic.gen.sdk.tencent.e.n.a
            public void a() {
                if (c.this.a(a2, str, str2, "preGetMobile", 3, genTokenListener)) {
                    c.this.a(a2);
                }
            }
        });
    }

    public void loginAuth(final String str, final String str2, final GenTokenListener genTokenListener) {
        final com.cmic.gen.sdk.tencent.a a2 = a(genTokenListener);
        n.a(new n.a(this.b, a2) { // from class: com.cmic.gen.sdk.tencent.auth.c.2
            @Override // com.cmic.gen.sdk.tencent.e.n.a
            public void a() {
                if (c.this.a(a2, str, str2, "loginAuth", 1, genTokenListener)) {
                    c.this.a(a2);
                }
            }
        });
    }

    public void mobileAuth(final String str, final String str2, final GenTokenListener genTokenListener) {
        final com.cmic.gen.sdk.tencent.a a2 = a(genTokenListener);
        n.a(new n.a(this.b, a2) { // from class: com.cmic.gen.sdk.tencent.auth.c.3
            @Override // com.cmic.gen.sdk.tencent.e.n.a
            public void a() {
                if (c.this.a(a2, str, str2, "mobileAuth", 0, genTokenListener)) {
                    c.this.a(a2);
                }
            }
        });
    }

    public void setOverTime(long j) {
        this.f7992c = j;
    }
}
