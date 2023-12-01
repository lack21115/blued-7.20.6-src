package java.nio.charset;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;
import libcore.icu.ICU;
import libcore.icu.NativeConverter;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:java/nio/charset/CharsetEncoderICU.class */
final class CharsetEncoderICU extends CharsetEncoder {
    private static final Map<String, byte[]> DEFAULT_REPLACEMENTS = new HashMap();
    private static final int INPUT_OFFSET = 0;
    private static final int INVALID_CHAR_COUNT = 2;
    private static final int OUTPUT_OFFSET = 1;
    private char[] allocatedInput;
    private byte[] allocatedOutput;
    private long converterHandle;
    private int[] data;
    private int inEnd;
    private char[] input;
    private int outEnd;
    private byte[] output;

    static {
        byte[] bArr = {63};
        DEFAULT_REPLACEMENTS.put("UTF-8", bArr);
        DEFAULT_REPLACEMENTS.put("ISO-8859-1", bArr);
        DEFAULT_REPLACEMENTS.put("US-ASCII", bArr);
    }

    private CharsetEncoderICU(Charset charset, float f, float f2, byte[] bArr, long j) {
        super(charset, f, f2, bArr, true);
        this.data = new int[3];
        this.converterHandle = 0L;
        this.input = null;
        this.output = null;
        this.allocatedInput = null;
        this.allocatedOutput = null;
        this.converterHandle = j;
        updateCallback();
    }

    private int getArray(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            this.output = byteBuffer.array();
            this.outEnd = byteBuffer.arrayOffset() + byteBuffer.limit();
            return byteBuffer.arrayOffset() + byteBuffer.position();
        }
        this.outEnd = byteBuffer.remaining();
        if (this.allocatedOutput == null || this.outEnd > this.allocatedOutput.length) {
            this.allocatedOutput = new byte[this.outEnd];
        }
        this.output = this.allocatedOutput;
        return 0;
    }

    private int getArray(CharBuffer charBuffer) {
        if (charBuffer.hasArray()) {
            this.input = charBuffer.array();
            this.inEnd = charBuffer.arrayOffset() + charBuffer.limit();
            return charBuffer.arrayOffset() + charBuffer.position();
        }
        this.inEnd = charBuffer.remaining();
        if (this.allocatedInput == null || this.inEnd > this.allocatedInput.length) {
            this.allocatedInput = new char[this.inEnd];
        }
        int position = charBuffer.position();
        charBuffer.get(this.allocatedInput, 0, this.inEnd);
        charBuffer.position(position);
        this.input = this.allocatedInput;
        return 0;
    }

    private static byte[] makeReplacement(String str, long j) {
        byte[] bArr = DEFAULT_REPLACEMENTS.get(str);
        return bArr != null ? (byte[]) bArr.clone() : NativeConverter.getSubstitutionBytes(j);
    }

    public static CharsetEncoderICU newInstance(Charset charset, String str) {
        long j = 0;
        try {
            long openConverter = NativeConverter.openConverter(str);
            j = openConverter;
            CharsetEncoderICU charsetEncoderICU = new CharsetEncoderICU(charset, NativeConverter.getAveBytesPerChar(openConverter), NativeConverter.getMaxBytesPerChar(openConverter), makeReplacement(str, openConverter), openConverter);
            if (0 != 0) {
                NativeConverter.closeConverter(0L);
            }
            return charsetEncoderICU;
        } catch (Throwable th) {
            if (j != 0) {
                NativeConverter.closeConverter(j);
            }
            throw th;
        }
    }

    private void setPosition(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            byteBuffer.position(this.data[1] - byteBuffer.arrayOffset());
        } else {
            byteBuffer.put(this.output, 0, this.data[1]);
        }
        this.output = null;
    }

    private void setPosition(CharBuffer charBuffer) {
        int position = (charBuffer.position() + this.data[0]) - this.data[2];
        int i = position;
        if (position < 0) {
            i = 0;
        }
        charBuffer.position(i);
        this.input = null;
    }

    private void updateCallback() {
        NativeConverter.setCallbackEncode(this.converterHandle, this);
    }

    @Override // java.nio.charset.CharsetEncoder
    protected CoderResult encodeLoop(CharBuffer charBuffer, ByteBuffer byteBuffer) {
        if (charBuffer.hasRemaining()) {
            this.data[0] = getArray(charBuffer);
            this.data[1] = getArray(byteBuffer);
            this.data[2] = 0;
            try {
                int encode = NativeConverter.encode(this.converterHandle, this.input, this.inEnd, this.output, this.outEnd, this.data, false);
                if (ICU.U_FAILURE(encode)) {
                    if (encode == 15) {
                        return CoderResult.OVERFLOW;
                    }
                    if (encode == 10) {
                        return CoderResult.unmappableForLength(this.data[2]);
                    }
                    if (encode == 12) {
                        return CoderResult.malformedForLength(this.data[2]);
                    }
                    throw new AssertionError(encode);
                }
                return CoderResult.UNDERFLOW;
            } finally {
                setPosition(charBuffer);
                setPosition(byteBuffer);
            }
        }
        return CoderResult.UNDERFLOW;
    }

    protected void finalize() throws Throwable {
        try {
            NativeConverter.closeConverter(this.converterHandle);
            this.converterHandle = 0L;
        } finally {
            super.finalize();
        }
    }

    @Override // java.nio.charset.CharsetEncoder
    protected CoderResult implFlush(ByteBuffer byteBuffer) {
        try {
            this.input = EmptyArray.CHAR;
            this.inEnd = 0;
            this.data[0] = 0;
            this.data[1] = getArray(byteBuffer);
            this.data[2] = 0;
            int encode = NativeConverter.encode(this.converterHandle, this.input, this.inEnd, this.output, this.outEnd, this.data, true);
            if (ICU.U_FAILURE(encode)) {
                if (encode == 15) {
                    return CoderResult.OVERFLOW;
                }
                if (encode == 11 && this.data[2] > 0) {
                    return CoderResult.malformedForLength(this.data[2]);
                }
            }
            return CoderResult.UNDERFLOW;
        } finally {
            setPosition(byteBuffer);
            implReset();
        }
    }

    @Override // java.nio.charset.CharsetEncoder
    protected void implOnMalformedInput(CodingErrorAction codingErrorAction) {
        updateCallback();
    }

    @Override // java.nio.charset.CharsetEncoder
    protected void implOnUnmappableCharacter(CodingErrorAction codingErrorAction) {
        updateCallback();
    }

    @Override // java.nio.charset.CharsetEncoder
    protected void implReplaceWith(byte[] bArr) {
        updateCallback();
    }

    @Override // java.nio.charset.CharsetEncoder
    protected void implReset() {
        NativeConverter.resetCharToByte(this.converterHandle);
        this.data[0] = 0;
        this.data[1] = 0;
        this.data[2] = 0;
        this.output = null;
        this.input = null;
        this.allocatedInput = null;
        this.allocatedOutput = null;
        this.inEnd = 0;
        this.outEnd = 0;
    }
}
