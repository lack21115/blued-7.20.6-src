package com.android.org.conscrypt;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLDigestContext.class */
public class OpenSSLDigestContext extends OpenSSLNativeReference {
    public OpenSSLDigestContext(long j) {
        super(j);
    }

    protected void finalize() throws Throwable {
        try {
            NativeCrypto.EVP_MD_CTX_destroy(this.context);
        } finally {
            super.finalize();
        }
    }
}
