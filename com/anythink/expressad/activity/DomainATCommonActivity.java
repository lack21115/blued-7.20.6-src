package com.anythink.expressad.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.Toast;
import com.anythink.expressad.foundation.b.a;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.s;
import com.anythink.expressad.foundation.webview.BrowserView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/activity/DomainATCommonActivity.class */
public class DomainATCommonActivity extends Activity {
    private static final String b = "ATCommonActivity";

    /* renamed from: c  reason: collision with root package name */
    private c f6987c;
    private BrowserView d;

    /* renamed from: a  reason: collision with root package name */
    String f6986a = "";
    private BrowserView.a e = new BrowserView.a() { // from class: com.anythink.expressad.activity.DomainATCommonActivity.1
        @Override // com.anythink.expressad.foundation.webview.BrowserView.a
        public final void a() {
            DomainATCommonActivity.this.finish();
        }

        @Override // com.anythink.expressad.foundation.webview.BrowserView.a
        public final boolean a(WebView webView, String str) {
            o.d(DomainATCommonActivity.b, "shouldOverrideUrlLoading  ".concat(String.valueOf(str)));
            if (s.a.a(str) && s.a.a(DomainATCommonActivity.this, str, null)) {
                DomainATCommonActivity.this.finish();
            }
            return DomainATCommonActivity.this.a(webView, str);
        }

        @Override // com.anythink.expressad.foundation.webview.BrowserView.a
        public final void b() {
        }
    };

    private void a() {
        String stringExtra = getIntent().getStringExtra("url");
        this.f6986a = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            Toast.makeText(this, "Error: no data", 0).show();
            return;
        }
        this.f6987c = (c) getIntent().getSerializableExtra("mvcommon");
        BrowserView browserView = new BrowserView(this, this.f6987c);
        this.d = browserView;
        browserView.setListener(this.e);
        this.d.loadUrl(this.f6986a);
        BrowserView browserView2 = this.d;
        if (browserView2 != null) {
            setContentView(browserView2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b1 A[Catch: all -> 0x00e3, TRY_LEAVE, TryCatch #2 {all -> 0x00ef, blocks: (B:2:0x0000, B:6:0x0009, B:9:0x0023, B:12:0x0033, B:14:0x0040, B:29:0x00a2, B:31:0x00b1, B:33:0x00b9, B:35:0x00c5, B:41:0x00db, B:16:0x0049, B:18:0x0056, B:20:0x0062, B:22:0x0079, B:24:0x0081), top: B:57:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.webkit.WebView r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.activity.DomainATCommonActivity.a(android.webkit.WebView, java.lang.String):boolean");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
        } catch (Throwable th) {
            o.d(b, th.getMessage());
        }
        if (a.b().d() == null) {
            a.b().a(getApplicationContext());
        }
        String stringExtra = getIntent().getStringExtra("url");
        this.f6986a = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            Toast.makeText(this, "Error: no data", 0).show();
            return;
        }
        this.f6987c = (c) getIntent().getSerializableExtra("mvcommon");
        BrowserView browserView = new BrowserView(this, this.f6987c);
        this.d = browserView;
        browserView.setListener(this.e);
        this.d.loadUrl(this.f6986a);
        BrowserView browserView2 = this.d;
        if (browserView2 != null) {
            setContentView(browserView2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BrowserView browserView = this.d;
        if (browserView != null) {
            browserView.destroy();
        }
    }
}
