package com.anythink.expressad.video.signal.communication;

import android.text.TextUtils;
import android.util.Base64;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.l;
import com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils;
import com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.d.b;
import com.anythink.expressad.foundation.g.a;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.bt.a.c;
import com.anythink.expressad.video.signal.factory.IJSFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/signal/communication/BaseVideoBridge.class */
public class BaseVideoBridge extends AbsFeedBackForH5 implements IVideoBridge {
    protected static final String h = "JS-Video-Brigde";
    private static final int j = 1;
    private static final int k = 2;
    private static final String l = "showTransparent";
    private static final String m = "mute";
    private static final String n = "closeType";
    private static final String o = "orientationType";
    private static final String p = "type";
    private static final String q = "h5cbp";
    private static final String r = "webfront";
    private static final String s = "showAlertRole";
    protected IJSFactory i;

    private static String a(int i) {
        switch (i) {
            case 1:
                return "sdk_info";
            case 2:
                return "unit_id";
            case 3:
                return "appSetting";
            case 4:
                return "unitSetting";
            case 5:
                return "device";
            case 6:
                return "sdkSetting";
            default:
                return "";
        }
    }

    private static void a(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 1);
                jSONObject.put("message", "params is null");
                j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (Exception e) {
            o.a(h, e.getMessage());
        }
    }

    private static String b(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String jSONObject2 = jSONObject.toString();
            return !TextUtils.isEmpty(jSONObject2) ? Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (Throwable th) {
            o.d(h, "code to string is error");
            return "";
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void appendSubView(Object obj, String str) {
        a(obj, str);
        try {
            c.a().i(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "appendSubView error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void appendViewTo(Object obj, String str) {
        a(obj, str);
        try {
            c.a().j(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "appendViewTo error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void bringViewToFront(Object obj, String str) {
        a(obj, str);
        try {
            c.a().m(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "bringViewToFront error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void broadcast(Object obj, String str) {
        a(obj, str);
        try {
            c.a().M(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "broadcast error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void cai(Object obj, String str) {
        o.a(h, "cai:".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            return;
        }
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
                    o.a(h, e.getMessage());
                }
            } catch (Throwable th) {
                CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + th.getLocalizedMessage());
                o.b(h, "cai", th);
            }
        } catch (JSONException e2) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + e2.getLocalizedMessage());
            o.b(h, "cai", e2);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void clearAllCache(Object obj, String str) {
        try {
            n.a().g().getSharedPreferences(a.p, 0).edit().clear().apply();
            if (obj != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 0);
                jSONObject.put("message", "Success");
                j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (Throwable th) {
            o.d(h, "getAllCache error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void click(Object obj, String str) {
        String str2;
        int i;
        com.anythink.expressad.video.signal.a.j jVar;
        o.b(h, "click");
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                i = jSONObject.optInt("type");
                str2 = jSONObject.optString("pt");
            } catch (JSONException e) {
                e.printStackTrace();
                str2 = "";
                i = 1;
            }
            if (this.i != null) {
                this.i.getJSCommon().click(i, str2);
            } else if (obj != null) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (!(aVar.f4263a.getObject() instanceof com.anythink.expressad.video.signal.a.j) || (jVar = (com.anythink.expressad.video.signal.a.j) aVar.f4263a.getObject()) == null) {
                    return;
                }
                jVar.click(i, str2);
            }
        } catch (Throwable th) {
            o.b(h, "click error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void closeAd(Object obj, String str) {
        a(obj, str);
        try {
            c.a().L(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "closeAd error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void closeVideoOperte(Object obj, String str) {
        try {
            if (this.i == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("close");
            int optInt2 = jSONObject.optInt("view_visible");
            o.b(h, "closeVideoOperte,close:" + optInt + ",viewVisible:" + optInt2);
            this.i.getJSVideoModule().closeVideoOperate(optInt, optInt2);
            j.a().a(obj, b(0));
        } catch (Throwable th) {
            o.b(h, "closeOperte error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void closeWeb(Object obj, String str) {
        o.d(h, "type".concat(String.valueOf(str)));
        try {
            if (TextUtils.isEmpty(str) || this.i == null || TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("status");
            this.i.getJSContainerModule().hideAlertWebview();
            this.i.getJSVideoModule().hideAlertView(optInt);
        } catch (Throwable th) {
            o.b(h, "closeWeb", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createNativeEC(Object obj, String str) {
        a(obj, str);
        try {
            c.a().Q(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "createNativeEC error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createPlayerView(Object obj, String str) {
        a(obj, str);
        try {
            c.a().c(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "createPlayerView error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createSubPlayTemplateView(Object obj, String str) {
        a(obj, str);
        try {
            c.a().d(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "createSubPlayTemplateView error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createView(Object obj, String str) {
        a(obj, str);
        try {
            c.a().a(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "createWebview error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createWebview(Object obj, String str) {
        a(obj, str);
        try {
            c.a().b(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "createWebview error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void destroyComponent(Object obj, String str) {
        a(obj, str);
        try {
            c.a().e(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "destroyComponent error ".concat(String.valueOf(th)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00aa A[Catch: all -> 0x00d9, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00d9, blocks: (B:15:0x008b, B:17:0x00aa, B:21:0x00c5, B:18:0x00b6), top: B:26:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b6 A[Catch: all -> 0x00d9, TRY_ENTER, TryCatch #0 {all -> 0x00d9, blocks: (B:15:0x008b, B:17:0x00aa, B:21:0x00c5, B:18:0x00b6), top: B:26:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c5 A[Catch: all -> 0x00d9, TRY_ENTER, TryCatch #0 {all -> 0x00d9, blocks: (B:15:0x008b, B:17:0x00aa, B:21:0x00c5, B:18:0x00b6), top: B:26:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void getAllCache(java.lang.Object r6, java.lang.String r7) {
        /*
            r5 = this;
            com.anythink.core.common.b.n r0 = com.anythink.core.common.b.n.a()     // Catch: java.lang.Throwable -> L5e
            android.content.Context r0 = r0.g()     // Catch: java.lang.Throwable -> L5e
            java.lang.String r1 = "anythink_h5_cachesp"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)     // Catch: java.lang.Throwable -> L5e
            r8 = r0
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L5e
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L5e
            r7 = r0
            r0 = r8
            java.util.Map r0 = r0.getAll()     // Catch: java.lang.Throwable -> L5a
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L5a
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L5a
            r8 = r0
        L26:
            r0 = r8
            boolean r0 = r0.hasNext()     // Catch: java.lang.Throwable -> L5a
            if (r0 == 0) goto L53
            r0 = r8
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L5a
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L5a
            r9 = r0
            r0 = r7
            r1 = r9
            java.lang.Object r1 = r1.getKey()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L5a
            r2 = r9
            java.lang.Object r2 = r2.getValue()     // Catch: java.lang.Throwable -> L5a
            org.json.JSONObject r0 = r0.put(r1, r2)     // Catch: java.lang.Throwable -> L5a
            goto L26
        L53:
            java.lang.String r0 = "getAllCache Success"
            r8 = r0
            goto L8b
        L5a:
            r8 = move-exception
            goto L61
        L5e:
            r8 = move-exception
            r0 = 0
            r7 = r0
        L61:
            java.lang.String r0 = "JS-Video-Brigde"
            java.lang.String r1 = "getAllCache error "
            r2 = r8
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r1 = r1.concat(r2)
            com.anythink.expressad.foundation.h.o.d(r0, r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            java.lang.String r2 = "getAllCache Error, reason is : "
            r1.<init>(r2)
            r9 = r0
            r0 = r9
            r1 = r8
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r9
            java.lang.String r0 = r0.toString()
            r8 = r0
        L8b:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Ld9
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> Ld9
            r9 = r0
            r0 = r9
            java.lang.String r1 = "code"
            r2 = 0
            org.json.JSONObject r0 = r0.put(r1, r2)     // Catch: java.lang.Throwable -> Ld9
            r0 = r9
            java.lang.String r1 = "message"
            r2 = r8
            org.json.JSONObject r0 = r0.put(r1, r2)     // Catch: java.lang.Throwable -> Ld9
            r0 = r7
            if (r0 == 0) goto Lb6
            r0 = r9
            java.lang.String r1 = "data"
            r2 = r7
            org.json.JSONObject r0 = r0.put(r1, r2)     // Catch: java.lang.Throwable -> Ld9
            goto Lc1
        Lb6:
            r0 = r9
            java.lang.String r1 = "data"
            java.lang.String r2 = "{}"
            org.json.JSONObject r0 = r0.put(r1, r2)     // Catch: java.lang.Throwable -> Ld9
        Lc1:
            r0 = r6
            if (r0 == 0) goto Ld8
            com.anythink.expressad.atsignalcommon.windvane.j r0 = com.anythink.expressad.atsignalcommon.windvane.j.a()     // Catch: java.lang.Throwable -> Ld9
            r1 = r6
            r2 = r9
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Ld9
            byte[] r2 = r2.getBytes()     // Catch: java.lang.Throwable -> Ld9
            r3 = 2
            java.lang.String r2 = android.util.Base64.encodeToString(r2, r3)     // Catch: java.lang.Throwable -> Ld9
            r0.a(r1, r2)     // Catch: java.lang.Throwable -> Ld9
        Ld8:
            return
        Ld9:
            r6 = move-exception
            java.lang.String r0 = "JS-Video-Brigde"
            java.lang.String r1 = "getAllCache error "
            r2 = r6
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r1 = r1.concat(r2)
            com.anythink.expressad.foundation.h.o.d(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.signal.communication.BaseVideoBridge.getAllCache(java.lang.Object, java.lang.String):void");
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getAppSetting(Object obj, String str) {
        JSONObject jSONObject;
        try {
            String optString = new JSONObject(str).optString("appid", "");
            JSONObject jSONObject2 = new JSONObject();
            if (TextUtils.isEmpty(optString)) {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "Get App Setting error, because must give a appId.");
            } else {
                b.a();
                String a2 = b.a(optString);
                if (TextUtils.isEmpty(a2)) {
                    b.a();
                    jSONObject = new JSONObject(b.c().R());
                } else {
                    jSONObject = new JSONObject(a2);
                    jSONObject.put("isDefault", 0);
                }
                if (obj != null) {
                    jSONObject2.put("code", 0);
                    jSONObject2.put("message", "Success");
                    jSONObject2.put("data", jSONObject);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put("message", "Get App Setting error, plz try again later.");
                }
            }
            j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Throwable th) {
            o.d(h, "getAppSetting error : " + th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getComponentOptions(Object obj, String str) {
        a(obj, str);
        try {
            c.a();
            c.f(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "getComponentOptions error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getCurrentProgress(Object obj, String str) {
        try {
            if (this.i != null) {
                String currentProgress = this.i.getJSVideoModule().getCurrentProgress();
                o.b(h, "getCurrentProgress:".concat(String.valueOf(currentProgress)));
                String str2 = currentProgress;
                if (!TextUtils.isEmpty(currentProgress)) {
                    str2 = Base64.encodeToString(currentProgress.getBytes(), 2);
                }
                j.a().a(obj, str2);
            }
        } catch (Throwable th) {
            o.b(h, "getCurrentProgress error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getCutout(Object obj, String str) {
        try {
            String o2 = this.i.getJSCommon().o();
            o.d(h, o2);
            if (obj != null && !TextUtils.isEmpty(o2)) {
                j.a().a(obj, Base64.encodeToString(o2.getBytes(), 2));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put("message", "No notch data, plz try again later.");
            j.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            o.d(h, "getCutout error : " + th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getEncryptPrice(Object obj, String str) {
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getFileInfo(Object obj, String str) {
        a(obj, str);
        try {
            c.a();
            c.P(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.b(h, "getFileInfo error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getRewardSetting(Object obj, String str) {
        try {
            JSONObject k2 = com.anythink.expressad.videocommon.e.c.a().b().k();
            JSONObject jSONObject = new JSONObject();
            if (obj != null) {
                jSONObject.put("code", 0);
                jSONObject.put("message", "Success");
                jSONObject.put("data", k2);
            } else {
                jSONObject.put("code", 1);
                jSONObject.put("message", "Get Reward Setting error, plz try again later.");
            }
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            o.d(h, "getRewardSetting error : " + th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getRewardUnitSetting(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("appid", "");
            String optString2 = jSONObject.optString("unitid", "");
            JSONObject jSONObject2 = new JSONObject();
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "Get reward unit Setting error, because must give appId and unitId.");
            } else {
                JSONObject R = com.anythink.expressad.videocommon.e.c.a().a(optString, optString2).R();
                if (obj != null) {
                    jSONObject2.put("code", 0);
                    jSONObject2.put("message", "Success");
                    jSONObject2.put("data", R);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put("message", "Get Reward Unit Setting error, plz try again later.");
                }
            }
            j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Throwable th) {
            o.d(h, "getRewardUnitSetting error : " + th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getSDKInfo(Object obj, String str) {
        o.b(h, "getSDKInfo");
        try {
            if (TextUtils.isEmpty(str)) {
                j.a().b(obj, "params is null");
                return;
            }
            JSONArray jSONArray = new JSONObject(str).getJSONArray("type");
            JSONObject jSONObject = new JSONObject();
            if (this.i != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    int i2 = jSONArray.getInt(i);
                    jSONObject.put(a(i2), this.i.getJSCommon().h(i2));
                }
            } else if (obj != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= jSONArray.length()) {
                        break;
                    }
                    int i5 = jSONArray.getInt(i4);
                    com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                    if (aVar.f4263a.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
                        jSONObject.put(a(i5), ((com.anythink.expressad.video.signal.a.j) aVar.f4263a.getObject()).h(i5));
                    }
                    i3 = i4 + 1;
                }
            }
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            o.b(h, "getSDKInfo error", th);
            j.a().b(obj, "exception");
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getUnitSetting(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put("message", "Get Unit Setting error, RV/IV can not support this method.");
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            o.d(h, "getUnitSetting error : " + th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void gial(Object obj, String str) {
        o.a(h, "gial:".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", CommonJSBridgeImpUtils.b);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("packageNameList", "[]");
            jSONObject.put("data", jSONObject2);
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            CommonJSBridgeImpUtils.callbackExcep(obj, e.getMessage());
            o.a(h, e.getMessage());
        } catch (Throwable th) {
            CommonJSBridgeImpUtils.callbackExcep(obj, th.getMessage());
            o.a(h, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void handleNativeObject(Object obj, String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.b.a().a(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "handleNativeObject error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void handlerH5Exception(Object obj, String str) {
        try {
            if (this.i == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            o.b(h, "handlerH5Exception,params:".concat(String.valueOf(str)));
            this.i.getJSCommon().handlerH5Exception(jSONObject.optInt("code", c.f5450a), jSONObject.optString("message", "h5 error"));
        } catch (Throwable th) {
            o.b(h, "handlerH5Exception", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void hideView(Object obj, String str) {
        a(obj, str);
        try {
            c.a().n(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "hideView error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void increaseOfferFrequence(Object obj, String str) {
        a(obj, str);
        try {
            c.a();
            new JSONObject(str);
            c.a(obj);
        } catch (Throwable th) {
            o.d(h, "increaseOfferFrequence error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void init(Object obj, String str) {
        o.b(h, "init");
        try {
            int i = 1;
            if (this.i != null) {
                String i2 = this.i.getJSCommon().i();
                String str2 = i2;
                if (!TextUtils.isEmpty(i2)) {
                    str2 = Base64.encodeToString(i2.getBytes(), 2);
                }
                j.a().a(obj, str2);
                this.i.getJSCommon().h();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(l);
                int optInt2 = jSONObject.optInt("mute");
                int optInt3 = jSONObject.optInt(n);
                int optInt4 = jSONObject.optInt(o);
                int optInt5 = jSONObject.optInt(q);
                int optInt6 = jSONObject.optInt(r);
                int optInt7 = jSONObject.optInt(s);
                this.i.getJSCommon().a(optInt == 1);
                this.i.getJSCommon().b(optInt2);
                this.i.getJSCommon().c(optInt3);
                this.i.getJSCommon().d(optInt4);
                this.i.getJSCommon().e(optInt5);
                this.i.getJSCommon().f(optInt6);
                com.anythink.expressad.video.signal.c jSCommon = this.i.getJSCommon();
                if (optInt7 != 0) {
                    i = optInt7;
                }
                jSCommon.i(i);
            } else if (obj != null) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.f4263a.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
                    com.anythink.expressad.video.signal.a.j jVar = (com.anythink.expressad.video.signal.a.j) aVar.f4263a.getObject();
                    String i3 = jVar.i();
                    if (!TextUtils.isEmpty(str)) {
                        JSONObject jSONObject2 = new JSONObject(str);
                        int optInt8 = jSONObject2.optInt(l);
                        int optInt9 = jSONObject2.optInt("mute");
                        int optInt10 = jSONObject2.optInt(n);
                        int optInt11 = jSONObject2.optInt(o);
                        int optInt12 = jSONObject2.optInt(q);
                        int optInt13 = jSONObject2.optInt(r);
                        int optInt14 = jSONObject2.optInt(s);
                        jVar.a(optInt8 == 1);
                        jVar.b(optInt9);
                        jVar.c(optInt10);
                        jVar.d(optInt11);
                        jVar.e(optInt12);
                        jVar.f(optInt13);
                        if (optInt14 == 0) {
                            optInt14 = 1;
                        }
                        jVar.i(optInt14);
                        o.b(h, "init jsCommon.setIsShowingTransparent = ".concat(String.valueOf(optInt8)));
                    }
                    j.a().a(obj, Base64.encodeToString(i3.getBytes(), 2));
                }
            }
        } catch (Throwable th) {
            o.b(h, "init error", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.l
    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        super.initialize(obj, windVaneWebView);
        if (obj instanceof IJSFactory) {
            this.i = (IJSFactory) obj;
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void insertViewAbove(Object obj, String str) {
        a(obj, str);
        try {
            c.a().s(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "insertViewAbove error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void insertViewBelow(Object obj, String str) {
        a(obj, str);
        try {
            c.a().t(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "insertViewBelow error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void isSystemResume(Object obj, String str) {
        try {
            if (this.i != null) {
                o.b(h, "isSystemResume,params:".concat(String.valueOf(str)));
                j.a().a(obj, b(this.i.getActivityProxy().h()));
            }
        } catch (Throwable th) {
            o.b(h, "isSystemResume", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void ivRewardAdsWithoutVideo(Object obj, String str) {
        o.d(h, "ivRewardAdsWithoutVideo ： params".concat(String.valueOf(str)));
        try {
            if (TextUtils.isEmpty(str) || this.i == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.i.getJSContainerModule().ivRewardAdsWithoutVideo(str);
        } catch (Throwable th) {
            o.b(h, "ivRewardAdsWithoutVideo", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void loadads(Object obj, String str) {
        String str2;
        int i;
        int i2;
        o.b(h, "loadads");
        try {
            if (TextUtils.isEmpty(str)) {
                str2 = "";
                i = 1;
                i2 = 1;
            } else {
                JSONObject jSONObject = new JSONObject(str);
                str2 = jSONObject.optString("unitId");
                int optInt = jSONObject.optInt("type", 1);
                i2 = optInt;
                if (optInt > 2) {
                    i2 = 1;
                }
                i = jSONObject.optInt("adtype", 1);
            }
            if (TextUtils.isEmpty(str2)) {
                j.a().a(obj, b(1));
                return;
            }
            if (obj != null) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.f4263a instanceof WindVaneWebView) {
                    WindVaneWebView windVaneWebView = aVar.f4263a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        ((com.anythink.expressad.atsignalcommon.a.a) windVaneWebView.getWebViewListener()).a(str2, i2, i);
                    }
                }
            }
            j.a().a(obj, b(0));
        } catch (Throwable th) {
            o.b(h, "loadads error", th);
            j.a().a(obj, b(1));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void loadingResourceStatus(Object obj, String str) {
        a(obj, str);
        if (obj != null) {
            try {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                int optInt = new JSONObject(str).optInt("isReady", 1);
                if (aVar.f4263a != null) {
                    WindVaneWebView windVaneWebView = aVar.f4263a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        windVaneWebView.getWebViewListener().loadingResourceStatus(windVaneWebView, optInt);
                    }
                }
            } catch (Throwable th) {
                o.d(h, "loadingResourceStatus error ".concat(String.valueOf(th)));
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.i == null || TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("state");
            o.b(h, "notifyCloseBtn,result:".concat(String.valueOf(optInt)));
            this.i.getJSVideoModule().notifyCloseBtn(optInt);
        } catch (Throwable th) {
            o.b(h, "notifyCloseBtn", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void onlyAppendSubView(Object obj, String str) {
        a(obj, str);
        try {
            c.a().k(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "appendSubView error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void onlyAppendViewTo(Object obj, String str) {
        a(obj, str);
        try {
            c.a().l(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "appendViewTo error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void onlyInsertViewAbove(Object obj, String str) {
        a(obj, str);
        try {
            c.a().u(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "insertViewAbove error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void onlyInsertViewBelow(Object obj, String str) {
        a(obj, str);
        try {
            c.a().v(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "insertViewBelow error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void openURL(Object obj, String str) {
        o.d(h, "openURL:".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt("type");
            if (optInt == 1) {
                l.a(this.e, optString);
            } else if (optInt == 2) {
                l.b(this.e, optString);
            }
        } catch (JSONException e) {
            o.d(h, e.getMessage());
        } catch (Throwable th) {
            o.d(h, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playVideoFinishOperate(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str) || this.i == null || TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("type");
            o.b(h, "playVideoFinishOperate,type: ".concat(String.valueOf(optInt)));
            this.i.getJSCommon().g(optInt);
        } catch (Throwable th) {
            o.b(h, "playVideoFinishOperate error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerGetMuteState(Object obj, String str) {
        a(obj, str);
        try {
            c.a().H(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "playerGetMuteState error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerMute(Object obj, String str) {
        a(obj, str);
        try {
            c.a().F(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "playerMute error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerPause(Object obj, String str) {
        a(obj, str);
        try {
            c.a().B(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "playerPause error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerPlay(Object obj, String str) {
        a(obj, str);
        try {
            c.a().A(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "playerPlay error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerResume(Object obj, String str) {
        a(obj, str);
        try {
            c.a().C(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "playerResume error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerSetRenderType(Object obj, String str) {
        a(obj, str);
        try {
            c.a();
            c.J(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "playerSetRenderType error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerSetSource(Object obj, String str) {
        a(obj, str);
        try {
            c.a();
            c.I(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "playerSetSource error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerStop(Object obj, String str) {
        a(obj, str);
        try {
            c.a().D(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "playerStop error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerUnmute(Object obj, String str) {
        a(obj, str);
        try {
            c.a().G(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "playerUnmute error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerUpdateFrame(Object obj, String str) {
        a(obj, str);
        try {
            c.a();
            c.E(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "playerUpdateFrame error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void preloadSubPlayTemplateView(Object obj, String str) {
        a(obj, str);
        try {
            if (this.i != null) {
                c.a().K(obj, new JSONObject(str));
                return;
            }
            com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
            if (aVar.f4263a instanceof WindVaneWebView) {
                WindVaneWebView windVaneWebView = aVar.f4263a;
                if (windVaneWebView.getWebViewListener() == null) {
                    o.a(h, "preloadSubPlayTemplateView: failed");
                    return;
                }
                ((com.anythink.expressad.atsignalcommon.a.a) windVaneWebView.getWebViewListener()).a(obj, str);
                o.a(h, "preloadSubPlayTemplateView: RVWebViewListener");
            }
        } catch (Throwable th) {
            o.d(h, "preloadSubPlayTemplateView error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void progressBarOperate(Object obj, String str) {
        try {
            if (this.i == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.i.getJSVideoModule().progressBarOperate(new JSONObject(str).optInt("view_visible"));
            j.a().a(obj, b(0));
        } catch (Throwable th) {
            o.b(h, "progressOperate error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void progressOperate(Object obj, String str) {
        try {
            if (this.i == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("progress");
            int optInt2 = jSONObject.optInt("view_visible");
            o.b(h, "progressOperate,progress:" + optInt + ",viewVisible:" + optInt2);
            this.i.getJSVideoModule().progressOperate(optInt, optInt2);
            j.a().a(obj, b(0));
        } catch (Throwable th) {
            o.b(h, "progressOperate error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void reactDeveloper(Object obj, String str) {
        o.a(h, "reactDeveloper");
        try {
            if (this.i == null || TextUtils.isEmpty(str)) {
                j.a().b(obj, b(1));
            } else {
                this.i.getJSBTModule().reactDeveloper(obj, str);
            }
        } catch (Throwable th) {
            o.d(h, "reactDeveloper error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                int optInt = new JSONObject(str).optInt("isReady", 1);
                if (aVar.f4263a.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
                    ((com.anythink.expressad.video.signal.a.j) aVar.f4263a.getObject()).j(optInt);
                }
                if (aVar.f4263a != null) {
                    WindVaneWebView windVaneWebView = aVar.f4263a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        windVaneWebView.getWebViewListener().readyState(windVaneWebView, optInt);
                    }
                }
            } catch (Throwable th) {
                o.b(h, "readyStatus", th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008a  */
    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void removeCacheItem(java.lang.Object r6, java.lang.String r7) {
        /*
            r5 = this;
            r0 = 1
            r9 = r0
            com.anythink.core.common.b.n r0 = com.anythink.core.common.b.n.a()     // Catch: java.lang.Throwable -> L4f
            android.content.Context r0 = r0.g()     // Catch: java.lang.Throwable -> L4f
            java.lang.String r1 = "anythink_h5_cachesp"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)     // Catch: java.lang.Throwable -> L4f
            r10 = r0
            r0 = r7
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L4f
            if (r0 != 0) goto L49
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4f
            r1 = r0
            r2 = r7
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r1 = "key"
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Throwable -> L4f
            r7 = r0
            r0 = r7
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L4f
            if (r0 != 0) goto L40
            r0 = r10
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch: java.lang.Throwable -> L4f
            r1 = r7
            android.content.SharedPreferences$Editor r0 = r0.remove(r1)     // Catch: java.lang.Throwable -> L4f
            r0.apply()     // Catch: java.lang.Throwable -> L4f
        L40:
            java.lang.String r0 = "Delete Success"
            r7 = r0
            r0 = 1
            r8 = r0
            goto L7d
        L49:
            java.lang.String r0 = ""
            r7 = r0
            goto L7b
        L4f:
            r7 = move-exception
            java.lang.String r0 = "JS-Video-Brigde"
            java.lang.String r1 = "removeCacheItem error "
            r2 = r7
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r1 = r1.concat(r2)
            com.anythink.expressad.foundation.h.o.d(r0, r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            java.lang.String r2 = "Delete Error, reason is : "
            r1.<init>(r2)
            r10 = r0
            r0 = r10
            r1 = r7
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r0 = r0.toString()
            r7 = r0
        L7b:
            r0 = 0
            r8 = r0
        L7d:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Ld9
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> Ld9
            r10 = r0
            r0 = r8
            if (r0 == 0) goto L8d
            r0 = 0
            r9 = r0
        L8d:
            r0 = r10
            java.lang.String r1 = "code"
            r2 = r9
            org.json.JSONObject r0 = r0.put(r1, r2)     // Catch: java.lang.Throwable -> Ld9
            r0 = r10
            java.lang.String r1 = "message"
            r2 = r7
            org.json.JSONObject r0 = r0.put(r1, r2)     // Catch: java.lang.Throwable -> Ld9
            r0 = r6
            if (r0 == 0) goto Lbc
            r0 = r8
            if (r0 == 0) goto Lbc
            com.anythink.expressad.atsignalcommon.windvane.j r0 = com.anythink.expressad.atsignalcommon.windvane.j.a()     // Catch: java.lang.Throwable -> Ld9
            r1 = r6
            r2 = r10
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Ld9
            byte[] r2 = r2.getBytes()     // Catch: java.lang.Throwable -> Ld9
            r3 = 2
            java.lang.String r2 = android.util.Base64.encodeToString(r2, r3)     // Catch: java.lang.Throwable -> Ld9
            r0.a(r1, r2)     // Catch: java.lang.Throwable -> Ld9
            return
        Lbc:
            com.anythink.expressad.atsignalcommon.windvane.j r0 = com.anythink.expressad.atsignalcommon.windvane.j.a()     // Catch: java.lang.Throwable -> Ld9
            r1 = r6
            r2 = r10
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Ld9
            byte[] r2 = r2.getBytes()     // Catch: java.lang.Throwable -> Ld9
            r3 = 2
            java.lang.String r2 = android.util.Base64.encodeToString(r2, r3)     // Catch: java.lang.Throwable -> Ld9
            r0.b(r1, r2)     // Catch: java.lang.Throwable -> Ld9
            return
        Ld0:
            java.lang.String r0 = "JS-Video-Brigde"
            java.lang.String r1 = "removeCacheItem error "
            com.anythink.expressad.foundation.h.o.d(r0, r1)
            return
        Ld9:
            r6 = move-exception
            goto Ld0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.signal.communication.BaseVideoBridge.removeCacheItem(java.lang.Object, java.lang.String):void");
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void removeFromSuperView(Object obj, String str) {
        a(obj, str);
        try {
            c.a().h(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "removeFromSuperView error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void reportUrls(Object obj, String str) {
        o.a(h, "reportUrls");
        try {
            if (TextUtils.isEmpty(str)) {
                j.a().b(obj, b(1));
                return;
            }
            c.a();
            c.b(obj, str);
        } catch (Throwable th) {
            o.d(h, "reportUrls error ".concat(String.valueOf(th)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a2  */
    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setCacheItem(java.lang.Object r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.signal.communication.BaseVideoBridge.setCacheItem(java.lang.Object, java.lang.String):void");
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setScaleFitXY(Object obj, String str) {
        try {
            if (this.i == null || TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("fitxy");
            o.b(h, "setScaleFitXY,type:".concat(String.valueOf(optInt)));
            this.i.getJSVideoModule().setScaleFitXY(optInt);
        } catch (Throwable th) {
            o.b(h, "showVideoClickView error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setSubPlayTemplateInfo(Object obj, String str) {
        o.d(h, "setSubPlayTemplateInfo : ".concat(String.valueOf(str)));
        a(obj, str);
        try {
            c.a().N(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "setSubPlayTemplateInfo error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setViewAlpha(Object obj, String str) {
        a(obj, str);
        try {
            c.a().q(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "setViewAlpha error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setViewBgColor(Object obj, String str) {
        a(obj, str);
        try {
            c.a().p(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "setViewBgColor error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setViewRect(Object obj, String str) {
        a(obj, str);
        try {
            c.a().g(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "setViewRect error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setViewScale(Object obj, String str) {
        a(obj, str);
        try {
            c.a().r(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "setViewScale error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void showAlertView(Object obj, String str) {
        o.b(h, "showAlertView");
        try {
            if (this.i == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.i.getJSVideoModule().showIVRewardAlertView(str);
            j.a().a(obj, "showAlertView", "");
        } catch (Throwable th) {
            o.b(h, "showAlertView", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void showVideoClickView(Object obj, String str) {
        try {
            if (this.i == null || TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("type");
            o.b(h, "showVideoClickView,type:".concat(String.valueOf(optInt)));
            this.i.getJSContainerModule().showVideoClickView(optInt);
        } catch (Throwable th) {
            o.b(h, "showVideoClickView error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void showVideoLocation(Object obj, String str) {
        try {
            if (this.i == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("margin_top", 0);
            int optInt2 = jSONObject.optInt("margin_left", 0);
            int optInt3 = jSONObject.optInt("view_width", 0);
            int optInt4 = jSONObject.optInt("view_height", 0);
            int optInt5 = jSONObject.optInt("radius", 0);
            int optInt6 = jSONObject.optInt("border_top", 0);
            int optInt7 = jSONObject.optInt("border_left", 0);
            int optInt8 = jSONObject.optInt("border_width", 0);
            int optInt9 = jSONObject.optInt("border_height", 0);
            o.b(h, "showVideoLocation,margin_top:" + optInt + ",marginLeft:" + optInt2 + ",viewWidth:" + optInt3 + ",viewHeight:" + optInt4 + ",radius:" + optInt5 + ",borderTop: " + optInt6 + ",borderLeft: " + optInt7 + ",borderWidth: " + optInt8 + ",borderHeight: " + optInt9);
            this.i.getJSVideoModule().showVideoLocation(optInt, optInt2, optInt3, optInt4, optInt5, optInt6, optInt7, optInt8, optInt9);
            this.i.getJSCommon().l();
        } catch (Throwable th) {
            o.b(h, "showVideoLocation error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void showView(Object obj, String str) {
        a(obj, str);
        try {
            c.a().o(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "showView error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void soundOperate(Object obj, String str) {
        try {
            if (this.i == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("mute");
            int optInt2 = jSONObject.optInt("view_visible");
            String optString = jSONObject.optString("pt", "");
            o.b(h, "soundOperate,mute:" + optInt + ",viewVisible:" + optInt2 + ",pt:" + optString);
            if (TextUtils.isEmpty(optString)) {
                this.i.getJSVideoModule().soundOperate(optInt, optInt2);
            } else {
                this.i.getJSVideoModule().soundOperate(optInt, optInt2, optString);
            }
            j.a().a(obj, b(0));
        } catch (Throwable th) {
            o.b(h, "soundOperate error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void statistics(Object obj, String str) {
        o.b(h, "statistics,params:".concat(String.valueOf(str)));
        try {
            if (this.i == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            this.i.getJSCommon().a(jSONObject.optInt("type"), jSONObject.optString("data"));
        } catch (Throwable th) {
            o.b(h, "statistics error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.i == null || TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("state");
            o.b(h, "toggleCloseBtn,result:".concat(String.valueOf(optInt)));
            int i = 2;
            if (optInt != 1) {
                i = optInt == 2 ? 1 : 0;
            }
            this.i.getJSVideoModule().closeVideoOperate(0, i);
        } catch (Throwable th) {
            o.b(h, "toggleCloseBtn", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void triggerCloseBtn(Object obj, String str) {
        o.b(h, "triggerCloseBtn");
        try {
            if (this.i == null || TextUtils.isEmpty(str) || !new JSONObject(str).optString("state").equals("click")) {
                return;
            }
            this.i.getJSVideoModule().closeVideoOperate(1, -1);
            j.a().a(obj, b(0));
        } catch (Throwable th) {
            o.b(h, "triggerCloseBtn error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void videoOperate(Object obj, String str) {
        try {
            if (this.i == null || TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("pause_or_resume");
            o.b(h, "videoOperate,pauseOrResume:".concat(String.valueOf(optInt)));
            this.i.getJSVideoModule().videoOperate(optInt);
            j.a().a(obj, b(0));
        } catch (Throwable th) {
            o.b(h, "videoOperate error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewFireEvent(Object obj, String str) {
        a(obj, str);
        try {
            c.a().O(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "setSubPlayTemplateInfo error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewGoBack(Object obj, String str) {
        a(obj, str);
        try {
            c.a().y(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "webviewGoBack error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewGoForward(Object obj, String str) {
        a(obj, str);
        try {
            c.a().z(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "webviewGoForward error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewLoad(Object obj, String str) {
        a(obj, str);
        try {
            c.a().w(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "webviewLoad error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewReload(Object obj, String str) {
        a(obj, str);
        try {
            c.a().x(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(h, "webviewReload error ".concat(String.valueOf(th)));
        }
    }
}
