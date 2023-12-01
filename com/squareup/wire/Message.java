package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/Message.class */
public abstract class Message<M extends Message<M, B>, B extends Builder<M, B>> implements Serializable {
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 0;
    private final transient ProtoAdapter<M> adapter;
    private transient int cachedSerializedSize;
    public transient int hashCode;
    private final transient ByteString unknownFields;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/Message$Builder.class */
    public static abstract class Builder<M extends Message<M, B>, B extends Builder<M, B>> {
        private transient Buffer unknownFieldsBuffer;
        private transient ByteString unknownFieldsByteString = ByteString.EMPTY;
        private transient ProtoWriter unknownFieldsWriter;

        private final void prepareForNewUnknownFields() {
            if (this.unknownFieldsBuffer == null) {
                Buffer buffer = new Buffer();
                this.unknownFieldsBuffer = buffer;
                Intrinsics.a(buffer);
                ProtoWriter protoWriter = new ProtoWriter(buffer);
                this.unknownFieldsWriter = protoWriter;
                Intrinsics.a(protoWriter);
                protoWriter.writeBytes(this.unknownFieldsByteString);
                this.unknownFieldsByteString = ByteString.EMPTY;
            }
        }

        public final Builder<M, B> addUnknownField(int i, FieldEncoding fieldEncoding, Object obj) {
            Intrinsics.e(fieldEncoding, "fieldEncoding");
            Builder<M, B> builder = this;
            builder.prepareForNewUnknownFields();
            ProtoAdapter<?> rawProtoAdapter = fieldEncoding.rawProtoAdapter();
            ProtoWriter unknownFieldsWriter$wire_runtime = builder.getUnknownFieldsWriter$wire_runtime();
            Intrinsics.a(unknownFieldsWriter$wire_runtime);
            rawProtoAdapter.encodeWithTag(unknownFieldsWriter$wire_runtime, i, (int) obj);
            return builder;
        }

        public final Builder<M, B> addUnknownFields(ByteString unknownFields) {
            Intrinsics.e(unknownFields, "unknownFields");
            Builder<M, B> builder = this;
            if (unknownFields.size() > 0) {
                builder.prepareForNewUnknownFields();
                ProtoWriter unknownFieldsWriter$wire_runtime = builder.getUnknownFieldsWriter$wire_runtime();
                Intrinsics.a(unknownFieldsWriter$wire_runtime);
                unknownFieldsWriter$wire_runtime.writeBytes(unknownFields);
            }
            return builder;
        }

        public abstract M build();

        public final ByteString buildUnknownFields() {
            Buffer buffer = this.unknownFieldsBuffer;
            if (buffer != null) {
                Intrinsics.a(buffer);
                this.unknownFieldsByteString = buffer.readByteString();
                this.unknownFieldsBuffer = null;
                this.unknownFieldsWriter = null;
            }
            return this.unknownFieldsByteString;
        }

        public final Builder<M, B> clearUnknownFields() {
            Builder<M, B> builder = this;
            builder.setUnknownFieldsByteString$wire_runtime(ByteString.EMPTY);
            if (builder.getUnknownFieldsBuffer$wire_runtime() != null) {
                Buffer unknownFieldsBuffer$wire_runtime = builder.getUnknownFieldsBuffer$wire_runtime();
                Intrinsics.a(unknownFieldsBuffer$wire_runtime);
                unknownFieldsBuffer$wire_runtime.clear();
                builder.setUnknownFieldsBuffer$wire_runtime(null);
            }
            builder.setUnknownFieldsWriter$wire_runtime(null);
            return builder;
        }

        public final Buffer getUnknownFieldsBuffer$wire_runtime() {
            return this.unknownFieldsBuffer;
        }

        public final ByteString getUnknownFieldsByteString$wire_runtime() {
            return this.unknownFieldsByteString;
        }

        public final ProtoWriter getUnknownFieldsWriter$wire_runtime() {
            return this.unknownFieldsWriter;
        }

        public final void setUnknownFieldsBuffer$wire_runtime(Buffer buffer) {
            this.unknownFieldsBuffer = buffer;
        }

        public final void setUnknownFieldsByteString$wire_runtime(ByteString byteString) {
            Intrinsics.e(byteString, "<set-?>");
            this.unknownFieldsByteString = byteString;
        }

        public final void setUnknownFieldsWriter$wire_runtime(ProtoWriter protoWriter) {
            this.unknownFieldsWriter = protoWriter;
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/Message$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Message(ProtoAdapter<M> adapter, ByteString unknownFields) {
        Intrinsics.e(adapter, "adapter");
        Intrinsics.e(unknownFields, "unknownFields");
        this.adapter = adapter;
        this.unknownFields = unknownFields;
    }

    public final ProtoAdapter<M> adapter() {
        return this.adapter;
    }

    public final void encode(OutputStream stream) throws IOException {
        Intrinsics.e(stream, "stream");
        this.adapter.encode(stream, (OutputStream) this);
    }

    public final void encode(BufferedSink sink) throws IOException {
        Intrinsics.e(sink, "sink");
        this.adapter.encode(sink, (BufferedSink) this);
    }

    public final byte[] encode() {
        return this.adapter.encode(this);
    }

    public final ByteString encodeByteString() {
        return this.adapter.encodeByteString(this);
    }

    public final int getCachedSerializedSize$wire_runtime() {
        return this.cachedSerializedSize;
    }

    public abstract B newBuilder();

    public final void setCachedSerializedSize$wire_runtime(int i) {
        this.cachedSerializedSize = i;
    }

    public String toString() {
        return this.adapter.toString(this);
    }

    public final ByteString unknownFields() {
        ByteString byteString = this.unknownFields;
        ByteString byteString2 = byteString;
        if (byteString == null) {
            byteString2 = ByteString.EMPTY;
        }
        return byteString2;
    }

    public final M withoutUnknownFields() {
        return newBuilder().clearUnknownFields().build();
    }

    protected final Object writeReplace() throws ObjectStreamException {
        return new MessageSerializedForm(encode(), getClass());
    }
}
