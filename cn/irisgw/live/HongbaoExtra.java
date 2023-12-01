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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/HongbaoExtra.class */
public final class HongbaoExtra extends GeneratedMessageV3 implements HongbaoExtraOrBuilder {
    public static final int BEANS_FIELD_NUMBER = 6;
    public static final int CONDITION_FIELD_NUMBER = 9;
    public static final int END_SECOND_FIELD_NUMBER = 3;
    public static final int HONGBAO_ID_FIELD_NUMBER = 1;
    public static final int IS_ANIM_FIELD_NUMBER = 7;
    public static final int PWD_FIELD_NUMBER = 10;
    public static final int REMAINING_MILLISECOND_FIELD_NUMBER = 8;
    public static final int SIZE_FIELD_NUMBER = 5;
    public static final int START_SECOND_FIELD_NUMBER = 2;
    public static final int STATUS_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private long beans_;
    private volatile Object condition_;
    private int endSecond_;
    private volatile Object hongbaoId_;
    private boolean isAnim_;
    private byte memoizedIsInitialized;
    private volatile Object pwd_;
    private long remainingMillisecond_;
    private volatile Object size_;
    private int startSecond_;
    private int status_;
    private static final HongbaoExtra DEFAULT_INSTANCE = new HongbaoExtra();
    private static final Parser<HongbaoExtra> PARSER = new AbstractParser<HongbaoExtra>() { // from class: cn.irisgw.live.HongbaoExtra.1
        @Override // com.google.protobuf.Parser
        public HongbaoExtra parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new HongbaoExtra(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/HongbaoExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HongbaoExtraOrBuilder {
        private long beans_;
        private Object condition_;
        private int endSecond_;
        private Object hongbaoId_;
        private boolean isAnim_;
        private Object pwd_;
        private long remainingMillisecond_;
        private Object size_;
        private int startSecond_;
        private int status_;

        private Builder() {
            this.hongbaoId_ = "";
            this.size_ = "";
            this.condition_ = "";
            this.pwd_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.hongbaoId_ = "";
            this.size_ = "";
            this.condition_ = "";
            this.pwd_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_HongbaoExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = HongbaoExtra.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public HongbaoExtra build() {
            HongbaoExtra buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public HongbaoExtra buildPartial() {
            HongbaoExtra hongbaoExtra = new HongbaoExtra(this);
            hongbaoExtra.hongbaoId_ = this.hongbaoId_;
            hongbaoExtra.startSecond_ = this.startSecond_;
            hongbaoExtra.endSecond_ = this.endSecond_;
            hongbaoExtra.status_ = this.status_;
            hongbaoExtra.size_ = this.size_;
            hongbaoExtra.beans_ = this.beans_;
            hongbaoExtra.isAnim_ = this.isAnim_;
            hongbaoExtra.remainingMillisecond_ = this.remainingMillisecond_;
            hongbaoExtra.condition_ = this.condition_;
            hongbaoExtra.pwd_ = this.pwd_;
            onBuilt();
            return hongbaoExtra;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.hongbaoId_ = "";
            this.startSecond_ = 0;
            this.endSecond_ = 0;
            this.status_ = 0;
            this.size_ = "";
            this.beans_ = 0L;
            this.isAnim_ = false;
            this.remainingMillisecond_ = 0L;
            this.condition_ = "";
            this.pwd_ = "";
            return this;
        }

        public Builder clearBeans() {
            this.beans_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearCondition() {
            this.condition_ = HongbaoExtra.getDefaultInstance().getCondition();
            onChanged();
            return this;
        }

        public Builder clearEndSecond() {
            this.endSecond_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearHongbaoId() {
            this.hongbaoId_ = HongbaoExtra.getDefaultInstance().getHongbaoId();
            onChanged();
            return this;
        }

        public Builder clearIsAnim() {
            this.isAnim_ = false;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearPwd() {
            this.pwd_ = HongbaoExtra.getDefaultInstance().getPwd();
            onChanged();
            return this;
        }

        public Builder clearRemainingMillisecond() {
            this.remainingMillisecond_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearSize() {
            this.size_ = HongbaoExtra.getDefaultInstance().getSize();
            onChanged();
            return this;
        }

        public Builder clearStartSecond() {
            this.startSecond_ = 0;
            onChanged();
            return this;
        }

        public Builder clearStatus() {
            this.status_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.HongbaoExtraOrBuilder
        public long getBeans() {
            return this.beans_;
        }

        @Override // cn.irisgw.live.HongbaoExtraOrBuilder
        public String getCondition() {
            Object obj = this.condition_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.condition_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.HongbaoExtraOrBuilder
        public ByteString getConditionBytes() {
            Object obj = this.condition_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.condition_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HongbaoExtra getDefaultInstanceForType() {
            return HongbaoExtra.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_HongbaoExtra_descriptor;
        }

        @Override // cn.irisgw.live.HongbaoExtraOrBuilder
        public int getEndSecond() {
            return this.endSecond_;
        }

        @Override // cn.irisgw.live.HongbaoExtraOrBuilder
        public String getHongbaoId() {
            Object obj = this.hongbaoId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.hongbaoId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.HongbaoExtraOrBuilder
        public ByteString getHongbaoIdBytes() {
            Object obj = this.hongbaoId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.hongbaoId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.HongbaoExtraOrBuilder
        public boolean getIsAnim() {
            return this.isAnim_;
        }

        @Override // cn.irisgw.live.HongbaoExtraOrBuilder
        public String getPwd() {
            Object obj = this.pwd_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.pwd_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.HongbaoExtraOrBuilder
        public ByteString getPwdBytes() {
            Object obj = this.pwd_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.pwd_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.HongbaoExtraOrBuilder
        public long getRemainingMillisecond() {
            return this.remainingMillisecond_;
        }

        @Override // cn.irisgw.live.HongbaoExtraOrBuilder
        public String getSize() {
            Object obj = this.size_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.size_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.HongbaoExtraOrBuilder
        public ByteString getSizeBytes() {
            Object obj = this.size_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.size_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.HongbaoExtraOrBuilder
        public int getStartSecond() {
            return this.startSecond_;
        }

        @Override // cn.irisgw.live.HongbaoExtraOrBuilder
        public int getStatus() {
            return this.status_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_HongbaoExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(HongbaoExtra.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(HongbaoExtra hongbaoExtra) {
            if (hongbaoExtra == HongbaoExtra.getDefaultInstance()) {
                return this;
            }
            if (!hongbaoExtra.getHongbaoId().isEmpty()) {
                this.hongbaoId_ = hongbaoExtra.hongbaoId_;
                onChanged();
            }
            if (hongbaoExtra.getStartSecond() != 0) {
                setStartSecond(hongbaoExtra.getStartSecond());
            }
            if (hongbaoExtra.getEndSecond() != 0) {
                setEndSecond(hongbaoExtra.getEndSecond());
            }
            if (hongbaoExtra.getStatus() != 0) {
                setStatus(hongbaoExtra.getStatus());
            }
            if (!hongbaoExtra.getSize().isEmpty()) {
                this.size_ = hongbaoExtra.size_;
                onChanged();
            }
            if (hongbaoExtra.getBeans() != 0) {
                setBeans(hongbaoExtra.getBeans());
            }
            if (hongbaoExtra.getIsAnim()) {
                setIsAnim(hongbaoExtra.getIsAnim());
            }
            if (hongbaoExtra.getRemainingMillisecond() != 0) {
                setRemainingMillisecond(hongbaoExtra.getRemainingMillisecond());
            }
            if (!hongbaoExtra.getCondition().isEmpty()) {
                this.condition_ = hongbaoExtra.condition_;
                onChanged();
            }
            if (!hongbaoExtra.getPwd().isEmpty()) {
                this.pwd_ = hongbaoExtra.pwd_;
                onChanged();
            }
            mergeUnknownFields(hongbaoExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.HongbaoExtra.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.HongbaoExtra.access$1500()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.HongbaoExtra r0 = (cn.irisgw.live.HongbaoExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.HongbaoExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.HongbaoExtra r0 = (cn.irisgw.live.HongbaoExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.HongbaoExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.HongbaoExtra.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.HongbaoExtra$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof HongbaoExtra) {
                return mergeFrom((HongbaoExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setBeans(long j) {
            this.beans_ = j;
            onChanged();
            return this;
        }

        public Builder setCondition(String str) {
            if (str != null) {
                this.condition_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setConditionBytes(ByteString byteString) {
            if (byteString != null) {
                HongbaoExtra.checkByteStringIsUtf8(byteString);
                this.condition_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setEndSecond(int i) {
            this.endSecond_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setHongbaoId(String str) {
            if (str != null) {
                this.hongbaoId_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setHongbaoIdBytes(ByteString byteString) {
            if (byteString != null) {
                HongbaoExtra.checkByteStringIsUtf8(byteString);
                this.hongbaoId_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setIsAnim(boolean z) {
            this.isAnim_ = z;
            onChanged();
            return this;
        }

        public Builder setPwd(String str) {
            if (str != null) {
                this.pwd_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPwdBytes(ByteString byteString) {
            if (byteString != null) {
                HongbaoExtra.checkByteStringIsUtf8(byteString);
                this.pwd_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setRemainingMillisecond(long j) {
            this.remainingMillisecond_ = j;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setSize(String str) {
            if (str != null) {
                this.size_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setSizeBytes(ByteString byteString) {
            if (byteString != null) {
                HongbaoExtra.checkByteStringIsUtf8(byteString);
                this.size_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setStartSecond(int i) {
            this.startSecond_ = i;
            onChanged();
            return this;
        }

        public Builder setStatus(int i) {
            this.status_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private HongbaoExtra() {
        this.memoizedIsInitialized = (byte) -1;
        this.hongbaoId_ = "";
        this.size_ = "";
        this.condition_ = "";
        this.pwd_ = "";
    }

    private HongbaoExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            this.hongbaoId_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 16:
                            this.startSecond_ = codedInputStream.readUInt32();
                            continue;
                        case 24:
                            this.endSecond_ = codedInputStream.readUInt32();
                            continue;
                        case 32:
                            this.status_ = codedInputStream.readUInt32();
                            continue;
                        case 42:
                            this.size_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 48:
                            this.beans_ = codedInputStream.readUInt64();
                            continue;
                        case 56:
                            this.isAnim_ = codedInputStream.readBool();
                            continue;
                        case 64:
                            this.remainingMillisecond_ = codedInputStream.readUInt64();
                            continue;
                        case 74:
                            this.condition_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 82:
                            this.pwd_ = codedInputStream.readStringRequireUtf8();
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
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                }
            } finally {
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    private HongbaoExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static HongbaoExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_HongbaoExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(HongbaoExtra hongbaoExtra) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(hongbaoExtra);
    }

    public static HongbaoExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HongbaoExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static HongbaoExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HongbaoExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static HongbaoExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static HongbaoExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static HongbaoExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HongbaoExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static HongbaoExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HongbaoExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static HongbaoExtra parseFrom(InputStream inputStream) throws IOException {
        return (HongbaoExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static HongbaoExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HongbaoExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static HongbaoExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static HongbaoExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static HongbaoExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static HongbaoExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<HongbaoExtra> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof HongbaoExtra) {
            HongbaoExtra hongbaoExtra = (HongbaoExtra) obj;
            return getHongbaoId().equals(hongbaoExtra.getHongbaoId()) && getStartSecond() == hongbaoExtra.getStartSecond() && getEndSecond() == hongbaoExtra.getEndSecond() && getStatus() == hongbaoExtra.getStatus() && getSize().equals(hongbaoExtra.getSize()) && getBeans() == hongbaoExtra.getBeans() && getIsAnim() == hongbaoExtra.getIsAnim() && getRemainingMillisecond() == hongbaoExtra.getRemainingMillisecond() && getCondition().equals(hongbaoExtra.getCondition()) && getPwd().equals(hongbaoExtra.getPwd()) && this.unknownFields.equals(hongbaoExtra.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.HongbaoExtraOrBuilder
    public long getBeans() {
        return this.beans_;
    }

    @Override // cn.irisgw.live.HongbaoExtraOrBuilder
    public String getCondition() {
        Object obj = this.condition_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.condition_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.HongbaoExtraOrBuilder
    public ByteString getConditionBytes() {
        Object obj = this.condition_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.condition_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public HongbaoExtra getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.HongbaoExtraOrBuilder
    public int getEndSecond() {
        return this.endSecond_;
    }

    @Override // cn.irisgw.live.HongbaoExtraOrBuilder
    public String getHongbaoId() {
        Object obj = this.hongbaoId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.hongbaoId_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.HongbaoExtraOrBuilder
    public ByteString getHongbaoIdBytes() {
        Object obj = this.hongbaoId_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.hongbaoId_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.HongbaoExtraOrBuilder
    public boolean getIsAnim() {
        return this.isAnim_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<HongbaoExtra> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.HongbaoExtraOrBuilder
    public String getPwd() {
        Object obj = this.pwd_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.pwd_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.HongbaoExtraOrBuilder
    public ByteString getPwdBytes() {
        Object obj = this.pwd_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.pwd_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.HongbaoExtraOrBuilder
    public long getRemainingMillisecond() {
        return this.remainingMillisecond_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!getHongbaoIdBytes().isEmpty()) {
            i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.hongbaoId_);
        }
        int i3 = this.startSecond_;
        int i4 = i2;
        if (i3 != 0) {
            i4 = i2 + CodedOutputStream.computeUInt32Size(2, i3);
        }
        int i5 = this.endSecond_;
        int i6 = i4;
        if (i5 != 0) {
            i6 = i4 + CodedOutputStream.computeUInt32Size(3, i5);
        }
        int i7 = this.status_;
        int i8 = i6;
        if (i7 != 0) {
            i8 = i6 + CodedOutputStream.computeUInt32Size(4, i7);
        }
        int i9 = i8;
        if (!getSizeBytes().isEmpty()) {
            i9 = i8 + GeneratedMessageV3.computeStringSize(5, this.size_);
        }
        long j = this.beans_;
        int i10 = i9;
        if (j != 0) {
            i10 = i9 + CodedOutputStream.computeUInt64Size(6, j);
        }
        boolean z = this.isAnim_;
        int i11 = i10;
        if (z) {
            i11 = i10 + CodedOutputStream.computeBoolSize(7, z);
        }
        long j2 = this.remainingMillisecond_;
        int i12 = i11;
        if (j2 != 0) {
            i12 = i11 + CodedOutputStream.computeUInt64Size(8, j2);
        }
        int i13 = i12;
        if (!getConditionBytes().isEmpty()) {
            i13 = i12 + GeneratedMessageV3.computeStringSize(9, this.condition_);
        }
        int i14 = i13;
        if (!getPwdBytes().isEmpty()) {
            i14 = i13 + GeneratedMessageV3.computeStringSize(10, this.pwd_);
        }
        int serializedSize = i14 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.HongbaoExtraOrBuilder
    public String getSize() {
        Object obj = this.size_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.size_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.HongbaoExtraOrBuilder
    public ByteString getSizeBytes() {
        Object obj = this.size_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.size_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.HongbaoExtraOrBuilder
    public int getStartSecond() {
        return this.startSecond_;
    }

    @Override // cn.irisgw.live.HongbaoExtraOrBuilder
    public int getStatus() {
        return this.status_;
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
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getHongbaoId().hashCode()) * 37) + 2) * 53) + getStartSecond()) * 37) + 3) * 53) + getEndSecond()) * 37) + 4) * 53) + getStatus()) * 37) + 5) * 53) + getSize().hashCode()) * 37) + 6) * 53) + Internal.hashLong(getBeans())) * 37) + 7) * 53) + Internal.hashBoolean(getIsAnim())) * 37) + 8) * 53) + Internal.hashLong(getRemainingMillisecond())) * 37) + 9) * 53) + getCondition().hashCode()) * 37) + 10) * 53) + getPwd().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_HongbaoExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(HongbaoExtra.class, Builder.class);
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
        return new HongbaoExtra();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getHongbaoIdBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.hongbaoId_);
        }
        int i = this.startSecond_;
        if (i != 0) {
            codedOutputStream.writeUInt32(2, i);
        }
        int i2 = this.endSecond_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(3, i2);
        }
        int i3 = this.status_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(4, i3);
        }
        if (!getSizeBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.size_);
        }
        long j = this.beans_;
        if (j != 0) {
            codedOutputStream.writeUInt64(6, j);
        }
        boolean z = this.isAnim_;
        if (z) {
            codedOutputStream.writeBool(7, z);
        }
        long j2 = this.remainingMillisecond_;
        if (j2 != 0) {
            codedOutputStream.writeUInt64(8, j2);
        }
        if (!getConditionBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 9, this.condition_);
        }
        if (!getPwdBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 10, this.pwd_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
