package com.tencent.cloud.huiyansdkface.normal.tools;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.anythink.china.common.a.a;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.cloud.huiyansdkface.normal.thread.ThreadOperate;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/normal/tools/WLogger.class */
public class WLogger {
    private static boolean isEnable;
    private static File mLocalFile;
    private static LogInterface mLog;
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS");
    private static String mName = "empty";
    private static String mLocalLogName = "";

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/normal/tools/WLogger$LogInterface.class */
    public interface LogInterface {
        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void v(String str, String str2);

        void w(String str, String str2);
    }

    private static String buildMessage(String str, String str2, Throwable th) {
        String str3 = mLocalLogName;
        if (str3 != null && !"".equals(str3) && isEnable) {
            StackTraceElement stackTraceElement = new Throwable().fillInStackTrace().getStackTrace()[2];
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(stackTraceElement.getClassName());
            stringBuffer.append(".");
            stringBuffer.append(stackTraceElement.getMethodName());
            stringBuffer.append("(");
            stringBuffer.append(stackTraceElement.getFileName());
            stringBuffer.append(": ");
            stringBuffer.append(stackTraceElement.getLineNumber());
            stringBuffer.append(")");
            stringBuffer.append(" : ");
            stringBuffer.append(str2);
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(dateFormat.format(new Date()));
            stringBuffer2.append("    ");
            stringBuffer2.append("    ");
            stringBuffer2.append(str);
            stringBuffer2.append("    ");
            stringBuffer2.append(stringBuffer);
            if (th != null) {
                stringBuffer2.append(System.getProperty("line.separator"));
                stringBuffer2.append(Log.getStackTraceString(th));
            }
            save2File(stringBuffer2.toString());
        }
        return str2;
    }

    public static void d(String str, String str2) {
        LogInterface logInterface = mLog;
        if (logInterface != null) {
            logInterface.d(str, str2);
        } else if (isEnable) {
            Log.d(mName + BridgeUtil.UNDERLINE_STR + str, buildMessage(str, str2, null));
        }
    }

    public static void e(String str, String str2) {
        LogInterface logInterface = mLog;
        if (logInterface != null) {
            logInterface.e(str, str2);
        } else if (isEnable) {
            Log.e(mName + BridgeUtil.UNDERLINE_STR + str, buildMessage(str, str2, null));
        }
    }

    protected static File getLogFile(Context context, String str) {
        if (context == null) {
            return null;
        }
        String str2 = context.getExternalCacheDir() + File.separator + "TxCloudHuiyanSdkFaceLog";
        String str3 = str2;
        if (context.getApplicationInfo() != null) {
            int i = context.getApplicationInfo().targetSdkVersion;
            str3 = str2;
            if (i > 13) {
                str3 = str2;
                if (i < 29) {
                    str3 = Environment.getExternalStorageDirectory() + File.separator + "TxCloudHuiyanSdkFaceLog";
                }
            }
        }
        File file = new File(str3 + File.separator + str);
        if (file.exists() || file.mkdirs()) {
            File file2 = new File(file.getPath() + File.separator + (dateFormat.format(new Date()) + a.f));
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                    return file2;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return file2;
        }
        return null;
    }

    @Deprecated
    protected static File getLogFile(String str) {
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "TxCloudHuiyanSdkFaceLog" + File.separator + str);
        if (file.exists() || file.mkdirs()) {
            File file2 = new File(file.getPath() + File.separator + (dateFormat.format(new Date()) + a.f));
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                    return file2;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return file2;
        }
        return null;
    }

    public static void i(String str) {
        LogInterface logInterface = mLog;
        if (logInterface != null) {
            logInterface.i(mName, str);
        } else {
            i("", str);
        }
    }

    public static void i(String str, Object obj) {
        LogInterface logInterface = mLog;
        if (logInterface != null) {
            logInterface.i(mName, obj.toString());
        } else if (isEnable) {
            try {
                Log.i(str, buildMessage(str, new WeJson().toJson(obj), null));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void i(String str, String str2) {
        LogInterface logInterface = mLog;
        if (logInterface != null) {
            logInterface.i(str, str2);
        } else if (isEnable) {
            Log.i(mName + BridgeUtil.UNDERLINE_STR + str, buildMessage(str, str2, null));
        }
    }

    public static void localLogFileName(Context context, String str) {
        mLocalLogName = str;
        mLocalFile = getLogFile(context, str);
    }

    @Deprecated
    public static void localLogFileName(String str) {
        mLocalLogName = str;
        mLocalFile = getLogFile(str);
    }

    private static void save2File(String str) {
        File file = mLocalFile;
        if (file != null) {
            writeFile(file, str);
        }
    }

    public static void setEnable(boolean z, String str) {
        isEnable = z;
        mName = str;
    }

    public static void setILog(LogInterface logInterface) {
        mLog = logInterface;
    }

    public static void v(String str, String str2) {
        LogInterface logInterface = mLog;
        if (logInterface != null) {
            logInterface.v(str, str2);
        } else if (isEnable) {
            Log.v(mName + BridgeUtil.UNDERLINE_STR + str, buildMessage(str, str2, null));
        }
    }

    public static void w(String str, String str2) {
        LogInterface logInterface = mLog;
        if (logInterface != null) {
            logInterface.w(str, str2);
        } else if (isEnable) {
            Log.w(mName + BridgeUtil.UNDERLINE_STR + str, buildMessage(str, str2, null));
        }
    }

    protected static void writeFile(final File file, final String str) {
        ThreadOperate.runOnSubThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.normal.tools.WLogger.1
            /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r9 = this;
                    java.io.PrintWriter r0 = new java.io.PrintWriter     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L38
                    r1 = r0
                    java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L38
                    r3 = r2
                    java.io.FileWriter r4 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L38
                    r5 = r4
                    r6 = r9
                    java.io.File r6 = java.io.File.this     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L38
                    r7 = 1
                    r5.<init>(r6, r7)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L38
                    r3.<init>(r4)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L38
                    r1.<init>(r2)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L38
                    r10 = r0
                    r0 = r10
                    r11 = r0
                    r0 = r10
                    r1 = r9
                    java.lang.String r1 = r5     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L4a
                    r0.println(r1)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L4a
                    r0 = r10
                    r11 = r0
                    r0 = r10
                    r0.flush()     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L4a
                    goto L45
                L2e:
                    r12 = move-exception
                    goto L3b
                L32:
                    r10 = move-exception
                    r0 = 0
                    r11 = r0
                    goto L4b
                L38:
                    r12 = move-exception
                    r0 = 0
                    r10 = r0
                L3b:
                    r0 = r10
                    r11 = r0
                    r0 = r12
                    r0.printStackTrace()     // Catch: java.lang.Throwable -> L4a
                    r0 = r10
                    if (r0 == 0) goto L49
                L45:
                    r0 = r10
                    r0.close()
                L49:
                    return
                L4a:
                    r10 = move-exception
                L4b:
                    r0 = r11
                    if (r0 == 0) goto L53
                    r0 = r11
                    r0.close()
                L53:
                    r0 = r10
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.normal.tools.WLogger.AnonymousClass1.run():void");
            }
        });
    }
}
