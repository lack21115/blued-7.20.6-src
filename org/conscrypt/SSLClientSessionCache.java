package org.conscrypt;

import javax.net.ssl.SSLSession;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/SSLClientSessionCache.class */
public interface SSLClientSessionCache {
    byte[] getSessionData(String str, int i);

    void putSessionData(SSLSession sSLSession, byte[] bArr);
}
