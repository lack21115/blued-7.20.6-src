package com.squareup.wire;

import android.os.BatteryStats;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.ByteString;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/ProtoWriter.class */
public final class ProtoWriter {
    public static final Companion Companion = new Companion(null);
    private final BufferedSink sink;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/ProtoWriter$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int decodeZigZag32$wire_runtime(int i) {
            return (-(i & 1)) ^ (i >>> 1);
        }

        public final long decodeZigZag64$wire_runtime(long j) {
            return (-(j & 1)) ^ (j >>> 1);
        }

        public final int encodeZigZag32$wire_runtime(int i) {
            return (i >> 31) ^ (i << 1);
        }

        public final long encodeZigZag64$wire_runtime(long j) {
            return (j >> 63) ^ (j << 1);
        }

        public final int int32Size$wire_runtime(int i) {
            if (i >= 0) {
                return varint32Size$wire_runtime(i);
            }
            return 10;
        }

        public final int makeTag$wire_runtime(int i, FieldEncoding fieldEncoding) {
            Intrinsics.e(fieldEncoding, "fieldEncoding");
            return (i << 3) | fieldEncoding.getValue$wire_runtime();
        }

        public final int tagSize$wire_runtime(int i) {
            return varint32Size$wire_runtime(makeTag$wire_runtime(i, FieldEncoding.VARINT));
        }

        public final int varint32Size$wire_runtime(int i) {
            if ((i & (-128)) == 0) {
                return 1;
            }
            if ((i & (-16384)) == 0) {
                return 2;
            }
            if (((-2097152) & i) == 0) {
                return 3;
            }
            return (i & ShareElfFile.SectionHeader.SHF_MASKPROC) == 0 ? 4 : 5;
        }

        public final int varint64Size$wire_runtime(long j) {
            if (((-128) & j) == 0) {
                return 1;
            }
            if (((-16384) & j) == 0) {
                return 2;
            }
            if (((-2097152) & j) == 0) {
                return 3;
            }
            if (((-268435456) & j) == 0) {
                return 4;
            }
            if (((-34359738368L) & j) == 0) {
                return 5;
            }
            if (((-4398046511104L) & j) == 0) {
                return 6;
            }
            if (((-562949953421312L) & j) == 0) {
                return 7;
            }
            if ((BatteryStats.STEP_LEVEL_MODIFIED_MODE_MASK & j) == 0) {
                return 8;
            }
            return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
        }
    }

    public ProtoWriter(BufferedSink bufferedSink) {
        Intrinsics.e(bufferedSink, "sink");
        this.sink = bufferedSink;
    }

    public final void writeBytes(ByteString byteString) throws IOException {
        Intrinsics.e(byteString, "value");
        this.sink.write(byteString);
    }

    public final void writeFixed32(int i) throws IOException {
        this.sink.writeIntLe(i);
    }

    public final void writeFixed64(long j) throws IOException {
        this.sink.writeLongLe(j);
    }

    public final void writeSignedVarint32$wire_runtime(int i) throws IOException {
        if (i >= 0) {
            writeVarint32(i);
        } else {
            writeVarint64(i);
        }
    }

    public final void writeString(String str) throws IOException {
        Intrinsics.e(str, "value");
        this.sink.writeUtf8(str);
    }

    public final void writeTag(int i, FieldEncoding fieldEncoding) throws IOException {
        Intrinsics.e(fieldEncoding, "fieldEncoding");
        writeVarint32(Companion.makeTag$wire_runtime(i, fieldEncoding));
    }

    public final void writeVarint32(int i) throws IOException {
        while ((i & (-128)) != 0) {
            this.sink.writeByte((i & 127) | 128);
            i >>>= 7;
        }
        this.sink.writeByte(i);
    }

    public final void writeVarint64(long j) throws IOException {
        while (((-128) & j) != 0) {
            this.sink.writeByte((((int) j) & 127) | 128);
            j >>>= 7;
        }
        this.sink.writeByte((int) j);
    }
}
