package org.apache.harmony.security.asn1;

import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1Implicit.class */
public final class ASN1Implicit extends ASN1Type {
    private static final int TAGGING_CONSTRUCTED = 1;
    private static final int TAGGING_PRIMITIVE = 0;
    private static final int TAGGING_STRING = 2;
    private final int taggingType;
    private final ASN1Type type;

    public ASN1Implicit(int i, ASN1Type aSN1Type) {
        super(128, i);
        if ((aSN1Type instanceof ASN1Choice) || (aSN1Type instanceof ASN1Any)) {
            throw new IllegalArgumentException("Implicit tagging can not be used for ASN.1 ANY or CHOICE type");
        }
        this.type = aSN1Type;
        if (!aSN1Type.checkTag(aSN1Type.id)) {
            this.taggingType = 1;
        } else if (aSN1Type.checkTag(aSN1Type.constrId)) {
            this.taggingType = 2;
        } else {
            this.taggingType = 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002f, code lost:
        if (r3.constrId == r4) goto L10;
     */
    @Override // org.apache.harmony.security.asn1.ASN1Type
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean checkTag(int r4) {
        /*
            r3 = this;
            r0 = 1
            r5 = r0
            r0 = 0
            r6 = r0
            r0 = r3
            int r0 = r0.taggingType
            switch(r0) {
                case 0: goto L36;
                case 1: goto L40;
                default: goto L20;
            }
        L20:
            r0 = r3
            int r0 = r0.id
            r1 = r4
            if (r0 == r1) goto L32
            r0 = r6
            r5 = r0
            r0 = r3
            int r0 = r0.constrId
            r1 = r4
            if (r0 != r1) goto L34
        L32:
            r0 = 1
            r5 = r0
        L34:
            r0 = r5
            return r0
        L36:
            r0 = r3
            int r0 = r0.id
            r1 = r4
            if (r0 == r1) goto L34
            r0 = 0
            return r0
        L40:
            r0 = r3
            int r0 = r0.constrId
            r1 = r4
            if (r0 == r1) goto L34
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.harmony.security.asn1.ASN1Implicit.checkTag(int):boolean");
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public Object decode(BerInputStream berInputStream) throws IOException {
        if (checkTag(berInputStream.tag)) {
            if (this.id == berInputStream.tag) {
                berInputStream.tag = this.type.id;
            } else {
                berInputStream.tag = this.type.constrId;
            }
            berInputStream.content = this.type.decode(berInputStream);
            if (berInputStream.isVerify) {
                return null;
            }
            return getDecodedObject(berInputStream);
        }
        throw new ASN1Exception("ASN.1 implicitly tagged type expected at [" + berInputStream.tagOffset + "]. Expected tag: " + Integer.toHexString(this.id) + ", but got " + Integer.toHexString(berInputStream.tag));
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public void encodeASN(BerOutputStream berOutputStream) {
        if (this.taggingType == 1) {
            berOutputStream.encodeTag(this.constrId);
        } else {
            berOutputStream.encodeTag(this.id);
        }
        encodeContent(berOutputStream);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public void encodeContent(BerOutputStream berOutputStream) {
        this.type.encodeContent(berOutputStream);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public void setEncodingContent(BerOutputStream berOutputStream) {
        this.type.setEncodingContent(berOutputStream);
    }
}
