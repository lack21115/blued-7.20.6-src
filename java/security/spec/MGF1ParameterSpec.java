package java.security.spec;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/MGF1ParameterSpec.class */
public class MGF1ParameterSpec implements AlgorithmParameterSpec {
    public static final MGF1ParameterSpec SHA1 = new MGF1ParameterSpec("SHA-1");
    public static final MGF1ParameterSpec SHA256 = new MGF1ParameterSpec("SHA-256");
    public static final MGF1ParameterSpec SHA384 = new MGF1ParameterSpec("SHA-384");
    public static final MGF1ParameterSpec SHA512 = new MGF1ParameterSpec("SHA-512");
    private final String mdName;

    public MGF1ParameterSpec(String str) {
        this.mdName = str;
        if (this.mdName == null) {
            throw new NullPointerException("mdName == null");
        }
    }

    public String getDigestAlgorithm() {
        return this.mdName;
    }
}
