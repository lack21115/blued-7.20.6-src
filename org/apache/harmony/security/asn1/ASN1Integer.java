package org.apache.harmony.security.asn1;

import java.io.IOException;
import java.math.BigInteger;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1Integer.class */
public final class ASN1Integer extends ASN1Primitive {
    private static final ASN1Integer ASN1 = new ASN1Integer();

    public ASN1Integer() {
        super(2);
    }

    public static Object fromIntValue(int i) {
        return BigInteger.valueOf(i).toByteArray();
    }

    public static ASN1Integer getInstance() {
        return ASN1;
    }

    public static BigInteger toBigIntegerValue(Object obj) {
        return new BigInteger((byte[]) obj);
    }

    public static int toIntValue(Object obj) {
        return new BigInteger((byte[]) obj).intValue();
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public Object decode(BerInputStream berInputStream) throws IOException {
        berInputStream.readInteger();
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
        byte[] bArr = new byte[berInputStream.length];
        System.arraycopy(berInputStream.buffer, berInputStream.contentOffset, bArr, 0, berInputStream.length);
        return bArr;
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public void setEncodingContent(BerOutputStream berOutputStream) {
        berOutputStream.length = ((byte[]) berOutputStream.content).length;
    }
}
