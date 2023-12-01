package com.anythink.expressad.video.signal.communication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.l;
import com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.a;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.signal.factory.IJSFactory;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/signal/communication/BaseRewardJsH5.class */
public class BaseRewardJsH5 implements IRewardBridge {

    /* renamed from: a  reason: collision with root package name */
    protected static final String f5681a = "JS-Reward-Brigde";
    protected IJSFactory b;

    private static String a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String jSONObject2 = jSONObject.toString();
            return !TextUtils.isEmpty(jSONObject2) ? Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (Throwable th) {
            o.d(f5681a, "code to string is error");
            return "";
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void cai(Object obj, String str) {
        o.a(f5681a, "cai:".concat(String.valueOf(str)));
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
                    o.a(f5681a, e.getMessage());
                }
            } catch (Throwable th) {
                CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + th.getLocalizedMessage());
                o.b(f5681a, "cai", th);
            }
        } catch (JSONException e2) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + e2.getLocalizedMessage());
            o.b(f5681a, "cai", e2);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void getEndScreenInfo(Object obj, String str) {
        String str2;
        try {
            if (this.b != null) {
                String a2 = this.b.getIJSRewardVideoV1().a();
                if (TextUtils.isEmpty(a2)) {
                    str2 = "";
                    o.a(f5681a, "getEndScreenInfo failed");
                } else {
                    str2 = Base64.encodeToString(a2.getBytes(), 2);
                    o.a(f5681a, "getEndScreenInfo success");
                }
                j.a().a(obj, str2);
            }
        } catch (Throwable th) {
            o.b(f5681a, "getEndScreenInfo", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void gial(Object obj, String str) {
        o.a(f5681a, "gial:".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", CommonJSBridgeImpUtils.b);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("packageNameList", "[]");
            jSONObject.put("data", jSONObject2);
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            CommonJSBridgeImpUtils.callbackExcep(obj, e.getMessage());
            o.a(f5681a, e.getMessage());
        } catch (Throwable th) {
            CommonJSBridgeImpUtils.callbackExcep(obj, th.getMessage());
            o.a(f5681a, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void handlerPlayableException(Object obj, String str) {
        try {
            if (this.b == null || TextUtils.isEmpty(str)) {
                return;
            }
            String optString = new JSONObject(str).optString("msg");
            o.a(f5681a, "handlerPlayableException,msg:".concat(String.valueOf(str)));
            this.b.getIJSRewardVideoV1().handlerPlayableException(optString);
        } catch (Throwable th) {
            o.b(f5681a, "setOrientation", th);
        }
    }

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        if (context instanceof IJSFactory) {
            this.b = (IJSFactory) context;
        }
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        if (obj instanceof IJSFactory) {
            this.b = (IJSFactory) obj;
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void install(Object obj, String str) {
        com.anythink.expressad.video.signal.a.j jVar;
        Context context;
        try {
            if (this.b != null) {
                o.a(f5681a, "install:".concat(String.valueOf(str)));
                if (obj != null) {
                    a aVar = (a) obj;
                    if ((aVar.f4263a.getObject() instanceof com.anythink.expressad.video.signal.a.j) && (jVar = (com.anythink.expressad.video.signal.a.j) aVar.f4263a.getObject()) != null && (context = aVar.f4263a.getContext()) != null && context != context.getApplicationContext()) {
                        jVar.a(context);
                    }
                }
                if (this.b.getJSContainerModule().endCardShowing()) {
                    this.b.getJSCommon().click(3, str);
                } else {
                    this.b.getJSCommon().click(1, str);
                }
            }
        } catch (Throwable th) {
            o.b(f5681a, "install", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.b == null || TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("state");
            o.a(f5681a, "notifyCloseBtn,state:".concat(String.valueOf(str)));
            this.b.getIJSRewardVideoV1().notifyCloseBtn(optInt);
        } catch (Throwable th) {
            o.b(f5681a, "notifyCloseBtn", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void openURL(Object obj, String str) {
        o.d(f5681a, "openURL:".concat(String.valueOf(str)));
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
                o.d(f5681a, e.getMessage());
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
            o.d(f5681a, e2.getMessage());
        } catch (Throwable th) {
            o.d(f5681a, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void setOrientation(Object obj, String str) {
        try {
            if (this.b == null || TextUtils.isEmpty(str)) {
                return;
            }
            String optString = new JSONObject(str).optString("state");
            o.a(f5681a, "setOrientation,state:".concat(String.valueOf(str)));
            this.b.getIJSRewardVideoV1().b(optString);
        } catch (Throwable th) {
            o.b(f5681a, "setOrientation", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.b == null || TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("state");
            o.a(f5681a, "toggleCloseBtn,state:".concat(String.valueOf(str)));
            this.b.getIJSRewardVideoV1().toggleCloseBtn(optInt);
        } catch (Throwable th) {
            o.b(f5681a, "toggleCloseBtn", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void triggerCloseBtn(Object obj, String str) {
        try {
            if (this.b == null || TextUtils.isEmpty(str)) {
                return;
            }
            j.a().a(obj, a(0));
            this.b.getIJSRewardVideoV1().a(new JSONObject(str).optString("state"));
            o.a(f5681a, "triggerCloseBtn,state:".concat(String.valueOf(str)));
        } catch (Throwable th) {
            o.b(f5681a, "triggerCloseBtn", th);
            j.a().a(obj, a(-1));
        }
    }
}
