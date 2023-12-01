package com.android.org.conscrypt;

import javax.net.ssl.SSLSession;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/ServerSessionContext.class */
public class ServerSessionContext extends AbstractSessionContext {
    private SSLServerSessionCache persistentCache;

    public ServerSessionContext() {
        super(100);
        NativeCrypto.SSL_CTX_set_session_id_context(this.sslCtxNativePointer, new byte[]{32});
    }

    @Override // com.android.org.conscrypt.AbstractSessionContext, javax.net.ssl.SSLSessionContext
    public SSLSession getSession(byte[] bArr) {
        SSLSession session = super.getSession(bArr);
        if (session == null) {
            session = null;
            if (this.persistentCache != null) {
                byte[] sessionData = this.persistentCache.getSessionData(bArr);
                session = null;
                if (sessionData != null) {
                    SSLSession session2 = toSession(sessionData, null, -1);
                    session = null;
                    if (session2 != null) {
                        session = null;
                        if (session2.isValid()) {
                            super.putSession(session2);
                            return session2;
                        }
                    }
                }
            }
        }
        return session;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.org.conscrypt.AbstractSessionContext
    public void putSession(SSLSession sSLSession) {
        byte[] bytes;
        super.putSession(sSLSession);
        if (this.persistentCache == null || (bytes = toBytes(sSLSession)) == null) {
            return;
        }
        this.persistentCache.putSessionData(sSLSession, bytes);
    }

    @Override // com.android.org.conscrypt.AbstractSessionContext
    protected void sessionRemoved(SSLSession sSLSession) {
    }

    public void setPersistentCache(SSLServerSessionCache sSLServerSessionCache) {
        this.persistentCache = sSLServerSessionCache;
    }

    @Override // com.android.org.conscrypt.AbstractSessionContext, javax.net.ssl.SSLSessionContext
    public /* bridge */ /* synthetic */ void setSessionTimeout(int i) throws IllegalArgumentException {
        super.setSessionTimeout(i);
    }
}
