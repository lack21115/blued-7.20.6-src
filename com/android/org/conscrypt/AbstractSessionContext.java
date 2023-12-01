package com.android.org.conscrypt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/AbstractSessionContext.class */
public abstract class AbstractSessionContext implements SSLSessionContext {
    private static final int DEFAULT_SESSION_TIMEOUT_SECONDS = 28800;
    static final int OPEN_SSL = 1;
    volatile int maximumSize;
    volatile int timeout = DEFAULT_SESSION_TIMEOUT_SECONDS;
    final long sslCtxNativePointer = NativeCrypto.SSL_CTX_new();
    private final Map<ByteArray, SSLSession> sessions = new LinkedHashMap<ByteArray, SSLSession>() { // from class: com.android.org.conscrypt.AbstractSessionContext.1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<ByteArray, SSLSession> entry) {
            if (AbstractSessionContext.this.maximumSize > 0 && size() > AbstractSessionContext.this.maximumSize) {
                remove(entry.getKey());
                AbstractSessionContext.this.sessionRemoved(entry.getValue());
                return false;
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractSessionContext(int i) {
        this.maximumSize = i;
    }

    static void log(Throwable th) {
        new Exception("Error converting session", th).printStackTrace();
    }

    private Iterator<SSLSession> sessionIterator() {
        Iterator<SSLSession> it;
        synchronized (this.sessions) {
            it = Arrays.asList((SSLSession[]) this.sessions.values().toArray(new SSLSession[this.sessions.size()])).iterator();
        }
        return it;
    }

    protected void finalize() throws Throwable {
        try {
            NativeCrypto.SSL_CTX_free(this.sslCtxNativePointer);
        } finally {
            super.finalize();
        }
    }

    @Override // javax.net.ssl.SSLSessionContext
    public final Enumeration<byte[]> getIds() {
        final Iterator<SSLSession> sessionIterator = sessionIterator();
        return new Enumeration<byte[]>() { // from class: com.android.org.conscrypt.AbstractSessionContext.2
            private SSLSession next;

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                if (this.next != null) {
                    return true;
                }
                while (sessionIterator.hasNext()) {
                    SSLSession sSLSession = (SSLSession) sessionIterator.next();
                    if (sSLSession.isValid()) {
                        this.next = sSLSession;
                        return true;
                    }
                }
                this.next = null;
                return false;
            }

            @Override // java.util.Enumeration
            public byte[] nextElement() {
                if (hasMoreElements()) {
                    byte[] id = this.next.getId();
                    this.next = null;
                    return id;
                }
                throw new NoSuchElementException();
            }
        };
    }

    @Override // javax.net.ssl.SSLSessionContext
    public SSLSession getSession(byte[] bArr) {
        SSLSession sSLSession;
        if (bArr == null) {
            throw new NullPointerException("sessionId == null");
        }
        ByteArray byteArray = new ByteArray(bArr);
        synchronized (this.sessions) {
            sSLSession = this.sessions.get(byteArray);
        }
        if (sSLSession == null || !sSLSession.isValid()) {
            return null;
        }
        return sSLSession;
    }

    @Override // javax.net.ssl.SSLSessionContext
    public final int getSessionCacheSize() {
        return this.maximumSize;
    }

    @Override // javax.net.ssl.SSLSessionContext
    public final int getSessionTimeout() {
        return this.timeout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putSession(SSLSession sSLSession) {
        byte[] id = sSLSession.getId();
        if (id.length == 0) {
            return;
        }
        ByteArray byteArray = new ByteArray(id);
        synchronized (this.sessions) {
            this.sessions.put(byteArray, sSLSession);
        }
    }

    protected abstract void sessionRemoved(SSLSession sSLSession);

    @Override // javax.net.ssl.SSLSessionContext
    public final void setSessionCacheSize(int i) throws IllegalArgumentException {
        if (i < 0) {
            throw new IllegalArgumentException("size < 0");
        }
        int i2 = this.maximumSize;
        this.maximumSize = i;
        if (i < i2) {
            trimToSize();
        }
    }

    @Override // javax.net.ssl.SSLSessionContext
    public void setSessionTimeout(int i) throws IllegalArgumentException {
        if (i < 0) {
            throw new IllegalArgumentException("seconds < 0");
        }
        this.timeout = i;
        synchronized (this.sessions) {
            Iterator<SSLSession> it = this.sessions.values().iterator();
            while (it.hasNext()) {
                SSLSession next = it.next();
                if (!next.isValid()) {
                    it.remove();
                    sessionRemoved(next);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] toBytes(SSLSession sSLSession) {
        if (!(sSLSession instanceof OpenSSLSessionImpl)) {
            return null;
        }
        OpenSSLSessionImpl openSSLSessionImpl = (OpenSSLSessionImpl) sSLSession;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(1);
            byte[] encoded = openSSLSessionImpl.getEncoded();
            dataOutputStream.writeInt(encoded.length);
            dataOutputStream.write(encoded);
            Certificate[] peerCertificates = sSLSession.getPeerCertificates();
            dataOutputStream.writeInt(peerCertificates.length);
            int length = peerCertificates.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return byteArrayOutputStream.toByteArray();
                }
                byte[] encoded2 = peerCertificates[i2].getEncoded();
                dataOutputStream.writeInt(encoded2.length);
                dataOutputStream.write(encoded2);
                i = i2 + 1;
            }
        } catch (IOException e) {
            log(e);
            return null;
        } catch (CertificateEncodingException e2) {
            log(e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SSLSession toSession(byte[] bArr, String str, int i) {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        try {
            int readInt = dataInputStream.readInt();
            if (readInt != 1) {
                log(new AssertionError("Unexpected type ID: " + readInt));
                return null;
            }
            byte[] bArr2 = new byte[dataInputStream.readInt()];
            dataInputStream.readFully(bArr2);
            int readInt2 = dataInputStream.readInt();
            X509Certificate[] x509CertificateArr = new X509Certificate[readInt2];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= readInt2) {
                    return new OpenSSLSessionImpl(bArr2, str, i, x509CertificateArr, this);
                }
                byte[] bArr3 = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr3);
                x509CertificateArr[i3] = OpenSSLX509Certificate.fromX509Der(bArr3);
                i2 = i3 + 1;
            }
        } catch (IOException e) {
            log(e);
            return null;
        }
    }

    protected void trimToSize() {
        int i;
        synchronized (this.sessions) {
            int size = this.sessions.size();
            if (size > this.maximumSize) {
                int i2 = size - this.maximumSize;
                Iterator<SSLSession> it = this.sessions.values().iterator();
                do {
                    it.remove();
                    sessionRemoved(it.next());
                    i = i2 - 1;
                    i2 = i;
                } while (i > 0);
            }
        }
    }
}
