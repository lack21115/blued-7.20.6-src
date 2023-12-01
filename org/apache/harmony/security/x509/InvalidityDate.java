package org.apache.harmony.security.x509;

import java.io.IOException;
import java.util.Date;
import org.apache.harmony.security.asn1.ASN1GeneralizedTime;
import org.apache.harmony.security.asn1.ASN1Type;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/InvalidityDate.class */
public final class InvalidityDate extends ExtensionValue {
    public static final ASN1Type ASN1 = ASN1GeneralizedTime.getInstance();
    private final Date date;

    public InvalidityDate(Date date) {
        this.date = (Date) date.clone();
    }

    public InvalidityDate(byte[] bArr) throws IOException {
        super(bArr);
        this.date = (Date) ASN1.decode(bArr);
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public void dumpValue(StringBuilder sb, String str) {
        sb.append(str).append("Invalidity Date: [ ").append(this.date).append(" ]\n");
    }

    public Date getDate() {
        return this.date;
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this.date);
        }
        return this.encoding;
    }
}
