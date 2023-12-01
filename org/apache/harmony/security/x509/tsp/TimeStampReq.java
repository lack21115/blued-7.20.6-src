package org.apache.harmony.security.x509.tsp;

import java.math.BigInteger;
import org.apache.harmony.security.asn1.ASN1Boolean;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;
import org.apache.harmony.security.x509.Extensions;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/tsp/TimeStampReq.class */
public class TimeStampReq {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{ASN1Integer.getInstance(), MessageImprint.ASN1, ASN1Oid.getInstance(), ASN1Integer.getInstance(), ASN1Boolean.getInstance(), new ASN1Implicit(0, Extensions.ASN1)}) { // from class: org.apache.harmony.security.x509.tsp.TimeStampReq.1
        {
            setDefault(Boolean.FALSE, 4);
            setOptional(2);
            setOptional(3);
            setOptional(5);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            String objectIdentifier = objArr[2] == null ? null : ObjectIdentifier.toString((int[]) objArr[2]);
            BigInteger bigInteger = objArr[3] == null ? null : new BigInteger((byte[]) objArr[3]);
            return objArr[5] == null ? new TimeStampReq(ASN1Integer.toIntValue(objArr[0]), (MessageImprint) objArr[1], objectIdentifier, bigInteger, (Boolean) objArr[4], null, berInputStream.getEncoded()) : new TimeStampReq(ASN1Integer.toIntValue(objArr[0]), (MessageImprint) objArr[1], objectIdentifier, bigInteger, (Boolean) objArr[4], (Extensions) objArr[5], berInputStream.getEncoded());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            TimeStampReq timeStampReq = (TimeStampReq) obj;
            objArr[0] = ASN1Integer.fromIntValue(timeStampReq.version);
            objArr[1] = timeStampReq.messageImprint;
            objArr[2] = timeStampReq.reqPolicy == null ? null : ObjectIdentifier.toIntArray(timeStampReq.reqPolicy);
            objArr[3] = timeStampReq.nonce == null ? null : timeStampReq.nonce.toByteArray();
            objArr[4] = timeStampReq.certReq == null ? Boolean.FALSE : timeStampReq.certReq;
            objArr[5] = timeStampReq.extensions;
        }
    };
    private final Boolean certReq;
    private byte[] encoding;
    private final Extensions extensions;
    private final MessageImprint messageImprint;
    private final BigInteger nonce;
    private final String reqPolicy;
    private final int version;

    public TimeStampReq(int i, MessageImprint messageImprint, String str, BigInteger bigInteger, Boolean bool, Extensions extensions) {
        this.version = i;
        this.messageImprint = messageImprint;
        this.reqPolicy = str;
        this.nonce = bigInteger;
        this.certReq = bool;
        this.extensions = extensions;
    }

    private TimeStampReq(int i, MessageImprint messageImprint, String str, BigInteger bigInteger, Boolean bool, Extensions extensions, byte[] bArr) {
        this(i, messageImprint, str, bigInteger, bool, extensions);
        this.encoding = bArr;
    }

    public Boolean getCertReq() {
        return this.certReq;
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public MessageImprint getMessageImprint() {
        return this.messageImprint;
    }

    public BigInteger getNonce() {
        return this.nonce;
    }

    public String getReqPolicy() {
        return this.reqPolicy;
    }

    public int getVersion() {
        return this.version;
    }

    public String toString() {
        return "-- TimeStampReq:\nversion : " + this.version + "\nmessageImprint:  " + this.messageImprint + "\nreqPolicy:  " + this.reqPolicy + "\nnonce:  " + this.nonce + "\ncertReq:  " + this.certReq + "\nextensions:  " + this.extensions + "\n-- TimeStampReq End\n";
    }
}
