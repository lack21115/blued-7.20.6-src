package kotlin.io.path;

import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/io/path/PathRelativizer.class */
final class PathRelativizer {
    public static final PathRelativizer a = new PathRelativizer();
    private static final Path b = Paths.get("", new String[0]);
    private static final Path c = Paths.get("..", new String[0]);

    private PathRelativizer() {
    }
}
