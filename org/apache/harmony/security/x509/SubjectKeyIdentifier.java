package org.apache.harmony.security.x509;

import java.io.IOException;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.utils.Array;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/SubjectKeyIdentifier.class */
public final class SubjectKeyIdentifier extends ExtensionValue {
    private final byte[] keyIdentifier;

    public SubjectKeyIdentifier(byte[] bArr) {
        this.keyIdentifier = bArr;
    }

    public static SubjectKeyIdentifier decode(byte[] bArr) throws IOException {
        SubjectKeyIdentifier subjectKeyIdentifier = new SubjectKeyIdentifier((byte[]) ASN1OctetString.getInstance().decode(bArr));
        subjectKeyIdentifier.encoding = bArr;
        return subjectKeyIdentifier;
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public void dumpValue(StringBuilder sb, String str) {
        sb.append(str).append("SubjectKeyIdentifier: [\n");
        sb.append(Array.toString(this.keyIdentifier, str));
        sb.append(str).append("]\n");
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1OctetString.getInstance().encode(this.keyIdentifier);
        }
        return this.encoding;
    }

    public byte[] getKeyIdentifier() {
        return this.keyIdentifier;
    }
}
