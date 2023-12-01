package com.huawei.openalliance.ad.utils;

import android.content.Context;
import com.huawei.hms.ads.base.R;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/h.class */
public class h {
    private static final String Code = "CNStrUtil";

    private static String Code(long j) {
        float f = (((float) j) * 1.0f) / 1048576.0f;
        float f2 = f;
        if (f < 0.1f) {
            f2 = 0.1f;
        }
        return String.format(Locale.getDefault(), "%.1f", Float.valueOf(f2));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String Code(android.content.Context r5, int r6, java.lang.String r7, java.lang.Object... r8) {
        /*
            r0 = r5
            android.content.res.Resources r0 = r0.getResources()
            r12 = r0
            r0 = 0
            r11 = r0
            r0 = r11
            r10 = r0
            r0 = r5
            com.huawei.hms.ads.ee r0 = com.huawei.hms.ads.dt.Code(r0)     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            boolean r0 = r0.Code()     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            if (r0 == 0) goto L96
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            r10 = r0
            r0 = r10
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            r0 = r10
            java.lang.String r1 = "_zh"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            r0 = r12
            r1 = r10
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            java.lang.String r2 = "string"
            r3 = r5
            java.lang.String r3 = r3.getPackageName()     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            int r0 = r0.getIdentifier(r1, r2, r3)     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            r9 = r0
            r0 = r8
            if (r0 == 0) goto L53
            r0 = r12
            r1 = r9
            r2 = r8
            java.lang.String r0 = r0.getString(r1, r2)     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            r5 = r0
            goto L5b
        L53:
            r0 = r12
            r1 = r9
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            r5 = r0
        L5b:
            r0 = r5
            r10 = r0
            goto L96
        L61:
            r5 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            goto L76
        L6d:
            r5 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
        L76:
            r0 = r7
            java.lang.String r1 = "getChinaString "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r5
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getSimpleName()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "CNStrUtil"
            r1 = r7
            java.lang.String r1 = r1.toString()
            com.huawei.hms.ads.ge.Z(r0, r1)
            r0 = r11
            r10 = r0
        L96:
            r0 = r10
            r5 = r0
            r0 = r10
            if (r0 != 0) goto Lb6
            r0 = r8
            if (r0 == 0) goto Laf
            r0 = r8
            int r0 = r0.length
            if (r0 <= 0) goto Laf
            r0 = r12
            r1 = r6
            r2 = r8
            java.lang.String r0 = r0.getString(r1, r2)
            return r0
        Laf:
            r0 = r12
            r1 = r6
            java.lang.String r0 = r0.getString(r1)
            r5 = r0
        Lb6:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.h.Code(android.content.Context, int, java.lang.String, java.lang.Object[]):java.lang.String");
    }

    public static String Code(Context context, long j) {
        if (context == null) {
            return "";
        }
        return context.getString(R.string.hiad_data_size_prompt, Code(j));
    }
}
