package com.blued.android.module.live.base.utils;

import android.graphics.Bitmap;
import android.util.Log;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.BluedSharedPreferences;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/utils/LiveLogUtils.class */
public class LiveLogUtils {

    /* renamed from: com.blued.android.module.live.base.utils.LiveLogUtils$2  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/utils/LiveLogUtils$2.class */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ byte[] b;

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    File file = new File(LiveLogUtils.c());
                    if (file.exists() || file.mkdirs()) {
                        File file2 = new File(file, this.a);
                        if (!file2.exists()) {
                            try {
                                file2.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file2, true);
                        try {
                            fileOutputStream.write(this.b);
                            fileOutputStream.close();
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
    }

    /* renamed from: com.blued.android.module.live.base.utils.LiveLogUtils$4  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/utils/LiveLogUtils$4.class */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ Bitmap b;

        @Override // java.lang.Runnable
        public void run() {
            File file = new File(AppMethods.a("LiveLog"));
            if (!file.exists() && !file.mkdirs()) {
                Log.d("PhotoEditorSDK", "Failed to create directory");
                return;
            }
            String str = file.getPath() + File.separator + this.a;
            Log.d("PhotoEditorSDK", "selected camera path " + str);
            File file2 = new File(str);
            try {
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                this.b.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.blued.android.module.live.base.utils.LiveLogUtils$5  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/utils/LiveLogUtils$5.class */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ LiveDecryptLogListener b;

        /* JADX WARN: Not initialized variable reg: 10, insn: 0x0249: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:95:0x0249 */
        /* JADX WARN: Not initialized variable reg: 9, insn: 0x024c: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:95:0x0249 */
        /* JADX WARN: Removed duplicated region for block: B:101:0x0262 A[Catch: IOException -> 0x027c, TRY_ENTER, TryCatch #8 {IOException -> 0x027c, blocks: (B:98:0x0257, B:101:0x0262, B:104:0x026a), top: B:116:0x0257 }] */
        /* JADX WARN: Removed duplicated region for block: B:104:0x026a A[Catch: IOException -> 0x027c, TRY_ENTER, TRY_LEAVE, TryCatch #8 {IOException -> 0x027c, blocks: (B:98:0x0257, B:101:0x0262, B:104:0x026a), top: B:116:0x0257 }] */
        /* JADX WARN: Removed duplicated region for block: B:116:0x0257 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x016b  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0229 A[Catch: IOException -> 0x0278, TRY_ENTER, TRY_LEAVE, TryCatch #1 {IOException -> 0x0278, blocks: (B:38:0x0115, B:84:0x0229, B:87:0x0235, B:90:0x023d), top: B:112:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0235 A[Catch: IOException -> 0x0278, TRY_ENTER, TryCatch #1 {IOException -> 0x0278, blocks: (B:38:0x0115, B:84:0x0229, B:87:0x0235, B:90:0x023d), top: B:112:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:90:0x023d A[Catch: IOException -> 0x0278, TRY_ENTER, TryCatch #1 {IOException -> 0x0278, blocks: (B:38:0x0115, B:84:0x0229, B:87:0x0235, B:90:0x023d), top: B:112:0x0000 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 640
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live.base.utils.LiveLogUtils.AnonymousClass5.run():void");
        }
    }

    public static String a() {
        return "audio_log.txt";
    }

    private static void a(File file, long j) {
        File[] listFiles = file.listFiles();
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                BluedSharedPreferences.a().c().a("YY_Log", j).a();
                return;
            }
            File file2 = listFiles[i2];
            if (file2 != null) {
                String name = file2.getName();
                String str = name;
                if (name.endsWith(".txt")) {
                    str = name.replaceAll(".txt", "");
                }
                if (j - StringUtils.a(str.startsWith("audioLog_") ? str.replaceAll("audioLog_", "") : "", 0L) > 5) {
                    file2.delete();
                }
            }
            i = i2 + 1;
        }
    }

    public static void a(final String str) {
        ThreadManager.a().a(new Runnable() { // from class: com.blued.android.module.live.base.utils.LiveLogUtils.3
            /* JADX WARN: Removed duplicated region for block: B:44:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r5 = this;
                    java.lang.String r0 = com.blued.android.module.live.base.utils.LiveLogUtils.b()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
                    java.io.File r0 = com.blued.android.module.live.base.utils.LiveLogUtils.b(r0)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
                    r6 = r0
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
                    r1 = r0
                    r1.<init>()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
                    r7 = r0
                    r0 = r7
                    long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
                    java.lang.String r1 = com.blued.android.module.live.base.utils.LiveTimeAndDateUtils.c(r1)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
                    java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
                    r0 = r7
                    java.lang.String r1 = " ::::: "
                    java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
                    r0 = r7
                    r1 = r5
                    java.lang.String r1 = java.lang.String.this     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
                    java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
                    r0 = r7
                    java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
                    r8 = r0
                    java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
                    r1 = r0
                    r2 = r6
                    r3 = 1
                    r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
                    r6 = r0
                    r0 = r6
                    r7 = r0
                    r0 = r6
                    java.lang.String r1 = "Blued_Voice"
                    r2 = r8
                    java.lang.String r1 = com.blued.android.module.live.base.utils.LogEncryptionUtils.a(r1, r2)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> La7
                    byte[] r1 = r1.getBytes()     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> La7
                    r0.write(r1)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> La7
                    r0 = r6
                    r7 = r0
                    r0 = r6
                    java.lang.String r1 = "\n"
                    byte[] r1 = r1.getBytes()     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> La7
                    r0.write(r1)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> La7
                    r0 = r6
                    r7 = r0
                    r0 = r6
                    r0.close()     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> La7
                L59:
                    r0 = r6
                    r0.close()     // Catch: java.lang.Exception -> Lb2
                    return
                L5e:
                    r8 = move-exception
                    goto L6b
                L62:
                    r6 = move-exception
                    r0 = 0
                    r7 = r0
                    goto La8
                L68:
                    r8 = move-exception
                    r0 = 0
                    r6 = r0
                L6b:
                    r0 = r6
                    r7 = r0
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La7
                    r1 = r0
                    r1.<init>()     // Catch: java.lang.Throwable -> La7
                    r9 = r0
                    r0 = r6
                    r7 = r0
                    r0 = r9
                    java.lang.String r1 = "write voice log error："
                    java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> La7
                    r0 = r6
                    r7 = r0
                    r0 = r9
                    r1 = r8
                    java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> La7
                    java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> La7
                    r0 = r6
                    r7 = r0
                    java.lang.String r0 = "LiveLogUtils"
                    r1 = r9
                    java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> La7
                    int r0 = android.util.Log.e(r0, r1)     // Catch: java.lang.Throwable -> La7
                    r0 = r6
                    r7 = r0
                    r0 = r8
                    r0.printStackTrace()     // Catch: java.lang.Throwable -> La7
                    r0 = r6
                    if (r0 == 0) goto La6
                    goto L59
                La6:
                    return
                La7:
                    r6 = move-exception
                La8:
                    r0 = r7
                    if (r0 == 0) goto Lb0
                    r0 = r7
                    r0.close()     // Catch: java.lang.Exception -> Lb4
                Lb0:
                    r0 = r6
                    throw r0
                Lb2:
                    r6 = move-exception
                    return
                Lb4:
                    r7 = move-exception
                    goto Lb0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live.base.utils.LiveLogUtils.AnonymousClass3.run():void");
            }
        });
    }

    public static void a(final String str, final String str2) {
        ThreadManager.a().b(new Runnable() { // from class: com.blued.android.module.live.base.utils.LiveLogUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        File file = new File(LiveLogUtils.c());
                        if (file.exists() || file.mkdirs()) {
                            File file2 = new File(file, String.this);
                            if (!file2.exists()) {
                                try {
                                    file2.createNewFile();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else if (file2.length() > 102400) {
                                try {
                                    if (file2.delete()) {
                                        file2.createNewFile();
                                    }
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            String str3 = "\r\n" + LiveTimeAndDateUtils.c(System.currentTimeMillis()) + " ::::: " + str;
                            FileOutputStream fileOutputStream = new FileOutputStream(file2, true);
                            try {
                                fileOutputStream.write(str3.getBytes());
                                fileOutputStream.close();
                            } catch (Exception e3) {
                                e = e3;
                                e.printStackTrace();
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e4) {
                    e = e4;
                }
            }
        });
    }

    public static String b() {
        return "audioLog_" + LiveTimeAndDateUtils.d(System.currentTimeMillis()) + ".txt";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File c(String str) throws Exception {
        File file = new File(c());
        if (file.exists() && file.isDirectory()) {
            long a = StringUtils.a(LiveTimeAndDateUtils.d(System.currentTimeMillis()), 0L);
            if (a > BluedSharedPreferences.a().a("YY_Log", 0L)) {
                a(file, a);
            }
        } else {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        if (str.startsWith("decrypt_") && file2.exists()) {
            file2.delete();
        }
        if (!file2.exists()) {
            file2.createNewFile();
        }
        return file2;
    }

    public static String c() {
        return AppMethods.a("LiveLog");
    }
}
