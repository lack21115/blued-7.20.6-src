package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/graphics/RectKt.class */
public final class RectKt {
    public static final Rect and(Rect rect, Rect r) {
        Intrinsics.e(rect, "<this>");
        Intrinsics.e(r, "r");
        Rect rect2 = new Rect(rect);
        rect2.intersect(r);
        return rect2;
    }

    public static final RectF and(RectF rectF, RectF r) {
        Intrinsics.e(rectF, "<this>");
        Intrinsics.e(r, "r");
        RectF rectF2 = new RectF(rectF);
        rectF2.intersect(r);
        return rectF2;
    }

    public static final float component1(RectF rectF) {
        Intrinsics.e(rectF, "<this>");
        return rectF.left;
    }

    public static final int component1(Rect rect) {
        Intrinsics.e(rect, "<this>");
        return rect.left;
    }

    public static final float component2(RectF rectF) {
        Intrinsics.e(rectF, "<this>");
        return rectF.top;
    }

    public static final int component2(Rect rect) {
        Intrinsics.e(rect, "<this>");
        return rect.top;
    }

    public static final float component3(RectF rectF) {
        Intrinsics.e(rectF, "<this>");
        return rectF.right;
    }

    public static final int component3(Rect rect) {
        Intrinsics.e(rect, "<this>");
        return rect.right;
    }

    public static final float component4(RectF rectF) {
        Intrinsics.e(rectF, "<this>");
        return rectF.bottom;
    }

    public static final int component4(Rect rect) {
        Intrinsics.e(rect, "<this>");
        return rect.bottom;
    }

    public static final boolean contains(Rect rect, Point p) {
        Intrinsics.e(rect, "<this>");
        Intrinsics.e(p, "p");
        return rect.contains(p.x, p.y);
    }

    public static final boolean contains(RectF rectF, PointF p) {
        Intrinsics.e(rectF, "<this>");
        Intrinsics.e(p, "p");
        return rectF.contains(p.x, p.y);
    }

    public static final Rect minus(Rect rect, int i) {
        Intrinsics.e(rect, "<this>");
        Rect rect2 = new Rect(rect);
        int i2 = -i;
        rect2.offset(i2, i2);
        return rect2;
    }

    public static final Rect minus(Rect rect, Point xy) {
        Intrinsics.e(rect, "<this>");
        Intrinsics.e(xy, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(-xy.x, -xy.y);
        return rect2;
    }

    public static final RectF minus(RectF rectF, float f) {
        Intrinsics.e(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        float f2 = -f;
        rectF2.offset(f2, f2);
        return rectF2;
    }

    public static final RectF minus(RectF rectF, PointF xy) {
        Intrinsics.e(rectF, "<this>");
        Intrinsics.e(xy, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(-xy.x, -xy.y);
        return rectF2;
    }

    public static final Region minus(Rect rect, Rect r) {
        Intrinsics.e(rect, "<this>");
        Intrinsics.e(r, "r");
        Region region = new Region(rect);
        region.op(r, Region.Op.DIFFERENCE);
        return region;
    }

    public static final Region minus(RectF rectF, RectF r) {
        Intrinsics.e(rectF, "<this>");
        Intrinsics.e(r, "r");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        r.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    public static final Rect or(Rect rect, Rect r) {
        Intrinsics.e(rect, "<this>");
        Intrinsics.e(r, "r");
        Rect rect2 = new Rect(rect);
        rect2.union(r);
        return rect2;
    }

    public static final RectF or(RectF rectF, RectF r) {
        Intrinsics.e(rectF, "<this>");
        Intrinsics.e(r, "r");
        RectF rectF2 = new RectF(rectF);
        rectF2.union(r);
        return rectF2;
    }

    public static final Rect plus(Rect rect, int i) {
        Intrinsics.e(rect, "<this>");
        Rect rect2 = new Rect(rect);
        rect2.offset(i, i);
        return rect2;
    }

    public static final Rect plus(Rect rect, Point xy) {
        Intrinsics.e(rect, "<this>");
        Intrinsics.e(xy, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(xy.x, xy.y);
        return rect2;
    }

    public static final Rect plus(Rect rect, Rect r) {
        Intrinsics.e(rect, "<this>");
        Intrinsics.e(r, "r");
        Rect rect2 = new Rect(rect);
        rect2.union(r);
        return rect2;
    }

    public static final RectF plus(RectF rectF, float f) {
        Intrinsics.e(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(f, f);
        return rectF2;
    }

    public static final RectF plus(RectF rectF, PointF xy) {
        Intrinsics.e(rectF, "<this>");
        Intrinsics.e(xy, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(xy.x, xy.y);
        return rectF2;
    }

    public static final RectF plus(RectF rectF, RectF r) {
        Intrinsics.e(rectF, "<this>");
        Intrinsics.e(r, "r");
        RectF rectF2 = new RectF(rectF);
        rectF2.union(r);
        return rectF2;
    }

    public static final Rect times(Rect rect, int i) {
        Intrinsics.e(rect, "<this>");
        Rect rect2 = new Rect(rect);
        rect2.top *= i;
        rect2.left *= i;
        rect2.right *= i;
        rect2.bottom *= i;
        return rect2;
    }

    public static final RectF times(RectF rectF, float f) {
        Intrinsics.e(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f;
        rectF2.left *= f;
        rectF2.right *= f;
        rectF2.bottom *= f;
        return rectF2;
    }

    public static final RectF times(RectF rectF, int i) {
        Intrinsics.e(rectF, "<this>");
        float f = i;
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f;
        rectF2.left *= f;
        rectF2.right *= f;
        rectF2.bottom *= f;
        return rectF2;
    }

    public static final Rect toRect(RectF rectF) {
        Intrinsics.e(rectF, "<this>");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return rect;
    }

    public static final RectF toRectF(Rect rect) {
        Intrinsics.e(rect, "<this>");
        return new RectF(rect);
    }

    public static final Region toRegion(Rect rect) {
        Intrinsics.e(rect, "<this>");
        return new Region(rect);
    }

    public static final Region toRegion(RectF rectF) {
        Intrinsics.e(rectF, "<this>");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return new Region(rect);
    }

    public static final RectF transform(RectF rectF, Matrix m) {
        Intrinsics.e(rectF, "<this>");
        Intrinsics.e(m, "m");
        m.mapRect(rectF);
        return rectF;
    }

    public static final Region xor(Rect rect, Rect r) {
        Intrinsics.e(rect, "<this>");
        Intrinsics.e(r, "r");
        Region region = new Region(rect);
        region.op(r, Region.Op.XOR);
        return region;
    }

    public static final Region xor(RectF rectF, RectF r) {
        Intrinsics.e(rectF, "<this>");
        Intrinsics.e(r, "r");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        r.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }
}
