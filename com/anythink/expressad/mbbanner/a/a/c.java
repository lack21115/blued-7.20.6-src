package com.anythink.expressad.mbbanner.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.anythink.core.common.a.i;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp;
import com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.g.a.f;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.s;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.OapsWrapper;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/mbbanner/a/a/c.class */
public final class c extends CommonBannerJSBridgeImp {
    private static final String b = "BannerJSBridgeImpl";

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<Context> f8004c;
    private List<com.anythink.expressad.foundation.d.c> d;
    private String e;
    private String f;
    private int g;
    private com.anythink.expressad.mbbanner.a.c.a h;
    private b i;
    private boolean j = false;

    public c(Context context, String str, String str2) {
        this.e = str;
        this.f = str2;
        this.f8004c = new WeakReference<>(context);
    }

    private static void a(Object obj, JSONObject jSONObject) {
        String str;
        String str2;
        String str3 = "message";
        JSONObject jSONObject2 = new JSONObject();
        String str4 = str3;
        String str5 = "code";
        try {
            jSONObject2.put("code", 0);
            jSONObject2.put("message", "");
            JSONArray jSONArray = jSONObject.getJSONArray("resource");
            if (jSONArray != null && jSONArray.length() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    str4 = str3;
                    str5 = "code";
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                    String optString = jSONObject3.optString(OapsKey.KEY_REF, "");
                    int i2 = jSONObject3.getInt("type");
                    JSONObject jSONObject4 = new JSONObject();
                    if (i2 == 1 && !TextUtils.isEmpty(optString)) {
                        JSONObject jSONObject5 = new JSONObject();
                        com.anythink.expressad.videocommon.b.a.a();
                        i b2 = com.anythink.expressad.videocommon.b.a.b(optString);
                        if (b2 != null) {
                            o.a(b, "VideoBean not null");
                            jSONObject5.put("type", 1);
                            try {
                                jSONObject5.put("videoDataLength", b2.d());
                                String b3 = b2.b();
                                if (TextUtils.isEmpty(b3)) {
                                    o.a(b, "VideoPath null");
                                    jSONObject5.put(OapsWrapper.KEY_PATH, "");
                                    jSONObject5.put("path4Web", "");
                                } else {
                                    o.a(b, "VideoPath not null");
                                    jSONObject5.put(OapsWrapper.KEY_PATH, b3);
                                    jSONObject5.put("path4Web", b3);
                                }
                                if (b2.c() == 100) {
                                    jSONObject5.put("downloaded", 1);
                                } else {
                                    jSONObject5.put("downloaded", 0);
                                }
                                jSONObject4.put(optString, jSONObject5);
                                jSONArray2.put(jSONObject4);
                            } catch (Throwable th) {
                                str = "code";
                                th = th;
                            }
                        } else {
                            o.a(b, "VideoBean null");
                        }
                    } else if (i2 == 2 && !TextUtils.isEmpty(optString)) {
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put("type", 2);
                        jSONObject6.put(OapsWrapper.KEY_PATH, com.anythink.expressad.videocommon.b.i.a().a(optString) == null ? "" : com.anythink.expressad.videocommon.b.i.a().c(optString));
                        jSONObject4.put(optString, jSONObject6);
                        jSONArray2.put(jSONObject4);
                    } else if (i2 == 3 && !TextUtils.isEmpty(optString)) {
                        File file = new File(optString);
                        if (file.exists() && file.isFile() && file.canRead()) {
                            o.a(b, "getFileInfo Mraid file ".concat(String.valueOf(optString)));
                            str2 = "file:////".concat(String.valueOf(optString));
                        } else {
                            str2 = "";
                        }
                        JSONObject jSONObject7 = new JSONObject();
                        jSONObject7.put("type", 3);
                        jSONObject7.put(OapsWrapper.KEY_PATH, str2);
                        jSONObject4.put(optString, jSONObject7);
                        jSONArray2.put(jSONObject4);
                    } else if (i2 == 4 && !TextUtils.isEmpty(optString)) {
                        JSONObject jSONObject8 = new JSONObject();
                        jSONObject8.put("type", 4);
                        jSONObject8.put(OapsWrapper.KEY_PATH, s.a(optString) == null ? "" : s.a(optString));
                        jSONObject4.put(optString, jSONObject8);
                        jSONArray2.put(jSONObject4);
                    }
                }
                jSONObject2.put("resource", jSONArray2);
                j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            }
            str = "code";
            try {
                jSONObject2.put(str, 1);
            } catch (JSONException e) {
                e = e;
            } catch (Throwable th2) {
                th = th2;
                str3 = "message";
            }
            try {
                try {
                    jSONObject2.put("message", "resource is null");
                    j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    return;
                } catch (Throwable unused) {
                    str3 = "message";
                    th = b;
                }
            } catch (JSONException e2) {
                e = e2;
                o.a(b, e.getMessage());
                return;
            }
        } catch (Throwable th3) {
            th = th3;
            str3 = str4;
            str = str5;
        }
        try {
            jSONObject2.put(str, 1);
            jSONObject2.put(str3, th.getLocalizedMessage());
            j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (JSONException e3) {
            o.a(b, e3.getMessage());
        }
    }

    public final void a() {
        if (this.h != null) {
            this.h = null;
        }
        if (this.i != null) {
            this.i = null;
        }
    }

    public final void a(int i) {
        this.g = i;
    }

    public final void a(com.anythink.expressad.mbbanner.a.c.a aVar) {
        if (aVar != null) {
            this.h = aVar;
        }
    }

    public final void a(List<com.anythink.expressad.foundation.d.c> list) {
        this.d = list;
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void click(Object obj, String str) {
        o.d(b, "click");
        try {
            if (this.d == null) {
                return;
            }
            com.anythink.expressad.foundation.d.c cVar = null;
            if (this.d != null) {
                cVar = null;
                if (this.d.size() > 0) {
                    cVar = this.d.get(0);
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject a2 = com.anythink.expressad.foundation.d.c.a(cVar);
                JSONObject jSONObject = new JSONObject(str).getJSONObject("pt");
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    a2.put(next, jSONObject.getString(next));
                }
                com.anythink.expressad.foundation.d.c b2 = com.anythink.expressad.foundation.d.c.b(a2);
                String optString = a2.optString("unitId");
                if (!TextUtils.isEmpty(optString)) {
                    b2.l(optString);
                }
                cVar = b2;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.h != null) {
                this.h.a(cVar);
            }
        } catch (Throwable th) {
            o.b(b, "click", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void close() {
        o.d(b, "close");
        try {
            if (this.h != null) {
                this.h.b();
            }
        } catch (Throwable th) {
            o.b(b, "close", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void expand(String str, boolean z) {
        Context context;
        String str2 = "";
        try {
            if (getMraidCampaign() != null) {
                if (TextUtils.isEmpty(getMraidCampaign().q())) {
                    str2 = getMraidCampaign().p();
                } else {
                    str2 = "file:////" + getMraidCampaign().q();
                }
            }
            Bundle bundle = new Bundle();
            String str3 = str;
            if (TextUtils.isEmpty(str)) {
                str3 = str2;
            }
            bundle.putString("url", str3);
            bundle.putBoolean("shouldUseCustomClose", z);
            if (this.f8004c != null && (context = this.f8004c.get()) != null) {
                if (this.i != null && this.i.isShowing()) {
                    return;
                }
                b bVar = new b(context, bundle, this.h);
                this.i = bVar;
                bVar.a(this.f, this.d);
                this.i.show();
            }
            if (this.h != null) {
                this.h.a(true);
            }
        } catch (Throwable th) {
            o.b(b, "expand", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void getFileInfo(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "params is empty");
            return;
        }
        try {
            a(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.a(b, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final com.anythink.expressad.foundation.d.c getMraidCampaign() {
        List<com.anythink.expressad.foundation.d.c> list = this.d;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.d.get(0);
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void init(Object obj, String str) {
        o.d(b, "BANNER INIT INVOKE");
        try {
            JSONObject jSONObject = new JSONObject();
            com.anythink.expressad.foundation.h.c cVar = new com.anythink.expressad.foundation.h.c(n.a().g());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.g);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", cVar.a());
            jSONObject.put("campaignList", com.anythink.expressad.foundation.d.c.b(this.d));
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.c c2 = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), this.f);
            com.anythink.expressad.d.c cVar2 = c2;
            if (c2 == null) {
                cVar2 = com.anythink.expressad.d.c.c(this.f);
            }
            if (!TextUtils.isEmpty(this.e)) {
                cVar2.e(this.e);
            }
            jSONObject.put("unitSetting", cVar2.s());
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.b.a(com.anythink.expressad.foundation.b.a.b().e());
            jSONObject.put("appSetting", new JSONObject());
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            o.b(b, "init", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void open(String str) {
        o.d(b, "open");
        try {
            o.d(b, str);
            String str2 = str;
            if (this.d.size() > 1) {
                n.a().g().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                str2 = null;
            }
            if (this.h != null) {
                this.h.a(true, str2);
            }
        } catch (Throwable th) {
            o.b(b, "open", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                int optInt = new JSONObject(str).optInt("isReady", 1);
                j.a().a(obj, CommonJSBridgeImpUtils.codeToJsonString(0));
                if (this.h != null) {
                    this.h.b(optInt);
                }
            } catch (Throwable th) {
                o.b(b, "readyStatus", th);
            }
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void sendImpressions(Object obj, String str) {
        o.a(b, "sendImpressions:".concat(String.valueOf(str)));
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
                for (com.anythink.expressad.foundation.d.c cVar : this.d) {
                    if (cVar.aZ().equals(string)) {
                        f.a(this.f, cVar, "banner");
                        arrayList.add(string);
                    }
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            o.b(b, "sendImpressions", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void toggleCloseBtn(Object obj, String str) {
        o.d(b, "toggleCloseBtn");
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("state");
            if (this.h != null) {
                this.h.a(optInt);
            }
        } catch (Throwable th) {
            o.b(b, "toggleCloseBtn", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void triggerCloseBtn(Object obj, String str) {
        o.d(b, "triggerCloseBtn");
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            new JSONObject(str).optString("state");
            if (this.h != null) {
                this.h.a();
            }
            j.a().a(obj, CommonJSBridgeImpUtils.codeToJsonString(0));
        } catch (Throwable th) {
            o.b(b, "triggerCloseBtn", th);
            j.a().a(obj, CommonJSBridgeImpUtils.codeToJsonString(-1));
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void unload() {
        close();
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void useCustomClose(boolean z) {
        int i = z ? 2 : 1;
        try {
            if (this.h != null) {
                this.h.a(i);
            }
        } catch (Throwable th) {
            o.b(b, "useCustomClose", th);
        }
    }
}
