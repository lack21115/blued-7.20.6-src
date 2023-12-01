package java.security.interfaces;

import java.math.BigInteger;
import java.security.PrivateKey;

/* loaded from: source-2895416-dex2jar.jar:java/security/interfaces/ECPrivateKey.class */
public interface ECPrivateKey extends PrivateKey, ECKey {
    public static final long serialVersionUID = -7896394956925609184L;

    BigInteger getS();
}
