package com.android.org.conscrypt;

import javax.net.ssl.SSLSession;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/SSLClientSessionCache.class */
public interface SSLClientSessionCache {
    byte[] getSessionData(String str, int i);

    void putSessionData(SSLSession sSLSession, byte[] bArr);
}
