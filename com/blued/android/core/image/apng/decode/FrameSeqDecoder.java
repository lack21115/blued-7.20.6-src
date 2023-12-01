package com.blued.android.core.image.apng.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.GlideApp;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.apng.executor.FrameDecoderExecutor;
import com.blued.android.core.image.apng.io.Reader;
import com.blued.android.core.image.apng.io.Writer;
import com.blued.android.core.image.apng.loader.ByteBufferLoader;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/decode/FrameSeqDecoder.class */
public abstract class FrameSeqDecoder<R extends Reader, W extends Writer> {
    private static final Rect l = new Rect();
    protected ByteBuffer e;
    protected volatile Rect f;
    private ByteBufferLoader g;
    private int h;
    private RenderListener j;

    /* renamed from: a  reason: collision with root package name */
    protected List<Frame> f9527a = new ArrayList();
    protected int b = -1;
    private Integer i = null;
    private AtomicBoolean k = new AtomicBoolean(true);
    private Runnable m = null;

    /* renamed from: c  reason: collision with root package name */
    protected int f9528c = 1;
    protected Map<Bitmap, Canvas> d = new WeakHashMap();
    private W o = d();
    private R p = null;
    private boolean q = false;
    private volatile State r = State.IDLE;
    private BitmapPool n = GlideApp.a(AppInfo.d()).a();

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/decode/FrameSeqDecoder$RenderListener.class */
    public interface RenderListener {
        void a();

        void a(ByteBuffer byteBuffer);

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/decode/FrameSeqDecoder$State.class */
    public enum State {
        IDLE,
        RUNNING,
        INITIALIZING,
        FINISHING
    }

    public FrameSeqDecoder(ByteBufferLoader byteBufferLoader, RenderListener renderListener) {
        this.g = byteBufferLoader;
        this.j = renderListener;
    }

    private int a() {
        List<Frame> list = this.f9527a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect) {
        this.f = rect;
        int width = rect.width();
        int height = rect.height();
        int i = this.f9528c;
        this.e = ByteBuffer.allocate((((width * height) / (i * i)) + 1) * 4);
        if (this.o == null) {
            this.o = d();
        }
    }

    private Frame b(int i) {
        if (i < 0 || i >= a()) {
            return null;
        }
        return this.f9527a.get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.k.compareAndSet(true, false);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (a() == 0) {
                if (this.p == null) {
                    this.p = c(this.g.b());
                } else {
                    this.p.reset();
                }
                a(b((FrameSeqDecoder<R, W>) this.p));
            }
            if (ImageLoader.a()) {
                Log.i("IMAGE", "innerStart\n" + o() + ", set state to RUNNING, cost " + (System.currentTimeMillis() - currentTimeMillis));
            }
            this.r = State.RUNNING;
            if (p() == 0 || !this.q) {
                this.b = -1;
                s().run();
                RenderListener renderListener = this.j;
                if (renderListener != null) {
                    renderListener.a();
                }
            } else if (ImageLoader.a()) {
                Log.i("IMAGE", "innerStart\n" + o() + " No need to started");
            }
        } catch (Throwable th) {
            if (ImageLoader.a()) {
                Log.i("IMAGE", "innerStart\n" + o() + ", set state to RUNNING, cost " + (System.currentTimeMillis() - currentTimeMillis));
            }
            this.r = State.RUNNING;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        FrameDecoderExecutor.a().a(this.m);
        this.m = null;
        List<Frame> list = this.f9527a;
        if (list != null) {
            list.clear();
        }
        ByteBuffer byteBuffer = this.e;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        Map<Bitmap, Canvas> map = this.d;
        if (map != null) {
            map.clear();
        }
        try {
            if (this.p != null) {
                this.p.close();
                this.p = null;
            }
            if (this.o != null) {
                this.o.c();
                this.o = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        c();
        if (ImageLoader.a()) {
            Log.i("IMAGE", "innerStop\n" + o() + " release and set state to IDLE");
        }
        this.r = State.IDLE;
        j();
        RenderListener renderListener = this.j;
        if (renderListener != null) {
            renderListener.b();
        }
    }

    private String o() {
        return String.format("Thread is %s, Decoder is %s, state is %s", Thread.currentThread().getName(), toString(), this.r.toString());
    }

    private int p() {
        Integer num = this.i;
        return num != null ? num.intValue() : b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        if (i() && a() != 0) {
            if (p() > 0 && this.h >= p() - 1) {
                if (this.h != p() - 1 || this.b >= a() - 1) {
                    this.q = true;
                    return false;
                } else if (ImageLoader.a()) {
                    Log.v("IMAGE", "canStep playCount = " + this.h + ", frameIndex = " + this.b);
                    return true;
                } else {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long r() {
        int i = this.b + 1;
        this.b = i;
        if (i >= a()) {
            this.b = 0;
            this.h++;
        }
        Frame b = b(this.b);
        if (b == null) {
            return 0L;
        }
        if (ImageLoader.a()) {
            Log.v("IMAGE", "step renderFrame, frameIndex=" + this.b);
        }
        a(b);
        return b.l;
    }

    private Runnable s() {
        if (this.m == null) {
            this.m = new Runnable() { // from class: com.blued.android.core.image.apng.decode.FrameSeqDecoder.5
                @Override // java.lang.Runnable
                public void run() {
                    if (FrameSeqDecoder.this.k.get()) {
                        return;
                    }
                    if (!FrameSeqDecoder.this.q()) {
                        FrameSeqDecoder.this.g();
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    long r = FrameSeqDecoder.this.r();
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (ImageLoader.a()) {
                        Log.v("IMAGE", "renderTask, delay=" + r + ", cost=" + currentTimeMillis2);
                    }
                    FrameDecoderExecutor.a().a(this, Math.max(0L, r - currentTimeMillis2));
                    if (FrameSeqDecoder.this.j != null) {
                        FrameSeqDecoder.this.j.a(FrameSeqDecoder.this.e);
                    }
                }
            };
        }
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap a(int i, int i2) {
        return this.n.b(i, i2, Bitmap.Config.ARGB_8888);
    }

    public void a(int i) {
        this.i = Integer.valueOf(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Bitmap bitmap) {
        if (bitmap != null) {
            this.n.a(bitmap);
        }
    }

    protected abstract void a(Frame frame);

    protected abstract int b();

    protected abstract Rect b(R r) throws IOException;

    public void b(int i, int i2) {
        int c2 = c(i, i2);
        if (c2 != this.f9528c) {
            this.f9528c = c2;
            final boolean i3 = i();
            FrameDecoderExecutor.a().a(this.m);
            FrameDecoderExecutor.a().b(new Runnable() { // from class: com.blued.android.core.image.apng.decode.FrameSeqDecoder.4
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    FrameSeqDecoder.this.n();
                    try {
                        FrameSeqDecoder.this.a(FrameSeqDecoder.this.b((FrameSeqDecoder) FrameSeqDecoder.this.c(FrameSeqDecoder.this.g.b())));
                        if (i3) {
                            FrameSeqDecoder.this.m();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    protected int c(int i, int i2) {
        int i3 = 1;
        if (i != 0) {
            if (i2 != 0) {
                int min = Math.min(e().width() / i, e().height() / i2);
                int i4 = 1;
                while (true) {
                    int i5 = i4;
                    int i6 = i5 * 2;
                    i3 = i5;
                    if (i6 > min) {
                        break;
                    }
                    i4 = i6;
                }
            } else {
                return 1;
            }
        }
        return i3;
    }

    protected abstract R c(Reader reader);

    protected abstract void c();

    protected abstract W d();

    public Rect e() {
        if (this.f == null) {
            if (this.r == State.FINISHING && ImageLoader.a()) {
                Log.e("IMAGE", "getBounds, In Finishing, do not interrupt.");
            }
            final Thread currentThread = Thread.currentThread();
            FrameDecoderExecutor.a().b(new Runnable() { // from class: com.blued.android.core.image.apng.decode.FrameSeqDecoder.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (FrameSeqDecoder.this.f == null) {
                            if (FrameSeqDecoder.this.p == null) {
                                FrameSeqDecoder.this.p = FrameSeqDecoder.this.c(FrameSeqDecoder.this.g.b());
                            } else {
                                FrameSeqDecoder.this.p.reset();
                            }
                            FrameSeqDecoder.this.a(FrameSeqDecoder.this.b((FrameSeqDecoder) FrameSeqDecoder.this.p));
                        }
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
            LockSupport.park(currentThread);
        }
        return this.f == null ? l : this.f;
    }

    public void f() {
        if (this.f == l) {
            return;
        }
        if (this.r == State.RUNNING || this.r == State.INITIALIZING) {
            if (ImageLoader.a()) {
                Log.i("IMAGE", "start\n" + o() + " Already started.");
                return;
            }
            return;
        }
        if (ImageLoader.a()) {
            if (this.r == State.FINISHING) {
                Log.e("IMAGE", "start\n" + o() + " Processing, wait for finish at " + this.r);
            }
            Log.i("IMAGE", "start\n" + o() + ", set state to INITIALIZING.");
        }
        this.r = State.INITIALIZING;
        if (FrameDecoderExecutor.a().c()) {
            m();
        } else {
            FrameDecoderExecutor.a().b(new Runnable() { // from class: com.blued.android.core.image.apng.decode.FrameSeqDecoder.2
                @Override // java.lang.Runnable
                public void run() {
                    FrameSeqDecoder.this.m();
                }
            });
        }
    }

    public void g() {
        if (this.f == l) {
            return;
        }
        if (this.r == State.FINISHING || this.r == State.IDLE) {
            if (ImageLoader.a()) {
                Log.i("IMAGE", "stop\n" + o() + " no need to stop");
                return;
            }
            return;
        }
        if (ImageLoader.a()) {
            if (this.r == State.INITIALIZING) {
                Log.e("IMAGE", "stop\n" + o() + " Processing, wait for finish at " + this.r);
            }
            Log.i("IMAGE", "stop\n" + o() + " set state to FINISHING");
        }
        this.r = State.FINISHING;
        if (FrameDecoderExecutor.a().c()) {
            n();
        } else {
            FrameDecoderExecutor.a().b(new Runnable() { // from class: com.blued.android.core.image.apng.decode.FrameSeqDecoder.3
                @Override // java.lang.Runnable
                public void run() {
                    FrameSeqDecoder.this.n();
                }
            });
        }
    }

    public void h() {
        this.g.a().clear();
        this.g = null;
        this.f9527a = null;
        this.d = null;
        this.j = null;
    }

    public boolean i() {
        return this.r == State.RUNNING || this.r == State.INITIALIZING;
    }

    public void j() {
        this.h = 0;
        this.b = -1;
        this.q = false;
    }

    public int k() {
        return this.f9528c;
    }
}
