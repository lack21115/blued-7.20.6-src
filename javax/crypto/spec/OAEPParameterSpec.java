package javax.crypto.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.spec.PSource;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/spec/OAEPParameterSpec.class */
public class OAEPParameterSpec implements AlgorithmParameterSpec {
    public static final OAEPParameterSpec DEFAULT = new OAEPParameterSpec();
    private final String mdName;
    private final String mgfName;
    private final AlgorithmParameterSpec mgfSpec;
    private final PSource pSrc;

    private OAEPParameterSpec() {
        this.mdName = "SHA-1";
        this.mgfName = "MGF1";
        this.mgfSpec = MGF1ParameterSpec.SHA1;
        this.pSrc = PSource.PSpecified.DEFAULT;
    }

    public OAEPParameterSpec(String str, String str2, AlgorithmParameterSpec algorithmParameterSpec, PSource pSource) {
        if (str == null) {
            throw new NullPointerException("mdName == null");
        }
        if (str2 == null) {
            throw new NullPointerException("mgfName == null");
        }
        if (pSource == null) {
            throw new NullPointerException("pSrc == null");
        }
        this.mdName = str;
        this.mgfName = str2;
        this.mgfSpec = algorithmParameterSpec;
        this.pSrc = pSource;
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

    public PSource getPSource() {
        return this.pSrc;
    }
}
