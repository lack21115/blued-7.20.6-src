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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/BluedChatContent.class */
public final class BluedChatContent extends GeneratedMessageV3 implements BluedChatContentOrBuilder {
    public static final int CONTENT_FIELD_NUMBER = 1;
    public static final int LIMIT_TYPE_FIELD_NUMBER = 4;
    public static final int LINK_FIELD_NUMBER = 2;
    public static final int LINK_TYPE_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private volatile Object content_;
    private volatile Object limitType_;
    private int linkType_;
    private volatile Object link_;
    private byte memoizedIsInitialized;
    private static final BluedChatContent DEFAULT_INSTANCE = new BluedChatContent();
    private static final Parser<BluedChatContent> PARSER = new AbstractParser<BluedChatContent>() { // from class: cn.irisgw.live.BluedChatContent.1
        @Override // com.google.protobuf.Parser
        public BluedChatContent parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new BluedChatContent(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/BluedChatContent$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BluedChatContentOrBuilder {
        private Object content_;
        private Object limitType_;
        private int linkType_;
        private Object link_;

        private Builder() {
            this.content_ = "";
            this.link_ = "";
            this.limitType_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.content_ = "";
            this.link_ = "";
            this.limitType_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_BluedChatContent_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = BluedChatContent.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BluedChatContent build() {
            BluedChatContent buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BluedChatContent buildPartial() {
            BluedChatContent bluedChatContent = new BluedChatContent(this);
            bluedChatContent.content_ = this.content_;
            bluedChatContent.link_ = this.link_;
            bluedChatContent.linkType_ = this.linkType_;
            bluedChatContent.limitType_ = this.limitType_;
            onBuilt();
            return bluedChatContent;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.content_ = "";
            this.link_ = "";
            this.linkType_ = 0;
            this.limitType_ = "";
            return this;
        }

        public Builder clearContent() {
            this.content_ = BluedChatContent.getDefaultInstance().getContent();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearLimitType() {
            this.limitType_ = BluedChatContent.getDefaultInstance().getLimitType();
            onChanged();
            return this;
        }

        public Builder clearLink() {
            this.link_ = BluedChatContent.getDefaultInstance().getLink();
            onChanged();
            return this;
        }

        public Builder clearLinkType() {
            this.linkType_ = 0;
            onChanged();
            return this;
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

        @Override // cn.irisgw.live.BluedChatContentOrBuilder
        public String getContent() {
            Object obj = this.content_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.content_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.BluedChatContentOrBuilder
        public ByteString getContentBytes() {
            Object obj = this.content_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.content_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BluedChatContent getDefaultInstanceForType() {
            return BluedChatContent.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_BluedChatContent_descriptor;
        }

        @Override // cn.irisgw.live.BluedChatContentOrBuilder
        public String getLimitType() {
            Object obj = this.limitType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.limitType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.BluedChatContentOrBuilder
        public ByteString getLimitTypeBytes() {
            Object obj = this.limitType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.limitType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.BluedChatContentOrBuilder
        public String getLink() {
            Object obj = this.link_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.link_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.BluedChatContentOrBuilder
        public ByteString getLinkBytes() {
            Object obj = this.link_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.link_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.BluedChatContentOrBuilder
        public int getLinkType() {
            return this.linkType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_BluedChatContent_fieldAccessorTable.ensureFieldAccessorsInitialized(BluedChatContent.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(BluedChatContent bluedChatContent) {
            if (bluedChatContent == BluedChatContent.getDefaultInstance()) {
                return this;
            }
            if (!bluedChatContent.getContent().isEmpty()) {
                this.content_ = bluedChatContent.content_;
                onChanged();
            }
            if (!bluedChatContent.getLink().isEmpty()) {
                this.link_ = bluedChatContent.link_;
                onChanged();
            }
            if (bluedChatContent.getLinkType() != 0) {
                setLinkType(bluedChatContent.getLinkType());
            }
            if (!bluedChatContent.getLimitType().isEmpty()) {
                this.limitType_ = bluedChatContent.limitType_;
                onChanged();
            }
            mergeUnknownFields(bluedChatContent.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.BluedChatContent.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.BluedChatContent.access$900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.BluedChatContent r0 = (cn.irisgw.live.BluedChatContent) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.BluedChatContent$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.BluedChatContent r0 = (cn.irisgw.live.BluedChatContent) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.BluedChatContent$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.BluedChatContent.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.BluedChatContent$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof BluedChatContent) {
                return mergeFrom((BluedChatContent) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setContent(String str) {
            if (str != null) {
                this.content_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setContentBytes(ByteString byteString) {
            if (byteString != null) {
                BluedChatContent.checkByteStringIsUtf8(byteString);
                this.content_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setLimitType(String str) {
            if (str != null) {
                this.limitType_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLimitTypeBytes(ByteString byteString) {
            if (byteString != null) {
                BluedChatContent.checkByteStringIsUtf8(byteString);
                this.limitType_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLink(String str) {
            if (str != null) {
                this.link_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLinkBytes(ByteString byteString) {
            if (byteString != null) {
                BluedChatContent.checkByteStringIsUtf8(byteString);
                this.link_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLinkType(int i) {
            this.linkType_ = i;
            onChanged();
            return this;
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

    private BluedChatContent() {
        this.memoizedIsInitialized = (byte) -1;
        this.content_ = "";
        this.link_ = "";
        this.limitType_ = "";
    }

    private BluedChatContent(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        if (readTag == 10) {
                            this.content_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 18) {
                            this.link_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 24) {
                            this.linkType_ = codedInputStream.readInt32();
                        } else if (readTag == 34) {
                            this.limitType_ = codedInputStream.readStringRequireUtf8();
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

    private BluedChatContent(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static BluedChatContent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_BluedChatContent_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(BluedChatContent bluedChatContent) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(bluedChatContent);
    }

    public static BluedChatContent parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (BluedChatContent) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static BluedChatContent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BluedChatContent) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static BluedChatContent parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static BluedChatContent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static BluedChatContent parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (BluedChatContent) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static BluedChatContent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BluedChatContent) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static BluedChatContent parseFrom(InputStream inputStream) throws IOException {
        return (BluedChatContent) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static BluedChatContent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BluedChatContent) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static BluedChatContent parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static BluedChatContent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static BluedChatContent parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static BluedChatContent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<BluedChatContent> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BluedChatContent) {
            BluedChatContent bluedChatContent = (BluedChatContent) obj;
            return getContent().equals(bluedChatContent.getContent()) && getLink().equals(bluedChatContent.getLink()) && getLinkType() == bluedChatContent.getLinkType() && getLimitType().equals(bluedChatContent.getLimitType()) && this.unknownFields.equals(bluedChatContent.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.BluedChatContentOrBuilder
    public String getContent() {
        Object obj = this.content_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.content_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.BluedChatContentOrBuilder
    public ByteString getContentBytes() {
        Object obj = this.content_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.content_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public BluedChatContent getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.BluedChatContentOrBuilder
    public String getLimitType() {
        Object obj = this.limitType_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.limitType_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.BluedChatContentOrBuilder
    public ByteString getLimitTypeBytes() {
        Object obj = this.limitType_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.limitType_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.BluedChatContentOrBuilder
    public String getLink() {
        Object obj = this.link_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.link_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.BluedChatContentOrBuilder
    public ByteString getLinkBytes() {
        Object obj = this.link_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.link_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.BluedChatContentOrBuilder
    public int getLinkType() {
        return this.linkType_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<BluedChatContent> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!getContentBytes().isEmpty()) {
            i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.content_);
        }
        int i3 = i2;
        if (!getLinkBytes().isEmpty()) {
            i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.link_);
        }
        int i4 = this.linkType_;
        int i5 = i3;
        if (i4 != 0) {
            i5 = i3 + CodedOutputStream.computeInt32Size(3, i4);
        }
        int i6 = i5;
        if (!getLimitTypeBytes().isEmpty()) {
            i6 = i5 + GeneratedMessageV3.computeStringSize(4, this.limitType_);
        }
        int serializedSize = i6 + this.unknownFields.getSerializedSize();
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
        int hashCode = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getContent().hashCode()) * 37) + 2) * 53) + getLink().hashCode()) * 37) + 3) * 53) + getLinkType()) * 37) + 4) * 53) + getLimitType().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_BluedChatContent_fieldAccessorTable.ensureFieldAccessorsInitialized(BluedChatContent.class, Builder.class);
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
        return new BluedChatContent();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getContentBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.content_);
        }
        if (!getLinkBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.link_);
        }
        int i = this.linkType_;
        if (i != 0) {
            codedOutputStream.writeInt32(3, i);
        }
        if (!getLimitTypeBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.limitType_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
