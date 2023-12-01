package com.alipay.sdk.widget;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.FrameLayout;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/g.class */
public abstract class g extends FrameLayout {
    protected Activity a;

    public g(Activity activity) {
        super(activity);
        this.a = activity;
    }

    public abstract void a();

    public abstract void a(String str);

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        CookieSyncManager.createInstance(this.a.getApplicationContext()).sync();
        CookieManager.getInstance().setCookie(str, str2);
        CookieSyncManager.getInstance().sync();
    }

    public abstract boolean b();
}
