package org.apache.harmony.security.pkcs7;

import java.util.List;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1SetOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x509.AlgorithmIdentifier;
import org.apache.harmony.security.x509.Certificate;
import org.apache.harmony.security.x509.CertificateList;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/pkcs7/SignedData.class */
public final class SignedData {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{ASN1Integer.getInstance(), new ASN1SetOf(AlgorithmIdentifier.ASN1), ContentInfo.ASN1, new ASN1Implicit(0, new ASN1SetOf(Certificate.ASN1)), new ASN1Implicit(1, new ASN1SetOf(CertificateList.ASN1)), new ASN1SetOf(SignerInfo.ASN1)}) { // from class: org.apache.harmony.security.pkcs7.SignedData.1
        {
            setOptional(3);
            setOptional(4);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            return new SignedData(ASN1Integer.toIntValue(objArr[0]), (List) objArr[1], (ContentInfo) objArr[2], (List) objArr[3], (List) objArr[4], (List) objArr[5]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            SignedData signedData = (SignedData) obj;
            byte[] bArr = new byte[1];
            bArr[0] = (byte) signedData.version;
            objArr[0] = bArr;
            objArr[1] = signedData.digestAlgorithms;
            objArr[2] = signedData.contentInfo;
            objArr[3] = signedData.certificates;
            objArr[4] = signedData.crls;
            objArr[5] = signedData.signerInfos;
        }
    };
    private final List<Certificate> certificates;
    private final ContentInfo contentInfo;
    private final List<CertificateList> crls;
    private final List<?> digestAlgorithms;
    private final List<SignerInfo> signerInfos;
    private final int version;

    private SignedData(int i, List<?> list, ContentInfo contentInfo, List<Certificate> list2, List<CertificateList> list3, List<SignerInfo> list4) {
        this.version = i;
        this.digestAlgorithms = list;
        this.contentInfo = contentInfo;
        this.certificates = list2;
        this.crls = list3;
        this.signerInfos = list4;
    }

    public List<CertificateList> getCRLs() {
        return this.crls;
    }

    public List<Certificate> getCertificates() {
        return this.certificates;
    }

    public List<SignerInfo> getSignerInfos() {
        return this.signerInfos;
    }

    public int getVersion() {
        return this.version;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---- SignedData:");
        sb.append("\nversion: ");
        sb.append(this.version);
        sb.append("\ndigestAlgorithms: ");
        sb.append(this.digestAlgorithms.toString());
        sb.append("\ncontentInfo: ");
        sb.append(this.contentInfo.toString());
        sb.append("\ncertificates: ");
        if (this.certificates != null) {
            sb.append(this.certificates.toString());
        }
        sb.append("\ncrls: ");
        if (this.crls != null) {
            sb.append(this.crls.toString());
        }
        sb.append("\nsignerInfos:\n");
        sb.append(this.signerInfos.toString());
        sb.append("\n---- SignedData End\n]");
        return sb.toString();
    }
}
