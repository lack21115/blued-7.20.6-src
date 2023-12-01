package com.anythink.expressad.splash.js;

import android.app.Dialog;
import android.content.ClipDescription;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Camera;
import android.media.tv.TvContract;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.a.b;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.splash.d.a;
import com.bytedance.applog.tracker.Tracker;
import com.google.android.material.badge.BadgeDrawable;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/js/SplashExpandDialog.class */
public class SplashExpandDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private final String f8236a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8237c;
    private FrameLayout d;
    private WindVaneWebView e;
    private TextView f;
    private String g;
    private List<c> h;
    private a i;
    private IMraidJSBridge j;

    /* renamed from: com.anythink.expressad.splash.js.SplashExpandDialog$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/js/SplashExpandDialog$1.class */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            SplashExpandDialog.this.dismiss();
        }
    }

    /* renamed from: com.anythink.expressad.splash.js.SplashExpandDialog$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/js/SplashExpandDialog$2.class */
    class AnonymousClass2 extends b {
        AnonymousClass2() {
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            StringBuilder sb = new StringBuilder("javascript:");
            com.anythink.expressad.d.b.a.a();
            sb.append(com.anythink.expressad.d.b.a.b());
            if (Build.VERSION.SDK_INT <= 19) {
                Tracker.loadUrl(webView, sb.toString());
            } else {
                webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: com.anythink.expressad.splash.js.SplashExpandDialog.2.1
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(String str2) {
                    }
                });
            }
            SplashExpandDialog.a(SplashExpandDialog.this);
        }
    }

    /* renamed from: com.anythink.expressad.splash.js.SplashExpandDialog$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/js/SplashExpandDialog$3.class */
    class AnonymousClass3 implements DialogInterface.OnDismissListener {
        AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (SplashExpandDialog.this.i != null) {
                SplashExpandDialog.this.i.a(false);
                SplashExpandDialog.this.i.c();
            }
            SplashExpandDialog.this.e.loadDataWithBaseURL(null, "", ClipDescription.MIMETYPE_TEXT_HTML, "utf-8", null);
            SplashExpandDialog.this.d.removeView(SplashExpandDialog.this.e);
            SplashExpandDialog.this.e.release();
            SplashExpandDialog.this.e = null;
            SplashExpandDialog.this.i = null;
        }
    }

    public SplashExpandDialog(Context context, Bundle bundle, a aVar) {
        super(context);
        this.f8236a = "SplashExpandDialog";
        this.j = new IMraidJSBridge() { // from class: com.anythink.expressad.splash.js.SplashExpandDialog.4
            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public void close() {
                SplashExpandDialog.this.dismiss();
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public void expand(String str, boolean z) {
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public c getMraidCampaign() {
                return null;
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public void open(String str) {
                try {
                    if (SplashExpandDialog.this.e != null && System.currentTimeMillis() - SplashExpandDialog.this.e.lastTouchTime > com.anythink.expressad.a.b.a.f6956c) {
                        c cVar = (c) SplashExpandDialog.this.h.get(0);
                        SplashExpandDialog.this.e.getUrl();
                        int i = com.anythink.expressad.a.b.a.f6955a;
                        if (com.anythink.expressad.a.b.a.a(cVar)) {
                            return;
                        }
                    }
                    o.d("SplashExpandDialog", str);
                    String str2 = str;
                    if (SplashExpandDialog.this.h.size() > 1) {
                        n.a().g().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        str2 = null;
                    }
                    if (SplashExpandDialog.this.i != null) {
                        SplashExpandDialog.this.i.b(str2);
                    }
                } catch (Throwable th) {
                    o.b("SplashExpandDialog", "open", th);
                }
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public void unload() {
                close();
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public void useCustomClose(boolean z) {
                try {
                    SplashExpandDialog.this.f.setVisibility(z ? 4 : 0);
                } catch (Throwable th) {
                    o.b("SplashExpandDialog", "useCustomClose", th);
                }
            }
        };
        if (bundle != null) {
            this.b = bundle.getString("url");
            this.f8237c = bundle.getBoolean("shouldUseCustomClose");
        }
        this.i = aVar;
    }

    private void a() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.d = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        WindVaneWebView windVaneWebView = new WindVaneWebView(getContext().getApplicationContext());
        this.e = windVaneWebView;
        windVaneWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.d.addView(this.e);
        TextView textView = new TextView(getContext());
        this.f = textView;
        textView.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = BadgeDrawable.TOP_END;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f.setLayoutParams(layoutParams);
        this.f.setVisibility(this.f8237c ? 4 : 0);
        this.f.setOnClickListener(new AnonymousClass1());
        this.d.addView(this.f);
        setContentView(this.d);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            getWindow().setAttributes(attributes);
            if (Build.VERSION.SDK_INT >= 16) {
                int i = 519;
                if (Build.VERSION.SDK_INT >= 19) {
                    i = 4615;
                }
                getWindow().getDecorView().setSystemUiVisibility(i);
            }
        }
        this.e.setWebViewListener(new AnonymousClass2());
        this.e.setObject(this.j);
        this.e.loadUrl(this.b);
        setOnDismissListener(new AnonymousClass3());
    }

    static /* synthetic */ void a(SplashExpandDialog splashExpandDialog) {
        int[] iArr;
        try {
            int i = n.a().g().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i == 2 ? Camera.Parameters.SCENE_MODE_LANDSCAPE : i == 1 ? Camera.Parameters.SCENE_MODE_PORTRAIT : "undefined");
            jSONObject.put(TvContract.Channels.COLUMN_LOCKED, "true");
            float e = k.e(n.a().g());
            float f = k.f(n.a().g());
            HashMap g = k.g(n.a().g());
            int intValue = ((Integer) g.get("width")).intValue();
            int intValue2 = ((Integer) g.get("height")).intValue();
            HashMap hashMap = new HashMap();
            hashMap.put(CallMraidJS.f7085a, "Interstitial");
            hashMap.put("state", CallMraidJS.g);
            hashMap.put(CallMraidJS.f7086c, "true");
            hashMap.put(CallMraidJS.d, jSONObject);
            splashExpandDialog.e.getLocationInWindow(new int[2]);
            CallMraidJS.getInstance().fireSetDefaultPosition(splashExpandDialog.e, iArr[0], iArr[1], splashExpandDialog.e.getWidth(), splashExpandDialog.e.getHeight());
            CallMraidJS.getInstance().fireSetCurrentPosition(splashExpandDialog.e, iArr[0], iArr[1], splashExpandDialog.e.getWidth(), splashExpandDialog.e.getHeight());
            CallMraidJS.getInstance().fireSetScreenSize(splashExpandDialog.e, e, f);
            CallMraidJS.getInstance().fireSetMaxSize(splashExpandDialog.e, intValue, intValue2);
            CallMraidJS.getInstance().fireChangeEventForPropertys(splashExpandDialog.e, hashMap);
            CallMraidJS.getInstance().fireReadyEvent(splashExpandDialog.e);
        } catch (Throwable th) {
            o.b("SplashExpandDialog", "notifyMraid", th);
        }
    }

    private void b() {
        int[] iArr;
        try {
            int i = n.a().g().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i == 2 ? Camera.Parameters.SCENE_MODE_LANDSCAPE : i == 1 ? Camera.Parameters.SCENE_MODE_PORTRAIT : "undefined");
            jSONObject.put(TvContract.Channels.COLUMN_LOCKED, "true");
            float e = k.e(n.a().g());
            float f = k.f(n.a().g());
            HashMap g = k.g(n.a().g());
            int intValue = ((Integer) g.get("width")).intValue();
            int intValue2 = ((Integer) g.get("height")).intValue();
            HashMap hashMap = new HashMap();
            hashMap.put(CallMraidJS.f7085a, "Interstitial");
            hashMap.put("state", CallMraidJS.g);
            hashMap.put(CallMraidJS.f7086c, "true");
            hashMap.put(CallMraidJS.d, jSONObject);
            this.e.getLocationInWindow(new int[2]);
            CallMraidJS.getInstance().fireSetDefaultPosition(this.e, iArr[0], iArr[1], this.e.getWidth(), this.e.getHeight());
            CallMraidJS.getInstance().fireSetCurrentPosition(this.e, iArr[0], iArr[1], this.e.getWidth(), this.e.getHeight());
            CallMraidJS.getInstance().fireSetScreenSize(this.e, e, f);
            CallMraidJS.getInstance().fireSetMaxSize(this.e, intValue, intValue2);
            CallMraidJS.getInstance().fireChangeEventForPropertys(this.e, hashMap);
            CallMraidJS.getInstance().fireReadyEvent(this.e);
        } catch (Throwable th) {
            o.b("SplashExpandDialog", "notifyMraid", th);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.d = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        WindVaneWebView windVaneWebView = new WindVaneWebView(getContext().getApplicationContext());
        this.e = windVaneWebView;
        windVaneWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.d.addView(this.e);
        TextView textView = new TextView(getContext());
        this.f = textView;
        textView.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = BadgeDrawable.TOP_END;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f.setLayoutParams(layoutParams);
        this.f.setVisibility(this.f8237c ? 4 : 0);
        this.f.setOnClickListener(new AnonymousClass1());
        this.d.addView(this.f);
        setContentView(this.d);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            getWindow().setAttributes(attributes);
            if (Build.VERSION.SDK_INT >= 16) {
                int i = 519;
                if (Build.VERSION.SDK_INT >= 19) {
                    i = 4615;
                }
                getWindow().getDecorView().setSystemUiVisibility(i);
            }
        }
        this.e.setWebViewListener(new AnonymousClass2());
        this.e.setObject(this.j);
        this.e.loadUrl(this.b);
        setOnDismissListener(new AnonymousClass3());
    }

    public void setCampaignList(String str, List<c> list) {
        this.g = str;
        this.h = list;
    }
}
