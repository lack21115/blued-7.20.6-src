package androidx.core.graphics;

import android.graphics.Path;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/graphics/PathKt.class */
public final class PathKt {
    public static final Path and(Path path, Path p) {
        Intrinsics.e(path, "<this>");
        Intrinsics.e(p, "p");
        Path path2 = new Path();
        path2.op(path, p, Path.Op.INTERSECT);
        return path2;
    }

    public static final Iterable<PathSegment> flatten(Path path, float f) {
        Intrinsics.e(path, "<this>");
        Collection<PathSegment> flatten = PathUtils.flatten(path, f);
        Intrinsics.c(flatten, "flatten(this, error)");
        return flatten;
    }

    public static /* synthetic */ Iterable flatten$default(Path path, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.5f;
        }
        return flatten(path, f);
    }

    public static final Path minus(Path path, Path p) {
        Intrinsics.e(path, "<this>");
        Intrinsics.e(p, "p");
        Path path2 = new Path(path);
        path2.op(p, Path.Op.DIFFERENCE);
        return path2;
    }

    public static final Path or(Path path, Path p) {
        Intrinsics.e(path, "<this>");
        Intrinsics.e(p, "p");
        Path path2 = new Path(path);
        path2.op(p, Path.Op.UNION);
        return path2;
    }

    public static final Path plus(Path path, Path p) {
        Intrinsics.e(path, "<this>");
        Intrinsics.e(p, "p");
        Path path2 = new Path(path);
        path2.op(p, Path.Op.UNION);
        return path2;
    }

    public static final Path xor(Path path, Path p) {
        Intrinsics.e(path, "<this>");
        Intrinsics.e(p, "p");
        Path path2 = new Path(path);
        path2.op(p, Path.Op.XOR);
        return path2;
    }
}
