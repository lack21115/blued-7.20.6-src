package java.security.spec;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/ECGenParameterSpec.class */
public class ECGenParameterSpec implements AlgorithmParameterSpec {
    private final String name;

    public ECGenParameterSpec(String str) {
        this.name = str;
        if (this.name == null) {
            throw new NullPointerException("name == null");
        }
    }

    public String getName() {
        return this.name;
    }
}
