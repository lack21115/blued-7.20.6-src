package com.weimob.library.groups.imageloader.core;

import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.drawee.backends.pipeline.DraweeConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.soloader.SoLoader;
import com.weimob.library.groups.imageloader.Imagepipeline.ImageLoaderImagePipelineFactory;
import com.weimob.library.groups.imageloader.assist.ImageLoaderInfo;
import com.weimob.library.groups.imageloader.cache.memory.ImageLoaderMemoryTrimmableRegistry;
import com.weimob.library.groups.imageloader.core.DisplayImageOptions;
import com.weimob.library.groups.imageloader.imageaware.ImageAware;
import com.weimob.library.groups.imageloader.imageaware.ImageViewAware;
import com.weimob.library.groups.imageloader.imageaware.NonViewAware;
import com.weimob.library.groups.imageloader.imageaware.TextViewAware;
import com.weimob.library.groups.imageloader.listener.ImageLoadingListener;
import com.weimob.library.groups.imageloader.listener.SimpleImageLoadingListener;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/core/ImageLoader.class */
public class ImageLoader {
    private static final String ERROR_NOT_INIT = "ImageLoader configuration can not be initialized with null";
    private final ComponentCallbacks DEFAULT_COMPONENT_CALLBACKS;
    private ImageLoaderConfiguration configuration;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/core/ImageLoader$Singleton.class */
    public enum Singleton {
        INSTANCE;
        
        private ImageLoader singleton = new ImageLoader();

        Singleton() {
        }

        public ImageLoader getInstance() {
            return this.singleton;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/core/ImageLoader$SyncImageLoadingListener.class */
    static class SyncImageLoadingListener extends SimpleImageLoadingListener {
        private ImageLoaderInfo imageLoaderInfo;

        private SyncImageLoadingListener() {
        }

        public ImageLoaderInfo getImageLoaderInfo() {
            return this.imageLoaderInfo;
        }

        @Override // com.weimob.library.groups.imageloader.listener.SimpleImageLoadingListener, com.weimob.library.groups.imageloader.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, ImageLoaderInfo imageLoaderInfo) {
            super.onLoadingComplete(str, view, imageLoaderInfo);
            this.imageLoaderInfo = imageLoaderInfo;
        }
    }

    private ImageLoader() {
        this.DEFAULT_COMPONENT_CALLBACKS = new ComponentCallbacks2() { // from class: com.weimob.library.groups.imageloader.core.ImageLoader.1
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
                ImageLoader.getInstance().onLowMemory();
            }

            @Override // android.content.ComponentCallbacks2
            public void onTrimMemory(int i) {
                ImageLoader.getInstance().onTrimMemory(i);
            }
        };
    }

    private void checkConfiguration() {
        if (this.configuration == null) {
            throw new IllegalStateException(ERROR_NOT_INIT);
        }
    }

    public static ImageLoader getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private void initFresco(ImageLoaderConfiguration imageLoaderConfiguration) {
        try {
            SoLoader.init(imageLoaderConfiguration.context, 0);
            ImagePipelineFactory.setInstance(new ImageLoaderImagePipelineFactory(ImageLoaderTransform.getImagePipelineConfig(imageLoaderConfiguration).build()));
            Method declaredMethod = Fresco.class.getDeclaredMethod("initializeDrawee", Context.class, DraweeConfig.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, imageLoaderConfiguration.context, null);
            Field declaredField = Fresco.class.getDeclaredField("sIsInitialized");
            declaredField.setAccessible(true);
            declaredField.set(null, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearCaches() {
        clearMemoryCache();
        clearDiskCache();
    }

    public void clearDiskCache() {
        checkConfiguration();
        Fresco.getImagePipeline().clearDiskCaches();
        ImageLoaderTransform.clearDiskCaches();
    }

    public void clearMemoryCache() {
        checkConfiguration();
        Fresco.getImagePipeline().clearMemoryCaches();
    }

    public void destroy() {
        ImageLoaderTransform.destroy();
        this.configuration = null;
        Fresco.shutDown();
    }

    public void displayImage(String str, ImageView imageView, DisplayImageOptions displayImageOptions) {
        displayImage(str, (String) null, new ImageViewAware(imageView), displayImageOptions, (ImageLoadingListener) null);
    }

    public void displayImage(String str, ImageView imageView, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        displayImage(str, (String) null, new ImageViewAware(imageView), displayImageOptions, imageLoadingListener);
    }

    public void displayImage(String str, ImageAware imageAware, DisplayImageOptions displayImageOptions) {
        displayImage(str, (String) null, imageAware, displayImageOptions, (ImageLoadingListener) null);
    }

    public void displayImage(String str, ImageAware imageAware, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        displayImage(str, (String) null, imageAware, displayImageOptions, imageLoadingListener);
    }

    public void displayImage(String str, String str2, ImageView imageView, DisplayImageOptions displayImageOptions) {
        displayImage(str, str2, new ImageViewAware(imageView), displayImageOptions, (ImageLoadingListener) null);
    }

    public void displayImage(String str, String str2, ImageView imageView, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        displayImage(str, str2, new ImageViewAware(imageView), displayImageOptions, imageLoadingListener);
    }

    public void displayImage(String str, String str2, ImageAware imageAware, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        checkConfiguration();
        imageAware.loadImage(str, str2, this.configuration, displayImageOptions, imageLoadingListener);
    }

    public void displayRichText(String str, TextView textView, DisplayImageOptions displayImageOptions) {
        displayRichText(str, new TextViewAware(textView), displayImageOptions);
    }

    public void displayRichText(String str, ImageAware imageAware, DisplayImageOptions displayImageOptions) {
        checkConfiguration();
        imageAware.loadRichText(str, this.configuration, displayImageOptions);
    }

    public File getDiskCacheFile(String str) {
        FileBinaryResource resource = Fresco.getImagePipelineFactory().getMainFileCache().getResource(Fresco.getImagePipeline().getCacheKeyFactory().getEncodedCacheKey(ImageRequest.fromUri(str), (Object) null));
        if (resource instanceof FileBinaryResource) {
            return resource.getFile();
        }
        return null;
    }

    public long getDiskCacheSize() {
        long totalSize = Fresco.getImagePipelineFactory().getMainFileCache().getTotalSize();
        long j = totalSize > 0 ? totalSize + 0 : 0L;
        long totalSize2 = Fresco.getImagePipelineFactory().getSmallImageFileCache().getTotalSize();
        long j2 = j;
        if (totalSize2 > 0) {
            j2 = j + totalSize2;
        }
        return j2;
    }

    public String getDiskCacheSizeTxt() {
        long diskCacheSize = getDiskCacheSize();
        String str = "0KB";
        if (diskCacheSize <= 0) {
            return "0KB";
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        if (diskCacheSize >= 1073741824) {
            return decimalFormat.format((((float) diskCacheSize) * 1.0f) / ((float) 1073741824)) + "G";
        } else if (diskCacheSize >= 1048576) {
            return decimalFormat.format((((float) diskCacheSize) * 1.0f) / ((float) 1048576)) + "M";
        } else {
            if (diskCacheSize >= 1024) {
                str = decimalFormat.format((((float) diskCacheSize) * 1.0f) / ((float) 1024)) + "KB";
            }
            return str;
        }
    }

    public void init(ImageLoaderConfiguration imageLoaderConfiguration) {
        synchronized (this) {
            if (this.configuration == null) {
                this.configuration = imageLoaderConfiguration;
            }
            checkConfiguration();
            imageLoaderConfiguration.getContext().unregisterComponentCallbacks(this.DEFAULT_COMPONENT_CALLBACKS);
            imageLoaderConfiguration.getContext().registerComponentCallbacks(this.DEFAULT_COMPONENT_CALLBACKS);
            initFresco(imageLoaderConfiguration);
        }
    }

    public boolean isInited() {
        return this.configuration != null;
    }

    public void loadImage(String str, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        checkConfiguration();
        new NonViewAware().loadImage(str, null, this.configuration, displayImageOptions, imageLoadingListener);
    }

    public ImageLoaderInfo loadImageSync(String str, DisplayImageOptions displayImageOptions) {
        checkConfiguration();
        DisplayImageOptions displayImageOptions2 = displayImageOptions;
        if (displayImageOptions == null) {
            displayImageOptions2 = this.configuration.defaultDisplayImageOptions;
        }
        DisplayImageOptions build = new DisplayImageOptions.Builder(this.configuration.getContext()).cloneFrom(displayImageOptions2).cacheInMemory(false).syncLoading(true).build();
        SyncImageLoadingListener syncImageLoadingListener = new SyncImageLoadingListener();
        new NonViewAware().loadImage(str, null, this.configuration, build, syncImageLoadingListener);
        return syncImageLoadingListener.getImageLoaderInfo();
    }

    public void onLowMemory() {
        ImageLoaderMemoryTrimmableRegistry.getInstance().onLowMemory();
    }

    public void onTrimMemory(int i) {
        onLowMemory();
    }

    public void pause() {
        Fresco.getImagePipeline().pause();
        ImageLoaderTransform.pause();
    }

    public void prefetchToCache(String str, DisplayImageOptions displayImageOptions) {
        boolean z;
        checkConfiguration();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        DisplayImageOptions displayImageOptions2 = displayImageOptions;
        if (displayImageOptions == null) {
            displayImageOptions2 = this.configuration.defaultDisplayImageOptions;
        }
        ImageRequest build = ImageLoaderTransform.getImageRequestBuilder(str, null, this.configuration, displayImageOptions2, null).build();
        boolean z2 = true;
        if (displayImageOptions2 != null) {
            z2 = displayImageOptions2.isCacheInMemory();
            z = displayImageOptions2.isCacheOnDisk();
        } else {
            z = true;
        }
        if (z2) {
            Fresco.getImagePipeline().prefetchToBitmapCache(build, this.configuration.getContext());
        }
        if (z) {
            Fresco.getImagePipeline().prefetchToDiskCache(build, this.configuration.getContext());
        }
    }

    public void resume() {
        Fresco.getImagePipeline().resume();
        ImageLoaderTransform.resume();
    }
}
