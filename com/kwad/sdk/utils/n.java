package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.service.ServiceProvider;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/n.class */
public final class n {
    public static com.kwad.sdk.h.kwai.d azo;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/n$a.class */
    static final class a extends com.kwad.sdk.h.kwai.a {
        public a() {
            CT();
        }

        private void CT() {
            this.axx = new ArrayList();
            this.axx.add(new com.kwad.sdk.h.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.a.1
                /* JADX WARN: Code restructure failed: missing block: B:107:0x0242, code lost:
                    if (android.os.Build.FINGERPRINT.contains("generic/vbox86p/vbox86p") != false) goto L113;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:36:0x00b9, code lost:
                    if (android.os.Build.MANUFACTURER.contains("TiantianVM") != false) goto L118;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:45:0x00eb, code lost:
                    if (android.os.Build.BRAND.contains("Andy") != false) goto L117;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:64:0x0154, code lost:
                    if (android.os.Build.DEVICE.contains("aries") != false) goto L116;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:81:0x01b2, code lost:
                    if (android.os.Build.MODEL.equals("Android SDK built for x86") != false) goto L115;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:90:0x01e4, code lost:
                    if (android.os.Build.HARDWARE.contains("ttVM_x86") != false) goto L114;
                 */
                @Override // com.kwad.sdk.h.kwai.a
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final boolean bs(android.content.Context r5) {
                    /*
                        Method dump skipped, instructions count: 680
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.n.a.AnonymousClass1.bs(android.content.Context):boolean");
                }
            });
            this.axx.add(new com.kwad.sdk.h.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.a.2
                @Override // com.kwad.sdk.h.kwai.a
                public final boolean bs(Context context) {
                    return "1".equals(bc.get("ro.kernel.qemu"));
                }
            });
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/n$b.class */
    static final class b extends com.kwad.sdk.h.kwai.a {
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/n$c.class */
    static final class c extends com.kwad.sdk.h.kwai.a {
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/n$d.class */
    static final class d extends com.kwad.sdk.h.kwai.a {
        public d() {
            CT();
        }

        private void CT() {
            this.axx = new ArrayList();
            this.axx.add(new com.kwad.sdk.h.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.1
                @Override // com.kwad.sdk.h.kwai.a
                public final boolean bs(Context context) {
                    return new File("/system/app/Superuser.apk").exists();
                }
            });
            this.axx.add(new com.kwad.sdk.h.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.2
                @Override // com.kwad.sdk.h.kwai.a
                public final boolean bs(Context context) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= 5) {
                            return false;
                        }
                        if (new File(new String[]{"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"}[i2] + com.kuaishou.weapon.p0.bh.y).exists()) {
                            return true;
                        }
                        i = i2 + 1;
                    }
                }
            });
            this.axx.add(new com.kwad.sdk.h.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.3
                @Override // com.kwad.sdk.h.kwai.a
                public final boolean bs(Context context) {
                    return !TextUtils.isEmpty(n.g(new String[]{"/system/xbin/which", com.kuaishou.weapon.p0.bh.y}));
                }
            });
            this.axx.add(new com.kwad.sdk.h.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.d.4
                @Override // com.kwad.sdk.h.kwai.a
                public final boolean bs(Context context) {
                    Charset forName = Charset.forName("UTF-8");
                    File file = new File("/data/su_test");
                    try {
                        q.a(file, com.igexin.push.core.b.x, forName, false);
                        return q.a(file, forName).equals(com.igexin.push.core.b.x);
                    } catch (Throwable th) {
                        return false;
                    }
                }
            });
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/n$e.class */
    static final class e extends com.kwad.sdk.h.kwai.a {
        public e() {
            CT();
        }

        private void CT() {
            this.axx = new ArrayList();
            this.axx.add(new com.kwad.sdk.h.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.e.1
                @Override // com.kwad.sdk.h.kwai.a
                public final boolean bs(Context context) {
                    return ak.ah(context, "de.robv.android.xposed.installer") || ak.ah(context, "com.saurik.substrate");
                }
            });
            this.axx.add(new com.kwad.sdk.h.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.e.2
                @Override // com.kwad.sdk.h.kwai.a
                public final boolean bs(Context context) {
                    try {
                        throw new Exception("empty");
                    } catch (Exception e) {
                        StackTraceElement[] stackTrace = e.getStackTrace();
                        int length = stackTrace.length;
                        int i = 0;
                        boolean z = false;
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i >= length) {
                                return z;
                            }
                            StackTraceElement stackTraceElement = stackTrace[i];
                            String className = stackTraceElement.getClassName();
                            String methodName = stackTraceElement.getMethodName();
                            boolean z2 = z;
                            int i4 = i3;
                            if (className.equals("com.android.internal.os.ZygoteInit")) {
                                int i5 = i3 + 1;
                                z2 = z;
                                i4 = i5;
                                if (i5 == 2) {
                                    z2 = true;
                                    i4 = i5;
                                }
                            }
                            boolean z3 = z2;
                            if (className.equals("com.saurik.substrate.MS$2")) {
                                z3 = z2;
                                if (methodName.equals("invoked")) {
                                    Log.wtf("HookDetection", "A method on the stack trace has been hooked using Substrate.");
                                    z3 = true;
                                }
                            }
                            boolean z4 = z3;
                            if (className.equals(com.kuaishou.weapon.p0.an.b)) {
                                z4 = z3;
                                if (methodName.equals("main")) {
                                    z4 = true;
                                }
                            }
                            z = z4;
                            if (className.equals(com.kuaishou.weapon.p0.an.b)) {
                                z = z4;
                                if (methodName.equals("handleHookedMethod")) {
                                    z = true;
                                }
                            }
                            i++;
                            i2 = i4;
                        }
                    }
                }
            });
            this.axx.add(new com.kwad.sdk.h.kwai.a(this.enabled) { // from class: com.kwad.sdk.utils.n.e.3
                @Override // com.kwad.sdk.h.kwai.a
                public final boolean bs(Context context) {
                    FileReader fileReader;
                    BufferedReader bufferedReader;
                    Throwable th;
                    HashSet hashSet;
                    boolean z = false;
                    boolean z2 = false;
                    try {
                        hashSet = new HashSet();
                        fileReader = new FileReader("/proc/" + Process.myPid() + "/maps");
                    } catch (Exception e) {
                        fileReader = null;
                        bufferedReader = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileReader = null;
                    }
                    try {
                        bufferedReader = new BufferedReader(fileReader);
                        while (true) {
                            z = false;
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                } else if (readLine.endsWith(".so") || readLine.endsWith(ShareConstants.JAR_SUFFIX)) {
                                    hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                                }
                            } catch (Exception e2) {
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                z2 = z;
                                com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                                return z2;
                            } catch (Throwable th3) {
                                th = th3;
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                                throw th;
                            }
                        }
                        Iterator<E> it = hashSet.iterator();
                        while (true) {
                            z = z2;
                            if (!it.hasNext()) {
                                break;
                            }
                            boolean z3 = z2;
                            String str = (String) it.next();
                            boolean z4 = z2;
                            boolean z5 = z2;
                            if (str.contains("com.saurik.substrate")) {
                                StringBuilder sb = new StringBuilder("Substrate shared object found: ");
                                boolean z6 = z2;
                                sb.append(str);
                                boolean z7 = z2;
                                Log.wtf("HookDetection", sb.toString());
                                z5 = true;
                            }
                            z2 = z5;
                            if (str.contains("XposedBridge.jar")) {
                                boolean z8 = z5;
                                StringBuilder sb2 = new StringBuilder("Xposed JAR found: ");
                                boolean z9 = z5;
                                sb2.append(str);
                                boolean z10 = z5;
                                Log.wtf("HookDetection", sb2.toString());
                                z2 = true;
                            }
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    } catch (Exception e3) {
                        bufferedReader = null;
                    } catch (Throwable th4) {
                        th = th4;
                        th = th;
                        bufferedReader = null;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                        throw th;
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                    return z2;
                }
            });
        }
    }

    public static com.kwad.sdk.h.kwai.d CS() {
        synchronized (n.class) {
            try {
                if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sA()) {
                    if (azo != null) {
                        return azo;
                    }
                    Context applicationContext = ServiceProvider.getContext().getApplicationContext();
                    com.kwad.sdk.h.kwai.d dVar = new com.kwad.sdk.h.kwai.d(applicationContext);
                    boolean br = new d().br(applicationContext);
                    boolean br2 = new e().br(applicationContext);
                    boolean br3 = new b().br(applicationContext);
                    boolean br4 = new a().br(applicationContext);
                    boolean br5 = new c().br(applicationContext);
                    dVar.bp(br);
                    dVar.bq(br2);
                    dVar.br(br3);
                    dVar.bt(br4);
                    dVar.bu(br5);
                    azo = dVar;
                    return dVar;
                }
                return null;
            } finally {
            }
        }
    }

    public static String g(String[] strArr) {
        try {
            return com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec(strArr).getInputStream());
        } catch (Exception e2) {
            return null;
        }
    }
}
