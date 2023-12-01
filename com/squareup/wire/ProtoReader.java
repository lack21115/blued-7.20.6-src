package com.squareup.wire;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/ProtoReader.class */
public final class ProtoReader {
    public static final Companion Companion = new Companion(null);
    private static final int FIELD_ENCODING_MASK = 7;
    private static final int RECURSION_LIMIT = 65;
    private static final int STATE_END_GROUP = 4;
    private static final int STATE_FIXED32 = 5;
    private static final int STATE_FIXED64 = 1;
    private static final int STATE_LENGTH_DELIMITED = 2;
    private static final int STATE_PACKED_TAG = 7;
    private static final int STATE_START_GROUP = 3;
    private static final int STATE_TAG = 6;
    private static final int STATE_VARINT = 0;
    public static final int TAG_FIELD_ENCODING_BITS = 3;
    private final List<Buffer> bufferStack;
    private long limit;
    private FieldEncoding nextFieldEncoding;
    private long pos;
    private long pushedLimit;
    private int recursionDepth;
    private final BufferedSource source;
    private int state;
    private int tag;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/ProtoReader$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ProtoReader(BufferedSource bufferedSource) {
        Intrinsics.e(bufferedSource, "source");
        this.source = bufferedSource;
        this.limit = Long.MAX_VALUE;
        this.state = 2;
        this.tag = -1;
        this.pushedLimit = -1L;
        this.bufferStack = new ArrayList();
    }

    private final void afterPackableScalar(int i) throws IOException {
        if (this.state == i) {
            this.state = 6;
            return;
        }
        long j = this.pos;
        long j2 = this.limit;
        if (j > j2) {
            throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
        } else if (j != j2) {
            this.state = 7;
        } else {
            this.limit = this.pushedLimit;
            this.pushedLimit = -1L;
            this.state = 6;
        }
    }

    private final long beforeLengthDelimitedScalar() throws IOException {
        if (this.state == 2) {
            long j = this.limit - this.pos;
            this.source.require(j);
            this.state = 6;
            this.pos = this.limit;
            this.limit = this.pushedLimit;
            this.pushedLimit = -1L;
            return j;
        }
        throw new ProtocolException(Intrinsics.a("Expected LENGTH_DELIMITED but was ", Integer.valueOf(this.state)));
    }

    private final int internalReadVarint32() {
        int i;
        this.source.require(1L);
        this.pos++;
        byte readByte = this.source.readByte();
        if (readByte >= 0) {
            return readByte;
        }
        int i2 = readByte & Byte.MAX_VALUE;
        this.source.require(1L);
        this.pos++;
        byte readByte2 = this.source.readByte();
        if (readByte2 >= 0) {
            i = readByte2 << 7;
        } else {
            i2 |= (readByte2 & Byte.MAX_VALUE) << 7;
            this.source.require(1L);
            this.pos++;
            byte readByte3 = this.source.readByte();
            if (readByte3 >= 0) {
                i = readByte3 << 14;
            } else {
                i2 |= (readByte3 & Byte.MAX_VALUE) << 14;
                this.source.require(1L);
                this.pos++;
                byte readByte4 = this.source.readByte();
                if (readByte4 < 0) {
                    this.source.require(1L);
                    this.pos++;
                    byte readByte5 = this.source.readByte();
                    int i3 = i2 | ((readByte4 & Byte.MAX_VALUE) << 21) | (readByte5 << 28);
                    if (readByte5 < 0) {
                        int i4 = 0;
                        while (i4 < 5) {
                            i4++;
                            this.source.require(1L);
                            this.pos++;
                            if (this.source.readByte() >= 0) {
                                return i3;
                            }
                        }
                        throw new ProtocolException("Malformed VARINT");
                    }
                    return i3;
                }
                i = readByte4 << 21;
            }
        }
        return i2 | i;
    }

    private final void skipGroup(int i) {
        while (this.pos < this.limit && !this.source.exhausted()) {
            int internalReadVarint32 = internalReadVarint32();
            if (internalReadVarint32 == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i2 = internalReadVarint32 >> 3;
            int i3 = internalReadVarint32 & 7;
            if (i3 == 0) {
                this.state = 0;
                readVarint64();
            } else if (i3 == 1) {
                this.state = 1;
                readFixed64();
            } else if (i3 == 2) {
                long internalReadVarint322 = internalReadVarint32();
                this.pos += internalReadVarint322;
                this.source.skip(internalReadVarint322);
            } else if (i3 == 3) {
                skipGroup(i2);
            } else if (i3 == 4) {
                if (i2 != i) {
                    throw new ProtocolException("Unexpected end group");
                }
                return;
            } else if (i3 != 5) {
                throw new ProtocolException(Intrinsics.a("Unexpected field encoding: ", Integer.valueOf(i3)));
            } else {
                this.state = 5;
                readFixed32();
            }
        }
        throw new EOFException();
    }

    /* renamed from: -forEachTag  reason: not valid java name */
    public final ByteString m6698forEachTag(Function1<? super Integer, ? extends Object> function1) {
        Intrinsics.e(function1, "tagHandler");
        long beginMessage = beginMessage();
        while (true) {
            int nextTag = nextTag();
            if (nextTag == -1) {
                return endMessageAndGetUnknownFields(beginMessage);
            }
            function1.invoke(Integer.valueOf(nextTag));
        }
    }

    public final void addUnknownField(int i, FieldEncoding fieldEncoding, Object obj) {
        Intrinsics.e(fieldEncoding, "fieldEncoding");
        fieldEncoding.rawProtoAdapter().encodeWithTag(new ProtoWriter(this.bufferStack.get(this.recursionDepth - 1)), i, (int) obj);
    }

    public final long beginMessage() throws IOException {
        if (this.state == 2) {
            int i = this.recursionDepth + 1;
            this.recursionDepth = i;
            if (i <= 65) {
                if (i > this.bufferStack.size()) {
                    this.bufferStack.add(new Buffer());
                }
                long j = this.pushedLimit;
                this.pushedLimit = -1L;
                this.state = 6;
                return j;
            }
            throw new IOException("Wire recursion limit exceeded");
        }
        throw new IllegalStateException("Unexpected call to beginMessage()".toString());
    }

    @Deprecated
    public final void endMessage(long j) throws IOException {
        endMessageAndGetUnknownFields(j);
    }

    public final ByteString endMessageAndGetUnknownFields(long j) throws IOException {
        if (this.state == 6) {
            int i = this.recursionDepth - 1;
            this.recursionDepth = i;
            if (i >= 0 && this.pushedLimit == -1) {
                if (this.pos == this.limit || this.recursionDepth == 0) {
                    this.limit = j;
                    Buffer buffer = this.bufferStack.get(this.recursionDepth);
                    return buffer.size() > 0 ? buffer.readByteString() : ByteString.EMPTY;
                }
                throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
            }
            throw new IllegalStateException("No corresponding call to beginMessage()".toString());
        }
        throw new IllegalStateException("Unexpected call to endMessage()".toString());
    }

    public final int nextTag() throws IOException {
        int i = this.state;
        if (i == 7) {
            this.state = 2;
            return this.tag;
        } else if (i == 6) {
            while (this.pos < this.limit && !this.source.exhausted()) {
                int internalReadVarint32 = internalReadVarint32();
                if (internalReadVarint32 == 0) {
                    throw new ProtocolException("Unexpected tag 0");
                }
                int i2 = internalReadVarint32 >> 3;
                this.tag = i2;
                int i3 = internalReadVarint32 & 7;
                if (i3 == 0) {
                    this.nextFieldEncoding = FieldEncoding.VARINT;
                    this.state = 0;
                    return this.tag;
                } else if (i3 == 1) {
                    this.nextFieldEncoding = FieldEncoding.FIXED64;
                    this.state = 1;
                    return this.tag;
                } else if (i3 == 2) {
                    this.nextFieldEncoding = FieldEncoding.LENGTH_DELIMITED;
                    this.state = 2;
                    int internalReadVarint322 = internalReadVarint32();
                    if (internalReadVarint322 >= 0) {
                        if (this.pushedLimit == -1) {
                            long j = this.limit;
                            this.pushedLimit = j;
                            long j2 = this.pos + internalReadVarint322;
                            this.limit = j2;
                            if (j2 <= j) {
                                return this.tag;
                            }
                            throw new EOFException();
                        }
                        throw new IllegalStateException();
                    }
                    throw new ProtocolException(Intrinsics.a("Negative length: ", Integer.valueOf(internalReadVarint322)));
                } else if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            this.nextFieldEncoding = FieldEncoding.FIXED32;
                            this.state = 5;
                            return this.tag;
                        }
                        throw new ProtocolException(Intrinsics.a("Unexpected field encoding: ", Integer.valueOf(i3)));
                    }
                    throw new ProtocolException("Unexpected end group");
                } else {
                    skipGroup(i2);
                }
            }
            return -1;
        } else {
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
    }

    public final FieldEncoding peekFieldEncoding() {
        return this.nextFieldEncoding;
    }

    public final ByteString readBytes() throws IOException {
        long beforeLengthDelimitedScalar = beforeLengthDelimitedScalar();
        this.source.require(beforeLengthDelimitedScalar);
        return this.source.readByteString(beforeLengthDelimitedScalar);
    }

    public final int readFixed32() throws IOException {
        int i = this.state;
        if (i == 5 || i == 2) {
            this.source.require(4L);
            this.pos += 4;
            int readIntLe = this.source.readIntLe();
            afterPackableScalar(5);
            return readIntLe;
        }
        throw new ProtocolException(Intrinsics.a("Expected FIXED32 or LENGTH_DELIMITED but was ", Integer.valueOf(this.state)));
    }

    public final long readFixed64() throws IOException {
        int i = this.state;
        if (i == 1 || i == 2) {
            this.source.require(8L);
            this.pos += 8;
            long readLongLe = this.source.readLongLe();
            afterPackableScalar(1);
            return readLongLe;
        }
        throw new ProtocolException(Intrinsics.a("Expected FIXED64 or LENGTH_DELIMITED but was ", Integer.valueOf(this.state)));
    }

    public final String readString() throws IOException {
        long beforeLengthDelimitedScalar = beforeLengthDelimitedScalar();
        this.source.require(beforeLengthDelimitedScalar);
        return this.source.readUtf8(beforeLengthDelimitedScalar);
    }

    public final void readUnknownField(int i) {
        FieldEncoding peekFieldEncoding = peekFieldEncoding();
        Intrinsics.a(peekFieldEncoding);
        addUnknownField(i, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(this));
    }

    public final int readVarint32() throws IOException {
        int i = this.state;
        if (i == 0 || i == 2) {
            int internalReadVarint32 = internalReadVarint32();
            afterPackableScalar(0);
            return internalReadVarint32;
        }
        throw new ProtocolException(Intrinsics.a("Expected VARINT or LENGTH_DELIMITED but was ", Integer.valueOf(this.state)));
    }

    public final long readVarint64() throws IOException {
        byte readByte;
        int i = this.state;
        if (i != 0 && i != 2) {
            throw new ProtocolException(Intrinsics.a("Expected VARINT or LENGTH_DELIMITED but was ", Integer.valueOf(this.state)));
        }
        long j = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 64) {
                throw new ProtocolException("WireInput encountered a malformed varint");
            }
            this.source.require(1L);
            this.pos++;
            j |= (readByte & Byte.MAX_VALUE) << i3;
            if ((this.source.readByte() & 128) == 0) {
                afterPackableScalar(0);
                return j;
            }
            i2 = i3 + 7;
        }
    }

    public final void skip() throws IOException {
        int i = this.state;
        if (i == 0) {
            readVarint64();
        } else if (i == 1) {
            readFixed64();
        } else if (i == 2) {
            this.source.skip(beforeLengthDelimitedScalar());
        } else if (i != 5) {
            throw new IllegalStateException("Unexpected call to skip()");
        } else {
            readFixed32();
        }
    }
}
