package org.apache.harmony.security.x509;

import java.io.IOException;
import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/DistributionPoint.class */
public final class DistributionPoint {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{new ASN1Explicit(0, DistributionPointName.ASN1), new ASN1Implicit(1, ReasonFlags.ASN1), new ASN1Implicit(2, GeneralNames.ASN1)}) { // from class: org.apache.harmony.security.x509.DistributionPoint.1
        {
            setOptional(0);
            setOptional(1);
            setOptional(2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
            Object[] objArr = (Object[]) berInputStream.content;
            return new DistributionPoint((DistributionPointName) objArr[0], (ReasonFlags) objArr[1], (GeneralNames) objArr[2]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            DistributionPoint distributionPoint = (DistributionPoint) obj;
            objArr[0] = distributionPoint.distributionPoint;
            objArr[1] = distributionPoint.reasons;
            objArr[2] = distributionPoint.cRLIssuer;
        }
    };
    private final GeneralNames cRLIssuer;
    private final DistributionPointName distributionPoint;
    private final ReasonFlags reasons;

    public DistributionPoint(DistributionPointName distributionPointName, ReasonFlags reasonFlags, GeneralNames generalNames) {
        if (reasonFlags != null && distributionPointName == null && generalNames == null) {
            throw new IllegalArgumentException("DistributionPoint MUST NOT consist of only the reasons field");
        }
        this.distributionPoint = distributionPointName;
        this.reasons = reasonFlags;
        this.cRLIssuer = generalNames;
    }

    public void dumpValue(StringBuilder sb, String str) {
        sb.append(str);
        sb.append("Distribution Point: [\n");
        if (this.distributionPoint != null) {
            this.distributionPoint.dumpValue(sb, str + "  ");
        }
        if (this.reasons != null) {
            this.reasons.dumpValue(sb, str + "  ");
        }
        if (this.cRLIssuer != null) {
            sb.append(str);
            sb.append("  CRL Issuer: [\n");
            this.cRLIssuer.dumpValue(sb, str + "    ");
            sb.append(str);
            sb.append("  ]\n");
        }
        sb.append(str);
        sb.append("]\n");
    }
}
