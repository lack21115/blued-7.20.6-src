package org.conscrypt;

import javax.net.ssl.SSLSession;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/SSLServerSessionCache.class */
interface SSLServerSessionCache {
    byte[] getSessionData(byte[] bArr);

    void putSessionData(SSLSession sSLSession, byte[] bArr);
}
