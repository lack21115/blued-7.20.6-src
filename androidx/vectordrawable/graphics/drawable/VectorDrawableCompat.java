package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import com.cdo.oaps.ad.OapsWrapper;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8756600-dex2jar.jar:androidx/vectordrawable/graphics/drawable/VectorDrawableCompat.class */
public class VectorDrawableCompat extends VectorDrawableCommon {

    /* renamed from: a  reason: collision with root package name */
    static final PorterDuff.Mode f3532a = PorterDuff.Mode.SRC_IN;
    private VectorDrawableCompatState b;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuffColorFilter f3533c;
    private ColorFilter e;
    private boolean f;
    private boolean g;
    private Drawable.ConstantState h;
    private final float[] i;
    private final Matrix j;
    private final Rect k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/vectordrawable/graphics/drawable/VectorDrawableCompat$VClipPath.class */
    public static class VClipPath extends VPath {
        VClipPath() {
        }

        VClipPath(VClipPath vClipPath) {
            super(vClipPath);
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.l = PathParser.createNodesFromPathData(string2);
            }
            this.n = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.d);
                a(obtainAttributes, xmlPullParser);
                obtainAttributes.recycle();
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public boolean isClipPath() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/vectordrawable/graphics/drawable/VectorDrawableCompat$VFullPath.class */
    public static class VFullPath extends VPath {

        /* renamed from: a  reason: collision with root package name */
        ComplexColorCompat f3534a;
        float b;

        /* renamed from: c  reason: collision with root package name */
        ComplexColorCompat f3535c;
        float d;
        float e;
        float f;
        float g;
        float h;
        Paint.Cap i;
        Paint.Join j;
        float k;
        private int[] p;

        VFullPath() {
            this.b = 0.0f;
            this.d = 1.0f;
            this.e = 1.0f;
            this.f = 0.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = Paint.Cap.BUTT;
            this.j = Paint.Join.MITER;
            this.k = 4.0f;
        }

        VFullPath(VFullPath vFullPath) {
            super(vFullPath);
            this.b = 0.0f;
            this.d = 1.0f;
            this.e = 1.0f;
            this.f = 0.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = Paint.Cap.BUTT;
            this.j = Paint.Join.MITER;
            this.k = 4.0f;
            this.p = vFullPath.p;
            this.f3534a = vFullPath.f3534a;
            this.b = vFullPath.b;
            this.d = vFullPath.d;
            this.f3535c = vFullPath.f3535c;
            this.n = vFullPath.n;
            this.e = vFullPath.e;
            this.f = vFullPath.f;
            this.g = vFullPath.g;
            this.h = vFullPath.h;
            this.i = vFullPath.i;
            this.j = vFullPath.j;
            this.k = vFullPath.k;
        }

        private Paint.Cap a(int i, Paint.Cap cap) {
            return i != 0 ? i != 1 ? i != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        private Paint.Join a(int i, Paint.Join join) {
            return i != 0 ? i != 1 ? i != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.p = null;
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.m = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.l = PathParser.createNodesFromPathData(string2);
                }
                this.f3535c = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.e = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "fillAlpha", 12, this.e);
                this.i = a(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.i);
                this.j = a(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.j);
                this.k = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.k);
                this.f3534a = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.d = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeAlpha", 11, this.d);
                this.b = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeWidth", 4, this.b);
                this.g = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathEnd", 6, this.g);
                this.h = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathOffset", 7, this.h);
                this.f = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathStart", 5, this.f);
                this.n = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 13, this.n);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public void applyTheme(Resources.Theme theme) {
            if (this.p == null) {
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public boolean canApplyTheme() {
            return this.p != null;
        }

        float getFillAlpha() {
            return this.e;
        }

        int getFillColor() {
            return this.f3535c.getColor();
        }

        float getStrokeAlpha() {
            return this.d;
        }

        int getStrokeColor() {
            return this.f3534a.getColor();
        }

        float getStrokeWidth() {
            return this.b;
        }

        float getTrimPathEnd() {
            return this.g;
        }

        float getTrimPathOffset() {
            return this.h;
        }

        float getTrimPathStart() {
            return this.f;
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.f3520c);
            a(obtainAttributes, xmlPullParser, theme);
            obtainAttributes.recycle();
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean isStateful() {
            return this.f3535c.isStateful() || this.f3534a.isStateful();
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean onStateChanged(int[] iArr) {
            return this.f3534a.onStateChanged(iArr) | this.f3535c.onStateChanged(iArr);
        }

        void setFillAlpha(float f) {
            this.e = f;
        }

        void setFillColor(int i) {
            this.f3535c.setColor(i);
        }

        void setStrokeAlpha(float f) {
            this.d = f;
        }

        void setStrokeColor(int i) {
            this.f3534a.setColor(i);
        }

        void setStrokeWidth(float f) {
            this.b = f;
        }

        void setTrimPathEnd(float f) {
            this.g = f;
        }

        void setTrimPathOffset(float f) {
            this.h = f;
        }

        void setTrimPathStart(float f) {
            this.f = f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/vectordrawable/graphics/drawable/VectorDrawableCompat$VGroup.class */
    public static class VGroup extends VObject {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f3536a;
        final ArrayList<VObject> b;

        /* renamed from: c  reason: collision with root package name */
        float f3537c;
        final Matrix d;
        int e;
        private float f;
        private float g;
        private float h;
        private float i;
        private float j;
        private float k;
        private int[] l;
        private String m;

        public VGroup() {
            super();
            this.f3536a = new Matrix();
            this.b = new ArrayList<>();
            this.f3537c = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 1.0f;
            this.i = 1.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.d = new Matrix();
            this.m = null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v45, types: [androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPath] */
        /* JADX WARN: Type inference failed for: r1v39, types: [androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPath] */
        public VGroup(VGroup vGroup, ArrayMap<String, Object> arrayMap) {
            super();
            VFullPath vClipPath;
            this.f3536a = new Matrix();
            this.b = new ArrayList<>();
            this.f3537c = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 1.0f;
            this.i = 1.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.d = new Matrix();
            this.m = null;
            this.f3537c = vGroup.f3537c;
            this.f = vGroup.f;
            this.g = vGroup.g;
            this.h = vGroup.h;
            this.i = vGroup.i;
            this.j = vGroup.j;
            this.k = vGroup.k;
            this.l = vGroup.l;
            String str = vGroup.m;
            this.m = str;
            this.e = vGroup.e;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.d.set(vGroup.d);
            ArrayList<VObject> arrayList = vGroup.b;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    return;
                }
                VObject vObject = arrayList.get(i2);
                if (vObject instanceof VGroup) {
                    this.b.add(new VGroup((VGroup) vObject, arrayMap));
                } else {
                    if (vObject instanceof VFullPath) {
                        vClipPath = new VFullPath((VFullPath) vObject);
                    } else if (!(vObject instanceof VClipPath)) {
                        throw new IllegalStateException("Unknown object in the tree!");
                    } else {
                        vClipPath = new VClipPath((VClipPath) vObject);
                    }
                    this.b.add(vClipPath);
                    if (vClipPath.m != null) {
                        arrayMap.put(vClipPath.m, vClipPath);
                    }
                }
                i = i2 + 1;
            }
        }

        private void a() {
            this.d.reset();
            this.d.postTranslate(-this.f, -this.g);
            this.d.postScale(this.h, this.i);
            this.d.postRotate(this.f3537c, 0.0f, 0.0f);
            this.d.postTranslate(this.j + this.f, this.k + this.g);
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.f3537c = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "rotation", 5, this.f3537c);
            this.f = typedArray.getFloat(1, this.f);
            this.g = typedArray.getFloat(2, this.g);
            this.h = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleX", 3, this.h);
            this.i = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleY", 4, this.i);
            this.j = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateX", 6, this.j);
            this.k = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateY", 7, this.k);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            a();
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.d;
        }

        public float getPivotX() {
            return this.f;
        }

        public float getPivotY() {
            return this.g;
        }

        public float getRotation() {
            return this.f3537c;
        }

        public float getScaleX() {
            return this.h;
        }

        public float getScaleY() {
            return this.i;
        }

        public float getTranslateX() {
            return this.j;
        }

        public float getTranslateY() {
            return this.k;
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.b);
            a(obtainAttributes, xmlPullParser);
            obtainAttributes.recycle();
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean isStateful() {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.b.size()) {
                    return false;
                }
                if (this.b.get(i2).isStateful()) {
                    return true;
                }
                i = i2 + 1;
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean onStateChanged(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.b.size(); i++) {
                z |= this.b.get(i).onStateChanged(iArr);
            }
            return z;
        }

        public void setPivotX(float f) {
            if (f != this.f) {
                this.f = f;
                a();
            }
        }

        public void setPivotY(float f) {
            if (f != this.g) {
                this.g = f;
                a();
            }
        }

        public void setRotation(float f) {
            if (f != this.f3537c) {
                this.f3537c = f;
                a();
            }
        }

        public void setScaleX(float f) {
            if (f != this.h) {
                this.h = f;
                a();
            }
        }

        public void setScaleY(float f) {
            if (f != this.i) {
                this.i = f;
                a();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.j) {
                this.j = f;
                a();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.k) {
                this.k = f;
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/vectordrawable/graphics/drawable/VectorDrawableCompat$VObject.class */
    public static abstract class VObject {
        private VObject() {
        }

        public boolean isStateful() {
            return false;
        }

        public boolean onStateChanged(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/vectordrawable/graphics/drawable/VectorDrawableCompat$VPath.class */
    public static abstract class VPath extends VObject {
        protected PathParser.PathDataNode[] l;
        String m;
        int n;
        int o;

        public VPath() {
            super();
            this.l = null;
            this.n = 0;
        }

        public VPath(VPath vPath) {
            super();
            this.l = null;
            this.n = 0;
            this.m = vPath.m;
            this.o = vPath.o;
            this.l = PathParser.deepCopyNodes(vPath.l);
        }

        public void applyTheme(Resources.Theme theme) {
        }

        public boolean canApplyTheme() {
            return false;
        }

        public PathParser.PathDataNode[] getPathData() {
            return this.l;
        }

        public String getPathName() {
            return this.m;
        }

        public boolean isClipPath() {
            return false;
        }

        public String nodesToString(PathParser.PathDataNode[] pathDataNodeArr) {
            float[] fArr;
            String str = " ";
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= pathDataNodeArr.length) {
                    return str;
                }
                str = str + pathDataNodeArr[i2].mType + ":";
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < pathDataNodeArr[i2].mParams.length) {
                        str = str + fArr[i4] + ",";
                        i3 = i4 + 1;
                    }
                }
                i = i2 + 1;
            }
        }

        public void printVPath(int i) {
            String str = "";
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    Log.v("VectorDrawableCompat", str + "current path is :" + this.m + " pathData is " + nodesToString(this.l));
                    return;
                }
                str = str + "    ";
                i2 = i3 + 1;
            }
        }

        public void setPathData(PathParser.PathDataNode[] pathDataNodeArr) {
            if (PathParser.canMorph(this.l, pathDataNodeArr)) {
                PathParser.updateNodes(this.l, pathDataNodeArr);
            } else {
                this.l = PathParser.deepCopyNodes(pathDataNodeArr);
            }
        }

        public void toPath(Path path) {
            path.reset();
            PathParser.PathDataNode[] pathDataNodeArr = this.l;
            if (pathDataNodeArr != null) {
                PathParser.PathDataNode.nodesToPath(pathDataNodeArr, path);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/vectordrawable/graphics/drawable/VectorDrawableCompat$VPathRenderer.class */
    public static class VPathRenderer {
        private static final Matrix n = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        Paint f3538a;
        Paint b;

        /* renamed from: c  reason: collision with root package name */
        final VGroup f3539c;
        float d;
        float e;
        float f;
        float g;
        int h;
        String i;
        Boolean j;
        final ArrayMap<String, Object> k;
        private final Path l;
        private final Path m;
        private final Matrix o;
        private PathMeasure p;
        private int q;

        public VPathRenderer() {
            this.o = new Matrix();
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 255;
            this.i = null;
            this.j = null;
            this.k = new ArrayMap<>();
            this.f3539c = new VGroup();
            this.l = new Path();
            this.m = new Path();
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.o = new Matrix();
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 255;
            this.i = null;
            this.j = null;
            ArrayMap<String, Object> arrayMap = new ArrayMap<>();
            this.k = arrayMap;
            this.f3539c = new VGroup(vPathRenderer.f3539c, arrayMap);
            this.l = new Path(vPathRenderer.l);
            this.m = new Path(vPathRenderer.m);
            this.d = vPathRenderer.d;
            this.e = vPathRenderer.e;
            this.f = vPathRenderer.f;
            this.g = vPathRenderer.g;
            this.q = vPathRenderer.q;
            this.h = vPathRenderer.h;
            this.i = vPathRenderer.i;
            String str = vPathRenderer.i;
            if (str != null) {
                this.k.put(str, this);
            }
            this.j = vPathRenderer.j;
        }

        private static float a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private float a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot(fArr[0], fArr[1]);
            float hypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max(hypot, hypot2);
            float f = 0.0f;
            if (max > 0.0f) {
                f = Math.abs(a2) / max;
            }
            return f;
        }

        private void a(VGroup vGroup, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            vGroup.f3536a.set(matrix);
            vGroup.f3536a.preConcat(vGroup.d);
            canvas.save();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= vGroup.b.size()) {
                    canvas.restore();
                    return;
                }
                VObject vObject = vGroup.b.get(i4);
                if (vObject instanceof VGroup) {
                    a((VGroup) vObject, vGroup.f3536a, canvas, i, i2, colorFilter);
                } else if (vObject instanceof VPath) {
                    a(vGroup, (VPath) vObject, canvas, i, i2, colorFilter);
                }
                i3 = i4 + 1;
            }
        }

        private void a(VGroup vGroup, VPath vPath, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = i / this.f;
            float f2 = i2 / this.g;
            float min = Math.min(f, f2);
            Matrix matrix = vGroup.f3536a;
            this.o.set(matrix);
            this.o.postScale(f, f2);
            float a2 = a(matrix);
            if (a2 == 0.0f) {
                return;
            }
            vPath.toPath(this.l);
            Path path = this.l;
            this.m.reset();
            if (vPath.isClipPath()) {
                this.m.setFillType(vPath.n == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.m.addPath(path, this.o);
                canvas.clipPath(this.m);
                return;
            }
            VFullPath vFullPath = (VFullPath) vPath;
            if (vFullPath.f != 0.0f || vFullPath.g != 1.0f) {
                float f3 = vFullPath.f;
                float f4 = vFullPath.h;
                float f5 = vFullPath.g;
                float f6 = vFullPath.h;
                if (this.p == null) {
                    this.p = new PathMeasure();
                }
                this.p.setPath(this.l, false);
                float length = this.p.getLength();
                float f7 = ((f3 + f4) % 1.0f) * length;
                float f8 = ((f5 + f6) % 1.0f) * length;
                path.reset();
                if (f7 > f8) {
                    this.p.getSegment(f7, length, path, true);
                    this.p.getSegment(0.0f, f8, path, true);
                } else {
                    this.p.getSegment(f7, f8, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.m.addPath(path, this.o);
            if (vFullPath.f3535c.willDraw()) {
                ComplexColorCompat complexColorCompat = vFullPath.f3535c;
                if (this.b == null) {
                    Paint paint = new Paint(1);
                    this.b = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.b;
                if (complexColorCompat.isGradient()) {
                    Shader shader = complexColorCompat.getShader();
                    shader.setLocalMatrix(this.o);
                    paint2.setShader(shader);
                    paint2.setAlpha(Math.round(vFullPath.e * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(VectorDrawableCompat.a(complexColorCompat.getColor(), vFullPath.e));
                }
                paint2.setColorFilter(colorFilter);
                this.m.setFillType(vFullPath.n == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.m, paint2);
            }
            if (vFullPath.f3534a.willDraw()) {
                ComplexColorCompat complexColorCompat2 = vFullPath.f3534a;
                if (this.f3538a == null) {
                    Paint paint3 = new Paint(1);
                    this.f3538a = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f3538a;
                if (vFullPath.j != null) {
                    paint4.setStrokeJoin(vFullPath.j);
                }
                if (vFullPath.i != null) {
                    paint4.setStrokeCap(vFullPath.i);
                }
                paint4.setStrokeMiter(vFullPath.k);
                if (complexColorCompat2.isGradient()) {
                    Shader shader2 = complexColorCompat2.getShader();
                    shader2.setLocalMatrix(this.o);
                    paint4.setShader(shader2);
                    paint4.setAlpha(Math.round(vFullPath.d * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(VectorDrawableCompat.a(complexColorCompat2.getColor(), vFullPath.d));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(vFullPath.b * min * a2);
                canvas.drawPath(this.m, paint4);
            }
        }

        public void draw(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            a(this.f3539c, n, canvas, i, i2, colorFilter);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.h;
        }

        public boolean isStateful() {
            if (this.j == null) {
                this.j = Boolean.valueOf(this.f3539c.isStateful());
            }
            return this.j.booleanValue();
        }

        public boolean onStateChanged(int[] iArr) {
            return this.f3539c.onStateChanged(iArr);
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.h = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/vectordrawable/graphics/drawable/VectorDrawableCompat$VectorDrawableCompatState.class */
    public static class VectorDrawableCompatState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f3540a;
        VPathRenderer b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f3541c;
        PorterDuff.Mode d;
        boolean e;
        Bitmap f;
        ColorStateList g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public VectorDrawableCompatState() {
            this.f3541c = null;
            this.d = VectorDrawableCompat.f3532a;
            this.b = new VPathRenderer();
        }

        public VectorDrawableCompatState(VectorDrawableCompatState vectorDrawableCompatState) {
            this.f3541c = null;
            this.d = VectorDrawableCompat.f3532a;
            if (vectorDrawableCompatState != null) {
                this.f3540a = vectorDrawableCompatState.f3540a;
                this.b = new VPathRenderer(vectorDrawableCompatState.b);
                if (vectorDrawableCompatState.b.b != null) {
                    this.b.b = new Paint(vectorDrawableCompatState.b.b);
                }
                if (vectorDrawableCompatState.b.f3538a != null) {
                    this.b.f3538a = new Paint(vectorDrawableCompatState.b.f3538a);
                }
                this.f3541c = vectorDrawableCompatState.f3541c;
                this.d = vectorDrawableCompatState.d;
                this.e = vectorDrawableCompatState.e;
            }
        }

        public boolean canReuseBitmap(int i, int i2) {
            return i == this.f.getWidth() && i2 == this.f.getHeight();
        }

        public boolean canReuseCache() {
            return !this.k && this.g == this.f3541c && this.h == this.d && this.j == this.e && this.i == this.b.getRootAlpha();
        }

        public void createCachedBitmapIfNeeded(int i, int i2) {
            if (this.f == null || !canReuseBitmap(i, i2)) {
                this.f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        public void drawCachedBitmapWithRootAlpha(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f, (Rect) null, rect, getPaint(colorFilter));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f3540a;
        }

        public Paint getPaint(ColorFilter colorFilter) {
            if (hasTranslucentRoot() || colorFilter != null) {
                if (this.l == null) {
                    Paint paint = new Paint();
                    this.l = paint;
                    paint.setFilterBitmap(true);
                }
                this.l.setAlpha(this.b.getRootAlpha());
                this.l.setColorFilter(colorFilter);
                return this.l;
            }
            return null;
        }

        public boolean hasTranslucentRoot() {
            return this.b.getRootAlpha() < 255;
        }

        public boolean isStateful() {
            return this.b.isStateful();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        public boolean onStateChanged(int[] iArr) {
            boolean onStateChanged = this.b.onStateChanged(iArr);
            this.k |= onStateChanged;
            return onStateChanged;
        }

        public void updateCacheStates() {
            this.g = this.f3541c;
            this.h = this.d;
            this.i = this.b.getRootAlpha();
            this.j = this.e;
            this.k = false;
        }

        public void updateCachedBitmap(int i, int i2) {
            this.f.eraseColor(0);
            this.b.draw(new Canvas(this.f), i, i2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/vectordrawable/graphics/drawable/VectorDrawableCompat$VectorDrawableDelegateState.class */
    public static class VectorDrawableDelegateState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f3542a;

        public VectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.f3542a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f3542a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f3542a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.d = (VectorDrawable) this.f3542a.newDrawable();
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.d = (VectorDrawable) this.f3542a.newDrawable(resources);
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.d = (VectorDrawable) this.f3542a.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }
    }

    VectorDrawableCompat() {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.b = new VectorDrawableCompatState();
    }

    VectorDrawableCompat(VectorDrawableCompatState vectorDrawableCompatState) {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.b = vectorDrawableCompatState;
        this.f3533c = a(this.f3533c, vectorDrawableCompatState.f3541c, vectorDrawableCompatState.d);
    }

    static int a(int i, float f) {
        return (i & 16777215) | (((int) (Color.alpha(i) * f)) << 24);
    }

    private static PorterDuff.Mode a(int i, PorterDuff.Mode mode) {
        if (i != 3) {
            if (i != 5) {
                if (i != 9) {
                    switch (i) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    private void a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        boolean z;
        boolean z2;
        VectorDrawableCompatState vectorDrawableCompatState = this.b;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(vPathRenderer.f3539c);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth();
        boolean z3 = true;
        while (true) {
            z = z3;
            if (eventType == 1 || (xmlPullParser.getDepth() < depth + 1 && eventType == 3)) {
                break;
            }
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                VGroup vGroup = (VGroup) arrayDeque.peek();
                if (OapsWrapper.KEY_PATH.equals(name)) {
                    VFullPath vFullPath = new VFullPath();
                    vFullPath.inflate(resources, attributeSet, theme, xmlPullParser);
                    vGroup.b.add(vFullPath);
                    if (vFullPath.getPathName() != null) {
                        vPathRenderer.k.put(vFullPath.getPathName(), vFullPath);
                    }
                    z2 = false;
                    vectorDrawableCompatState.f3540a = vFullPath.o | vectorDrawableCompatState.f3540a;
                } else if ("clip-path".equals(name)) {
                    VClipPath vClipPath = new VClipPath();
                    vClipPath.inflate(resources, attributeSet, theme, xmlPullParser);
                    vGroup.b.add(vClipPath);
                    if (vClipPath.getPathName() != null) {
                        vPathRenderer.k.put(vClipPath.getPathName(), vClipPath);
                    }
                    vectorDrawableCompatState.f3540a = vClipPath.o | vectorDrawableCompatState.f3540a;
                    z2 = z;
                } else {
                    z2 = z;
                    if ("group".equals(name)) {
                        VGroup vGroup2 = new VGroup();
                        vGroup2.inflate(resources, attributeSet, theme, xmlPullParser);
                        vGroup.b.add(vGroup2);
                        arrayDeque.push(vGroup2);
                        if (vGroup2.getGroupName() != null) {
                            vPathRenderer.k.put(vGroup2.getGroupName(), vGroup2);
                        }
                        vectorDrawableCompatState.f3540a = vGroup2.e | vectorDrawableCompatState.f3540a;
                        z2 = z;
                    }
                }
            } else {
                z2 = z;
                if (eventType == 3) {
                    z2 = z;
                    if ("group".equals(xmlPullParser.getName())) {
                        arrayDeque.pop();
                        z2 = z;
                    }
                }
            }
            eventType = xmlPullParser.next();
            z3 = z2;
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        VectorDrawableCompatState vectorDrawableCompatState = this.b;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.b;
        vectorDrawableCompatState.d = a(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList namedColorStateList = TypedArrayUtils.getNamedColorStateList(typedArray, xmlPullParser, theme, "tint", 1);
        if (namedColorStateList != null) {
            vectorDrawableCompatState.f3541c = namedColorStateList;
        }
        vectorDrawableCompatState.e = TypedArrayUtils.getNamedBoolean(typedArray, xmlPullParser, "autoMirrored", 5, vectorDrawableCompatState.e);
        vPathRenderer.f = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportWidth", 7, vPathRenderer.f);
        vPathRenderer.g = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportHeight", 8, vPathRenderer.g);
        if (vPathRenderer.f <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (vPathRenderer.g <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            vPathRenderer.d = typedArray.getDimension(3, vPathRenderer.d);
            vPathRenderer.e = typedArray.getDimension(2, vPathRenderer.e);
            if (vPathRenderer.d <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (vPathRenderer.e <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                vPathRenderer.setAlpha(TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "alpha", 4, vPathRenderer.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    vPathRenderer.i = string;
                    vPathRenderer.k.put(string, vPathRenderer);
                }
            }
        }
    }

    private boolean a() {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 17) {
            z = false;
            if (isAutoMirrored()) {
                z = false;
                if (DrawableCompat.getLayoutDirection(this) == 1) {
                    z = true;
                }
            }
        }
        return z;
    }

    public static VectorDrawableCompat create(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.d = ResourcesCompat.getDrawable(resources, i, theme);
            vectorDrawableCompat.h = new VectorDrawableDelegateState(vectorDrawableCompat.d.getConstantState());
            return vectorDrawableCompat;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return createFromXmlInner(resources, (XmlPullParser) xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (XmlPullParserException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public static VectorDrawableCompat createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(String str) {
        return this.b.b.k.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.g = z;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.d != null) {
            DrawableCompat.canApplyTheme(this.d);
            return false;
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.d != null) {
            this.d.draw(canvas);
            return;
        }
        copyBounds(this.k);
        if (this.k.width() <= 0 || this.k.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.e;
        PorterDuffColorFilter porterDuffColorFilter = colorFilter;
        if (colorFilter == null) {
            porterDuffColorFilter = this.f3533c;
        }
        canvas.getMatrix(this.j);
        this.j.getValues(this.i);
        float abs = Math.abs(this.i[0]);
        float abs2 = Math.abs(this.i[4]);
        float abs3 = Math.abs(this.i[1]);
        float abs4 = Math.abs(this.i[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min(2048, (int) (this.k.width() * abs));
        int min2 = Math.min(2048, (int) (this.k.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(this.k.left, this.k.top);
        if (a()) {
            canvas.translate(this.k.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.k.offsetTo(0, 0);
        this.b.createCachedBitmapIfNeeded(min, min2);
        if (!this.g) {
            this.b.updateCachedBitmap(min, min2);
        } else if (!this.b.canReuseCache()) {
            this.b.updateCachedBitmap(min, min2);
            this.b.updateCacheStates();
        }
        this.b.drawCachedBitmapWithRootAlpha(canvas, porterDuffColorFilter, this.k);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.d != null ? DrawableCompat.getAlpha(this.d) : this.b.b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.d != null ? this.d.getChangingConfigurations() : super.getChangingConfigurations() | this.b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.d != null ? DrawableCompat.getColorFilter(this.d) : this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.d == null || Build.VERSION.SDK_INT < 24) {
            this.b.f3540a = getChangingConfigurations();
            return this.b;
        }
        return new VectorDrawableDelegateState(this.d.getConstantState());
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.d != null ? this.d.getIntrinsicHeight() : (int) this.b.b.e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.d != null ? this.d.getIntrinsicWidth() : (int) this.b.b.d;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.d != null) {
            return this.d.getOpacity();
        }
        return -3;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public float getPixelSize() {
        VectorDrawableCompatState vectorDrawableCompatState = this.b;
        if (vectorDrawableCompatState == null || vectorDrawableCompatState.b == null || this.b.b.d == 0.0f || this.b.b.e == 0.0f || this.b.b.g == 0.0f || this.b.b.f == 0.0f) {
            return 1.0f;
        }
        float f = this.b.b.d;
        float f2 = this.b.b.e;
        return Math.min(this.b.b.f / f, this.b.b.g / f2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.d != null) {
            this.d.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.d != null) {
            DrawableCompat.inflate(this.d, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.b;
        vectorDrawableCompatState.b = new VPathRenderer();
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.f3519a);
        a(obtainAttributes, xmlPullParser, theme);
        obtainAttributes.recycle();
        vectorDrawableCompatState.f3540a = getChangingConfigurations();
        vectorDrawableCompatState.k = true;
        a(resources, xmlPullParser, attributeSet, theme);
        this.f3533c = a(this.f3533c, vectorDrawableCompatState.f3541c, vectorDrawableCompatState.d);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.d != null) {
            this.d.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.d != null ? DrawableCompat.isAutoMirrored(this.d) : this.b.e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.d != null) {
            return this.d.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.b;
        if (vectorDrawableCompatState != null) {
            if (vectorDrawableCompatState.isStateful()) {
                return true;
            }
            return this.b.f3541c != null && this.b.f3541c.isStateful();
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.d != null) {
            this.d.mutate();
            return this;
        }
        if (!this.f && super.mutate() == this) {
            this.b = new VectorDrawableCompatState(this.b);
            this.f = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        if (this.d != null) {
            this.d.setBounds(rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (this.d != null) {
            return this.d.setState(iArr);
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.b;
        boolean z = false;
        if (vectorDrawableCompatState.f3541c != null) {
            z = false;
            if (vectorDrawableCompatState.d != null) {
                this.f3533c = a(this.f3533c, vectorDrawableCompatState.f3541c, vectorDrawableCompatState.d);
                invalidateSelf();
                z = true;
            }
        }
        if (vectorDrawableCompatState.isStateful() && vectorDrawableCompatState.onStateChanged(iArr)) {
            invalidateSelf();
            return true;
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        if (this.d != null) {
            this.d.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.d != null) {
            this.d.setAlpha(i);
        } else if (this.b.b.getRootAlpha() != i) {
            this.b.b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.d != null) {
            DrawableCompat.setAutoMirrored(this.d, z);
        } else {
            this.b.e = z;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.d != null) {
            this.d.setColorFilter(colorFilter);
            return;
        }
        this.e = colorFilter;
        invalidateSelf();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        if (this.d != null) {
            DrawableCompat.setTint(this.d, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.d != null) {
            DrawableCompat.setTintList(this.d, colorStateList);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.b;
        if (vectorDrawableCompatState.f3541c != colorStateList) {
            vectorDrawableCompatState.f3541c = colorStateList;
            this.f3533c = a(this.f3533c, colorStateList, vectorDrawableCompatState.d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.d != null) {
            DrawableCompat.setTintMode(this.d, mode);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.b;
        if (vectorDrawableCompatState.d != mode) {
            vectorDrawableCompatState.d = mode;
            this.f3533c = a(this.f3533c, vectorDrawableCompatState.f3541c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.d != null ? this.d.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        if (this.d != null) {
            this.d.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
