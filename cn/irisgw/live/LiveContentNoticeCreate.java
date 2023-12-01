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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveContentNoticeCreate.class */
public final class LiveContentNoticeCreate extends GeneratedMessageV3 implements LiveContentNoticeCreateOrBuilder {
    public static final int CONTENT_FIELD_NUMBER = 4;
    public static final int COUNTDOWN_FIELD_NUMBER = 3;
    public static final int COUNT_FIELD_NUMBER = 1;
    public static final int FREQUENCY_FIELD_NUMBER = 6;
    public static final int ID_FIELD_NUMBER = 10;
    public static final int PLATFORM_FIELD_NUMBER = 11;
    public static final int SHOW_TYPE_FIELD_NUMBER = 9;
    public static final int STRATEGY_FIELD_NUMBER = 5;
    public static final int SUB_TYPE_FIELD_NUMBER = 8;
    public static final int TYPE_FIELD_NUMBER = 7;
    public static final int URL_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private volatile Object content_;
    private int count_;
    private int countdown_;
    private int frequency_;
    private int id_;
    private byte memoizedIsInitialized;
    private volatile Object platform_;
    private int showType_;
    private int strategy_;
    private int subType_;
    private int type_;
    private volatile Object url_;
    private static final LiveContentNoticeCreate DEFAULT_INSTANCE = new LiveContentNoticeCreate();
    private static final Parser<LiveContentNoticeCreate> PARSER = new AbstractParser<LiveContentNoticeCreate>() { // from class: cn.irisgw.live.LiveContentNoticeCreate.1
        @Override // com.google.protobuf.Parser
        public LiveContentNoticeCreate parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LiveContentNoticeCreate(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveContentNoticeCreate$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveContentNoticeCreateOrBuilder {
        private Object content_;
        private int count_;
        private int countdown_;
        private int frequency_;
        private int id_;
        private Object platform_;
        private int showType_;
        private int strategy_;
        private int subType_;
        private int type_;
        private Object url_;

        private Builder() {
            this.url_ = "";
            this.content_ = "";
            this.platform_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.url_ = "";
            this.content_ = "";
            this.platform_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveContentNoticeCreate_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = LiveContentNoticeCreate.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LiveContentNoticeCreate build() {
            LiveContentNoticeCreate buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LiveContentNoticeCreate buildPartial() {
            LiveContentNoticeCreate liveContentNoticeCreate = new LiveContentNoticeCreate(this);
            liveContentNoticeCreate.count_ = this.count_;
            liveContentNoticeCreate.url_ = this.url_;
            liveContentNoticeCreate.countdown_ = this.countdown_;
            liveContentNoticeCreate.content_ = this.content_;
            liveContentNoticeCreate.strategy_ = this.strategy_;
            liveContentNoticeCreate.frequency_ = this.frequency_;
            liveContentNoticeCreate.type_ = this.type_;
            liveContentNoticeCreate.subType_ = this.subType_;
            liveContentNoticeCreate.showType_ = this.showType_;
            liveContentNoticeCreate.id_ = this.id_;
            liveContentNoticeCreate.platform_ = this.platform_;
            onBuilt();
            return liveContentNoticeCreate;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.count_ = 0;
            this.url_ = "";
            this.countdown_ = 0;
            this.content_ = "";
            this.strategy_ = 0;
            this.frequency_ = 0;
            this.type_ = 0;
            this.subType_ = 0;
            this.showType_ = 0;
            this.id_ = 0;
            this.platform_ = "";
            return this;
        }

        public Builder clearContent() {
            this.content_ = LiveContentNoticeCreate.getDefaultInstance().getContent();
            onChanged();
            return this;
        }

        public Builder clearCount() {
            this.count_ = 0;
            onChanged();
            return this;
        }

        public Builder clearCountdown() {
            this.countdown_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearFrequency() {
            this.frequency_ = 0;
            onChanged();
            return this;
        }

        public Builder clearId() {
            this.id_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearPlatform() {
            this.platform_ = LiveContentNoticeCreate.getDefaultInstance().getPlatform();
            onChanged();
            return this;
        }

        public Builder clearShowType() {
            this.showType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearStrategy() {
            this.strategy_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSubType() {
            this.subType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearType() {
            this.type_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUrl() {
            this.url_ = LiveContentNoticeCreate.getDefaultInstance().getUrl();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
        public String getContent() {
            Object obj = this.content_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.content_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
        public ByteString getContentBytes() {
            Object obj = this.content_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.content_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
        public int getCount() {
            return this.count_;
        }

        @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
        public int getCountdown() {
            return this.countdown_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LiveContentNoticeCreate getDefaultInstanceForType() {
            return LiveContentNoticeCreate.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveContentNoticeCreate_descriptor;
        }

        @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
        public int getFrequency() {
            return this.frequency_;
        }

        @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
        public String getPlatform() {
            Object obj = this.platform_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.platform_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
        public ByteString getPlatformBytes() {
            Object obj = this.platform_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.platform_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
        public int getShowType() {
            return this.showType_;
        }

        @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
        public int getStrategy() {
            return this.strategy_;
        }

        @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
        public int getSubType() {
            return this.subType_;
        }

        @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveContentNoticeCreate_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveContentNoticeCreate.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(LiveContentNoticeCreate liveContentNoticeCreate) {
            if (liveContentNoticeCreate == LiveContentNoticeCreate.getDefaultInstance()) {
                return this;
            }
            if (liveContentNoticeCreate.getCount() != 0) {
                setCount(liveContentNoticeCreate.getCount());
            }
            if (!liveContentNoticeCreate.getUrl().isEmpty()) {
                this.url_ = liveContentNoticeCreate.url_;
                onChanged();
            }
            if (liveContentNoticeCreate.getCountdown() != 0) {
                setCountdown(liveContentNoticeCreate.getCountdown());
            }
            if (!liveContentNoticeCreate.getContent().isEmpty()) {
                this.content_ = liveContentNoticeCreate.content_;
                onChanged();
            }
            if (liveContentNoticeCreate.getStrategy() != 0) {
                setStrategy(liveContentNoticeCreate.getStrategy());
            }
            if (liveContentNoticeCreate.getFrequency() != 0) {
                setFrequency(liveContentNoticeCreate.getFrequency());
            }
            if (liveContentNoticeCreate.getType() != 0) {
                setType(liveContentNoticeCreate.getType());
            }
            if (liveContentNoticeCreate.getSubType() != 0) {
                setSubType(liveContentNoticeCreate.getSubType());
            }
            if (liveContentNoticeCreate.getShowType() != 0) {
                setShowType(liveContentNoticeCreate.getShowType());
            }
            if (liveContentNoticeCreate.getId() != 0) {
                setId(liveContentNoticeCreate.getId());
            }
            if (!liveContentNoticeCreate.getPlatform().isEmpty()) {
                this.platform_ = liveContentNoticeCreate.platform_;
                onChanged();
            }
            mergeUnknownFields(liveContentNoticeCreate.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LiveContentNoticeCreate.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LiveContentNoticeCreate.access$1600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LiveContentNoticeCreate r0 = (cn.irisgw.live.LiveContentNoticeCreate) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LiveContentNoticeCreate$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LiveContentNoticeCreate r0 = (cn.irisgw.live.LiveContentNoticeCreate) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LiveContentNoticeCreate$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LiveContentNoticeCreate.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LiveContentNoticeCreate$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof LiveContentNoticeCreate) {
                return mergeFrom((LiveContentNoticeCreate) message);
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
                LiveContentNoticeCreate.checkByteStringIsUtf8(byteString);
                this.content_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setCount(int i) {
            this.count_ = i;
            onChanged();
            return this;
        }

        public Builder setCountdown(int i) {
            this.countdown_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setFrequency(int i) {
            this.frequency_ = i;
            onChanged();
            return this;
        }

        public Builder setId(int i) {
            this.id_ = i;
            onChanged();
            return this;
        }

        public Builder setPlatform(String str) {
            if (str != null) {
                this.platform_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPlatformBytes(ByteString byteString) {
            if (byteString != null) {
                LiveContentNoticeCreate.checkByteStringIsUtf8(byteString);
                this.platform_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setShowType(int i) {
            this.showType_ = i;
            onChanged();
            return this;
        }

        public Builder setStrategy(int i) {
            this.strategy_ = i;
            onChanged();
            return this;
        }

        public Builder setSubType(int i) {
            this.subType_ = i;
            onChanged();
            return this;
        }

        public Builder setType(int i) {
            this.type_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public Builder setUrl(String str) {
            if (str != null) {
                this.url_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setUrlBytes(ByteString byteString) {
            if (byteString != null) {
                LiveContentNoticeCreate.checkByteStringIsUtf8(byteString);
                this.url_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }
    }

    private LiveContentNoticeCreate() {
        this.memoizedIsInitialized = (byte) -1;
        this.url_ = "";
        this.content_ = "";
        this.platform_ = "";
    }

    private LiveContentNoticeCreate(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.count_ = codedInputStream.readUInt32();
                                continue;
                            case 18:
                                this.url_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 24:
                                this.countdown_ = codedInputStream.readUInt32();
                                continue;
                            case 34:
                                this.content_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 40:
                                this.strategy_ = codedInputStream.readUInt32();
                                continue;
                            case 48:
                                this.frequency_ = codedInputStream.readUInt32();
                                continue;
                            case 56:
                                this.type_ = codedInputStream.readUInt32();
                                continue;
                            case 64:
                                this.subType_ = codedInputStream.readUInt32();
                                continue;
                            case 72:
                                this.showType_ = codedInputStream.readUInt32();
                                continue;
                            case 80:
                                this.id_ = codedInputStream.readUInt32();
                                continue;
                            case 90:
                                this.platform_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            default:
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    break;
                                } else {
                                    continue;
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

    private LiveContentNoticeCreate(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LiveContentNoticeCreate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LiveContentNoticeCreate_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(LiveContentNoticeCreate liveContentNoticeCreate) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(liveContentNoticeCreate);
    }

    public static LiveContentNoticeCreate parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (LiveContentNoticeCreate) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LiveContentNoticeCreate parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LiveContentNoticeCreate) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LiveContentNoticeCreate parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static LiveContentNoticeCreate parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LiveContentNoticeCreate parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (LiveContentNoticeCreate) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LiveContentNoticeCreate parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LiveContentNoticeCreate) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LiveContentNoticeCreate parseFrom(InputStream inputStream) throws IOException {
        return (LiveContentNoticeCreate) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LiveContentNoticeCreate parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LiveContentNoticeCreate) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LiveContentNoticeCreate parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static LiveContentNoticeCreate parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LiveContentNoticeCreate parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LiveContentNoticeCreate parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LiveContentNoticeCreate> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LiveContentNoticeCreate) {
            LiveContentNoticeCreate liveContentNoticeCreate = (LiveContentNoticeCreate) obj;
            return getCount() == liveContentNoticeCreate.getCount() && getUrl().equals(liveContentNoticeCreate.getUrl()) && getCountdown() == liveContentNoticeCreate.getCountdown() && getContent().equals(liveContentNoticeCreate.getContent()) && getStrategy() == liveContentNoticeCreate.getStrategy() && getFrequency() == liveContentNoticeCreate.getFrequency() && getType() == liveContentNoticeCreate.getType() && getSubType() == liveContentNoticeCreate.getSubType() && getShowType() == liveContentNoticeCreate.getShowType() && getId() == liveContentNoticeCreate.getId() && getPlatform().equals(liveContentNoticeCreate.getPlatform()) && this.unknownFields.equals(liveContentNoticeCreate.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
    public String getContent() {
        Object obj = this.content_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.content_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
    public ByteString getContentBytes() {
        Object obj = this.content_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.content_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
    public int getCount() {
        return this.count_;
    }

    @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
    public int getCountdown() {
        return this.countdown_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public LiveContentNoticeCreate getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
    public int getFrequency() {
        return this.frequency_;
    }

    @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
    public int getId() {
        return this.id_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<LiveContentNoticeCreate> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
    public String getPlatform() {
        Object obj = this.platform_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.platform_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
    public ByteString getPlatformBytes() {
        Object obj = this.platform_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.platform_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.count_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int i4 = i2;
        if (!getUrlBytes().isEmpty()) {
            i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.url_);
        }
        int i5 = this.countdown_;
        int i6 = i4;
        if (i5 != 0) {
            i6 = i4 + CodedOutputStream.computeUInt32Size(3, i5);
        }
        int i7 = i6;
        if (!getContentBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(4, this.content_);
        }
        int i8 = this.strategy_;
        int i9 = i7;
        if (i8 != 0) {
            i9 = i7 + CodedOutputStream.computeUInt32Size(5, i8);
        }
        int i10 = this.frequency_;
        int i11 = i9;
        if (i10 != 0) {
            i11 = i9 + CodedOutputStream.computeUInt32Size(6, i10);
        }
        int i12 = this.type_;
        int i13 = i11;
        if (i12 != 0) {
            i13 = i11 + CodedOutputStream.computeUInt32Size(7, i12);
        }
        int i14 = this.subType_;
        int i15 = i13;
        if (i14 != 0) {
            i15 = i13 + CodedOutputStream.computeUInt32Size(8, i14);
        }
        int i16 = this.showType_;
        int i17 = i15;
        if (i16 != 0) {
            i17 = i15 + CodedOutputStream.computeUInt32Size(9, i16);
        }
        int i18 = this.id_;
        int i19 = i17;
        if (i18 != 0) {
            i19 = i17 + CodedOutputStream.computeUInt32Size(10, i18);
        }
        int i20 = i19;
        if (!getPlatformBytes().isEmpty()) {
            i20 = i19 + GeneratedMessageV3.computeStringSize(11, this.platform_);
        }
        int serializedSize = i20 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
    public int getShowType() {
        return this.showType_;
    }

    @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
    public int getStrategy() {
        return this.strategy_;
    }

    @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
    public int getSubType() {
        return this.subType_;
    }

    @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
    public int getType() {
        return this.type_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LiveContentNoticeCreateOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getCount()) * 37) + 2) * 53) + getUrl().hashCode()) * 37) + 3) * 53) + getCountdown()) * 37) + 4) * 53) + getContent().hashCode()) * 37) + 5) * 53) + getStrategy()) * 37) + 6) * 53) + getFrequency()) * 37) + 7) * 53) + getType()) * 37) + 8) * 53) + getSubType()) * 37) + 9) * 53) + getShowType()) * 37) + 10) * 53) + getId()) * 37) + 11) * 53) + getPlatform().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LiveContentNoticeCreate_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveContentNoticeCreate.class, Builder.class);
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
        return new LiveContentNoticeCreate();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.count_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        if (!getUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.url_);
        }
        int i2 = this.countdown_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(3, i2);
        }
        if (!getContentBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.content_);
        }
        int i3 = this.strategy_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(5, i3);
        }
        int i4 = this.frequency_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(6, i4);
        }
        int i5 = this.type_;
        if (i5 != 0) {
            codedOutputStream.writeUInt32(7, i5);
        }
        int i6 = this.subType_;
        if (i6 != 0) {
            codedOutputStream.writeUInt32(8, i6);
        }
        int i7 = this.showType_;
        if (i7 != 0) {
            codedOutputStream.writeUInt32(9, i7);
        }
        int i8 = this.id_;
        if (i8 != 0) {
            codedOutputStream.writeUInt32(10, i8);
        }
        if (!getPlatformBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 11, this.platform_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
