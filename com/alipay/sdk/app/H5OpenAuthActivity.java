package com.alipay.sdk.app;

import android.content.Intent;
import android.net.Uri;
import com.alipay.sdk.sys.a;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/H5OpenAuthActivity.class */
public class H5OpenAuthActivity extends H5PayActivity {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4574a = false;

    @Override // com.alipay.sdk.app.H5PayActivity
    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.sdk.app.H5PayActivity, android.app.Activity
    public void onDestroy() {
        if (this.f4574a) {
            try {
                com.alipay.sdk.sys.a a2 = a.C0050a.a(getIntent());
                if (a2 != null) {
                    com.alipay.sdk.app.statistic.a.b(this, a2, "", a2.p);
                }
            } catch (Throwable th) {
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        try {
            com.alipay.sdk.sys.a a2 = a.C0050a.a(intent);
            if (a2 == null) {
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
                com.alipay.sdk.app.statistic.a.a(a2, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.ai, th, (intent == null || intent.getData() == null) ? com.igexin.push.core.b.l : intent.getData().toString());
                this.f4574a = true;
                throw th;
            }
        } catch (Throwable th2) {
            finish();
        }
    }
}
