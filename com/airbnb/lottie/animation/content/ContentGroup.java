package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/animation/content/ContentGroup.class */
public class ContentGroup implements DrawingContent, PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    private final Matrix a;
    private final Path b;
    private final RectF c;
    private final String d;
    private final boolean e;
    private final List<Content> f;
    private final LottieDrawable g;
    private List<PathContent> h;
    private TransformKeyframeAnimation i;

    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeGroup shapeGroup) {
        this(lottieDrawable, baseLayer, shapeGroup.a(), shapeGroup.c(), a(lottieDrawable, baseLayer, shapeGroup.b()), a(shapeGroup.b()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, String str, boolean z, List<Content> list, AnimatableTransform animatableTransform) {
        this.a = new Matrix();
        this.b = new Path();
        this.c = new RectF();
        this.d = str;
        this.g = lottieDrawable;
        this.e = z;
        this.f = list;
        if (animatableTransform != null) {
            TransformKeyframeAnimation j = animatableTransform.j();
            this.i = j;
            j.a(baseLayer);
            this.i.a(this);
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                break;
            }
            Content content = list.get(i);
            if (content instanceof GreedyContent) {
                arrayList.add((GreedyContent) content);
            }
            size = i;
        }
        int size2 = arrayList.size();
        while (true) {
            int i2 = size2 - 1;
            if (i2 < 0) {
                return;
            }
            ((GreedyContent) arrayList.get(i2)).a(list.listIterator(list.size()));
            size2 = i2;
        }
    }

    static AnimatableTransform a(List<ContentModel> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return null;
            }
            ContentModel contentModel = list.get(i2);
            if (contentModel instanceof AnimatableTransform) {
                return (AnimatableTransform) contentModel;
            }
            i = i2 + 1;
        }
    }

    private static List<Content> a(LottieDrawable lottieDrawable, BaseLayer baseLayer, List<ContentModel> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return arrayList;
            }
            Content a = list.get(i2).a(lottieDrawable, baseLayer);
            if (a != null) {
                arrayList.add(a);
            }
            i = i2 + 1;
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        this.g.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void a(Canvas canvas, Matrix matrix, int i) {
        if (this.e) {
            return;
        }
        this.a.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.i;
        int i2 = i;
        if (transformKeyframeAnimation != null) {
            this.a.preConcat(transformKeyframeAnimation.d());
            i2 = (int) (((((this.i.a() == null ? 100 : this.i.a().g().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        int size = this.f.size();
        while (true) {
            int i3 = size - 1;
            if (i3 < 0) {
                return;
            }
            Content content = this.f.get(i3);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).a(canvas, this.a, i2);
            }
            size = i3;
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.a.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.i;
        if (transformKeyframeAnimation != null) {
            this.a.preConcat(transformKeyframeAnimation.d());
        }
        this.c.set(0.0f, 0.0f, 0.0f, 0.0f);
        int size = this.f.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            Content content = this.f.get(i);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).a(this.c, this.a, z);
                rectF.union(this.c);
            }
            size = i;
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void a(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        if (!keyPath.a(b(), i)) {
            return;
        }
        KeyPath keyPath3 = keyPath2;
        if (!"__container".equals(b())) {
            KeyPath a = keyPath2.a(b());
            keyPath3 = a;
            if (keyPath.c(b(), i)) {
                list.add(a.a(this));
                keyPath3 = a;
            }
        }
        if (!keyPath.d(b(), i)) {
            return;
        }
        int b = keyPath.b(b(), i);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f.size()) {
                return;
            }
            Content content = this.f.get(i3);
            if (content instanceof KeyPathElement) {
                ((KeyPathElement) content).a(keyPath, i + b, list, keyPath3);
            }
            i2 = i3 + 1;
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void a(T t, LottieValueCallback<T> lottieValueCallback) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.i;
        if (transformKeyframeAnimation != null) {
            transformKeyframeAnimation.a(t, lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void a(List<Content> list, List<Content> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f.size());
        arrayList.addAll(list);
        int size = this.f.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            Content content = this.f.get(i);
            content.a(arrayList, this.f.subList(0, i));
            arrayList.add(content);
            size = i;
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String b() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<PathContent> c() {
        if (this.h == null) {
            this.h = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f.size()) {
                    break;
                }
                Content content = this.f.get(i2);
                if (content instanceof PathContent) {
                    this.h.add((PathContent) content);
                }
                i = i2 + 1;
            }
        }
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix d() {
        TransformKeyframeAnimation transformKeyframeAnimation = this.i;
        if (transformKeyframeAnimation != null) {
            return transformKeyframeAnimation.d();
        }
        this.a.reset();
        return this.a;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path e() {
        this.a.reset();
        TransformKeyframeAnimation transformKeyframeAnimation = this.i;
        if (transformKeyframeAnimation != null) {
            this.a.set(transformKeyframeAnimation.d());
        }
        this.b.reset();
        if (this.e) {
            return this.b;
        }
        int size = this.f.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return this.b;
            }
            Content content = this.f.get(i);
            if (content instanceof PathContent) {
                this.b.addPath(((PathContent) content).e(), this.a);
            }
            size = i;
        }
    }
}
