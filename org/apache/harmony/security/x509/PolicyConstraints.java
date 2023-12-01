package org.apache.harmony.security.x509;

import java.io.IOException;
import java.math.BigInteger;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/PolicyConstraints.class */
public final class PolicyConstraints extends ExtensionValue {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{new ASN1Implicit(0, ASN1Integer.getInstance()), new ASN1Implicit(1, ASN1Integer.getInstance())}) { // from class: org.apache.harmony.security.x509.PolicyConstraints.1
        {
            setOptional(0);
            setOptional(1);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            BigInteger bigInteger = null;
            BigInteger bigInteger2 = null;
            if (objArr[0] != null) {
                bigInteger = new BigInteger((byte[]) objArr[0]);
            }
            if (objArr[1] != null) {
                bigInteger2 = new BigInteger((byte[]) objArr[1]);
            }
            return new PolicyConstraints(bigInteger, bigInteger2, berInputStream.getEncoded());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            PolicyConstraints policyConstraints = (PolicyConstraints) obj;
            objArr[0] = policyConstraints.requireExplicitPolicy.toByteArray();
            objArr[1] = policyConstraints.inhibitPolicyMapping.toByteArray();
        }
    };
    private byte[] encoding;
    private final BigInteger inhibitPolicyMapping;
    private final BigInteger requireExplicitPolicy;

    public PolicyConstraints(BigInteger bigInteger, BigInteger bigInteger2) {
        this.requireExplicitPolicy = bigInteger;
        this.inhibitPolicyMapping = bigInteger2;
    }

    private PolicyConstraints(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this(bigInteger, bigInteger2);
        this.encoding = bArr;
    }

    public PolicyConstraints(byte[] bArr) throws IOException {
        super(bArr);
        PolicyConstraints policyConstraints = (PolicyConstraints) ASN1.decode(bArr);
        this.requireExplicitPolicy = policyConstraints.requireExplicitPolicy;
        this.inhibitPolicyMapping = policyConstraints.inhibitPolicyMapping;
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public void dumpValue(StringBuilder sb, String str) {
        sb.append(str).append("PolicyConstraints: [\n");
        if (this.requireExplicitPolicy != null) {
            sb.append(str).append("  requireExplicitPolicy: ").append(this.requireExplicitPolicy).append('\n');
        }
        if (this.inhibitPolicyMapping != null) {
            sb.append(str).append("  inhibitPolicyMapping: ").append(this.inhibitPolicyMapping).append('\n');
        }
        sb.append(str).append("]\n");
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }
}
