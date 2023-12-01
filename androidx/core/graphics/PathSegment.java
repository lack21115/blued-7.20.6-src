package androidx.core.graphics;

import android.graphics.PointF;
import androidx.core.util.Preconditions;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/graphics/PathSegment.class */
public final class PathSegment {

    /* renamed from: a  reason: collision with root package name */
    private final PointF f2452a;
    private final float b;

    /* renamed from: c  reason: collision with root package name */
    private final PointF f2453c;
    private final float d;

    public PathSegment(PointF pointF, float f, PointF pointF2, float f2) {
        this.f2452a = (PointF) Preconditions.checkNotNull(pointF, "start == null");
        this.b = f;
        this.f2453c = (PointF) Preconditions.checkNotNull(pointF2, "end == null");
        this.d = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PathSegment) {
            PathSegment pathSegment = (PathSegment) obj;
            return Float.compare(this.b, pathSegment.b) == 0 && Float.compare(this.d, pathSegment.d) == 0 && this.f2452a.equals(pathSegment.f2452a) && this.f2453c.equals(pathSegment.f2453c);
        }
        return false;
    }

    public PointF getEnd() {
        return this.f2453c;
    }

    public float getEndFraction() {
        return this.d;
    }

    public PointF getStart() {
        return this.f2452a;
    }

    public float getStartFraction() {
        return this.b;
    }

    public int hashCode() {
        int hashCode = this.f2452a.hashCode();
        float f = this.b;
        int i = 0;
        int floatToIntBits = f != 0.0f ? Float.floatToIntBits(f) : 0;
        int hashCode2 = this.f2453c.hashCode();
        float f2 = this.d;
        if (f2 != 0.0f) {
            i = Float.floatToIntBits(f2);
        }
        return (((((hashCode * 31) + floatToIntBits) * 31) + hashCode2) * 31) + i;
    }

    public String toString() {
        return "PathSegment{start=" + this.f2452a + ", startFraction=" + this.b + ", end=" + this.f2453c + ", endFraction=" + this.d + '}';
    }
}
