package com.tencent.mapsdk.internal;

import com.blued.das.live.LiveProtos;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/q.class */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    private static final int f37708a = 37;
    private static final int b = 17;

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f37709c;
    private static final byte[] d;

    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 256) {
                f37709c = bArr2;
                d = bArr3;
                return;
            }
            bArr2[i2] = bArr[i2 >>> 4];
            bArr3[i2] = bArr[i2 & 15];
            i = i2 + 1;
        }
    }

    public static int a(byte b2) {
        return b2 + LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_TRY_CLICK_VALUE;
    }

    public static int a(byte b2, byte b3) {
        if (b2 < b3) {
            return -1;
        }
        return b2 > b3 ? 1 : 0;
    }

    public static int a(char c2) {
        return c2 + LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_TRY_CLICK_VALUE;
    }

    public static int a(char c2, char c3) {
        if (c2 < c3) {
            return -1;
        }
        return c2 > c3 ? 1 : 0;
    }

    public static int a(double d2) {
        return a(Double.doubleToLongBits(d2));
    }

    public static int a(double d2, double d3) {
        if (d2 < d3) {
            return -1;
        }
        return d2 > d3 ? 1 : 0;
    }

    public static int a(float f) {
        return Float.floatToIntBits(f) + LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_TRY_CLICK_VALUE;
    }

    public static int a(float f, float f2) {
        if (f < f2) {
            return -1;
        }
        return f > f2 ? 1 : 0;
    }

    public static int a(int i) {
        return i + LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_TRY_CLICK_VALUE;
    }

    public static int a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int a(long j) {
        return ((int) (j ^ (j >> 32))) + LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_TRY_CLICK_VALUE;
    }

    public static int a(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    public static <T extends Comparable<T>> int a(T t, T t2) {
        return t.compareTo(t2);
    }

    public static int a(Object obj) {
        return obj == null ? LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_TRY_CLICK_VALUE : obj.getClass().isArray() ? obj instanceof long[] ? a((long[]) obj) : obj instanceof int[] ? a((int[]) obj) : obj instanceof short[] ? a((short[]) obj) : obj instanceof char[] ? a((char[]) obj) : obj instanceof byte[] ? b((byte[]) obj) : obj instanceof double[] ? a((double[]) obj) : obj instanceof float[] ? a((float[]) obj) : obj instanceof boolean[] ? a((boolean[]) obj) : obj instanceof p[] ? a((p[]) obj) : a((Object[]) obj) : obj instanceof p ? obj.hashCode() : obj.hashCode() + LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_TRY_CLICK_VALUE;
    }

    public static <T extends Comparable<T>> int a(List<T> list, List<T> list2) {
        Iterator<T> it = list.iterator();
        Iterator<T> it2 = list2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compareTo = it.next().compareTo(it2.next());
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return a(it.hasNext(), it2.hasNext());
    }

    public static int a(short s) {
        return s + LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_TRY_CLICK_VALUE;
    }

    public static int a(short s, short s2) {
        if (s < s2) {
            return -1;
        }
        return s > s2 ? 1 : 0;
    }

    public static int a(boolean z) {
        return (!z ? 1 : 0) + LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_TRY_CLICK_VALUE;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static int a(boolean z, boolean z2) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static int a(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= bArr.length || i3 >= bArr2.length) {
                break;
            }
            int a2 = a(bArr[i], bArr2[i3]);
            if (a2 != 0) {
                return a2;
            }
            i++;
            i2 = i3 + 1;
        }
        return a(bArr.length, bArr2.length);
    }

    public static int a(char[] cArr) {
        if (cArr == null) {
            return LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_TRY_CLICK_VALUE;
        }
        int i = 17;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= cArr.length) {
                return i;
            }
            i = (i * 37) + cArr[i3];
            i2 = i3 + 1;
        }
    }

    public static int a(char[] cArr, char[] cArr2) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= cArr.length || i3 >= cArr2.length) {
                break;
            }
            int a2 = a(cArr[i], cArr2[i3]);
            if (a2 != 0) {
                return a2;
            }
            i++;
            i2 = i3 + 1;
        }
        return a(cArr.length, cArr2.length);
    }

    public static int a(double[] dArr) {
        if (dArr == null) {
            return LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_TRY_CLICK_VALUE;
        }
        int i = 17;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= dArr.length) {
                return i;
            }
            i = (i * 37) + ((int) (Double.doubleToLongBits(dArr[i3]) ^ (Double.doubleToLongBits(dArr[i3]) >> 32)));
            i2 = i3 + 1;
        }
    }

    public static int a(double[] dArr, double[] dArr2) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= dArr.length || i3 >= dArr2.length) {
                break;
            }
            int a2 = a(dArr[i], dArr2[i3]);
            if (a2 != 0) {
                return a2;
            }
            i++;
            i2 = i3 + 1;
        }
        return a(dArr.length, dArr2.length);
    }

    public static int a(float[] fArr) {
        if (fArr == null) {
            return LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_TRY_CLICK_VALUE;
        }
        int i = 17;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= fArr.length) {
                return i;
            }
            i = (i * 37) + Float.floatToIntBits(fArr[i3]);
            i2 = i3 + 1;
        }
    }

    public static int a(float[] fArr, float[] fArr2) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= fArr.length || i3 >= fArr2.length) {
                break;
            }
            int a2 = a(fArr[i], fArr2[i3]);
            if (a2 != 0) {
                return a2;
            }
            i++;
            i2 = i3 + 1;
        }
        return a(fArr.length, fArr2.length);
    }

    public static int a(int[] iArr) {
        if (iArr == null) {
            return LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_TRY_CLICK_VALUE;
        }
        int i = 17;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= iArr.length) {
                return i;
            }
            i = (i * 37) + iArr[i3];
            i2 = i3 + 1;
        }
    }

    public static int a(int[] iArr, int[] iArr2) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= iArr.length || i3 >= iArr2.length) {
                break;
            }
            int a2 = a(iArr[i], iArr2[i3]);
            if (a2 != 0) {
                return a2;
            }
            i++;
            i2 = i3 + 1;
        }
        return a(iArr.length, iArr2.length);
    }

    public static int a(long[] jArr) {
        if (jArr == null) {
            return LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_TRY_CLICK_VALUE;
        }
        int i = 17;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= jArr.length) {
                return i;
            }
            i = (i * 37) + ((int) (jArr[i3] ^ (jArr[i3] >> 32)));
            i2 = i3 + 1;
        }
    }

    public static int a(long[] jArr, long[] jArr2) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= jArr.length || i3 >= jArr2.length) {
                break;
            }
            int a2 = a(jArr[i], jArr2[i3]);
            if (a2 != 0) {
                return a2;
            }
            i++;
            i2 = i3 + 1;
        }
        return a(jArr.length, jArr2.length);
    }

    public static int a(p[] pVarArr) {
        if (pVarArr == null) {
            return LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_TRY_CLICK_VALUE;
        }
        int i = 17;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= pVarArr.length) {
                return i;
            }
            i = (i * 37) + pVarArr[i3].hashCode();
            i2 = i3 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
        return a(r4.length, r5.length);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T extends java.lang.Comparable<T>> int a(T[] r4, T[] r5) {
        /*
            r0 = 0
            r7 = r0
            r0 = 0
            r6 = r0
        L4:
            r0 = r7
            r1 = r4
            int r1 = r1.length
            if (r0 >= r1) goto L30
            r0 = r6
            r1 = r5
            int r1 = r1.length
            if (r0 >= r1) goto L30
            r0 = r4
            r1 = r7
            r0 = r0[r1]
            r1 = r5
            r2 = r6
            r1 = r1[r2]
            int r0 = r0.compareTo(r1)
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L25
            r0 = r8
            return r0
        L25:
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L4
        L30:
            r0 = r4
            int r0 = r0.length
            r1 = r5
            int r1 = r1.length
            int r0 = a(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.q.a(java.lang.Comparable[], java.lang.Comparable[]):int");
    }

    public static int a(short[] sArr) {
        if (sArr == null) {
            return LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_TRY_CLICK_VALUE;
        }
        int i = 17;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= sArr.length) {
                return i;
            }
            i = (i * 37) + sArr[i3];
            i2 = i3 + 1;
        }
    }

    public static int a(short[] sArr, short[] sArr2) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= sArr.length || i3 >= sArr2.length) {
                break;
            }
            int a2 = a(sArr[i], sArr2[i3]);
            if (a2 != 0) {
                return a2;
            }
            i++;
            i2 = i3 + 1;
        }
        return a(sArr.length, sArr2.length);
    }

    public static int a(boolean[] zArr) {
        if (zArr == null) {
            return LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_TRY_CLICK_VALUE;
        }
        int i = 17;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= zArr.length) {
                return i;
            }
            i = (i * 37) + (!zArr[i3] ? 1 : 0);
            i2 = i3 + 1;
        }
    }

    public static int a(boolean[] zArr, boolean[] zArr2) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= zArr.length || i3 >= zArr2.length) {
                break;
            }
            int a2 = a(zArr[i], zArr2[i3]);
            if (a2 != 0) {
                return a2;
            }
            i++;
            i2 = i3 + 1;
        }
        return a(zArr.length, zArr2.length);
    }

    public static String a(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining == 0) {
            return "empty";
        }
        StringBuffer stringBuffer = new StringBuffer((byteBuffer.remaining() * 3) - 1);
        int position = byteBuffer.position();
        int i = byteBuffer.get() & 255;
        stringBuffer.append((char) f37709c[i]);
        stringBuffer.append((char) d[i]);
        while (true) {
            remaining--;
            if (remaining <= 0) {
                byteBuffer.position(position);
                return stringBuffer.toString();
            }
            stringBuffer.append(' ');
            int i2 = byteBuffer.get() & 255;
            stringBuffer.append((char) f37709c[i2]);
            stringBuffer.append((char) d[i2]);
        }
    }

    public static String a(byte[] bArr) {
        return a(ByteBuffer.wrap(bArr));
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj == obj2 : obj.equals(obj2);
    }

    public static int b(byte[] bArr) {
        if (bArr == null) {
            return LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_TRY_CLICK_VALUE;
        }
        int i = 17;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= bArr.length) {
                return i;
            }
            i = (i * 37) + bArr[i3];
            i2 = i3 + 1;
        }
    }

    public static boolean b(byte b2, byte b3) {
        return b2 == b3;
    }

    public static boolean b(char c2, char c3) {
        return c2 == c3;
    }

    public static boolean b(double d2, double d3) {
        return d2 == d3;
    }

    public static boolean b(float f, float f2) {
        return f == f2;
    }

    public static boolean b(int i, int i2) {
        return i == i2;
    }

    public static boolean b(long j, long j2) {
        return j == j2;
    }

    public static boolean b(short s, short s2) {
        return s == s2;
    }

    public static boolean b(boolean z, boolean z2) {
        return z == z2;
    }

    public static byte[] b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        System.arraycopy((Object) byteBuffer.array(), 0, (Object) bArr, 0, position);
        return bArr;
    }
}
