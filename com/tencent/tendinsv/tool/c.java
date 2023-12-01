package com.tencent.tendinsv.tool;

import android.Manifest;
import android.content.Context;
import android.os.SystemClock;
import android.util.Base64;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.CtSetting;
import cn.com.chinatelecom.account.api.ResultListener;
import com.cdo.oaps.ad.OapsKey;
import com.cmic.gen.sdk.tencent.auth.GenAuthnHelper;
import com.cmic.gen.sdk.tencent.auth.GenTokenListener;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
import com.sdk.tencent.base.api.CallBack;
import com.sdk.tencent.base.api.ToolUtils;
import com.sdk.tencent.base.module.manager.SDKManager;
import com.sdk.tencent.mobile.manager.oauth.cucc.OauthManager;
import com.tencent.tendinsv.a.b;
import com.tencent.tendinsv.listener.AuthCallbacks;
import com.tencent.tendinsv.utils.t;
import com.unikuwei.mianmi.account.shield.tencent.UniAccountHelper;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/tool/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f39038a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private AuthCallbacks f39039c;
    private String d;
    private a e = new a();
    private ExecutorService f;
    private String g;
    private long h;
    private long i;
    private long j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/tool/c$a.class */
    public class a implements GenTokenListener {
        private a() {
        }

        @Override // com.cmic.gen.sdk.tencent.auth.GenTokenListener
        public void onGetTokenComplete(int i, JSONObject jSONObject) {
            try {
                if (jSONObject == null) {
                    c.this.f39039c.authFailed(2003, 2003, "mCMCCAuth jsonObject isEmpty", "SDK获取token失败", 11, c.this.g, c.this.i, c.this.h, c.this.j);
                } else if (!jSONObject.has("token")) {
                    AuthCallbacks authCallbacks = c.this.f39039c;
                    authCallbacks.authFailed(2003, 2003, "getPhoneInfo()" + jSONObject.toString(), com.tencent.tendinsv.utils.d.a(jSONObject), 11, c.this.g, c.this.i, c.this.h, c.this.j);
                } else {
                    String optString = jSONObject.optString("token");
                    int optInt = jSONObject.optInt(ProcessBridgeProvider.KEY_RESULT_CODE);
                    if (!optString.isEmpty() && optInt == 103000) {
                        c.this.a(com.tencent.tendinsv.b.i, optString, "", "1", c.this.i, c.this.h, c.this.j);
                        return;
                    }
                    AuthCallbacks authCallbacks2 = c.this.f39039c;
                    authCallbacks2.authFailed(2003, optInt, "getPhoneInfo()" + jSONObject.toString(), com.tencent.tendinsv.utils.d.a(jSONObject), 11, c.this.g, c.this.i, c.this.h, c.this.j);
                }
            } catch (Exception e) {
                e.printStackTrace();
                com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "mCMCCAuth--Exception_e=", e);
                AuthCallbacks authCallbacks3 = c.this.f39039c;
                authCallbacks3.authFailed(1014, 1014, "mCMCCAuth--Exception_e=" + e, e.getClass().getSimpleName(), 11, c.this.g, c.this.i, c.this.h, c.this.j);
            }
        }
    }

    private c() {
    }

    public static c a() {
        if (f39038a == null) {
            synchronized (c.class) {
                try {
                    if (f39038a == null) {
                        f39038a = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f39038a;
    }

    private void a(String str) {
        this.g = str;
        this.h = SystemClock.uptimeMillis();
        this.j = SystemClock.uptimeMillis();
        this.i = System.currentTimeMillis();
        GenAuthnHelper.getInstance(this.b).mobileAuth(t.b(this.b, t.k, new String()), t.b(this.b, t.o, new String()), this.e);
    }

    private void a(final String str, final int i, final long j, final long j2, final long j3) {
        int b = t.b(this.b, t.H, 4) * 1000;
        int i2 = b / 2;
        CtAuth.getInstance().requestPreLogin(new CtSetting(i2, i2, b), new ResultListener() { // from class: com.tencent.tendinsv.tool.c.2
            @Override // cn.com.chinatelecom.account.api.ResultListener
            public void onResult(String str2) {
                AuthCallbacks authCallbacks;
                int i3;
                String str3;
                int i4;
                String str4;
                long j4;
                long j5;
                long j6;
                try {
                    if (com.tencent.tendinsv.utils.d.b(str2)) {
                        JSONObject jSONObject = new JSONObject(str2);
                        i3 = jSONObject.optInt("result");
                        if (i3 == 0) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                String optString = optJSONObject.optString("accessCode");
                                String optString2 = optJSONObject.optString("gwAuth");
                                if (com.tencent.tendinsv.utils.d.b(optString) && com.tencent.tendinsv.utils.d.b(optString2)) {
                                    c.this.a(str, optString, optString2, "3", j, j2, j3);
                                    return;
                                }
                                authCallbacks = c.this.f39039c;
                                str3 = com.tencent.tendinsv.utils.d.d(str2);
                                i4 = i;
                                str4 = str;
                                j4 = j;
                                j5 = j2;
                                j6 = j3;
                            } else {
                                authCallbacks = c.this.f39039c;
                                str3 = com.tencent.tendinsv.utils.d.d(str2);
                                i4 = i;
                                str4 = str;
                                j4 = j;
                                j5 = j2;
                                j6 = j3;
                            }
                        } else {
                            authCallbacks = c.this.f39039c;
                            str3 = com.tencent.tendinsv.utils.d.d(str2);
                            i4 = i;
                            str4 = str;
                            j4 = j;
                            j5 = j2;
                            j6 = j3;
                        }
                    } else {
                        authCallbacks = c.this.f39039c;
                        i3 = 2003;
                        str3 = "s isEmpty";
                        i4 = i;
                        str4 = str;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                    }
                    authCallbacks.authFailed(2003, i3, str2, str3, i4, str4, j4, j5, j6);
                } catch (JSONException e) {
                    e.printStackTrace();
                    com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "mCTCCAuth--Exception_e=", e);
                    c.this.f39039c.authFailed(1014, 1014, "mCTCCAuth--Exception_e=" + e, e.getClass().getSimpleName(), i, str, j, j2, j3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, long j, long j2, long j3) {
        StringBuilder sb;
        try {
            String b = t.b(this.b, "appId", "");
            String b2 = t.b(this.b, t.j, "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ap", b);
            jSONObject.put("tk", str2);
            jSONObject.put(ActVideoSetting.ACT_URL, str3);
            jSONObject.put("dd", t.b(this.b, "DID", ""));
            jSONObject.put("ud", t.b(this.b, "uuid", ""));
            jSONObject.put("vs", com.tencent.tendinsv.b.ao);
            jSONObject.put(OapsKey.KEY_TYPE, "1");
            jSONObject.put("ii", d.a().b(this.b));
            jSONObject.put(b.a.q, d.a().b());
            if ("2".equals(str4)) {
                jSONObject.put("nlt", "1");
            }
            String a2 = com.tencent.tendinsv.utils.a.a(this.d);
            String encodeToString = Base64.encodeToString(com.tencent.tendinsv.utils.a.a(jSONObject.toString().getBytes("UTF_8"), a2.substring(0, 16), a2.substring(16)), 11);
            JSONObject jSONObject2 = new JSONObject();
            if (com.tencent.tendinsv.utils.d.b(b2) && "1".equals(b2)) {
                sb = new StringBuilder();
                sb.append("A");
                sb.append(str4);
                sb.append(b);
                sb.append("-");
                sb.append(encodeToString);
            } else {
                sb = new StringBuilder();
                sb.append("A");
                sb.append(str4);
                sb.append("-");
                sb.append(encodeToString);
            }
            jSONObject2.put("token", sb.toString());
            this.f39039c.authSuccessed(2000, 2000, jSONObject2.toString(), com.tencent.tendinsv.b.aw, 11, str, j, j2, j3);
        } catch (Exception e) {
            e.printStackTrace();
            com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "phoneNumVerify--Exception_e=", e);
            AuthCallbacks authCallbacks = this.f39039c;
            authCallbacks.authFailed(1014, 1014, "phoneNumVerify--Exception_e=" + e, e.getClass().getSimpleName(), 11, str, j, j2, j3);
        }
    }

    private void b(final String str, final int i, final long j, final long j2, final long j3) {
        int b = t.b(this.b, t.H, 4);
        String b2 = t.b(this.b, t.l, new String());
        SDKManager.init(this.b, t.b(this.b, t.p, new String()), b2);
        OauthManager.getInstance(this.b).getAuthoriseCode(b, new CallBack<Object>() { // from class: com.tencent.tendinsv.tool.c.3
            @Override // com.sdk.tencent.base.api.CallBack
            public void onFailed(int i2, int i3, String str2, String str3) {
                AuthCallbacks authCallbacks = c.this.f39039c;
                authCallbacks.authFailed(2003, i3, "_code=" + i2 + "_msg=" + str2 + "_status=" + i3 + "_seq=" + str3, "check_error", i, str, j, j2, j3);
            }

            @Override // com.sdk.tencent.base.api.CallBack
            public void onSuccess(int i2, String str2, int i3, Object obj, String str3) {
                String str4;
                int i4;
                String str5;
                long j4;
                long j5;
                long j6;
                AuthCallbacks authCallbacks;
                try {
                    if (i2 == 0) {
                        String optString = new JSONObject(obj.toString()).optString("accessCode");
                        if (!optString.isEmpty()) {
                            c.this.a(str, optString, "", "2", j, j2, j3);
                            ToolUtils.clearCache(c.this.b);
                            return;
                        }
                        AuthCallbacks authCallbacks2 = c.this.f39039c;
                        str4 = "_code=" + i2 + "_msg=" + str2 + "_status=" + i3 + "_response=" + obj + "_seq=" + str3;
                        i4 = i;
                        str5 = str;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                        authCallbacks = authCallbacks2;
                    } else {
                        AuthCallbacks authCallbacks3 = c.this.f39039c;
                        str4 = "_code=" + i2 + "_msg=" + str2 + "_status=" + i3 + "_response=" + obj + "_seq=" + str3;
                        i4 = i;
                        str5 = str;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                        authCallbacks = authCallbacks3;
                    }
                    authCallbacks.authFailed(2003, i3, str4, "check_error", i4, str5, j4, j5, j6);
                } catch (Exception e) {
                    e.printStackTrace();
                    com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "mCUCCAuth--Exception_e=", e);
                    c.this.f39039c.authFailed(1014, 1014, "mCUCCAuth--Exception_e=" + e, e.getClass().getSimpleName(), i, str, j, j2, j3);
                }
            }
        });
    }

    private void c(final String str, final int i, final long j, final long j2, final long j3) {
        int b = t.b(this.b, t.H, 4);
        UniAccountHelper.getInstance().init(this.b, t.b(this.b, t.n, new String()), t.b(this.b, t.r, new String()));
        UniAccountHelper.getInstance().mobileAuth(b * 1000, new com.unikuwei.mianmi.account.shield.tencent.ResultListener() { // from class: com.tencent.tendinsv.tool.c.4
            @Override // com.unikuwei.mianmi.account.shield.tencent.ResultListener
            public void onResult(String str2) {
                AuthCallbacks authCallbacks;
                int i2;
                String str3;
                long j4;
                long j5;
                long j6;
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int optInt = jSONObject.optInt(ProcessBridgeProvider.KEY_RESULT_CODE);
                    String optString = jSONObject.optString(ProcessBridgeProvider.KEY_RESULT_DATA);
                    String optString2 = jSONObject.optString(ProcessBridgeProvider.KEY_RESULT_MSG);
                    if (optInt != 0) {
                        authCallbacks = c.this.f39039c;
                        i2 = i;
                        str3 = str;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                    } else if (com.tencent.tendinsv.utils.d.b(optString)) {
                        String optString3 = new JSONObject(optString).optString("accessCode");
                        if (!optString3.isEmpty()) {
                            c.this.a(str, optString3, "", "4", j, j2, j3);
                            return;
                        }
                        authCallbacks = c.this.f39039c;
                        i2 = i;
                        str3 = str;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                    } else {
                        authCallbacks = c.this.f39039c;
                        i2 = i;
                        str3 = str;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                    }
                    authCallbacks.authFailed(2003, optInt, str2, optString2, i2, str3, j4, j5, j6);
                } catch (Exception e) {
                    e.printStackTrace();
                    com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "mCUCCAuth--Exception_e=", e);
                    AuthCallbacks authCallbacks2 = c.this.f39039c;
                    authCallbacks2.authFailed(1014, 1014, "mCUCCAuth--Exception_e=" + e, e.getClass().getSimpleName(), i, str, j, j2, j3);
                }
            }
        });
    }

    public void a(final int i, final long j, final long j2, final long j3) {
        this.f39039c = new com.tencent.tendinsv.c.a();
        Runnable runnable = new Runnable() { // from class: com.tencent.tendinsv.tool.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.tencent.tendinsv.utils.e.a(c.this.b, new String[]{"android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", Manifest.permission.CHANGE_NETWORK_STATE, Manifest.permission.CHANGE_WIFI_STATE, "android.permission.READ_PHONE_STATE"});
                    com.tencent.tendinsv.utils.l.a(com.tencent.tendinsv.b.H, "authStart--processName=", Integer.valueOf(i), "__INIT_STATUS=", Integer.valueOf(com.tencent.tendinsv.b.V.get()));
                    int i2 = com.tencent.tendinsv.b.V.get();
                    if (i2 != 0) {
                        if (i2 != 1) {
                            return;
                        }
                        c.a().b(i, j, j2, j3);
                    } else if (1 == t.b(c.this.b, t.E, 0)) {
                        com.tencent.tendinsv.b.av = false;
                        c.this.f39039c.authFailed(1032, 1032, "用户被禁用", "check_error", i, d.a().a(c.this.b), j, j2, j3);
                    } else {
                        com.tencent.tendinsv.b.R.set(true);
                        j.a().a(i, j, j2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "authStart--Exception_e=", e);
                    AuthCallbacks authCallbacks = c.this.f39039c;
                    authCallbacks.authFailed(1014, 1014, "authStart--Exception_e=" + e, e.getClass().getSimpleName(), i, d.a().a(c.this.b), j, j2, j3);
                }
            }
        };
        if (this.b == null || this.f == null) {
            this.f39039c.authFailed(1004, 1004, "getPhoneInfoMethod()未初始化", "未初始化", i, "Unknown_Operator", j, j2, j3);
        } else if (com.tencent.tendinsv.b.U != com.tencent.tendinsv.b.Y.getAndSet(com.tencent.tendinsv.b.U)) {
            this.f.execute(runnable);
        } else {
            com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "auth is in progress");
        }
    }

    public void a(Context context, String str, ExecutorService executorService) {
        this.b = context;
        this.d = str;
        this.f = executorService;
    }

    public void b(int i, long j, long j2, long j3) {
        AuthCallbacks authCallbacks;
        String str;
        try {
            String a2 = d.a().a(this.b);
            boolean z = false;
            com.tencent.tendinsv.utils.l.a(com.tencent.tendinsv.b.H, "startAuth--operatorType=", a2);
            int hashCode = a2.hashCode();
            if (hashCode != 2078865) {
                if (hashCode == 2079826 && a2.equals(com.tencent.tendinsv.b.g)) {
                }
                z = true;
            } else {
                if (a2.equals(com.tencent.tendinsv.b.h)) {
                    z = true;
                }
                z = true;
            }
            if (!z) {
                int b = t.b(this.b, t.D, 1);
                int b2 = t.b(this.b, t.B, 1);
                if (1 == b) {
                    c(a2, i, j, j2, j3);
                    return;
                } else if (1 == b2) {
                    b(a2, i, j, j2, j3);
                    return;
                } else {
                    authCallbacks = this.f39039c;
                    str = "联通运营商通道未开启";
                }
            } else if (!z) {
                if (1 == t.b(this.b, t.A, 1)) {
                    a(a2);
                    return;
                } else {
                    authCallbacks = this.f39039c;
                    str = "移动运营商通道未开启";
                }
            } else if (1 == t.b(this.b, t.C, 1)) {
                a(a2, i, j, j2, j3);
                return;
            } else {
                authCallbacks = this.f39039c;
                str = "电信运营商通道未开启";
            }
            authCallbacks.authFailed(1001, 1001, str, "check_error", i, a2, j, j2, j3);
        } catch (Exception e) {
            e.printStackTrace();
            this.f39039c.authFailed(1014, 1014, "startAuth--Exception_e=" + e, e.getClass().getSimpleName(), i, d.a().a(this.b), j, j2, j3);
        }
    }
}
