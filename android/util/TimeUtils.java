package android.util;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.SystemClock;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;
import libcore.util.ZoneInfoDB;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/util/TimeUtils.class */
public class TimeUtils {
    private static final boolean DBG = false;
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final long LARGEST_DURATION = 86399999999L;
    public static final long NANOS_PER_MS = 1000000;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final String TAG = "TimeUtils";
    private static final Object sLastLockObj = new Object();
    private static ArrayList<TimeZone> sLastZones = null;
    private static String sLastCountry = null;
    private static final Object sLastUniqueLockObj = new Object();
    private static ArrayList<TimeZone> sLastUniqueZoneOffsets = null;
    private static String sLastUniqueCountry = null;
    private static final Object sFormatSync = new Object();
    private static char[] sFormatStr = new char[24];

    private static int accumField(int i, int i2, boolean z, int i3) {
        if (i > 99 || (z && i3 >= 3)) {
            return i2 + 3;
        }
        if (i > 9 || (z && i3 >= 2)) {
            return i2 + 2;
        }
        if (z || i > 0) {
            return i2 + 1;
        }
        return 0;
    }

    public static void formatDuration(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j - j2, printWriter, 0);
        }
    }

    public static void formatDuration(long j, PrintWriter printWriter) {
        formatDuration(j, printWriter, 0);
    }

    public static void formatDuration(long j, PrintWriter printWriter, int i) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j, i)));
        }
    }

    public static void formatDuration(long j, StringBuilder sb) {
        synchronized (sFormatSync) {
            sb.append(sFormatStr, 0, formatDurationLocked(j, 0));
        }
    }

    private static int formatDurationLocked(long j, int i) {
        char c2;
        if (sFormatStr.length < i) {
            sFormatStr = new char[i];
        }
        char[] cArr = sFormatStr;
        if (j != 0) {
            if (j > 0) {
                c2 = '+';
            } else {
                c2 = '-';
                j = -j;
            }
            long j2 = j;
            if (j > LARGEST_DURATION) {
                j2 = 86399999999L;
            }
            int i2 = (int) (j2 % 1000);
            int floor = (int) Math.floor(j2 / 1000);
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = floor;
            if (floor > 86400) {
                i3 = floor / 86400;
                i6 = floor - (86400 * i3);
            }
            int i7 = i6;
            if (i6 > 3600) {
                i4 = i6 / 3600;
                i7 = i6 - (i4 * 3600);
            }
            int i8 = i7;
            if (i7 > 60) {
                i5 = i7 / 60;
                i8 = i7 - (i5 * 60);
            }
            int i9 = 0;
            if (i != 0) {
                int accumField = accumField(i3, 1, false, 0);
                int accumField2 = accumField + accumField(i4, 1, accumField > 0, 2);
                int accumField3 = accumField2 + accumField(i5, 1, accumField2 > 0, 2);
                int accumField4 = accumField3 + accumField(i8, 1, accumField3 > 0, 2);
                int accumField5 = accumField4 + accumField(i2, 2, true, accumField4 > 0 ? 3 : 0) + 1;
                int i10 = 0;
                while (true) {
                    i9 = i10;
                    if (accumField5 >= i) {
                        break;
                    }
                    cArr[i10] = ' ';
                    i10++;
                    accumField5++;
                }
            }
            cArr[i9] = c2;
            int i11 = i9 + 1;
            boolean z = i != 0;
            int printField = printField(cArr, i3, 'd', i11, false, 0);
            int printField2 = printField(cArr, i4, 'h', printField, printField != i11, z ? 2 : 0);
            int printField3 = printField(cArr, i5, 'm', printField2, printField2 != i11, z ? 2 : 0);
            int printField4 = printField(cArr, i8, 's', printField3, printField3 != i11, z ? 2 : 0);
            int printField5 = printField(cArr, i2, 'm', printField4, true, (!z || printField4 == i11) ? 0 : 3);
            cArr[printField5] = 's';
            return printField5 + 1;
        }
        int i12 = 0;
        while (true) {
            int i13 = i12;
            if (i13 >= i - 1) {
                cArr[i13] = '0';
                return i13 + 1;
            }
            cArr[i13] = ' ';
            i12 = i13 + 1;
        }
    }

    public static String formatUptime(long j) {
        long uptimeMillis = j - SystemClock.uptimeMillis();
        return uptimeMillis > 0 ? j + " (in " + uptimeMillis + " ms)" : uptimeMillis < 0 ? j + " (" + (-uptimeMillis) + " ms ago)" : j + " (now)";
    }

    public static TimeZone getTimeZone(int i, boolean z, long j, String str) {
        Date date = new Date(j);
        TimeZone timeZone = TimeZone.getDefault();
        String id = timeZone.getID();
        int offset = timeZone.getOffset(j);
        boolean inDaylightTime = timeZone.inDaylightTime(date);
        Iterator<TimeZone> it = getTimeZones(str).iterator();
        TimeZone timeZone2 = null;
        while (it.hasNext()) {
            TimeZone next = it.next();
            if (next.getID().equals(id) && offset == i && inDaylightTime == z) {
                return timeZone;
            }
            if (timeZone2 == null && next.getOffset(j) == i && next.inDaylightTime(date) == z) {
                timeZone2 = next;
            }
        }
        return timeZone2;
    }

    public static String getTimeZoneDatabaseVersion() {
        return ZoneInfoDB.getInstance().getVersion();
    }

    public static ArrayList<TimeZone> getTimeZones(String str) {
        ArrayList<TimeZone> arrayList;
        synchronized (sLastLockObj) {
            if (str != null) {
                if (str.equals(sLastCountry)) {
                    return sLastZones;
                }
            }
            ArrayList<TimeZone> arrayList2 = new ArrayList<>();
            if (str != null) {
                XmlResourceParser xml = Resources.getSystem().getXml(17891347);
                try {
                    XmlUtils.beginDocument(xml, "timezones");
                    while (true) {
                        XmlUtils.nextElement(xml);
                        String name = xml.getName();
                        if (name == null || !name.equals("timezone")) {
                            break;
                        } else if (str.equals(xml.getAttributeValue(null, "code")) && xml.next() == 4) {
                            TimeZone timeZone = TimeZone.getTimeZone(xml.getText());
                            if (!timeZone.getID().startsWith("GMT")) {
                                arrayList2.add(timeZone);
                            }
                        }
                    }
                } catch (IOException e) {
                    Log.e(TAG, "Got IO exception getTimeZone('" + str + "'): e=", e);
                } catch (XmlPullParserException e2) {
                    Log.e(TAG, "Got xml parser exception getTimeZone('" + str + "'): e=", e2);
                } finally {
                    xml.close();
                }
                synchronized (sLastLockObj) {
                    sLastZones = arrayList2;
                    sLastCountry = str;
                    arrayList = sLastZones;
                }
                return arrayList;
            }
            return arrayList2;
        }
    }

    public static ArrayList<TimeZone> getTimeZonesWithUniqueOffsets(String str) {
        ArrayList<TimeZone> arrayList;
        boolean z;
        synchronized (sLastUniqueLockObj) {
            if (str != null) {
                if (str.equals(sLastUniqueCountry)) {
                    return sLastUniqueZoneOffsets;
                }
            }
            ArrayList<TimeZone> timeZones = getTimeZones(str);
            ArrayList<TimeZone> arrayList2 = new ArrayList<>();
            for (TimeZone timeZone : timeZones) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    z = false;
                    if (i2 >= arrayList2.size()) {
                        break;
                    } else if (arrayList2.get(i2).getRawOffset() == timeZone.getRawOffset()) {
                        z = true;
                        break;
                    } else {
                        i = i2 + 1;
                    }
                }
                if (!z) {
                    arrayList2.add(timeZone);
                }
            }
            synchronized (sLastUniqueLockObj) {
                sLastUniqueZoneOffsets = arrayList2;
                sLastUniqueCountry = str;
                arrayList = sLastUniqueZoneOffsets;
            }
            return arrayList;
        }
    }

    public static String logTimeOfDay(long j) {
        Calendar calendar = Calendar.getInstance();
        if (j >= 0) {
            calendar.setTimeInMillis(j);
            return String.format("%tm-%td %tH:%tM:%tS.%tL", calendar, calendar, calendar, calendar, calendar, calendar);
        }
        return Long.toString(j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
        if (r6 > 99) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005c, code lost:
        if (r8 != r12) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0009, code lost:
        if (r6 > 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int printField(char[] r5, int r6, char r7, int r8, boolean r9, int r10) {
        /*
            r0 = r9
            if (r0 != 0) goto Lc
            r0 = r8
            r11 = r0
            r0 = r6
            if (r0 <= 0) goto L92
        Lc:
            r0 = r9
            if (r0 == 0) goto L17
            r0 = r10
            r1 = 3
            if (r0 >= r1) goto L23
        L17:
            r0 = r6
            r11 = r0
            r0 = r8
            r12 = r0
            r0 = r6
            r1 = 99
            if (r0 <= r1) goto L40
        L23:
            r0 = r6
            r1 = 100
            int r0 = r0 / r1
            r11 = r0
            r0 = r5
            r1 = r8
            r2 = r11
            r3 = 48
            int r2 = r2 + r3
            char r2 = (char) r2
            r0[r1] = r2
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r12 = r0
            r0 = r6
            r1 = r11
            r2 = 100
            int r1 = r1 * r2
            int r0 = r0 - r1
            r11 = r0
        L40:
            r0 = r9
            if (r0 == 0) goto L4b
            r0 = r10
            r1 = 2
            if (r0 >= r1) goto L5f
        L4b:
            r0 = r11
            r1 = 9
            if (r0 > r1) goto L5f
            r0 = r11
            r10 = r0
            r0 = r12
            r6 = r0
            r0 = r8
            r1 = r12
            if (r0 == r1) goto L7c
        L5f:
            r0 = r11
            r1 = 10
            int r0 = r0 / r1
            r8 = r0
            r0 = r5
            r1 = r12
            r2 = r8
            r3 = 48
            int r2 = r2 + r3
            char r2 = (char) r2
            r0[r1] = r2
            r0 = r12
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            r0 = r11
            r1 = r8
            r2 = 10
            int r1 = r1 * r2
            int r0 = r0 - r1
            r10 = r0
        L7c:
            r0 = r5
            r1 = r6
            r2 = r10
            r3 = 48
            int r2 = r2 + r3
            char r2 = (char) r2
            r0[r1] = r2
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            r0 = r5
            r1 = r6
            r2 = r7
            r0[r1] = r2
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r11 = r0
        L92:
            r0 = r11
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.util.TimeUtils.printField(char[], int, char, int, boolean, int):int");
    }
}
