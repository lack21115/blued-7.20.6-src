package com.anythink.basead.mraid;

import android.app.Dialog;
import android.content.ClipDescription;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Camera;
import android.media.tv.TvContract;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.bytedance.applog.tracker.Tracker;
import com.google.android.material.badge.BadgeDrawable;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/mraid/c.class */
public final class c extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private final String f6020a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6021c;
    private FrameLayout d;
    private WindVaneWebView e;
    private TextView f;
    private b g;
    private IMraidJSBridge h;

    /* renamed from: com.anythink.basead.mraid.c$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/mraid/c$1.class */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            c.this.dismiss();
        }
    }

    /* renamed from: com.anythink.basead.mraid.c$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/mraid/c$2.class */
    final class AnonymousClass2 extends com.anythink.expressad.atsignalcommon.a.b {
        AnonymousClass2() {
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            StringBuilder sb = new StringBuilder("javascript:");
            com.anythink.expressad.d.b.a.a();
            sb.append(com.anythink.expressad.d.b.a.b());
            if (Build.VERSION.SDK_INT <= 19) {
                Tracker.loadUrl(webView, sb.toString());
            } else {
                webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: com.anythink.basead.mraid.c.2.1
                    private static void a() {
                    }

                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                    }
                });
            }
            c.a(c.this);
        }
    }

    /* renamed from: com.anythink.basead.mraid.c$3  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/mraid/c$3.class */
    final class AnonymousClass3 implements DialogInterface.OnDismissListener {
        AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            c.this.e.loadDataWithBaseURL(null, "", ClipDescription.MIMETYPE_TEXT_HTML, "utf-8", null);
            c.this.d.removeView(c.this.e);
            c.this.e.release();
            c.this.e = null;
            c.this.g = null;
        }
    }

    public c(Context context, Bundle bundle, b bVar) {
        super(context);
        this.f6020a = "BannerExpandDialog";
        this.h = new IMraidJSBridge() { // from class: com.anythink.basead.mraid.c.4
            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public final void close() {
                c.this.dismiss();
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public final void expand(String str, boolean z) {
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public final com.anythink.expressad.foundation.d.c getMraidCampaign() {
                return null;
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public final void open(String str) {
                try {
                    o.d("BannerExpandDialog", str);
                    if (c.this.g != null) {
                        c.this.g.open(str);
                    }
                } catch (Throwable th) {
                    o.b("BannerExpandDialog", "open", th);
                }
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public final void unload() {
                close();
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public final void useCustomClose(boolean z) {
                try {
                    c.this.f.setVisibility(z ? 4 : 0);
                } catch (Throwable th) {
                    o.b("BannerExpandDialog", "useCustomClose", th);
                }
            }
        };
        this.b = bundle.getString("url");
        this.f6021c = bundle.getBoolean("shouldUseCustomClose");
        this.g = bVar;
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
        this.f.setVisibility(this.f6021c ? 4 : 0);
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
        this.e.setObject(this.h);
        this.e.loadUrl(this.b);
        setOnDismissListener(new AnonymousClass3());
    }

    static /* synthetic */ void a(c cVar) {
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
            cVar.e.getLocationInWindow(new int[2]);
            CallMraidJS.getInstance().fireSetDefaultPosition(cVar.e, iArr[0], iArr[1], cVar.e.getWidth(), cVar.e.getHeight());
            CallMraidJS.getInstance().fireSetCurrentPosition(cVar.e, iArr[0], iArr[1], cVar.e.getWidth(), cVar.e.getHeight());
            CallMraidJS.getInstance().fireSetScreenSize(cVar.e, e, f);
            CallMraidJS.getInstance().fireSetMaxSize(cVar.e, intValue, intValue2);
            CallMraidJS.getInstance().fireChangeEventForPropertys(cVar.e, hashMap);
            CallMraidJS.getInstance().fireReadyEvent(cVar.e);
        } catch (Throwable th) {
            o.b("BannerExpandDialog", "notifyMraid", th);
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
            o.b("BannerExpandDialog", "notifyMraid", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
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
        this.f.setVisibility(this.f6021c ? 4 : 0);
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
        this.e.setObject(this.h);
        this.e.loadUrl(this.b);
        setOnDismissListener(new AnonymousClass3());
    }
}
