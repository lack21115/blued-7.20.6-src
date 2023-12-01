package com.android.org.conscrypt;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLDSAKeyFactory.class */
public class OpenSSLDSAKeyFactory extends KeyFactorySpi {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec == null) {
            throw new InvalidKeySpecException("keySpec == null");
        }
        if (keySpec instanceof DSAPrivateKeySpec) {
            return new OpenSSLDSAPrivateKey((DSAPrivateKeySpec) keySpec);
        }
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            return OpenSSLKey.getPrivateKey((PKCS8EncodedKeySpec) keySpec, 116);
        }
        throw new InvalidKeySpecException("Must use DSAPrivateKeySpec or PKCS8EncodedKeySpec; was " + keySpec.getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec == null) {
            throw new InvalidKeySpecException("keySpec == null");
        }
        if (keySpec instanceof DSAPublicKeySpec) {
            return new OpenSSLDSAPublicKey((DSAPublicKeySpec) keySpec);
        }
        if (keySpec instanceof X509EncodedKeySpec) {
            return OpenSSLKey.getPublicKey((X509EncodedKeySpec) keySpec, 116);
        }
        throw new InvalidKeySpecException("Must use DSAPublicKeySpec or X509EncodedKeySpec; was " + keySpec.getClass().getName());
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
        if ("DSA".equals(key.getAlgorithm())) {
            if ((key instanceof DSAPublicKey) && DSAPublicKeySpec.class.isAssignableFrom(cls)) {
                DSAPublicKey dSAPublicKey = (DSAPublicKey) key;
                DSAParams params = dSAPublicKey.getParams();
                return new DSAPublicKeySpec(dSAPublicKey.getY(), params.getP(), params.getQ(), params.getG());
            } else if ((key instanceof PublicKey) && DSAPublicKeySpec.class.isAssignableFrom(cls)) {
                byte[] encoded = key.getEncoded();
                if (!"X.509".equals(key.getFormat()) || encoded == null) {
                    throw new InvalidKeySpecException("Not a valid X.509 encoding");
                }
                DSAPublicKey dSAPublicKey2 = (DSAPublicKey) engineGeneratePublic(new X509EncodedKeySpec(encoded));
                DSAParams params2 = dSAPublicKey2.getParams();
                return new DSAPublicKeySpec(dSAPublicKey2.getY(), params2.getP(), params2.getQ(), params2.getG());
            } else if ((key instanceof DSAPrivateKey) && DSAPrivateKeySpec.class.isAssignableFrom(cls)) {
                DSAPrivateKey dSAPrivateKey = (DSAPrivateKey) key;
                DSAParams params3 = dSAPrivateKey.getParams();
                return new DSAPrivateKeySpec(dSAPrivateKey.getX(), params3.getP(), params3.getQ(), params3.getG());
            } else if ((key instanceof PrivateKey) && DSAPrivateKeySpec.class.isAssignableFrom(cls)) {
                byte[] encoded2 = key.getEncoded();
                if (!"PKCS#8".equals(key.getFormat()) || encoded2 == null) {
                    throw new InvalidKeySpecException("Not a valid PKCS#8 encoding");
                }
                DSAPrivateKey dSAPrivateKey2 = (DSAPrivateKey) engineGeneratePrivate(new PKCS8EncodedKeySpec(encoded2));
                DSAParams params4 = dSAPrivateKey2.getParams();
                return new DSAPrivateKeySpec(dSAPrivateKey2.getX(), params4.getP(), params4.getQ(), params4.getG());
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
        throw new InvalidKeySpecException("Key must be a DSA key");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (key == null) {
            throw new InvalidKeyException("key == null");
        }
        if ((key instanceof OpenSSLDSAPublicKey) || (key instanceof OpenSSLDSAPrivateKey)) {
            return key;
        }
        if (key instanceof DSAPublicKey) {
            DSAPublicKey dSAPublicKey = (DSAPublicKey) key;
            BigInteger y = dSAPublicKey.getY();
            DSAParams params = dSAPublicKey.getParams();
            try {
                return engineGeneratePublic(new DSAPublicKeySpec(y, params.getP(), params.getQ(), params.getG()));
            } catch (InvalidKeySpecException e) {
                throw new InvalidKeyException(e);
            }
        } else if (key instanceof DSAPrivateKey) {
            DSAPrivateKey dSAPrivateKey = (DSAPrivateKey) key;
            BigInteger x = dSAPrivateKey.getX();
            DSAParams params2 = dSAPrivateKey.getParams();
            try {
                return engineGeneratePrivate(new DSAPrivateKeySpec(x, params2.getP(), params2.getQ(), params2.getG()));
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
            throw new InvalidKeyException("Key must be DSA public or private key; was " + key.getClass().getName());
        }
    }
}
