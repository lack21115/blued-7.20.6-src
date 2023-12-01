package com.weimob.library.groups.imageloader.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.weimob.library.groups.imageloader.core.DisplayImageOptions;
import com.weimob.library.groups.imageloader.core.ImageLoaderConfiguration;
import com.weimob.library.groups.imageloader.listener.ImageLoadingListener;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/imageaware/ImageAware.class */
public interface ImageAware {
    int getHeight();

    int getId();

    int getMeasuredHeight();

    int getMeasuredWidth();

    int getWidth();

    View getWrappedView();

    boolean isCollected();

    void loadImage(String str, String str2, ImageLoaderConfiguration imageLoaderConfiguration, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener);

    void loadRichText(CharSequence charSequence, ImageLoaderConfiguration imageLoaderConfiguration, DisplayImageOptions displayImageOptions);

    boolean setImageBitmap(Bitmap bitmap);

    boolean setImageDrawable(Drawable drawable);
}
