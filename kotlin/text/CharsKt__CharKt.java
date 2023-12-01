package kotlin.text;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/CharsKt__CharKt.class */
class CharsKt__CharKt extends CharsKt__CharJVMKt {
    public static final boolean a(char c2, char c3, boolean z) {
        if (c2 == c3) {
            return true;
        }
        if (z) {
            char upperCase = Character.toUpperCase(c2);
            char upperCase2 = Character.toUpperCase(c3);
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
