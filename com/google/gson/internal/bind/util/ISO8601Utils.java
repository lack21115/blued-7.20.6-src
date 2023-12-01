package com.google.gson.internal.bind.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: source-8110460-dex2jar.jar:com/google/gson/internal/bind/util/ISO8601Utils.class */
public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone("UTC");
    private static final String UTC_ID = "UTC";

    private static boolean checkOffset(String str, int i, char c2) {
        return i < str.length() && str.charAt(i) == c2;
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z) {
        return format(date, z, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        char c2 = '-';
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            int abs = Math.abs(i / 60);
            int abs2 = Math.abs(i % 60);
            if (offset >= 0) {
                c2 = '+';
            }
            sb.append(c2);
            padInt(sb, abs, 2);
            sb.append(':');
            padInt(sb, abs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                i++;
            }
            return i;
        }
        return str.length();
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String num = Integer.toString(i);
        int i3 = i2;
        int length = num.length();
        while (true) {
            int i4 = i3 - length;
            if (i4 <= 0) {
                sb.append(num);
                return;
            }
            sb.append('0');
            i3 = i4;
            length = 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x033f, code lost:
        if (r0.isEmpty() != false) goto L121;
     */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016a A[Catch: IllegalArgumentException -> 0x02ef, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x02f4, IndexOutOfBoundsException -> 0x02f9, TRY_LEAVE, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x02f4, blocks: (B:2:0x0000, B:4:0x000a, B:6:0x0016, B:11:0x002b, B:13:0x0037, B:18:0x004c, B:20:0x0064, B:22:0x006d, B:27:0x0099, B:29:0x00a5, B:34:0x00ba, B:36:0x00c6, B:40:0x00d6, B:42:0x00de, B:50:0x00ff, B:56:0x011d, B:60:0x012e, B:66:0x0162, B:68:0x016a, B:71:0x0176, B:95:0x028b, B:95:0x028b, B:96:0x028e, B:76:0x01b0, B:81:0x01e3, B:83:0x01f4, B:86:0x0201, B:88:0x0239, B:91:0x024d, B:92:0x0285, B:93:0x0286, B:93:0x0286, B:79:0x01c2, B:73:0x0182, B:74:0x01ae, B:98:0x02e5, B:98:0x02e5, B:99:0x02e8, B:100:0x02ee), top: B:130:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02e5 A[Catch: IllegalArgumentException -> 0x02ef, IllegalArgumentException -> 0x02ef, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x02f4, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x02f4, IndexOutOfBoundsException -> 0x02f9, IndexOutOfBoundsException -> 0x02f9, TRY_ENTER, TRY_LEAVE, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x02f4, blocks: (B:2:0x0000, B:4:0x000a, B:6:0x0016, B:11:0x002b, B:13:0x0037, B:18:0x004c, B:20:0x0064, B:22:0x006d, B:27:0x0099, B:29:0x00a5, B:34:0x00ba, B:36:0x00c6, B:40:0x00d6, B:42:0x00de, B:50:0x00ff, B:56:0x011d, B:60:0x012e, B:66:0x0162, B:68:0x016a, B:71:0x0176, B:95:0x028b, B:95:0x028b, B:96:0x028e, B:76:0x01b0, B:81:0x01e3, B:83:0x01f4, B:86:0x0201, B:88:0x0239, B:91:0x024d, B:92:0x0285, B:93:0x0286, B:93:0x0286, B:79:0x01c2, B:73:0x0182, B:74:0x01ae, B:98:0x02e5, B:98:0x02e5, B:99:0x02e8, B:100:0x02ee), top: B:130:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Date parse(java.lang.String r6, java.text.ParsePosition r7) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 1016
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i3 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = -digit;
        } else {
            i3 = i;
            i4 = 0;
        }
        while (i3 < i2) {
            int digit2 = Character.digit(str.charAt(i3), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = (i4 * 10) - digit2;
            i3++;
        }
        return -i4;
    }
}
