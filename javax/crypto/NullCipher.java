package javax.crypto;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.Provider;
import java.security.SecureRandom;
import org.apache.harmony.crypto.internal.NullCipherSpi;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/NullCipher.class */
public class NullCipher extends Cipher {
    public NullCipher() {
        super(new NullCipherSpi(), (Provider) null, (String) null);
        try {
            init(1, (Key) null, (SecureRandom) null);
        } catch (InvalidKeyException e) {
        }
    }
}
