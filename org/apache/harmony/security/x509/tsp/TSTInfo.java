package org.apache.harmony.security.x509.tsp;

import java.math.BigInteger;
import java.util.Date;
import org.apache.harmony.security.asn1.ASN1Boolean;
import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1GeneralizedTime;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;
import org.apache.harmony.security.x509.Extensions;
import org.apache.harmony.security.x509.GeneralName;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/tsp/TSTInfo.class */
public class TSTInfo {
    public static final ASN1Sequence ACCURACY = new ASN1Sequence(new ASN1Type[]{ASN1Integer.getInstance(), ASN1Integer.getInstance(), ASN1Integer.getInstance()}) { // from class: org.apache.harmony.security.x509.tsp.TSTInfo.1
        {
            setOptional(0);
            setOptional(1);
            setOptional(2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            int i;
            Object[] objArr = (Object[]) berInputStream.content;
            int[] iArr = new int[3];
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= 3) {
                    return iArr;
                }
                if (objArr[i] != null) {
                    iArr[i] = ASN1Integer.toIntValue(objArr[i]);
                    if (i > 0 && (iArr[i] < 0 || iArr[i] > 999)) {
                        break;
                    }
                }
                i2 = i + 1;
            }
            throw new RuntimeException("Time-stamp accuracy value is incorrect: " + iArr[i]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            int i;
            int[] iArr = (int[]) obj;
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= 3) {
                    return;
                }
                if (i <= 0 || (iArr[i] >= 0 && iArr[i] <= 999)) {
                    objArr[i] = BigInteger.valueOf(iArr[i]).toByteArray();
                    i2 = i + 1;
                }
            }
            throw new RuntimeException("Time-stamp accuracy value is incorrect: " + iArr[i]);
        }
    };
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{ASN1Integer.getInstance(), ASN1Oid.getInstance(), MessageImprint.ASN1, ASN1Integer.getInstance(), ASN1GeneralizedTime.getInstance(), ACCURACY, ASN1Boolean.getInstance(), ASN1Integer.getInstance(), new ASN1Explicit(0, GeneralName.ASN1), new ASN1Implicit(1, Extensions.ASN1)}) { // from class: org.apache.harmony.security.x509.tsp.TSTInfo.2
        {
            setOptional(5);
            setDefault(Boolean.FALSE, 6);
            setOptional(7);
            setOptional(8);
            setOptional(9);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            return new TSTInfo(ASN1Integer.toIntValue(objArr[0]), ObjectIdentifier.toString((int[]) objArr[1]), (MessageImprint) objArr[2], new BigInteger((byte[]) objArr[3]), (Date) objArr[4], (int[]) objArr[5], (Boolean) objArr[6], objArr[7] == null ? null : new BigInteger((byte[]) objArr[7]), (GeneralName) objArr[8], (Extensions) objArr[9]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            TSTInfo tSTInfo = (TSTInfo) obj;
            objArr[0] = ASN1Integer.fromIntValue(tSTInfo.version);
            objArr[1] = ObjectIdentifier.toIntArray(tSTInfo.policy);
            objArr[2] = tSTInfo.messageImprint;
            objArr[3] = tSTInfo.serialNumber.toByteArray();
            objArr[4] = tSTInfo.genTime;
            objArr[5] = tSTInfo.accuracy;
            objArr[6] = tSTInfo.ordering;
            objArr[7] = tSTInfo.nonce == null ? null : tSTInfo.nonce.toByteArray();
            objArr[8] = tSTInfo.tsa;
            objArr[9] = tSTInfo.extensions;
        }
    };
    private final int[] accuracy;
    private final Extensions extensions;
    private final Date genTime;
    private final MessageImprint messageImprint;
    private final BigInteger nonce;
    private final Boolean ordering;
    private final String policy;
    private final BigInteger serialNumber;
    private final GeneralName tsa;
    private final int version;

    public TSTInfo(int i, String str, MessageImprint messageImprint, BigInteger bigInteger, Date date, int[] iArr, Boolean bool, BigInteger bigInteger2, GeneralName generalName, Extensions extensions) {
        this.version = i;
        this.policy = str;
        this.messageImprint = messageImprint;
        this.serialNumber = bigInteger;
        this.genTime = date;
        this.accuracy = iArr;
        this.ordering = bool;
        this.nonce = bigInteger2;
        this.tsa = generalName;
        this.extensions = extensions;
    }

    public int[] getAccuracy() {
        return this.accuracy;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public Date getGenTime() {
        return this.genTime;
    }

    public MessageImprint getMessageImprint() {
        return this.messageImprint;
    }

    public BigInteger getNonce() {
        return this.nonce;
    }

    public Boolean getOrdering() {
        return this.ordering;
    }

    public String getPolicy() {
        return this.policy;
    }

    public BigInteger getSerialNumber() {
        return this.serialNumber;
    }

    public GeneralName getTsa() {
        return this.tsa;
    }

    public int getVersion() {
        return this.version;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-- TSTInfo:");
        sb.append("\nversion:  ");
        sb.append(this.version);
        sb.append("\npolicy:  ");
        sb.append(this.policy);
        sb.append("\nmessageImprint:  ");
        sb.append(this.messageImprint);
        sb.append("\nserialNumber:  ");
        sb.append(this.serialNumber);
        sb.append("\ngenTime:  ");
        sb.append(this.genTime);
        sb.append("\naccuracy:  ");
        if (this.accuracy != null) {
            sb.append(this.accuracy[0] + " sec, " + this.accuracy[1] + " millis, " + this.accuracy[2] + " micros");
        }
        sb.append("\nordering:  ");
        sb.append(this.ordering);
        sb.append("\nnonce:  ");
        sb.append(this.nonce);
        sb.append("\ntsa:  ");
        sb.append(this.tsa);
        sb.append("\nextensions:  ");
        sb.append(this.extensions);
        sb.append("\n-- TSTInfo End\n");
        return sb.toString();
    }
}
