package org.apache.harmony.security.asn1;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/BerOutputStream.class */
public class BerOutputStream {
    public Object content;
    public byte[] encoded;
    public int length;
    protected int offset;

    public void encodeANY() {
        System.arraycopy(this.content, 0, this.encoded, this.offset, this.length);
        this.offset += this.length;
    }

    public void encodeBitString() {
        BitString bitString = (BitString) this.content;
        this.encoded[this.offset] = (byte) bitString.unusedBits;
        System.arraycopy(bitString.bytes, 0, this.encoded, this.offset + 1, this.length - 1);
        this.offset += this.length;
    }

    public void encodeBoolean() {
        if (((Boolean) this.content).booleanValue()) {
            this.encoded[this.offset] = -1;
        } else {
            this.encoded[this.offset] = 0;
        }
        this.offset++;
    }

    public void encodeChoice(ASN1Choice aSN1Choice) {
        throw new RuntimeException("Is not implemented yet");
    }

    public void encodeExplicit(ASN1Explicit aSN1Explicit) {
        throw new RuntimeException("Is not implemented yet");
    }

    public void encodeGeneralizedTime() {
        System.arraycopy(this.content, 0, this.encoded, this.offset, this.length);
        this.offset += this.length;
    }

    public void encodeInteger() {
        System.arraycopy(this.content, 0, this.encoded, this.offset, this.length);
        this.offset += this.length;
    }

    public void encodeOID() {
        int i;
        int[] iArr = (int[]) this.content;
        int i2 = this.length;
        int length = iArr.length - 1;
        while (length > 1) {
            int i3 = iArr[length];
            if (i3 > 127) {
                this.encoded[(this.offset + i2) - 1] = (byte) (i3 & 127);
                while (true) {
                    i3 >>= 7;
                    i = i2;
                    if (i3 > 0) {
                        i2--;
                        this.encoded[(this.offset + i2) - 1] = (byte) (i3 | 128);
                    }
                }
            } else {
                this.encoded[(this.offset + i2) - 1] = (byte) i3;
                i = i2;
            }
            length--;
            i2 = i - 1;
        }
        int i4 = (iArr[0] * 40) + iArr[1];
        if (i4 > 127) {
            this.encoded[(this.offset + i2) - 1] = (byte) (i4 & 127);
            int i5 = i2;
            int i6 = i4 >> 7;
            while (true) {
                int i7 = i6;
                if (i7 <= 0) {
                    break;
                }
                i5--;
                this.encoded[(this.offset + i5) - 1] = (byte) (i7 | 128);
                i6 = i7 >> 7;
            }
        } else {
            this.encoded[(this.offset + i2) - 1] = (byte) i4;
        }
        this.offset += this.length;
    }

    public void encodeOctetString() {
        System.arraycopy(this.content, 0, this.encoded, this.offset, this.length);
        this.offset += this.length;
    }

    public void encodeSequence(ASN1Sequence aSN1Sequence) {
        throw new RuntimeException("Is not implemented yet");
    }

    public void encodeSequenceOf(ASN1SequenceOf aSN1SequenceOf) {
        throw new RuntimeException("Is not implemented yet");
    }

    public void encodeSet(ASN1Set aSN1Set) {
        throw new RuntimeException("Is not implemented yet");
    }

    public void encodeSetOf(ASN1SetOf aSN1SetOf) {
        throw new RuntimeException("Is not implemented yet");
    }

    public void encodeString() {
        System.arraycopy(this.content, 0, this.encoded, this.offset, this.length);
        this.offset += this.length;
    }

    public final void encodeTag(int i) {
        byte[] bArr = this.encoded;
        int i2 = this.offset;
        this.offset = i2 + 1;
        bArr[i2] = (byte) i;
        if (this.length <= 127) {
            byte[] bArr2 = this.encoded;
            int i3 = this.offset;
            this.offset = i3 + 1;
            bArr2[i3] = (byte) this.length;
            return;
        }
        byte b = 1;
        for (int i4 = this.length >> 8; i4 > 0; i4 >>= 8) {
            b = (byte) (b + 1);
        }
        this.encoded[this.offset] = (byte) (b | 128);
        this.offset++;
        int i5 = this.length;
        int i6 = this.offset;
        byte b2 = 0;
        while (b2 < b) {
            this.encoded[((i6 + b) - 1) - b2] = (byte) i5;
            b2++;
            i5 >>= 8;
        }
        this.offset += b;
    }

    public void encodeUTCTime() {
        System.arraycopy(this.content, 0, this.encoded, this.offset, this.length);
        this.offset += this.length;
    }

    public void getChoiceLength(ASN1Choice aSN1Choice) {
        throw new RuntimeException("Is not implemented yet");
    }

    public void getExplicitLength(ASN1Explicit aSN1Explicit) {
        throw new RuntimeException("Is not implemented yet");
    }

    public void getSequenceLength(ASN1Sequence aSN1Sequence) {
        throw new RuntimeException("Is not implemented yet");
    }

    public void getSequenceOfLength(ASN1SequenceOf aSN1SequenceOf) {
        throw new RuntimeException("Is not implemented yet");
    }

    public void getSetLength(ASN1Set aSN1Set) {
        throw new RuntimeException("Is not implemented yet");
    }

    public void getSetOfLength(ASN1SetOf aSN1SetOf) {
        throw new RuntimeException("Is not implemented yet");
    }
}
