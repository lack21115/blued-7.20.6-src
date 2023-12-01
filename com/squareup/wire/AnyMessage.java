package com.squareup.wire;

import com.squareup.wire.Message;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/AnyMessage.class */
public final class AnyMessage extends Message {
    public static final ProtoAdapter<AnyMessage> ADAPTER;
    public static final Companion Companion = new Companion(null);
    private final String typeUrl;
    private final ByteString value;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/AnyMessage$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AnyMessage pack(Message<?, ?> message) {
            Intrinsics.e(message, "message");
            String typeUrl = message.adapter().getTypeUrl();
            if (typeUrl != null) {
                return new AnyMessage(typeUrl, message.encodeByteString());
            }
            throw new IllegalStateException(("recompile " + Reflection.b(message.getClass()) + " to use it with AnyMessage").toString());
        }
    }

    static {
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass b = Reflection.b(AnyMessage.class);
        final Syntax syntax = Syntax.PROTO_3;
        ADAPTER = new ProtoAdapter<AnyMessage>(fieldEncoding, b, syntax) { // from class: com.squareup.wire.AnyMessage$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AnyMessage decode(ProtoReader protoReader) {
                Intrinsics.e(protoReader, "reader");
                ByteString byteString = ByteString.EMPTY;
                long beginMessage = protoReader.beginMessage();
                String str = "";
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag == -1) {
                        protoReader.endMessageAndGetUnknownFields(beginMessage);
                        return new AnyMessage(str, byteString);
                    } else if (nextTag == 1) {
                        str = ProtoAdapter.STRING.decode(protoReader);
                    } else if (nextTag != 2) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        byteString = ProtoAdapter.BYTES.decode(protoReader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, AnyMessage anyMessage) {
                Intrinsics.e(protoWriter, "writer");
                Intrinsics.e(anyMessage, "value");
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, (int) anyMessage.getTypeUrl());
                ProtoAdapter.BYTES.encodeWithTag(protoWriter, 2, (int) anyMessage.getValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ReverseProtoWriter reverseProtoWriter, AnyMessage anyMessage) {
                Intrinsics.e(reverseProtoWriter, "writer");
                Intrinsics.e(anyMessage, "value");
                ProtoAdapter.BYTES.encodeWithTag(reverseProtoWriter, 2, (int) anyMessage.getValue());
                ProtoAdapter.STRING.encodeWithTag(reverseProtoWriter, 1, (int) anyMessage.getTypeUrl());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(AnyMessage anyMessage) {
                Intrinsics.e(anyMessage, "value");
                return ProtoAdapter.STRING.encodedSizeWithTag(1, anyMessage.getTypeUrl()) + ProtoAdapter.BYTES.encodedSizeWithTag(2, anyMessage.getValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public AnyMessage redact(AnyMessage anyMessage) {
                Intrinsics.e(anyMessage, "value");
                return new AnyMessage("square.github.io/wire/redacted", ByteString.EMPTY);
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnyMessage(String str, ByteString byteString) {
        super(ADAPTER, ByteString.EMPTY);
        Intrinsics.e(str, "typeUrl");
        Intrinsics.e(byteString, "value");
        this.typeUrl = str;
        this.value = byteString;
    }

    public /* synthetic */ AnyMessage(String str, ByteString byteString, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? ByteString.EMPTY : byteString);
    }

    public static /* synthetic */ AnyMessage copy$default(AnyMessage anyMessage, String str, ByteString byteString, int i, Object obj) {
        if ((i & 1) != 0) {
            str = anyMessage.typeUrl;
        }
        if ((i & 2) != 0) {
            byteString = anyMessage.value;
        }
        return anyMessage.copy(str, byteString);
    }

    public final AnyMessage copy(String str, ByteString byteString) {
        Intrinsics.e(str, "typeUrl");
        Intrinsics.e(byteString, "value");
        return new AnyMessage(str, byteString);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AnyMessage) {
            AnyMessage anyMessage = (AnyMessage) obj;
            return Intrinsics.a(this.typeUrl, anyMessage.typeUrl) && Intrinsics.a(this.value, anyMessage.value);
        }
        return false;
    }

    public final String getTypeUrl() {
        return this.typeUrl;
    }

    public final ByteString getValue() {
        return this.value;
    }

    public int hashCode() {
        int i = this.hashCode;
        int i2 = i;
        if (i == 0) {
            i2 = (((i * 37) + this.typeUrl.hashCode()) * 37) + this.value.hashCode();
            this.hashCode = i2;
        }
        return i2;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return (Message.Builder) m6691newBuilder();
    }

    @Deprecated
    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m6691newBuilder() {
        throw new AssertionError();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return "Any{type_url=" + this.typeUrl + ", value=" + this.value + '}';
    }

    public final <T> T unpack(ProtoAdapter<T> protoAdapter) {
        Intrinsics.e(protoAdapter, "adapter");
        if (Intrinsics.a(this.typeUrl, protoAdapter.getTypeUrl())) {
            return protoAdapter.decode(this.value);
        }
        throw new IllegalStateException(("type mismatch: " + getTypeUrl() + " != " + ((Object) protoAdapter.getTypeUrl())).toString());
    }

    public final <T> T unpackOrNull(ProtoAdapter<T> protoAdapter) {
        Intrinsics.e(protoAdapter, "adapter");
        if (Intrinsics.a(this.typeUrl, protoAdapter.getTypeUrl())) {
            return protoAdapter.decode(this.value);
        }
        return null;
    }
}
