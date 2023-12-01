package org.conscrypt;

import java.math.BigInteger;
import java.security.PublicKey;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/CertBlocklist.class */
public interface CertBlocklist {
    boolean isPublicKeyBlockListed(PublicKey publicKey);

    boolean isSerialNumberBlockListed(BigInteger bigInteger);
}
