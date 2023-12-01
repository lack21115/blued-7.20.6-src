package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/p.class */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private static File f38975a;

    public static long a() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockSize() * statFs.getAvailableBlocks();
    }

    public static boolean a(Context context) {
        File tbsFolderDir;
        if (context == null) {
            return false;
        }
        if (f38975a == null) {
            try {
                if (context.getApplicationInfo().processName.contains("com.tencent.mm") && (tbsFolderDir = QbSdk.getTbsFolderDir(context)) != null && tbsFolderDir.isDirectory()) {
                    File file = new File(tbsFolderDir, "share");
                    if (file.isDirectory() || file.mkdir()) {
                        f38975a = file;
                        file.setExecutable(true, false);
                        return true;
                    }
                    return false;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
