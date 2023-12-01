package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/LottieDrawable.class */
public class LottieDrawable extends Drawable implements Animatable, Drawable.Callback {
    private static final String c = LottieDrawable.class.getSimpleName();
    FontAssetDelegate a;
    TextDelegate b;
    private LottieComposition e;
    private ImageAssetManager k;
    private String l;
    private ImageAssetDelegate m;
    private FontAssetManager n;
    private boolean o;
    private CompositionLayer p;
    private boolean r;
    private final Matrix d = new Matrix();
    private final LottieValueAnimator f = new LottieValueAnimator();
    private float g = 1.0f;
    private boolean h = true;
    private final Set<ColorFilterData> i = new HashSet();
    private final ArrayList<LazyCompositionTask> j = new ArrayList<>();
    private int q = 255;
    private boolean s = false;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.airbnb.lottie.LottieDrawable$16  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/LottieDrawable$16.class */
    class AnonymousClass16<T> extends LottieValueCallback<T> {
        final /* synthetic */ SimpleLottieValueCallback a;

        @Override // com.airbnb.lottie.value.LottieValueCallback
        public T a(LottieFrameInfo<T> lottieFrameInfo) {
            return (T) this.a.a(lottieFrameInfo);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/LottieDrawable$ColorFilterData.class */
    static class ColorFilterData {
        final String a;
        final String b;
        final ColorFilter c;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ColorFilterData) {
                ColorFilterData colorFilterData = (ColorFilterData) obj;
                return hashCode() == colorFilterData.hashCode() && this.c == colorFilterData.c;
            }
            return false;
        }

        public int hashCode() {
            String str = this.a;
            int hashCode = str != null ? 527 * str.hashCode() : 17;
            String str2 = this.b;
            int i = hashCode;
            if (str2 != null) {
                i = hashCode * 31 * str2.hashCode();
            }
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/LottieDrawable$LazyCompositionTask.class */
    public interface LazyCompositionTask {
        void a(LottieComposition lottieComposition);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/LottieDrawable$RepeatMode.class */
    public @interface RepeatMode {
    }

    public LottieDrawable() {
        this.f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.LottieDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (LottieDrawable.this.p != null) {
                    LottieDrawable.this.p.a(LottieDrawable.this.f.d());
                }
            }
        });
    }

    private float a(Canvas canvas) {
        return Math.min(canvas.getWidth() / this.e.d().width(), canvas.getHeight() / this.e.d().height());
    }

    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private void v() {
        this.p = new CompositionLayer(this, LayerParser.a(this.e), this.e.i(), this.e);
    }

    private void w() {
        if (this.e == null) {
            return;
        }
        float q = q();
        setBounds(0, 0, (int) (this.e.d().width() * q), (int) (this.e.d().height() * q));
    }

    private ImageAssetManager x() {
        if (getCallback() == null) {
            return null;
        }
        ImageAssetManager imageAssetManager = this.k;
        if (imageAssetManager != null && !imageAssetManager.a(getContext())) {
            this.k = null;
        }
        if (this.k == null) {
            this.k = new ImageAssetManager(getCallback(), this.l, this.m, this.e.l());
        }
        return this.k;
    }

    private FontAssetManager y() {
        if (getCallback() == null) {
            return null;
        }
        if (this.n == null) {
            this.n = new FontAssetManager(getCallback(), this.a);
        }
        return this.n;
    }

    public Typeface a(String str, String str2) {
        FontAssetManager y = y();
        if (y != null) {
            return y.a(str, str2);
        }
        return null;
    }

    public List<KeyPath> a(KeyPath keyPath) {
        if (this.p == null) {
            Logger.b("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.p.a(keyPath, 0, arrayList, new KeyPath(new String[0]));
        return arrayList;
    }

    public void a(final float f) {
        LottieComposition lottieComposition = this.e;
        if (lottieComposition == null) {
            this.j.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.5
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void a(LottieComposition lottieComposition2) {
                    LottieDrawable.this.a(f);
                }
            });
        } else {
            a((int) MiscUtils.a(lottieComposition.f(), this.e.g(), f));
        }
    }

    public void a(final float f, final float f2) {
        LottieComposition lottieComposition = this.e;
        if (lottieComposition == null) {
            this.j.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.12
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void a(LottieComposition lottieComposition2) {
                    LottieDrawable.this.a(f, f2);
                }
            });
        } else {
            a((int) MiscUtils.a(lottieComposition.f(), this.e.g(), f), (int) MiscUtils.a(this.e.f(), this.e.g(), f2));
        }
    }

    public void a(final int i) {
        if (this.e == null) {
            this.j.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.4
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.a(i);
                }
            });
        } else {
            this.f.b(i);
        }
    }

    public void a(final int i, final int i2) {
        if (this.e == null) {
            this.j.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.11
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.a(i, i2);
                }
            });
        } else {
            this.f.a(i, i2 + 0.99f);
        }
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.f.addListener(animatorListener);
    }

    public void a(FontAssetDelegate fontAssetDelegate) {
        this.a = fontAssetDelegate;
        FontAssetManager fontAssetManager = this.n;
        if (fontAssetManager != null) {
            fontAssetManager.a(fontAssetDelegate);
        }
    }

    public void a(ImageAssetDelegate imageAssetDelegate) {
        this.m = imageAssetDelegate;
        ImageAssetManager imageAssetManager = this.k;
        if (imageAssetManager != null) {
            imageAssetManager.a(imageAssetDelegate);
        }
    }

    public void a(TextDelegate textDelegate) {
        this.b = textDelegate;
    }

    public <T> void a(final KeyPath keyPath, final T t, final LottieValueCallback<T> lottieValueCallback) {
        if (this.p == null) {
            this.j.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.15
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.a(keyPath, t, lottieValueCallback);
                }
            });
            return;
        }
        boolean z = true;
        if (keyPath.a() != null) {
            keyPath.a().a(t, lottieValueCallback);
        } else {
            List<KeyPath> a = a(keyPath);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= a.size()) {
                    break;
                }
                a.get(i2).a().a(t, lottieValueCallback);
                i = i2 + 1;
            }
            z = true ^ a.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t == LottieProperty.A) {
                d(u());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Boolean bool) {
        this.h = bool.booleanValue();
    }

    public void a(String str) {
        this.l = str;
    }

    public void a(boolean z) {
        if (this.o == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            Logger.b("Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.o = z;
        if (this.e != null) {
            v();
        }
    }

    public boolean a() {
        return this.o;
    }

    public boolean a(LottieComposition lottieComposition) {
        if (this.e == lottieComposition) {
            return false;
        }
        this.s = false;
        d();
        this.e = lottieComposition;
        v();
        this.f.a(lottieComposition);
        d(this.f.getAnimatedFraction());
        e(this.g);
        w();
        Iterator it = new ArrayList(this.j).iterator();
        while (it.hasNext()) {
            ((LazyCompositionTask) it.next()).a(lottieComposition);
            it.remove();
        }
        this.j.clear();
        lottieComposition.b(this.r);
        return true;
    }

    public String b() {
        return this.l;
    }

    public void b(final float f) {
        LottieComposition lottieComposition = this.e;
        if (lottieComposition == null) {
            this.j.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.7
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void a(LottieComposition lottieComposition2) {
                    LottieDrawable.this.b(f);
                }
            });
        } else {
            b((int) MiscUtils.a(lottieComposition.f(), this.e.g(), f));
        }
    }

    public void b(final int i) {
        if (this.e == null) {
            this.j.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.6
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.b(i);
                }
            });
        } else {
            this.f.a(i + 0.99f);
        }
    }

    public void b(final String str) {
        LottieComposition lottieComposition = this.e;
        if (lottieComposition == null) {
            this.j.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.8
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void a(LottieComposition lottieComposition2) {
                    LottieDrawable.this.b(str);
                }
            });
            return;
        }
        Marker c2 = lottieComposition.c(str);
        if (c2 != null) {
            a((int) c2.a);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void b(boolean z) {
        this.r = z;
        LottieComposition lottieComposition = this.e;
        if (lottieComposition != null) {
            lottieComposition.b(z);
        }
    }

    public PerformanceTracker c() {
        LottieComposition lottieComposition = this.e;
        if (lottieComposition != null) {
            return lottieComposition.c();
        }
        return null;
    }

    public void c(float f) {
        this.f.b(f);
    }

    public void c(final int i) {
        if (this.e == null) {
            this.j.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.13
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.c(i);
                }
            });
        } else {
            this.f.a(i);
        }
    }

    public void c(final String str) {
        LottieComposition lottieComposition = this.e;
        if (lottieComposition == null) {
            this.j.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.9
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void a(LottieComposition lottieComposition2) {
                    LottieDrawable.this.c(str);
                }
            });
            return;
        }
        Marker c2 = lottieComposition.c(str);
        if (c2 != null) {
            b((int) (c2.a + c2.b));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void d() {
        if (this.f.isRunning()) {
            this.f.cancel();
        }
        this.e = null;
        this.p = null;
        this.k = null;
        this.f.f();
        invalidateSelf();
    }

    public void d(final float f) {
        LottieComposition lottieComposition = this.e;
        if (lottieComposition == null) {
            this.j.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.14
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void a(LottieComposition lottieComposition2) {
                    LottieDrawable.this.d(f);
                }
            });
        } else {
            c((int) MiscUtils.a(lottieComposition.f(), this.e.g(), f));
        }
    }

    public void d(int i) {
        this.f.setRepeatMode(i);
    }

    public void d(final String str) {
        LottieComposition lottieComposition = this.e;
        if (lottieComposition == null) {
            this.j.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.10
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void a(LottieComposition lottieComposition2) {
                    LottieDrawable.this.d(str);
                }
            });
            return;
        }
        Marker c2 = lottieComposition.c(str);
        if (c2 != null) {
            int i = (int) c2.a;
            a(i, ((int) c2.b) + i);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f;
        this.s = false;
        L.a("Drawable#draw");
        if (this.p == null) {
            return;
        }
        float f2 = this.g;
        float a = a(canvas);
        if (f2 > a) {
            f = this.g / a;
        } else {
            a = f2;
            f = 1.0f;
        }
        int i = -1;
        if (f > 1.0f) {
            i = canvas.save();
            float width = this.e.d().width() / 2.0f;
            float height = this.e.d().height() / 2.0f;
            float f3 = width * a;
            float f4 = height * a;
            canvas.translate((q() * width) - f3, (q() * height) - f4);
            canvas.scale(f, f, f3, f4);
        }
        this.d.reset();
        this.d.preScale(a, a);
        this.p.a(canvas, this.d, this.q);
        L.b("Drawable#draw");
        if (i > 0) {
            canvas.restoreToCount(i);
        }
    }

    public Bitmap e(String str) {
        ImageAssetManager x = x();
        if (x != null) {
            return x.a(str);
        }
        return null;
    }

    public void e() {
        if (this.p == null) {
            this.j.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.2
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.e();
                }
            });
            return;
        }
        if (this.h || m() == 0) {
            this.f.i();
        }
        if (this.h) {
            return;
        }
        c((int) (j() < 0.0f ? h() : i()));
    }

    public void e(float f) {
        this.g = f;
        w();
    }

    public void e(int i) {
        this.f.setRepeatCount(i);
    }

    public void f() {
        this.j.clear();
        this.f.j();
    }

    public void g() {
        if (this.p == null) {
            this.j.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.3
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.g();
                }
            });
        } else {
            this.f.l();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        LottieComposition lottieComposition = this.e;
        if (lottieComposition == null) {
            return -1;
        }
        return (int) (lottieComposition.d().height() * q());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        LottieComposition lottieComposition = this.e;
        if (lottieComposition == null) {
            return -1;
        }
        return (int) (lottieComposition.d().width() * q());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float h() {
        return this.f.m();
    }

    public float i() {
        return this.f.n();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.s) {
            return;
        }
        this.s = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return n();
    }

    public float j() {
        return this.f.h();
    }

    public int k() {
        return (int) this.f.e();
    }

    public int l() {
        return this.f.getRepeatMode();
    }

    public int m() {
        return this.f.getRepeatCount();
    }

    public boolean n() {
        return this.f.isRunning();
    }

    public TextDelegate o() {
        return this.b;
    }

    public boolean p() {
        return this.b == null && this.e.j().size() > 0;
    }

    public float q() {
        return this.g;
    }

    public LottieComposition r() {
        return this.e;
    }

    public void s() {
        this.j.clear();
        this.f.cancel();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.q = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Logger.b("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        e();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        f();
    }

    public void t() {
        this.j.clear();
        this.f.k();
    }

    public float u() {
        return this.f.d();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }
}
