package org.apache.harmony.security.provider.crypto;

import java.security.Provider;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/provider/crypto/CryptoProvider.class */
public final class CryptoProvider extends Provider {
    private static final long serialVersionUID = 7991202868423459598L;

    public CryptoProvider() {
        super("Crypto", 1.0d, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
        put("SecureRandom.SHA1PRNG", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
        put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
    }
}
