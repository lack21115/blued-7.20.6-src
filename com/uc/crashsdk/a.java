package com.uc.crashsdk;

import android.content.pm.PackageInfo;
import android.util.SparseArray;
import com.huawei.openalliance.ad.constant.t;
import com.uc.crashsdk.export.LogType;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: source-8829756-dex2jar.jar:com/uc/crashsdk/a.class */
public class a {
    static final /* synthetic */ boolean d = !a.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    public static String f26866a = "";
    public static String b = "";
    private static final Map<String, String> e = new HashMap();
    private static final List<String> f = new ArrayList();
    private static String g = "";
    private static String h = null;
    private static int i = -1;
    private static long j = 0;
    private static final HashMap<String, Object[]> k = new HashMap<>();
    private static final List<String> l = new ArrayList();
    private static int m = 0;
    private static int n = 0;
    private static int o = 0;
    private static int p = 0;
    private static final HashMap<String, Object[]> q = new HashMap<>();
    private static final List<String> r = new ArrayList();
    private static int s = 0;
    private static int t = 0;
    private static int u = 0;
    private static int v = 0;
    private static int w = 0;
    private static int x = 0;
    private static final SparseArray<Object[]> y = new SparseArray<>();
    private static final List<Integer> z = new ArrayList();
    private static final HashMap<String, Object[]> A = new HashMap<>();
    private static final List<String> B = new ArrayList();
    private static int C = 0;
    private static int D = 0;
    private static int E = 0;

    /* renamed from: c  reason: collision with root package name */
    static boolean f26867c = false;
    private static Runnable F = new com.uc.crashsdk.a.e(201);
    private static boolean G = false;
    private static boolean H = false;
    private static boolean I = false;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static int a(int i2, String str) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static int a(String str, int i2, int i3) {
        int i4;
        int i5;
        boolean z2;
        if (str == null || i2 <= 0) {
            return 0;
        }
        if (i2 > 1500) {
            com.uc.crashsdk.a.a.a("crashsdk", "createCachedInfo: capacity is too large!", null);
            return 0;
        }
        synchronized (A) {
            if (A.containsKey(str)) {
                i5 = ((Integer) A.get(str)[1]).intValue();
                i4 = LogType.addType(i5, i3);
            } else {
                i4 = i3;
                i5 = 0;
            }
            int i6 = i4;
            if (LogType.isForJava(i4)) {
                i6 = i4;
                if (!LogType.isForJava(i5)) {
                    if (C >= 8) {
                        i6 = LogType.removeType(i4, 16);
                    } else {
                        C++;
                        i6 = i4;
                    }
                }
            }
            int i7 = i6;
            if (LogType.isForNative(i6)) {
                i7 = i6;
                if (!LogType.isForNative(i5)) {
                    if (D >= 8) {
                        i7 = LogType.removeType(i6, 1);
                    } else {
                        D++;
                        i7 = i6;
                    }
                }
            }
            int i8 = i7;
            if (LogType.isForANR(i7)) {
                i8 = i7;
                if (!LogType.isForANR(i5)) {
                    if (E >= 8) {
                        i8 = LogType.removeType(i7, 1048576);
                    } else {
                        E++;
                        i8 = i7;
                    }
                }
            }
            if ((1048849 & i8) == 0) {
                z2 = false;
            } else {
                if (i5 == 0) {
                    B.add(str);
                }
                z2 = true;
            }
            if (z2) {
                int i9 = i8;
                if (b.d) {
                    i9 = i8;
                    if ((i3 & 1048577) != 0) {
                        int nativeCreateCachedInfo = JNIBridge.nativeCreateCachedInfo(str, i2, i8);
                        int i10 = i8;
                        if (!LogType.isForNative(nativeCreateCachedInfo)) {
                            i10 = LogType.removeType(i8, 1);
                        }
                        i9 = i10;
                        if (!LogType.isForANR(nativeCreateCachedInfo)) {
                            i9 = LogType.removeType(i10, 1048576);
                        }
                    }
                }
                A.put(str, new Object[]{Integer.valueOf(i2), Integer.valueOf(i9), new ArrayList()});
                return i9;
            }
            return i8;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:149:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ab A[Catch: all -> 0x0295, TRY_ENTER, TryCatch #0 {, blocks: (B:8:0x000e, B:10:0x0018, B:14:0x0045, B:18:0x004d, B:22:0x0059, B:24:0x0061, B:40:0x00ab, B:29:0x0072, B:32:0x007d, B:36:0x0097, B:33:0x0088, B:42:0x00b6, B:44:0x00bc, B:46:0x00c4, B:63:0x012b, B:66:0x0142, B:70:0x014e, B:72:0x0156, B:74:0x015e, B:75:0x016a, B:78:0x017c, B:82:0x0188, B:84:0x0190, B:86:0x0198, B:87:0x01a5, B:91:0x01b8, B:95:0x01cc, B:98:0x01d0, B:103:0x01dd, B:105:0x01ea, B:107:0x01f2, B:109:0x01ff, B:113:0x020f, B:116:0x021d, B:118:0x0225, B:121:0x0234, B:124:0x0242, B:126:0x024a, B:129:0x025c, B:131:0x026a, B:132:0x0292, B:51:0x00d5, B:54:0x00df, B:56:0x00fb, B:59:0x0109), top: B:152:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x012b A[Catch: all -> 0x0295, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:8:0x000e, B:10:0x0018, B:14:0x0045, B:18:0x004d, B:22:0x0059, B:24:0x0061, B:40:0x00ab, B:29:0x0072, B:32:0x007d, B:36:0x0097, B:33:0x0088, B:42:0x00b6, B:44:0x00bc, B:46:0x00c4, B:63:0x012b, B:66:0x0142, B:70:0x014e, B:72:0x0156, B:74:0x015e, B:75:0x016a, B:78:0x017c, B:82:0x0188, B:84:0x0190, B:86:0x0198, B:87:0x01a5, B:91:0x01b8, B:95:0x01cc, B:98:0x01d0, B:103:0x01dd, B:105:0x01ea, B:107:0x01f2, B:109:0x01ff, B:113:0x020f, B:116:0x021d, B:118:0x0225, B:121:0x0234, B:124:0x0242, B:126:0x024a, B:129:0x025c, B:131:0x026a, B:132:0x0292, B:51:0x00d5, B:54:0x00df, B:56:0x00fb, B:59:0x0109), top: B:152:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01d0 A[Catch: all -> 0x0295, TRY_ENTER, TryCatch #0 {, blocks: (B:8:0x000e, B:10:0x0018, B:14:0x0045, B:18:0x004d, B:22:0x0059, B:24:0x0061, B:40:0x00ab, B:29:0x0072, B:32:0x007d, B:36:0x0097, B:33:0x0088, B:42:0x00b6, B:44:0x00bc, B:46:0x00c4, B:63:0x012b, B:66:0x0142, B:70:0x014e, B:72:0x0156, B:74:0x015e, B:75:0x016a, B:78:0x017c, B:82:0x0188, B:84:0x0190, B:86:0x0198, B:87:0x01a5, B:91:0x01b8, B:95:0x01cc, B:98:0x01d0, B:103:0x01dd, B:105:0x01ea, B:107:0x01f2, B:109:0x01ff, B:113:0x020f, B:116:0x021d, B:118:0x0225, B:121:0x0234, B:124:0x0242, B:126:0x024a, B:129:0x025c, B:131:0x026a, B:132:0x0292, B:51:0x00d5, B:54:0x00df, B:56:0x00fb, B:59:0x0109), top: B:152:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(java.lang.String r8, int r9, java.util.concurrent.Callable<java.lang.String> r10, long r11, int r13) {
        /*
            Method dump skipped, instructions count: 754
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.lang.String, int, java.util.concurrent.Callable, long, int):int");
    }

    public static int a(String str, String str2, boolean z2, boolean z3, int i2, boolean z4) {
        int i3;
        int i4;
        boolean z5;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str.length() > 256) {
            com.uc.crashsdk.a.a.a("crashsdk", "addDumpFile: description is too long!", null);
            return 0;
        }
        synchronized (k) {
            if (k.containsKey(str)) {
                i4 = ((Integer) k.get(str)[0]).intValue();
                i3 = LogType.addType(i4, i2);
            } else {
                i3 = i2;
                i4 = 0;
            }
            int i5 = i3;
            if (LogType.isForJava(i3)) {
                i5 = i3;
                if (!LogType.isForJava(i4)) {
                    if (m >= 10) {
                        i5 = LogType.removeType(i3, 16);
                    } else {
                        m++;
                        i5 = i3;
                    }
                }
            }
            int i6 = i5;
            if (LogType.isForNative(i5)) {
                i6 = i5;
                if (!LogType.isForNative(i4)) {
                    if (n >= 10) {
                        i6 = LogType.removeType(i5, 1);
                    } else {
                        n++;
                        i6 = i5;
                    }
                }
            }
            int i7 = i6;
            if (LogType.isForUnexp(i6)) {
                i7 = i6;
                if (!LogType.isForUnexp(i4)) {
                    if (o >= 10) {
                        i7 = LogType.removeType(i6, 256);
                    } else {
                        o++;
                        i7 = i6;
                    }
                }
            }
            int i8 = i7;
            if (LogType.isForANR(i7)) {
                i8 = i7;
                if (!LogType.isForANR(i4)) {
                    if (p >= 10) {
                        i8 = LogType.removeType(i7, 1048576);
                    } else {
                        p++;
                        i8 = i7;
                    }
                }
            }
            if ((1048849 & i8) == 0) {
                z5 = false;
            } else {
                if (i4 == 0) {
                    l.add(str);
                }
                z5 = true;
            }
            if (z5) {
                int i9 = i8;
                if (b.d) {
                    i9 = i8;
                    if ((1048833 & i2) != 0) {
                        int nativeAddDumpFile = JNIBridge.nativeAddDumpFile(str, str2, z2, z3, i2, z4);
                        int i10 = i8;
                        if (!LogType.isForNative(nativeAddDumpFile)) {
                            i10 = LogType.removeType(i8, 1);
                        }
                        int i11 = i10;
                        if (!LogType.isForUnexp(nativeAddDumpFile)) {
                            i11 = LogType.removeType(i10, 256);
                        }
                        i9 = i11;
                        if (!LogType.isForANR(nativeAddDumpFile)) {
                            i9 = LogType.removeType(i11, 1048576);
                        }
                    }
                }
                k.put(str, new Object[]{Integer.valueOf(i9), str2, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)});
                return i9;
            }
            return i8;
        }
    }

    public static String a() {
        String str = h;
        return str != null ? str : o() ? h : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        synchronized (k) {
            Object[] objArr = k.get(str);
            if (objArr == null) {
                return null;
            }
            int i2 = 1;
            String str2 = (String) objArr[1];
            boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
            boolean booleanValue2 = ((Boolean) objArr[3]).booleanValue();
            Locale locale = Locale.US;
            int i3 = booleanValue ? 1 : 0;
            if (!booleanValue2) {
                i2 = 0;
            }
            return String.format(locale, "%s%s%d%d", str2, "`", Integer.valueOf(i3), Integer.valueOf(i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, boolean z2) {
        String nativeGetCallbackInfo;
        synchronized (q) {
            Object[] objArr = q.get(str);
            long longValue = ((Long) objArr[2]).longValue();
            nativeGetCallbackInfo = longValue != 0 ? JNIBridge.nativeGetCallbackInfo(str, longValue, ((Integer) objArr[3]).intValue(), z2) : b(str, z2).toString();
        }
        return nativeGetCallbackInfo;
    }

    public static void a(int i2) {
        if (i2 == 201) {
            com.uc.crashsdk.a.a.a("crashsdk", "Begin update info ...");
            long currentTimeMillis = System.currentTimeMillis();
            if (b.d && f26867c) {
                JNIBridge.nativeCmd(11, g.G(), String.valueOf(g.H()), null);
            }
            com.uc.crashsdk.a.a.a("crashsdk", "Update info took " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            a(false);
        } else if (i2 != 202) {
            if (!d) {
                throw new AssertionError();
            }
        } else {
            p();
            String format = String.format(Locale.US, "%s/%s/%s", g.T(), g.U(), g.V());
            g = m();
            if (b.d) {
                JNIBridge.set(128, g);
            }
            boolean z2 = !format.equals(g);
            if (z2) {
                com.uc.crashsdk.a.b.a(b.m(), format);
            }
            if (z2 && g.u()) {
                com.uc.crashsdk.a.a.a("crashsdk", String.format(Locale.US, "Is new version ('%s' -> '%s'), deleting old stats data!", g, format));
                b.v();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OutputStream outputStream, String str) {
        synchronized (e) {
            for (String str2 : f) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(str2);
                sb.append(": ");
                String str3 = e.get(str2);
                if (str3 != null) {
                    sb.append(str3);
                }
                sb.append("\n");
                outputStream.write(sb.toString().getBytes(str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013f A[Catch: all -> 0x0197, TryCatch #7 {, blocks: (B:4:0x0008, B:6:0x0019, B:8:0x0021, B:9:0x002f, B:27:0x00b8, B:58:0x01c3, B:54:0x01a0, B:37:0x0134, B:39:0x013f, B:41:0x014c, B:47:0x0165, B:49:0x0171, B:29:0x00bf, B:33:0x00e8), top: B:68:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x019f A[EDGE_INSN: B:83:0x019f->B:53:0x019f ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.io.OutputStream r8, java.lang.String r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 466
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0096 A[Catch: all -> 0x00e0, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0008, B:6:0x0014, B:8:0x001c, B:9:0x0028, B:37:0x010e, B:39:0x0114, B:41:0x011a, B:43:0x0122, B:45:0x0136, B:47:0x0143, B:10:0x002b, B:12:0x0045, B:18:0x005c, B:21:0x0096, B:25:0x00bd, B:27:0x00c5, B:28:0x00d2, B:22:0x00ad, B:15:0x0050, B:32:0x00e9), top: B:54:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ad A[Catch: all -> 0x00e0, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0008, B:6:0x0014, B:8:0x001c, B:9:0x0028, B:37:0x010e, B:39:0x0114, B:41:0x011a, B:43:0x0122, B:45:0x0136, B:47:0x0143, B:10:0x002b, B:12:0x0045, B:18:0x005c, B:21:0x0096, B:25:0x00bd, B:27:0x00c5, B:28:0x00d2, B:22:0x00ad, B:15:0x0050, B:32:0x00e9), top: B:54:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.io.OutputStream r6, java.lang.String r7, java.lang.String r8, java.util.ArrayList<java.lang.String> r9) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.lang.String, java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0026 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0079 A[Catch: all -> 0x017f, TRY_LEAVE, TryCatch #3 {all -> 0x017f, blocks: (B:13:0x003c, B:14:0x003f, B:16:0x004d, B:22:0x006c, B:24:0x0079, B:19:0x0060), top: B:87:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0115 A[Catch: all -> 0x017a, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x017a, blocks: (B:32:0x00c0, B:34:0x00f3, B:36:0x00fe, B:39:0x0115, B:40:0x0122), top: B:83:0x00c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0122 A[Catch: all -> 0x017a, TRY_ENTER, TryCatch #1 {all -> 0x017a, blocks: (B:32:0x00c0, B:34:0x00f3, B:36:0x00fe, B:39:0x0115, B:40:0x0122), top: B:83:0x00c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x013c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.io.OutputStream r7, java.lang.String r8, java.util.ArrayList<java.lang.String> r9) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.util.ArrayList):void");
    }

    public static void a(String str, String str2) {
        synchronized (e) {
            if (!e.containsKey(str)) {
                f.add(str);
            }
            e.put(str, str2);
            if (b.d) {
                JNIBridge.nativeAddHeaderInfo(str, str2);
            }
            e.y();
        }
    }

    private static boolean a(String str, Thread thread) {
        if (thread == null) {
            return false;
        }
        synchronized (y) {
            int id = (int) thread.getId();
            if (y.get(id) == null) {
                z.add(Integer.valueOf(id));
            }
            y.put(id, new Object[]{new WeakReference(thread), str});
        }
        return true;
    }

    private static boolean a(List<String> list, String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return false;
        }
        for (String str2 : list) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(boolean z2) {
        int G2;
        if (!b.f26884c) {
            com.uc.crashsdk.a.a.a("crashsdk", "Unexp log not enabled, skip update unexp info!");
            return false;
        } else if (e.F() || b.L()) {
            return false;
        } else {
            if (z2) {
                com.uc.crashsdk.a.f.a(F);
                G2 = 0;
            } else if (!b.B()) {
                com.uc.crashsdk.a.a.a("crashsdk", "Stop update unexp info in background!");
                return false;
            } else if (g.G() <= 0) {
                return false;
            } else {
                if (com.uc.crashsdk.a.f.b(F)) {
                    return true;
                }
                G2 = g.G() * 1000;
            }
            com.uc.crashsdk.a.f.a(0, F, G2);
            return true;
        }
    }

    public static int b(String str, String str2) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        if (str == null || str2 == null) {
            return 0;
        }
        String str3 = str2;
        if (str2.length() > 2048) {
            str3 = str2.substring(0, 2048);
        }
        synchronized (A) {
            Object[] objArr = A.get(str);
            if (objArr != null) {
                int intValue = ((Integer) objArr[0]).intValue();
                i4 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if (list.size() >= intValue) {
                    list.remove(0);
                }
                list.add(str3);
                if (LogType.isForJava(i4)) {
                    i5 = LogType.addType(0, 16);
                }
                int i6 = i5;
                if (!b.d) {
                    int i7 = i5;
                    if (LogType.isForNative(i4)) {
                        i7 = LogType.addType(i5, 1);
                    }
                    i6 = i7;
                    if (LogType.isForANR(i4)) {
                        i6 = LogType.addType(i7, 1048576);
                    }
                }
                i2 = i6;
            } else {
                i2 = 0;
            }
            i3 = i2;
            if (b.d) {
                i3 = i2;
                if (JNIBridge.nativeAddCachedInfo(str, str3)) {
                    int i8 = i2;
                    if (LogType.isForNative(i4)) {
                        i8 = LogType.addType(i2, 1);
                    }
                    i3 = i8;
                    if (LogType.isForANR(i4)) {
                        i3 = LogType.addType(i8, 1048576);
                    }
                }
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b() {
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str) {
        StringBuilder sb = new StringBuilder();
        synchronized (A) {
            Object[] objArr = A.get(str);
            int intValue = ((Integer) objArr[0]).intValue();
            List<String> list = (List) objArr[2];
            sb.append(String.format(Locale.US, "%s (%d/%d)\n", str, Integer.valueOf(list.size()), Integer.valueOf(intValue)));
            for (String str2 : list) {
                sb.append(str2);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private static StringBuilder b(String str, boolean z2) {
        String a2;
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr = q.get(str);
            if (objArr == null) {
                a2 = "Unknown callback: " + str;
            } else {
                Callable callable = (Callable) objArr[1];
                a2 = callable != null ? (String) callable.call() : d.a(str, z2);
            }
            if (a2 != null) {
                sb.append(a2);
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        try {
            if (sb.length() == 0) {
                sb.append("(data is null)\n");
                return sb;
            }
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bf A[Catch: all -> 0x00df, LOOP:1: B:20:0x00b5->B:23:0x00bf, LOOP_END, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0008, B:6:0x0014, B:8:0x001c, B:10:0x005a, B:13:0x0065, B:32:0x010d, B:34:0x0113, B:36:0x0119, B:38:0x0121, B:40:0x0135, B:42:0x0142, B:15:0x0072, B:27:0x00e8, B:19:0x00ae, B:21:0x00b7, B:23:0x00bf), top: B:49:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(java.io.OutputStream r8, java.lang.String r9, java.lang.String r10, java.util.ArrayList<java.lang.String> r11) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.b(java.io.OutputStream, java.lang.String, java.lang.String, java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c() {
        if (i == -1) {
            o();
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<String> c(String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return null;
        }
        String[] split = str.split(t.aE, 20);
        ArrayList<String> arrayList = new ArrayList<>();
        int length = split.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return arrayList;
            }
            String str2 = split[i3];
            if (!com.uc.crashsdk.a.g.a(str2)) {
                arrayList.add(str2);
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d() {
        StringBuilder sb = new StringBuilder();
        synchronized (e) {
            for (String str : f) {
                String str2 = e.get(str);
                sb.append(str);
                sb.append(": ");
                if (str2 != null) {
                    sb.append(str2);
                }
                sb.append("\n");
            }
        }
        sb.append(String.format(Locale.US, "(saved at %s)\n", e.n()));
        com.uc.crashsdk.a.b.a(b.h(), sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (e) {
            for (String str : f) {
                JNIBridge.nativeAddHeaderInfo(str, e.get(str));
            }
        }
    }

    public static byte[] f() {
        return new byte[]{24, 99, 121, 60};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (k) {
            for (String str : l) {
                Object[] objArr = k.get(str);
                int intValue = ((Integer) objArr[0]).intValue();
                if ((1048833 & intValue) != 0) {
                    JNIBridge.nativeAddDumpFile(str, (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), intValue, ((Boolean) objArr[4]).booleanValue());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h() {
        StringBuilder sb = new StringBuilder();
        synchronized (k) {
            boolean z2 = true;
            for (String str : l) {
                if (LogType.isForJava(((Integer) k.get(str)[0]).intValue())) {
                    if (!z2) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z2 = false;
                }
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (q) {
            for (String str : r) {
                Object[] objArr = q.get(str);
                int intValue = ((Integer) objArr[0]).intValue();
                if ((1048833 & intValue) != 0) {
                    JNIBridge.nativeAddCallbackInfo(str, intValue, ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String j() {
        String sb;
        synchronized (q) {
            StringBuilder sb2 = new StringBuilder();
            synchronized (r) {
                boolean z2 = true;
                for (String str : r) {
                    if (LogType.isForJava(((Integer) q.get(str)[0]).intValue())) {
                        if (!z2) {
                            sb2.append("`");
                        }
                        sb2.append(str);
                        z2 = false;
                    }
                }
            }
            sb = sb2.toString();
        }
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (A) {
            for (String str : B) {
                Object[] objArr = A.get(str);
                int intValue = ((Integer) objArr[0]).intValue();
                int intValue2 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if ((1048577 & intValue2) != 0 && JNIBridge.nativeCreateCachedInfo(str, intValue, intValue2) != 0) {
                    Iterator it = list.iterator();
                    do {
                        if (it.hasNext()) {
                        }
                    } while (JNIBridge.nativeAddCachedInfo(str, (String) it.next()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l() {
        StringBuilder sb = new StringBuilder();
        synchronized (A) {
            boolean z2 = true;
            for (String str : B) {
                if (LogType.isForJava(((Integer) A.get(str)[1]).intValue())) {
                    if (!z2) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z2 = false;
                }
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String m() {
        if (!G) {
            String a2 = com.uc.crashsdk.a.b.a(b.m());
            g = a2;
            G = true;
            if (a2 == null) {
                g = "";
            }
        }
        return g;
    }

    public static void n() {
        p();
        if (!H) {
            H = true;
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(202));
        } else if (b.d) {
            JNIBridge.set(128, g);
        }
    }

    private static boolean o() {
        try {
            PackageInfo packageInfo = com.uc.crashsdk.a.g.a().getPackageManager().getPackageInfo(f26866a, 0);
            h = packageInfo.versionName;
            j = packageInfo.lastUpdateTime;
            i = packageInfo.versionCode;
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.b(th);
            return false;
        }
    }

    private static void p() {
        if (!I && e.a()) {
            if (b.d || !b.g) {
                String format = String.format(Locale.US, "%s/%s/%s", g.T(), g.U(), g.V());
                com.uc.crashsdk.a.a.b("crashsdk", "UUID: " + e.q());
                com.uc.crashsdk.a.a.b("crashsdk", "Version: " + format);
                com.uc.crashsdk.a.a.b("crashsdk", "Process Name: " + e.h());
                I = true;
            }
        }
    }
}
