package org.apache.harmony.security.x509;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/CertificatePolicies.class */
public final class CertificatePolicies extends ExtensionValue {
    public static final ASN1Type ASN1 = new ASN1SequenceOf(PolicyInformation.ASN1) { // from class: org.apache.harmony.security.x509.CertificatePolicies.1
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            return new CertificatePolicies((List) berInputStream.content, berInputStream.getEncoded());
        }

        @Override // org.apache.harmony.security.asn1.ASN1ValueCollection
        public Collection getValues(Object obj) {
            return ((CertificatePolicies) obj).policyInformations;
        }
    };
    private byte[] encoding;
    private List<PolicyInformation> policyInformations;

    public CertificatePolicies() {
    }

    private CertificatePolicies(List<PolicyInformation> list, byte[] bArr) {
        this.policyInformations = list;
        this.encoding = bArr;
    }

    public static CertificatePolicies decode(byte[] bArr) throws IOException {
        CertificatePolicies certificatePolicies = (CertificatePolicies) ASN1.decode(bArr);
        certificatePolicies.encoding = bArr;
        return certificatePolicies;
    }

    public CertificatePolicies addPolicyInformation(PolicyInformation policyInformation) {
        this.encoding = null;
        if (this.policyInformations == null) {
            this.policyInformations = new ArrayList();
        }
        this.policyInformations.add(policyInformation);
        return this;
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public void dumpValue(StringBuilder sb, String str) {
        sb.append(str).append("CertificatePolicies [\n");
        for (PolicyInformation policyInformation : this.policyInformations) {
            sb.append(str);
            sb.append("  ");
            policyInformation.dumpValue(sb);
            sb.append('\n');
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

    public List<PolicyInformation> getPolicyInformations() {
        return new ArrayList(this.policyInformations);
    }
}
