package java.security.cert;

import java.security.InvalidAlgorithmParameterException;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/CertPathBuilderSpi.class */
public abstract class CertPathBuilderSpi {
    public abstract CertPathBuilderResult engineBuild(CertPathParameters certPathParameters) throws CertPathBuilderException, InvalidAlgorithmParameterException;
}
