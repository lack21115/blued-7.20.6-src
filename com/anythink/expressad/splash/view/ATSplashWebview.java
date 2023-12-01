package com.anythink.expressad.splash.view;

import android.content.Context;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/view/ATSplashWebview.class */
public class ATSplashWebview extends WindVaneWebView {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5433a = ATSplashWebview.class.getSimpleName();
    private String b;

    public ATSplashWebview(Context context) {
        super(context);
        setBackgroundColor(0);
    }

    public String getRequestId() {
        return this.b;
    }

    public void setRequestId(String str) {
        this.b = str;
    }
}
