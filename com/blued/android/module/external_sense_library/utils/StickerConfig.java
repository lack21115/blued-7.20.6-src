package com.blued.android.module.external_sense_library.utils;

import android.content.Context;
import java.io.File;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/utils/StickerConfig.class */
public class StickerConfig {
    private static String a;

    public static String a() {
        return a + "sticker" + File.separator;
    }

    public static String a(String str) {
        return a + "sticker" + File.separator + str + ".zip";
    }

    public static void a(Context context) {
        a = context.getExternalFilesDir(null) + File.separator;
    }

    public static String b() {
        return a + "temp" + File.separator;
    }

    public static String b(String str) {
        return a + "temp" + File.separator + str + ".zip";
    }
}
