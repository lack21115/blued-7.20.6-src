package org.apache.harmony.security.asn1;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1Enumerated.class */
public final class ASN1Enumerated extends ASN1Primitive {
    private static final ASN1Enumerated ASN1 = new ASN1Enumerated();

    public ASN1Enumerated() {
        super(10);
    }

    public static ASN1Enumerated getInstance() {
        return ASN1;
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public Object decode(BerInputStream berInputStream) throws IOException {
        berInputStream.readEnumerated();
        if (berInputStream.isVerify) {
            return null;
        }
        return getDecodedObject(berInputStream);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public void encodeContent(BerOutputStream berOutputStream) {
        berOutputStream.encodeInteger();
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
        return Arrays.copyOfRange(berInputStream.buffer, berInputStream.contentOffset, berInputStream.contentOffset + berInputStream.length);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public void setEncodingContent(BerOutputStream berOutputStream) {
        berOutputStream.length = ((byte[]) berOutputStream.content).length;
    }
}
