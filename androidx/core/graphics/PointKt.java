package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/graphics/PointKt.class */
public final class PointKt {
    public static final float component1(PointF pointF) {
        Intrinsics.e(pointF, "<this>");
        return pointF.x;
    }

    public static final int component1(Point point) {
        Intrinsics.e(point, "<this>");
        return point.x;
    }

    public static final float component2(PointF pointF) {
        Intrinsics.e(pointF, "<this>");
        return pointF.y;
    }

    public static final int component2(Point point) {
        Intrinsics.e(point, "<this>");
        return point.y;
    }

    public static final Point minus(Point point, int i) {
        Intrinsics.e(point, "<this>");
        Point point2 = new Point(point.x, point.y);
        int i2 = -i;
        point2.offset(i2, i2);
        return point2;
    }

    public static final Point minus(Point point, Point point2) {
        Intrinsics.e(point, "<this>");
        Intrinsics.e(point2, "p");
        Point point3 = new Point(point.x, point.y);
        point3.offset(-point2.x, -point2.y);
        return point3;
    }

    public static final PointF minus(PointF pointF, float f) {
        Intrinsics.e(pointF, "<this>");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        float f2 = -f;
        pointF2.offset(f2, f2);
        return pointF2;
    }

    public static final PointF minus(PointF pointF, PointF pointF2) {
        Intrinsics.e(pointF, "<this>");
        Intrinsics.e(pointF2, "p");
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(-pointF2.x, -pointF2.y);
        return pointF3;
    }

    public static final Point plus(Point point, int i) {
        Intrinsics.e(point, "<this>");
        Point point2 = new Point(point.x, point.y);
        point2.offset(i, i);
        return point2;
    }

    public static final Point plus(Point point, Point point2) {
        Intrinsics.e(point, "<this>");
        Intrinsics.e(point2, "p");
        Point point3 = new Point(point.x, point.y);
        point3.offset(point2.x, point2.y);
        return point3;
    }

    public static final PointF plus(PointF pointF, float f) {
        Intrinsics.e(pointF, "<this>");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(f, f);
        return pointF2;
    }

    public static final PointF plus(PointF pointF, PointF pointF2) {
        Intrinsics.e(pointF, "<this>");
        Intrinsics.e(pointF2, "p");
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(pointF2.x, pointF2.y);
        return pointF3;
    }

    public static final Point toPoint(PointF pointF) {
        Intrinsics.e(pointF, "<this>");
        return new Point((int) pointF.x, (int) pointF.y);
    }

    public static final PointF toPointF(Point point) {
        Intrinsics.e(point, "<this>");
        return new PointF(point);
    }

    public static final Point unaryMinus(Point point) {
        Intrinsics.e(point, "<this>");
        return new Point(-point.x, -point.y);
    }

    public static final PointF unaryMinus(PointF pointF) {
        Intrinsics.e(pointF, "<this>");
        return new PointF(-pointF.x, -pointF.y);
    }
}
