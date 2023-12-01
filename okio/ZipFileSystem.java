package okio;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;
import okio.internal.FixedLengthSource;
import okio.internal.ZipEntry;
import okio.internal.ZipKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/ZipFileSystem.class */
public final class ZipFileSystem extends FileSystem {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    private static final Path ROOT = Path.Companion.get$default(Path.Companion, BridgeUtil.SPLIT_MARK, false, 1, (Object) null);
    private final String comment;
    private final Map<Path, ZipEntry> entries;
    private final FileSystem fileSystem;
    private final Path zipPath;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:okio/ZipFileSystem$Companion.class */
    static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Path getROOT() {
            return ZipFileSystem.ROOT;
        }
    }

    public ZipFileSystem(Path zipPath, FileSystem fileSystem, Map<Path, ZipEntry> entries, String str) {
        Intrinsics.e(zipPath, "zipPath");
        Intrinsics.e(fileSystem, "fileSystem");
        Intrinsics.e(entries, "entries");
        this.zipPath = zipPath;
        this.fileSystem = fileSystem;
        this.entries = entries;
        this.comment = str;
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    private final List<Path> list(Path path, boolean z) {
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(path));
        if (zipEntry == null) {
            if (z) {
                throw new IOException(Intrinsics.a("not a directory: ", (Object) path));
            }
            return null;
        }
        return CollectionsKt.f((Iterable) zipEntry.getChildren());
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path file, boolean z) {
        Intrinsics.e(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void atomicMove(Path source, Path target) {
        Intrinsics.e(source, "source");
        Intrinsics.e(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public Path canonicalize(Path path) {
        Intrinsics.e(path, "path");
        return canonicalizeInternal(path);
    }

    @Override // okio.FileSystem
    public void createDirectory(Path dir, boolean z) {
        Intrinsics.e(dir, "dir");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void createSymlink(Path source, Path target) {
        Intrinsics.e(source, "source");
        Intrinsics.e(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void delete(Path path, boolean z) {
        Intrinsics.e(path, "path");
        throw new IOException("zip file systems are read-only");
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
        BufferedSource bufferedSource;
        Intrinsics.e(path, "path");
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(path));
        if (zipEntry == null) {
            return null;
        }
        FileMetadata fileMetadata = new FileMetadata(!zipEntry.isDirectory(), zipEntry.isDirectory(), null, zipEntry.isDirectory() ? null : Long.valueOf(zipEntry.getSize()), null, zipEntry.getLastModifiedAtMillis(), null, null, 128, null);
        if (zipEntry.getOffset() == -1) {
            return fileMetadata;
        }
        FileHandle openReadOnly = this.fileSystem.openReadOnly(this.zipPath);
        try {
            th = null;
            bufferedSource = Okio.buffer(openReadOnly.source(zipEntry.getOffset()));
        } catch (Throwable th) {
            th = th;
            bufferedSource = null;
        }
        if (openReadOnly != null) {
            try {
                openReadOnly.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    ExceptionsKt.a(th, th2);
                }
            }
        }
        if (th == null) {
            Intrinsics.a(bufferedSource);
            return ZipKt.readLocalHeader(bufferedSource, fileMetadata);
        }
        throw th;
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path file) {
        Intrinsics.e(file, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // okio.FileSystem
    public FileHandle openReadWrite(Path file, boolean z, boolean z2) {
        Intrinsics.e(file, "file");
        throw new IOException("zip entries are not writable");
    }

    @Override // okio.FileSystem
    public Sink sink(Path file, boolean z) {
        Intrinsics.e(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public Source source(Path path) throws IOException {
        BufferedSource bufferedSource;
        Intrinsics.e(path, "path");
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(path));
        if (zipEntry != null) {
            FileHandle openReadOnly = this.fileSystem.openReadOnly(this.zipPath);
            Throwable th = null;
            try {
                bufferedSource = Okio.buffer(openReadOnly.source(zipEntry.getOffset()));
            } catch (Throwable th2) {
                th = th2;
                bufferedSource = null;
            }
            if (openReadOnly != null) {
                try {
                    openReadOnly.close();
                } catch (Throwable th3) {
                    if (th == null) {
                        th = th3;
                    } else {
                        ExceptionsKt.a(th, th3);
                    }
                }
            }
            if (th == null) {
                Intrinsics.a(bufferedSource);
                ZipKt.skipLocalHeader(bufferedSource);
                return zipEntry.getCompressionMethod() == 0 ? new FixedLengthSource(bufferedSource, zipEntry.getSize(), true) : new FixedLengthSource(new InflaterSource(new FixedLengthSource(bufferedSource, zipEntry.getCompressedSize(), true), new Inflater(true)), zipEntry.getSize(), false);
            }
            throw th;
        }
        throw new FileNotFoundException(Intrinsics.a("no such file: ", (Object) path));
    }
}
