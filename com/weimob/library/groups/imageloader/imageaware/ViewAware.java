package com.weimob.library.groups.imageloader.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/imageaware/ViewAware.class */
public abstract class ViewAware implements ImageAware {
    protected boolean checkActualViewSize;
    protected Reference<View> viewRef;

    public ViewAware(View view) {
        this(view, true);
    }

    public ViewAware(View view, boolean z) {
        if (view == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        this.viewRef = new WeakReference(view);
        this.checkActualViewSize = z;
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public int getHeight() {
        View view = this.viewRef.get();
        int i = 0;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int i2 = 0;
            if (this.checkActualViewSize) {
                i2 = 0;
                if (layoutParams != null) {
                    i2 = 0;
                    if (layoutParams.height != -2) {
                        i2 = view.getHeight();
                    }
                }
            }
            i = i2;
            if (i2 <= 0) {
                i = i2;
                if (layoutParams != null) {
                    i = layoutParams.height;
                }
            }
        }
        return i;
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public int getId() {
        View view = this.viewRef.get();
        return view == null ? super.hashCode() : view.hashCode();
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public int getMeasuredHeight() {
        View view = this.viewRef.get();
        if (view != null) {
            return view.getMeasuredHeight();
        }
        return 0;
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public int getMeasuredWidth() {
        View view = this.viewRef.get();
        if (view != null) {
            return view.getMeasuredWidth();
        }
        return 0;
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public int getWidth() {
        View view = this.viewRef.get();
        int i = 0;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int i2 = 0;
            if (this.checkActualViewSize) {
                i2 = 0;
                if (layoutParams != null) {
                    i2 = 0;
                    if (layoutParams.width != -2) {
                        i2 = view.getWidth();
                    }
                }
            }
            i = i2;
            if (i2 <= 0) {
                i = i2;
                if (layoutParams != null) {
                    i = layoutParams.width;
                }
            }
        }
        return i;
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public View getWrappedView() {
        return this.viewRef.get();
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public boolean isCollected() {
        return this.viewRef.get() == null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void measureView(View view) {
        try {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = layoutParams;
            if (layoutParams == null) {
                layoutParams2 = new ViewGroup.LayoutParams(-1, -2);
            }
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams2.width);
            int i = layoutParams2.height;
            view.measure(childMeasureSpec, i > 0 ? View.MeasureSpec.makeMeasureSpec(i, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public boolean setImageBitmap(Bitmap bitmap) {
        View view;
        if (Looper.myLooper() != Looper.getMainLooper() || (view = this.viewRef.get()) == null) {
            return false;
        }
        setImageBitmapInto(bitmap, view);
        return true;
    }

    protected abstract void setImageBitmapInto(Bitmap bitmap, View view);

    @Override // com.weimob.library.groups.imageloader.imageaware.ImageAware
    public boolean setImageDrawable(Drawable drawable) {
        View view;
        if (Looper.myLooper() != Looper.getMainLooper() || (view = this.viewRef.get()) == null) {
            return false;
        }
        setImageDrawableInto(drawable, view);
        return true;
    }

    protected abstract void setImageDrawableInto(Drawable drawable, View view);
}
