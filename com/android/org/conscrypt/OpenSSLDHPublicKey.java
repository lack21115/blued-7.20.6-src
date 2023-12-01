package com.android.org.conscrypt;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLDHPublicKey.class */
public class OpenSSLDHPublicKey implements DHPublicKey, OpenSSLKeyHolder {
    private static final long serialVersionUID = 6123717708079837723L;
    private transient byte[] g;
    private transient OpenSSLKey key;
    private final transient Object mParamsLock = new Object();
    private transient byte[] p;
    private transient boolean readParams;
    private transient byte[] y;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLDHPublicKey(OpenSSLKey openSSLKey) {
        this.key = openSSLKey;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLDHPublicKey(DHPublicKeySpec dHPublicKeySpec) throws InvalidKeySpecException {
        try {
            this.key = new OpenSSLKey(NativeCrypto.EVP_PKEY_new_DH(dHPublicKeySpec.getP().toByteArray(), dHPublicKeySpec.getG().toByteArray(), dHPublicKeySpec.getY().toByteArray(), null));
        } catch (Exception e) {
            throw new InvalidKeySpecException(e);
        }
    }

    private void ensureReadParams() {
        synchronized (this.mParamsLock) {
            if (this.readParams) {
                return;
            }
            byte[][] bArr = NativeCrypto.get_DH_params(this.key.getPkeyContext());
            this.p = bArr[0];
            this.g = bArr[1];
            this.y = bArr[2];
            this.readParams = true;
        }
    }

    static OpenSSLKey getInstance(DHPublicKey dHPublicKey) throws InvalidKeyException {
        try {
            DHParameterSpec params = dHPublicKey.getParams();
            return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_DH(params.getP().toByteArray(), params.getG().toByteArray(), dHPublicKey.getY().toByteArray(), null));
        } catch (Exception e) {
            throw new InvalidKeyException(e);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        BigInteger bigInteger = (BigInteger) objectInputStream.readObject();
        this.key = new OpenSSLKey(NativeCrypto.EVP_PKEY_new_DH(((BigInteger) objectInputStream.readObject()).toByteArray(), bigInteger.toByteArray(), ((BigInteger) objectInputStream.readObject()).toByteArray(), null));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        ensureReadParams();
        objectOutputStream.writeObject(new BigInteger(this.g));
        objectOutputStream.writeObject(new BigInteger(this.p));
        objectOutputStream.writeObject(new BigInteger(this.y));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof OpenSSLDHPublicKey) && this.key.equals(((OpenSSLDHPublicKey) obj).getOpenSSLKey())) {
            return true;
        }
        if (obj instanceof DHPublicKey) {
            ensureReadParams();
            DHPublicKey dHPublicKey = (DHPublicKey) obj;
            if (this.y.equals(dHPublicKey.getY())) {
                DHParameterSpec params = dHPublicKey.getParams();
                return this.g.equals(params.getG()) && this.p.equals(params.getP());
            }
            return false;
        }
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DH";
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

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        ensureReadParams();
        return new DHParameterSpec(new BigInteger(this.p), new BigInteger(this.g));
    }

    @Override // javax.crypto.interfaces.DHPublicKey
    public BigInteger getY() {
        ensureReadParams();
        return new BigInteger(this.y);
    }

    public int hashCode() {
        ensureReadParams();
        return ((((this.y.hashCode() + 3) * 7) + this.p.hashCode()) * 13) + this.g.hashCode();
    }

    public String toString() {
        ensureReadParams();
        return "OpenSSLDHPublicKey{Y=" + new BigInteger(this.y).toString(16) + ",P=" + new BigInteger(this.p).toString(16) + ",G=" + new BigInteger(this.g).toString(16) + '}';
    }
}
