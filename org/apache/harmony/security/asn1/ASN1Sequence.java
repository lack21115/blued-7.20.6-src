package org.apache.harmony.security.asn1;

import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1Sequence.class */
public class ASN1Sequence extends ASN1TypeCollection {
    public ASN1Sequence(ASN1Type[] aSN1TypeArr) {
        super(16, aSN1TypeArr);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public Object decode(BerInputStream berInputStream) throws IOException {
        berInputStream.readSequence(this);
        if (berInputStream.isVerify) {
            return null;
        }
        return getDecodedObject(berInputStream);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public final void encodeContent(BerOutputStream berOutputStream) {
        berOutputStream.encodeSequence(this);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public final void setEncodingContent(BerOutputStream berOutputStream) {
        berOutputStream.getSequenceLength(this);
    }
}
