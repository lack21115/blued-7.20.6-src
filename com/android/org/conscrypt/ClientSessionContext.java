package com.android.org.conscrypt;

import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLSession;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/ClientSessionContext.class */
public class ClientSessionContext extends AbstractSessionContext {
    private SSLClientSessionCache persistentCache;
    final Map<HostAndPort, SSLSession> sessionsByHostAndPort;

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/ClientSessionContext$HostAndPort.class */
    static class HostAndPort {
        final String host;
        final int port;

        HostAndPort(String str, int i) {
            this.host = str;
            this.port = i;
        }

        public boolean equals(Object obj) {
            if (obj instanceof HostAndPort) {
                HostAndPort hostAndPort = (HostAndPort) obj;
                return this.host.equals(hostAndPort.host) && this.port == hostAndPort.port;
            }
            return false;
        }

        public int hashCode() {
            return (this.host.hashCode() * 31) + this.port;
        }
    }

    public ClientSessionContext() {
        super(10);
        this.sessionsByHostAndPort = new HashMap();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
        if (r0.isValid() == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public javax.net.ssl.SSLSession getSession(java.lang.String r6, int r7) {
        /*
            r5 = this;
            r0 = r6
            if (r0 != 0) goto L8
            r0 = 0
            r8 = r0
        L6:
            r0 = r8
            return r0
        L8:
            com.android.org.conscrypt.ClientSessionContext$HostAndPort r0 = new com.android.org.conscrypt.ClientSessionContext$HostAndPort
            r1 = r0
            r2 = r6
            r3 = r7
            r1.<init>(r2, r3)
            r10 = r0
            r0 = r5
            java.util.Map<com.android.org.conscrypt.ClientSessionContext$HostAndPort, javax.net.ssl.SSLSession> r0 = r0.sessionsByHostAndPort
            r8 = r0
            r0 = r8
            monitor-enter(r0)
            r0 = r5
            java.util.Map<com.android.org.conscrypt.ClientSessionContext$HostAndPort, javax.net.ssl.SSLSession> r0 = r0.sessionsByHostAndPort     // Catch: java.lang.Throwable -> L8c
            r1 = r10
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L8c
            javax.net.ssl.SSLSession r0 = (javax.net.ssl.SSLSession) r0     // Catch: java.lang.Throwable -> L8c
            r9 = r0
            r0 = r8
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8c
            r0 = r9
            if (r0 == 0) goto L3e
            r0 = r9
            r8 = r0
            r0 = r9
            boolean r0 = r0.isValid()
            if (r0 != 0) goto L6
        L3e:
            r0 = r5
            com.android.org.conscrypt.SSLClientSessionCache r0 = r0.persistentCache
            if (r0 == 0) goto L91
            r0 = r5
            com.android.org.conscrypt.SSLClientSessionCache r0 = r0.persistentCache
            r1 = r6
            r2 = r7
            byte[] r0 = r0.getSessionData(r1, r2)
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L91
            r0 = r5
            r1 = r8
            r2 = r6
            r3 = r7
            javax.net.ssl.SSLSession r0 = r0.toSession(r1, r2, r3)
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L91
            r0 = r8
            boolean r0 = r0.isValid()
            if (r0 == 0) goto L91
            r0 = r5
            r1 = r8
            super.putSession(r1)
            r0 = r5
            java.util.Map<com.android.org.conscrypt.ClientSessionContext$HostAndPort, javax.net.ssl.SSLSession> r0 = r0.sessionsByHostAndPort
            r6 = r0
            r0 = r6
            monitor-enter(r0)
            r0 = r5
            java.util.Map<com.android.org.conscrypt.ClientSessionContext$HostAndPort, javax.net.ssl.SSLSession> r0 = r0.sessionsByHostAndPort     // Catch: java.lang.Throwable -> L87
            r1 = r10
            r2 = r8
            java.lang.Object r0 = r0.put(r1, r2)     // Catch: java.lang.Throwable -> L87
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L87
            r0 = r8
            return r0
        L87:
            r8 = move-exception
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L87
            r0 = r8
            throw r0
        L8c:
            r6 = move-exception
            r0 = r8
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8c
            r0 = r6
            throw r0
        L91:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.org.conscrypt.ClientSessionContext.getSession(java.lang.String, int):javax.net.ssl.SSLSession");
    }

    @Override // com.android.org.conscrypt.AbstractSessionContext, javax.net.ssl.SSLSessionContext
    public /* bridge */ /* synthetic */ SSLSession getSession(byte[] bArr) {
        return super.getSession(bArr);
    }

    @Override // com.android.org.conscrypt.AbstractSessionContext
    public void putSession(SSLSession sSLSession) {
        byte[] bytes;
        super.putSession(sSLSession);
        String peerHost = sSLSession.getPeerHost();
        int peerPort = sSLSession.getPeerPort();
        if (peerHost == null) {
            return;
        }
        HostAndPort hostAndPort = new HostAndPort(peerHost, peerPort);
        synchronized (this.sessionsByHostAndPort) {
            this.sessionsByHostAndPort.put(hostAndPort, sSLSession);
        }
        if (this.persistentCache == null || (bytes = toBytes(sSLSession)) == null) {
            return;
        }
        this.persistentCache.putSessionData(sSLSession, bytes);
    }

    @Override // com.android.org.conscrypt.AbstractSessionContext
    protected void sessionRemoved(SSLSession sSLSession) {
        String peerHost = sSLSession.getPeerHost();
        int peerPort = sSLSession.getPeerPort();
        if (peerHost == null) {
            return;
        }
        HostAndPort hostAndPort = new HostAndPort(peerHost, peerPort);
        synchronized (this.sessionsByHostAndPort) {
            this.sessionsByHostAndPort.remove(hostAndPort);
        }
    }

    public void setPersistentCache(SSLClientSessionCache sSLClientSessionCache) {
        this.persistentCache = sSLClientSessionCache;
    }

    @Override // com.android.org.conscrypt.AbstractSessionContext, javax.net.ssl.SSLSessionContext
    public /* bridge */ /* synthetic */ void setSessionTimeout(int i) throws IllegalArgumentException {
        super.setSessionTimeout(i);
    }

    public int size() {
        return this.sessionsByHostAndPort.size();
    }
}
