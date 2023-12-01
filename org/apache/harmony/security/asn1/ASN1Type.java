package org.apache.harmony.security.asn1;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1Type.class */
public abstract class ASN1Type implements ASN1Constants {
    public final int constrId;
    public final int id;

    public ASN1Type(int i) {
        this(0, i);
    }

    public ASN1Type(int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("tagNumber < 0");
        }
        if (i != 0 && i != 64 && i != 128 && i != 192) {
            throw new IllegalArgumentException("invalid tagClass");
        }
        if (i2 >= 31) {
            throw new IllegalArgumentException("tag long form not implemented");
        }
        this.id = i + i2;
        this.constrId = this.id + 32;
    }

    public abstract boolean checkTag(int i);

    public final Object decode(InputStream inputStream) throws IOException {
        return decode(new DerInputStream(inputStream));
    }

    public abstract Object decode(BerInputStream berInputStream) throws IOException;

    public final Object decode(byte[] bArr) throws IOException {
        return decode(new DerInputStream(bArr));
    }

    public final Object decode(byte[] bArr, int i, int i2) throws IOException {
        return decode(new DerInputStream(bArr, i, i2));
    }

    public final byte[] encode(Object obj) {
        return new DerOutputStream(this, obj).encoded;
    }

    public abstract void encodeASN(BerOutputStream berOutputStream);

    public abstract void encodeContent(BerOutputStream berOutputStream);

    /* JADX INFO: Access modifiers changed from: protected */
    public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
        return berInputStream.content;
    }

    public int getEncodedLength(BerOutputStream berOutputStream) {
        int i = 1 + 1;
        int i2 = i;
        if (berOutputStream.length > 127) {
            int i3 = i + 1;
            int i4 = berOutputStream.length >> 8;
            while (true) {
                i2 = i3;
                if (i4 <= 0) {
                    break;
                }
                i4 >>= 8;
                i3++;
            }
        }
        return i2 + berOutputStream.length;
    }

    public abstract void setEncodingContent(BerOutputStream berOutputStream);

    public String toString() {
        return getClass().getName() + "(tag: 0x" + Integer.toHexString(this.id & 255) + ")";
    }

    public final void verify(InputStream inputStream) throws IOException {
        DerInputStream derInputStream = new DerInputStream(inputStream);
        derInputStream.setVerify();
        decode(derInputStream);
    }

    public final void verify(byte[] bArr) throws IOException {
        DerInputStream derInputStream = new DerInputStream(bArr);
        derInputStream.setVerify();
        decode(derInputStream);
    }
}
