package com.android.org.conscrypt;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLRSAKeyFactory.class */
public class OpenSSLRSAKeyFactory extends KeyFactorySpi {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec == null) {
            throw new InvalidKeySpecException("keySpec == null");
        }
        if (keySpec instanceof RSAPrivateCrtKeySpec) {
            return new OpenSSLRSAPrivateCrtKey((RSAPrivateCrtKeySpec) keySpec);
        }
        if (keySpec instanceof RSAPrivateKeySpec) {
            return new OpenSSLRSAPrivateKey((RSAPrivateKeySpec) keySpec);
        }
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            return OpenSSLKey.getPrivateKey((PKCS8EncodedKeySpec) keySpec, 6);
        }
        throw new InvalidKeySpecException("Must use RSAPublicKeySpec or PKCS8EncodedKeySpec; was " + keySpec.getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec == null) {
            throw new InvalidKeySpecException("keySpec == null");
        }
        if (keySpec instanceof RSAPublicKeySpec) {
            return new OpenSSLRSAPublicKey((RSAPublicKeySpec) keySpec);
        }
        if (keySpec instanceof X509EncodedKeySpec) {
            return OpenSSLKey.getPublicKey((X509EncodedKeySpec) keySpec, 6);
        }
        throw new InvalidKeySpecException("Must use RSAPublicKeySpec or X509EncodedKeySpec; was " + keySpec.getClass().getName());
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
        if ("RSA".equals(key.getAlgorithm())) {
            if ((key instanceof RSAPublicKey) && RSAPublicKeySpec.class.isAssignableFrom(cls)) {
                RSAPublicKey rSAPublicKey = (RSAPublicKey) key;
                return new RSAPublicKeySpec(rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent());
            } else if ((key instanceof PublicKey) && RSAPublicKeySpec.class.isAssignableFrom(cls)) {
                byte[] encoded = key.getEncoded();
                if (!"X.509".equals(key.getFormat()) || encoded == null) {
                    throw new InvalidKeySpecException("Not a valid X.509 encoding");
                }
                RSAPublicKey rSAPublicKey2 = (RSAPublicKey) engineGeneratePublic(new X509EncodedKeySpec(encoded));
                return new RSAPublicKeySpec(rSAPublicKey2.getModulus(), rSAPublicKey2.getPublicExponent());
            } else if ((key instanceof RSAPrivateCrtKey) && RSAPrivateCrtKeySpec.class.isAssignableFrom(cls)) {
                RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) key;
                return new RSAPrivateCrtKeySpec(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent(), rSAPrivateCrtKey.getPrivateExponent(), rSAPrivateCrtKey.getPrimeP(), rSAPrivateCrtKey.getPrimeQ(), rSAPrivateCrtKey.getPrimeExponentP(), rSAPrivateCrtKey.getPrimeExponentQ(), rSAPrivateCrtKey.getCrtCoefficient());
            } else if ((key instanceof RSAPrivateCrtKey) && RSAPrivateKeySpec.class.isAssignableFrom(cls)) {
                RSAPrivateCrtKey rSAPrivateCrtKey2 = (RSAPrivateCrtKey) key;
                return new RSAPrivateKeySpec(rSAPrivateCrtKey2.getModulus(), rSAPrivateCrtKey2.getPrivateExponent());
            } else if ((key instanceof RSAPrivateKey) && RSAPrivateKeySpec.class.isAssignableFrom(cls)) {
                RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) key;
                return new RSAPrivateKeySpec(rSAPrivateKey.getModulus(), rSAPrivateKey.getPrivateExponent());
            } else if ((key instanceof PrivateKey) && RSAPrivateCrtKeySpec.class.isAssignableFrom(cls)) {
                byte[] encoded2 = key.getEncoded();
                if (!"PKCS#8".equals(key.getFormat()) || encoded2 == null) {
                    throw new InvalidKeySpecException("Not a valid PKCS#8 encoding");
                }
                RSAPrivateKey rSAPrivateKey2 = (RSAPrivateKey) engineGeneratePrivate(new PKCS8EncodedKeySpec(encoded2));
                if (rSAPrivateKey2 instanceof RSAPrivateCrtKey) {
                    RSAPrivateCrtKey rSAPrivateCrtKey3 = (RSAPrivateCrtKey) rSAPrivateKey2;
                    return new RSAPrivateCrtKeySpec(rSAPrivateCrtKey3.getModulus(), rSAPrivateCrtKey3.getPublicExponent(), rSAPrivateCrtKey3.getPrivateExponent(), rSAPrivateCrtKey3.getPrimeP(), rSAPrivateCrtKey3.getPrimeQ(), rSAPrivateCrtKey3.getPrimeExponentP(), rSAPrivateCrtKey3.getPrimeExponentQ(), rSAPrivateCrtKey3.getCrtCoefficient());
                }
                throw new InvalidKeySpecException("Encoded key is not an RSAPrivateCrtKey");
            } else if ((key instanceof PrivateKey) && RSAPrivateKeySpec.class.isAssignableFrom(cls)) {
                byte[] encoded3 = key.getEncoded();
                if (!"PKCS#8".equals(key.getFormat()) || encoded3 == null) {
                    throw new InvalidKeySpecException("Not a valid PKCS#8 encoding");
                }
                RSAPrivateKey rSAPrivateKey3 = (RSAPrivateKey) engineGeneratePrivate(new PKCS8EncodedKeySpec(encoded3));
                return new RSAPrivateKeySpec(rSAPrivateKey3.getModulus(), rSAPrivateKey3.getPrivateExponent());
            } else if ((key instanceof PrivateKey) && PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                byte[] encoded4 = key.getEncoded();
                if ("PKCS#8".equals(key.getFormat())) {
                    if (encoded4 == null) {
                        throw new InvalidKeySpecException("Key is not encodable");
                    }
                    return new PKCS8EncodedKeySpec(encoded4);
                }
                throw new InvalidKeySpecException("Encoding type must be PKCS#8; was " + key.getFormat());
            } else if ((key instanceof PublicKey) && X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                byte[] encoded5 = key.getEncoded();
                if ("X.509".equals(key.getFormat())) {
                    if (encoded5 == null) {
                        throw new InvalidKeySpecException("Key is not encodable");
                    }
                    return new X509EncodedKeySpec(encoded5);
                }
                throw new InvalidKeySpecException("Encoding type must be X.509; was " + key.getFormat());
            } else {
                throw new InvalidKeySpecException("Unsupported key type and key spec combination; key=" + key.getClass().getName() + ", keySpec=" + cls.getName());
            }
        }
        throw new InvalidKeySpecException("Key must be a RSA key");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (key == null) {
            throw new InvalidKeyException("key == null");
        }
        if ((key instanceof OpenSSLRSAPublicKey) || (key instanceof OpenSSLRSAPrivateKey)) {
            return key;
        }
        if (key instanceof RSAPublicKey) {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) key;
            try {
                return engineGeneratePublic(new RSAPublicKeySpec(rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent()));
            } catch (InvalidKeySpecException e) {
                throw new InvalidKeyException(e);
            }
        } else if (key instanceof RSAPrivateCrtKey) {
            RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) key;
            try {
                return engineGeneratePrivate(new RSAPrivateCrtKeySpec(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent(), rSAPrivateCrtKey.getPrivateExponent(), rSAPrivateCrtKey.getPrimeP(), rSAPrivateCrtKey.getPrimeQ(), rSAPrivateCrtKey.getPrimeExponentP(), rSAPrivateCrtKey.getPrimeExponentQ(), rSAPrivateCrtKey.getCrtCoefficient()));
            } catch (InvalidKeySpecException e2) {
                throw new InvalidKeyException(e2);
            }
        } else if (key instanceof RSAPrivateKey) {
            RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) key;
            try {
                return engineGeneratePrivate(new RSAPrivateKeySpec(rSAPrivateKey.getModulus(), rSAPrivateKey.getPrivateExponent()));
            } catch (InvalidKeySpecException e3) {
                throw new InvalidKeyException(e3);
            }
        } else if ((key instanceof PrivateKey) && "PKCS#8".equals(key.getFormat())) {
            byte[] encoded = key.getEncoded();
            if (encoded == null) {
                throw new InvalidKeyException("Key does not support encoding");
            }
            try {
                return engineGeneratePrivate(new PKCS8EncodedKeySpec(encoded));
            } catch (InvalidKeySpecException e4) {
                throw new InvalidKeyException(e4);
            }
        } else if ((key instanceof PublicKey) && "X.509".equals(key.getFormat())) {
            byte[] encoded2 = key.getEncoded();
            if (encoded2 == null) {
                throw new InvalidKeyException("Key does not support encoding");
            }
            try {
                return engineGeneratePublic(new X509EncodedKeySpec(encoded2));
            } catch (InvalidKeySpecException e5) {
                throw new InvalidKeyException(e5);
            }
        } else {
            throw new InvalidKeyException("Key must be an RSA public or private key; was " + key.getClass().getName());
        }
    }
}
