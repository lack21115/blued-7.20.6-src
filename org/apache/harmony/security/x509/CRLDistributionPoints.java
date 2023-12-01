package org.apache.harmony.security.x509;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/CRLDistributionPoints.class */
public final class CRLDistributionPoints extends ExtensionValue {
    public static final ASN1Type ASN1 = new ASN1SequenceOf(DistributionPoint.ASN1) { // from class: org.apache.harmony.security.x509.CRLDistributionPoints.1
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            return new CRLDistributionPoints((List) berInputStream.content, berInputStream.getEncoded());
        }

        @Override // org.apache.harmony.security.asn1.ASN1ValueCollection
        public Collection<?> getValues(Object obj) {
            return ((CRLDistributionPoints) obj).distributionPoints;
        }
    };
    private List<DistributionPoint> distributionPoints;
    private byte[] encoding;

    private CRLDistributionPoints(List<DistributionPoint> list, byte[] bArr) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("distributionPoints are empty");
        }
        this.distributionPoints = list;
        this.encoding = bArr;
    }

    public static CRLDistributionPoints decode(byte[] bArr) throws IOException {
        return (CRLDistributionPoints) ASN1.decode(bArr);
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public void dumpValue(StringBuilder sb, String str) {
        sb.append(str).append("CRL Distribution Points: [\n");
        int i = 0;
        for (DistributionPoint distributionPoint : this.distributionPoints) {
            i++;
            sb.append(str).append("  [").append(i).append("]\n");
            distributionPoint.dumpValue(sb, str + "  ");
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
