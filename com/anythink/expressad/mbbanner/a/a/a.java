package com.anythink.expressad.mbbanner.a.a;

import android.hardware.Camera;
import android.media.tv.TvContract;
import android.os.BatteryManager;
import android.util.Base64;
import android.webkit.WebView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/mbbanner/a/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7996a = "BannerCallJS";

    public static void a(WebView webView) {
        o.d(f7996a, "fireOnJSBridgeConnected");
        j.a();
        j.b(webView);
    }

    public static void a(WebView webView, float f, float f2) {
        o.d(f7996a, "fireOnBannerWebViewShow");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startX", f);
            jSONObject.put("startY", f2);
            jSONObject.put(BatteryManager.EXTRA_SCALE, t.c(n.a().g()));
            String encodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
            j.a();
            j.a(webView, "webviewshow", encodeToString);
        } catch (Throwable th) {
            o.b(f7996a, "fireOnBannerWebViewShow", th);
        }
    }

    private static void a(WebView webView, int i, int i2) {
        o.d(f7996a, "fireOnBannerViewSizeChange");
        try {
            CallMraidJS.getInstance().fireSizeChangeEvent(webView, i, i2);
        } catch (Throwable th) {
            o.b(f7996a, "fireOnBannerViewSizeChange", th);
        }
    }

    public static void a(WebView webView, int i, int i2, int i3, int i4) {
        o.d(f7996a, "transInfoForMraid");
        try {
            int i5 = n.a().g().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i5 == 2 ? Camera.Parameters.SCENE_MODE_LANDSCAPE : i5 == 1 ? Camera.Parameters.SCENE_MODE_PORTRAIT : "undefined");
            jSONObject.put(TvContract.Channels.COLUMN_LOCKED, "true");
            float e = k.e(n.a().g());
            float f = k.f(n.a().g());
            HashMap g = k.g(n.a().g());
            int intValue = ((Integer) g.get("width")).intValue();
            int intValue2 = ((Integer) g.get("height")).intValue();
            HashMap hashMap = new HashMap();
            hashMap.put(CallMraidJS.f7085a, "inline");
            hashMap.put("state", "default");
            hashMap.put(CallMraidJS.f7086c, "true");
            hashMap.put(CallMraidJS.d, jSONObject);
            float f2 = i;
            float f3 = i2;
            float f4 = i3;
            float f5 = i4;
            CallMraidJS.getInstance().fireSetDefaultPosition(webView, f2, f3, f4, f5);
            CallMraidJS.getInstance().fireSetCurrentPosition(webView, f2, f3, f4, f5);
            CallMraidJS.getInstance().fireSetScreenSize(webView, e, f);
            CallMraidJS.getInstance().fireSetMaxSize(webView, intValue, intValue2);
            CallMraidJS.getInstance().fireChangeEventForPropertys(webView, hashMap);
            CallMraidJS.getInstance().fireReadyEvent(webView);
        } catch (Throwable th) {
            o.b(f7996a, "transInfoForMraid", th);
        }
    }

    public static void a(WindVaneWebView windVaneWebView, boolean z) {
        try {
            CallMraidJS.getInstance().fireSetIsViewable(windVaneWebView, z ? "true" : "false");
        } catch (Throwable th) {
            o.b(f7996a, "fireMraidIsViewable", th);
        }
    }
}
