package okio.internal;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Path;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/internal/_PathKt.class */
public final class _PathKt {
    private static final ByteString SLASH = ByteString.Companion.encodeUtf8(BridgeUtil.SPLIT_MARK);
    private static final ByteString BACKSLASH = ByteString.Companion.encodeUtf8("\\");
    private static final ByteString ANY_SLASH = ByteString.Companion.encodeUtf8("/\\");
    private static final ByteString DOT = ByteString.Companion.encodeUtf8(".");
    private static final ByteString DOT_DOT = ByteString.Companion.encodeUtf8("..");

    public static final int commonCompareTo(Path path, Path other) {
        Intrinsics.e(path, "<this>");
        Intrinsics.e(other, "other");
        return path.getBytes$okio().compareTo(other.getBytes$okio());
    }

    public static final boolean commonEquals(Path path, Object obj) {
        Intrinsics.e(path, "<this>");
        return (obj instanceof Path) && Intrinsics.a(((Path) obj).getBytes$okio(), path.getBytes$okio());
    }

    public static final int commonHashCode(Path path) {
        Intrinsics.e(path, "<this>");
        return path.getBytes$okio().hashCode();
    }

    public static final boolean commonIsAbsolute(Path path) {
        Intrinsics.e(path, "<this>");
        return rootLength(path) != -1;
    }

    public static final boolean commonIsRelative(Path path) {
        Intrinsics.e(path, "<this>");
        return rootLength(path) == -1;
    }

    public static final boolean commonIsRoot(Path path) {
        Intrinsics.e(path, "<this>");
        return rootLength(path) == path.getBytes$okio().size();
    }

    public static final String commonName(Path path) {
        Intrinsics.e(path, "<this>");
        return path.nameBytes().utf8();
    }

    public static final ByteString commonNameBytes(Path path) {
        Intrinsics.e(path, "<this>");
        int indexOfLastSlash = getIndexOfLastSlash(path);
        return indexOfLastSlash != -1 ? ByteString.substring$default(path.getBytes$okio(), indexOfLastSlash + 1, 0, 2, null) : (path.volumeLetter() == null || path.getBytes$okio().size() != 2) ? path.getBytes$okio() : ByteString.EMPTY;
    }

    public static final Path commonNormalized(Path path) {
        Intrinsics.e(path, "<this>");
        return Path.Companion.get(path.toString(), true);
    }

    public static final Path commonParent(Path path) {
        Intrinsics.e(path, "<this>");
        if (Intrinsics.a(path.getBytes$okio(), DOT) || Intrinsics.a(path.getBytes$okio(), SLASH) || Intrinsics.a(path.getBytes$okio(), BACKSLASH) || lastSegmentIsDotDot(path)) {
            return null;
        }
        int indexOfLastSlash = getIndexOfLastSlash(path);
        if (indexOfLastSlash == 2 && path.volumeLetter() != null) {
            if (path.getBytes$okio().size() == 3) {
                return null;
            }
            return new Path(ByteString.substring$default(path.getBytes$okio(), 0, 3, 1, null));
        } else if (indexOfLastSlash == 1 && path.getBytes$okio().startsWith(BACKSLASH)) {
            return null;
        } else {
            if (indexOfLastSlash != -1 || path.volumeLetter() == null) {
                return indexOfLastSlash == -1 ? new Path(DOT) : indexOfLastSlash == 0 ? new Path(ByteString.substring$default(path.getBytes$okio(), 0, 1, 1, null)) : new Path(ByteString.substring$default(path.getBytes$okio(), 0, indexOfLastSlash, 1, null));
            } else if (path.getBytes$okio().size() == 2) {
                return null;
            } else {
                return new Path(ByteString.substring$default(path.getBytes$okio(), 0, 2, 1, null));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x010c A[LOOP:2: B:82:0x010c->B:85:0x0131, LOOP_START, PHI: r8 
      PHI: (r8v1 int) = (r8v0 int), (r8v2 int) binds: [B:81:0x0109, B:85:0x0131] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final okio.Path commonRelativeTo(okio.Path r6, okio.Path r7) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._PathKt.commonRelativeTo(okio.Path, okio.Path):okio.Path");
    }

    public static final Path commonResolve(Path path, String child, boolean z) {
        Intrinsics.e(path, "<this>");
        Intrinsics.e(child, "child");
        return commonResolve(path, toPath(new Buffer().writeUtf8(child), false), z);
    }

    public static final Path commonResolve(Path path, Buffer child, boolean z) {
        Intrinsics.e(path, "<this>");
        Intrinsics.e(child, "child");
        return commonResolve(path, toPath(child, false), z);
    }

    public static final Path commonResolve(Path path, ByteString child, boolean z) {
        Intrinsics.e(path, "<this>");
        Intrinsics.e(child, "child");
        return commonResolve(path, toPath(new Buffer().write(child), false), z);
    }

    public static final Path commonResolve(Path path, Path child, boolean z) {
        Intrinsics.e(path, "<this>");
        Intrinsics.e(child, "child");
        if (!child.isAbsolute() && child.volumeLetter() == null) {
            ByteString slash = getSlash(path);
            ByteString byteString = slash;
            if (slash == null) {
                ByteString slash2 = getSlash(child);
                byteString = slash2;
                if (slash2 == null) {
                    byteString = toSlash(Path.DIRECTORY_SEPARATOR);
                }
            }
            Buffer buffer = new Buffer();
            buffer.write(path.getBytes$okio());
            if (buffer.size() > 0) {
                buffer.write(byteString);
            }
            buffer.write(child.getBytes$okio());
            return toPath(buffer, z);
        }
        return child;
    }

    public static final Path commonRoot(Path path) {
        Intrinsics.e(path, "<this>");
        int rootLength = rootLength(path);
        if (rootLength == -1) {
            return null;
        }
        return new Path(path.getBytes$okio().substring(0, rootLength));
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x007a, code lost:
        if (r5.getBytes$okio().getByte(r9) == ((byte) 92)) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.List<java.lang.String> commonSegments(okio.Path r5) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._PathKt.commonSegments(okio.Path):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x007a, code lost:
        if (r5.getBytes$okio().getByte(r9) == ((byte) 92)) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.List<okio.ByteString> commonSegmentsBytes(okio.Path r5) {
        /*
            Method dump skipped, instructions count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._PathKt.commonSegmentsBytes(okio.Path):java.util.List");
    }

    public static final Path commonToPath(String str, boolean z) {
        Intrinsics.e(str, "<this>");
        return toPath(new Buffer().writeUtf8(str), z);
    }

    public static final String commonToString(Path path) {
        Intrinsics.e(path, "<this>");
        return path.getBytes$okio().utf8();
    }

    public static final Character commonVolumeLetter(Path path) {
        Intrinsics.e(path, "<this>");
        if (ByteString.indexOf$default(path.getBytes$okio(), SLASH, 0, 2, (Object) null) == -1 && path.getBytes$okio().size() >= 2 && path.getBytes$okio().getByte(1) == ((byte) 58)) {
            char c = (char) path.getBytes$okio().getByte(0);
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

    private static /* synthetic */ void getANY_SLASH$annotations() {
    }

    private static /* synthetic */ void getBACKSLASH$annotations() {
    }

    private static /* synthetic */ void getDOT$annotations() {
    }

    private static /* synthetic */ void getDOT_DOT$annotations() {
    }

    public static final int getIndexOfLastSlash(Path path) {
        int lastIndexOf$default = ByteString.lastIndexOf$default(path.getBytes$okio(), SLASH, 0, 2, (Object) null);
        return lastIndexOf$default != -1 ? lastIndexOf$default : ByteString.lastIndexOf$default(path.getBytes$okio(), BACKSLASH, 0, 2, (Object) null);
    }

    private static /* synthetic */ void getSLASH$annotations() {
    }

    public static final ByteString getSlash(Path path) {
        ByteString byteString = null;
        if (ByteString.indexOf$default(path.getBytes$okio(), SLASH, 0, 2, (Object) null) != -1) {
            return SLASH;
        }
        if (ByteString.indexOf$default(path.getBytes$okio(), BACKSLASH, 0, 2, (Object) null) != -1) {
            byteString = BACKSLASH;
        }
        return byteString;
    }

    public static final boolean lastSegmentIsDotDot(Path path) {
        if (path.getBytes$okio().endsWith(DOT_DOT)) {
            return path.getBytes$okio().size() == 2 || path.getBytes$okio().rangeEquals(path.getBytes$okio().size() - 3, SLASH, 0, 1) || path.getBytes$okio().rangeEquals(path.getBytes$okio().size() - 3, BACKSLASH, 0, 1);
        }
        return false;
    }

    public static final int rootLength(Path path) {
        if (path.getBytes$okio().size() == 0) {
            return -1;
        }
        if (path.getBytes$okio().getByte(0) == ((byte) 47)) {
            return 1;
        }
        byte b = (byte) 92;
        if (path.getBytes$okio().getByte(0) == b) {
            if (path.getBytes$okio().size() <= 2 || path.getBytes$okio().getByte(1) != b) {
                return 1;
            }
            int indexOf = path.getBytes$okio().indexOf(BACKSLASH, 2);
            int i = indexOf;
            if (indexOf == -1) {
                i = path.getBytes$okio().size();
            }
            return i;
        } else if (path.getBytes$okio().size() > 2 && path.getBytes$okio().getByte(1) == ((byte) 58) && path.getBytes$okio().getByte(2) == b) {
            char c = (char) path.getBytes$okio().getByte(0);
            if ('a' <= c && c <= 'z') {
                return 3;
            }
            boolean z = false;
            if ('A' <= c) {
                z = false;
                if (c <= 'Z') {
                    z = true;
                }
            }
            return !z ? -1 : 3;
        } else {
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x005f, code lost:
        if (('A' <= r0 && r0 <= 'Z') != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final boolean startsWithVolumeLetterAndColon(okio.Buffer r5, okio.ByteString r6) {
        /*
            r0 = r6
            okio.ByteString r1 = okio.internal._PathKt.BACKSLASH
            boolean r0 = kotlin.jvm.internal.Intrinsics.a(r0, r1)
            r10 = r0
            r0 = 0
            r9 = r0
            r0 = r10
            if (r0 != 0) goto L13
            r0 = 0
            return r0
        L13:
            r0 = r5
            long r0 = r0.size()
            r1 = 2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L20
            r0 = 0
            return r0
        L20:
            r0 = r5
            r1 = 1
            byte r0 = r0.getByte(r1)
            r1 = 58
            byte r1 = (byte) r1
            if (r0 == r1) goto L2d
            r0 = 0
            return r0
        L2d:
            r0 = r5
            r1 = 0
            byte r0 = r0.getByte(r1)
            char r0 = (char) r0
            r8 = r0
            r0 = 97
            r1 = r8
            if (r0 > r1) goto L45
            r0 = r8
            r1 = 122(0x7a, float:1.71E-43)
            if (r0 > r1) goto L45
            r0 = 1
            r7 = r0
            goto L47
        L45:
            r0 = 0
            r7 = r0
        L47:
            r0 = r7
            if (r0 != 0) goto L62
            r0 = 65
            r1 = r8
            if (r0 > r1) goto L5c
            r0 = r8
            r1 = 90
            if (r0 > r1) goto L5c
            r0 = 1
            r7 = r0
            goto L5e
        L5c:
            r0 = 0
            r7 = r0
        L5e:
            r0 = r7
            if (r0 == 0) goto L65
        L62:
            r0 = 1
            r9 = r0
        L65:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._PathKt.startsWithVolumeLetterAndColon(okio.Buffer, okio.ByteString):boolean");
    }

    public static final Path toPath(Buffer buffer, boolean z) {
        ByteString readByteString;
        Intrinsics.e(buffer, "<this>");
        Buffer buffer2 = new Buffer();
        ByteString byteString = null;
        int i = 0;
        while (true) {
            if (!buffer.rangeEquals(0L, SLASH) && !buffer.rangeEquals(0L, BACKSLASH)) {
                break;
            }
            byte readByte = buffer.readByte();
            ByteString byteString2 = byteString;
            if (byteString == null) {
                byteString2 = toSlash(readByte);
            }
            i++;
            byteString = byteString2;
        }
        boolean z2 = i >= 2 && Intrinsics.a(byteString, BACKSLASH);
        if (z2) {
            Intrinsics.a(byteString);
            buffer2.write(byteString);
            buffer2.write(byteString);
        } else if (i > 0) {
            Intrinsics.a(byteString);
            buffer2.write(byteString);
        } else {
            long indexOfElement = buffer.indexOfElement(ANY_SLASH);
            ByteString byteString3 = byteString;
            if (byteString == null) {
                byteString3 = indexOfElement == -1 ? toSlash(Path.DIRECTORY_SEPARATOR) : toSlash(buffer.getByte(indexOfElement));
            }
            byteString = byteString3;
            if (startsWithVolumeLetterAndColon(buffer, byteString3)) {
                if (indexOfElement == 2) {
                    buffer2.write(buffer, 3L);
                    byteString = byteString3;
                } else {
                    buffer2.write(buffer, 2L);
                    byteString = byteString3;
                }
            }
        }
        boolean z3 = buffer2.size() > 0;
        ArrayList arrayList = new ArrayList();
        while (!buffer.exhausted()) {
            long indexOfElement2 = buffer.indexOfElement(ANY_SLASH);
            if (indexOfElement2 == -1) {
                readByteString = buffer.readByteString();
            } else {
                readByteString = buffer.readByteString(indexOfElement2);
                buffer.readByte();
            }
            if (Intrinsics.a(readByteString, DOT_DOT)) {
                if (!z3 || !arrayList.isEmpty()) {
                    if (!z || (!z3 && (arrayList.isEmpty() || Intrinsics.a(CollectionsKt.j((List<? extends Object>) arrayList), DOT_DOT)))) {
                        arrayList.add(readByteString);
                    } else if (!z2 || arrayList.size() != 1) {
                        CollectionsKt.f((List) arrayList);
                    }
                }
            } else if (!Intrinsics.a(readByteString, DOT) && !Intrinsics.a(readByteString, ByteString.EMPTY)) {
                arrayList.add(readByteString);
            }
        }
        int size = arrayList.size();
        if (size > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                int i4 = i3 + 1;
                if (i3 > 0) {
                    buffer2.write(byteString);
                }
                buffer2.write((ByteString) arrayList.get(i3));
                if (i4 >= size) {
                    break;
                }
                i2 = i4;
            }
        }
        if (buffer2.size() == 0) {
            buffer2.write(DOT);
        }
        return new Path(buffer2.readByteString());
    }

    private static final ByteString toSlash(byte b) {
        if (b == 47) {
            return SLASH;
        }
        if (b == 92) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException(Intrinsics.a("not a directory separator: ", (Object) Byte.valueOf(b)));
    }

    public static final ByteString toSlash(String str) {
        if (Intrinsics.a((Object) str, (Object) BridgeUtil.SPLIT_MARK)) {
            return SLASH;
        }
        if (Intrinsics.a((Object) str, (Object) "\\")) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException(Intrinsics.a("not a directory separator: ", (Object) str));
    }
}
