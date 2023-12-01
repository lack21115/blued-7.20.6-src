package com.anythink.expressad.atsignalcommon.bridge;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.l;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.a;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/bridge/CommonBannerJSBridgeImp.class */
public abstract class CommonBannerJSBridgeImp implements IBannerJSBridge {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4236a = CommonBannerJSBridgeImp.class.getSimpleName();

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void cai(Object obj, String str) {
        o.a(f4236a, "cai:".concat(String.valueOf(str)));
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
                        o.a(f4236a, e.getMessage());
                    }
                } catch (Throwable th) {
                    CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + th.getLocalizedMessage());
                    o.b(f4236a, "cai", th);
                }
            } catch (JSONException e2) {
                CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + e2.getLocalizedMessage());
                o.b(f4236a, "cai", e2);
            }
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void click(Object obj, String str) {
        o.a(f4236a, "click: ".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void getFileInfo(Object obj, String str) {
        o.a(f4236a, "getFileInfo:".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void getNetstat(Object obj, String str) {
        o.d(f4236a, "getNetstat:".concat(String.valueOf(str)));
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
                if (obj instanceof a) {
                    WindVaneWebView windVaneWebView = ((a) obj).f4263a;
                    context = g;
                    if (windVaneWebView != null) {
                        context = windVaneWebView.getContext();
                    }
                }
            } catch (Exception e) {
                o.d(f4236a, e.getMessage());
                context = g;
            }
        }
        if (context == null) {
            j.a().a(obj, CommonJSBridgeImpUtils.codeToJsonString(1));
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NativeAdvancedJsUtils.m, k.a());
            String jSONObject2 = jSONObject.toString();
            String str2 = jSONObject2;
            if (!TextUtils.isEmpty(jSONObject2)) {
                str2 = Base64.encodeToString(jSONObject2.getBytes(), 2);
            }
            j.a().a(obj, str2);
        } catch (Throwable th) {
            o.d(f4236a, th.getMessage());
            j.a().a(obj, CommonJSBridgeImpUtils.codeToJsonString(1));
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void gial(Object obj, String str) {
        o.a(f4236a, "gial:".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", CommonJSBridgeImpUtils.b);
            jSONObject.put("data", new JSONObject());
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            CommonJSBridgeImpUtils.callbackExcep(obj, e.getMessage());
            o.a(f4236a, e.getMessage());
        } catch (Throwable th) {
            CommonJSBridgeImpUtils.callbackExcep(obj, th.getMessage());
            o.a(f4236a, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void handlerH5Exception(Object obj, String str) {
        o.a(f4236a, "handlerH5Exception: ".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void increaseOfferFrequence(Object obj, String str) {
        o.a(f4236a, "increaseOfferFrequence:".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "params is null");
        } else if (TextUtils.isEmpty(str)) {
        } else {
            try {
                CommonJSBridgeImpUtils.increaseOfferFrequence(obj, new JSONObject(str));
            } catch (Throwable th) {
                o.b(f4236a, "increaseOfferFrequence", th);
            }
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void init(Object obj, String str) {
        o.a(f4236a, "init: ".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void install(Object obj, String str) {
        o.a(f4236a, "install: ".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void onJSBridgeConnect(Object obj, String str) {
        try {
            if (obj instanceof a) {
                j.a();
                j.b(((a) obj).f4263a);
            }
        } catch (Throwable th) {
            o.b(f4236a, "onJSBridgeConnect", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void openURL(Object obj, String str) {
        o.d(f4236a, "openURL:".concat(String.valueOf(str)));
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
                if (obj instanceof a) {
                    WindVaneWebView windVaneWebView = ((a) obj).f4263a;
                    context = g;
                    if (windVaneWebView != null) {
                        context = windVaneWebView.getContext();
                    }
                }
            } catch (Exception e) {
                o.d(f4236a, e.getMessage());
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
            o.d(f4236a, e2.getMessage());
        } catch (Throwable th) {
            o.d(f4236a, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void readyStatus(Object obj, String str) {
        o.a(f4236a, "readyStatus: ".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void reportUrls(Object obj, String str) {
        o.a(f4236a, "reportUrls:".concat(String.valueOf(str)));
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
                        j.a().a(obj, CommonJSBridgeImpUtils.codeToJsonString(0));
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
                o.b(f4236a, "reportUrls", th);
            }
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void resetCountdown(Object obj, String str) {
        o.a(f4236a, "resetCountdown: ".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void sendImpressions(Object obj, String str) {
        o.a(f4236a, "sendImpressions: ".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void toggleCloseBtn(Object obj, String str) {
        o.a(f4236a, "toggleCloseBtn: ".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void triggerCloseBtn(Object obj, String str) {
        o.a(f4236a, "triggerCloseBtn: ".concat(String.valueOf(str)));
    }
}
