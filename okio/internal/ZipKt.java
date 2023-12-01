package okio.internal;

import android.widget.ExpandableListView;
import com.android.org.conscrypt.NativeCrypto;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okio.BufferedSource;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.ZipFileSystem;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/internal/ZipKt.class */
public final class ZipKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (ZipEntry zipEntry : CollectionsKt.a((Iterable) list, new Comparator() { // from class: okio.internal.ZipKt$buildIndex$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.a(((ZipEntry) t).getCanonicalPath(), ((ZipEntry) t2).getCanonicalPath());
            }
        })) {
            ZipEntry zipEntry2 = zipEntry;
            if (((ZipEntry) linkedHashMap.put(zipEntry.getCanonicalPath(), zipEntry)) == null) {
                while (true) {
                    Path parent = zipEntry2.getCanonicalPath().parent();
                    if (parent != null) {
                        ZipEntry zipEntry3 = (ZipEntry) linkedHashMap.get(parent);
                        if (zipEntry3 != null) {
                            zipEntry3.getChildren().add(zipEntry2.getCanonicalPath());
                            break;
                        }
                        ZipEntry zipEntry4 = new ZipEntry(parent, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null);
                        linkedHashMap.put(parent, zipEntry4);
                        zipEntry4.getChildren().add(zipEntry2.getCanonicalPath());
                        zipEntry2 = zipEntry4;
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private static final Long dosDateTimeToEpochMillis(int i, int i2) {
        if (i2 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        gregorianCalendar.set(((i >> 9) & 127) + 1980, ((i >> 5) & 15) - 1, i & 31, (i2 >> 11) & 31, (i2 >> 5) & 63, (i2 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    private static final String getHex(int i) {
        String num = Integer.toString(i, CharsKt.a(16));
        Intrinsics.c(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return Intrinsics.a("0x", (Object) num);
    }

    public static final ZipFileSystem openZip(Path zipPath, FileSystem fileSystem, Function1<? super ZipEntry, Boolean> predicate) throws IOException {
        long j;
        int readIntLe;
        Intrinsics.e(zipPath, "zipPath");
        Intrinsics.e(fileSystem, "fileSystem");
        Intrinsics.e(predicate, "predicate");
        BufferedSource openReadOnly = fileSystem.openReadOnly(zipPath);
        Throwable th = null;
        try {
            FileHandle fileHandle = openReadOnly;
            BufferedSource buffer = Okio.buffer(FileHandle.source$default(fileHandle, 0L, 1, null));
            Throwable th2 = null;
            int readIntLe2 = buffer.readIntLe();
            if (readIntLe2 != LOCAL_FILE_HEADER_SIGNATURE) {
                if (readIntLe2 == END_OF_CENTRAL_DIRECTORY_SIGNATURE) {
                    throw new IOException("unsupported zip: empty");
                }
                throw new IOException("not a zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe2));
            }
            Unit unit = Unit.a;
            CloseableKt.a(buffer, th2);
            long size = fileHandle.size() - 22;
            if (size >= 0) {
                long max = Math.max(size - NativeCrypto.SSL_OP_NO_SESSION_RESUMPTION_ON_RENEGOTIATION, 0L);
                do {
                    BufferedSource buffer2 = Okio.buffer(fileHandle.source(size));
                    if (buffer2.readIntLe() == END_OF_CENTRAL_DIRECTORY_SIGNATURE) {
                        EocdRecord readEocdRecord = readEocdRecord(buffer2);
                        String readUtf8 = buffer2.readUtf8(readEocdRecord.getCommentByteCount());
                        buffer2.close();
                        long j2 = size - 20;
                        EocdRecord eocdRecord = readEocdRecord;
                        if (j2 > 0) {
                            BufferedSource buffer3 = Okio.buffer(fileHandle.source(j2));
                            Throwable th3 = null;
                            BufferedSource bufferedSource = buffer3;
                            eocdRecord = readEocdRecord;
                            if (bufferedSource.readIntLe() == ZIP64_LOCATOR_SIGNATURE) {
                                int readIntLe3 = bufferedSource.readIntLe();
                                long readLongLe = bufferedSource.readLongLe();
                                if (bufferedSource.readIntLe() != 1 || readIntLe3 != 0) {
                                    throw new IOException("unsupported zip: spanned");
                                }
                                openReadOnly = Okio.buffer(fileHandle.source(readLongLe));
                                Throwable th4 = null;
                                try {
                                    BufferedSource bufferedSource2 = openReadOnly;
                                    if (bufferedSource2.readIntLe() != ZIP64_EOCD_RECORD_SIGNATURE) {
                                        throw new IOException("bad zip: expected " + getHex(ZIP64_EOCD_RECORD_SIGNATURE) + " but was " + getHex(readIntLe));
                                    }
                                    eocdRecord = readZip64EocdRecord(bufferedSource2, readEocdRecord);
                                    Unit unit2 = Unit.a;
                                    CloseableKt.a(openReadOnly, th4);
                                } finally {
                                }
                            }
                            Unit unit3 = Unit.a;
                            CloseableKt.a(buffer3, th3);
                        }
                        ArrayList arrayList = new ArrayList();
                        BufferedSource buffer4 = Okio.buffer(fileHandle.source(eocdRecord.getCentralDirectoryOffset()));
                        Throwable th5 = null;
                        BufferedSource bufferedSource3 = buffer4;
                        long entryCount = eocdRecord.getEntryCount();
                        long j3 = 0;
                        if (0 >= entryCount) {
                            Unit unit4 = Unit.a;
                            CloseableKt.a(buffer4, th5);
                            ZipFileSystem zipFileSystem = new ZipFileSystem(zipPath, fileSystem, buildIndex(arrayList), readUtf8);
                            CloseableKt.a(openReadOnly, th);
                            return zipFileSystem;
                        }
                        do {
                            j = j3 + 1;
                            ZipEntry readEntry = readEntry(bufferedSource3);
                            if (readEntry.getOffset() >= eocdRecord.getCentralDirectoryOffset()) {
                                throw new IOException("bad zip: local file header offset >= central directory offset");
                            }
                            if (predicate.invoke(readEntry).booleanValue()) {
                                arrayList.add(readEntry);
                            }
                            j3 = j;
                        } while (j < entryCount);
                        Unit unit42 = Unit.a;
                        CloseableKt.a(buffer4, th5);
                        ZipFileSystem zipFileSystem2 = new ZipFileSystem(zipPath, fileSystem, buildIndex(arrayList), readUtf8);
                        CloseableKt.a(openReadOnly, th);
                        return zipFileSystem2;
                    }
                    buffer2.close();
                    size--;
                } while (size >= max);
                throw new IOException("not a zip: end of central directory signature not found");
            }
            throw new IOException(Intrinsics.a("not a zip: size=", (Object) Long.valueOf(fileHandle.size())));
        } finally {
            try {
                throw th;
            } finally {
            }
        }
    }

    public static /* synthetic */ ZipFileSystem openZip$default(Path path, FileSystem fileSystem, Function1 function1, int i, Object obj) throws IOException {
        if ((i & 4) != 0) {
            function1 = new Function1<ZipEntry, Boolean>() { // from class: okio.internal.ZipKt$openZip$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(ZipEntry it) {
                    Intrinsics.e(it, "it");
                    return true;
                }
            };
        }
        return openZip(path, fileSystem, function1);
    }

    public static final ZipEntry readEntry(final BufferedSource bufferedSource) throws IOException {
        int readIntLe;
        Intrinsics.e(bufferedSource, "<this>");
        if (bufferedSource.readIntLe() != CENTRAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
        }
        bufferedSource.skip(4L);
        int readShortLe = bufferedSource.readShortLe() & 65535;
        if ((readShortLe & 1) == 0) {
            short readShortLe2 = bufferedSource.readShortLe();
            Long dosDateTimeToEpochMillis = dosDateTimeToEpochMillis(bufferedSource.readShortLe() & 65535, bufferedSource.readShortLe() & 65535);
            long readIntLe2 = bufferedSource.readIntLe();
            final Ref.LongRef longRef = new Ref.LongRef();
            longRef.a = bufferedSource.readIntLe() & 4294967295L;
            final Ref.LongRef longRef2 = new Ref.LongRef();
            longRef2.a = bufferedSource.readIntLe() & 4294967295L;
            short readShortLe3 = bufferedSource.readShortLe();
            short readShortLe4 = bufferedSource.readShortLe();
            short readShortLe5 = bufferedSource.readShortLe();
            bufferedSource.skip(8L);
            final Ref.LongRef longRef3 = new Ref.LongRef();
            longRef3.a = bufferedSource.readIntLe() & 4294967295L;
            String readUtf8 = bufferedSource.readUtf8(readShortLe3 & 65535);
            if (StringsKt.a((CharSequence) readUtf8, (char) 0, false, 2, (Object) null)) {
                throw new IOException("bad zip: filename contains 0x00");
            }
            long j = longRef2.a == 4294967295L ? 8 + 0 : 0L;
            long j2 = j;
            if (longRef.a == 4294967295L) {
                j2 = j + 8;
            }
            long j3 = j2;
            if (longRef3.a == 4294967295L) {
                j3 = j2 + 8;
            }
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            final long j4 = j3;
            readExtra(bufferedSource, readShortLe4 & 65535, new Function2<Integer, Long, Unit>() { // from class: okio.internal.ZipKt$readEntry$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* synthetic */ Unit invoke(Integer num, Long l) {
                    invoke(num.intValue(), l.longValue());
                    return Unit.a;
                }

                public final void invoke(int i, long j5) {
                    if (i == 1) {
                        if (Ref.BooleanRef.this.a) {
                            throw new IOException("bad zip: zip64 extra repeated");
                        }
                        Ref.BooleanRef.this.a = true;
                        if (j5 < j4) {
                            throw new IOException("bad zip: zip64 extra too short");
                        }
                        Ref.LongRef longRef4 = longRef2;
                        longRef4.a = longRef4.a == ExpandableListView.PACKED_POSITION_VALUE_NULL ? bufferedSource.readLongLe() : longRef2.a;
                        Ref.LongRef longRef5 = longRef;
                        longRef5.a = longRef5.a == ExpandableListView.PACKED_POSITION_VALUE_NULL ? bufferedSource.readLongLe() : 0L;
                        Ref.LongRef longRef6 = longRef3;
                        long j6 = 0;
                        if (longRef6.a == ExpandableListView.PACKED_POSITION_VALUE_NULL) {
                            j6 = bufferedSource.readLongLe();
                        }
                        longRef6.a = j6;
                    }
                }
            });
            if (j3 <= 0 || booleanRef.a) {
                return new ZipEntry(Path.Companion.get$default(Path.Companion, BridgeUtil.SPLIT_MARK, false, 1, (Object) null).resolve(readUtf8), StringsKt.b(readUtf8, BridgeUtil.SPLIT_MARK, false, 2, (Object) null), bufferedSource.readUtf8(readShortLe5 & 65535), readIntLe2 & 4294967295L, longRef.a, longRef2.a, readShortLe2 & 65535, dosDateTimeToEpochMillis, longRef3.a);
            }
            throw new IOException("bad zip: zip64 extra required but absent");
        }
        throw new IOException(Intrinsics.a("unsupported zip: general purpose bit flag=", (Object) getHex(readShortLe)));
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource) throws IOException {
        short readShortLe = bufferedSource.readShortLe();
        short readShortLe2 = bufferedSource.readShortLe();
        long readShortLe3 = bufferedSource.readShortLe() & 65535;
        if (readShortLe3 == (bufferedSource.readShortLe() & 65535) && (readShortLe & 65535) == 0 && (readShortLe2 & 65535) == 0) {
            bufferedSource.skip(4L);
            return new EocdRecord(readShortLe3, 4294967295L & bufferedSource.readIntLe(), bufferedSource.readShortLe() & 65535);
        }
        throw new IOException("unsupported zip: spanned");
    }

    private static final void readExtra(BufferedSource bufferedSource, int i, Function2<? super Integer, ? super Long, Unit> function2) {
        long j = i;
        while (true) {
            long j2 = j;
            if (j2 == 0) {
                return;
            }
            if (j2 < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int readShortLe = bufferedSource.readShortLe() & 65535;
            long readShortLe2 = bufferedSource.readShortLe() & 65535;
            long j3 = j2 - 4;
            if (j3 < readShortLe2) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            bufferedSource.require(readShortLe2);
            long size = bufferedSource.getBuffer().size();
            function2.invoke(Integer.valueOf(readShortLe), Long.valueOf(readShortLe2));
            long size2 = (bufferedSource.getBuffer().size() + readShortLe2) - size;
            int i2 = (size2 > 0L ? 1 : (size2 == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IOException(Intrinsics.a("unsupported zip: too many bytes processed for ", (Object) Integer.valueOf(readShortLe)));
            }
            if (i2 > 0) {
                bufferedSource.getBuffer().skip(size2);
            }
            j = j3 - readShortLe2;
        }
    }

    public static final FileMetadata readLocalHeader(BufferedSource bufferedSource, FileMetadata basicMetadata) {
        Intrinsics.e(bufferedSource, "<this>");
        Intrinsics.e(basicMetadata, "basicMetadata");
        FileMetadata readOrSkipLocalHeader = readOrSkipLocalHeader(bufferedSource, basicMetadata);
        Intrinsics.a(readOrSkipLocalHeader);
        return readOrSkipLocalHeader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final FileMetadata readOrSkipLocalHeader(final BufferedSource bufferedSource, FileMetadata fileMetadata) {
        int readIntLe;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.a = fileMetadata == null ? null : fileMetadata.getLastModifiedAtMillis();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        if (bufferedSource.readIntLe() != LOCAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
        }
        bufferedSource.skip(2L);
        int readShortLe = bufferedSource.readShortLe() & 65535;
        if ((readShortLe & 1) == 0) {
            bufferedSource.skip(18L);
            long readShortLe2 = bufferedSource.readShortLe();
            int readShortLe3 = bufferedSource.readShortLe() & 65535;
            bufferedSource.skip(readShortLe2 & 65535);
            if (fileMetadata == null) {
                bufferedSource.skip(readShortLe3);
                return null;
            }
            readExtra(bufferedSource, readShortLe3, new Function2<Integer, Long, Unit>() { // from class: okio.internal.ZipKt$readOrSkipLocalHeader$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* synthetic */ Unit invoke(Integer num, Long l) {
                    invoke(num.intValue(), l.longValue());
                    return Unit.a;
                }

                /* JADX WARN: Type inference failed for: r1v17, types: [T, java.lang.Long] */
                /* JADX WARN: Type inference failed for: r1v23, types: [T, java.lang.Long] */
                /* JADX WARN: Type inference failed for: r1v29, types: [T, java.lang.Long] */
                public final void invoke(int i, long j) {
                    if (i == 21589) {
                        long j2 = 1;
                        if (j < 1) {
                            throw new IOException("bad zip: extended timestamp extra too short");
                        }
                        int readByte = BufferedSource.this.readByte() & 255;
                        boolean z = false;
                        boolean z2 = (readByte & 1) == 1;
                        boolean z3 = (readByte & 2) == 2;
                        if ((readByte & 4) == 4) {
                            z = true;
                        }
                        if (z2) {
                            j2 = 5;
                        }
                        long j3 = j2;
                        if (z3) {
                            j3 = j2 + 4;
                        }
                        long j4 = j3;
                        if (z) {
                            j4 = j3 + 4;
                        }
                        if (j < j4) {
                            throw new IOException("bad zip: extended timestamp extra too short");
                        }
                        if (z2) {
                            objectRef.a = Long.valueOf(BufferedSource.this.readIntLe() * 1000);
                        }
                        if (z3) {
                            objectRef2.a = Long.valueOf(BufferedSource.this.readIntLe() * 1000);
                        }
                        if (z) {
                            objectRef3.a = Long.valueOf(BufferedSource.this.readIntLe() * 1000);
                        }
                    }
                }
            });
            return new FileMetadata(fileMetadata.isRegularFile(), fileMetadata.isDirectory(), null, fileMetadata.getSize(), (Long) objectRef3.a, (Long) objectRef.a, (Long) objectRef2.a, null, 128, null);
        }
        throw new IOException(Intrinsics.a("unsupported zip: general purpose bit flag=", (Object) getHex(readShortLe)));
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource, EocdRecord eocdRecord) throws IOException {
        bufferedSource.skip(12L);
        int readIntLe = bufferedSource.readIntLe();
        int readIntLe2 = bufferedSource.readIntLe();
        long readLongLe = bufferedSource.readLongLe();
        if (readLongLe == bufferedSource.readLongLe() && readIntLe == 0 && readIntLe2 == 0) {
            bufferedSource.skip(8L);
            return new EocdRecord(readLongLe, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
        }
        throw new IOException("unsupported zip: spanned");
    }

    public static final void skipLocalHeader(BufferedSource bufferedSource) {
        Intrinsics.e(bufferedSource, "<this>");
        readOrSkipLocalHeader(bufferedSource, null);
    }
}
