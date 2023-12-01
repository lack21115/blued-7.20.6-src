package org.apache.harmony.security.asn1;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1Constructed.class */
public abstract class ASN1Constructed extends ASN1Type {
    /* JADX INFO: Access modifiers changed from: protected */
    public ASN1Constructed(int i) {
        super(0, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ASN1Constructed(int i, int i2) {
        super(i, i2);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public final boolean checkTag(int i) {
        return this.constrId == i;
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public void encodeASN(BerOutputStream berOutputStream) {
        berOutputStream.encodeTag(this.constrId);
        encodeContent(berOutputStream);
    }
}
