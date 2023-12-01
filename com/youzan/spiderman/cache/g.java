package com.youzan.spiderman.cache;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.youzan.spiderman.utils.PermissionUtil;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/cache/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static String f28116a;
    private static boolean b;

    static {
        g.class.getSimpleName();
        f28116a = null;
        b = false;
    }

    public static void a(Context context) {
        File externalFilesDir;
        try {
            if (PermissionUtil.hasExtStroragePermision(context) && Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
                f28116a = externalFilesDir.getAbsolutePath() + File.separator + "spider_porval";
                b = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(f28116a)) {
            f28116a = context.getFilesDir().getAbsolutePath() + File.separator + "spider_porval";
            b = true;
        }
        try {
            a(b());
            a(c());
            a(d());
            a(e());
            a(f());
            a(g());
            a(h());
            a(i());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static boolean a() {
        return b;
    }

    public static String b() {
        return String.format("%s%s%s", f28116a, File.separator, "preload_res");
    }

    public static String c() {
        return String.format("%s%s%s", f28116a, File.separator, DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
    }

    public static String d() {
        return String.format("%s%s%s", f28116a, File.separator, "stream_download_dir");
    }

    public static String e() {
        return String.format("%s%s%s", f28116a, File.separator, "preference_dir");
    }

    public static String f() {
        return String.format("%s%s%s", b(), File.separator, "YZScriptCaches");
    }

    public static String g() {
        return String.format("%s%s%s", b(), File.separator, "YZImageCaches");
    }

    public static String h() {
        return String.format("%s%s%s", b(), File.separator, "YZHtmlContent");
    }

    public static String i() {
        return String.format("%s%s%s", b(), File.separator, "YZHtmlHeader");
    }
}
