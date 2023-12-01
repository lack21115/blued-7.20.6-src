package com.blued.android.module.shortvideo.view;

import android.graphics.Bitmap;
import com.blued.android.module.shortvideo.utils.StvTools;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/StvFileUtils.class */
public class StvFileUtils {
    public static String a(Bitmap bitmap, String str, String str2) {
        if (bitmap == null) {
            return "";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        StvTools.c(file.getAbsolutePath());
        File file2 = new File(file, str2);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file2.getAbsolutePath();
    }
}
