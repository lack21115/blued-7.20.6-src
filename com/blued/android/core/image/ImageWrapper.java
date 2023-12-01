package com.blued.android.core.image;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.apng.AnimationRequestListener;
import com.blued.android.core.image.http.HttpRequestListener;
import com.blued.android.core.net.IRequestHost;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import java.util.ArrayList;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/ImageWrapper.class */
public class ImageWrapper {

    /* renamed from: a  reason: collision with root package name */
    private RequestBuilder f9509a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private ImageLoadResult f9510c;
    private ImageLoader.OnAnimationStateListener f;
    private int d = 0;
    private int e = 1;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int[] l = null;
    private float m = 0.0f;
    private float n = 0.0f;
    private boolean o = true;
    private int p = 25;
    private int q = 0;
    private int r = 0;
    private Drawable s = null;
    private String t = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageWrapper(IRequestHost iRequestHost, RequestBuilder requestBuilder) {
        this.b = iRequestHost;
        this.f9509a = requestBuilder;
    }

    private ImageWrapper a(int i, boolean z, int i2) {
        this.d = i;
        this.f9509a.b(DiskCacheStrategy.e).b((Option<Option<Boolean>>) ImageLoaderOptions.b, (Option<Boolean>) Boolean.valueOf(i == 1)).d(!z).b((Option<Option<Integer>>) ImageLoaderOptions.f9506c, (Option<Integer>) Integer.valueOf(i2));
        return this;
    }

    private void b(int i, int i2) {
        this.h = i | (i2 & this.h);
    }

    private void i() {
        if (this.h > 0) {
            ArrayList<Transformation> j = j();
            if (j.size() > 0) {
                this.f9509a.b((Transformation[]) j.toArray(new Transformation[0]));
            }
            if (4096 == this.h) {
                this.f9509a.b(DownsampleStrategy.d);
            }
        }
        ImageLoadResult imageLoadResult = this.f9510c;
        if (imageLoadResult != null) {
            this.f9509a.d(new HttpRequestListener(imageLoadResult));
        }
        if (this.f != null || ((this.d == 1 && this.e != 1) || (this.d == 2 && this.e > 0))) {
            AnimationRequestListener animationRequestListener = new AnimationRequestListener(this.e, this.f);
            if (this.f9510c != null) {
                this.f9509a.c(animationRequestListener);
            } else {
                this.f9509a.d(animationRequestListener);
            }
        }
        int i = this.r;
        if (i != 0) {
            this.f9509a.h(i);
        } else {
            Drawable drawable = this.s;
            if (drawable != null) {
                this.f9509a.b(drawable);
            }
        }
        int i2 = this.q;
        if (i2 != 0) {
            this.f9509a.f(i2).g(this.q);
        }
        if (!TextUtils.isEmpty(this.t)) {
            this.f9509a.b(ImageLoader.a(this.b).b(this.t).e(true));
        }
        int i3 = this.g;
        if (i3 > 0) {
            if (this.r == 0 && this.s == null) {
                this.f9509a.b((TransitionOptions) DrawableTransitionOptions.a(i3));
            } else {
                this.f9509a.b((TransitionOptions) DrawableTransitionOptions.a(new DrawableCrossFadeFactory.Builder(this.g).a(true).a()));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
        if (r0 == 4) goto L79;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.ArrayList<com.bumptech.glide.load.Transformation> j() {
        /*
            Method dump skipped, instructions count: 466
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.core.image.ImageWrapper.j():java.util.ArrayList");
    }

    public ImageWrapper a() {
        this.f9509a.b(DiskCacheStrategy.b).d(true);
        return this;
    }

    public ImageWrapper a(float f) {
        b(3, 15);
        this.k = AppMethods.a(f);
        return this;
    }

    public ImageWrapper a(float f, float f2) {
        b(16, 240);
        this.m = f;
        this.n = f2;
        return this;
    }

    public ImageWrapper a(float f, float f2, float f3, float f4) {
        b(4, 15);
        int[] iArr = new int[4];
        this.l = iArr;
        iArr[0] = AppMethods.a(f);
        this.l[1] = AppMethods.a(f2);
        this.l[2] = AppMethods.a(f3);
        this.l[3] = AppMethods.a(f4);
        return this;
    }

    public ImageWrapper a(float f, int i) {
        b(2, 15);
        this.i = AppMethods.a(f);
        this.j = i;
        return this;
    }

    public ImageWrapper a(int i) {
        this.h |= 256;
        if (i <= 0) {
            i = 25;
        }
        this.p = i;
        return this;
    }

    public ImageWrapper a(int i, int i2) {
        this.f9509a.b(i, i2);
        return this;
    }

    public ImageWrapper a(ImageLoadResult imageLoadResult) {
        this.f9510c = imageLoadResult;
        return this;
    }

    public ImageWrapper a(ImageLoader.OnAnimationStateListener onAnimationStateListener) {
        this.f = onAnimationStateListener;
        return this;
    }

    public ImageWrapper a(ImageOptions imageOptions) {
        if (imageOptions != null) {
            this.r = imageOptions.f9507a;
            this.q = imageOptions.f9508c;
            this.t = imageOptions.b;
        }
        return this;
    }

    public ImageWrapper a(String str) {
        this.t = str;
        return this;
    }

    public ImageWrapper a(boolean z, float f) {
        b(48, 240);
        this.o = z;
        b(3, 15);
        this.k = AppMethods.a(f);
        return this;
    }

    public void a(ImageView imageView) {
        if (imageView != null) {
            i();
            this.f9509a.a(imageView);
        }
    }

    public void a(Target<Drawable> target) {
        if (target != null) {
            i();
            this.f9509a.a((RequestBuilder) target);
        }
    }

    public ImageWrapper b() {
        this.f9509a.b(DiskCacheStrategy.b);
        return this;
    }

    public ImageWrapper b(int i) {
        this.r = i;
        return this;
    }

    public ImageWrapper c() {
        b(1, 15);
        return this;
    }

    public ImageWrapper c(int i) {
        this.g = i;
        return this;
    }

    public ImageWrapper d() {
        this.h |= 256;
        this.p = 25;
        return this;
    }

    public ImageWrapper d(int i) {
        this.q = i;
        return this;
    }

    public ImageWrapper e() {
        this.f9509a.b(DiskCacheStrategy.f20763c).e(Integer.MIN_VALUE);
        return this;
    }

    public ImageWrapper e(int i) {
        return a(1, true, i);
    }

    public ImageWrapper f() {
        return a(1, true, 0);
    }

    public ImageWrapper f(int i) {
        return a(2, true, i);
    }

    public ImageWrapper g() {
        return a(1, false, hashCode());
    }

    public ImageWrapper g(int i) {
        if (i <= 0) {
            i = -1;
        }
        this.e = i;
        return this;
    }

    public ImageWrapper h() {
        return a(2, true, 0);
    }
}
