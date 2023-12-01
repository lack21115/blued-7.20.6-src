package com.android.org.conscrypt;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.util.Arrays;
import javax.crypto.SecretKey;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLSecretKey.class */
public class OpenSSLSecretKey implements SecretKey, OpenSSLKeyHolder {
    private static final long serialVersionUID = 1831053062911514589L;
    private final String algorithm;
    private final byte[] encoded;
    private transient OpenSSLKey key;
    private final int type;

    public OpenSSLSecretKey(String str, OpenSSLKey openSSLKey) {
        this.algorithm = str;
        this.key = openSSLKey;
        this.type = NativeCrypto.EVP_PKEY_type(openSSLKey.getPkeyContext());
        this.encoded = null;
    }

    public OpenSSLSecretKey(String str, byte[] bArr) {
        this.algorithm = str;
        this.encoded = bArr;
        this.type = NativeCrypto.EVP_PKEY_HMAC;
        this.key = new OpenSSLKey(NativeCrypto.EVP_PKEY_new_mac_key(this.type, bArr));
    }

    public static OpenSSLKey getInstance(SecretKey secretKey) throws InvalidKeyException {
        try {
            return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_mac_key(NativeCrypto.EVP_PKEY_HMAC, secretKey.getEncoded()));
        } catch (Exception e) {
            throw new InvalidKeyException(e);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.key = new OpenSSLKey(NativeCrypto.EVP_PKEY_new_mac_key(this.type, this.encoded));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        if (getOpenSSLKey().isEngineBased()) {
            throw new NotSerializableException("engine-based keys can not be serialized");
        }
        objectOutputStream.defaultWriteObject();
    }

    public boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            z = true;
        } else {
            z = false;
            if (obj instanceof SecretKey) {
                SecretKey secretKey = (SecretKey) obj;
                z = false;
                if (this.algorithm.equals(secretKey.getAlgorithm())) {
                    if (obj instanceof OpenSSLSecretKey) {
                        return this.key.equals(((OpenSSLSecretKey) obj).getOpenSSLKey());
                    }
                    z = false;
                    if (!this.key.isEngineBased()) {
                        z = false;
                        if (getFormat().equals(secretKey.getFormat())) {
                            return Arrays.equals(this.encoded, secretKey.getEncoded());
                        }
                    }
                }
            }
        }
        return z;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        if (this.key.isEngineBased()) {
            return null;
        }
        return this.encoded;
    }

    @Override // java.security.Key
    public String getFormat() {
        if (this.key.isEngineBased()) {
            return null;
        }
        return "RAW";
    }

    @Override // com.android.org.conscrypt.OpenSSLKeyHolder
    public OpenSSLKey getOpenSSLKey() {
        return this.key;
    }

    public int hashCode() {
        return this.key.hashCode();
    }
}
