package com.opos.cmn.biz.web.base.activity.api;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.applog.tracker.Tracker;
import com.opos.cmn.biz.web.b.a.a;
import com.opos.cmn.biz.web.b.a.a.b;
import com.opos.cmn.biz.web.b.a.b;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/web/base/activity/api/BaseWebActivity.class */
public abstract class BaseWebActivity extends Activity implements b {

    /* renamed from: a  reason: collision with root package name */
    private a f11047a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11048c = false;
    private ViewGroup d;

    private void b(Intent intent) {
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("loadUrl");
                this.b = stringExtra;
                if (TextUtils.isEmpty(stringExtra)) {
                    e();
                    return;
                }
                b();
                d();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("AdActivity", "handleAction", e);
                e();
            }
        }
    }

    private void d() {
        try {
            com.opos.cmn.an.f.a.b("AdActivity", "showWebView url:" + this.b);
            if (com.opos.cmn.an.c.a.a(this.b)) {
                return;
            }
            this.d = (ViewGroup) getWindow().getDecorView().findViewById(R.id.content);
            if (this.f11047a.b() != null && this.f11047a.b().getParent() == null) {
                this.d.addView(this.f11047a.b(), new RelativeLayout.LayoutParams(-1, -1));
            }
            this.f11047a.a(this.b);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("AdActivity", "showWebView", e);
        }
    }

    private void e() {
        finish();
    }

    protected abstract Map<String, Object> a();

    public void a(Intent intent) {
        com.opos.cmn.an.f.a.b("AdActivity", "reInitWebView");
        a aVar = this.f11047a;
        if (aVar != null) {
            aVar.e();
            b(intent);
        }
    }

    public void b() {
        if (this.f11048c) {
            return;
        }
        try {
            com.opos.cmn.biz.web.base.activity.a.a.a.a(this);
            com.opos.cmn.biz.web.base.activity.a.a.a.b(this);
            this.f11047a = new a(this, new b.a().a(this).a(a()).a(true).a());
            this.f11048c = true;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("AdActivity", "initWebView", e);
        }
    }

    @Override // com.opos.cmn.biz.web.b.a.a.b
    public void c() {
        com.opos.cmn.an.f.a.b("AdActivity", "onWebViewClose");
        e();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.opos.cmn.an.f.a.b("AdActivity", "onCreate");
        b(getIntent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        com.opos.cmn.an.f.a.b("AdActivity", "onDestroy");
        com.opos.cmn.an.f.a.b("AdActivity", "closeWebWidget");
        a aVar = this.f11047a;
        if (aVar != null && aVar.b() != null) {
            this.d.removeView(this.f11047a.b());
        }
        a aVar2 = this.f11047a;
        if (aVar2 != null) {
            aVar2.a();
        }
        this.f11047a = null;
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        a aVar;
        com.opos.cmn.an.f.a.b("AdActivity", "onKeyDown");
        if (i == 4 && keyEvent.getAction() == 0 && (aVar = this.f11047a) != null) {
            if (!aVar.c() && this.f11047a.d()) {
                return true;
            }
            c();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
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
        com.opos.cmn.an.f.a.b("AdActivity", "onResume");
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
