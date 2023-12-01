package com.weimob.library.groups.imageloader.core;

import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/core/ImageLoaderHierarchyWrapper.class */
public class ImageLoaderHierarchyWrapper implements SettableDraweeHierarchy {
    private GenericDraweeHierarchy genericDraweeHierarchyDelega;

    public ImageLoaderHierarchyWrapper(GenericDraweeHierarchy genericDraweeHierarchy) {
        this.genericDraweeHierarchyDelega = genericDraweeHierarchy;
    }

    public void getActualImageBounds(RectF rectF) {
        this.genericDraweeHierarchyDelega.getActualImageBounds(rectF);
    }

    public ScalingUtils.ScaleType getActualImageScaleType() {
        return this.genericDraweeHierarchyDelega.getActualImageScaleType();
    }

    public int getFadeDuration() {
        return this.genericDraweeHierarchyDelega.getFadeDuration();
    }

    public RoundingParams getRoundingParams() {
        return this.genericDraweeHierarchyDelega.getRoundingParams();
    }

    public Drawable getTopLevelDrawable() {
        return this.genericDraweeHierarchyDelega.getTopLevelDrawable();
    }

    public boolean hasPlaceholderImage() {
        return this.genericDraweeHierarchyDelega.hasPlaceholderImage();
    }

    public void reset() {
        this.genericDraweeHierarchyDelega.reset();
    }

    public void setActualImageColorFilter(ColorFilter colorFilter) {
        this.genericDraweeHierarchyDelega.setActualImageColorFilter(colorFilter);
    }

    public void setActualImageFocusPoint(PointF pointF) {
        this.genericDraweeHierarchyDelega.setActualImageFocusPoint(pointF);
    }

    public void setActualImageScaleType(ScalingUtils.ScaleType scaleType) {
        this.genericDraweeHierarchyDelega.setActualImageScaleType(scaleType);
    }

    public void setBackgroundImage(Drawable drawable) {
        this.genericDraweeHierarchyDelega.setBackgroundImage(drawable);
    }

    public void setControllerOverlay(Drawable drawable) {
        this.genericDraweeHierarchyDelega.setControllerOverlay(drawable);
    }

    public void setFadeDuration(int i) {
        this.genericDraweeHierarchyDelega.setFadeDuration(i);
    }

    public void setFailure(Throwable th) {
        this.genericDraweeHierarchyDelega.setFailure(th);
    }

    public void setFailureImage(int i) {
        this.genericDraweeHierarchyDelega.setFailureImage(i);
    }

    public void setFailureImage(int i, ScalingUtils.ScaleType scaleType) {
        this.genericDraweeHierarchyDelega.setFailureImage(i, scaleType);
    }

    public void setFailureImage(Drawable drawable) {
        this.genericDraweeHierarchyDelega.setFailureImage(drawable);
    }

    public void setFailureImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        this.genericDraweeHierarchyDelega.setFailureImage(drawable, scaleType);
    }

    public void setImage(Drawable drawable, float f, boolean z) {
        this.genericDraweeHierarchyDelega.setImage(drawable, f, z);
    }

    public void setOverlayImage(int i, Drawable drawable) {
        this.genericDraweeHierarchyDelega.setOverlayImage(i, drawable);
    }

    public void setOverlayImage(Drawable drawable) {
        this.genericDraweeHierarchyDelega.setOverlayImage(drawable);
    }

    public void setPlaceholderImage(int i) {
        this.genericDraweeHierarchyDelega.setPlaceholderImage(i);
    }

    public void setPlaceholderImage(int i, ScalingUtils.ScaleType scaleType) {
        this.genericDraweeHierarchyDelega.setPlaceholderImage(i, scaleType);
    }

    public void setPlaceholderImage(Drawable drawable) {
        this.genericDraweeHierarchyDelega.setPlaceholderImage(drawable);
    }

    public void setPlaceholderImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        this.genericDraweeHierarchyDelega.setPlaceholderImage(drawable, scaleType);
    }

    public void setPlaceholderImageFocusPoint(PointF pointF) {
        this.genericDraweeHierarchyDelega.setPlaceholderImageFocusPoint(pointF);
    }

    public void setProgress(float f, boolean z) {
        this.genericDraweeHierarchyDelega.setProgress(f, z);
    }

    public void setProgressBarImage(int i) {
        this.genericDraweeHierarchyDelega.setProgressBarImage(i);
    }

    public void setProgressBarImage(int i, ScalingUtils.ScaleType scaleType) {
        this.genericDraweeHierarchyDelega.setProgressBarImage(i, scaleType);
    }

    public void setProgressBarImage(Drawable drawable) {
        this.genericDraweeHierarchyDelega.setProgressBarImage(drawable);
    }

    public void setProgressBarImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        this.genericDraweeHierarchyDelega.setProgressBarImage(drawable, scaleType);
    }

    public void setRetry(Throwable th) {
        this.genericDraweeHierarchyDelega.setRetry(th);
    }

    public void setRetryImage(int i) {
        this.genericDraweeHierarchyDelega.setRetryImage(i);
    }

    public void setRetryImage(int i, ScalingUtils.ScaleType scaleType) {
        this.genericDraweeHierarchyDelega.setRetryImage(i, scaleType);
    }

    public void setRetryImage(Drawable drawable) {
        this.genericDraweeHierarchyDelega.setRetryImage(drawable);
    }

    public void setRetryImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        this.genericDraweeHierarchyDelega.setRetryImage(drawable, scaleType);
    }

    public void setRoundingParams(RoundingParams roundingParams) {
        this.genericDraweeHierarchyDelega.setRoundingParams(roundingParams);
    }
}
