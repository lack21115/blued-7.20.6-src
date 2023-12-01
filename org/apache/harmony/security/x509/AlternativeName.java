package org.apache.harmony.security.x509;

import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/AlternativeName.class */
public final class AlternativeName extends ExtensionValue {
    public static final boolean ISSUER = false;
    public static final boolean SUBJECT = true;
    private GeneralNames alternativeNames;
    private boolean which;

    public AlternativeName(boolean z, byte[] bArr) throws IOException {
        super(bArr);
        this.which = z;
        this.alternativeNames = (GeneralNames) GeneralNames.ASN1.decode(bArr);
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public void dumpValue(StringBuilder sb, String str) {
        sb.append(str).append(this.which ? "Subject" : "Issuer").append(" Alternative Names [\n");
        this.alternativeNames.dumpValue(sb, str + "  ");
        sb.append(str).append("]\n");
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = GeneralNames.ASN1.encode(this.alternativeNames);
        }
        return this.encoding;
    }
}
