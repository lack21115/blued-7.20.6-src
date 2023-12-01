package com.android.org.conscrypt;

import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.spec.AlgorithmParameterSpec;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLDSAParams.class */
public class OpenSSLDSAParams implements DSAParams, AlgorithmParameterSpec {
    private boolean fetchedParams;
    private BigInteger g;
    private OpenSSLKey key;
    private BigInteger p;
    private BigInteger q;
    private BigInteger x;
    private BigInteger y;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLDSAParams(OpenSSLKey openSSLKey) {
        this.key = openSSLKey;
    }

    private final void ensureReadParams() {
        synchronized (this) {
            if (!this.fetchedParams) {
                byte[][] bArr = NativeCrypto.get_DSA_params(this.key.getPkeyContext());
                if (bArr[0] != null) {
                    this.g = new BigInteger(bArr[0]);
                }
                if (bArr[1] != null) {
                    this.p = new BigInteger(bArr[1]);
                }
                if (bArr[2] != null) {
                    this.q = new BigInteger(bArr[2]);
                }
                if (bArr[3] != null) {
                    this.y = new BigInteger(bArr[3]);
                }
                if (bArr[4] != null) {
                    this.x = new BigInteger(bArr[4]);
                }
                this.fetchedParams = true;
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof OpenSSLDSAParams) && this.key == ((OpenSSLDSAParams) obj).getOpenSSLKey()) {
            return true;
        }
        if (obj instanceof DSAParams) {
            ensureReadParams();
            DSAParams dSAParams = (DSAParams) obj;
            return this.g.equals(dSAParams.getG()) && this.p.equals(dSAParams.getP()) && this.q.equals(dSAParams.getQ());
        }
        return false;
    }

    @Override // java.security.interfaces.DSAParams
    public BigInteger getG() {
        ensureReadParams();
        return this.g;
    }

    OpenSSLKey getOpenSSLKey() {
        return this.key;
    }

    @Override // java.security.interfaces.DSAParams
    public BigInteger getP() {
        ensureReadParams();
        return this.p;
    }

    @Override // java.security.interfaces.DSAParams
    public BigInteger getQ() {
        ensureReadParams();
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BigInteger getX() {
        ensureReadParams();
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BigInteger getY() {
        ensureReadParams();
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasParams() {
        ensureReadParams();
        return (this.g == null || this.p == null || this.q == null) ? false : true;
    }

    public int hashCode() {
        ensureReadParams();
        return (this.g.hashCode() ^ this.p.hashCode()) ^ this.q.hashCode();
    }

    public String toString() {
        ensureReadParams();
        return "OpenSSLDSAParams{G=" + this.g.toString(16) + ",P=" + this.p.toString(16) + ",Q=" + this.q.toString(16) + '}';
    }
}
