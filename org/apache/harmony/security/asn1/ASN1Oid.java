package org.apache.harmony.security.asn1;

import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1Oid.class */
public class ASN1Oid extends ASN1Primitive {
    private static final ASN1Oid ASN1 = new ASN1Oid();
    private static final ASN1Oid STRING_OID = new ASN1Oid() { // from class: org.apache.harmony.security.asn1.ASN1Oid.1
        @Override // org.apache.harmony.security.asn1.ASN1Oid, org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
            int i;
            StringBuilder sb = new StringBuilder();
            byte b = berInputStream.buffer[berInputStream.contentOffset];
            int i2 = b & Byte.MAX_VALUE;
            int i3 = 0;
            while ((b & 128) != 0) {
                i3++;
                b = berInputStream.buffer[berInputStream.contentOffset + i3];
                i2 = (i2 << 7) | (b & Byte.MAX_VALUE);
            }
            if (i2 > 79) {
                sb.append('2');
                sb.append('.');
                sb.append(i2 - 80);
            } else {
                sb.append(i2 / 40);
                sb.append('.');
                sb.append(i2 % 40);
            }
            int i4 = 2;
            while (true) {
                int i5 = i4;
                if (i5 >= berInputStream.oidElement) {
                    return sb.toString();
                }
                sb.append('.');
                i3++;
                byte b2 = berInputStream.buffer[berInputStream.contentOffset + i3];
                int i6 = b2 & Byte.MAX_VALUE;
                while (true) {
                    i = i6;
                    if ((b2 & 128) != 0) {
                        i3++;
                        b2 = berInputStream.buffer[berInputStream.contentOffset + i3];
                        i6 = (i << 7) | (b2 & Byte.MAX_VALUE);
                    }
                }
                sb.append(i);
                i4 = i5 + 1;
            }
        }

        @Override // org.apache.harmony.security.asn1.ASN1Oid, org.apache.harmony.security.asn1.ASN1Type
        public void setEncodingContent(BerOutputStream berOutputStream) {
            berOutputStream.content = ObjectIdentifier.toIntArray((String) berOutputStream.content);
            super.setEncodingContent(berOutputStream);
        }
    };

    public ASN1Oid() {
        super(6);
    }

    public static ASN1Oid getInstance() {
        return ASN1;
    }

    public static ASN1Oid getInstanceForString() {
        return STRING_OID;
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public Object decode(BerInputStream berInputStream) throws IOException {
        berInputStream.readOID();
        if (berInputStream.isVerify) {
            return null;
        }
        return getDecodedObject(berInputStream);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public void encodeContent(BerOutputStream berOutputStream) {
        berOutputStream.encodeOID();
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
        int i;
        int[] iArr = new int[berInputStream.oidElement];
        int i2 = 1;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 >= iArr.length) {
                break;
            }
            byte b = berInputStream.buffer[berInputStream.contentOffset + i4];
            int i5 = b & Byte.MAX_VALUE;
            while (true) {
                i = i5;
                if ((b & 128) != 0) {
                    i4++;
                    b = berInputStream.buffer[berInputStream.contentOffset + i4];
                    i5 = (i << 7) | (b & Byte.MAX_VALUE);
                }
            }
            iArr[i2] = i;
            i2++;
            i3 = i4 + 1;
        }
        if (iArr[1] > 79) {
            iArr[0] = 2;
            iArr[1] = iArr[1] - 80;
            return iArr;
        }
        iArr[0] = iArr[1] / 40;
        iArr[1] = iArr[1] % 40;
        return iArr;
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public void setEncodingContent(BerOutputStream berOutputStream) {
        int i;
        int[] iArr = (int[]) berOutputStream.content;
        int i2 = 0;
        int i3 = (iArr[0] * 40) + iArr[1];
        int i4 = i3;
        if (i3 != 0) {
            while (true) {
                i = i2;
                if (i4 <= 0) {
                    break;
                }
                i2++;
                i4 >>= 7;
            }
        } else {
            i = 1;
        }
        int i5 = 2;
        while (true) {
            int i6 = i5;
            if (i6 >= iArr.length) {
                berOutputStream.length = i;
                return;
            }
            if (iArr[i6] == 0) {
                i++;
            } else {
                int i7 = iArr[i6];
                int i8 = i;
                while (true) {
                    i = i8;
                    if (i7 > 0) {
                        i8++;
                        i7 >>= 7;
                    }
                }
            }
            i5 = i6 + 1;
        }
    }
}
