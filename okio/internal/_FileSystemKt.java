package okio.internal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import okio.BufferedSink;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Source;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/internal/_FileSystemKt.class */
public final class _FileSystemKt {
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01ba, code lost:
        if (r13 != false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01bd, code lost:
        r19 = r8;
        r16 = r12;
        r20 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01c9, code lost:
        if (r15 != 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01cc, code lost:
        r9.b((kotlin.collections.ArrayDeque<okio.Path>) r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01d2, code lost:
        r0 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01dc, code lost:
        r9 = r10;
        r18 = r11;
        r11 = r0;
        r10 = r8;
        r17 = r17.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0284, code lost:
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0285, code lost:
        r8 = r9;
        r9 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object collectRecursively(kotlin.sequences.SequenceScope<? super okio.Path> r8, okio.FileSystem r9, kotlin.collections.ArrayDeque<okio.Path> r10, okio.Path r11, boolean r12, boolean r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instructions count: 741
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._FileSystemKt.collectRecursively(kotlin.sequences.SequenceScope, okio.FileSystem, kotlin.collections.ArrayDeque, okio.Path, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void commonCopy(FileSystem fileSystem, Path source, Path target) throws IOException {
        Long l;
        Long l2;
        Intrinsics.e(fileSystem, "<this>");
        Intrinsics.e(source, "source");
        Intrinsics.e(target, "target");
        Source source2 = fileSystem.source(source);
        try {
            Source source3 = source2;
            BufferedSink buffer = Okio.buffer(fileSystem.sink(target));
            try {
                l2 = Long.valueOf(buffer.writeAll(source3));
                th = null;
            } catch (Throwable th) {
                th = th;
                l2 = null;
            }
            if (buffer != null) {
                buffer.close();
            }
        } catch (Throwable th2) {
            th = th2;
            l = null;
        }
        if (th != null) {
            throw th;
        }
        Intrinsics.a(l2);
        l = Long.valueOf(l2.longValue());
        th = null;
        if (source2 != null) {
            try {
                source2.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    ExceptionsKt.a(th, th3);
                }
            }
        }
        if (th != null) {
            throw th;
        }
        Intrinsics.a(l);
    }

    public static final void commonCreateDirectories(FileSystem fileSystem, Path dir, boolean z) throws IOException {
        Intrinsics.e(fileSystem, "<this>");
        Intrinsics.e(dir, "dir");
        ArrayDeque arrayDeque = new ArrayDeque();
        Path path = dir;
        while (true) {
            Path path2 = path;
            if (path2 == null || fileSystem.exists(path2)) {
                break;
            }
            arrayDeque.a((ArrayDeque) path2);
            path = path2.parent();
        }
        if (z && arrayDeque.isEmpty()) {
            throw new IOException(dir + " already exist.");
        }
        Iterator<E> it = arrayDeque.iterator();
        while (it.hasNext()) {
            fileSystem.createDirectory((Path) it.next());
        }
    }

    public static final void commonDeleteRecursively(FileSystem fileSystem, Path fileOrDirectory, boolean z) throws IOException {
        Intrinsics.e(fileSystem, "<this>");
        Intrinsics.e(fileOrDirectory, "fileOrDirectory");
        Iterator it = SequencesKt.a(new _FileSystemKt$commonDeleteRecursively$sequence$1(fileSystem, fileOrDirectory, null)).iterator();
        while (it.hasNext()) {
            fileSystem.delete((Path) it.next(), z && !it.hasNext());
        }
    }

    public static final boolean commonExists(FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.e(fileSystem, "<this>");
        Intrinsics.e(path, "path");
        return fileSystem.metadataOrNull(path) != null;
    }

    public static final Sequence<Path> commonListRecursively(FileSystem fileSystem, Path dir, boolean z) throws IOException {
        Intrinsics.e(fileSystem, "<this>");
        Intrinsics.e(dir, "dir");
        return SequencesKt.a(new _FileSystemKt$commonListRecursively$1(dir, fileSystem, z, null));
    }

    public static final FileMetadata commonMetadata(FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.e(fileSystem, "<this>");
        Intrinsics.e(path, "path");
        FileMetadata metadataOrNull = fileSystem.metadataOrNull(path);
        if (metadataOrNull != null) {
            return metadataOrNull;
        }
        throw new FileNotFoundException(Intrinsics.a("no such file: ", (Object) path));
    }

    public static final Path symlinkTarget(FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.e(fileSystem, "<this>");
        Intrinsics.e(path, "path");
        Path symlinkTarget = fileSystem.metadata(path).getSymlinkTarget();
        if (symlinkTarget == null) {
            return null;
        }
        Path parent = path.parent();
        Intrinsics.a(parent);
        return parent.resolve(symlinkTarget);
    }
}
