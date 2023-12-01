package com.sobot.chat.camera.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import com.sobot.chat.utils.IOUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SobotPathManager;
import com.sobot.chat.utils.ToastUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/util/FileUtil.class */
public class FileUtil {
    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static String getFileEndWith(String str) {
        return str.indexOf(".") != -1 ? str.substring(str.lastIndexOf(".") - 1) : "";
    }

    public static boolean isExternalStorageWritable() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    public static String saveBitmap(int i, Bitmap bitmap) {
        String picDir = SobotPathManager.getInstance().getPicDir();
        IOUtils.createFolder(picDir);
        String str = picDir + "pic_" + System.currentTimeMillis() + ".jpg";
        try {
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, bufferedOutputStream);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                return str;
            } catch (Exception e) {
                e.printStackTrace();
                if (bitmap == null || bitmap.isRecycled()) {
                    return "";
                }
                bitmap.recycle();
                return "";
            }
        } catch (Throwable th) {
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            throw th;
        }
    }

    public static String saveImageFile(Context context, Uri uri, String str, String str2) throws Exception {
        if (uri == null) {
            return str2;
        }
        FileInputStream fileInputStream = new FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor());
        String picDir = SobotPathManager.getInstance().getPicDir();
        IOUtils.createFolder(picDir);
        String str3 = picDir + str;
        if (IOUtils.copyFileWithStream(new FileOutputStream(str3), fileInputStream)) {
            return str3;
        }
        ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_pic_type_error"));
        return str2;
    }
}
