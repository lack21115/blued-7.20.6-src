package com.tencent.map.tools.net.http;

import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/tools/net/http/HttpProxy.class */
public class HttpProxy {
    private final boolean mIsForward;
    private final Proxy mProxy;
    private final String mProxyUrl;

    public HttpProxy(Proxy proxy, String str, boolean z) {
        this.mProxy = proxy;
        this.mProxyUrl = str;
        this.mIsForward = z;
    }

    public static Proxy getForwardProxy(HttpProxy httpProxy) {
        return (httpProxy == null || !httpProxy.isForward()) ? Proxy.NO_PROXY : httpProxy.getProxy();
    }

    public static URL getProxyURL(HttpProxy httpProxy) throws MalformedURLException {
        if (httpProxy == null || httpProxy.isForward()) {
            return null;
        }
        return new URL(httpProxy.getProxyUrl());
    }

    public Proxy getProxy() {
        return this.mProxy;
    }

    public String getProxyUrl() {
        return this.mProxyUrl;
    }

    public boolean isForward() {
        return this.mIsForward;
    }

    public String toString() {
        return "HttpProxy{mProxy=" + this.mProxy + ", mProxyUrl='" + this.mProxyUrl + "', mIsForward=" + this.mIsForward + '}';
    }
}
