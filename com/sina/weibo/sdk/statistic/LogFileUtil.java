package com.sina.weibo.sdk.statistic;

import android.os.Environment;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/statistic/LogFileUtil.class */
class LogFileUtil {
    public static final String ANALYTICS_FILE_NAME = "app_logs";
    private static final String ANALYTICS_FILE_SUFFIX = ".txt";
    private static final String SDCARD_WEIBO_ANALYTICS_DIR = "/sina/weibo/.applogs/";

    LogFileUtil() {
    }

    public static boolean delete(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            file.delete();
            return true;
        }
        return false;
    }

    public static String getAppLogPath(String str) {
        String str2;
        if (LogReport.getPackageName() != null) {
            str2 = String.valueOf(MD5.hexdigest(LogReport.getPackageName())) + BridgeUtil.SPLIT_MARK;
        } else {
            str2 = "";
        }
        return String.valueOf(getSDPath()) + SDCARD_WEIBO_ANALYTICS_DIR + str2 + str + ANALYTICS_FILE_SUFFIX;
    }

    public static String getAppLogs(String str) {
        return TextUtils.isEmpty(str) ? "" : readStringFromFile(str);
    }

    private static String getSDPath() {
        File externalStorageDirectory = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) ? Environment.getExternalStorageDirectory() : null;
        if (externalStorageDirectory != null) {
            return externalStorageDirectory.toString();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
        if (r7 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0083, code lost:
        if (r7 == null) goto L22;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String readStringFromFile(java.lang.String r6) {
        /*
            r0 = r6
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto La
            java.lang.String r0 = ""
            return r0
        La:
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r6
            r1.<init>(r2)
            r6 = r0
            r0 = r6
            boolean r0 = r0.isFile()
            if (r0 == 0) goto L99
            r0 = r6
            boolean r0 = r0.exists()
            if (r0 != 0) goto L24
            java.lang.String r0 = ""
            return r0
        L24:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r2 = r6
            long r2 = r2.length()
            int r2 = (int) r2
            r1.<init>(r2)
            r9 = r0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L66 java.lang.OutOfMemoryError -> L6c java.io.IOException -> La4
            r1 = r0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L66 java.lang.OutOfMemoryError -> L6c java.io.IOException -> La4
            r3 = r2
            r4 = r6
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L66 java.lang.OutOfMemoryError -> L6c java.io.IOException -> La4
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L66 java.lang.OutOfMemoryError -> L6c java.io.IOException -> La4
            r7 = r0
        L41:
            r0 = r7
            r6 = r0
            r0 = r7
            java.lang.String r0 = r0.readLine()     // Catch: java.lang.OutOfMemoryError -> L5e java.io.IOException -> L62 java.lang.Throwable -> L8e
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L53
        L4c:
            r0 = r7
            r0.close()     // Catch: java.io.IOException -> L9c
            goto L89
        L53:
            r0 = r7
            r6 = r0
            r0 = r9
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.OutOfMemoryError -> L5e java.io.IOException -> L62 java.lang.Throwable -> L8e
            goto L41
        L5e:
            r8 = move-exception
            goto L6f
        L62:
            r8 = move-exception
            goto L7c
        L66:
            r7 = move-exception
            r0 = 0
            r6 = r0
            goto L8f
        L6c:
            r8 = move-exception
            r0 = 0
            r7 = r0
        L6f:
            r0 = r7
            r6 = r0
            r0 = r8
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L8e
            r0 = r7
            if (r0 == 0) goto L89
            goto L4c
        L7c:
            r0 = r7
            r6 = r0
            r0 = r8
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L8e
            r0 = r7
            if (r0 == 0) goto L89
            goto L4c
        L89:
            r0 = r9
            java.lang.String r0 = r0.toString()
            return r0
        L8e:
            r7 = move-exception
        L8f:
            r0 = r6
            if (r0 == 0) goto L97
            r0 = r6
            r0.close()     // Catch: java.io.IOException -> La0
        L97:
            r0 = r7
            throw r0
        L99:
            java.lang.String r0 = ""
            return r0
        L9c:
            r6 = move-exception
            goto L89
        La0:
            r6 = move-exception
            goto L97
        La4:
            r8 = move-exception
            r0 = 0
            r7 = r0
            goto L7c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.statistic.LogFileUtil.readStringFromFile(java.lang.String):java.lang.String");
    }

    public static void writeToFile(String str, String str2, boolean z) {
        FileWriter fileWriter;
        boolean z2;
        synchronized (LogFileUtil.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                LogUtil.i(WBAgent.TAG, "filePath:" + str);
                if (str2 != null && str2.length() != 0) {
                    StringBuilder sb = new StringBuilder(str2);
                    if (sb.charAt(0) == '[') {
                        sb.replace(0, 1, "");
                    }
                    if (sb.charAt(sb.length() - 1) != ',') {
                        sb.replace(sb.length() - 1, sb.length(), ",");
                    }
                    File file = new File(str);
                    try {
                        File parentFile = file.getParentFile();
                        if (!parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        if (file.exists()) {
                            z2 = z;
                            if (file.lastModified() > 0) {
                                z2 = z;
                                if (System.currentTimeMillis() - file.lastModified() > 86400000) {
                                    z2 = false;
                                }
                            }
                        } else {
                            file.createNewFile();
                            z2 = z;
                        }
                        fileWriter = new FileWriter(file, z2);
                    } catch (IOException e) {
                        fileWriter = null;
                    } catch (Throwable th) {
                        th = th;
                        fileWriter = null;
                    }
                    try {
                        fileWriter.write(sb.toString());
                        fileWriter.flush();
                    } catch (IOException e2) {
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e3) {
                                e = e3;
                                e.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                    try {
                        fileWriter.close();
                    } catch (IOException e5) {
                        e = e5;
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
