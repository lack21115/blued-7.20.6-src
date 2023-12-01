package io.noties.markwon.image;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/image/AsyncDrawable.class */
public class AsyncDrawable extends Drawable {
    private Drawable.Callback callback;
    private int canvasWidth;
    private final String destination;
    private final ImageSize imageSize;
    private final ImageSizeResolver imageSizeResolver;
    private final AsyncDrawableLoader loader;
    private Drawable result;
    private float textSize;
    private boolean waitingForDimensions;

    /* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/image/AsyncDrawable$WrappedCallback.class */
    class WrappedCallback implements Drawable.Callback {
        private final Drawable.Callback callback;

        WrappedCallback(Drawable.Callback callback) {
            this.callback = callback;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            this.callback.invalidateDrawable(AsyncDrawable.this);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.callback.scheduleDrawable(AsyncDrawable.this, runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.callback.unscheduleDrawable(AsyncDrawable.this, runnable);
        }
    }

    public AsyncDrawable(String str, AsyncDrawableLoader asyncDrawableLoader, ImageSizeResolver imageSizeResolver, ImageSize imageSize) {
        this.destination = str;
        this.loader = asyncDrawableLoader;
        this.imageSizeResolver = imageSizeResolver;
        this.imageSize = imageSize;
        Drawable placeholder = asyncDrawableLoader.placeholder(this);
        if (placeholder != null) {
            setPlaceholderResult(placeholder);
        }
    }

    private void initBounds() {
        if (this.canvasWidth == 0) {
            this.waitingForDimensions = true;
            setBounds(noDimensionsBounds(this.result));
            return;
        }
        this.waitingForDimensions = false;
        Rect resolveBounds = resolveBounds();
        this.result.setBounds(resolveBounds);
        this.result.setCallback(this.callback);
        setBounds(resolveBounds);
        invalidateSelf();
    }

    private static Rect noDimensionsBounds(Drawable drawable) {
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            if (!bounds.isEmpty()) {
                return bounds;
            }
            Rect intrinsicBounds = DrawableUtils.intrinsicBounds(drawable);
            if (!intrinsicBounds.isEmpty()) {
                return intrinsicBounds;
            }
        }
        return new Rect(0, 0, 1, 1);
    }

    private Rect resolveBounds() {
        return this.imageSizeResolver.resolveImageSize(this);
    }

    public void clearResult() {
        Drawable drawable = this.result;
        if (drawable != null) {
            drawable.setCallback(null);
            this.result = null;
            setBounds(0, 0, 0, 0);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (hasResult()) {
            this.result.draw(canvas);
        }
    }

    public String getDestination() {
        return this.destination;
    }

    public ImageSize getImageSize() {
        return this.imageSize;
    }

    public ImageSizeResolver getImageSizeResolver() {
        return this.imageSizeResolver;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (hasResult()) {
            return this.result.getIntrinsicHeight();
        }
        return 1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (hasResult()) {
            return this.result.getIntrinsicWidth();
        }
        return 1;
    }

    public float getLastKnowTextSize() {
        return this.textSize;
    }

    public int getLastKnownCanvasWidth() {
        return this.canvasWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (hasResult()) {
            return this.result.getOpacity();
        }
        return -2;
    }

    public Drawable getResult() {
        return this.result;
    }

    public boolean hasKnownDimensions() {
        return this.canvasWidth > 0;
    }

    @Deprecated
    public boolean hasKnownDimentions() {
        return this.canvasWidth > 0;
    }

    public boolean hasResult() {
        return this.result != null;
    }

    public void initWithKnownDimensions(int i, float f) {
        this.canvasWidth = i;
        this.textSize = f;
        if (this.waitingForDimensions) {
            initBounds();
        }
    }

    public boolean isAttached() {
        return getCallback() != null;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    public void setCallback2(Drawable.Callback callback) {
        this.callback = callback == null ? null : new WrappedCallback(callback);
        super.setCallback(callback);
        if (this.callback != null) {
            Drawable drawable = this.result;
            if (drawable != null && drawable.getCallback() == null) {
                this.result.setCallback(this.callback);
            }
            this.loader.load(this);
            return;
        }
        Drawable drawable2 = this.result;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            Drawable drawable3 = this.result;
            if (drawable3 instanceof Animatable) {
                ((Animatable) drawable3).stop();
            }
        }
        this.loader.cancel(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    protected void setPlaceholderResult(Drawable drawable) {
        Drawable drawable2 = this.result;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        Rect bounds = drawable.getBounds();
        if (!bounds.isEmpty()) {
            this.result = drawable;
            drawable.setCallback(this.callback);
            setBounds(bounds);
            this.waitingForDimensions = false;
            return;
        }
        Rect intrinsicBounds = DrawableUtils.intrinsicBounds(drawable);
        if (intrinsicBounds.isEmpty()) {
            drawable.setBounds(0, 0, 1, 1);
        } else {
            drawable.setBounds(intrinsicBounds);
        }
        setBounds(drawable.getBounds());
        setResult(drawable);
    }

    public void setResult(Drawable drawable) {
        Drawable drawable2 = this.result;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.result = drawable;
        initBounds();
    }

    public String toString() {
        return "AsyncDrawable{destination='" + this.destination + "', imageSize=" + this.imageSize + ", result=" + this.result + ", canvasWidth=" + this.canvasWidth + ", textSize=" + this.textSize + ", waitingForDimensions=" + this.waitingForDimensions + '}';
    }
}
