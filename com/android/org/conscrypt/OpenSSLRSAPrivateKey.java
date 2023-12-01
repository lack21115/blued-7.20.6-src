package com.android.org.conscrypt;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLRSAPrivateKey.class */
public class OpenSSLRSAPrivateKey implements RSAPrivateKey, OpenSSLKeyHolder {
    private static final long serialVersionUID = 4872170254439578735L;
    protected transient boolean fetchedParams;
    protected transient OpenSSLKey key;
    protected BigInteger modulus;
    protected BigInteger privateExponent;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLRSAPrivateKey(OpenSSLKey openSSLKey) {
        this.key = openSSLKey;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLRSAPrivateKey(OpenSSLKey openSSLKey, byte[][] bArr) {
        this(openSSLKey);
        readParams(bArr);
        this.fetchedParams = true;
    }

    public OpenSSLRSAPrivateKey(RSAPrivateKeySpec rSAPrivateKeySpec) throws InvalidKeySpecException {
        this(init(rSAPrivateKeySpec));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OpenSSLKey getInstance(RSAPrivateKey rSAPrivateKey) throws InvalidKeyException {
        if (rSAPrivateKey.getFormat() == null) {
            return wrapPlatformKey(rSAPrivateKey);
        }
        BigInteger modulus = rSAPrivateKey.getModulus();
        BigInteger privateExponent = rSAPrivateKey.getPrivateExponent();
        if (modulus == null) {
            throw new InvalidKeyException("modulus == null");
        }
        if (privateExponent == null) {
            throw new InvalidKeyException("privateExponent == null");
        }
        try {
            return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_RSA(modulus.toByteArray(), null, privateExponent.toByteArray(), null, null, null, null, null));
        } catch (Exception e) {
            throw new InvalidKeyException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OpenSSLRSAPrivateKey getInstance(OpenSSLKey openSSLKey) {
        byte[][] bArr = NativeCrypto.get_RSA_private_params(openSSLKey.getPkeyContext());
        return bArr[1] != null ? new OpenSSLRSAPrivateCrtKey(openSSLKey, bArr) : new OpenSSLRSAPrivateKey(openSSLKey, bArr);
    }

    private static OpenSSLKey init(RSAPrivateKeySpec rSAPrivateKeySpec) throws InvalidKeySpecException {
        BigInteger modulus = rSAPrivateKeySpec.getModulus();
        BigInteger privateExponent = rSAPrivateKeySpec.getPrivateExponent();
        if (modulus == null) {
            throw new InvalidKeySpecException("modulus == null");
        }
        if (privateExponent == null) {
            throw new InvalidKeySpecException("privateExponent == null");
        }
        try {
            return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_RSA(modulus.toByteArray(), null, privateExponent.toByteArray(), null, null, null, null, null));
        } catch (Exception e) {
            throw new InvalidKeySpecException(e);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.key = new OpenSSLKey(NativeCrypto.EVP_PKEY_new_RSA(this.modulus.toByteArray(), null, this.privateExponent.toByteArray(), null, null, null, null, null));
        this.fetchedParams = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static OpenSSLKey wrapPlatformKey(RSAPrivateKey rSAPrivateKey) throws InvalidKeyException {
        OpenSSLKey wrapRsaKey = Platform.wrapRsaKey(rSAPrivateKey);
        return wrapRsaKey != null ? wrapRsaKey : new OpenSSLKey(NativeCrypto.getRSAPrivateKeyWrapper(rSAPrivateKey, rSAPrivateKey.getModulus().toByteArray()), true);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        if (getOpenSSLKey().isEngineBased()) {
            throw new NotSerializableException("engine-based keys can not be serialized");
        }
        ensureReadParams();
        objectOutputStream.defaultWriteObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void ensureReadParams() {
        synchronized (this) {
            if (!this.fetchedParams) {
                readParams(NativeCrypto.get_RSA_private_params(this.key.getPkeyContext()));
                this.fetchedParams = true;
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OpenSSLRSAPrivateKey) {
            return this.key.equals(((OpenSSLRSAPrivateKey) obj).getOpenSSLKey());
        }
        if (obj instanceof RSAPrivateKey) {
            ensureReadParams();
            RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) obj;
            return this.modulus.equals(rSAPrivateKey.getModulus()) && this.privateExponent.equals(rSAPrivateKey.getPrivateExponent());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "RSA";
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        if (this.key.isEngineBased()) {
            return null;
        }
        return NativeCrypto.i2d_PKCS8_PRIV_KEY_INFO(this.key.getPkeyContext());
    }

    @Override // java.security.Key
    public final String getFormat() {
        if (this.key.isEngineBased()) {
            return null;
        }
        return "PKCS#8";
    }

    @Override // java.security.interfaces.RSAKey
    public final BigInteger getModulus() {
        ensureReadParams();
        return this.modulus;
    }

    @Override // com.android.org.conscrypt.OpenSSLKeyHolder
    public OpenSSLKey getOpenSSLKey() {
        return this.key;
    }

    @Override // java.security.interfaces.RSAPrivateKey
    public final BigInteger getPrivateExponent() {
        if (this.key.isEngineBased()) {
            throw new UnsupportedOperationException("private exponent cannot be extracted");
        }
        ensureReadParams();
        return this.privateExponent;
    }

    public int hashCode() {
        ensureReadParams();
        int hashCode = this.modulus.hashCode() + 3;
        int i = hashCode;
        if (this.privateExponent != null) {
            i = (hashCode * 7) + this.privateExponent.hashCode();
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void readParams(byte[][] bArr) {
        if (bArr[0] == null) {
            throw new NullPointerException("modulus == null");
        }
        if (bArr[2] == null && !this.key.isEngineBased()) {
            throw new NullPointerException("privateExponent == null");
        }
        this.modulus = new BigInteger(bArr[0]);
        if (bArr[2] != null) {
            this.privateExponent = new BigInteger(bArr[2]);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OpenSSLRSAPrivateKey{");
        boolean isEngineBased = this.key.isEngineBased();
        if (isEngineBased) {
            sb.append("key=");
            sb.append(this.key);
            sb.append('}');
        }
        ensureReadParams();
        sb.append("modulus=");
        sb.append(this.modulus.toString(16));
        sb.append(',');
        if (!isEngineBased) {
            sb.append("privateExponent=");
            sb.append(this.privateExponent.toString(16));
            sb.append(',');
        }
        return sb.toString();
    }
}
