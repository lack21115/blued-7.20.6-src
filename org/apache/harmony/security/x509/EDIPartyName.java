package org.apache.harmony.security.x509;

import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.DirectoryString;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/EDIPartyName.class */
public final class EDIPartyName {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{new ASN1Explicit(0, DirectoryString.ASN1), new ASN1Explicit(1, DirectoryString.ASN1)}) { // from class: org.apache.harmony.security.x509.EDIPartyName.1
        {
            setOptional(0);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            return new EDIPartyName((String) objArr[0], (String) objArr[1], berInputStream.getEncoded());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            EDIPartyName eDIPartyName = (EDIPartyName) obj;
            objArr[0] = eDIPartyName.nameAssigner;
            objArr[1] = eDIPartyName.partyName;
        }
    };
    private byte[] encoding;
    private final String nameAssigner;
    private final String partyName;

    private EDIPartyName(String str, String str2, byte[] bArr) {
        this.nameAssigner = str;
        this.partyName = str2;
        this.encoding = bArr;
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }
}
