package com.opos.exoplayer.core.i;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Pattern;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/u.class */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final int f25510a;
    public static final String b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f25511c;
    public static final String d;
    public static final String e;
    private static final Pattern f;
    private static final Pattern g;
    private static final Pattern h;
    private static final int[] i;

    static {
        f25510a = (Build.VERSION.SDK_INT == 25 && Build.VERSION.CODENAME.charAt(0) == 'O') ? 26 : Build.VERSION.SDK_INT;
        b = Build.DEVICE;
        f25511c = Build.MANUFACTURER;
        d = Build.MODEL;
        e = b + ", " + d + ", " + f25511c + ", " + f25510a;
        f = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        g = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        h = Pattern.compile("%([A-Fa-f0-9]{2})");
        i = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
    }

    public static float a(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f2, f4));
    }

    public static int a(int i2, int i3) {
        return ((i2 + i3) - 1) / i3;
    }

    public static int a(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i2, i4));
    }

    public static int a(long j, long j2) {
        int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 == 0 ? 0 : 1;
    }

    public static int a(byte[] bArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            i4 = i[((i4 >>> 24) ^ (bArr[i2] & 255)) & 255] ^ (i4 << 8);
            i2++;
        }
        return i4;
    }

    public static int a(long[] jArr, long j, boolean z, boolean z2) {
        int i2;
        int i3;
        int binarySearch = Arrays.binarySearch(jArr, j);
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
            } while (jArr[i2] == j);
            i3 = z ? i2 + 1 : i2;
        }
        int i5 = i3;
        if (z2) {
            i5 = Math.max(0, i3);
        }
        return i5;
    }

    public static long a(long j, float f2) {
        return f2 == 1.0f ? j : Math.round(j * f2);
    }

    public static long a(long j, long j2, long j3) {
        return Math.max(j2, Math.min(j, j3));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006e, code lost:
        if (java.lang.Math.abs(r10 - r7) > java.lang.Math.abs(r12 - r7)) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long a(long r7, com.opos.exoplayer.core.w r9, long r10, long r12) {
        /*
            com.opos.exoplayer.core.w r0 = com.opos.exoplayer.core.w.f25588a
            r1 = r9
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lc
            r0 = r7
            return r0
        Lc:
            r0 = r7
            r1 = r9
            long r1 = r1.f
            r2 = -9223372036854775808
            long r0 = c(r0, r1, r2)
            r16 = r0
            r0 = r7
            r1 = r9
            long r1 = r1.g
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r0 = b(r0, r1, r2)
            r18 = r0
            r0 = 1
            r15 = r0
            r0 = r16
            r1 = r10
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L3d
            r0 = r10
            r1 = r18
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L3d
            r0 = 1
            r14 = r0
            goto L40
        L3d:
            r0 = 0
            r14 = r0
        L40:
            r0 = r16
            r1 = r12
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L53
            r0 = r12
            r1 = r18
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L53
            goto L56
        L53:
            r0 = 0
            r15 = r0
        L56:
            r0 = r14
            if (r0 == 0) goto L74
            r0 = r15
            if (r0 == 0) goto L74
            r0 = r10
            r1 = r7
            long r0 = r0 - r1
            long r0 = java.lang.Math.abs(r0)
            r1 = r12
            r2 = r7
            long r1 = r1 - r2
            long r1 = java.lang.Math.abs(r1)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L84
            goto L7e
        L74:
            r0 = r14
            if (r0 != 0) goto L84
            r0 = r15
            if (r0 == 0) goto L81
        L7e:
            r0 = r12
            return r0
        L81:
            r0 = r16
            return r0
        L84:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.i.u.a(long, com.opos.exoplayer.core.w, long, long):long");
    }

    public static String a(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            str2 = "?";
        }
        return str + BridgeUtil.SPLIT_MARK + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") ExoPlayerLib/2.7.3";
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
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.opos.exoplayer.core.i.u.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, String.this);
            }
        });
    }

    public static void a(com.opos.exoplayer.core.h.g gVar) {
        if (gVar != null) {
            try {
                gVar.b();
            } catch (IOException e2) {
            }
        }
    }

    public static void a(long[] jArr, long j, long j2) {
        int i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
        if (i2 >= 0 && j2 % j == 0) {
            long j3 = j2 / j;
            for (int i3 = 0; i3 < jArr.length; i3++) {
                jArr[i3] = jArr[i3] / j3;
            }
        } else if (i2 >= 0 || j % j2 != 0) {
            double d2 = j / j2;
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
            long j4 = j / j2;
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

    public static boolean a(int i2) {
        return i2 == 10 || i2 == 13;
    }

    public static boolean a(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || scheme.equals(ContentResolver.SCHEME_FILE);
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
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

    public static int b(int i2) {
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

    public static int b(int i2, int i3) {
        int i4;
        if (i2 != Integer.MIN_VALUE) {
            if (i2 != 1073741824) {
                if (i2 == 2) {
                    return i3 * 2;
                }
                i4 = i3;
                if (i2 != 3) {
                    if (i2 != 4) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            return i3 * 4;
        }
        i4 = i3 * 3;
        return i4;
    }

    public static int b(long[] jArr, long j, boolean z, boolean z2) {
        int i2;
        int i3;
        int binarySearch = Arrays.binarySearch(jArr, j);
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
            } while (jArr[i2] == j);
            i3 = z ? i2 - 1 : i2;
        }
        int i5 = i3;
        if (z2) {
            i5 = Math.min(jArr.length - 1, i3);
        }
        return i5;
    }

    public static long b(long j, float f2) {
        return f2 == 1.0f ? j : Math.round(j / f2);
    }

    public static long b(long j, long j2, long j3) {
        long j4 = j + j2;
        return ((j ^ j4) & (j2 ^ j4)) < 0 ? j3 : j4;
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

    public static long c(long j, long j2, long j3) {
        long j4 = j - j2;
        return ((j ^ j4) & (j2 ^ j)) < 0 ? j3 : j4;
    }

    public static boolean c(int i2) {
        return i2 == Integer.MIN_VALUE || i2 == 1073741824;
    }

    public static byte[] c(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }

    public static int d(int i2) {
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

    public static long d(long j, long j2, long j3) {
        int i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
        return (i2 < 0 || j3 % j2 != 0) ? (i2 >= 0 || j2 % j3 != 0) ? (long) ((j2 / j3) * j) : j * (j2 / j3) : j / (j3 / j2);
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(Locale.US);
    }

    public static int e(int i2) {
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

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(Locale.US);
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
            bArr[i3] = (byte) (Character.digit(str.charAt(i4 + 1), 16) + (Character.digit(str.charAt(i4), 16) << 4));
            i2 = i3 + 1;
        }
    }
}
