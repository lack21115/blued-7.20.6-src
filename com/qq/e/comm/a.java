package com.qq.e.comm;

import android.content.Context;
import android.content.Intent;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/a.class */
public class a {
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e0, code lost:
        com.qq.e.comm.util.GDTLogger.e(java.lang.String.format("Service[%s]需要在AndroidManifest.xml中声明", r0.getName()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0106, code lost:
        r7 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r6) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.a.a(android.content.Context):boolean");
    }

    private static boolean a(Context context, Class<?>... clsArr) {
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= clsArr.length) {
                    return true;
                }
                Intent intent = new Intent();
                intent.setClass(context, clsArr[i2]);
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    GDTLogger.e(String.format("Activity[%s]需要在AndroidManifest.xml中声明", clsArr[i2].getName()));
                    return false;
                }
                i = i2 + 1;
            } catch (Throwable th) {
                GDTLogger.e("检查Activity时发生异常", th);
                return false;
            }
        }
    }
}
