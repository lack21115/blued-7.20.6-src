package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.widget.MediaController;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import pl.droidsonroids.gif.transforms.Transform;

/* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/GifDrawable.class */
public class GifDrawable extends Drawable implements Animatable, MediaController.MediaPlayerControl {

    /* renamed from: a  reason: collision with root package name */
    final ScheduledThreadPoolExecutor f44129a;
    volatile boolean b;

    /* renamed from: c  reason: collision with root package name */
    long f44130c;
    protected final Paint d;
    final Bitmap e;
    final GifInfoHandle f;
    final ConcurrentLinkedQueue<AnimationListener> g;
    final boolean h;
    final InvalidationHandler i;
    ScheduledFuture<?> j;
    private final Rect k;
    private ColorStateList l;
    private PorterDuffColorFilter m;
    private PorterDuff.Mode n;
    private final RenderTask o;
    private final Rect p;
    private int q;
    private int r;
    private Transform s;

    /* renamed from: pl.droidsonroids.gif.GifDrawable$3  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/GifDrawable$3.class */
    class AnonymousClass3 extends SafeRunnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f44133a;
        final /* synthetic */ GifDrawable b;

        @Override // pl.droidsonroids.gif.SafeRunnable
        public void a() {
            this.b.f.b(this.f44133a, this.b.e);
            this.b.i.sendEmptyMessageAtTime(-1, 0L);
        }
    }

    public GifDrawable(ContentResolver contentResolver, Uri uri) throws IOException {
        this(GifInfoHandle.a(contentResolver, uri), null, null, true);
    }

    public GifDrawable(AssetFileDescriptor assetFileDescriptor) throws IOException {
        this(new GifInfoHandle(assetFileDescriptor), null, null, true);
    }

    public GifDrawable(Resources resources, int i) throws Resources.NotFoundException, IOException {
        this(resources.openRawResourceFd(i));
        float a2 = GifViewUtils.a(resources, i);
        this.r = (int) (this.f.o() * a2);
        this.q = (int) (this.f.n() * a2);
    }

    public GifDrawable(String str) throws IOException {
        this(new GifInfoHandle(str), null, null, true);
    }

    GifDrawable(GifInfoHandle gifInfoHandle, GifDrawable gifDrawable, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z) {
        this.b = true;
        this.f44130c = Long.MIN_VALUE;
        this.k = new Rect();
        this.d = new Paint(6);
        this.g = new ConcurrentLinkedQueue<>();
        this.o = new RenderTask(this);
        this.h = z;
        this.f44129a = scheduledThreadPoolExecutor == null ? GifRenderingExecutor.a() : scheduledThreadPoolExecutor;
        this.f = gifInfoHandle;
        Bitmap bitmap = null;
        if (gifDrawable != null) {
            synchronized (gifDrawable.f) {
                bitmap = null;
                if (!gifDrawable.f.k()) {
                    bitmap = null;
                    if (gifDrawable.f.o() >= this.f.o()) {
                        bitmap = null;
                        if (gifDrawable.f.n() >= this.f.n()) {
                            gifDrawable.f();
                            bitmap = gifDrawable.e;
                            bitmap.eraseColor(0);
                        }
                    }
                }
            }
        }
        if (bitmap == null) {
            this.e = Bitmap.createBitmap(this.f.n(), this.f.o(), Bitmap.Config.ARGB_8888);
        } else {
            this.e = bitmap;
        }
        if (Build.VERSION.SDK_INT >= 12) {
            this.e.setHasAlpha(!gifInfoHandle.q());
        }
        this.p = new Rect(0, 0, this.f.n(), this.f.o());
        this.i = new InvalidationHandler(this);
        this.o.a();
        this.q = this.f.n();
        this.r = this.f.o();
    }

    public GifDrawable(byte[] bArr) throws IOException {
        this(new GifInfoHandle(bArr), null, null, true);
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void f() {
        this.b = false;
        this.i.removeMessages(-1);
        this.f.a();
    }

    private void g() {
        ScheduledFuture<?> scheduledFuture = this.j;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.i.removeMessages(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        if (this.h) {
            this.f44130c = 0L;
            this.i.sendEmptyMessageAtTime(-1, 0L);
            return;
        }
        g();
        this.j = this.f44129a.schedule(this.o, Math.max(j, 0L), TimeUnit.MILLISECONDS);
    }

    public boolean a() {
        return this.f.k();
    }

    public void b() {
        this.f44129a.execute(new SafeRunnable(this) { // from class: pl.droidsonroids.gif.GifDrawable.1
            @Override // pl.droidsonroids.gif.SafeRunnable
            public void a() {
                if (GifDrawable.this.f.c()) {
                    GifDrawable.this.start();
                }
            }
        });
    }

    public int c() {
        return this.f.p();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return c() > 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return c() > 1;
    }

    public int d() {
        return this.f.i();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        if (this.m == null || this.d.getColorFilter() != null) {
            z = false;
        } else {
            this.d.setColorFilter(this.m);
            z = true;
        }
        Transform transform = this.s;
        if (transform == null) {
            canvas.drawBitmap(this.e, this.p, this.k, this.d);
        } else {
            transform.a(canvas, this.d, this.e);
        }
        if (z) {
            this.d.setColorFilter(null);
        }
        if (this.h && this.b) {
            long j = this.f44130c;
            if (j != Long.MIN_VALUE) {
                long max = Math.max(0L, j - SystemClock.uptimeMillis());
                this.f44130c = Long.MIN_VALUE;
                this.f44129a.remove(this.o);
                this.j = this.f44129a.schedule(this.o, max, TimeUnit.MILLISECONDS);
            }
        }
    }

    public int e() {
        int j = this.f.j();
        int i = j;
        if (j != 0) {
            if (j < this.f.e()) {
                return j;
            }
            i = j - 1;
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.d.getAlpha();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 100;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.d.getColorFilter();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.f.h();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.f.g();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return (!this.f.q() || this.d.getAlpha() < 255) ? -2 : -1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.b;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.l;
        return colorStateList != null && colorStateList.isStateful();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.k.set(rect);
        Transform transform = this.s;
        if (transform != null) {
            transform.a(rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.l;
        if (colorStateList == null || (mode = this.n) == null) {
            return false;
        }
        this.m = a(colorStateList, mode);
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        stop();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(final int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Position is not positive");
        }
        this.f44129a.execute(new SafeRunnable(this) { // from class: pl.droidsonroids.gif.GifDrawable.2
            @Override // pl.droidsonroids.gif.SafeRunnable
            public void a() {
                GifDrawable.this.f.a(i, GifDrawable.this.e);
                this.f44170c.i.sendEmptyMessageAtTime(-1, 0L);
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.d.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public void setDither(boolean z) {
        this.d.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.d.setFilterBitmap(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.l = colorStateList;
        this.m = a(colorStateList, this.n);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.n = mode;
        this.m = a(this.l, mode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!this.h) {
            if (z) {
                if (z2) {
                    b();
                }
                if (visible) {
                    start();
                    return visible;
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        synchronized (this) {
            if (this.b) {
                return;
            }
            this.b = true;
            a(this.f.b());
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        synchronized (this) {
            if (this.b) {
                this.b = false;
                g();
                this.f.d();
            }
        }
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, error: %d", Integer.valueOf(this.f.n()), Integer.valueOf(this.f.o()), Integer.valueOf(this.f.p()), Integer.valueOf(this.f.f()));
    }
}
