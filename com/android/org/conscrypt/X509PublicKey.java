package com.android.org.conscrypt;

import java.security.PublicKey;
import java.util.Arrays;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/X509PublicKey.class */
public class X509PublicKey implements PublicKey {
    private static final long serialVersionUID = -8610156854731664298L;
    private final String algorithm;
    private final byte[] encoded;

    public X509PublicKey(String str, byte[] bArr) {
        this.algorithm = str;
        this.encoded = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            X509PublicKey x509PublicKey = (X509PublicKey) obj;
            if (this.algorithm == null) {
                if (x509PublicKey.algorithm != null) {
                    return false;
                }
            } else if (!this.algorithm.equals(x509PublicKey.algorithm)) {
                return false;
            }
            return Arrays.equals(this.encoded, x509PublicKey.encoded);
        }
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return this.encoded;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return (((this.algorithm == null ? 0 : this.algorithm.hashCode()) + 31) * 31) + Arrays.hashCode(this.encoded);
    }

    public String toString() {
        return "X509PublicKey [algorithm=" + this.algorithm + ", encoded=" + Arrays.toString(this.encoded) + "]";
    }
}
