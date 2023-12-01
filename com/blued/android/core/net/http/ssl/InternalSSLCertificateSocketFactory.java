package com.blued.android.core.net.http.ssl;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Socket;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;
import org.conscrypt.OpenSSLSocketImpl;
import org.conscrypt.SSLClientSessionCache;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/http/ssl/InternalSSLCertificateSocketFactory.class */
public class InternalSSLCertificateSocketFactory extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final TrustManager[] f9699a = {new X509TrustManager() { // from class: com.blued.android.core.net.http.ssl.InternalSSLCertificateSocketFactory.1
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }};
    private SSLSocketFactory b = null;

    /* renamed from: c  reason: collision with root package name */
    private SSLSocketFactory f9700c = null;
    private TrustManager[] d = null;
    private KeyManager[] e = null;
    private byte[] f = null;
    private byte[] g = null;
    private PrivateKey h = null;
    private final int i;
    private final SSLClientSessionCache j;
    private final boolean k;

    private InternalSSLCertificateSocketFactory(int i, InternalSSLSessionCache internalSSLSessionCache, boolean z) {
        this.i = i;
        this.k = z;
        SSLClientSessionCache sSLClientSessionCache = null;
        if (internalSSLSessionCache != null) {
            try {
                Field declaredField = internalSSLSessionCache.getClass().getDeclaredField("mSessionCache");
                declaredField.setAccessible(true);
                sSLClientSessionCache = (SSLClientSessionCache) declaredField.get(internalSSLSessionCache);
            } catch (Exception e) {
                e.printStackTrace();
                sSLClientSessionCache = null;
            }
        }
        this.j = sSLClientSessionCache;
    }

    private SSLSocketFactory a() {
        synchronized (this) {
            if (this.k) {
                if (this.f9700c == null) {
                    this.f9700c = a(this.e, this.d);
                }
                return this.f9700c;
            }
            if (this.b == null) {
                if (this.k) {
                    Log.w("SSLCertificateSocket", "*** BYPASSING SSL SECURITY CHECKS (socket.relaxsslcheck=yes) ***");
                } else {
                    Log.w("SSLCertificateSocket", "Bypassing SSL security checks at caller's request");
                }
                this.b = a(this.e, f9699a);
            }
            return this.b;
        }
    }

    public static SSLSocketFactory a(int i, InternalSSLSessionCache internalSSLSessionCache) {
        return new InternalSSLCertificateSocketFactory(i, internalSSLSessionCache, false);
    }

    private SSLSocketFactory a(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr) {
        try {
            if (Conscrypt.isAvailable()) {
                X509TrustManager defaultX509TrustManager = Conscrypt.getDefaultX509TrustManager();
                SSLContext sSLContext = SSLContext.getInstance("TLS", "Conscrypt");
                sSLContext.init(null, new TrustManager[]{defaultX509TrustManager}, null);
                return sSLContext.getSocketFactory();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (SSLSocketFactory) SSLSocketFactory.getDefault();
    }

    private static OpenSSLSocketImpl a(Socket socket) {
        if (socket instanceof OpenSSLSocketImpl) {
            return (OpenSSLSocketImpl) socket;
        }
        throw new IllegalArgumentException("Socket not created by this factory: " + socket);
    }

    public static void a(Socket socket, String str) throws IOException {
        if (!(socket instanceof SSLSocket)) {
            throw new IllegalArgumentException("Attempt to verify non-SSL socket");
        }
        SSLSocket sSLSocket = (SSLSocket) socket;
        sSLSocket.startHandshake();
        SSLSession session = sSLSocket.getSession();
        if (session == null) {
            throw new SSLException("Cannot verify SSL socket without session");
        }
        if (HttpsURLConnection.getDefaultHostnameVerifier().verify(str, session)) {
            return;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
    }

    public void a(Socket socket, boolean z) {
        a(socket).setUseSessionTickets(z);
    }

    public void a(SSLContext sSLContext, SSLSocketFactory sSLSocketFactory) {
        Conscrypt.setClientSessionCache(sSLContext, this.j);
        this.b = sSLSocketFactory;
    }

    public void b(Socket socket, String str) {
        a(socket).setHostname(str);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        OpenSSLSocketImpl openSSLSocketImpl = (OpenSSLSocketImpl) a().createSocket();
        openSSLSocketImpl.setNpnProtocols(this.f);
        openSSLSocketImpl.setAlpnProtocols(this.g);
        openSSLSocketImpl.setHandshakeTimeout(this.i);
        openSSLSocketImpl.setChannelIdPrivateKey(this.h);
        return openSSLSocketImpl;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        OpenSSLSocketImpl openSSLSocketImpl = (OpenSSLSocketImpl) a().createSocket(str, i);
        openSSLSocketImpl.setNpnProtocols(this.f);
        openSSLSocketImpl.setAlpnProtocols(this.g);
        openSSLSocketImpl.setHandshakeTimeout(this.i);
        openSSLSocketImpl.setChannelIdPrivateKey(this.h);
        if (this.k) {
            a(openSSLSocketImpl, str);
        }
        return openSSLSocketImpl;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        OpenSSLSocketImpl openSSLSocketImpl = (OpenSSLSocketImpl) a().createSocket(str, i, inetAddress, i2);
        openSSLSocketImpl.setNpnProtocols(this.f);
        openSSLSocketImpl.setAlpnProtocols(this.g);
        openSSLSocketImpl.setHandshakeTimeout(this.i);
        openSSLSocketImpl.setChannelIdPrivateKey(this.h);
        if (this.k) {
            a(openSSLSocketImpl, str);
        }
        return openSSLSocketImpl;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        OpenSSLSocketImpl openSSLSocketImpl = (OpenSSLSocketImpl) a().createSocket(inetAddress, i);
        openSSLSocketImpl.setNpnProtocols(this.f);
        openSSLSocketImpl.setAlpnProtocols(this.g);
        openSSLSocketImpl.setHandshakeTimeout(this.i);
        openSSLSocketImpl.setChannelIdPrivateKey(this.h);
        return openSSLSocketImpl;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        OpenSSLSocketImpl openSSLSocketImpl = (OpenSSLSocketImpl) a().createSocket(inetAddress, i, inetAddress2, i2);
        openSSLSocketImpl.setNpnProtocols(this.f);
        openSSLSocketImpl.setAlpnProtocols(this.g);
        openSSLSocketImpl.setHandshakeTimeout(this.i);
        openSSLSocketImpl.setChannelIdPrivateKey(this.h);
        return openSSLSocketImpl;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        OpenSSLSocketImpl openSSLSocketImpl = (OpenSSLSocketImpl) a().createSocket(socket, str, i, z);
        openSSLSocketImpl.setNpnProtocols(this.f);
        openSSLSocketImpl.setAlpnProtocols(this.g);
        openSSLSocketImpl.setHandshakeTimeout(this.i);
        openSSLSocketImpl.setChannelIdPrivateKey(this.h);
        if (this.k) {
            a(openSSLSocketImpl, str);
        }
        return openSSLSocketImpl;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return a().getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return a().getSupportedCipherSuites();
    }
}
