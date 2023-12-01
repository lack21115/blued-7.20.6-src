package kotlin.text;

import kotlin.Metadata;
import kotlin.ranges.IntRange;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/CharsKt__CharJVMKt.class */
public class CharsKt__CharJVMKt {
    public static final int a(char c, int i) {
        return Character.digit((int) c, i);
    }

    public static final int a(int i) {
        boolean z = false;
        if (2 <= i) {
            z = false;
            if (i < 37) {
                z = true;
            }
        }
        if (z) {
            return i;
        }
        throw new IllegalArgumentException("radix " + i + " was not in valid range " + new IntRange(2, 36));
    }

    public static final boolean a(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }
}
