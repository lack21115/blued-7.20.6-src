package okio;

import java.io.File;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._PathKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/Path.class */
public final class Path implements Comparable<Path> {
    public static final Companion Companion = new Companion(null);
    public static final String DIRECTORY_SEPARATOR;
    private final ByteString bytes;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:okio/Path$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Path get$default(Companion companion, File file, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.get(file, z);
        }

        public static /* synthetic */ Path get$default(Companion companion, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.get(str, z);
        }

        public static /* synthetic */ Path get$default(Companion companion, java.nio.file.Path path, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.get(path, z);
        }

        @JvmStatic
        public final Path get(File file) {
            Intrinsics.e(file, "<this>");
            return get$default(this, file, false, 1, (Object) null);
        }

        @JvmStatic
        public final Path get(File file, boolean z) {
            Intrinsics.e(file, "<this>");
            String file2 = file.toString();
            Intrinsics.c(file2, "toString()");
            return get(file2, z);
        }

        @JvmStatic
        public final Path get(String str) {
            Intrinsics.e(str, "<this>");
            return get$default(this, str, false, 1, (Object) null);
        }

        @JvmStatic
        public final Path get(String str, boolean z) {
            Intrinsics.e(str, "<this>");
            return _PathKt.commonToPath(str, z);
        }

        @JvmStatic
        public final Path get(java.nio.file.Path path) {
            Intrinsics.e(path, "<this>");
            return get$default(this, path, false, 1, (Object) null);
        }

        @JvmStatic
        public final Path get(java.nio.file.Path path, boolean z) {
            Intrinsics.e(path, "<this>");
            return get(path.toString(), z);
        }
    }

    static {
        String separator = File.separator;
        Intrinsics.c(separator, "separator");
        DIRECTORY_SEPARATOR = separator;
    }

    public Path(ByteString bytes) {
        Intrinsics.e(bytes, "bytes");
        this.bytes = bytes;
    }

    @JvmStatic
    public static final Path get(File file) {
        return Companion.get(file);
    }

    @JvmStatic
    public static final Path get(File file, boolean z) {
        return Companion.get(file, z);
    }

    @JvmStatic
    public static final Path get(String str) {
        return Companion.get(str);
    }

    @JvmStatic
    public static final Path get(String str, boolean z) {
        return Companion.get(str, z);
    }

    @JvmStatic
    public static final Path get(java.nio.file.Path path) {
        return Companion.get(path);
    }

    @JvmStatic
    public static final Path get(java.nio.file.Path path, boolean z) {
        return Companion.get(path, z);
    }

    public static /* synthetic */ Path resolve$default(Path path, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return path.resolve(str, z);
    }

    public static /* synthetic */ Path resolve$default(Path path, ByteString byteString, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return path.resolve(byteString, z);
    }

    public static /* synthetic */ Path resolve$default(Path path, Path path2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return path.resolve(path2, z);
    }

    @Override // java.lang.Comparable
    public int compareTo(Path other) {
        Intrinsics.e(other, "other");
        return getBytes$okio().compareTo(other.getBytes$okio());
    }

    public boolean equals(Object obj) {
        return (obj instanceof Path) && Intrinsics.a(((Path) obj).getBytes$okio(), getBytes$okio());
    }

    public final ByteString getBytes$okio() {
        return this.bytes;
    }

    public final Path getRoot() {
        int access$rootLength = _PathKt.access$rootLength(this);
        if (access$rootLength == -1) {
            return null;
        }
        return new Path(getBytes$okio().substring(0, access$rootLength));
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0074, code lost:
        if (getBytes$okio().getByte(r9) == ((byte) 92)) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<java.lang.String> getSegments() {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Path.getSegments():java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0074, code lost:
        if (getBytes$okio().getByte(r9) == ((byte) 92)) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<okio.ByteString> getSegmentsBytes() {
        /*
            Method dump skipped, instructions count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Path.getSegmentsBytes():java.util.List");
    }

    public int hashCode() {
        return getBytes$okio().hashCode();
    }

    public final boolean isAbsolute() {
        return _PathKt.access$rootLength(this) != -1;
    }

    public final boolean isRelative() {
        return _PathKt.access$rootLength(this) == -1;
    }

    public final boolean isRoot() {
        return _PathKt.access$rootLength(this) == getBytes$okio().size();
    }

    public final String name() {
        return nameBytes().utf8();
    }

    public final ByteString nameBytes() {
        int access$getIndexOfLastSlash = _PathKt.access$getIndexOfLastSlash(this);
        return access$getIndexOfLastSlash != -1 ? ByteString.substring$default(getBytes$okio(), access$getIndexOfLastSlash + 1, 0, 2, null) : (volumeLetter() == null || getBytes$okio().size() != 2) ? getBytes$okio() : ByteString.EMPTY;
    }

    public final Path normalized() {
        return Companion.get(toString(), true);
    }

    public final Path parent() {
        Path path;
        Path path2 = null;
        if (!Intrinsics.a(getBytes$okio(), _PathKt.access$getDOT$p())) {
            path2 = null;
            if (!Intrinsics.a(getBytes$okio(), _PathKt.access$getSLASH$p())) {
                path2 = null;
                if (!Intrinsics.a(getBytes$okio(), _PathKt.access$getBACKSLASH$p())) {
                    if (_PathKt.access$lastSegmentIsDotDot(this)) {
                        return null;
                    }
                    int access$getIndexOfLastSlash = _PathKt.access$getIndexOfLastSlash(this);
                    if (access$getIndexOfLastSlash != 2 || volumeLetter() == null) {
                        if (access$getIndexOfLastSlash == 1 && getBytes$okio().startsWith(_PathKt.access$getBACKSLASH$p())) {
                            return null;
                        }
                        if (access$getIndexOfLastSlash != -1 || volumeLetter() == null) {
                            if (access$getIndexOfLastSlash == -1) {
                                return new Path(_PathKt.access$getDOT$p());
                            }
                            if (access$getIndexOfLastSlash == 0) {
                                path = new Path(ByteString.substring$default(getBytes$okio(), 0, 1, 1, null));
                            } else {
                                path2 = new Path(ByteString.substring$default(getBytes$okio(), 0, access$getIndexOfLastSlash, 1, null));
                            }
                        } else if (getBytes$okio().size() == 2) {
                            return null;
                        } else {
                            path = new Path(ByteString.substring$default(getBytes$okio(), 0, 2, 1, null));
                        }
                    } else if (getBytes$okio().size() == 3) {
                        return null;
                    } else {
                        path = new Path(ByteString.substring$default(getBytes$okio(), 0, 3, 1, null));
                    }
                    return path;
                }
            }
        }
        return path2;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0109 A[LOOP:2: B:34:0x0109->B:37:0x012e, LOOP_START, PHI: r8 
      PHI: (r8v1 int) = (r8v0 int), (r8v2 int) binds: [B:33:0x0106, B:37:0x012e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okio.Path relativeTo(okio.Path r7) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Path.relativeTo(okio.Path):okio.Path");
    }

    public final Path resolve(String child) {
        Intrinsics.e(child, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().writeUtf8(child), false), false);
    }

    public final Path resolve(String child, boolean z) {
        Intrinsics.e(child, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().writeUtf8(child), false), z);
    }

    public final Path resolve(ByteString child) {
        Intrinsics.e(child, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().write(child), false), false);
    }

    public final Path resolve(ByteString child, boolean z) {
        Intrinsics.e(child, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().write(child), false), z);
    }

    public final Path resolve(Path child) {
        Intrinsics.e(child, "child");
        return _PathKt.commonResolve(this, child, false);
    }

    public final Path resolve(Path child, boolean z) {
        Intrinsics.e(child, "child");
        return _PathKt.commonResolve(this, child, z);
    }

    public final File toFile() {
        return new File(toString());
    }

    public final java.nio.file.Path toNioPath() {
        java.nio.file.Path path = Paths.get(toString(), new String[0]);
        Intrinsics.c(path, "get(toString())");
        return path;
    }

    public String toString() {
        return getBytes$okio().utf8();
    }

    public final Character volumeLetter() {
        if (ByteString.indexOf$default(getBytes$okio(), _PathKt.access$getSLASH$p(), 0, 2, (Object) null) == -1 && getBytes$okio().size() >= 2 && getBytes$okio().getByte(1) == ((byte) 58)) {
            char c = (char) getBytes$okio().getByte(0);
            if (!('a' <= c && c <= 'z')) {
                boolean z = false;
                if ('A' <= c) {
                    z = false;
                    if (c <= 'Z') {
                        z = true;
                    }
                }
                if (!z) {
                    return null;
                }
            }
            return Character.valueOf(c);
        }
        return null;
    }
}
