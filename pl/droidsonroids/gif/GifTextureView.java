package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Surface;
import android.view.TextureView;
import android.widget.ImageView;
import java.io.IOException;
import java.lang.ref.WeakReference;
import pl.droidsonroids.gif.InputSource;

/* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/GifTextureView.class */
public class GifTextureView extends TextureView {
    private static final ImageView.ScaleType[] a = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private ImageView.ScaleType b;
    private final Matrix c;
    private InputSource d;
    private boolean e;
    private RenderThread f;
    private float g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: pl.droidsonroids.gif.GifTextureView$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/GifTextureView$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0065 -> B:41:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0069 -> B:37:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006d -> B:49:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0071 -> B:43:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0075 -> B:39:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0079 -> B:35:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007d -> B:47:0x0058). Please submit an issue!!! */
        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/GifTextureView$PlaceholderDrawListener.class */
    public interface PlaceholderDrawListener {
        void a(Canvas canvas);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/GifTextureView$RenderThread.class */
    public static class RenderThread extends Thread implements TextureView.SurfaceTextureListener {
        final ConditionVariable a;
        long[] b;
        private GifInfoHandle c;
        private IOException d;
        private final WeakReference<GifTextureView> e;

        RenderThread(GifTextureView gifTextureView) {
            super("GifRenderThread");
            this.a = new ConditionVariable();
            this.c = new GifInfoHandle();
            this.e = new WeakReference<>(gifTextureView);
        }

        void a(GifTextureView gifTextureView, PlaceholderDrawListener placeholderDrawListener) {
            this.a.b();
            gifTextureView.setSuperSurfaceTextureListener(placeholderDrawListener != null ? new PlaceholderDrawingSurfaceTextureListener(placeholderDrawListener) : null);
            this.c.l();
            interrupt();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            GifTextureView gifTextureView = this.e.get();
            if (gifTextureView != null) {
                gifTextureView.a(this.c);
            }
            this.a.a();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.a.b();
            this.c.l();
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                GifTextureView gifTextureView = this.e.get();
                if (gifTextureView == null) {
                    return;
                }
                GifInfoHandle a = gifTextureView.d.a();
                this.c = a;
                a.a((char) 1, gifTextureView.isOpaque());
                final GifTextureView gifTextureView2 = this.e.get();
                if (gifTextureView2 == null) {
                    this.c.a();
                    return;
                }
                gifTextureView2.setSuperSurfaceTextureListener(this);
                boolean isAvailable = gifTextureView2.isAvailable();
                this.a.a(isAvailable);
                if (isAvailable) {
                    gifTextureView2.post(new Runnable() { // from class: pl.droidsonroids.gif.GifTextureView.RenderThread.1
                        @Override // java.lang.Runnable
                        public void run() {
                            gifTextureView2.a(RenderThread.this.c);
                        }
                    });
                }
                this.c.a(gifTextureView2.g);
                while (!isInterrupted()) {
                    try {
                        this.a.c();
                        SurfaceTexture surfaceTexture = gifTextureView2.getSurfaceTexture();
                        if (surfaceTexture != null) {
                            Surface surface = new Surface(surfaceTexture);
                            try {
                                this.c.a(surface, this.b);
                            } finally {
                                surface.release();
                                surfaceTexture.release();
                            }
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                this.c.a();
                this.c = new GifInfoHandle();
            } catch (IOException e2) {
                this.d = e2;
            }
        }
    }

    public GifTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = ImageView.ScaleType.FIT_CENTER;
        this.c = new Matrix();
        this.g = 1.0f;
        a(attributeSet, 0, 0);
    }

    public GifTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = ImageView.ScaleType.FIT_CENTER;
        this.c = new Matrix();
        this.g = 1.0f;
        a(attributeSet, i, 0);
    }

    private static InputSource a(TypedArray typedArray) {
        TypedValue typedValue = new TypedValue();
        if (typedArray.getValue(R.styleable.GifTextureView_gifSource, typedValue)) {
            if (typedValue.resourceId != 0) {
                String resourceTypeName = typedArray.getResources().getResourceTypeName(typedValue.resourceId);
                if (GifViewUtils.a.contains(resourceTypeName)) {
                    return new InputSource.ResourcesSource(typedArray.getResources(), typedValue.resourceId);
                }
                if (!"string".equals(resourceTypeName)) {
                    throw new IllegalArgumentException("Expected string, drawable, mipmap or raw resource type. '" + resourceTypeName + "' is not supported");
                }
            }
            return new InputSource.AssetSource(typedArray.getResources().getAssets(), typedValue.string.toString());
        }
        return null;
    }

    private void a(AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null) {
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "scaleType", -1);
            if (attributeIntValue >= 0) {
                ImageView.ScaleType[] scaleTypeArr = a;
                if (attributeIntValue < scaleTypeArr.length) {
                    this.b = scaleTypeArr[attributeIntValue];
                }
            }
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GifTextureView, i, i2);
            this.d = a(obtainStyledAttributes);
            super.setOpaque(obtainStyledAttributes.getBoolean(R.styleable.GifTextureView_isOpaque, false));
            obtainStyledAttributes.recycle();
            this.e = GifViewUtils.a(this, attributeSet, i, i2);
        } else {
            super.setOpaque(false);
        }
        if (isInEditMode()) {
            return;
        }
        RenderThread renderThread = new RenderThread(this);
        this.f = renderThread;
        if (this.d != null) {
            renderThread.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GifInfoHandle gifInfoHandle) {
        Matrix matrix = new Matrix();
        float width = getWidth();
        float height = getHeight();
        float n = gifInfoHandle.n() / width;
        float o = gifInfoHandle.o() / height;
        RectF rectF = new RectF(0.0f, 0.0f, gifInfoHandle.n(), gifInfoHandle.o());
        RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
        float f = 1.0f;
        switch (AnonymousClass1.a[this.b.ordinal()]) {
            case 1:
                matrix.setScale(n, o, width / 2.0f, height / 2.0f);
                break;
            case 2:
                float min = 1.0f / Math.min(n, o);
                matrix.setScale(n * min, min * o, width / 2.0f, height / 2.0f);
                break;
            case 3:
                if (gifInfoHandle.n() > width || gifInfoHandle.o() > height) {
                    f = Math.min(1.0f / n, 1.0f / o);
                }
                matrix.setScale(n * f, f * o, width / 2.0f, height / 2.0f);
                break;
            case 4:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                matrix.preScale(n, o);
                break;
            case 5:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                matrix.preScale(n, o);
                break;
            case 6:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                matrix.preScale(n, o);
                break;
            case 7:
                return;
            case 8:
                matrix.set(this.c);
                matrix.preScale(n, o);
                break;
        }
        super.setTransform(matrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuperSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        super.setSurfaceTextureListener(surfaceTextureListener);
    }

    public void a(InputSource inputSource, PlaceholderDrawListener placeholderDrawListener) {
        synchronized (this) {
            this.f.a(this, placeholderDrawListener);
            this.d = inputSource;
            RenderThread renderThread = new RenderThread(this);
            this.f = renderThread;
            if (inputSource != null) {
                renderThread.start();
            }
        }
    }

    public IOException getIOException() {
        return this.f.d != null ? this.f.d : GifIOException.a(this.f.c.f());
    }

    public ImageView.ScaleType getScaleType() {
        return this.b;
    }

    @Override // android.view.TextureView
    public TextureView.SurfaceTextureListener getSurfaceTextureListener() {
        return null;
    }

    @Override // android.view.TextureView
    public Matrix getTransform(Matrix matrix) {
        Matrix matrix2 = matrix;
        if (matrix == null) {
            matrix2 = new Matrix();
        }
        matrix2.set(this.c);
        return matrix2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        this.f.a(this, null);
        super.onDetachedFromWindow();
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        this.f.b = gifViewSavedState.a[0];
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        RenderThread renderThread = this.f;
        renderThread.b = renderThread.c.m();
        return new GifViewSavedState(super.onSaveInstanceState(), this.e ? this.f.b : null);
    }

    public void setFreezesAnimation(boolean z) {
        this.e = z;
    }

    public void setImageMatrix(Matrix matrix) {
        setTransform(matrix);
    }

    public void setInputSource(InputSource inputSource) {
        synchronized (this) {
            a(inputSource, (PlaceholderDrawListener) null);
        }
    }

    @Override // android.view.TextureView
    public void setOpaque(boolean z) {
        if (z != isOpaque()) {
            super.setOpaque(z);
            setInputSource(this.d);
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.b = scaleType;
        a(this.f.c);
    }

    public void setSpeed(float f) {
        this.g = f;
        this.f.c.a(f);
    }

    @Override // android.view.TextureView
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        throw new UnsupportedOperationException("Changing SurfaceTexture is not supported");
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        throw new UnsupportedOperationException("Changing SurfaceTextureListener is not supported");
    }

    @Override // android.view.TextureView
    public void setTransform(Matrix matrix) {
        this.c.set(matrix);
        a(this.f.c);
    }
}
