package java.nio.charset;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/nio/charset/CharsetEncoder.class */
public abstract class CharsetEncoder {
    private static final String END_OF_INPUT = "END_OF_INPUT";
    private static final String FLUSHED = "FLUSHED";
    private static final String ONGOING = "ONGOING";
    private static final String RESET = "RESET";
    private final float averageBytesPerChar;
    private final Charset charset;
    private CharsetDecoder decoder;
    private CodingErrorAction malformedInputAction;
    private final float maxBytesPerChar;
    private byte[] replacementBytes;
    private String state;
    private CodingErrorAction unmappableCharacterAction;

    protected CharsetEncoder(Charset charset, float f, float f2) {
        this(charset, f, f2, new byte[]{63});
    }

    protected CharsetEncoder(Charset charset, float f, float f2, byte[] bArr) {
        this(charset, f, f2, bArr, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharsetEncoder(Charset charset, float f, float f2, byte[] bArr, boolean z) {
        this.state = RESET;
        this.malformedInputAction = CodingErrorAction.REPORT;
        this.unmappableCharacterAction = CodingErrorAction.REPORT;
        if (f <= 0.0f || f2 <= 0.0f) {
            throw new IllegalArgumentException("averageBytesPerChar and maxBytesPerChar must both be positive");
        }
        if (f > f2) {
            throw new IllegalArgumentException("averageBytesPerChar is greater than maxBytesPerChar");
        }
        this.charset = charset;
        this.averageBytesPerChar = f;
        this.maxBytesPerChar = f2;
        if (z) {
            this.replacementBytes = bArr;
        } else {
            replaceWith(bArr);
        }
    }

    private ByteBuffer allocateMore(ByteBuffer byteBuffer) {
        if (byteBuffer.capacity() == 0) {
            return ByteBuffer.allocate(1);
        }
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity() * 2);
        byteBuffer.flip();
        allocate.put(byteBuffer);
        return allocate;
    }

    private void checkCoderResult(CoderResult coderResult) throws CharacterCodingException {
        if (this.malformedInputAction == CodingErrorAction.REPORT && coderResult.isMalformed()) {
            throw new MalformedInputException(coderResult.length());
        }
        if (this.unmappableCharacterAction == CodingErrorAction.REPORT && coderResult.isUnmappable()) {
            throw new UnmappableCharacterException(coderResult.length());
        }
    }

    private IllegalStateException illegalStateException() {
        throw new IllegalStateException("State: " + this.state);
    }

    public final float averageBytesPerChar() {
        return this.averageBytesPerChar;
    }

    public boolean canEncode(char c2) {
        return canEncode(CharBuffer.wrap(new char[]{c2}));
    }

    public boolean canEncode(CharSequence charSequence) {
        CharBuffer duplicate = charSequence instanceof CharBuffer ? ((CharBuffer) charSequence).duplicate() : CharBuffer.wrap(charSequence);
        if (this.state == FLUSHED) {
            reset();
        }
        if (this.state != RESET) {
            throw illegalStateException();
        }
        CodingErrorAction codingErrorAction = this.malformedInputAction;
        CodingErrorAction codingErrorAction2 = this.unmappableCharacterAction;
        onMalformedInput(CodingErrorAction.REPORT);
        onUnmappableCharacter(CodingErrorAction.REPORT);
        try {
            encode(duplicate);
            onMalformedInput(codingErrorAction);
            onUnmappableCharacter(codingErrorAction2);
            reset();
            return true;
        } catch (CharacterCodingException e) {
            onMalformedInput(codingErrorAction);
            onUnmappableCharacter(codingErrorAction2);
            reset();
            return false;
        } catch (Throwable th) {
            onMalformedInput(codingErrorAction);
            onUnmappableCharacter(codingErrorAction2);
            reset();
            throw th;
        }
    }

    public final Charset charset() {
        return this.charset;
    }

    public final ByteBuffer encode(CharBuffer charBuffer) throws CharacterCodingException {
        ByteBuffer allocate = ByteBuffer.allocate((int) (charBuffer.remaining() * this.averageBytesPerChar));
        reset();
        while (this.state != FLUSHED) {
            CoderResult encode = encode(charBuffer, allocate, true);
            if (encode == CoderResult.OVERFLOW) {
                allocate = allocateMore(allocate);
            } else {
                checkCoderResult(encode);
                CoderResult flush = flush(allocate);
                if (flush == CoderResult.OVERFLOW) {
                    allocate = allocateMore(allocate);
                } else {
                    checkCoderResult(flush);
                }
            }
        }
        allocate.flip();
        return allocate;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x008c, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.nio.charset.CoderResult encode(java.nio.CharBuffer r5, java.nio.ByteBuffer r6, boolean r7) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.charset.CharsetEncoder.encode(java.nio.CharBuffer, java.nio.ByteBuffer, boolean):java.nio.charset.CoderResult");
    }

    protected abstract CoderResult encodeLoop(CharBuffer charBuffer, ByteBuffer byteBuffer);

    public final CoderResult flush(ByteBuffer byteBuffer) {
        if (this.state == FLUSHED || this.state == END_OF_INPUT) {
            CoderResult implFlush = implFlush(byteBuffer);
            if (implFlush == CoderResult.UNDERFLOW) {
                this.state = FLUSHED;
            }
            return implFlush;
        }
        throw illegalStateException();
    }

    protected CoderResult implFlush(ByteBuffer byteBuffer) {
        return CoderResult.UNDERFLOW;
    }

    protected void implOnMalformedInput(CodingErrorAction codingErrorAction) {
    }

    protected void implOnUnmappableCharacter(CodingErrorAction codingErrorAction) {
    }

    protected void implReplaceWith(byte[] bArr) {
    }

    protected void implReset() {
    }

    public boolean isLegalReplacement(byte[] bArr) {
        if (this.decoder == null) {
            this.decoder = this.charset.newDecoder();
            this.decoder.onMalformedInput(CodingErrorAction.REPORT);
            this.decoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        }
        return !this.decoder.decode(ByteBuffer.wrap(bArr), CharBuffer.allocate((int) (((float) bArr.length) * this.decoder.maxCharsPerByte())), true).isError();
    }

    public CodingErrorAction malformedInputAction() {
        return this.malformedInputAction;
    }

    public final float maxBytesPerChar() {
        return this.maxBytesPerChar;
    }

    public final CharsetEncoder onMalformedInput(CodingErrorAction codingErrorAction) {
        if (codingErrorAction == null) {
            throw new IllegalArgumentException("newAction == null");
        }
        this.malformedInputAction = codingErrorAction;
        implOnMalformedInput(codingErrorAction);
        return this;
    }

    public final CharsetEncoder onUnmappableCharacter(CodingErrorAction codingErrorAction) {
        if (codingErrorAction == null) {
            throw new IllegalArgumentException("newAction == null");
        }
        this.unmappableCharacterAction = codingErrorAction;
        implOnUnmappableCharacter(codingErrorAction);
        return this;
    }

    public final CharsetEncoder replaceWith(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("replacement == null");
        }
        if (bArr.length == 0) {
            throw new IllegalArgumentException("replacement.length == 0");
        }
        if (bArr.length > maxBytesPerChar()) {
            throw new IllegalArgumentException("replacement.length > maxBytesPerChar: " + bArr.length + " > " + maxBytesPerChar());
        }
        if (isLegalReplacement(bArr)) {
            this.replacementBytes = bArr;
            implReplaceWith(this.replacementBytes);
            return this;
        }
        throw new IllegalArgumentException("Bad replacement: " + Arrays.toString(bArr));
    }

    public final byte[] replacement() {
        return this.replacementBytes;
    }

    public final CharsetEncoder reset() {
        this.state = RESET;
        implReset();
        return this;
    }

    public CodingErrorAction unmappableCharacterAction() {
        return this.unmappableCharacterAction;
    }
}
