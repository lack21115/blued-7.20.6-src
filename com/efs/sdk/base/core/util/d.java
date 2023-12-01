package com.efs.sdk.base.core.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.UUID;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/util/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f21797a = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(f21797a)) {
            synchronized (d.class) {
                try {
                    if (TextUtils.isEmpty(f21797a)) {
                        String b = b(context);
                        f21797a = b;
                        if (TextUtils.isEmpty(b)) {
                            f21797a = c(context);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f21797a;
    }

    private static String b(Context context) {
        try {
            File file = new File(a.a(context), "efsid");
            if (file.exists()) {
                return b.a(file);
            }
            return null;
        } catch (Exception e) {
            Log.e("efs.base", "get uuid error", e);
            return null;
        }
    }

    private static String c(Context context) {
        String str;
        String uuid;
        String str2 = "";
        int i = 0;
        while (true) {
            str = str2;
            if (i < 3) {
                String str3 = str2;
                try {
                    uuid = UUID.randomUUID().toString();
                    str3 = uuid;
                } catch (Throwable th) {
                }
                if (!TextUtils.isEmpty(uuid)) {
                    str = uuid;
                    break;
                }
                i++;
                str2 = str3;
            }
        }
        try {
            File a2 = a.a(context);
            File file = new File(a2, "efsid" + Process.myPid());
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            b.a(file, str);
            if (file.renameTo(new File(a2, "efsid"))) {
                file.delete();
                return str;
            }
        } catch (Exception e) {
            Log.e("efs.base", "save uuid '" + str + "' error", e);
        }
        return str;
    }
}
