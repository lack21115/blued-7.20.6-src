package org.apache.harmony.security;

import java.security.PublicKey;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/PublicKeyImpl.class */
public class PublicKeyImpl implements PublicKey {
    private static final long serialVersionUID = 7179022516819534075L;
    private String algorithm;
    private byte[] encoding;

    public PublicKeyImpl(String str) {
        this.algorithm = str;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        byte[] bArr = new byte[this.encoding.length];
        System.arraycopy(this.encoding, 0, bArr, 0, this.encoding.length);
        return bArr;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public void setAlgorithm(String str) {
        this.algorithm = str;
    }

    public void setEncoding(byte[] bArr) {
        this.encoding = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.encoding, 0, bArr.length);
    }
}
