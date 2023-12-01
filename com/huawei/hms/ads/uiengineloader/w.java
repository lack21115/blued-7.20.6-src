package com.huawei.hms.ads.uiengineloader;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/w.class */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8968a = "EmuiUtil";
    private static final String b = "EMUI_SDK_INT";

    /* renamed from: c  reason: collision with root package name */
    private static final String f8969c = "com.huawei.android.os.BuildEx$VERSION";
    private static final int d = -1;
    private static final int e = 7;
    private static final int f = 8;
    private static final int g = 9;
    private static final int h = 10;
    private static final int i = 11;
    private static final int j = 14;
    private static final int k = 15;
    private static final int l = 17;
    private static final int m = 30;
    private static final int n = 31;
    private static final int o = 40;
    private static final int p = 41;
    private static final int q = 50;
    private static final int r = 60;
    private static final int s = 81;
    private static final int t = 90;
    private static int u = -1;
    private static int v = d();

    /* JADX WARN: Removed duplicated region for block: B:61:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    static {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.uiengineloader.w.m4128clinit():void");
    }

    public static boolean a() {
        return u == 50;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b() {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.uiengineloader.w.b():void");
    }

    private static void c() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, "ro.build.version.emui");
            aa.a(f8968a, "isNeed2UseHwEmui :");
            if (str != null) {
                if (str.contains("EmotionUI_3.0")) {
                    u = 30;
                } else if (str.contains("EmotionUI_3.1")) {
                    u = 31;
                } else if (str.contains("EmotionUI_4.0")) {
                    u = 40;
                } else if (str.contains("EmotionUI_4.1")) {
                    u = 41;
                } else if (str.contains("EmotionUI_5.0")) {
                    u = 50;
                } else if (str.contains("EmotionUI_6.0")) {
                    u = 60;
                } else {
                    u = -1;
                }
            }
        } catch (Throwable th) {
            aa.d(f8968a, "dealTypeUnknow Exception:" + th.getClass().getSimpleName());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int d() {
        /*
            java.lang.String r0 = "com.huawei.android.os.BuildEx$VERSION"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.ClassNotFoundException -> L56 java.lang.IllegalAccessException -> L5a java.lang.NoSuchFieldException -> L5e java.lang.SecurityException -> L62 java.lang.Exception -> L66
            r5 = r0
            r0 = r5
            java.lang.String r1 = "EMUI_SDK_INT"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r1)     // Catch: java.lang.ClassNotFoundException -> L56 java.lang.IllegalAccessException -> L5a java.lang.NoSuchFieldException -> L5e java.lang.SecurityException -> L62 java.lang.Exception -> L66
            r6 = r0
            r0 = 1
            java.lang.reflect.Field[] r0 = new java.lang.reflect.Field[r0]     // Catch: java.lang.ClassNotFoundException -> L56 java.lang.IllegalAccessException -> L5a java.lang.NoSuchFieldException -> L5e java.lang.SecurityException -> L62 java.lang.Exception -> L66
            r1 = r0
            r2 = 0
            r3 = r6
            r1[r2] = r3     // Catch: java.lang.ClassNotFoundException -> L56 java.lang.IllegalAccessException -> L5a java.lang.NoSuchFieldException -> L5e java.lang.SecurityException -> L62 java.lang.Exception -> L66
            r1 = 1
            java.lang.reflect.AccessibleObject.setAccessible(r0, r1)     // Catch: java.lang.ClassNotFoundException -> L56 java.lang.IllegalAccessException -> L5a java.lang.NoSuchFieldException -> L5e java.lang.SecurityException -> L62 java.lang.Exception -> L66
            r0 = r6
            r1 = r5
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.ClassNotFoundException -> L56 java.lang.IllegalAccessException -> L5a java.lang.NoSuchFieldException -> L5e java.lang.SecurityException -> L62 java.lang.Exception -> L66
            r5 = r0
            goto L45
        L22:
            java.lang.String r0 = "getEMUIVersionCode exception "
            r5 = r0
            goto L3d
        L28:
            java.lang.String r0 = "getEMUIVersionCode SecurityException"
            r5 = r0
            goto L3d
        L2e:
            java.lang.String r0 = "getEMUIVersionCode NoSuchFieldException"
            r5 = r0
            goto L3d
        L34:
            java.lang.String r0 = "getEMUIVersionCode IllegalAccessException"
            r5 = r0
            goto L3d
        L3a:
            java.lang.String r0 = "getEMUIVersionCode ClassNotFoundException"
            r5 = r0
        L3d:
            java.lang.String r0 = "EmuiUtil"
            r1 = r5
            com.huawei.hms.ads.uiengineloader.aa.c(r0, r1)
            r0 = 0
            r5 = r0
        L45:
            r0 = r5
            boolean r0 = r0 instanceof java.lang.Integer
            if (r0 != 0) goto L4e
            r0 = 0
            return r0
        L4e:
            r0 = r5
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            return r0
        L56:
            r5 = move-exception
            goto L3a
        L5a:
            r5 = move-exception
            goto L34
        L5e:
            r5 = move-exception
            goto L2e
        L62:
            r5 = move-exception
            goto L28
        L66:
            r5 = move-exception
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.uiengineloader.w.d():int");
    }
}
