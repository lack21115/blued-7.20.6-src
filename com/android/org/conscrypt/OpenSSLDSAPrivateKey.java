package com.android.org.conscrypt;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.InvalidKeySpecException;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLDSAPrivateKey.class */
public class OpenSSLDSAPrivateKey implements DSAPrivateKey, OpenSSLKeyHolder {
    private static final long serialVersionUID = 6524734576187424628L;
    private transient OpenSSLKey key;
    private transient OpenSSLDSAParams params;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLDSAPrivateKey(OpenSSLKey openSSLKey) {
        this.key = openSSLKey;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLDSAPrivateKey(DSAPrivateKeySpec dSAPrivateKeySpec) throws InvalidKeySpecException {
        try {
            this.key = new OpenSSLKey(NativeCrypto.EVP_PKEY_new_DSA(dSAPrivateKeySpec.getP().toByteArray(), dSAPrivateKeySpec.getQ().toByteArray(), dSAPrivateKeySpec.getG().toByteArray(), null, dSAPrivateKeySpec.getX().toByteArray()));
        } catch (Exception e) {
            throw new InvalidKeySpecException(e);
        }
    }

    private void ensureReadParams() {
        if (this.params == null) {
            this.params = new OpenSSLDSAParams(this.key);
        }
    }

    static OpenSSLKey getInstance(DSAPrivateKey dSAPrivateKey) throws InvalidKeyException {
        if (dSAPrivateKey.getFormat() == null) {
            return wrapPlatformKey(dSAPrivateKey);
        }
        try {
            DSAParams params = dSAPrivateKey.getParams();
            return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_DSA(params.getP().toByteArray(), params.getQ().toByteArray(), params.getG().toByteArray(), null, dSAPrivateKey.getX().toByteArray()));
        } catch (Exception e) {
            throw new InvalidKeyException(e);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        BigInteger bigInteger = (BigInteger) objectInputStream.readObject();
        this.key = new OpenSSLKey(NativeCrypto.EVP_PKEY_new_DSA(((BigInteger) objectInputStream.readObject()).toByteArray(), ((BigInteger) objectInputStream.readObject()).toByteArray(), bigInteger.toByteArray(), null, ((BigInteger) objectInputStream.readObject()).toByteArray()));
    }

    public static OpenSSLKey wrapPlatformKey(DSAPrivateKey dSAPrivateKey) {
        return new OpenSSLKey(NativeCrypto.getDSAPrivateKeyWrapper(dSAPrivateKey), true);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        if (getOpenSSLKey().isEngineBased()) {
            throw new NotSerializableException("engine-based keys can not be serialized");
        }
        objectOutputStream.defaultWriteObject();
        ensureReadParams();
        objectOutputStream.writeObject(this.params.getG());
        objectOutputStream.writeObject(this.params.getP());
        objectOutputStream.writeObject(this.params.getQ());
        objectOutputStream.writeObject(this.params.getX());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof OpenSSLDSAPrivateKey) && this.key.equals(((OpenSSLDSAPrivateKey) obj).getOpenSSLKey())) {
            return true;
        }
        if (obj instanceof DSAPrivateKey) {
            ensureReadParams();
            BigInteger x = this.params.getX();
            if (x == null) {
                return false;
            }
            DSAPrivateKey dSAPrivateKey = (DSAPrivateKey) obj;
            return x.equals(dSAPrivateKey.getX()) && this.params.equals(dSAPrivateKey.getParams());
        }
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        if (this.key.isEngineBased()) {
            return null;
        }
        return NativeCrypto.i2d_PKCS8_PRIV_KEY_INFO(this.key.getPkeyContext());
    }

    @Override // java.security.Key
    public String getFormat() {
        if (this.key.isEngineBased()) {
            return null;
        }
        return "PKCS#8";
    }

    @Override // com.android.org.conscrypt.OpenSSLKeyHolder
    public OpenSSLKey getOpenSSLKey() {
        return this.key;
    }

    @Override // java.security.interfaces.DSAKey
    public DSAParams getParams() {
        ensureReadParams();
        return this.params;
    }

    @Override // java.security.interfaces.DSAPrivateKey
    public BigInteger getX() {
        if (this.key.isEngineBased()) {
            throw new UnsupportedOperationException("private key value X cannot be extracted");
        }
        ensureReadParams();
        return this.params.getX();
    }

    public int hashCode() {
        ensureReadParams();
        int i = 1;
        BigInteger x = getX();
        if (x != null) {
            i = x.hashCode() + 3;
        }
        return (i * 7) + this.params.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OpenSSLDSAPrivateKey{");
        if (this.key.isEngineBased()) {
            sb.append("key=");
            sb.append(this.key);
            sb.append('}');
            return sb.toString();
        }
        ensureReadParams();
        sb.append("X=");
        sb.append(this.params.getX().toString(16));
        sb.append(',');
        sb.append("params=");
        sb.append(this.params.toString());
        sb.append('}');
        return sb.toString();
    }
}
