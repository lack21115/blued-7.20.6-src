package com.tencent.cloud.huiyansdkface.wehttp2;

import android.os.Build;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/SSLSocketFactoryCompat.class */
public class SSLSocketFactoryCompat extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f22417a = {"TLSv1.2"};
    private final SSLSocketFactory b;

    public SSLSocketFactoryCompat() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, null, null);
        this.b = sSLContext.getSocketFactory();
    }

    public SSLSocketFactoryCompat(SSLSocketFactory sSLSocketFactory) {
        if (sSLSocketFactory == null) {
            throw null;
        }
        this.b = sSLSocketFactory;
    }

    private Socket a(Socket socket) {
        if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 20 && (socket instanceof SSLSocket)) {
            ((SSLSocket) socket).setEnabledProtocols(f22417a);
        }
        return socket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        return a(this.b.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return a(this.b.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return a(this.b.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return a(this.b.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return a(this.b.createSocket(socket, str, i, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.b.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.b.getSupportedCipherSuites();
    }
}
