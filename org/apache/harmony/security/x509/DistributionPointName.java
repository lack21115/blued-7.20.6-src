package org.apache.harmony.security.x509;

import java.io.IOException;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1Choice;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.Name;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/DistributionPointName.class */
public final class DistributionPointName {
    public static final ASN1Choice ASN1 = new ASN1Choice(new ASN1Type[]{new ASN1Implicit(0, GeneralNames.ASN1), new ASN1Implicit(1, Name.ASN1_RDN)}) { // from class: org.apache.harmony.security.x509.DistributionPointName.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
            return berInputStream.choiceIndex == 0 ? new DistributionPointName((GeneralNames) berInputStream.content) : new DistributionPointName((Name) berInputStream.content);
        }

        @Override // org.apache.harmony.security.asn1.ASN1Choice
        public int getIndex(Object obj) {
            return ((DistributionPointName) obj).fullName == null ? 1 : 0;
        }

        @Override // org.apache.harmony.security.asn1.ASN1Choice
        public Object getObjectToEncode(Object obj) {
            DistributionPointName distributionPointName = (DistributionPointName) obj;
            return distributionPointName.fullName == null ? distributionPointName.nameRelativeToCRLIssuer : distributionPointName.fullName;
        }
    };
    private final GeneralNames fullName;
    private final Name nameRelativeToCRLIssuer;

    public DistributionPointName(Name name) {
        this.fullName = null;
        this.nameRelativeToCRLIssuer = name;
    }

    public DistributionPointName(GeneralNames generalNames) {
        this.fullName = generalNames;
        this.nameRelativeToCRLIssuer = null;
    }

    public void dumpValue(StringBuilder sb, String str) {
        sb.append(str);
        sb.append("Distribution Point Name: [\n");
        if (this.fullName != null) {
            this.fullName.dumpValue(sb, str + "  ");
        } else {
            sb.append(str);
            sb.append("  ");
            sb.append(this.nameRelativeToCRLIssuer.getName(X500Principal.RFC2253));
        }
        sb.append(str);
        sb.append("]\n");
    }
}
