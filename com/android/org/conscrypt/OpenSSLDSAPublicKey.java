package com.android.org.conscrypt;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.InvalidKeySpecException;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLDSAPublicKey.class */
public class OpenSSLDSAPublicKey implements DSAPublicKey, OpenSSLKeyHolder {
    private static final long serialVersionUID = 5238609500353792232L;
    private transient OpenSSLKey key;
    private transient OpenSSLDSAParams params;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLDSAPublicKey(OpenSSLKey openSSLKey) {
        this.key = openSSLKey;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLDSAPublicKey(DSAPublicKeySpec dSAPublicKeySpec) throws InvalidKeySpecException {
        try {
            this.key = new OpenSSLKey(NativeCrypto.EVP_PKEY_new_DSA(dSAPublicKeySpec.getP().toByteArray(), dSAPublicKeySpec.getQ().toByteArray(), dSAPublicKeySpec.getG().toByteArray(), dSAPublicKeySpec.getY().toByteArray(), null));
        } catch (Exception e) {
            throw new InvalidKeySpecException(e);
        }
    }

    private void ensureReadParams() {
        if (this.params == null) {
            this.params = new OpenSSLDSAParams(this.key);
        }
    }

    static OpenSSLKey getInstance(DSAPublicKey dSAPublicKey) throws InvalidKeyException {
        try {
            DSAParams params = dSAPublicKey.getParams();
            return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_DSA(params.getP().toByteArray(), params.getQ().toByteArray(), params.getG().toByteArray(), dSAPublicKey.getY().toByteArray(), null));
        } catch (Exception e) {
            throw new InvalidKeyException(e);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        BigInteger bigInteger = (BigInteger) objectInputStream.readObject();
        this.key = new OpenSSLKey(NativeCrypto.EVP_PKEY_new_DSA(((BigInteger) objectInputStream.readObject()).toByteArray(), ((BigInteger) objectInputStream.readObject()).toByteArray(), bigInteger.toByteArray(), ((BigInteger) objectInputStream.readObject()).toByteArray(), null));
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
        objectOutputStream.writeObject(this.params.getY());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof OpenSSLDSAPublicKey) && this.key.equals(((OpenSSLDSAPublicKey) obj).getOpenSSLKey())) {
            return true;
        }
        if (obj instanceof DSAPublicKey) {
            ensureReadParams();
            DSAPublicKey dSAPublicKey = (DSAPublicKey) obj;
            return this.params.getY().equals(dSAPublicKey.getY()) && this.params.equals(dSAPublicKey.getParams());
        }
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return NativeCrypto.i2d_PUBKEY(this.key.getPkeyContext());
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // com.android.org.conscrypt.OpenSSLKeyHolder
    public OpenSSLKey getOpenSSLKey() {
        return this.key;
    }

    @Override // java.security.interfaces.DSAKey
    public DSAParams getParams() {
        ensureReadParams();
        if (this.params.hasParams()) {
            return this.params;
        }
        return null;
    }

    @Override // java.security.interfaces.DSAPublicKey
    public BigInteger getY() {
        ensureReadParams();
        return this.params.getY();
    }

    public int hashCode() {
        ensureReadParams();
        return this.params.getY().hashCode() ^ this.params.hashCode();
    }

    public String toString() {
        ensureReadParams();
        return "OpenSSLDSAPublicKey{Y=" + this.params.getY().toString(16) + ",params=" + this.params.toString() + '}';
    }
}
