package javax.crypto.interfaces;

import javax.crypto.SecretKey;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/interfaces/PBEKey.class */
public interface PBEKey extends SecretKey {
    public static final long serialVersionUID = -1430015993304333921L;

    int getIterationCount();

    char[] getPassword();

    byte[] getSalt();
}
