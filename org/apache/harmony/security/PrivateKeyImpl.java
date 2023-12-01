package org.apache.harmony.security;

import java.security.PrivateKey;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/PrivateKeyImpl.class */
public class PrivateKeyImpl implements PrivateKey {
    private static final long serialVersionUID = 7776497482533790279L;
    private String algorithm;
    private byte[] encoding;

    public PrivateKeyImpl(String str) {
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
        return "PKCS#8";
    }

    public void setAlgorithm(String str) {
        this.algorithm = str;
    }

    public void setEncoding(byte[] bArr) {
        this.encoding = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.encoding, 0, bArr.length);
    }
}
