package org.apache.harmony.security.x509.tsp;

import java.math.BigInteger;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1StringType;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BitString;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/tsp/PKIStatusInfo.class */
public class PKIStatusInfo {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{ASN1Integer.getInstance(), new ASN1SequenceOf(ASN1StringType.UTF8STRING), ASN1BitString.getInstance()}) { // from class: org.apache.harmony.security.x509.tsp.PKIStatusInfo.1
        {
            setOptional(1);
            setOptional(2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            int i = -1;
            if (objArr[2] != null) {
                boolean[] booleanArray = ((BitString) objArr[2]).toBooleanArray();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    i = -1;
                    if (i3 >= booleanArray.length) {
                        break;
                    } else if (booleanArray[i3]) {
                        i = i3;
                        break;
                    } else {
                        i2 = i3 + 1;
                    }
                }
            }
            return new PKIStatusInfo(PKIStatus.getInstance(ASN1Integer.toIntValue(objArr[0])), (List) objArr[1], PKIFailureInfo.getInstance(i));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            PKIStatusInfo pKIStatusInfo = (PKIStatusInfo) obj;
            objArr[0] = BigInteger.valueOf(pKIStatusInfo.status.getStatus()).toByteArray();
            objArr[1] = pKIStatusInfo.statusString;
            if (pKIStatusInfo.failInfo == null) {
                objArr[2] = null;
                return;
            }
            boolean[] zArr = new boolean[PKIFailureInfo.getMaxValue()];
            zArr[pKIStatusInfo.failInfo.getValue()] = true;
            objArr[2] = new BitString(zArr);
        }
    };
    private final PKIFailureInfo failInfo;
    private final PKIStatus status;
    private final List statusString;

    public PKIStatusInfo(PKIStatus pKIStatus, List list, PKIFailureInfo pKIFailureInfo) {
        this.status = pKIStatus;
        this.statusString = list;
        this.failInfo = pKIFailureInfo;
    }

    public PKIFailureInfo getFailInfo() {
        return this.failInfo;
    }

    public PKIStatus getStatus() {
        return this.status;
    }

    public List getStatusString() {
        return this.statusString;
    }

    public String toString() {
        return "-- PKIStatusInfo:\nPKIStatus : " + this.status + "\nstatusString:  " + this.statusString + "\nfailInfo:  " + this.failInfo + "\n-- PKIStatusInfo End\n";
    }
}
