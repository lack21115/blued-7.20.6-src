package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: source-8110460-dex2jar.jar:com/github/chrisbanes/photoview/PhotoView.class */
public class PhotoView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private PhotoViewAttacher f8437a;
    private ImageView.ScaleType b;

    public PhotoView(Context context) {
        this(context, null);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.f8437a = new PhotoViewAttacher(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.b = null;
        }
    }

    public void a(float f, float f2, float f3, boolean z) {
        this.f8437a.a(f, f2, f3, z);
    }

    public void a(float f, boolean z) {
        this.f8437a.a(f, z);
    }

    public PhotoViewAttacher getAttacher() {
        return this.f8437a;
    }

    public RectF getDisplayRect() {
        return this.f8437a.a();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f8437a.g();
    }

    public float getMaximumScale() {
        return this.f8437a.d();
    }

    public float getMediumScale() {
        return this.f8437a.c();
    }

    public float getMinimumScale() {
        return this.f8437a.b();
    }

    public float getScale() {
        return this.f8437a.e();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f8437a.f();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f8437a.a(z);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.f8437a.update();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        PhotoViewAttacher photoViewAttacher = this.f8437a;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        PhotoViewAttacher photoViewAttacher = this.f8437a;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        PhotoViewAttacher photoViewAttacher = this.f8437a;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    public void setMaximumScale(float f) {
        this.f8437a.e(f);
    }

    public void setMediumScale(float f) {
        this.f8437a.d(f);
    }

    public void setMinimumScale(float f) {
        this.f8437a.c(f);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f8437a.a(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f8437a.a(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f8437a.a(onLongClickListener);
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.f8437a.a(onMatrixChangedListener);
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.f8437a.a(onOutsidePhotoTapListener);
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.f8437a.a(onPhotoTapListener);
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
        this.f8437a.a(onScaleChangedListener);
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        this.f8437a.a(onSingleFlingListener);
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener) {
        this.f8437a.a(onViewDragListener);
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.f8437a.a(onViewTapListener);
    }

    public void setRotationBy(float f) {
        this.f8437a.b(f);
    }

    public void setRotationTo(float f) {
        this.f8437a.a(f);
    }

    public void setScale(float f) {
        this.f8437a.f(f);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        PhotoViewAttacher photoViewAttacher = this.f8437a;
        if (photoViewAttacher == null) {
            this.b = scaleType;
        } else {
            photoViewAttacher.a(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i) {
        this.f8437a.a(i);
    }

    public void setZoomable(boolean z) {
        this.f8437a.b(z);
    }
}
