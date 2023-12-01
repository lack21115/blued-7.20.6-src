package com.danlan.android.cognition.network;

import com.danlan.android.cognition.StringFog;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyStore;
import java.util.Arrays;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/network/TLSSocketFactory.class */
public class TLSSocketFactory extends SSLSocketFactory {
    private final SSLSocketFactory delegate;
    private TrustManager[] trustManagers;

    public TLSSocketFactory() {
        generateTrustManagers();
        SSLContext sSLContext = SSLContext.getInstance(StringFog.decrypt("dW93"));
        sSLContext.init(null, this.trustManagers, null);
        this.delegate = sSLContext.getSocketFactory();
    }

    private Socket enableTLSOnSocket(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{StringFog.decrypt("dW93VRANFQ=="), StringFog.decrypt("dW93VRANFg==")});
        }
        return socket;
    }

    private void generateTrustManagers() {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            this.trustManagers = trustManagers;
            return;
        }
        throw new IllegalStateException(StringFog.decrypt("dE1BW1FGR1VERwRHREVFVE1XBFdTVldVAU5FTUBEQVNSGQ==") + Arrays.toString(trustManagers));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() {
        return enableTLSOnSocket(this.delegate.createSocket());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) {
        return enableTLSOnSocket(this.delegate.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return enableTLSOnSocket(this.delegate.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) {
        return enableTLSOnSocket(this.delegate.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return enableTLSOnSocket(this.delegate.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return enableTLSOnSocket(this.delegate.createSocket(socket, str, i, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    public X509TrustManager getTrustManager() {
        return (X509TrustManager) this.trustManagers[0];
    }
}
