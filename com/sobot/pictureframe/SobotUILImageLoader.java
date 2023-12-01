package com.sobot.pictureframe;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.sobot.chat.imageloader.SobotImageLoader;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/pictureframe/SobotUILImageLoader.class */
public class SobotUILImageLoader extends SobotImageLoader {
    private void initImageLoader(Context context) {
        if (ImageLoader.getInstance().isInited()) {
            return;
        }
        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(context.getApplicationContext()).threadPoolSize(3).defaultDisplayImageOptions(new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build()).build());
    }

    @Override // com.sobot.chat.imageloader.SobotImageLoader
    public void displayImage(Context context, ImageView imageView, int i, int i2, int i3, int i4, int i5, final SobotImageLoader.SobotDisplayImageListener sobotDisplayImageListener) {
        initImageLoader(context);
        DisplayImageOptions build = new DisplayImageOptions.Builder().showImageOnLoading(i2).showImageOnFail(i3).showImageForEmptyUri(i3).cacheInMemory(true).bitmapConfig(Bitmap.Config.RGB_565).build();
        ImageSize imageSize = (i4 == 0 && i5 == 0) ? null : new ImageSize(i4, i5);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage("drawable://" + i, new ImageViewAware(imageView), build, imageSize, new SimpleImageLoadingListener() { // from class: com.sobot.pictureframe.SobotUILImageLoader.2
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                SobotImageLoader.SobotDisplayImageListener sobotDisplayImageListener2 = sobotDisplayImageListener;
                if (sobotDisplayImageListener2 != null) {
                    sobotDisplayImageListener2.onSuccess(view, str);
                }
            }
        }, (ImageLoadingProgressListener) null);
    }

    @Override // com.sobot.chat.imageloader.SobotImageLoader
    public void displayImage(Context context, ImageView imageView, String str, int i, int i2, int i3, int i4, final SobotImageLoader.SobotDisplayImageListener sobotDisplayImageListener) {
        initImageLoader(context);
        ImageLoader.getInstance().displayImage(str, new ImageViewAware(imageView), new DisplayImageOptions.Builder().showImageOnLoading(i).showImageOnFail(i2).showImageForEmptyUri(i2).cacheInMemory(true).cacheOnDisk(true).bitmapConfig(Bitmap.Config.RGB_565).build(), (i3 == 0 && i4 == 0) ? null : new ImageSize(i3, i4), new SimpleImageLoadingListener() { // from class: com.sobot.pictureframe.SobotUILImageLoader.1
            public void onLoadingComplete(String str2, View view, Bitmap bitmap) {
                SobotImageLoader.SobotDisplayImageListener sobotDisplayImageListener2 = sobotDisplayImageListener;
                if (sobotDisplayImageListener2 != null) {
                    sobotDisplayImageListener2.onSuccess(view, str2);
                }
            }
        }, (ImageLoadingProgressListener) null);
    }
}
