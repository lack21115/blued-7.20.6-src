package com.anythink.expressad.exoplayer.k;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/af.class */
public final class af {

    /* renamed from: a  reason: collision with root package name */
    public static final int f7632a;
    public static final String b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f7633c;
    public static final String d;
    public static final String e;
    private static final String f = "Util";
    private static final Pattern g;
    private static final Pattern h;
    private static final Pattern i;
    private static final int[] j;

    static {
        f7632a = (Build.VERSION.SDK_INT == 25 && Build.VERSION.CODENAME.charAt(0) == 'O') ? 26 : Build.VERSION.SDK_INT;
        b = Build.DEVICE;
        f7633c = Build.MANUFACTURER;
        d = Build.MODEL;
        e = b + ", " + d + ", " + f7633c + ", " + f7632a;
        g = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        h = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        i = Pattern.compile("%([A-Fa-f0-9]{2})");
        j = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
    }

    private af() {
    }

    public static float a(float f2) {
        return Math.max(0.1f, Math.min(f2, 8.0f));
    }

    public static int a(int i2, int i3) {
        return ((i2 + i3) - 1) / i3;
    }

    public static int a(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i2, i4));
    }

    private static int a(Uri uri, String str) {
        if (TextUtils.isEmpty(str)) {
            String path = uri.getPath();
            if (path == null) {
                return 3;
            }
            return l(path);
        }
        return l(".".concat(String.valueOf(str)));
    }

    private static <T> int a(List<? extends Comparable<? super T>> list, T t, boolean z, boolean z2) {
        int i2;
        int i3;
        int binarySearch = Collections.binarySearch(list, t);
        int i4 = binarySearch;
        if (binarySearch < 0) {
            i3 = -(binarySearch + 2);
        } else {
            do {
                i2 = i4 - 1;
                if (i2 < 0) {
                    break;
                }
                i4 = i2;
            } while (list.get(i2).compareTo(t) == 0);
            i3 = z ? i2 + 1 : i2;
        }
        int i5 = i3;
        if (z2) {
            i5 = Math.max(0, i3);
        }
        return i5;
    }

    private static int a(byte[] bArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            i4 = j[((i4 >>> 24) ^ (bArr[i2] & 255)) & 255] ^ (i4 << 8);
            i2++;
        }
        return i4;
    }

    public static int a(int[] iArr, int i2) {
        int i3;
        int binarySearch = Arrays.binarySearch(iArr, i2);
        int i4 = binarySearch;
        if (binarySearch < 0) {
            return -(binarySearch + 2);
        }
        do {
            i3 = i4 - 1;
            if (i3 < 0) {
                break;
            }
            i4 = i3;
        } while (iArr[i3] == i2);
        return i3;
    }

    public static int a(long[] jArr, long j2, boolean z) {
        int i2;
        int i3;
        int binarySearch = Arrays.binarySearch(jArr, j2);
        int i4 = binarySearch;
        if (binarySearch < 0) {
            i3 = -(binarySearch + 2);
        } else {
            do {
                i2 = i4 - 1;
                if (i2 < 0) {
                    break;
                }
                i4 = i2;
            } while (jArr[i2] == j2);
            i3 = i2 + 1;
        }
        int i5 = i3;
        if (z) {
            i5 = Math.max(0, i3);
        }
        return i5;
    }

    public static int a(long[] jArr, long j2, boolean z, boolean z2) {
        int i2;
        int i3;
        int binarySearch = Arrays.binarySearch(jArr, j2);
        int i4 = binarySearch;
        if (binarySearch < 0) {
            i3 = binarySearch;
        } else {
            do {
                i2 = i4 + 1;
                if (i2 >= jArr.length) {
                    break;
                }
                i4 = i2;
            } while (jArr[i2] == j2);
            i3 = z ? i2 - 1 : i2;
        }
        return z2 ? Math.min(jArr.length - 1, i3) : i3;
    }

    public static long a(long j2, float f2) {
        return f2 == 1.0f ? j2 : Math.round(j2 * f2);
    }

    public static long a(long j2, long j3) {
        return Math.max(0L, Math.min(j2, j3));
    }

    public static long a(long j2, long j3, long j4) {
        int i2 = (j4 > j3 ? 1 : (j4 == j3 ? 0 : -1));
        if (i2 < 0 || j4 % j3 != 0) {
            if (i2 >= 0 || j3 % j4 != 0) {
                return (long) (j2 * (j3 / j4));
            }
            return j2 * (j3 / j4);
        }
        return j2 / (j4 / j3);
    }

    public static long a(long j2, com.anythink.expressad.exoplayer.ac acVar, long j3, long j4) {
        if (com.anythink.expressad.exoplayer.ac.f7157a.equals(acVar)) {
            return j2;
        }
        long j5 = acVar.f;
        long j6 = j2 - j5;
        long j7 = j6;
        if (((j5 ^ j2) & (j2 ^ j6)) < 0) {
            j7 = Long.MIN_VALUE;
        }
        long j8 = acVar.g;
        long j9 = j2 + j8;
        long j10 = j9;
        if (((j8 ^ j9) & (j2 ^ j9)) < 0) {
            j10 = Long.MAX_VALUE;
        }
        boolean z = true;
        boolean z2 = j7 <= j3 && j3 <= j10;
        if (j7 > j4 || j4 > j10) {
            z = false;
        }
        return (z2 && z) ? Math.abs(j3 - j2) <= Math.abs(j4 - j2) ? j3 : j4 : z2 ? j3 : z ? j4 : j7;
    }

    public static ComponentName a(Context context, Intent intent) {
        return f7632a >= 26 ? context.startForegroundService(intent) : context.startService(intent);
    }

    public static Point a(Context context) {
        return a(context, ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay());
    }

    private static Point a(Context context, Display display) {
        if (f7632a < 25 && display.getDisplayId() == 0) {
            if ("Sony".equals(f7633c) && d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
            if (("NVIDIA".equals(f7633c) && d.contains("SHIELD")) || ("philips".equals(d(f7633c)) && (d.startsWith("QM1") || d.equals("QV151E") || d.equals("TPM171E")))) {
                String str = null;
                try {
                    Class<?> cls = Class.forName("android.os.SystemProperties");
                    str = (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, "sys.display-size");
                } catch (Exception e2) {
                    Log.e(f, "Failed to read sys.display-size", e2);
                }
                if (!TextUtils.isEmpty(str)) {
                    try {
                        String[] split = str.trim().split("x", -1);
                        if (split.length == 2) {
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            if (parseInt > 0 && parseInt2 > 0) {
                                return new Point(parseInt, parseInt2);
                            }
                        }
                    } catch (NumberFormatException e3) {
                    }
                    Log.e(f, "Invalid sys.display-size: ".concat(String.valueOf(str)));
                }
            }
        }
        Point point = new Point();
        int i2 = f7632a;
        if (i2 >= 23) {
            Display.Mode mode = display.getMode();
            point.x = mode.getPhysicalWidth();
            point.y = mode.getPhysicalHeight();
            return point;
        } else if (i2 >= 17) {
            display.getRealSize(point);
            return point;
        } else if (i2 >= 16) {
            display.getSize(point);
            return point;
        } else {
            point.x = display.getWidth();
            point.y = display.getHeight();
            return point;
        }
    }

    private static String a(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            str2 = "?";
        }
        return str + BridgeUtil.SPLIT_MARK + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") ExoPlayerLib/2.8.4";
    }

    private static String a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.trim().split("(\\s*,\\s*)", -1);
        StringBuilder sb = new StringBuilder();
        int length = split.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                break;
            }
            String str2 = split[i4];
            if (i2 == o.f(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
            i3 = i4 + 1;
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private static String a(StringBuilder sb, Formatter formatter, long j2) {
        long j3 = j2;
        if (j2 == com.anythink.expressad.exoplayer.b.b) {
            j3 = 0;
        }
        long j4 = (j3 + 500) / 1000;
        long j5 = j4 % 60;
        long j6 = (j4 / 60) % 60;
        long j7 = j4 / com.anythink.expressad.d.a.b.P;
        sb.setLength(0);
        return j7 > 0 ? formatter.format("%d:%02d:%02d", Long.valueOf(j7), Long.valueOf(j6), Long.valueOf(j5)).toString() : formatter.format("%02d:%02d", Long.valueOf(j6), Long.valueOf(j5)).toString();
    }

    public static String a(byte[] bArr) {
        return new String(bArr, Charset.forName("UTF-8"));
    }

    public static String a(byte[] bArr, int i2, int i3) {
        return new String(bArr, i2, i3, Charset.forName("UTF-8"));
    }

    public static String a(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= objArr.length) {
                return sb.toString();
            }
            sb.append(objArr[i3].getClass().getSimpleName());
            if (i3 < objArr.length - 1) {
                sb.append(", ");
            }
            i2 = i3 + 1;
        }
    }

    public static ExecutorService a(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.anythink.expressad.exoplayer.k.af.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, String.this);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static void a(Parcel parcel, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private static void a(Display display, Point point) {
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
    }

    public static void a(com.anythink.expressad.exoplayer.j.h hVar) {
        if (hVar != null) {
            try {
                hVar.b();
            } catch (IOException e2) {
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
            }
        }
    }

    private static void a(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                a(listFiles[i3]);
                i2 = i3 + 1;
            }
        }
        file.delete();
    }

    public static void a(Throwable th) {
        throw th;
    }

    public static <T> void a(List<T> list, int i2, int i3) {
        list.subList(i2, i3).clear();
    }

    public static void a(long[] jArr, long j2) {
        int i2 = (j2 > 1000000L ? 1 : (j2 == 1000000L ? 0 : -1));
        if (i2 >= 0 && j2 % 1000000 == 0) {
            long j3 = j2 / 1000000;
            for (int i3 = 0; i3 < jArr.length; i3++) {
                jArr[i3] = jArr[i3] / j3;
            }
        } else if (i2 >= 0 || 1000000 % j2 != 0) {
            double d2 = 1000000.0d / j2;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= jArr.length) {
                    return;
                }
                jArr[i5] = (long) (jArr[i5] * d2);
                i4 = i5 + 1;
            }
        } else {
            long j4 = 1000000 / j2;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= jArr.length) {
                    return;
                }
                jArr[i7] = jArr[i7] * j4;
                i6 = i7 + 1;
            }
        }
    }

    private static boolean a() {
        return false;
    }

    private static boolean a(char c2) {
        return c2 == '\"' || c2 == '%' || c2 == '*' || c2 == '/' || c2 == ':' || c2 == '<' || c2 == '\\' || c2 == '|' || c2 == '>' || c2 == '?';
    }

    public static boolean a(int i2) {
        return i2 == 10 || i2 == 13;
    }

    public static boolean a(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || ContentResolver.SCHEME_FILE.equals(scheme);
    }

    public static boolean a(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static boolean a(Object[] objArr, Object obj) {
        int length = objArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return false;
            }
            if (a(objArr[i3], obj)) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    private static byte[] a(InputStream inputStream) {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static int[] a(List<Integer> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        int[] iArr = new int[size];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return iArr;
            }
            iArr[i3] = list.get(i3).intValue();
            i2 = i3 + 1;
        }
    }

    private static long[] a(List<Long> list, long j2, long j3) {
        int size = list.size();
        long[] jArr = new long[size];
        int i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
        if (i2 >= 0 && j3 % j2 == 0) {
            long j4 = j3 / j2;
            for (int i3 = 0; i3 < size; i3++) {
                jArr[i3] = list.get(i3).longValue() / j4;
            }
        } else if (i2 < 0 && j2 % j3 == 0) {
            long j5 = j2 / j3;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= size) {
                    break;
                }
                jArr[i5] = list.get(i5).longValue() * j5;
                i4 = i5 + 1;
            }
        } else {
            double d2 = j2 / j3;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= size) {
                    break;
                }
                jArr[i7] = (long) (list.get(i7).longValue() * d2);
                i6 = i7 + 1;
            }
        }
        return jArr;
    }

    public static <T> T[] a(T[] tArr, int i2) {
        a.a(i2 <= tArr.length);
        return (T[]) Arrays.copyOf(tArr, i2);
    }

    public static String[] a(String str, String str2) {
        return str.split(str2, -1);
    }

    public static int b(int i2, int i3) {
        if (i2 != Integer.MIN_VALUE) {
            if (i2 != 1073741824) {
                if (i2 == 2) {
                    return i3 * 2;
                }
                if (i2 == 3) {
                    return i3;
                }
                if (i2 != 4) {
                    throw new IllegalArgumentException();
                }
            }
            return i3 * 4;
        }
        return i3 * 3;
    }

    public static int b(long j2, long j3) {
        int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 == 0 ? 0 : 1;
    }

    private static int b(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return 3;
        }
        return l(path);
    }

    private static <T> int b(List<? extends Comparable<? super T>> list, T t, boolean z, boolean z2) {
        int i2;
        int i3;
        int binarySearch = Collections.binarySearch(list, t);
        if (binarySearch < 0) {
            i3 = binarySearch;
        } else {
            int size = list.size();
            do {
                i2 = binarySearch + 1;
                if (i2 >= size) {
                    break;
                }
                binarySearch = i2;
            } while (list.get(i2).compareTo(t) == 0);
            i3 = z ? i2 - 1 : i2;
        }
        return z2 ? Math.min(list.size() - 1, i3) : i3;
    }

    public static long b(long j2, float f2) {
        return f2 == 1.0f ? j2 : Math.round(j2 / f2);
    }

    private static File b(Context context, String str) {
        File createTempFile = File.createTempFile(str, null, context.getCacheDir());
        createTempFile.delete();
        createTempFile.mkdir();
        return createTempFile;
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new Locale(str).getISO3Language();
        } catch (MissingResourceException e2) {
            return d(str);
        }
    }

    private static void b(Display display, Point point) {
        display.getRealSize(point);
    }

    private static <T extends Throwable> void b(Throwable th) {
        throw th;
    }

    public static boolean b(int i2) {
        return i2 == 3 || i2 == 2 || i2 == Integer.MIN_VALUE || i2 == 1073741824 || i2 == 4;
    }

    private static String[] b(String str, String str2) {
        return str.split(str2, 2);
    }

    private static long c(long j2, long j3) {
        return ((j2 + j3) - 1) / j3;
    }

    private static File c(Context context, String str) {
        return File.createTempFile(str, null, context.getCacheDir());
    }

    private static void c(Display display, Point point) {
        display.getSize(point);
    }

    public static boolean c(int i2) {
        return i2 == Integer.MIN_VALUE || i2 == 1073741824;
    }

    public static byte[] c(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }

    public static int d(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    int i3 = 4;
                    if (i2 != 4) {
                        i3 = 5;
                        if (i2 != 5) {
                            return i2 != 8 ? 1 : 3;
                        }
                    }
                    return i3;
                }
                return 6;
            }
            return 13;
        }
        return 2;
    }

    private static long d(long j2, long j3) {
        long j4 = j2 + j3;
        if (((j2 ^ j4) & (j3 ^ j4)) < 0) {
            return Long.MAX_VALUE;
        }
        return j4;
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(Locale.US);
    }

    private static void d(Display display, Point point) {
        point.x = display.getWidth();
        point.y = display.getHeight();
    }

    public static int e(int i2) {
        if (i2 != 0) {
            return (i2 == 1 || i2 == 2 || i2 == 4 || i2 == 5 || i2 == 8) ? 4 : 2;
        }
        return 1;
    }

    private static long e(long j2, long j3) {
        long j4 = j2 - j3;
        if (((j2 ^ j4) & (j3 ^ j2)) < 0) {
            return Long.MIN_VALUE;
        }
        return j4;
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(Locale.US);
    }

    public static int f(int i2) {
        if (i2 != 13) {
            switch (i2) {
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                default:
                    return 3;
            }
        }
        return 1;
    }

    public static int f(String str) {
        int length = str.length();
        a.a(length <= 4);
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 = (i2 << 8) | str.charAt(i3);
        }
        return i2;
    }

    public static int g(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3 || i2 == 4) {
                        return 131072;
                    }
                    throw new IllegalStateException();
                }
                return com.anythink.expressad.exoplayer.b.aY;
            }
            return com.anythink.expressad.exoplayer.b.aZ;
        }
        return 16777216;
    }

    public static byte[] g(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return bArr;
            }
            int i4 = i3 * 2;
            bArr[i3] = (byte) ((Character.digit(str.charAt(i4), 16) << 4) + Character.digit(str.charAt(i4 + 1), 16));
            i2 = i3 + 1;
        }
    }

    private static int h(int i2) {
        if (i2 != 8) {
            if (i2 != 16) {
                if (i2 != 24) {
                    return i2 != 32 ? 0 : 1073741824;
                }
                return Integer.MIN_VALUE;
            }
            return 2;
        }
        return 3;
    }

    public static String h(String str) {
        int i2;
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i2 = i4;
            if (i3 >= length) {
                break;
            }
            int i5 = i2;
            if (str.charAt(i3) == '%') {
                i5 = i2 + 1;
            }
            i3++;
            i4 = i5;
        }
        if (i2 == 0) {
            return str;
        }
        int i6 = length - (i2 * 2);
        StringBuilder sb = new StringBuilder(i6);
        Matcher matcher = i.matcher(str);
        int i7 = 0;
        while (i2 > 0 && matcher.find()) {
            sb.append((CharSequence) str, i7, matcher.start());
            sb.append((char) Integer.parseInt(matcher.group(1), 16));
            i7 = matcher.end();
            i2--;
        }
        if (i7 < length) {
            sb.append((CharSequence) str, i7, length);
        }
        if (sb.length() != i6) {
            return null;
        }
        return sb.toString();
    }

    private static long i(String str) {
        Matcher matcher = h.matcher(str);
        if (matcher.matches()) {
            boolean isEmpty = TextUtils.isEmpty(matcher.group(1));
            String group = matcher.group(3);
            double d2 = 0.0d;
            double parseDouble = group != null ? Double.parseDouble(group) * 3.1556908E7d : 0.0d;
            String group2 = matcher.group(5);
            double parseDouble2 = group2 != null ? Double.parseDouble(group2) * 2629739.0d : 0.0d;
            String group3 = matcher.group(7);
            double parseDouble3 = group3 != null ? Double.parseDouble(group3) * 86400.0d : 0.0d;
            String group4 = matcher.group(10);
            double parseDouble4 = group4 != null ? Double.parseDouble(group4) * 3600.0d : 0.0d;
            String group5 = matcher.group(12);
            double parseDouble5 = group5 != null ? Double.parseDouble(group5) * 60.0d : 0.0d;
            String group6 = matcher.group(14);
            if (group6 != null) {
                d2 = Double.parseDouble(group6);
            }
            long j2 = (long) ((parseDouble + parseDouble2 + parseDouble3 + parseDouble4 + parseDouble5 + d2) * 1000.0d);
            long j3 = j2;
            if (true ^ isEmpty) {
                j3 = -j2;
            }
            return j3;
        }
        return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
    }

    private static long j(String str) {
        Matcher matcher = g.matcher(str);
        if (matcher.matches()) {
            int i2 = 0;
            if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
                int parseInt = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
                i2 = parseInt;
                if ("-".equals(matcher.group(11))) {
                    i2 = parseInt * (-1);
                }
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
            gregorianCalendar.clear();
            gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
            if (!TextUtils.isEmpty(matcher.group(8))) {
                gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
            }
            long timeInMillis = gregorianCalendar.getTimeInMillis();
            long j2 = timeInMillis;
            if (i2 != 0) {
                j2 = timeInMillis - (i2 * 60000);
            }
            return j2;
        }
        throw new com.anythink.expressad.exoplayer.t("Invalid date/time format: ".concat(String.valueOf(str)));
    }

    private static UUID k(String str) {
        boolean z;
        String d2 = d(str);
        int hashCode = d2.hashCode();
        if (hashCode == -1860423953) {
            if (d2.equals("playready")) {
                z = true;
            }
            z = true;
        } else if (hashCode != -1400551171) {
            if (hashCode == 790309106 && d2.equals("clearkey")) {
                z = true;
            }
            z = true;
        } else {
            if (d2.equals("widevine")) {
                z = false;
            }
            z = true;
        }
        if (z) {
            if (!z) {
                if (!z) {
                    try {
                        return UUID.fromString(str);
                    } catch (RuntimeException e2) {
                        return null;
                    }
                }
                return com.anythink.expressad.exoplayer.b.bj;
            }
            return com.anythink.expressad.exoplayer.b.bl;
        }
        return com.anythink.expressad.exoplayer.b.bk;
    }

    private static int l(String str) {
        String d2 = d(str);
        if (d2.endsWith(".mpd")) {
            return 0;
        }
        if (d2.endsWith(".m3u8")) {
            return 2;
        }
        return d2.matches(".*\\.ism(l)?(/manifest(\\(.+\\))?)?") ? 1 : 3;
    }

    private static String m(String str) {
        int i2;
        int i3;
        int length = str.length();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i2 = i5;
            if (i4 >= length) {
                break;
            }
            int i6 = i2;
            if (a(str.charAt(i4))) {
                i6 = i2 + 1;
            }
            i4++;
            i5 = i6;
        }
        if (i2 == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder((i2 * 2) + length);
        int i7 = i2;
        int i8 = 0;
        while (true) {
            i3 = i8;
            if (i7 <= 0) {
                break;
            }
            char charAt = str.charAt(i3);
            if (a(charAt)) {
                sb.append('%');
                sb.append(Integer.toHexString(charAt));
                i7--;
            } else {
                sb.append(charAt);
            }
            i8 = i3 + 1;
        }
        if (i3 < length) {
            sb.append((CharSequence) str, i3, length);
        }
        return sb.toString();
    }
}
