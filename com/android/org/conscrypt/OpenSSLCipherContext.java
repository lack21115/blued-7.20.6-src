package com.android.org.conscrypt;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipherContext.class */
class OpenSSLCipherContext {
    private final long context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLCipherContext(long j) {
        if (j == 0) {
            throw new NullPointerException("ctx == 0");
        }
        this.context = j;
    }

    protected void finalize() throws Throwable {
        try {
            NativeCrypto.EVP_CIPHER_CTX_free(this.context);
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getContext() {
        return this.context;
    }
}
