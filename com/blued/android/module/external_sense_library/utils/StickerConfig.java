package com.blued.android.module.external_sense_library.utils;

import android.content.Context;
import java.io.File;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/utils/StickerConfig.class */
public class StickerConfig {

    /* renamed from: a  reason: collision with root package name */
    private static String f11325a;

    public static String a() {
        return f11325a + "sticker" + File.separator;
    }

    public static String a(String str) {
        return f11325a + "sticker" + File.separator + str + ".zip";
    }

    public static void a(Context context) {
        f11325a = context.getExternalFilesDir(null) + File.separator;
    }

    public static String b() {
        return f11325a + "temp" + File.separator;
    }

    public static String b(String str) {
        return f11325a + "temp" + File.separator + str + ".zip";
    }
}
