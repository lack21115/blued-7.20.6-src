package java.security.spec;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/PSSParameterSpec.class */
public class PSSParameterSpec implements AlgorithmParameterSpec {
    public static final PSSParameterSpec DEFAULT = new PSSParameterSpec(20);
    private final String mdName;
    private final String mgfName;
    private final AlgorithmParameterSpec mgfSpec;
    private final int saltLen;
    private final int trailerField;

    public PSSParameterSpec(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("saltLen < 0");
        }
        this.saltLen = i;
        this.mdName = "SHA-1";
        this.mgfName = "MGF1";
        this.mgfSpec = MGF1ParameterSpec.SHA1;
        this.trailerField = 1;
    }

    public PSSParameterSpec(String str, String str2, AlgorithmParameterSpec algorithmParameterSpec, int i, int i2) {
        if (str == null) {
            throw new NullPointerException("mdName == null");
        }
        if (str2 == null) {
            throw new NullPointerException("mgfName == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("saltLen < 0");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("trailerField < 0");
        }
        this.mdName = str;
        this.mgfName = str2;
        this.mgfSpec = algorithmParameterSpec;
        this.saltLen = i;
        this.trailerField = i2;
    }

    public String getDigestAlgorithm() {
        return this.mdName;
    }

    public String getMGFAlgorithm() {
        return this.mgfName;
    }

    public AlgorithmParameterSpec getMGFParameters() {
        return this.mgfSpec;
    }

    public int getSaltLength() {
        return this.saltLen;
    }

    public int getTrailerField() {
        return this.trailerField;
    }
}
