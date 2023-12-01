package org.apache.harmony.security.asn1;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1Primitive.class */
public abstract class ASN1Primitive extends ASN1Type {
    public ASN1Primitive(int i) {
        super(i);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public final boolean checkTag(int i) {
        return this.id == i;
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public void encodeASN(BerOutputStream berOutputStream) {
        berOutputStream.encodeTag(this.id);
        encodeContent(berOutputStream);
    }
}
