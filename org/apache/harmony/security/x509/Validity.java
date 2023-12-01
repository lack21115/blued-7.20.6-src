package org.apache.harmony.security.x509;

import java.util.Date;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/Validity.class */
public final class Validity {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{Time.ASN1, Time.ASN1}) { // from class: org.apache.harmony.security.x509.Validity.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            return new Validity((Date) objArr[0], (Date) objArr[1]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            Validity validity = (Validity) obj;
            objArr[0] = validity.notBefore;
            objArr[1] = validity.notAfter;
        }
    };
    private byte[] encoding;
    private final Date notAfter;
    private final Date notBefore;

    public Validity(Date date, Date date2) {
        this.notBefore = date;
        this.notAfter = date2;
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public Date getNotAfter() {
        return this.notAfter;
    }

    public Date getNotBefore() {
        return this.notBefore;
    }
}
