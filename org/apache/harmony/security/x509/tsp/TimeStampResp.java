package org.apache.harmony.security.x509.tsp;

import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.pkcs7.ContentInfo;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/tsp/TimeStampResp.class */
public class TimeStampResp {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{PKIStatusInfo.ASN1, ContentInfo.ASN1}) { // from class: org.apache.harmony.security.x509.tsp.TimeStampResp.1
        {
            setOptional(1);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            return new TimeStampResp((PKIStatusInfo) objArr[0], (ContentInfo) objArr[1]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            TimeStampResp timeStampResp = (TimeStampResp) obj;
            objArr[0] = timeStampResp.status;
            objArr[1] = timeStampResp.timeStampToken;
        }
    };
    private final PKIStatusInfo status;
    private final ContentInfo timeStampToken;

    public TimeStampResp(PKIStatusInfo pKIStatusInfo, ContentInfo contentInfo) {
        this.status = pKIStatusInfo;
        this.timeStampToken = contentInfo;
    }

    public PKIStatusInfo getStatus() {
        return this.status;
    }

    public ContentInfo getTimeStampToken() {
        return this.timeStampToken;
    }

    public String toString() {
        return "-- TimeStampResp:\nstatus:  " + this.status + "\ntimeStampToken:  " + this.timeStampToken + "\n-- TimeStampResp End\n";
    }
}
