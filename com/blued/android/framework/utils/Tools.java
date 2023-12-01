package com.blued.android.framework.utils;

import android.app.Activity;
import android.os.Environment;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/Tools.class */
public class Tools {
    public static String a() {
        File externalStoragePublicDirectory = b() ? Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) : AppInfo.d().getFilesDir();
        if (externalStoragePublicDirectory != null) {
            File file = new File(externalStoragePublicDirectory.getAbsolutePath(), "blued");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        }
        return "";
    }

    public static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(Activity activity) {
        return (activity == null || activity == null || activity.isFinishing()) ? false : true;
    }

    public static boolean a(Fragment fragment) {
        if (fragment == null || !fragment.isAdded()) {
            return false;
        }
        return a((Activity) fragment.getActivity());
    }

    public static boolean b() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
