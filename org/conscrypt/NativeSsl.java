package org.conscrypt;

import com.sensetime.stmobile.STMobileHumanActionNative;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.X509KeyManager;
import javax.security.auth.x500.X500Principal;
import org.conscrypt.NativeCrypto;
import org.conscrypt.SSLParametersImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/NativeSsl.class */
public final class NativeSsl {
    private final SSLParametersImpl.AliasChooser aliasChooser;
    private final NativeCrypto.SSLHandshakeCallbacks handshakeCallbacks;
    private X509Certificate[] localCertificates;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final SSLParametersImpl parameters;
    private final SSLParametersImpl.PSKCallbacks pskCallbacks;
    private volatile long ssl;

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/NativeSsl$BioWrapper.class */
    final class BioWrapper {
        private volatile long bio;

        private BioWrapper() throws SSLException {
            this.bio = NativeCrypto.SSL_BIO_new(NativeSsl.this.ssl, NativeSsl.this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void close() {
            long j = this.bio;
            this.bio = 0L;
            NativeCrypto.BIO_free_all(j);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getPendingWrittenBytes() {
            if (this.bio != 0) {
                return NativeCrypto.SSL_pending_written_bytes_in_BIO(this.bio);
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int readDirectByteBuffer(long j, int i) throws IOException {
            return NativeCrypto.ENGINE_SSL_read_BIO_direct(NativeSsl.this.ssl, NativeSsl.this, this.bio, j, i, NativeSsl.this.handshakeCallbacks);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int writeDirectByteBuffer(long j, int i) throws IOException {
            return NativeCrypto.ENGINE_SSL_write_BIO_direct(NativeSsl.this.ssl, NativeSsl.this, this.bio, j, i, NativeSsl.this.handshakeCallbacks);
        }
    }

    private NativeSsl(long j, SSLParametersImpl sSLParametersImpl, NativeCrypto.SSLHandshakeCallbacks sSLHandshakeCallbacks, SSLParametersImpl.AliasChooser aliasChooser, SSLParametersImpl.PSKCallbacks pSKCallbacks) {
        this.ssl = j;
        this.parameters = sSLParametersImpl;
        this.handshakeCallbacks = sSLHandshakeCallbacks;
        this.aliasChooser = aliasChooser;
        this.pskCallbacks = pSKCallbacks;
    }

    private void enablePSKKeyManagerIfRequested() throws SSLException {
        boolean z;
        PSKKeyManager pSKKeyManager = this.parameters.getPSKKeyManager();
        if (pSKKeyManager != null) {
            String[] strArr = this.parameters.enabledCipherSuites;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                z = false;
                if (i2 < length) {
                    String str = strArr[i2];
                    if (str != null && str.contains("PSK")) {
                        z = true;
                        break;
                    }
                    i = i2 + 1;
                } else {
                    break;
                }
            }
            if (z) {
                if (isClient()) {
                    NativeCrypto.set_SSL_psk_client_callback_enabled(this.ssl, this, true);
                    return;
                }
                NativeCrypto.set_SSL_psk_server_callback_enabled(this.ssl, this, true);
                NativeCrypto.SSL_use_psk_identity_hint(this.ssl, this, this.pskCallbacks.chooseServerPSKIdentityHint(pSKKeyManager));
            }
        }
    }

    private Set<String> getCipherKeyTypes() {
        HashSet hashSet = new HashSet();
        long[] SSL_get_ciphers = NativeCrypto.SSL_get_ciphers(this.ssl, this);
        int length = SSL_get_ciphers.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return hashSet;
            }
            String serverX509KeyType = SSLUtils.getServerX509KeyType(SSL_get_ciphers[i2]);
            if (serverX509KeyType != null) {
                hashSet.add(serverX509KeyType);
            }
            i = i2 + 1;
        }
    }

    private boolean isClient() {
        return this.parameters.getUseClientMode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NativeSsl newInstance(SSLParametersImpl sSLParametersImpl, NativeCrypto.SSLHandshakeCallbacks sSLHandshakeCallbacks, SSLParametersImpl.AliasChooser aliasChooser, SSLParametersImpl.PSKCallbacks pSKCallbacks) throws SSLException {
        AbstractSessionContext sessionContext = sSLParametersImpl.getSessionContext();
        return new NativeSsl(NativeCrypto.SSL_new(sessionContext.sslCtxNativePointer, sessionContext), sSLParametersImpl, sSLHandshakeCallbacks, aliasChooser, pSKCallbacks);
    }

    /* JADX WARN: Type inference failed for: r0v18, types: [byte[], byte[][]] */
    private void setCertificate(String str) throws CertificateEncodingException, SSLException {
        X509KeyManager x509KeyManager;
        PrivateKey privateKey;
        if (str == null || (x509KeyManager = this.parameters.getX509KeyManager()) == null || (privateKey = x509KeyManager.getPrivateKey(str)) == null) {
            return;
        }
        X509Certificate[] certificateChain = x509KeyManager.getCertificateChain(str);
        this.localCertificates = certificateChain;
        if (certificateChain == null) {
            return;
        }
        int length = certificateChain.length;
        PublicKey publicKey = length > 0 ? certificateChain[0].getPublicKey() : null;
        ?? r0 = new byte[length];
        for (int i = 0; i < length; i++) {
            r0[i] = this.localCertificates[i].getEncoded();
        }
        try {
            NativeCrypto.setLocalCertsAndPrivateKey(this.ssl, this, r0, OpenSSLKey.fromPrivateKeyForTLSStackOnly(privateKey, publicKey).getNativeRef());
        } catch (InvalidKeyException e) {
            throw new SSLException(e);
        }
    }

    private void setCertificateValidation() throws SSLException {
        X509Certificate[] acceptedIssuers;
        if (isClient()) {
            return;
        }
        boolean z = false;
        if (this.parameters.getNeedClientAuth()) {
            NativeCrypto.SSL_set_verify(this.ssl, this, 3);
        } else if (!this.parameters.getWantClientAuth()) {
            NativeCrypto.SSL_set_verify(this.ssl, this, 0);
            if (z || (acceptedIssuers = this.parameters.getX509TrustManager().getAcceptedIssuers()) == null || acceptedIssuers.length == 0) {
                return;
            }
            try {
                NativeCrypto.SSL_set_client_CA_list(this.ssl, this, SSLUtils.encodeSubjectX509Principals(acceptedIssuers));
                return;
            } catch (CertificateEncodingException e) {
                throw new SSLException("Problem encoding principals", e);
            }
        } else {
            NativeCrypto.SSL_set_verify(this.ssl, this, 1);
        }
        z = true;
        if (z) {
        }
    }

    private void setTlsChannelId(OpenSSLKey openSSLKey) throws SSLException {
        if (this.parameters.channelIdEnabled) {
            if (!this.parameters.getUseClientMode()) {
                NativeCrypto.SSL_enable_tls_channel_id(this.ssl, this);
            } else if (openSSLKey == null) {
                throw new SSLHandshakeException("Invalid TLS channel ID key specified");
            } else {
                NativeCrypto.SSL_set1_tls_channel_id(this.ssl, this, openSSLKey.getNativeRef());
            }
        }
    }

    private void verifyWithSniMatchers(String str) throws SSLHandshakeException {
        if (AddressUtils.isValidSniHostname(str) && !Platform.serverNamePermitted(this.parameters, str)) {
            throw new SSLHandshakeException("SNI match failed: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void chooseClientCertificate(byte[] bArr, int[] iArr, byte[][] bArr2) throws SSLException, CertificateEncodingException {
        X500Principal[] x500PrincipalArr;
        Set<String> supportedClientKeyTypes = SSLUtils.getSupportedClientKeyTypes(bArr, iArr);
        String[] strArr = (String[]) supportedClientKeyTypes.toArray(new String[supportedClientKeyTypes.size()]);
        String str = null;
        if (bArr2 != null) {
            X500Principal[] x500PrincipalArr2 = new X500Principal[bArr2.length];
            int i = 0;
            while (true) {
                int i2 = i;
                x500PrincipalArr = x500PrincipalArr2;
                if (i2 >= bArr2.length) {
                    break;
                }
                x500PrincipalArr2[i2] = new X500Principal(bArr2[i2]);
                i = i2 + 1;
            }
        } else {
            x500PrincipalArr = null;
        }
        X509KeyManager x509KeyManager = this.parameters.getX509KeyManager();
        if (x509KeyManager != null) {
            str = this.aliasChooser.chooseClientAlias(x509KeyManager, x500PrincipalArr, strArr);
        }
        setCertificate(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int clientPSKKeyRequested(String str, byte[] bArr, byte[] bArr2) {
        byte[] bytes;
        PSKKeyManager pSKKeyManager = this.parameters.getPSKKeyManager();
        if (pSKKeyManager == null) {
            return 0;
        }
        String chooseClientPSKIdentity = this.pskCallbacks.chooseClientPSKIdentity(pSKKeyManager, str);
        if (chooseClientPSKIdentity == null) {
            bytes = EmptyArray.BYTE;
            chooseClientPSKIdentity = "";
        } else if (chooseClientPSKIdentity.isEmpty()) {
            bytes = EmptyArray.BYTE;
        } else {
            try {
                bytes = chooseClientPSKIdentity.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UTF-8 encoding not supported", e);
            }
        }
        if (bytes.length + 1 > bArr.length) {
            return 0;
        }
        if (bytes.length > 0) {
            System.arraycopy((Object) bytes, 0, (Object) bArr, 0, bytes.length);
        }
        bArr[bytes.length] = 0;
        byte[] encoded = this.pskCallbacks.getPSKKey(pSKKeyManager, str, chooseClientPSKIdentity).getEncoded();
        if (encoded != null && encoded.length <= bArr2.length) {
            System.arraycopy((Object) encoded, 0, (Object) bArr2, 0, encoded.length);
            return encoded.length;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close() {
        this.lock.writeLock().lock();
        try {
            if (!isClosed()) {
                long j = this.ssl;
                this.ssl = 0L;
                NativeCrypto.SSL_free(j, this);
            }
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void configureServerCertificate() throws IOException {
        X509KeyManager x509KeyManager;
        verifyWithSniMatchers(getRequestedServerName());
        if (isClient() || (x509KeyManager = this.parameters.getX509KeyManager()) == null) {
            return;
        }
        for (String str : getCipherKeyTypes()) {
            try {
                setCertificate(this.aliasChooser.chooseServerAlias(x509KeyManager, str));
            } catch (CertificateEncodingException e) {
                throw new IOException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int doHandshake() throws IOException {
        this.lock.readLock().lock();
        try {
            return NativeCrypto.ENGINE_SSL_do_handshake(this.ssl, this, this.handshakeCallbacks);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doHandshake(FileDescriptor fileDescriptor, int i) throws CertificateException, IOException {
        this.lock.readLock().lock();
        try {
            if (isClosed() || fileDescriptor == null || !fileDescriptor.valid()) {
                throw new SocketException("Socket is closed");
            }
            NativeCrypto.SSL_do_handshake(this.ssl, this, fileDescriptor, this.handshakeCallbacks, i);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] exportKeyingMaterial(String str, byte[] bArr, int i) throws SSLException {
        if (str != null) {
            return NativeCrypto.SSL_export_keying_material(this.ssl, this, str.getBytes(Charset.forName("US-ASCII")), bArr, i);
        }
        throw new NullPointerException("Label is null");
    }

    protected final void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void forceRead() throws IOException {
        this.lock.readLock().lock();
        try {
            NativeCrypto.ENGINE_SSL_force_read(this.ssl, this, this.handshakeCallbacks);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getApplicationProtocol() {
        return NativeCrypto.getApplicationProtocol(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getCipherSuite() {
        return NativeCrypto.cipherSuiteToJava(NativeCrypto.SSL_get_current_cipher(this.ssl, this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getError(int i) {
        return NativeCrypto.SSL_get_error(this.ssl, this, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public X509Certificate[] getLocalCertificates() {
        return this.localCertificates;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMaxSealOverhead() {
        return NativeCrypto.SSL_max_seal_overhead(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getPeerCertificateOcspData() {
        return NativeCrypto.SSL_get_ocsp_response(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public X509Certificate[] getPeerCertificates() throws CertificateException {
        byte[][] SSL_get0_peer_certificates = NativeCrypto.SSL_get0_peer_certificates(this.ssl, this);
        if (SSL_get0_peer_certificates == null) {
            return null;
        }
        return SSLUtils.decodeX509CertificateChain(SSL_get0_peer_certificates);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getPeerTlsSctData() {
        return NativeCrypto.SSL_get_signed_cert_timestamp_list(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPendingReadableBytes() {
        this.lock.readLock().lock();
        try {
            int SSL_pending_readable_bytes = !isClosed() ? NativeCrypto.SSL_pending_readable_bytes(this.ssl, this) : 0;
            this.lock.readLock().unlock();
            return SSL_pending_readable_bytes;
        } catch (Throwable th) {
            this.lock.readLock().unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getRequestedServerName() {
        return NativeCrypto.SSL_get_servername(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getSessionId() {
        return NativeCrypto.SSL_session_id(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getTime() {
        return NativeCrypto.SSL_get_time(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getTimeout() {
        return NativeCrypto.SSL_get_timeout(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getTlsChannelId() throws SSLException {
        return NativeCrypto.SSL_get_tls_channel_id(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getTlsUnique() {
        return NativeCrypto.SSL_get_tls_unique(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getVersion() {
        return NativeCrypto.SSL_get_version(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initialize(String str, OpenSSLKey openSSLKey) throws IOException {
        if (!this.parameters.getEnableSessionCreation()) {
            NativeCrypto.SSL_set_session_creation_enabled(this.ssl, this, false);
        }
        NativeCrypto.SSL_accept_renegotiations(this.ssl, this);
        if (isClient()) {
            NativeCrypto.SSL_set_connect_state(this.ssl, this);
            NativeCrypto.SSL_enable_ocsp_stapling(this.ssl, this);
            if (this.parameters.isCTVerificationEnabled(str)) {
                NativeCrypto.SSL_enable_signed_cert_timestamps(this.ssl, this);
            }
        } else {
            NativeCrypto.SSL_set_accept_state(this.ssl, this);
            if (this.parameters.getOCSPResponse() != null) {
                NativeCrypto.SSL_enable_ocsp_stapling(this.ssl, this);
            }
        }
        if (this.parameters.getEnabledProtocols().length == 0 && this.parameters.isEnabledProtocolsFiltered) {
            throw new SSLHandshakeException("No enabled protocols; SSLv3 is no longer supported and was filtered from the list");
        }
        NativeCrypto.setEnabledProtocols(this.ssl, this, this.parameters.enabledProtocols);
        NativeCrypto.setEnabledCipherSuites(this.ssl, this, this.parameters.enabledCipherSuites, this.parameters.enabledProtocols);
        if (this.parameters.applicationProtocols.length > 0) {
            NativeCrypto.setApplicationProtocols(this.ssl, this, isClient(), this.parameters.applicationProtocols);
        }
        if (!isClient() && this.parameters.applicationProtocolSelector != null) {
            NativeCrypto.setHasApplicationProtocolSelector(this.ssl, this, true);
        }
        if (!isClient()) {
            NativeCrypto.SSL_set_options(this.ssl, this, STMobileHumanActionNative.ST_MOBILE_HAND_666);
            if (this.parameters.sctExtension != null) {
                NativeCrypto.SSL_set_signed_cert_timestamp_list(this.ssl, this, this.parameters.sctExtension);
            }
            if (this.parameters.ocspResponse != null) {
                NativeCrypto.SSL_set_ocsp_response(this.ssl, this, this.parameters.ocspResponse);
            }
        }
        enablePSKKeyManagerIfRequested();
        if (this.parameters.useSessionTickets) {
            NativeCrypto.SSL_clear_options(this.ssl, this, 16384L);
        } else {
            NativeCrypto.SSL_set_options(this.ssl, this, NativeCrypto.SSL_get_options(this.ssl, this) | 16384);
        }
        if (this.parameters.getUseSni() && AddressUtils.isValidSniHostname(str)) {
            NativeCrypto.SSL_set_tlsext_host_name(this.ssl, this, str);
        }
        NativeCrypto.SSL_set_mode(this.ssl, this, 256L);
        setCertificateValidation();
        setTlsChannelId(openSSLKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void interrupt() {
        NativeCrypto.SSL_interrupt(this.ssl, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isClosed() {
        return this.ssl == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BioWrapper newBio() {
        try {
            return new BioWrapper();
        } catch (SSLException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void offerToResumeSession(long j) throws SSLException {
        NativeCrypto.SSL_set_session(this.ssl, this, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int read(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, int i3) throws IOException {
        this.lock.readLock().lock();
        try {
            if (isClosed() || fileDescriptor == null || !fileDescriptor.valid()) {
                throw new SocketException("Socket is closed");
            }
            return NativeCrypto.SSL_read(this.ssl, this, fileDescriptor, this.handshakeCallbacks, bArr, i, i2, i3);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int readDirectByteBuffer(long j, int i) throws IOException, CertificateException {
        this.lock.readLock().lock();
        try {
            return NativeCrypto.ENGINE_SSL_read_direct(this.ssl, this, j, i, this.handshakeCallbacks);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int serverPSKKeyRequested(String str, String str2, byte[] bArr) {
        byte[] encoded;
        PSKKeyManager pSKKeyManager = this.parameters.getPSKKeyManager();
        if (pSKKeyManager == null || (encoded = this.pskCallbacks.getPSKKey(pSKKeyManager, str, str2).getEncoded()) == null || encoded.length > bArr.length) {
            return 0;
        }
        System.arraycopy((Object) encoded, 0, (Object) bArr, 0, encoded.length);
        return encoded.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTimeout(long j) {
        NativeCrypto.SSL_set_timeout(this.ssl, this, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void shutdown() throws IOException {
        this.lock.readLock().lock();
        try {
            NativeCrypto.ENGINE_SSL_shutdown(this.ssl, this, this.handshakeCallbacks);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void shutdown(FileDescriptor fileDescriptor) throws IOException {
        NativeCrypto.SSL_shutdown(this.ssl, this, fileDescriptor, this.handshakeCallbacks);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean wasShutdownReceived() {
        this.lock.readLock().lock();
        try {
            boolean z = (NativeCrypto.SSL_get_shutdown(this.ssl, this) & 2) != 0;
            this.lock.readLock().unlock();
            return z;
        } catch (Throwable th) {
            this.lock.readLock().unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean wasShutdownSent() {
        this.lock.readLock().lock();
        try {
            boolean z = true;
            if ((NativeCrypto.SSL_get_shutdown(this.ssl, this) & 1) == 0) {
                z = false;
            }
            this.lock.readLock().unlock();
            return z;
        } catch (Throwable th) {
            this.lock.readLock().unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void write(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, int i3) throws IOException {
        this.lock.readLock().lock();
        try {
            if (isClosed() || fileDescriptor == null || !fileDescriptor.valid()) {
                throw new SocketException("Socket is closed");
            }
            NativeCrypto.SSL_write(this.ssl, this, fileDescriptor, this.handshakeCallbacks, bArr, i, i2, i3);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int writeDirectByteBuffer(long j, int i) throws IOException {
        this.lock.readLock().lock();
        try {
            return NativeCrypto.ENGINE_SSL_write_direct(this.ssl, this, j, i, this.handshakeCallbacks);
        } finally {
            this.lock.readLock().unlock();
        }
    }
}
