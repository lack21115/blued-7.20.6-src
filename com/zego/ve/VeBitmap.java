package com.zego.ve;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: source-8829756-dex2jar.jar:com/zego/ve/VeBitmap.class */
public class VeBitmap {
    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        int i6 = 1;
        if (i3 > i2 || i4 > i) {
            int i7 = i3 / 2;
            int i8 = i4 / 2;
            while (true) {
                i5 = i6;
                if (i7 / i6 < i2) {
                    break;
                }
                i5 = i6;
                if (i8 / i6 < i) {
                    break;
                }
                i6 *= 2;
            }
        }
        return i5;
    }

    public static Bitmap createBitmapRGBA(int i, int i2) {
        return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
    }

    public static Bitmap getBitmap(Context context, int i, int i2, String str) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            return null;
        }
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(indexOf + 1, str.length());
        if (substring.compareTo("asset") == 0) {
            return getBitmapFromAsset(context, substring2);
        }
        if (substring.compareTo(ContentResolver.SCHEME_FILE) == 0) {
            return getBitmapFromPath(context, i, i2, substring2);
        }
        if (substring.compareTo("content") == 0) {
            return getBitmapFromUri(context, i, i2, str);
        }
        return null;
    }

    public static Bitmap getBitmapFromAsset(Context context, String str) {
        try {
            return BitmapFactory.decodeStream(context.getAssets().open(str));
        } catch (IOException e) {
            return null;
        }
    }

    public static Bitmap getBitmapFromPath(Context context, int i, int i2, String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap getBitmapFromUri(Context context, int i, int i2, String str) {
        Uri parse = Uri.parse(str);
        Bitmap bitmap = null;
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(parse, "r");
            FileDescriptor fileDescriptor = openFileDescriptor.getFileDescriptor();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            options.inJustDecodeBounds = false;
            options.inSampleSize = calculateInSampleSize(options, i, i2);
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            bitmap = decodeFileDescriptor;
            openFileDescriptor.close();
            return decodeFileDescriptor;
        } catch (IOException e) {
            e.printStackTrace();
            return bitmap;
        }
    }

    public static int saveBitmap(Bitmap bitmap) {
        File file = new File("/sdcard/", "snapshot-" + SystemClock.uptimeMillis() + ".jpg");
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
