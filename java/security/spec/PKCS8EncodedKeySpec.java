package java.security.spec;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/PKCS8EncodedKeySpec.class */
public class PKCS8EncodedKeySpec extends EncodedKeySpec {
    public PKCS8EncodedKeySpec(byte[] bArr) {
        super(bArr);
    }

    @Override // java.security.spec.EncodedKeySpec
    public byte[] getEncoded() {
        return super.getEncoded();
    }

    @Override // java.security.spec.EncodedKeySpec
    public final String getFormat() {
        return "PKCS#8";
    }
}
