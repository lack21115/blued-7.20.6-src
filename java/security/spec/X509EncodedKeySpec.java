package java.security.spec;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/X509EncodedKeySpec.class */
public class X509EncodedKeySpec extends EncodedKeySpec {
    public X509EncodedKeySpec(byte[] bArr) {
        super(bArr);
    }

    @Override // java.security.spec.EncodedKeySpec
    public byte[] getEncoded() {
        return super.getEncoded();
    }

    @Override // java.security.spec.EncodedKeySpec
    public final String getFormat() {
        return "X.509";
    }
}
