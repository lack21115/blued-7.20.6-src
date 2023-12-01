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
            public AnyMessage decode(ProtoReader reader) {
                Intrinsics.e(reader, "reader");
                ByteString byteString = ByteString.EMPTY;
                long beginMessage = reader.beginMessage();
                String str = "";
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag == -1) {
                        reader.endMessageAndGetUnknownFields(beginMessage);
                        return new AnyMessage(str, byteString);
                    } else if (nextTag == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (nextTag != 2) {
                        reader.readUnknownField(nextTag);
                    } else {
                        byteString = ProtoAdapter.BYTES.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter writer, AnyMessage value) {
                Intrinsics.e(writer, "writer");
                Intrinsics.e(value, "value");
                ProtoAdapter.STRING.encodeWithTag(writer, 1, (int) value.getTypeUrl());
                ProtoAdapter.BYTES.encodeWithTag(writer, 2, (int) value.getValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ReverseProtoWriter writer, AnyMessage value) {
                Intrinsics.e(writer, "writer");
                Intrinsics.e(value, "value");
                ProtoAdapter.BYTES.encodeWithTag(writer, 2, (int) value.getValue());
                ProtoAdapter.STRING.encodeWithTag(writer, 1, (int) value.getTypeUrl());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(AnyMessage value) {
                Intrinsics.e(value, "value");
                return ProtoAdapter.STRING.encodedSizeWithTag(1, value.getTypeUrl()) + ProtoAdapter.BYTES.encodedSizeWithTag(2, value.getValue());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public AnyMessage redact(AnyMessage value) {
                Intrinsics.e(value, "value");
                return new AnyMessage("square.github.io/wire/redacted", ByteString.EMPTY);
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnyMessage(String typeUrl, ByteString value) {
        super(ADAPTER, ByteString.EMPTY);
        Intrinsics.e(typeUrl, "typeUrl");
        Intrinsics.e(value, "value");
        this.typeUrl = typeUrl;
        this.value = value;
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

    public final AnyMessage copy(String typeUrl, ByteString value) {
        Intrinsics.e(typeUrl, "typeUrl");
        Intrinsics.e(value, "value");
        return new AnyMessage(typeUrl, value);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AnyMessage) {
            AnyMessage anyMessage = (AnyMessage) obj;
            return Intrinsics.a((Object) this.typeUrl, (Object) anyMessage.typeUrl) && Intrinsics.a(this.value, anyMessage.value);
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
        return (Message.Builder) m9740newBuilder();
    }

    @Deprecated
    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m9740newBuilder() {
        throw new AssertionError();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return "Any{type_url=" + this.typeUrl + ", value=" + this.value + '}';
    }

    public final <T> T unpack(ProtoAdapter<T> adapter) {
        Intrinsics.e(adapter, "adapter");
        if (Intrinsics.a((Object) this.typeUrl, (Object) adapter.getTypeUrl())) {
            return adapter.decode(this.value);
        }
        throw new IllegalStateException(("type mismatch: " + getTypeUrl() + " != " + ((Object) adapter.getTypeUrl())).toString());
    }

    public final <T> T unpackOrNull(ProtoAdapter<T> adapter) {
        Intrinsics.e(adapter, "adapter");
        if (Intrinsics.a((Object) this.typeUrl, (Object) adapter.getTypeUrl())) {
            return adapter.decode(this.value);
        }
        return null;
    }
}
