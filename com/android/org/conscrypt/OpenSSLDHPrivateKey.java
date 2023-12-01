package com.android.org.conscrypt;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLDHPrivateKey.class */
public class OpenSSLDHPrivateKey implements DHPrivateKey, OpenSSLKeyHolder {
    private static final long serialVersionUID = -7321023036951606638L;
    private transient byte[] g;
    private transient OpenSSLKey key;
    private transient Object mParamsLock = new Object();
    private transient byte[] p;
    private transient boolean readParams;
    private transient byte[] x;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLDHPrivateKey(OpenSSLKey openSSLKey) {
        this.key = openSSLKey;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLDHPrivateKey(DHPrivateKeySpec dHPrivateKeySpec) throws InvalidKeySpecException {
        try {
            this.key = new OpenSSLKey(NativeCrypto.EVP_PKEY_new_DH(dHPrivateKeySpec.getP().toByteArray(), dHPrivateKeySpec.getG().toByteArray(), null, dHPrivateKeySpec.getX().toByteArray()));
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
            this.x = bArr[3];
            this.readParams = true;
        }
    }

    static OpenSSLKey getInstance(DHPrivateKey dHPrivateKey) throws InvalidKeyException {
        try {
            DHParameterSpec params = dHPrivateKey.getParams();
            return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_DH(params.getP().toByteArray(), params.getG().toByteArray(), null, dHPrivateKey.getX().toByteArray()));
        } catch (Exception e) {
            throw new InvalidKeyException(e);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        BigInteger bigInteger = (BigInteger) objectInputStream.readObject();
        this.key = new OpenSSLKey(NativeCrypto.EVP_PKEY_new_DH(((BigInteger) objectInputStream.readObject()).toByteArray(), bigInteger.toByteArray(), null, ((BigInteger) objectInputStream.readObject()).toByteArray()));
        this.mParamsLock = new Object();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        if (getOpenSSLKey().isEngineBased()) {
            throw new NotSerializableException("engine-based keys can not be serialized");
        }
        objectOutputStream.defaultWriteObject();
        ensureReadParams();
        objectOutputStream.writeObject(new BigInteger(this.g));
        objectOutputStream.writeObject(new BigInteger(this.p));
        objectOutputStream.writeObject(new BigInteger(this.x));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof OpenSSLDHPrivateKey) && this.key.equals(((OpenSSLDHPrivateKey) obj).getOpenSSLKey())) {
            return true;
        }
        if (obj instanceof DHPrivateKey) {
            ensureReadParams();
            DHPrivateKey dHPrivateKey = (DHPrivateKey) obj;
            if (this.x.equals(dHPrivateKey.getX())) {
                DHParameterSpec params = dHPrivateKey.getParams();
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

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        ensureReadParams();
        return new DHParameterSpec(new BigInteger(this.p), new BigInteger(this.g));
    }

    @Override // javax.crypto.interfaces.DHPrivateKey
    public BigInteger getX() {
        if (this.key.isEngineBased()) {
            throw new UnsupportedOperationException("private key value X cannot be extracted");
        }
        ensureReadParams();
        return new BigInteger(this.x);
    }

    public int hashCode() {
        ensureReadParams();
        int i = 1;
        if (!this.key.isEngineBased()) {
            i = this.x.hashCode() + 3;
        }
        return (((i * 7) + this.p.hashCode()) * 13) + this.g.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OpenSSLDHPrivateKey{");
        if (this.key.isEngineBased()) {
            sb.append("key=");
            sb.append(this.key);
            sb.append('}');
            return sb.toString();
        }
        ensureReadParams();
        sb.append("X=");
        sb.append(new BigInteger(this.x).toString(16));
        sb.append(',');
        sb.append("P=");
        sb.append(new BigInteger(this.p).toString(16));
        sb.append(',');
        sb.append("G=");
        sb.append(new BigInteger(this.g).toString(16));
        sb.append('}');
        return sb.toString();
    }
}
