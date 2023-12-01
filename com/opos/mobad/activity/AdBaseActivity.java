package com.opos.mobad.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.bytedance.applog.tracker.Tracker;
import com.opos.mobad.activity.webview.WebDataHepler;
import com.opos.mobad.activity.webview.b;
import com.opos.mobad.activity.webview.b.e;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.cmn.a.d;
import com.opos.mobad.cmn.b.f;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/activity/AdBaseActivity.class */
public abstract class AdBaseActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private b f25622a;
    private f b;

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        finish();
    }

    private void a(WebDataHepler webDataHepler) {
        f fVar = new f(webDataHepler.f());
        this.b = fVar;
        fVar.a(this, webDataHepler.g(), webDataHepler.h());
    }

    private void a(d dVar, WebDataHepler webDataHepler) {
        try {
            if (TextUtils.isEmpty(webDataHepler.d())) {
                com.opos.cmn.an.f.a.b("AdActivity", "data is null " + webDataHepler);
                a();
                return;
            }
            if (this.f25622a != null) {
                this.f25622a.d();
            }
            e.a aVar = null;
            if (webDataHepler.f() != null) {
                aVar = new e.a(webDataHepler.f());
            }
            b bVar = new b(this, webDataHepler);
            this.f25622a = bVar;
            bVar.a();
            this.f25622a.a(aVar);
            this.f25622a.a(new b.a() { // from class: com.opos.mobad.activity.AdBaseActivity.1
                @Override // com.opos.mobad.activity.webview.b.a
                public void a() {
                    AdBaseActivity.this.a();
                }
            });
            setContentView(this.f25622a.c());
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdActivity", "initWebView", (Throwable) e);
        }
    }

    private void b(Intent intent) {
        d b = com.opos.mobad.cmn.service.a.a().b();
        if (b == null) {
            a();
            com.opos.cmn.an.f.a.b("AdActivity", "handle but not init");
        } else if (intent != null) {
            try {
                WebDataHepler webDataHepler = (WebDataHepler) intent.getParcelableExtra("webData");
                if (webDataHepler == null) {
                    com.opos.cmn.an.f.a.b("AdActivity", "data is null " + webDataHepler);
                    a();
                    return;
                }
                int g = webDataHepler.g();
                if (g == 1 || g == 2) {
                    g.a((Activity) this, "#F5EEEEEE");
                    a(b, webDataHepler);
                } else if (g == 3 || g == 4) {
                    a(webDataHepler);
                } else {
                    a();
                }
                com.opos.cmn.an.f.a.a("AdActivity", webDataHepler);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("AdActivity", "handleAction", (Throwable) e);
                a();
            }
        }
    }

    public void a(Intent intent) {
        com.opos.cmn.an.f.a.b("AdActivity", "reInitWebView");
        b bVar = this.f25622a;
        if (bVar != null) {
            bVar.d();
        }
        b(intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.opos.cmn.an.f.a.b("AdActivity", "onConfigurationChanged newConfig=" + configuration.toString());
        b bVar = this.f25622a;
        if (bVar != null) {
            bVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        g.a(this);
        com.opos.cmn.i.g.a((Activity) this);
        super.onCreate(bundle);
        com.opos.cmn.an.f.a.b("AdActivity", "onCreate");
        b(getIntent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        com.opos.cmn.an.f.a.b("AdActivity", "onDestroy");
        b bVar = this.f25622a;
        if (bVar != null) {
            bVar.d();
        }
        f fVar = this.b;
        if (fVar != null) {
            fVar.a();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.opos.cmn.an.f.a.b("AdActivity", "onKeyDown");
        b bVar = this.f25622a;
        if (bVar == null || !bVar.a(i, keyEvent)) {
            f fVar = this.b;
            if (fVar == null || !fVar.a(i, keyEvent)) {
                return super.onKeyDown(i, keyEvent);
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.opos.cmn.an.f.a.b("AdActivity", "onNewIntent");
        setIntent(intent);
        a(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.opos.cmn.an.f.a.b("AdActivity", "onPause");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        com.opos.cmn.an.f.a.b("AdActivity", "onStart");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        com.opos.cmn.an.f.a.b("AdActivity", "onStop");
    }
}
