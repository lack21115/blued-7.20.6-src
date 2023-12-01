package com.alipay.sdk.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.n;
import com.bytedance.applog.tracker.Tracker;
import javax.xml.transform.OutputKeys;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/H5PayActivity.class */
public class H5PayActivity extends Activity {
    private com.alipay.sdk.widget.g a;
    private String b;
    private String c;
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
        Object obj = PayTask.a;
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
        com.alipay.sdk.widget.g gVar = this.a;
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

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        b();
        super.onCreate(bundle);
        try {
            com.alipay.sdk.sys.a a = a.C0010a.a(getIntent());
            if (a == null) {
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
                this.c = extras.getString("method", null);
                this.e = extras.getString("title", null);
                this.g = extras.getString(OutputKeys.VERSION, "v1");
                this.f = extras.getBoolean("backisexit", false);
                try {
                    if ("v2".equals(this.g)) {
                        com.alipay.sdk.widget.j jVar = new com.alipay.sdk.widget.j(this, a);
                        setContentView(jVar);
                        jVar.a(this.e, this.c, this.f);
                        jVar.a(this.b);
                        this.a = jVar;
                        return;
                    }
                    com.alipay.sdk.widget.h hVar = new com.alipay.sdk.widget.h(this, a);
                    this.a = hVar;
                    setContentView(hVar);
                    this.a.a(this.b, this.d);
                    this.a.a(this.b);
                } catch (Throwable th) {
                    com.alipay.sdk.app.statistic.a.a(a, com.alipay.sdk.app.statistic.c.b, "GetInstalledAppEx", th);
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
        com.alipay.sdk.widget.g gVar = this.a;
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
                com.alipay.sdk.app.statistic.a.a(a.C0010a.a(getIntent()), com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.u, th);
            } catch (Throwable th2) {
            }
        }
    }
}
