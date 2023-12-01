package com.anythink.expressad.splash.view;

import android.app.Activity;
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
import com.anythink.core.common.k.u;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.splash.js.SplashJSBridgeImpl;
import com.anythink.expressad.splash.js.SplashJsUtils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/view/ATSplashView.class */
public class ATSplashView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    protected static final String f8270a = "webviewshow";
    protected static final String b = "updateCountdown";

    /* renamed from: c  reason: collision with root package name */
    private static String f8271c = "ATSplashView";
    private int d;
    private ATSplashWebview e;
    private ViewGroup f;
    private View g;
    private View h;
    private int i;
    private boolean j;
    private boolean k;
    private ViewGroup l;
    private boolean m;
    private View n;
    private boolean o;
    private boolean p;
    private RelativeLayout.LayoutParams q;
    private SplashJSBridgeImpl r;

    public ATSplashView(Context context) {
        this(context, null);
    }

    public ATSplashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ATSplashView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    private void b() {
        setBackgroundColor(0);
        this.d = getResources().getConfiguration().orientation;
    }

    private void c() {
        View view;
        View view2;
        View view3;
        if (this.h != null) {
            if (this.f == null) {
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                this.f = relativeLayout;
                relativeLayout.setId(2147482647);
            }
            if (this.d == 2) {
                this.i = t.f(getContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(0, this.f.getId());
                if (!this.o || (view2 = this.n) == null) {
                    ATSplashWebview aTSplashWebview = this.e;
                    if (aTSplashWebview != null && aTSplashWebview.getParent() == null) {
                        addView(this.e, layoutParams);
                    }
                    d();
                } else {
                    if (view2.getParent() != null) {
                        u.a(this.n);
                    }
                    addView(this.n, layoutParams);
                }
                ViewGroup viewGroup = this.f;
                if (viewGroup != null && viewGroup.getParent() == null) {
                    int i = this.q.width;
                    int i2 = this.i;
                    int i3 = i;
                    if (i > i2 / 4) {
                        i3 = i2 / 4;
                    }
                    this.f.addView(this.h, i3, -1);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i3, -1);
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(13);
                    addView(this.f, layoutParams2);
                }
            } else {
                this.i = t.e(getContext());
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams3.addRule(2, this.f.getId());
                if (!this.o || (view = this.n) == null) {
                    ATSplashWebview aTSplashWebview2 = this.e;
                    if (aTSplashWebview2 != null && aTSplashWebview2.getParent() == null) {
                        addView(this.e, layoutParams3);
                    }
                    d();
                } else {
                    if (view.getParent() != null) {
                        u.a(this.n);
                    }
                    addView(this.n, layoutParams3);
                }
                ViewGroup viewGroup2 = this.f;
                if (viewGroup2 != null && viewGroup2.getParent() == null) {
                    int i4 = this.q.height;
                    int i5 = this.i;
                    int i6 = i4;
                    if (i4 > i5 / 4) {
                        i6 = i5 / 4;
                    }
                    this.f.addView(this.h, -1, i6);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, i6);
                    layoutParams4.addRule(12);
                    addView(this.f, layoutParams4);
                }
            }
        } else if (!this.o || (view3 = this.n) == null) {
            ATSplashWebview aTSplashWebview3 = this.e;
            if (aTSplashWebview3 != null && aTSplashWebview3.getParent() == null) {
                addView(this.e, new ViewGroup.LayoutParams(-1, -1));
            }
            d();
        } else {
            if (view3.getParent() != null) {
                u.a(this.n);
            }
            addView(this.n, new ViewGroup.LayoutParams(-1, -1));
        }
        View view4 = this.g;
        if (view4 != null) {
            if (view4.getParent() != null) {
                bringChildToFront(this.g);
                return;
            }
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(t.b(getContext(), 100.0f), t.b(getContext(), 30.0f));
            layoutParams5.addRule(10);
            layoutParams5.addRule(11);
            layoutParams5.rightMargin = t.b(getContext(), 10.0f);
            layoutParams5.topMargin = t.b(getContext(), 10.0f);
            addView(this.g, layoutParams5);
        }
    }

    private void d() {
        ATSplashWebview aTSplashWebview = this.e;
        if (aTSplashWebview != null) {
            aTSplashWebview.setObject(this.r);
            this.e.post(new Runnable() { // from class: com.anythink.expressad.splash.view.ATSplashView.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        o.a(ATSplashView.f8271c, ATSplashView.f8270a);
                        int[] iArr = new int[2];
                        ATSplashView.this.e.getLocationOnScreen(iArr);
                        String str = ATSplashView.f8271c;
                        o.d(str, "coordinate:" + iArr[0] + "--" + iArr[1]);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("startX", t.a(n.a().g(), (float) iArr[0]));
                        jSONObject.put("startY", t.a(n.a().g(), (float) iArr[1]));
                        String jSONObject2 = jSONObject.toString();
                        int[] iArr2 = new int[2];
                        ATSplashView.this.e.getLocationInWindow(iArr2);
                        ATSplashView.transInfoForMraid(ATSplashView.this.e, iArr2[0], iArr2[1], ATSplashView.this.e.getWidth(), ATSplashView.this.e.getHeight());
                        String encodeToString = Base64.encodeToString(jSONObject2.toString().getBytes(), 2);
                        j.a();
                        j.a((WebView) ATSplashView.this.e, ATSplashView.f8270a, encodeToString);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void transInfoForMraid(WebView webView, int i, int i2, int i3, int i4) {
        o.d(f8271c, "transInfoForMraid");
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
            hashMap.put(CallMraidJS.f7085a, "Interstitial");
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
            o.b(f8271c, "transInfoForMraid", th);
        }
    }

    public void changeCloseBtnState(int i) {
        View view = this.g;
        if (view != null) {
            if (i == 2) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    public void clearResState() {
        this.m = false;
        this.k = false;
        this.j = false;
    }

    public void destroy() {
        ATSplashWebview aTSplashWebview = this.e;
        if (aTSplashWebview == null || aTSplashWebview.isDestroyed()) {
            return;
        }
        this.e.release();
        SplashJsUtils.sendEventToH5(this.e, "onSystemDestory", "");
    }

    public View getCloseView() {
        return this.g;
    }

    public ViewGroup getDevContainer() {
        return this.l;
    }

    public View getIconVg() {
        return this.h;
    }

    public SplashJSBridgeImpl getSplashJSBridgeImpl() {
        return this.r;
    }

    public ATSplashWebview getSplashWebview() {
        return this.e;
    }

    public boolean isAttach() {
        return this.p;
    }

    public boolean isDynamicView() {
        return this.o;
    }

    public boolean isH5Ready() {
        return this.j;
    }

    public boolean isImageReady() {
        return this.m;
    }

    public boolean isVideoReady() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.p = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b();
    }

    public void onPause() {
        View view = this.n;
        if (view == null || !(view instanceof ATSplashNativeView)) {
            return;
        }
        ((ATSplashNativeView) view).setIsPause(true);
    }

    public void onResume() {
        View view = this.n;
        if (view == null || !(view instanceof ATSplashNativeView)) {
            return;
        }
        ((ATSplashNativeView) view).setIsPause(false);
    }

    public void resetLoadState() {
        this.k = false;
        this.j = false;
    }

    public void setCloseView(View view) {
        this.g = view;
        if (view != null) {
            view.setContentDescription("closeButton");
        }
    }

    public void setDevContainer(ViewGroup viewGroup) {
        this.l = viewGroup;
    }

    public void setDynamicView(boolean z) {
        this.o = z;
    }

    public void setH5Ready(boolean z) {
        this.j = z;
    }

    public void setIconVg(View view, RelativeLayout.LayoutParams layoutParams) {
        this.h = view;
        this.q = layoutParams;
    }

    public void setImageReady(boolean z) {
        this.m = z;
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        View view = this.n;
        if (view == null || !(view instanceof ATSplashNativeView)) {
            return;
        }
        ((ATSplashNativeView) view).setNotchPadding(i, i2, i3, i4);
    }

    public void setSplashJSBridgeImpl(SplashJSBridgeImpl splashJSBridgeImpl) {
        this.r = splashJSBridgeImpl;
        ATSplashWebview aTSplashWebview = this.e;
        if (aTSplashWebview != null) {
            aTSplashWebview.setObject(splashJSBridgeImpl);
        }
    }

    public void setSplashNativeView(View view) {
        if (view != null) {
            this.n = view;
        }
    }

    public void setSplashWebview(ATSplashWebview aTSplashWebview) {
        this.e = aTSplashWebview;
        SplashJSBridgeImpl splashJSBridgeImpl = this.r;
        if (splashJSBridgeImpl != null) {
            aTSplashWebview.setObject(splashJSBridgeImpl);
        }
    }

    public void setVideoReady(boolean z) {
        this.k = z;
    }

    public void show() {
        View view;
        View view2;
        View view3;
        ViewGroup viewGroup;
        if (this.r != null && (viewGroup = this.l) != null && (viewGroup.getContext() instanceof Activity)) {
            this.r.updateContext(this.l.getContext());
        }
        if (this.h != null) {
            if (this.f == null) {
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                this.f = relativeLayout;
                relativeLayout.setId(2147482647);
            }
            if (this.d == 2) {
                this.i = t.f(getContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(0, this.f.getId());
                if (!this.o || (view2 = this.n) == null) {
                    ATSplashWebview aTSplashWebview = this.e;
                    if (aTSplashWebview != null && aTSplashWebview.getParent() == null) {
                        addView(this.e, layoutParams);
                    }
                    d();
                } else {
                    if (view2.getParent() != null) {
                        u.a(this.n);
                    }
                    addView(this.n, layoutParams);
                }
                ViewGroup viewGroup2 = this.f;
                if (viewGroup2 != null && viewGroup2.getParent() == null) {
                    int i = this.q.width;
                    int i2 = this.i;
                    int i3 = i;
                    if (i > i2 / 4) {
                        i3 = i2 / 4;
                    }
                    this.f.addView(this.h, i3, -1);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i3, -1);
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(13);
                    addView(this.f, layoutParams2);
                }
            } else {
                this.i = t.e(getContext());
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams3.addRule(2, this.f.getId());
                if (!this.o || (view = this.n) == null) {
                    ATSplashWebview aTSplashWebview2 = this.e;
                    if (aTSplashWebview2 != null && aTSplashWebview2.getParent() == null) {
                        addView(this.e, layoutParams3);
                    }
                    d();
                } else {
                    if (view.getParent() != null) {
                        u.a(this.n);
                    }
                    addView(this.n, layoutParams3);
                }
                ViewGroup viewGroup3 = this.f;
                if (viewGroup3 != null && viewGroup3.getParent() == null) {
                    int i4 = this.q.height;
                    int i5 = this.i;
                    int i6 = i4;
                    if (i4 > i5 / 4) {
                        i6 = i5 / 4;
                    }
                    this.f.addView(this.h, -1, i6);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, i6);
                    layoutParams4.addRule(12);
                    addView(this.f, layoutParams4);
                }
            }
        } else if (!this.o || (view3 = this.n) == null) {
            ATSplashWebview aTSplashWebview3 = this.e;
            if (aTSplashWebview3 != null && aTSplashWebview3.getParent() == null) {
                addView(this.e, new ViewGroup.LayoutParams(-1, -1));
            }
            d();
        } else {
            if (view3.getParent() != null) {
                u.a(this.n);
            }
            addView(this.n, new ViewGroup.LayoutParams(-1, -1));
        }
        View view4 = this.g;
        if (view4 != null) {
            if (view4.getParent() == null) {
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(t.b(getContext(), 100.0f), t.b(getContext(), 30.0f));
                layoutParams5.addRule(10);
                layoutParams5.addRule(11);
                layoutParams5.rightMargin = t.b(getContext(), 10.0f);
                layoutParams5.topMargin = t.b(getContext(), 10.0f);
                addView(this.g, layoutParams5);
            } else {
                bringChildToFront(this.g);
            }
        }
        clearResState();
    }

    public void updateCountdown(int i) {
        View view;
        if (this.e != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("countdown", i);
                String encodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
                j.a();
                j.a((WebView) this.e, b, encodeToString);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.o && (view = this.n) != null && (view instanceof ATSplashNativeView)) {
                ((ATSplashNativeView) view).updateCountDown(i);
            }
        }
    }
}
