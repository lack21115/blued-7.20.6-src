package kotlin.io;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/io/FilePathComponents.class */
public final class FilePathComponents {

    /* renamed from: a  reason: collision with root package name */
    private final File f42485a;
    private final List<File> b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FilePathComponents) {
            FilePathComponents filePathComponents = (FilePathComponents) obj;
            return Intrinsics.a(this.f42485a, filePathComponents.f42485a) && Intrinsics.a(this.b, filePathComponents.b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f42485a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "FilePathComponents(root=" + this.f42485a + ", segments=" + this.b + ')';
    }
}
