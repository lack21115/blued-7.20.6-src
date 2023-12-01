package org.conscrypt;

import java.io.Serializable;
import java.security.SecureRandomSpi;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLRandom.class */
public final class OpenSSLRandom extends SecureRandomSpi implements Serializable {
    private static final long serialVersionUID = 8506210602917522861L;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SecureRandomSpi
    public byte[] engineGenerateSeed(int i) {
        byte[] bArr = new byte[i];
        NativeCrypto.RAND_bytes(bArr);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SecureRandomSpi
    public void engineNextBytes(byte[] bArr) {
        NativeCrypto.RAND_bytes(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SecureRandomSpi
    public void engineSetSeed(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("seed == null");
        }
    }
}
