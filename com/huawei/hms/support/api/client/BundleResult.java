package com.huawei.hms.support.api.client;

import android.os.Bundle;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/support/api/client/BundleResult.class */
public class BundleResult {

    /* renamed from: a  reason: collision with root package name */
    private int f22881a;
    private Bundle b;

    public BundleResult(int i, Bundle bundle) {
        this.f22881a = i;
        this.b = bundle;
    }

    public int getResultCode() {
        return this.f22881a;
    }

    public Bundle getRspBody() {
        return this.b;
    }

    public void setResultCode(int i) {
        this.f22881a = i;
    }

    public void setRspBody(Bundle bundle) {
        this.b = bundle;
    }
}
