package com.weimob.library.groups.imageloader.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.weimob.library.groups.imageloader.assist.ImageScaleType;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/core/DisplayImageOptions.class */
public final class DisplayImageOptions {
    final ColorFilter actualImageColorFilter;
    final ImageScaleType actualImageScaleType;
    final float aspectRatio;
    final Drawable backgroundDrawable;
    final Bitmap.Config bitmapConfig;
    final int borderColor;
    final float borderWidth;
    final float bottomLeft;
    final float bottomRight;
    final Context context;
    final int fadeDuration;
    final Drawable failureImage;
    final ImageScaleType failureImageScaleType;
    final boolean isCacheInMemory;
    final boolean isCacheOnDisk;
    final boolean isCircle;
    final boolean isDecodeImage;
    final boolean isSyncLoading;
    final Drawable placeholderImage;
    final ImageScaleType placeholderImageScaleType;
    final Drawable progressBarImage;
    final ImageScaleType progressBarImageScaleType;
    final boolean progressiveRenderingEnabled;
    final boolean resizeAndRotateEnabledForNetwork;
    final Drawable retryImage;
    final ImageScaleType retryImageScaleType;
    final int targetHeight;
    final int targetWidth;
    final float topLeft;
    final float topRight;

    /* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/core/DisplayImageOptions$Builder.class */
    public static class Builder {
        private ColorFilter actualImageColorFilter;
        private ImageScaleType actualImageScaleType;
        private float aspectRatio;
        private Drawable backgroundDrawable;
        private int borderColor;
        private float borderWidth;
        private float bottomLeft;
        private float bottomRight;
        private Context context;
        private Drawable failureImage;
        private ImageScaleType failureImageScaleType;
        private boolean isCircle;
        private boolean isSyncLoading;
        private Drawable placeholderImage;
        private ImageScaleType placeholderImageScaleType;
        private Drawable progressBarImage;
        private ImageScaleType progressBarImageScaleType;
        private boolean progressiveRenderingEnabled;
        private Drawable retryImage;
        private ImageScaleType retryImageScaleType;
        private int targetHeight;
        private int targetWidth;
        private float topLeft;
        private float topRight;
        private boolean isCacheInMemory = true;
        private boolean isCacheOnDisk = true;
        private int fadeDuration = 300;
        private boolean isDecodeImage = true;
        private boolean resizeAndRotateEnabledForNetwork = true;
        private Bitmap.Config bitmapConfig = null;

        public Builder(Context context) {
            this.context = context.getApplicationContext();
        }

        private Drawable getDrawable(int i) {
            if (i == 0) {
                return null;
            }
            return ContextCompat.getDrawable(this.context, i);
        }

        private void initEmptyFieldsWithDefaultValues() {
            if (this.progressBarImageScaleType == null) {
                this.progressBarImageScaleType = ImageScaleType.CENTER_INSIDE;
            }
            if (this.progressBarImage == null) {
                AnimationDrawable animationDrawable = new AnimationDrawable();
                animationDrawable.addFrame(new ColorDrawable(0), 0);
                this.progressBarImage = animationDrawable;
            }
        }

        public Builder actualImageColorFilter(ColorFilter colorFilter) {
            this.actualImageColorFilter = colorFilter;
            return this;
        }

        public Builder actualImageScaleType(ImageScaleType imageScaleType) {
            this.actualImageScaleType = imageScaleType;
            return this;
        }

        public Builder aspectRatio(float f) {
            this.aspectRatio = f;
            return this;
        }

        public Builder background(int i) {
            this.backgroundDrawable = getDrawable(i);
            return this;
        }

        public Builder background(Drawable drawable) {
            this.backgroundDrawable = drawable;
            return this;
        }

        public Builder bitmapConfig(Bitmap.Config config) {
            this.bitmapConfig = config;
            return this;
        }

        public Builder border(int i, float f) {
            this.borderColor = i;
            this.borderWidth = f;
            return this;
        }

        public DisplayImageOptions build() {
            initEmptyFieldsWithDefaultValues();
            return new DisplayImageOptions(this);
        }

        public Builder cacheInMemory(boolean z) {
            this.isCacheInMemory = z;
            return this;
        }

        public Builder cacheOnDisk(boolean z) {
            this.isCacheOnDisk = z;
            return this;
        }

        public Builder circle(boolean z) {
            this.isCircle = z;
            return this;
        }

        public Builder cloneFrom(DisplayImageOptions displayImageOptions) {
            if (displayImageOptions != null) {
                this.context = displayImageOptions.context;
                this.backgroundDrawable = displayImageOptions.backgroundDrawable;
                this.placeholderImage = displayImageOptions.placeholderImage;
                this.placeholderImageScaleType = displayImageOptions.placeholderImageScaleType;
                this.progressBarImage = displayImageOptions.progressBarImage;
                this.progressBarImageScaleType = displayImageOptions.progressBarImageScaleType;
                this.progressiveRenderingEnabled = displayImageOptions.progressiveRenderingEnabled;
                this.retryImage = displayImageOptions.retryImage;
                this.retryImageScaleType = displayImageOptions.retryImageScaleType;
                this.failureImage = displayImageOptions.failureImage;
                this.failureImageScaleType = displayImageOptions.failureImageScaleType;
                this.actualImageScaleType = displayImageOptions.actualImageScaleType;
                this.actualImageColorFilter = displayImageOptions.actualImageColorFilter;
                this.borderColor = displayImageOptions.borderColor;
                this.borderWidth = displayImageOptions.borderWidth;
                this.isCircle = displayImageOptions.isCircle;
                this.topLeft = displayImageOptions.topLeft;
                this.topRight = displayImageOptions.topRight;
                this.bottomLeft = displayImageOptions.bottomLeft;
                this.bottomRight = displayImageOptions.bottomRight;
                this.aspectRatio = displayImageOptions.aspectRatio;
                this.isCacheInMemory = displayImageOptions.isCacheInMemory;
                this.isCacheOnDisk = displayImageOptions.isCacheOnDisk;
                this.targetWidth = displayImageOptions.targetWidth;
                this.targetHeight = displayImageOptions.targetHeight;
                this.fadeDuration = displayImageOptions.fadeDuration;
                this.isSyncLoading = displayImageOptions.isSyncLoading;
                this.isDecodeImage = displayImageOptions.isDecodeImage;
                this.resizeAndRotateEnabledForNetwork = displayImageOptions.resizeAndRotateEnabledForNetwork;
                this.bitmapConfig = displayImageOptions.bitmapConfig;
            }
            return this;
        }

        public Builder cornersRadius(float f) {
            this.topLeft = f;
            this.topRight = f;
            this.bottomLeft = f;
            this.bottomRight = f;
            return this;
        }

        public Builder cornersRadius(float f, float f2, float f3, float f4) {
            this.topLeft = f;
            this.topRight = f2;
            this.bottomLeft = f4;
            this.bottomRight = f3;
            return this;
        }

        public Builder decodeImage(boolean z) {
            this.isDecodeImage = z;
            return this;
        }

        public Builder fadeDuration(int i) {
            this.fadeDuration = i;
            return this;
        }

        public Builder failureImage(int i) {
            this.failureImage = getDrawable(i);
            return this;
        }

        public Builder failureImage(Drawable drawable) {
            this.failureImage = drawable;
            return this;
        }

        public Builder failureImageScaleType(ImageScaleType imageScaleType) {
            this.failureImageScaleType = imageScaleType;
            return this;
        }

        public Builder placeholderImage(int i) {
            this.placeholderImage = getDrawable(i);
            return this;
        }

        public Builder placeholderImage(Drawable drawable) {
            this.placeholderImage = drawable;
            return this;
        }

        public Builder placeholderImageScaleType(ImageScaleType imageScaleType) {
            this.placeholderImageScaleType = imageScaleType;
            return this;
        }

        public Builder progressBarImage(int i) {
            this.progressBarImage = getDrawable(i);
            return this;
        }

        public Builder progressBarImage(Drawable drawable) {
            this.progressBarImage = drawable;
            return this;
        }

        public Builder progressBarImageScaleType(ImageScaleType imageScaleType) {
            this.progressBarImageScaleType = imageScaleType;
            return this;
        }

        public Builder progressiveRenderingEnabled(boolean z) {
            this.progressiveRenderingEnabled = z;
            return this;
        }

        public Builder resizeAndRotateEnabledForNetwork(boolean z) {
            this.resizeAndRotateEnabledForNetwork = z;
            return this;
        }

        public Builder retryImage(int i) {
            this.retryImage = getDrawable(i);
            return this;
        }

        public Builder retryImage(Drawable drawable) {
            this.retryImage = drawable;
            return this;
        }

        public Builder retryImageScaleType(ImageScaleType imageScaleType) {
            this.retryImageScaleType = imageScaleType;
            return this;
        }

        public Builder syncLoading(boolean z) {
            this.isSyncLoading = z;
            return this;
        }

        public Builder targetSize(int i, int i2) {
            this.targetWidth = i;
            this.targetHeight = i2;
            return this;
        }
    }

    private DisplayImageOptions(Builder builder) {
        this.context = builder.context;
        this.backgroundDrawable = builder.backgroundDrawable;
        this.placeholderImage = builder.placeholderImage;
        this.placeholderImageScaleType = builder.placeholderImageScaleType;
        this.progressBarImage = builder.progressBarImage;
        this.progressBarImageScaleType = builder.progressBarImageScaleType;
        this.retryImage = builder.retryImage;
        this.retryImageScaleType = builder.retryImageScaleType;
        this.failureImage = builder.failureImage;
        this.failureImageScaleType = builder.failureImageScaleType;
        this.actualImageScaleType = builder.actualImageScaleType;
        this.actualImageColorFilter = builder.actualImageColorFilter;
        this.progressiveRenderingEnabled = builder.progressiveRenderingEnabled;
        this.borderColor = builder.borderColor;
        this.borderWidth = builder.borderWidth;
        this.isCircle = builder.isCircle;
        this.topLeft = builder.topLeft;
        this.topRight = builder.topRight;
        this.bottomLeft = builder.bottomLeft;
        this.bottomRight = builder.bottomRight;
        this.aspectRatio = builder.aspectRatio;
        this.isCacheInMemory = builder.isCacheInMemory;
        this.isCacheOnDisk = builder.isCacheOnDisk;
        this.targetWidth = builder.targetWidth;
        this.targetHeight = builder.targetHeight;
        this.fadeDuration = builder.fadeDuration;
        this.isSyncLoading = builder.isSyncLoading;
        this.isDecodeImage = builder.isDecodeImage;
        this.resizeAndRotateEnabledForNetwork = builder.resizeAndRotateEnabledForNetwork;
        this.bitmapConfig = builder.bitmapConfig;
    }

    public ColorFilter getActualImageColorFilter() {
        return this.actualImageColorFilter;
    }

    public ImageScaleType getActualImageScaleType() {
        return this.actualImageScaleType;
    }

    public float getAspectRatio() {
        return this.aspectRatio;
    }

    public Drawable getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    public Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    public int getBorderColor() {
        return this.borderColor;
    }

    public float getBorderWidth() {
        return this.borderWidth;
    }

    public float getBottomLeft() {
        return this.bottomLeft;
    }

    public float getBottomRight() {
        return this.bottomRight;
    }

    public Context getContext() {
        return this.context;
    }

    public int getFadeDuration() {
        return this.fadeDuration;
    }

    public Drawable getFailureImage() {
        return this.failureImage;
    }

    public ImageScaleType getFailureImageScaleType() {
        return this.failureImageScaleType;
    }

    public Drawable getPlaceholderImage() {
        return this.placeholderImage;
    }

    public ImageScaleType getPlaceholderImageScaleType() {
        return this.placeholderImageScaleType;
    }

    public Drawable getProgressBarImage() {
        return this.progressBarImage;
    }

    public ImageScaleType getProgressBarImageScaleType() {
        return this.progressBarImageScaleType;
    }

    public Drawable getRetryImage() {
        return this.retryImage;
    }

    public ImageScaleType getRetryImageScaleType() {
        return this.retryImageScaleType;
    }

    public int getTargetHeight() {
        return this.targetHeight;
    }

    public int getTargetWidth() {
        return this.targetWidth;
    }

    public float getTopLeft() {
        return this.topLeft;
    }

    public float getTopRight() {
        return this.topRight;
    }

    public boolean isCacheInMemory() {
        return this.isCacheInMemory;
    }

    public boolean isCacheOnDisk() {
        return this.isCacheOnDisk;
    }

    public boolean isCircle() {
        return this.isCircle;
    }

    public boolean isDecodeImage() {
        return this.isDecodeImage;
    }

    public boolean isProgressiveRenderingEnabled() {
        return this.progressiveRenderingEnabled;
    }

    public boolean isResizeAndRotateEnabledForNetwork() {
        return this.resizeAndRotateEnabledForNetwork;
    }

    public boolean isSyncLoading() {
        return this.isSyncLoading;
    }
}
