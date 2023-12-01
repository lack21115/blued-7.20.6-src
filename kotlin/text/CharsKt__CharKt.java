package kotlin.text;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/CharsKt__CharKt.class */
class CharsKt__CharKt extends CharsKt__CharJVMKt {
    public static final boolean a(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (z) {
            char upperCase = Character.toUpperCase(c);
            char upperCase2 = Character.toUpperCase(c2);
            boolean z2 = true;
            if (upperCase != upperCase2) {
                if (Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) {
                    return true;
                }
                z2 = false;
            }
            return z2;
        }
        return false;
    }
}
