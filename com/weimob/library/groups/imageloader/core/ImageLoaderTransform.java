package com.weimob.library.groups.imageloader.core;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.backends.pipeline.DraweeConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilderSupplier;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.ImageLoaderGenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.weimob.library.groups.imageloader.Imagepipeline.ImageLoaderImagePipelineFactory;
import com.weimob.library.groups.imageloader.assist.ImageScaleType;
import com.weimob.library.groups.imageloader.cache.disk.ImageLoaderDiskCacheConfig;
import com.weimob.library.groups.imageloader.cache.disk.ImageLoaderDiskStorageCacheFactory;
import com.weimob.library.groups.imageloader.cache.memory.BitmapMemoryCacheParamsSupplier;
import com.weimob.library.groups.imageloader.cache.memory.EncodedMemoryCacheParamsSupplier;
import com.weimob.library.groups.imageloader.cache.memory.ImageLoaderCacheStatsTracker;
import com.weimob.library.groups.imageloader.cache.memory.ImageLoaderMemoryTrimmableRegistry;
import com.weimob.library.groups.imageloader.drawable.AnimationScaleTypeDrawable;
import com.weimob.library.groups.imageloader.executor.CallerThreadExecutorSupplier;
import com.weimob.library.groups.imageloader.executor.ImageLoaderHttpUrlConnectionNetworkFetcher;
import com.weimob.library.groups.imageloader.imageaware.ImageAware;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/core/ImageLoaderTransform.class */
public class ImageLoaderTransform {
    private static ImagePipelineFactory noMemoryImagePipelineFactory;
    private static ImagePipelineFactory noMemoryNoResizeNetworkImagePipelineFactory;
    private static ImagePipelineFactory noMemorySyncImagePipelineFactory;
    private static ImagePipelineFactory noMemorySyncNoResizeNetworkImagePipelineFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.weimob.library.groups.imageloader.core.ImageLoaderTransform$1  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/core/ImageLoaderTransform$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$weimob$library$groups$imageloader$assist$ImageScaleType;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007d -> B:61:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0081 -> B:55:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0085 -> B:51:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0089 -> B:45:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x008d -> B:59:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0091 -> B:53:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0095 -> B:49:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0099 -> B:43:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x009d -> B:57:0x0070). Please submit an issue!!! */
        static {
            int[] iArr = new int[ImageScaleType.values().length];
            $SwitchMap$com$weimob$library$groups$imageloader$assist$ImageScaleType = iArr;
            try {
                iArr[ImageScaleType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$weimob$library$groups$imageloader$assist$ImageScaleType[ImageScaleType.FIT_XY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$weimob$library$groups$imageloader$assist$ImageScaleType[ImageScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$weimob$library$groups$imageloader$assist$ImageScaleType[ImageScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$weimob$library$groups$imageloader$assist$ImageScaleType[ImageScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$weimob$library$groups$imageloader$assist$ImageScaleType[ImageScaleType.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$weimob$library$groups$imageloader$assist$ImageScaleType[ImageScaleType.CENTER_INSIDE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$weimob$library$groups$imageloader$assist$ImageScaleType[ImageScaleType.CENTER_CROP.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$weimob$library$groups$imageloader$assist$ImageScaleType[ImageScaleType.FOCUS_CROP.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$weimob$library$groups$imageloader$assist$ImageScaleType[ImageScaleType.FIT_BOTTOM_START.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    public static void clearDiskCaches() {
        ImagePipelineFactory imagePipelineFactory = noMemoryImagePipelineFactory;
        if (imagePipelineFactory != null) {
            imagePipelineFactory.getImagePipeline().clearDiskCaches();
        }
        ImagePipelineFactory imagePipelineFactory2 = noMemorySyncImagePipelineFactory;
        if (imagePipelineFactory2 != null) {
            imagePipelineFactory2.getImagePipeline().clearDiskCaches();
        }
        ImagePipelineFactory imagePipelineFactory3 = noMemorySyncNoResizeNetworkImagePipelineFactory;
        if (imagePipelineFactory3 != null) {
            imagePipelineFactory3.getImagePipeline().clearDiskCaches();
        }
        ImagePipelineFactory imagePipelineFactory4 = noMemoryNoResizeNetworkImagePipelineFactory;
        if (imagePipelineFactory4 != null) {
            imagePipelineFactory4.getImagePipeline().clearDiskCaches();
        }
    }

    public static void destroy() {
        ImagePipelineFactory imagePipelineFactory = noMemoryImagePipelineFactory;
        if (imagePipelineFactory != null) {
            imagePipelineFactory.getImagePipeline().clearMemoryCaches();
        }
        ImagePipelineFactory imagePipelineFactory2 = noMemorySyncImagePipelineFactory;
        if (imagePipelineFactory2 != null) {
            imagePipelineFactory2.getImagePipeline().clearMemoryCaches();
        }
        ImagePipelineFactory imagePipelineFactory3 = noMemoryNoResizeNetworkImagePipelineFactory;
        if (imagePipelineFactory3 != null) {
            imagePipelineFactory3.getImagePipeline().clearMemoryCaches();
        }
        ImagePipelineFactory imagePipelineFactory4 = noMemorySyncNoResizeNetworkImagePipelineFactory;
        if (imagePipelineFactory4 != null) {
            imagePipelineFactory4.getImagePipeline().clearMemoryCaches();
        }
        noMemoryImagePipelineFactory = null;
        noMemorySyncImagePipelineFactory = null;
        noMemoryNoResizeNetworkImagePipelineFactory = null;
        noMemorySyncNoResizeNetworkImagePipelineFactory = null;
    }

    public static long getDiskCacheSize() {
        long j;
        ImagePipelineFactory imagePipelineFactory = noMemoryImagePipelineFactory;
        if (imagePipelineFactory != null) {
            long size = imagePipelineFactory.getMainFileCache().getSize();
            long j2 = size > 0 ? size + 0 : 0L;
            long size2 = noMemoryImagePipelineFactory.getSmallImageFileCache().getSize();
            j = j2;
            if (size2 > 0) {
                j = j2 + size2;
            }
        } else {
            j = 0;
        }
        ImagePipelineFactory imagePipelineFactory2 = noMemorySyncImagePipelineFactory;
        long j3 = j;
        if (imagePipelineFactory2 != null) {
            long size3 = imagePipelineFactory2.getMainFileCache().getSize();
            long j4 = j;
            if (size3 > 0) {
                j4 = j + size3;
            }
            long size4 = noMemorySyncImagePipelineFactory.getSmallImageFileCache().getSize();
            j3 = j4;
            if (size4 > 0) {
                j3 = j4 + size4;
            }
        }
        ImagePipelineFactory imagePipelineFactory3 = noMemorySyncNoResizeNetworkImagePipelineFactory;
        long j5 = j3;
        if (imagePipelineFactory3 != null) {
            long size5 = imagePipelineFactory3.getMainFileCache().getSize();
            long j6 = j3;
            if (size5 > 0) {
                j6 = j3 + size5;
            }
            long size6 = noMemorySyncNoResizeNetworkImagePipelineFactory.getSmallImageFileCache().getSize();
            j5 = j6;
            if (size6 > 0) {
                j5 = j6 + size6;
            }
        }
        ImagePipelineFactory imagePipelineFactory4 = noMemoryNoResizeNetworkImagePipelineFactory;
        long j7 = j5;
        if (imagePipelineFactory4 != null) {
            long size7 = imagePipelineFactory4.getMainFileCache().getSize();
            long j8 = j5;
            if (size7 > 0) {
                j8 = j5 + size7;
            }
            long size8 = noMemoryNoResizeNetworkImagePipelineFactory.getSmallImageFileCache().getSize();
            j7 = j8;
            if (size8 > 0) {
                j7 = j8 + size8;
            }
        }
        return j7;
    }

    public static AbstractDraweeControllerBuilder getDraweeController(String str, String str2, ImageAware imageAware, ImageLoaderConfiguration imageLoaderConfiguration, DisplayImageOptions displayImageOptions, Postprocessor postprocessor) {
        if (imageLoaderConfiguration != null) {
            ImagePipelineFactory imagePipelineFactory = getImagePipelineFactory(imageLoaderConfiguration, displayImageOptions);
            PipelineDraweeControllerBuilder newDraweeControllerBuilder = imagePipelineFactory == Fresco.getImagePipelineFactory() ? Fresco.newDraweeControllerBuilder() : new PipelineDraweeControllerBuilderSupplier(imageLoaderConfiguration.getContext(), imagePipelineFactory, (DraweeConfig) null).get();
            ImageRequest build = getImageRequestBuilder(str, imageAware, imageLoaderConfiguration, displayImageOptions, postprocessor).build();
            newDraweeControllerBuilder.setImageRequest(build);
            if (!TextUtils.isEmpty(str2)) {
                ImageRequestBuilder cacheChoice = ImageRequestBuilder.fromRequest(build).setSource(UriUtil.parseUriOrNull(str2)).setCacheChoice(ImageRequest.CacheChoice.SMALL);
                if (!displayImageOptions.isCacheOnDisk()) {
                    cacheChoice.disableDiskCache();
                }
                newDraweeControllerBuilder.setLowResImageRequest(cacheChoice.build());
            }
            newDraweeControllerBuilder.setAutoPlayAnimations(true);
            newDraweeControllerBuilder.setCallerContext(displayImageOptions != null ? displayImageOptions.getContext() : imageLoaderConfiguration.getContext());
            return newDraweeControllerBuilder;
        }
        return Fresco.newDraweeControllerBuilder();
    }

    public static GenericDraweeHierarchyBuilder getDraweeHierarchy(DisplayImageOptions displayImageOptions) {
        if (displayImageOptions == null) {
            return null;
        }
        ImageLoaderGenericDraweeHierarchyBuilder imageLoaderGenericDraweeHierarchyBuilder = new ImageLoaderGenericDraweeHierarchyBuilder(displayImageOptions.getContext().getResources());
        imageLoaderGenericDraweeHierarchyBuilder.setBackground(displayImageOptions.getBackgroundDrawable()).setPlaceholderImage(displayImageOptions.getPlaceholderImage());
        if (displayImageOptions.getPlaceholderImageScaleType() != null) {
            imageLoaderGenericDraweeHierarchyBuilder.setPlaceholderImageScaleType(getScaleType(displayImageOptions.getPlaceholderImageScaleType()));
        }
        imageLoaderGenericDraweeHierarchyBuilder.setProgressBarImage(getScaleTypeDrawable(displayImageOptions.getProgressBarImage(), displayImageOptions.getProgressBarImageScaleType(), null)).setProgressBarImageScaleType((ScalingUtils.ScaleType) null).setRetryImage(displayImageOptions.getRetryImage());
        if (displayImageOptions.getRetryImageScaleType() != null) {
            imageLoaderGenericDraweeHierarchyBuilder.setRetryImageScaleType(getScaleType(displayImageOptions.getRetryImageScaleType()));
        }
        imageLoaderGenericDraweeHierarchyBuilder.setFailureImage(displayImageOptions.getFailureImage());
        if (displayImageOptions.getFailureImageScaleType() != null) {
            imageLoaderGenericDraweeHierarchyBuilder.setFailureImageScaleType(getScaleType(displayImageOptions.getFailureImageScaleType()));
        }
        if (displayImageOptions.getActualImageScaleType() != null) {
            imageLoaderGenericDraweeHierarchyBuilder.setActualImageScaleType(getScaleType(displayImageOptions.getActualImageScaleType()));
        }
        imageLoaderGenericDraweeHierarchyBuilder.setActualImageColorFilter(displayImageOptions.getActualImageColorFilter());
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.setBorder(displayImageOptions.getBorderColor(), displayImageOptions.getBorderWidth());
        if (displayImageOptions.isCircle()) {
            roundingParams.setRoundAsCircle(displayImageOptions.isCircle());
        } else {
            roundingParams.setCornersRadii(displayImageOptions.getTopLeft(), displayImageOptions.getTopRight(), displayImageOptions.getBottomLeft(), displayImageOptions.getBottomRight());
        }
        imageLoaderGenericDraweeHierarchyBuilder.setRoundingParams(roundingParams);
        imageLoaderGenericDraweeHierarchyBuilder.setFadeDuration(displayImageOptions.getFadeDuration());
        imageLoaderGenericDraweeHierarchyBuilder.setDesiredAspectRatio(displayImageOptions.getAspectRatio());
        return imageLoaderGenericDraweeHierarchyBuilder;
    }

    public static ImagePipelineConfig.Builder getImagePipelineConfig(ImageLoaderConfiguration imageLoaderConfiguration) {
        if (imageLoaderConfiguration != null) {
            ImagePipelineConfig.Builder newBuilder = ImagePipelineConfig.newBuilder(imageLoaderConfiguration.getContext());
            newBuilder.setBitmapMemoryCacheParamsSupplier(new BitmapMemoryCacheParamsSupplier(imageLoaderConfiguration.getMaxMemoryCacheSize()));
            newBuilder.setEncodedMemoryCacheParamsSupplier(new EncodedMemoryCacheParamsSupplier(DefaultConfigurationFactory.getEncodeMaxCacheSize()));
            newBuilder.setMemoryTrimmableRegistry(ImageLoaderMemoryTrimmableRegistry.getInstance());
            newBuilder.setImageCacheStatsTracker(ImageLoaderCacheStatsTracker.getInstance().setDebug(imageLoaderConfiguration.isDebug()));
            newBuilder.setMainDiskCacheConfig(ImageLoaderDiskCacheConfig.getInstance().getMainDiskCacheConfig(imageLoaderConfiguration.getContext(), imageLoaderConfiguration.getMaxDiskCacheSize(), imageLoaderConfiguration.isDebug()));
            newBuilder.setSmallImageDiskCacheConfig(ImageLoaderDiskCacheConfig.getInstance().getSmallDiskCacheConfig(imageLoaderConfiguration.getContext(), imageLoaderConfiguration.getMaxDiskCacheSize(), imageLoaderConfiguration.isDebug()));
            newBuilder.setFileCacheFactory(ImageLoaderDiskStorageCacheFactory.getInstance());
            newBuilder.setBitmapsConfig(imageLoaderConfiguration.getBitmapConfig());
            newBuilder.setDownsampleEnabled(true);
            newBuilder.setResizeAndRotateEnabledForNetwork(true);
            return newBuilder;
        }
        return null;
    }

    public static ImagePipelineFactory getImagePipelineFactory(ImageLoaderConfiguration imageLoaderConfiguration, DisplayImageOptions displayImageOptions) {
        if (displayImageOptions != null) {
            if (!displayImageOptions.isCacheInMemory() && displayImageOptions.isSyncLoading() && !displayImageOptions.isResizeAndRotateEnabledForNetwork()) {
                if (noMemorySyncNoResizeNetworkImagePipelineFactory == null) {
                    ImagePipelineConfig.Builder imagePipelineConfig = getImagePipelineConfig(imageLoaderConfiguration);
                    imagePipelineConfig.setBitmapMemoryCacheParamsSupplier(new BitmapMemoryCacheParamsSupplier());
                    imagePipelineConfig.setEncodedMemoryCacheParamsSupplier(new EncodedMemoryCacheParamsSupplier());
                    imagePipelineConfig.setNetworkFetcher(new ImageLoaderHttpUrlConnectionNetworkFetcher(CallerThreadExecutor.getInstance()));
                    imagePipelineConfig.setExecutorSupplier(new CallerThreadExecutorSupplier());
                    imagePipelineConfig.setResizeAndRotateEnabledForNetwork(false);
                    imagePipelineConfig.setBitmapsConfig(Bitmap.Config.ARGB_8888);
                    noMemorySyncNoResizeNetworkImagePipelineFactory = new ImageLoaderImagePipelineFactory(imagePipelineConfig.build());
                }
                return noMemorySyncNoResizeNetworkImagePipelineFactory;
            } else if (!displayImageOptions.isCacheInMemory() && !displayImageOptions.isResizeAndRotateEnabledForNetwork()) {
                if (noMemoryNoResizeNetworkImagePipelineFactory == null) {
                    ImagePipelineConfig.Builder imagePipelineConfig2 = getImagePipelineConfig(imageLoaderConfiguration);
                    imagePipelineConfig2.setBitmapMemoryCacheParamsSupplier(new BitmapMemoryCacheParamsSupplier());
                    imagePipelineConfig2.setEncodedMemoryCacheParamsSupplier(new EncodedMemoryCacheParamsSupplier());
                    imagePipelineConfig2.setResizeAndRotateEnabledForNetwork(false);
                    imagePipelineConfig2.setBitmapsConfig(Bitmap.Config.ARGB_8888);
                    noMemoryNoResizeNetworkImagePipelineFactory = new ImageLoaderImagePipelineFactory(imagePipelineConfig2.build());
                }
                return noMemoryNoResizeNetworkImagePipelineFactory;
            } else if (!displayImageOptions.isCacheInMemory() && displayImageOptions.isSyncLoading()) {
                if (noMemorySyncImagePipelineFactory == null) {
                    ImagePipelineConfig.Builder imagePipelineConfig3 = getImagePipelineConfig(imageLoaderConfiguration);
                    imagePipelineConfig3.setBitmapMemoryCacheParamsSupplier(new BitmapMemoryCacheParamsSupplier());
                    imagePipelineConfig3.setEncodedMemoryCacheParamsSupplier(new EncodedMemoryCacheParamsSupplier());
                    imagePipelineConfig3.setNetworkFetcher(new ImageLoaderHttpUrlConnectionNetworkFetcher(CallerThreadExecutor.getInstance()));
                    imagePipelineConfig3.setExecutorSupplier(new CallerThreadExecutorSupplier());
                    noMemorySyncImagePipelineFactory = new ImageLoaderImagePipelineFactory(imagePipelineConfig3.build());
                }
                return noMemorySyncImagePipelineFactory;
            } else if (!displayImageOptions.isCacheInMemory()) {
                if (noMemoryImagePipelineFactory == null) {
                    ImagePipelineConfig.Builder imagePipelineConfig4 = getImagePipelineConfig(imageLoaderConfiguration);
                    imagePipelineConfig4.setBitmapMemoryCacheParamsSupplier(new BitmapMemoryCacheParamsSupplier());
                    imagePipelineConfig4.setEncodedMemoryCacheParamsSupplier(new EncodedMemoryCacheParamsSupplier());
                    noMemoryImagePipelineFactory = new ImageLoaderImagePipelineFactory(imagePipelineConfig4.build());
                }
                return noMemoryImagePipelineFactory;
            } else if (displayImageOptions.isSyncLoading()) {
                if (noMemorySyncImagePipelineFactory == null) {
                    ImagePipelineConfig.Builder imagePipelineConfig5 = getImagePipelineConfig(imageLoaderConfiguration);
                    imagePipelineConfig5.setBitmapMemoryCacheParamsSupplier(new BitmapMemoryCacheParamsSupplier());
                    imagePipelineConfig5.setEncodedMemoryCacheParamsSupplier(new EncodedMemoryCacheParamsSupplier());
                    imagePipelineConfig5.setNetworkFetcher(new ImageLoaderHttpUrlConnectionNetworkFetcher(CallerThreadExecutor.getInstance()));
                    imagePipelineConfig5.setExecutorSupplier(new CallerThreadExecutorSupplier());
                    noMemorySyncImagePipelineFactory = new ImageLoaderImagePipelineFactory(imagePipelineConfig5.build());
                }
                return noMemorySyncImagePipelineFactory;
            }
        }
        return Fresco.getImagePipelineFactory();
    }

    public static ImageRequestBuilder getImageRequestBuilder(String str, ImageAware imageAware, ImageLoaderConfiguration imageLoaderConfiguration, DisplayImageOptions displayImageOptions, Postprocessor postprocessor) {
        ResizeOptions resizeOptions = getResizeOptions(imageAware, displayImageOptions);
        ImageDecodeOptionsBuilder bitmapConfig = ImageDecodeOptions.newBuilder().setDecodePreviewFrame(true).setBitmapConfig(imageLoaderConfiguration.getBitmapConfig());
        if (displayImageOptions != null && displayImageOptions.isSyncLoading()) {
            bitmapConfig.setMinDecodeIntervalMs(Integer.MIN_VALUE);
        }
        ImageRequestBuilder postprocessor2 = ImageRequestBuilder.newBuilderWithSource(UriUtil.parseUriOrNull(str)).setRotationOptions(RotationOptions.autoRotate()).setProgressiveRenderingEnabled(displayImageOptions != null ? displayImageOptions.isProgressiveRenderingEnabled() : false).setLocalThumbnailPreviewsEnabled(true).setResizeOptions(resizeOptions).setImageDecodeOptions(bitmapConfig.build()).setPostprocessor(postprocessor);
        if (displayImageOptions != null && !displayImageOptions.isCacheOnDisk()) {
            postprocessor2.disableDiskCache();
        }
        return postprocessor2;
    }

    private static ResizeOptions getResizeOptions(ImageAware imageAware, DisplayImageOptions displayImageOptions) {
        ResizeOptions resizeOptions = (displayImageOptions == null || displayImageOptions.getTargetWidth() <= 0 || displayImageOptions.getTargetHeight() <= 0) ? null : new ResizeOptions(displayImageOptions.getTargetWidth(), displayImageOptions.getTargetHeight());
        ResizeOptions resizeOptions2 = resizeOptions;
        if (resizeOptions == null) {
            resizeOptions2 = resizeOptions;
            if (imageAware != null) {
                resizeOptions2 = resizeOptions;
                if (imageAware.getWidth() > 0) {
                    resizeOptions2 = resizeOptions;
                    if (imageAware.getHeight() > 0) {
                        resizeOptions2 = new ResizeOptions(imageAware.getWidth(), imageAware.getHeight());
                    }
                }
            }
        }
        return resizeOptions2;
    }

    public static ScalingUtils.ScaleType getScaleType(ImageScaleType imageScaleType) {
        if (imageScaleType != null) {
            switch (AnonymousClass1.$SwitchMap$com$weimob$library$groups$imageloader$assist$ImageScaleType[imageScaleType.ordinal()]) {
                case 2:
                    return ScalingUtils.ScaleType.FIT_XY;
                case 3:
                    return ScalingUtils.ScaleType.FIT_START;
                case 4:
                    return ScalingUtils.ScaleType.FIT_CENTER;
                case 5:
                    return ScalingUtils.ScaleType.FIT_END;
                case 6:
                    return ScalingUtils.ScaleType.CENTER;
                case 7:
                    return ScalingUtils.ScaleType.CENTER_INSIDE;
                case 8:
                    return ScalingUtils.ScaleType.CENTER_CROP;
                case 9:
                    return ScalingUtils.ScaleType.FOCUS_CROP;
                case 10:
                    return ScalingUtils.ScaleType.FIT_BOTTOM_START;
                default:
                    return null;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.weimob.library.groups.imageloader.drawable.AnimationScaleTypeDrawable, android.graphics.drawable.Drawable] */
    private static Drawable getScaleTypeDrawable(Drawable drawable, ImageScaleType imageScaleType, PointF pointF) {
        ScalingUtils.ScaleType scaleType = getScaleType(imageScaleType);
        if (drawable != null && scaleType != null) {
            ?? animationScaleTypeDrawable = new AnimationScaleTypeDrawable(drawable, scaleType);
            if (pointF != null) {
                animationScaleTypeDrawable.setFocusPoint(pointF);
            }
            return animationScaleTypeDrawable;
        }
        return drawable;
    }

    public static void pause() {
        ImagePipelineFactory imagePipelineFactory = noMemoryImagePipelineFactory;
        if (imagePipelineFactory != null) {
            imagePipelineFactory.getImagePipeline().pause();
        }
        ImagePipelineFactory imagePipelineFactory2 = noMemoryNoResizeNetworkImagePipelineFactory;
        if (imagePipelineFactory2 != null) {
            imagePipelineFactory2.getImagePipeline().pause();
        }
    }

    public static void resume() {
        ImagePipelineFactory imagePipelineFactory = noMemoryImagePipelineFactory;
        if (imagePipelineFactory != null) {
            imagePipelineFactory.getImagePipeline().resume();
        }
        ImagePipelineFactory imagePipelineFactory2 = noMemoryNoResizeNetworkImagePipelineFactory;
        if (imagePipelineFactory2 != null) {
            imagePipelineFactory2.getImagePipeline().resume();
        }
    }
}
