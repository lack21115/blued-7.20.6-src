package javax.net.ssl;

import java.nio.ByteBuffer;
import javax.net.ssl.SSLEngineResult;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/SSLEngine.class */
public abstract class SSLEngine {
    private final String peerHost;
    private final int peerPort;

    /* JADX INFO: Access modifiers changed from: protected */
    public SSLEngine() {
        this.peerHost = null;
        this.peerPort = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SSLEngine(String str, int i) {
        this.peerHost = str;
        this.peerPort = i;
    }

    public abstract void beginHandshake() throws SSLException;

    public abstract void closeInbound() throws SSLException;

    public abstract void closeOutbound();

    public abstract Runnable getDelegatedTask();

    public abstract boolean getEnableSessionCreation();

    public abstract String[] getEnabledCipherSuites();

    public abstract String[] getEnabledProtocols();

    public abstract SSLEngineResult.HandshakeStatus getHandshakeStatus();

    public abstract boolean getNeedClientAuth();

    public String getPeerHost() {
        return this.peerHost;
    }

    public int getPeerPort() {
        return this.peerPort;
    }

    public SSLParameters getSSLParameters() {
        SSLParameters sSLParameters = new SSLParameters();
        sSLParameters.setCipherSuites(getEnabledCipherSuites());
        sSLParameters.setProtocols(getEnabledProtocols());
        sSLParameters.setNeedClientAuth(getNeedClientAuth());
        sSLParameters.setWantClientAuth(getWantClientAuth());
        return sSLParameters;
    }

    public abstract SSLSession getSession();

    public abstract String[] getSupportedCipherSuites();

    public abstract String[] getSupportedProtocols();

    public abstract boolean getUseClientMode();

    public abstract boolean getWantClientAuth();

    public abstract boolean isInboundDone();

    public abstract boolean isOutboundDone();

    public abstract void setEnableSessionCreation(boolean z);

    public abstract void setEnabledCipherSuites(String[] strArr);

    public abstract void setEnabledProtocols(String[] strArr);

    public abstract void setNeedClientAuth(boolean z);

    public void setSSLParameters(SSLParameters sSLParameters) {
        String[] cipherSuites = sSLParameters.getCipherSuites();
        if (cipherSuites != null) {
            setEnabledCipherSuites(cipherSuites);
        }
        String[] protocols = sSLParameters.getProtocols();
        if (protocols != null) {
            setEnabledProtocols(protocols);
        }
        if (sSLParameters.getNeedClientAuth()) {
            setNeedClientAuth(true);
        } else if (sSLParameters.getWantClientAuth()) {
            setWantClientAuth(true);
        } else {
            setWantClientAuth(false);
        }
    }

    public abstract void setUseClientMode(boolean z);

    public abstract void setWantClientAuth(boolean z);

    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        return unwrap(byteBuffer, new ByteBuffer[]{byteBuffer2}, 0, 1);
    }

    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) throws SSLException {
        if (byteBufferArr == null) {
            throw new IllegalArgumentException("Byte buffer array dsts is null");
        }
        return unwrap(byteBuffer, byteBufferArr, 0, byteBufferArr.length);
    }

    public abstract SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i, int i2) throws SSLException;

    public SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        return wrap(new ByteBuffer[]{byteBuffer}, 0, 1, byteBuffer2);
    }

    public abstract SSLEngineResult wrap(ByteBuffer[] byteBufferArr, int i, int i2, ByteBuffer byteBuffer) throws SSLException;

    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, ByteBuffer byteBuffer) throws SSLException {
        if (byteBufferArr == null) {
            throw new IllegalArgumentException("Byte buffer array srcs is null");
        }
        return wrap(byteBufferArr, 0, byteBufferArr.length, byteBuffer);
    }
}
