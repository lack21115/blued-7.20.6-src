package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/gif/GifFrameLoader.class */
public class GifFrameLoader {

    /* renamed from: a  reason: collision with root package name */
    final RequestManager f20994a;
    private final GifDecoder b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f20995c;
    private final List<FrameCallback> d;
    private final BitmapPool e;
    private boolean f;
    private boolean g;
    private boolean h;
    private RequestBuilder<Bitmap> i;
    private DelayTarget j;
    private boolean k;
    private DelayTarget l;
    private Bitmap m;
    private Transformation<Bitmap> n;
    private DelayTarget o;
    private OnEveryFrameListener p;
    private int q;
    private int r;
    private int s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/gif/GifFrameLoader$DelayTarget.class */
    public static class DelayTarget extends CustomTarget<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        final int f20996a;
        private final Handler b;

        /* renamed from: c  reason: collision with root package name */
        private final long f20997c;
        private Bitmap d;

        DelayTarget(Handler handler, int i, long j) {
            this.b = handler;
            this.f20996a = i;
            this.f20997c = j;
        }

        Bitmap a() {
            return this.d;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* renamed from: a */
        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
            this.d = bitmap;
            this.b.sendMessageAtTime(this.b.obtainMessage(1, this), this.f20997c);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
            this.d = null;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/gif/GifFrameLoader$FrameCallback.class */
    public interface FrameCallback {
        void f();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/gif/GifFrameLoader$FrameLoaderCallback.class */
    class FrameLoaderCallback implements Handler.Callback {
        FrameLoaderCallback() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                GifFrameLoader.this.a((DelayTarget) message.obj);
                return true;
            } else if (message.what == 2) {
                GifFrameLoader.this.f20994a.a((DelayTarget) message.obj);
                return false;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/gif/GifFrameLoader$OnEveryFrameListener.class */
    public interface OnEveryFrameListener {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifFrameLoader(Glide glide, GifDecoder gifDecoder, int i, int i2, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this(glide.a(), Glide.b(glide.getContext()), gifDecoder, null, a(Glide.b(glide.getContext()), i, i2), transformation, bitmap);
    }

    GifFrameLoader(BitmapPool bitmapPool, RequestManager requestManager, GifDecoder gifDecoder, Handler handler, RequestBuilder<Bitmap> requestBuilder, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.d = new ArrayList();
        this.f20994a = requestManager;
        Handler handler2 = handler == null ? new Handler(Looper.getMainLooper(), new FrameLoaderCallback()) : handler;
        this.e = bitmapPool;
        this.f20995c = handler2;
        this.i = requestBuilder;
        this.b = gifDecoder;
        a(transformation, bitmap);
    }

    private static RequestBuilder<Bitmap> a(RequestManager requestManager, int i, int i2) {
        return requestManager.f().b(RequestOptions.c(DiskCacheStrategy.b).f(true).d(true).b(i, i2));
    }

    private void k() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.k = false;
        m();
    }

    private void l() {
        this.f = false;
    }

    private void m() {
        if (!this.f || this.g) {
            return;
        }
        if (this.h) {
            Preconditions.a(this.o == null, "Pending target must be null when starting from the first frame");
            this.b.f();
            this.h = false;
        }
        DelayTarget delayTarget = this.o;
        if (delayTarget != null) {
            this.o = null;
            a(delayTarget);
            return;
        }
        this.g = true;
        int c2 = this.b.c();
        this.b.b();
        this.l = new DelayTarget(this.f20995c, this.b.e(), SystemClock.uptimeMillis() + c2);
        this.i.b(RequestOptions.c(o())).b(this.b).a((RequestBuilder<Bitmap>) this.l);
    }

    private void n() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.e.a(bitmap);
            this.m = null;
        }
    }

    private static Key o() {
        return new ObjectKey(Double.valueOf(Math.random()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap a() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.n = (Transformation) Preconditions.a(transformation);
        this.m = (Bitmap) Preconditions.a(bitmap);
        this.i = this.i.b(new RequestOptions().b(transformation));
        this.q = Util.a(bitmap);
        this.r = bitmap.getWidth();
        this.s = bitmap.getHeight();
    }

    void a(DelayTarget delayTarget) {
        OnEveryFrameListener onEveryFrameListener = this.p;
        if (onEveryFrameListener != null) {
            onEveryFrameListener.a();
        }
        this.g = false;
        if (this.k) {
            this.f20995c.obtainMessage(2, delayTarget).sendToTarget();
        } else if (!this.f) {
            this.o = delayTarget;
        } else {
            if (delayTarget.a() != null) {
                n();
                DelayTarget delayTarget2 = this.j;
                this.j = delayTarget;
                int size = this.d.size();
                while (true) {
                    int i = size - 1;
                    if (i < 0) {
                        break;
                    }
                    this.d.get(i).f();
                    size = i;
                }
                if (delayTarget2 != null) {
                    this.f20995c.obtainMessage(2, delayTarget2).sendToTarget();
                }
            }
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FrameCallback frameCallback) {
        if (this.k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.d.contains(frameCallback)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean isEmpty = this.d.isEmpty();
        this.d.add(frameCallback);
        if (isEmpty) {
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(FrameCallback frameCallback) {
        this.d.remove(frameCallback);
        if (this.d.isEmpty()) {
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.b.h() + this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        DelayTarget delayTarget = this.j;
        if (delayTarget != null) {
            return delayTarget.f20996a;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer f() {
        return this.b.a().asReadOnlyBuffer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.b.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.b.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        this.d.clear();
        n();
        l();
        DelayTarget delayTarget = this.j;
        if (delayTarget != null) {
            this.f20994a.a(delayTarget);
            this.j = null;
        }
        DelayTarget delayTarget2 = this.l;
        if (delayTarget2 != null) {
            this.f20994a.a(delayTarget2);
            this.l = null;
        }
        DelayTarget delayTarget3 = this.o;
        if (delayTarget3 != null) {
            this.f20994a.a(delayTarget3);
            this.o = null;
        }
        this.b.j();
        this.k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap j() {
        DelayTarget delayTarget = this.j;
        return delayTarget != null ? delayTarget.a() : this.m;
    }
}
