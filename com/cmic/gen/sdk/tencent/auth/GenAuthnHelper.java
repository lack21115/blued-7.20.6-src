package com.cmic.gen.sdk.tencent.auth;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.cmic.gen.sdk.tencent.auth.c;
import com.cmic.gen.sdk.tencent.e.e;
import com.cmic.gen.sdk.tencent.e.h;
import com.cmic.gen.sdk.tencent.e.n;
import com.cmic.gen.sdk.tencent.view.GenAuthThemeConfig;
import com.cmic.gen.sdk.tencent.view.GenLoginPageInListener;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/auth/GenAuthnHelper.class */
public class GenAuthnHelper extends c {
    private static GenAuthnHelper f;
    private GenAuthThemeConfig g;
    private GenLoginPageInListener h;

    private GenAuthnHelper(Context context) {
        super(context);
        this.h = null;
    }

    private GenAuthnHelper(Context context, String str) {
        super(context);
        this.h = null;
        this.e = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, com.cmic.gen.sdk.tencent.a aVar) {
        String b = aVar.b("traceId");
        Intent intent = new Intent();
        intent.putExtra("traceId", b);
        e.a(aVar.b("traceId"), aVar);
        intent.setClassName(context, "com.cmic.gen.sdk.tencent.view.GenLoginAuthActivity");
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static GenAuthnHelper getInstance(Context context) {
        if (f == null) {
            synchronized (GenAuthnHelper.class) {
                try {
                    if (f == null) {
                        f = new GenAuthnHelper(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f;
    }

    public static GenAuthnHelper getInstance(Context context, String str) {
        if (f == null) {
            synchronized (GenAuthnHelper.class) {
                try {
                    if (f == null) {
                        f = new GenAuthnHelper(context, str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cmic.gen.sdk.tencent.auth.c
    public void a(com.cmic.gen.sdk.tencent.a aVar) {
        final c.a aVar2 = new c.a(aVar);
        this.d.postDelayed(aVar2, this.f7992c);
        this.f7991a.a(aVar, new b() { // from class: com.cmic.gen.sdk.tencent.auth.GenAuthnHelper.4
            @Override // com.cmic.gen.sdk.tencent.auth.b
            public void a(String str, String str2, com.cmic.gen.sdk.tencent.a aVar3, JSONObject jSONObject) {
                com.cmic.gen.sdk.tencent.e.c.b("onBusinessComplete", "onBusinessComplete");
                GenAuthnHelper.this.d.removeCallbacks(aVar2);
                if (!"103000".equals(str) || e.a(aVar3.b("traceId"))) {
                    GenAuthnHelper.this.callBackResult(str, str2, aVar3, jSONObject);
                } else {
                    GenAuthnHelper.b(GenAuthnHelper.this.b, aVar3);
                }
            }
        });
    }

    public GenAuthThemeConfig getAuthThemeConfig() {
        if (this.g == null) {
            this.g = new GenAuthThemeConfig.Builder().build();
        }
        return this.g;
    }

    public long getOverTime() {
        return this.f7992c;
    }

    @Override // com.cmic.gen.sdk.tencent.auth.c
    public void getPhoneInfo(String str, String str2, GenTokenListener genTokenListener) {
        getPhoneInfo(str, str2, genTokenListener, -1);
    }

    public void getPhoneInfo(final String str, final String str2, final GenTokenListener genTokenListener, int i) {
        final com.cmic.gen.sdk.tencent.a a2 = a(genTokenListener);
        a2.a("SDKRequestCode", i);
        n.a(new n.a(this.b, a2) { // from class: com.cmic.gen.sdk.tencent.auth.GenAuthnHelper.1
            @Override // com.cmic.gen.sdk.tencent.e.n.a
            public void a() {
                if (GenAuthnHelper.this.a(a2, str, str2, "preGetMobile", 3, genTokenListener)) {
                    GenAuthnHelper.super.a(a2);
                }
            }
        });
    }

    @Override // com.cmic.gen.sdk.tencent.auth.c
    public void loginAuth(String str, String str2, GenTokenListener genTokenListener) {
        loginAuth(str, str2, genTokenListener, -1);
    }

    public void loginAuth(final String str, final String str2, final GenTokenListener genTokenListener, int i) {
        final com.cmic.gen.sdk.tencent.a a2 = a(genTokenListener);
        a2.a("SDKRequestCode", i);
        n.a(new n.a(this.b, a2) { // from class: com.cmic.gen.sdk.tencent.auth.GenAuthnHelper.2
            @Override // com.cmic.gen.sdk.tencent.e.n.a
            public void a() {
                if (GenAuthnHelper.this.a(a2, str, str2, "loginAuth", 3, genTokenListener)) {
                    String a3 = h.a(GenAuthnHelper.this.b);
                    if (!TextUtils.isEmpty(a3)) {
                        a2.a("phonescrip", a3);
                    }
                    GenAuthnHelper.this.a(a2);
                }
            }
        });
    }

    public void loginPageInCallBack(String str, JSONObject jSONObject) {
        GenLoginPageInListener genLoginPageInListener = this.h;
        if (genLoginPageInListener != null) {
            genLoginPageInListener.onLoginPageInComplete(str, jSONObject);
        }
    }

    @Override // com.cmic.gen.sdk.tencent.auth.c
    public void mobileAuth(String str, String str2, GenTokenListener genTokenListener) {
        mobileAuth(str, str2, genTokenListener, -1);
    }

    public void mobileAuth(final String str, final String str2, final GenTokenListener genTokenListener, int i) {
        final com.cmic.gen.sdk.tencent.a a2 = a(genTokenListener);
        a2.a("SDKRequestCode", i);
        n.a(new n.a(this.b, a2) { // from class: com.cmic.gen.sdk.tencent.auth.GenAuthnHelper.3
            @Override // com.cmic.gen.sdk.tencent.e.n.a
            public void a() {
                if (GenAuthnHelper.this.a(a2, str, str2, "mobileAuth", 0, genTokenListener)) {
                    GenAuthnHelper.super.a(a2);
                }
            }
        });
    }

    public void quitAuthActivity() {
        try {
            if (com.cmic.gen.sdk.tencent.view.b.a().b() != null) {
                com.cmic.gen.sdk.tencent.view.b.a().b().a();
            }
        } catch (Exception e) {
            e.printStackTrace();
            com.cmic.gen.sdk.tencent.e.c.a("AuthnHelper", "关闭授权页失败");
        }
    }

    public void setAuthThemeConfig(GenAuthThemeConfig genAuthThemeConfig) {
        this.g = genAuthThemeConfig;
    }

    public void setPageInListener(GenLoginPageInListener genLoginPageInListener) {
        this.h = genLoginPageInListener;
    }
}
