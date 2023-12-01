package android.security;

import java.security.Provider;

/* loaded from: source-9557208-dex2jar.jar:android/security/AndroidKeyStoreProvider.class */
public class AndroidKeyStoreProvider extends Provider {
    public static final String PROVIDER_NAME = "AndroidKeyStore";

    public AndroidKeyStoreProvider() {
        super("AndroidKeyStore", 1.0d, "Android KeyStore security provider");
        put("KeyStore.AndroidKeyStore", AndroidKeyStore.class.getName());
        put("KeyPairGenerator.RSA", AndroidKeyPairGenerator.class.getName());
    }
}
