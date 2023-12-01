package com.android.org.conscrypt;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateCrtKeySpec;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLRSAPrivateCrtKey.class */
public class OpenSSLRSAPrivateCrtKey extends OpenSSLRSAPrivateKey implements RSAPrivateCrtKey {
    private static final long serialVersionUID = 3785291944868707197L;
    private BigInteger crtCoefficient;
    private BigInteger primeExponentP;
    private BigInteger primeExponentQ;
    private BigInteger primeP;
    private BigInteger primeQ;
    private BigInteger publicExponent;

    OpenSSLRSAPrivateCrtKey(OpenSSLKey openSSLKey) {
        super(openSSLKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLRSAPrivateCrtKey(OpenSSLKey openSSLKey, byte[][] bArr) {
        super(openSSLKey, bArr);
    }

    public OpenSSLRSAPrivateCrtKey(RSAPrivateCrtKeySpec rSAPrivateCrtKeySpec) throws InvalidKeySpecException {
        super(init(rSAPrivateCrtKeySpec));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OpenSSLKey getInstance(RSAPrivateCrtKey rSAPrivateCrtKey) throws InvalidKeyException {
        if (rSAPrivateCrtKey.getFormat() == null) {
            return wrapPlatformKey(rSAPrivateCrtKey);
        }
        BigInteger modulus = rSAPrivateCrtKey.getModulus();
        BigInteger privateExponent = rSAPrivateCrtKey.getPrivateExponent();
        if (modulus == null) {
            throw new InvalidKeyException("modulus == null");
        }
        if (privateExponent == null) {
            throw new InvalidKeyException("privateExponent == null");
        }
        try {
            BigInteger publicExponent = rSAPrivateCrtKey.getPublicExponent();
            BigInteger primeP = rSAPrivateCrtKey.getPrimeP();
            BigInteger primeQ = rSAPrivateCrtKey.getPrimeQ();
            BigInteger primeExponentP = rSAPrivateCrtKey.getPrimeExponentP();
            BigInteger primeExponentQ = rSAPrivateCrtKey.getPrimeExponentQ();
            BigInteger crtCoefficient = rSAPrivateCrtKey.getCrtCoefficient();
            return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_RSA(modulus.toByteArray(), publicExponent == null ? null : publicExponent.toByteArray(), privateExponent.toByteArray(), primeP == null ? null : primeP.toByteArray(), primeQ == null ? null : primeQ.toByteArray(), primeExponentP == null ? null : primeExponentP.toByteArray(), primeExponentQ == null ? null : primeExponentQ.toByteArray(), crtCoefficient == null ? null : crtCoefficient.toByteArray()));
        } catch (Exception e) {
            throw new InvalidKeyException(e);
        }
    }

    private static OpenSSLKey init(RSAPrivateCrtKeySpec rSAPrivateCrtKeySpec) throws InvalidKeySpecException {
        BigInteger modulus = rSAPrivateCrtKeySpec.getModulus();
        BigInteger privateExponent = rSAPrivateCrtKeySpec.getPrivateExponent();
        if (modulus == null) {
            throw new InvalidKeySpecException("modulus == null");
        }
        if (privateExponent == null) {
            throw new InvalidKeySpecException("privateExponent == null");
        }
        try {
            BigInteger publicExponent = rSAPrivateCrtKeySpec.getPublicExponent();
            BigInteger primeP = rSAPrivateCrtKeySpec.getPrimeP();
            BigInteger primeQ = rSAPrivateCrtKeySpec.getPrimeQ();
            BigInteger primeExponentP = rSAPrivateCrtKeySpec.getPrimeExponentP();
            BigInteger primeExponentQ = rSAPrivateCrtKeySpec.getPrimeExponentQ();
            BigInteger crtCoefficient = rSAPrivateCrtKeySpec.getCrtCoefficient();
            return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_RSA(modulus.toByteArray(), publicExponent == null ? null : publicExponent.toByteArray(), privateExponent.toByteArray(), primeP == null ? null : primeP.toByteArray(), primeQ == null ? null : primeQ.toByteArray(), primeExponentP == null ? null : primeExponentP.toByteArray(), primeExponentQ == null ? null : primeExponentQ.toByteArray(), crtCoefficient == null ? null : crtCoefficient.toByteArray()));
        } catch (Exception e) {
            throw new InvalidKeySpecException(e);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        byte[] bArr = null;
        objectInputStream.defaultReadObject();
        byte[] byteArray = this.modulus.toByteArray();
        byte[] byteArray2 = this.publicExponent == null ? null : this.publicExponent.toByteArray();
        byte[] byteArray3 = this.privateExponent.toByteArray();
        byte[] byteArray4 = this.primeP == null ? null : this.primeP.toByteArray();
        byte[] byteArray5 = this.primeQ == null ? null : this.primeQ.toByteArray();
        byte[] byteArray6 = this.primeExponentP == null ? null : this.primeExponentP.toByteArray();
        byte[] byteArray7 = this.primeExponentQ == null ? null : this.primeExponentQ.toByteArray();
        if (this.crtCoefficient != null) {
            bArr = this.crtCoefficient.toByteArray();
        }
        this.key = new OpenSSLKey(NativeCrypto.EVP_PKEY_new_RSA(byteArray, byteArray2, byteArray3, byteArray4, byteArray5, byteArray6, byteArray7, bArr));
        this.fetchedParams = true;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        if (getOpenSSLKey().isEngineBased()) {
            throw new NotSerializableException("engine-based keys can not be serialized");
        }
        ensureReadParams();
        objectOutputStream.defaultWriteObject();
    }

    @Override // com.android.org.conscrypt.OpenSSLRSAPrivateKey
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OpenSSLRSAPrivateKey) {
            return getOpenSSLKey().equals(((OpenSSLRSAPrivateKey) obj).getOpenSSLKey());
        }
        if (obj instanceof RSAPrivateCrtKey) {
            ensureReadParams();
            RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) obj;
            return getOpenSSLKey().isEngineBased() ? getModulus().equals(rSAPrivateCrtKey.getModulus()) && this.publicExponent.equals(rSAPrivateCrtKey.getPublicExponent()) : getModulus().equals(rSAPrivateCrtKey.getModulus()) && this.publicExponent.equals(rSAPrivateCrtKey.getPublicExponent()) && getPrivateExponent().equals(rSAPrivateCrtKey.getPrivateExponent()) && this.primeP.equals(rSAPrivateCrtKey.getPrimeP()) && this.primeQ.equals(rSAPrivateCrtKey.getPrimeQ()) && this.primeExponentP.equals(rSAPrivateCrtKey.getPrimeExponentP()) && this.primeExponentQ.equals(rSAPrivateCrtKey.getPrimeExponentQ()) && this.crtCoefficient.equals(rSAPrivateCrtKey.getCrtCoefficient());
        } else if (obj instanceof RSAPrivateKey) {
            ensureReadParams();
            RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) obj;
            return getOpenSSLKey().isEngineBased() ? getModulus().equals(rSAPrivateKey.getModulus()) : getModulus().equals(rSAPrivateKey.getModulus()) && getPrivateExponent().equals(rSAPrivateKey.getPrivateExponent());
        } else {
            return false;
        }
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getCrtCoefficient() {
        ensureReadParams();
        return this.crtCoefficient;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeExponentP() {
        ensureReadParams();
        return this.primeExponentP;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeExponentQ() {
        ensureReadParams();
        return this.primeExponentQ;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeP() {
        ensureReadParams();
        return this.primeP;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeQ() {
        ensureReadParams();
        return this.primeQ;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPublicExponent() {
        ensureReadParams();
        return this.publicExponent;
    }

    @Override // com.android.org.conscrypt.OpenSSLRSAPrivateKey
    public final int hashCode() {
        int hashCode = super.hashCode();
        int i = hashCode;
        if (this.publicExponent != null) {
            i = hashCode ^ this.publicExponent.hashCode();
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.org.conscrypt.OpenSSLRSAPrivateKey
    public void readParams(byte[][] bArr) {
        synchronized (this) {
            super.readParams(bArr);
            if (bArr[1] != null) {
                this.publicExponent = new BigInteger(bArr[1]);
            }
            if (bArr[3] != null) {
                this.primeP = new BigInteger(bArr[3]);
            }
            if (bArr[4] != null) {
                this.primeQ = new BigInteger(bArr[4]);
            }
            if (bArr[5] != null) {
                this.primeExponentP = new BigInteger(bArr[5]);
            }
            if (bArr[6] != null) {
                this.primeExponentQ = new BigInteger(bArr[6]);
            }
            if (bArr[7] != null) {
                this.crtCoefficient = new BigInteger(bArr[7]);
            }
        }
    }

    @Override // com.android.org.conscrypt.OpenSSLRSAPrivateKey
    public String toString() {
        StringBuilder sb = new StringBuilder("OpenSSLRSAPrivateCrtKey{");
        boolean isEngineBased = getOpenSSLKey().isEngineBased();
        if (isEngineBased) {
            sb.append("key=");
            sb.append(getOpenSSLKey());
            sb.append('}');
        }
        ensureReadParams();
        sb.append("modulus=");
        sb.append(getModulus().toString(16));
        sb.append(',');
        if (this.publicExponent != null) {
            sb.append("publicExponent=");
            sb.append(this.publicExponent.toString(16));
            sb.append(',');
        }
        if (!isEngineBased) {
            sb.append("privateExponent=");
            sb.append(getPrivateExponent().toString(16));
            sb.append(',');
        }
        if (this.primeP != null) {
            sb.append("primeP=");
            sb.append(this.primeP.toString(16));
            sb.append(',');
        }
        if (this.primeQ != null) {
            sb.append("primeQ=");
            sb.append(this.primeQ.toString(16));
            sb.append(',');
        }
        if (this.primeExponentP != null) {
            sb.append("primeExponentP=");
            sb.append(this.primeExponentP.toString(16));
            sb.append(',');
        }
        if (this.primeExponentQ != null) {
            sb.append("primeExponentQ=");
            sb.append(this.primeExponentQ.toString(16));
            sb.append(',');
        }
        if (this.crtCoefficient != null) {
            sb.append("crtCoefficient=");
            sb.append(this.crtCoefficient.toString(16));
            sb.append(',');
        }
        return sb.toString();
    }
}
