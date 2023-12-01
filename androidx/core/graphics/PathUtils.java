package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/graphics/PathUtils.class */
public final class PathUtils {
    private PathUtils() {
    }

    public static Collection<PathSegment> flatten(Path path) {
        return flatten(path, 0.5f);
    }

    public static Collection<PathSegment> flatten(Path path, float f) {
        float[] approximate = path.approximate(f);
        int length = approximate.length / 3;
        ArrayList arrayList = new ArrayList(length);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            int i3 = i2 * 3;
            int i4 = (i2 - 1) * 3;
            float f2 = approximate[i3];
            float f3 = approximate[i3 + 1];
            float f4 = approximate[i3 + 2];
            float f5 = approximate[i4];
            float f6 = approximate[i4 + 1];
            float f7 = approximate[i4 + 2];
            if (f2 != f5 && (f3 != f6 || f4 != f7)) {
                arrayList.add(new PathSegment(new PointF(f6, f7), f5, new PointF(f3, f4), f2));
            }
            i = i2 + 1;
        }
    }
}
