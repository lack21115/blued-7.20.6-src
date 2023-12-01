package javax.net.ssl;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/KeyManagerFactorySpi.class */
public abstract class KeyManagerFactorySpi {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract KeyManager[] engineGetKeyManagers();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(KeyStore keyStore, char[] cArr) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(ManagerFactoryParameters managerFactoryParameters) throws InvalidAlgorithmParameterException;
}
