package javax.crypto.spec;

import java.security.spec.AlgorithmParameterSpec;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/spec/DHGenParameterSpec.class */
public class DHGenParameterSpec implements AlgorithmParameterSpec {
    private final int exponentSize;
    private final int primeSize;

    public DHGenParameterSpec(int i, int i2) {
        this.primeSize = i;
        this.exponentSize = i2;
    }

    public int getExponentSize() {
        return this.exponentSize;
    }

    public int getPrimeSize() {
        return this.primeSize;
    }
}
