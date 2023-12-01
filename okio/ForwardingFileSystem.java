package okio;

import android.content.ContentResolver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.cdo.oaps.ad.OapsWrapper;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/ForwardingFileSystem.class */
public abstract class ForwardingFileSystem extends FileSystem {
    private final FileSystem delegate;

    public ForwardingFileSystem(FileSystem delegate) {
        Intrinsics.e(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path file, boolean z) throws IOException {
        Intrinsics.e(file, "file");
        return this.delegate.appendingSink(onPathParameter(file, "appendingSink", ContentResolver.SCHEME_FILE), z);
    }

    @Override // okio.FileSystem
    public void atomicMove(Path source, Path target) throws IOException {
        Intrinsics.e(source, "source");
        Intrinsics.e(target, "target");
        this.delegate.atomicMove(onPathParameter(source, "atomicMove", "source"), onPathParameter(target, "atomicMove", TypedValues.AttributesType.S_TARGET));
    }

    @Override // okio.FileSystem
    public Path canonicalize(Path path) throws IOException {
        Intrinsics.e(path, "path");
        return onPathResult(this.delegate.canonicalize(onPathParameter(path, "canonicalize", OapsWrapper.KEY_PATH)), "canonicalize");
    }

    @Override // okio.FileSystem
    public void createDirectory(Path dir, boolean z) throws IOException {
        Intrinsics.e(dir, "dir");
        this.delegate.createDirectory(onPathParameter(dir, "createDirectory", SharePatchInfo.OAT_DIR), z);
    }

    @Override // okio.FileSystem
    public void createSymlink(Path source, Path target) throws IOException {
        Intrinsics.e(source, "source");
        Intrinsics.e(target, "target");
        this.delegate.createSymlink(onPathParameter(source, "createSymlink", "source"), onPathParameter(target, "createSymlink", TypedValues.AttributesType.S_TARGET));
    }

    public final FileSystem delegate() {
        return this.delegate;
    }

    @Override // okio.FileSystem
    public void delete(Path path, boolean z) throws IOException {
        Intrinsics.e(path, "path");
        this.delegate.delete(onPathParameter(path, "delete", OapsWrapper.KEY_PATH), z);
    }

    @Override // okio.FileSystem
    public List<Path> list(Path dir) throws IOException {
        Intrinsics.e(dir, "dir");
        List<Path> list = this.delegate.list(onPathParameter(dir, "list", SharePatchInfo.OAT_DIR));
        ArrayList arrayList = new ArrayList();
        for (Path path : list) {
            arrayList.add(onPathResult(path, "list"));
        }
        ArrayList arrayList2 = arrayList;
        CollectionsKt.d((List) arrayList2);
        return arrayList2;
    }

    @Override // okio.FileSystem
    public List<Path> listOrNull(Path dir) {
        Intrinsics.e(dir, "dir");
        List<Path> listOrNull = this.delegate.listOrNull(onPathParameter(dir, "listOrNull", SharePatchInfo.OAT_DIR));
        if (listOrNull == null) {
            return null;
        }
        List<Path> list = listOrNull;
        ArrayList arrayList = new ArrayList();
        for (Path path : list) {
            arrayList.add(onPathResult(path, "listOrNull"));
        }
        ArrayList arrayList2 = arrayList;
        CollectionsKt.d((List) arrayList2);
        return arrayList2;
    }

    @Override // okio.FileSystem
    public Sequence<Path> listRecursively(Path dir, boolean z) {
        Intrinsics.e(dir, "dir");
        return SequencesKt.c(this.delegate.listRecursively(onPathParameter(dir, "listRecursively", SharePatchInfo.OAT_DIR), z), new Function1<Path, Path>() { // from class: okio.ForwardingFileSystem$listRecursively$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Path invoke(Path it) {
                Intrinsics.e(it, "it");
                return ForwardingFileSystem.this.onPathResult(it, "listRecursively");
            }
        });
    }

    @Override // okio.FileSystem
    public FileMetadata metadataOrNull(Path path) throws IOException {
        Intrinsics.e(path, "path");
        FileMetadata metadataOrNull = this.delegate.metadataOrNull(onPathParameter(path, "metadataOrNull", OapsWrapper.KEY_PATH));
        if (metadataOrNull == null) {
            return null;
        }
        return metadataOrNull.getSymlinkTarget() == null ? metadataOrNull : FileMetadata.copy$default(metadataOrNull, false, false, onPathResult(metadataOrNull.getSymlinkTarget(), "metadataOrNull"), null, null, null, null, null, 251, null);
    }

    public Path onPathParameter(Path path, String functionName, String parameterName) {
        Intrinsics.e(path, "path");
        Intrinsics.e(functionName, "functionName");
        Intrinsics.e(parameterName, "parameterName");
        return path;
    }

    public Path onPathResult(Path path, String functionName) {
        Intrinsics.e(path, "path");
        Intrinsics.e(functionName, "functionName");
        return path;
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path file) throws IOException {
        Intrinsics.e(file, "file");
        return this.delegate.openReadOnly(onPathParameter(file, "openReadOnly", ContentResolver.SCHEME_FILE));
    }

    @Override // okio.FileSystem
    public FileHandle openReadWrite(Path file, boolean z, boolean z2) throws IOException {
        Intrinsics.e(file, "file");
        return this.delegate.openReadWrite(onPathParameter(file, "openReadWrite", ContentResolver.SCHEME_FILE), z, z2);
    }

    @Override // okio.FileSystem
    public Sink sink(Path file, boolean z) throws IOException {
        Intrinsics.e(file, "file");
        return this.delegate.sink(onPathParameter(file, "sink", ContentResolver.SCHEME_FILE), z);
    }

    @Override // okio.FileSystem
    public Source source(Path file) throws IOException {
        Intrinsics.e(file, "file");
        return this.delegate.source(onPathParameter(file, "source", ContentResolver.SCHEME_FILE));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) Reflection.b(getClass()).b());
        sb.append('(');
        sb.append(this.delegate);
        sb.append(')');
        return sb.toString();
    }
}
