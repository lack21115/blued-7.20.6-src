package java.nio.charset;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import libcore.icu.ICU;
import libcore.icu.NativeConverter;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:java/nio/charset/CharsetDecoderICU.class */
final class CharsetDecoderICU extends CharsetDecoder {
    private static final int INPUT_OFFSET = 0;
    private static final int INVALID_BYTE_COUNT = 2;
    private static final int MAX_CHARS_PER_BYTE = 2;
    private static final int OUTPUT_OFFSET = 1;
    private byte[] allocatedInput;
    private char[] allocatedOutput;
    private long converterHandle;
    private final int[] data;
    private int inEnd;
    private byte[] input;
    private int outEnd;
    private char[] output;

    private CharsetDecoderICU(Charset charset, float f, long j) {
        super(charset, f, 2.0f);
        this.data = new int[3];
        this.converterHandle = 0L;
        this.input = null;
        this.output = null;
        this.allocatedInput = null;
        this.allocatedOutput = null;
        this.converterHandle = j;
    }

    private int getArray(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            this.input = byteBuffer.array();
            this.inEnd = byteBuffer.arrayOffset() + byteBuffer.limit();
            return byteBuffer.arrayOffset() + byteBuffer.position();
        }
        this.inEnd = byteBuffer.remaining();
        if (this.allocatedInput == null || this.inEnd > this.allocatedInput.length) {
            this.allocatedInput = new byte[this.inEnd];
        }
        int position = byteBuffer.position();
        byteBuffer.get(this.allocatedInput, 0, this.inEnd);
        byteBuffer.position(position);
        this.input = this.allocatedInput;
        return 0;
    }

    private int getArray(CharBuffer charBuffer) {
        if (charBuffer.hasArray()) {
            this.output = charBuffer.array();
            this.outEnd = charBuffer.arrayOffset() + charBuffer.limit();
            return charBuffer.arrayOffset() + charBuffer.position();
        }
        this.outEnd = charBuffer.remaining();
        if (this.allocatedOutput == null || this.outEnd > this.allocatedOutput.length) {
            this.allocatedOutput = new char[this.outEnd];
        }
        this.output = this.allocatedOutput;
        return 0;
    }

    public static CharsetDecoderICU newInstance(Charset charset, String str) {
        long j = 0;
        try {
            long openConverter = NativeConverter.openConverter(str);
            CharsetDecoderICU charsetDecoderICU = new CharsetDecoderICU(charset, NativeConverter.getAveCharsPerByte(openConverter), openConverter);
            j = 0;
            charsetDecoderICU.updateCallback();
            if (0 != 0) {
                NativeConverter.closeConverter(0L);
            }
            return charsetDecoderICU;
        } catch (Throwable th) {
            if (j != 0) {
                NativeConverter.closeConverter(j);
            }
            throw th;
        }
    }

    private void setPosition(ByteBuffer byteBuffer) {
        byteBuffer.position(byteBuffer.position() + this.data[0]);
        this.input = null;
    }

    private void setPosition(CharBuffer charBuffer) {
        if (charBuffer.hasArray()) {
            charBuffer.position((charBuffer.position() + this.data[1]) - charBuffer.arrayOffset());
        } else {
            charBuffer.put(this.output, 0, this.data[1]);
        }
        this.output = null;
    }

    private void updateCallback() {
        NativeConverter.setCallbackDecode(this.converterHandle, this);
    }

    @Override // java.nio.charset.CharsetDecoder
    protected CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        if (byteBuffer.hasRemaining()) {
            this.data[0] = getArray(byteBuffer);
            this.data[1] = getArray(charBuffer);
            try {
                int decode = NativeConverter.decode(this.converterHandle, this.input, this.inEnd, this.output, this.outEnd, this.data, false);
                if (ICU.U_FAILURE(decode)) {
                    if (decode == 15) {
                        return CoderResult.OVERFLOW;
                    }
                    if (decode == 10) {
                        return CoderResult.unmappableForLength(this.data[2]);
                    }
                    if (decode == 12) {
                        return CoderResult.malformedForLength(this.data[2]);
                    }
                    throw new AssertionError(decode);
                }
                return CoderResult.UNDERFLOW;
            } finally {
                setPosition(byteBuffer);
                setPosition(charBuffer);
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

    @Override // java.nio.charset.CharsetDecoder
    protected final CoderResult implFlush(CharBuffer charBuffer) {
        try {
            this.input = EmptyArray.BYTE;
            this.inEnd = 0;
            this.data[0] = 0;
            this.data[1] = getArray(charBuffer);
            this.data[2] = 0;
            int decode = NativeConverter.decode(this.converterHandle, this.input, this.inEnd, this.output, this.outEnd, this.data, true);
            if (ICU.U_FAILURE(decode)) {
                if (decode == 15) {
                    return CoderResult.OVERFLOW;
                }
                if (decode == 11 && this.data[2] > 0) {
                    return CoderResult.malformedForLength(this.data[2]);
                }
            }
            return CoderResult.UNDERFLOW;
        } finally {
            setPosition(charBuffer);
            implReset();
        }
    }

    @Override // java.nio.charset.CharsetDecoder
    protected final void implOnMalformedInput(CodingErrorAction codingErrorAction) {
        updateCallback();
    }

    @Override // java.nio.charset.CharsetDecoder
    protected final void implOnUnmappableCharacter(CodingErrorAction codingErrorAction) {
        updateCallback();
    }

    @Override // java.nio.charset.CharsetDecoder
    protected void implReplaceWith(String str) {
        updateCallback();
    }

    @Override // java.nio.charset.CharsetDecoder
    protected void implReset() {
        NativeConverter.resetByteToChar(this.converterHandle);
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
