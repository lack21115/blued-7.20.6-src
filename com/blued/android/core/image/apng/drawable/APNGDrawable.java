package com.blued.android.core.image.apng.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.GlideApp;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.apng.decode.APNGDecoder;
import com.blued.android.core.image.apng.decode.FrameSeqDecoder;
import com.blued.android.core.image.apng.loader.ByteBufferLoader;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/drawable/APNGDrawable.class */
public class APNGDrawable extends Drawable implements Animatable2Compat, FrameSeqDecoder.RenderListener {
    private volatile APNGDecoder b;
    private Bitmap f;
    private BitmapPool g;

    /* renamed from: a  reason: collision with root package name */
    private final Paint f9541a = new Paint();

    /* renamed from: c  reason: collision with root package name */
    private DrawFilter f9542c = new PaintFlagsDrawFilter(0, 3);
    private Matrix d = new Matrix();
    private ConcurrentHashMap<Animatable2Compat.AnimationCallback, Animatable2Compat.AnimationCallback> e = new ConcurrentHashMap<>();
    private Object h = new Object();
    private int i = 1;
    private Runnable j = new Runnable() { // from class: com.blued.android.core.image.apng.drawable.APNGDrawable.1
        @Override // java.lang.Runnable
        public void run() {
            APNGDrawable.this.invalidateSelf();
        }
    };

    public APNGDrawable(ByteBufferLoader byteBufferLoader) {
        this.f9541a.setAntiAlias(true);
        this.b = new APNGDecoder(byteBufferLoader, this);
        this.b.a(this.i);
        this.g = GlideApp.a(AppInfo.d()).a();
    }

    @Override // com.blued.android.core.image.apng.decode.FrameSeqDecoder.RenderListener
    public void a() {
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.core.image.apng.drawable.APNGDrawable.2
            @Override // java.lang.Runnable
            public void run() {
                for (Animatable2Compat.AnimationCallback animationCallback : APNGDrawable.this.e.values()) {
                    animationCallback.onAnimationStart(APNGDrawable.this);
                }
            }
        });
    }

    public void a(int i) {
        this.i = i;
        this.b.a(i);
    }

    @Override // com.blued.android.core.image.apng.decode.FrameSeqDecoder.RenderListener
    public void a(ByteBuffer byteBuffer) {
        if (this.b == null || !this.b.i()) {
            return;
        }
        synchronized (this.h) {
            if (this.b != null && this.b.i()) {
                if (this.f == null || this.f.isRecycled()) {
                    this.f = this.g.a(this.b.e().width() / this.b.k(), this.b.e().height() / this.b.k(), Bitmap.Config.ARGB_8888);
                }
                if (byteBuffer == null) {
                    this.f.eraseColor(0);
                } else {
                    byteBuffer.rewind();
                    if (byteBuffer.remaining() < this.f.getByteCount()) {
                        Log.e("IMAGE", "onRender:Buffer not large enough for pixels");
                        return;
                    }
                    this.f.copyPixelsFromBuffer(byteBuffer);
                }
                AppInfo.n().post(this.j);
            }
        }
    }

    @Override // com.blued.android.core.image.apng.decode.FrameSeqDecoder.RenderListener
    public void b() {
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.core.image.apng.drawable.APNGDrawable.3
            @Override // java.lang.Runnable
            public void run() {
                if (ImageLoader.a()) {
                    Log.d("IMAGE", this + ", onEnd ");
                }
                for (Animatable2Compat.AnimationCallback animationCallback : APNGDrawable.this.e.values()) {
                    animationCallback.onAnimationEnd(APNGDrawable.this);
                }
            }
        });
    }

    public void c() {
        if (ImageLoader.a()) {
            Log.d("IMAGE", toString() + ", recycle");
        }
        AppInfo.n().removeCallbacks(this.j);
        this.j = null;
        this.b.h();
        this.b = null;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        this.e.clear();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        if (ImageLoader.a()) {
            Log.v("IMAGE", this + ", draw ");
        }
        canvas.setDrawFilter(this.f9542c);
        canvas.drawBitmap(this.f, this.d, this.f9541a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Rect e = this.b.e();
        if (e != null) {
            return e.height();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Rect e = this.b.e();
        if (e != null) {
            return e.width();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.b.i();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        this.e.put(animationCallback, animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f9541a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.b.b(getBounds().width(), getBounds().height());
        this.d.setScale(((getBounds().width() * 1.0f) * this.b.k()) / this.b.e().width(), ((getBounds().height() * 1.0f) * this.b.k()) / this.b.e().height());
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f9541a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (ImageLoader.a()) {
            Log.d("IMAGE", toString() + ", visible:" + z + ", restart:" + z2);
        }
        if (!z) {
            if (isRunning()) {
                stop();
            }
            return super.setVisible(false, z2);
        }
        boolean visible = super.setVisible(true, z2);
        if (this.i < 0 && !isRunning()) {
            start();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (ImageLoader.a()) {
            Log.d("IMAGE", toString() + ", start, isVisible=" + isVisible());
        }
        if (isVisible()) {
            synchronized (this.h) {
                if (this.f != null && !this.f.isRecycled()) {
                    this.f.eraseColor(0);
                }
            }
            this.b.f();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (ImageLoader.a()) {
            Log.d("IMAGE", toString() + ", @" + Thread.currentThread().getName() + ", stop");
        }
        this.b.g();
        synchronized (this.h) {
            if (this.f != null && !this.f.isRecycled()) {
                if (this.i == 1) {
                    this.f.recycle();
                } else {
                    this.g.a(this.f);
                }
                this.f = null;
            }
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        this.e.remove(animationCallback);
        return true;
    }
}
