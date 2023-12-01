package com.alipay.sdk.app;

import android.content.Intent;
import android.net.Uri;
import com.alipay.sdk.sys.a;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/H5OpenAuthActivity.class */
public class H5OpenAuthActivity extends H5PayActivity {
    private boolean a = false;

    @Override // com.alipay.sdk.app.H5PayActivity
    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.sdk.app.H5PayActivity, android.app.Activity
    public void onDestroy() {
        if (this.a) {
            try {
                com.alipay.sdk.sys.a a = a.C0010a.a(getIntent());
                if (a != null) {
                    com.alipay.sdk.app.statistic.a.b(this, a, "", a.p);
                }
            } catch (Throwable th) {
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        try {
            com.alipay.sdk.sys.a a = a.C0010a.a(intent);
            if (a == null) {
                finish();
                return;
            }
            try {
                super.startActivity(intent);
                Uri data = intent != null ? intent.getData() : null;
                if (data == null || !data.toString().startsWith("alipays://platformapi/startapp")) {
                    return;
                }
                finish();
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(a, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.ai, th, (intent == null || intent.getData() == null) ? "null" : intent.getData().toString());
                this.a = true;
                throw th;
            }
        } catch (Throwable th2) {
            finish();
        }
    }
}
