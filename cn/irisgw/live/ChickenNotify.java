package cn.irisgw.live;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChickenNotify.class */
public final class ChickenNotify extends GeneratedMessageV3 implements ChickenNotifyOrBuilder {
    public static final int HIDE_FIELD_NUMBER = 3;
    public static final int LINK_HALF_OPEN_FIELD_NUMBER = 5;
    public static final int LINK_URL_FIELD_NUMBER = 4;
    public static final int MSG_FIELD_NUMBER = 7;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int RESULT_FIELD_NUMBER = 6;
    public static final int UID_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private boolean hide_;
    private boolean linkHalfOpen_;
    private volatile Object linkUrl_;
    private byte memoizedIsInitialized;
    private volatile Object msg_;
    private volatile Object name_;
    private int result_;
    private int uid_;
    private static final ChickenNotify DEFAULT_INSTANCE = new ChickenNotify();
    private static final Parser<ChickenNotify> PARSER = new AbstractParser<ChickenNotify>() { // from class: cn.irisgw.live.ChickenNotify.1
        @Override // com.google.protobuf.Parser
        public ChickenNotify parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ChickenNotify(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChickenNotify$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChickenNotifyOrBuilder {
        private boolean hide_;
        private boolean linkHalfOpen_;
        private Object linkUrl_;
        private Object msg_;
        private Object name_;
        private int result_;
        private int uid_;

        private Builder() {
            this.name_ = "";
            this.linkUrl_ = "";
            this.msg_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.linkUrl_ = "";
            this.msg_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_ChickenNotify_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = ChickenNotify.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ChickenNotify build() {
            ChickenNotify buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ChickenNotify buildPartial() {
            ChickenNotify chickenNotify = new ChickenNotify(this);
            chickenNotify.name_ = this.name_;
            chickenNotify.uid_ = this.uid_;
            chickenNotify.hide_ = this.hide_;
            chickenNotify.linkUrl_ = this.linkUrl_;
            chickenNotify.linkHalfOpen_ = this.linkHalfOpen_;
            chickenNotify.result_ = this.result_;
            chickenNotify.msg_ = this.msg_;
            onBuilt();
            return chickenNotify;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.name_ = "";
            this.uid_ = 0;
            this.hide_ = false;
            this.linkUrl_ = "";
            this.linkHalfOpen_ = false;
            this.result_ = 0;
            this.msg_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearHide() {
            this.hide_ = false;
            onChanged();
            return this;
        }

        public Builder clearLinkHalfOpen() {
            this.linkHalfOpen_ = false;
            onChanged();
            return this;
        }

        public Builder clearLinkUrl() {
            this.linkUrl_ = ChickenNotify.getDefaultInstance().getLinkUrl();
            onChanged();
            return this;
        }

        public Builder clearMsg() {
            this.msg_ = ChickenNotify.getDefaultInstance().getMsg();
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = ChickenNotify.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearResult() {
            this.result_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUid() {
            this.uid_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChickenNotify getDefaultInstanceForType() {
            return ChickenNotify.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_ChickenNotify_descriptor;
        }

        @Override // cn.irisgw.live.ChickenNotifyOrBuilder
        public boolean getHide() {
            return this.hide_;
        }

        @Override // cn.irisgw.live.ChickenNotifyOrBuilder
        public boolean getLinkHalfOpen() {
            return this.linkHalfOpen_;
        }

        @Override // cn.irisgw.live.ChickenNotifyOrBuilder
        public String getLinkUrl() {
            Object obj = this.linkUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.linkUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ChickenNotifyOrBuilder
        public ByteString getLinkUrlBytes() {
            Object obj = this.linkUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.linkUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ChickenNotifyOrBuilder
        public String getMsg() {
            Object obj = this.msg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.msg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ChickenNotifyOrBuilder
        public ByteString getMsgBytes() {
            Object obj = this.msg_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.msg_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ChickenNotifyOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ChickenNotifyOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ChickenNotifyOrBuilder
        public int getResult() {
            return this.result_;
        }

        @Override // cn.irisgw.live.ChickenNotifyOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ChickenNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ChickenNotify.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ChickenNotify chickenNotify) {
            if (chickenNotify == ChickenNotify.getDefaultInstance()) {
                return this;
            }
            if (!chickenNotify.getName().isEmpty()) {
                this.name_ = chickenNotify.name_;
                onChanged();
            }
            if (chickenNotify.getUid() != 0) {
                setUid(chickenNotify.getUid());
            }
            if (chickenNotify.getHide()) {
                setHide(chickenNotify.getHide());
            }
            if (!chickenNotify.getLinkUrl().isEmpty()) {
                this.linkUrl_ = chickenNotify.linkUrl_;
                onChanged();
            }
            if (chickenNotify.getLinkHalfOpen()) {
                setLinkHalfOpen(chickenNotify.getLinkHalfOpen());
            }
            if (chickenNotify.getResult() != 0) {
                setResult(chickenNotify.getResult());
            }
            if (!chickenNotify.getMsg().isEmpty()) {
                this.msg_ = chickenNotify.msg_;
                onChanged();
            }
            mergeUnknownFields(chickenNotify.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.ChickenNotify.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.ChickenNotify.access$1200()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.ChickenNotify r0 = (cn.irisgw.live.ChickenNotify) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.ChickenNotify$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.ChickenNotify r0 = (cn.irisgw.live.ChickenNotify) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.ChickenNotify$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ChickenNotify.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ChickenNotify$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof ChickenNotify) {
                return mergeFrom((ChickenNotify) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setHide(boolean z) {
            this.hide_ = z;
            onChanged();
            return this;
        }

        public Builder setLinkHalfOpen(boolean z) {
            this.linkHalfOpen_ = z;
            onChanged();
            return this;
        }

        public Builder setLinkUrl(String str) {
            if (str != null) {
                this.linkUrl_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLinkUrlBytes(ByteString byteString) {
            if (byteString != null) {
                ChickenNotify.checkByteStringIsUtf8(byteString);
                this.linkUrl_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setMsg(String str) {
            if (str != null) {
                this.msg_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setMsgBytes(ByteString byteString) {
            if (byteString != null) {
                ChickenNotify.checkByteStringIsUtf8(byteString);
                this.msg_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setName(String str) {
            if (str != null) {
                this.name_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setNameBytes(ByteString byteString) {
            if (byteString != null) {
                ChickenNotify.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setResult(int i) {
            this.result_ = i;
            onChanged();
            return this;
        }

        public Builder setUid(int i) {
            this.uid_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private ChickenNotify() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.linkUrl_ = "";
        this.msg_ = "";
    }

    private ChickenNotify(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        if (extensionRegistryLite == null) {
            throw null;
        }
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        while (!z) {
            try {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 16) {
                                this.uid_ = codedInputStream.readUInt32();
                            } else if (readTag == 24) {
                                this.hide_ = codedInputStream.readBool();
                            } else if (readTag == 34) {
                                this.linkUrl_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 40) {
                                this.linkHalfOpen_ = codedInputStream.readBool();
                            } else if (readTag == 48) {
                                this.result_ = codedInputStream.readUInt32();
                            } else if (readTag == 58) {
                                this.msg_ = codedInputStream.readStringRequireUtf8();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    }
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                }
            } finally {
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    private ChickenNotify(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ChickenNotify getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_ChickenNotify_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ChickenNotify chickenNotify) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(chickenNotify);
    }

    public static ChickenNotify parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ChickenNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ChickenNotify parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChickenNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ChickenNotify parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static ChickenNotify parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ChickenNotify parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ChickenNotify) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ChickenNotify parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChickenNotify) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static ChickenNotify parseFrom(InputStream inputStream) throws IOException {
        return (ChickenNotify) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ChickenNotify parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChickenNotify) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ChickenNotify parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static ChickenNotify parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ChickenNotify parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static ChickenNotify parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<ChickenNotify> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChickenNotify) {
            ChickenNotify chickenNotify = (ChickenNotify) obj;
            return getName().equals(chickenNotify.getName()) && getUid() == chickenNotify.getUid() && getHide() == chickenNotify.getHide() && getLinkUrl().equals(chickenNotify.getLinkUrl()) && getLinkHalfOpen() == chickenNotify.getLinkHalfOpen() && getResult() == chickenNotify.getResult() && getMsg().equals(chickenNotify.getMsg()) && this.unknownFields.equals(chickenNotify.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ChickenNotify getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.ChickenNotifyOrBuilder
    public boolean getHide() {
        return this.hide_;
    }

    @Override // cn.irisgw.live.ChickenNotifyOrBuilder
    public boolean getLinkHalfOpen() {
        return this.linkHalfOpen_;
    }

    @Override // cn.irisgw.live.ChickenNotifyOrBuilder
    public String getLinkUrl() {
        Object obj = this.linkUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.linkUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ChickenNotifyOrBuilder
    public ByteString getLinkUrlBytes() {
        Object obj = this.linkUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.linkUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.ChickenNotifyOrBuilder
    public String getMsg() {
        Object obj = this.msg_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.msg_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ChickenNotifyOrBuilder
    public ByteString getMsgBytes() {
        Object obj = this.msg_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.msg_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.ChickenNotifyOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ChickenNotifyOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ChickenNotify> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.ChickenNotifyOrBuilder
    public int getResult() {
        return this.result_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!getNameBytes().isEmpty()) {
            i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
        }
        int i3 = this.uid_;
        int i4 = i2;
        if (i3 != 0) {
            i4 = i2 + CodedOutputStream.computeUInt32Size(2, i3);
        }
        boolean z = this.hide_;
        int i5 = i4;
        if (z) {
            i5 = i4 + CodedOutputStream.computeBoolSize(3, z);
        }
        int i6 = i5;
        if (!getLinkUrlBytes().isEmpty()) {
            i6 = i5 + GeneratedMessageV3.computeStringSize(4, this.linkUrl_);
        }
        boolean z2 = this.linkHalfOpen_;
        int i7 = i6;
        if (z2) {
            i7 = i6 + CodedOutputStream.computeBoolSize(5, z2);
        }
        int i8 = this.result_;
        int i9 = i7;
        if (i8 != 0) {
            i9 = i7 + CodedOutputStream.computeUInt32Size(6, i8);
        }
        int i10 = i9;
        if (!getMsgBytes().isEmpty()) {
            i10 = i9 + GeneratedMessageV3.computeStringSize(7, this.msg_);
        }
        int serializedSize = i10 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.ChickenNotifyOrBuilder
    public int getUid() {
        return this.uid_;
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
        int hashCode = ((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getUid()) * 37) + 3) * 53) + Internal.hashBoolean(getHide())) * 37) + 4) * 53) + getLinkUrl().hashCode()) * 37) + 5) * 53) + Internal.hashBoolean(getLinkHalfOpen())) * 37) + 6) * 53) + getResult()) * 37) + 7) * 53) + getMsg().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_ChickenNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ChickenNotify.class, Builder.class);
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
        return new ChickenNotify();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
        }
        int i = this.uid_;
        if (i != 0) {
            codedOutputStream.writeUInt32(2, i);
        }
        boolean z = this.hide_;
        if (z) {
            codedOutputStream.writeBool(3, z);
        }
        if (!getLinkUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.linkUrl_);
        }
        boolean z2 = this.linkHalfOpen_;
        if (z2) {
            codedOutputStream.writeBool(5, z2);
        }
        int i2 = this.result_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(6, i2);
        }
        if (!getMsgBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.msg_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
