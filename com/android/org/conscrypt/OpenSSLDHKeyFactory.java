package com.android.org.conscrypt;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import javax.crypto.spec.DHPublicKeySpec;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLDHKeyFactory.class */
public class OpenSSLDHKeyFactory extends KeyFactorySpi {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec == null) {
            throw new InvalidKeySpecException("keySpec == null");
        }
        if (keySpec instanceof DHPrivateKeySpec) {
            return new OpenSSLDHPrivateKey((DHPrivateKeySpec) keySpec);
        }
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            return OpenSSLKey.getPrivateKey((PKCS8EncodedKeySpec) keySpec, 28);
        }
        throw new InvalidKeySpecException("Must use DHPrivateKeySpec or PKCS8EncodedKeySpec; was " + keySpec.getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec == null) {
            throw new InvalidKeySpecException("keySpec == null");
        }
        if (keySpec instanceof DHPublicKeySpec) {
            return new OpenSSLDHPublicKey((DHPublicKeySpec) keySpec);
        }
        if (keySpec instanceof X509EncodedKeySpec) {
            return OpenSSLKey.getPublicKey((X509EncodedKeySpec) keySpec, 28);
        }
        throw new InvalidKeySpecException("Must use DHPublicKeySpec or X509EncodedKeySpec; was " + keySpec.getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.KeyFactorySpi
    public <T extends KeySpec> T engineGetKeySpec(Key key, Class<T> cls) throws InvalidKeySpecException {
        if (key == null) {
            throw new InvalidKeySpecException("key == null");
        }
        if (cls == null) {
            throw new InvalidKeySpecException("keySpec == null");
        }
        if ("DH".equals(key.getAlgorithm())) {
            if ((key instanceof DHPublicKey) && DHPublicKeySpec.class.isAssignableFrom(cls)) {
                DHPublicKey dHPublicKey = (DHPublicKey) key;
                DHParameterSpec params = dHPublicKey.getParams();
                return new DHPublicKeySpec(dHPublicKey.getY(), params.getP(), params.getG());
            } else if ((key instanceof PublicKey) && DHPublicKeySpec.class.isAssignableFrom(cls)) {
                byte[] encoded = key.getEncoded();
                if (!"X.509".equals(key.getFormat()) || encoded == null) {
                    throw new InvalidKeySpecException("Not a valid X.509 encoding");
                }
                DHPublicKey dHPublicKey2 = (DHPublicKey) engineGeneratePublic(new X509EncodedKeySpec(encoded));
                DHParameterSpec params2 = dHPublicKey2.getParams();
                return new DHPublicKeySpec(dHPublicKey2.getY(), params2.getP(), params2.getG());
            } else if ((key instanceof DHPrivateKey) && DHPrivateKeySpec.class.isAssignableFrom(cls)) {
                DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
                DHParameterSpec params3 = dHPrivateKey.getParams();
                return new DHPrivateKeySpec(dHPrivateKey.getX(), params3.getP(), params3.getG());
            } else if ((key instanceof PrivateKey) && DHPrivateKeySpec.class.isAssignableFrom(cls)) {
                byte[] encoded2 = key.getEncoded();
                if (!"PKCS#8".equals(key.getFormat()) || encoded2 == null) {
                    throw new InvalidKeySpecException("Not a valid PKCS#8 encoding");
                }
                DHPrivateKey dHPrivateKey2 = (DHPrivateKey) engineGeneratePrivate(new PKCS8EncodedKeySpec(encoded2));
                DHParameterSpec params4 = dHPrivateKey2.getParams();
                return new DHPrivateKeySpec(dHPrivateKey2.getX(), params4.getP(), params4.getG());
            } else if ((key instanceof PrivateKey) && PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                byte[] encoded3 = key.getEncoded();
                if ("PKCS#8".equals(key.getFormat())) {
                    if (encoded3 == null) {
                        throw new InvalidKeySpecException("Key is not encodable");
                    }
                    return new PKCS8EncodedKeySpec(encoded3);
                }
                throw new InvalidKeySpecException("Encoding type must be PKCS#8; was " + key.getFormat());
            } else if ((key instanceof PublicKey) && X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                byte[] encoded4 = key.getEncoded();
                if ("X.509".equals(key.getFormat())) {
                    if (encoded4 == null) {
                        throw new InvalidKeySpecException("Key is not encodable");
                    }
                    return new X509EncodedKeySpec(encoded4);
                }
                throw new InvalidKeySpecException("Encoding type must be X.509; was " + key.getFormat());
            } else {
                throw new InvalidKeySpecException("Unsupported key type and key spec combination; key=" + key.getClass().getName() + ", keySpec=" + cls.getName());
            }
        }
        throw new InvalidKeySpecException("Key must be a DH key");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (key == null) {
            throw new InvalidKeyException("key == null");
        }
        if ((key instanceof OpenSSLDHPublicKey) || (key instanceof OpenSSLDHPrivateKey)) {
            return key;
        }
        if (key instanceof DHPublicKey) {
            DHPublicKey dHPublicKey = (DHPublicKey) key;
            BigInteger y = dHPublicKey.getY();
            DHParameterSpec params = dHPublicKey.getParams();
            try {
                return engineGeneratePublic(new DHPublicKeySpec(y, params.getP(), params.getG()));
            } catch (InvalidKeySpecException e) {
                throw new InvalidKeyException(e);
            }
        } else if (key instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            BigInteger x = dHPrivateKey.getX();
            DHParameterSpec params2 = dHPrivateKey.getParams();
            try {
                return engineGeneratePrivate(new DHPrivateKeySpec(x, params2.getP(), params2.getG()));
            } catch (InvalidKeySpecException e2) {
                throw new InvalidKeyException(e2);
            }
        } else if ((key instanceof PrivateKey) && "PKCS#8".equals(key.getFormat())) {
            byte[] encoded = key.getEncoded();
            if (encoded == null) {
                throw new InvalidKeyException("Key does not support encoding");
            }
            try {
                return engineGeneratePrivate(new PKCS8EncodedKeySpec(encoded));
            } catch (InvalidKeySpecException e3) {
                throw new InvalidKeyException(e3);
            }
        } else if ((key instanceof PublicKey) && "X.509".equals(key.getFormat())) {
            byte[] encoded2 = key.getEncoded();
            if (encoded2 == null) {
                throw new InvalidKeyException("Key does not support encoding");
            }
            try {
                return engineGeneratePublic(new X509EncodedKeySpec(encoded2));
            } catch (InvalidKeySpecException e4) {
                throw new InvalidKeyException(e4);
            }
        } else {
            throw new InvalidKeyException("Key must be DH public or private key; was " + key.getClass().getName());
        }
    }
}
