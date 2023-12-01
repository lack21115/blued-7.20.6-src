package com.blued.android.module.shortvideo.utils;

import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Md5;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvTools.class */
public class StvTools {
    public static String a() {
        return d("autn_");
    }

    public static String a(String str) {
        File externalFilesDir = AppInfo.d().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir != null) {
            File file = new File(externalFilesDir, "Pictures");
            if (file.exists() || file.mkdirs()) {
                File file2 = new File(file, "temp_" + str.toLowerCase().trim());
                if (!file2.exists()) {
                    file2.mkdir();
                }
                return file2.getAbsolutePath();
            }
        }
        File filesDir = AppInfo.d().getFilesDir();
        if (filesDir != null) {
            File file3 = new File(filesDir, "Pictures");
            if (file3.exists() || file3.mkdirs()) {
                File file4 = new File(file3, "temp_" + str.toLowerCase().trim());
                if (!file3.exists()) {
                    file3.mkdir();
                }
                return file4.getAbsolutePath();
            }
            return null;
        }
        return null;
    }

    public static byte[] a(Bitmap bitmap, String str, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            Log.v("drb", "baos.size() = " + byteArrayOutputStream.size());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String b() {
        return d("record_");
    }

    public static String b(String str) {
        File externalFilesDir = AppInfo.d().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir != null) {
            File file = new File(externalFilesDir, "Pictures");
            c(file.getAbsolutePath());
            if (file.exists() || file.mkdirs()) {
                return new File(file, "temp_" + System.currentTimeMillis() + BridgeUtil.UNDERLINE_STR + Md5.a(str.toLowerCase().trim()) + ".jpg").getAbsolutePath();
            }
        }
        File filesDir = AppInfo.d().getFilesDir();
        if (filesDir != null) {
            File file2 = new File(filesDir, "Pictures");
            c(file2.getAbsolutePath());
            if (file2.exists() || file2.mkdirs()) {
                return new File(file2, "temp_" + System.currentTimeMillis() + BridgeUtil.UNDERLINE_STR + Md5.a(str.toLowerCase().trim()) + ".jpg").getAbsolutePath();
            }
            return null;
        }
        return null;
    }

    public static String c() {
        return d("edited_");
    }

    public static void c(String str) {
        File file = new File(str);
        File file2 = new File(str, MediaStore.MEDIA_IGNORE_FILENAME);
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!file2.exists()) {
                file2.createNewFile();
                fileOutputStream2 = new FileOutputStream(file2);
                try {
                    fileOutputStream2.flush();
                } catch (Exception e) {
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    return;
                } catch (Throwable th) {
                    fileOutputStream = fileOutputStream2;
                    th = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } catch (Exception e5) {
            fileOutputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String d() {
        return d("trimmed_");
    }

    private static String d(String str) {
        String str2;
        return (StvConfig.b() + str + System.currentTimeMillis() + BridgeUtil.UNDERLINE_STR) + Md5.a(str2.toLowerCase().trim()) + ".mp4";
    }

    public static String e() {
        return d("transcoder_");
    }
}
