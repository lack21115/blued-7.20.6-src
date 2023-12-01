package org.apache.harmony.security.x509;

import java.io.IOException;
import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.ASN1Type;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/KeyUsage.class */
public final class KeyUsage extends ExtensionValue {
    private final boolean[] keyUsage;
    private static final String[] USAGES = {"digitalSignature", "nonRepudiation", "keyEncipherment", "dataEncipherment", "keyAgreement", "keyCertSign", "cRLSign", "encipherOnly", "decipherOnly"};
    private static final ASN1Type ASN1 = new ASN1BitString.ASN1NamedBitList(9);

    public KeyUsage(byte[] bArr) throws IOException {
        super(bArr);
        this.keyUsage = (boolean[]) ASN1.decode(bArr);
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public void dumpValue(StringBuilder sb, String str) {
        sb.append(str).append("KeyUsage [\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.keyUsage.length) {
                sb.append(str).append("]\n");
                return;
            }
            if (this.keyUsage[i2]) {
                sb.append(str).append("  ").append(USAGES[i2]).append('\n');
            }
            i = i2 + 1;
        }
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this.keyUsage);
        }
        return this.encoding;
    }

    public boolean[] getKeyUsage() {
        return this.keyUsage;
    }
}
