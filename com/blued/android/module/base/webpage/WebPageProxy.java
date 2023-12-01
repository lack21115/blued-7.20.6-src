package com.blued.android.module.base.webpage;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/webpage/WebPageProxy.class */
public class WebPageProxy implements IWebPage {
    private static WebPageProxy a = new WebPageProxy();
    private IWebPage b = null;

    private WebPageProxy() {
    }

    public static WebPageProxy a() {
        return a;
    }

    public void a(IWebPage iWebPage) {
        this.b = iWebPage;
    }
}
