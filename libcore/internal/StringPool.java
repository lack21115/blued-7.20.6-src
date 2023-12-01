package libcore.internal;

/* loaded from: source-2895416-dex2jar.jar:libcore/internal/StringPool.class */
public final class StringPool {
    private final String[] pool = new String[512];

    private static boolean contentEquals(String str, char[] cArr, int i, int i2) {
        if (str.length() != i2) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return true;
            }
            if (cArr[i + i4] != str.charAt(i4)) {
                return false;
            }
            i3 = i4 + 1;
        }
    }

    public String get(char[] cArr, int i, int i2) {
        int i3 = 0;
        int i4 = i;
        while (true) {
            int i5 = i4;
            if (i5 >= i + i2) {
                break;
            }
            i3 = (i3 * 31) + cArr[i5];
            i4 = i5 + 1;
        }
        int i6 = i3 ^ ((i3 >>> 20) ^ (i3 >>> 12));
        int length = (i6 ^ ((i6 >>> 7) ^ (i6 >>> 4))) & (this.pool.length - 1);
        String str = this.pool[length];
        if (str == null || !contentEquals(str, cArr, i, i2)) {
            String str2 = new String(cArr, i, i2);
            this.pool[length] = str2;
            return str2;
        }
        return str;
    }
}
