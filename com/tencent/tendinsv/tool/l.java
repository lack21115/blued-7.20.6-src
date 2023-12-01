package com.tencent.tendinsv.tool;

import android.Manifest;
import android.content.Context;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.CtSetting;
import cn.com.chinatelecom.account.api.ResultListener;
import com.cmic.gen.sdk.tencent.auth.GenAuthnHelper;
import com.cmic.gen.sdk.tencent.auth.GenTokenListener;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
import com.sdk.tencent.base.api.CallBack;
import com.sdk.tencent.base.module.manager.SDKManager;
import com.sdk.tencent.mobile.manager.login.cucc.UiOauthManager;
import com.tencent.tendinsv.listener.GetPhoneInfoCallbacks;
import com.tencent.tendinsv.utils.o;
import com.tencent.tendinsv.utils.t;
import com.unikuwei.mianmi.account.shield.tencent.UniAccountHelper;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/tool/l.class */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static volatile l f39079a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private GetPhoneInfoCallbacks f39080c;
    private a d;
    private int e;
    private String f;
    private long g;
    private long h;
    private long i;
    private ExecutorService j;
    private GenAuthnHelper k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/tool/l$a.class */
    public class a implements GenTokenListener {
        private a() {
        }

        @Override // com.cmic.gen.sdk.tencent.auth.GenTokenListener
        public void onGetTokenComplete(int i, JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    if (jSONObject.has(ProcessBridgeProvider.KEY_RESULT_CODE)) {
                        int optInt = jSONObject.optInt(ProcessBridgeProvider.KEY_RESULT_CODE);
                        if (optInt != 103000) {
                            GetPhoneInfoCallbacks getPhoneInfoCallbacks = l.this.f39080c;
                            getPhoneInfoCallbacks.getPhoneInfoFailed(1023, optInt, "getPhoneInfo()" + jSONObject.toString(), com.tencent.tendinsv.utils.d.a(jSONObject), l.this.e, l.this.f, l.this.h, l.this.g, l.this.i);
                            return;
                        }
                        com.tencent.tendinsv.b.v = m.b(com.tencent.tendinsv.b.x, com.igexin.push.core.b.l);
                        com.tencent.tendinsv.b.r = com.tencent.tendinsv.b.f38999c;
                        com.tencent.tendinsv.b.t = com.tencent.tendinsv.b.d;
                        com.tencent.tendinsv.b.p = com.tencent.tendinsv.b.i;
                        l.this.f39080c.getPhoneInfoSuccessed(1022, 1022, com.tencent.tendinsv.b.ax, com.tencent.tendinsv.b.ax, l.this.e, l.this.h, l.this.g, l.this.i);
                        t.a(l.this.b, t.e, System.currentTimeMillis() + (t.b(l.this.b, t.v, (long) com.anythink.expressad.d.a.b.P) * 1000));
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "mOperatePreCMCC--Exception_e=", e);
                    GetPhoneInfoCallbacks getPhoneInfoCallbacks2 = l.this.f39080c;
                    getPhoneInfoCallbacks2.getPhoneInfoFailed(1014, 1014, "mOperatePreCUCC--Exception_e=" + e, e.getClass().getSimpleName(), l.this.e, l.this.f, l.this.h, l.this.g, l.this.i);
                    return;
                }
            }
            l.this.f39080c.getPhoneInfoFailed(1023, 1023, "getPhoneInfo() jsonObject isEmpty", "jsonObject isEmpty", l.this.e, l.this.f, l.this.h, l.this.g, l.this.i);
        }
    }

    private l() {
    }

    public static l a() {
        if (f39079a == null) {
            synchronized (l.class) {
                try {
                    if (f39079a == null) {
                        f39079a = new l();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f39079a;
    }

    private void a(String str, int i, long j, long j2, long j3) {
        boolean z;
        int i2;
        GetPhoneInfoCallbacks getPhoneInfoCallbacks;
        String str2;
        int hashCode = str.hashCode();
        if (hashCode != 2078865) {
            if (hashCode == 2079826 && str.equals(com.tencent.tendinsv.b.g)) {
                z = false;
            }
            z = true;
        } else {
            if (str.equals(com.tencent.tendinsv.b.h)) {
                z = true;
            }
            z = true;
        }
        if (!z) {
            int b = t.b(this.b, t.B, 1);
            int b2 = t.b(this.b, t.D, 1);
            i2 = b2;
            if (1 != b2) {
                if (1 != b) {
                    getPhoneInfoCallbacks = this.f39080c;
                    str2 = "联通运营商通道未开启";
                    getPhoneInfoCallbacks.getPhoneInfoFailed(1001, 1001, str2, "check_error", i, str, j, j2, j3);
                    return;
                }
                i2 = b2;
            }
            a(str, i, j, j2, j3, i2);
        } else if (!z) {
            i2 = t.b(this.b, t.A, 1);
            if (1 != i2) {
                getPhoneInfoCallbacks = this.f39080c;
                str2 = "移动运营商通道未开启";
                getPhoneInfoCallbacks.getPhoneInfoFailed(1001, 1001, str2, "check_error", i, str, j, j2, j3);
                return;
            }
            a(str, i, j, j2, j3, i2);
        } else {
            i2 = t.b(this.b, t.C, 1);
            if (1 != i2) {
                getPhoneInfoCallbacks = this.f39080c;
                str2 = "电信运营商通道未开启";
                getPhoneInfoCallbacks.getPhoneInfoFailed(1001, 1001, str2, "check_error", i, str, j, j2, j3);
                return;
            }
            a(str, i, j, j2, j3, i2);
        }
    }

    private void a(String str, int i, long j, long j2, long j3, int i2) {
        String str2 = com.tencent.tendinsv.b.g;
        try {
            String b = t.b(this.b, t.d, "");
            boolean b2 = t.b(this.b, t.U, false);
            String b3 = t.b(this.b, "number", "");
            boolean a2 = com.tencent.tendinsv.utils.g.a(this.b, "preInfo_sub");
            com.tencent.tendinsv.utils.l.a(com.tencent.tendinsv.b.H, "preTimeCheck processName", Integer.valueOf(i), Boolean.valueOf(a2), str, Boolean.valueOf(b2), Integer.valueOf(i2));
            if ((!com.tencent.tendinsv.b.g.equals(str) && !com.tencent.tendinsv.b.h.equals(str)) || !com.tencent.tendinsv.utils.d.a(b3)) {
                try {
                    if (a2 || !str.equals(b)) {
                        b(str, i, j, j2, j3, i2);
                        return;
                    } else if (System.currentTimeMillis() <= t.b(this.b, t.e, 1L)) {
                        if (!b2) {
                            b();
                            if (com.tencent.tendinsv.utils.d.a(t.b(this.b, "uuid", ""))) {
                                t.a(this.b, "uuid", System.currentTimeMillis() + "");
                            }
                            this.f39080c.getPhoneInfoFailed(1023, 1023, "frequent operation", "cache", i, str, j, j2, j3);
                            return;
                        }
                        if (com.tencent.tendinsv.utils.d.a(t.b(this.b, "uuid", ""))) {
                            t.a(this.b, "uuid", System.currentTimeMillis() + "");
                        }
                        if (com.tencent.tendinsv.b.g.equals(str)) {
                            com.tencent.tendinsv.b.v = b3;
                            com.tencent.tendinsv.b.r = com.tencent.tendinsv.b.e;
                            com.tencent.tendinsv.b.t = com.tencent.tendinsv.b.f;
                        } else if (com.tencent.tendinsv.b.h.equals(str)) {
                            com.tencent.tendinsv.b.v = b3;
                            com.tencent.tendinsv.b.r = com.tencent.tendinsv.b.f38997a;
                            com.tencent.tendinsv.b.t = com.tencent.tendinsv.b.b;
                            com.tencent.tendinsv.b.p = com.tencent.tendinsv.b.h;
                            this.f39080c.getPhoneInfoSuccessed(1022, 1022, com.tencent.tendinsv.b.ax, "cache", i, j, j2, j3);
                            return;
                        } else {
                            com.tencent.tendinsv.b.v = m.b(com.tencent.tendinsv.b.x, com.igexin.push.core.b.l);
                            com.tencent.tendinsv.b.r = com.tencent.tendinsv.b.f38999c;
                            com.tencent.tendinsv.b.t = com.tencent.tendinsv.b.d;
                            str2 = com.tencent.tendinsv.b.i;
                        }
                        com.tencent.tendinsv.b.p = str2;
                        this.f39080c.getPhoneInfoSuccessed(1022, 1022, com.tencent.tendinsv.b.ax, "cache", i, j, j2, j3);
                        return;
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "preTimeCheck--Exception_e=", e);
                    GetPhoneInfoCallbacks getPhoneInfoCallbacks = this.f39080c;
                    getPhoneInfoCallbacks.getPhoneInfoFailed(1014, 1014, "preTimeCheck--Exception_e=" + e, e.getClass().getSimpleName(), i, str, j, j2, j3);
                    return;
                }
            }
            b(str, i, j, j2, j3, i2);
        } catch (Exception e2) {
            e = e2;
        }
    }

    private void b() {
        try {
            if (t.b(this.b, t.e, 1L) - System.currentTimeMillis() > t.b(this.b, t.f, 3L) * 1000) {
                t.a(this.b, t.e, 0L);
            }
        } catch (Exception e) {
            com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "checkFailFlag--Exception_e=", e);
            t.a(this.b, t.e, 0L);
        }
    }

    private void b(String str, int i, long j, long j2, long j3, int i2) {
        boolean z;
        this.e = i;
        this.g = j2;
        this.i = j3;
        this.h = j;
        this.f = str;
        t.a(this.b, "uuid", System.currentTimeMillis() + "");
        int b = t.b(this.b, t.H, 4);
        int hashCode = str.hashCode();
        if (hashCode != 2078865) {
            if (hashCode == 2079826 && str.equals(com.tencent.tendinsv.b.g)) {
                z = false;
            }
            z = true;
        } else {
            if (str.equals(com.tencent.tendinsv.b.h)) {
                z = true;
            }
            z = true;
        }
        if (!z) {
            if (1 == i2) {
                e(str, i, j, j2, j3, b);
            } else {
                d(str, i, j, j2, j3, b);
            }
        } else if (z) {
            c(str, i, j, j2, j3, b);
        } else {
            this.k.setOverTime(b * 1000);
            if (this.d == null) {
                this.d = new a();
            }
            this.k.getPhoneInfo(t.b(this.b, t.k, new String()), t.b(this.b, t.o, new String()), this.d);
        }
    }

    private void c(final String str, final int i, final long j, final long j2, final long j3, int i2) {
        int i3 = i2 * 1000;
        int i4 = i3 / 2;
        CtAuth.getInstance().requestPreLogin(new CtSetting(i4, i4, i3), new ResultListener() { // from class: com.tencent.tendinsv.tool.l.2
            @Override // cn.com.chinatelecom.account.api.ResultListener
            public void onResult(String str2) {
                GetPhoneInfoCallbacks getPhoneInfoCallbacks;
                String d;
                int i5;
                String str3;
                long j4;
                long j5;
                long j6;
                try {
                    if (!com.tencent.tendinsv.utils.d.b(str2)) {
                        l.this.f39080c.getPhoneInfoFailed(1023, 1023, "response isEmpty", "response isEmpty", i, str, j, j2, j3);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(str2);
                    int optInt = jSONObject.optInt("result");
                    if (optInt == 0) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("number");
                            String optString2 = optJSONObject.optString("accessCode");
                            String optString3 = optJSONObject.optString("gwAuth");
                            if (com.tencent.tendinsv.utils.d.b(optString) && com.tencent.tendinsv.utils.d.b(optString2) && com.tencent.tendinsv.utils.d.b(optString3)) {
                                t.a(l.this.b, "number", optString);
                                t.a(l.this.b, t.e, System.currentTimeMillis() + (t.b(l.this.b, t.w, 600L) * 1000));
                                t.a(l.this.b, com.tencent.tendinsv.b.w, optString2);
                                t.a(l.this.b, t.g, optString3);
                                com.tencent.tendinsv.b.v = optString;
                                com.tencent.tendinsv.b.r = com.tencent.tendinsv.b.f38997a;
                                com.tencent.tendinsv.b.t = com.tencent.tendinsv.b.b;
                                com.tencent.tendinsv.b.p = com.tencent.tendinsv.b.h;
                                l.this.f39080c.getPhoneInfoSuccessed(1022, 1022, com.tencent.tendinsv.b.ax, com.tencent.tendinsv.b.ax, i, j, j2, j3);
                                return;
                            }
                            getPhoneInfoCallbacks = l.this.f39080c;
                            d = com.tencent.tendinsv.utils.d.d(str2);
                            i5 = i;
                            str3 = str;
                            j4 = j;
                            j5 = j2;
                            j6 = j3;
                        } else {
                            getPhoneInfoCallbacks = l.this.f39080c;
                            d = com.tencent.tendinsv.utils.d.d(str2);
                            i5 = i;
                            str3 = str;
                            j4 = j;
                            j5 = j2;
                            j6 = j3;
                        }
                    } else {
                        getPhoneInfoCallbacks = l.this.f39080c;
                        d = com.tencent.tendinsv.utils.d.d(str2);
                        i5 = i;
                        str3 = str;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                    }
                    getPhoneInfoCallbacks.getPhoneInfoFailed(1023, optInt, str2, d, i5, str3, j4, j5, j6);
                } catch (JSONException e) {
                    e.printStackTrace();
                    com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "mOperatePreCTCC--Exception_e=", e);
                    GetPhoneInfoCallbacks getPhoneInfoCallbacks2 = l.this.f39080c;
                    getPhoneInfoCallbacks2.getPhoneInfoFailed(1014, 1014, "mOperatePreCUCC--Exception_e=" + e, e.getClass().getSimpleName(), i, str, j, j2, j3);
                }
            }
        });
    }

    private void d(final String str, final int i, final long j, final long j2, final long j3, int i2) {
        String b = t.b(this.b, t.l, "");
        SDKManager.init(this.b, t.b(this.b, t.p, ""), b);
        UiOauthManager.getInstance(this.b).login(i2, new CallBack<Object>() { // from class: com.tencent.tendinsv.tool.l.3
            @Override // com.sdk.tencent.base.api.CallBack
            public void onFailed(int i3, int i4, String str2, String str3) {
                GetPhoneInfoCallbacks getPhoneInfoCallbacks = l.this.f39080c;
                getPhoneInfoCallbacks.getPhoneInfoFailed(1023, i4, "_code=" + i3 + "_msg=" + str2 + "_status=" + i4 + "_seq=" + str3, str2, i, str, j, j2, j3);
            }

            @Override // com.sdk.tencent.base.api.CallBack
            public void onSuccess(int i3, String str2, int i4, Object obj, String str3) {
                GetPhoneInfoCallbacks getPhoneInfoCallbacks;
                String str4;
                int i5;
                String str5;
                long j4;
                long j5;
                long j6;
                try {
                    if (i3 == 0) {
                        JSONObject jSONObject = new JSONObject(obj.toString());
                        String optString = jSONObject.optString("fakeMobile");
                        String optString2 = jSONObject.optString("accessCode");
                        if (com.tencent.tendinsv.utils.d.b(optString) && com.tencent.tendinsv.utils.d.b(optString2)) {
                            t.a(l.this.b, "number", optString);
                            t.a(l.this.b, t.e, System.currentTimeMillis() + (t.b(l.this.b, t.x, (long) com.anythink.expressad.d.a.b.aC) * 1000));
                            t.a(l.this.b, com.tencent.tendinsv.b.w, optString2);
                            com.tencent.tendinsv.b.v = optString;
                            com.tencent.tendinsv.b.r = com.tencent.tendinsv.b.e;
                            com.tencent.tendinsv.b.t = com.tencent.tendinsv.b.f;
                            com.tencent.tendinsv.b.p = com.tencent.tendinsv.b.g;
                            l.this.f39080c.getPhoneInfoSuccessed(1022, 1022, com.tencent.tendinsv.b.ax, com.tencent.tendinsv.b.ax, i, j, j2, j3);
                            return;
                        }
                        getPhoneInfoCallbacks = l.this.f39080c;
                        str4 = "_code=" + i3 + "_msg=" + str2 + "_status=" + i4 + "_response=" + obj + "_seq=" + str3;
                        i5 = i;
                        str5 = str;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                    } else {
                        getPhoneInfoCallbacks = l.this.f39080c;
                        str4 = "_code=" + i3 + "_msg=" + str2 + "_status=" + i4 + "_response=" + obj + "_seq=" + str3;
                        i5 = i;
                        str5 = str;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                    }
                    getPhoneInfoCallbacks.getPhoneInfoFailed(1023, i4, str4, str2, i5, str5, j4, j5, j6);
                } catch (Exception e) {
                    e.printStackTrace();
                    com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "mOperatePreCUCC--Exception_e=", e);
                    l.this.f39080c.getPhoneInfoFailed(1014, 1014, "mOperatePreCUCC--Exception_e=" + e, e.getClass().getSimpleName(), i, str, j, j2, j3);
                }
            }
        });
    }

    private void e(final String str, final int i, final long j, final long j2, final long j3, int i2) {
        UniAccountHelper.getInstance().init(this.b, t.b(this.b, t.n, new String()), t.b(this.b, t.r, new String()));
        UniAccountHelper.getInstance().login(i2 * 1000, new com.unikuwei.mianmi.account.shield.tencent.ResultListener() { // from class: com.tencent.tendinsv.tool.l.4
            @Override // com.unikuwei.mianmi.account.shield.tencent.ResultListener
            public void onResult(String str2) {
                GetPhoneInfoCallbacks getPhoneInfoCallbacks;
                int i3;
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
                        getPhoneInfoCallbacks = l.this.f39080c;
                        i3 = i;
                        str3 = str;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                    } else if (com.tencent.tendinsv.utils.d.b(optString)) {
                        JSONObject jSONObject2 = new JSONObject(optString);
                        String optString3 = jSONObject2.optString("mobile");
                        String optString4 = jSONObject2.optString("accessCode");
                        t.a(l.this.b, "number", optString3);
                        t.a(l.this.b, t.e, System.currentTimeMillis() + (t.b(l.this.b, t.x, (long) com.anythink.expressad.d.a.b.aC) * 1000));
                        t.a(l.this.b, com.tencent.tendinsv.b.w, optString4);
                        com.tencent.tendinsv.b.v = optString3;
                        com.tencent.tendinsv.b.r = com.tencent.tendinsv.b.e;
                        com.tencent.tendinsv.b.t = com.tencent.tendinsv.b.f;
                        com.tencent.tendinsv.b.p = com.tencent.tendinsv.b.g;
                        l.this.f39080c.getPhoneInfoSuccessed(1022, 1022, com.tencent.tendinsv.b.ax, optString2, i, j, j2, j3);
                        return;
                    } else {
                        getPhoneInfoCallbacks = l.this.f39080c;
                        i3 = i;
                        str3 = str;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                    }
                    getPhoneInfoCallbacks.getPhoneInfoFailed(1023, optInt, str2, optString2, i3, str3, j4, j5, j6);
                } catch (Exception e) {
                    e.printStackTrace();
                    com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "mOperatePreCUCC--Exception_e=", e);
                    GetPhoneInfoCallbacks getPhoneInfoCallbacks2 = l.this.f39080c;
                    getPhoneInfoCallbacks2.getPhoneInfoFailed(1014, 1014, "mOperatePreCUCC--Exception_e=" + e, e.getClass().getSimpleName(), i, str, j, j2, j3);
                }
            }
        });
    }

    public void a(final int i, final String str, final long j, final long j2, final long j3) {
        GetPhoneInfoCallbacks getPhoneInfoCallbacks;
        int i2;
        int i3;
        String str2;
        String str3;
        this.f39080c = new com.tencent.tendinsv.c.b(this.b);
        Runnable runnable = new Runnable() { // from class: com.tencent.tendinsv.tool.l.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.tencent.tendinsv.utils.e.a(l.this.b, new String[]{"android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", Manifest.permission.CHANGE_NETWORK_STATE, Manifest.permission.CHANGE_WIFI_STATE, "android.permission.READ_PHONE_STATE"});
                    int b = t.b(l.this.b, t.H, 4);
                    o.a(d.a().a(l.this.b), b * 1000, i, l.this.f39080c, j, j2, j);
                    com.tencent.tendinsv.utils.l.a(com.tencent.tendinsv.b.H, "getPhoneInfoMethod--delay=", Integer.valueOf(b), "__INIT_STATUS=", Integer.valueOf(com.tencent.tendinsv.b.V.get()));
                    int i4 = com.tencent.tendinsv.b.V.get();
                    if (i4 != 0) {
                        if (i4 != 1) {
                            return;
                        }
                        l.this.b(i, str, j, j2, j3);
                    } else if (1 != t.b(l.this.b, t.E, 0)) {
                        j.a().a(i, j, j2);
                    } else {
                        com.tencent.tendinsv.b.av = false;
                        l.this.f39080c.getPhoneInfoFailed(1032, 1032, "用户被禁用", "check_error", i, d.a().a(l.this.b), j, j2, j3);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "getPhoneInfoMethod--Exception_e=", e);
                    GetPhoneInfoCallbacks getPhoneInfoCallbacks2 = l.this.f39080c;
                    getPhoneInfoCallbacks2.getPhoneInfoFailed(1014, 1014, "getPhoneInfoMethod--Exception_e=" + e, e.getClass().getSimpleName(), i, d.a().a(l.this.b), j, j2, j3);
                }
            }
        };
        Context context = this.b;
        if (context == null || this.j == null) {
            getPhoneInfoCallbacks = this.f39080c;
            i2 = 1004;
            i3 = 1004;
            str2 = "getPhoneInfoMethod()未初始化";
            str3 = "未初始化";
        } else if (com.tencent.tendinsv.utils.g.g(context) > 0) {
            if (com.tencent.tendinsv.b.U != com.tencent.tendinsv.b.W.getAndSet(com.tencent.tendinsv.b.U)) {
                this.j.execute(runnable);
                return;
            } else if (i == 4) {
                com.tencent.tendinsv.b.Q.set(true);
                return;
            } else {
                com.tencent.tendinsv.utils.l.d(com.tencent.tendinsv.b.F, "getPhoneInfoMethod is in progress");
                return;
            }
        } else {
            getPhoneInfoCallbacks = this.f39080c;
            i2 = 1023;
            i3 = 200010;
            str2 = "无法识别sim卡或没有sim卡";
            str3 = "无SIM卡";
        }
        getPhoneInfoCallbacks.getPhoneInfoFailed(i2, i3, str2, str3, i, "Unknown_Operator", j, j2, j3);
    }

    public void a(Context context, ExecutorService executorService) {
        this.b = context;
        this.j = executorService;
        this.k = GenAuthnHelper.getInstance(context);
    }

    public void b(int i, String str, long j, long j2, long j3) {
        com.tencent.tendinsv.utils.l.a(com.tencent.tendinsv.b.H, "startGetPhoneInfo--processName=", Integer.valueOf(i), "__operator=", str);
        int b = t.b(this.b, t.D, 1);
        if (str != null) {
            a(str, i, j, j2, j3, b);
        } else {
            a(d.a().a(this.b), i, j, j2, j3);
        }
    }
}
