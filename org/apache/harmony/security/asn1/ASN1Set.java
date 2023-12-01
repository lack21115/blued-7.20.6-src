package org.apache.harmony.security.asn1;

import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1Set.class */
public final class ASN1Set extends ASN1TypeCollection {
    public ASN1Set(ASN1Type[] aSN1TypeArr) {
        super(17, aSN1TypeArr);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public Object decode(BerInputStream berInputStream) throws IOException {
        berInputStream.readSet(this);
        if (berInputStream.isVerify) {
            return null;
        }
        return getDecodedObject(berInputStream);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public final void encodeContent(BerOutputStream berOutputStream) {
        berOutputStream.encodeSet(this);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public final void setEncodingContent(BerOutputStream berOutputStream) {
        berOutputStream.getSetLength(this);
    }
}
