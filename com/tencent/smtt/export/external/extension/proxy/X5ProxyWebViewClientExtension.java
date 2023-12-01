package com.tencent.smtt.export.external.extension.proxy;

import com.tencent.smtt.export.external.WebViewWizardBase;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/extension/proxy/X5ProxyWebViewClientExtension.class */
public abstract class X5ProxyWebViewClientExtension extends ProxyWebViewClientExtension {
    public X5ProxyWebViewClientExtension(WebViewWizardBase webViewWizardBase) {
        this.mWebViewClientExt = (IX5WebViewClientExtension) webViewWizardBase.newInstance("com.tencent.smtt.webkit.WebViewClientExtension");
    }

    public X5ProxyWebViewClientExtension(IX5WebViewClientExtension iX5WebViewClientExtension) {
        this.mWebViewClientExt = iX5WebViewClientExtension;
    }
}
