package com.android.org.conscrypt;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.security.KeyManagementException;
import javax.net.ssl.SSLServerSocketFactory;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLServerSocketFactoryImpl.class */
public class OpenSSLServerSocketFactoryImpl extends SSLServerSocketFactory {
    private IOException instantiationException;
    private SSLParametersImpl sslParameters;

    public OpenSSLServerSocketFactoryImpl() {
        try {
            this.sslParameters = SSLParametersImpl.getDefault();
            this.sslParameters.setUseClientMode(false);
        } catch (KeyManagementException e) {
            this.instantiationException = new IOException("Delayed instantiation exception:");
            this.instantiationException.initCause(e);
        }
    }

    public OpenSSLServerSocketFactoryImpl(SSLParametersImpl sSLParametersImpl) {
        this.sslParameters = (SSLParametersImpl) sSLParametersImpl.clone();
        this.sslParameters.setUseClientMode(false);
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket() throws IOException {
        return new OpenSSLServerSocketImpl((SSLParametersImpl) this.sslParameters.clone());
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i) throws IOException {
        return new OpenSSLServerSocketImpl(i, (SSLParametersImpl) this.sslParameters.clone());
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i, int i2) throws IOException {
        return new OpenSSLServerSocketImpl(i, i2, (SSLParametersImpl) this.sslParameters.clone());
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i, int i2, InetAddress inetAddress) throws IOException {
        return new OpenSSLServerSocketImpl(i, i2, inetAddress, (SSLParametersImpl) this.sslParameters.clone());
    }

    @Override // javax.net.ssl.SSLServerSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.sslParameters.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLServerSocketFactory
    public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }
}
