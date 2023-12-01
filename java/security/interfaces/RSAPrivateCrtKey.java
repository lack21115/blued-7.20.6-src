package java.security.interfaces;

import java.math.BigInteger;

/* loaded from: source-2895416-dex2jar.jar:java/security/interfaces/RSAPrivateCrtKey.class */
public interface RSAPrivateCrtKey extends RSAPrivateKey {
    public static final long serialVersionUID = -5682214253527700368L;

    BigInteger getCrtCoefficient();

    BigInteger getPrimeExponentP();

    BigInteger getPrimeExponentQ();

    BigInteger getPrimeP();

    BigInteger getPrimeQ();

    BigInteger getPublicExponent();
}
