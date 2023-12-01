package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/layer/TextLayer.class */
public class TextLayer extends BaseLayer {
    private final StringBuilder e;
    private final RectF f;
    private final Matrix g;
    private final Paint h;
    private final Paint i;
    private final Map<FontCharacter, List<ContentGroup>> j;
    private final LongSparseArray<String> k;
    private final TextKeyframeAnimation l;
    private final LottieDrawable m;
    private final LottieComposition n;
    private BaseKeyframeAnimation<Integer, Integer> o;
    private BaseKeyframeAnimation<Integer, Integer> p;
    private BaseKeyframeAnimation<Float, Float> q;
    private BaseKeyframeAnimation<Float, Float> r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.airbnb.lottie.model.layer.TextLayer$3  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/layer/TextLayer$3.class */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[DocumentData.Justification.values().length];
            a = iArr;
            try {
                iArr[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.e = new StringBuilder(2);
        this.f = new RectF();
        this.g = new Matrix();
        this.h = new Paint(1) { // from class: com.airbnb.lottie.model.layer.TextLayer.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.i = new Paint(1) { // from class: com.airbnb.lottie.model.layer.TextLayer.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.j = new HashMap();
        this.k = new LongSparseArray<>();
        this.m = lottieDrawable;
        this.n = layer.a();
        TextKeyframeAnimation a = layer.s().a();
        this.l = a;
        a.a(this);
        a(this.l);
        AnimatableTextProperties t = layer.t();
        if (t != null && t.a != null) {
            BaseKeyframeAnimation<Integer, Integer> a2 = t.a.a();
            this.o = a2;
            a2.a(this);
            a(this.o);
        }
        if (t != null && t.b != null) {
            BaseKeyframeAnimation<Integer, Integer> a3 = t.b.a();
            this.p = a3;
            a3.a(this);
            a(this.p);
        }
        if (t != null && t.c != null) {
            BaseKeyframeAnimation<Float, Float> a4 = t.c.a();
            this.q = a4;
            a4.a(this);
            a(this.q);
        }
        if (t == null || t.d == null) {
            return;
        }
        BaseKeyframeAnimation<Float, Float> a5 = t.d.a();
        this.r = a5;
        a5.a(this);
        a(this.r);
    }

    private float a(String str, Font font, float f, float f2) {
        float f3 = 0.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return f3;
            }
            FontCharacter fontCharacter = (FontCharacter) this.n.j().get(FontCharacter.a(str.charAt(i2), font.a(), font.c()));
            if (fontCharacter != null) {
                f3 = (float) (f3 + (fontCharacter.b() * f * Utils.a() * f2));
            }
            i = i2 + 1;
        }
    }

    private String a(String str, int i) {
        int codePointAt = str.codePointAt(i);
        int charCount = Character.charCount(codePointAt) + i;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!a(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j = codePointAt;
        if (this.k.containsKey(j)) {
            return (String) this.k.get(j);
        }
        this.e.setLength(0);
        while (i < charCount) {
            int codePointAt3 = str.codePointAt(i);
            this.e.appendCodePoint(codePointAt3);
            i += Character.charCount(codePointAt3);
        }
        String sb = this.e.toString();
        this.k.put(j, sb);
        return sb;
    }

    private List<ContentGroup> a(FontCharacter fontCharacter) {
        if (this.j.containsKey(fontCharacter)) {
            return this.j.get(fontCharacter);
        }
        List<ShapeGroup> a = fontCharacter.a();
        int size = a.size();
        ArrayList arrayList = new ArrayList(size);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                this.j.put(fontCharacter, arrayList);
                return arrayList;
            }
            arrayList.add(new ContentGroup(this.m, this, a.get(i2)));
            i = i2 + 1;
        }
    }

    private List<String> a(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void a(DocumentData.Justification justification, Canvas canvas, float f) {
        int i = AnonymousClass3.a[justification.ordinal()];
        if (i == 2) {
            canvas.translate(-f, 0.0f);
        } else if (i != 3) {
        } else {
            canvas.translate((-f) / 2.0f, 0.0f);
        }
    }

    private void a(DocumentData documentData, Matrix matrix, Font font, Canvas canvas) {
        float f = ((float) documentData.c) / 100.0f;
        float a = Utils.a(matrix);
        String str = documentData.a;
        float a2 = ((float) documentData.f) * Utils.a();
        List<String> a3 = a(str);
        int size = a3.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            String str2 = a3.get(i2);
            float a4 = a(str2, font, f, a);
            canvas.save();
            a(documentData.d, canvas, a4);
            canvas.translate(0.0f, (i2 * a2) - (((size - 1) * a2) / 2.0f));
            a(str2, documentData, matrix, font, canvas, a, f);
            canvas.restore();
            i = i2 + 1;
        }
    }

    private void a(DocumentData documentData, Font font, Matrix matrix, Canvas canvas) {
        float a = Utils.a(matrix);
        Typeface a2 = this.m.a(font.a(), font.c());
        if (a2 == null) {
            return;
        }
        String str = documentData.a;
        TextDelegate o = this.m.o();
        String str2 = str;
        if (o != null) {
            str2 = o.a(str);
        }
        this.h.setTypeface(a2);
        this.h.setTextSize((float) (documentData.c * Utils.a()));
        this.i.setTypeface(this.h.getTypeface());
        this.i.setTextSize(this.h.getTextSize());
        float a3 = ((float) documentData.f) * Utils.a();
        List<String> a4 = a(str2);
        int size = a4.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            String str3 = a4.get(i2);
            a(documentData.d, canvas, this.i.measureText(str3));
            canvas.translate(0.0f, (i2 * a3) - (((size - 1) * a3) / 2.0f));
            a(str3, documentData, canvas, a);
            canvas.setMatrix(matrix);
            i = i2 + 1;
        }
    }

    private void a(FontCharacter fontCharacter, Matrix matrix, float f, DocumentData documentData, Canvas canvas) {
        List<ContentGroup> a = a(fontCharacter);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a.size()) {
                return;
            }
            Path e = a.get(i2).e();
            e.computeBounds(this.f, false);
            this.g.set(matrix);
            this.g.preTranslate(0.0f, ((float) (-documentData.g)) * Utils.a());
            this.g.preScale(f, f);
            e.transform(this.g);
            if (documentData.k) {
                a(e, this.h, canvas);
                a(e, this.i, canvas);
            } else {
                a(e, this.i, canvas);
                a(e, this.h, canvas);
            }
            i = i2 + 1;
        }
    }

    private void a(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private void a(String str, DocumentData documentData, Canvas canvas) {
        if (documentData.k) {
            a(str, this.h, canvas);
            a(str, this.i, canvas);
            return;
        }
        a(str, this.i, canvas);
        a(str, this.h, canvas);
    }

    private void a(String str, DocumentData documentData, Canvas canvas, float f) {
        int i = 0;
        while (i < str.length()) {
            String a = a(str, i);
            i += a.length();
            a(a, documentData, canvas);
            float measureText = this.h.measureText(a, 0, 1);
            float f2 = documentData.e / 10.0f;
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.r;
            float f3 = f2;
            if (baseKeyframeAnimation != null) {
                f3 = f2 + baseKeyframeAnimation.g().floatValue();
            }
            canvas.translate(measureText + (f3 * f), 0.0f);
        }
    }

    private void a(String str, DocumentData documentData, Matrix matrix, Font font, Canvas canvas, float f, float f2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return;
            }
            FontCharacter fontCharacter = (FontCharacter) this.n.j().get(FontCharacter.a(str.charAt(i2), font.a(), font.c()));
            if (fontCharacter != null) {
                a(fontCharacter, matrix, f2, documentData, canvas);
                float b = (float) fontCharacter.b();
                float a = Utils.a();
                float f3 = documentData.e / 10.0f;
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.r;
                float f4 = f3;
                if (baseKeyframeAnimation != null) {
                    f4 = f3 + baseKeyframeAnimation.g().floatValue();
                }
                canvas.translate((b * f2 * a * f) + (f4 * f), 0.0f);
            }
            i = i2 + 1;
        }
    }

    private boolean a(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 19;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.n.d().width(), this.n.d().height());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void a(T t, LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2;
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation3;
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation4;
        super.a((TextLayer) t, (LottieValueCallback<TextLayer>) lottieValueCallback);
        if (t == LottieProperty.a && (baseKeyframeAnimation4 = this.o) != null) {
            baseKeyframeAnimation4.a((LottieValueCallback<Integer>) lottieValueCallback);
        } else if (t == LottieProperty.b && (baseKeyframeAnimation3 = this.p) != null) {
            baseKeyframeAnimation3.a((LottieValueCallback<Integer>) lottieValueCallback);
        } else if (t == LottieProperty.o && (baseKeyframeAnimation2 = this.q) != null) {
            baseKeyframeAnimation2.a((LottieValueCallback<Float>) lottieValueCallback);
        } else if (t != LottieProperty.p || (baseKeyframeAnimation = this.r) == null) {
        } else {
            baseKeyframeAnimation.a((LottieValueCallback<Float>) lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.m.p()) {
            canvas.setMatrix(matrix);
        }
        DocumentData g = this.l.g();
        Font font = this.n.k().get(g.b);
        if (font == null) {
            canvas.restore();
            return;
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.o;
        if (baseKeyframeAnimation != null) {
            this.h.setColor(baseKeyframeAnimation.g().intValue());
        } else {
            this.h.setColor(g.h);
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.p;
        if (baseKeyframeAnimation2 != null) {
            this.i.setColor(baseKeyframeAnimation2.g().intValue());
        } else {
            this.i.setColor(g.i);
        }
        int intValue = ((this.d.a() == null ? 100 : this.d.a().g().intValue()) * 255) / 100;
        this.h.setAlpha(intValue);
        this.i.setAlpha(intValue);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.q;
        if (baseKeyframeAnimation3 != null) {
            this.i.setStrokeWidth(baseKeyframeAnimation3.g().floatValue());
        } else {
            this.i.setStrokeWidth((float) (g.j * Utils.a() * Utils.a(matrix)));
        }
        if (this.m.p()) {
            a(g, matrix, font, canvas);
        } else {
            a(g, font, matrix, canvas);
        }
        canvas.restore();
    }
}
