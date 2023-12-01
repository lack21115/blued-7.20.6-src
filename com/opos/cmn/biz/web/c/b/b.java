package com.opos.cmn.biz.web.c.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import com.opos.cmn.an.b.d;
import com.opos.cmn.biz.ststrategy.StStrategyManager;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/web/c/b/b.class */
public class b extends a {
    private final Handler e;
    private String f;

    public b(Context context, c cVar) {
        super(context, cVar != null ? cVar.f24742c : "", cVar != null ? cVar.b : true);
        this.e = new Handler(Looper.getMainLooper());
        this.f24737a = context.getApplicationContext();
        this.f = cVar != null ? cVar.f24741a : "";
    }

    private String a() {
        try {
            return !com.opos.cmn.an.f.a.b(this.f24737a) ? StStrategyManager.getInstance(this.f24737a).getAnId(this.f24737a) : "";
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            return "";
        }
    }

    @JavascriptInterface
    public String getAllInstalledPkgName() {
        String str = "";
        if (this.b) {
            try {
                List<String> b = com.opos.cmn.an.h.d.a.b(this.f24737a);
                str = "";
                if (b != null) {
                    str = "";
                    if (b.size() > 0) {
                        String[] strArr = new String[b.size()];
                        b.toArray(strArr);
                        str = Arrays.toString(strArr);
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                str = "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getAllInstalledPkgName=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return str;
    }

    @JavascriptInterface
    public String getAndroidInfo() {
        String str = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                String packageName = this.f24737a.getPackageName();
                jSONObject.put("pkgName", packageName);
                jSONObject.put("verName", com.opos.cmn.an.h.d.a.c(this.f24737a, packageName));
                jSONObject.put("verCode", com.opos.cmn.an.h.d.a.b(this.f24737a, packageName));
                jSONObject.put("imei", getImei());
                jSONObject.put("localId", getLocalId());
                jSONObject.put("anId", a());
                jSONObject.put("mac", "");
                jSONObject.put("osVer", d.b());
                jSONObject.put("romVer", d.a());
                jSONObject.put("anVer", com.opos.cmn.an.b.c.c());
                jSONObject.put("net", com.opos.cmn.biz.web.c.a.a.a.a(this.f24737a));
                jSONObject.put("opt", com.opos.cmn.an.h.e.a.c(this.f24737a));
                jSONObject.put("ori", com.opos.cmn.an.h.f.a.i(this.f24737a));
                jSONObject.put("hg", com.opos.cmn.an.h.f.a.c(this.f24737a));
                jSONObject.put(ActVideoSetting.WIFI_DISPLAY, com.opos.cmn.an.h.f.a.b(this.f24737a));
                jSONObject.put("density", com.opos.cmn.an.h.f.a.f(this.f24737a));
                jSONObject.put("model", com.opos.cmn.an.b.c.a());
                jSONObject.put("brand", com.opos.cmn.biz.a.b.a(this.f24737a));
                jSONObject.put("lang", com.opos.cmn.an.b.b.a());
                jSONObject.put("country", com.opos.cmn.an.b.b.b());
                jSONObject.put("ouId", getOuId());
                jSONObject.put("duId", getDuId());
                jSONObject.put("guId", getGuId());
                jSONObject.put("ouIdStatus", getOUIDStatus());
                str = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                str = "";
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getAndroidInfo = " + str);
        return str;
    }

    @JavascriptInterface
    public String getBrand() {
        String str = "";
        if (this.b) {
            try {
                str = com.opos.cmn.biz.a.b.a(this.f24737a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                str = "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getBrand=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return str;
    }

    @JavascriptInterface
    public String getBuildInfo() {
        String str = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("model", com.opos.cmn.an.b.c.a());
                jSONObject.put("brand", com.opos.cmn.biz.a.b.a(this.f24737a));
                str = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                str = "";
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getBuildInfo=" + str);
        return str;
    }

    @JavascriptInterface
    public String getBusinessType() {
        return this.f;
    }

    @JavascriptInterface
    public int getCommonApiVer() {
        int a2 = com.opos.cmn.biz.web.c.a.a.a.a();
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getCommonApiVer=" + a2);
        return a2;
    }

    @JavascriptInterface
    public String getDevId() {
        String str = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imei", getImei());
                jSONObject.put("localId", getLocalId());
                jSONObject.put("anId", a());
                jSONObject.put("mac", "");
                jSONObject.put("ouId", getOuId());
                jSONObject.put("duId", getDuId());
                jSONObject.put("guId", getGuId());
                jSONObject.put("ouIdStatus", getOUIDStatus());
                str = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                str = "";
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getDevId=" + str);
        return str;
    }

    @JavascriptInterface
    public String getDevOS() {
        String str = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("osVer", d.b());
                jSONObject.put("romVer", d.a());
                jSONObject.put("anVer", com.opos.cmn.an.b.c.c());
                str = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                str = "";
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getDevOS=" + str);
        return str;
    }

    @JavascriptInterface
    public String getDuId() {
        String str = "";
        if (this.b) {
            try {
                str = com.opos.cmn.g.a.b.b(this.f24737a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                str = "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getDuId=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return str;
    }

    @JavascriptInterface
    public String getGuId() {
        String str = "";
        if (this.b) {
            str = "";
            try {
                if (!com.opos.cmn.an.f.a.b(this.f24737a)) {
                    str = StStrategyManager.getInstance(this.f24737a).getGUID();
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                str = "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getGuId=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return str;
    }

    @JavascriptInterface
    public String getImei() {
        String str = "";
        if (this.b) {
            str = "";
            try {
                if (!com.opos.cmn.an.f.a.b(this.f24737a)) {
                    str = StStrategyManager.getInstance(this.f24737a).getImei();
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                str = "";
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getImei=" + str);
        return str;
    }

    @JavascriptInterface
    public String getLocal() {
        String str = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("lang", com.opos.cmn.an.b.b.a());
                jSONObject.put("country", com.opos.cmn.an.b.b.b());
                str = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                str = "";
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getLocal=" + str);
        return str;
    }

    @JavascriptInterface
    public String getLocalId() {
        String str = "";
        if (this.b) {
            try {
                str = com.opos.cmn.g.a.c.c(this.f24737a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                str = "";
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getLocalId=" + str);
        return str;
    }

    @JavascriptInterface
    public String getNetType() {
        String str = "";
        if (this.b) {
            try {
                str = com.opos.cmn.biz.web.c.a.a.a.a(this.f24737a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                str = "";
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getNetType=" + str);
        return str;
    }

    @JavascriptInterface
    public boolean getOUIDStatus() {
        boolean h;
        if (this.b) {
            try {
                h = com.opos.cmn.g.a.b.h(this.f24737a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
            com.opos.cmn.an.f.a.b("JSCommonEngine", "getOUIDStatus=" + h);
            return h;
        }
        h = false;
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getOUIDStatus=" + h);
        return h;
    }

    @JavascriptInterface
    public String getOperator() {
        String str = "";
        if (this.b) {
            try {
                str = com.opos.cmn.an.h.e.a.c(this.f24737a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                str = "";
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getOperator=" + str);
        return str;
    }

    @JavascriptInterface
    public int getOri() {
        int i;
        if (this.b) {
            try {
                i = com.opos.cmn.an.h.f.a.i(this.f24737a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
            com.opos.cmn.an.f.a.b("JSCommonEngine", "getOri=" + i);
            return i;
        }
        i = 0;
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getOri=" + i);
        return i;
    }

    @JavascriptInterface
    public String getOuId() {
        String str = "";
        if (this.b) {
            try {
                str = com.opos.cmn.g.a.b.a(this.f24737a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                str = "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getOUID=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return str;
    }

    @JavascriptInterface
    public String getPkgInfo(String str) {
        String str2 = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                String packageName = com.opos.cmn.an.c.a.a(str) ? this.f24737a.getPackageName() : str;
                jSONObject.put("pkgName", packageName);
                jSONObject.put("verName", com.opos.cmn.an.h.d.a.c(this.f24737a, packageName));
                jSONObject.put("verCode", com.opos.cmn.an.h.d.a.b(this.f24737a, packageName));
                str2 = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                str2 = "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getPkgInfo pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb.append(str);
        sb.append(str2);
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return str2;
    }

    @JavascriptInterface
    public String getRegion() {
        String str = "";
        if (this.b) {
            try {
                str = com.opos.cmn.biz.a.d.a(this.f24737a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                str = "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getRegion=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return str;
    }

    @JavascriptInterface
    public String getScreen() {
        String str = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("hg", com.opos.cmn.an.h.f.a.c(this.f24737a));
                jSONObject.put(ActVideoSetting.WIFI_DISPLAY, com.opos.cmn.an.h.f.a.b(this.f24737a));
                jSONObject.put("density", com.opos.cmn.an.h.f.a.f(this.f24737a));
                str = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                str = "";
            }
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getScreen=" + str);
        return str;
    }

    @JavascriptInterface
    public boolean getTouristModeSwitch() {
        boolean b;
        if (this.b) {
            try {
                b = com.opos.cmn.an.f.a.b(this.f24737a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
            com.opos.cmn.an.f.a.b("JSCommonEngine", "getTouristModeSwitch=" + b);
            return b;
        }
        b = false;
        com.opos.cmn.an.f.a.b("JSCommonEngine", "getTouristModeSwitch=" + b);
        return b;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean hasPkgInstalled(java.lang.String r5) {
        /*
            r4 = this;
            r0 = r4
            boolean r0 = r0.b
            if (r0 == 0) goto L1c
            r0 = r4
            android.content.Context r0 = r0.f24737a     // Catch: java.lang.Exception -> L13
            r1 = r5
            boolean r0 = com.opos.cmn.an.h.d.a.d(r0, r1)     // Catch: java.lang.Exception -> L13
            r6 = r0
            goto L1e
        L13:
            r7 = move-exception
            java.lang.String r0 = "JSCommonEngine"
            java.lang.String r1 = ""
            r2 = r7
            com.opos.cmn.an.f.a.c(r0, r1, r2)
        L1c:
            r0 = 0
            r6 = r0
        L1e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "hasPkgInstalled pkgName="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            if (r0 == 0) goto L35
            goto L38
        L35:
            java.lang.String r0 = "null"
            r5 = r0
        L38:
            r0 = r7
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r1 = ",result="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "JSCommonEngine"
            r1 = r7
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.web.c.b.b.hasPkgInstalled(java.lang.String):boolean");
    }

    @JavascriptInterface
    public String hasPkgListInstalled(String str) {
        String str2 = "";
        if (this.b) {
            str2 = "";
            try {
                if (!com.opos.cmn.an.c.a.a(str)) {
                    str2 = "";
                    if (2 <= str.length()) {
                        com.opos.cmn.an.f.a.b("JSCommonEngine", "pkgList=" + str);
                        String substring = str.substring(1, str.length() - 1);
                        str2 = "";
                        if (substring.length() > 0) {
                            JSONObject jSONObject = new JSONObject();
                            StringTokenizer stringTokenizer = new StringTokenizer(substring, ",");
                            while (stringTokenizer.hasMoreTokens()) {
                                String nextToken = stringTokenizer.nextToken();
                                if (!com.opos.cmn.an.c.a.a(nextToken)) {
                                    jSONObject.put(nextToken, com.opos.cmn.an.h.d.a.d(this.f24737a, nextToken));
                                }
                            }
                            str2 = jSONObject.toString();
                        }
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                str2 = "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("hasPkgListInstalled = ");
        sb.append(str2 != null ? str2 : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.toString());
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean installApk(java.lang.String r5) {
        /*
            r4 = this;
            r0 = r4
            boolean r0 = r0.b
            if (r0 == 0) goto L1c
            r0 = r4
            android.content.Context r0 = r0.f24737a     // Catch: java.lang.Exception -> L13
            r1 = r5
            boolean r0 = com.opos.cmn.biz.web.c.a.a.a.a(r0, r1)     // Catch: java.lang.Exception -> L13
            r6 = r0
            goto L1e
        L13:
            r7 = move-exception
            java.lang.String r0 = "JSCommonEngine"
            java.lang.String r1 = ""
            r2 = r7
            com.opos.cmn.an.f.a.c(r0, r1, r2)
        L1c:
            r0 = 0
            r6 = r0
        L1e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "installApk url="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            if (r0 == 0) goto L35
            goto L38
        L35:
            java.lang.String r0 = "null"
            r5 = r0
        L38:
            r0 = r7
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r1 = ",result="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "JSCommonEngine"
            r1 = r7
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.web.c.b.b.installApk(java.lang.String):boolean");
    }

    @JavascriptInterface
    public void showToast(final String str, final boolean z) {
        if (this.b) {
            this.e.post(new Runnable() { // from class: com.opos.cmn.biz.web.c.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Toast.makeText(b.this.f24737a, str, !z ? 1 : 0).show();
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
                    }
                }
            });
        }
    }
}
