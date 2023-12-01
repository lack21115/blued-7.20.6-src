package org.apache.harmony.security.x509;

import java.io.IOException;
import java.math.BigInteger;
import org.apache.harmony.security.asn1.ASN1Integer;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/InhibitAnyPolicy.class */
public final class InhibitAnyPolicy extends ExtensionValue {
    private final int skipCerts;

    public InhibitAnyPolicy(byte[] bArr) throws IOException {
        super(bArr);
        this.skipCerts = new BigInteger((byte[]) ASN1Integer.getInstance().decode(bArr)).intValue();
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public void dumpValue(StringBuilder sb, String str) {
        sb.append(str).append("Inhibit Any-Policy: ").append(this.skipCerts).append('\n');
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1Integer.getInstance().encode(ASN1Integer.fromIntValue(this.skipCerts));
        }
        return this.encoding;
    }
}
