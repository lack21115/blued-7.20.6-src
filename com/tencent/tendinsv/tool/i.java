package com.tencent.tendinsv.tool;

import android.content.Context;
import android.util.Base64;
import com.cdo.oaps.ad.OapsKey;
import com.cmic.gen.sdk.tencent.auth.GenAuthnHelper;
import com.cmic.gen.sdk.tencent.auth.GenTokenListener;
import com.cmic.gen.sdk.tencent.view.GenAuthThemeConfig;
import com.cmic.gen.sdk.tencent.view.GenLoginClickListener;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
import com.sdk.tencent.base.api.ToolUtils;
import com.tencent.tendinsv.a.b;
import com.tencent.tendinsv.listener.LoginAuthCallbacks;
import com.tencent.tendinsv.utils.t;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/tool/i.class */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static volatile i f25373a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private LoginAuthCallbacks f25374c;
    private long d;
    private long e;
    private long f;
    private String g;
    private String h;
    private GenAuthnHelper i;
    private a j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/tool/i$a.class */
    public class a implements GenTokenListener {
        private a() {
        }

        @Override // com.cmic.gen.sdk.tencent.auth.GenTokenListener
        public void onGetTokenComplete(int i, JSONObject jSONObject) {
            int i2;
            int i3;
            String str;
            long j;
            long j2;
            long j3;
            LoginAuthCallbacks loginAuthCallbacks;
            String str2;
            String str3;
            try {
                com.tencent.tendinsv.utils.l.a(com.tencent.tendinsv.b.H, "onGetTokenComplete_type=", Integer.valueOf(i));
                if (jSONObject != null) {
                    if (jSONObject.has(ProcessBridgeProvider.KEY_RESULT_CODE)) {
                        i3 = jSONObject.optInt(ProcessBridgeProvider.KEY_RESULT_CODE);
                        if (jSONObject.has("token") && i3 == 103000) {
                            i.this.a("1", com.tencent.tendinsv.b.p, jSONObject.optString("token"), "", i.this.f, i.this.e, i.this.d);
                        } else if (i3 == 102101 || i3 == 102102 || i3 == 102103 || i3 == 200025 || i3 == 102507) {
                            LoginAuthCallbacks loginAuthCallbacks2 = i.this.f25374c;
                            i2 = 1007;
                            String str4 = "loginAuth()" + jSONObject.toString();
                            String b = com.tencent.tendinsv.utils.d.b(jSONObject);
                            str = i.this.h;
                            j = i.this.f;
                            j2 = i.this.e;
                            j3 = i.this.d;
                            loginAuthCallbacks = loginAuthCallbacks2;
                            str2 = str4;
                            str3 = b;
                        } else if (i3 != 200020) {
                            LoginAuthCallbacks loginAuthCallbacks3 = i.this.f25374c;
                            i2 = 1003;
                            str2 = "loginAuth()" + jSONObject.toString();
                            str3 = com.tencent.tendinsv.utils.d.b(jSONObject);
                            str = i.this.h;
                            j = i.this.f;
                            j2 = i.this.e;
                            j3 = i.this.d;
                            loginAuthCallbacks = loginAuthCallbacks3;
                        }
                    } else {
                        LoginAuthCallbacks loginAuthCallbacks4 = i.this.f25374c;
                        i2 = 1003;
                        i3 = 1003;
                        String str5 = "loginAuth()" + jSONObject.toString();
                        String b2 = com.tencent.tendinsv.utils.d.b(jSONObject);
                        str = i.this.h;
                        j = i.this.f;
                        j2 = i.this.e;
                        j3 = i.this.d;
                        loginAuthCallbacks = loginAuthCallbacks4;
                        str2 = str5;
                        str3 = b2;
                    }
                    loginAuthCallbacks.getTokenFailed(i2, i3, str2, str3, str, j, j2, j3);
                } else {
                    i.this.f25374c.getTokenFailed(1003, 1003, "jObj isEmpty", "jObj isEmpty", i.this.h, i.this.f, i.this.e, i.this.d);
                }
                i.this.i.quitAuthActivity();
            } catch (Exception e) {
                e.printStackTrace();
                com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "mCMCCLoginMethod--Exception_e=", e);
                i.this.f25374c.getTokenFailed(1014, 1014, "mCMCCLoginMethod--Exception_e=" + e, e.getClass().getSimpleName(), i.this.h, i.this.f, i.this.e, i.this.d);
                i.this.i.quitAuthActivity();
            }
        }
    }

    private i() {
    }

    public static i a() {
        if (f25373a == null) {
            synchronized (i.class) {
                try {
                    if (f25373a == null) {
                        f25373a = new i();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f25373a;
    }

    private void a(String str, String str2, long j, long j2, long j3) {
        String str3;
        String str4;
        try {
            if (com.tencent.tendinsv.b.h.equals(str2)) {
                str4 = t.b(this.b, t.g, "");
                str3 = "3";
            } else {
                if (1 == t.b(this.b, t.D, 1)) {
                    str3 = "4";
                } else {
                    str3 = "2";
                    ToolUtils.clearCache(this.b);
                }
                str4 = "";
            }
            a(str3, com.tencent.tendinsv.b.p, str, str4, j, j2, j3);
        } catch (Exception e) {
            e.printStackTrace();
            com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "setOnClickListener--Exception_e=", e);
            LoginAuthCallbacks loginAuthCallbacks = this.f25374c;
            loginAuthCallbacks.getTokenFailed(1014, 1014, "setOnClickListener--Exception_e=" + e, e.getClass().getSimpleName(), str2, j, j2, j3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0131 A[Catch: Exception -> 0x016c, TRY_ENTER, TryCatch #0 {Exception -> 0x016c, blocks: (B:3:0x0013, B:5:0x001a, B:7:0x0029, B:9:0x0040, B:14:0x0058, B:21:0x00c3, B:23:0x00cb, B:25:0x00d5, B:28:0x00e2, B:30:0x00ee, B:32:0x010c, B:34:0x0114, B:36:0x0122, B:38:0x0131, B:12:0x004b, B:40:0x013f), top: B:50:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r14, long r15, long r17, long r19) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tendinsv.tool.i.a(int, long, long, long):void");
    }

    public void a(Context context, String str) {
        this.b = context;
        this.g = str;
        this.i = GenAuthnHelper.getInstance(context);
    }

    public void a(String str, long j, long j2, long j3) {
        this.f = j;
        this.e = j2;
        this.d = j3;
        this.h = str;
        this.i.setAuthThemeConfig(new GenAuthThemeConfig.Builder().setLogBtnClickListener(new GenLoginClickListener() { // from class: com.tencent.tendinsv.tool.i.1
            @Override // com.cmic.gen.sdk.tencent.view.GenLoginClickListener
            public void onLoginClickComplete(Context context, JSONObject jSONObject) {
            }

            @Override // com.cmic.gen.sdk.tencent.view.GenLoginClickListener
            public void onLoginClickStart(Context context, JSONObject jSONObject) {
            }
        }).build());
        this.i.setOverTime(t.b(this.b, t.I, 4) * 1000);
        String b = t.b(this.b, t.k, "");
        String b2 = t.b(this.b, t.o, "");
        if (this.j == null) {
            this.j = new a();
        }
        this.i.loginAuth(b, b2, this.j);
    }

    public void a(String str, String str2, String str3, String str4, long j, long j2, long j3) {
        String str5;
        try {
            t.a(this.b, "number", "");
            t.a(this.b, t.e, 0L);
            String b = t.b(this.b, "appId", "");
            String b2 = t.b(this.b, t.j, "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ap", b);
            jSONObject.put("tk", str3);
            jSONObject.put(ActVideoSetting.ACT_URL, str4);
            jSONObject.put("dd", t.b(this.b, "DID", ""));
            jSONObject.put("ud", t.b(this.b, "uuid", ""));
            jSONObject.put("vs", com.tencent.tendinsv.b.ao);
            jSONObject.put(OapsKey.KEY_TYPE, "0");
            jSONObject.put("ii", d.a().b(this.b));
            jSONObject.put(b.a.q, d.a().b());
            if ("2".equals(str)) {
                jSONObject.put("nlt", "1");
            }
            String a2 = com.tencent.tendinsv.utils.a.a(this.g);
            String encodeToString = Base64.encodeToString(com.tencent.tendinsv.utils.a.a(jSONObject.toString().getBytes("UTF_8"), a2.substring(0, 16), a2.substring(16)), 11);
            JSONObject jSONObject2 = new JSONObject();
            if (com.tencent.tendinsv.utils.d.b(b2) && "1".equals(b2)) {
                str5 = "A" + str + b + Constants.ACCEPT_TIME_SEPARATOR_SERVER + encodeToString;
            } else {
                str5 = "A" + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + encodeToString;
            }
            jSONObject2.put("token", str5);
            this.f25374c.getTokenSuccessed(1000, 1000, jSONObject2.toString(), com.tencent.tendinsv.b.aw, j, j2, j3);
        } catch (Exception e) {
            e.printStackTrace();
            com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "getMobileNum--Exception_e=", e);
            this.f25374c.getTokenFailed(1014, 1014, "getMobileNum--Exception_e=" + e, e.getClass().getSimpleName(), str2, j, j2, j3);
        }
    }
}
