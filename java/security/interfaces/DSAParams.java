package java.security.interfaces;

import java.math.BigInteger;

/* loaded from: source-2895416-dex2jar.jar:java/security/interfaces/DSAParams.class */
public interface DSAParams {
    BigInteger getG();

    BigInteger getP();

    BigInteger getQ();
}
