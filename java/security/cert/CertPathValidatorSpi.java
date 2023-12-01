package java.security.cert;

import java.security.InvalidAlgorithmParameterException;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/CertPathValidatorSpi.class */
public abstract class CertPathValidatorSpi {
    public abstract CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) throws CertPathValidatorException, InvalidAlgorithmParameterException;
}
