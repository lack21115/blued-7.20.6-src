package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/MtmV0.class */
public final class MtmV0 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39895a = kC0XR.a(kC0XR.A0);
    public static final String b = kC0XR.a(kC0XR.B0);

    /* renamed from: c  reason: collision with root package name */
    public static boolean f39896c = false;

    public static String a(Context context) {
        File dir = context.getDir(f39895a, 0);
        if (dir == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dir.getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append("1");
        File file = new File(sb.toString());
        if (file.exists() || file.mkdirs()) {
            return file.getAbsolutePath() + str + b;
        }
        return "";
    }

    public static void a(Context context, fenkF fenkf) {
        try {
            if (f39896c) {
                return;
            }
            f39896c = true;
            long a2 = fenkf.a(context, "502");
            int myUid = Process.myUid();
            if (a2 == 0 || myUid == 0 || myUid == a2) {
                return;
            }
            fenkf.a(context, "101", "", true);
            fenkf.b(context, 0L);
            HashMap hashMap = new HashMap();
            hashMap.put("901", "");
            fenkF.a(context, hashMap);
            new File(a(context)).delete();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
