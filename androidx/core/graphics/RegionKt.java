package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/graphics/RegionKt.class */
public final class RegionKt {
    public static final Region and(Region region, Rect r) {
        Intrinsics.e(region, "<this>");
        Intrinsics.e(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.INTERSECT);
        return region2;
    }

    public static final Region and(Region region, Region r) {
        Intrinsics.e(region, "<this>");
        Intrinsics.e(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.INTERSECT);
        return region2;
    }

    public static final boolean contains(Region region, Point p) {
        Intrinsics.e(region, "<this>");
        Intrinsics.e(p, "p");
        return region.contains(p.x, p.y);
    }

    public static final void forEach(Region region, Function1<? super Rect, Unit> action) {
        Intrinsics.e(region, "<this>");
        Intrinsics.e(action, "action");
        RegionIterator regionIterator = new RegionIterator(region);
        while (true) {
            Rect rect = new Rect();
            if (!regionIterator.next(rect)) {
                return;
            }
            action.invoke(rect);
        }
    }

    public static final Iterator<Rect> iterator(Region region) {
        Intrinsics.e(region, "<this>");
        return new RegionKt$iterator$1(region);
    }

    public static final Region minus(Region region, Rect r) {
        Intrinsics.e(region, "<this>");
        Intrinsics.e(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region minus(Region region, Region r) {
        Intrinsics.e(region, "<this>");
        Intrinsics.e(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region not(Region region) {
        Intrinsics.e(region, "<this>");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region or(Region region, Rect r) {
        Intrinsics.e(region, "<this>");
        Intrinsics.e(r, "r");
        Region region2 = new Region(region);
        region2.union(r);
        return region2;
    }

    public static final Region or(Region region, Region r) {
        Intrinsics.e(region, "<this>");
        Intrinsics.e(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.UNION);
        return region2;
    }

    public static final Region plus(Region region, Rect r) {
        Intrinsics.e(region, "<this>");
        Intrinsics.e(r, "r");
        Region region2 = new Region(region);
        region2.union(r);
        return region2;
    }

    public static final Region plus(Region region, Region r) {
        Intrinsics.e(region, "<this>");
        Intrinsics.e(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.UNION);
        return region2;
    }

    public static final Region unaryMinus(Region region) {
        Intrinsics.e(region, "<this>");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region xor(Region region, Rect r) {
        Intrinsics.e(region, "<this>");
        Intrinsics.e(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.XOR);
        return region2;
    }

    public static final Region xor(Region region, Region r) {
        Intrinsics.e(region, "<this>");
        Intrinsics.e(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.XOR);
        return region2;
    }
}
