package org.apache.harmony.security.x509;

import java.security.PublicKey;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/X509PublicKey.class */
public final class X509PublicKey implements PublicKey {
    private final String algorithm;
    private final byte[] encoded;
    private final byte[] keyBytes;

    public X509PublicKey(String str, byte[] bArr, byte[] bArr2) {
        this.algorithm = str;
        this.encoded = bArr;
        this.keyBytes = bArr2;
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

    public String toString() {
        return "algorithm = " + this.algorithm + ", params unparsed, unparsed keybits = \n";
    }
}
