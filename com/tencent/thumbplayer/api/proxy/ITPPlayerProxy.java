package com.tencent.thumbplayer.api.proxy;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/proxy/ITPPlayerProxy.class */
public interface ITPPlayerProxy {
    void pushEvent(int i);

    void setIsActive(boolean z);

    void setProxyServiceType(int i);

    void setTPPlayerProxyListener(ITPPlayerProxyListener iTPPlayerProxyListener);
}
