package com.sina.weibo.sdk.component;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/BrowserLauncher.class */
public enum BrowserLauncher {
    AUTH,
    SHARE,
    WIDGET,
    COMMON,
    GAME;

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static BrowserLauncher[] valuesCustom() {
        BrowserLauncher[] valuesCustom = values();
        int length = valuesCustom.length;
        BrowserLauncher[] browserLauncherArr = new BrowserLauncher[length];
        System.arraycopy(valuesCustom, 0, browserLauncherArr, 0, length);
        return browserLauncherArr;
    }
}
