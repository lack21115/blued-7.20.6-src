package com.alipay.sdk.app;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/H5AuthActivity.class */
public class H5AuthActivity extends H5PayActivity {
    @Override // com.alipay.sdk.app.H5PayActivity
    public void a() {
        Object obj = AuthTask.a;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception e) {
            }
        }
    }
}
