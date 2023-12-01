package com.weimob.library.groups.imageloader.imageaware;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.weimob.library.groups.imageloader.assist.ImageLoaderInfo;
import com.weimob.library.groups.imageloader.core.DisplayImageOptions;
import com.weimob.library.groups.imageloader.core.ImageLoaderConfiguration;
import com.weimob.library.groups.imageloader.core.ImageLoaderTransform;
import com.weimob.library.groups.imageloader.listener.ImageLoadingListener;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/imageaware/NonViewAware.class */
public class NonViewAware implements ImageAware {

    /* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/imageaware/NonViewAware$BitmapDataSubscriber.class */
    static class BitmapDataSubscriber extends BaseBitmapDataSubscriber {
        private Context context;
        private ImageLoadingListener imageLoadingListener;
        private String uri;

        public BitmapDataSubscriber(Context context, String str, ImageLoadingListener imageLoadingListener) {
            this.context = context;
            this.uri = str;
            this.imageLoadingListener = imageLoadingListener;
        }

        protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            ImageLoadingListener imageLoadingListener = this.imageLoadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingFailed(this.uri, null);
            }
        }

        protected void onNewResultImpl(Bitmap bitmap) {
            ImageLoadingListener imageLoadingListener = this.imageLoadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingComplete(this.uri, (View) null, new BitmapDrawable(this.context.getResources(), bitmap));
            }
        }

        public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            if (!dataSource.isFinished()) {
                ImageLoadingListener imageLoadingListener = this.imageLoadingListener;
                if (imageLoadingListener != null) {
                    imageLoadingListener.onLoadingFailed(this.uri, null);
                    return;
                }
                return;
            }
            CloseableReference<?> closeableReference = (CloseableReference) dataSource.getResult();
            Bitmap underlyingBitmap = (closeableReference == null || !(closeableReference.get() instanceof CloseableBitmap)) ? null : ((CloseableBitmap) closeableReference.get()).getUnderlyingBitmap();
            ImageLoaderInfo imageLoaderInfo = new ImageLoaderInfo();
            imageLoaderInfo.bitmap = underlyingBitmap;
            imageLoaderInfo.setCloseableImageRef(closeableReference);
            onNewResultImpl(underlyingBitmap);
            ImageLoadingListener imageLoadingListener2 = this.imageLoadingListener;
            if (imageLoadingListener2 != null) {
                imageLoadingListener2.onLoadingComplete(this.uri, (View) null, imageLoaderInfo);
            }
        }

        public void onProgressUpdate(DataSource<CloseableReference<CloseableImage>> dataSource) {
            ImageLoadingListener imageLoadingListener;
            super.onProgressUpdate(dataSource);
            if (dataSource == null || (imageLoadingListener = this.imageLoadingListener) == null) {
                return;
            }
            imageLoadingListener.onLoadingProgressUpdate(this.uri, null, dataSource.getProgress(), 1.0f);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/imageaware/NonViewAware$DataByteBufferSubscriber.class */
    static class DataByteBufferSubscriber extends BaseDataSubscriber<CloseableReference<PooledByteBuffer>> {
        private Context context;
        private ImageLoadingListener imageLoadingListener;
        private String uri;

        public DataByteBufferSubscriber(Context context, String str, ImageLoadingListener imageLoadingListener) {
            this.context = context;
            this.uri = str;
            this.imageLoadingListener = imageLoadingListener;
        }

        protected void onFailureImpl(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
            ImageLoadingListener imageLoadingListener = this.imageLoadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingFailed(this.uri, null);
            }
            CloseableReference.closeSafely((CloseableReference) dataSource.getResult());
        }

        protected void onNewResultImpl(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
            CloseableReference closeableReference;
            EncodedImage encodedImage;
            if (dataSource.isFinished()) {
                if (dataSource != null) {
                    closeableReference = (CloseableReference) dataSource.getResult();
                    encodedImage = new EncodedImage(closeableReference);
                    try {
                        encodedImage.parseMetaData();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    closeableReference = null;
                    encodedImage = null;
                }
                try {
                    ImageLoaderInfo imageLoaderInfo = new ImageLoaderInfo();
                    if (encodedImage != null) {
                        imageLoaderInfo.inputStream = encodedImage.getInputStream();
                        ImageFormat imageFormat = encodedImage.getImageFormat();
                        if (imageFormat != null) {
                            imageLoaderInfo.imageFormat = imageFormat.getName();
                            imageLoaderInfo.fileExtension = imageFormat.getFileExtension();
                        }
                        imageLoaderInfo.rotationAngle = encodedImage.getRotationAngle();
                        imageLoaderInfo.exifOrientation = encodedImage.getExifOrientation();
                        imageLoaderInfo.width = encodedImage.getWidth();
                        imageLoaderInfo.height = encodedImage.getHeight();
                    }
                    if (this.imageLoadingListener != null) {
                        this.imageLoadingListener.onLoadingComplete(this.uri, (View) null, imageLoaderInfo);
                    }
                    CloseableReference.closeSafely(closeableReference);
                } catch (Throwable th) {
                    CloseableReference.closeSafely(closeableReference);
                    throw th;
                }
            }
        }
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public int getHeight() {
        return 0;
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public int getId() {
        return 0;
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public int getMeasuredHeight() {
        return 0;
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public int getMeasuredWidth() {
        return 0;
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public int getWidth() {
        return 0;
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public View getWrappedView() {
        return null;
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public boolean isCollected() {
        return false;
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public void loadImage(String str, String str2, ImageLoaderConfiguration imageLoaderConfiguration, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        if (imageLoadingListener != null) {
            imageLoadingListener.onLoadingStarted(str, null);
        }
        if (imageLoaderConfiguration == null) {
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingFailed(str, null);
                return;
            }
            return;
        }
        DisplayImageOptions displayImageOptions2 = displayImageOptions;
        if (displayImageOptions == null) {
            displayImageOptions2 = imageLoaderConfiguration.getDefaultDisplayImageOptions();
        }
        ImagePipelineFactory imagePipelineFactory = ImageLoaderTransform.getImagePipelineFactory(imageLoaderConfiguration, displayImageOptions2);
        ImageRequest build = ImageLoaderTransform.getImageRequestBuilder(str, this, imageLoaderConfiguration, displayImageOptions2, null).build();
        ImagePipeline imagePipeline = imagePipelineFactory.getImagePipeline();
        if (displayImageOptions2 != null ? displayImageOptions2.isDecodeImage() : true) {
            imagePipeline.fetchDecodedImage(build, imageLoaderConfiguration.getContext()).subscribe(new BitmapDataSubscriber(imageLoaderConfiguration.getContext(), str, imageLoadingListener), (displayImageOptions2 == null || !displayImageOptions2.isSyncLoading()) ? UiThreadImmediateExecutorService.getInstance() : CallerThreadExecutor.getInstance());
        } else {
            imagePipeline.fetchEncodedImage(build, imageLoaderConfiguration.getContext()).subscribe(new DataByteBufferSubscriber(imageLoaderConfiguration.getContext(), str, imageLoadingListener), (displayImageOptions2 == null || !displayImageOptions2.isSyncLoading()) ? UiThreadImmediateExecutorService.getInstance() : CallerThreadExecutor.getInstance());
        }
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public void loadRichText(CharSequence charSequence, ImageLoaderConfiguration imageLoaderConfiguration, DisplayImageOptions displayImageOptions) {
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public boolean setImageBitmap(Bitmap bitmap) {
        return false;
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public boolean setImageDrawable(Drawable drawable) {
        return false;
    }
}
