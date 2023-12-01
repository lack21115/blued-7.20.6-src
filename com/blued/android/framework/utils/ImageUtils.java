package com.blued.android.framework.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.R;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/ImageUtils.class */
public class ImageUtils {
    private ImageUtils() {
    }

    private static int a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        while (true) {
            int i6 = i5;
            if (i3 <= i2 && i4 <= i) {
                return i6;
            }
            i3 >>= 1;
            i4 >>= 1;
            i5 = i6 << 1;
        }
    }

    public static Bitmap a(int i, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        Resources resources = AppUtils.a().getResources();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = a(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    public static Bitmap a(File file) {
        if (file == null) {
            return null;
        }
        return BitmapFactory.decodeFile(file.getAbsolutePath());
    }

    public static Bitmap a(File file, int i, int i2) {
        if (file == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        options.inSampleSize = a(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
    }

    private static File a(String str) {
        if (StringUtils.b(str)) {
            return null;
        }
        return new File(str);
    }

    public static void a(Bitmap bitmap) {
        a(bitmap, 100);
    }

    public static void a(Bitmap bitmap, int i) {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            a(bitmap, externalStoragePublicDirectory.getAbsolutePath() + File.separator + "blued", i);
        }
    }

    public static void a(Bitmap bitmap, String str, int i) {
        a(bitmap, str, i, true);
    }

    public static void a(Bitmap bitmap, String str, int i, boolean z) {
        if (bitmap == null) {
            return;
        }
        String str2 = System.currentTimeMillis() + ".jpg";
        if ("mounted".equals(Environment.getExternalStorageState())) {
            String str3 = str;
            if (str == null) {
                File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                str3 = externalStoragePublicDirectory.getAbsolutePath() + File.separator + "blued";
            }
            String str4 = str3 + File.separator + str2;
            if (Build.VERSION.SDK_INT < 29 || Environment.isExternalStorageLegacy()) {
                b(bitmap, str4, i, false);
                AppUtils.a(AppInfo.d(), str4, z);
                return;
            }
            a(bitmap, str2, Environment.DIRECTORY_PICTURES + "/blued", i, false);
            if (z) {
                AppMethods.a((CharSequence) (AppInfo.d().getString(R.string.pic_save) + str4));
            }
        }
    }

    public static void a(Bitmap bitmap, String str, String str2, int i, boolean z) {
        Uri uri;
        ContentValues contentValues = new ContentValues();
        contentValues.put("description", "Blued image");
        contentValues.put("_display_name", str);
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put("title", str);
        contentValues.put("relative_path", str2);
        ContentResolver contentResolver = AppInfo.d().getContentResolver();
        try {
            uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
            uri = null;
        }
        Uri uri2 = uri;
        if (uri == null) {
            try {
                uri2 = contentResolver.insert(MediaStore.Images.Media.INTERNAL_CONTENT_URI, contentValues);
            } catch (Exception e2) {
                e2.printStackTrace();
                uri2 = uri;
            }
        }
        if (uri2 != null) {
            try {
                try {
                    if (bitmap != null) {
                        try {
                            OutputStream openOutputStream = contentResolver.openOutputStream(uri2);
                            if (openOutputStream != null) {
                                bitmap.compress(Bitmap.CompressFormat.JPEG, i, openOutputStream);
                                openOutputStream.flush();
                                openOutputStream.close();
                            }
                            if (z) {
                                bitmap.recycle();
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            if (z) {
                                bitmap.recycle();
                            }
                        }
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } catch (Throwable th) {
                if (z) {
                    try {
                        bitmap.recycle();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    public static boolean a(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, boolean z) {
        BufferedOutputStream bufferedOutputStream;
        boolean z2 = false;
        if (b(bitmap) || !b(file)) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                try {
                    BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        boolean compress = bitmap.compress(compressFormat, 100, bufferedOutputStream3);
                        if (z && !bitmap.isRecycled()) {
                            z2 = compress;
                            bitmap.recycle();
                        }
                        bufferedOutputStream3.close();
                        return compress;
                    } catch (IOException e) {
                        bufferedOutputStream = bufferedOutputStream3;
                        e = e;
                        e.printStackTrace();
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        return z2;
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream2 = bufferedOutputStream3;
                        if (bufferedOutputStream2 != null) {
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    z2 = false;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
            return z;
        }
    }

    public static boolean a(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        return a(bitmap, a(str), compressFormat, false);
    }

    private static boolean b(Bitmap bitmap) {
        return bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0;
    }

    private static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if ((!file.exists() || file.delete()) && c(file.getParentFile())) {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static byte[] b(Bitmap bitmap, String str, int i) {
        return b(bitmap, str, i, false);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0040 -> B:24:0x007c). Please submit an issue!!! */
    public static byte[] b(Bitmap bitmap, String str, int i, boolean z) {
        FileUtils.a(str, true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                    FileOutputStream fileOutputStream = new FileOutputStream(str);
                    fileOutputStream.write(byteArrayOutputStream.toByteArray());
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    if (z) {
                        bitmap.recycle();
                    }
                } catch (Throwable th) {
                    if (z) {
                        try {
                            bitmap.recycle();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                Log.v("ddrb", " compressBmpToFile = " + e2.toString());
                if (z) {
                    bitmap.recycle();
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static boolean c(File file) {
        if (file != null) {
            return file.exists() ? file.isDirectory() : file.mkdirs();
        }
        return false;
    }
}
