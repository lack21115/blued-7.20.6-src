package com.android.org.conscrypt;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContextSpi;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLContextImpl.class */
public class OpenSSLContextImpl extends SSLContextSpi {
    private static DefaultSSLContextImpl DEFAULT_SSL_CONTEXT_IMPL;
    private final ClientSessionContext clientSessionContext;
    private final ServerSessionContext serverSessionContext;
    protected SSLParametersImpl sslParameters;

    public OpenSSLContextImpl() {
        this.clientSessionContext = new ClientSessionContext();
        this.serverSessionContext = new ServerSessionContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public OpenSSLContextImpl(DefaultSSLContextImpl defaultSSLContextImpl) throws GeneralSecurityException, IOException {
        synchronized (DefaultSSLContextImpl.class) {
            try {
                if (DEFAULT_SSL_CONTEXT_IMPL == null) {
                    this.clientSessionContext = new ClientSessionContext();
                    this.serverSessionContext = new ServerSessionContext();
                    DEFAULT_SSL_CONTEXT_IMPL = (DefaultSSLContextImpl) this;
                } else {
                    this.clientSessionContext = DEFAULT_SSL_CONTEXT_IMPL.engineGetClientSessionContext();
                    this.serverSessionContext = DEFAULT_SSL_CONTEXT_IMPL.engineGetServerSessionContext();
                }
                this.sslParameters = new SSLParametersImpl(DEFAULT_SSL_CONTEXT_IMPL.getKeyManagers(), DEFAULT_SSL_CONTEXT_IMPL.getTrustManagers(), null, this.clientSessionContext, this.serverSessionContext);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLEngine engineCreateSSLEngine() {
        if (this.sslParameters == null) {
            throw new IllegalStateException("SSLContext is not initialized.");
        }
        SSLParametersImpl sSLParametersImpl = (SSLParametersImpl) this.sslParameters.clone();
        sSLParametersImpl.setUseClientMode(false);
        return new OpenSSLEngineImpl(sSLParametersImpl);
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLEngine engineCreateSSLEngine(String str, int i) {
        if (this.sslParameters == null) {
            throw new IllegalStateException("SSLContext is not initialized.");
        }
        SSLParametersImpl sSLParametersImpl = (SSLParametersImpl) this.sslParameters.clone();
        sSLParametersImpl.setUseClientMode(false);
        return new OpenSSLEngineImpl(str, i, sSLParametersImpl);
    }

    @Override // javax.net.ssl.SSLContextSpi
    public ClientSessionContext engineGetClientSessionContext() {
        return this.clientSessionContext;
    }

    @Override // javax.net.ssl.SSLContextSpi
    public ServerSessionContext engineGetServerSessionContext() {
        return this.serverSessionContext;
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLServerSocketFactory engineGetServerSocketFactory() {
        if (this.sslParameters == null) {
            throw new IllegalStateException("SSLContext is not initialized.");
        }
        return new OpenSSLServerSocketFactoryImpl(this.sslParameters);
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLSocketFactory engineGetSocketFactory() {
        if (this.sslParameters == null) {
            throw new IllegalStateException("SSLContext is not initialized.");
        }
        return new OpenSSLSocketFactoryImpl(this.sslParameters);
    }

    @Override // javax.net.ssl.SSLContextSpi
    public void engineInit(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom) throws KeyManagementException {
        this.sslParameters = new SSLParametersImpl(keyManagerArr, trustManagerArr, secureRandom, this.clientSessionContext, this.serverSessionContext);
    }
}
