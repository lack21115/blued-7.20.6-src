package org.apache.harmony.security.x509;

import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BitString;
import org.apache.harmony.security.utils.Array;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/CertificateList.class */
public final class CertificateList {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{TBSCertList.ASN1, AlgorithmIdentifier.ASN1, ASN1BitString.getInstance()}) { // from class: org.apache.harmony.security.x509.CertificateList.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            return new CertificateList((TBSCertList) objArr[0], (AlgorithmIdentifier) objArr[1], ((BitString) objArr[2]).bytes, berInputStream.getEncoded());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            CertificateList certificateList = (CertificateList) obj;
            objArr[0] = certificateList.tbsCertList;
            objArr[1] = certificateList.signatureAlgorithm;
            objArr[2] = new BitString(certificateList.signatureValue, 0);
        }
    };
    private byte[] encoding;
    private final AlgorithmIdentifier signatureAlgorithm;
    private final byte[] signatureValue;
    private final TBSCertList tbsCertList;

    public CertificateList(TBSCertList tBSCertList, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.tbsCertList = tBSCertList;
        this.signatureAlgorithm = algorithmIdentifier;
        this.signatureValue = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.signatureValue, 0, bArr.length);
    }

    private CertificateList(TBSCertList tBSCertList, AlgorithmIdentifier algorithmIdentifier, byte[] bArr, byte[] bArr2) {
        this(tBSCertList, algorithmIdentifier, bArr);
        this.encoding = bArr2;
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public byte[] getSignatureValue() {
        byte[] bArr = new byte[this.signatureValue.length];
        System.arraycopy(this.signatureValue, 0, bArr, 0, this.signatureValue.length);
        return bArr;
    }

    public TBSCertList getTbsCertList() {
        return this.tbsCertList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.tbsCertList.dumpValue(sb);
        sb.append("\nSignature Value:\n");
        sb.append(Array.toString(this.signatureValue, ""));
        return sb.toString();
    }
}
