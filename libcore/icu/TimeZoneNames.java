package libcore.icu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import libcore.util.BasicLruCache;
import libcore.util.ZoneInfoDB;

/* loaded from: source-2895416-dex2jar.jar:libcore/icu/TimeZoneNames.class */
public final class TimeZoneNames {
    public static final int LONG_NAME = 1;
    public static final int LONG_NAME_DST = 3;
    public static final int NAME_COUNT = 5;
    public static final int OLSON_NAME = 0;
    public static final int SHORT_NAME = 2;
    public static final int SHORT_NAME_DST = 4;
    private static final Comparator<String[]> ZONE_STRINGS_COMPARATOR;
    private static final String[] availableTimeZoneIds = TimeZone.getAvailableIDs();
    private static final ZoneStringsCache cachedZoneStrings = new ZoneStringsCache();

    /* loaded from: source-2895416-dex2jar.jar:libcore/icu/TimeZoneNames$ZoneStringsCache.class */
    public static class ZoneStringsCache extends BasicLruCache<Locale, String[][]> {
        public ZoneStringsCache() {
            super(5);
        }

        private void internStrings(String[][] strArr) {
            synchronized (this) {
                HashMap hashMap = new HashMap();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < strArr.length) {
                        int i3 = 1;
                        while (true) {
                            int i4 = i3;
                            if (i4 < 5) {
                                String str = strArr[i2][i4];
                                String str2 = (String) hashMap.get(str);
                                if (str2 == null) {
                                    hashMap.put(str, str);
                                } else {
                                    strArr[i2][i4] = str2;
                                }
                                i3 = i4 + 1;
                            }
                        }
                        i = i2 + 1;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // libcore.util.BasicLruCache
        public String[][] create(Locale locale) {
            long currentTimeMillis = System.currentTimeMillis();
            String[][] strArr = (String[][]) Array.newInstance(String.class, TimeZoneNames.availableTimeZoneIds.length, 5);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= TimeZoneNames.availableTimeZoneIds.length) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    TimeZoneNames.fillZoneStrings(locale.toString(), strArr);
                    long currentTimeMillis3 = System.currentTimeMillis();
                    internStrings(strArr);
                    System.logI("Loaded time zone names for \"" + locale + "\" in " + (System.currentTimeMillis() - currentTimeMillis) + "ms (" + (currentTimeMillis3 - currentTimeMillis2) + "ms in ICU)");
                    return strArr;
                }
                strArr[i2][0] = TimeZoneNames.availableTimeZoneIds[i2];
                i = i2 + 1;
            }
        }
    }

    static {
        cachedZoneStrings.get(Locale.ROOT);
        cachedZoneStrings.get(Locale.US);
        cachedZoneStrings.get(Locale.getDefault());
        ZONE_STRINGS_COMPARATOR = new Comparator<String[]>() { // from class: libcore.icu.TimeZoneNames.1
            @Override // java.util.Comparator
            public int compare(String[] strArr, String[] strArr2) {
                return strArr[0].compareTo(strArr2[0]);
            }
        };
    }

    private TimeZoneNames() {
    }

    public static void clearLocaleCache() {
        Locale locale = Locale.getDefault();
        if (locale.equals(Locale.US) || locale.equals(Locale.ROOT)) {
            return;
        }
        cachedZoneStrings.remove(locale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void fillZoneStrings(String str, String[][] strArr);

    public static String[] forLocale(Locale locale) {
        String country = locale.getCountry();
        ArrayList arrayList = new ArrayList();
        String[] split = ZoneInfoDB.getInstance().getZoneTab().split("\n");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            String str = split[i2];
            if (str.startsWith(country)) {
                int indexOf = str.indexOf(9, 4) + 1;
                int indexOf2 = str.indexOf(9, indexOf);
                int i3 = indexOf2;
                if (indexOf2 == -1) {
                    i3 = str.length();
                }
                arrayList.add(str.substring(indexOf, i3));
            }
            i = i2 + 1;
        }
    }

    public static String getDisplayName(String[][] strArr, String str, boolean z, int i) {
        int binarySearch = Arrays.binarySearch(strArr, new String[]{str}, ZONE_STRINGS_COMPARATOR);
        if (binarySearch >= 0) {
            String[] strArr2 = strArr[binarySearch];
            return z ? i == 1 ? strArr2[3] : strArr2[4] : i == 1 ? strArr2[1] : strArr2[2];
        }
        return null;
    }

    public static native String getExemplarLocation(String str, String str2);

    public static String[][] getZoneStrings(Locale locale) {
        Locale locale2 = locale;
        if (locale == null) {
            locale2 = Locale.getDefault();
        }
        return cachedZoneStrings.get(locale2);
    }
}
