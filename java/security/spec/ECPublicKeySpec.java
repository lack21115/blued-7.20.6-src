package java.security.spec;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/ECPublicKeySpec.class */
public class ECPublicKeySpec implements KeySpec {
    private final ECParameterSpec params;
    private final ECPoint w;

    public ECPublicKeySpec(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        this.w = eCPoint;
        this.params = eCParameterSpec;
        if (this.w == null) {
            throw new NullPointerException("w == null");
        }
        if (this.params == null) {
            throw new NullPointerException("params == null");
        }
        if (this.w.equals(ECPoint.POINT_INFINITY)) {
            throw new IllegalArgumentException("the w parameter is point at infinity");
        }
    }

    public ECParameterSpec getParams() {
        return this.params;
    }

    public ECPoint getW() {
        return this.w;
    }
}
