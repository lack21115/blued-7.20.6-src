package org.apache.harmony.security.asn1;

import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1Explicit.class */
public final class ASN1Explicit extends ASN1Constructed {
    public final ASN1Type type;

    public ASN1Explicit(int i, int i2, ASN1Type aSN1Type) {
        super(i, i2);
        this.type = aSN1Type;
    }

    public ASN1Explicit(int i, ASN1Type aSN1Type) {
        this(128, i, aSN1Type);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public Object decode(BerInputStream berInputStream) throws IOException {
        if (this.constrId != berInputStream.tag) {
            throw new ASN1Exception("ASN.1 explicitly tagged type is expected at [" + berInputStream.tagOffset + "]. Expected tag: " + Integer.toHexString(this.constrId) + ", but encountered tag " + Integer.toHexString(berInputStream.tag));
        }
        berInputStream.next();
        berInputStream.content = this.type.decode(berInputStream);
        if (berInputStream.isVerify) {
            return null;
        }
        return getDecodedObject(berInputStream);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public void encodeContent(BerOutputStream berOutputStream) {
        berOutputStream.encodeExplicit(this);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public void setEncodingContent(BerOutputStream berOutputStream) {
        berOutputStream.getExplicitLength(this);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public String toString() {
        return super.toString() + " for type " + this.type;
    }
}
