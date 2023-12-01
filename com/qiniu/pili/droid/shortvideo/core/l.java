package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/l.class */
public class l {
    static {
        System.loadLibrary("pldroid_shortvideo_core");
    }

    public static String a(Context context, String str) {
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return file.getAbsolutePath();
        }
        File file2 = file;
        if (!parentFile.mkdirs()) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.f13984a;
            eVar.e("ShortVideoCore", "failed to mkdirs: " + parentFile + " use default: " + context.getFilesDir());
            file2 = new File(context.getFilesDir(), file.getName());
        }
        return file2.getAbsolutePath();
    }

    public static void a(Context context) {
        com.qiniu.pili.droid.shortvideo.f.e.b.b(com.qiniu.pili.droid.shortvideo.f.j.j(context));
        u.a().a(context);
        QosManager.a().b(context);
        com.qiniu.pili.droid.crash.c.a(context);
    }
}
