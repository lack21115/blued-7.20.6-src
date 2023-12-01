package com.sobot.network.http.utils;

import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.io.InputStream;
import java.lang.reflect.Field;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/utils/ImageUtils.class */
public class ImageUtils {

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/utils/ImageUtils$ImageSize.class */
    public static class ImageSize {
        int height;
        int width;

        public ImageSize() {
        }

        public ImageSize(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public String toString() {
            return "ImageSize{width=" + this.width + ", height=" + this.height + '}';
        }
    }

    public static int calculateInSampleSize(ImageSize imageSize, ImageSize imageSize2) {
        int i = imageSize.width;
        int i2 = imageSize.height;
        int i3 = imageSize2.width;
        int i4 = imageSize2.height;
        if (i <= i3 || i2 <= i4) {
            return 1;
        }
        return Math.max(Math.round(i / i3), Math.round(i2 / i4));
    }

    private static int getExpectHeight(View view) {
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i = 0;
        if (layoutParams != null) {
            i = 0;
            if (layoutParams.height != -2) {
                i = view.getWidth();
            }
        }
        int i2 = i;
        if (i <= 0) {
            i2 = i;
            if (layoutParams != null) {
                i2 = layoutParams.height;
            }
        }
        int i3 = i2;
        if (i2 <= 0) {
            i3 = getImageViewFieldValue(view, "mMaxHeight");
        }
        int i4 = i3;
        if (i3 <= 0) {
            i4 = view.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        return i4;
    }

    private static int getExpectWidth(View view) {
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i = 0;
        if (layoutParams != null) {
            i = 0;
            if (layoutParams.width != -2) {
                i = view.getWidth();
            }
        }
        int i2 = i;
        if (i <= 0) {
            i2 = i;
            if (layoutParams != null) {
                i2 = layoutParams.width;
            }
        }
        int i3 = i2;
        if (i2 <= 0) {
            i3 = getImageViewFieldValue(view, "mMaxWidth");
        }
        int i4 = i3;
        if (i3 <= 0) {
            i4 = view.getContext().getResources().getDisplayMetrics().widthPixels;
        }
        return i4;
    }

    public static ImageSize getImageSize(InputStream inputStream) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        return new ImageSize(options.outWidth, options.outHeight);
    }

    private static int getImageViewFieldValue(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int i = declaredField.getInt(obj);
            int i2 = 0;
            if (i > 0) {
                i2 = 0;
                if (i < Integer.MAX_VALUE) {
                    i2 = i;
                }
            }
            return i2;
        } catch (Exception e) {
            return 0;
        }
    }

    public static ImageSize getImageViewSize(View view) {
        ImageSize imageSize = new ImageSize();
        imageSize.width = getExpectWidth(view);
        imageSize.height = getExpectHeight(view);
        return imageSize;
    }
}
