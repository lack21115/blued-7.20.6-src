package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dv.class */
public class dv implements ee {
    private static final String I = "BaseDeviceImpl";
    protected Context Code;
    protected com.huawei.openalliance.ad.utils.am V;

    /* JADX INFO: Access modifiers changed from: protected */
    public dv(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.Code = applicationContext;
        this.V = com.huawei.openalliance.ad.utils.am.Code(applicationContext);
    }

    @Override // com.huawei.hms.ads.ee
    public boolean B() {
        return false;
    }

    @Override // com.huawei.hms.ads.ee
    public String C() {
        return null;
    }

    @Override // com.huawei.hms.ads.ee
    public int Code(View view) {
        return 0;
    }

    @Override // com.huawei.hms.ads.ee
    public boolean Code() {
        return true;
    }

    @Override // com.huawei.hms.ads.ee
    public boolean Code(Context context) {
        return false;
    }

    @Override // com.huawei.hms.ads.ee
    public boolean Code(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable th) {
            ge.I(I, "check widget available error");
            return false;
        }
    }

    @Override // com.huawei.hms.ads.ee
    public boolean I() {
        return true;
    }

    @Override // com.huawei.hms.ads.ee
    public boolean S() {
        return false;
    }

    @Override // com.huawei.hms.ads.ee
    public boolean V() {
        return true;
    }

    @Override // com.huawei.hms.ads.ee
    public String Z() {
        return null;
    }
}
