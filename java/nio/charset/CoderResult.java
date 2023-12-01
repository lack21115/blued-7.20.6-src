package java.nio.charset;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.WeakHashMap;

/* loaded from: source-2895416-dex2jar.jar:java/nio/charset/CoderResult.class */
public class CoderResult {
    private static final int TYPE_MALFORMED_INPUT = 3;
    private static final int TYPE_OVERFLOW = 2;
    private static final int TYPE_UNDERFLOW = 1;
    private static final int TYPE_UNMAPPABLE_CHAR = 4;
    private final int length;
    private final int type;
    public static final CoderResult UNDERFLOW = new CoderResult(1, 0);
    public static final CoderResult OVERFLOW = new CoderResult(2, 0);
    private static WeakHashMap<Integer, CoderResult> _malformedErrors = new WeakHashMap<>();
    private static WeakHashMap<Integer, CoderResult> _unmappableErrors = new WeakHashMap<>();

    private CoderResult(int i, int i2) {
        this.type = i;
        this.length = i2;
    }

    public static CoderResult malformedForLength(int i) throws IllegalArgumentException {
        CoderResult coderResult;
        synchronized (CoderResult.class) {
            try {
                if (i <= 0) {
                    throw new IllegalArgumentException("length <= 0: " + i);
                }
                Integer valueOf = Integer.valueOf(i);
                synchronized (_malformedErrors) {
                    CoderResult coderResult2 = _malformedErrors.get(valueOf);
                    coderResult = coderResult2;
                    if (coderResult2 == null) {
                        coderResult = new CoderResult(3, i);
                        _malformedErrors.put(valueOf, coderResult);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return coderResult;
    }

    public static CoderResult unmappableForLength(int i) throws IllegalArgumentException {
        CoderResult coderResult;
        synchronized (CoderResult.class) {
            try {
                if (i <= 0) {
                    throw new IllegalArgumentException("length <= 0: " + i);
                }
                Integer valueOf = Integer.valueOf(i);
                synchronized (_unmappableErrors) {
                    CoderResult coderResult2 = _unmappableErrors.get(valueOf);
                    coderResult = coderResult2;
                    if (coderResult2 == null) {
                        coderResult = new CoderResult(4, i);
                        _unmappableErrors.put(valueOf, coderResult);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return coderResult;
    }

    public boolean isError() {
        return this.type == 3 || this.type == 4;
    }

    public boolean isMalformed() {
        return this.type == 3;
    }

    public boolean isOverflow() {
        return this.type == 2;
    }

    public boolean isUnderflow() {
        return this.type == 1;
    }

    public boolean isUnmappable() {
        return this.type == 4;
    }

    public int length() throws UnsupportedOperationException {
        if (this.type == 3 || this.type == 4) {
            return this.length;
        }
        throw new UnsupportedOperationException("length meaningless for " + toString());
    }

    public void throwException() throws BufferUnderflowException, BufferOverflowException, UnmappableCharacterException, MalformedInputException, CharacterCodingException {
        switch (this.type) {
            case 1:
                throw new BufferUnderflowException();
            case 2:
                throw new BufferOverflowException();
            case 3:
                throw new MalformedInputException(this.length);
            case 4:
                throw new UnmappableCharacterException(this.length);
            default:
                throw new CharacterCodingException();
        }
    }

    public String toString() {
        String str;
        switch (this.type) {
            case 1:
                str = "UNDERFLOW error";
                break;
            case 2:
                str = "OVERFLOW error";
                break;
            case 3:
                str = "Malformed-input error with erroneous input length " + this.length;
                break;
            case 4:
                str = "Unmappable-character error with erroneous input length " + this.length;
                break;
            default:
                str = "";
                break;
        }
        return getClass().getName() + "[" + str + "]";
    }
}
