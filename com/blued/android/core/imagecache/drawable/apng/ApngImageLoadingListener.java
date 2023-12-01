package com.blued.android.core.imagecache.drawable.apng;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.NetworkOnMainThreadException;
import android.widget.ImageView;
import com.blued.android.core.imagecache.BaseImageLoadingListener;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.imagecache.view.RecyclingImageView;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/drawable/apng/ApngImageLoadingListener.class */
public class ApngImageLoadingListener extends BaseImageLoadingListener {
    private ApngPlayListener a;
    private boolean b;

    private ApngDrawable a(String str, ImageView.ScaleType scaleType, Drawable drawable) {
        File a = a(str);
        Bitmap bitmap = null;
        if ((a == null || !a.exists()) ? false : ApngDrawable.a(a)) {
            if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            }
            return new RecyclingApngDrawable(str, bitmap, Uri.fromFile(a), scaleType);
        }
        return null;
    }

    protected File a(String str) {
        File file = new File(RecyclingUtils.d(str));
        if (!file.exists()) {
            if (RecyclingUtils.Scheme.a(str) == RecyclingUtils.Scheme.ASSETS) {
                try {
                    RecyclingUtils.a(RecyclingUtils.c(str), file);
                    return file;
                } catch (IOException e) {
                    e.printStackTrace();
                    return file;
                }
            }
            try {
                RecyclingUtils.a(new URL(str).openStream(), file);
                return file;
            } catch (NetworkOnMainThreadException e2) {
                e2.printStackTrace();
                return file;
            } catch (MalformedURLException e3) {
                e3.printStackTrace();
            } catch (IOException e4) {
                e4.printStackTrace();
                return file;
            }
        }
        return file;
    }

    @Override // com.blued.android.core.imagecache.BaseImageLoadingListener, com.blued.android.core.imagecache.ImageLoadingListener
    public void a(String str, RecyclingImageView recyclingImageView, LoadOptions loadOptions, Drawable drawable, boolean z) {
        ApngDrawable apngDrawable;
        if (drawable instanceof ApngDrawable) {
            super.a(str, recyclingImageView, loadOptions, drawable, z);
            apngDrawable = (ApngDrawable) drawable;
        } else {
            ApngDrawable a = a(str, recyclingImageView.getScaleType(), drawable);
            if (a != null) {
                recyclingImageView.setImageDrawable(a);
            } else {
                super.a(str, recyclingImageView, loadOptions, drawable, z);
            }
            apngDrawable = a;
        }
        if (apngDrawable == null) {
            ApngPlayListener apngPlayListener = this.a;
            if (apngPlayListener != null) {
                apngPlayListener.b(null);
                return;
            }
            return;
        }
        apngDrawable.g();
        apngDrawable.a(this.a);
        if (this.b) {
            apngDrawable.a(1);
        }
        apngDrawable.start();
    }
}
