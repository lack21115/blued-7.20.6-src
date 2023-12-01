package org.apache.harmony.security.x509;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/InfoAccessSyntax.class */
public final class InfoAccessSyntax extends ExtensionValue {
    public static final ASN1Type ASN1 = new ASN1SequenceOf(AccessDescription.ASN1) { // from class: org.apache.harmony.security.x509.InfoAccessSyntax.1
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
            return new InfoAccessSyntax((List) berInputStream.content, berInputStream.getEncoded());
        }

        @Override // org.apache.harmony.security.asn1.ASN1ValueCollection
        public Collection getValues(Object obj) {
            return ((InfoAccessSyntax) obj).accessDescriptions;
        }
    };
    private final List<?> accessDescriptions;

    private InfoAccessSyntax(List<?> list, byte[] bArr) throws IOException {
        if (list == null || list.isEmpty()) {
            throw new IOException("AccessDescriptions list is null or empty");
        }
        this.accessDescriptions = list;
        this.encoding = bArr;
    }

    public static InfoAccessSyntax decode(byte[] bArr) throws IOException {
        return (InfoAccessSyntax) ASN1.decode(bArr);
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public void dumpValue(StringBuilder sb, String str) {
        sb.append(str).append("AccessDescriptions:\n");
        if (this.accessDescriptions == null || this.accessDescriptions.isEmpty()) {
            sb.append("NULL\n");
            return;
        }
        Iterator<?> it = this.accessDescriptions.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n---- InfoAccessSyntax:");
        if (this.accessDescriptions != null) {
            for (Object obj : this.accessDescriptions) {
                sb.append('\n');
                sb.append(obj);
            }
        }
        sb.append("\n---- InfoAccessSyntax END\n");
        return sb.toString();
    }
}
