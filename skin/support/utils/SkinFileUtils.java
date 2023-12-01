package skin.support.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* loaded from: source-3503164-dex2jar.jar:skin/support/utils/SkinFileUtils.class */
public class SkinFileUtils {
    public static String a(Context context) {
        File file = new File(b(context), "skins");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    private static String b(Context context) {
        File externalCacheDir;
        return (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) && (externalCacheDir = context.getExternalCacheDir()) != null && (externalCacheDir.exists() || externalCacheDir.mkdirs())) ? externalCacheDir.getAbsolutePath() : context.getCacheDir().getAbsolutePath();
    }
}
