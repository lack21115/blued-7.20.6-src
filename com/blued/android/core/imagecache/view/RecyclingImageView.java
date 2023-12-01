package com.blued.android.core.imagecache.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.RecyclingImageLoader;
import com.blued.android.core.imagecache.drawable.IRecyclingDrawable;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/view/RecyclingImageView.class */
public class RecyclingImageView extends ImageView {
    public RecyclingImageView(Context context) {
        super(context);
    }

    public RecyclingImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private static void a(Drawable drawable, boolean z) {
        if (drawable instanceof IRecyclingDrawable) {
            ((IRecyclingDrawable) drawable).a(z);
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                a(layerDrawable.getDrawable(i), z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (getDrawable() instanceof IRecyclingDrawable) {
            setImageDrawable(null);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        super.setImageDrawable(drawable);
        a(drawable, true);
        a(drawable2, false);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (isInEditMode() || !LoadOptions.f9592a) {
            setImageResourceInner(i);
        } else {
            setImageResourceOverload(i);
        }
    }

    public void setImageResourceInner(int i) {
        super.setImageResource(i);
    }

    public void setImageResourceOverload(int i) {
        RecyclingImageLoader.a(this, i, null);
    }
}
