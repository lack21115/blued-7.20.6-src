package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.igexin.push.core.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/utils/ImageUtils.class */
public class ImageUtils {
    private static void delete(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        throw new RuntimeException(String.valueOf(file.getAbsolutePath()) + " doesn't be deleted!");
    }

    private static boolean deleteDependon(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        int i = 1;
        while (!z && i <= 5 && file.isFile()) {
            if (!file.exists()) {
                return z;
            }
            boolean delete = file.delete();
            z = delete;
            if (!delete) {
                i++;
                z = delete;
            }
        }
        return z;
    }

    private static boolean isFileExisted(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    private static boolean isParentExist(File file) {
        File parentFile;
        if (file == null || (parentFile = file.getParentFile()) == null || parentFile.exists()) {
            return false;
        }
        return file.exists() || file.mkdirs();
    }

    public static boolean isWifi(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    private static void makesureFileExist(String str) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists() || !isParentExist(file)) {
            return;
        }
        if (file.exists()) {
            delete(file);
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void revitionImageSize(String str, int i, int i2) throws IOException {
        int i3;
        if (i <= 0) {
            throw new IllegalArgumentException("size must be greater than 0!");
        }
        if (!isFileExisted(str)) {
            String str2 = str;
            if (str == null) {
                str2 = b.l;
            }
            throw new FileNotFoundException(str2);
        } else if (!BitmapHelper.verifyBitmap(str)) {
            throw new IOException("");
        } else {
            FileInputStream fileInputStream = new FileInputStream(str);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(fileInputStream, null, options);
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int i4 = 0;
            while (true) {
                i3 = i4;
                if ((options.outWidth >> i3) <= i && (options.outHeight >> i3) <= i) {
                    break;
                }
                i4 = i3 + 1;
            }
            options.inSampleSize = (int) Math.pow(2.0d, i3);
            options.inJustDecodeBounds = false;
            Bitmap safeDecodeBimtapFile = safeDecodeBimtapFile(str, options);
            if (safeDecodeBimtapFile == null) {
                throw new IOException("Bitmap decode error!");
            }
            deleteDependon(str);
            makesureFileExist(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            if (options.outMimeType == null || !options.outMimeType.contains("png")) {
                safeDecodeBimtapFile.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
            } else {
                safeDecodeBimtapFile.compress(Bitmap.CompressFormat.PNG, i2, fileOutputStream);
            }
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            safeDecodeBimtapFile.recycle();
        }
    }

    private static void revitionImageSizeHD(String str, int i, int i2) throws IOException {
        int i3;
        if (i <= 0) {
            throw new IllegalArgumentException("size must be greater than 0!");
        }
        if (!isFileExisted(str)) {
            String str2 = str;
            if (str == null) {
                str2 = b.l;
            }
            throw new FileNotFoundException(str2);
        } else if (!BitmapHelper.verifyBitmap(str)) {
            throw new IOException("");
        } else {
            int i4 = i * 2;
            FileInputStream fileInputStream = new FileInputStream(str);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(fileInputStream, null, options);
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int i5 = 0;
            while (true) {
                i3 = i5;
                if ((options.outWidth >> i3) <= i4 && (options.outHeight >> i3) <= i4) {
                    break;
                }
                i5 = i3 + 1;
            }
            options.inSampleSize = (int) Math.pow(2.0d, i3);
            options.inJustDecodeBounds = false;
            Bitmap safeDecodeBimtapFile = safeDecodeBimtapFile(str, options);
            if (safeDecodeBimtapFile == null) {
                throw new IOException("Bitmap decode error!");
            }
            deleteDependon(str);
            makesureFileExist(str);
            float width = i / (safeDecodeBimtapFile.getWidth() > safeDecodeBimtapFile.getHeight() ? safeDecodeBimtapFile.getWidth() : safeDecodeBimtapFile.getHeight());
            Bitmap bitmap = safeDecodeBimtapFile;
            if (width < 1.0f) {
                while (true) {
                    try {
                        bitmap = Bitmap.createBitmap((int) (safeDecodeBimtapFile.getWidth() * width), (int) (safeDecodeBimtapFile.getHeight() * width), Bitmap.Config.ARGB_8888);
                        break;
                    } catch (OutOfMemoryError e2) {
                        System.gc();
                        width = (float) (width * 0.8d);
                    }
                }
                if (bitmap == null) {
                    safeDecodeBimtapFile.recycle();
                }
                Canvas canvas = new Canvas(bitmap);
                Matrix matrix = new Matrix();
                matrix.setScale(width, width);
                canvas.drawBitmap(safeDecodeBimtapFile, matrix, new Paint());
                safeDecodeBimtapFile.recycle();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            if (options.outMimeType == null || !options.outMimeType.contains("png")) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
            } else {
                bitmap.compress(Bitmap.CompressFormat.PNG, i2, fileOutputStream);
            }
            try {
                fileOutputStream.close();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            bitmap.recycle();
        }
    }

    public static boolean revitionPostImageSize(Context context, String str) {
        try {
            if (NetworkHelper.isWifiValid(context)) {
                revitionImageSizeHD(str, 1600, 75);
                return true;
            }
            revitionImageSize(str, 1024, 75);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static Bitmap safeDecodeBimtapFile(String str, BitmapFactory.Options options) {
        BitmapFactory.Options options2;
        if (options == null) {
            options2 = new BitmapFactory.Options();
            options2.inSampleSize = 1;
        } else {
            options2 = options;
        }
        FileInputStream fileInputStream = null;
        Bitmap bitmap = null;
        for (int i = 0; i < 5; i++) {
            Bitmap bitmap2 = bitmap;
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(str);
                    Bitmap bitmap3 = bitmap;
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream2, null, options);
                        try {
                            fileInputStream2.close();
                            return decodeStream;
                        } catch (IOException e) {
                            bitmap3 = decodeStream;
                            bitmap2 = decodeStream;
                            e.printStackTrace();
                            return decodeStream;
                        }
                    } catch (OutOfMemoryError e2) {
                        e = e2;
                        bitmap = bitmap3;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        options2.inSampleSize *= 2;
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (OutOfMemoryError e4) {
                    e = e4;
                }
            } catch (FileNotFoundException e5) {
                return bitmap2;
            }
        }
        return bitmap;
    }
}
