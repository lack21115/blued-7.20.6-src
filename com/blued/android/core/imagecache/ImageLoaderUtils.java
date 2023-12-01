package com.blued.android.core.imagecache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.blued.android.core.AppInfo;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/ImageLoaderUtils.class */
public class ImageLoaderUtils {
    public static boolean a = false;
    public static String b;
    public static String c;

    /* renamed from: com.blued.android.core.imagecache.ImageLoaderUtils$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/ImageLoaderUtils$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static int a() {
        if (AppInfo.l > 0) {
            return AppInfo.l * 2;
        }
        return 2048;
    }

    public static int a(int i, int i2, String str) {
        int i3 = 1;
        if (i > 0) {
            i3 = 1;
            if (i2 > 0) {
                i3 = 1;
                if (!TextUtils.isEmpty(str)) {
                    int a2 = a(str);
                    int b2 = b(str);
                    int i4 = (i2 <= b2 || b2 <= 0) ? 1 : (int) (i2 / b2);
                    i3 = 1;
                    if (i > a2) {
                        i3 = 1;
                        if (a2 > 0) {
                            i3 = Math.min((int) (i / a2), i4);
                        }
                    }
                }
            }
        }
        return i3;
    }

    public static int a(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf(42)) <= 0) {
            return 0;
        }
        return Integer.parseInt(str.substring(0, indexOf));
    }

    public static Bitmap a(String str, Bitmap bitmap) {
        Matrix matrix;
        if (bitmap == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return bitmap;
        }
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 0);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i = width >> 1;
            int i2 = height >> 1;
            if (attributeInt == 2) {
                matrix = new Matrix();
                matrix.setTranslate(width, 0.0f);
                matrix.setScale(-1.0f, 1.0f);
            } else if (attributeInt == 3) {
                matrix = new Matrix();
                matrix.setRotate(180.0f, i, i2);
            } else if (attributeInt == 4) {
                matrix = new Matrix();
                matrix.setTranslate(0.0f, height);
                matrix.setScale(1.0f, -1.0f);
            } else if (attributeInt != 5) {
                if (attributeInt == 6) {
                    matrix = new Matrix();
                    matrix.postRotate(90.0f, i, i2);
                    matrix.postTranslate(i2 - i, i - i2);
                } else if (attributeInt != 8) {
                    matrix = null;
                } else {
                    matrix = new Matrix();
                    matrix.postRotate(270.0f, i, i2);
                    matrix.postTranslate(i2 - i, i - i2);
                }
                width = height;
                height = width;
            } else {
                matrix = new Matrix();
                matrix.setTranslate(width, height);
                matrix.setScale(-1.0f, -1.0f);
            }
            Bitmap bitmap2 = bitmap;
            if (matrix != null) {
                bitmap2 = bitmap;
                if (!matrix.isIdentity()) {
                    bitmap2 = Bitmap.createBitmap(width, height, bitmap.getConfig());
                    new Canvas(bitmap2).drawBitmap(bitmap, matrix, new Paint());
                    bitmap.recycle();
                }
            }
            return bitmap2;
        } catch (IOException e) {
            return bitmap;
        }
    }

    public static BitmapFactory.Options a(BitmapFactory.Options options, boolean z) {
        BitmapFactory.Options options2 = options;
        if (options == null) {
            options2 = new BitmapFactory.Options();
        }
        options2.inJustDecodeBounds = false;
        options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options2.inDither = false;
        if (!z) {
            options2.inPurgeable = true;
            options2.inInputShareable = true;
        }
        options2.inSampleSize = 1;
        return options2;
    }

    public static String a(int i, int i2) {
        return "" + i + '*' + i2;
    }

    public static int b(int i, int i2, String str) {
        int i3;
        int a2 = a(i, i2, str);
        int a3 = a();
        while (true) {
            i3 = a2;
            if (i / a2 <= a3) {
                break;
            }
            a2 *= 2;
        }
        while (i2 / i3 > a3) {
            i3 *= 2;
        }
        return i3;
    }

    public static int b(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf(42)) < 0 || indexOf >= str.length()) {
            return 0;
        }
        return Integer.parseInt(str.substring(indexOf + 1));
    }

    public static String b() {
        if (TextUtils.isEmpty(b)) {
            if (AppInfo.l <= 0 || AppInfo.m <= 0) {
                DisplayMetrics displayMetrics = AppInfo.d().getResources().getDisplayMetrics();
                b = a(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                b = a(AppInfo.l, AppInfo.m);
            }
        }
        return b;
    }
}
