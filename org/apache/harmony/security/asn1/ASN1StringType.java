package org.apache.harmony.security.asn1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1StringType.class */
public abstract class ASN1StringType extends ASN1Type {
    public static final ASN1StringType BMPSTRING = new ASN1StringType(30) { // from class: org.apache.harmony.security.asn1.ASN1StringType.1
    };
    public static final ASN1StringType IA5STRING = new ASN1StringType(22) { // from class: org.apache.harmony.security.asn1.ASN1StringType.2
    };
    public static final ASN1StringType GENERALSTRING = new ASN1StringType(27) { // from class: org.apache.harmony.security.asn1.ASN1StringType.3
    };
    public static final ASN1StringType PRINTABLESTRING = new ASN1StringType(19) { // from class: org.apache.harmony.security.asn1.ASN1StringType.4
    };
    public static final ASN1StringType TELETEXSTRING = new ASN1StringUTF8Type(20) { // from class: org.apache.harmony.security.asn1.ASN1StringType.5
    };
    public static final ASN1StringType UNIVERSALSTRING = new ASN1StringType(28) { // from class: org.apache.harmony.security.asn1.ASN1StringType.6
    };
    public static final ASN1StringType UTF8STRING = new ASN1StringUTF8Type(12) { // from class: org.apache.harmony.security.asn1.ASN1StringType.7
    };

    /* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1StringType$ASN1StringUTF8Type.class */
    private static class ASN1StringUTF8Type extends ASN1StringType {
        public ASN1StringUTF8Type(int i) {
            super(i);
        }

        @Override // org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
            return new String(berInputStream.buffer, berInputStream.contentOffset, berInputStream.length, StandardCharsets.UTF_8);
        }

        @Override // org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
        public void setEncodingContent(BerOutputStream berOutputStream) {
            byte[] bytes = ((String) berOutputStream.content).getBytes(StandardCharsets.UTF_8);
            berOutputStream.content = bytes;
            berOutputStream.length = bytes.length;
        }
    }

    public ASN1StringType(int i) {
        super(i);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public final boolean checkTag(int i) {
        return this.id == i || this.constrId == i;
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public Object decode(BerInputStream berInputStream) throws IOException {
        berInputStream.readString(this);
        if (berInputStream.isVerify) {
            return null;
        }
        return getDecodedObject(berInputStream);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public void encodeASN(BerOutputStream berOutputStream) {
        berOutputStream.encodeTag(this.id);
        encodeContent(berOutputStream);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public void encodeContent(BerOutputStream berOutputStream) {
        berOutputStream.encodeString();
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
        return new String(berInputStream.buffer, berInputStream.contentOffset, berInputStream.length, StandardCharsets.ISO_8859_1);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public void setEncodingContent(BerOutputStream berOutputStream) {
        byte[] bytes = ((String) berOutputStream.content).getBytes(StandardCharsets.UTF_8);
        berOutputStream.content = bytes;
        berOutputStream.length = bytes.length;
    }
}
