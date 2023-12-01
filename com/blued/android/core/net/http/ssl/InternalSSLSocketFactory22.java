package com.blued.android.core.net.http.ssl;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/http/ssl/InternalSSLSocketFactory22.class */
public class InternalSSLSocketFactory22 extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private final SSLSocketFactory f9702a;
    private final SSLContext b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f9703c = {"TLSv1", "TLSv1.1", "TLSv1.2", "TLSv1.3"};

    public InternalSSLSocketFactory22(SSLContext sSLContext) {
        this.b = sSLContext;
        this.f9702a = sSLContext.getSocketFactory();
    }

    private Socket a(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(this.f9703c);
        }
        return socket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return a(this.f9702a.createSocket());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        return a(this.f9702a.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return a(this.f9702a.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return a(this.f9702a.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return a(this.f9702a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        try {
            String a2 = HttpsIPAccessUtils.a(str);
            InternalSSLCertificateSocketFactory internalSSLCertificateSocketFactory = (InternalSSLCertificateSocketFactory) InternalSSLCertificateSocketFactory.a(10000, new InternalSSLSessionCache(AppInfo.d()));
            internalSSLCertificateSocketFactory.a(this.b, this.f9702a);
            SSLSocket sSLSocket = (SSLSocket) internalSSLCertificateSocketFactory.createSocket(socket, str, i, z);
            internalSSLCertificateSocketFactory.a((Socket) sSLSocket, true);
            sSLSocket.setEnabledProtocols(this.f9703c);
            if (!TextUtils.isEmpty(a2)) {
                internalSSLCertificateSocketFactory.b(sSLSocket, a2);
            }
            sSLSocket.startHandshake();
            return sSLSocket;
        } catch (Throwable th) {
            throw new IOException("createSocket exception: " + th);
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f9702a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f9702a.getSupportedCipherSuites();
    }
}
