package com.anythink.core.basead.ui.web;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.anythink.core.api.IOfferClickHandler;
import com.anythink.core.basead.a;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.am;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.j.c;
import com.anythink.core.common.k.h;
import com.anythink.core.common.k.l;
import com.bytedance.applog.tracker.Tracker;
import com.youzan.androidsdk.tool.WebParameter;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.json.JSONArray;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/basead/ui/web/WebLandPageActivity.class */
public class WebLandPageActivity extends Activity {
    private static final int e = 343452;
    JSONArray b;
    private WebProgressBarView f;
    private WebView g;
    private ImageButton h;
    private ImageButton i;
    private ImageButton j;
    private ImageButton k;
    private boolean l;
    private i m;
    private j n;
    private String o;
    private IOfferClickHandler p;
    private b q;

    /* renamed from: a  reason: collision with root package name */
    int f6397a = 8;
    private ValueCallback<Uri[]> r = null;
    private final int s = 512;

    /* renamed from: c  reason: collision with root package name */
    int f6398c = 0;
    int d = 0;

    /* renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/basead/ui/web/WebLandPageActivity$1.class */
    final class AnonymousClass1 implements DownloadListener {
        AnonymousClass1() {
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (WebLandPageActivity.this.m == null || WebLandPageActivity.this.n == null || TextUtils.isEmpty(WebLandPageActivity.this.m.B())) {
                WebLandPageActivity.this.f6397a = 11;
                l.a(WebLandPageActivity.this, str);
            } else if (WebLandPageActivity.this.p != null && (WebLandPageActivity.this.p instanceof IOfferClickHandler) && WebLandPageActivity.this.p.startDownloadApp(WebLandPageActivity.this.getApplicationContext(), WebLandPageActivity.this.m, WebLandPageActivity.this.n, str)) {
                WebLandPageActivity.this.f6397a = 6;
                WebLandPageActivity.this.d = 1;
            } else {
                WebLandPageActivity.this.d = 2;
                l.a(WebLandPageActivity.this, str);
                WebLandPageActivity.this.f6397a = 7;
            }
            WebLandPageActivity.this.finish();
        }
    }

    /* renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/basead/ui/web/WebLandPageActivity$2.class */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            if (WebLandPageActivity.this.g.canGoBack()) {
                WebLandPageActivity.this.g.goBack();
            }
        }
    }

    /* renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$3  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/basead/ui/web/WebLandPageActivity$3.class */
    final class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            if (WebLandPageActivity.this.g.canGoForward()) {
                WebLandPageActivity.this.g.goForward();
            }
        }
    }

    /* renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$4  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/basead/ui/web/WebLandPageActivity$4.class */
    final class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            WebLandPageActivity.this.g.reload();
        }
    }

    /* renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$5  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/basead/ui/web/WebLandPageActivity$5.class */
    final class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            WebLandPageActivity.this.finish();
        }
    }

    private ImageButton a(Drawable drawable) {
        ImageButton imageButton = new ImageButton(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, h.a(this, 35.0f), 1.0f);
        layoutParams.gravity = 16;
        imageButton.setLayoutParams(layoutParams);
        imageButton.setBackgroundColor(0);
        imageButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageButton.setImageDrawable(drawable);
        return imageButton;
    }

    public static void a(Context context, com.anythink.core.basead.b.a aVar) {
        Intent intent = new Intent();
        intent.setClass(context, WebLandPageActivity.class);
        intent.putExtra(a.C0092a.f6391c, aVar.f6395c);
        intent.putExtra(a.C0092a.e, aVar.h);
        intent.putExtra(a.C0092a.j, aVar.f);
        if (aVar.g != null) {
            intent.putExtra(a.C0092a.l, aVar.g);
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static void a(Context context, String str) {
        com.anythink.core.basead.b.a aVar = new com.anythink.core.basead.b.a();
        aVar.f = str;
        a(context, aVar);
    }

    private void a(String str) {
        WebSettings settings = this.g.getSettings();
        this.g.setHorizontalScrollBarEnabled(false);
        this.g.setVerticalScrollBarEnabled(false);
        this.g.setVerticalScrollBarEnabled(false);
        this.g.requestFocus();
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setAppCacheMaxSize(5242880L);
        settings.setAllowFileAccess(false);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setSavePassword(false);
        settings.setDatabaseEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        if (Build.VERSION.SDK_INT >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Method declaredMethod = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(settings, Boolean.FALSE);
            } catch (Exception e3) {
            }
        }
        settings.setDatabaseEnabled(true);
        String path = getDir(WebParameter.PATH_DATABASE, 0).getPath();
        settings.setDatabasePath(path);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(path);
        this.g.setWebViewClient(new a(this));
        this.g.setDownloadListener(new AnonymousClass1());
        am a2 = com.anythink.core.basead.a.a.a(str);
        this.f6397a = a2.l;
        Tracker.loadUrl(this.g, a2.o);
    }

    private void a(boolean z) {
        this.i.setImageResource(z ? h.a(this, "browser_right_icon", com.anythink.expressad.foundation.h.i.f7952c) : h.a(this, "browser_unright_icon", com.anythink.expressad.foundation.h.i.f7952c));
    }

    private void b() {
        Intent intent = getIntent();
        if (intent != null) {
            try {
                Serializable serializableExtra = intent.getSerializableExtra(a.C0092a.f6391c);
                if (serializableExtra != null && (serializableExtra instanceof i)) {
                    i iVar = (i) serializableExtra;
                    this.m = iVar;
                    this.q = new b(iVar);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                Serializable serializableExtra2 = intent.getSerializableExtra(a.C0092a.e);
                if (serializableExtra2 != null && (serializableExtra2 instanceof j)) {
                    this.n = (j) serializableExtra2;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            try {
                Serializable serializableExtra3 = intent.getSerializableExtra(a.C0092a.l);
                if (serializableExtra3 != null && (serializableExtra3 instanceof IOfferClickHandler)) {
                    this.p = (IOfferClickHandler) serializableExtra3;
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            try {
                this.o = intent.getStringExtra(a.C0092a.j);
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
        }
    }

    private void b(String str) {
        if (this.b == null) {
            this.b = new JSONArray();
        }
        this.b.put(str);
    }

    private void b(boolean z) {
        this.h.setImageResource(z ? h.a(this, "browser_left_icon", com.anythink.expressad.foundation.h.i.f7952c) : h.a(this, "browser_unleft_icon", com.anythink.expressad.foundation.h.i.f7952c));
    }

    private void c() {
        this.h.setBackgroundColor(0);
        this.h.setOnClickListener(new AnonymousClass2());
        this.i.setBackgroundColor(0);
        this.i.setOnClickListener(new AnonymousClass3());
        this.j.setBackgroundColor(0);
        this.j.setOnClickListener(new AnonymousClass4());
        this.k.setBackgroundColor(0);
        this.k.setOnClickListener(new AnonymousClass5());
    }

    private void d() {
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
    }

    private View e() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(-16777216);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setId(e);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, h.a(this, 55.0f));
        layoutParams.addRule(12);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundDrawable(new ColorDrawable(-592138));
        int a2 = h.a(this, 20.0f);
        linearLayout.setPadding(a2, 0, a2, 0);
        relativeLayout.addView(linearLayout);
        this.h = a(getResources().getDrawable(h.a(this, "browser_unleft_icon", com.anythink.expressad.foundation.h.i.f7952c)));
        this.i = a(getResources().getDrawable(h.a(this, "browser_unright_icon", com.anythink.expressad.foundation.h.i.f7952c)));
        this.j = a(getResources().getDrawable(h.a(this, "browser_refresh_icon", com.anythink.expressad.foundation.h.i.f7952c)));
        this.k = a(getResources().getDrawable(h.a(this, "browser_close_icon", com.anythink.expressad.foundation.h.i.f7952c)));
        linearLayout.addView(this.h);
        linearLayout.addView(this.i);
        linearLayout.addView(this.j);
        linearLayout.addView(this.k);
        this.g = new BaseWebView(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(2, e);
        this.g.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.g);
        View view = new View(this);
        view.setBackgroundColor(-2434342);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, h.a(this, 1.0f));
        layoutParams3.addRule(2, e);
        view.setLayoutParams(layoutParams3);
        relativeLayout.addView(view);
        WebProgressBarView webProgressBarView = new WebProgressBarView(this);
        this.f = webProgressBarView;
        webProgressBarView.setProgress(0);
        relativeLayout.addView(this.f, new RelativeLayout.LayoutParams(-1, h.a(this, 2.0f)));
        return relativeLayout;
    }

    public final WebProgressBarView a() {
        return this.f;
    }

    public final void a(WebView webView, String str) {
        this.h.setImageResource(webView.canGoBack() ? h.a(this, "browser_left_icon", com.anythink.expressad.foundation.h.i.f7952c) : h.a(this, "browser_unleft_icon", com.anythink.expressad.foundation.h.i.f7952c));
        this.i.setImageResource(webView.canGoForward() ? h.a(this, "browser_right_icon", com.anythink.expressad.foundation.h.i.f7952c) : h.a(this, "browser_unright_icon", com.anythink.expressad.foundation.h.i.f7952c));
        b bVar = this.q;
        if (bVar == null || bVar.b == null) {
            return;
        }
        try {
            Iterator<String> keys = bVar.b.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && str != null && str.contains(next) && bVar.f6410c.get(next) == null) {
                    bVar.f6410c.put(next, Boolean.TRUE);
                    Tracker.loadUrl(webView, bVar.b.optString(next));
                }
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(am amVar) {
        this.f6397a = amVar.l;
        if (amVar.n) {
            if (!amVar.m) {
                this.f6398c = 2;
                return;
            }
            this.f6398c = 1;
            finish();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void finish() {
        ((ViewGroup) getWindow().getDecorView()).removeAllViews();
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006b A[Catch: all -> 0x0095, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0095, blocks: (B:4:0x0007, B:11:0x0018, B:26:0x006b, B:27:0x007d), top: B:38:0x0007 }] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(int r6, int r7, android.content.Intent r8) {
        /*
            r5 = this;
            r0 = r6
            r1 = 512(0x200, float:7.175E-43)
            if (r0 != r1) goto L94
            r0 = r5
            android.webkit.ValueCallback<android.net.Uri[]> r0 = r0.r     // Catch: java.lang.Throwable -> L95
            if (r0 != 0) goto Lf
            return
        Lf:
            r0 = r7
            r1 = -1
            if (r0 != r1) goto La4
            r0 = r8
            if (r0 == 0) goto La4
            r0 = r8
            java.lang.String r0 = r0.getDataString()     // Catch: java.lang.Throwable -> L95
            r12 = r0
            r0 = r8
            android.content.ClipData r0 = r0.getClipData()     // Catch: java.lang.Throwable -> L9a
            r13 = r0
            r0 = r13
            if (r0 == 0) goto L63
            r0 = r13
            int r0 = r0.getItemCount()     // Catch: java.lang.Throwable -> L9a
            android.net.Uri[] r0 = new android.net.Uri[r0]     // Catch: java.lang.Throwable -> L9a
            r11 = r0
            r0 = 0
            r9 = r0
        L36:
            r0 = r11
            r10 = r0
            r0 = r9
            r1 = r13
            int r1 = r1.getItemCount()     // Catch: java.lang.Throwable -> L9f
            if (r0 >= r1) goto L66
            r0 = r11
            r1 = r9
            r2 = r13
            r3 = r9
            android.content.ClipData$Item r2 = r2.getItemAt(r3)     // Catch: java.lang.Throwable -> L9f
            android.net.Uri r2 = r2.getUri()     // Catch: java.lang.Throwable -> L9f
            r0[r1] = r2     // Catch: java.lang.Throwable -> L9f
            r0 = r9
            r1 = 1
            int r0 = r0 + r1
            r9 = r0
            goto L36
        L5c:
            r0 = r11
            r10 = r0
            goto L66
        L63:
            r0 = 0
            r10 = r0
        L66:
            r0 = r12
            if (r0 == 0) goto L7d
            r0 = 1
            android.net.Uri[] r0 = new android.net.Uri[r0]     // Catch: java.lang.Throwable -> L95
            r10 = r0
            r0 = r10
            r1 = 0
            r2 = r12
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch: java.lang.Throwable -> L95
            r0[r1] = r2     // Catch: java.lang.Throwable -> L95
            goto L7d
        L7d:
            r0 = r5
            android.webkit.ValueCallback<android.net.Uri[]> r0 = r0.r     // Catch: java.lang.Throwable -> L95
            r1 = r10
            r0.onReceiveValue(r1)     // Catch: java.lang.Throwable -> L95
            r0 = r5
            r1 = 0
            r0.r = r1     // Catch: java.lang.Throwable -> L95
        L8d:
            r0 = r5
            r1 = r6
            r2 = r7
            r3 = r8
            super.onActivityResult(r1, r2, r3)
        L94:
            return
        L95:
            r10 = move-exception
            goto L8d
        L9a:
            r10 = move-exception
            goto L63
        L9f:
            r10 = move-exception
            goto L5c
        La4:
            r0 = 0
            r10 = r0
            goto L7d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.basead.ui.web.WebLandPageActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setResult(-1);
        boolean requestFeature = getWindow().requestFeature(2);
        this.l = requestFeature;
        if (requestFeature) {
            getWindow().setFeatureInt(2, -1);
        }
        Intent intent = getIntent();
        if (intent != null) {
            try {
                Serializable serializableExtra = intent.getSerializableExtra(a.C0092a.f6391c);
                if (serializableExtra != null && (serializableExtra instanceof i)) {
                    i iVar = (i) serializableExtra;
                    this.m = iVar;
                    this.q = new b(iVar);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                Serializable serializableExtra2 = intent.getSerializableExtra(a.C0092a.e);
                if (serializableExtra2 != null && (serializableExtra2 instanceof j)) {
                    this.n = (j) serializableExtra2;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            try {
                Serializable serializableExtra3 = intent.getSerializableExtra(a.C0092a.l);
                if (serializableExtra3 != null && (serializableExtra3 instanceof IOfferClickHandler)) {
                    this.p = (IOfferClickHandler) serializableExtra3;
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            try {
                this.o = intent.getStringExtra(a.C0092a.j);
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
        }
        String str = this.o;
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            i iVar2 = this.m;
            str2 = iVar2 != null ? iVar2.A() : "";
        }
        Context applicationContext = getApplicationContext();
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(applicationContext, h.a(applicationContext, "basead_click_empty", "string"), 0).show();
            finish();
            return;
        }
        am a2 = com.anythink.core.basead.a.a.a(applicationContext, str2);
        if (a2.m) {
            a(a2);
            return;
        }
        a(a2);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(-16777216);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setId(e);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, h.a(this, 55.0f));
        layoutParams.addRule(12);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundDrawable(new ColorDrawable(-592138));
        int a3 = h.a(this, 20.0f);
        linearLayout.setPadding(a3, 0, a3, 0);
        relativeLayout.addView(linearLayout);
        this.h = a(getResources().getDrawable(h.a(this, "browser_unleft_icon", com.anythink.expressad.foundation.h.i.f7952c)));
        this.i = a(getResources().getDrawable(h.a(this, "browser_unright_icon", com.anythink.expressad.foundation.h.i.f7952c)));
        this.j = a(getResources().getDrawable(h.a(this, "browser_refresh_icon", com.anythink.expressad.foundation.h.i.f7952c)));
        this.k = a(getResources().getDrawable(h.a(this, "browser_close_icon", com.anythink.expressad.foundation.h.i.f7952c)));
        linearLayout.addView(this.h);
        linearLayout.addView(this.i);
        linearLayout.addView(this.j);
        linearLayout.addView(this.k);
        this.g = new BaseWebView(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(2, e);
        this.g.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.g);
        View view = new View(this);
        view.setBackgroundColor(-2434342);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, h.a(this, 1.0f));
        layoutParams3.addRule(2, e);
        view.setLayoutParams(layoutParams3);
        relativeLayout.addView(view);
        WebProgressBarView webProgressBarView = new WebProgressBarView(this);
        this.f = webProgressBarView;
        webProgressBarView.setProgress(0);
        relativeLayout.addView(this.f, new RelativeLayout.LayoutParams(-1, h.a(this, 2.0f)));
        setContentView(relativeLayout);
        this.h.setBackgroundColor(0);
        this.h.setOnClickListener(new AnonymousClass2());
        this.i.setBackgroundColor(0);
        this.i.setOnClickListener(new AnonymousClass3());
        this.j.setBackgroundColor(0);
        this.j.setOnClickListener(new AnonymousClass4());
        this.k.setBackgroundColor(0);
        this.k.setOnClickListener(new AnonymousClass5());
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
        WebSettings settings = this.g.getSettings();
        this.g.setHorizontalScrollBarEnabled(false);
        this.g.setVerticalScrollBarEnabled(false);
        this.g.setVerticalScrollBarEnabled(false);
        this.g.requestFocus();
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setAppCacheMaxSize(5242880L);
        settings.setAllowFileAccess(false);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setSavePassword(false);
        settings.setDatabaseEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        if (Build.VERSION.SDK_INT >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Method declaredMethod = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(settings, Boolean.FALSE);
            } catch (Exception e3) {
            }
        }
        settings.setDatabaseEnabled(true);
        String path = getDir(WebParameter.PATH_DATABASE, 0).getPath();
        settings.setDatabasePath(path);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(path);
        this.g.setWebViewClient(new a(this));
        this.g.setDownloadListener(new AnonymousClass1());
        am a4 = com.anythink.core.basead.a.a.a(str2);
        this.f6397a = a4.l;
        Tracker.loadUrl(this.g, a4.o);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        j jVar;
        super.onDestroy();
        WebView webView = this.g;
        if (webView != null) {
            webView.destroy();
        }
        this.g = null;
        if (this.m == null || (jVar = this.n) == null) {
            return;
        }
        c.a(jVar.b, this.n.d, this.m.d(), this.m.p(), this.b, this.f6398c, this.d, this.f6397a, this.o, this.n.j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
        this.g.setWebChromeClient(null);
        WebView webView = this.g;
        if (isFinishing()) {
            webView.stopLoading();
            Tracker.loadUrl(webView, "");
        }
        webView.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
        this.g.setWebChromeClient(new WebChromeClient() { // from class: com.anythink.core.basead.ui.web.WebLandPageActivity.6
            @Override // android.webkit.WebChromeClient
            public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                try {
                    callback.invoke(str, true, false);
                } catch (Throwable th) {
                }
                super.onGeolocationPermissionsShowPrompt(str, callback);
            }

            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView, int i) {
                Tracker.onProgressChanged(this, webView, i);
                if (WebLandPageActivity.this.f != null) {
                    WebLandPageActivity.this.f.setProgress(i);
                    if (i == 100) {
                        n.a().a(new Runnable() { // from class: com.anythink.core.basead.ui.web.WebLandPageActivity.6.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                WebLandPageActivity.this.f.setVisibility(8);
                            }
                        }, 200L);
                    }
                }
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                try {
                    WebLandPageActivity.this.r = valueCallback;
                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                    intent.setType("*/*");
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                    WebLandPageActivity.this.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 512);
                    return true;
                } catch (Throwable th) {
                    return false;
                }
            }
        });
        this.g.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
    }
}
