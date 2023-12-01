package com.android.org.conscrypt;

import java.io.Serializable;
import java.security.SecureRandomSpi;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLRandom.class */
public class OpenSSLRandom extends SecureRandomSpi implements Serializable {
    private static final long serialVersionUID = 8506210602917522860L;
    private boolean mSeeded;

    public static void seedOpenSSLPRNGFromLinuxRNG() {
        int RAND_load_file = NativeCrypto.RAND_load_file("/dev/urandom", 1024);
        if (RAND_load_file != 1024) {
            throw new SecurityException("Failed to read sufficient bytes from /dev/urandom. Expected: 1024, actual: " + RAND_load_file);
        }
    }

    private void selfSeedIfNotSeeded() {
        if (this.mSeeded) {
            return;
        }
        seedOpenSSLPRNGFromLinuxRNG();
        this.mSeeded = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SecureRandomSpi
    public byte[] engineGenerateSeed(int i) {
        selfSeedIfNotSeeded();
        byte[] bArr = new byte[i];
        NativeCrypto.RAND_bytes(bArr);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SecureRandomSpi
    public void engineNextBytes(byte[] bArr) {
        selfSeedIfNotSeeded();
        NativeCrypto.RAND_bytes(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SecureRandomSpi
    public void engineSetSeed(byte[] bArr) {
        selfSeedIfNotSeeded();
        NativeCrypto.RAND_seed(bArr);
    }
}
