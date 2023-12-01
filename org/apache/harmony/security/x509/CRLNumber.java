package org.apache.harmony.security.x509;

import java.io.IOException;
import java.math.BigInteger;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Type;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/CRLNumber.class */
public final class CRLNumber extends ExtensionValue {
    public static final ASN1Type ASN1 = ASN1Integer.getInstance();
    private final BigInteger number;

    public CRLNumber(byte[] bArr) throws IOException {
        super(bArr);
        this.number = new BigInteger((byte[]) ASN1.decode(bArr));
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public void dumpValue(StringBuilder sb, String str) {
        sb.append(str).append("CRL Number: [ ").append(this.number).append(" ]\n");
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this.number.toByteArray());
        }
        return this.encoding;
    }

    public BigInteger getNumber() {
        return this.number;
    }
}
