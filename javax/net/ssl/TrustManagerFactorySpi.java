package javax.net.ssl;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/TrustManagerFactorySpi.class */
public abstract class TrustManagerFactorySpi {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract TrustManager[] engineGetTrustManagers();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(KeyStore keyStore) throws KeyStoreException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(ManagerFactoryParameters managerFactoryParameters) throws InvalidAlgorithmParameterException;
}
