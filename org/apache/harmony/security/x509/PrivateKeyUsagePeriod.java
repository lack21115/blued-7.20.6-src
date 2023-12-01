package org.apache.harmony.security.x509;

import java.util.Date;
import org.apache.harmony.security.asn1.ASN1GeneralizedTime;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/PrivateKeyUsagePeriod.class */
public final class PrivateKeyUsagePeriod {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{new ASN1Implicit(0, ASN1GeneralizedTime.getInstance()), new ASN1Implicit(1, ASN1GeneralizedTime.getInstance())}) { // from class: org.apache.harmony.security.x509.PrivateKeyUsagePeriod.1
        {
            setOptional(0);
            setOptional(1);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            return new PrivateKeyUsagePeriod((Date) objArr[0], (Date) objArr[1], berInputStream.getEncoded());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            PrivateKeyUsagePeriod privateKeyUsagePeriod = (PrivateKeyUsagePeriod) obj;
            objArr[0] = privateKeyUsagePeriod.notBeforeDate;
            objArr[1] = privateKeyUsagePeriod.notAfterDate;
        }
    };
    private byte[] encoding;
    private final Date notAfterDate;
    private final Date notBeforeDate;

    public PrivateKeyUsagePeriod(Date date, Date date2) {
        this(date, date2, null);
    }

    private PrivateKeyUsagePeriod(Date date, Date date2, byte[] bArr) {
        this.notBeforeDate = date;
        this.notAfterDate = date2;
        this.encoding = bArr;
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public Date getNotAfter() {
        return this.notAfterDate;
    }

    public Date getNotBefore() {
        return this.notBeforeDate;
    }
}
