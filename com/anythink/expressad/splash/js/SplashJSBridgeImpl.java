package com.anythink.expressad.splash.js;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.l;
import com.anythink.expressad.atsignalcommon.base.d;
import com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.d.b;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.g.a.f;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.splash.d.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/js/SplashJSBridgeImpl.class */
public class SplashJSBridgeImpl implements ISplashBridge {
    private WeakReference<Context> b;

    /* renamed from: c  reason: collision with root package name */
    private List<c> f8244c;
    private String d;
    private String e;
    private int f;
    private int g;
    private int i;
    private a j;
    private SplashExpandDialog k;

    /* renamed from: a  reason: collision with root package name */
    private String f8243a = "SplashJSBridgeImpl";
    private int h = 5;

    public SplashJSBridgeImpl(Context context, String str, String str2) {
        this.e = str;
        this.d = str2;
        this.b = new WeakReference<>(context);
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void cai(Object obj, String str) {
        o.a(this.f8243a, "cai:".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "params is null");
        } else if (TextUtils.isEmpty(str)) {
        } else {
            try {
                try {
                    String optString = new JSONObject(str).optString("packageName");
                    if (TextUtils.isEmpty(optString)) {
                        CommonJSBridgeImpUtils.callbackExcep(obj, "packageName is empty");
                    }
                    int i = t.a(n.a().g(), optString) ? 1 : 2;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", CommonJSBridgeImpUtils.b);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", i);
                        jSONObject.put("data", jSONObject2);
                        j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e) {
                        CommonJSBridgeImpUtils.callbackExcep(obj, e.getMessage());
                        o.a(this.f8243a, e.getMessage());
                    }
                } catch (Throwable th) {
                    CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + th.getLocalizedMessage());
                    o.b(this.f8243a, "cai", th);
                }
            } catch (JSONException e2) {
                CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + e2.getLocalizedMessage());
                o.b(this.f8243a, "cai", e2);
            }
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void close() {
        o.d(this.f8243a, "close");
        try {
            if (this.j != null) {
                this.j.c();
            }
        } catch (Throwable th) {
            o.b(this.f8243a, "close", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void expand(String str, boolean z) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z);
            if (this.b == null || this.b.get() == null) {
                return;
            }
            if (this.k == null || !this.k.isShowing()) {
                SplashExpandDialog splashExpandDialog = new SplashExpandDialog(this.b.get(), bundle, this.j);
                this.k = splashExpandDialog;
                splashExpandDialog.setCampaignList(this.d, this.f8244c);
                this.k.show();
                if (this.j != null) {
                    this.j.a(true);
                }
            }
        } catch (Throwable th) {
            o.b(this.f8243a, "expand", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public c getMraidCampaign() {
        List<c> list = this.f8244c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.f8244c.get(0);
    }

    public a getSplashBridgeListener() {
        return this.j;
    }

    public List<c> getmCampaignList() {
        return this.f8244c;
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void gial(Object obj, String str) {
        o.a(this.f8243a, "gial:".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", CommonJSBridgeImpUtils.b);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("packageNameList", new JSONArray());
            jSONObject.put("data", jSONObject2);
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            CommonJSBridgeImpUtils.callbackExcep(obj, e.getMessage());
            o.a(this.f8243a, e.getMessage());
        } catch (Throwable th) {
            CommonJSBridgeImpUtils.callbackExcep(obj, th.getMessage());
            o.a(this.f8243a, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void handlerH5Exception(Object obj, String str) {
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void init(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            com.anythink.expressad.splash.a.a aVar = new com.anythink.expressad.splash.a.a(n.a().g());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.f);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", aVar.a());
            jSONObject.put("campaignList", c.b(this.f8244c));
            b.a();
            com.anythink.expressad.d.c c2 = b.c(com.anythink.expressad.foundation.b.a.b().e(), this.d);
            com.anythink.expressad.d.c cVar = c2;
            if (c2 == null) {
                cVar = com.anythink.expressad.d.c.c(this.d);
            }
            if (!TextUtils.isEmpty(this.e)) {
                cVar.e(this.e);
            }
            cVar.a(this.d);
            cVar.b(this.h);
            cVar.a(this.g);
            jSONObject.put("unitSetting", cVar.s());
            b.a();
            String a2 = b.a(com.anythink.expressad.foundation.b.a.b().e());
            if (!TextUtils.isEmpty(a2)) {
                jSONObject.put("appSetting", new JSONObject(a2));
            }
            jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO, d.f7071a);
            String str2 = this.f8243a;
            o.d(str2, "init" + jSONObject.toString());
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            o.b(this.f8243a, "init", th);
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void install(Object obj, String str) {
        o.d(this.f8243a, "install");
        try {
            if (this.f8244c == null) {
                return;
            }
            c cVar = null;
            if (this.f8244c != null) {
                cVar = null;
                if (this.f8244c.size() > 0) {
                    cVar = this.f8244c.get(0);
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject a2 = c.a(cVar);
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    a2.put(next, jSONObject.getString(next));
                }
                c b = c.b(a2);
                String optString = a2.optString("unitId");
                if (!TextUtils.isEmpty(optString)) {
                    b.l(optString);
                }
                cVar = b;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.j != null) {
                this.j.a(cVar);
            }
        } catch (Throwable th) {
            o.b(this.f8243a, "click", th);
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void onJSBridgeConnect(Object obj, String str) {
        try {
            if (obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) {
                j.a();
                j.b(((com.anythink.expressad.atsignalcommon.windvane.a) obj).f7101a);
            }
        } catch (Throwable th) {
            o.b(this.f8243a, "onJSBridgeConnect", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void open(String str) {
        a aVar = this.j;
        if (aVar != null) {
            aVar.b(str);
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void openURL(Object obj, String str) {
        o.d(this.f8243a, "openURL:".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "params is null");
            return;
        }
        Context g = n.a().g();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Context context = g;
        if (g == null) {
            context = g;
            try {
                if (obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) {
                    WindVaneWebView windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).f7101a;
                    context = g;
                    if (windVaneWebView != null) {
                        context = windVaneWebView.getContext();
                    }
                }
            } catch (Exception e) {
                o.d(this.f8243a, e.getMessage());
                context = g;
            }
        }
        if (context == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt("type");
            if (optInt == 1) {
                l.a(context, optString);
            } else if (optInt == 2) {
                l.b(context, optString);
            }
        } catch (JSONException e2) {
            o.d(this.f8243a, e2.getMessage());
        } catch (Throwable th) {
            o.d(this.f8243a, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void pauseCountDown(Object obj, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", 0);
            jSONObject.put("message", "Call pause count down success.");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("countdown", this.i);
            jSONObject.put("data", jSONObject2);
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            o.d(this.f8243a, e.getMessage());
        }
        a aVar = this.j;
        if (aVar != null) {
            aVar.a(1, -1);
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void readyStatus(Object obj, String str) {
    }

    public void release() {
        if (this.j != null) {
            this.j = null;
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void reportUrls(Object obj, String str) {
        o.a(this.f8243a, "reportUrls:".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "params is null");
        } else if (TextUtils.isEmpty(str)) {
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        j.a().a(obj, SplashJsUtils.codeToJsonString(0));
                        return;
                    }
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    int optInt = jSONObject.optInt("type");
                    String optString = jSONObject.optString("url");
                    int optInt2 = jSONObject.optInt("report");
                    boolean z = true;
                    if (optInt2 == 0) {
                        Context g = n.a().g();
                        if (optInt == 0) {
                            z = false;
                        }
                        com.anythink.expressad.a.a.a(g, (c) null, "", optString, z);
                    } else {
                        com.anythink.expressad.a.a.a(n.a().g(), null, "", optString, false, optInt != 0, optInt2);
                    }
                    i = i2 + 1;
                }
            } catch (Throwable th) {
                o.b(this.f8243a, "reportUrls", th);
            }
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void resetCountdown(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int i = new JSONObject(str).getInt("countdown");
            if (this.j != null) {
                this.j.b(i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    @Override // com.anythink.expressad.splash.js.ISplashBridge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void resumeCountDown(java.lang.Object r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = r6
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r9 = r0
            r0 = 0
            r7 = r0
            r0 = 0
            r8 = r0
            r0 = r9
            if (r0 != 0) goto L40
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L31
            r1 = r0
            r2 = r6
            r1.<init>(r2)     // Catch: java.lang.Exception -> L31
            java.lang.String r1 = "countdown"
            int r0 = r0.optInt(r1)     // Catch: java.lang.Exception -> L31
            r7 = r0
            com.anythink.expressad.atsignalcommon.windvane.j r0 = com.anythink.expressad.atsignalcommon.windvane.j.a()     // Catch: java.lang.Exception -> L2d java.lang.Exception -> L31
            r1 = r5
            r2 = 0
            java.lang.String r2 = com.anythink.expressad.splash.js.SplashJsUtils.codeToJsonString(r2)     // Catch: java.lang.Exception -> L2d
            r0.a(r1, r2)     // Catch: java.lang.Exception -> L2d
            goto L40
        L2d:
            r5 = move-exception
            goto L35
        L31:
            r5 = move-exception
            r0 = r8
            r7 = r0
        L35:
            r0 = r4
            java.lang.String r0 = r0.f8243a
            r1 = r5
            java.lang.String r1 = r1.getMessage()
            com.anythink.expressad.foundation.h.o.d(r0, r1)
        L40:
            r0 = r4
            com.anythink.expressad.splash.d.a r0 = r0.j
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L51
            r0 = r5
            r1 = 2
            r2 = r7
            r0.a(r1, r2)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.splash.js.SplashJSBridgeImpl.resumeCountDown(java.lang.Object, java.lang.String):void");
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void sendImpressions(Object obj, String str) {
        o.a(this.f8243a, "sendImpressions:".concat(String.valueOf(str)));
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    return;
                }
                String string = jSONArray.getString(i2);
                for (c cVar : this.f8244c) {
                    if (cVar.aZ().equals(string)) {
                        f.a(this.d, cVar, f.f);
                        arrayList.add(string);
                    }
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            o.b(this.f8243a, "sendImpressions", th);
        }
    }

    public void setAllowSkip(int i) {
        this.g = i;
    }

    public void setCampaignList(List<c> list) {
        this.f8244c = list;
    }

    public void setCountdownS(int i) {
        this.h = i;
    }

    public void setDevCloseBtnStatus(int i) {
        this.f = i;
    }

    public void setSplashBridgeListener(a aVar) {
        if (aVar != null) {
            this.j = aVar;
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("state");
            if (this.j != null) {
                this.j.a(optInt);
            }
        } catch (Throwable th) {
            o.b(this.f8243a, "toggleCloseBtn", th);
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void triggerCloseBtn(Object obj, String str) {
        a aVar = this.j;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void unload() {
        close();
    }

    public void updateContext(Context context) {
        this.b = new WeakReference<>(context);
    }

    public void updateCountDown(int i) {
        this.i = i;
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void useCustomClose(boolean z) {
        int i = z ? 2 : 1;
        try {
            if (this.j != null) {
                this.j.a(i);
            }
        } catch (Throwable th) {
            o.b(this.f8243a, "useCustomClose", th);
        }
    }
}
