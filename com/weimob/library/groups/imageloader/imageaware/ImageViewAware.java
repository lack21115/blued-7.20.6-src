package com.weimob.library.groups.imageloader.imageaware;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.weimob.library.groups.imageloader.assist.ImageLoaderInfo;
import com.weimob.library.groups.imageloader.core.DisplayImageOptions;
import com.weimob.library.groups.imageloader.core.ImageLoaderConfiguration;
import com.weimob.library.groups.imageloader.core.ImageLoaderTransform;
import com.weimob.library.groups.imageloader.drawable.AnimationScaleTypeDrawable;
import com.weimob.library.groups.imageloader.drawable.OnLevelChangeListener;
import com.weimob.library.groups.imageloader.drawee.ImageDraweeView;
import com.weimob.library.groups.imageloader.listener.ImageLoadingListener;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/imageaware/ImageViewAware.class */
public class ImageViewAware extends ViewAware {
    private DraweeHolder<GenericDraweeHierarchy> draweeHolder;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/imageaware/ImageViewAware$ImageLoaderControllerListener.class */
    public static class ImageLoaderControllerListener implements ControllerListener<ImageInfo> {
        private GenericDraweeHierarchy genericDraweeHierarchy;
        private ImageLoadingListener imageLoadingListener;
        private boolean isDebug;
        private String uri;
        private View view;

        public ImageLoaderControllerListener(String str, View view, GenericDraweeHierarchy genericDraweeHierarchy, ImageLoadingListener imageLoadingListener, boolean z) {
            this.uri = str;
            this.view = view;
            this.genericDraweeHierarchy = genericDraweeHierarchy;
            this.imageLoadingListener = imageLoadingListener;
            this.isDebug = z;
        }

        private Drawable getActualImageDrawable() {
            Drawable topLevelDrawable;
            FadeDrawable fadeDrawable;
            GenericDraweeHierarchy genericDraweeHierarchy = this.genericDraweeHierarchy;
            if (genericDraweeHierarchy == null || (topLevelDrawable = genericDraweeHierarchy.getTopLevelDrawable()) == null || topLevelDrawable.getCurrent() == null) {
                return null;
            }
            if (topLevelDrawable.getCurrent() instanceof FadeDrawable) {
                fadeDrawable = (FadeDrawable) topLevelDrawable.getCurrent();
            } else {
                if (topLevelDrawable.getCurrent() instanceof RoundedCornersDrawable) {
                    RoundedCornersDrawable current = topLevelDrawable.getCurrent();
                    if (current.getCurrent() instanceof FadeDrawable) {
                        fadeDrawable = current.getCurrent();
                    }
                }
                fadeDrawable = null;
            }
            if (fadeDrawable != null) {
                ForwardingDrawable drawable = fadeDrawable.getDrawable(2);
                if (drawable instanceof ForwardingDrawable) {
                    return drawable.getDrawable();
                }
                return null;
            }
            return null;
        }

        public void onFailure(String str, Throwable th) {
            if (this.isDebug && th != null) {
                th.printStackTrace();
            }
            ImageLoadingListener imageLoadingListener = this.imageLoadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingFailed(this.uri, this.view);
            }
        }

        public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
            ImageLoadingListener imageLoadingListener = this.imageLoadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingComplete(this.uri, this.view, getActualImageDrawable());
                ImageLoaderInfo imageLoaderInfo = new ImageLoaderInfo();
                imageLoaderInfo.width = imageInfo.getWidth();
                imageLoaderInfo.height = imageInfo.getHeight();
                this.imageLoadingListener.onLoadingComplete(this.uri, this.view, imageLoaderInfo);
            }
        }

        public void onIntermediateImageFailed(String str, Throwable th) {
        }

        public void onIntermediateImageSet(String str, ImageInfo imageInfo) {
            if (this.imageLoadingListener != null) {
                ImageLoaderInfo imageLoaderInfo = new ImageLoaderInfo();
                imageLoaderInfo.width = imageInfo.getWidth();
                imageLoaderInfo.height = imageInfo.getHeight();
                this.imageLoadingListener.onLoadingComplete(this.uri, this.view, imageLoaderInfo);
            }
        }

        public void onRelease(String str) {
        }

        public void onSubmit(String str, Object obj) {
            ImageLoadingListener imageLoadingListener = this.imageLoadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingStarted(this.uri, this.view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/imageaware/ImageViewAware$ImageLoaderOnLevelChangeListener.class */
    public static class ImageLoaderOnLevelChangeListener implements OnLevelChangeListener {
        private ImageLoadingListener imageLoadingListener;
        private String uri;
        private View view;

        public ImageLoaderOnLevelChangeListener(String str, View view, ImageLoadingListener imageLoadingListener) {
            this.uri = str;
            this.view = view;
            this.imageLoadingListener = imageLoadingListener;
        }

        @Override // com.weimob.library.groups.imageloader.drawable.OnLevelChangeListener
        public void onLevelChange(int i) {
            float f = i / 10000.0f;
            ImageLoadingListener imageLoadingListener = this.imageLoadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingProgressUpdate(this.uri, this.view, f, 1.0f);
            }
        }
    }

    public ImageViewAware(ImageView imageView) {
        super(imageView);
        init();
    }

    public ImageViewAware(ImageView imageView, boolean z) {
        super(imageView, z);
        init();
    }

    private Context getContext() {
        ImageView wrappedView = getWrappedView();
        if (wrappedView != null) {
            return wrappedView.getContext();
        }
        return null;
    }

    private DraweeController getOldController(ImageView imageView) {
        return imageView instanceof ImageDraweeView ? ((ImageDraweeView) imageView).getController() : imageView instanceof SimpleDraweeView ? ((SimpleDraweeView) imageView).getController() : this.draweeHolder.getController();
    }

    private void init() {
        this.draweeHolder = DraweeHolder.create((DraweeHierarchy) null, getContext());
    }

    private void setAspectRatio(ImageView imageView, DisplayImageOptions displayImageOptions) {
        if (displayImageOptions != null) {
            if (imageView instanceof ImageDraweeView) {
                ((ImageDraweeView) imageView).setAspectRatio(displayImageOptions.getAspectRatio());
            } else if (imageView instanceof SimpleDraweeView) {
                ((SimpleDraweeView) imageView).setAspectRatio(displayImageOptions.getAspectRatio());
            } else if (displayImageOptions.getAspectRatio() > 0.0f) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                if (layoutParams != null && (layoutParams.width > 0 || layoutParams.height > 0)) {
                    if (layoutParams.width > 0 && layoutParams.height <= 0) {
                        layoutParams.height = (int) (layoutParams.width / displayImageOptions.getAspectRatio());
                        imageView.setLayoutParams(layoutParams);
                        return;
                    } else if (layoutParams.width > 0 || layoutParams.height <= 0) {
                        return;
                    } else {
                        layoutParams.width = (int) (layoutParams.height * displayImageOptions.getAspectRatio());
                        imageView.setLayoutParams(layoutParams);
                        return;
                    }
                }
                int measuredWidth = imageView.getMeasuredWidth();
                int measuredHeight = imageView.getMeasuredHeight();
                if (measuredWidth <= 0 && measuredHeight <= 0) {
                    measureView(imageView);
                }
                int measuredWidth2 = getMeasuredWidth();
                int measuredHeight2 = getMeasuredHeight();
                if (measuredWidth2 > 0 && measuredHeight2 <= 0) {
                    if (layoutParams != null) {
                        layoutParams.height = (int) (measuredWidth2 / displayImageOptions.getAspectRatio());
                        imageView.setLayoutParams(layoutParams);
                    }
                } else if (measuredWidth2 > 0 || measuredHeight2 <= 0 || layoutParams == null) {
                } else {
                    layoutParams.width = (int) (measuredHeight2 * displayImageOptions.getAspectRatio());
                    imageView.setLayoutParams(layoutParams);
                }
            }
        }
    }

    private void setControllerListener(String str, GenericDraweeHierarchy genericDraweeHierarchy, AbstractDraweeController abstractDraweeController, ImageLoadingListener imageLoadingListener, ImageLoaderConfiguration imageLoaderConfiguration) {
        if (imageLoadingListener != null) {
            abstractDraweeController.addControllerListener(new ImageLoaderControllerListener(str, getWrappedView(), genericDraweeHierarchy, imageLoadingListener, imageLoaderConfiguration.isDebug()));
        }
    }

    private void setProgressListener(String str, GenericDraweeHierarchy genericDraweeHierarchy, ImageLoadingListener imageLoadingListener) {
        Drawable topLevelDrawable;
        FadeDrawable fadeDrawable;
        if (imageLoadingListener == null || (topLevelDrawable = genericDraweeHierarchy.getTopLevelDrawable()) == null || topLevelDrawable.getCurrent() == null) {
            return;
        }
        if (topLevelDrawable.getCurrent() instanceof FadeDrawable) {
            fadeDrawable = (FadeDrawable) topLevelDrawable.getCurrent();
        } else {
            fadeDrawable = null;
            if (topLevelDrawable.getCurrent() instanceof RoundedCornersDrawable) {
                RoundedCornersDrawable current = topLevelDrawable.getCurrent();
                fadeDrawable = null;
                if (current.getCurrent() instanceof FadeDrawable) {
                    fadeDrawable = current.getCurrent();
                }
            }
        }
        if (fadeDrawable != null) {
            Drawable drawable = fadeDrawable.getDrawable(3);
            if (drawable instanceof AnimationScaleTypeDrawable) {
                ((AnimationScaleTypeDrawable) drawable).setOnLevelChangeListener(new ImageLoaderOnLevelChangeListener(str, getWrappedView(), imageLoadingListener));
            }
        }
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ViewAware, com.weimob.library.groups.imageloader.imageaware.ImageAware
    public int getHeight() {
        int height = super.getHeight();
        int i = height;
        if (height <= 0) {
            ImageView imageView = (ImageView) this.viewRef.get();
            i = height;
            if (imageView != null) {
                i = imageView.getHeight();
            }
        }
        return i;
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ViewAware, com.weimob.library.groups.imageloader.imageaware.ImageAware
    public int getWidth() {
        int width = super.getWidth();
        int i = width;
        if (width <= 0) {
            ImageView imageView = (ImageView) this.viewRef.get();
            i = width;
            if (imageView != null) {
                i = imageView.getWidth();
            }
        }
        return i;
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ViewAware, com.weimob.library.groups.imageloader.imageaware.ImageAware
    public ImageView getWrappedView() {
        return (ImageView) super.getWrappedView();
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public void loadImage(String str, String str2, ImageLoaderConfiguration imageLoaderConfiguration, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        ImageView wrappedView = getWrappedView();
        if (imageLoaderConfiguration == null || wrappedView == null) {
            return;
        }
        String str3 = str;
        if (TextUtils.isEmpty(str)) {
            str3 = "";
        }
        DisplayImageOptions displayImageOptions2 = displayImageOptions;
        if (displayImageOptions == null) {
            displayImageOptions2 = imageLoaderConfiguration.getDefaultDisplayImageOptions();
        }
        setAspectRatio(wrappedView, displayImageOptions2);
        GenericDraweeHierarchyBuilder draweeHierarchy = ImageLoaderTransform.getDraweeHierarchy(displayImageOptions2);
        if (draweeHierarchy == null) {
            return;
        }
        GenericDraweeHierarchy build = draweeHierarchy.build();
        AbstractDraweeControllerBuilder draweeController = ImageLoaderTransform.getDraweeController(str3, str2, this, imageLoaderConfiguration, displayImageOptions2, null);
        draweeController.setOldController(getOldController(wrappedView));
        AbstractDraweeController build2 = draweeController.build();
        setControllerListener(str3, build, build2, imageLoadingListener, imageLoaderConfiguration);
        setProgressListener(str3, build, imageLoadingListener);
        if (wrappedView instanceof ImageDraweeView) {
            ImageDraweeView imageDraweeView = (ImageDraweeView) wrappedView;
            imageDraweeView.setAspectRatio(draweeHierarchy.getDesiredAspectRatio());
            imageDraweeView.setHierarchy(build);
            imageDraweeView.setController(build2);
        } else if (!(wrappedView instanceof SimpleDraweeView)) {
            this.draweeHolder.setHierarchy(build);
            setImageDrawableInto(build.getTopLevelDrawable(), wrappedView);
            this.draweeHolder.setController(build2);
        } else {
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) wrappedView;
            simpleDraweeView.setAspectRatio(draweeHierarchy.getDesiredAspectRatio());
            simpleDraweeView.setHierarchy(build);
            simpleDraweeView.setController(build2);
        }
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public void loadRichText(CharSequence charSequence, ImageLoaderConfiguration imageLoaderConfiguration, DisplayImageOptions displayImageOptions) {
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ViewAware
    protected void setImageBitmapInto(Bitmap bitmap, View view) {
        if (view != null) {
            ((ImageView) view).setImageBitmap(bitmap);
        }
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ViewAware
    protected void setImageDrawableInto(Drawable drawable, View view) {
        if (drawable != null) {
            drawable.setFilterBitmap(true);
        }
        if (view != null) {
            ((ImageView) view).setImageDrawable(drawable);
        }
    }
}
