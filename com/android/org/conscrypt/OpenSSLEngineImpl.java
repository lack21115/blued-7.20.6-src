package com.android.org.conscrypt;

import com.android.org.conscrypt.NativeCrypto;
import com.android.org.conscrypt.SSLParametersImpl;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import javax.crypto.SecretKey;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLEngineImpl.class */
public class OpenSSLEngineImpl extends SSLEngine implements NativeCrypto.SSLHandshakeCallbacks, SSLParametersImpl.AliasChooser, SSLParametersImpl.PSKCallbacks {
    private static OpenSSLBIOSource nullSource = OpenSSLBIOSource.wrap(ByteBuffer.allocate(0));
    OpenSSLKey channelIdPrivateKey;
    private EngineState engineState;
    private OpenSSLSessionImpl handshakeSession;
    private OpenSSLBIOSink handshakeSink;
    private final OpenSSLBIOSink localToRemoteSink;
    private long sslNativePointer;
    private final SSLParametersImpl sslParameters;
    private OpenSSLSessionImpl sslSession;
    private final Object stateLock;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.android.org.conscrypt.OpenSSLEngineImpl$1  reason: invalid class name */
    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLEngineImpl$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$conscrypt$OpenSSLEngineImpl$EngineState = new int[EngineState.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007f -> B:43:0x0070). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0083 -> B:45:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0087 -> B:59:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x008b -> B:55:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x008f -> B:51:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0093 -> B:47:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0097 -> B:61:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x009b -> B:57:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x009f -> B:53:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$org$conscrypt$OpenSSLEngineImpl$EngineState[EngineState.HANDSHAKE_WANTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLEngineImpl$EngineState[EngineState.HANDSHAKE_STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLEngineImpl$EngineState[EngineState.HANDSHAKE_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLEngineImpl$EngineState[EngineState.NEW.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLEngineImpl$EngineState[EngineState.MODE_SET.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLEngineImpl$EngineState[EngineState.CLOSED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLEngineImpl$EngineState[EngineState.CLOSED_INBOUND.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLEngineImpl$EngineState[EngineState.CLOSED_OUTBOUND.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLEngineImpl$EngineState[EngineState.READY.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLEngineImpl$EngineState[EngineState.READY_HANDSHAKE_CUT_THROUGH.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLEngineImpl$EngineState.class */
    public enum EngineState {
        NEW,
        MODE_SET,
        HANDSHAKE_WANTED,
        HANDSHAKE_STARTED,
        HANDSHAKE_COMPLETED,
        READY_HANDSHAKE_CUT_THROUGH,
        READY,
        CLOSED_INBOUND,
        CLOSED_OUTBOUND,
        CLOSED
    }

    public OpenSSLEngineImpl(SSLParametersImpl sSLParametersImpl) {
        this.stateLock = new Object();
        this.engineState = EngineState.NEW;
        this.localToRemoteSink = OpenSSLBIOSink.create();
        this.sslParameters = sSLParametersImpl;
    }

    public OpenSSLEngineImpl(String str, int i, SSLParametersImpl sSLParametersImpl) {
        super(str, i);
        this.stateLock = new Object();
        this.engineState = EngineState.NEW;
        this.localToRemoteSink = OpenSSLBIOSink.create();
        this.sslParameters = sSLParametersImpl;
    }

    private static void checkIndex(int i, int i2, int i3) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("offset < 0");
        }
        if (i3 < 0) {
            throw new IndexOutOfBoundsException("count < 0");
        }
        if (i2 > i) {
            throw new IndexOutOfBoundsException("offset > length");
        }
        if (i2 > i - i3) {
            throw new IndexOutOfBoundsException("offset + count > length");
        }
    }

    private void free() {
        if (this.sslNativePointer == 0) {
            return;
        }
        NativeCrypto.SSL_free(this.sslNativePointer);
        this.sslNativePointer = 0L;
    }

    private ByteBuffer getNextAvailableByteBuffer(ByteBuffer[] byteBufferArr, int i, int i2) {
        while (i < i2) {
            if (byteBufferArr[i].remaining() > 0) {
                return byteBufferArr[i];
            }
            i++;
        }
        return null;
    }

    private void shutdown() {
        try {
            NativeCrypto.SSL_shutdown_BIO(this.sslNativePointer, nullSource.getContext(), this.localToRemoteSink.getContext(), this);
        } catch (IOException e) {
        }
    }

    private void shutdownAndFreeSslNative() {
        try {
            shutdown();
        } finally {
            free();
        }
    }

    private static int writeSinkToByteBuffer(OpenSSLBIOSink openSSLBIOSink, ByteBuffer byteBuffer) {
        int min = Math.min(openSSLBIOSink.available(), byteBuffer.remaining());
        byteBuffer.put(openSSLBIOSink.toByteArray(), openSSLBIOSink.position(), min);
        openSSLBIOSink.skip(min);
        return min;
    }

    @Override // javax.net.ssl.SSLEngine
    public void beginHandshake() throws SSLException {
        synchronized (this.stateLock) {
            if (this.engineState == EngineState.CLOSED || this.engineState == EngineState.CLOSED_OUTBOUND || this.engineState == EngineState.CLOSED_INBOUND) {
                throw new IllegalStateException("Engine has already been closed");
            }
            if (this.engineState == EngineState.HANDSHAKE_STARTED) {
                throw new IllegalStateException("Handshake has already been started");
            }
            if (this.engineState != EngineState.MODE_SET) {
                throw new IllegalStateException("Client/server mode must be set before handshake");
            }
            if (getUseClientMode()) {
                this.engineState = EngineState.HANDSHAKE_WANTED;
            } else {
                this.engineState = EngineState.HANDSHAKE_STARTED;
            }
        }
        try {
            try {
                long j = this.sslParameters.getSessionContext().sslCtxNativePointer;
                this.sslNativePointer = NativeCrypto.SSL_new(j);
                this.sslSession = this.sslParameters.getSessionToReuse(this.sslNativePointer, getPeerHost(), getPeerPort());
                this.sslParameters.setSSLParameters(j, this.sslNativePointer, this, this, getPeerHost());
                this.sslParameters.setCertificateValidation(this.sslNativePointer);
                this.sslParameters.setTlsChannelId(this.sslNativePointer, this.channelIdPrivateKey);
                if (getUseClientMode()) {
                    NativeCrypto.SSL_set_connect_state(this.sslNativePointer);
                } else {
                    NativeCrypto.SSL_set_accept_state(this.sslNativePointer);
                }
                this.handshakeSink = OpenSSLBIOSink.create();
                if (0 != 0) {
                    synchronized (this.stateLock) {
                        this.engineState = EngineState.CLOSED;
                    }
                    shutdownAndFreeSslNative();
                }
            } catch (IOException e) {
                if (e.getMessage().contains("unexpected CCS")) {
                    Platform.logEvent(String.format("ssl_unexpected_ccs: host=%s", getPeerHost()));
                }
                throw new SSLException(e);
            }
        } catch (Throwable th) {
            if (1 != 0) {
                synchronized (this.stateLock) {
                    this.engineState = EngineState.CLOSED;
                    shutdownAndFreeSslNative();
                }
            }
            throw th;
        }
    }

    @Override // com.android.org.conscrypt.SSLParametersImpl.AliasChooser
    public String chooseClientAlias(X509KeyManager x509KeyManager, X500Principal[] x500PrincipalArr, String[] strArr) {
        return x509KeyManager instanceof X509ExtendedKeyManager ? ((X509ExtendedKeyManager) x509KeyManager).chooseEngineClientAlias(strArr, x500PrincipalArr, this) : x509KeyManager.chooseClientAlias(strArr, x500PrincipalArr, null);
    }

    @Override // com.android.org.conscrypt.SSLParametersImpl.PSKCallbacks
    public String chooseClientPSKIdentity(PSKKeyManager pSKKeyManager, String str) {
        return pSKKeyManager.chooseClientKeyIdentity(str, this);
    }

    @Override // com.android.org.conscrypt.SSLParametersImpl.AliasChooser
    public String chooseServerAlias(X509KeyManager x509KeyManager, String str) {
        return x509KeyManager instanceof X509ExtendedKeyManager ? ((X509ExtendedKeyManager) x509KeyManager).chooseEngineServerAlias(str, null, this) : x509KeyManager.chooseServerAlias(str, null, null);
    }

    @Override // com.android.org.conscrypt.SSLParametersImpl.PSKCallbacks
    public String chooseServerPSKIdentityHint(PSKKeyManager pSKKeyManager) {
        return pSKKeyManager.chooseServerKeyIdentityHint(this);
    }

    @Override // com.android.org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void clientCertificateRequested(byte[] bArr, byte[][] bArr2) throws CertificateEncodingException, SSLException {
        this.sslParameters.chooseClientCertificate(bArr, bArr2, this.sslNativePointer, this);
    }

    @Override // com.android.org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public int clientPSKKeyRequested(String str, byte[] bArr, byte[] bArr2) {
        return this.sslParameters.clientPSKKeyRequested(str, bArr, bArr2, this);
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeInbound() throws SSLException {
        synchronized (this.stateLock) {
            if (this.engineState == EngineState.CLOSED) {
                return;
            }
            if (this.engineState == EngineState.CLOSED_OUTBOUND) {
                this.engineState = EngineState.CLOSED;
            } else {
                this.engineState = EngineState.CLOSED_INBOUND;
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeOutbound() {
        synchronized (this.stateLock) {
            if (this.engineState == EngineState.CLOSED || this.engineState == EngineState.CLOSED_OUTBOUND) {
                return;
            }
            if (this.engineState != EngineState.MODE_SET && this.engineState != EngineState.NEW) {
                shutdownAndFreeSslNative();
            }
            if (this.engineState == EngineState.CLOSED_INBOUND) {
                this.engineState = EngineState.CLOSED;
            } else {
                this.engineState = EngineState.CLOSED_OUTBOUND;
            }
            shutdown();
        }
    }

    protected void finalize() throws Throwable {
        try {
            free();
        } finally {
            super.finalize();
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public Runnable getDelegatedTask() {
        return null;
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getEnableSessionCreation() {
        return this.sslParameters.getEnableSessionCreation();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getEnabledCipherSuites() {
        return this.sslParameters.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getEnabledProtocols() {
        return this.sslParameters.getEnabledProtocols();
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        synchronized (this.stateLock) {
            switch (AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLEngineImpl$EngineState[this.engineState.ordinal()]) {
                case 1:
                    if (getUseClientMode()) {
                        return SSLEngineResult.HandshakeStatus.NEED_WRAP;
                    }
                    return SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
                case 2:
                    if (this.handshakeSink.available() > 0) {
                        return SSLEngineResult.HandshakeStatus.NEED_WRAP;
                    }
                    return SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
                case 3:
                    if (this.handshakeSink.available() != 0) {
                        return SSLEngineResult.HandshakeStatus.NEED_WRAP;
                    }
                    this.handshakeSink = null;
                    this.engineState = EngineState.READY;
                    return SSLEngineResult.HandshakeStatus.FINISHED;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                default:
                    throw new IllegalStateException("Unexpected engine state: " + this.engineState);
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getNeedClientAuth() {
        return this.sslParameters.getNeedClientAuth();
    }

    @Override // com.android.org.conscrypt.SSLParametersImpl.PSKCallbacks
    public SecretKey getPSKKey(PSKKeyManager pSKKeyManager, String str, String str2) {
        return pSKKeyManager.getKey(str, str2, this);
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLSession getSession() {
        return this.sslSession == null ? SSLNullSession.getNullSession() : this.sslSession;
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getSupportedProtocols() {
        return NativeCrypto.getSupportedProtocols();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getUseClientMode() {
        return this.sslParameters.getUseClientMode();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getWantClientAuth() {
        return this.sslParameters.getWantClientAuth();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean isInboundDone() {
        boolean z;
        boolean z2 = true;
        if (this.sslNativePointer != 0) {
            if ((NativeCrypto.SSL_get_shutdown(this.sslNativePointer) & 2) == 0) {
                z2 = false;
            }
            return z2;
        }
        synchronized (this.stateLock) {
            z = true;
            if (this.engineState != EngineState.CLOSED) {
                z = this.engineState == EngineState.CLOSED_INBOUND;
            }
        }
        return z;
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean isOutboundDone() {
        boolean z;
        boolean z2 = true;
        if (this.sslNativePointer != 0) {
            if ((NativeCrypto.SSL_get_shutdown(this.sslNativePointer) & 1) == 0) {
                z2 = false;
            }
            return z2;
        }
        synchronized (this.stateLock) {
            z = true;
            if (this.engineState != EngineState.CLOSED) {
                z = this.engineState == EngineState.CLOSED_OUTBOUND;
            }
        }
        return z;
    }

    @Override // com.android.org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void onSSLStateChange(long j, int i, int i2) {
        synchronized (this.stateLock) {
            switch (i) {
                case 16:
                    this.engineState = EngineState.HANDSHAKE_STARTED;
                    break;
                case 32:
                    if (this.engineState != EngineState.HANDSHAKE_STARTED && this.engineState != EngineState.READY_HANDSHAKE_CUT_THROUGH) {
                        throw new IllegalStateException("Completed handshake while in mode " + this.engineState);
                    }
                    this.engineState = EngineState.HANDSHAKE_COMPLETED;
                    break;
            }
        }
    }

    @Override // com.android.org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public int serverPSKKeyRequested(String str, String str2, byte[] bArr) {
        return this.sslParameters.serverPSKKeyRequested(str, str2, bArr, this);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnableSessionCreation(boolean z) {
        this.sslParameters.setEnableSessionCreation(z);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnabledCipherSuites(String[] strArr) {
        this.sslParameters.setEnabledCipherSuites(strArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnabledProtocols(String[] strArr) {
        this.sslParameters.setEnabledProtocols(strArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setNeedClientAuth(boolean z) {
        this.sslParameters.setNeedClientAuth(z);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setUseClientMode(boolean z) {
        synchronized (this.stateLock) {
            if (this.engineState != EngineState.MODE_SET && this.engineState != EngineState.NEW) {
                throw new IllegalArgumentException("Can not change mode after handshake: engineState == " + this.engineState);
            }
            this.engineState = EngineState.MODE_SET;
        }
        this.sslParameters.setUseClientMode(z);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setWantClientAuth(boolean z) {
        this.sslParameters.setWantClientAuth(z);
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i, int i2) throws SSLException {
        OpenSSLBIOSource wrap;
        long j;
        if (byteBuffer == null) {
            throw new IllegalArgumentException("src == null");
        }
        if (byteBufferArr == null) {
            throw new IllegalArgumentException("dsts == null");
        }
        checkIndex(byteBufferArr.length, i, i2);
        int i3 = 0;
        int i4 = 0;
        while (i4 < byteBufferArr.length) {
            ByteBuffer byteBuffer2 = byteBufferArr[i4];
            if (byteBuffer2 == null) {
                throw new IllegalArgumentException("one of the dst == null");
            }
            if (byteBuffer2.isReadOnly()) {
                throw new ReadOnlyBufferException();
            }
            int i5 = i3;
            if (i4 >= i) {
                i5 = i3;
                if (i4 < i + i2) {
                    i5 = i3 + byteBuffer2.remaining();
                }
            }
            i4++;
            i3 = i5;
        }
        synchronized (this.stateLock) {
            if (this.engineState == EngineState.CLOSED || this.engineState == EngineState.CLOSED_INBOUND) {
                return new SSLEngineResult(SSLEngineResult.Status.CLOSED, getHandshakeStatus(), 0, 0);
            }
            if (this.engineState == EngineState.NEW || this.engineState == EngineState.MODE_SET) {
                beginHandshake();
            }
            SSLEngineResult.HandshakeStatus handshakeStatus = getHandshakeStatus();
            if (handshakeStatus != SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
                if (handshakeStatus != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
                    return new SSLEngineResult(SSLEngineResult.Status.OK, handshakeStatus, 0, 0);
                }
                if (i3 == 0) {
                    return new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW, getHandshakeStatus(), 0, 0);
                }
                ByteBuffer duplicate = byteBuffer.duplicate();
                wrap = OpenSSLBIOSource.wrap(duplicate);
                try {
                    try {
                        int position = duplicate.position();
                        int i6 = 0;
                        boolean z = false;
                        while (!z) {
                            ByteBuffer nextAvailableByteBuffer = getNextAvailableByteBuffer(byteBufferArr, i, i2);
                            if (nextAvailableByteBuffer == null) {
                                z = true;
                            } else {
                                ByteBuffer byteBuffer3 = nextAvailableByteBuffer;
                                if (nextAvailableByteBuffer.isDirect()) {
                                    byteBuffer3 = ByteBuffer.allocate(nextAvailableByteBuffer.remaining());
                                }
                                int SSL_read_BIO = NativeCrypto.SSL_read_BIO(this.sslNativePointer, byteBuffer3.array(), byteBuffer3.arrayOffset() + byteBuffer3.position(), nextAvailableByteBuffer.remaining(), wrap.getContext(), this.localToRemoteSink.getContext(), this);
                                if (SSL_read_BIO <= 0) {
                                    z = true;
                                } else {
                                    byteBuffer3.position(byteBuffer3.position() + SSL_read_BIO);
                                    int i7 = i6 + SSL_read_BIO;
                                    i6 = i7;
                                    if (nextAvailableByteBuffer != byteBuffer3) {
                                        byteBuffer3.flip();
                                        nextAvailableByteBuffer.put(byteBuffer3);
                                        i6 = i7;
                                    }
                                }
                            }
                        }
                        int position2 = duplicate.position() - position;
                        byteBuffer.position(duplicate.position());
                        return new SSLEngineResult(position2 > 0 ? SSLEngineResult.Status.OK : SSLEngineResult.Status.BUFFER_UNDERFLOW, getHandshakeStatus(), position2, i6);
                    } finally {
                        wrap.release();
                    }
                } catch (IOException e) {
                    throw new SSLException(e);
                }
            }
            int position3 = byteBuffer.position();
            wrap = OpenSSLBIOSource.wrap(byteBuffer);
            try {
                try {
                    j = NativeCrypto.SSL_do_handshake_bio(this.sslNativePointer, wrap.getContext(), this.handshakeSink.getContext(), this, getUseClientMode(), this.sslParameters.npnProtocols, this.sslParameters.alpnProtocols);
                    if (j != 0) {
                        try {
                            if (this.sslSession != null && this.engineState == EngineState.HANDSHAKE_STARTED) {
                                this.engineState = EngineState.READY_HANDSHAKE_CUT_THROUGH;
                            }
                            this.sslSession = this.sslParameters.setupSession(j, this.sslNativePointer, this.sslSession, getPeerHost(), getPeerPort(), true);
                        } catch (Exception e2) {
                            e = e2;
                            throw ((SSLHandshakeException) new SSLHandshakeException("Handshake failed").initCause(e));
                        }
                    }
                    int position4 = this.handshakeSink.position();
                    int position5 = byteBuffer.position() - position3;
                    SSLEngineResult sSLEngineResult = new SSLEngineResult(position5 > 0 ? SSLEngineResult.Status.OK : SSLEngineResult.Status.BUFFER_UNDERFLOW, getHandshakeStatus(), position5, position4);
                    if (this.sslSession == null && j != 0) {
                        NativeCrypto.SSL_SESSION_free(j);
                    }
                    return sSLEngineResult;
                } catch (Exception e3) {
                    e = e3;
                    j = 0;
                } catch (Throwable th) {
                    th = th;
                    if (this.sslSession == null) {
                        NativeCrypto.SSL_SESSION_free(0L);
                    }
                    wrap.release();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (this.sslSession == null && 0 != 0) {
                    NativeCrypto.SSL_SESSION_free(0L);
                }
                wrap.release();
                throw th;
            }
        }
    }

    @Override // com.android.org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void verifyCertificateChain(long j, long[] jArr, String str) throws CertificateException {
        try {
            try {
                X509TrustManager x509TrustManager = this.sslParameters.getX509TrustManager();
                if (x509TrustManager == null) {
                    throw new CertificateException("No X.509 TrustManager");
                }
                if (jArr == null || jArr.length == 0) {
                    throw new SSLException("Peer sent no certificate");
                }
                OpenSSLX509Certificate[] openSSLX509CertificateArr = new OpenSSLX509Certificate[jArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jArr.length) {
                        break;
                    }
                    openSSLX509CertificateArr[i2] = new OpenSSLX509Certificate(jArr[i2]);
                    i = i2 + 1;
                }
                this.handshakeSession = new OpenSSLSessionImpl(j, null, openSSLX509CertificateArr, getPeerHost(), getPeerPort(), null);
                if (this.sslParameters.getUseClientMode()) {
                    Platform.checkServerTrusted(x509TrustManager, openSSLX509CertificateArr, str, getPeerHost());
                } else {
                    x509TrustManager.checkClientTrusted(openSSLX509CertificateArr, openSSLX509CertificateArr[0].getPublicKey().getAlgorithm());
                }
            } catch (CertificateException e) {
                throw e;
            } catch (Exception e2) {
                throw new CertificateException(e2);
            }
        } finally {
            this.handshakeSession = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x01fd, code lost:
        if (r0 > r23.length) goto L116;
     */
    @Override // javax.net.ssl.SSLEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public javax.net.ssl.SSLEngineResult wrap(java.nio.ByteBuffer[] r12, int r13, int r14, java.nio.ByteBuffer r15) throws javax.net.ssl.SSLException {
        /*
            Method dump skipped, instructions count: 646
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.org.conscrypt.OpenSSLEngineImpl.wrap(java.nio.ByteBuffer[], int, int, java.nio.ByteBuffer):javax.net.ssl.SSLEngineResult");
    }
}
