package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/SerialWriterStringEncoder.class */
public class SerialWriterStringEncoder {
    private static final ThreadLocal<SoftReference<byte[]>> bytesBufLocal = new ThreadLocal<>();
    private final CharsetEncoder encoder;

    public SerialWriterStringEncoder(Charset charset) {
        this(charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE));
    }

    public SerialWriterStringEncoder(CharsetEncoder charsetEncoder) {
        this.encoder = charsetEncoder;
    }

    private static byte[] allocateBytes(int i) {
        if (i > 131072) {
            return new byte[i];
        }
        byte[] bArr = new byte[(i >>> 10) <= 0 ? 1024 : 1 << (32 - Integer.numberOfLeadingZeros(i - 1))];
        bytesBufLocal.set(new SoftReference<>(bArr));
        return bArr;
    }

    public static void clearBytes() {
        bytesBufLocal.set(null);
    }

    public static byte[] getBytes(int i) {
        byte[] bArr;
        SoftReference<byte[]> softReference = bytesBufLocal.get();
        if (softReference != null && (bArr = softReference.get()) != null) {
            byte[] bArr2 = bArr;
            if (bArr.length < i) {
                bArr2 = allocateBytes(i);
            }
            return bArr2;
        }
        return allocateBytes(i);
    }

    private static int scale(int i, float f) {
        return (int) (i * f);
    }

    public byte[] encode(char[] cArr, int i, int i2) {
        if (i2 == 0) {
            return new byte[0];
        }
        this.encoder.reset();
        return encode(cArr, i, i2, getBytes(scale(i2, this.encoder.maxBytesPerChar())));
    }

    public byte[] encode(char[] cArr, int i, int i2, byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        try {
            CoderResult encode = this.encoder.encode(CharBuffer.wrap(cArr, i, i2), wrap, true);
            if (!encode.isUnderflow()) {
                encode.throwException();
            }
            CoderResult flush = this.encoder.flush(wrap);
            if (!flush.isUnderflow()) {
                flush.throwException();
            }
            int position = wrap.position();
            byte[] bArr2 = new byte[position];
            System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, position);
            return bArr2;
        } catch (CharacterCodingException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public CharsetEncoder getEncoder() {
        return this.encoder;
    }
}
