package com.weimob.library.groups.imageloader.core;

import android.content.Context;
import android.graphics.Bitmap;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/core/ImageLoaderConfiguration.class */
public final class ImageLoaderConfiguration {
    final Bitmap.Config bitmapConfig;
    final Context context;
    final boolean debug;
    final DisplayImageOptions defaultDisplayImageOptions;
    final int maxDiskCacheSize;
    final int maxMemoryCacheSize;

    /* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/core/ImageLoaderConfiguration$Builder.class */
    public static class Builder {
        private Bitmap.Config bitmapConfig;
        private Context context;
        private boolean debug;
        private DisplayImageOptions defaultDisplayImageOptions;
        private int maxDiskCacheSize;
        private int maxMemoryCacheSize;

        public Builder(Context context) {
            this.context = context.getApplicationContext();
        }

        private void initEmptyFieldsWithDefaultValues() {
            if (this.maxMemoryCacheSize <= 0) {
                this.maxMemoryCacheSize = DefaultConfigurationFactory.getMaxMemoryCacheSize(this.context);
            }
            if (this.maxDiskCacheSize <= 0) {
                this.maxDiskCacheSize = DefaultConfigurationFactory.getMaxDiskCacheSize();
            }
            if (this.bitmapConfig == null) {
                this.bitmapConfig = DefaultConfigurationFactory.getBitmapConfig();
            }
            if (this.defaultDisplayImageOptions == null) {
                this.defaultDisplayImageOptions = DefaultConfigurationFactory.getDefaultDisplayImageOptions(this.context);
            }
        }

        public Builder bitmapConfig(Bitmap.Config config) {
            this.bitmapConfig = config;
            return this;
        }

        public ImageLoaderConfiguration build() {
            initEmptyFieldsWithDefaultValues();
            return new ImageLoaderConfiguration(this);
        }

        public Builder debug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder defaultDisplayImageOptions(DisplayImageOptions displayImageOptions) {
            this.defaultDisplayImageOptions = displayImageOptions;
            return this;
        }

        public Builder maxDiskCacheSize(int i) {
            this.maxDiskCacheSize = i;
            return this;
        }

        public Builder maxMemoryCacheSize(int i) {
            this.maxMemoryCacheSize = i;
            return this;
        }
    }

    private ImageLoaderConfiguration(Builder builder) {
        this.context = builder.context;
        this.defaultDisplayImageOptions = builder.defaultDisplayImageOptions;
        this.maxMemoryCacheSize = builder.maxMemoryCacheSize;
        this.maxDiskCacheSize = builder.maxDiskCacheSize;
        this.bitmapConfig = builder.bitmapConfig;
        this.debug = builder.debug;
    }

    public Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    public Context getContext() {
        return this.context;
    }

    public DisplayImageOptions getDefaultDisplayImageOptions() {
        return this.defaultDisplayImageOptions;
    }

    public int getMaxDiskCacheSize() {
        return this.maxDiskCacheSize;
    }

    public int getMaxMemoryCacheSize() {
        return this.maxMemoryCacheSize;
    }

    public boolean isDebug() {
        return this.debug;
    }
}
