package com.blued.android.module.svgaplayer.drawer;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.media.SoundPool;
import android.os.Build;
import android.text.BoringLayout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.ImageView;
import com.blued.android.module.svgaplayer.IClickAreaListener;
import com.blued.android.module.svgaplayer.SVGADynamicEntity;
import com.blued.android.module.svgaplayer.SVGASoundManager;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.android.module.svgaplayer.drawer.SGVADrawer;
import com.blued.android.module.svgaplayer.entities.SVGAAudioEntity;
import com.blued.android.module.svgaplayer.entities.SVGAPathEntity;
import com.blued.android.module.svgaplayer.entities.SVGAVideoData;
import com.blued.android.module.svgaplayer.entities.SVGAVideoShapeEntity;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/drawer/SVGACanvasDrawer.class */
public final class SVGACanvasDrawer extends SGVADrawer {

    /* renamed from: a  reason: collision with root package name */
    private final SVGADynamicEntity f15994a;
    private final ShareValues b;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, Bitmap> f15995c;
    private final PathCache d;
    private Boolean[] e;
    private Boolean[] f;
    private final float[] g;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/drawer/SVGACanvasDrawer$PathCache.class */
    public static final class PathCache {

        /* renamed from: a  reason: collision with root package name */
        private int f15996a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private final HashMap<SVGAVideoShapeEntity, Path> f15997c = new HashMap<>();

        public final Path a(SVGAVideoShapeEntity shape) {
            Intrinsics.e(shape, "shape");
            if (!this.f15997c.containsKey(shape)) {
                Path path = new Path();
                Path e = shape.e();
                if (e != null) {
                    path.set(e);
                }
                this.f15997c.put(shape, path);
            }
            Path path2 = this.f15997c.get(shape);
            Intrinsics.a(path2);
            return path2;
        }

        public final void a(Canvas canvas) {
            Intrinsics.e(canvas, "canvas");
            if (this.f15996a != canvas.getWidth() || this.b != canvas.getHeight()) {
                this.f15997c.clear();
            }
            this.f15996a = canvas.getWidth();
            this.b = canvas.getHeight();
        }
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/drawer/SVGACanvasDrawer$ShareValues.class */
    public static final class ShareValues {

        /* renamed from: a  reason: collision with root package name */
        private final Paint f15998a = new Paint();
        private final Path b = new Path();

        /* renamed from: c  reason: collision with root package name */
        private final Path f15999c = new Path();
        private final Matrix d = new Matrix();
        private final Matrix e = new Matrix();
        private final Paint f = new Paint();
        private Canvas g;
        private Bitmap h;

        public final Canvas a(int i, int i2) {
            if (this.g == null) {
                this.h = Bitmap.createBitmap(i, i2, Bitmap.Config.ALPHA_8);
            }
            Bitmap bitmap = this.h;
            Intrinsics.a(bitmap);
            return new Canvas(bitmap);
        }

        public final Paint a() {
            this.f15998a.reset();
            return this.f15998a;
        }

        public final Path b() {
            this.b.reset();
            return this.b;
        }

        public final Path c() {
            this.f15999c.reset();
            return this.f15999c;
        }

        public final Matrix d() {
            this.d.reset();
            return this.d;
        }

        public final Matrix e() {
            this.e.reset();
            return this.e;
        }

        public final Paint f() {
            this.f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            return this.f;
        }

        public final Bitmap g() {
            Bitmap bitmap = this.h;
            if (bitmap != null) {
                return bitmap;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.Bitmap");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGACanvasDrawer(SVGAVideoEntity videoItem, SVGADynamicEntity dynamicItem) {
        super(videoItem);
        Intrinsics.e(videoItem, "videoItem");
        Intrinsics.e(dynamicItem, "dynamicItem");
        this.f15994a = dynamicItem;
        this.b = new ShareValues();
        this.f15995c = new HashMap<>();
        this.d = new PathCache();
        this.g = new float[16];
    }

    private final Matrix a(Matrix matrix) {
        Matrix d = this.b.d();
        d.postScale(b().c(), b().d());
        d.postTranslate(b().a(), b().b());
        d.preConcat(matrix);
        return d;
    }

    private final void a(Canvas canvas, Bitmap bitmap, SGVADrawer.SVGADrawerSprite sVGADrawerSprite, Matrix matrix) {
        String b;
        int i;
        StaticLayout build;
        if (this.f15994a.k()) {
            this.f15995c.clear();
            this.f15994a.a(false);
        }
        SVGAVideoData a2 = a().a();
        if (a2 == null || (b = sVGADrawerSprite.b()) == null) {
            return;
        }
        String str = this.f15994a.c().get(b);
        Bitmap bitmap2 = null;
        if (str != null) {
            TextPaint textPaint = this.f15994a.d().get(b);
            bitmap2 = null;
            if (textPaint != null) {
                bitmap2 = this.f15995c.get(b);
                if (bitmap2 == null) {
                    bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    Intrinsics.a(bitmap2);
                    Canvas canvas2 = new Canvas(bitmap2);
                    textPaint.setAntiAlias(true);
                    Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
                    float f = fontMetrics.top;
                    float f2 = fontMetrics.bottom;
                    float centerY = rect.centerY();
                    float f3 = 2;
                    canvas2.drawText(str, rect.centerX(), (centerY - (f / f3)) - (f2 / f3), textPaint);
                    this.f15995c.put(b, bitmap2);
                }
            }
        }
        BoringLayout boringLayout = this.f15994a.f().get(b);
        if (boringLayout != null) {
            bitmap2 = this.f15995c.get(b);
            if (bitmap2 == null) {
                boringLayout.getPaint().setAntiAlias(true);
                bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Intrinsics.a(bitmap2);
                Canvas canvas3 = new Canvas(bitmap2);
                canvas3.translate(0.0f, (bitmap.getHeight() - boringLayout.getHeight()) / 2);
                boringLayout.draw(canvas3);
                this.f15995c.put(b, bitmap2);
            }
        }
        StaticLayout staticLayout = this.f15994a.e().get(b);
        if (staticLayout != null) {
            bitmap2 = this.f15995c.get(b);
            if (bitmap2 == null) {
                SVGACanvasDrawer sVGACanvasDrawer = this;
                staticLayout.getPaint().setAntiAlias(true);
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        Field declaredField = StaticLayout.class.getDeclaredField("mMaximumVisibleLineCount");
                        Intrinsics.c(declaredField, "StaticLayout::class.java…MaximumVisibleLineCount\")");
                        declaredField.setAccessible(true);
                        i = declaredField.getInt(staticLayout);
                    } catch (Exception e) {
                        i = Integer.MAX_VALUE;
                    }
                    build = StaticLayout.Builder.obtain(staticLayout.getText(), 0, staticLayout.getText().length(), staticLayout.getPaint(), bitmap.getWidth()).setAlignment(staticLayout.getAlignment()).setMaxLines(i).setEllipsize(TextUtils.TruncateAt.END).build();
                } else {
                    build = new StaticLayout(staticLayout.getText(), 0, staticLayout.getText().length(), staticLayout.getPaint(), bitmap.getWidth(), staticLayout.getAlignment(), staticLayout.getSpacingMultiplier(), staticLayout.getSpacingAdd(), false);
                }
                Intrinsics.c(build, "if (Build.VERSION.SDK_IN… false)\n                }");
                Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Intrinsics.a(createBitmap);
                Canvas canvas4 = new Canvas(createBitmap);
                canvas4.translate(0.0f, (bitmap.getHeight() - build.getHeight()) / 2);
                build.draw(canvas4);
                sVGACanvasDrawer.f15995c.put(b, createBitmap);
                bitmap2 = createBitmap;
            }
        }
        if (bitmap2 != null) {
            Paint a3 = this.b.a();
            a3.setAntiAlias(a2.a());
            a3.setAlpha((int) (sVGADrawerSprite.c().a() * 255));
            if (sVGADrawerSprite.c().d() == null) {
                a3.setFilterBitmap(a2.a());
                canvas.drawBitmap(bitmap2, matrix, a3);
                return;
            }
            SVGAPathEntity d = sVGADrawerSprite.c().d();
            if (d == null) {
                return;
            }
            canvas.save();
            canvas.concat(matrix);
            canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            a3.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
            Path b2 = this.b.b();
            d.a(b2);
            canvas.drawPath(b2, a3);
            canvas.restore();
        }
    }

    private final void a(SGVADrawer.SVGADrawerSprite sVGADrawerSprite, Canvas canvas) {
        String str;
        String b = sVGADrawerSprite.b();
        if (b == null || Intrinsics.a((Object) this.f15994a.a().get(b), (Object) true)) {
            return;
        }
        if (StringsKt.b(b, ".matte", false, 2, (Object) null)) {
            str = b.substring(0, b.length() - 6);
            Intrinsics.c(str, "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            str = b;
        }
        Bitmap bitmap = this.f15994a.b().get(str);
        Bitmap bitmap2 = bitmap;
        if (bitmap == null) {
            SVGAVideoData a2 = a().a();
            bitmap2 = null;
            if (a2 != null) {
                HashMap<String, Bitmap> h = a2.h();
                bitmap2 = null;
                if (h != null) {
                    bitmap2 = h.get(str);
                }
            }
            if (bitmap2 == null) {
                return;
            }
        }
        Matrix a3 = a(sVGADrawerSprite.c().c());
        Paint a4 = this.b.a();
        SVGAVideoData a5 = a().a();
        a4.setAntiAlias(a5 != null ? a5.a() : true);
        SVGAVideoData a6 = a().a();
        boolean z = true;
        if (a6 != null) {
            z = a6.a();
        }
        a4.setFilterBitmap(z);
        a4.setAlpha((int) (sVGADrawerSprite.c().a() * 255));
        if (sVGADrawerSprite.c().d() != null) {
            SVGAPathEntity d = sVGADrawerSprite.c().d();
            if (d == null) {
                return;
            }
            canvas.save();
            Path b2 = this.b.b();
            d.a(b2);
            b2.transform(a3);
            canvas.clipPath(b2);
            a3.preScale((float) (sVGADrawerSprite.c().b().a() / bitmap2.getWidth()), (float) (sVGADrawerSprite.c().b().b() / bitmap2.getHeight()));
            if (!bitmap2.isRecycled()) {
                canvas.drawBitmap(bitmap2, a3, a4);
            }
            canvas.restore();
        } else {
            a3.preScale((float) (sVGADrawerSprite.c().b().a() / bitmap2.getWidth()), (float) (sVGADrawerSprite.c().b().b() / bitmap2.getHeight()));
            if (!bitmap2.isRecycled()) {
                canvas.drawBitmap(bitmap2, a3, a4);
            }
        }
        IClickAreaListener iClickAreaListener = this.f15994a.i().get(b);
        if (iClickAreaListener != null) {
            float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            a3.getValues(fArr);
            iClickAreaListener.a(b, (int) fArr[2], (int) fArr[5], (int) ((bitmap2.getWidth() * fArr[0]) + fArr[2]), (int) ((bitmap2.getHeight() * fArr[4]) + fArr[5]));
        }
        a(canvas, bitmap2, sVGADrawerSprite, a3);
    }

    private final void a(SGVADrawer.SVGADrawerSprite sVGADrawerSprite, Canvas canvas, int i) {
        a(sVGADrawerSprite, canvas);
        b(sVGADrawerSprite, canvas);
        b(sVGADrawerSprite, canvas, i);
    }

    private final boolean a(int i, List<SGVADrawer.SVGADrawerSprite> list) {
        String a2;
        SGVADrawer.SVGADrawerSprite sVGADrawerSprite;
        boolean z = false;
        if (this.e == null) {
            int size = list.size();
            Boolean[] boolArr = new Boolean[size];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    break;
                }
                boolArr[i3] = false;
                i2 = i3 + 1;
            }
            Iterator<SGVADrawer.SVGADrawerSprite> it = list.iterator();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (!it.hasNext()) {
                    break;
                }
                SGVADrawer.SVGADrawerSprite next = it.next();
                if (i5 < 0) {
                    CollectionsKt.c();
                }
                SGVADrawer.SVGADrawerSprite sVGADrawerSprite2 = next;
                String b = sVGADrawerSprite2.b();
                if ((b == null || !StringsKt.b(b, ".matte", false, 2, (Object) null)) && (a2 = sVGADrawerSprite2.a()) != null && a2.length() > 0 && (sVGADrawerSprite = list.get(i5 - 1)) != null) {
                    String a3 = sVGADrawerSprite.a();
                    if (a3 == null || a3.length() == 0) {
                        boolArr[i5] = true;
                    } else if (!Intrinsics.a((Object) sVGADrawerSprite.a(), (Object) sVGADrawerSprite2.a())) {
                        boolArr[i5] = true;
                    }
                }
                i4 = i5 + 1;
            }
            this.e = boolArr;
        }
        Boolean[] boolArr2 = this.e;
        if (boolArr2 != null) {
            z = boolArr2[i].booleanValue();
        }
        return z;
    }

    private final float b(Matrix matrix) {
        matrix.getValues(this.g);
        if (this.g[0] == 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.g;
        double d = fArr[0];
        double d2 = fArr[3];
        double d3 = fArr[1];
        double d4 = fArr[4];
        boolean z = false;
        if (d * d4 == d2 * d3) {
            z = true;
        }
        if (z) {
            return 0.0f;
        }
        double sqrt = Math.sqrt((d * d) + (d2 * d2));
        double d5 = d / sqrt;
        double d6 = d2 / sqrt;
        double d7 = (d5 * d3) + (d6 * d4);
        double d8 = d3 - (d5 * d7);
        double d9 = d4 - (d7 * d6);
        double sqrt2 = Math.sqrt((d8 * d8) + (d9 * d9));
        double d10 = sqrt;
        if (d5 * (d9 / sqrt2) < d6 * (d8 / sqrt2)) {
            d10 = -sqrt;
        }
        return Math.abs(b().e() ? (float) d10 : (float) sqrt2);
    }

    private final void b(int i) {
        List<SVGAAudioEntity> g;
        Integer d;
        SVGAVideoData a2 = a().a();
        if (a2 == null || (g = a2.g()) == null) {
            return;
        }
        for (SVGAAudioEntity sVGAAudioEntity : g) {
            if (sVGAAudioEntity.b() == i) {
                if (SVGASoundManager.f15975a.a()) {
                    Integer d2 = sVGAAudioEntity.d();
                    if (d2 != null) {
                        sVGAAudioEntity.b(Integer.valueOf(SVGASoundManager.f15975a.b(d2.intValue())));
                    }
                } else {
                    SoundPool b = a().b();
                    if (b != null && (d = sVGAAudioEntity.d()) != null) {
                        sVGAAudioEntity.b(Integer.valueOf(b.play(d.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
                    }
                }
            }
            if (sVGAAudioEntity.c() <= i) {
                Integer e = sVGAAudioEntity.e();
                if (e != null) {
                    int intValue = e.intValue();
                    if (SVGASoundManager.f15975a.a()) {
                        SVGASoundManager.f15975a.c(intValue);
                    } else {
                        SoundPool b2 = a().b();
                        if (b2 != null) {
                            b2.stop(intValue);
                        }
                    }
                }
                sVGAAudioEntity.b(null);
            }
        }
    }

    private final void b(SGVADrawer.SVGADrawerSprite sVGADrawerSprite, Canvas canvas) {
        SVGAVideoShapeEntity.Styles b;
        float[] g;
        String e;
        String d;
        int a2;
        Matrix a3 = a(sVGADrawerSprite.c().c());
        SVGAVideoData a4 = a().a();
        if (a4 == null) {
            return;
        }
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : sVGADrawerSprite.c().e()) {
            sVGAVideoShapeEntity.f();
            if (sVGAVideoShapeEntity.e() != null) {
                Paint a5 = this.b.a();
                a5.reset();
                a5.setAntiAlias(a4.a());
                double d2 = 255;
                a5.setAlpha((int) (sVGADrawerSprite.c().a() * d2));
                Path b2 = this.b.b();
                b2.reset();
                b2.addPath(this.d.a(sVGAVideoShapeEntity));
                Matrix e2 = this.b.e();
                e2.reset();
                Matrix c2 = sVGAVideoShapeEntity.c();
                if (c2 != null) {
                    e2.postConcat(c2);
                }
                e2.postConcat(a3);
                b2.transform(e2);
                SVGAVideoShapeEntity.Styles b3 = sVGAVideoShapeEntity.b();
                if (b3 != null && (a2 = b3.a()) != 0) {
                    a5.setStyle(Paint.Style.FILL);
                    a5.setColor(a2);
                    int min = Math.min(255, Math.max(0, (int) (sVGADrawerSprite.c().a() * d2)));
                    if (min != 255) {
                        a5.setAlpha(min);
                    }
                    if (sVGADrawerSprite.c().d() != null) {
                        canvas.save();
                    }
                    SVGAPathEntity d3 = sVGADrawerSprite.c().d();
                    if (d3 != null) {
                        Path c3 = this.b.c();
                        d3.a(c3);
                        c3.transform(a3);
                        canvas.clipPath(c3);
                    }
                    canvas.drawPath(b2, a5);
                    if (sVGADrawerSprite.c().d() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.Styles b4 = sVGAVideoShapeEntity.b();
                if (b4 != null && b4.c() > 0.0f) {
                    a5.setAlpha((int) (sVGADrawerSprite.c().a() * d2));
                    a5.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.Styles b5 = sVGAVideoShapeEntity.b();
                    if (b5 != null) {
                        a5.setColor(b5.b());
                        int min2 = Math.min(255, Math.max(0, (int) (sVGADrawerSprite.c().a() * d2)));
                        if (min2 != 255) {
                            a5.setAlpha(min2);
                        }
                    }
                    float b6 = b(a3);
                    SVGAVideoShapeEntity.Styles b7 = sVGAVideoShapeEntity.b();
                    if (b7 != null) {
                        a5.setStrokeWidth(b7.c() * b6);
                    }
                    SVGAVideoShapeEntity.Styles b8 = sVGAVideoShapeEntity.b();
                    if (b8 != null && (d = b8.d()) != null) {
                        if (StringsKt.a(d, "butt", true)) {
                            a5.setStrokeCap(Paint.Cap.BUTT);
                        } else if (StringsKt.a(d, "round", true)) {
                            a5.setStrokeCap(Paint.Cap.ROUND);
                        } else if (StringsKt.a(d, "square", true)) {
                            a5.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.Styles b9 = sVGAVideoShapeEntity.b();
                    if (b9 != null && (e = b9.e()) != null) {
                        if (StringsKt.a(e, "miter", true)) {
                            a5.setStrokeJoin(Paint.Join.MITER);
                        } else if (StringsKt.a(e, "round", true)) {
                            a5.setStrokeJoin(Paint.Join.ROUND);
                        } else if (StringsKt.a(e, "bevel", true)) {
                            a5.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    if (sVGAVideoShapeEntity.b() != null) {
                        a5.setStrokeMiter(b.f() * b6);
                    }
                    SVGAVideoShapeEntity.Styles b10 = sVGAVideoShapeEntity.b();
                    if (b10 != null && (g = b10.g()) != null && g.length == 3 && (g[0] > 0.0f || g[1] > 0.0f)) {
                        a5.setPathEffect(new DashPathEffect(new float[]{(g[0] >= 1.0f ? g[0] : 1.0f) * b6, (g[1] >= 0.1f ? g[1] : 0.1f) * b6}, g[2] * b6));
                    }
                    if (sVGADrawerSprite.c().d() != null) {
                        canvas.save();
                    }
                    SVGAPathEntity d4 = sVGADrawerSprite.c().d();
                    if (d4 != null) {
                        Path c4 = this.b.c();
                        d4.a(c4);
                        c4.transform(a3);
                        canvas.clipPath(c4);
                    }
                    canvas.drawPath(b2, a5);
                    if (sVGADrawerSprite.c().d() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final void b(SGVADrawer.SVGADrawerSprite sVGADrawerSprite, Canvas canvas, int i) {
        String b = sVGADrawerSprite.b();
        if (b == null) {
            return;
        }
        Function2<Canvas, Integer, Boolean> function2 = this.f15994a.g().get(b);
        if (function2 != null) {
            Matrix a2 = a(sVGADrawerSprite.c().c());
            canvas.save();
            canvas.concat(a2);
            function2.invoke(canvas, Integer.valueOf(i));
            canvas.restore();
        }
        Function4<Canvas, Integer, Integer, Integer, Boolean> function4 = this.f15994a.j().get(b);
        if (function4 != null) {
            Matrix a3 = a(sVGADrawerSprite.c().c());
            canvas.save();
            canvas.concat(a3);
            function4.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) sVGADrawerSprite.c().b().a()), Integer.valueOf((int) sVGADrawerSprite.c().b().b()));
            canvas.restore();
        }
    }

    private final boolean b(int i, List<SGVADrawer.SVGADrawerSprite> list) {
        String a2;
        boolean z = false;
        if (this.f == null) {
            List<SGVADrawer.SVGADrawerSprite> list2 = list;
            int size = list2.size();
            Boolean[] boolArr = new Boolean[size];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    break;
                }
                boolArr[i3] = false;
                i2 = i3 + 1;
            }
            Iterator<SGVADrawer.SVGADrawerSprite> it = list.iterator();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (!it.hasNext()) {
                    break;
                }
                SGVADrawer.SVGADrawerSprite next = it.next();
                int i6 = i5 + 1;
                if (i5 < 0) {
                    CollectionsKt.c();
                }
                SGVADrawer.SVGADrawerSprite sVGADrawerSprite = next;
                String b = sVGADrawerSprite.b();
                if ((b == null || !StringsKt.b(b, ".matte", false, 2, (Object) null)) && (a2 = sVGADrawerSprite.a()) != null && a2.length() > 0) {
                    if (i5 == list2.size() - 1) {
                        boolArr[i5] = true;
                    } else {
                        SGVADrawer.SVGADrawerSprite sVGADrawerSprite2 = list.get(i6);
                        if (sVGADrawerSprite2 != null) {
                            String a3 = sVGADrawerSprite2.a();
                            if (a3 == null || a3.length() == 0) {
                                boolArr[i5] = true;
                            } else if (!Intrinsics.a((Object) sVGADrawerSprite2.a(), (Object) sVGADrawerSprite.a())) {
                                boolArr[i5] = true;
                            }
                        }
                    }
                }
                i4 = i6;
            }
            this.f = boolArr;
        }
        Boolean[] boolArr2 = this.f;
        if (boolArr2 != null) {
            z = boolArr2[i].booleanValue();
        }
        return z;
    }

    @Override // com.blued.android.module.svgaplayer.drawer.SGVADrawer
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        SGVADrawer.SVGADrawerSprite sVGADrawerSprite;
        Intrinsics.e(canvas, "canvas");
        Intrinsics.e(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        b(i);
        this.d.a(canvas);
        List<SGVADrawer.SVGADrawerSprite> a2 = a(i);
        if (a2.size() <= 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.e = null;
        this.f = null;
        String b = a2.get(0).b();
        boolean b2 = b != null ? StringsKt.b(b, ".matte", false, 2, (Object) null) : false;
        Iterator<SGVADrawer.SVGADrawerSprite> it = a2.iterator();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (!it.hasNext()) {
                a(a2);
                return;
            }
            SGVADrawer.SVGADrawerSprite next = it.next();
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.c();
            }
            SGVADrawer.SVGADrawerSprite sVGADrawerSprite2 = next;
            String b3 = sVGADrawerSprite2.b();
            if (b3 != null) {
                if (!b2 || Build.VERSION.SDK_INT < 21) {
                    a(sVGADrawerSprite2, canvas, i);
                } else if (StringsKt.b(b3, ".matte", false, 2, (Object) null)) {
                    linkedHashMap.put(b3, sVGADrawerSprite2);
                }
                i3 = i5;
            }
            if (a(i4, a2)) {
                if (Build.VERSION.SDK_INT >= 21) {
                    i2 = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
                } else {
                    canvas.save();
                }
            }
            a(sVGADrawerSprite2, canvas, i);
            if (b(i4, a2) && (sVGADrawerSprite = (SGVADrawer.SVGADrawerSprite) linkedHashMap.get(sVGADrawerSprite2.a())) != null) {
                a(sVGADrawerSprite, this.b.a(canvas.getWidth(), canvas.getHeight()), i);
                canvas.drawBitmap(this.b.g(), 0.0f, 0.0f, this.b.f());
                if (i2 != -1) {
                    canvas.restoreToCount(i2);
                } else {
                    canvas.restore();
                }
            }
            i3 = i5;
        }
    }
}
