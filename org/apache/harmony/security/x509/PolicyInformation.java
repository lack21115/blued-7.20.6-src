package org.apache.harmony.security.x509;

import org.apache.harmony.security.asn1.ASN1Any;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/PolicyInformation.class */
public final class PolicyInformation {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{ASN1Oid.getInstance(), ASN1Any.getInstance()}) { // from class: org.apache.harmony.security.x509.PolicyInformation.1
        {
            setOptional(1);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            return new PolicyInformation(ObjectIdentifier.toString((int[]) ((Object[]) berInputStream.content)[0]));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            objArr[0] = ObjectIdentifier.toIntArray(((PolicyInformation) obj).policyIdentifier);
        }
    };
    private byte[] encoding;
    private final String policyIdentifier;

    public PolicyInformation(String str) {
        this.policyIdentifier = str;
    }

    public void dumpValue(StringBuilder sb) {
        sb.append("Policy Identifier [").append(this.policyIdentifier).append(']');
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public String getPolicyIdentifier() {
        return this.policyIdentifier;
    }
}
