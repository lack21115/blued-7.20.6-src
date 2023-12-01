package com.soft.blued.ui.photo.camera.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/camera/utils/CameraImageUtils.class */
public class CameraImageUtils {
    public static Bitmap a(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        options.inInputShareable = true;
        return BitmapFactory.decodeStream(AppInfo.d().getResources().openRawResource(i), null, options);
    }

    public static Bitmap a(String str, float f) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        int width = decodeFile.getWidth();
        Bitmap createBitmap = Bitmap.createBitmap(width, (int) (width / f), Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        new Canvas(createBitmap).drawBitmap(decodeFile, new Matrix(), paint);
        decodeFile.recycle();
        return createBitmap;
    }

    public static File a(Bitmap bitmap, String str) {
        File file = new File(str);
        if (bitmap == null) {
            return file;
        }
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            return file;
        } catch (Exception e) {
            return file;
        }
    }

    public static File a(byte[] bArr, String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsoluteFile());
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return file;
        }
    }

    public static void a(String str) {
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            Random random = new Random();
            long currentTimeMillis = System.currentTimeMillis();
            int nextInt = random.nextInt(10000);
            String a2 = HMACUtils.a(UserInfo.getInstance().getLoginUserInfo().getUid() + ":" + AppInfo.b + ":" + BluedDeviceIdentity.a().f() + ":" + currentTimeMillis, String.valueOf(nextInt));
            exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_USER_COMMENT, "{\"t\":\"" + currentTimeMillis + "\",\"r\":\"" + nextInt + "\",\"h\":\"" + a2 + "\"}");
            exifInterface.saveAttributes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
