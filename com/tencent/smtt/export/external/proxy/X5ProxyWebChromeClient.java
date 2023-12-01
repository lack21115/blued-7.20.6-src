package com.tencent.smtt.export.external.proxy;

import com.tencent.smtt.export.external.WebViewWizardBase;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/proxy/X5ProxyWebChromeClient.class */
public abstract class X5ProxyWebChromeClient extends ProxyWebChromeClient {
    public X5ProxyWebChromeClient(WebViewWizardBase webViewWizardBase) {
        this.mWebChromeClient = (IX5WebChromeClient) webViewWizardBase.newInstance("com.tencent.smtt.webkit.WebChromeClient");
    }

    public X5ProxyWebChromeClient(IX5WebChromeClient iX5WebChromeClient) {
        setWebChromeClient(iX5WebChromeClient);
    }
}
