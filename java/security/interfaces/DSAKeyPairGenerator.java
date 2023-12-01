package java.security.interfaces;

import java.security.InvalidParameterException;
import java.security.SecureRandom;

/* loaded from: source-2895416-dex2jar.jar:java/security/interfaces/DSAKeyPairGenerator.class */
public interface DSAKeyPairGenerator {
    void initialize(int i, boolean z, SecureRandom secureRandom) throws InvalidParameterException;

    void initialize(DSAParams dSAParams, SecureRandom secureRandom) throws InvalidParameterException;
}
