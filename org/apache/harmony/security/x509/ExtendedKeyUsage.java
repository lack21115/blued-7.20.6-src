package org.apache.harmony.security.x509;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/ExtendedKeyUsage.class */
public final class ExtendedKeyUsage extends ExtensionValue {
    public static final ASN1Type ASN1 = new ASN1SequenceOf(new ASN1Oid() { // from class: org.apache.harmony.security.x509.ExtendedKeyUsage.1
        @Override // org.apache.harmony.security.asn1.ASN1Oid, org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
            return ObjectIdentifier.toString((int[]) super.getDecodedObject(berInputStream));
        }
    });
    private List<String> keys;

    public ExtendedKeyUsage(byte[] bArr) {
        super(bArr);
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public void dumpValue(StringBuilder sb, String str) {
        sb.append(str).append("Extended Key Usage: ");
        if (this.keys == null) {
            try {
                this.keys = getExtendedKeyUsage();
            } catch (IOException e) {
                super.dumpValue(sb);
                return;
            }
        }
        sb.append('[');
        Iterator<String> it = this.keys.iterator();
        while (it.hasNext()) {
            sb.append(" \"").append((Object) it.next()).append('\"');
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(" ]\n");
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this.keys);
        }
        return this.encoding;
    }

    public List<String> getExtendedKeyUsage() throws IOException {
        if (this.keys == null) {
            this.keys = (List) ASN1.decode(getEncoded());
        }
        return this.keys;
    }
}
