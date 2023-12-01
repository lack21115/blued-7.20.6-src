package org.apache.harmony.security.x509;

import java.io.IOException;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.Name;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/CertificateIssuer.class */
public final class CertificateIssuer extends ExtensionValue {
    public static final ASN1Type ASN1 = new ASN1Sequence(new ASN1Type[]{GeneralName.ASN1}) { // from class: org.apache.harmony.security.x509.CertificateIssuer.1
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            return ((Name) ((GeneralName) ((Object[]) berInputStream.content)[0]).getName()).getX500Principal();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            objArr[0] = obj;
        }
    };
    private X500Principal issuer;

    public CertificateIssuer(byte[] bArr) {
        super(bArr);
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public void dumpValue(StringBuilder sb, String str) {
        sb.append(str).append("Certificate Issuer: ");
        if (this.issuer == null) {
            try {
                this.issuer = getIssuer();
            } catch (IOException e) {
                sb.append("Unparseable (incorrect!) extension value:\n");
                super.dumpValue(sb);
            }
        }
        sb.append(this.issuer).append('\n');
    }

    public X500Principal getIssuer() throws IOException {
        if (this.issuer == null) {
            this.issuer = (X500Principal) ASN1.decode(getEncoded());
        }
        return this.issuer;
    }
}
