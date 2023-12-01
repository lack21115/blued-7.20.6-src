package com.weimob.library.groups.imageloader.listener;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.weimob.library.groups.imageloader.assist.ImageLoaderInfo;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/listener/ImageLoadingListener.class */
public interface ImageLoadingListener {
    void onLoadingComplete(String str, View view, Drawable drawable);

    void onLoadingComplete(String str, View view, ImageLoaderInfo imageLoaderInfo);

    void onLoadingFailed(String str, View view);

    void onLoadingProgressUpdate(String str, View view, float f, float f2);

    void onLoadingStarted(String str, View view);
}
