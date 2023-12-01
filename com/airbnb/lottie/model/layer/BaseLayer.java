package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/layer/BaseLayer.class */
public abstract class BaseLayer implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    final LottieDrawable b;
    final Layer c;
    final TransformKeyframeAnimation d;
    private final String p;
    private MaskKeyframeAnimation q;
    private BaseLayer r;
    private BaseLayer s;
    private List<BaseLayer> t;
    private final Path e = new Path();
    private final Matrix f = new Matrix();
    private final Paint g = new LPaint(1);
    private final Paint h = new LPaint(1, PorterDuff.Mode.DST_IN);
    private final Paint i = new LPaint(1, PorterDuff.Mode.DST_OUT);
    private final Paint j = new LPaint(1);
    private final Paint k = new LPaint(PorterDuff.Mode.CLEAR);
    private final RectF l = new RectF();
    private final RectF m = new RectF();
    private final RectF n = new RectF();
    private final RectF o = new RectF();
    final Matrix a = new Matrix();
    private final List<BaseKeyframeAnimation<?, ?>> u = new ArrayList();
    private boolean v = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.airbnb.lottie.model.layer.BaseLayer$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/layer/BaseLayer$2.class */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0083 -> B:56:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0087 -> B:50:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x008b -> B:8:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x008f -> B:60:0x003e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0093 -> B:54:0x0049). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0097 -> B:48:0x0054). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x009b -> B:44:0x005f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x009f -> B:58:0x006a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00a3 -> B:52:0x0076). Please submit an issue!!! */
        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            b = iArr;
            try {
                iArr[Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            a = iArr2;
            try {
                iArr2[Layer.LayerType.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[Layer.LayerType.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[Layer.LayerType.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[Layer.LayerType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[Layer.LayerType.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
            try {
                a[Layer.LayerType.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[Layer.LayerType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseLayer(LottieDrawable lottieDrawable, Layer layer) {
        this.b = lottieDrawable;
        this.c = layer;
        this.p = layer.f() + "#draw";
        if (layer.l() == Layer.MatteType.INVERT) {
            this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        TransformKeyframeAnimation j = layer.o().j();
        this.d = j;
        j.a((BaseKeyframeAnimation.AnimationListener) this);
        if (layer.j() != null && !layer.j().isEmpty()) {
            MaskKeyframeAnimation maskKeyframeAnimation = new MaskKeyframeAnimation(layer.j());
            this.q = maskKeyframeAnimation;
            for (BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation : maskKeyframeAnimation.b()) {
                baseKeyframeAnimation.a(this);
            }
            for (BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 : this.q.c()) {
                a(baseKeyframeAnimation2);
                baseKeyframeAnimation2.a(this);
            }
        }
        f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BaseLayer a(Layer layer, LottieDrawable lottieDrawable, LottieComposition lottieComposition) {
        switch (AnonymousClass2.a[layer.k().ordinal()]) {
            case 1:
                return new ShapeLayer(lottieDrawable, layer);
            case 2:
                return new CompositionLayer(lottieDrawable, layer, lottieComposition.b(layer.g()), lottieComposition);
            case 3:
                return new SolidLayer(lottieDrawable, layer);
            case 4:
                return new ImageLayer(lottieDrawable, layer);
            case 5:
                return new NullLayer(lottieDrawable, layer);
            case 6:
                return new TextLayer(lottieDrawable, layer);
            default:
                Logger.b("Unknown layer type " + layer.k());
                return null;
        }
    }

    private void a(Canvas canvas) {
        L.a("Layer#clearLayer");
        canvas.drawRect(this.l.left - 1.0f, this.l.top - 1.0f, this.l.right + 1.0f, this.l.bottom + 1.0f, this.k);
        L.b("Layer#clearLayer");
    }

    private void a(Canvas canvas, Matrix matrix) {
        L.a("Layer#saveLayer");
        a(canvas, this.l, this.h, false);
        L.b("Layer#saveLayer");
        for (int i = 0; i < this.q.a().size(); i++) {
            Mask mask = this.q.a().get(i);
            BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation = this.q.b().get(i);
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.q.c().get(i);
            int i2 = AnonymousClass2.b[mask.a().ordinal()];
            if (i2 == 1) {
                if (i == 0) {
                    Paint paint = new Paint();
                    paint.setColor(View.MEASURED_STATE_MASK);
                    canvas.drawRect(this.l, paint);
                }
                if (mask.d()) {
                    d(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                } else {
                    c(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                }
            } else if (i2 != 2) {
                if (i2 == 3) {
                    if (mask.d()) {
                        b(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    } else {
                        a(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    }
                }
            } else if (mask.d()) {
                f(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
            } else {
                e(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
            }
        }
        L.a("Layer#restoreLayer");
        canvas.restore();
        L.b("Layer#restoreLayer");
    }

    private void a(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        this.e.set(baseKeyframeAnimation.g());
        this.e.transform(matrix);
        this.g.setAlpha((int) (baseKeyframeAnimation2.g().intValue() * 2.55f));
        canvas.drawPath(this.e, this.g);
    }

    private void a(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, z ? 31 : 19);
        } else {
            canvas.saveLayer(rectF, paint);
        }
    }

    private void a(RectF rectF, Matrix matrix) {
        this.m.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (!e()) {
            return;
        }
        int size = this.q.a().size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                if (rectF.intersect(this.m)) {
                    return;
                }
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
                return;
            }
            Mask mask = this.q.a().get(i2);
            this.e.set(this.q.b().get(i2).g());
            this.e.transform(matrix);
            int i3 = AnonymousClass2.b[mask.a().ordinal()];
            if (i3 == 1) {
                return;
            }
            if ((i3 == 2 || i3 == 3) && mask.d()) {
                return;
            }
            this.e.computeBounds(this.o, false);
            if (i2 == 0) {
                this.m.set(this.o);
            } else {
                RectF rectF2 = this.m;
                rectF2.set(Math.min(rectF2.left, this.o.left), Math.min(this.m.top, this.o.top), Math.max(this.m.right, this.o.right), Math.max(this.m.bottom, this.o.bottom));
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z != this.v) {
            this.v = z;
            g();
        }
    }

    private void b(float f) {
        this.b.r().c().a(this.c.f(), f);
    }

    private void b(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        a(canvas, this.l, this.g, true);
        canvas.drawRect(this.l, this.g);
        this.e.set(baseKeyframeAnimation.g());
        this.e.transform(matrix);
        this.g.setAlpha((int) (baseKeyframeAnimation2.g().intValue() * 2.55f));
        canvas.drawPath(this.e, this.i);
        canvas.restore();
    }

    private void b(RectF rectF, Matrix matrix) {
        if (d() && this.c.l() != Layer.MatteType.INVERT) {
            this.n.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.r.a(this.n, matrix, true);
            if (rectF.intersect(this.n)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void c(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        this.e.set(baseKeyframeAnimation.g());
        this.e.transform(matrix);
        canvas.drawPath(this.e, this.i);
    }

    private void d(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        a(canvas, this.l, this.i, true);
        canvas.drawRect(this.l, this.g);
        this.i.setAlpha((int) (baseKeyframeAnimation2.g().intValue() * 2.55f));
        this.e.set(baseKeyframeAnimation.g());
        this.e.transform(matrix);
        canvas.drawPath(this.e, this.i);
        canvas.restore();
    }

    private void e(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        a(canvas, this.l, this.h, true);
        this.e.set(baseKeyframeAnimation.g());
        this.e.transform(matrix);
        this.g.setAlpha((int) (baseKeyframeAnimation2.g().intValue() * 2.55f));
        canvas.drawPath(this.e, this.g);
        canvas.restore();
    }

    private void f() {
        boolean z = true;
        if (this.c.d().isEmpty()) {
            a(true);
            return;
        }
        final FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(this.c.d());
        floatKeyframeAnimation.a();
        floatKeyframeAnimation.a(new BaseKeyframeAnimation.AnimationListener() { // from class: com.airbnb.lottie.model.layer.BaseLayer.1
            @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
            public void a() {
                BaseLayer.this.a(floatKeyframeAnimation.i() == 1.0f);
            }
        });
        if (floatKeyframeAnimation.g().floatValue() != 1.0f) {
            z = false;
        }
        a(z);
        a(floatKeyframeAnimation);
    }

    private void f(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        a(canvas, this.l, this.h, true);
        canvas.drawRect(this.l, this.g);
        this.i.setAlpha((int) (baseKeyframeAnimation2.g().intValue() * 2.55f));
        this.e.set(baseKeyframeAnimation.g());
        this.e.transform(matrix);
        canvas.drawPath(this.e, this.i);
        canvas.restore();
    }

    private void g() {
        this.b.invalidateSelf();
    }

    private void h() {
        if (this.t != null) {
            return;
        }
        if (this.s == null) {
            this.t = Collections.emptyList();
            return;
        }
        this.t = new ArrayList();
        BaseLayer baseLayer = this.s;
        while (true) {
            BaseLayer baseLayer2 = baseLayer;
            if (baseLayer2 == null) {
                return;
            }
            this.t.add(baseLayer2);
            baseLayer = baseLayer2.s;
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        this.d.a(f);
        if (this.q != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.q.b().size()) {
                    break;
                }
                this.q.b().get(i2).a(f);
                i = i2 + 1;
            }
        }
        float f2 = f;
        if (this.c.b() != 0.0f) {
            f2 = f / this.c.b();
        }
        BaseLayer baseLayer = this.r;
        int i3 = 0;
        if (baseLayer != null) {
            this.r.a(baseLayer.c.b() * f2);
            i3 = 0;
        }
        while (i3 < this.u.size()) {
            this.u.get(i3).a(f2);
            i3++;
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void a(Canvas canvas, Matrix matrix, int i) {
        L.a(this.p);
        if (!this.v || this.c.v()) {
            L.b(this.p);
            return;
        }
        h();
        L.a("Layer#parentMatrix");
        this.f.reset();
        this.f.set(matrix);
        int size = this.t.size();
        while (true) {
            int i2 = size - 1;
            if (i2 < 0) {
                break;
            }
            this.f.preConcat(this.t.get(i2).d.d());
            size = i2;
        }
        L.b("Layer#parentMatrix");
        int intValue = (int) ((((i / 255.0f) * (this.d.a() == null ? 100 : this.d.a().g().intValue())) / 100.0f) * 255.0f);
        if (!d() && !e()) {
            this.f.preConcat(this.d.d());
            L.a("Layer#drawLayer");
            b(canvas, this.f, intValue);
            L.b("Layer#drawLayer");
            b(L.b(this.p));
            return;
        }
        L.a("Layer#computeBounds");
        a(this.l, this.f, false);
        b(this.l, matrix);
        this.f.preConcat(this.d.d());
        a(this.l, this.f);
        L.b("Layer#computeBounds");
        if (!this.l.isEmpty()) {
            L.a("Layer#saveLayer");
            a(canvas, this.l, this.g, true);
            L.b("Layer#saveLayer");
            a(canvas);
            L.a("Layer#drawLayer");
            b(canvas, this.f, intValue);
            L.b("Layer#drawLayer");
            if (e()) {
                a(canvas, this.f);
            }
            if (d()) {
                L.a("Layer#drawMatte");
                L.a("Layer#saveLayer");
                a(canvas, this.l, this.j, false);
                L.b("Layer#saveLayer");
                a(canvas);
                this.r.a(canvas, matrix, intValue);
                L.a("Layer#restoreLayer");
                canvas.restore();
                L.b("Layer#restoreLayer");
                L.b("Layer#drawMatte");
            }
            L.a("Layer#restoreLayer");
            canvas.restore();
            L.b("Layer#restoreLayer");
        }
        b(L.b(this.p));
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.l.set(0.0f, 0.0f, 0.0f, 0.0f);
        h();
        this.a.set(matrix);
        if (z) {
            List<BaseLayer> list = this.t;
            if (list != null) {
                int size = list.size();
                while (true) {
                    int i = size - 1;
                    if (i < 0) {
                        break;
                    }
                    this.a.preConcat(this.t.get(i).d.d());
                    size = i;
                }
            } else {
                BaseLayer baseLayer = this.s;
                if (baseLayer != null) {
                    this.a.preConcat(baseLayer.d.d());
                }
            }
        }
        this.a.preConcat(this.d.d());
    }

    public void a(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        if (baseKeyframeAnimation == null) {
            return;
        }
        this.u.add(baseKeyframeAnimation);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void a(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        if (keyPath.a(b(), i)) {
            KeyPath keyPath3 = keyPath2;
            if (!"__container".equals(b())) {
                KeyPath a = keyPath2.a(b());
                keyPath3 = a;
                if (keyPath.c(b(), i)) {
                    list.add(a.a(this));
                    keyPath3 = a;
                }
            }
            if (keyPath.d(b(), i)) {
                b(keyPath, i + keyPath.b(b(), i), list, keyPath3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(BaseLayer baseLayer) {
        this.r = baseLayer;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void a(T t, LottieValueCallback<T> lottieValueCallback) {
        this.d.a(t, lottieValueCallback);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void a(List<Content> list, List<Content> list2) {
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String b() {
        return this.c.f();
    }

    abstract void b(Canvas canvas, Matrix matrix, int i);

    public void b(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.u.remove(baseKeyframeAnimation);
    }

    void b(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(BaseLayer baseLayer) {
        this.s = baseLayer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer c() {
        return this.c;
    }

    boolean d() {
        return this.r != null;
    }

    boolean e() {
        MaskKeyframeAnimation maskKeyframeAnimation = this.q;
        return (maskKeyframeAnimation == null || maskKeyframeAnimation.b().isEmpty()) ? false : true;
    }
}
