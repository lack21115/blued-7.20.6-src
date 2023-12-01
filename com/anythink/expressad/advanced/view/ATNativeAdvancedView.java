package com.anythink.expressad.advanced.view;

import android.content.Context;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.media.tv.TvContract;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.anythink.core.common.b.n;
import com.anythink.expressad.advanced.d.c;
import com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.huawei.hms.ads.fw;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/view/ATNativeAdvancedView.class */
public class ATNativeAdvancedView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    protected static final String f4210a = "webviewshow";
    private static String b = "ATNativeAdvancedView";

    /* renamed from: c  reason: collision with root package name */
    private ATNativeAdvancedWebview f4211c;
    private View d;
    private boolean e;
    private boolean f;
    private boolean g;
    private c h;
    private NativeAdvancedJSBridgeImpl i;
    private Context j;

    /* renamed from: com.anythink.expressad.advanced.view.ATNativeAdvancedView$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/view/ATNativeAdvancedView$1.class */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                o.a(ATNativeAdvancedView.b, ATNativeAdvancedView.f4210a);
                int[] iArr = new int[2];
                ATNativeAdvancedView.this.f4211c.getLocationOnScreen(iArr);
                String str = ATNativeAdvancedView.b;
                o.d(str, "coordinate:" + iArr[0] + "--" + iArr[1]);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("startX", t.a(n.a().g(), (float) iArr[0]));
                jSONObject.put("startY", t.a(n.a().g(), (float) iArr[1]));
                String encodeToString = Base64.encodeToString(jSONObject.toString().toString().getBytes(), 2);
                j.a();
                j.a((WebView) ATNativeAdvancedView.this.f4211c, ATNativeAdvancedView.f4210a, encodeToString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ATNativeAdvancedView(Context context) {
        this(context, null);
    }

    public ATNativeAdvancedView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ATNativeAdvancedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = context;
    }

    private void b() {
        ATNativeAdvancedWebview aTNativeAdvancedWebview = this.f4211c;
        if (aTNativeAdvancedWebview != null && aTNativeAdvancedWebview.getParent() == null) {
            addView(this.f4211c, new ViewGroup.LayoutParams(-1, -1));
        }
        int[] iArr = new int[2];
        this.f4211c.getLocationInWindow(iArr);
        ATNativeAdvancedWebview aTNativeAdvancedWebview2 = this.f4211c;
        transInfoForMraid(aTNativeAdvancedWebview2, iArr[0], iArr[1], aTNativeAdvancedWebview2.getWidth(), this.f4211c.getHeight());
        ATNativeAdvancedWebview aTNativeAdvancedWebview3 = this.f4211c;
        if (aTNativeAdvancedWebview3 != null) {
            aTNativeAdvancedWebview3.setObject(this.i);
            this.f4211c.post(new AnonymousClass1());
        }
        View view = this.d;
        if (view != null) {
            if (view.getParent() != null) {
                bringChildToFront(this.d);
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t.b(getContext(), 28.0f), t.b(getContext(), 16.0f));
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.rightMargin = t.b(getContext(), 2.0f);
            layoutParams.topMargin = t.b(getContext(), 2.0f);
            addView(this.d, layoutParams);
        }
    }

    private void c() {
        int[] iArr = new int[2];
        this.f4211c.getLocationInWindow(iArr);
        ATNativeAdvancedWebview aTNativeAdvancedWebview = this.f4211c;
        transInfoForMraid(aTNativeAdvancedWebview, iArr[0], iArr[1], aTNativeAdvancedWebview.getWidth(), this.f4211c.getHeight());
        ATNativeAdvancedWebview aTNativeAdvancedWebview2 = this.f4211c;
        if (aTNativeAdvancedWebview2 != null) {
            aTNativeAdvancedWebview2.setObject(this.i);
            this.f4211c.post(new AnonymousClass1());
        }
    }

    public static void transInfoForMraid(WebView webView, int i, int i2, int i3, int i4) {
        o.d(b, "transInfoForMraid");
        try {
            int i5 = n.a().g().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i5 == 2 ? Camera.Parameters.SCENE_MODE_LANDSCAPE : i5 == 1 ? Camera.Parameters.SCENE_MODE_PORTRAIT : "undefined");
            jSONObject.put(TvContract.Channels.COLUMN_LOCKED, fw.Code);
            float e = k.e(n.a().g());
            float f = k.f(n.a().g());
            HashMap g = k.g(n.a().g());
            int intValue = ((Integer) g.get("width")).intValue();
            int intValue2 = ((Integer) g.get("height")).intValue();
            HashMap hashMap = new HashMap();
            hashMap.put(CallMraidJS.f4247a, "inline");
            hashMap.put("state", "default");
            hashMap.put(CallMraidJS.f4248c, fw.Code);
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
            o.b(b, "transInfoForMraid", th);
        }
    }

    public void changeCloseBtnState(int i) {
        View view = this.d;
        if (view != null) {
            if (i == 2) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    public void clearResState() {
        this.g = false;
        this.f = false;
        this.e = false;
    }

    public void clearResStateAndRemoveClose() {
        clearResState();
        View view = this.d;
        if (view == null || view.getParent() == null) {
            return;
        }
        removeView(this.d);
    }

    public void destroy() {
        removeAllViews();
        ATNativeAdvancedWebview aTNativeAdvancedWebview = this.f4211c;
        if (aTNativeAdvancedWebview != null && !aTNativeAdvancedWebview.isDestroyed()) {
            this.f4211c.release();
            NativeAdvancedJsUtils.sendEventToH5(this.f4211c, "onSystemDestory", "");
        }
        if (this.j != null) {
            this.j = null;
        }
    }

    public NativeAdvancedJSBridgeImpl getAdvancedNativeJSBridgeImpl() {
        return this.i;
    }

    public ATNativeAdvancedWebview getAdvancedNativeWebview() {
        return this.f4211c;
    }

    public View getCloseView() {
        return this.d;
    }

    public boolean isEndCardReady() {
        return this.g;
    }

    public boolean isH5Ready() {
        return this.e;
    }

    public boolean isVideoReady() {
        return this.f;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void resetLoadState() {
        this.g = false;
        this.f = false;
        this.e = false;
    }

    public void setAdvancedNativeJSBridgeImpl(NativeAdvancedJSBridgeImpl nativeAdvancedJSBridgeImpl) {
        this.i = nativeAdvancedJSBridgeImpl;
        ATNativeAdvancedWebview aTNativeAdvancedWebview = this.f4211c;
        if (aTNativeAdvancedWebview != null) {
            aTNativeAdvancedWebview.setObject(nativeAdvancedJSBridgeImpl);
        }
    }

    public void setAdvancedNativeWebview(ATNativeAdvancedWebview aTNativeAdvancedWebview) {
        this.f4211c = aTNativeAdvancedWebview;
        NativeAdvancedJSBridgeImpl nativeAdvancedJSBridgeImpl = this.i;
        if (nativeAdvancedJSBridgeImpl != null) {
            aTNativeAdvancedWebview.setObject(nativeAdvancedJSBridgeImpl);
        }
    }

    public void setCloseView(View view) {
        this.d = view;
        if (view != null) {
            view.setContentDescription("closeButton");
        }
    }

    public void setEndCardReady(boolean z) {
        this.g = z;
    }

    public void setH5Ready(boolean z) {
        this.e = z;
    }

    public void setVideoReady(boolean z) {
        this.f = z;
    }

    public void show() {
        ATNativeAdvancedWebview aTNativeAdvancedWebview = this.f4211c;
        if (aTNativeAdvancedWebview != null && aTNativeAdvancedWebview.getParent() == null) {
            addView(this.f4211c, new ViewGroup.LayoutParams(-1, -1));
        }
        int[] iArr = new int[2];
        this.f4211c.getLocationInWindow(iArr);
        ATNativeAdvancedWebview aTNativeAdvancedWebview2 = this.f4211c;
        transInfoForMraid(aTNativeAdvancedWebview2, iArr[0], iArr[1], aTNativeAdvancedWebview2.getWidth(), this.f4211c.getHeight());
        ATNativeAdvancedWebview aTNativeAdvancedWebview3 = this.f4211c;
        if (aTNativeAdvancedWebview3 != null) {
            aTNativeAdvancedWebview3.setObject(this.i);
            this.f4211c.post(new AnonymousClass1());
        }
        View view = this.d;
        if (view != null) {
            if (view.getParent() == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t.b(getContext(), 28.0f), t.b(getContext(), 16.0f));
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                layoutParams.rightMargin = t.b(getContext(), 2.0f);
                layoutParams.topMargin = t.b(getContext(), 2.0f);
                addView(this.d, layoutParams);
            } else {
                bringChildToFront(this.d);
            }
        }
        clearResState();
    }
}
