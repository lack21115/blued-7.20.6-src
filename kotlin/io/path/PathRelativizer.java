package kotlin.io.path;

import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/io/path/PathRelativizer.class */
final class PathRelativizer {

    /* renamed from: a  reason: collision with root package name */
    public static final PathRelativizer f42511a = new PathRelativizer();
    private static final Path b = Paths.get("", new String[0]);

    /* renamed from: c  reason: collision with root package name */
    private static final Path f42512c = Paths.get("..", new String[0]);

    private PathRelativizer() {
    }
}
