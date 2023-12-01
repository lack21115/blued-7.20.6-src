package org.apache.harmony.security.x509;

import java.io.IOException;
import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BerOutputStream;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/ReasonFlags.class */
public final class ReasonFlags {
    private final boolean[] flags;
    static final String[] REASONS = {"unused", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "privilegeWithdrawn", "aACompromise"};
    public static final ASN1BitString ASN1 = new ASN1BitString.ASN1NamedBitList(REASONS.length) { // from class: org.apache.harmony.security.x509.ReasonFlags.1
        @Override // org.apache.harmony.security.asn1.ASN1BitString.ASN1NamedBitList, org.apache.harmony.security.asn1.ASN1BitString, org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
            return new ReasonFlags((boolean[]) super.getDecodedObject(berInputStream));
        }

        @Override // org.apache.harmony.security.asn1.ASN1BitString.ASN1NamedBitList, org.apache.harmony.security.asn1.ASN1BitString, org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
        public void setEncodingContent(BerOutputStream berOutputStream) {
            berOutputStream.content = ((ReasonFlags) berOutputStream.content).flags;
            super.setEncodingContent(berOutputStream);
        }
    };

    public ReasonFlags(boolean[] zArr) {
        this.flags = zArr;
    }

    public void dumpValue(StringBuilder sb, String str) {
        sb.append(str);
        sb.append("ReasonFlags [\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.flags.length) {
                sb.append(str);
                sb.append("]\n");
                return;
            }
            if (this.flags[i2]) {
                sb.append(str).append("  ").append(REASONS[i2]).append('\n');
            }
            i = i2 + 1;
        }
    }
}
