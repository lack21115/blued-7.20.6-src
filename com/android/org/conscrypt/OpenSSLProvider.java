package com.android.org.conscrypt;

import java.security.Provider;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLProvider.class */
public final class OpenSSLProvider extends Provider {
    public static final String PROVIDER_NAME = "AndroidOpenSSL";
    private static final long serialVersionUID = 2996752495318905136L;

    public OpenSSLProvider() {
        this(PROVIDER_NAME);
    }

    public OpenSSLProvider(String str) {
        super(str, 1.0d, "Android's OpenSSL-backed security provider");
        Platform.setup();
        new StringBuilder();
        throw new VerifyError("bad dex opcode");
    }
}
