package org.apache.harmony.security.pkcs7;

import java.io.IOException;
import java.util.Arrays;
import javax.xml.datatype.DatatypeConstants;
import org.apache.harmony.security.asn1.ASN1Any;
import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/pkcs7/ContentInfo.class */
public final class ContentInfo {
    private final Object content;
    private byte[] encoding;
    private final int[] oid;
    public static final int[] DATA = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 7, 1};
    public static final int[] SIGNED_DATA = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 7, 2};
    public static final int[] ENVELOPED_DATA = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 7, 3};
    public static final int[] SIGNED_AND_ENVELOPED_DATA = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 7, 4};
    public static final int[] DIGESTED_DATA = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 7, 5};
    public static final int[] ENCRYPTED_DATA = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 7, 6};
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{ASN1Oid.getInstance(), new ASN1Explicit(0, ASN1Any.getInstance())}) { // from class: org.apache.harmony.security.pkcs7.ContentInfo.1
        {
            setOptional(1);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
            Object[] objArr = (Object[]) berInputStream.content;
            int[] iArr = (int[]) objArr[0];
            return Arrays.equals(iArr, ContentInfo.DATA) ? objArr[1] != null ? new ContentInfo(iArr, ASN1OctetString.getInstance().decode((byte[]) objArr[1]), berInputStream.getEncoded()) : new ContentInfo((int[]) objArr[0], null, berInputStream.getEncoded()) : Arrays.equals(iArr, ContentInfo.SIGNED_DATA) ? new ContentInfo((int[]) objArr[0], SignedData.ASN1.decode((byte[]) objArr[1]), berInputStream.getEncoded()) : new ContentInfo((int[]) objArr[0], objArr[1], berInputStream.getEncoded());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            ContentInfo contentInfo = (ContentInfo) obj;
            objArr[0] = contentInfo.oid;
            if (contentInfo.content != null) {
                if (Arrays.equals(contentInfo.oid, ContentInfo.DATA)) {
                    if (contentInfo.content != null) {
                        objArr[1] = ASN1OctetString.getInstance().encode(contentInfo.content);
                    }
                } else if (contentInfo.content instanceof SignedData) {
                    objArr[1] = SignedData.ASN1.encode(contentInfo.content);
                } else {
                    objArr[1] = contentInfo.content;
                }
            }
        }
    };

    private ContentInfo(int[] iArr, Object obj, byte[] bArr) {
        this.oid = iArr;
        this.content = obj;
        this.encoding = bArr;
    }

    public Object getContent() {
        return this.content;
    }

    public int[] getContentType() {
        return this.oid;
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public SignedData getSignedData() {
        if (Arrays.equals(this.oid, SIGNED_DATA)) {
            return (SignedData) this.content;
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("==== ContentInfo:");
        sb.append("\n== ContentType (OID): ");
        int[] iArr = this.oid;
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            sb.append(iArr[i2]);
            sb.append(' ');
            i = i2 + 1;
        }
        sb.append("\n== Content: ");
        if (this.content != null) {
            sb.append("\n");
            sb.append(this.content.toString());
        }
        sb.append("\n== Content End");
        sb.append("\n==== ContentInfo End\n");
        return sb.toString();
    }
}
