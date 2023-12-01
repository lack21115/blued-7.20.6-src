package com.cmic.gen.sdk.tencent.a;

import android.text.TextUtils;
import com.cmic.gen.sdk.tencent.a.a;
import com.cmic.gen.sdk.tencent.e.k;
import com.cmic.gen.sdk.tencent.e.n;
import com.igexin.assist.sdk.AssistPushConsts;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/a/b.class */
public class b {

    /* renamed from: c  reason: collision with root package name */
    private static b f21580c;

    /* renamed from: a  reason: collision with root package name */
    private com.cmic.gen.sdk.tencent.a.a f21581a;
    private final com.cmic.gen.sdk.tencent.a.a b;
    private volatile boolean d = false;
    private a e;

    /* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/a/b$a.class */
    interface a {
        void a(com.cmic.gen.sdk.tencent.a.a aVar);
    }

    private b(boolean z) {
        com.cmic.gen.sdk.tencent.a.a a2 = new a.C0328a().a();
        this.b = a2;
        if (z) {
            this.f21581a = a2;
        } else {
            this.f21581a = d();
        }
    }

    public static b a(boolean z) {
        if (f21580c == null) {
            synchronized (b.class) {
                try {
                    if (f21580c == null) {
                        f21580c = new b(z);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f21580c;
    }

    private String a(String str, String str2) {
        String str3;
        String[] split = str.split("&");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                str3 = "";
                break;
            }
            str3 = split[i2];
            if (str3.contains(str2)) {
                break;
            }
            i = i2 + 1;
        }
        String str4 = str3;
        if (!TextUtils.isEmpty(str3)) {
            str4 = str3.substring(str3.lastIndexOf("=") + 1);
        }
        return str4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        k.a b = k.b("sso_config_xf");
        try {
            if (jSONObject.has("client_valid")) {
                b.a("client_valid", System.currentTimeMillis() + (Integer.parseInt(jSONObject.getString("client_valid")) * 60 * 60 * 1000));
            }
            if (jSONObject.has("Configlist")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("Configlist");
                if (jSONObject2.has("CHANGE_HOST")) {
                    String string = jSONObject2.getString("CHANGE_HOST");
                    if (string.contains("M007")) {
                        String a2 = a(string, "M007");
                        if (!TextUtils.isEmpty(a2)) {
                            b.a("logHost", a2);
                        }
                    }
                    if (string.contains("M008")) {
                        String a3 = a(string, "M008");
                        if (!TextUtils.isEmpty(a3)) {
                            b.a("https_get_phone_scrip_host", a3);
                        }
                    }
                    if (string.contains("M009")) {
                        String a4 = a(string, "M009");
                        if (!TextUtils.isEmpty(a4)) {
                            b.a("config_host", a4);
                        }
                    }
                } else {
                    b.a("logHost");
                    b.a("https_get_phone_scrip_host");
                    b.a("config_host");
                }
                a(jSONObject2, "CLOSE_FRIEND_WAPKS", "0", b);
                a(jSONObject2, "CLOSE_LOGS_VERSION", "0", b);
                a(jSONObject2, "CLOSE_IPV4_LIST", "0", b);
                a(jSONObject2, "CLOSE_IPV6_LIST", "0", b);
                a(jSONObject2, "CLOSE_M008_SDKVERSION_LIST", "0", b);
                a(jSONObject2, "CLOSE_M008_APPID_LIST", "0", b);
                if (jSONObject2.has("LOGS_CONTROL")) {
                    String[] split = jSONObject2.getString("LOGS_CONTROL").replace("h", "").split("&");
                    if (split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                        try {
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            b.a("maxFailedLogTimes", parseInt);
                            b.a("pauseTime", parseInt2);
                        } catch (Exception e) {
                            com.cmic.gen.sdk.tencent.e.c.a("UmcConfigHandle", "解析日志上报限制时间次数异常");
                        }
                    }
                } else {
                    b.a("maxFailedLogTimes");
                    b.a("pauseTime");
                }
            }
            b.b();
        } catch (Exception e2) {
            com.cmic.gen.sdk.tencent.e.c.a("UmcConfigHandle", "配置项异常，配置失效");
            e2.printStackTrace();
        }
    }

    private void a(JSONObject jSONObject, String str, String str2, k.a aVar) {
        if (!jSONObject.has(str)) {
            aVar.a(str);
            return;
        }
        String optString = jSONObject.optString(str, str2);
        if ("CLOSE_FRIEND_WAPKS".equals(str)) {
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            if (!optString.contains("CU") && !optString.contains(AssistPushConsts.MSG_KEY_CONTENT) && !optString.contains("CM")) {
                return;
            }
        } else if (!"0".equals(optString) && !"1".equals(optString)) {
            return;
        }
        aVar.a(str, jSONObject.optString(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.cmic.gen.sdk.tencent.a aVar) {
        if (this.d) {
            com.cmic.gen.sdk.tencent.e.c.a("UmcConfigHandle", "正在获取配置中...");
            return;
        }
        this.d = true;
        com.cmic.gen.sdk.tencent.c.c.a.a().a(false, aVar, new com.cmic.gen.sdk.tencent.c.c.d() { // from class: com.cmic.gen.sdk.tencent.a.b.1
            @Override // com.cmic.gen.sdk.tencent.c.c.d
            public void a(String str, String str2, JSONObject jSONObject) {
                try {
                    if ("103000".equals(str)) {
                        b.this.a(jSONObject);
                        k.a("sdk_config_version", com.cmic.gen.sdk.tencent.auth.c.SDK_VERSION);
                        b.this.f21581a = b.this.d();
                        if (b.this.e != null) {
                            b.this.e.a(b.this.f21581a);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                b.this.d = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.cmic.gen.sdk.tencent.a.a d() {
        return new a.C0328a().a(d.b(this.b.a())).c(d.a(this.b.c())).b(d.b(this.b.b())).d(d.c(this.b.d())).d(d.a(this.b.h())).e(d.b(this.b.i())).a(d.e(this.b.e())).b(d.d(this.b.f())).c(d.c(this.b.g())).f(d.f(this.b.j())).a(d.a(this.b.k())).b(d.b(this.b.l())).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.cmic.gen.sdk.tencent.a.a a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final com.cmic.gen.sdk.tencent.a aVar) {
        if (d.a()) {
            n.a(new n.a() { // from class: com.cmic.gen.sdk.tencent.a.b.2
                @Override // com.cmic.gen.sdk.tencent.e.n.a
                public void a() {
                    com.cmic.gen.sdk.tencent.e.c.b("UmcConfigHandle", "开始拉取配置..");
                    b.this.b(aVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.cmic.gen.sdk.tencent.a.a b() {
        return this.f21581a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        k.a b = k.b("sso_config_xf");
        b.c();
        b.b();
    }
}
