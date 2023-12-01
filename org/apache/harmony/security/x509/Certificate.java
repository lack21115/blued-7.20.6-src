package org.apache.harmony.security.x509;

import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BitString;
import org.apache.harmony.security.utils.Array;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/Certificate.class */
public final class Certificate {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{TBSCertificate.ASN1, AlgorithmIdentifier.ASN1, ASN1BitString.getInstance()}) { // from class: org.apache.harmony.security.x509.Certificate.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            return new Certificate((TBSCertificate) objArr[0], (AlgorithmIdentifier) objArr[1], ((BitString) objArr[2]).bytes, berInputStream.getEncoded());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            Certificate certificate = (Certificate) obj;
            objArr[0] = certificate.tbsCertificate;
            objArr[1] = certificate.signatureAlgorithm;
            objArr[2] = new BitString(certificate.signatureValue, 0);
        }
    };
    private byte[] encoding;
    private final AlgorithmIdentifier signatureAlgorithm;
    private final byte[] signatureValue;
    private final TBSCertificate tbsCertificate;

    public Certificate(TBSCertificate tBSCertificate, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.tbsCertificate = tBSCertificate;
        this.signatureAlgorithm = algorithmIdentifier;
        this.signatureValue = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.signatureValue, 0, bArr.length);
    }

    private Certificate(TBSCertificate tBSCertificate, AlgorithmIdentifier algorithmIdentifier, byte[] bArr, byte[] bArr2) {
        this(tBSCertificate, algorithmIdentifier, bArr);
        this.encoding = bArr2;
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public byte[] getSignatureValue() {
        return (byte[]) this.signatureValue.clone();
    }

    public TBSCertificate getTbsCertificate() {
        return this.tbsCertificate;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("X.509 Certificate:\n[\n");
        this.tbsCertificate.dumpValue(sb);
        sb.append("\n  Algorithm: [");
        this.signatureAlgorithm.dumpValue(sb);
        sb.append(']');
        sb.append("\n  Signature Value:\n");
        sb.append(Array.toString(this.signatureValue, ""));
        sb.append(']');
        return sb.toString();
    }
}
