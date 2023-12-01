package java.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import libcore.icu.TimeZoneNames;
import libcore.io.IoUtils;
import libcore.util.ZoneInfoDB;
import org.apache.harmony.luni.internal.util.TimezoneGetter;

/* loaded from: source-2895416-dex2jar.jar:java/util/TimeZone.class */
public abstract class TimeZone implements Serializable, Cloneable {
    public static final int LONG = 1;
    public static final int SHORT = 0;
    private static TimeZone defaultTimeZone;
    private static final long serialVersionUID = 3581463369166924961L;
    private String ID;
    private static final Pattern CUSTOM_ZONE_ID_PATTERN = Pattern.compile("^GMT[-+](\\d{1,2})(:?(\\d\\d))?$");
    private static final TimeZone GMT = new SimpleTimeZone(0, "GMT");
    private static final TimeZone UTC = new SimpleTimeZone(0, "UTC");

    private static void appendNumber(StringBuilder sb, int i, int i2) {
        String num = Integer.toString(i2);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i - num.length()) {
                sb.append(num);
                return;
            } else {
                sb.append('0');
                i3 = i4 + 1;
            }
        }
    }

    public static String createGmtOffsetString(boolean z, boolean z2, int i) {
        int i2 = i / 60000;
        char c = '+';
        int i3 = i2;
        if (i2 < 0) {
            c = '-';
            i3 = -i2;
        }
        StringBuilder sb = new StringBuilder(9);
        if (z) {
            sb.append("GMT");
        }
        sb.append(c);
        appendNumber(sb, 2, i3 / 60);
        if (z2) {
            sb.append(':');
        }
        appendNumber(sb, 2, i3 % 60);
        return sb.toString();
    }

    public static String[] getAvailableIDs() {
        String[] availableIDs;
        synchronized (TimeZone.class) {
            try {
                availableIDs = ZoneInfoDB.getInstance().getAvailableIDs();
            } catch (Throwable th) {
                throw th;
            }
        }
        return availableIDs;
    }

    public static String[] getAvailableIDs(int i) {
        String[] availableIDs;
        synchronized (TimeZone.class) {
            try {
                availableIDs = ZoneInfoDB.getInstance().getAvailableIDs(i);
            } catch (Throwable th) {
                throw th;
            }
        }
        return availableIDs;
    }

    private static TimeZone getCustomTimeZone(String str) {
        Matcher matcher = CUSTOM_ZONE_ID_PATTERN.matcher(str);
        if (matcher.matches()) {
            int i = 0;
            try {
                int parseInt = Integer.parseInt(matcher.group(1));
                if (matcher.group(3) != null) {
                    i = Integer.parseInt(matcher.group(3));
                }
                if (parseInt < 0 || parseInt > 23 || i < 0 || i > 59) {
                    return null;
                }
                char charAt = str.charAt(3);
                int i2 = (Grego.MILLIS_PER_HOUR * parseInt) + (60000 * i);
                int i3 = i2;
                if (charAt == '-') {
                    i3 = -i2;
                }
                return new SimpleTimeZone(i3, String.format("GMT%c%02d:%02d", Character.valueOf(charAt), Integer.valueOf(parseInt), Integer.valueOf(i)));
            } catch (NumberFormatException e) {
                throw new AssertionError(e);
            }
        }
        return null;
    }

    public static TimeZone getDefault() {
        TimeZone timeZone;
        synchronized (TimeZone.class) {
            try {
                if (defaultTimeZone == null) {
                    TimezoneGetter timezoneGetter = TimezoneGetter.getInstance();
                    String id = timezoneGetter != null ? timezoneGetter.getId() : null;
                    String str = id;
                    if (id != null) {
                        str = id.trim();
                    }
                    if (str == null || str.isEmpty()) {
                        try {
                            str = IoUtils.readFileAsString("/etc/timezone");
                        } catch (IOException e) {
                            str = "GMT";
                        }
                    }
                    defaultTimeZone = getTimeZone(str);
                }
                timeZone = (TimeZone) defaultTimeZone.clone();
            } catch (Throwable th) {
                throw th;
            }
        }
        return timeZone;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:9|(4:11|(1:13)(2:18|(1:20))|14|15)|21|22|23|24|25|(3:27|28|(4:30|31|32|(1:34)))|35|(1:37)|38|14|15) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.TimeZone getTimeZone(java.lang.String r4) {
        /*
            java.lang.Class<java.util.TimeZone> r0 = java.util.TimeZone.class
            monitor-enter(r0)
            r0 = r4
            if (r0 != 0) goto L17
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> L11
            r1 = r0
            java.lang.String r2 = "id == null"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L11
            throw r0     // Catch: java.lang.Throwable -> L11
        L11:
            r4 = move-exception
            java.lang.Class<java.util.TimeZone> r0 = java.util.TimeZone.class
            monitor-exit(r0)
            r0 = r4
            throw r0
        L17:
            r0 = r4
            int r0 = r0.length()     // Catch: java.lang.Throwable -> L11
            r1 = 3
            if (r0 != r1) goto L4d
            r0 = r4
            java.lang.String r1 = "GMT"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L11
            if (r0 == 0) goto L37
            java.util.TimeZone r0 = java.util.TimeZone.GMT     // Catch: java.lang.Throwable -> L11
            java.lang.Object r0 = r0.clone()     // Catch: java.lang.Throwable -> L11
            java.util.TimeZone r0 = (java.util.TimeZone) r0     // Catch: java.lang.Throwable -> L11
            r4 = r0
        L32:
            java.lang.Class<java.util.TimeZone> r0 = java.util.TimeZone.class
            monitor-exit(r0)
            r0 = r4
            return r0
        L37:
            r0 = r4
            java.lang.String r1 = "UTC"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L11
            if (r0 == 0) goto L4d
            java.util.TimeZone r0 = java.util.TimeZone.UTC     // Catch: java.lang.Throwable -> L11
            java.lang.Object r0 = r0.clone()     // Catch: java.lang.Throwable -> L11
            java.util.TimeZone r0 = (java.util.TimeZone) r0     // Catch: java.lang.Throwable -> L11
            r4 = r0
            goto L32
        L4d:
            r0 = 0
            r5 = r0
            libcore.util.ZoneInfoDB$TzData r0 = libcore.util.ZoneInfoDB.getInstance()     // Catch: java.lang.Throwable -> L11 java.io.IOException -> L89
            r1 = r4
            libcore.util.ZoneInfo r0 = r0.makeTimeZone(r1)     // Catch: java.lang.Throwable -> L11 java.io.IOException -> L89
            r6 = r0
            r0 = r6
            r5 = r0
        L59:
            r0 = r5
            r6 = r0
            r0 = r5
            if (r0 != 0) goto L8d
            r0 = r5
            r6 = r0
            r0 = r4
            int r0 = r0.length()     // Catch: java.lang.Throwable -> L11
            r1 = 3
            if (r0 <= r1) goto L8d
            r0 = r5
            r6 = r0
            r0 = r4
            java.lang.String r1 = "GMT"
            boolean r0 = r0.startsWith(r1)     // Catch: java.lang.Throwable -> L11
            if (r0 == 0) goto L8d
            r0 = r4
            java.util.TimeZone r0 = getCustomTimeZone(r0)     // Catch: java.lang.Throwable -> L11
            r6 = r0
            goto L8d
        L7c:
            java.util.TimeZone r0 = java.util.TimeZone.GMT     // Catch: java.lang.Throwable -> L11
            java.lang.Object r0 = r0.clone()     // Catch: java.lang.Throwable -> L11
            java.util.TimeZone r0 = (java.util.TimeZone) r0     // Catch: java.lang.Throwable -> L11
            r6 = r0
            goto L91
        L89:
            r6 = move-exception
            goto L59
        L8d:
            r0 = r6
            if (r0 == 0) goto L7c
        L91:
            r0 = r6
            r4 = r0
            goto L32
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.TimeZone.getTimeZone(java.lang.String):java.util.TimeZone");
    }

    public static void setDefault(TimeZone timeZone) {
        TimeZone timeZone2;
        synchronized (TimeZone.class) {
            if (timeZone != null) {
                try {
                    timeZone2 = (TimeZone) timeZone.clone();
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                timeZone2 = null;
            }
            defaultTimeZone = timeZone2;
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public int getDSTSavings() {
        if (useDaylightTime()) {
            return Grego.MILLIS_PER_HOUR;
        }
        return 0;
    }

    public final String getDisplayName() {
        return getDisplayName(false, 1, Locale.getDefault());
    }

    public final String getDisplayName(Locale locale) {
        return getDisplayName(false, 1, locale);
    }

    public final String getDisplayName(boolean z, int i) {
        return getDisplayName(z, i, Locale.getDefault());
    }

    public String getDisplayName(boolean z, int i, Locale locale) {
        if (i == 0 || i == 1) {
            String displayName = TimeZoneNames.getDisplayName(TimeZoneNames.getZoneStrings(locale), getID(), z, i);
            if (displayName != null) {
                return displayName;
            }
            int rawOffset = getRawOffset();
            int i2 = rawOffset;
            if (z) {
                i2 = rawOffset + getDSTSavings();
            }
            return createGmtOffsetString(true, true, i2);
        }
        throw new IllegalArgumentException("Bad style: " + i);
    }

    public String getID() {
        return this.ID;
    }

    public abstract int getOffset(int i, int i2, int i3, int i4, int i5, int i6);

    public int getOffset(long j) {
        return inDaylightTime(new Date(j)) ? getRawOffset() + getDSTSavings() : getRawOffset();
    }

    public abstract int getRawOffset();

    public boolean hasSameRules(TimeZone timeZone) {
        return timeZone != null && getRawOffset() == timeZone.getRawOffset();
    }

    public abstract boolean inDaylightTime(Date date);

    public void setID(String str) {
        if (str == null) {
            throw new NullPointerException("id == null");
        }
        this.ID = str;
    }

    public abstract void setRawOffset(int i);

    public abstract boolean useDaylightTime();
}
