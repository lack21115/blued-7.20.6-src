package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/Logger.class */
public class Logger {
    private static boolean sDisablePushLog = false;
    private static LoggerInterface sUserLogger;

    public static void disablePushFileLog(Context context) {
        sDisablePushLog = true;
        setPushLog(context);
    }

    public static void enablePushFileLog(Context context) {
        sDisablePushLog = false;
        setPushLog(context);
    }

    @Deprecated
    public static File getLogFile(String str) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static LoggerInterface getUserLogger() {
        return sUserLogger;
    }

    private static boolean hasWritePermission(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr == null) {
                return false;
            }
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(strArr[i2])) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static void setLogger(Context context, LoggerInterface loggerInterface) {
        sUserLogger = loggerInterface;
        setPushLog(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void setPushLog(android.content.Context r5) {
        /*
            com.xiaomi.channel.commonutils.logger.LoggerInterface r0 = com.xiaomi.mipush.sdk.Logger.sUserLogger
            r10 = r0
            r0 = 1
            r8 = r0
            r0 = 0
            r7 = r0
            r0 = r10
            if (r0 == 0) goto L13
            r0 = 1
            r6 = r0
            goto L15
        L13:
            r0 = 0
            r6 = r0
        L15:
            boolean r0 = com.xiaomi.mipush.sdk.Logger.sDisablePushLog
            if (r0 == 0) goto L1e
            goto L30
        L1e:
            r0 = r5
            boolean r0 = hasWritePermission(r0)
            r9 = r0
            r0 = r6
            r7 = r0
            r0 = r9
            if (r0 == 0) goto L30
            r0 = r8
            r7 = r0
            goto L36
        L30:
            r0 = 0
            r8 = r0
            r0 = r7
            r6 = r0
            r0 = r8
            r7 = r0
        L36:
            r0 = 0
            r11 = r0
            r0 = r6
            if (r0 == 0) goto L45
            com.xiaomi.channel.commonutils.logger.LoggerInterface r0 = com.xiaomi.mipush.sdk.Logger.sUserLogger
            r10 = r0
            goto L48
        L45:
            r0 = 0
            r10 = r0
        L48:
            r0 = r7
            if (r0 == 0) goto L52
            r0 = r5
            com.xiaomi.push.dh r0 = com.xiaomi.push.dh.a(r0)
            r11 = r0
        L52:
            com.xiaomi.push.dg r0 = new com.xiaomi.push.dg
            r1 = r0
            r2 = r10
            r3 = r11
            r1.<init>(r2, r3)
            com.xiaomi.channel.commonutils.logger.b.a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.Logger.setPushLog(android.content.Context):void");
    }

    @Deprecated
    public static void uploadLogFile(Context context, boolean z) {
    }
}
