package org.apache.harmony.security.asn1;

import com.amap.api.services.core.AMapException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/BerInputStream.class */
public class BerInputStream {
    private static final int BUF_INCREASE_SIZE = 16384;
    protected static final int INDEFINIT_LENGTH = -1;
    protected byte[] buffer;
    public int choiceIndex;
    public Object content;
    protected int contentOffset;
    private final InputStream in;
    protected boolean isIndefinedLength;
    protected boolean isVerify;
    protected int length;
    protected int offset;
    public int oidElement;
    private Object[][] pool;
    public int tag;
    protected int tagOffset;
    public int[] times;

    public BerInputStream(InputStream inputStream) throws IOException {
        this(inputStream, 16384);
    }

    public BerInputStream(InputStream inputStream, int i) throws IOException {
        this.offset = 0;
        this.in = inputStream;
        this.buffer = new byte[i];
        next();
        if (this.length == -1) {
            this.isIndefinedLength = true;
            throw new ASN1Exception("Decoding indefinite length encoding is not supported");
        } else if (this.buffer.length < this.length + this.offset) {
            byte[] bArr = new byte[this.length + this.offset];
            System.arraycopy(this.buffer, 0, bArr, 0, this.offset);
            this.buffer = bArr;
        }
    }

    public BerInputStream(byte[] bArr) throws IOException {
        this(bArr, 0, bArr.length);
    }

    public BerInputStream(byte[] bArr, int i, int i2) throws IOException {
        this.offset = 0;
        this.in = null;
        this.buffer = bArr;
        this.offset = i;
        next();
        if (this.length != -1 && i + i2 != this.offset + this.length) {
            throw new ASN1Exception("Wrong content length");
        }
    }

    private void decodeValueCollection(ASN1ValueCollection aSN1ValueCollection) throws IOException {
        int i = this.offset;
        int i2 = i + this.length;
        ASN1Type aSN1Type = aSN1ValueCollection.type;
        if (this.isVerify) {
            while (i2 > this.offset) {
                next();
                aSN1Type.decode(this);
            }
        } else {
            int i3 = this.tagOffset;
            ArrayList arrayList = new ArrayList();
            while (i2 > this.offset) {
                next();
                arrayList.add(aSN1Type.decode(this));
            }
            arrayList.trimToSize();
            this.content = arrayList;
            this.tagOffset = i3;
        }
        if (this.offset != i2) {
            throw new ASN1Exception("Wrong encoding at [" + i + "]. Content's length and encoded length are not the same");
        }
    }

    private ASN1Exception expected(String str) throws ASN1Exception {
        throw new ASN1Exception("ASN.1 " + str + " identifier expected at [" + this.tagOffset + "], got " + Integer.toHexString(this.tag));
    }

    public static int getLength(byte[] bArr) {
        int i = bArr[1] & 255;
        int i2 = 0;
        int i3 = i;
        if ((i & 128) != 0) {
            int i4 = i & 127;
            int i5 = bArr[2] & 255;
            int i6 = 3;
            while (true) {
                int i7 = i6;
                i3 = i5;
                i2 = i4;
                if (i7 >= i4 + 2) {
                    break;
                }
                i5 = (i5 << 8) + (bArr[i7] & 255);
                i6 = i7 + 1;
            }
        }
        return i2 + 2 + i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002c, code lost:
        throw new org.apache.harmony.security.asn1.ASN1Exception("Time encoding has invalid char");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int strToInt(int r5, int r6) throws org.apache.harmony.security.asn1.ASN1Exception {
        /*
            r4 = this;
            r0 = 0
            r8 = r0
            r0 = r5
            r7 = r0
        L5:
            r0 = r7
            r1 = r5
            r2 = r6
            int r1 = r1 + r2
            if (r0 >= r1) goto L3e
            r0 = r4
            byte[] r0 = r0.buffer
            r1 = r7
            r0 = r0[r1]
            r1 = 48
            int r0 = r0 - r1
            r9 = r0
            r0 = r9
            if (r0 < 0) goto L23
            r0 = r9
            r1 = 9
            if (r0 <= r1) goto L2d
        L23:
            org.apache.harmony.security.asn1.ASN1Exception r0 = new org.apache.harmony.security.asn1.ASN1Exception
            r1 = r0
            java.lang.String r2 = "Time encoding has invalid char"
            r1.<init>(r2)
            throw r0
        L2d:
            r0 = r8
            r1 = 10
            int r0 = r0 * r1
            r1 = r9
            int r0 = r0 + r1
            r8 = r0
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            goto L5
        L3e:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.harmony.security.asn1.BerInputStream.strToInt(int, int):int");
    }

    public void compactBuffer() {
        if (this.offset != this.buffer.length) {
            byte[] bArr = new byte[this.offset];
            System.arraycopy(this.buffer, 0, bArr, 0, this.offset);
            this.buffer = bArr;
        }
    }

    public Object get(Object obj) {
        if (this.pool == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.pool[0].length) {
                return null;
            }
            if (this.pool[0][i2] == obj) {
                return this.pool[1][i2];
            }
            i = i2 + 1;
        }
    }

    public final byte[] getBuffer() {
        return this.buffer;
    }

    public byte[] getEncoded() {
        byte[] bArr = new byte[this.offset - this.tagOffset];
        System.arraycopy(this.buffer, this.tagOffset, bArr, 0, bArr.length);
        return bArr;
    }

    public final int getEndOffset() {
        return this.offset + this.length;
    }

    public final int getLength() {
        return this.length;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final int getTagOffset() {
        return this.tagOffset;
    }

    public int next() throws IOException {
        this.tagOffset = this.offset;
        this.tag = read();
        this.length = read();
        if (this.length == 128) {
            this.length = -1;
        } else if ((this.length & 128) != 0) {
            int i = this.length & 127;
            if (i > 5) {
                throw new ASN1Exception("Too long encoding at [" + this.tagOffset + "]");
            }
            this.length = read();
            int i2 = 1;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    break;
                }
                this.length = (this.length << 8) + read();
                i2 = i3 + 1;
            }
            if (this.length > 16777215) {
                throw new ASN1Exception("Too long encoding at [" + this.tagOffset + "]");
            }
        }
        this.contentOffset = this.offset;
        return this.tag;
    }

    public void put(Object obj, Object obj2) {
        int i;
        if (this.pool == null) {
            this.pool = (Object[][]) Array.newInstance(Object.class, 2, 10);
        }
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.pool[0].length || this.pool[0][i] == null) {
                break;
            } else if (this.pool[0][i] == obj) {
                this.pool[1][i] = obj2;
                return;
            } else {
                i2 = i + 1;
            }
        }
        if (i != this.pool[0].length) {
            this.pool[0][i] = obj;
            this.pool[1][i] = obj2;
            return;
        }
        Object[][] objArr = (Object[][]) Array.newInstance(Object.class, this.pool[0].length * 2, 2);
        System.arraycopy(this.pool[0], 0, objArr[0], 0, this.pool[0].length);
        System.arraycopy(this.pool[1], 0, objArr[1], 0, this.pool[0].length);
        this.pool = objArr;
    }

    protected int read() throws IOException {
        if (this.offset == this.buffer.length) {
            throw new ASN1Exception("Unexpected end of encoding");
        }
        if (this.in == null) {
            byte[] bArr = this.buffer;
            int i = this.offset;
            this.offset = i + 1;
            return bArr[i] & 255;
        }
        int read = this.in.read();
        if (read == -1) {
            throw new ASN1Exception("Unexpected end of encoding");
        }
        byte[] bArr2 = this.buffer;
        int i2 = this.offset;
        this.offset = i2 + 1;
        bArr2[i2] = (byte) read;
        return read;
    }

    public void readBitString() throws IOException {
        if (this.tag != 3) {
            if (this.tag != 35) {
                throw expected("bitstring");
            }
            throw new ASN1Exception("Decoding constructed ASN.1 bitstring  type is not provided");
        } else if (this.length == 0) {
            throw new ASN1Exception("ASN.1 Bitstring: wrong length. Tag at [" + this.tagOffset + "]");
        } else {
            readContent();
            if (this.buffer[this.contentOffset] > 7) {
                throw new ASN1Exception("ASN.1 Bitstring: wrong content at [" + this.contentOffset + "]. A number of unused bits MUST be in range 0 to 7");
            }
            if (this.length == 1 && this.buffer[this.contentOffset] != 0) {
                throw new ASN1Exception("ASN.1 Bitstring: wrong content at [" + this.contentOffset + "]. For empty string unused bits MUST be 0");
            }
        }
    }

    public void readBoolean() throws IOException {
        if (this.tag != 1) {
            throw expected("boolean");
        }
        if (this.length != 1) {
            throw new ASN1Exception("Wrong length for ASN.1 boolean at [" + this.tagOffset + "]");
        }
        readContent();
    }

    public void readContent() throws IOException {
        if (this.offset + this.length > this.buffer.length) {
            throw new ASN1Exception("Unexpected end of encoding");
        }
        if (this.in == null) {
            this.offset += this.length;
            return;
        }
        int read = this.in.read(this.buffer, this.offset, this.length);
        if (read == this.length) {
            this.offset += this.length;
            return;
        }
        int i = read;
        while (i >= 1 && read <= this.length) {
            i = this.in.read(this.buffer, this.offset + read, this.length - read);
            int i2 = read + i;
            read = i2;
            if (i2 == this.length) {
                this.offset += this.length;
                return;
            }
        }
        throw new ASN1Exception("Failed to read encoded content");
    }

    public void readEnumerated() throws IOException {
        if (this.tag != 10) {
            throw expected("enumerated");
        }
        if (this.length == 0) {
            throw new ASN1Exception("ASN.1 enumerated: wrong length for identifier at [" + this.tagOffset + "]");
        }
        readContent();
        if (this.length > 1) {
            int i = this.buffer[this.contentOffset] & 255;
            int i2 = i;
            if (this.buffer[this.contentOffset + 1] < 0) {
                i2 = i + 256;
            }
            if (i2 == 0 || i2 == 511) {
                throw new ASN1Exception("ASN.1 enumerated: wrong content at [" + this.contentOffset + "]. An integer MUST be encoded in minimum number of octets");
            }
        }
    }

    public void readGeneralizedTime() throws IOException {
        byte b;
        if (this.tag != 24) {
            if (this.tag != 56) {
                throw expected("GeneralizedTime");
            }
            throw new ASN1Exception("Decoding constructed ASN.1 GeneralizedTime type is not supported");
        }
        readContent();
        if (this.buffer[this.offset - 1] != 90) {
            throw new ASN1Exception("ASN.1 GeneralizedTime: encoded format is not implemented");
        }
        if (this.length != 15 && (this.length < 17 || this.length > 19)) {
            throw new ASN1Exception("ASN.1 GeneralizedTime wrongly encoded at [" + this.contentOffset + "]");
        }
        if (this.length > 16 && (b = this.buffer[this.contentOffset + 14]) != 46 && b != 44) {
            throw new ASN1Exception("ASN.1 GeneralizedTime wrongly encoded at [" + this.contentOffset + "]");
        }
        if (this.times == null) {
            this.times = new int[7];
        }
        this.times[0] = strToInt(this.contentOffset, 4);
        this.times[1] = strToInt(this.contentOffset + 4, 2);
        this.times[2] = strToInt(this.contentOffset + 6, 2);
        this.times[3] = strToInt(this.contentOffset + 8, 2);
        this.times[4] = strToInt(this.contentOffset + 10, 2);
        this.times[5] = strToInt(this.contentOffset + 12, 2);
        if (this.length > 16) {
            this.times[6] = strToInt(this.contentOffset + 15, this.length - 16);
            if (this.length == 17) {
                this.times[6] = this.times[6] * 100;
            } else if (this.length == 18) {
                this.times[6] = this.times[6] * 10;
            }
        }
    }

    public void readInteger() throws IOException {
        if (this.tag != 2) {
            throw expected("integer");
        }
        if (this.length < 1) {
            throw new ASN1Exception("Wrong length for ASN.1 integer at [" + this.tagOffset + "]");
        }
        readContent();
        if (this.length > 1) {
            byte b = this.buffer[this.offset - this.length];
            byte b2 = (byte) (this.buffer[(this.offset - this.length) + 1] & 128);
            if ((b == 0 && b2 == 0) || (b == -1 && b2 == Byte.MIN_VALUE)) {
                throw new ASN1Exception("Wrong content for ASN.1 integer at [" + (this.offset - this.length) + "]. An integer MUST be encoded in minimum number of octets");
            }
        }
    }

    public void readOID() throws IOException {
        if (this.tag != 6) {
            throw expected("OID");
        }
        if (this.length < 1) {
            throw new ASN1Exception("Wrong length for ASN.1 object identifier at [" + this.tagOffset + "]");
        }
        readContent();
        if ((this.buffer[this.offset - 1] & 128) != 0) {
            throw new ASN1Exception("Wrong encoding at [" + (this.offset - 1) + "]");
        }
        this.oidElement = 1;
        int i = 0;
        while (i < this.length) {
            while ((this.buffer[this.contentOffset + i] & 128) == 128) {
                i++;
            }
            i++;
            this.oidElement++;
        }
    }

    public void readOctetString() throws IOException {
        if (this.tag == 4) {
            readContent();
        } else if (this.tag != 36) {
            throw expected("octetstring");
        } else {
            throw new ASN1Exception("Decoding constructed ASN.1 octet string type is not supported");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a6, code lost:
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ae, code lost:
        if (r8 >= r0.length) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b7, code lost:
        if (r6.OPTIONAL[r8] != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00dd, code lost:
        throw new org.apache.harmony.security.asn1.ASN1Exception("ASN.1 Sequence: mandatory value is missing at [" + r5.tagOffset + "]");
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0148, code lost:
        throw new org.apache.harmony.security.asn1.ASN1Exception("ASN.1 Sequence: mandatory value is missing at [" + r5.tagOffset + "]");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void readSequence(org.apache.harmony.security.asn1.ASN1Sequence r6) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 504
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.harmony.security.asn1.BerInputStream.readSequence(org.apache.harmony.security.asn1.ASN1Sequence):void");
    }

    public void readSequenceOf(ASN1SequenceOf aSN1SequenceOf) throws IOException {
        if (this.tag != 48) {
            throw expected("sequenceOf");
        }
        decodeValueCollection(aSN1SequenceOf);
    }

    public void readSet(ASN1Set aSN1Set) throws IOException {
        if (this.tag == 49) {
            throw new ASN1Exception("Decoding ASN.1 Set type is not supported");
        }
        throw expected("set");
    }

    public void readSetOf(ASN1SetOf aSN1SetOf) throws IOException {
        if (this.tag != 49) {
            throw expected("setOf");
        }
        decodeValueCollection(aSN1SetOf);
    }

    public void readString(ASN1StringType aSN1StringType) throws IOException {
        if (this.tag == aSN1StringType.id) {
            readContent();
        } else if (this.tag != aSN1StringType.constrId) {
            throw expected("string");
        } else {
            throw new ASN1Exception("Decoding constructed ASN.1 string type is not provided");
        }
    }

    public void readUTCTime() throws IOException {
        if (this.tag != 23) {
            if (this.tag != 55) {
                throw expected("UTCTime");
            }
            throw new ASN1Exception("Decoding constructed ASN.1 UTCTime type is not supported");
        }
        switch (this.length) {
            case 11:
            case 13:
                readContent();
                if (this.buffer[this.offset - 1] != 90) {
                    throw new ASN1Exception("ASN.1 UTCTime wrongly encoded at [" + this.contentOffset + ']');
                }
                if (this.times == null) {
                    this.times = new int[7];
                }
                this.times[0] = strToInt(this.contentOffset, 2);
                if (this.times[0] > 49) {
                    int[] iArr = this.times;
                    iArr[0] = iArr[0] + AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR;
                } else {
                    int[] iArr2 = this.times;
                    iArr2[0] = iArr2[0] + 2000;
                }
                this.times[1] = strToInt(this.contentOffset + 2, 2);
                this.times[2] = strToInt(this.contentOffset + 4, 2);
                this.times[3] = strToInt(this.contentOffset + 6, 2);
                this.times[4] = strToInt(this.contentOffset + 8, 2);
                if (this.length == 13) {
                    this.times[5] = strToInt(this.contentOffset + 10, 2);
                    return;
                }
                return;
            case 12:
            case 14:
            case 16:
            default:
                throw new ASN1Exception("ASN.1 UTCTime: wrong length, identifier at " + this.tagOffset);
            case 15:
            case 17:
                throw new ASN1Exception("ASN.1 UTCTime: local time format is not supported");
        }
    }

    public final void reset(byte[] bArr) throws IOException {
        this.buffer = bArr;
        next();
    }

    public final void setVerify() {
        this.isVerify = true;
    }
}
