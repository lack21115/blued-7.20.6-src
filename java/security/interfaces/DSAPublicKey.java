package java.security.interfaces;

import java.math.BigInteger;
import java.security.PublicKey;

/* loaded from: source-2895416-dex2jar.jar:java/security/interfaces/DSAPublicKey.class */
public interface DSAPublicKey extends DSAKey, PublicKey {
    public static final long serialVersionUID = 1234526332779022332L;

    BigInteger getY();
}
