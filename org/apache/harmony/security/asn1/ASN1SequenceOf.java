package org.apache.harmony.security.asn1;

import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1SequenceOf.class */
public class ASN1SequenceOf extends ASN1ValueCollection {
    public ASN1SequenceOf(ASN1Type aSN1Type) {
        super(16, aSN1Type);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public Object decode(BerInputStream berInputStream) throws IOException {
        berInputStream.readSequenceOf(this);
        if (berInputStream.isVerify) {
            return null;
        }
        return getDecodedObject(berInputStream);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public final void encodeContent(BerOutputStream berOutputStream) {
        berOutputStream.encodeSequenceOf(this);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public final void setEncodingContent(BerOutputStream berOutputStream) {
        berOutputStream.getSequenceOfLength(this);
    }
}
