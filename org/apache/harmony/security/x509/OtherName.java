package org.apache.harmony.security.x509;

import org.apache.harmony.security.asn1.ASN1Any;
import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/OtherName.class */
public final class OtherName {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{ASN1Oid.getInstance(), new ASN1Explicit(0, ASN1Any.getInstance())}) { // from class: org.apache.harmony.security.x509.OtherName.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            return new OtherName(ObjectIdentifier.toString((int[]) objArr[0]), (byte[]) objArr[1], berInputStream.getEncoded());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            OtherName otherName = (OtherName) obj;
            objArr[0] = ObjectIdentifier.toIntArray(otherName.typeID);
            objArr[1] = otherName.value;
        }
    };
    private byte[] encoding;
    private String typeID;
    private byte[] value;

    public OtherName(String str, byte[] bArr) {
        this(str, bArr, null);
    }

    private OtherName(String str, byte[] bArr, byte[] bArr2) {
        this.typeID = str;
        this.value = bArr;
        this.encoding = bArr2;
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public byte[] getValue() {
        return this.value;
    }
}
