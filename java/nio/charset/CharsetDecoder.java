package java.nio.charset;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/* loaded from: source-2895416-dex2jar.jar:java/nio/charset/CharsetDecoder.class */
public abstract class CharsetDecoder {
    private static final String END_OF_INPUT = "END_OF_INPUT";
    private static final String FLUSHED = "FLUSHED";
    private static final String ONGOING = "ONGOING";
    private static final String RESET = "RESET";
    private final float averageCharsPerByte;
    private final Charset charset;
    private final float maxCharsPerByte;
    private String replacementChars = "�";
    private String state = RESET;
    private CodingErrorAction malformedInputAction = CodingErrorAction.REPORT;
    private CodingErrorAction unmappableCharacterAction = CodingErrorAction.REPORT;

    /* JADX INFO: Access modifiers changed from: protected */
    public CharsetDecoder(Charset charset, float f, float f2) {
        if (f <= 0.0f || f2 <= 0.0f) {
            throw new IllegalArgumentException("averageCharsPerByte and maxCharsPerByte must be positive");
        }
        if (f > f2) {
            throw new IllegalArgumentException("averageCharsPerByte is greater than maxCharsPerByte");
        }
        this.averageCharsPerByte = f;
        this.maxCharsPerByte = f2;
        this.charset = charset;
    }

    private CharBuffer allocateMore(CharBuffer charBuffer) {
        if (charBuffer.capacity() == 0) {
            return CharBuffer.allocate(1);
        }
        CharBuffer allocate = CharBuffer.allocate(charBuffer.capacity() * 2);
        charBuffer.flip();
        allocate.put(charBuffer);
        return allocate;
    }

    private void checkCoderResult(CoderResult coderResult) throws CharacterCodingException {
        if (coderResult.isMalformed() && this.malformedInputAction == CodingErrorAction.REPORT) {
            throw new MalformedInputException(coderResult.length());
        }
        if (coderResult.isUnmappable() && this.unmappableCharacterAction == CodingErrorAction.REPORT) {
            throw new UnmappableCharacterException(coderResult.length());
        }
    }

    private IllegalStateException illegalStateException() {
        throw new IllegalStateException("State: " + this.state);
    }

    public final float averageCharsPerByte() {
        return this.averageCharsPerByte;
    }

    public final Charset charset() {
        return this.charset;
    }

    public final CharBuffer decode(ByteBuffer byteBuffer) throws CharacterCodingException {
        CharBuffer allocate = CharBuffer.allocate((int) (byteBuffer.remaining() * this.averageCharsPerByte));
        reset();
        while (this.state != FLUSHED) {
            CoderResult decode = decode(byteBuffer, allocate, true);
            if (decode == CoderResult.OVERFLOW) {
                allocate = allocateMore(allocate);
            } else {
                checkCoderResult(decode);
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
    public final java.nio.charset.CoderResult decode(java.nio.ByteBuffer r5, java.nio.CharBuffer r6, boolean r7) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.charset.CharsetDecoder.decode(java.nio.ByteBuffer, java.nio.CharBuffer, boolean):java.nio.charset.CoderResult");
    }

    protected abstract CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer);

    public Charset detectedCharset() {
        throw new UnsupportedOperationException();
    }

    public final CoderResult flush(CharBuffer charBuffer) {
        if (this.state == FLUSHED || this.state == END_OF_INPUT) {
            CoderResult implFlush = implFlush(charBuffer);
            if (implFlush == CoderResult.UNDERFLOW) {
                this.state = FLUSHED;
            }
            return implFlush;
        }
        throw illegalStateException();
    }

    protected CoderResult implFlush(CharBuffer charBuffer) {
        return CoderResult.UNDERFLOW;
    }

    protected void implOnMalformedInput(CodingErrorAction codingErrorAction) {
    }

    protected void implOnUnmappableCharacter(CodingErrorAction codingErrorAction) {
    }

    protected void implReplaceWith(String str) {
    }

    protected void implReset() {
    }

    public boolean isAutoDetecting() {
        return false;
    }

    public boolean isCharsetDetected() {
        throw new UnsupportedOperationException();
    }

    public CodingErrorAction malformedInputAction() {
        return this.malformedInputAction;
    }

    public final float maxCharsPerByte() {
        return this.maxCharsPerByte;
    }

    public final CharsetDecoder onMalformedInput(CodingErrorAction codingErrorAction) {
        if (codingErrorAction == null) {
            throw new IllegalArgumentException("newAction == null");
        }
        this.malformedInputAction = codingErrorAction;
        implOnMalformedInput(codingErrorAction);
        return this;
    }

    public final CharsetDecoder onUnmappableCharacter(CodingErrorAction codingErrorAction) {
        if (codingErrorAction == null) {
            throw new IllegalArgumentException("newAction == null");
        }
        this.unmappableCharacterAction = codingErrorAction;
        implOnUnmappableCharacter(codingErrorAction);
        return this;
    }

    public final CharsetDecoder replaceWith(String str) {
        if (str == null) {
            throw new IllegalArgumentException("replacement == null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("replacement.isEmpty()");
        }
        if (str.length() > maxCharsPerByte()) {
            throw new IllegalArgumentException("replacement length > maxCharsPerByte: " + str.length() + " > " + maxCharsPerByte());
        }
        this.replacementChars = str;
        implReplaceWith(str);
        return this;
    }

    public final String replacement() {
        return this.replacementChars;
    }

    public final CharsetDecoder reset() {
        this.state = RESET;
        implReset();
        return this;
    }

    public CodingErrorAction unmappableCharacterAction() {
        return this.unmappableCharacterAction;
    }
}
