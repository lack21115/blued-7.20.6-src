package org.apache.harmony.security.asn1;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/DerInputStream.class */
public final class DerInputStream extends BerInputStream {
    private static final byte[] UNUSED_BITS_MASK = {1, 3, 7, 15, 31, 63, Byte.MAX_VALUE};

    public DerInputStream(InputStream inputStream) throws IOException {
        super(inputStream);
    }

    public DerInputStream(byte[] bArr) throws IOException {
        super(bArr, 0, bArr.length);
    }

    public DerInputStream(byte[] bArr, int i, int i2) throws IOException {
        super(bArr, i, i2);
    }

    @Override // org.apache.harmony.security.asn1.BerInputStream
    public int next() throws IOException {
        int next = super.next();
        if (this.length == -1) {
            throw new ASN1Exception("DER: only definite length encoding MUST be used");
        }
        return next;
    }

    @Override // org.apache.harmony.security.asn1.BerInputStream
    public void readBitString() throws IOException {
        if (this.tag == 35) {
            throw new ASN1Exception("ASN.1 bitstring: constructed identifier at [" + this.tagOffset + "]. Not valid for DER.");
        }
        super.readBitString();
        if (this.length > 1 && this.buffer[this.contentOffset] != 0 && (this.buffer[this.offset - 1] & UNUSED_BITS_MASK[this.buffer[this.contentOffset] - 1]) != 0) {
            throw new ASN1Exception("ASN.1 bitstring: wrong content at [" + this.contentOffset + "]. DER requires zero unused bits in final octet.");
        }
    }

    @Override // org.apache.harmony.security.asn1.BerInputStream
    public void readBoolean() throws IOException {
        super.readBoolean();
        if (this.buffer[this.contentOffset] != 0 && this.buffer[this.contentOffset] != -1) {
            throw new ASN1Exception("ASN.1 boolean: wrong content at [" + this.contentOffset + "]. DER allows only 0x00 or 0xFF values");
        }
    }

    @Override // org.apache.harmony.security.asn1.BerInputStream
    public void readGeneralizedTime() throws IOException {
        if (this.tag == 56) {
            throw new ASN1Exception("ASN.1 GeneralizedTime: constructed identifier at [" + this.tagOffset + "]. Not valid for DER.");
        }
        super.readGeneralizedTime();
    }

    @Override // org.apache.harmony.security.asn1.BerInputStream
    public void readOctetString() throws IOException {
        if (this.tag == 36) {
            throw new ASN1Exception("ASN.1 octetstring: constructed identifier at [" + this.tagOffset + "]. Not valid for DER.");
        }
        super.readOctetString();
    }

    @Override // org.apache.harmony.security.asn1.BerInputStream
    public void readSequence(ASN1Sequence aSN1Sequence) throws IOException {
        super.readSequence(aSN1Sequence);
    }

    @Override // org.apache.harmony.security.asn1.BerInputStream
    public void readSetOf(ASN1SetOf aSN1SetOf) throws IOException {
        super.readSetOf(aSN1SetOf);
    }

    @Override // org.apache.harmony.security.asn1.BerInputStream
    public void readString(ASN1StringType aSN1StringType) throws IOException {
        if (this.tag == aSN1StringType.constrId) {
            throw new ASN1Exception("ASN.1 string: constructed identifier at [" + this.tagOffset + "]. Not valid for DER.");
        }
        super.readString(aSN1StringType);
    }

    @Override // org.apache.harmony.security.asn1.BerInputStream
    public void readUTCTime() throws IOException {
        if (this.tag == 55) {
            throw new ASN1Exception("ASN.1 UTCTime: constructed identifier at [" + this.tagOffset + "]. Not valid for DER.");
        }
        if (this.length != 13) {
            throw new ASN1Exception("ASN.1 UTCTime: wrong format for DER, identifier at [" + this.tagOffset + "]");
        }
        super.readUTCTime();
    }
}
