package org.apache.harmony.security.asn1;

import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1Any.class */
public final class ASN1Any extends ASN1Type {
    private static final ASN1Any ASN1 = new ASN1Any();

    public ASN1Any() {
        super(0);
    }

    public static ASN1Any getInstance() {
        return ASN1;
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public final boolean checkTag(int i) {
        return true;
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public Object decode(BerInputStream berInputStream) throws IOException {
        berInputStream.readContent();
        if (berInputStream.isVerify) {
            return null;
        }
        return getDecodedObject(berInputStream);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public void encodeASN(BerOutputStream berOutputStream) {
        berOutputStream.encodeANY();
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public void encodeContent(BerOutputStream berOutputStream) {
        berOutputStream.encodeANY();
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
        byte[] bArr = new byte[berInputStream.offset - berInputStream.tagOffset];
        System.arraycopy(berInputStream.buffer, berInputStream.tagOffset, bArr, 0, bArr.length);
        return bArr;
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public int getEncodedLength(BerOutputStream berOutputStream) {
        return berOutputStream.length;
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public void setEncodingContent(BerOutputStream berOutputStream) {
        berOutputStream.length = ((byte[]) berOutputStream.content).length;
    }
}
