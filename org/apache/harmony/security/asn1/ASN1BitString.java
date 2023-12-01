package org.apache.harmony.security.asn1;

import java.io.IOException;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1BitString.class */
public class ASN1BitString extends ASN1StringType {
    private static final ASN1BitString ASN1 = new ASN1BitString();

    /* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1BitString$ASN1NamedBitList.class */
    public static class ASN1NamedBitList extends ASN1BitString {
        private static final int INDEFINITE_SIZE = -1;
        private static final byte[] SET_MASK = {Byte.MIN_VALUE, 64, 32, 16, 8, 4, 2, 1};
        private static final BitString emptyString = new BitString(EmptyArray.BYTE, 0);
        private final int maxBits = -1;
        private final int minBits;

        public ASN1NamedBitList(int i) {
            this.minBits = i;
        }

        @Override // org.apache.harmony.security.asn1.ASN1BitString, org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
            boolean[] zArr;
            byte b = berInputStream.buffer[berInputStream.contentOffset];
            int i = ((berInputStream.length - 1) * 8) - b;
            if (this.maxBits == -1) {
                zArr = this.minBits == -1 ? new boolean[i] : i > this.minBits ? new boolean[i] : new boolean[this.minBits];
            } else if (i > this.maxBits) {
                throw new ASN1Exception("ASN.1 Named Bitstring: size constraints");
            } else {
                zArr = new boolean[this.maxBits];
            }
            if (i != 0) {
                int i2 = 1;
                int i3 = 0;
                byte b2 = berInputStream.buffer[berInputStream.contentOffset + 1];
                int i4 = berInputStream.length;
                while (i2 < i4 - 1) {
                    int i5 = 0;
                    while (i5 < 8) {
                        zArr[i3] = (SET_MASK[i5] & b2) != 0;
                        i5++;
                        i3++;
                    }
                    int i6 = i2 + 1;
                    b2 = berInputStream.buffer[berInputStream.contentOffset + i6];
                    i2 = i6 + 1;
                }
                int i7 = 0;
                while (i7 < 8 - b) {
                    zArr[i3] = (SET_MASK[i7] & b2) != 0;
                    i7++;
                    i3++;
                }
            }
            return zArr;
        }

        @Override // org.apache.harmony.security.asn1.ASN1BitString, org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
        public void setEncodingContent(BerOutputStream berOutputStream) {
            int i;
            boolean[] zArr = (boolean[]) berOutputStream.content;
            int length = zArr.length;
            while (true) {
                i = length - 1;
                if (i <= -1 || zArr[i]) {
                    break;
                }
                length = i;
            }
            if (i == -1) {
                berOutputStream.content = emptyString;
                berOutputStream.length = 1;
                return;
            }
            int i2 = 7 - (i % 8);
            byte[] bArr = new byte[(i / 8) + 1];
            int i3 = 0;
            int length2 = bArr.length - 1;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= length2) {
                    break;
                }
                int i6 = 0;
                while (i6 < 8) {
                    if (zArr[i3]) {
                        bArr[i5] = (byte) (bArr[i5] | SET_MASK[i6]);
                    }
                    i6++;
                    i3++;
                }
                i4 = i5 + 1;
            }
            int i7 = 0;
            while (i7 < 8 - i2) {
                if (zArr[i3]) {
                    bArr[length2] = (byte) (bArr[length2] | SET_MASK[i7]);
                }
                i7++;
                i3++;
            }
            berOutputStream.content = new BitString(bArr, i2);
            berOutputStream.length = bArr.length + 1;
        }
    }

    public ASN1BitString() {
        super(3);
    }

    public static ASN1BitString getInstance() {
        return ASN1;
    }

    @Override // org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
    public Object decode(BerInputStream berInputStream) throws IOException {
        berInputStream.readBitString();
        if (berInputStream.isVerify) {
            return null;
        }
        return getDecodedObject(berInputStream);
    }

    @Override // org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
    public void encodeContent(BerOutputStream berOutputStream) {
        berOutputStream.encodeBitString();
    }

    @Override // org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
    public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
        byte[] bArr = new byte[berInputStream.length - 1];
        System.arraycopy(berInputStream.buffer, berInputStream.contentOffset + 1, bArr, 0, berInputStream.length - 1);
        return new BitString(bArr, berInputStream.buffer[berInputStream.contentOffset]);
    }

    @Override // org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
    public void setEncodingContent(BerOutputStream berOutputStream) {
        berOutputStream.length = ((BitString) berOutputStream.content).bytes.length + 1;
    }
}
