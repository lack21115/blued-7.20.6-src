package org.apache.commons.codec.net;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

/* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/net/URLCodec.class */
public class URLCodec implements BinaryDecoder, BinaryEncoder, StringDecoder, StringEncoder {
    protected static final byte ESCAPE_CHAR = 37;
    static final int RADIX = 16;
    protected static final BitSet WWW_FORM_URL = new BitSet(256);
    protected String charset;

    static {
        int i = 97;
        while (true) {
            int i2 = i;
            if (i2 > 122) {
                break;
            }
            WWW_FORM_URL.set(i2);
            i = i2 + 1;
        }
        int i3 = 65;
        while (true) {
            int i4 = i3;
            if (i4 > 90) {
                break;
            }
            WWW_FORM_URL.set(i4);
            i3 = i4 + 1;
        }
        int i5 = 48;
        while (true) {
            int i6 = i5;
            if (i6 > 57) {
                WWW_FORM_URL.set(45);
                WWW_FORM_URL.set(95);
                WWW_FORM_URL.set(46);
                WWW_FORM_URL.set(42);
                WWW_FORM_URL.set(32);
                return;
            }
            WWW_FORM_URL.set(i6);
            i5 = i6 + 1;
        }
    }

    public URLCodec() {
        this("UTF-8");
    }

    public URLCodec(String str) {
        this.charset = str;
    }

    public static final byte[] decodeUrl(byte[] bArr) throws DecoderException {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return byteArrayOutputStream.toByteArray();
            }
            byte b = bArr[i2];
            if (b == 43) {
                byteArrayOutputStream.write(32);
            } else if (b == 37) {
                int i3 = i2 + 1;
                try {
                    i2 = i3 + 1;
                    byteArrayOutputStream.write((char) ((Utils.digit16(bArr[i3]) << 4) + Utils.digit16(bArr[i2])));
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new DecoderException("Invalid URL encoding: ", e);
                }
            } else {
                byteArrayOutputStream.write(b);
            }
            i = i2 + 1;
        }
    }

    public static final byte[] encodeUrl(BitSet bitSet, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        BitSet bitSet2 = bitSet;
        if (bitSet == null) {
            bitSet2 = WWW_FORM_URL;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return byteArrayOutputStream.toByteArray();
            }
            byte b = bArr[i2];
            byte b2 = b;
            if (b < 0) {
                b2 = b + 256;
            }
            if (bitSet2.get(b2)) {
                int i3 = b2;
                if (b2 == 32) {
                    i3 = 43;
                }
                byteArrayOutputStream.write(i3);
            } else {
                byteArrayOutputStream.write(37);
                char upperCase = Character.toUpperCase(Character.forDigit((b2 >> 4) & 15, 16));
                char upperCase2 = Character.toUpperCase(Character.forDigit(b2 & 15, 16));
                byteArrayOutputStream.write(upperCase);
                byteArrayOutputStream.write(upperCase2);
            }
            i = i2 + 1;
        }
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new DecoderException("Objects of type " + obj.getClass().getName() + " cannot be URL decoded");
    }

    @Override // org.apache.commons.codec.StringDecoder
    public String decode(String str) throws DecoderException {
        if (str == null) {
            return null;
        }
        try {
            return decode(str, getDefaultCharset());
        } catch (UnsupportedEncodingException e) {
            throw new DecoderException(e.getMessage(), e);
        }
    }

    public String decode(String str, String str2) throws DecoderException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return new String(decode(StringUtils.getBytesUsAscii(str)), str2);
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) throws DecoderException {
        return decodeUrl(bArr);
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        if (obj instanceof String) {
            return encode((String) obj);
        }
        throw new EncoderException("Objects of type " + obj.getClass().getName() + " cannot be URL encoded");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) throws EncoderException {
        if (str == null) {
            return null;
        }
        try {
            return encode(str, getDefaultCharset());
        } catch (UnsupportedEncodingException e) {
            throw new EncoderException(e.getMessage(), e);
        }
    }

    public String encode(String str, String str2) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return StringUtils.newStringUsAscii(encode(str.getBytes(str2)));
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return encodeUrl(WWW_FORM_URL, bArr);
    }

    public String getDefaultCharset() {
        return this.charset;
    }

    public String getEncoding() {
        return this.charset;
    }
}
