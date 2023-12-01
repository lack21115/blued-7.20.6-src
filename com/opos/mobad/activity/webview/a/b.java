package com.opos.mobad.activity.webview.a;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.opos.cmn.biz.web.c.b.c;
import com.opos.cmn.func.b.b.d;
import java.util.StringTokenizer;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/activity/webview/a/b.class */
public class b extends com.opos.cmn.biz.web.c.b.b {
    private com.opos.mobad.activity.webview.b.b e;

    public b(Context context, c cVar, com.opos.mobad.activity.webview.b.b bVar) {
        super(context, cVar);
        this.e = bVar;
    }

    public void a() {
        this.e = null;
    }

    @JavascriptInterface
    public void actionDownloader(String str, String str2, String str3, String str4, int i) {
        if (this.b) {
            try {
                if (this.e != null) {
                    this.e.a(str, str2, str3, str4, i);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
    }

    @JavascriptInterface
    public void closeWebview() {
        if (this.b) {
            com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.activity.webview.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (b.this.e != null) {
                            b.this.e.c();
                        }
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public int getApiVer() {
        int a2 = com.opos.mobad.activity.webview.a.a.a.a();
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getApiVer=" + a2);
        return a2;
    }

    @JavascriptInterface
    public String getDownloaderStatus(String str, String str2) {
        String str3 = "";
        if (this.b) {
            str3 = "";
            try {
                if (this.e != null) {
                    str3 = this.e.c(str, str2);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
                str3 = "";
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getDownloaderStatus url=" + str + ",pkgName:" + str2 + ",downloadStatus:" + str3);
        return str3;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public String getDuId() {
        String str = "";
        if (this.b) {
            try {
                str = com.opos.mobad.service.e.a.a().g();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("MixAdJsEngine", "", e);
                str = "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getDuId=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
        return str;
    }

    @JavascriptInterface
    public String getGps() {
        String str = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                double[] c2 = com.opos.cmn.an.e.c.a().c();
                jSONObject.put("lt", String.valueOf(c2[0]));
                jSONObject.put("lg", String.valueOf(c2[1]));
                str = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
                str = "";
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getGps=" + str);
        return str;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public String getGuId() {
        String str = "";
        if (this.b) {
            try {
                str = com.opos.mobad.service.e.a.a().h();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("MixAdJsEngine", "", e);
                str = "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getGuId=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
        return str;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public String getImei() {
        String str = "";
        if (this.b) {
            try {
                str = com.opos.mobad.service.e.a.a().k();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
                str = "";
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getImei=" + str);
        return str;
    }

    @JavascriptInterface
    public String getInstantSdkVer() {
        String str = "";
        if (this.b) {
            try {
                str = com.opos.mobad.service.f.a.a().b();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
                str = "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getInstantSdkVer=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
        return str;
    }

    @JavascriptInterface
    public String getInstantVer() {
        String str = "";
        if (this.b) {
            try {
                str = com.opos.mobad.service.f.a.a().d();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
                str = "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getInstantVer=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
        return str;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public boolean getOUIDStatus() {
        boolean j;
        if (this.b) {
            try {
                j = com.opos.mobad.service.e.a.a().j();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("MixAdJsEngine", "", e);
            }
            com.opos.cmn.an.f.a.b("MixAdJsEngine", "getOUIDStatus=" + j);
            return j;
        }
        j = false;
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getOUIDStatus=" + j);
        return j;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public int getOri() {
        int i;
        if (this.b) {
            try {
                i = com.opos.cmn.an.h.f.a.i(this.f11049a);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
            com.opos.cmn.an.f.a.b("MixAdJsEngine", "getOri=" + i);
            return i;
        }
        i = 0;
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getOri=" + i);
        return i;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public String getOuId() {
        String str = "";
        if (this.b) {
            try {
                str = com.opos.mobad.service.e.a.a().f();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("MixAdJsEngine", "", e);
                str = "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getOuId=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
        return str;
    }

    @JavascriptInterface
    public String getPosId() {
        String str = "";
        if (this.b) {
            str = "";
            try {
                if (this.e != null) {
                    str = this.e.d();
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
                str = "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getPosId=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
        return str;
    }

    @JavascriptInterface
    public String getSdkInfo() {
        String str = "";
        if (this.b) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("verName", this.e != null ? this.e.b() : "");
                jSONObject.put("verCode", this.e != null ? this.e.a() : 0);
                str = jSONObject.toString();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
                str = "";
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "getSdkInfo=" + str);
        return str;
    }

    @Override // com.opos.cmn.biz.web.c.b.b
    @JavascriptInterface
    public String hasPkgListInstalled(String str) {
        String str2 = "";
        if (this.b) {
            str2 = "";
            try {
                if (!com.opos.cmn.an.c.a.a(str)) {
                    str2 = "";
                    if (2 <= str.length()) {
                        com.opos.cmn.an.f.a.b("MixAdJsEngine", "pkgList=" + str);
                        String substring = str.substring(1, str.length() - 1);
                        str2 = "";
                        if (substring.length() > 0) {
                            JSONObject jSONObject = new JSONObject();
                            StringTokenizer stringTokenizer = new StringTokenizer(substring, ",");
                            while (stringTokenizer.hasMoreTokens()) {
                                String nextToken = stringTokenizer.nextToken();
                                if (!com.opos.cmn.an.c.a.a(nextToken)) {
                                    jSONObject.put(nextToken, com.opos.cmn.an.h.d.a.d(this.f11049a, nextToken));
                                }
                            }
                            str2 = jSONObject.toString();
                        }
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
                str2 = "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("hasPkgListInstalled = ");
        sb.append(str2 != null ? str2 : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean launchAppHomePage(java.lang.String r5) {
        /*
            r4 = this;
            r0 = r4
            boolean r0 = r0.b
            if (r0 == 0) goto L25
            r0 = r4
            com.opos.mobad.activity.webview.b.b r0 = r0.e     // Catch: java.lang.Exception -> L1c
            if (r0 == 0) goto L25
            r0 = r4
            com.opos.mobad.activity.webview.b.b r0 = r0.e     // Catch: java.lang.Exception -> L1c
            r1 = r5
            boolean r0 = r0.b(r1)     // Catch: java.lang.Exception -> L1c
            r6 = r0
            goto L27
        L1c:
            r7 = move-exception
            java.lang.String r0 = "MixAdJsEngine"
            java.lang.String r1 = ""
            r2 = r7
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        L25:
            r0 = 0
            r6 = r0
        L27:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "launchAppHomePage pkgName="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            if (r0 == 0) goto L3d
            goto L40
        L3d:
            java.lang.String r0 = "null"
            r5 = r0
        L40:
            r0 = r7
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r1 = ",result="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "MixAdJsEngine"
            r1 = r7
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.activity.webview.a.b.launchAppHomePage(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean launchAppPage(java.lang.String r5) {
        /*
            r4 = this;
            r0 = r4
            boolean r0 = r0.b
            if (r0 == 0) goto L1c
            r0 = r4
            android.content.Context r0 = r0.f11049a     // Catch: java.lang.Exception -> L13
            r1 = r5
            boolean r0 = com.opos.mobad.activity.webview.a.a.a.b(r0, r1)     // Catch: java.lang.Exception -> L13
            r6 = r0
            goto L1e
        L13:
            r7 = move-exception
            java.lang.String r0 = "MixAdJsEngine"
            java.lang.String r1 = ""
            r2 = r7
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        L1c:
            r0 = 0
            r6 = r0
        L1e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "launchAppPage url="
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
            java.lang.String r0 = "MixAdJsEngine"
            r1 = r7
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.activity.webview.a.b.launchAppPage(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean launchBrowserViewPage(java.lang.String r5) {
        /*
            r4 = this;
            r0 = r4
            boolean r0 = r0.b
            if (r0 == 0) goto L1c
            r0 = r4
            android.content.Context r0 = r0.f11049a     // Catch: java.lang.Exception -> L13
            r1 = r5
            boolean r0 = com.opos.mobad.activity.webview.a.a.a.a(r0, r1)     // Catch: java.lang.Exception -> L13
            r6 = r0
            goto L1e
        L13:
            r7 = move-exception
            java.lang.String r0 = "MixAdJsEngine"
            java.lang.String r1 = ""
            r2 = r7
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        L1c:
            r0 = 0
            r6 = r0
        L1e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "launchBrowserViewPage url="
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
            java.lang.String r0 = "MixAdJsEngine"
            r1 = r7
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.activity.webview.a.b.launchBrowserViewPage(java.lang.String):boolean");
    }

    @JavascriptInterface
    public void launchInstant(String str, String str2, String str3, String str4, String str5) {
        if (this.b) {
            try {
                if (this.e != null) {
                    this.e.b(str, str5);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("launchInstant instantUrl=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb.append(str);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
    }

    @JavascriptInterface
    public void launchMarketDLPage(String str, String str2, String str3, String str4, boolean z) {
        if (this.b) {
            try {
                if (this.e != null) {
                    this.e.a(str, z);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("launchMarketDLPage pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb.append(str);
        sb.append(",exchange=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
    }

    @JavascriptInterface
    public void launchMarketDLPageForTrack(String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        if (this.b) {
            try {
                if (this.e != null) {
                    this.e.a(str, z, str5, str6);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("launchMarketDLPage pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb.append(str);
        sb.append(",exchange=");
        sb.append(z);
        sb.append(",trackContent=");
        sb.append(str5);
        sb.append(",trackReference=");
        sb.append(str6);
        com.opos.cmn.an.f.a.b("MixAdJsEngine", sb.toString());
    }

    @JavascriptInterface
    public void launchMarketDeeplinkDLApk(String str, String str2) {
        if (this.b) {
            try {
                if (this.e != null) {
                    this.e.d(str, str2);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "launchMarketDeeplinkDLApk url=" + str + ",pkgName:" + str2);
    }

    @JavascriptInterface
    public void launchMarketDeeplinkDLApkForSafe(String str, String str2) {
        if (this.b) {
            try {
                if (this.e != null) {
                    this.e.e(str, str2);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MixAdJsEngine", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "launchMarketDeeplinkDLApkForSafe url=" + str + ",pkgName:" + str2);
    }

    @JavascriptInterface
    public boolean openMiniProgram(String str, String str2) {
        boolean a2;
        if (this.b) {
            try {
                a2 = this.e.a(str, str2);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("MixAdJsEngine", "", e);
            }
            com.opos.cmn.an.f.a.b("MixAdJsEngine", "openMiniProgram=" + str + "," + str2 + "," + a2);
            return a2;
        }
        a2 = false;
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "openMiniProgram=" + str + "," + str2 + "," + a2);
        return a2;
    }

    @JavascriptInterface
    public void request(final String str, final String str2) {
        if (this.b) {
            com.opos.cmn.an.j.b.a(new Runnable() { // from class: com.opos.mobad.activity.webview.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.opos.cmn.func.b.b.b.a().a(b.this.f11049a, new d.a().b(str).a(str2.getBytes()).a("POST").a());
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("MixAdJsEngine", "request fail", e);
                    }
                }
            });
        }
        com.opos.cmn.an.f.a.b("MixAdJsEngine", "request url=" + str + ",data:" + str2);
    }
}
