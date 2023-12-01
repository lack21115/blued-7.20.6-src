package javax.crypto.interfaces;

import java.math.BigInteger;
import java.security.PublicKey;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/interfaces/DHPublicKey.class */
public interface DHPublicKey extends DHKey, PublicKey {
    public static final long serialVersionUID = -6628103563352519193L;

    BigInteger getY();
}
