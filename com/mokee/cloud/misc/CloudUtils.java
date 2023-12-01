package com.mokee.cloud.misc;

import android.os.SystemProperties;
import com.mokee.os.Build;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/cloud/misc/CloudUtils.class */
public class CloudUtils {
    public static final String TAG = null;
    private static final String[] a = null;
    public static boolean b;

    static {
        String[] strArr = new String[12];
        throw new VerifyError("bad dex opcode");
    }

    public static String formatNumber(String str) {
        return str.replaceAll(a[0], "");
    }

    public static String getInfoFromResult(String str) {
        byte b2 = 1;
        try {
            String[] split = new JSONObject(str.substring(5, str.length() - 1)).getString(a[4]).split("：");
            try {
                if (split.length <= 1) {
                    b2 = 0;
                }
                return split[b2 == 1 ? 1 : 0];
            } catch (JSONException e) {
                throw e;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean hasAccessPermission() {
        return Build.MOD_VERSION.startsWith(a[5]) && Build.VERSION.startsWith(a[8]) && SystemProperties.get(a[7]).equals(a[6]);
    }

    public static boolean inBlackList() {
        return android.os.Build.DISPLAY.contains(a[3]) || android.os.Build.USER.contains(a[1]) || android.os.Build.HOST.contains(a[2]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean inContactList(android.content.ContentResolver r7, java.lang.String r8) {
        /*
            java.lang.String[] r0 = com.mokee.cloud.misc.CloudUtils.a
            r1 = 9
            r0 = r0[r1]
            r10 = r0
            android.net.Uri r0 = android.provider.ContactsContract.PhoneLookup.CONTENT_FILTER_URI
            r1 = r8
            java.lang.String r1 = android.net.Uri.encode(r1)
            android.net.Uri r0 = android.net.Uri.withAppendedPath(r0, r1)
            r8 = r0
            r0 = r7
            r1 = r8
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Exception -> L40 java.lang.Throwable -> L62
            r3 = r2
            r4 = 0
            r5 = r10
            r3[r4] = r5     // Catch: java.lang.Exception -> L40 java.lang.Throwable -> L62
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L40 java.lang.Throwable -> L62
            r8 = r0
            r0 = r8
            r7 = r0
            r0 = r8
            int r0 = r0.getCount()     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> L88
            r9 = r0
            r0 = r9
            r1 = 1
            if (r0 <= r1) goto L74
            r0 = r8
            if (r0 == 0) goto L3b
            r0 = r8
            r0.close()     // Catch: java.lang.Exception -> L3d
        L3b:
            r0 = 1
            return r0
        L3d:
            r7 = move-exception
            r0 = r7
            throw r0
        L40:
            r10 = move-exception
            r0 = 0
            r8 = r0
        L43:
            r0 = r8
            r7 = r0
            java.lang.String[] r0 = com.mokee.cloud.misc.CloudUtils.a     // Catch: java.lang.Throwable -> L84
            r1 = 10
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L84
            java.lang.String[] r1 = com.mokee.cloud.misc.CloudUtils.a     // Catch: java.lang.Throwable -> L84
            r2 = 11
            r1 = r1[r2]     // Catch: java.lang.Throwable -> L84
            r2 = r10
            int r0 = android.util.Log.e(r0, r1, r2)     // Catch: java.lang.Throwable -> L84
            r0 = r8
            if (r0 == 0) goto L60
            r0 = r8
            r0.close()
        L60:
            r0 = 0
            return r0
        L62:
            r8 = move-exception
            r0 = 0
            r7 = r0
        L65:
            r0 = r7
            if (r0 == 0) goto L6f
            r0 = r7
            r0.close()     // Catch: java.lang.Exception -> L71
        L6f:
            r0 = r8
            throw r0
        L71:
            r7 = move-exception
            r0 = r7
            throw r0
        L74:
            r0 = r8
            if (r0 == 0) goto L60
            r0 = r8
            r0.close()     // Catch: java.lang.Exception -> L81
            goto L60
        L81:
            r7 = move-exception
            r0 = r7
            throw r0
        L84:
            r8 = move-exception
            goto L65
        L88:
            r10 = move-exception
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.cloud.misc.CloudUtils.inContactList(android.content.ContentResolver, java.lang.String):boolean");
    }
}
