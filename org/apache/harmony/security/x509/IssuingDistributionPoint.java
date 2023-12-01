package org.apache.harmony.security.x509;

import java.io.IOException;
import org.apache.harmony.security.asn1.ASN1Boolean;
import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/IssuingDistributionPoint.class */
public final class IssuingDistributionPoint extends ExtensionValue {
    public static final ASN1Type ASN1 = new ASN1Sequence(new ASN1Type[]{new ASN1Explicit(0, DistributionPointName.ASN1), new ASN1Implicit(1, ASN1Boolean.getInstance()), new ASN1Implicit(2, ASN1Boolean.getInstance()), new ASN1Implicit(3, ReasonFlags.ASN1), new ASN1Implicit(4, ASN1Boolean.getInstance()), new ASN1Implicit(5, ASN1Boolean.getInstance())}) { // from class: org.apache.harmony.security.x509.IssuingDistributionPoint.1
        {
            setOptional(0);
            setOptional(3);
            setDefault(Boolean.FALSE, 1);
            setDefault(Boolean.FALSE, 2);
            setDefault(Boolean.FALSE, 4);
            setDefault(Boolean.FALSE, 5);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            IssuingDistributionPoint issuingDistributionPoint = new IssuingDistributionPoint((DistributionPointName) objArr[0], (ReasonFlags) objArr[3]);
            issuingDistributionPoint.encoding = berInputStream.getEncoded();
            if (objArr[1] != null) {
                issuingDistributionPoint.setOnlyContainsUserCerts(((Boolean) objArr[1]).booleanValue());
            }
            if (objArr[2] != null) {
                issuingDistributionPoint.setOnlyContainsCACerts(((Boolean) objArr[2]).booleanValue());
            }
            if (objArr[4] != null) {
                issuingDistributionPoint.setIndirectCRL(((Boolean) objArr[4]).booleanValue());
            }
            if (objArr[5] != null) {
                issuingDistributionPoint.setOnlyContainsAttributeCerts(((Boolean) objArr[5]).booleanValue());
            }
            return issuingDistributionPoint;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            IssuingDistributionPoint issuingDistributionPoint = (IssuingDistributionPoint) obj;
            objArr[0] = issuingDistributionPoint.distributionPoint;
            objArr[1] = issuingDistributionPoint.onlyContainsUserCerts ? Boolean.TRUE : null;
            objArr[2] = issuingDistributionPoint.onlyContainsCACerts ? Boolean.TRUE : null;
            objArr[3] = issuingDistributionPoint.onlySomeReasons;
            objArr[4] = issuingDistributionPoint.indirectCRL ? Boolean.TRUE : null;
            Boolean bool = null;
            if (issuingDistributionPoint.onlyContainsAttributeCerts) {
                bool = Boolean.TRUE;
            }
            objArr[5] = bool;
        }
    };
    private DistributionPointName distributionPoint;
    private ReasonFlags onlySomeReasons;
    private boolean onlyContainsUserCerts = false;
    private boolean onlyContainsCACerts = false;
    private boolean indirectCRL = false;
    private boolean onlyContainsAttributeCerts = false;

    public IssuingDistributionPoint(DistributionPointName distributionPointName, ReasonFlags reasonFlags) {
        this.distributionPoint = distributionPointName;
        this.onlySomeReasons = reasonFlags;
    }

    public static IssuingDistributionPoint decode(byte[] bArr) throws IOException {
        IssuingDistributionPoint issuingDistributionPoint = (IssuingDistributionPoint) ASN1.decode(bArr);
        issuingDistributionPoint.encoding = bArr;
        return issuingDistributionPoint;
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public void dumpValue(StringBuilder sb, String str) {
        sb.append(str).append("Issuing Distribution Point: [\n");
        if (this.distributionPoint != null) {
            this.distributionPoint.dumpValue(sb, "  " + str);
        }
        sb.append(str).append("  onlyContainsUserCerts: ").append(this.onlyContainsUserCerts).append('\n');
        sb.append(str).append("  onlyContainsCACerts: ").append(this.onlyContainsCACerts).append('\n');
        if (this.onlySomeReasons != null) {
            this.onlySomeReasons.dumpValue(sb, str + "  ");
        }
        sb.append(str).append("  indirectCRL: ").append(this.indirectCRL).append('\n');
        sb.append(str).append("  onlyContainsAttributeCerts: ").append(this.onlyContainsAttributeCerts).append('\n');
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public void setIndirectCRL(boolean z) {
        this.indirectCRL = z;
    }

    public void setOnlyContainsAttributeCerts(boolean z) {
        this.onlyContainsAttributeCerts = z;
    }

    public void setOnlyContainsCACerts(boolean z) {
        this.onlyContainsCACerts = z;
    }

    public void setOnlyContainsUserCerts(boolean z) {
        this.onlyContainsUserCerts = z;
    }
}
