package com.android.org.conscrypt;

import javax.net.ssl.SSLSession;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/SSLServerSessionCache.class */
public interface SSLServerSessionCache {
    byte[] getSessionData(byte[] bArr);

    void putSessionData(SSLSession sSLSession, byte[] bArr);
}
