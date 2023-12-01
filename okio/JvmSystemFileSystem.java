package okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/JvmSystemFileSystem.class */
public class JvmSystemFileSystem extends FileSystem {
    private final List<Path> list(Path path, boolean z) {
        File file = path.toFile();
        String[] list = file.list();
        if (list == null) {
            if (z) {
                if (file.exists()) {
                    throw new IOException(Intrinsics.a("failed to list ", (Object) path));
                }
                throw new FileNotFoundException(Intrinsics.a("no such file: ", (Object) path));
            }
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = list.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                ArrayList arrayList2 = arrayList;
                CollectionsKt.d((List) arrayList2);
                return arrayList2;
            }
            String it = list[i2];
            Intrinsics.c(it, "it");
            arrayList.add(path.resolve(it));
            i = i2 + 1;
        }
    }

    private final void requireCreate(Path path) {
        if (exists(path)) {
            throw new IOException(path + " already exists.");
        }
    }

    private final void requireExist(Path path) {
        if (exists(path)) {
            return;
        }
        throw new IOException(path + " doesn't exist.");
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path file, boolean z) {
        Intrinsics.e(file, "file");
        if (z) {
            requireExist(file);
        }
        return Okio.sink(file.toFile(), true);
    }

    @Override // okio.FileSystem
    public void atomicMove(Path source, Path target) {
        Intrinsics.e(source, "source");
        Intrinsics.e(target, "target");
        if (source.toFile().renameTo(target.toFile())) {
            return;
        }
        throw new IOException("failed to move " + source + " to " + target);
    }

    @Override // okio.FileSystem
    public Path canonicalize(Path path) {
        Intrinsics.e(path, "path");
        File canonicalFile = path.toFile().getCanonicalFile();
        if (canonicalFile.exists()) {
            Path.Companion companion = Path.Companion;
            Intrinsics.c(canonicalFile, "canonicalFile");
            return Path.Companion.get$default(companion, canonicalFile, false, 1, (Object) null);
        }
        throw new FileNotFoundException("no such file");
    }

    @Override // okio.FileSystem
    public void createDirectory(Path dir, boolean z) {
        Intrinsics.e(dir, "dir");
        if (dir.toFile().mkdir()) {
            return;
        }
        FileMetadata metadataOrNull = metadataOrNull(dir);
        boolean z2 = false;
        if (metadataOrNull != null && metadataOrNull.isDirectory()) {
            z2 = true;
        }
        if (!z2) {
            throw new IOException(Intrinsics.a("failed to create directory: ", (Object) dir));
        }
        if (z) {
            throw new IOException(dir + " already exist.");
        }
    }

    @Override // okio.FileSystem
    public void createSymlink(Path source, Path target) {
        Intrinsics.e(source, "source");
        Intrinsics.e(target, "target");
        throw new IOException("unsupported");
    }

    @Override // okio.FileSystem
    public void delete(Path path, boolean z) {
        Intrinsics.e(path, "path");
        File file = path.toFile();
        if (file.delete()) {
            return;
        }
        if (file.exists()) {
            throw new IOException(Intrinsics.a("failed to delete ", (Object) path));
        }
        if (z) {
            throw new FileNotFoundException(Intrinsics.a("no such file: ", (Object) path));
        }
    }

    @Override // okio.FileSystem
    public List<Path> list(Path dir) {
        Intrinsics.e(dir, "dir");
        List<Path> list = list(dir, true);
        Intrinsics.a(list);
        return list;
    }

    @Override // okio.FileSystem
    public List<Path> listOrNull(Path dir) {
        Intrinsics.e(dir, "dir");
        return list(dir, false);
    }

    @Override // okio.FileSystem
    public FileMetadata metadataOrNull(Path path) {
        Intrinsics.e(path, "path");
        File file = path.toFile();
        boolean isFile = file.isFile();
        boolean isDirectory = file.isDirectory();
        long lastModified = file.lastModified();
        long length = file.length();
        if (isFile || isDirectory || lastModified != 0 || length != 0 || file.exists()) {
            return new FileMetadata(isFile, isDirectory, null, Long.valueOf(length), null, Long.valueOf(lastModified), null, null, 128, null);
        }
        return null;
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path file) {
        Intrinsics.e(file, "file");
        return new JvmFileHandle(false, new RandomAccessFile(file.toFile(), "r"));
    }

    @Override // okio.FileSystem
    public FileHandle openReadWrite(Path file, boolean z, boolean z2) {
        Intrinsics.e(file, "file");
        if ((z && z2) ? false : true) {
            if (z) {
                requireCreate(file);
            }
            if (z2) {
                requireExist(file);
            }
            return new JvmFileHandle(true, new RandomAccessFile(file.toFile(), "rw"));
        }
        throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.".toString());
    }

    @Override // okio.FileSystem
    public Sink sink(Path file, boolean z) {
        Sink sink$default;
        Intrinsics.e(file, "file");
        if (z) {
            requireCreate(file);
        }
        sink$default = Okio__JvmOkioKt.sink$default(file.toFile(), false, 1, null);
        return sink$default;
    }

    @Override // okio.FileSystem
    public Source source(Path file) {
        Intrinsics.e(file, "file");
        return Okio.source(file.toFile());
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
