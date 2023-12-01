package com.bytedance.bdtracker;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.bytedance.applog.AppLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/g2.class */
public final class g2 {

    /* renamed from: a  reason: collision with root package name */
    public String f21221a;

    @JavascriptInterface
    public void addHeaderInfo(String str, String str2) {
        z2.a("bridge:addHeaderInfo: {}, {}", str, str2);
        b.b(this.f21221a).setHeaderInfo(str, str2);
    }

    @JavascriptInterface
    public String getABTestConfigValueForKey(String str, String str2) {
        z2.a("bridge:getABTestConfigValueForKey: {}, {}", str, str2);
        return (String) b.b(this.f21221a).getAbConfig(str, str2);
    }

    @JavascriptInterface
    public String getAbSdkVersion() {
        z2.a("bridge:getAbSdkVersion");
        return b.b(this.f21221a).getAbSdkVersion();
    }

    @JavascriptInterface
    public String getAppId() {
        return TextUtils.isEmpty(this.f21221a) ? AppLog.getAppId() : this.f21221a;
    }

    @JavascriptInterface
    public String getClientUdid() {
        z2.a("bridge:getClientUdid");
        return b.b(this.f21221a).getClientUdid();
    }

    @JavascriptInterface
    public String getIid() {
        z2.a("bridge:getIid");
        return b.b(this.f21221a).getIid();
    }

    @JavascriptInterface
    public String getOpenUdid() {
        z2.a("bridge:getOpenUdid");
        return b.b(this.f21221a).getOpenUdid();
    }

    @JavascriptInterface
    public String getSsid() {
        z2.a("bridge:getSsid");
        return b.b(this.f21221a).getSsid();
    }

    @JavascriptInterface
    public String getUdid() {
        z2.a("bridge:getUdid");
        return b.b(this.f21221a).getUdid();
    }

    @JavascriptInterface
    public String getUuid() {
        z2.a("bridge:getUuid");
        return b.b(this.f21221a).getUserUniqueID();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @JavascriptInterface
    @Deprecated
    public int hasStartedForJsSdkUnderV5_deprecated() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @JavascriptInterface
    public void onEventV3(String str, String str2) {
        z2.a("bridge:onEventV3: {}, {}", str, str2);
        b.b(this.f21221a).onEventV3(str, j1.d(str2));
    }

    @JavascriptInterface
    public void profileAppend(String str) {
        z2.a("bridge:profileAppend: " + str);
        b.b(this.f21221a).profileAppend(j1.d(str));
    }

    @JavascriptInterface
    public void profileIncrement(String str) {
        z2.a("bridge:profileIncrement: " + str);
        b.b(this.f21221a).profileIncrement(j1.d(str));
    }

    @JavascriptInterface
    public void profileSet(String str) {
        z2.a("bridge:profileSet: {}", str);
        b.b(this.f21221a).profileSet(j1.d(str));
    }

    @JavascriptInterface
    public void profileSetOnce(String str) {
        z2.a("bridge:profileSetOnce: {}", str);
        b.b(this.f21221a).profileSetOnce(j1.d(str));
    }

    @JavascriptInterface
    public void profileUnset(String str) {
        z2.a("bridge:profileUnset: {}", str);
        b.b(this.f21221a).profileUnset(str);
    }

    @JavascriptInterface
    public void removeHeaderInfo(String str) {
        z2.a("bridge:removeHeaderInfo: {}", str);
        b.b(this.f21221a).removeHeaderInfo(str);
    }

    @JavascriptInterface
    public void setHeaderInfo(String str) {
        z2.a("bridge:setHeaderInfo: {}", str);
        if (TextUtils.isEmpty(str) || str.equals("undefined")) {
            b.b(this.f21221a).setHeaderInfo(null);
            return;
        }
        JSONObject d = j1.d(str);
        if (d == null) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        Iterator<String> keys = d.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                hashMap.put(next, d.get(next));
            } catch (JSONException e) {
                z2.a("wrong Json format, return", e);
                return;
            }
        }
        b.b(this.f21221a).setHeaderInfo(hashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001c, code lost:
        if (r7.equals("undefined") != false) goto L8;
     */
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setNativeAppId(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "bridge:setNativeAppId: {}"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = r1
            r3 = 0
            r4 = r7
            r2[r3] = r4
            com.bytedance.bdtracker.z2.a(r0, r1)
            r0 = r7
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L1f
            r0 = r7
            r8 = r0
            r0 = r7
            java.lang.String r1 = "undefined"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L21
        L1f:
            r0 = 0
            r8 = r0
        L21:
            r0 = r6
            r1 = r8
            r0.f21221a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.g2.setNativeAppId(java.lang.String):void");
    }

    @JavascriptInterface
    public void setUserUniqueId(String str) {
        z2.a("bridge:setUuid: {}", str);
        b.b(this.f21221a).setUserUniqueID(str);
    }
}
