package com.opos.cmn.an.h.a;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/h/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static ActivityManager f10872a;
    private static volatile String b = "";

    public static ActivityManager a(Context context) {
        if (f10872a == null && context != null) {
            f10872a = (ActivityManager) context.getApplicationContext().getSystemService("activity");
        }
        return f10872a;
    }

    private static String a() {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                return Application.getProcessName();
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
        if (r0.getPackageName().equals(r5) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 1
            r6 = r0
            r0 = r4
            android.app.ActivityManager r0 = a(r0)     // Catch: java.lang.Exception -> L43
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L4c
            r0 = r5
            boolean r0 = com.opos.cmn.an.c.a.a(r0)     // Catch: java.lang.Exception -> L43
            if (r0 != 0) goto L4c
            r0 = r4
            r1 = 1
            java.util.List r0 = r0.getRunningTasks(r1)     // Catch: java.lang.Exception -> L43
            r4 = r0
            r0 = r4
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Exception -> L43
            if (r0 != 0) goto L4c
            r0 = r4
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> L43
            android.app.ActivityManager$RunningTaskInfo r0 = (android.app.ActivityManager.RunningTaskInfo) r0     // Catch: java.lang.Exception -> L43
            android.content.ComponentName r0 = r0.topActivity     // Catch: java.lang.Exception -> L43
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L4c
            r0 = r4
            java.lang.String r0 = r0.getPackageName()     // Catch: java.lang.Exception -> L43
            r1 = r5
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L43
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L4c
            goto L4e
        L43:
            r4 = move-exception
            java.lang.String r0 = "ActMgrTool"
            java.lang.String r1 = ""
            r2 = r4
            com.opos.cmn.an.f.a.c(r0, r1, r2)
        L4c:
            r0 = 0
            r6 = r0
        L4e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r4 = r0
            r0 = r4
            java.lang.String r1 = "isRunningTasks pkgName="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            if (r0 == 0) goto L64
            goto L67
        L64:
            java.lang.String r0 = "null"
            r5 = r0
        L67:
            r0 = r4
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r1 = ",result="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "ActMgrTool"
            r1 = r4
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.h.a.a.a(android.content.Context, java.lang.String):boolean");
    }

    public static int b(Context context) {
        int i;
        try {
            i = Process.myPid();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ActMgrTool", "", e);
            i = -1;
        }
        com.opos.cmn.an.f.a.b("ActMgrTool", "getMyPid pid=" + i);
        return i;
    }

    private static String b() {
        String str = null;
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                str = (String) invoke;
            }
            return str;
        } catch (Throwable th) {
            return null;
        }
    }

    private static String c() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        String str;
        String str2 = null;
        String str3 = null;
        if (TextUtils.isEmpty(null)) {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/cmdline"));
                str = null;
            } catch (Exception e) {
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
            try {
                String readLine = bufferedReader.readLine();
                str2 = readLine;
                bufferedReader2 = bufferedReader;
                if (!TextUtils.isEmpty(readLine)) {
                    str = readLine;
                    str2 = readLine.trim();
                    bufferedReader2 = bufferedReader;
                }
            } catch (Exception e2) {
                str2 = str;
                str3 = str2;
                if (bufferedReader != null) {
                    bufferedReader2 = bufferedReader;
                    bufferedReader2.close();
                    return str2;
                }
                return str3;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e3) {
                    }
                }
                throw th;
            }
            try {
                bufferedReader2.close();
                return str2;
            } catch (Exception e4) {
                return str2;
            }
        }
        return str3;
    }

    public static String c(Context context) {
        try {
            if (TextUtils.isEmpty(b)) {
                b = a();
                if (TextUtils.isEmpty(b)) {
                    b = b();
                }
                if (TextUtils.isEmpty(b)) {
                    b = c();
                }
                if (TextUtils.isEmpty(b)) {
                    b = f(context);
                }
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("ActMgrTool", "getMyProName", th);
        }
        if (b == null) {
            b = "";
        }
        com.opos.cmn.an.f.a.b("ActMgrTool", "getMyProName = " + b);
        return b;
    }

    public static boolean d(Context context) {
        boolean z;
        try {
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ActMgrTool", "", e);
        }
        if (a(context, context.getPackageName())) {
            if (e(context)) {
                z = true;
                com.opos.cmn.an.f.a.b("ActMgrTool", "isForegroundApp=" + z);
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("ActMgrTool", "isForegroundApp=" + z);
        return z;
    }

    public static boolean e(Context context) {
        boolean z;
        boolean z2 = false;
        boolean z3 = false;
        try {
            ActivityManager a2 = a(context);
            z = false;
            if (a2 != null) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = a2.getRunningAppProcesses();
                z = false;
                if (runningAppProcesses != null) {
                    z = false;
                    if (runningAppProcesses.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("android.os.Process.myPid()=");
                        sb.append(Process.myPid());
                        com.opos.cmn.an.f.a.b("ActMgrTool", sb.toString());
                        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                        while (true) {
                            z3 = z2;
                            z = z2;
                            if (!it.hasNext()) {
                                break;
                            }
                            boolean z4 = z2;
                            ActivityManager.RunningAppProcessInfo next = it.next();
                            boolean z5 = z2;
                            StringBuilder sb2 = new StringBuilder();
                            boolean z6 = z2;
                            sb2.append("appProcess.processName=");
                            boolean z7 = z2;
                            sb2.append(next.processName);
                            boolean z8 = z2;
                            sb2.append(",appProcess.pid=");
                            boolean z9 = z2;
                            sb2.append(next.pid);
                            boolean z10 = z2;
                            sb2.append(",appProcess.importance=");
                            boolean z11 = z2;
                            sb2.append(next.importance);
                            boolean z12 = z2;
                            com.opos.cmn.an.f.a.b("ActMgrTool", sb2.toString());
                            boolean z13 = z2;
                            if (next.importance == 100) {
                                boolean z14 = z2;
                                int i = next.pid;
                                boolean z15 = z2;
                                if (i == Process.myPid()) {
                                    z2 = true;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ActMgrTool", "", e);
            z = z3;
        }
        com.opos.cmn.an.f.a.b("ActMgrTool", "isRunningAppProcesses result=" + z);
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
        r5 = r0.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String f(android.content.Context r4) {
        /*
            java.lang.String r0 = ""
            r6 = r0
            r0 = r4
            android.app.ActivityManager r0 = a(r0)     // Catch: java.lang.Exception -> L40
            r7 = r0
            r0 = r6
            r5 = r0
            r0 = r7
            if (r0 == 0) goto L4b
            r0 = r7
            java.util.List r0 = r0.getRunningAppProcesses()     // Catch: java.lang.Exception -> L40
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> L40
            r7 = r0
        L18:
            r0 = r6
            r5 = r0
            r0 = r7
            boolean r0 = r0.hasNext()     // Catch: java.lang.Exception -> L40
            if (r0 == 0) goto L4b
            r0 = r7
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Exception -> L40
            android.app.ActivityManager$RunningAppProcessInfo r0 = (android.app.ActivityManager.RunningAppProcessInfo) r0     // Catch: java.lang.Exception -> L40
            r5 = r0
            r0 = r5
            int r0 = r0.pid     // Catch: java.lang.Exception -> L40
            r1 = r4
            int r1 = b(r1)     // Catch: java.lang.Exception -> L40
            if (r0 != r1) goto L18
            r0 = r5
            java.lang.String r0 = r0.processName     // Catch: java.lang.Exception -> L40
            r5 = r0
            goto L4b
        L40:
            r4 = move-exception
            java.lang.String r0 = "ActMgrTool"
            java.lang.String r1 = ""
            r2 = r4
            com.opos.cmn.an.f.a.c(r0, r1, r2)
            r0 = r6
            r5 = r0
        L4b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r6
            java.lang.String r1 = "getProcessNameByAms = "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            if (r0 == 0) goto L63
            r0 = r5
            r4 = r0
            goto L67
        L63:
            java.lang.String r0 = " null "
            r4 = r0
        L67:
            r0 = r6
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "ActMgrTool"
            r1 = r6
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.h.a.a.f(android.content.Context):java.lang.String");
    }
}
