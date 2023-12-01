package com.android.org.conscrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.SecretKey;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLKey.class */
public class OpenSSLKey {
    private final String alias;
    private final long ctx;
    private final OpenSSLEngine engine;
    private final boolean wrapped;

    public OpenSSLKey(long j) {
        this(j, false);
    }

    public OpenSSLKey(long j, OpenSSLEngine openSSLEngine, String str) {
        this.ctx = j;
        this.engine = openSSLEngine;
        this.alias = str;
        this.wrapped = false;
    }

    public OpenSSLKey(long j, boolean z) {
        this.ctx = j;
        this.engine = null;
        this.alias = null;
        this.wrapped = z;
    }

    public static OpenSSLKey fromPrivateKey(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof OpenSSLKeyHolder) {
            return ((OpenSSLKeyHolder) privateKey).getOpenSSLKey();
        }
        String format = privateKey.getFormat();
        if (format == null) {
            return wrapPrivateKey(privateKey);
        }
        if ("PKCS#8".equals(privateKey.getFormat())) {
            if (privateKey.getEncoded() == null) {
                throw new InvalidKeyException("Key encoding is null");
            }
            return new OpenSSLKey(NativeCrypto.d2i_PKCS8_PRIV_KEY_INFO(privateKey.getEncoded()));
        }
        throw new InvalidKeyException("Unknown key format " + format);
    }

    public static OpenSSLKey fromPublicKey(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof OpenSSLKeyHolder) {
            return ((OpenSSLKeyHolder) publicKey).getOpenSSLKey();
        }
        if ("X.509".equals(publicKey.getFormat())) {
            if (publicKey.getEncoded() == null) {
                throw new InvalidKeyException("Key encoding is null");
            }
            return new OpenSSLKey(NativeCrypto.d2i_PUBKEY(publicKey.getEncoded()));
        }
        throw new InvalidKeyException("Unknown key format " + publicKey.getFormat());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PrivateKey getPrivateKey(PKCS8EncodedKeySpec pKCS8EncodedKeySpec, int i) throws InvalidKeySpecException {
        try {
            OpenSSLKey openSSLKey = new OpenSSLKey(NativeCrypto.d2i_PKCS8_PRIV_KEY_INFO(pKCS8EncodedKeySpec.getEncoded()));
            if (NativeCrypto.EVP_PKEY_type(openSSLKey.getPkeyContext()) != i) {
                throw new InvalidKeySpecException("Unexpected key type");
            }
            try {
                return openSSLKey.getPrivateKey();
            } catch (NoSuchAlgorithmException e) {
                throw new InvalidKeySpecException(e);
            }
        } catch (Exception e2) {
            throw new InvalidKeySpecException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PublicKey getPublicKey(X509EncodedKeySpec x509EncodedKeySpec, int i) throws InvalidKeySpecException {
        try {
            OpenSSLKey openSSLKey = new OpenSSLKey(NativeCrypto.d2i_PUBKEY(x509EncodedKeySpec.getEncoded()));
            if (NativeCrypto.EVP_PKEY_type(openSSLKey.getPkeyContext()) != i) {
                throw new InvalidKeySpecException("Unexpected key type");
            }
            try {
                return openSSLKey.getPublicKey();
            } catch (NoSuchAlgorithmException e) {
                throw new InvalidKeySpecException(e);
            }
        } catch (Exception e2) {
            throw new InvalidKeySpecException(e2);
        }
    }

    private static OpenSSLKey wrapPrivateKey(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof RSAPrivateKey) {
            return OpenSSLRSAPrivateKey.wrapPlatformKey((RSAPrivateKey) privateKey);
        }
        if (privateKey instanceof DSAPrivateKey) {
            return OpenSSLDSAPrivateKey.wrapPlatformKey((DSAPrivateKey) privateKey);
        }
        if (privateKey instanceof ECPrivateKey) {
            return OpenSSLECPrivateKey.wrapPlatformKey((ECPrivateKey) privateKey);
        }
        throw new InvalidKeyException("Unknown key type: " + privateKey.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
        if (r0.getEngine() == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            r8 = r0
            r0 = 0
            r9 = r0
            r0 = r6
            r1 = r5
            if (r0 != r1) goto Le
            r0 = 1
            r7 = r0
        Lc:
            r0 = r7
            return r0
        Le:
            r0 = r9
            r7 = r0
            r0 = r6
            boolean r0 = r0 instanceof com.android.org.conscrypt.OpenSSLKey
            if (r0 == 0) goto Lc
            r0 = r6
            com.android.org.conscrypt.OpenSSLKey r0 = (com.android.org.conscrypt.OpenSSLKey) r0
            r6 = r0
            r0 = r5
            long r0 = r0.ctx
            r1 = r6
            long r1 = r1.getPkeyContext()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L2b
            r0 = 1
            return r0
        L2b:
            r0 = r5
            com.android.org.conscrypt.OpenSSLEngine r0 = r0.engine
            if (r0 != 0) goto L4f
            r0 = r9
            r7 = r0
            r0 = r6
            com.android.org.conscrypt.OpenSSLEngine r0 = r0.getEngine()
            if (r0 != 0) goto Lc
        L3c:
            r0 = r5
            long r0 = r0.ctx
            r1 = r6
            long r1 = r1.getPkeyContext()
            int r0 = com.android.org.conscrypt.NativeCrypto.EVP_PKEY_cmp(r0, r1)
            r1 = 1
            if (r0 != r1) goto L7c
            r0 = r8
            r7 = r0
        L4d:
            r0 = r7
            return r0
        L4f:
            r0 = r9
            r7 = r0
            r0 = r5
            com.android.org.conscrypt.OpenSSLEngine r0 = r0.engine
            r1 = r6
            com.android.org.conscrypt.OpenSSLEngine r1 = r1.getEngine()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lc
            r0 = r5
            java.lang.String r0 = r0.alias
            if (r0 == 0) goto L73
            r0 = r5
            java.lang.String r0 = r0.alias
            r1 = r6
            java.lang.String r1 = r1.getAlias()
            boolean r0 = r0.equals(r1)
            return r0
        L73:
            r0 = r6
            java.lang.String r0 = r0.getAlias()
            if (r0 == 0) goto L3c
            r0 = 0
            return r0
        L7c:
            r0 = 0
            r7 = r0
            goto L4d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.org.conscrypt.OpenSSLKey.equals(java.lang.Object):boolean");
    }

    protected void finalize() throws Throwable {
        try {
            if (this.ctx != 0) {
                NativeCrypto.EVP_PKEY_free(this.ctx);
            }
        } finally {
            super.finalize();
        }
    }

    public String getAlias() {
        return this.alias;
    }

    OpenSSLEngine getEngine() {
        return this.engine;
    }

    public long getPkeyContext() {
        return this.ctx;
    }

    public PrivateKey getPrivateKey() throws NoSuchAlgorithmException {
        switch (NativeCrypto.EVP_PKEY_type(this.ctx)) {
            case 6:
                return new OpenSSLRSAPrivateKey(this);
            case 28:
                return new OpenSSLDHPrivateKey(this);
            case 116:
                return new OpenSSLDSAPrivateKey(this);
            case 408:
                return new OpenSSLECPrivateKey(this);
            default:
                throw new NoSuchAlgorithmException("unknown PKEY type");
        }
    }

    public PublicKey getPublicKey() throws NoSuchAlgorithmException {
        switch (NativeCrypto.EVP_PKEY_type(this.ctx)) {
            case 6:
                return new OpenSSLRSAPublicKey(this);
            case 28:
                return new OpenSSLDHPublicKey(this);
            case 116:
                return new OpenSSLDSAPublicKey(this);
            case 408:
                return new OpenSSLECPublicKey(this);
            default:
                throw new NoSuchAlgorithmException("unknown PKEY type");
        }
    }

    public SecretKey getSecretKey(String str) throws NoSuchAlgorithmException {
        switch (NativeCrypto.EVP_PKEY_type(this.ctx)) {
            case NativeCrypto.EVP_PKEY_HMAC /* 855 */:
            case NativeCrypto.EVP_PKEY_CMAC /* 894 */:
                return new OpenSSLSecretKey(str, this);
            default:
                throw new NoSuchAlgorithmException("unknown PKEY type");
        }
    }

    public int hashCode() {
        return ((((int) this.ctx) + 17) * 31) + ((int) (this.engine == null ? 0L : this.engine.getEngineContext()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEngineBased() {
        return this.engine != null;
    }

    public boolean isWrapped() {
        return this.wrapped;
    }
}
