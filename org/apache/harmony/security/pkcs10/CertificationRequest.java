package org.apache.harmony.security.pkcs10;

import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BitString;
import org.apache.harmony.security.x509.AlgorithmIdentifier;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/pkcs10/CertificationRequest.class */
public final class CertificationRequest {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{CertificationRequestInfo.ASN1, AlgorithmIdentifier.ASN1, ASN1BitString.getInstance()}) { // from class: org.apache.harmony.security.pkcs10.CertificationRequest.1
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            return new CertificationRequest((CertificationRequestInfo) objArr[0], (AlgorithmIdentifier) objArr[1], ((BitString) objArr[2]).bytes, berInputStream.getEncoded());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            CertificationRequest certificationRequest = (CertificationRequest) obj;
            objArr[0] = certificationRequest.info;
            objArr[1] = certificationRequest.algId;
            objArr[2] = new BitString(certificationRequest.signature, 0);
        }
    };
    private AlgorithmIdentifier algId;
    private byte[] encoding;
    private CertificationRequestInfo info;
    private byte[] signature;

    public CertificationRequest(CertificationRequestInfo certificationRequestInfo, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.info = certificationRequestInfo;
        this.algId = algorithmIdentifier;
        this.signature = (byte[]) bArr.clone();
    }

    private CertificationRequest(CertificationRequestInfo certificationRequestInfo, AlgorithmIdentifier algorithmIdentifier, byte[] bArr, byte[] bArr2) {
        this(certificationRequestInfo, algorithmIdentifier, bArr);
        this.encoding = bArr2;
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public CertificationRequestInfo getInfo() {
        return this.info;
    }

    public byte[] getSignature() {
        byte[] bArr = new byte[this.signature.length];
        System.arraycopy(this.signature, 0, bArr, 0, this.signature.length);
        return bArr;
    }
}
