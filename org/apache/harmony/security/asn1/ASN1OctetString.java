package org.apache.harmony.security.asn1;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1OctetString.class */
public class ASN1OctetString extends ASN1StringType {
    private static final ASN1OctetString ASN1 = new ASN1OctetString();

    public ASN1OctetString() {
        super(4);
    }

    public static ASN1OctetString getInstance() {
        return ASN1;
    }

    @Override // org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
    public Object decode(BerInputStream berInputStream) throws IOException {
        berInputStream.readOctetString();
        if (berInputStream.isVerify) {
            return null;
        }
        return getDecodedObject(berInputStream);
    }

    @Override // org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
    public void encodeContent(BerOutputStream berOutputStream) {
        berOutputStream.encodeOctetString();
    }

    @Override // org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
    public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
        return Arrays.copyOfRange(berInputStream.buffer, berInputStream.contentOffset, berInputStream.contentOffset + berInputStream.length);
    }

    @Override // org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
    public void setEncodingContent(BerOutputStream berOutputStream) {
        berOutputStream.length = ((byte[]) berOutputStream.content).length;
    }
}
