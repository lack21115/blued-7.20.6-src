package com.android.org.conscrypt;

import com.android.org.conscrypt.NativeCrypto;
import com.android.org.conscrypt.SSLParametersImpl;
import com.android.org.conscrypt.util.Arrays;
import com.blued.android.module.common.web.LoaderConstants;
import dalvik.system.BlockGuard;
import dalvik.system.CloseGuard;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.crypto.SecretKey;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLSocketImpl.class */
public class OpenSSLSocketImpl extends SSLSocket implements NativeCrypto.SSLHandshakeCallbacks, SSLParametersImpl.AliasChooser, SSLParametersImpl.PSKCallbacks {
    private static final boolean DBG_STATE = false;
    private static final int STATE_CLOSED = 5;
    private static final int STATE_HANDSHAKE_COMPLETED = 2;
    private static final int STATE_HANDSHAKE_STARTED = 1;
    private static final int STATE_NEW = 0;
    private static final int STATE_READY = 4;
    private static final int STATE_READY_HANDSHAKE_CUT_THROUGH = 3;
    private final boolean autoClose;
    OpenSSLKey channelIdPrivateKey;
    private final CloseGuard guard;
    private OpenSSLSessionImpl handshakeSession;
    private int handshakeTimeoutMilliseconds;
    private SSLInputStream is;
    private ArrayList<HandshakeCompletedListener> listeners;
    private SSLOutputStream os;
    private String peerHostname;
    private final int peerPort;
    private int readTimeoutMilliseconds;
    private String resolvedHostname;
    private final Socket socket;
    private long sslNativePointer;
    private final SSLParametersImpl sslParameters;
    private OpenSSLSessionImpl sslSession;
    private int state;
    private final Object stateLock;
    private int writeTimeoutMilliseconds;

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLSocketImpl$SSLInputStream.class */
    private class SSLInputStream extends InputStream {
        private final Object readLock = new Object();

        SSLInputStream() {
        }

        public void awaitPendingOps() {
            synchronized (this.readLock) {
            }
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int i = -1;
            byte[] bArr = new byte[1];
            if (read(bArr, 0, 1) != -1) {
                i = bArr[0] & 255;
            }
            return i;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int SSL_read;
            BlockGuard.getThreadPolicy().onNetwork();
            OpenSSLSocketImpl.this.checkOpen();
            Arrays.checkOffsetAndCount(bArr.length, i, i2);
            if (i2 == 0) {
                return 0;
            }
            synchronized (this.readLock) {
                synchronized (OpenSSLSocketImpl.this.stateLock) {
                    if (OpenSSLSocketImpl.this.state == 5) {
                        throw new SocketException("socket is closed");
                    }
                }
                SSL_read = NativeCrypto.SSL_read(OpenSSLSocketImpl.this.sslNativePointer, Platform.getFileDescriptor(OpenSSLSocketImpl.this.socket), OpenSSLSocketImpl.this, bArr, i, i2, OpenSSLSocketImpl.this.getSoTimeout());
            }
            return SSL_read;
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLSocketImpl$SSLOutputStream.class */
    private class SSLOutputStream extends OutputStream {
        private final Object writeLock = new Object();

        SSLOutputStream() {
        }

        public void awaitPendingOps() {
            synchronized (this.writeLock) {
            }
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            write(new byte[]{(byte) (i & 255)});
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            BlockGuard.getThreadPolicy().onNetwork();
            OpenSSLSocketImpl.this.checkOpen();
            Arrays.checkOffsetAndCount(bArr.length, i, i2);
            if (i2 == 0) {
                return;
            }
            synchronized (this.writeLock) {
                synchronized (OpenSSLSocketImpl.this.stateLock) {
                    if (OpenSSLSocketImpl.this.state == 5) {
                        throw new SocketException("socket is closed");
                    }
                }
                NativeCrypto.SSL_write(OpenSSLSocketImpl.this.sslNativePointer, Platform.getFileDescriptor(OpenSSLSocketImpl.this.socket), OpenSSLSocketImpl.this, bArr, i, i2, OpenSSLSocketImpl.this.writeTimeoutMilliseconds);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public OpenSSLSocketImpl(SSLParametersImpl sSLParametersImpl) throws IOException {
        this.stateLock = new Object();
        this.state = 0;
        this.guard = CloseGuard.get();
        this.readTimeoutMilliseconds = 0;
        this.writeTimeoutMilliseconds = 0;
        this.handshakeTimeoutMilliseconds = -1;
        this.socket = this;
        this.peerHostname = null;
        this.peerPort = -1;
        this.autoClose = false;
        this.sslParameters = sSLParametersImpl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public OpenSSLSocketImpl(String str, int i, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(str, i);
        this.stateLock = new Object();
        this.state = 0;
        this.guard = CloseGuard.get();
        this.readTimeoutMilliseconds = 0;
        this.writeTimeoutMilliseconds = 0;
        this.handshakeTimeoutMilliseconds = -1;
        this.socket = this;
        this.peerHostname = str;
        this.peerPort = i;
        this.autoClose = false;
        this.sslParameters = sSLParametersImpl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public OpenSSLSocketImpl(String str, int i, InetAddress inetAddress, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(str, i, inetAddress, i2);
        this.stateLock = new Object();
        this.state = 0;
        this.guard = CloseGuard.get();
        this.readTimeoutMilliseconds = 0;
        this.writeTimeoutMilliseconds = 0;
        this.handshakeTimeoutMilliseconds = -1;
        this.socket = this;
        this.peerHostname = str;
        this.peerPort = i;
        this.autoClose = false;
        this.sslParameters = sSLParametersImpl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public OpenSSLSocketImpl(InetAddress inetAddress, int i, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(inetAddress, i);
        this.stateLock = new Object();
        this.state = 0;
        this.guard = CloseGuard.get();
        this.readTimeoutMilliseconds = 0;
        this.writeTimeoutMilliseconds = 0;
        this.handshakeTimeoutMilliseconds = -1;
        this.socket = this;
        this.peerHostname = null;
        this.peerPort = -1;
        this.autoClose = false;
        this.sslParameters = sSLParametersImpl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public OpenSSLSocketImpl(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(inetAddress, i, inetAddress2, i2);
        this.stateLock = new Object();
        this.state = 0;
        this.guard = CloseGuard.get();
        this.readTimeoutMilliseconds = 0;
        this.writeTimeoutMilliseconds = 0;
        this.handshakeTimeoutMilliseconds = -1;
        this.socket = this;
        this.peerHostname = null;
        this.peerPort = -1;
        this.autoClose = false;
        this.sslParameters = sSLParametersImpl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public OpenSSLSocketImpl(Socket socket, String str, int i, boolean z, SSLParametersImpl sSLParametersImpl) throws IOException {
        this.stateLock = new Object();
        this.state = 0;
        this.guard = CloseGuard.get();
        this.readTimeoutMilliseconds = 0;
        this.writeTimeoutMilliseconds = 0;
        this.handshakeTimeoutMilliseconds = -1;
        this.socket = socket;
        this.peerHostname = str;
        this.peerPort = i;
        this.autoClose = z;
        this.sslParameters = sSLParametersImpl;
    }

    private void assertReadableOrWriteableState() {
        if (this.state != 4 && this.state != 3) {
            throw new AssertionError("Invalid state: " + this.state);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkOpen() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
    }

    private void closeUnderlyingSocket() throws IOException {
        if (this.socket == this) {
            if (super.isClosed()) {
                return;
            }
            super.close();
        } else if (!this.autoClose || this.socket.isClosed()) {
        } else {
            this.socket.close();
        }
    }

    private void free() {
        if (this.sslNativePointer == 0) {
            return;
        }
        NativeCrypto.SSL_free(this.sslNativePointer);
        this.sslNativePointer = 0L;
        this.guard.close();
    }

    private String getHostname() {
        InetAddress inetAddress;
        if (this.peerHostname != null) {
            return this.peerHostname;
        }
        if (this.resolvedHostname == null && (inetAddress = super.getInetAddress()) != null) {
            this.resolvedHostname = inetAddress.getHostName();
        }
        return this.resolvedHostname;
    }

    private void notifyHandshakeCompletedListeners() {
        if (this.listeners == null || this.listeners.isEmpty()) {
            return;
        }
        HandshakeCompletedEvent handshakeCompletedEvent = new HandshakeCompletedEvent(this, this.sslSession);
        Iterator<HandshakeCompletedListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().handshakeCompleted(handshakeCompletedEvent);
            } catch (RuntimeException e) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, e);
            }
        }
    }

    private void shutdownAndFreeSslNative() throws IOException {
        try {
            BlockGuard.getThreadPolicy().onNetwork();
            NativeCrypto.SSL_shutdown(this.sslNativePointer, Platform.getFileDescriptor(this.socket), this);
        } catch (IOException e) {
        } finally {
            free();
            closeUnderlyingSocket();
        }
    }

    private void waitForHandshake() throws IOException {
        startHandshake();
        synchronized (this.stateLock) {
            while (this.state != 4 && this.state != 3 && this.state != 5) {
                try {
                    this.stateLock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    IOException iOException = new IOException("Interrupted waiting for handshake");
                    iOException.initCause(e);
                    throw iOException;
                }
            }
            if (this.state == 5) {
                throw new SocketException("Socket is closed");
            }
        }
    }

    @Override // javax.net.ssl.SSLSocket
    public void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        if (handshakeCompletedListener == null) {
            throw new IllegalArgumentException("Provided listener is null");
        }
        if (this.listeners == null) {
            this.listeners = new ArrayList<>();
        }
        this.listeners.add(handshakeCompletedListener);
    }

    @Override // com.android.org.conscrypt.SSLParametersImpl.AliasChooser
    public String chooseClientAlias(X509KeyManager x509KeyManager, X500Principal[] x500PrincipalArr, String[] strArr) {
        return x509KeyManager.chooseClientAlias(strArr, null, this);
    }

    @Override // com.android.org.conscrypt.SSLParametersImpl.PSKCallbacks
    public String chooseClientPSKIdentity(PSKKeyManager pSKKeyManager, String str) {
        return pSKKeyManager.chooseClientKeyIdentity(str, this);
    }

    @Override // com.android.org.conscrypt.SSLParametersImpl.AliasChooser
    public String chooseServerAlias(X509KeyManager x509KeyManager, String str) {
        return x509KeyManager.chooseServerAlias(str, null, this);
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

    @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.stateLock) {
            if (this.state == 5) {
                return;
            }
            int i = this.state;
            this.state = 5;
            if (i == 0) {
                closeUnderlyingSocket();
                this.stateLock.notifyAll();
            } else if (i != 4 && i != 3) {
                NativeCrypto.SSL_interrupt(this.sslNativePointer);
                this.stateLock.notifyAll();
            } else {
                this.stateLock.notifyAll();
                SSLInputStream sSLInputStream = this.is;
                SSLOutputStream sSLOutputStream = this.os;
                if (sSLInputStream != null || sSLOutputStream != null) {
                    NativeCrypto.SSL_interrupt(this.sslNativePointer);
                }
                if (sSLInputStream != null) {
                    sSLInputStream.awaitPendingOps();
                }
                if (sSLOutputStream != null) {
                    sSLOutputStream.awaitPendingOps();
                }
                shutdownAndFreeSslNative();
            }
        }
    }

    protected void finalize() throws Throwable {
        try {
            if (this.guard != null) {
                this.guard.warnIfOpen();
            }
            free();
        } finally {
            super.finalize();
        }
    }

    public byte[] getAlpnSelectedProtocol() {
        return NativeCrypto.SSL_get0_alpn_selected(this.sslNativePointer);
    }

    public byte[] getChannelId() throws SSLException {
        if (getUseClientMode()) {
            throw new IllegalStateException("Client mode");
        }
        synchronized (this.stateLock) {
            if (this.state != 4) {
                throw new IllegalStateException("Channel ID is only available after handshake completes");
            }
        }
        return NativeCrypto.SSL_get_tls_channel_id(this.sslNativePointer);
    }

    @Override // javax.net.ssl.SSLSocket
    public boolean getEnableSessionCreation() {
        return this.sslParameters.getEnableSessionCreation();
    }

    @Override // javax.net.ssl.SSLSocket
    public String[] getEnabledCipherSuites() {
        return this.sslParameters.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocket
    public String[] getEnabledProtocols() {
        return this.sslParameters.getEnabledProtocols();
    }

    @Override // java.net.Socket
    public FileDescriptor getFileDescriptor$() {
        return this.socket == this ? Platform.getFileDescriptorFromSSLSocket(this) : Platform.getFileDescriptor(this.socket);
    }

    @Override // java.net.Socket
    public InputStream getInputStream() throws IOException {
        SSLInputStream sSLInputStream;
        checkOpen();
        synchronized (this.stateLock) {
            if (this.state == 5) {
                throw new SocketException("Socket is closed.");
            }
            if (this.is == null) {
                this.is = new SSLInputStream();
            }
            sSLInputStream = this.is;
        }
        waitForHandshake();
        return sSLInputStream;
    }

    @Override // javax.net.ssl.SSLSocket
    public boolean getNeedClientAuth() {
        return this.sslParameters.getNeedClientAuth();
    }

    public byte[] getNpnSelectedProtocol() {
        return NativeCrypto.SSL_get_npn_negotiated_protocol(this.sslNativePointer);
    }

    @Override // java.net.Socket
    public OutputStream getOutputStream() throws IOException {
        SSLOutputStream sSLOutputStream;
        checkOpen();
        synchronized (this.stateLock) {
            if (this.state == 5) {
                throw new SocketException("Socket is closed.");
            }
            if (this.os == null) {
                this.os = new SSLOutputStream();
            }
            sSLOutputStream = this.os;
        }
        waitForHandshake();
        return sSLOutputStream;
    }

    @Override // com.android.org.conscrypt.SSLParametersImpl.PSKCallbacks
    public SecretKey getPSKKey(PSKKeyManager pSKKeyManager, String str, String str2) {
        return pSKKeyManager.getKey(str, str2, this);
    }

    @Override // java.net.Socket
    public int getPort() {
        return this.peerPort == -1 ? super.getPort() : this.peerPort;
    }

    @Override // javax.net.ssl.SSLSocket
    public SSLSession getSession() {
        if (this.sslSession == null) {
            try {
                waitForHandshake();
            } catch (IOException e) {
                return SSLNullSession.getNullSession();
            }
        }
        return this.sslSession;
    }

    @Override // java.net.Socket
    public int getSoTimeout() throws SocketException {
        return this.readTimeoutMilliseconds;
    }

    public int getSoWriteTimeout() throws SocketException {
        return this.writeTimeoutMilliseconds;
    }

    @Override // javax.net.ssl.SSLSocket
    public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocket
    public String[] getSupportedProtocols() {
        return NativeCrypto.getSupportedProtocols();
    }

    @Override // javax.net.ssl.SSLSocket
    public boolean getUseClientMode() {
        return this.sslParameters.getUseClientMode();
    }

    @Override // javax.net.ssl.SSLSocket
    public boolean getWantClientAuth() {
        return this.sslParameters.getWantClientAuth();
    }

    @Override // com.android.org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void onSSLStateChange(long j, int i, int i2) {
        if (i != 32) {
            return;
        }
        synchronized (this.stateLock) {
            if (this.state == 1) {
                this.state = 2;
            } else if (this.state != 3 && this.state == 5) {
            } else {
                this.sslSession.resetId();
                (this.sslParameters.getUseClientMode() ? this.sslParameters.getClientSessionContext() : this.sslParameters.getServerSessionContext()).putSession(this.sslSession);
                notifyHandshakeCompletedListeners();
                synchronized (this.stateLock) {
                    this.state = 4;
                    this.stateLock.notifyAll();
                }
            }
        }
    }

    @Override // javax.net.ssl.SSLSocket
    public void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        if (handshakeCompletedListener == null) {
            throw new IllegalArgumentException("Provided listener is null");
        }
        if (this.listeners == null) {
            throw new IllegalArgumentException("Provided listener is not registered");
        }
        if (!this.listeners.remove(handshakeCompletedListener)) {
            throw new IllegalArgumentException("Provided listener is not registered");
        }
    }

    @Override // java.net.Socket
    public void sendUrgentData(int i) throws IOException {
        throw new SocketException("Method sendUrgentData() is not supported.");
    }

    @Override // com.android.org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public int serverPSKKeyRequested(String str, String str2, byte[] bArr) {
        return this.sslParameters.serverPSKKeyRequested(str, str2, bArr, this);
    }

    public void setAlpnProtocols(byte[] bArr) {
        if (bArr != null && bArr.length == 0) {
            throw new IllegalArgumentException("alpnProtocols.length == 0");
        }
        this.sslParameters.alpnProtocols = bArr;
    }

    public void setChannelIdEnabled(boolean z) {
        if (getUseClientMode()) {
            throw new IllegalStateException("Client mode");
        }
        synchronized (this.stateLock) {
            if (this.state != 0) {
                throw new IllegalStateException("Could not enable/disable Channel ID after the initial handshake has begun.");
            }
        }
        this.sslParameters.channelIdEnabled = z;
    }

    public void setChannelIdPrivateKey(PrivateKey privateKey) {
        if (!getUseClientMode()) {
            throw new IllegalStateException("Server mode");
        }
        synchronized (this.stateLock) {
            if (this.state != 0) {
                throw new IllegalStateException("Could not change Channel ID private key after the initial handshake has begun.");
            }
        }
        if (privateKey == null) {
            this.sslParameters.channelIdEnabled = false;
            this.channelIdPrivateKey = null;
            return;
        }
        this.sslParameters.channelIdEnabled = true;
        try {
            this.channelIdPrivateKey = OpenSSLKey.fromPrivateKey(privateKey);
        } catch (InvalidKeyException e) {
        }
    }

    @Override // javax.net.ssl.SSLSocket
    public void setEnableSessionCreation(boolean z) {
        this.sslParameters.setEnableSessionCreation(z);
    }

    @Override // javax.net.ssl.SSLSocket
    public void setEnabledCipherSuites(String[] strArr) {
        this.sslParameters.setEnabledCipherSuites(strArr);
    }

    @Override // javax.net.ssl.SSLSocket
    public void setEnabledProtocols(String[] strArr) {
        this.sslParameters.setEnabledProtocols(strArr);
    }

    public void setHandshakeTimeout(int i) throws SocketException {
        this.handshakeTimeoutMilliseconds = i;
    }

    public void setHostname(String str) {
        this.sslParameters.setUseSni(str != null);
        this.peerHostname = str;
    }

    @Override // javax.net.ssl.SSLSocket
    public void setNeedClientAuth(boolean z) {
        this.sslParameters.setNeedClientAuth(z);
    }

    public void setNpnProtocols(byte[] bArr) {
        if (bArr != null && bArr.length == 0) {
            throw new IllegalArgumentException("npnProtocols.length == 0");
        }
        this.sslParameters.npnProtocols = bArr;
    }

    @Override // java.net.Socket
    public void setOOBInline(boolean z) throws SocketException {
        throw new SocketException("Methods sendUrgentData, setOOBInline are not supported.");
    }

    @Override // java.net.Socket
    public void setSoTimeout(int i) throws SocketException {
        super.setSoTimeout(i);
        this.readTimeoutMilliseconds = i;
    }

    public void setSoWriteTimeout(int i) throws SocketException {
        this.writeTimeoutMilliseconds = i;
        Platform.setSocketWriteTimeout(this, i);
    }

    @Override // javax.net.ssl.SSLSocket
    public void setUseClientMode(boolean z) {
        synchronized (this.stateLock) {
            if (this.state != 0) {
                throw new IllegalArgumentException("Could not change the mode after the initial handshake has begun.");
            }
        }
        this.sslParameters.setUseClientMode(z);
    }

    public void setUseSessionTickets(boolean z) {
        this.sslParameters.useSessionTickets = z;
    }

    @Override // javax.net.ssl.SSLSocket
    public void setWantClientAuth(boolean z) {
        this.sslParameters.setWantClientAuth(z);
    }

    /* JADX WARN: Finally extract failed */
    @Override // javax.net.ssl.SSLSocket
    public void startHandshake() throws IOException {
        checkOpen();
        synchronized (this.stateLock) {
            if (this.state == 0) {
                this.state = 1;
                SecureRandom secureRandomMember = this.sslParameters.getSecureRandomMember();
                if (secureRandomMember == null) {
                    NativeCrypto.RAND_load_file("/dev/urandom", 1024L);
                } else {
                    NativeCrypto.RAND_seed(secureRandomMember.generateSeed(1024));
                }
                boolean useClientMode = this.sslParameters.getUseClientMode();
                this.sslNativePointer = 0L;
                try {
                    try {
                        long j = this.sslParameters.getSessionContext().sslCtxNativePointer;
                        this.sslNativePointer = NativeCrypto.SSL_new(j);
                        this.guard.open(LoaderConstants.CLOSE);
                        boolean enableSessionCreation = getEnableSessionCreation();
                        if (!enableSessionCreation) {
                            NativeCrypto.SSL_set_session_creation_enabled(this.sslNativePointer, enableSessionCreation);
                        }
                        OpenSSLSessionImpl sessionToReuse = this.sslParameters.getSessionToReuse(this.sslNativePointer, getHostname(), getPort());
                        this.sslParameters.setSSLParameters(j, this.sslNativePointer, this, this, this.peerHostname);
                        this.sslParameters.setCertificateValidation(this.sslNativePointer);
                        this.sslParameters.setTlsChannelId(this.sslNativePointer, this.channelIdPrivateKey);
                        int soTimeout = getSoTimeout();
                        int soWriteTimeout = getSoWriteTimeout();
                        if (this.handshakeTimeoutMilliseconds >= 0) {
                            setSoTimeout(this.handshakeTimeoutMilliseconds);
                            setSoWriteTimeout(this.handshakeTimeoutMilliseconds);
                        }
                        synchronized (this.stateLock) {
                            if (this.state == 5) {
                                if (1 != 0) {
                                    synchronized (this.stateLock) {
                                        this.state = 5;
                                        this.stateLock.notifyAll();
                                    }
                                    try {
                                        shutdownAndFreeSslNative();
                                        return;
                                    } catch (IOException e) {
                                        return;
                                    }
                                }
                                return;
                            }
                            try {
                                long SSL_do_handshake = NativeCrypto.SSL_do_handshake(this.sslNativePointer, Platform.getFileDescriptor(this.socket), this, getSoTimeout(), useClientMode, this.sslParameters.npnProtocols, useClientMode ? null : this.sslParameters.alpnProtocols);
                                boolean z = false;
                                boolean z2 = this.stateLock;
                                synchronized (z2) {
                                    try {
                                        if (this.state == 2) {
                                            z = true;
                                        } else if (this.state == 5) {
                                            if (1 != 0) {
                                                synchronized (this.stateLock) {
                                                    this.state = 5;
                                                    this.stateLock.notifyAll();
                                                }
                                                try {
                                                    shutdownAndFreeSslNative();
                                                    return;
                                                } catch (IOException e2) {
                                                    return;
                                                }
                                            }
                                        }
                                        this.sslSession = this.sslParameters.setupSession(SSL_do_handshake, this.sslNativePointer, sessionToReuse, getHostname(), getPort(), z);
                                        if (this.handshakeTimeoutMilliseconds >= 0) {
                                            setSoTimeout(soTimeout);
                                            setSoWriteTimeout(soWriteTimeout);
                                        }
                                        if (z) {
                                            notifyHandshakeCompletedListeners();
                                        }
                                        z2 = this.stateLock;
                                        synchronized (z2) {
                                            boolean z3 = true;
                                            try {
                                                z2 = this.state == 5;
                                                if (this.state == 1) {
                                                    boolean z4 = z2;
                                                    this.state = 3;
                                                } else if (this.state == 2) {
                                                    boolean z5 = z2;
                                                    this.state = 4;
                                                }
                                                if (!z2) {
                                                    this.stateLock.notifyAll();
                                                }
                                                z3 = z2;
                                            } catch (Throwable th) {
                                                throw th;
                                            }
                                        }
                                        if (z2) {
                                            synchronized (this.stateLock) {
                                                this.state = 5;
                                                this.stateLock.notifyAll();
                                            }
                                            try {
                                                shutdownAndFreeSslNative();
                                            } catch (IOException e3) {
                                            }
                                        }
                                    } finally {
                                        boolean z6 = z2;
                                    }
                                }
                            } catch (CertificateException e4) {
                                SSLHandshakeException sSLHandshakeException = new SSLHandshakeException(e4.getMessage());
                                sSLHandshakeException.initCause(e4);
                                throw sSLHandshakeException;
                            } catch (SSLException e5) {
                                synchronized (this.stateLock) {
                                    if (this.state != 5) {
                                        if (e5.getMessage().contains("unexpected CCS")) {
                                            Platform.logEvent(String.format("ssl_unexpected_ccs: host=%s", getHostname()));
                                        }
                                        throw e5;
                                    } else if (1 != 0) {
                                        synchronized (this.stateLock) {
                                            this.state = 5;
                                            this.stateLock.notifyAll();
                                            try {
                                                shutdownAndFreeSslNative();
                                            } catch (IOException e6) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } catch (SSLProtocolException e7) {
                        throw ((SSLHandshakeException) new SSLHandshakeException("Handshake failed").initCause(e7));
                    }
                } catch (Throwable th2) {
                    if (1 != 0) {
                        synchronized (this.stateLock) {
                            this.state = 5;
                            this.stateLock.notifyAll();
                            try {
                                shutdownAndFreeSslNative();
                            } catch (IOException e8) {
                            }
                        }
                    }
                    throw th2;
                }
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
                this.handshakeSession = new OpenSSLSessionImpl(j, null, openSSLX509CertificateArr, getHostname(), getPort(), null);
                if (this.sslParameters.getUseClientMode()) {
                    Platform.checkServerTrusted(x509TrustManager, openSSLX509CertificateArr, str, getHostname());
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
}
