package com.android.org.conscrypt;

import com.android.org.conscrypt.util.EmptyArray;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashSet;
import javax.crypto.SecretKey;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/SSLParametersImpl.class */
public class SSLParametersImpl implements Cloneable {
    private static final String KEY_TYPE_DH_DSA = "DH_DSA";
    private static final String KEY_TYPE_DH_RSA = "DH_RSA";
    private static final String KEY_TYPE_DSA = "DSA";
    private static final String KEY_TYPE_EC = "EC";
    private static final String KEY_TYPE_EC_EC = "EC_EC";
    private static final String KEY_TYPE_EC_RSA = "EC_RSA";
    private static final String KEY_TYPE_RSA = "RSA";
    private static volatile SSLParametersImpl defaultParameters;
    private static volatile SecureRandom defaultSecureRandom;
    private static volatile X509KeyManager defaultX509KeyManager;
    private static volatile X509TrustManager defaultX509TrustManager;
    byte[] alpnProtocols;
    boolean channelIdEnabled;
    private final ClientSessionContext clientSessionContext;
    private String[] enabledCipherSuites;
    private String[] enabledProtocols;
    private String endpointIdentificationAlgorithm;
    byte[] npnProtocols;
    private final PSKKeyManager pskKeyManager;
    private SecureRandom secureRandom;
    private final ServerSessionContext serverSessionContext;
    boolean useSessionTickets;
    private Boolean useSni;
    private final X509KeyManager x509KeyManager;
    private final X509TrustManager x509TrustManager;
    private boolean client_mode = true;
    private boolean need_client_auth = false;
    private boolean want_client_auth = false;
    private boolean enable_session_creation = true;

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/SSLParametersImpl$AliasChooser.class */
    public interface AliasChooser {
        String chooseClientAlias(X509KeyManager x509KeyManager, X500Principal[] x500PrincipalArr, String[] strArr);

        String chooseServerAlias(X509KeyManager x509KeyManager, String str);
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/SSLParametersImpl$PSKCallbacks.class */
    public interface PSKCallbacks {
        String chooseClientPSKIdentity(PSKKeyManager pSKKeyManager, String str);

        String chooseServerPSKIdentityHint(PSKKeyManager pSKKeyManager);

        SecretKey getPSKKey(PSKKeyManager pSKKeyManager, String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SSLParametersImpl(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom, ClientSessionContext clientSessionContext, ServerSessionContext serverSessionContext) throws KeyManagementException {
        this.serverSessionContext = serverSessionContext;
        this.clientSessionContext = clientSessionContext;
        if (keyManagerArr == null) {
            this.x509KeyManager = getDefaultX509KeyManager();
            this.pskKeyManager = null;
        } else {
            this.x509KeyManager = findFirstX509KeyManager(keyManagerArr);
            this.pskKeyManager = findFirstPSKKeyManager(keyManagerArr);
        }
        if (trustManagerArr == null) {
            this.x509TrustManager = getDefaultX509TrustManager();
        } else {
            this.x509TrustManager = findFirstX509TrustManager(trustManagerArr);
        }
        this.secureRandom = secureRandom;
        this.enabledProtocols = getDefaultProtocols();
        this.enabledCipherSuites = getDefaultCipherSuites((this.x509KeyManager == null && this.x509TrustManager == null) ? false : true, this.pskKeyManager != null);
    }

    private static String[] concat(String[]... strArr) {
        int i = 0;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                break;
            }
            i += strArr[i3].length;
            i2 = i3 + 1;
        }
        String[] strArr2 = new String[i];
        int i4 = 0;
        int length2 = strArr.length;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= length2) {
                return strArr2;
            }
            String[] strArr3 = strArr[i6];
            System.arraycopy(strArr3, 0, strArr2, i4, strArr3.length);
            i4 += strArr3.length;
            i5 = i6 + 1;
        }
    }

    private static OpenSSLX509Certificate[] createCertChain(long[] jArr) throws IOException {
        OpenSSLX509Certificate[] openSSLX509CertificateArr;
        if (jArr != null) {
            OpenSSLX509Certificate[] openSSLX509CertificateArr2 = new OpenSSLX509Certificate[jArr.length];
            int i = 0;
            while (true) {
                int i2 = i;
                openSSLX509CertificateArr = openSSLX509CertificateArr2;
                if (i2 >= jArr.length) {
                    break;
                }
                openSSLX509CertificateArr2[i2] = new OpenSSLX509Certificate(jArr[i2]);
                i = i2 + 1;
            }
        } else {
            openSSLX509CertificateArr = null;
        }
        return openSSLX509CertificateArr;
    }

    private static X509KeyManager createDefaultX509KeyManager() throws KeyManagementException {
        try {
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(null, null);
            KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();
            X509KeyManager findFirstX509KeyManager = findFirstX509KeyManager(keyManagers);
            if (findFirstX509KeyManager == null) {
                throw new KeyManagementException("No X509KeyManager among default KeyManagers: " + Arrays.toString(keyManagers));
            }
            return findFirstX509KeyManager;
        } catch (KeyStoreException e) {
            throw new KeyManagementException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new KeyManagementException(e2);
        } catch (UnrecoverableKeyException e3) {
            throw new KeyManagementException(e3);
        }
    }

    private static X509TrustManager createDefaultX509TrustManager() throws KeyManagementException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            X509TrustManager findFirstX509TrustManager = findFirstX509TrustManager(trustManagers);
            if (findFirstX509TrustManager == null) {
                throw new KeyManagementException("No X509TrustManager in among default TrustManagers: " + Arrays.toString(trustManagers));
            }
            return findFirstX509TrustManager;
        } catch (KeyStoreException e) {
            throw new KeyManagementException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new KeyManagementException(e2);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [byte[], byte[][]] */
    static byte[][] encodeIssuerX509Principals(X509Certificate[] x509CertificateArr) throws CertificateEncodingException {
        ?? r0 = new byte[x509CertificateArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= x509CertificateArr.length) {
                return r0;
            }
            r0[i2] = x509CertificateArr[i2].getIssuerX500Principal().getEncoded();
            i = i2 + 1;
        }
    }

    private static PSKKeyManager findFirstPSKKeyManager(KeyManager[] keyManagerArr) {
        int length = keyManagerArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            KeyManager keyManager = keyManagerArr[i2];
            if (keyManager instanceof PSKKeyManager) {
                return (PSKKeyManager) keyManager;
            }
            i = i2 + 1;
        }
    }

    private static X509KeyManager findFirstX509KeyManager(KeyManager[] keyManagerArr) {
        int length = keyManagerArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            KeyManager keyManager = keyManagerArr[i2];
            if (keyManager instanceof X509KeyManager) {
                return (X509KeyManager) keyManager;
            }
            i = i2 + 1;
        }
    }

    private static X509TrustManager findFirstX509TrustManager(TrustManager[] trustManagerArr) {
        int length = trustManagerArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            TrustManager trustManager = trustManagerArr[i2];
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
            i = i2 + 1;
        }
    }

    public static String getClientKeyType(byte b) {
        switch (b) {
            case 1:
                return KEY_TYPE_RSA;
            case 2:
                return KEY_TYPE_DSA;
            case 3:
                return KEY_TYPE_DH_RSA;
            case 4:
                return KEY_TYPE_DH_DSA;
            case 64:
                return KEY_TYPE_EC;
            case 65:
                return KEY_TYPE_EC_RSA;
            case 66:
                return KEY_TYPE_EC_EC;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static SSLParametersImpl getDefault() throws KeyManagementException {
        SSLParametersImpl sSLParametersImpl = defaultParameters;
        SSLParametersImpl sSLParametersImpl2 = sSLParametersImpl;
        if (sSLParametersImpl == null) {
            sSLParametersImpl2 = new SSLParametersImpl(null, null, null, new ClientSessionContext(), new ServerSessionContext());
            defaultParameters = sSLParametersImpl2;
        }
        return (SSLParametersImpl) sSLParametersImpl2.clone();
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.String[], java.lang.String[][]] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.String[], java.lang.String[][]] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.String[], java.lang.String[][]] */
    private static String[] getDefaultCipherSuites(boolean z, boolean z2) {
        return z ? z2 ? concat(new String[]{NativeCrypto.DEFAULT_PSK_CIPHER_SUITES, NativeCrypto.DEFAULT_X509_CIPHER_SUITES, new String[]{NativeCrypto.TLS_EMPTY_RENEGOTIATION_INFO_SCSV}}) : concat(new String[]{NativeCrypto.DEFAULT_X509_CIPHER_SUITES, new String[]{NativeCrypto.TLS_EMPTY_RENEGOTIATION_INFO_SCSV}}) : z2 ? concat(new String[]{NativeCrypto.DEFAULT_PSK_CIPHER_SUITES, new String[]{NativeCrypto.TLS_EMPTY_RENEGOTIATION_INFO_SCSV}}) : new String[]{NativeCrypto.TLS_EMPTY_RENEGOTIATION_INFO_SCSV};
    }

    private static String[] getDefaultProtocols() {
        return (String[]) NativeCrypto.DEFAULT_PROTOCOLS.clone();
    }

    private static X509KeyManager getDefaultX509KeyManager() throws KeyManagementException {
        X509KeyManager x509KeyManager = defaultX509KeyManager;
        X509KeyManager x509KeyManager2 = x509KeyManager;
        if (x509KeyManager == null) {
            x509KeyManager2 = createDefaultX509KeyManager();
            defaultX509KeyManager = x509KeyManager2;
        }
        return x509KeyManager2;
    }

    public static X509TrustManager getDefaultX509TrustManager() throws KeyManagementException {
        X509TrustManager x509TrustManager = defaultX509TrustManager;
        X509TrustManager x509TrustManager2 = x509TrustManager;
        if (x509TrustManager == null) {
            x509TrustManager2 = createDefaultX509TrustManager();
            defaultX509TrustManager = x509TrustManager2;
        }
        return x509TrustManager2;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0086 A[PHI: r12 
      PHI: (r12v3 java.lang.String) = (r12v0 java.lang.String), (r12v1 java.lang.String), (r12v2 java.lang.String), (r12v4 java.lang.String) binds: [B:3:0x0012, B:21:0x00c0, B:10:0x008e, B:6:0x0082] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String getServerX509KeyType(long r8) throws javax.net.ssl.SSLException {
        /*
            r0 = 0
            r13 = r0
            r0 = r8
            int r0 = com.android.org.conscrypt.NativeCrypto.get_SSL_CIPHER_algorithm_mkey(r0)
            r10 = r0
            r0 = r8
            int r0 = com.android.org.conscrypt.NativeCrypto.get_SSL_CIPHER_algorithm_auth(r0)
            r11 = r0
            r0 = r13
            r12 = r0
            r0 = r10
            switch(r0) {
                case 1: goto L82;
                case 8: goto L89;
                case 32: goto Lb5;
                case 64: goto Lb8;
                case 128: goto Lbb;
                case 256: goto L86;
                default: goto L4c;
            }
        L4c:
            javax.net.ssl.SSLException r0 = new javax.net.ssl.SSLException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Unsupported key exchange. mkey: 0x"
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r10
            long r3 = (long) r3
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r3 = r3 & r4
            java.lang.String r3 = java.lang.Long.toHexString(r3)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ", auth: 0x"
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r11
            long r3 = (long) r3
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r3 = r3 & r4
            java.lang.String r3 = java.lang.Long.toHexString(r3)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L82:
            java.lang.String r0 = "RSA"
            r12 = r0
        L86:
            r0 = r12
            return r0
        L89:
            r0 = r13
            r12 = r0
            r0 = r11
            switch(r0) {
                case 1: goto Laf;
                case 2: goto Lb2;
                case 3: goto Lac;
                case 4: goto L86;
                default: goto Lac;
            }
        Lac:
            goto L4c
        Laf:
            java.lang.String r0 = "RSA"
            return r0
        Lb2:
            java.lang.String r0 = "DSA"
            return r0
        Lb5:
            java.lang.String r0 = "EC_RSA"
            return r0
        Lb8:
            java.lang.String r0 = "EC_EC"
            return r0
        Lbb:
            r0 = r13
            r12 = r0
            r0 = r11
            switch(r0) {
                case 1: goto Lef;
                case 4: goto L86;
                case 64: goto Lf2;
                case 128: goto L86;
                default: goto Lec;
            }
        Lec:
            goto L4c
        Lef:
            java.lang.String r0 = "RSA"
            return r0
        Lf2:
            java.lang.String r0 = "EC_EC"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.org.conscrypt.SSLParametersImpl.getServerX509KeyType(long):java.lang.String");
    }

    private boolean isSniEnabledByDefault() {
        String property = System.getProperty("jsse.enableSNIExtension", Platform.isSniEnabledByDefault() ? "true" : "false");
        if ("true".equalsIgnoreCase(property)) {
            return true;
        }
        if ("false".equalsIgnoreCase(property)) {
            return false;
        }
        throw new RuntimeException("Can only set \"jsse.enableSNIExtension\" to \"true\" or \"false\"");
    }

    private static boolean isValidSniHostname(String str) {
        return (str == null || str.indexOf(46) == -1 || Platform.isLiteralIpAddress(str)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void chooseClientCertificate(byte[] bArr, byte[][] bArr2, long j, AliasChooser aliasChooser) throws SSLException, CertificateEncodingException {
        X500Principal[] x500PrincipalArr;
        String[] strArr = new String[bArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                break;
            }
            strArr[i2] = getClientKeyType(bArr[i2]);
            i = i2 + 1;
        }
        if (bArr2 != null) {
            X500Principal[] x500PrincipalArr2 = new X500Principal[bArr2.length];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                x500PrincipalArr = x500PrincipalArr2;
                if (i4 >= bArr2.length) {
                    break;
                }
                x500PrincipalArr2[i4] = new X500Principal(bArr2[i4]);
                i3 = i4 + 1;
            }
        } else {
            x500PrincipalArr = null;
        }
        X509KeyManager x509KeyManager = getX509KeyManager();
        setCertificate(j, x509KeyManager != null ? aliasChooser.chooseClientAlias(x509KeyManager, x500PrincipalArr, strArr) : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int clientPSKKeyRequested(String str, byte[] bArr, byte[] bArr2, PSKCallbacks pSKCallbacks) {
        byte[] bytes;
        PSKKeyManager pSKKeyManager = getPSKKeyManager();
        if (pSKKeyManager == null) {
            return 0;
        }
        String chooseClientPSKIdentity = pSKCallbacks.chooseClientPSKIdentity(pSKKeyManager, str);
        if (chooseClientPSKIdentity == null) {
            chooseClientPSKIdentity = "";
            bytes = EmptyArray.BYTE;
        } else if (chooseClientPSKIdentity.isEmpty()) {
            bytes = EmptyArray.BYTE;
        } else {
            try {
                bytes = chooseClientPSKIdentity.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UTF-8 encoding not supported", e);
            }
        }
        if (bytes.length + 1 <= bArr.length) {
            if (bytes.length > 0) {
                System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            }
            bArr[bytes.length] = 0;
            byte[] encoded = pSKCallbacks.getPSKKey(pSKKeyManager, str, chooseClientPSKIdentity).getEncoded();
            if (encoded == null || encoded.length > bArr2.length) {
                return 0;
            }
            System.arraycopy(encoded, 0, bArr2, 0, encoded.length);
            return encoded.length;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    OpenSSLSessionImpl getCachedClientSession(ClientSessionContext clientSessionContext, String str, int i) {
        OpenSSLSessionImpl openSSLSessionImpl;
        boolean z;
        boolean z2;
        if (str == null) {
            openSSLSessionImpl = null;
        } else {
            openSSLSessionImpl = (OpenSSLSessionImpl) clientSessionContext.getSession(str, i);
            if (openSSLSessionImpl == null) {
                return null;
            }
            String protocol = openSSLSessionImpl.getProtocol();
            String[] strArr = this.enabledProtocols;
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                z = false;
                if (i3 >= length) {
                    break;
                } else if (protocol.equals(strArr[i3])) {
                    z = true;
                    break;
                } else {
                    i2 = i3 + 1;
                }
            }
            if (!z) {
                return null;
            }
            String cipherSuite = openSSLSessionImpl.getCipherSuite();
            String[] strArr2 = this.enabledCipherSuites;
            int length2 = strArr2.length;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                z2 = false;
                if (i5 >= length2) {
                    break;
                } else if (cipherSuite.equals(strArr2[i5])) {
                    z2 = true;
                    break;
                } else {
                    i4 = i5 + 1;
                }
            }
            if (!z2) {
                return null;
            }
        }
        return openSSLSessionImpl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ClientSessionContext getClientSessionContext() {
        return this.clientSessionContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getEnableSessionCreation() {
        return this.enable_session_creation;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] getEnabledCipherSuites() {
        return (String[]) this.enabledCipherSuites.clone();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] getEnabledProtocols() {
        return (String[]) this.enabledProtocols.clone();
    }

    public String getEndpointIdentificationAlgorithm() {
        return this.endpointIdentificationAlgorithm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getNeedClientAuth() {
        return this.need_client_auth;
    }

    protected PSKKeyManager getPSKKeyManager() {
        return this.pskKeyManager;
    }

    protected SecureRandom getSecureRandom() {
        if (this.secureRandom != null) {
            return this.secureRandom;
        }
        SecureRandom secureRandom = defaultSecureRandom;
        SecureRandom secureRandom2 = secureRandom;
        if (secureRandom == null) {
            secureRandom2 = new SecureRandom();
            defaultSecureRandom = secureRandom2;
        }
        this.secureRandom = secureRandom2;
        return this.secureRandom;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SecureRandom getSecureRandomMember() {
        return this.secureRandom;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ServerSessionContext getServerSessionContext() {
        return this.serverSessionContext;
    }

    public AbstractSessionContext getSessionContext() {
        return this.client_mode ? this.clientSessionContext : this.serverSessionContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLSessionImpl getSessionToReuse(long j, String str, int i) throws SSLException {
        if (this.client_mode) {
            OpenSSLSessionImpl cachedClientSession = getCachedClientSession(this.clientSessionContext, str, i);
            if (cachedClientSession != null) {
                NativeCrypto.SSL_set_session(j, cachedClientSession.sslSessionNativePointer);
            }
            return cachedClientSession;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getUseClientMode() {
        return this.client_mode;
    }

    protected boolean getUseSni() {
        return this.useSni != null ? this.useSni.booleanValue() : isSniEnabledByDefault();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getWantClientAuth() {
        return this.want_client_auth;
    }

    protected X509KeyManager getX509KeyManager() {
        return this.x509KeyManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public X509TrustManager getX509TrustManager() {
        return this.x509TrustManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int serverPSKKeyRequested(String str, String str2, byte[] bArr, PSKCallbacks pSKCallbacks) {
        byte[] encoded;
        PSKKeyManager pSKKeyManager = getPSKKeyManager();
        if (pSKKeyManager == null || (encoded = pSKCallbacks.getPSKKey(pSKKeyManager, str, str2).getEncoded()) == null || encoded.length > bArr.length) {
            return 0;
        }
        System.arraycopy(encoded, 0, bArr, 0, encoded.length);
        return encoded.length;
    }

    void setCertificate(long j, String str) throws CertificateEncodingException, SSLException {
        X509KeyManager x509KeyManager;
        PrivateKey privateKey;
        X509Certificate[] certificateChain;
        if (str == null || (x509KeyManager = getX509KeyManager()) == null || (privateKey = x509KeyManager.getPrivateKey(str)) == null || (certificateChain = x509KeyManager.getCertificateChain(str)) == null) {
            return;
        }
        OpenSSLX509Certificate[] openSSLX509CertificateArr = new OpenSSLX509Certificate[certificateChain.length];
        long[] jArr = new long[certificateChain.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= certificateChain.length) {
                break;
            }
            OpenSSLX509Certificate fromCertificate = OpenSSLX509Certificate.fromCertificate(certificateChain[i2]);
            openSSLX509CertificateArr[i2] = fromCertificate;
            jArr[i2] = fromCertificate.getContext();
            i = i2 + 1;
        }
        NativeCrypto.SSL_use_certificate(j, jArr);
        try {
            OpenSSLKey fromPrivateKey = OpenSSLKey.fromPrivateKey(privateKey);
            NativeCrypto.SSL_use_PrivateKey(j, fromPrivateKey.getPkeyContext());
            if (fromPrivateKey.isWrapped()) {
                return;
            }
            NativeCrypto.SSL_check_private_key(j);
        } catch (InvalidKeyException e) {
            throw new SSLException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCertificateValidation(long j) throws IOException {
        boolean z;
        X509Certificate[] acceptedIssuers;
        if (this.client_mode) {
            return;
        }
        if (getNeedClientAuth()) {
            NativeCrypto.SSL_set_verify(j, 3);
            z = true;
        } else if (getWantClientAuth()) {
            NativeCrypto.SSL_set_verify(j, 1);
            z = true;
        } else {
            NativeCrypto.SSL_set_verify(j, 0);
            z = false;
        }
        if (!z || (acceptedIssuers = getX509TrustManager().getAcceptedIssuers()) == null || acceptedIssuers.length == 0) {
            return;
        }
        try {
            NativeCrypto.SSL_set_client_CA_list(j, encodeIssuerX509Principals(acceptedIssuers));
        } catch (CertificateEncodingException e) {
            throw new IOException("Problem encoding principals", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setEnableSessionCreation(boolean z) {
        this.enable_session_creation = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setEnabledCipherSuites(String[] strArr) {
        this.enabledCipherSuites = (String[]) NativeCrypto.checkEnabledCipherSuites(strArr).clone();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setEnabledProtocols(String[] strArr) {
        this.enabledProtocols = (String[]) NativeCrypto.checkEnabledProtocols(strArr).clone();
    }

    public void setEndpointIdentificationAlgorithm(String str) {
        this.endpointIdentificationAlgorithm = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNeedClientAuth(boolean z) {
        this.need_client_auth = z;
        this.want_client_auth = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSSLParameters(long j, long j2, AliasChooser aliasChooser, PSKCallbacks pSKCallbacks, String str) throws SSLException, IOException {
        boolean z;
        if (this.npnProtocols != null) {
            NativeCrypto.SSL_CTX_enable_npn(j);
        }
        if (this.client_mode && this.alpnProtocols != null) {
            NativeCrypto.SSL_set_alpn_protos(j2, this.alpnProtocols);
        }
        NativeCrypto.setEnabledProtocols(j2, this.enabledProtocols);
        NativeCrypto.setEnabledCipherSuites(j2, this.enabledCipherSuites);
        if (!this.client_mode) {
            HashSet<String> hashSet = new HashSet();
            long[] SSL_get_ciphers = NativeCrypto.SSL_get_ciphers(j2);
            int length = SSL_get_ciphers.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String serverX509KeyType = getServerX509KeyType(SSL_get_ciphers[i2]);
                if (serverX509KeyType != null) {
                    hashSet.add(serverX509KeyType);
                }
                i = i2 + 1;
            }
            if (getX509KeyManager() != null) {
                for (String str2 : hashSet) {
                    try {
                        setCertificate(j2, aliasChooser.chooseServerAlias(this.x509KeyManager, str2));
                    } catch (CertificateEncodingException e) {
                        throw new IOException(e);
                    }
                }
            }
        }
        PSKKeyManager pSKKeyManager = getPSKKeyManager();
        if (pSKKeyManager != null) {
            String[] strArr = this.enabledCipherSuites;
            int length2 = strArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                z = false;
                if (i4 >= length2) {
                    break;
                }
                String str3 = strArr[i4];
                if (str3 != null && str3.contains("PSK")) {
                    z = true;
                    break;
                }
                i3 = i4 + 1;
            }
            if (z) {
                if (this.client_mode) {
                    NativeCrypto.set_SSL_psk_client_callback_enabled(j2, true);
                } else {
                    NativeCrypto.set_SSL_psk_server_callback_enabled(j2, true);
                    NativeCrypto.SSL_use_psk_identity_hint(j2, pSKCallbacks.chooseServerPSKIdentityHint(pSKKeyManager));
                }
            }
        }
        if (this.useSessionTickets) {
            NativeCrypto.SSL_clear_options(j2, NativeCrypto.SSL_OP_NO_TICKET);
        }
        if (getUseSni() && AddressUtils.isValidSniHostname(str)) {
            NativeCrypto.SSL_set_tlsext_host_name(j2, str);
        }
        NativeCrypto.SSL_set_mode(j2, 256L);
        boolean enableSessionCreation = getEnableSessionCreation();
        if (enableSessionCreation) {
            return;
        }
        NativeCrypto.SSL_set_session_creation_enabled(j2, enableSessionCreation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTlsChannelId(long j, OpenSSLKey openSSLKey) throws SSLHandshakeException, SSLException {
        if (this.channelIdEnabled) {
            if (!this.client_mode) {
                NativeCrypto.SSL_enable_tls_channel_id(j);
            } else if (openSSLKey == null) {
                throw new SSLHandshakeException("Invalid TLS channel ID key specified");
            } else {
                NativeCrypto.SSL_set1_tls_channel_id(j, openSSLKey.getPkeyContext());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUseClientMode(boolean z) {
        this.client_mode = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUseSni(boolean z) {
        this.useSni = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setWantClientAuth(boolean z) {
        this.want_client_auth = z;
        this.need_client_auth = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLSessionImpl setupSession(long j, long j2, OpenSSLSessionImpl openSSLSessionImpl, String str, int i, boolean z) throws IOException {
        byte[] SSL_SESSION_session_id = NativeCrypto.SSL_SESSION_session_id(j);
        if (openSSLSessionImpl != null && Arrays.equals(openSSLSessionImpl.getId(), SSL_SESSION_session_id)) {
            openSSLSessionImpl.lastAccessedTime = System.currentTimeMillis();
            NativeCrypto.SSL_SESSION_free(j);
        } else if (!getEnableSessionCreation()) {
            throw new IllegalStateException("SSL Session may not be created");
        } else {
            OpenSSLSessionImpl openSSLSessionImpl2 = new OpenSSLSessionImpl(j, createCertChain(NativeCrypto.SSL_get_certificate(j2)), createCertChain(NativeCrypto.SSL_get_peer_cert_chain(j2)), str, i, getSessionContext());
            openSSLSessionImpl = openSSLSessionImpl2;
            if (z) {
                getSessionContext().putSession(openSSLSessionImpl2);
                return openSSLSessionImpl2;
            }
        }
        return openSSLSessionImpl;
    }
}
