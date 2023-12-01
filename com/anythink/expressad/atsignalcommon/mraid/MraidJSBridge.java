package com.anythink.expressad.atsignalcommon.mraid;

import android.content.Context;
import android.hardware.Camera;
import android.text.TextUtils;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.a;
import com.anythink.expressad.atsignalcommon.windvane.l;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.o;
import com.huawei.hms.ads.fw;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/mraid/MraidJSBridge.class */
public class MraidJSBridge extends l {

    /* renamed from: a  reason: collision with root package name */
    protected static final String f4250a = "MraidJSBridge";
    private IMraidJSBridge b;

    public void close(Object obj, String str) {
        if (obj instanceof a) {
            CallMraidJS.getInstance().fireNativeMethodCompleteEvent(((a) obj).f4263a, "close");
        }
        try {
            o.d(f4250a, "MRAID close");
            if (this.b != null) {
                this.b.close();
            }
        } catch (Throwable th) {
            o.b(f4250a, "MRAID close", th);
        }
    }

    public void expand(Object obj, String str) {
        if (obj instanceof a) {
            CallMraidJS.getInstance().fireNativeMethodCompleteEvent(((a) obj).f4263a, "expand");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("shouldUseCustomClose");
            o.d(f4250a, "MRAID expand " + optString + " " + optString2);
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || this.b == null) {
                return;
            }
            this.b.expand(optString, optString2.toLowerCase().equals(fw.Code));
        } catch (Throwable th) {
            o.b(f4250a, "MRAID expand", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.l
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof IMraidJSBridge) {
                this.b = (IMraidJSBridge) context;
                return;
            }
            if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof IMraidJSBridge)) {
                this.b = (IMraidJSBridge) windVaneWebView.getObject();
            }
            if (windVaneWebView.getMraidObject() == null || !(windVaneWebView.getMraidObject() instanceof IMraidJSBridge)) {
                return;
            }
            this.b = (IMraidJSBridge) windVaneWebView.getMraidObject();
        } catch (Exception e) {
            if (com.anythink.expressad.a.f4103a) {
                e.printStackTrace();
            }
        }
    }

    public void open(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        if (obj instanceof a) {
            windVaneWebView = ((a) obj).f4263a;
            CallMraidJS.getInstance().fireNativeMethodCompleteEvent(windVaneWebView, "open");
        } else {
            windVaneWebView = null;
        }
        try {
            String optString = new JSONObject(str).optString("url");
            o.d(f4250a, "MRAID Open ".concat(String.valueOf(optString)));
            if (this.b == null || TextUtils.isEmpty(optString)) {
                return;
            }
            if (windVaneWebView != null && System.currentTimeMillis() - windVaneWebView.lastTouchTime > com.anythink.expressad.a.b.a.f4118c) {
                c mraidCampaign = this.b.getMraidCampaign();
                windVaneWebView.getUrl();
                int i = com.anythink.expressad.a.b.a.f4117a;
                if (com.anythink.expressad.a.b.a.a(mraidCampaign)) {
                    return;
                }
            }
            this.b.open(optString);
        } catch (Throwable th) {
            o.b(f4250a, "MRAID Open", th);
        }
    }

    public void setOrientationProperties(Object obj, String str) {
        if (obj instanceof a) {
            CallMraidJS.getInstance().fireNativeMethodCompleteEvent(((a) obj).f4263a, "setOrientationProperties");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("allowOrientationChange");
            String optString2 = jSONObject.optString("forceOrientation");
            o.d(f4250a, "MRAID setOrientationProperties");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || this.b == null) {
                return;
            }
            optString.toLowerCase().equals(fw.Code);
            String lowerCase = optString2.toLowerCase();
            int hashCode = lowerCase.hashCode();
            if (hashCode == 729267099) {
                if (lowerCase.equals(Camera.Parameters.SCENE_MODE_PORTRAIT)) {
                }
            } else if (hashCode != 1430647483) {
            } else {
                lowerCase.equals(Camera.Parameters.SCENE_MODE_LANDSCAPE);
            }
        } catch (Throwable th) {
            o.b(f4250a, "MRAID setOrientationProperties", th);
        }
    }

    public void unload(Object obj, String str) {
        if (obj instanceof a) {
            CallMraidJS.getInstance().fireNativeMethodCompleteEvent(((a) obj).f4263a, "unload");
        }
        try {
            o.d(f4250a, "MRAID unload");
            if (this.b != null) {
                this.b.unload();
            }
        } catch (Throwable th) {
            o.b(f4250a, "MRAID unload", th);
        }
    }

    public void useCustomClose(Object obj, String str) {
        if (obj instanceof a) {
            CallMraidJS.getInstance().fireNativeMethodCompleteEvent(((a) obj).f4263a, "useCustomClose");
        }
        try {
            String optString = new JSONObject(str).optString("shouldUseCustomClose");
            o.d(f4250a, "MRAID useCustomClose ".concat(String.valueOf(optString)));
            if (TextUtils.isEmpty(optString) || this.b == null) {
                return;
            }
            this.b.useCustomClose(optString.toLowerCase().equals(fw.Code));
        } catch (Throwable th) {
            o.b(f4250a, "MRAID useCustomClose", th);
        }
    }
}
