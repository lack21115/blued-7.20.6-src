package com.huawei.hms.ads.dynamicloader;

import android.os.Bundle;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamicloader/j.class */
public final class j extends Exception {

    /* renamed from: a  reason: collision with root package name */
    Bundle f22475a;

    public j(String str) {
        super(str);
    }

    public j(String str, Bundle bundle) {
        super(str);
        this.f22475a = bundle;
    }

    private Bundle a() {
        return this.f22475a;
    }
}
