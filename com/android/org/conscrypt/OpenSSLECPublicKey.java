package com.android.org.conscrypt;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLECPublicKey.class */
public final class OpenSSLECPublicKey implements ECPublicKey, OpenSSLKeyHolder {
    private static final String ALGORITHM = "EC";
    private static final long serialVersionUID = 3215842926808298020L;
    protected transient OpenSSLECGroupContext group;
    protected transient OpenSSLKey key;

    public OpenSSLECPublicKey(OpenSSLECGroupContext openSSLECGroupContext, OpenSSLKey openSSLKey) {
        this.group = openSSLECGroupContext;
        this.key = openSSLKey;
    }

    public OpenSSLECPublicKey(OpenSSLKey openSSLKey) {
        this.group = new OpenSSLECGroupContext(NativeCrypto.EC_GROUP_dup(NativeCrypto.EC_KEY_get0_group(openSSLKey.getPkeyContext())));
        this.key = openSSLKey;
    }

    public OpenSSLECPublicKey(ECPublicKeySpec eCPublicKeySpec) throws InvalidKeySpecException {
        try {
            this.group = OpenSSLECGroupContext.getInstance(eCPublicKeySpec.getParams());
            this.key = new OpenSSLKey(NativeCrypto.EVP_PKEY_new_EC_KEY(this.group.getContext(), OpenSSLECPointContext.getInstance(NativeCrypto.get_EC_GROUP_type(this.group.getContext()), this.group, eCPublicKeySpec.getW()).getContext(), null));
        } catch (Exception e) {
            throw new InvalidKeySpecException(e);
        }
    }

    public static OpenSSLKey getInstance(ECPublicKey eCPublicKey) throws InvalidKeyException {
        try {
            OpenSSLECGroupContext openSSLECGroupContext = OpenSSLECGroupContext.getInstance(eCPublicKey.getParams());
            return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_EC_KEY(openSSLECGroupContext.getContext(), OpenSSLECPointContext.getInstance(NativeCrypto.get_EC_GROUP_type(openSSLECGroupContext.getContext()), openSSLECGroupContext, eCPublicKey.getW()).getContext(), null));
        } catch (Exception e) {
            throw new InvalidKeyException(e);
        }
    }

    private ECPoint getPublicKey() {
        return new OpenSSLECPointContext(this.group, NativeCrypto.EC_KEY_get_public_key(this.key.getPkeyContext())).getECPoint();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.key = new OpenSSLKey(NativeCrypto.d2i_PUBKEY((byte[]) objectInputStream.readObject()));
        this.group = new OpenSSLECGroupContext(NativeCrypto.EC_GROUP_dup(NativeCrypto.EC_KEY_get0_group(this.key.getPkeyContext())));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        if (this.key.isEngineBased()) {
            throw new NotSerializableException("engine-based keys can not be serialized");
        }
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OpenSSLECPrivateKey) {
            return this.key.equals(((OpenSSLECPrivateKey) obj).key);
        }
        if (obj instanceof ECPublicKey) {
            ECPublicKey eCPublicKey = (ECPublicKey) obj;
            if (getPublicKey().equals(eCPublicKey.getW())) {
                ECParameterSpec params = getParams();
                ECParameterSpec params2 = eCPublicKey.getParams();
                return params.getCurve().equals(params2.getCurve()) && params.getGenerator().equals(params2.getGenerator()) && params.getOrder().equals(params2.getOrder()) && params.getCofactor() == params2.getCofactor();
            }
            return false;
        }
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return ALGORITHM;
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

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.group.getECParameterSpec();
    }

    @Override // java.security.interfaces.ECPublicKey
    public ECPoint getW() {
        return getPublicKey();
    }

    public int hashCode() {
        return Arrays.hashCode(NativeCrypto.i2d_PUBKEY(this.key.getPkeyContext()));
    }

    public String toString() {
        return NativeCrypto.EVP_PKEY_print_public(this.key.getPkeyContext());
    }
}
