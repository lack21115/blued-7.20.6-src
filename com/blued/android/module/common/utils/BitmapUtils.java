package com.blued.android.module.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.anythink.expressad.foundation.h.i;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/BitmapUtils.class */
public class BitmapUtils {
    public static int a(Context context, ImageView imageView, int i) {
        return a(context, imageView, i, true, false);
    }

    public static int a(Context context, ImageView imageView, int i, boolean z) {
        return a(context, imageView, i, z, false);
    }

    private static int a(Context context, ImageView imageView, int i, boolean z, boolean z2) {
        String str;
        Bitmap bitmap;
        if (i < 0) {
            if (imageView != null) {
                imageView.setVisibility(8);
                return -1;
            }
            return -1;
        }
        int i2 = i;
        if (i >= 35) {
            i2 = 35;
        }
        if (i2 < 10) {
            str = "00" + i2;
        } else if (i2 < 100) {
            str = "0" + i2;
        } else {
            str = i2 + "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("rich");
        sb.append(z2 ? "" : "_new_");
        sb.append(str);
        int identifier = context.getResources().getIdentifier(sb.toString(), i.f7952c, context.getPackageName());
        if (imageView != null) {
            if (identifier > 0) {
                Drawable drawable = context.getResources().getDrawable(identifier);
                if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    if (height > 0) {
                        int a2 = DensityUtils.a(context, 15.0f);
                        int i3 = (int) ((a2 * (width * 1.0f)) / height);
                        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                        if (layoutParams != null && i3 > 0) {
                            layoutParams.width = i3;
                            layoutParams.height = a2;
                            imageView.setLayoutParams(layoutParams);
                        }
                    }
                }
                imageView.setImageResource(identifier);
                if (i2 == 0 && z) {
                    imageView.setVisibility(8);
                    return identifier;
                }
                imageView.setVisibility(0);
                return identifier;
            }
            imageView.setVisibility(8);
        }
        return identifier;
    }

    public static Bitmap a(int i, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap a(Context context, Bitmap bitmap, Bitmap bitmap2, int i, int i2) {
        return a(bitmap, bitmap2, i, (bitmap.getHeight() - bitmap2.getHeight()) - i2);
    }

    public static Bitmap a(Context context, View view) {
        if (view == null) {
            return null;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    public static Bitmap a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width >= 4096 || height >= 4096) {
            float f = 4096;
            float min = Math.min(f / width, f / height);
            Matrix matrix = new Matrix();
            matrix.postScale(min, min);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        return bitmap;
    }

    public static Bitmap a(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap a(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap2, (width - width2) / 2, (height - height2) / 2, (Paint) null);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    private static Bitmap a(Bitmap bitmap, Bitmap bitmap2, int i, int i2) {
        Bitmap bitmap3;
        if (bitmap == null) {
            return null;
        }
        if (bitmap2 != null && bitmap.getWidth() >= bitmap2.getWidth() + (i * 2)) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            try {
                bitmap3 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    bitmap3 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    bitmap3 = null;
                }
            }
            if (bitmap3 == null) {
                return null;
            }
            Canvas canvas = new Canvas(bitmap3);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            canvas.drawBitmap(bitmap2, i, i2, (Paint) null);
            canvas.save();
            canvas.restore();
            return bitmap3;
        }
        return bitmap;
    }

    public static Bitmap a(Drawable drawable) {
        Bitmap createBitmap;
        try {
            createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        } catch (Exception e) {
            createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_4444 : Bitmap.Config.RGB_565);
        }
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static Bitmap a(View view) {
        return a(view, Bitmap.Config.RGB_565);
    }

    public static Bitmap a(View view, Bitmap.Config config) {
        if (view == null) {
            return null;
        }
        view.buildDrawingCache(true);
        if (view.getDrawingCache(true) == null) {
            return null;
        }
        Bitmap copy = view.getDrawingCache(true).copy(config, false);
        view.setDrawingCacheEnabled(true);
        if (copy == null) {
            return null;
        }
        view.setDrawingCacheEnabled(false);
        view.destroyDrawingCache();
        return copy;
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x01ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap a(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.utils.BitmapUtils.a(java.lang.String):android.graphics.Bitmap");
    }

    public static Bitmap a(String str, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i2 = options.outWidth / i;
        int i3 = options.outHeight / i;
        if (i2 > 1 || i3 > 1) {
            if (i2 > i3) {
                options.inSampleSize = i2;
            } else {
                options.inSampleSize = i3;
            }
        }
        options.inJustDecodeBounds = false;
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            MemoryRequest.a().b();
            return null;
        }
    }

    public static File a(String str, Bitmap bitmap, int i, boolean z) {
        BufferedOutputStream bufferedOutputStream;
        if (bitmap == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        } else if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        bitmap.compress(Bitmap.CompressFormat.PNG, i, bufferedOutputStream);
                        if (z) {
                            bitmap.recycle();
                        }
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        return file;
                    } catch (IOException e2) {
                        e = e2;
                        bufferedOutputStream2 = bufferedOutputStream;
                        e.printStackTrace();
                        if (bufferedOutputStream != null) {
                            if (z) {
                                bitmap.recycle();
                            }
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            return file;
                        }
                        return file;
                    } catch (Throwable th) {
                        bufferedOutputStream2 = bufferedOutputStream;
                        th = th;
                        if (bufferedOutputStream2 != null) {
                            if (z) {
                                try {
                                    bitmap.recycle();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    throw th;
                                }
                            }
                            bufferedOutputStream2.flush();
                            bufferedOutputStream2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e4) {
                e = e4;
                bufferedOutputStream = null;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    public static String a(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return "";
        }
        String str = RecyclingUtils.e("shareImg") + ".jpg";
        a(str, bitmap, 100, z);
        return str;
    }

    public static void a(Bitmap bitmap, String str, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            Logger.a("drb", "baos.size() = ", Integer.valueOf(byteArrayOutputStream.size()));
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Bitmap b(Bitmap bitmap, float f) {
        Bitmap bitmap2;
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() >= bitmap.getHeight() && bitmap.getWidth() > f) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) f, (int) ((bitmap.getHeight() * f) / bitmap.getWidth()), true);
            bitmap2 = createScaledBitmap;
            if (!bitmap.isRecycled()) {
                bitmap2 = createScaledBitmap;
                if (!bitmap.equals(createScaledBitmap)) {
                    bitmap.recycle();
                    bitmap2 = createScaledBitmap;
                }
            }
        } else if (bitmap.getHeight() <= bitmap.getWidth() || bitmap.getHeight() <= f) {
            return bitmap;
        } else {
            Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(bitmap, (int) ((bitmap.getWidth() * f) / bitmap.getHeight()), (int) f, true);
            bitmap2 = createScaledBitmap2;
            if (bitmap != null) {
                bitmap2 = createScaledBitmap2;
                if (!bitmap.isRecycled()) {
                    bitmap2 = createScaledBitmap2;
                    if (!bitmap.equals(createScaledBitmap2)) {
                        bitmap.recycle();
                        bitmap2 = createScaledBitmap2;
                    }
                }
            }
        }
        return bitmap2;
    }
}
