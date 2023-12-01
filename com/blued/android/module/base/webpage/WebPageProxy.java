package com.blued.android.module.base.webpage;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/webpage/WebPageProxy.class */
public class WebPageProxy implements IWebPage {

    /* renamed from: a  reason: collision with root package name */
    private static WebPageProxy f10434a = new WebPageProxy();
    private IWebPage b = null;

    private WebPageProxy() {
    }

    public static WebPageProxy a() {
        return f10434a;
    }

    public void a(IWebPage iWebPage) {
        this.b = iWebPage;
    }
}
