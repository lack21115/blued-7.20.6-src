package com.alipay.sdk.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.n;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/H5PayActivity.class */
public class H5PayActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private com.alipay.sdk.widget.g f4575a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f4576c;
    private String d;
    private String e;
    private boolean f;
    private String g;

    private void b() {
        try {
            super.requestWindowFeature(1);
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }

    public void a() {
        Object obj = PayTask.f4584a;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception e) {
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void finish() {
        a();
        super.finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.alipay.sdk.widget.g gVar = this.f4575a;
        if (gVar instanceof com.alipay.sdk.widget.h) {
            gVar.b();
            return;
        }
        if (!gVar.b()) {
            super.onBackPressed();
        }
        j.a(j.c());
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        b();
        super.onCreate(bundle);
        try {
            com.alipay.sdk.sys.a a2 = a.C0050a.a(getIntent());
            if (a2 == null) {
                finish();
                return;
            }
            if (com.alipay.sdk.data.a.j().b()) {
                setRequestedOrientation(3);
            } else {
                setRequestedOrientation(1);
            }
            try {
                Bundle extras = getIntent().getExtras();
                String string = extras.getString("url", null);
                this.b = string;
                if (!n.d(string)) {
                    finish();
                    return;
                }
                this.d = extras.getString("cookie", null);
                this.f4576c = extras.getString("method", null);
                this.e = extras.getString("title", null);
                this.g = extras.getString("version", com.huawei.hms.ads.dynamicloader.b.f);
                this.f = extras.getBoolean("backisexit", false);
                try {
                    if (com.huawei.hms.ads.dynamicloader.b.g.equals(this.g)) {
                        com.alipay.sdk.widget.j jVar = new com.alipay.sdk.widget.j(this, a2);
                        setContentView(jVar);
                        jVar.a(this.e, this.f4576c, this.f);
                        jVar.a(this.b);
                        this.f4575a = jVar;
                        return;
                    }
                    com.alipay.sdk.widget.h hVar = new com.alipay.sdk.widget.h(this, a2);
                    this.f4575a = hVar;
                    setContentView(hVar);
                    this.f4575a.a(this.b, this.d);
                    this.f4575a.a(this.b);
                } catch (Throwable th) {
                    com.alipay.sdk.app.statistic.a.a(a2, com.alipay.sdk.app.statistic.c.b, "GetInstalledAppEx", th);
                    finish();
                }
            } catch (Exception e) {
                finish();
            }
        } catch (Exception e2) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.alipay.sdk.widget.g gVar = this.f4575a;
        if (gVar != null) {
            gVar.a();
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        try {
            super.setRequestedOrientation(i);
        } catch (Throwable th) {
            try {
                com.alipay.sdk.app.statistic.a.a(a.C0050a.a(getIntent()), com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.u, th);
            } catch (Throwable th2) {
            }
        }
    }
}
