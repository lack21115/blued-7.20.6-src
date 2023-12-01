package java.security.spec;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/EncodedKeySpec.class */
public abstract class EncodedKeySpec implements KeySpec {
    private final byte[] encodedKey;

    public EncodedKeySpec(byte[] bArr) {
        this.encodedKey = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.encodedKey, 0, this.encodedKey.length);
    }

    public byte[] getEncoded() {
        byte[] bArr = new byte[this.encodedKey.length];
        System.arraycopy(this.encodedKey, 0, bArr, 0, bArr.length);
        return bArr;
    }

    public abstract String getFormat();
}
