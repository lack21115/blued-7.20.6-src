package com.squareup.wire;

import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/ReverseProtoWriter.class */
public final class ReverseProtoWriter {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    private static final byte[] EMPTY_ARRAY = new byte[0];
    private int arrayLimit;
    private Buffer tail = new Buffer();
    private Buffer head = new Buffer();
    private final Buffer.UnsafeCursor cursor = new Buffer.UnsafeCursor();
    private byte[] array = EMPTY_ARRAY;
    private final Lazy forwardBuffer$delegate = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<Buffer>() { // from class: com.squareup.wire.ReverseProtoWriter$forwardBuffer$2
        @Override // kotlin.jvm.functions.Function0
        public final Buffer invoke() {
            return new Buffer();
        }
    });
    private final Lazy forwardWriter$delegate = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<ProtoWriter>() { // from class: com.squareup.wire.ReverseProtoWriter$forwardWriter$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ProtoWriter invoke() {
            Buffer forwardBuffer;
            forwardBuffer = ReverseProtoWriter.this.getForwardBuffer();
            return new ProtoWriter(forwardBuffer);
        }
    });

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/ReverseProtoWriter$Companion.class */
    static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void emitCurrentSegment() {
        if (this.array == EMPTY_ARRAY) {
            return;
        }
        this.cursor.close();
        this.head.skip(this.arrayLimit);
        this.head.writeAll(this.tail);
        Buffer buffer = this.tail;
        this.tail = this.head;
        this.head = buffer;
        this.array = EMPTY_ARRAY;
        this.arrayLimit = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Buffer getForwardBuffer() {
        return (Buffer) this.forwardBuffer$delegate.getValue();
    }

    private final ProtoWriter getForwardWriter() {
        return (ProtoWriter) this.forwardWriter$delegate.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void require(int r6) {
        /*
            r5 = this;
            r0 = r5
            int r0 = r0.arrayLimit
            r1 = r6
            if (r0 < r1) goto L9
            return
        L9:
            r0 = r5
            r0.emitCurrentSegment()
            r0 = r5
            okio.Buffer r0 = r0.head
            r1 = r5
            okio.Buffer$UnsafeCursor r1 = r1.cursor
            okio.Buffer$UnsafeCursor r0 = r0.readAndWriteUnsafe(r1)
            r0 = r5
            okio.Buffer$UnsafeCursor r0 = r0.cursor
            r1 = r6
            long r0 = r0.expandBuffer(r1)
            r0 = r5
            okio.Buffer$UnsafeCursor r0 = r0.cursor
            long r0 = r0.offset
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L4d
            r0 = r5
            okio.Buffer$UnsafeCursor r0 = r0.cursor
            int r0 = r0.end
            r6 = r0
            r0 = r5
            okio.Buffer$UnsafeCursor r0 = r0.cursor
            byte[] r0 = r0.data
            r7 = r0
            r0 = r7
            kotlin.jvm.internal.Intrinsics.a(r0)
            r0 = r6
            r1 = r7
            int r1 = r1.length
            if (r0 != r1) goto L4d
            r0 = 1
            r6 = r0
            goto L4f
        L4d:
            r0 = 0
            r6 = r0
        L4f:
            r0 = r6
            if (r0 == 0) goto L70
            r0 = r5
            okio.Buffer$UnsafeCursor r0 = r0.cursor
            byte[] r0 = r0.data
            r7 = r0
            r0 = r7
            kotlin.jvm.internal.Intrinsics.a(r0)
            r0 = r5
            r1 = r7
            r0.array = r1
            r0 = r5
            r1 = r5
            okio.Buffer$UnsafeCursor r1 = r1.cursor
            int r1 = r1.end
            r0.arrayLimit = r1
            return
        L70:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "Check failed."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.ReverseProtoWriter.require(int):void");
    }

    public final int getByteCount() {
        return ((int) this.tail.size()) + (this.array.length - this.arrayLimit);
    }

    public final void writeBytes(ByteString value) {
        Intrinsics.e(value, "value");
        int size = value.size();
        while (size != 0) {
            require(1);
            int min = Math.min(this.arrayLimit, size);
            int i = this.arrayLimit - min;
            this.arrayLimit = i;
            size -= min;
            value.copyInto(size, this.array, i, min);
        }
    }

    public final void writeFixed32(int i) {
        require(4);
        int i2 = this.arrayLimit - 4;
        this.arrayLimit = i2;
        byte[] bArr = this.array;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 8) & 255);
        bArr[i4] = (byte) ((i >>> 16) & 255);
        bArr[i4 + 1] = (byte) ((i >>> 24) & 255);
    }

    public final void writeFixed64(long j) {
        require(8);
        int i = this.arrayLimit - 8;
        this.arrayLimit = i;
        byte[] bArr = this.array;
        int i2 = i + 1;
        bArr[i] = (byte) (j & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 8) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 24) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 32) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 40) & 255);
        bArr[i7] = (byte) ((j >>> 48) & 255);
        bArr[i7 + 1] = (byte) ((j >>> 56) & 255);
    }

    public final void writeForward$wire_runtime(Function1<? super ProtoWriter, Unit> block) throws IOException {
        Intrinsics.e(block, "block");
        block.invoke(getForwardWriter());
        writeBytes(getForwardBuffer().readByteString());
    }

    public final void writeSignedVarint32$wire_runtime(int i) {
        if (i >= 0) {
            writeVarint32(i);
        } else {
            writeVarint64(i);
        }
    }

    public final void writeString(String value) {
        char charAt;
        Intrinsics.e(value, "value");
        int length = value.length() - 1;
        while (true) {
            int i = length;
            if (i < 0) {
                return;
            }
            int i2 = i - 1;
            char charAt2 = value.charAt(i);
            if (charAt2 < 128) {
                require(1);
                int i3 = this.arrayLimit;
                byte[] bArr = this.array;
                int i4 = i3 - 1;
                bArr[i4] = (byte) charAt2;
                int max = Math.max(-1, i2 - i4);
                while (i2 > max && (charAt = value.charAt(i2)) < 128) {
                    i2--;
                    i4--;
                    bArr[i4] = (byte) charAt;
                }
                this.arrayLimit = i4;
            } else if (charAt2 < 2048) {
                require(2);
                byte[] bArr2 = this.array;
                int i5 = this.arrayLimit - 1;
                this.arrayLimit = i5;
                bArr2[i5] = (byte) (128 | (charAt2 & '?'));
                int i6 = i5 - 1;
                this.arrayLimit = i6;
                bArr2[i6] = (byte) ((charAt2 >> 6) | 192);
            } else if (charAt2 < 55296 || charAt2 > 57343) {
                require(3);
                byte[] bArr3 = this.array;
                int i7 = this.arrayLimit - 1;
                this.arrayLimit = i7;
                bArr3[i7] = (byte) ((charAt2 & '?') | 128);
                int i8 = i7 - 1;
                this.arrayLimit = i8;
                bArr3[i8] = (byte) (128 | (63 & (charAt2 >> 6)));
                int i9 = i8 - 1;
                this.arrayLimit = i9;
                bArr3[i9] = (byte) ((charAt2 >> '\f') | 224);
            } else {
                char charAt3 = i2 >= 0 ? value.charAt(i2) : (char) 65535;
                if (charAt3 <= 56319) {
                    boolean z = false;
                    if (56320 <= charAt2) {
                        z = false;
                        if (charAt2 < 57344) {
                            z = true;
                        }
                    }
                    if (z) {
                        i2--;
                        int i10 = ((charAt2 & 1023) | ((charAt3 & 1023) << 10)) + 65536;
                        require(4);
                        byte[] bArr4 = this.array;
                        int i11 = this.arrayLimit - 1;
                        this.arrayLimit = i11;
                        bArr4[i11] = (byte) ((i10 & 63) | 128);
                        int i12 = i11 - 1;
                        this.arrayLimit = i12;
                        bArr4[i12] = (byte) (((i10 >> 6) & 63) | 128);
                        int i13 = i12 - 1;
                        this.arrayLimit = i13;
                        bArr4[i13] = (byte) (128 | (63 & (i10 >> 12)));
                        int i14 = i13 - 1;
                        this.arrayLimit = i14;
                        bArr4[i14] = (byte) ((i10 >> 18) | 240);
                    }
                }
                require(1);
                byte[] bArr5 = this.array;
                int i15 = this.arrayLimit - 1;
                this.arrayLimit = i15;
                bArr5[i15] = 63;
            }
            length = i2;
        }
    }

    public final void writeTag(int i, FieldEncoding fieldEncoding) {
        Intrinsics.e(fieldEncoding, "fieldEncoding");
        writeVarint32(ProtoWriter.Companion.makeTag$wire_runtime(i, fieldEncoding));
    }

    public final void writeTo(BufferedSink sink) throws IOException {
        Intrinsics.e(sink, "sink");
        emitCurrentSegment();
        sink.writeAll(this.tail);
    }

    public final void writeVarint32(int i) {
        int varint32Size$wire_runtime = ProtoWriter.Companion.varint32Size$wire_runtime(i);
        require(varint32Size$wire_runtime);
        int i2 = this.arrayLimit - varint32Size$wire_runtime;
        this.arrayLimit = i2;
        int i3 = i;
        int i4 = i2;
        while (true) {
            int i5 = i4;
            if ((i3 & (-128)) == 0) {
                this.array[i5] = (byte) i3;
                return;
            }
            this.array[i5] = (byte) ((i3 & 127) | 128);
            i3 >>>= 7;
            i4 = i5 + 1;
        }
    }

    public final void writeVarint64(long j) {
        int varint64Size$wire_runtime = ProtoWriter.Companion.varint64Size$wire_runtime(j);
        require(varint64Size$wire_runtime);
        int i = this.arrayLimit - varint64Size$wire_runtime;
        this.arrayLimit = i;
        while (((-128) & j) != 0) {
            this.array[i] = (byte) ((127 & j) | 128);
            j >>>= 7;
            i++;
        }
        this.array[i] = (byte) j;
    }
}
