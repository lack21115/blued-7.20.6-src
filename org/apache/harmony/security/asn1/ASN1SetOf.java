package org.apache.harmony.security.asn1;

import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1SetOf.class */
public class ASN1SetOf extends ASN1ValueCollection {
    public ASN1SetOf(ASN1Type aSN1Type) {
        super(17, aSN1Type);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public Object decode(BerInputStream berInputStream) throws IOException {
        berInputStream.readSetOf(this);
        if (berInputStream.isVerify) {
            return null;
        }
        return getDecodedObject(berInputStream);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public final void encodeContent(BerOutputStream berOutputStream) {
        berOutputStream.encodeSetOf(this);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public final void setEncodingContent(BerOutputStream berOutputStream) {
        berOutputStream.getSetOfLength(this);
    }
}
