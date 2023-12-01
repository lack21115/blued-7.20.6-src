package com.android.org.conscrypt;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLNativeReference.class */
public abstract class OpenSSLNativeReference {
    final long context;

    public OpenSSLNativeReference(long j) {
        if (j == 0) {
            throw new NullPointerException("ctx == 0");
        }
        this.context = j;
    }
}
