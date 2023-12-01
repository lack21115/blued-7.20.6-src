package org.conscrypt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/ClientSessionContext.class */
public final class ClientSessionContext extends AbstractSessionContext {
    private SSLClientSessionCache persistentCache;
    private final Map<HostAndPort, List<NativeSslSession>> sessionsByHostAndPort;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/ClientSessionContext$HostAndPort.class */
    public static final class HostAndPort {
        final String host;
        final int port;

        HostAndPort(String str, int i) {
            this.host = str;
            this.port = i;
        }

        public boolean equals(Object obj) {
            if (obj instanceof HostAndPort) {
                HostAndPort hostAndPort = (HostAndPort) obj;
                boolean z = false;
                if (this.host.equals(hostAndPort.host)) {
                    z = false;
                    if (this.port == hostAndPort.port) {
                        z = true;
                    }
                }
                return z;
            }
            return false;
        }

        public int hashCode() {
            return (this.host.hashCode() * 31) + this.port;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClientSessionContext() {
        super(10);
        this.sessionsByHostAndPort = new HashMap();
    }

    private NativeSslSession getSession(String str, int i) {
        NativeSslSession nativeSslSession;
        byte[] sessionData;
        NativeSslSession newInstance;
        if (str == null) {
            return null;
        }
        HostAndPort hostAndPort = new HostAndPort(str, i);
        synchronized (this.sessionsByHostAndPort) {
            List<NativeSslSession> list = this.sessionsByHostAndPort.get(hostAndPort);
            nativeSslSession = (list == null || list.size() <= 0) ? null : list.get(0);
        }
        if (nativeSslSession == null || !nativeSslSession.isValid()) {
            SSLClientSessionCache sSLClientSessionCache = this.persistentCache;
            if (sSLClientSessionCache == null || (sessionData = sSLClientSessionCache.getSessionData(str, i)) == null || (newInstance = NativeSslSession.newInstance(this, sessionData, str, i)) == null || !newInstance.isValid()) {
                return null;
            }
            putSession(hostAndPort, newInstance);
            return newInstance;
        }
        return nativeSslSession;
    }

    private void putSession(HostAndPort hostAndPort, NativeSslSession nativeSslSession) {
        synchronized (this.sessionsByHostAndPort) {
            List<NativeSslSession> list = this.sessionsByHostAndPort.get(hostAndPort);
            ArrayList arrayList = list;
            if (list == null) {
                arrayList = new ArrayList();
                this.sessionsByHostAndPort.put(hostAndPort, arrayList);
            }
            if (arrayList.size() > 0 && arrayList.get(0).isSingleUse() != nativeSslSession.isSingleUse()) {
                while (!arrayList.isEmpty()) {
                    removeSession(arrayList.get(0));
                }
                this.sessionsByHostAndPort.put(hostAndPort, arrayList);
            }
            arrayList.add(nativeSslSession);
        }
    }

    private void removeSession(HostAndPort hostAndPort, NativeSslSession nativeSslSession) {
        synchronized (this.sessionsByHostAndPort) {
            List<NativeSslSession> list = this.sessionsByHostAndPort.get(hostAndPort);
            if (list != null) {
                list.remove(nativeSslSession);
                if (list.isEmpty()) {
                    this.sessionsByHostAndPort.remove(hostAndPort);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeSslSession getCachedSession(String str, int i, SSLParametersImpl sSLParametersImpl) {
        boolean z;
        boolean z2;
        synchronized (this) {
            if (str == null) {
                return null;
            }
            NativeSslSession session = getSession(str, i);
            if (session == null) {
                return null;
            }
            String protocol = session.getProtocol();
            String[] strArr = sSLParametersImpl.enabledProtocols;
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    z = false;
                    break;
                } else if (protocol.equals(strArr[i3])) {
                    z = true;
                    break;
                } else {
                    i2 = i3 + 1;
                }
            }
            if (z) {
                String cipherSuite = session.getCipherSuite();
                String[] enabledCipherSuites = sSLParametersImpl.getEnabledCipherSuites();
                int length2 = enabledCipherSuites.length;
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    z2 = false;
                    if (i5 >= length2) {
                        break;
                    } else if (cipherSuite.equals(enabledCipherSuites[i5])) {
                        z2 = true;
                        break;
                    } else {
                        i4 = i5 + 1;
                    }
                }
                if (z2) {
                    if (session.isSingleUse()) {
                        removeSession(session);
                    }
                    return session;
                }
                return null;
            }
            return null;
        }
    }

    @Override // org.conscrypt.AbstractSessionContext
    NativeSslSession getSessionFromPersistentCache(byte[] bArr) {
        return null;
    }

    @Override // org.conscrypt.AbstractSessionContext
    void onBeforeAddSession(NativeSslSession nativeSslSession) {
        byte[] bytes;
        String peerHost = nativeSslSession.getPeerHost();
        int peerPort = nativeSslSession.getPeerPort();
        if (peerHost == null) {
            return;
        }
        putSession(new HostAndPort(peerHost, peerPort), nativeSslSession);
        if (this.persistentCache == null || nativeSslSession.isSingleUse() || (bytes = nativeSslSession.toBytes()) == null) {
            return;
        }
        this.persistentCache.putSessionData(nativeSslSession.toSSLSession(), bytes);
    }

    @Override // org.conscrypt.AbstractSessionContext
    void onBeforeRemoveSession(NativeSslSession nativeSslSession) {
        String peerHost = nativeSslSession.getPeerHost();
        if (peerHost == null) {
            return;
        }
        removeSession(new HostAndPort(peerHost, nativeSslSession.getPeerPort()), nativeSslSession);
    }

    public void setPersistentCache(SSLClientSessionCache sSLClientSessionCache) {
        this.persistentCache = sSLClientSessionCache;
    }

    int size() {
        int i;
        synchronized (this.sessionsByHostAndPort) {
            i = 0;
            for (List<NativeSslSession> list : this.sessionsByHostAndPort.values()) {
                i += list.size();
            }
        }
        return i;
    }
}
