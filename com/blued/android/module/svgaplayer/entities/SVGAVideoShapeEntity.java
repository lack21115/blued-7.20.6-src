package com.blued.android.module.svgaplayer.entities;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.alipay.sdk.sys.a;
import com.blued.android.module.svgaplayer.proto.ShapeEntity;
import com.blued.android.module.svgaplayer.proto.Transform;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/entities/SVGAVideoShapeEntity.class */
public final class SVGAVideoShapeEntity {
    private Type a;
    private Map<String, ? extends Object> b;
    private Styles c;
    private Matrix d;
    private Path e;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/entities/SVGAVideoShapeEntity$Styles.class */
    public static final class Styles {
        private int a;
        private int b;
        private float c;
        private int f;
        private String d = "butt";
        private String e = "miter";
        private float[] g = new float[0];

        public final int a() {
            return this.a;
        }

        public final void a(float f) {
            this.c = f;
        }

        public final void a(int i) {
            this.a = i;
        }

        public final void a(String str) {
            Intrinsics.e(str, "<set-?>");
            this.d = str;
        }

        public final void a(float[] fArr) {
            Intrinsics.e(fArr, "<set-?>");
            this.g = fArr;
        }

        public final int b() {
            return this.b;
        }

        public final void b(int i) {
            this.b = i;
        }

        public final void b(String str) {
            Intrinsics.e(str, "<set-?>");
            this.e = str;
        }

        public final float c() {
            return this.c;
        }

        public final void c(int i) {
            this.f = i;
        }

        public final String d() {
            return this.d;
        }

        public final String e() {
            return this.e;
        }

        public final int f() {
            return this.f;
        }

        public final float[] g() {
            return this.g;
        }
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/entities/SVGAVideoShapeEntity$Type.class */
    public enum Type {
        shape,
        rect,
        ellipse,
        keep
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/entities/SVGAVideoShapeEntity$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[ShapeEntity.ShapeType.values().length];
            iArr[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
            iArr[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
            iArr[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
            iArr[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
            a = iArr;
            int[] iArr2 = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
            iArr2[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
            iArr2[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
            iArr2[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
            b = iArr2;
            int[] iArr3 = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
            iArr3[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
            iArr3[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
            iArr3[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
            c = iArr3;
        }
    }

    public SVGAVideoShapeEntity(ShapeEntity obj) {
        Intrinsics.e(obj, "obj");
        this.a = Type.shape;
        a(obj);
        b(obj);
        c(obj);
        d(obj);
    }

    public SVGAVideoShapeEntity(JSONObject obj) {
        Intrinsics.e(obj, "obj");
        this.a = Type.shape;
        a(obj);
        b(obj);
        c(obj);
        d(obj);
    }

    private final float a(ShapeEntity.ShapeStyle.RGBAColor rGBAColor) {
        Float f = rGBAColor.r;
        float f2 = 1.0f;
        if ((f == null ? 0.0f : f.floatValue()) <= 1.0f) {
            Float f3 = rGBAColor.g;
            f2 = 1.0f;
            if ((f3 == null ? 0.0f : f3.floatValue()) <= 1.0f) {
                Float f4 = rGBAColor.b;
                f2 = 1.0f;
                if ((f4 == null ? 0.0f : f4.floatValue()) <= 1.0f) {
                    f2 = 255.0f;
                }
            }
        }
        return f2;
    }

    private final float a(JSONArray jSONArray) {
        return (jSONArray.optDouble(0) > 1.0d || jSONArray.optDouble(1) > 1.0d || jSONArray.optDouble(2) > 1.0d) ? 1.0f : 255.0f;
    }

    private final void a(ShapeEntity shapeEntity) {
        Type type;
        ShapeEntity.ShapeType shapeType = shapeEntity.type;
        if (shapeType != null) {
            int i = WhenMappings.a[shapeType.ordinal()];
            if (i == 1) {
                type = Type.shape;
            } else if (i == 2) {
                type = Type.rect;
            } else if (i == 3) {
                type = Type.ellipse;
            } else if (i != 4) {
                throw new NoWhenBranchMatchedException();
            } else {
                type = Type.keep;
            }
            this.a = type;
        }
    }

    private final void a(JSONObject jSONObject) {
        String optString = jSONObject.optString("type");
        if (optString != null) {
            if (StringsKt.a(optString, "shape", true)) {
                this.a = Type.shape;
            } else if (StringsKt.a(optString, "rect", true)) {
                this.a = Type.rect;
            } else if (StringsKt.a(optString, "ellipse", true)) {
                this.a = Type.ellipse;
            } else if (StringsKt.a(optString, "keep", true)) {
                this.a = Type.keep;
            }
        }
    }

    private final float b(ShapeEntity.ShapeStyle.RGBAColor rGBAColor) {
        Float f = rGBAColor.a;
        Intrinsics.c(f, "color.a");
        float f2 = 1.0f;
        if (f.floatValue() <= 1.0f) {
            f2 = 255.0f;
        }
        return f2;
    }

    private final float b(JSONArray jSONArray) {
        return jSONArray.optDouble(3) <= 1.0d ? 255.0f : 1.0f;
    }

    private final void b(ShapeEntity shapeEntity) {
        float floatValue;
        float floatValue2;
        float floatValue3;
        float floatValue4;
        float floatValue5;
        float floatValue6;
        float floatValue7;
        float floatValue8;
        float floatValue9;
        String d;
        HashMap hashMap = new HashMap();
        ShapeEntity.ShapeArgs shapeArgs = shapeEntity.shape;
        if (shapeArgs != null && (d = shapeArgs.d) != null) {
            Intrinsics.c(d, "d");
            hashMap.put("d", d);
        }
        ShapeEntity.EllipseArgs ellipseArgs = shapeEntity.ellipse;
        if (ellipseArgs != null) {
            Float f = ellipseArgs.x;
            if (f == null) {
                floatValue6 = 0.0f;
            } else {
                Intrinsics.c(f, "it.x ?: 0.0f");
                floatValue6 = f.floatValue();
            }
            hashMap.put("x", Float.valueOf(floatValue6));
            Float f2 = ellipseArgs.y;
            if (f2 == null) {
                floatValue7 = 0.0f;
            } else {
                Intrinsics.c(f2, "it.y ?: 0.0f");
                floatValue7 = f2.floatValue();
            }
            hashMap.put("y", Float.valueOf(floatValue7));
            Float f3 = ellipseArgs.radiusX;
            if (f3 == null) {
                floatValue8 = 0.0f;
            } else {
                Intrinsics.c(f3, "it.radiusX ?: 0.0f");
                floatValue8 = f3.floatValue();
            }
            hashMap.put("radiusX", Float.valueOf(floatValue8));
            Float f4 = ellipseArgs.radiusY;
            if (f4 == null) {
                floatValue9 = 0.0f;
            } else {
                Intrinsics.c(f4, "it.radiusY ?: 0.0f");
                floatValue9 = f4.floatValue();
            }
            hashMap.put("radiusY", Float.valueOf(floatValue9));
        }
        ShapeEntity.RectArgs rectArgs = shapeEntity.rect;
        if (rectArgs != null) {
            Float f5 = rectArgs.x;
            if (f5 == null) {
                floatValue = 0.0f;
            } else {
                Intrinsics.c(f5, "it.x ?: 0.0f");
                floatValue = f5.floatValue();
            }
            hashMap.put("x", Float.valueOf(floatValue));
            Float f6 = rectArgs.y;
            if (f6 == null) {
                floatValue2 = 0.0f;
            } else {
                Intrinsics.c(f6, "it.y ?: 0.0f");
                floatValue2 = f6.floatValue();
            }
            hashMap.put("y", Float.valueOf(floatValue2));
            Float f7 = rectArgs.width;
            if (f7 == null) {
                floatValue3 = 0.0f;
            } else {
                Intrinsics.c(f7, "it.width ?: 0.0f");
                floatValue3 = f7.floatValue();
            }
            hashMap.put("width", Float.valueOf(floatValue3));
            Float f8 = rectArgs.height;
            if (f8 == null) {
                floatValue4 = 0.0f;
            } else {
                Intrinsics.c(f8, "it.height ?: 0.0f");
                floatValue4 = f8.floatValue();
            }
            hashMap.put("height", Float.valueOf(floatValue4));
            Float f9 = rectArgs.cornerRadius;
            if (f9 == null) {
                floatValue5 = 0.0f;
            } else {
                Intrinsics.c(f9, "it.cornerRadius ?: 0.0f");
                floatValue5 = f9.floatValue();
            }
            hashMap.put("cornerRadius", Float.valueOf(floatValue5));
        }
        this.b = hashMap;
    }

    private final void b(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        JSONObject optJSONObject = jSONObject.optJSONObject("args");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            Intrinsics.c(keys, "values.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = optJSONObject.get(next);
                if (obj != null) {
                    Intrinsics.c(obj, "get(key)");
                    hashMap.put(next, obj);
                }
            }
            this.b = hashMap;
        }
    }

    private final void c(ShapeEntity shapeEntity) {
        float floatValue;
        ShapeEntity.ShapeStyle shapeStyle = shapeEntity.styles;
        if (shapeStyle != null) {
            Styles styles = new Styles();
            ShapeEntity.ShapeStyle.RGBAColor fill = shapeStyle.fill;
            if (fill != null) {
                Intrinsics.c(fill, "fill");
                float a = a(fill);
                float b = b(fill);
                Float f = fill.a;
                int floatValue2 = (int) ((f != null ? f.floatValue() : 0.0f) * b);
                Float f2 = fill.r;
                int floatValue3 = (int) ((f2 != null ? f2.floatValue() : 0.0f) * a);
                Float f3 = fill.g;
                int floatValue4 = (int) ((f3 != null ? f3.floatValue() : 0.0f) * a);
                Float f4 = fill.b;
                styles.a(Color.argb(floatValue2, floatValue3, floatValue4, (int) ((f4 != null ? f4.floatValue() : 0.0f) * a)));
            }
            ShapeEntity.ShapeStyle.RGBAColor stroke = shapeStyle.stroke;
            if (stroke != null) {
                Intrinsics.c(stroke, "stroke");
                float a2 = a(stroke);
                float b2 = b(stroke);
                Float f5 = stroke.a;
                int floatValue5 = (int) ((f5 != null ? f5.floatValue() : 0.0f) * b2);
                Float f6 = stroke.r;
                int floatValue6 = (int) ((f6 != null ? f6.floatValue() : 0.0f) * a2);
                Float f7 = stroke.g;
                int floatValue7 = (int) ((f7 != null ? f7.floatValue() : 0.0f) * a2);
                Float f8 = stroke.b;
                styles.b(Color.argb(floatValue5, floatValue6, floatValue7, (int) ((f8 != null ? f8.floatValue() : 0.0f) * a2)));
            }
            Float f9 = shapeStyle.strokeWidth;
            if (f9 == null) {
                floatValue = 0.0f;
            } else {
                Intrinsics.c(f9, "it.strokeWidth ?: 0.0f");
                floatValue = f9.floatValue();
            }
            styles.a(floatValue);
            ShapeEntity.ShapeStyle.LineCap lineCap = shapeStyle.lineCap;
            if (lineCap != null) {
                Intrinsics.c(lineCap, "lineCap");
                int i = WhenMappings.b[lineCap.ordinal()];
                if (i == 1) {
                    styles.a("butt");
                } else if (i == 2) {
                    styles.a("round");
                } else if (i == 3) {
                    styles.a("square");
                }
            }
            ShapeEntity.ShapeStyle.LineJoin lineJoin = shapeStyle.lineJoin;
            if (lineJoin != null) {
                Intrinsics.c(lineJoin, "lineJoin");
                int i2 = WhenMappings.c[lineJoin.ordinal()];
                if (i2 == 1) {
                    styles.b("bevel");
                } else if (i2 == 2) {
                    styles.b("miter");
                } else if (i2 == 3) {
                    styles.b("round");
                }
            }
            Float f10 = shapeStyle.miterLimit;
            float f11 = 0.0f;
            if (f10 != null) {
                f11 = f10.floatValue();
            }
            styles.c((int) f11);
            styles.a(new float[3]);
            Float lineDashI = shapeStyle.lineDashI;
            if (lineDashI != null) {
                Intrinsics.c(lineDashI, "lineDashI");
                styles.g()[0] = lineDashI.floatValue();
            }
            Float lineDashII = shapeStyle.lineDashII;
            if (lineDashII != null) {
                Intrinsics.c(lineDashII, "lineDashII");
                styles.g()[1] = lineDashII.floatValue();
            }
            Float lineDashIII = shapeStyle.lineDashIII;
            if (lineDashIII != null) {
                Intrinsics.c(lineDashIII, "lineDashIII");
                styles.g()[2] = lineDashIII.floatValue();
            }
            this.c = styles;
        }
    }

    private final void c(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("styles");
        if (optJSONObject != null) {
            Styles styles = new Styles();
            JSONArray optJSONArray = optJSONObject.optJSONArray("fill");
            if (optJSONArray != null) {
                Intrinsics.c(optJSONArray, "optJSONArray(\"fill\")");
                if (optJSONArray.length() == 4) {
                    float a = a(optJSONArray);
                    int optDouble = (int) (optJSONArray.optDouble(3) * b(optJSONArray));
                    double optDouble2 = optJSONArray.optDouble(0);
                    double d = a;
                    styles.a(Color.argb(optDouble, (int) (optDouble2 * d), (int) (optJSONArray.optDouble(1) * d), (int) (optJSONArray.optDouble(2) * d)));
                }
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("stroke");
            if (optJSONArray2 != null) {
                Intrinsics.c(optJSONArray2, "optJSONArray(\"stroke\")");
                if (optJSONArray2.length() == 4) {
                    float a2 = a(optJSONArray2);
                    int optDouble3 = (int) (optJSONArray2.optDouble(3) * b(optJSONArray2));
                    double optDouble4 = optJSONArray2.optDouble(0);
                    double d2 = a2;
                    styles.b(Color.argb(optDouble3, (int) (optDouble4 * d2), (int) (optJSONArray2.optDouble(1) * d2), (int) (optJSONArray2.optDouble(2) * d2)));
                }
            }
            styles.a((float) optJSONObject.optDouble("strokeWidth", 0.0d));
            String optString = optJSONObject.optString("lineCap", "butt");
            Intrinsics.c(optString, "it.optString(\"lineCap\", \"butt\")");
            styles.a(optString);
            String optString2 = optJSONObject.optString("lineJoin", "miter");
            Intrinsics.c(optString2, "it.optString(\"lineJoin\", \"miter\")");
            styles.b(optString2);
            styles.c(optJSONObject.optInt("miterLimit", 0));
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("lineDash");
            if (optJSONArray3 != null) {
                Intrinsics.c(optJSONArray3, "optJSONArray(\"lineDash\")");
                styles.a(new float[optJSONArray3.length()]);
                int length = optJSONArray3.length();
                for (int i = 0; i < length; i++) {
                    styles.g()[i] = (float) optJSONArray3.optDouble(i, 0.0d);
                }
            }
            this.c = styles;
        }
    }

    private final void d(ShapeEntity shapeEntity) {
        float floatValue;
        float floatValue2;
        float floatValue3;
        float floatValue4;
        float floatValue5;
        float floatValue6;
        Transform transform = shapeEntity.transform;
        if (transform != null) {
            Matrix matrix = new Matrix();
            Float f = transform.a;
            if (f == null) {
                floatValue = 1.0f;
            } else {
                Intrinsics.c(f, "it.a ?: 1.0f");
                floatValue = f.floatValue();
            }
            Float f2 = transform.b;
            if (f2 == null) {
                floatValue2 = 0.0f;
            } else {
                Intrinsics.c(f2, "it.b ?: 0.0f");
                floatValue2 = f2.floatValue();
            }
            Float f3 = transform.c;
            if (f3 == null) {
                floatValue3 = 0.0f;
            } else {
                Intrinsics.c(f3, "it.c ?: 0.0f");
                floatValue3 = f3.floatValue();
            }
            Float f4 = transform.d;
            if (f4 == null) {
                floatValue4 = 1.0f;
            } else {
                Intrinsics.c(f4, "it.d ?: 1.0f");
                floatValue4 = f4.floatValue();
            }
            Float f5 = transform.tx;
            if (f5 == null) {
                floatValue5 = 0.0f;
            } else {
                Intrinsics.c(f5, "it.tx ?: 0.0f");
                floatValue5 = f5.floatValue();
            }
            Float f6 = transform.ty;
            if (f6 == null) {
                floatValue6 = 0.0f;
            } else {
                Intrinsics.c(f6, "it.ty ?: 0.0f");
                floatValue6 = f6.floatValue();
            }
            matrix.setValues(new float[]{floatValue, floatValue3, floatValue5, floatValue2, floatValue4, floatValue6, 0.0f, 0.0f, 1.0f});
            this.d = matrix;
        }
    }

    private final void d(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("transform");
        if (optJSONObject != null) {
            Matrix matrix = new Matrix();
            double optDouble = optJSONObject.optDouble("a", 1.0d);
            double optDouble2 = optJSONObject.optDouble("b", 0.0d);
            matrix.setValues(new float[]{(float) optDouble, (float) optJSONObject.optDouble("c", 0.0d), (float) optJSONObject.optDouble("tx", 0.0d), (float) optDouble2, (float) optJSONObject.optDouble("d", 1.0d), (float) optJSONObject.optDouble(a.g, 0.0d), 0.0f, 0.0f, 1.0f});
            this.d = matrix;
        }
    }

    public final Map<String, Object> a() {
        return this.b;
    }

    public final Styles b() {
        return this.c;
    }

    public final Matrix c() {
        return this.d;
    }

    public final boolean d() {
        return this.a == Type.keep;
    }

    public final Path e() {
        return this.e;
    }

    public final void f() {
        if (this.e != null) {
            return;
        }
        SVGAVideoShapeEntityKt.a().reset();
        Number number = null;
        Number number2 = null;
        String str = null;
        if (this.a == Type.shape) {
            Map<String, ? extends Object> map = this.b;
            Object obj = map != null ? map.get("d") : null;
            if (obj instanceof String) {
                str = (String) obj;
            }
            if (str != null) {
                new SVGAPathEntity(str).a(SVGAVideoShapeEntityKt.a());
            }
        } else if (this.a == Type.ellipse) {
            Map<String, ? extends Object> map2 = this.b;
            Object obj2 = map2 != null ? map2.get("x") : null;
            Number number3 = obj2 instanceof Number ? (Number) obj2 : null;
            if (number3 == null) {
                return;
            }
            Map<String, ? extends Object> map3 = this.b;
            Object obj3 = map3 != null ? map3.get("y") : null;
            Number number4 = obj3 instanceof Number ? (Number) obj3 : null;
            if (number4 == null) {
                return;
            }
            Map<String, ? extends Object> map4 = this.b;
            Object obj4 = map4 != null ? map4.get("radiusX") : null;
            Number number5 = obj4 instanceof Number ? (Number) obj4 : null;
            if (number5 == null) {
                return;
            }
            Map<String, ? extends Object> map5 = this.b;
            Object obj5 = map5 != null ? map5.get("radiusY") : null;
            if (obj5 instanceof Number) {
                number = (Number) obj5;
            }
            if (number == null) {
                return;
            }
            float floatValue = number3.floatValue();
            float floatValue2 = number4.floatValue();
            float floatValue3 = number5.floatValue();
            float floatValue4 = number.floatValue();
            SVGAVideoShapeEntityKt.a().addOval(new RectF(floatValue - floatValue3, floatValue2 - floatValue4, floatValue + floatValue3, floatValue2 + floatValue4), Path.Direction.CW);
        } else if (this.a == Type.rect) {
            Map<String, ? extends Object> map6 = this.b;
            Object obj6 = map6 != null ? map6.get("x") : null;
            Number number6 = obj6 instanceof Number ? (Number) obj6 : null;
            if (number6 == null) {
                return;
            }
            Map<String, ? extends Object> map7 = this.b;
            Object obj7 = map7 != null ? map7.get("y") : null;
            Number number7 = obj7 instanceof Number ? (Number) obj7 : null;
            if (number7 == null) {
                return;
            }
            Map<String, ? extends Object> map8 = this.b;
            Object obj8 = map8 != null ? map8.get("width") : null;
            Number number8 = obj8 instanceof Number ? (Number) obj8 : null;
            if (number8 == null) {
                return;
            }
            Map<String, ? extends Object> map9 = this.b;
            Object obj9 = map9 != null ? map9.get("height") : null;
            Number number9 = obj9 instanceof Number ? (Number) obj9 : null;
            if (number9 == null) {
                return;
            }
            Map<String, ? extends Object> map10 = this.b;
            Object obj10 = map10 != null ? map10.get("cornerRadius") : null;
            if (obj10 instanceof Number) {
                number2 = (Number) obj10;
            }
            if (number2 == null) {
                return;
            }
            float floatValue5 = number6.floatValue();
            float floatValue6 = number7.floatValue();
            float floatValue7 = number8.floatValue();
            float floatValue8 = number9.floatValue();
            float floatValue9 = number2.floatValue();
            SVGAVideoShapeEntityKt.a().addRoundRect(new RectF(floatValue5, floatValue6, floatValue7 + floatValue5, floatValue8 + floatValue6), floatValue9, floatValue9, Path.Direction.CW);
        }
        Path path = new Path();
        this.e = path;
        if (path != null) {
            path.set(SVGAVideoShapeEntityKt.a());
        }
    }

    public final Type getType() {
        return this.a;
    }
}
