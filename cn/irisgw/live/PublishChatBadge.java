package cn.irisgw.live;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PublishChatBadge.class */
public final class PublishChatBadge extends GeneratedMessageV3 implements PublishChatBadgeOrBuilder {
    public static final int CHAT_BADGE_HEIGHT_FIELD_NUMBER = 4;
    public static final int CHAT_BADGE_ID_FIELD_NUMBER = 1;
    public static final int CHAT_BADGE_LENGTH_FIELD_NUMBER = 3;
    public static final int CHAT_BADGE_URL_FIELD_NUMBER = 2;
    private static final PublishChatBadge DEFAULT_INSTANCE = new PublishChatBadge();
    private static final Parser<PublishChatBadge> PARSER = new AbstractParser<PublishChatBadge>() { // from class: cn.irisgw.live.PublishChatBadge.1
        @Override // com.google.protobuf.Parser
        public PublishChatBadge parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new PublishChatBadge(codedInputStream, extensionRegistryLite);
        }
    };
    private static final long serialVersionUID = 0;
    private int chatBadgeHeight_;
    private int chatBadgeId_;
    private int chatBadgeLength_;
    private volatile Object chatBadgeUrl_;
    private byte memoizedIsInitialized;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PublishChatBadge$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PublishChatBadgeOrBuilder {
        private int chatBadgeHeight_;
        private int chatBadgeId_;
        private int chatBadgeLength_;
        private Object chatBadgeUrl_;

        private Builder() {
            this.chatBadgeUrl_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.chatBadgeUrl_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_PublishChatBadge_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = PublishChatBadge.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PublishChatBadge build() {
            PublishChatBadge buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PublishChatBadge buildPartial() {
            PublishChatBadge publishChatBadge = new PublishChatBadge(this);
            publishChatBadge.chatBadgeId_ = this.chatBadgeId_;
            publishChatBadge.chatBadgeUrl_ = this.chatBadgeUrl_;
            publishChatBadge.chatBadgeLength_ = this.chatBadgeLength_;
            publishChatBadge.chatBadgeHeight_ = this.chatBadgeHeight_;
            onBuilt();
            return publishChatBadge;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.chatBadgeId_ = 0;
            this.chatBadgeUrl_ = "";
            this.chatBadgeLength_ = 0;
            this.chatBadgeHeight_ = 0;
            return this;
        }

        public Builder clearChatBadgeHeight() {
            this.chatBadgeHeight_ = 0;
            onChanged();
            return this;
        }

        public Builder clearChatBadgeId() {
            this.chatBadgeId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearChatBadgeLength() {
            this.chatBadgeLength_ = 0;
            onChanged();
            return this;
        }

        public Builder clearChatBadgeUrl() {
            this.chatBadgeUrl_ = PublishChatBadge.getDefaultInstance().getChatBadgeUrl();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.PublishChatBadgeOrBuilder
        public int getChatBadgeHeight() {
            return this.chatBadgeHeight_;
        }

        @Override // cn.irisgw.live.PublishChatBadgeOrBuilder
        public int getChatBadgeId() {
            return this.chatBadgeId_;
        }

        @Override // cn.irisgw.live.PublishChatBadgeOrBuilder
        public int getChatBadgeLength() {
            return this.chatBadgeLength_;
        }

        @Override // cn.irisgw.live.PublishChatBadgeOrBuilder
        public String getChatBadgeUrl() {
            Object obj = this.chatBadgeUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatBadgeUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.PublishChatBadgeOrBuilder
        public ByteString getChatBadgeUrlBytes() {
            Object obj = this.chatBadgeUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatBadgeUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PublishChatBadge getDefaultInstanceForType() {
            return PublishChatBadge.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_PublishChatBadge_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_PublishChatBadge_fieldAccessorTable.ensureFieldAccessorsInitialized(PublishChatBadge.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(PublishChatBadge publishChatBadge) {
            if (publishChatBadge == PublishChatBadge.getDefaultInstance()) {
                return this;
            }
            if (publishChatBadge.getChatBadgeId() != 0) {
                setChatBadgeId(publishChatBadge.getChatBadgeId());
            }
            if (!publishChatBadge.getChatBadgeUrl().isEmpty()) {
                this.chatBadgeUrl_ = publishChatBadge.chatBadgeUrl_;
                onChanged();
            }
            if (publishChatBadge.getChatBadgeLength() != 0) {
                setChatBadgeLength(publishChatBadge.getChatBadgeLength());
            }
            if (publishChatBadge.getChatBadgeHeight() != 0) {
                setChatBadgeHeight(publishChatBadge.getChatBadgeHeight());
            }
            mergeUnknownFields(publishChatBadge.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.PublishChatBadge.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.PublishChatBadge.access$900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.PublishChatBadge r0 = (cn.irisgw.live.PublishChatBadge) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.PublishChatBadge$Builder r0 = r0.mergeFrom(r1)
            L1a:
                r0 = r4
                return r0
            L1c:
                r6 = move-exception
                r0 = r7
                r5 = r0
                goto L31
            L22:
                r6 = move-exception
                r0 = r6
                com.google.protobuf.MessageLite r0 = r0.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L1c
                cn.irisgw.live.PublishChatBadge r0 = (cn.irisgw.live.PublishChatBadge) r0     // Catch: java.lang.Throwable -> L1c
                r5 = r0
                r0 = r6
                java.io.IOException r0 = r0.unwrapIOException()     // Catch: java.lang.Throwable -> L30
                throw r0     // Catch: java.lang.Throwable -> L30
            L30:
                r6 = move-exception
            L31:
                r0 = r5
                if (r0 == 0) goto L3b
                r0 = r4
                r1 = r5
                cn.irisgw.live.PublishChatBadge$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.PublishChatBadge.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.PublishChatBadge$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof PublishChatBadge) {
                return mergeFrom((PublishChatBadge) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setChatBadgeHeight(int i) {
            this.chatBadgeHeight_ = i;
            onChanged();
            return this;
        }

        public Builder setChatBadgeId(int i) {
            this.chatBadgeId_ = i;
            onChanged();
            return this;
        }

        public Builder setChatBadgeLength(int i) {
            this.chatBadgeLength_ = i;
            onChanged();
            return this;
        }

        public Builder setChatBadgeUrl(String str) {
            if (str != null) {
                this.chatBadgeUrl_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setChatBadgeUrlBytes(ByteString byteString) {
            if (byteString != null) {
                PublishChatBadge.checkByteStringIsUtf8(byteString);
                this.chatBadgeUrl_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private PublishChatBadge() {
        this.memoizedIsInitialized = (byte) -1;
        this.chatBadgeUrl_ = "";
    }

    private PublishChatBadge(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        if (extensionRegistryLite == null) {
            throw null;
        }
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.chatBadgeId_ = codedInputStream.readInt32();
                        } else if (readTag == 18) {
                            this.chatBadgeUrl_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 24) {
                            this.chatBadgeLength_ = codedInputStream.readInt32();
                        } else if (readTag == 32) {
                            this.chatBadgeHeight_ = codedInputStream.readInt32();
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                }
            } finally {
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    private PublishChatBadge(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static PublishChatBadge getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_PublishChatBadge_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(PublishChatBadge publishChatBadge) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(publishChatBadge);
    }

    public static PublishChatBadge parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PublishChatBadge) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PublishChatBadge parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PublishChatBadge) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PublishChatBadge parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static PublishChatBadge parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PublishChatBadge parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PublishChatBadge) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static PublishChatBadge parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PublishChatBadge) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static PublishChatBadge parseFrom(InputStream inputStream) throws IOException {
        return (PublishChatBadge) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static PublishChatBadge parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PublishChatBadge) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PublishChatBadge parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static PublishChatBadge parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PublishChatBadge parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static PublishChatBadge parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<PublishChatBadge> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PublishChatBadge) {
            PublishChatBadge publishChatBadge = (PublishChatBadge) obj;
            return getChatBadgeId() == publishChatBadge.getChatBadgeId() && getChatBadgeUrl().equals(publishChatBadge.getChatBadgeUrl()) && getChatBadgeLength() == publishChatBadge.getChatBadgeLength() && getChatBadgeHeight() == publishChatBadge.getChatBadgeHeight() && this.unknownFields.equals(publishChatBadge.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.PublishChatBadgeOrBuilder
    public int getChatBadgeHeight() {
        return this.chatBadgeHeight_;
    }

    @Override // cn.irisgw.live.PublishChatBadgeOrBuilder
    public int getChatBadgeId() {
        return this.chatBadgeId_;
    }

    @Override // cn.irisgw.live.PublishChatBadgeOrBuilder
    public int getChatBadgeLength() {
        return this.chatBadgeLength_;
    }

    @Override // cn.irisgw.live.PublishChatBadgeOrBuilder
    public String getChatBadgeUrl() {
        Object obj = this.chatBadgeUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatBadgeUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.PublishChatBadgeOrBuilder
    public ByteString getChatBadgeUrlBytes() {
        Object obj = this.chatBadgeUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatBadgeUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PublishChatBadge getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PublishChatBadge> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.chatBadgeId_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeInt32Size(1, i3);
        }
        int i4 = i2;
        if (!getChatBadgeUrlBytes().isEmpty()) {
            i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.chatBadgeUrl_);
        }
        int i5 = this.chatBadgeLength_;
        int i6 = i4;
        if (i5 != 0) {
            i6 = i4 + CodedOutputStream.computeInt32Size(3, i5);
        }
        int i7 = this.chatBadgeHeight_;
        int i8 = i6;
        if (i7 != 0) {
            i8 = i6 + CodedOutputStream.computeInt32Size(4, i7);
        }
        int serializedSize = i8 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getChatBadgeId()) * 37) + 2) * 53) + getChatBadgeUrl().hashCode()) * 37) + 3) * 53) + getChatBadgeLength()) * 37) + 4) * 53) + getChatBadgeHeight()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_PublishChatBadge_fieldAccessorTable.ensureFieldAccessorsInitialized(PublishChatBadge.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new PublishChatBadge();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.chatBadgeId_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        if (!getChatBadgeUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.chatBadgeUrl_);
        }
        int i2 = this.chatBadgeLength_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(3, i2);
        }
        int i3 = this.chatBadgeHeight_;
        if (i3 != 0) {
            codedOutputStream.writeInt32(4, i3);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
