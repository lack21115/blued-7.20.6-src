package com.sobot.pictureframe;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.view.WindowManager;
import android.widget.ImageView;
import com.sobot.chat.imageloader.SobotGlideV4ImageLoader;
import com.sobot.chat.imageloader.SobotImageLoader;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/pictureframe/SobotBitmapUtil.class */
public class SobotBitmapUtil {
    private static SobotImageLoader sImageLoader;

    public static Bitmap compress(String str, Context context, boolean z) {
        if (Build.VERSION.SDK_INT < 29 || z) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            options.inSampleSize = SobotPictureUtils.calculateInSampleSize(options, windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight());
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        }
        return SobotPictureUtils.getBitmapFromUri(context, SobotPictureUtils.getImageContentUri(context, str));
    }

    public static void display(Context context, int i, ImageView imageView) {
        if (context == null || imageView == null) {
            return;
        }
        getImageLoader().displayImage(context, imageView, i, 0, 0, imageView.getWidth(), imageView.getHeight(), (SobotImageLoader.SobotDisplayImageListener) null);
    }

    public static void display(Context context, String str, ImageView imageView) {
        if (context == null || imageView == null) {
            return;
        }
        getImageLoader().displayImage(context, imageView, str, 0, 0, imageView.getWidth(), imageView.getHeight(), (SobotImageLoader.SobotDisplayImageListener) null);
    }

    public static void display(Context context, String str, ImageView imageView, int i, int i2) {
        if (context == null || imageView == null) {
            return;
        }
        getImageLoader().displayImage(context, imageView, str, i, i2, imageView.getWidth(), imageView.getHeight(), (SobotImageLoader.SobotDisplayImageListener) null);
    }

    private static final SobotImageLoader getImageLoader() {
        if (sImageLoader == null) {
            synchronized (SobotBitmapUtil.class) {
                try {
                    if (sImageLoader == null) {
                        if (isClassExists("com.bumptech.glide.request.RequestOptions")) {
                            sImageLoader = new SobotGlideV4ImageLoader();
                        } else if (isClassExists("com.bumptech.glide.Glide")) {
                            sImageLoader = new SobotGlideImageLoader();
                        } else if (isClassExists("com.squareup.picasso.Picasso")) {
                            sImageLoader = new SobotPicassoImageLoader();
                        } else if (!isClassExists("com.nostra13.universalimageloader.core.ImageLoader")) {
                            throw new RuntimeException("必须在(Glide、Picasso、universal-image-loader)中选择一个图片加载库添加依赖,或者检查是否添加了相应的混淆配置");
                        } else {
                            sImageLoader = new SobotUILImageLoader();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sImageLoader;
    }

    private static final boolean isClassExists(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static void setImageLoader(SobotImageLoader sobotImageLoader) {
        sImageLoader = sobotImageLoader;
    }
}
