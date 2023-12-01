package com.cmic.gen.sdk.tencent.auth;

import android.content.Context;
import com.cmic.gen.sdk.tencent.b;
import com.cmic.gen.sdk.tencent.e.l;
import com.huawei.hms.ads.fw;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/auth/a.class */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f7987c;

    /* renamed from: a  reason: collision with root package name */
    private final com.cmic.gen.sdk.tencent.c.c.a f7988a = com.cmic.gen.sdk.tencent.c.c.a.a();
    private final Context b;

    private a(Context context) {
        this.b = context.getApplicationContext();
    }

    public static a a(Context context) {
        if (f7987c == null) {
            synchronized (a.class) {
                try {
                    if (f7987c == null) {
                        f7987c = new a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f7987c;
    }

    private void a(com.cmic.gen.sdk.tencent.a aVar) {
        String packageName = this.b.getPackageName();
        String a2 = com.cmic.gen.sdk.tencent.e.d.a(l.a(this.b, packageName));
        aVar.a("apppackage", packageName);
        aVar.a("appsign", a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0190  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.cmic.gen.sdk.tencent.a r10, com.cmic.gen.sdk.tencent.auth.b r11, java.lang.String r12, java.lang.String r13, org.json.JSONObject r14) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmic.gen.sdk.tencent.auth.a.a(com.cmic.gen.sdk.tencent.a, com.cmic.gen.sdk.tencent.auth.b, java.lang.String, java.lang.String, org.json.JSONObject):void");
    }

    private void b(com.cmic.gen.sdk.tencent.a aVar) {
        byte[] bArr = new byte[0];
        if (aVar.b("use2048PublicKey", false)) {
            com.cmic.gen.sdk.tencent.e.c.a("AuthnBusiness", "使用2048公钥对应的对称秘钥生成方式");
            bArr = com.cmic.gen.sdk.tencent.e.a.a();
        } else {
            com.cmic.gen.sdk.tencent.e.c.a("AuthnBusiness", "使用1024公钥对应的对称秘钥生成方式");
            try {
                bArr = UUID.randomUUID().toString().substring(0, 16).getBytes("utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        byte[] a2 = com.cmic.gen.sdk.tencent.e.a.a();
        aVar.a(b.a.f8006a, bArr);
        aVar.a(b.a.b, a2);
        aVar.a("authType", "3");
    }

    public void a(com.cmic.gen.sdk.tencent.a aVar, b bVar) {
        com.cmic.gen.sdk.tencent.e.c.b("AuthnBusiness", "LoginCheck method start");
        int c2 = aVar.c("logintype");
        if (!aVar.b("isCacheScrip", false)) {
            b(aVar, bVar);
            return;
        }
        String b = aVar.b(com.tencent.tendinsv.b.x, "");
        if (c2 == 3) {
            bVar.a("103000", fw.Code, aVar, d.a(b));
        } else {
            b(aVar, bVar);
        }
    }

    public void b(final com.cmic.gen.sdk.tencent.a aVar, final b bVar) {
        String str;
        com.cmic.gen.sdk.tencent.e.c.b("AuthnBusiness", "getScripAndToken start");
        boolean b = aVar.b("isGotScrip", false);
        com.cmic.gen.sdk.tencent.e.c.b("AuthnBusiness", "isGotScrip = " + b);
        if (!b) {
            a(aVar);
            if (!aVar.b("isCacheScrip", false)) {
                b(aVar);
                if (aVar.c("networktype") == 3 && !"loginAuth".equals(aVar.b("loginMethod")) && aVar.c("logintype") != 3) {
                    aVar.a("isRisk", true);
                }
            }
            if (aVar.c("logintype") == 1) {
                str = BasicPushStatus.SUCCESS_CODE;
            } else {
                str = aVar.c("logintype") == 0 ? "50" : "50";
            }
            aVar.a("userCapaid", str);
        }
        this.f7988a.a(aVar, new com.cmic.gen.sdk.tencent.c.c.d() { // from class: com.cmic.gen.sdk.tencent.auth.a.1
            @Override // com.cmic.gen.sdk.tencent.c.c.d
            public void a(String str2, String str3, JSONObject jSONObject) {
                a.this.a(aVar, bVar, str2, str3, jSONObject);
            }
        });
    }
}
