package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;

/* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/net/QCodec.class */
public class QCodec extends RFC1522Codec implements StringDecoder, StringEncoder {
    private static final byte BLANK = 32;
    private static final BitSet PRINTABLE_CHARS;
    private static final byte UNDERSCORE = 95;
    private final String charset;
    private boolean encodeBlanks;

    static {
        BitSet bitSet = new BitSet(256);
        PRINTABLE_CHARS = bitSet;
        bitSet.set(32);
        PRINTABLE_CHARS.set(33);
        PRINTABLE_CHARS.set(34);
        PRINTABLE_CHARS.set(35);
        PRINTABLE_CHARS.set(36);
        PRINTABLE_CHARS.set(37);
        PRINTABLE_CHARS.set(38);
        PRINTABLE_CHARS.set(39);
        PRINTABLE_CHARS.set(40);
        PRINTABLE_CHARS.set(41);
        PRINTABLE_CHARS.set(42);
        PRINTABLE_CHARS.set(43);
        PRINTABLE_CHARS.set(44);
        PRINTABLE_CHARS.set(45);
        PRINTABLE_CHARS.set(46);
        PRINTABLE_CHARS.set(47);
        int i = 48;
        while (true) {
            int i2 = i;
            if (i2 > 57) {
                break;
            }
            PRINTABLE_CHARS.set(i2);
            i = i2 + 1;
        }
        PRINTABLE_CHARS.set(58);
        PRINTABLE_CHARS.set(59);
        PRINTABLE_CHARS.set(60);
        PRINTABLE_CHARS.set(62);
        PRINTABLE_CHARS.set(64);
        int i3 = 65;
        while (true) {
            int i4 = i3;
            if (i4 > 90) {
                break;
            }
            PRINTABLE_CHARS.set(i4);
            i3 = i4 + 1;
        }
        PRINTABLE_CHARS.set(91);
        PRINTABLE_CHARS.set(92);
        PRINTABLE_CHARS.set(93);
        PRINTABLE_CHARS.set(94);
        PRINTABLE_CHARS.set(96);
        int i5 = 97;
        while (true) {
            int i6 = i5;
            if (i6 > 122) {
                PRINTABLE_CHARS.set(123);
                PRINTABLE_CHARS.set(124);
                PRINTABLE_CHARS.set(125);
                PRINTABLE_CHARS.set(126);
                return;
            }
            PRINTABLE_CHARS.set(i6);
            i5 = i6 + 1;
        }
    }

    public QCodec() {
        this("UTF-8");
    }

    public QCodec(String str) {
        this.encodeBlanks = false;
        this.charset = str;
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new DecoderException("Objects of type " + obj.getClass().getName() + " cannot be decoded using Q codec");
    }

    @Override // org.apache.commons.codec.StringDecoder
    public String decode(String str) throws DecoderException {
        if (str == null) {
            return null;
        }
        try {
            return decodeText(str);
        } catch (UnsupportedEncodingException e) {
            throw new DecoderException(e.getMessage(), e);
        }
    }

    @Override // org.apache.commons.codec.net.RFC1522Codec
    protected byte[] doDecoding(byte[] bArr) throws DecoderException {
        boolean z;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                z = false;
                break;
            } else if (bArr[i2] == 95) {
                z = true;
                break;
            } else {
                i = i2 + 1;
            }
        }
        if (!z) {
            return QuotedPrintableCodec.decodeQuotedPrintable(bArr);
        }
        byte[] bArr2 = new byte[bArr.length];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= bArr.length) {
                return QuotedPrintableCodec.decodeQuotedPrintable(bArr2);
            }
            byte b = bArr[i4];
            if (b != 95) {
                bArr2[i4] = b;
            } else {
                bArr2[i4] = 32;
            }
            i3 = i4 + 1;
        }
    }

    @Override // org.apache.commons.codec.net.RFC1522Codec
    protected byte[] doEncoding(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] encodeQuotedPrintable = QuotedPrintableCodec.encodeQuotedPrintable(PRINTABLE_CHARS, bArr);
        if (this.encodeBlanks) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= encodeQuotedPrintable.length) {
                    break;
                }
                if (encodeQuotedPrintable[i2] == 32) {
                    encodeQuotedPrintable[i2] = 95;
                }
                i = i2 + 1;
            }
        }
        return encodeQuotedPrintable;
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return encode((String) obj);
        }
        throw new EncoderException("Objects of type " + obj.getClass().getName() + " cannot be encoded using Q codec");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) throws EncoderException {
        if (str == null) {
            return null;
        }
        return encode(str, getDefaultCharset());
    }

    public String encode(String str, String str2) throws EncoderException {
        if (str == null) {
            return null;
        }
        try {
            return encodeText(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new EncoderException(e.getMessage(), e);
        }
    }

    public String getDefaultCharset() {
        return this.charset;
    }

    @Override // org.apache.commons.codec.net.RFC1522Codec
    protected String getEncoding() {
        return "Q";
    }

    public boolean isEncodeBlanks() {
        return this.encodeBlanks;
    }

    public void setEncodeBlanks(boolean z) {
        this.encodeBlanks = z;
    }
}
