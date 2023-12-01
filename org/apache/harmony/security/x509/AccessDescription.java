package org.apache.harmony.security.x509;

import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/AccessDescription.class */
public final class AccessDescription {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{ASN1Oid.getInstance(), GeneralName.ASN1}) { // from class: org.apache.harmony.security.x509.AccessDescription.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            return new AccessDescription(ObjectIdentifier.toString((int[]) objArr[0]), (GeneralName) objArr[1], berInputStream.getEncoded());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            AccessDescription accessDescription = (AccessDescription) obj;
            objArr[0] = ObjectIdentifier.toIntArray(accessDescription.accessMethod);
            objArr[1] = accessDescription.accessLocation;
        }
    };
    private final GeneralName accessLocation;
    private final String accessMethod;
    private byte[] encoding;

    private AccessDescription(String str, GeneralName generalName, byte[] bArr) {
        this.accessMethod = str;
        this.accessLocation = generalName;
        this.encoding = bArr;
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public String toString() {
        return "\n-- AccessDescription:\naccessMethod:  " + this.accessMethod + "\naccessLocation:  " + this.accessLocation + "\n-- AccessDescription END\n";
    }
}
