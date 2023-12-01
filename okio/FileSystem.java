package okio;

import java.io.IOException;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import okio.Path;
import okio.internal.ResourceFileSystem;
import okio.internal._FileSystemKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/FileSystem.class */
public abstract class FileSystem {
    public static final Companion Companion = new Companion(null);
    public static final FileSystem RESOURCES;
    public static final FileSystem SYSTEM;
    public static final Path SYSTEM_TEMPORARY_DIRECTORY;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:okio/FileSystem$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: -write$default  reason: not valid java name */
    public static /* synthetic */ Object m13287write$default(FileSystem fileSystem, Path file, boolean z, Function1 writerAction, int i, Object obj) throws IOException {
        Object obj2;
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            Intrinsics.e(file, "file");
            Intrinsics.e(writerAction, "writerAction");
            BufferedSink buffer = Okio.buffer(fileSystem.sink(file, z));
            Throwable th = null;
            try {
                obj2 = writerAction.invoke(buffer);
            } catch (Throwable th2) {
                th = th2;
                obj2 = null;
            }
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th3) {
                    if (th == null) {
                        th = th3;
                    } else {
                        ExceptionsKt.a(th, th3);
                    }
                }
            }
            if (th == null) {
                Intrinsics.a(obj2);
                return obj2;
            }
            throw th;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
    }

    static {
        NioSystemFileSystem jvmSystemFileSystem;
        try {
            Class.forName("java.nio.file.Files");
            jvmSystemFileSystem = new NioSystemFileSystem();
        } catch (ClassNotFoundException e) {
            jvmSystemFileSystem = new JvmSystemFileSystem();
        }
        SYSTEM = jvmSystemFileSystem;
        Path.Companion companion = Path.Companion;
        String property = System.getProperty("java.io.tmpdir");
        Intrinsics.c(property, "getProperty(\"java.io.tmpdir\")");
        SYSTEM_TEMPORARY_DIRECTORY = Path.Companion.get$default(companion, property, false, 1, (Object) null);
        ClassLoader classLoader = ResourceFileSystem.class.getClassLoader();
        Intrinsics.c(classLoader, "ResourceFileSystem::class.java.classLoader");
        RESOURCES = new ResourceFileSystem(classLoader, false);
    }

    public static /* synthetic */ Sink appendingSink$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            return fileSystem.appendingSink(path, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendingSink");
    }

    public static /* synthetic */ void createDirectories$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectories");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystem.createDirectories(path, z);
    }

    public static /* synthetic */ void createDirectory$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystem.createDirectory(path, z);
    }

    public static /* synthetic */ void delete$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystem.delete(path, z);
    }

    public static /* synthetic */ void deleteRecursively$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteRecursively");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystem.deleteRecursively(path, z);
    }

    public static /* synthetic */ Sequence listRecursively$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            return fileSystem.listRecursively(path, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listRecursively");
    }

    public static /* synthetic */ FileHandle openReadWrite$default(FileSystem fileSystem, Path path, boolean z, boolean z2, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            return fileSystem.openReadWrite(path, z, z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openReadWrite");
    }

    public static /* synthetic */ Sink sink$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            return fileSystem.sink(path, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
    }

    /* renamed from: -read  reason: not valid java name */
    public final <T> T m13289read(Path file, Function1<? super BufferedSource, ? extends T> readerAction) throws IOException {
        T t;
        Intrinsics.e(file, "file");
        Intrinsics.e(readerAction, "readerAction");
        BufferedSource buffer = Okio.buffer(source(file));
        Throwable th = null;
        try {
            t = readerAction.invoke(buffer);
        } catch (Throwable th2) {
            th = th2;
            t = null;
        }
        if (buffer != null) {
            try {
                buffer.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    ExceptionsKt.a(th, th3);
                }
            }
        }
        if (th == null) {
            Intrinsics.a(t);
            return t;
        }
        throw th;
    }

    /* renamed from: -write  reason: not valid java name */
    public final <T> T m13290write(Path file, boolean z, Function1<? super BufferedSink, ? extends T> writerAction) throws IOException {
        T t;
        Intrinsics.e(file, "file");
        Intrinsics.e(writerAction, "writerAction");
        BufferedSink buffer = Okio.buffer(sink(file, z));
        Throwable th = null;
        try {
            t = writerAction.invoke(buffer);
        } catch (Throwable th2) {
            th = th2;
            t = null;
        }
        if (buffer != null) {
            try {
                buffer.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    ExceptionsKt.a(th, th3);
                }
            }
        }
        if (th == null) {
            Intrinsics.a(t);
            return t;
        }
        throw th;
    }

    public final Sink appendingSink(Path file) throws IOException {
        Intrinsics.e(file, "file");
        return appendingSink(file, false);
    }

    public abstract Sink appendingSink(Path path, boolean z) throws IOException;

    public abstract void atomicMove(Path path, Path path2) throws IOException;

    public abstract Path canonicalize(Path path) throws IOException;

    public void copy(Path source, Path target) throws IOException {
        Intrinsics.e(source, "source");
        Intrinsics.e(target, "target");
        _FileSystemKt.commonCopy(this, source, target);
    }

    public final void createDirectories(Path dir) throws IOException {
        Intrinsics.e(dir, "dir");
        createDirectories(dir, false);
    }

    public final void createDirectories(Path dir, boolean z) throws IOException {
        Intrinsics.e(dir, "dir");
        _FileSystemKt.commonCreateDirectories(this, dir, z);
    }

    public final void createDirectory(Path dir) throws IOException {
        Intrinsics.e(dir, "dir");
        createDirectory(dir, false);
    }

    public abstract void createDirectory(Path path, boolean z) throws IOException;

    public abstract void createSymlink(Path path, Path path2) throws IOException;

    public final void delete(Path path) throws IOException {
        Intrinsics.e(path, "path");
        delete(path, false);
    }

    public abstract void delete(Path path, boolean z) throws IOException;

    public final void deleteRecursively(Path fileOrDirectory) throws IOException {
        Intrinsics.e(fileOrDirectory, "fileOrDirectory");
        deleteRecursively(fileOrDirectory, false);
    }

    public void deleteRecursively(Path fileOrDirectory, boolean z) throws IOException {
        Intrinsics.e(fileOrDirectory, "fileOrDirectory");
        _FileSystemKt.commonDeleteRecursively(this, fileOrDirectory, z);
    }

    public final boolean exists(Path path) throws IOException {
        Intrinsics.e(path, "path");
        return _FileSystemKt.commonExists(this, path);
    }

    public abstract List<Path> list(Path path) throws IOException;

    public abstract List<Path> listOrNull(Path path);

    public final Sequence<Path> listRecursively(Path dir) {
        Intrinsics.e(dir, "dir");
        return listRecursively(dir, false);
    }

    public Sequence<Path> listRecursively(Path dir, boolean z) {
        Intrinsics.e(dir, "dir");
        return _FileSystemKt.commonListRecursively(this, dir, z);
    }

    public final FileMetadata metadata(Path path) throws IOException {
        Intrinsics.e(path, "path");
        return _FileSystemKt.commonMetadata(this, path);
    }

    public abstract FileMetadata metadataOrNull(Path path) throws IOException;

    public abstract FileHandle openReadOnly(Path path) throws IOException;

    public final FileHandle openReadWrite(Path file) throws IOException {
        Intrinsics.e(file, "file");
        return openReadWrite(file, false, false);
    }

    public abstract FileHandle openReadWrite(Path path, boolean z, boolean z2) throws IOException;

    public final Sink sink(Path file) throws IOException {
        Intrinsics.e(file, "file");
        return sink(file, false);
    }

    public abstract Sink sink(Path path, boolean z) throws IOException;

    public abstract Source source(Path path) throws IOException;
}
