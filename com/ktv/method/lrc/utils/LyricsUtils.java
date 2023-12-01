package com.ktv.method.lrc.utils;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import com.ktv.method.lrc.model.LyricsLineInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/* loaded from: source-7994992-dex2jar.jar:com/ktv/method/lrc/utils/LyricsUtils.class */
public class LyricsUtils {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/ktv/method/lrc/utils/LyricsUtils$ForeachListener.class */
    public interface ForeachListener {
        void a(LyricsLineInfo lyricsLineInfo);
    }

    public static float a(int i, Paint paint, LyricsLineInfo lyricsLineInfo, int i2, float f) {
        float a2 = a(paint, lyricsLineInfo.f());
        float f2 = a2;
        if (i != 0) {
            if (i2 == -2) {
                return a2;
            }
            if (i2 != -1) {
                String[] b = lyricsLineInfo.b();
                int[] c2 = lyricsLineInfo.c();
                StringBuilder sb = new StringBuilder();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= i2) {
                        return paint.measureText(sb.toString()) + ((paint.measureText(b[i2].trim()) / c2[i2]) * f);
                    }
                    sb.append(b[i4]);
                    i3 = i4 + 1;
                }
            } else {
                f2 = 0.0f;
            }
        }
        return f2;
    }

    public static float a(Paint paint, String str) {
        return paint.measureText(str);
    }

    public static int a(int i, TreeMap<Integer, LyricsLineInfo> treeMap, long j, long j2) {
        int size;
        int i2;
        int i3;
        if (treeMap == null) {
            return 0;
        }
        long j3 = j + j2;
        if (i == 0) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < treeMap.size()) {
                    if (j3 < treeMap.get(Integer.valueOf(i5)).d()) {
                        return 0;
                    }
                    if (j3 >= treeMap.get(Integer.valueOf(i5)).d() && (i3 = i5 + 1) < treeMap.size() && j3 <= treeMap.get(Integer.valueOf(i3)).d()) {
                        return i5;
                    }
                    i4 = i5 + 1;
                } else if (treeMap.size() <= 0) {
                    return 0;
                } else {
                    size = treeMap.size();
                }
            }
        } else if (i != 1) {
            return 0;
        } else {
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 < treeMap.size()) {
                    if (j3 >= treeMap.get(Integer.valueOf(i7)).d() && j3 <= treeMap.get(Integer.valueOf(i7)).e()) {
                        return i7;
                    }
                    if (j3 > treeMap.get(Integer.valueOf(i7)).e() && (i2 = i7 + 1) < treeMap.size() && j3 <= treeMap.get(Integer.valueOf(i2)).d()) {
                        return i7;
                    }
                    i6 = i7 + 1;
                } else if (j3 < treeMap.get(Integer.valueOf(treeMap.size() - 1)).e()) {
                    return 0;
                } else {
                    size = treeMap.size();
                }
            }
        }
        return size - 1;
    }

    public static int a(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (int) (((-fontMetrics.leading) - fontMetrics.ascent) + fontMetrics.descent);
    }

    private static int a(List<LyricsLineInfo> list, long j, long j2) {
        int i;
        long j3 = j + j2;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                if (list.size() > 0) {
                    return list.size() - 1;
                }
                return 0;
            } else if (j3 < list.get(i3).d()) {
                return 0;
            } else {
                if (j3 >= list.get(i3).d() && (i = i3 + 1) < list.size() && j3 <= list.get(i).d()) {
                    return i3;
                }
                i2 = i3 + 1;
            }
        }
    }

    public static int a(TreeMap<Integer, LyricsLineInfo> treeMap, int i, long j, long j2) {
        return b(treeMap.get(Integer.valueOf(i)).a(), j, j2);
    }

    private static LyricsLineInfo a(LyricsLineInfo lyricsLineInfo, int i, int i2) {
        if (i2 < 0) {
            return null;
        }
        LyricsLineInfo lyricsLineInfo2 = new LyricsLineInfo();
        int d = lyricsLineInfo.d();
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String[] b = lyricsLineInfo.b();
        int[] c2 = lyricsLineInfo.c();
        int i3 = 0;
        for (int i4 = 0; i4 <= i2; i4++) {
            if (i4 < i) {
                d += c2[i4];
            } else {
                sb.append(b[i4]);
                arrayList2.add(Integer.valueOf(c2[i4]));
                arrayList.add(b[i4]);
                i3 += c2[i4];
            }
        }
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        int[] a2 = a(arrayList2);
        lyricsLineInfo2.b(i3 + d);
        lyricsLineInfo2.a(d);
        lyricsLineInfo2.a(sb.toString());
        lyricsLineInfo2.a(strArr);
        lyricsLineInfo2.a(a2);
        return lyricsLineInfo2;
    }

    public static TreeMap<Integer, LyricsLineInfo> a(TreeMap<Integer, LyricsLineInfo> treeMap, float f, Paint paint) {
        if (treeMap == null) {
            return null;
        }
        TreeMap<Integer, LyricsLineInfo> treeMap2 = new TreeMap<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= treeMap.size()) {
                return treeMap2;
            }
            LyricsLineInfo lyricsLineInfo = new LyricsLineInfo();
            lyricsLineInfo.a(lyricsLineInfo, treeMap.get(Integer.valueOf(i2)));
            a(lyricsLineInfo, paint, f);
            treeMap2.put(Integer.valueOf(i2), lyricsLineInfo);
            i = i2 + 1;
        }
    }

    public static void a(Canvas canvas, Paint paint, Paint paint2, int[] iArr, int[] iArr2, String str, float f, float f2, float f3) {
        canvas.save();
        paint.setShader(new LinearGradient(f2, f3 - b(paint), f2, f3, iArr, (float[]) null, Shader.TileMode.CLAMP));
        canvas.drawText(str, f2, f3, paint);
        canvas.clipRect(f2, f3 - a(paint), f2 + f, a(paint) + f3);
        paint2.setShader(new LinearGradient(f2, f3 - b(paint), f2, f3, iArr2, (float[]) null, Shader.TileMode.CLAMP));
        canvas.drawText(str, f2, f3, paint2);
        canvas.restore();
    }

    public static void a(Canvas canvas, Paint paint, String str, float f, float f2) {
        canvas.drawText(str, f - 1.0f, f2, paint);
        canvas.drawText(str, f + 1.0f, f2, paint);
        canvas.drawText(str, f, f2 + 1.0f, paint);
        canvas.drawText(str, f, f2 - 1.0f, paint);
    }

    private static void a(LyricsLineInfo lyricsLineInfo, Paint paint, float f) {
        final ArrayList arrayList = new ArrayList();
        a(lyricsLineInfo, paint, f, new ForeachListener() { // from class: com.ktv.method.lrc.utils.LyricsUtils.1
            @Override // com.ktv.method.lrc.utils.LyricsUtils.ForeachListener
            public void a(LyricsLineInfo lyricsLineInfo2) {
                List.this.add(lyricsLineInfo2);
            }
        });
        lyricsLineInfo.a(arrayList);
    }

    private static void a(LyricsLineInfo lyricsLineInfo, Paint paint, float f, ForeachListener foreachListener) {
        int i;
        String trim = lyricsLineInfo.f().trim();
        String[] b = lyricsLineInfo.b();
        if (((int) paint.measureText(trim)) <= f) {
            if (foreachListener != null) {
                foreachListener.a(lyricsLineInfo);
                return;
            }
            return;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i2 >= b.length) {
                return;
            }
            int measureText = i3 + ((int) paint.measureText(b[i2]));
            int i6 = i2 + 1;
            if ((i6 < b.length ? (int) paint.measureText(b[i6]) : 0) + measureText > f) {
                LyricsLineInfo a2 = a(lyricsLineInfo, i5, i2);
                if (a2 != null && foreachListener != null) {
                    foreachListener.a(a2);
                }
                i3 = 0;
                i = i6 == b.length ? b.length - 1 : i6;
            } else {
                i3 = measureText;
                i = i5;
                if (i2 == b.length - 1) {
                    LyricsLineInfo a3 = a(lyricsLineInfo, i5, b.length - 1);
                    i3 = measureText;
                    i = i5;
                    if (a3 != null) {
                        i3 = measureText;
                        i = i5;
                        if (foreachListener != null) {
                            foreachListener.a(a3);
                            i = i5;
                            i3 = measureText;
                        }
                    }
                }
            }
            i2 = i6;
            i4 = i;
        }
    }

    private static int[] a(List<Integer> list) {
        int[] iArr = new int[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return iArr;
            }
            iArr[i2] = list.get(i2).intValue();
            i = i2 + 1;
        }
    }

    public static int b(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (int) (-(fontMetrics.ascent + fontMetrics.descent));
    }

    private static int b(List<LyricsLineInfo> list, long j, long j2) {
        int i;
        long j3 = j + j2;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                if (j3 >= list.get(list.size() - 1).e()) {
                    return list.size() - 1;
                }
                return 0;
            } else if (j3 < list.get(i3).d()) {
                return 0;
            } else {
                if (j3 >= list.get(i3).d() && j3 <= list.get(i3).e()) {
                    return i3;
                }
                if (j3 > list.get(i3).e() && (i = i3 + 1) < list.size() && j3 <= list.get(i).d()) {
                    return i3;
                }
                i2 = i3 + 1;
            }
        }
    }

    public static int b(TreeMap<Integer, LyricsLineInfo> treeMap, int i, long j, long j2) {
        return a(treeMap.get(Integer.valueOf(i)).a(), j, j2);
    }

    public static void b(Canvas canvas, Paint paint, String str, float f, float f2) {
        canvas.drawText(str, f, f2, paint);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0072, code lost:
        r0 = r0.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007e, code lost:
        if (r11 >= r0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0086, code lost:
        if (r0 > r0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
        return -2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int c(java.util.TreeMap<java.lang.Integer, com.ktv.method.lrc.model.LyricsLineInfo> r5, int r6, long r7, long r9) {
        /*
            r0 = r6
            if (r0 >= 0) goto L6
            r0 = -1
            return r0
        L6:
            r0 = r7
            r1 = r9
            long r0 = r0 + r1
            r7 = r0
            r0 = r5
            r1 = r6
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r0 = r0.get(r1)
            com.ktv.method.lrc.model.LyricsLineInfo r0 = (com.ktv.method.lrc.model.LyricsLineInfo) r0
            java.util.List r0 = r0.a()
            r5 = r0
            r0 = 0
            r6 = r0
        L1c:
            r0 = r6
            r1 = r5
            int r1 = r1.size()
            if (r0 >= r1) goto L93
            r0 = r5
            r1 = r6
            java.lang.Object r0 = r0.get(r1)
            com.ktv.method.lrc.model.LyricsLineInfo r0 = (com.ktv.method.lrc.model.LyricsLineInfo) r0
            r13 = r0
            r0 = r13
            int r0 = r0.d()
            r11 = r0
            r0 = r7
            r1 = r11
            long r1 = (long) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L43
            r0 = -1
            return r0
        L43:
            r0 = 0
            r12 = r0
        L46:
            r0 = r12
            r1 = r13
            java.lang.String[] r1 = r1.b()
            int r1 = r1.length
            if (r0 >= r1) goto L72
            r0 = r11
            r1 = r13
            int[] r1 = r1.c()
            r2 = r12
            r1 = r1[r2]
            int r0 = r0 + r1
            r11 = r0
            r0 = r7
            r1 = r11
            long r1 = (long) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L69
            r0 = r12
            return r0
        L69:
            r0 = r12
            r1 = 1
            int r0 = r0 + r1
            r12 = r0
            goto L46
        L72:
            r0 = r13
            int r0 = r0.e()
            r12 = r0
            r0 = r11
            long r0 = (long) r0
            r1 = r7
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L8c
            r0 = r7
            r1 = r12
            long r1 = (long) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L8c
            goto L93
        L8c:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L1c
        L93:
            r0 = -2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktv.method.lrc.utils.LyricsUtils.c(java.util.TreeMap, int, long, long):int");
    }

    public static int d(TreeMap<Integer, LyricsLineInfo> treeMap, int i, long j, long j2) {
        if (i < 0) {
            return -1;
        }
        long j3 = j + j2;
        LyricsLineInfo lyricsLineInfo = treeMap.get(Integer.valueOf(i));
        int d = lyricsLineInfo.d();
        if (j3 < d) {
            return -1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= lyricsLineInfo.b().length) {
                return -2;
            }
            d += lyricsLineInfo.c()[i3];
            if (j3 <= d) {
                return i3;
            }
            i2 = i3 + 1;
        }
    }

    public static long e(TreeMap<Integer, LyricsLineInfo> treeMap, int i, long j, long j2) {
        if (i < 0) {
            return 0L;
        }
        long j3 = j + j2;
        LyricsLineInfo lyricsLineInfo = treeMap.get(Integer.valueOf(i));
        int d = lyricsLineInfo.d();
        if (j3 < d) {
            return 0L;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= lyricsLineInfo.b().length) {
                return 0L;
            }
            d += lyricsLineInfo.c()[i3];
            long j4 = d;
            if (j3 <= j4) {
                return lyricsLineInfo.c()[i3] - (j4 - j3);
            }
            i2 = i3 + 1;
        }
    }
}
