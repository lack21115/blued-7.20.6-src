package java.security;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

/* loaded from: source-2895416-dex2jar.jar:java/security/KeyFactorySpi.class */
public abstract class KeyFactorySpi {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract <T extends KeySpec> T engineGetKeySpec(Key key, Class<T> cls) throws InvalidKeySpecException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Key engineTranslateKey(Key key) throws InvalidKeyException;
}
