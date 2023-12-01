package org.apache.harmony.security.pkcs10;

import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1SetOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.AttributeTypeAndValue;
import org.apache.harmony.security.x501.Name;
import org.apache.harmony.security.x509.SubjectPublicKeyInfo;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/pkcs10/CertificationRequestInfo.class */
public final class CertificationRequestInfo {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{ASN1Integer.getInstance(), Name.ASN1, SubjectPublicKeyInfo.ASN1, new ASN1Implicit(0, new ASN1SetOf(AttributeTypeAndValue.ASN1))}) { // from class: org.apache.harmony.security.pkcs10.CertificationRequestInfo.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            return new CertificationRequestInfo(ASN1Integer.toIntValue(objArr[0]), (Name) objArr[1], (SubjectPublicKeyInfo) objArr[2], (List) objArr[3], berInputStream.getEncoded());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            CertificationRequestInfo certificationRequestInfo = (CertificationRequestInfo) obj;
            objArr[0] = ASN1Integer.fromIntValue(certificationRequestInfo.version);
            objArr[1] = certificationRequestInfo.subject;
            objArr[2] = certificationRequestInfo.subjectPublicKeyInfo;
            objArr[3] = certificationRequestInfo.attributes;
        }
    };
    private final List<?> attributes;
    private byte[] encoding;
    private final Name subject;
    private final SubjectPublicKeyInfo subjectPublicKeyInfo;
    private final int version;

    private CertificationRequestInfo(int i, Name name, SubjectPublicKeyInfo subjectPublicKeyInfo, List<?> list, byte[] bArr) {
        this.version = i;
        this.subject = name;
        this.subjectPublicKeyInfo = subjectPublicKeyInfo;
        this.attributes = list;
        this.encoding = bArr;
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public Name getSubject() {
        return this.subject;
    }

    public int getVersion() {
        return this.version;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-- CertificationRequestInfo:");
        sb.append("\n version: ");
        sb.append(this.version);
        sb.append("\n subject: ");
        sb.append(this.subject.getName(X500Principal.CANONICAL));
        sb.append("\n subjectPublicKeyInfo: ");
        sb.append("\n\t algorithm: ");
        sb.append(this.subjectPublicKeyInfo.getAlgorithmIdentifier().getAlgorithm());
        sb.append("\n\t public key: ").append(this.subjectPublicKeyInfo.getPublicKey());
        sb.append("\n attributes: ");
        if (this.attributes != null) {
            sb.append(this.attributes.toString());
        } else {
            sb.append("none");
        }
        sb.append("\n-- CertificationRequestInfo End\n");
        return sb.toString();
    }
}
